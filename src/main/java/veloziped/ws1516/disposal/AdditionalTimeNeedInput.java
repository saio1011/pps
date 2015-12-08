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
import veloziped.ws1516.generated.Results.Workplace;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Rosen
 */
public class AdditionalTimeNeedInput {

    static Hashtable<String, String> WorkplacesHashTable;
    private ExtendedWorkplace workplace;
    private ExtendedArticle article;
    private ArrayList<ExtendedWorkplace> workplacesList;
    private long amount;
    private long timeNeeded;
    private ArticleDelayTyp articleDelayTyp;

    public AdditionalTimeNeedInput() {
        WorkplacesHashTable = new Hashtable<>();
        WorkplacesHashTable.put("13,13", "12,8,7,9");
        WorkplacesHashTable.put("12,13", "8,7,9");
        WorkplacesHashTable.put("8,13", "7,9");
        WorkplacesHashTable.put("7,13", "9");
        WorkplacesHashTable.put("6,18", "8,7,9");
        WorkplacesHashTable.put("8,18", "7,9");
        WorkplacesHashTable.put("7,18", "9");
        WorkplacesHashTable.put("10,7", "11");
        WorkplacesHashTable.put("6,16", "14");
        WorkplacesHashTable.put("10,4", "11");
        WorkplacesHashTable.put("7,26", "15");
        WorkplacesHashTable.put("13,10", "12,8,7,9");
        WorkplacesHashTable.put("12,10", "8,7,9");
        WorkplacesHashTable.put("8,10", "7,9");
        WorkplacesHashTable.put("7,10", "9");
        WorkplacesHashTable.put("10,8", "11");
        WorkplacesHashTable.put("6,16", "14");
        WorkplacesHashTable.put("10,5", "11");
        WorkplacesHashTable.put("7,26", "15");
        WorkplacesHashTable.put("13,11", "12,8,7,9");
        WorkplacesHashTable.put("12,11", "8,7,9");
        WorkplacesHashTable.put("8,11", "7,9");
        WorkplacesHashTable.put("7,11", "9");
        WorkplacesHashTable.put("6,19", "8,7,9");
        WorkplacesHashTable.put("8,19", "7,9");
        WorkplacesHashTable.put("7,19", "9");
        WorkplacesHashTable.put("13,15", "12,8,7,9");
        WorkplacesHashTable.put("12,15", "8,7,9");
        WorkplacesHashTable.put("8,15", "7,9");
        WorkplacesHashTable.put("7,15", "9");
        WorkplacesHashTable.put("6,20", "8,7,9");
        WorkplacesHashTable.put("8,20", "7,9");
        WorkplacesHashTable.put("7,20", "9");
        WorkplacesHashTable.put("10,9", "11");
        WorkplacesHashTable.put("10,6", "11");
        WorkplacesHashTable.put("6,16", "14");
        WorkplacesHashTable.put("7,26", "15");
        WorkplacesHashTable.put("13,12", "12,8,7,9");
        WorkplacesHashTable.put("12,12", "8,7,9");
        WorkplacesHashTable.put("8,12", "7,9");
        WorkplacesHashTable.put("7,12", "9");
        WorkplacesHashTable.put("13,14", "12,8,7,9");
        WorkplacesHashTable.put("12,14", "8,7,9");
        WorkplacesHashTable.put("8,14", "7,9");
        WorkplacesHashTable.put("7,14", "9");
    }

    /* The WPs in Line P1
        Keys in Form PX.WP.EX
        Values String dotseparated
     */
    public long[] GetChildWorkplaces(long workplaceId, long articleId) {

        String[] res = WorkplacesHashTable.get(workplaceId + "," + articleId).split(",");

        long[] numbers = new long[res.length];
        for (int i = 0; i < res.length; i++) {
            numbers[i] = Long.parseLong(res[i]);
        }
        return numbers;
    }

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
