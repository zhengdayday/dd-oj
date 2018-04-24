package com.ddoj.web.judger.task;

import com.ddoj.web.entity.ContestEntity;
import com.ddoj.web.entity.ContestProblemEntity;
import com.ddoj.web.entity.ContestUserEntity;

/**
 * @author zhengtt
 **/
public class ContestJudgeTask extends ProblemJudgeTask {

    private int cid;

    private ContestEntity contestEntity;

    private ContestUserEntity contestUserEntity;

    private ContestProblemEntity contestProblemEntity;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public ContestEntity getContestEntity() {
        return contestEntity;
    }

    public void setContestEntity(ContestEntity contestEntity) {
        this.contestEntity = contestEntity;
    }

    public ContestUserEntity getContestUserEntity() {
        return contestUserEntity;
    }

    public void setContestUserEntity(ContestUserEntity contestUserEntity) {
        this.contestUserEntity = contestUserEntity;
    }

    public ContestProblemEntity getContestProblemEntity() {
        return contestProblemEntity;
    }

    public void setContestProblemEntity(ContestProblemEntity contestProblemEntity) {
        this.contestProblemEntity = contestProblemEntity;
    }
}
