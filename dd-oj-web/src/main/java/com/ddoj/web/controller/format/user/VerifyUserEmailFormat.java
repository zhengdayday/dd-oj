package com.ddoj.web.controller.format.user;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author zhengtt
 **/
public class VerifyUserEmailFormat {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
