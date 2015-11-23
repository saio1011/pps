/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import veloziped.ws1516.workplace.ProcessTime;
import veloziped.ws1516.workplace.WorkplaceValues;

/**
 *
 * @author Martin
 */
public class SharedInstance {

    private SharedInstance() {
    }
    private JSONParser parser = new JSONParser();
    private Map<String, JSONObject> articleValues;
    private List<WorkplaceValues> workplaceValues;

    public static SharedInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }

    private static class SharedInstanceHolder {

        private static final SharedInstance INSTANCE = new SharedInstance();
    }

    public void readArticleJson() {
        articleValues = new HashMap<>();

        try {
            //this ist in util package
            //file ist in json package
            //TODO: get json file
            FileReader reader = new FileReader("src/main/java/veloziped/ws1516/json/ArticleValues.json");

            JSONArray a = (JSONArray) parser.parse(reader);

            for (Object o : a) {
                JSONObject articleValues = (JSONObject) o;

                String id = String.valueOf(articleValues.get("id"));
                JSONObject values = (JSONObject) articleValues.get("defaults");

                this.articleValues.put(id, values);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readWorkplaceJson() {
        workplaceValues = new ArrayList<WorkplaceValues>();

        try {
            FileReader reader = new FileReader("src/main/java/veloziped/ws1516/json/WorkplaceValues.json");

            JSONArray a = (JSONArray) parser.parse(reader);

            for (Object o : a) {
                JSONObject workplace = (JSONObject) o;

                long id = (long) workplace.get("id");
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
                
                WorkplaceValues workV = new WorkplaceValues(id, firstShiftWage, secondShiftWage, thirdShiftWage, 
                        overtimeWage, variableMachineCosts, fixMachineCosts, processTimes);
                
                this.workplaceValues.add(workV);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, JSONObject> getArticleValues() {
        return articleValues;
    }

    public JSONObject getArticleValueForId(int id) {
        if (articleValues == null) {
            return null;
        } else {
            return articleValues.get(String.valueOf(id));
        }
    }

    public List<WorkplaceValues> getWorkplaceValues() {
        return workplaceValues;
    }
}
