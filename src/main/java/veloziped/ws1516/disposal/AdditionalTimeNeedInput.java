/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.disposal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import veloziped.ws1516.articles.ExtendedArticle;
import veloziped.ws1516.generated.Workplace;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Rosen
 */
public class AdditionalTimeNeedInput {

    Hashtable<String, String> WorkplacesHashTable = new Hashtable<>();
    private ExtendedWorkplace workplace;
    private ExtendedArticle article;
    private ArrayList<ExtendedWorkplace> workplacesList;
    private long amount;
    private long timeNeeded;
    private ArticleDelayTyp articleDelayTyp;

    public AdditionalTimeNeedInput() {    }

    /* The WPs in Line P1
        Keys in Form PX.WP.EX
        Values String dotseparated
     */
    public String GetChildWorkplaces(String produktId, String workplaceId, String articleId) {

        WorkplacesHashTable.put("1.9.13", "13.12.8.7");
        WorkplacesHashTable.put("1.7.13", "13.12.8");
        WorkplacesHashTable.put("1.8.13", "13.12");
        WorkplacesHashTable.put("1.12.13", "13");
        WorkplacesHashTable.put("1.9.18", "6.8.7");
        WorkplacesHashTable.put("1.7.18", "6.8");
        WorkplacesHashTable.put("1.8.18", "6");
        WorkplacesHashTable.put("1.14.16", "6");
        WorkplacesHashTable.put("1.11.7", "10");
        WorkplacesHashTable.put("1.11.4", "10");
        WorkplacesHashTable.put("1.15.26", "7");
        WorkplacesHashTable.put("1.9.10", "13.12.8.7");
        WorkplacesHashTable.put("1.7.10", "13.12.8");
        WorkplacesHashTable.put("1.8.10", "13.12");
        WorkplacesHashTable.put("1.12.10", "13");
        WorkplacesHashTable.put("2.9.14", "13.12.8.7");
        WorkplacesHashTable.put("2.7.14", "13.12.8");
        WorkplacesHashTable.put("2.8.14", "13.12");
        WorkplacesHashTable.put("2.12.14", "13");
        WorkplacesHashTable.put("2.14.16", "6");
        WorkplacesHashTable.put("2.9.19", "6.8.7");
        WorkplacesHashTable.put("2.7.19", "6.8");
        WorkplacesHashTable.put("2.8.19", "6");
        WorkplacesHashTable.put("2.11.8", "10");
        WorkplacesHashTable.put("2.15.26", "7");
        WorkplacesHashTable.put("2.11.5", "10");
        WorkplacesHashTable.put("2.9.11", "13.12.8.7");
        WorkplacesHashTable.put("2.7.11", "13.12.8");
        WorkplacesHashTable.put("2.8.11", "13.12");
        WorkplacesHashTable.put("2.12.11", "13");
        WorkplacesHashTable.put("3.9.15", "13.12.8.7");
        WorkplacesHashTable.put("3.7.15", "13.12.8");
        WorkplacesHashTable.put("3.8.15", "13.12");
        WorkplacesHashTable.put("3.12.15", "13");
        WorkplacesHashTable.put("3.14.16", "6");
        WorkplacesHashTable.put("3.9.20", "6.8.7");
        WorkplacesHashTable.put("3.7.20", "6.8");
        WorkplacesHashTable.put("3.8.20", "6");
        WorkplacesHashTable.put("3.11.9", "10");
        WorkplacesHashTable.put("3.14.16", "6");
        WorkplacesHashTable.put("3.11.6", "10");
        WorkplacesHashTable.put("3.15.26", "7");
        WorkplacesHashTable.put("3.9.12", "13.12.8.7");
        WorkplacesHashTable.put("3.7.12", "13.12.8");
        WorkplacesHashTable.put("3.8.12", "13.12");
        WorkplacesHashTable.put("3.12.12", "13");

        return WorkplacesHashTable.get( produktId + "." + workplaceId + "." + articleId);
    };

    
   
    public ExtendedWorkplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(ExtendedWorkplace workplace) {
        this.workplace = workplace;
    }

    public ExtendedArticle getArticle() {
        return article;
    }

    public void setArticle(ExtendedArticle article) {
        this.article = article;
    }

    public ArrayList<ExtendedWorkplace> getWorkplacesList() {
        return workplacesList;
    }

    public void setWorkplacesList(ArrayList<ExtendedWorkplace> workplacesList) {
        this.workplacesList = workplacesList;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(long timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public ArticleDelayTyp getArticleDelayTyp() {
        return articleDelayTyp;
    }

    public void setArticleDelayTyp(ArticleDelayTyp articleDelayTyp) {
        this.articleDelayTyp = articleDelayTyp;
    }

}
