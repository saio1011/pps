/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.util;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Martin
 */
public class SharedInstance {

    private SharedInstance() {
    }
    private JSONParser parser = new JSONParser();
    private Map<String, JSONObject> articleValues;

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
            FileReader reader = new FileReader("ArticleValues.json");
            
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

    public Map<String, JSONObject> getArticleValues() {
        return articleValues;
    }
    
    public JSONObject getArticleValueForId(int id) {
        if(articleValues == null) {
            return null;
        } else {
            return articleValues.get(String.valueOf(id));
        }
    }
}
