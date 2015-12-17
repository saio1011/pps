/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.costs;

import veloziped.ws1516.main.SharedInstance;

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
    
    private Costs() {
    }
    
    public static Costs getInstance() {
        return EstimatedCostsHolder.INSTANCE;
    }
    
    private static class EstimatedCostsHolder {

        private static final Costs INSTANCE = new Costs();
    }
    
    public void calculateCosts() {
        this.oldStockValue();
    }
    
    private void oldStockValue() {
       this.oldStockValue = SharedInstance.getInstance().getWarehouseStock().getTotalstockvalue();
    }
    
    private void estimatedStockValue() {
        
    }
}
