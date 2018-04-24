package com.ddoj.web.controller.format.user;

import org.hibernate.validator.constraints.Length;

/**
 * @author zhengtt
 **/
public class EnterGroupFormat {

    @Length(max = 6)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
