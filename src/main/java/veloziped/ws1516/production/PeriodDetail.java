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
public class PeriodDetail {
    
    private long product1;
    private long product2;
    private long product3;
    private long sum;

    public PeriodDetail(long product1, long product2, long product3) {
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
        this.calcCum();
    }

    public long getSum() {
        return sum;
    }

    public long getProduct3() {
        return product3;
    }

    public long getProduct2() {
        return product2;
    }

    public long getProduct1() {
        return product1;
    }
    
    private void calcCum() {
        this.sum = product1 + product2 + product3;
    }

}
