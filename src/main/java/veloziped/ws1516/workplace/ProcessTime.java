/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veloziped.ws1516.workplace;

/**
 *
 * @author Martin
 */
public class ProcessTime {
    
    private long articleId;
    private long runTime;
    private long setupTime;

    public ProcessTime(long articleId, long runTime, long setupTime) {
        this.articleId = articleId;
        this.runTime = runTime;
        this.setupTime = setupTime;
    }

    public long getSetupTime() {
        return setupTime;
    }


    public long getRunTime() {
        return runTime;
    }


    public long getArticleId() {
        return articleId;
    }

}
