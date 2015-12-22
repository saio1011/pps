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
import veloziped.ws1516.generated.Results.Waitinglist;
import veloziped.ws1516.generated.Results.Workplace;
import veloziped.ws1516.main.SharedInstance;
import veloziped.ws1516.workplace.ExtendedWorkplace;

/**
 *
 * @author Rosen
 */
public class Disposal {

    private static Hashtable<String, String> WorkplacesHashTable;
    private ExtendedWorkplace extendedWorkplace;
    private long timeneed;

    public Disposal() {
        WorkplacesHashTable = new Hashtable<>();
        WorkplacesHashTable.put("13,13", "12,8,7,9");
        WorkplacesHashTable.put("1,29", "12,8,7,9");
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

    public String[] getChildWorkplaces(long workplaceId, long articleId) {
        if (WorkplacesHashTable.containsKey(workplaceId + "," + articleId)) {
            return WorkplacesHashTable.get(String.valueOf(workplaceId) + "," + String.valueOf(articleId)).split(",");
        } else {
            return new String[0];
        }
    }

    private void calculateOrdersInWork(List<Workplace> orders) {
        for (Workplace workplace : orders) {
            extendedWorkplace = SharedInstance.getInstance().getWorkplaceForId(workplace.getId());
            timeneed = workplace.getTimeneed();

            try {
                timeneed += extendedWorkplace.getTimeneed();
            } catch (Exception e) {
            }

            extendedWorkplace.setTimeneed(timeneed);
            SharedInstance.getInstance().setExtendedWorkplaceForId(extendedWorkplace.getId(), extendedWorkplace);

            ExtendedArticle extendedArticle = SharedInstance.getInstance().getArticleForId(workplace.getItem());
            extendedArticle.setAdditionalAmountInWork(workplace.getAmount() + extendedArticle.getAdditionalAmountInWork());
            SharedInstance.getInstance().setExtendedArticleForId(extendedArticle.getId(), extendedArticle);
        }
    }

    private void calculateWaitingLists(List<Workplace> workplaces) {
        // hier optimieren
        for (Workplace wp : workplaces) {
            ExtendedWorkplace eWp = SharedInstance.getInstance().getWorkplaceForId(wp.getId());
            eWp.setTimeneed(wp.getTimeneed());
            SharedInstance.getInstance().setExtendedWorkplaceForId(eWp.getId(), eWp);
        }

        for (Workplace wpl : workplaces) {
            if (wpl.getTimeneed() != 0) {
                List<Waitinglist> waitingLists = wpl.getWaitinglist();
                for (Waitinglist waitinglist : waitingLists) {
                    String[] wp = getChildWorkplaces(wpl.getId(), waitinglist.getItem());
                    if (wp.length != 0) {
                        for (String wpId : wp) {
                            ExtendedWorkplace tmpWp = SharedInstance.getInstance().getWorkplaceForId(Long.parseLong(wpId));
                            long tntmp = 0;
                            if (tmpWp.getTimeneed() != null) {
                                tntmp = tmpWp.getTimeneed();
                            }
                            tmpWp.setTimeneed(wpl.getTimeneed() + tntmp);
                            SharedInstance.getInstance().setExtendedWorkplaceForId(Long.parseLong(wpId), tmpWp);
                        }
                    }
                    ExtendedArticle extendedArticleWithAddAmount = SharedInstance.getInstance().getArticleForId(waitinglist.getItem());
                    extendedArticleWithAddAmount.setAdditionalAmount(waitinglist.getAmount() + extendedArticleWithAddAmount.getAdditionalAmount());
                    SharedInstance.getInstance().setExtendedArticleForId(extendedArticleWithAddAmount.getId(), extendedArticleWithAddAmount);
                }
            }
        }
    }

    public void calculateAdditionalAmountAndTime() {
        calculateWaitingLists(SharedInstance.getInstance().getWaitinglistWorkstations().getWorkplace());
        calculateOrdersInWork(SharedInstance.getInstance().getOrdersInWork().getWorkplace());
    }
}