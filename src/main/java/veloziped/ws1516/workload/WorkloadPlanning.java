/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.workplace.ExtendedWorkplace;
import veloziped.ws1516.workplace.ProcessTime;

/**
 *
 * @author Martin
 */
public class WorkloadPlanning {

    private final long limitShift1;
    private final long limitShift2;
    private final long limitShift3;
    private final long limitOvertime;
    private Map<String, WorkloadResults> workloadResults;

    public WorkloadPlanning() {
        this.limitShift3 = 7200;
        this.limitShift2 = 4800;
        this.limitShift1 = 2400;
        this.limitOvertime = 1200;

        this.reloadWorkloadResults();
    }

    private void reloadWorkloadResults() {
        workloadResults = new HashMap<>();
        
        Map<String, ExtendedWorkplace> workplaces = SharedInstance.getInstance().getWorkplaces();

        for (Map.Entry<String, ExtendedWorkplace> entry : workplaces.entrySet()) {
            ExtendedWorkplace place = entry.getValue();
            
            List<ProcessTime> pT = place.getProcessTimes();
            
            WorkloadResults results = new WorkloadResults(place.getId(), pT);
            workloadResults.put(entry.getKey(), results);
        }
    }
}
