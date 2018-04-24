package com.ddoj.judge.judger;

import com.ddoj.judge.entity.ResponseEntity;

/**
 * @author zhengtt
 **/
abstract class AbstractJudger {
    JudgerApi judgerApi;

    AbstractJudger(JudgerApi judgerApi) {
        this.judgerApi = judgerApi;
    }

    abstract ResponseEntity judge();
}
