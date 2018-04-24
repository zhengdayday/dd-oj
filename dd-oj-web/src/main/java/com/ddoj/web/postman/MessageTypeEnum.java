package com.ddoj.web.postman;

/**
 * @author zhengtt
 **/
public enum MessageTypeEnum {
    NORMAL(0), GLOBAL_CONTEST(1);

    private int number;

    private MessageTypeEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
