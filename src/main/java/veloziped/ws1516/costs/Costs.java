/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.costs;

import com.google.common.math.DoubleMath;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.workload.WorkloadResult;
import veloziped.ws1516.workplace.ExtendedWorkplace;
import veloziped.ws1516.workplace.ProcessTime;

/**
 *
 * @author Martin
 */
public class Costs {

    private double estimatedStockValue;
    private double oldStockValue;
    private long countOfWarehouses;
    private double warehouseHoldingCosts;
    private double laborCosts;
    private double machineCosts;
    private double emptyCosts;
    private double materialCosts;
    private double averageStockValue;
    private double warehouseHoldingPctChange;
    private double stockChangePct;
    private int countWarehouseChange;

    public double getAverageStockValue() {
        return averageStockValue;
    }

    public double getWarehouseHoldingPctChange() {
        return warehouseHoldingPctChange;
    }

    public double getStockChangePct() {
        return stockChangePct;
    }

    public int getCountWarehouseChange() {
        return countWarehouseChange;
    }

    public double getOldStockValue() {
        return oldStockValue;
    }

    public double getEstimatedStockValue() {
        return estimatedStockValue;
    }

    public long getCountOfWarehouses() {
        return countOfWarehouses;
    }

    public double getWarehouseHoldingCosts() {
        return warehouseHoldingCosts;
    }

    public double getLaborCosts() {
        return laborCosts;
    }

    public double getMachineCosts() {
        return machineCosts;
    }

    public double getEmptyCosts() {
        return emptyCosts;
    }

    public double getMaterialCosts() {
        return materialCosts;
    }

    public Costs() {
        estimatedStockValue = 0;
        oldStockValue = 0;
        countOfWarehouses = 0;
        warehouseHoldingCosts = 0;
        laborCosts = 0;
        machineCosts = 0;
        emptyCosts = 0;
        materialCosts = 0;
        averageStockValue = 0;
        warehouseHoldingPctChange = 0;
        stockChangePct = 0;
        countWarehouseChange = 0;
    }

    public void calculateCosts() {
        this.oldStockValue();
        this.estimatedStockValue();
        this.averageStockValue();
        this.numberHouses();
        this.warehouseHolding();

        this.laberCosts();
    }

    private void oldStockValue() {
        //ist was anderes als general.storevalue.current
        this.oldStockValue = SharedInstance.getInstance().getWarehouseStock().getTotalstockvalue();
    }

    private void estimatedStockValue() {
        Collection<ExtendedArticle> list = SharedInstance.getInstance().getExtendedArticles().values();
        for (ExtendedArticle article : list) {
            this.estimatedStockValue += article.getNewStockValue();
        }
        this.estimatedStockValue = SharedInstance.twoDecimals(this.estimatedStockValue);

        if (this.estimatedStockValue > 0) {
            double stockPct = this.estimatedStockValue / this.oldStockValue;

            if (stockPct < 1) {
                this.stockChangePct = SharedInstance.twoDecimals(((double) 1 - stockPct) * -100);
            } else if (stockPct > 1) {
                this.stockChangePct = SharedInstance.twoDecimals((stockPct - 1) * 100);
            }
        }
    }

    private void averageStockValue() {
        this.averageStockValue = (SharedInstance.getInstance().getResult().getGeneral().getStorevalue().getAverage()
                + this.estimatedStockValue) / 2;
    }

    private void numberHouses() {
        //anzahl lager anhand durchschnittl lagerwert?
        this.countOfWarehouses = (this.averageStockValue > 250000) ? 2 : 1;
        int numberOld = (SharedInstance.getInstance().getResult().getGeneral().getStorevalue().getAverage() > 250000) ? 2 : 1;
        if (numberOld < this.countOfWarehouses) {
            this.countWarehouseChange = 1;
        } else if (numberOld < this.countOfWarehouses) {
            this.countWarehouseChange = -1;
        }
    }

    private void warehouseHolding() {
        if (this.averageStockValue > 250000) {
            this.warehouseHoldingCosts = SharedInstance.twoDecimals(0.006 * 250000 + 0.012 * (this.averageStockValue - 250000) + 5000);
        } else {
            this.warehouseHoldingCosts = SharedInstance.twoDecimals(0.006 * this.averageStockValue);
        }

        if (this.warehouseHoldingCosts > 0) {
            double holdingPct =  this.warehouseHoldingCosts / SharedInstance.getInstance().getResult().getGeneral().getStoragecosts().getCurrent();
            
            if (holdingPct < 1) {
                this.warehouseHoldingPctChange = SharedInstance.twoDecimals(((double) 1 - holdingPct) * -100);
            } else if (holdingPct > 1) {
                this.warehouseHoldingPctChange = SharedInstance.twoDecimals((holdingPct - 1) * 100);
            }
        }
    }

    private void laberCosts() {
        Collection<WorkloadResult> wResults = SharedInstance.getInstance().getWorkloadResults().values();

        for (WorkloadResult result : wResults) {
            for (ProcessTime times : result.getWorkplace().getProcessTimes()) {
                ExtendedArticle article = SharedInstance.getInstance().getArticleForId(times.getArticleId());
                
                if (result.getNumberOfShifts() == 1) {
                    long overtimeProd = calcProductionAmountInOvertime(result, times);

                    this.laborCosts += (article.getPlannedProductionAmount() - overtimeProd) * times.getRunTime() * result.getWorkplace().getFirstShiftWage()
                            + result.getLastSetupCycles() * result.getWorkplace().getFirstShiftWage()
                            + overtimeProd * times.getRunTime() * result.getWorkplace().getFirstShiftWage();
                } else {
                    
                }
            }
        }
        
        this.laborCosts = SharedInstance.twoDecimals(this.laborCosts);
    }

    private long calcProductionAmountInOvertime(WorkloadResult wRes, ProcessTime time) {
        long result = 0;
        double calc = result = wRes.getOverTimePeriod() / time.getRunTime() - time.getSetupTime();
        try {
            if (calc > 0) {
                result = DoubleMath.roundToLong(calc, RoundingMode.HALF_UP);
            }
        } catch (NumberFormatException ex) {

        }
        return result;
    }
    
    private long calcProductionAmountInShift(WorkloadResult wRes, ProcessTime time) {
        long result = 0;
        double calc = result = (wRes.getTotalCapacityNeeded() - wRes.getOverTimePeriod()) / time.getRunTime() - time.getSetupTime();
        try {
            if (calc > 0) {
                result = DoubleMath.roundToLong(calc, RoundingMode.HALF_UP);
            }
        } catch (NumberFormatException ex) {

        }
        return result;
    }
}
