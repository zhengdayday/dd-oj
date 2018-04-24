package com.ddoj.web.judger.task;

import com.ddoj.web.entity.ProblemEntity;

/**
 * @author zhengtt
 **/
public class ProblemJudgeTask extends AbstractUserTask {

    private int pid;

    private ProblemEntity problemEntity;

    public ProblemEntity getProblemEntity() {
        return problemEntity;
    }

    public void setProblemEntity(ProblemEntity problemEntity) {
        this.problemEntity = problemEntity;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
