/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.disposal;

/**
 *
 * @author Martin
 */
public class ConsumptionPlan {

    private long n1;
    private long n2;
    private long n3;
    private long n4;

    public ConsumptionPlan(long n1, long n2, long n3, long n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public long getN1() {
        return n1;
    }

    public long getN2() {
        return n2;
    }

    public long getN3() {
        return n3;
    }

    public long getN4() {
        return n4;
    }

}
