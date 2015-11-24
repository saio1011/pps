/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.util.Map;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Martin
 */
public class SharedInstance {
    
    private SharedInstance() {}
    
    private Forecast forecast = new Forecast();
    private Map<String, Long> orderQuantities;
    private Map<String, ExtendedWorkplace> workplaces;
    
    public static SharedInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }
    
    private static class SharedInstanceHolder {

        private static final SharedInstance INSTANCE = new SharedInstance();
    }
    
    public ExtendedWorkplace getWorkplaceForId(Long id) {
        ExtendedWorkplace result = null;
        
        if(id != null) {
            result = workplaces.get(String.valueOf(id));
        }
        
        return result;
    }
    
    public Map<String, ExtendedWorkplace> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(Map<String, ExtendedWorkplace> workplaces) {
        this.workplaces = workplaces;
    }
    
    public boolean setOrderQuantityForArticleId(Long id, Long quantity) {
        boolean result = false;
        
        if(id != null) {
            orderQuantities.put(String.valueOf(id), quantity);
            result = true;
        }
        
        return result;
    }
    
    public Long getOrderQuantityForArticleId(Long id) {
        Long result = null;
        
        if(id != null) {
            result = orderQuantities.get(String.valueOf(id));
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
}
