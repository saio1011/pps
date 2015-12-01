/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workload;

import static java.lang.Math.ceil;
import java.text.DecimalFormat;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.workplace.*;
import static java.lang.Math.round;

/**
 *
 * @author Martin
 */
public class WorkloadResult {

    //TODO: Kap. Bed. (Rückstand Vorperiode)
    private final ExtendedWorkplace workplace;
    private long capacityNeeded;
    private long setupTime;
    private long lastSetupCycles;
    private double setupFactor;
    private long additionalSetupTime;
    private final long backlogCapacityLastPeriod;
    private final long backlogSetupTimeLastPeriod;
    private long totalCapacityNeeded;
    private long numberOfShifts;
    private long overTimePeriod;
    private long overTimeDay;
    private long freeCapacity;
    private double workloadPercentage;

    public WorkloadResult(ExtendedWorkplace workplace) {
        this.workplace = workplace;
        this.lastSetupCycles = workplace.getSetupevents();

        //TODO get from xml
        this.backlogCapacityLastPeriod = 0;
        this.backlogSetupTimeLastPeriod = 0;

        this.capacityNeeded = 0;
        this.setupTime = 0;
        this.setupFactor = 0;
        this.additionalSetupTime = 0;
        this.totalCapacityNeeded = 0;
        this.numberOfShifts = 0;
        this.overTimePeriod = 0;
        this.overTimeDay = 0;
        this.freeCapacity = 0;
        this.workloadPercentage = 0;
    }

    public long getBacklogSetupTimeLastPeriod() {
        return backlogSetupTimeLastPeriod;
    }

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

    public long getBacklogCapacityLastPeriod() {
        return backlogCapacityLastPeriod;
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

    public ExtendedWorkplace getWorkplaceId() {
        return workplace;
    }

    public void reCalculateResults() {
        this.calcCapacityNeeded();
        this.calcSetupTime();
        this.calcAdditionalSetupTime();
        this.calcTotalCapacityNeeded();
        this.calcNumberOfShifts();
        this.calcOverTime();
        this.calcFreeCapacity();
        this.calcWorkloadPercentage();
    }

    private void calcCapacityNeeded() {
        for (ProcessTime process : this.workplace.getProcessTimes()) {
            Long orderQuantity = SharedInstance.getInstance()
                    .getOrderQuantityForArticleId(process.getArticleId());

            if (orderQuantity != null) {
                this.capacityNeeded += orderQuantity * process.getRunTime();
            }
        }
    }

    private void calcSetupTime() {
        for (ProcessTime process : this.workplace.getProcessTimes()) {
            Long orderQuantity = SharedInstance.getInstance()
                    .getOrderQuantityForArticleId(process.getArticleId());

            if (orderQuantity != null && orderQuantity > 0) {
                this.setupTime += process.getSetupTime();
            }
        }
    }

    private void calcAdditionalSetupTime() {
        int size = this.workplace.getProcessTimes().size();

        if (size > 0) {
            this.setupFactor = this.lastSetupCycles
                    / this.workplace.getProcessTimes().size();
        }

        this.additionalSetupTime = (long) ceil(this.setupTime * this.setupFactor);
    }

    private void calcTotalCapacityNeeded() {
        this.totalCapacityNeeded = this.capacityNeeded + this.setupTime
                + this.additionalSetupTime + this.backlogCapacityLastPeriod
                + this.backlogSetupTimeLastPeriod;
    }

    private void calcNumberOfShifts() {
        //enough capacity for first shift
        if (this.totalCapacityNeeded < WorkloadPlanning.LIMITPERSHIFT) {
            this.numberOfShifts = 1;

            //limit of over time not reached (first shift)
        } else if ((this.totalCapacityNeeded - WorkloadPlanning.LIMITPERSHIFT)
                <= WorkloadPlanning.LIMITOVERTIME
                && //and costs of over time is lower than costs of second shift
                ((this.totalCapacityNeeded - WorkloadPlanning.LIMITPERSHIFT)
                * this.workplace.getOvertimeWage())
                < (WorkloadPlanning.LIMITPERSHIFT * this.workplace.getSecondShiftWage())) {
            this.numberOfShifts = 1;

            //enough capacity for second shift
        } else if (this.totalCapacityNeeded < (WorkloadPlanning.LIMITPERSHIFT * 2)) {
            this.numberOfShifts = 2;

            //limit of over time not reached (second shift)
        } else if ((this.totalCapacityNeeded - (WorkloadPlanning.LIMITPERSHIFT * 2))
                <= WorkloadPlanning.LIMITOVERTIME
                && //and costs of over time is lower than costs of third shift
                ((this.totalCapacityNeeded - (WorkloadPlanning.LIMITPERSHIFT * 2))
                * this.workplace.getOvertimeWage())
                < ((WorkloadPlanning.LIMITPERSHIFT * 2) * this.workplace.getThirdShiftWage())) {
            this.numberOfShifts = 2;

            //work in three shifts
        } else {
            this.numberOfShifts = 3;
        }
    }

    private void calcOverTime() {
        if (this.totalCapacityNeeded > (this.numberOfShifts * WorkloadPlanning.LIMITPERSHIFT)) {
            this.overTimePeriod = this.totalCapacityNeeded
                    - (this.numberOfShifts * WorkloadPlanning.LIMITPERSHIFT);
        } else {
            this.overTimePeriod = 0;
        }

        this.overTimeDay = round(this.overTimePeriod / 5);
    }

    private void calcFreeCapacity() {
        if (this.totalCapacityNeeded < (this.numberOfShifts * WorkloadPlanning.LIMITPERSHIFT)) {
            this.freeCapacity = (this.numberOfShifts * WorkloadPlanning.LIMITPERSHIFT)
                    - this.totalCapacityNeeded;
        } else {
            this.freeCapacity = 0;
        }
    }

    private void calcWorkloadPercentage() {
        double perct = this.totalCapacityNeeded / (this.numberOfShifts * WorkloadPlanning.LIMITPERSHIFT);
        DecimalFormat df = new DecimalFormat("#.##");
        this.workloadPercentage = Double.valueOf(df.format(perct));
    }
}
