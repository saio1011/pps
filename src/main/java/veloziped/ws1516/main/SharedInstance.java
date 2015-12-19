/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import com.google.common.math.DoubleMath;
import com.rits.cloning.Cloner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Input.Input;
import veloziped.ws1516.generated.Input.Item;
import veloziped.ws1516.generated.Input.Orderlist;
import veloziped.ws1516.generated.Input.Production;
import veloziped.ws1516.generated.Input.Productionlist;
import veloziped.ws1516.generated.Input.Qualitycontrol;
import veloziped.ws1516.generated.Input.Selldirect;
import veloziped.ws1516.generated.Input.Sellwish;
import veloziped.ws1516.generated.Input.Workingtime;
import veloziped.ws1516.generated.Input.Workingtimelist;
import veloziped.ws1516.generated.Results.Completedorders;
import veloziped.ws1516.generated.Results.Cycletimes;
import veloziped.ws1516.generated.Results.Futureinwardstockmovement;
import veloziped.ws1516.generated.Results.Idletimecosts;
import veloziped.ws1516.generated.Results.Inwardstockmovement;
import veloziped.ws1516.generated.Results.Order;
import veloziped.ws1516.generated.Results.Ordersinwork;
import veloziped.ws1516.generated.Results.Result;
import veloziped.ws1516.generated.Results.Results;
import veloziped.ws1516.generated.Results.Waitingliststock;
import veloziped.ws1516.generated.Results.Waitinglistworkstations;
import veloziped.ws1516.generated.Results.Warehousestock;
import veloziped.ws1516.generated.Results.Workplace;
import veloziped.ws1516.production.Forecast;
import veloziped.ws1516.production.ProductionPlan;
import veloziped.ws1516.production.CalculationMode;
import veloziped.ws1516.workload.WorkloadResult;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Martin
 */
public class SharedInstance {

    private SharedInstance() {
    }

    private Forecast forecast = new Forecast();
    private Map<String, ExtendedWorkplace> extendedWorkplaces;
    private Map<String, ExtendedArticle> extendedArticles;
    private Map<String, Order> incomingOrdersThisPeriod;
    private ProductionPlan productionPlan;
    private Results results;
    private CalculationMode calculationMode;
    // 1 == 100%
    private double discountFactor;
    private double bufferFactor;
    private List<Order> newOrders;
    private List<Item> sellDirect;
    private Map<String, WorkloadResult> workloadResults;
    private List<Production> productionListCalculated;
    private Locale currentLocale = Locale.getDefault();

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

    public void replaceNewOrder(Order newOrder) {
        for (int i = 0; i < newOrders.size(); i++) {
            if (newOrders.get(i).getArticle() == newOrder.getArticle()) {
                newOrders.set(i, newOrder);
            }
        }
    }

    public void setDefaultValues() {
        this.sellDirect = new ArrayList<>();
        Item p1 = new Item();
        p1.setArticle(1);
        p1.setQuantity(0);
        p1.setPrice(0.0);
        p1.setPenalty(0.0);
        Item p2 = new Item();
        p2.setArticle(2);
        p2.setQuantity(0);
        p2.setPrice(0.0);
        p2.setPenalty(0.0);
        Item p3 = new Item();
        p3.setArticle(3);
        p3.setQuantity(0);
        p3.setPrice(0.0);
        p3.setPenalty(0.0);
        this.sellDirect.add(p1);
        this.sellDirect.add(p2);
        this.sellDirect.add(p3);
    }
    
