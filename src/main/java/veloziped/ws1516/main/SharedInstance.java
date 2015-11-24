/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import veloziped.ws1516.production.Forecast;

/**
 *
 * @author Martin
 */
public class SharedInstance {
    
    private SharedInstance() {}
    
    private Forecast forecast = new Forecast();
    
    public static SharedInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }
    
    private static class SharedInstanceHolder {

        private static final SharedInstance INSTANCE = new SharedInstance();
    }
    
    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
