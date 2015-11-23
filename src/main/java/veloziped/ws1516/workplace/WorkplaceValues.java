/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workplace;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Martin
 */
public class WorkplaceValues {
    
    private long id;
    private double firstShiftWage;
    private double secondShiftWage;
    private double thirdShiftWage;
    private double overtimeWage;
    private double variableMachineCosts;
    private double fixMachineCosts;
    private List<ProcessTime> processTimes;

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj == null) {
            result = false;
        } else if (obj.getClass() == this.getClass()) {
            WorkplaceValues b = (WorkplaceValues) obj;
            if (Objects.equals(this.id, b.id)) {
                result = true;
            }
        }
        
        return result;
    }
    
    public List<ProcessTime> getProcessTimes() {
        return processTimes;
    }

    public WorkplaceValues(long id, double firstShiftWage, double secondShiftWage, double thirdShiftWage, 
            double overtimeWage, double variableMachineCosts, double fixMachineCosts, List<ProcessTime> processTimes) {
        this.id = id;
        this.firstShiftWage = firstShiftWage;
        this.secondShiftWage = secondShiftWage;
        this.thirdShiftWage = thirdShiftWage;
        this.overtimeWage = overtimeWage;
        this.variableMachineCosts = variableMachineCosts;
        this.fixMachineCosts = fixMachineCosts;
        this.processTimes = processTimes;
    }
    
    public double getFixMachineCosts() {
        return fixMachineCosts;
    }

    public double getVariableMachineCosts() {
        return variableMachineCosts;
    }

    public double getOvertimeWage() {
        return overtimeWage;
    }

    public double getThirdShiftWage() {
        return thirdShiftWage;
    }

    public double getFirstShiftWage() {
        return firstShiftWage;
    }

    public double getSecondShiftWage() {
        return secondShiftWage;
    }

    public long getId() {
        return id;
    }
}
