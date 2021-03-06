package com.ddoj.web.controller.format.user;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import com.ddoj.judge.LanguageEnum;

import javax.validation.constraints.NotNull;

/**
 * @author zhengtt
 **/
public class UserSubmitCodeFormat {

    @NotNull
    @Range(min = 1)
    @JSONField(name = "problem_id")
    private Integer problemId;

    @Range(min = 0)
    @NotNull
    @JSONField(name = "contest_id")
    private Integer contestId;

    @Range(min = 0)
    @NotNull
    @JSONField(name = "group_id")
    private Integer groupId;

    @NotNull
    @JSONField(name = "lang")
    private LanguageEnum lang;

    @NotNull
    @NotBlank
    @JSONField(name = "source_code")
    private String SourceCode;

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public LanguageEnum getLang() {
        return lang;
    }

    public void setLang(LanguageEnum lang) {
        this.lang = lang;
    }

    public String getSourceCode() {
        return SourceCode;
    }

    public void setSourceCode(String sourceCode) {
        SourceCode = sourceCode;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
