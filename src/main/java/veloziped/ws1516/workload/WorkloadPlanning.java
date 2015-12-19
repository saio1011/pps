/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workload;

import com.rits.cloning.Cloner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import veloziped.ws1516.workplace.ExtendedWorkplace;
import veloziped.ws1516.workplace.ProcessTime;

/**
 *
 * @author Martin
 */
public class WorkloadPlanning {

    public static final long LIMITPERSHIFT = 2400;
    public static final long LIMITOVERTIME = 1200;
    private Map<String, WorkloadResult> workloadResults;

    private WorkloadPlanning() {
    }

    public static WorkloadPlanning getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }

    private static class SharedInstanceHolder {

        private static final WorkloadPlanning INSTANCE = new WorkloadPlanning();
    }

    public Map<String, WorkloadResult> calculateWorkload(Map<String, ExtendedWorkplace> workplaces) {
        workloadResults = new HashMap<>();
        Cloner cloner = new Cloner();

        for (Map.Entry<String, ExtendedWorkplace> entry : cloner.deepClone(workplaces.entrySet())) {
            ExtendedWorkplace place = entry.getValue();

            if (place != null) {

                List<ProcessTime> pT = place.getProcessTimes();

                if (pT.size() > 0) {
                    WorkloadResult results = new WorkloadResult(place);
                    results.reCalculateResults(null);
                    workloadResults.put(entry.getKey(), results);
                }

            }
        }

        return workloadResults;
    }
    
    public void reCalculateResultWithSetupCycles(WorkloadResult wResult, long newSetupCycles) {
        Cloner cloner = new Cloner();
        WorkloadResult wRes = cloner.deepClone(wResult);
        wRes.setLastSetupCycles(newSetupCycles);
        wRes.reCalculateResults(null);
        
        this.setSingleResult(wRes);
    }
    
    public void reCalculateResultWithOvertime(WorkloadResult wResult, long overtime) {
        Cloner cloner = new Cloner();
        WorkloadResult wRes = cloner.deepClone(wResult);
        wRes.reCalculateResults(overtime);
        this.setSingleResult(wRes);
    }
    
    public void setSingleResult(WorkloadResult result) {
        this.workloadResults.put(String.valueOf(result.getWorkplace().getId()), result);
    }

    public Map<String, WorkloadResult> getWorkloadResults() {
        return workloadResults;
    }
}
