/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workplace;

import veloziped.ws1516.generated.Workplace;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import veloziped.ws1516.main.SetupInstance;

/**
 *
 * @author Martin
 */
public class ExtendedWorkplace extends Workplace {

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
            ExtendedWorkplace b = (ExtendedWorkplace) obj;
            if (Objects.equals(super.id, b.id)) {
                result = true;
            }
        }

        return result;
    }

    public List<ProcessTime> getProcessTimes() {
        return processTimes;
    }

    public void setValues() {
        JSONObject workplace = SetupInstance.getInstance().getWorkplaceValuesForId(super.id);

        double firstShiftWage = (double) workplace.get("firstShiftWage");
        double secondShiftWage = (double) workplace.get("secondShiftWage");
        double thirdShiftWage = (double) workplace.get("thirdShiftWage");
        double overtimeWage = (double) workplace.get("overtimeWage");
        double variableMachineCosts = (double) workplace.get("variableMachineCosts");
        double fixMachineCosts = (double) workplace.get("fixMachineCosts");
        JSONArray processTimesArray = (JSONArray) workplace.get("processTimes");
        List<ProcessTime> processTimes = new ArrayList<ProcessTime>();

        for (Object pt : processTimesArray) {
            JSONObject times = (JSONObject) pt;

            long articleId = (long) times.get("articleId");
            long runTime = (long) times.get("runTime");
            long setupTime = (long) times.get("setupTime");

            ProcessTime processTime = new ProcessTime(articleId, runTime, setupTime);
            processTimes.add(processTime);
        }
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
}