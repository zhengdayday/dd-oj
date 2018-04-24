package com.ddoj.web.data.status;

/**
 * @author zhengtt
 **/
public enum RoleStatus {

    ROOT(9), ADMIN(8);

    private int number;

    private RoleStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
