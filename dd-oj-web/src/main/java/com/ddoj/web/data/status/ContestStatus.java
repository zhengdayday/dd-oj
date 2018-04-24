package com.ddoj.web.data.status;

/**
 * @author zhengtt
 **/
public enum ContestStatus {
    EDITING(0), USING(1), CLOSED(2);

    private int number;

    private ContestStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
