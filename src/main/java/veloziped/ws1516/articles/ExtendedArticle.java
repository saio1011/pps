/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.articles;

import java.util.Locale;
import java.util.Objects;
import org.json.simple.JSONObject;
import veloziped.ws1516.generated.Results.Warehousestock.Article;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.util.Utils;

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
        JSONObject values = SharedInstance.getInstance().getArticleValueForId(super.id);
        
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
    
    public double getStockvalueAsDouble() {
        String value = super.getStockvalue(); //To change body of generated methods, choose Tools | Templates.
        Number number = Utils.getNumberFromString(value, Locale.GERMANY);

        return number.doubleValue();
    }

    public float getPriceAsFloat() {
        String value = super.getPrice(); //To change body of generated methods, choose Tools | Templates.
        Number number = Utils.getNumberFromString(value, Locale.GERMANY);

        return number.floatValue();
    }

    public float getPctAsFloat() {
        String value = super.getPct(); //To change body of generated methods, choose Tools | Templates.
        Number number = Utils.getNumberFromString(value, Locale.GERMANY);

        return number.floatValue();
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
