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
import veloziped.ws1516.util.SharedInstance;
import veloziped.ws1516.util.Utils;

/**
 *
 * @author Martin
 */
public class ExtendedArticle extends Article {

    private ArticleType type;
    private ArticleUsage usage;
    private float deliverTime;
    private float deviation;
    private float deliverCosts;
    private int usageProductOne;
    private int usageProductTwo;
    private int usageProductThree;
    private int discountQuantity;
    private String name;

    public void setValues() {
        JSONObject values = SharedInstance.getInstance().getArticleValueForId(this.getIdAsInt());
        
        String aType = (String) values.get("type");
        String aUsage = (String) values.get("usage");
        float aDeliverTime = (float) values.get("deliverTime");
        float aDeviation = (float) values.get("deviation");
        float aDeliverCosts = (float) values.get("deliverCosts");
        int aUsagePOne = (int) values.get("usageProductOne");
        int aUsagePTwo = (int) values.get("usageProductTwo");
        int aUsagePThree = (int) values.get("usageProductThree");
        int aDiscountQuantity = (int) values.get("discountQuantity");
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

    public int getIdAsInt() {
        return super.getId().intValue(); //To change body of generated methods, choose Tools | Templates.
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
    
    public float getDeliverCosts() {
        return deliverCosts;
    }
    
    public int getDiscountQuantity() {
        return discountQuantity;
    }

    public int getUsageProductThree() {
        return usageProductThree;
    }

    public int getUsageProductTwo() {
        return usageProductTwo;
    }

    public int getUsageForProductOne() {
        return usageProductOne;
    }

    public float getDeviation() {
        return deviation;
    }

    public float getDeliverTime() {
        return deliverTime;
    }

    public ArticleUsage getUsage() {
        return usage;
    }

    public ArticleType getType() {
        return type;
    }

}
