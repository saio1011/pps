/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.articles;

import com.google.common.math.DoubleMath;
import java.math.RoundingMode;
import java.util.Objects;
import org.json.simple.JSONObject;
import veloziped.ws1516.generated.Results.Article;
import veloziped.ws1516.production.CalculationMode;

/**
 *
 * @author Martin
 */
public class ExtendedArticle extends Article implements Comparable<ExtendedArticle>{
    private ArticleType type;
    private ArticleUsage usage;
    private double deliverTime;
    private double deviation;
    private long deliverCosts;
    private long usageProductOne;
    private long usageProductTwo;
    private long usageProductThree;
    private long discountQuantity;
    private String name;
    private long stockChange;
    private long newStock;
    private double newStockValue;
    private double stockChangePct;
    private long safetyStock;
    private long plannedProductionAmount;
    private long additionalAmount;
    private long additionalAmountInWork;

    public void setValues(JSONObject values) {
        String aType = (String) values.get("type");
        String aUsage = (String) values.get("usage");
        double aDeliverTime = (double) values.get("deliverTime");
        double aDeviation = (double) values.get("deviation");
        long aDeliverCosts = (long) values.get("deliverCosts");
        long aUsagePOne = (long) values.get("usageProductOne");
        long aUsagePTwo = (long) values.get("usageProductTwo");
        long aUsagePThree = (long) values.get("usageProductThree");
        long aDiscountQuantity = (long) values.get("discountQuantity");
        String aName = (String) values.get("name");

        this.type = ArticleType.valueOf(aType);
        this.usage = ArticleUsage.valueOf(aUsage);
        this.deliverTime = aDeliverTime;
        this.deviation = aDeviation;
        this.deliverCosts = aDeliverCosts;
        this.usageProductOne = aUsagePOne;
        this.usageProductTwo = aUsagePTwo;
        this.usageProductThree = aUsagePThree;
        this.discountQuantity = aDiscountQuantity;
        this.name = aName;
        this.additionalAmountInWork = additionalAmountInWork;
    }

    public ExtendedArticle(Article article) {
        super.amount = article.getAmount();
        super.id = article.getId();
        super.pct = article.getPct();
        super.price = article.getPrice();
        super.startamount = article.getStartamount();
        super.stockvalue = article.getStockvalue();
        
        this.stockChange = 0;
        this.newStock = super.amount;
        this.newStockValue = super.stockvalue;
        this.safetyStock = super.amount;
        //remove 100 value in release
        this.plannedProductionAmount = 0;
        this.additionalAmount = 0;
        this.additionalAmountInWork = 0;
    }

    public long getAdditionalAmountInWork() {
        return additionalAmountInWork;
    }

    public void setAdditionalAmountInWork(long additionalAmountInWork) {
        this.additionalAmountInWork = additionalAmountInWork;
    }

    public boolean equals(Object obj) {
        boolean result = false;

        if (obj == null) {
            result = false;
        } else if (obj.getClass() == this.getClass()) {
            ExtendedArticle b = (ExtendedArticle) obj;
            if (Objects.equals(this.id, b.id)) {
                result = true;
            }
        }

        return result;
    }

    public long getDeliveryTimeFastInDays(CalculationMode mode) {
        if (null == mode) {
            return 0;
        }

        //half time of deliver time without deviation
        double deliverFast = (this.deliverTime / 2) * 5;
        //1 day moving to warehouse
        switch (mode) {
            case OPTIMISTIC:
                return DoubleMath.roundToLong(deliverFast, RoundingMode.DOWN) + 1;
            case PESSIMISTIC:
                return DoubleMath.roundToLong(deliverFast, RoundingMode.CEILING) + 1;
            default:
                return 0;
        }
    }

    public long getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(long safetyStock) {
        this.safetyStock = safetyStock;
    }

    public long getPlannedProductionAmount() {
        return plannedProductionAmount;
    }

    public void setPlannedProductionAmount(long plannedProductionAmount) {
        this.plannedProductionAmount = plannedProductionAmount;
    }
    
    public double getStockChangePct() {
        return stockChangePct;
    }

    public void setStockChangePct(double stockChangePct) {
        this.stockChangePct = stockChangePct;
    }
    
    public long getUsageProductOne() {
        return usageProductOne;
    }

    public void setUsageProductOne(long usageProductOne) {
        this.usageProductOne = usageProductOne;
    }

    public long getStockChange() {
        return stockChange;
    }

    public void setStockChange(long stockChange) {
        this.stockChange = stockChange;
    }

    public long getNewStock() {
        return newStock;
    }

    public void setNewStock(long newStock) {
        this.newStock = newStock;
    }

    public double getNewStockValue() {
        return newStockValue;
    }

    public void setNewStockValue(double newStockValue) {
        this.newStockValue = newStockValue;
    }
    
    public double getDeliveryTimeFastAsPeriod() {
        //half time of deliver time without deviation
        double deliverFast = (this.deliverTime / 2) * 5;
        //1 day moving to warehouse
        return (deliverFast + 1) / 5;
    }

    public long getDeliveryTimeNormalInDays(CalculationMode mode) {
        if (null == mode) {
            return 0;
        }
        double deliverNormal;

        //1 day moving to warehouse
        switch (mode) {
            case OPTIMISTIC:
                //5 days
                deliverNormal = (this.deliverTime - this.deviation) * 5;
                return DoubleMath.roundToLong(deliverNormal, RoundingMode.DOWN) + 1;
                
            case PESSIMISTIC:
                //5 days
                deliverNormal = (this.deliverTime + this.deviation) * 5;
                return DoubleMath.roundToLong(deliverNormal, RoundingMode.CEILING) + 1;
            default:
                return 0;
        }
    }

    public double getDeliveryTimeNormalAsPeriods(CalculationMode mode) {
        //5 days
        double deliverNormal;
        
        switch (mode) {
            case OPTIMISTIC:
                //5 days
                deliverNormal = (this.deliverTime - this.deviation) * 5;
                 return (deliverNormal + 1) / 5;
                
            case PESSIMISTIC:
                //5 days
                deliverNormal = (this.deliverTime + this.deviation) * 5;
                 return (deliverNormal + 1) / 5;
            default:
                return 0;
        }
    }

    public String getName() {
        return name;
    }

    public long getDeliverCosts() {
        return deliverCosts;
    }

    public long getDiscountQuantity() {
        return discountQuantity;
    }

    public long getUsageProductThree() {
        return usageProductThree;
    }

    public long getUsageProductTwo() {
        return usageProductTwo;
    }

    public long getUsageForProductOne() {
        return usageProductOne;
    }

    public double getDeviation() {
        return deviation;
    }

    public double getDeliverTime() {
        return deliverTime;
    }

    public ArticleUsage getUsage() {
        return usage;
    }

    public ArticleType getType() {
        return type;
    }

    public long getAdditionalAmount() {
        return additionalAmount;
    }

    public void setAdditionalAmount(long additionalAmount) {
        this.additionalAmount = additionalAmount;
    }
    @Override
    public int compareTo(ExtendedArticle o) {
        return Long.compare(super.id, o.getId());
    }

}
