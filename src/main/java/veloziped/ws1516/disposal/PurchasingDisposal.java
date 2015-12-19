/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.disposal;

import com.google.common.math.DoubleMath;
import com.rits.cloning.Cloner;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import veloziped.ws1516.articles.ArticleType;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Results.Order;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.production.ProductionPlan;
import veloziped.ws1516.util.Utils;

/**
 *
 * @author Martin
 */
public class PurchasingDisposal {

    private PurchasingDisposal() {
    }

    public static PurchasingDisposal getInstance() {
        return PurchasingDisposalHolder.INSTANCE;
    }

    private static class PurchasingDisposalHolder {

        private static final PurchasingDisposal INSTANCE = new PurchasingDisposal();
    }

    private String errorArticles;

    public List<Order> calculateOrders(Map<String, ExtendedArticle> articles) {
        Cloner cloner = new Cloner();
        Collection<ExtendedArticle> cArticles = cloner.deepClone(articles.values());
        
        List<Order> orders = new ArrayList<>();
        errorArticles = "";

        for (ExtendedArticle article : cArticles) {
            if (article.getType() == ArticleType.K) {
                Order incoming = SharedInstance.getInstance()
                        .getIncomingOrderForArticleId(article.getId());
                long stock = article.getAmount();
                if (incoming != null) {
                    stock += incoming.getAmount();
                }

                ConsumptionPlan plan = this.calcConsumption(article);
                long consumInDays = this.calcConsumInDays(stock, plan);

                if (this.isOrderNeeded(article, consumInDays)) {
                    OrderMode mode = this.calcOrderMode(article, consumInDays);
                    long consumInDeliverTime = this.calcConsumInDeliverTime(article, plan);
                    //updated version, maybe change later
                    long missing = (plan.getN1() - stock > 0) ? (plan.getN1() - stock) : 0;

                    /*
                    if (mode == OrderMode.FAST) {
                        //TODO: maybe do not use incoming amount
                        //could be not avaiilable on first day
                        missing = consumInDeliverTime - stock;
                    }
                     */
                    long neededConsumption = this.calcNeededConsumption(consumInDeliverTime, missing);
                    long missingUntilDicount = 0;
                    if (neededConsumption - article.getDiscountQuantity() < 0) {
                        missingUntilDicount = article.getDiscountQuantity() - neededConsumption;
                    }

                    double percentUntilDiscount = this.calcPercentUntilDiscount(missingUntilDicount, plan);

                    long orderAmount = neededConsumption;
                    if (percentUntilDiscount < SharedInstance.getInstance().getDiscountFactor()) {
                        orderAmount += missingUntilDicount;
                    }

                    Order order = new Order();
                    order.setArticle(article.getId());
                    order.setMode((long) mode.getValue());
                    order.setAmount(orderAmount);
                    orders.add(order);
                }
            }
        }

        if(errorArticles.length() > 0) {
            Locale locale = SharedInstance.getInstance().getCurrentLocale();
            ResourceBundle i18n = Utils.getResourceBundle(locale.getLanguage(), locale.getCountry());
            JOptionPane.showMessageDialog(null, String.format(i18n.getString("ProductionToHigh"), errorArticles), null, JOptionPane.WARNING_MESSAGE);
        }

        return orders;
    }

    private double calcPercentUntilDiscount(long missingUntilDiscount, ConsumptionPlan plan) {
        return missingUntilDiscount / ((plan.getN1() + plan.getN2() + plan.getN3() + plan.getN4()) / 4);
    }

    private long calcNeededConsumption(long consumInDeliverTime, long missing) {

        double bufferFact = SharedInstance.getInstance().getBufferFactor();
        double neededCon = ((double) consumInDeliverTime + missing) * (1 + bufferFact);
        long neededConsumption = 0;

        switch (SharedInstance.getInstance().getCalculationMode()) {
            case OPTIMISTIC:
                neededConsumption = DoubleMath.roundToLong(neededCon, RoundingMode.DOWN);

                //10er losgrößen
                if (neededConsumption % 10 != 0) {
                    neededConsumption += neededConsumption % 10;
                }
            case PESSIMISTIC:
                neededConsumption = DoubleMath.roundToLong(neededCon, RoundingMode.CEILING);

                //10er losgrößen
                if (neededConsumption % 10 != 0) {
                    neededConsumption -= neededConsumption % 10;
                }
        }
        return neededConsumption;
    }

