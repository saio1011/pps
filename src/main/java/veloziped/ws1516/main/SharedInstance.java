/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import com.google.common.math.DoubleMath;
import java.io.File;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Completedorders;
import veloziped.ws1516.generated.Cycletimes;
import veloziped.ws1516.generated.Futureinwardstockmovement;
import veloziped.ws1516.generated.Idletimecosts;
import veloziped.ws1516.generated.Inwardstockmovement;
import veloziped.ws1516.generated.Order;
import veloziped.ws1516.generated.Ordersinwork;
import veloziped.ws1516.generated.Result;
import veloziped.ws1516.generated.Results;
import veloziped.ws1516.generated.Waitingliststock;
import veloziped.ws1516.generated.Waitinglistworkstations;
import veloziped.ws1516.generated.Warehousestock;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.production.ProductionPlan;
import veloziped.ws1516.production.CalculationMode;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Martin
 */
public class SharedInstance {

    private SharedInstance() {
    }

    private Forecast forecast = new Forecast();
    private Map<String, Long> orderQuantities;
    private Map<String, ExtendedWorkplace> extendedWorkplaces;
    private Map<String, ExtendedArticle> extendedArticles;
    private Map<String, Order> incomingOrdersThisPeriod;
    private ProductionPlan productionPlan;
    private Results results;
    private CalculationMode calculationMode;
    // 1 == 100%
    private double discountFactor;
    private double bufferFactor;

    private Result result;
    private Inwardstockmovement inwardStockMovement;
    private Cycletimes cycleTimes;
    private Waitinglistworkstations waitinglistWorkstations;
    private Idletimecosts idleTimeCosts;
    private Waitingliststock waitinglistStock;
    private Ordersinwork ordersInWork;
    private Completedorders completeOrder;
    private Futureinwardstockmovement futureInwardStockMovement;
    private Warehousestock warehouseStock;

    public double getBufferFactor() {
        return bufferFactor;
    }

    public void setBufferFactor(double bufferFactor) {
        this.bufferFactor = bufferFactor;
    }

    public Results getResults() {
        return results;
    }

    public Result getResult() {
        return result;
    }

    public Inwardstockmovement getInwardStockMovement() {
        return inwardStockMovement;
    }

    public Cycletimes getCycleTimes() {
        return cycleTimes;
    }

    public Waitinglistworkstations getWaitinglistWorkstations() {
        return waitinglistWorkstations;
    }

    public Idletimecosts getIdleTimeCosts() {
        return idleTimeCosts;
    }

    public Waitingliststock getWaitinglistStock() {
        return waitinglistStock;
    }

    public Ordersinwork getOrdersInWork() {
        return ordersInWork;
    }

    public Completedorders getCompleteOrder() {
        return completeOrder;
    }

    public Futureinwardstockmovement getFutureInwardStockMovement() {
        return futureInwardStockMovement;
    }

    public Warehousestock getWarehouseStock() {
        return warehouseStock;
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public CalculationMode getCalculationMode() {
        return calculationMode;
    }

    public void setCalculationMode(CalculationMode calculationMode) {
        this.calculationMode = calculationMode;
    }

    public static SharedInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }

    private static class SharedInstanceHolder {

        private static final SharedInstance INSTANCE = new SharedInstance();
    }

    public ExtendedWorkplace getWorkplaceForId(Long id) {
        ExtendedWorkplace result = null;

        if (id != null) {
            result = extendedWorkplaces.get(String.valueOf(id));
        }

        return result;
    }

    public Map<String, ExtendedWorkplace> getExtendedWorkplaces() {
        return extendedWorkplaces;
    }

    public Map<String, ExtendedArticle> getExtendedArticles() {
        return extendedArticles;
    }

    public Map<String, Order> getIncomingOrdersThisPeriod() {
        return incomingOrdersThisPeriod;
    }

    public ProductionPlan getProductionPlan() {
        return productionPlan;
    }

    public ExtendedArticle getArticleForId(Long id) {
        ExtendedArticle result = null;

        if (id != null) {
            result = extendedArticles.get(String.valueOf(id));
        }

        return result;
    }

