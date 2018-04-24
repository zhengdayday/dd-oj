package com.ddoj.judge.judger;

import com.ddoj.judge.entity.RequestEntity;
import com.ddoj.judge.entity.ResponseEntity;
import com.ddoj.judge.ResultEnum;
import com.ddoj.judge.entity.TestCaseResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengtt
 **/
public class Judger extends AbstractJudger {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private RequestEntity requestEntity;

    private String url;

    public Judger(String url, RequestEntity requestEntity, JudgerApi judgerApi) {
        super(judgerApi);
        this.url = url;
        this.requestEntity = requestEntity;
    }

    @Override
    public ResponseEntity judge() {
        try {
            return judgerApi.judge(url, requestEntity);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return getSEResponseEntity(requestEntity);
        }
    }

    private ResponseEntity getSEResponseEntity(RequestEntity requestEntity) {
        List<TestCaseResponseEntity> testCases = new ArrayList<>(requestEntity.getTestCases().size());
        for (int i=0; i<requestEntity.getTestCases().size(); i++) {
            TestCaseResponseEntity responseEntity = new TestCaseResponseEntity(ResultEnum.SE, ResultEnum.SE.getName());
            testCases.add(responseEntity);
        }
        return new ResponseEntity(0, 0, ResultEnum.SE, testCases);
    }
}
