package com.ddoj.web.controller.format.admin;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotNull;

/**
 * @author zhengtt
 **/
public class ProblemAuditingFormat {
    @NotNull
    @JSONField(name = "is_accepted")
    private Boolean isAccepted;

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }
}
