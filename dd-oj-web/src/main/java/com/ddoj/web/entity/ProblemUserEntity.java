package com.ddoj.web.entity;

import com.ddoj.judge.ResultEnum;

/**
 * @author zhengtt
 **/
public class ProblemUserEntity {
    private Integer pid;

    private Integer uid;

    private ResultEnum status;

    public ProblemUserEntity(Integer pid, Integer uid, ResultEnum status) {
        this.pid = pid;
        this.uid = uid;
        this.status = status;
    }

    public ProblemUserEntity() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public ResultEnum getStatus() {
        return status;
    }

    public void setStatus(ResultEnum status) {
        this.status = status;
    }
}
