package com.ddoj.web.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author zhengtt
 **/
public class ContestUserEntity {
    private Integer cid;

    private Integer uid;

    @JSONField(name = "total_used_time")
    private Long totalUsedTime;

    @JSONField(name = "total_score")
    private Integer totalScore;

    @JSONField(name = "total_wrong_times")
    private Integer totalWrongTimes;

    @JSONField(name = "submit_times")
    private Integer submitTimes;

    @JSONField(name = "finished_problems")
    private Integer finishedProblems;

    @JSONField(name = "ac_times")
    private Integer ACTimes;

    @JSONField(name = "wa_times")
    private Integer WATimes;

    @JSONField(name = "rte_times")
    private Integer RTETimes;

    @JSONField(name = "tle_times")
    private Integer TLETimes;

    @JSONField(name = "ce_times")
    private Integer CETimes;

    @JSONField(name = "join_time")
    private Long joinTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSubmitTimes() {
        return submitTimes;
    }

    public void setSubmitTimes(Integer submitTimes) {
        this.submitTimes = submitTimes;
    }

    public Integer getFinishedProblems() {
        return finishedProblems;
    }

    public void setFinishedProblems(Integer finishedProblems) {
        this.finishedProblems = finishedProblems;
    }

    public Integer getACTimes() {
        return ACTimes;
    }

    public void setACTimes(Integer ACTimes) {
        this.ACTimes = ACTimes;
    }

    public Integer getWATimes() {
        return WATimes;
    }

    public void setWATimes(Integer WATimes) {
        this.WATimes = WATimes;
    }

    public Integer getRTETimes() {
        return RTETimes;
    }

    public void setRTETimes(Integer RTETimes) {
        this.RTETimes = RTETimes;
    }

    public Integer getTLETimes() {
        return TLETimes;
    }

    public void setTLETimes(Integer TLETimes) {
        this.TLETimes = TLETimes;
    }

    public Integer getCETimes() {
        return CETimes;
    }

    public void setCETimes(Integer CETimes) {
        this.CETimes = CETimes;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public Long getTotalUsedTime() {
        return totalUsedTime;
    }

    public void setTotalUsedTime(Long totalUsedTime) {
        this.totalUsedTime = totalUsedTime;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getTotalWrongTimes() {
        return totalWrongTimes;
    }

    public void setTotalWrongTimes(Integer totalWrongTimes) {
        this.totalWrongTimes = totalWrongTimes;
    }
}
