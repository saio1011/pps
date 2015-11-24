/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package production;

/**
 *
 * @author Martin
 */
public class Forecast {
    
    private ForecastDetail periodN1;
    private ForecastDetail periodN2;
    private ForecastDetail periodN3;
    private ForecastDetail periodN4;

    public ForecastDetail getPeriodN3() {
        return periodN4;
    }

    public void setPeriodN3(ForecastDetail periodN3) {
        this.periodN4 = periodN3;
    }

    public ForecastDetail getPeriodN2() {
        return periodN3;
    }

    public void setPeriodN2(ForecastDetail periodN2) {
        this.periodN3 = periodN2;
    }

    public ForecastDetail getPeriodN1() {
        return periodN2;
    }

    public void setPeriodN1(ForecastDetail periodN1) {
        this.periodN2 = periodN1;
    }

    public ForecastDetail getPeriodN0() {
        return periodN1;
    }

    public void setPeriodN0(ForecastDetail periodN0) {
        this.periodN1 = periodN0;
    }

}
