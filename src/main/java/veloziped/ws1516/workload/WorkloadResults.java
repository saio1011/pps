/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workload;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import veloziped.ws1516.workplace.ProcessTime;

/**
 *
 * @author Martin
 */
public class WorkloadResults {

    //TODO: Kap. Bed. (Rückstand Vorperiode)
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final long workplaceId;
    private long capacityNeeded;
    private long setupTime;
    private long lastSetupCycles;
    private double setupFactor;
    private long additionalSetupTime;
    private long capacityNeededLastPeriod;
    private long totalCapacityNeeded;
    private long numberOfShifts;
    private long overTimePeriod;
    private long overTimeDay;
    private long freeCapacity;
    private double workloadPercentage;
    private List<ProcessTime> processTimes;

    public double getWorkloadPercentage() {
        return workloadPercentage;
    }

    public long getFreeCapacity() {
        return freeCapacity;
    }

    public long getOverTimeDay() {
        return overTimeDay;
    }

    public long getOverTimePeriod() {
        return overTimePeriod;
    }

    public long getNumberOfShifts() {
        return numberOfShifts;
    }

    public long getTotalCapacityNeeded() {
        return totalCapacityNeeded;
    }

    public long getCapacityNeededLastPeriod() {
        return capacityNeededLastPeriod;
    }

    public long getAdditionalSetupTime() {
        return additionalSetupTime;
    }

    public double getSetupFactor() {
        return setupFactor;
    }

    public long getLastSetupCycles() {
        return lastSetupCycles;
    }

    public void setLastSetupCycles(long lastSetupCycles) {
        this.lastSetupCycles = lastSetupCycles;
    }

    public long getSetupTime() {
        return setupTime;
    }

    public long getCapacityNeeded() {
        return capacityNeeded;
    }

    public WorkloadResults(long workplaceId, List<ProcessTime> processTimes) {
        this.workplaceId = workplaceId;
        this.processTimes = processTimes;
    }

    public long getWorkplaceId() {
        return workplaceId;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
