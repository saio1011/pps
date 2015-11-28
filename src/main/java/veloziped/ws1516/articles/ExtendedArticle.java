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
import veloziped.ws1516.generated.Article;
import veloziped.ws1516.main.SetupInstance;
import veloziped.ws1516.production.OrderMode;

/**
 *
 * @author Martin
 */
public class ExtendedArticle extends Article {

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

    public void setValues() {
        JSONObject values = SetupInstance.getInstance().getArticleValueForId(super.id);

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

    public long getDeliveryTimeFastInDays(OrderMode mode) {
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

    public double getDeliveryTimeFastAsPeriod() {
        //half time of deliver time without deviation
        double deliverFast = (this.deliverTime / 2) * 5;
        //1 day moving to warehouse
        return (deliverFast + 1) / 5;
    }

    public long getDeliveryTimeNormalInDays(OrderMode mode) {
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

    public double getDeliveryTimeNormalAsPeriods(OrderMode mode) {
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

}