    public boolean setExtendedArticleForId(Long id, ExtendedArticle article) {
        boolean result = false;

        if (id != null) {
            extendedArticles.put(String.valueOf(id), article);
            result = true;
        }

        return result;
    }

    public ProductionPlan getProcudtionPlan() {
        return productionPlan;
    }

    public void setProductionPlan(ProductionPlan productionPlan) {
        this.productionPlan = productionPlan;
    }

    public Map<String, ExtendedWorkplace> getWorkplaces() {
        return extendedWorkplaces;
    }

    public void setExtendedWorkplaces(Map<String, ExtendedWorkplace> workplaces) {
        this.extendedWorkplaces = workplaces;
    }

    public void setExtendedArticles(Map<String, ExtendedArticle> articles) {
        this.extendedArticles = articles;
    }

    public boolean setOrderQuantityForArticleId(Long id, Long quantity) {
        boolean result = false;

        if (id != null) {
            orderQuantities.put(String.valueOf(id), quantity);
            result = true;
        }

        return result;
    }

    public Long getOrderQuantityForArticleId(Long id) {
        Long result = null;

        if (id != null) {
            result = orderQuantities.get(String.valueOf(id));
        }

        return result;
    }

    public Order getIncomingOrderForArticleId(Long id) {
        Order result = null;

        if (id != null) {
            result = incomingOrdersThisPeriod.get(String.valueOf(id));
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

    public Map<String, Order> calcIncomingOrdersThisPeriod(List<Order> incoming) {
        incomingOrdersThisPeriod = new HashMap<>();
        long currentPeriod = this.results.getPeriod() + 1;

        for (Order order : incoming) {
            ExtendedArticle article = this.getArticleForId(order.getArticle());
            long estimatedPeriod = this.getEstimatedDeliverPeriod(article, order);

            if (estimatedPeriod <= currentPeriod) {
                incomingOrdersThisPeriod.put(String.valueOf(order.getArticle()), order);
            }
        }

        return incomingOrdersThisPeriod;
    }

    private long getEstimatedDeliverPeriod(ExtendedArticle article, Order order) {
        long estimatedPeriod = 0;

        if (order.getMode() == 5) {
            estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeNormalAsPeriods(this.calculationMode) + order.getOrderperiod(), RoundingMode.DOWN);
        } else if (order.getMode() == 4) {
            estimatedPeriod = DoubleMath.roundToLong(article.getDeliveryTimeFastAsPeriod() + order.getOrderperiod(), RoundingMode.DOWN);
        } else {
            throw new IllegalArgumentException("Delivery mode not supported.");
        }

        return estimatedPeriod;
    }

    public static Results parseXmlInput(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Results results = (Results) jaxbUnmarshaller.unmarshal(file);
        return results;
    }

    public void parseResults(Results results) {
        if (results == null) {
            return;
        }

        this.results = results;

        for (Object object : results.getContent()) {
            if (object.getClass().equals(Warehousestock.class)) {
                warehouseStock = (Warehousestock) object;
            } else if (object.getClass().equals(Result.class)) {
                result = (Result) object;
            } else if (object.getClass().equals(Inwardstockmovement.class)) {
                inwardStockMovement = (Inwardstockmovement) object;
            } else if (object.getClass().equals(Cycletimes.class)) {
                cycleTimes = (Cycletimes) object;
            } else if (object.getClass().equals(Waitinglistworkstations.class)) {
                waitinglistWorkstations = (Waitinglistworkstations) object;
            } else if (object.getClass().equals(Idletimecosts.class)) {
                idleTimeCosts = (Idletimecosts) object;
            } else if (object.getClass().equals(Waitingliststock.class)) {
                waitinglistStock = (Waitingliststock) object;
            } else if (object.getClass().equals(Ordersinwork.class)) {
                ordersInWork = (Ordersinwork) object;
            } else if (object.getClass().equals(Completedorders.class)) {
                completeOrder = (Completedorders) object;
            } else if (object.getClass().equals(Futureinwardstockmovement.class)) {
                futureInwardStockMovement = (Futureinwardstockmovement) object;
            }
        }
    }
}
