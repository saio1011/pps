/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.disposal;

import java.io.Console;
import org.junit.experimental.results.PrintableResult;
import veloziped.ws1516.articles.ArticleType;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.production.PeriodDetail;

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
    // Period
    private PeriodDetail period;
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
            long processingArticle,
            PeriodDetail period) {
        this.forecast = forecast;
        this.prodOrder = prodOrder;
        this.productAmount = productAmount;
        this.order = order;
        this.securityProvision = securityProvision;
        this.storeLastPeriod = storeLastPeriod;
        this.waitingArticle = waitingArticle;
        this.processingArticle = processingArticle;
        //this.period = forecast.getPeriodN0();
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

    /*void CalculateProdOrders(
            ExtendedArticle article) {
        if (article.getType().equals(ArticleType.P)) {
            // TODO in Article property for ProdMenge
            // TODO 
            long pa = order + securityProvision - storeLastPeriod - waitingArticle - processingArticle;
            article.setProdAmount(article.getProdAmount() > 0 ? article.getProdAmount() : 0);
        } else {
            PeriodDetail per = forecast.getPeriodN0();
            this.prodOrder = article.getParentArticle().getProdAmount() > 0 ? article.getParentArticle().getProdAmount() : 0;
            //if (parentArticle.) {

            //}
        }
    }*/
}
