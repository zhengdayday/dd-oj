package com.ddoj.judge.judger;

import com.ddoj.judge.entity.RequestEntity;
import com.ddoj.judge.entity.ResponseEntity;

/**
 * @author zhengtt
 **/
public interface JudgerApi {
    ResponseEntity judge(String url, RequestEntity requestEntity) throws Exception;
}
