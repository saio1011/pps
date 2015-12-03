/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workload;

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

        for (Map.Entry<String, ExtendedWorkplace> entry : workplaces.entrySet()) {
            ExtendedWorkplace place = entry.getValue();

            if (place != null) {

                List<ProcessTime> pT = place.getProcessTimes();

                if (pT.size() > 0) {
                    WorkloadResult results = new WorkloadResult(place);
                    results.reCalculateResults();
                    workloadResults.put(entry.getKey(), results);
                }

            }
        }

        return workloadResults;
    }

    public Map<String, WorkloadResult> getWorkloadResults() {
        return workloadResults;
    }
}
