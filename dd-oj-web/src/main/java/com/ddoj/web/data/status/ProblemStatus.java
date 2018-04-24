package com.ddoj.web.data.status;

/**
 * @author zhengtt
 **/
public enum ProblemStatus {

    EDITING(0), AUDITING(1), SHARING(2);

    private int number;

    private ProblemStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
