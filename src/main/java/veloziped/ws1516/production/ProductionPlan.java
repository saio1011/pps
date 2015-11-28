/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.production;

/**
 *
 * @author Martin
 */
public class ProductionPlan {
    
    private PeriodDetail periodN1;
    private PeriodDetail periodN2;
    private PeriodDetail periodN3;
    private PeriodDetail periodN4;

    public PeriodDetail getPeriodN4() {
        return periodN4;
    }

    public void setPeriodN4(PeriodDetail periodN4) {
        this.periodN4 = periodN4;
    }

    public PeriodDetail getPeriodN3() {
        return periodN3;
    }

    public void setPeriodN3(PeriodDetail periodN3) {
        this.periodN3 = periodN3;
    }

    public PeriodDetail getPeriodN2() {
        return periodN2;
    }

    public void setPeriodN2(PeriodDetail periodN2) {
        this.periodN2 = periodN2;
    }

    public PeriodDetail getPeriodN1() {
        return periodN1;
    }

    public void setPeriodN1(PeriodDetail periodN1) {
        this.periodN1 = periodN1;
    }
}
