/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Martin
 */
public class SetupInstance {

    private SetupInstance() {
    }
    private JSONParser parser = new JSONParser();
    private Map<String, JSONObject> articleValues;
    private Map<String, JSONObject> workplaceValues;

    public static SetupInstance getInstance() {
        return SharedInstanceHolder.INSTANCE;
    }

    private static class SharedInstanceHolder {

        private static final SetupInstance INSTANCE = new SetupInstance();
    }

    public void readArticleJson() {
        articleValues = new HashMap<>();

        try {
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
        workplaceValues = new HashMap<>();

        try {
            FileReader reader = new FileReader("src/main/java/veloziped/ws1516/json/WorkplaceValues.json");

            JSONArray a = (JSONArray) parser.parse(reader);

            for (Object o : a) {
                JSONObject workplace = (JSONObject) o;

                String id = String.valueOf(workplace.get("id"));
                JSONObject values = (JSONObject) workplace.get("defaults");

                this.workplaceValues.put(id, values);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, JSONObject> getArticleValues() {
        return articleValues;
    }

    public JSONObject getArticleValueForId(long id) {
        if (articleValues == null) {
            return null;
        } else {
            return articleValues.get(String.valueOf(id));
        }
    }
    
    public JSONObject getWorkplaceValuesForId(long id) {
        if (workplaceValues == null) {
            return null;
        } else {
            return workplaceValues.get(String.valueOf(id));
        }
    }

    public Map<String, JSONObject> getWorkplaceValues() {
        return workplaceValues;
    }
}