    public Order getNewOrderById(long id) {
        for (int i = 0; i < newOrders.size(); i++) {
            if (newOrders.get(i).getArticle() == id) {
                return newOrders.get(i);
            }
        }
        return null;
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public List<Production> getProductionListCalculated() {
        return productionListCalculated;
    }
    
    public void setSellDirectForArticle(Item item) {
        for(Item curItem : this.sellDirect) {
            if(curItem.getArticle() == item.getArticle()){
                this.sellDirect.remove(curItem);
                this.sellDirect.add(item);
                break;
            } 
        }
    }

    public void setProductionListCalculated(List<Production> productionListCalculated) {
        this.productionListCalculated = productionListCalculated;
    }

    public List<Item> getSellDirect() {
        if (sellDirect == null) {
            return new ArrayList<>();
        }
        return sellDirect;
    }

    public void setSellDirect(List<Item> sellDirect) {
        this.sellDirect = sellDirect;
    }

    public Map<String, WorkloadResult> getWorkloadResults() {
        if (workloadResults == null) {
            return new HashMap<>();
        }
        return workloadResults;
    }

    public void setWorkloadResults(Map<String, WorkloadResult> workloadResults) {
        this.workloadResults = workloadResults;
    }

    public List<Order> getNewOrders() {
        if (newOrders == null) {
            return new ArrayList<>();
        }
        return newOrders;
    }

    public void setNewOrders(List<Order> newOrders) {
        this.newOrders = newOrders;
    }

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

    public boolean setExtendedWorkplaceForId(Long id, ExtendedWorkplace workplace) {
        boolean result = false;

        if (id != null) {
            extendedWorkplaces.put(String.valueOf(id), workplace);
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

    public Order getIncomingOrderForArticleId(Long id) {
        Order result = null;

        if (id != null) {
            result = incomingOrdersThisPeriod.get(String.valueOf(id));
        }

        return result;
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
        Results results = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            results = (Results) jaxbUnmarshaller.unmarshal(file);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not load data", null, JOptionPane.ERROR_MESSAGE);
        }
        return results;
    }

    public void saveInputFile(File file) {
        Input input = this.combineInput();
        try {
            JAXBContext context = JAXBContext
                    .newInstance(Input.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //This removes all the XML declaration line.
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);

            m.marshal(input, file);

            Desktop desktop = null;
            try {
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                    desktop.open(new File(file.getParent()));
                } else {
                    System.out.println("desktop is not supported");

                }
            } catch (IOException e) {
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not save data", null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public Input combineInput() {
        Input input = new Input();

        Qualitycontrol control = new Qualitycontrol();
        control.setDelay(0);
        control.setLosequantity(0);
        control.setType("no");
        input.setQualitycontrol(control);

        input.setSellwish(this.getSellwish());
        input.setSelldirect(this.getSelldirectForInput());
        input.setOrderlist(this.getOrderList());
        input.setWorkingtimelist(this.getWorkingTimeList());
        input.setProductionlist(this.getProductionList());

        return input;
    }

    private Sellwish getSellwish() {
        Sellwish sellwish = new Sellwish();
        List<Item> items = new ArrayList<>();

        Item p1 = new Item();
        p1.setArticle(1);
        p1.setQuantity(0);
        //p1.setQuantity(this.getArticleForId((long)1).get);
        Item p2 = new Item();
        p2.setArticle(2);
        p2.setQuantity(0);
        //p2.setQuantity(this.getArticleForId((long)2).get);
        Item p3 = new Item();
        p3.setArticle(3);
        p3.setQuantity(0);
        //p3.setQuantity(this.getArticleForId((long)3).get);
        items.add(p1);
        items.add(p2);
        items.add(p3);
        sellwish.setItem(items);

        return sellwish;
    }

    private Selldirect getSelldirectForInput() {
        Selldirect sell = new Selldirect();
        sell.setItem(this.getSellDirect());

        return sell;
    }

    private Orderlist getOrderList() {
        Orderlist list = new Orderlist();
        List<veloziped.ws1516.generated.Input.Order> orderList = new ArrayList<>();

        for (Order order : this.getNewOrders()) {
            veloziped.ws1516.generated.Input.Order inputOrder = new veloziped.ws1516.generated.Input.Order();
            inputOrder.setArticle(order.getArticle());
            inputOrder.setModus(order.getMode());
            inputOrder.setQuantity(order.getAmount());
            orderList.add(inputOrder);
        }

        list.setOrder(orderList);
        return list;
    }

    private Workingtimelist getWorkingTimeList() {
        Workingtimelist timeList = new Workingtimelist();
        List<Workingtime> work = new ArrayList<>();

        for (WorkloadResult result : this.getWorkloadResults().values()) {
            Workingtime time = new Workingtime();
            time.setStation(result.getWorkplace().getId());
            time.setShift(result.getNumberOfShifts());
            time.setOvertime(result.getOverTimeDay());
            work.add(time);
        }

        timeList.setWorkingtime(work);
        return timeList;
    }

    private Productionlist getProductionList() {
        Productionlist prodList = new Productionlist();
        prodList.setProduction(this.productionListCalculated);

        return prodList;
    }

    public void parseResults(Results results) {
        if (results == null) {
            return;
        }

        this.results = results;

        warehouseStock = results.getWarehousestock();
        result = results.getResult();
        inwardStockMovement = results.getInwardstockmovement();
        cycleTimes = results.getCycletimes();
        waitinglistWorkstations = results.getWaitinglistworkstations();
        idleTimeCosts = results.getIdletimecosts();
        waitinglistStock = results.getWaitingliststock();
        ordersInWork = results.getOrdersinwork();
        completeOrder = results.getCompletedorders();
        futureInwardStockMovement = results.getFutureinwardstockmovement();

    }

    public Map<String, ExtendedArticle> calcNewArticleStockValue() {
        for (ExtendedArticle article : this.extendedArticles.values()) {
            long change = 0;
            Order incoming = this.getIncomingOrderForArticleId(article.getId());
            if (incoming != null) {
                change += incoming.getAmount();
            }
            //Zuwachs dazurechnen
            change += (article.getSafetyStock() - article.getAmount());

            article.setStockChange(change);
            article.setNewStock(article.getAmount() + change);
            article.setNewStockValue(article.getPrice() * article.getNewStock());

            double stockChangePct = 0.0;
            stockChangePct = (double) article.getAmount() / article.getNewStock();
            if (stockChangePct < 1) {
                article.setStockChangePct(((double) 1 - stockChangePct) * 100);
            } else if (stockChangePct > 1) {
                article.setStockChangePct((stockChangePct - 1) * -100);
            }

            this.setExtendedArticleForId(article.getId(), article);
        }

        return this.extendedArticles;
    }

    public final int[] productionListOrder = new int[]{
        13,
        18,
        7,
        14,
        19,
        8,
        15,
        20,
        9,
        10,
        4,
        49,
        11,
        5,
        54,
        12,
        29,
        6,
        50,
        55,
        30,
        16,
        17,
        51,
        56,
        31,
        26,
        1,
        2,
        3};

    public List<Production> calculateProductionList() {
        List<Production> pList = new ArrayList<>();
        int Interation_One = 100;
        int Interation_Two = 150;

        Cloner cloner = new Cloner();
        Map<String, ExtendedArticle> articles = cloner.deepClone(this.extendedArticles);

        for (int i = 0; i < this.productionListOrder.length; i++) {
            ExtendedArticle article = articles.get(String.valueOf(this.productionListOrder[i]));

            int Interation_One_Use = Interation_One;

            if (article.getId() == 16 || article.getId() == 17 || article.getId() == 26) {
                Interation_One_Use = 150;
            }

            if (article.getPlannedProductionAmount() > Interation_One_Use) {
                Production prod = new Production();
                prod.setArticle(article.getId());
                prod.setQuantity(Interation_One_Use);
                pList.add(prod);

                article.setPlannedProductionAmount(article.getPlannedProductionAmount() - Interation_One_Use);
            } else if (article.getPlannedProductionAmount() > 0) {
                Production prod = new Production();
                prod.setArticle(article.getId());
                prod.setQuantity(article.getPlannedProductionAmount());
                pList.add(prod);
            }
        }

        for (int i = 0; i < this.productionListOrder.length; i++) {
            ExtendedArticle article = articles.get(String.valueOf(this.productionListOrder[i]));

            int Interation_Two_Use = Interation_Two;

            if (article.getId() == 16 || article.getId() == 17 || article.getId() == 26) {
                Interation_Two_Use = 220;
            }

            if (article.getPlannedProductionAmount() > Interation_Two_Use) {
                Production prod = new Production();
                prod.setArticle(article.getId());
                prod.setQuantity(Interation_Two_Use);
                pList.add(prod);

                article.setPlannedProductionAmount(article.getPlannedProductionAmount() - Interation_Two_Use);
            } else if (article.getPlannedProductionAmount() > 0) {
                Production prod = new Production();
                prod.setArticle(article.getId());
                prod.setQuantity(article.getPlannedProductionAmount());
                pList.add(prod);
            }
        }

        for (int i = 0; i < this.productionListOrder.length; i++) {
            ExtendedArticle article = articles.get(String.valueOf(this.productionListOrder[i]));

            if (article.getPlannedProductionAmount() > 0) {
                Production prod = new Production();
                prod.setArticle(article.getId());
                prod.setQuantity(article.getPlannedProductionAmount());
                pList.add(prod);
            }
        }

        this.productionListCalculated = pList;

        return this.productionListCalculated;
    }

    public static final <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void swapProductionListOrder(int i, int j) {
        Collections.swap(this.productionListCalculated, i, j);
    }
    
    
    public static double twoDecimals(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(new Locale("us")));
        String val = df.format(value);
        return Double.valueOf(val);
    }
}
