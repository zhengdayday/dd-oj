package com.ddoj.web.postman.task;

/**
 * @author zhengtt
 **/
public class CloseNormalContestTask implements BaseTask {
    private int cid;

    public CloseNormalContestTask(int cid) {
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
