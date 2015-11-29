/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.disposal;

import java.io.Console;
import org.junit.experimental.results.PrintableResult;
import veloziped.ws1516.production.Forecast;

/**
 *
 * @author Rosen
 */
// TODO...
public class Disposal {

    // Die Produktionsprognose
    private Forecast forecast;
    // Prod. Auftraege
    private long prodOrder;
    // Produkte 1,2,3
    private long productAmount;
    // Verbindliche Aufträge
    private long order;
    // Sicherheitsbestand
    private long securityProvision;
    // Lager Ende Vorperiode
    private long storeLastPeriod;
    // Warteschlange
    private long waitingArticle;
    // In Bearbeitung
    private long processingArticle;

    public Disposal(
            Forecast forecast,
            long prodOrder,
            long productAmount,
            long order,
            long securityProvision,
            long storeLastPeriod,
            long waitingArticle,
            long processingArticle) {
        this.forecast = forecast;
        this.prodOrder = prodOrder;
        this.productAmount = productAmount;
        this.order = order;
        this.securityProvision = securityProvision;
        this.storeLastPeriod = storeLastPeriod;
        this.waitingArticle = waitingArticle;
        this.processingArticle = processingArticle;
    }

    long CalculateProdOrders(
            long order,
            long securityProvision,
            long storeLastPeriod,
            long waitingArticle,
            long processingArticle) {
        long param = order + securityProvision - storeLastPeriod - waitingArticle - processingArticle;

        return param > 0 ? param : 0;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public long getProdOrder() {
        return prodOrder;
    }

    public void setProdOrder(long prodOrder) {
        this.prodOrder = prodOrder;
    }

    public long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(long productAmount) {
        this.productAmount = productAmount;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getSecurityProvision() {
        return securityProvision;
    }

    public void setSecurityProvision(long securityProvision) {
        this.securityProvision = securityProvision;
    }

    public long getStoreLastPeriod() {
        return storeLastPeriod;
    }

    public void setStoreLastPeriod(long storeLastPeriod) {
        this.storeLastPeriod = storeLastPeriod;
    }

    public long getWaitingArticle() {
        return waitingArticle;
    }

    public void setWaitingArticle(long waitingArticle) {
        this.waitingArticle = waitingArticle;
    }

    public long getProcessingArticle() {
        return processingArticle;
    }

    public void setProcessingArticle(long processingArticle) {
        this.processingArticle = processingArticle;
    }
}
