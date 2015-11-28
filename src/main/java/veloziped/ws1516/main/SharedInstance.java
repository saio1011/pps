/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import com.google.common.math.DoubleMath;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Order;
import veloziped.ws1516.generated.Results;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.production.ProductionPlan;
import veloziped.ws1516.production.CalculationMode;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Martin
 */
public class SharedInstance {

    private SharedInstance() {
    }

    private Forecast forecast = new Forecast();
    private Map<String, Long> orderQuantities;
    private Map<String, ExtendedWorkplace> workplaces;
    private Map<String, ExtendedArticle> extendedArticles;
    private Map<String, Order> incomingOrdersThisPeriod;
    private ProductionPlan productionPlan;
    private Results results;
    private CalculationMode calculationMode;
    // 1 == 100%
    private double discountFactor;
    private double bufferFactor;

    public double getBufferFactor() {
        return bufferFactor;
    }

    public void setBufferFactor(double bufferFactor) {
        this.bufferFactor = bufferFactor;
    }


    public double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }


    public CalculationMode getCalculationMode() {
        return calculationMode;
    }

    public void setCalculationMode(CalculationMode calculationMode) {
        this.calculationMode = calculationMode;
    }

    public static SharedInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }

    private static class SharedInstanceHolder {

        private static final SharedInstance INSTANCE = new SharedInstance();
    }

    public ExtendedWorkplace getWorkplaceForId(Long id) {
        ExtendedWorkplace result = null;

        if (id != null) {
            result = workplaces.get(String.valueOf(id));
        }

        return result;
    }
    
    public ExtendedArticle getArticleForId(Long id) {
        ExtendedArticle result = null;

        if (id != null) {
            result = extendedArticles.get(String.valueOf(id));
        }

        return result;
    }
    
    public boolean setExtendedArticleForId(Long id, ExtendedArticle article) {
        boolean result = false;

        if (id != null) {
            extendedArticles.put(String.valueOf(id), article);
            result = true;
        }

        return result;
    }

    public ProductionPlan getProcudtionPlan() {
        return productionPlan;
    }

    public void setProductionPlan(ProductionPlan productionPlan) {
        this.productionPlan = productionPlan;
    }

    public Map<String, ExtendedWorkplace> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(Map<String, ExtendedWorkplace> workplaces) {
        this.workplaces = workplaces;
    }

    public boolean setOrderQuantityForArticleId(Long id, Long quantity) {
        boolean result = false;

        if (id != null) {
            orderQuantities.put(String.valueOf(id), quantity);
            result = true;
        }

        return result;
    }

    public Long getOrderQuantityForArticleId(Long id) {
        Long result = null;

        if (id != null) {
            result = orderQuantities.get(String.valueOf(id));
        }

        return result;
    }
    
    public Order getIncomingOrderForArticleId(Long id) {
        Order result = null;

        if (id != null) {
            result = incomingOrdersThisPeriod.get(String.valueOf(id));
        }

        return result;
    }

    public Map<String, Long> getOrderQuantities() {
        return orderQuantities;
    }

    public void setOrderQuantities(Map<String, Long> orderQuantities) {
        this.orderQuantities = orderQuantities;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void calcIncomingOrdersThisPeriod(List<Order> incoming) {
        incomingOrdersThisPeriod = new HashMap<>();
        long currentPeriod = this.results.getPeriod() + 1;

        for (Order order : incoming) {
            ExtendedArticle article = this.getArticleForId(order.getArticle());
            long estimatedPeriod = this.getEstimatedDeliverPeriod(article, order);

            if (currentPeriod <= estimatedPeriod) {
                incomingOrdersThisPeriod.put(String.valueOf(order.getArticle()), order);
            }
        }
    }

    private long getEstimatedDeliverPeriod(ExtendedArticle article, Order order) {
        long estimatedPeriod = 0;

        switch (this.calculationMode) {
            case OPTIMISTIC:
                if (order.getMode() == 5) {
                    estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeNormalAsPeriods(this.calculationMode) + order.getOrderperiod(), RoundingMode.DOWN);
                } else if (order.getMode() == 4) {
                    estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeFastAsPeriod() + order.getOrderperiod(), RoundingMode.DOWN);
                } else {
                    throw new IllegalArgumentException("Delivery mode not supported.");
                }
                break;
            case PESSIMISTIC:
                if (order.getMode() == 5) {
                    estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeNormalAsPeriods(this.calculationMode) + order.getOrderperiod(), RoundingMode.CEILING);
                } else if (order.getMode() == 4) {
                    estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeFastAsPeriod() + order.getOrderperiod(), RoundingMode.CEILING);
                } else {
                    throw new IllegalArgumentException("Delivery mode not supported.");
                }
                break;

        }
        return estimatedPeriod;
    }
}
