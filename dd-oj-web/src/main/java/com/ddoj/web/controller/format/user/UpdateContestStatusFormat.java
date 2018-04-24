package com.ddoj.web.controller.format.user;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author zhengtt
 **/
public class UpdateContestStatusFormat {

    @NotNull
    @Range(min = 0, max = 2)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
