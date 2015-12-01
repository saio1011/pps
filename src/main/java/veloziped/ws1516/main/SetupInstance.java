/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.main;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Article;
import veloziped.ws1516.generated.Completedorders;
import veloziped.ws1516.generated.Cycletimes;
import veloziped.ws1516.generated.Futureinwardstockmovement;
import veloziped.ws1516.generated.Idletimecosts;
import veloziped.ws1516.generated.Inwardstockmovement;
import veloziped.ws1516.generated.Ordersinwork;
import veloziped.ws1516.generated.Result;
import veloziped.ws1516.generated.Results;
import veloziped.ws1516.generated.Waitingliststock;
import veloziped.ws1516.generated.Waitinglistworkstations;
import veloziped.ws1516.generated.Warehousestock;
import veloziped.ws1516.generated.Workplace;
import veloziped.ws1516.workplace.ExtendedWorkplace;

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

    public Map<String, ExtendedArticle> generateExtendedArticles(List<Article> articles) {
        Map<String, ExtendedArticle> extArticles = new HashMap<>();

        for (Article article : articles) {
            JSONObject values = this.getArticleValueForId(article.getId());

            if (values != null) {
                ExtendedArticle extArt = new ExtendedArticle(article);
                extArt.setValues(values);

                extArticles.put(String.valueOf(extArt.getId()), extArt);
            }
        }

        return extArticles;
    }

    public Map<String, ExtendedWorkplace> generateExtendedWorkplaces(List<Workplace> workplaces) {
        Map<String, ExtendedWorkplace> extWorkplaces = new HashMap<>();

        for (Workplace workplace : workplaces) {
            JSONObject values = this.getWorkplaceValuesForId(workplace.getId());

            if (values != null) {
                ExtendedWorkplace extWork = (ExtendedWorkplace) workplace;
                extWork.setValues(values);

                extWorkplaces.put(String.valueOf(extWork.getId()), extWork);
            }
        }

        return extWorkplaces;
    }
}