    private long calcConsumInDeliverTime(ExtendedArticle article, ConsumptionPlan plan) {
        double deliverTimeInPeriods = article.getDeliveryTimeNormalAsPeriods(SharedInstance
                .getInstance().getCalculationMode());
        long n1 = plan.getN1();
        long n2 = plan.getN2();
        long n3 = plan.getN3();
        long n4 = plan.getN4();
        long consum = 0;
        if (deliverTimeInPeriods < 1) {
            consum = n1;
        } else if (deliverTimeInPeriods < 2) {
            consum = n1 + n2;
        } else if (deliverTimeInPeriods < 3) {
            consum = n1 + n2 + n3;
        } else if (deliverTimeInPeriods < 4) {
            consum = n1 + n2 + n3 + n4;
        }

        return consum;
    }

    private OrderMode calcOrderMode(ExtendedArticle article, long consumInDays) {
        OrderMode mode;

        boolean normalDeliveryIsOk = (consumInDays > article.
                getDeliveryTimeNormalInDays(SharedInstance.getInstance()
                        .getCalculationMode()));
        
        boolean fastDeliveryOk = (consumInDays > article.
                getDeliveryTimeFastInDays(SharedInstance.getInstance()
                        .getCalculationMode()));

        if (normalDeliveryIsOk) {
            mode = OrderMode.NORMAL;
        } else if (fastDeliveryOk) {
            mode = OrderMode.FAST;
        } else {
            errorArticles += (String.format("\n <ID: %d, %s>", article.getId(), article.getName()));
            mode = OrderMode.FAST;
        }

        return mode;
    }

    private boolean isOrderNeeded(ExtendedArticle article, long consumInDays) {
        if ((consumInDays - 5) < article.getDeliveryTimeNormalInDays(SharedInstance
                .getInstance().getCalculationMode())) {
            return true;
        } else {
            return false;
        }
    }

    private long calcConsumInDays(long stock, ConsumptionPlan plan) {
        long n1 = plan.getN1();
        long n2 = plan.getN2();
        long n3 = plan.getN3();
        long n4 = plan.getN4();
        double days = 0;

        if (stock < n1) {
            days = stock / n1 * 5;
        } else if (stock < (n1 + n2)) {
            days = 5 + ((double) stock - n1) / n2 * 5;
        } else if (stock < (n1 + n2 + n3)) {
            days = 10 + ((double) stock - n1 - n2) / n3 * 5;
        } else if (stock < (n1 + n2 + n3 + n4)) {
            days = 15 + ((double) stock - n1 - n2 - n3) / n4 * 5;
        } else {
            days = 999;
        }

        switch (SharedInstance.getInstance().getCalculationMode()) {
            case OPTIMISTIC:
                return DoubleMath.roundToLong(days, RoundingMode.CEILING);
            case PESSIMISTIC:
                return DoubleMath.roundToLong(days, RoundingMode.DOWN);
            default:
                return -1;
        }
    }

    private ConsumptionPlan calcConsumption(ExtendedArticle article) {
        ProductionPlan plan = SharedInstance.getInstance().getProcudtionPlan();
        if (plan == null) {
            throw new NullPointerException();
        }

        long n1 = article.getUsageForProductOne() * plan.getPeriodN1().getProduct1()
                + article.getUsageProductTwo() * plan.getPeriodN1().getProduct2()
                + article.getUsageProductThree() * plan.getPeriodN1().getProduct3();
        long n2 = article.getUsageForProductOne() * plan.getPeriodN2().getProduct1()
                + article.getUsageProductTwo() * plan.getPeriodN2().getProduct2()
                + article.getUsageProductThree() * plan.getPeriodN2().getProduct3();
        long n3 = article.getUsageForProductOne() * plan.getPeriodN3().getProduct1()
                + article.getUsageProductTwo() * plan.getPeriodN3().getProduct2()
                + article.getUsageProductThree() * plan.getPeriodN3().getProduct3();
        long n4 = article.getUsageForProductOne() * plan.getPeriodN4().getProduct1()
                + article.getUsageProductTwo() * plan.getPeriodN4().getProduct2()
                + article.getUsageProductThree() * plan.getPeriodN4().getProduct3();

        return new ConsumptionPlan(n1, n2, n3, n4);
    }
}
