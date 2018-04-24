package com.ddoj.web.judger.task;

/**
 * @author zhengtt
 **/
public class AbstractUserTask extends AbstractBaseTask {
    private int owner;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
