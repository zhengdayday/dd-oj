package com.ddoj.judge.judger.judge0;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddoj.judge.entity.RequestEntity;
import com.ddoj.judge.entity.ResponseEntity;
import okhttp3.*;
import com.ddoj.judge.LanguageEnum;
import com.ddoj.judge.ResultEnum;
import com.ddoj.judge.entity.TestCaseRequestEntity;
import com.ddoj.judge.entity.TestCaseResponseEntity;
import com.ddoj.judge.judger.JudgerApi;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengtt
 **/
public class Judge0 implements JudgerApi {

    private final OkHttpClient CLIENT = new OkHttpClient();

    private String REQUEST_URL = null;

    private RequestEntity REQUEST_ENTITY;

    @Override
    public ResponseEntity judge(String url, RequestEntity requestEntity) throws Exception {
        this.REQUEST_URL = url+"/submissions?wait=true&fields=time,memory,stderr,compile_output,status";
        this.REQUEST_ENTITY = requestEntity;
        List<ResponseEntity> tempResponses = new ArrayList<>(requestEntity.getTestCases().size());
        for (int i=0; i<requestEntity.getTestCases().size(); i++) {
            ResponseEntity responseEntity = judgeEach(i);
            tempResponses.add(responseEntity);
        }
        return getResponseEntity(tempResponses);
    }

    private ResponseEntity getResponseEntity(List<ResponseEntity> tempResponses) {
        int length = tempResponses.size();
        int countLength = 0;
        double totalTime = 0;
        int totalMemory = 0;
        ResultEnum result = ResultEnum.AC;
        List<TestCaseResponseEntity> testCases = new ArrayList<>(length);
        for (ResponseEntity responseEntity: tempResponses) {
            if (result == ResultEnum.AC) {
                if (responseEntity.getResult() != ResultEnum.AC) {
                    result = responseEntity.getResult();
                }
            }
            TestCaseResponseEntity testCase = responseEntity.getTestCases().get(0);
            testCases.add(testCase);
            if (responseEntity.getMemory()!=0 && responseEntity.getTime()!=0) {
                totalMemory = totalMemory + responseEntity.getMemory();
                totalTime = totalTime + responseEntity.getTime();
                countLength++;
            }
        }

        if (countLength == 0) {
            return new ResponseEntity(0, 0, result, testCases);
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            double time = Double.valueOf(df.format(totalTime / countLength));
            int memory = (int) Math.ceil(totalMemory/(double)countLength);
            return new ResponseEntity(time, memory, result, testCases);
        }
    }

    private ResponseEntity judgeEach(int index) throws Exception {
        TestCaseRequestEntity testCase = REQUEST_ENTITY.getTestCases().get(index);
        RequestBody formBody = new FormBody.Builder()
                .add("source_code", REQUEST_ENTITY.getSourceCode())
                .add("language_id", String.valueOf(getLanguageId(REQUEST_ENTITY.getLang())))
                .add("stdin", String.valueOf(testCase.getStdin()))
                .add("expected_output", String.valueOf(testCase.getStdout()))
                .add("cpu_time_limit", String.valueOf(REQUEST_ENTITY.getTimeLimit()))
                .add("memory_limit", String.valueOf(REQUEST_ENTITY.getMemoryLimit() * 1000))
                .build();
        Request request = new Request.Builder()
                .url(REQUEST_URL)
                .post(formBody)
                .build();
        String json = null;
        try (Response response = CLIENT.newCall(request).execute()) {
            if (! response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            json = response.body().string();
        }
        return parse(json);
    }

    private ResponseEntity parse(String json) throws Exception {
        // System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject status = jsonObject.getJSONObject("status");
        ResultEnum result = getResult(status.getInteger("id"));
        double time = 0;
        Double tempTime = jsonObject.getDouble("time");
        if (tempTime != null) {
            DecimalFormat df = new DecimalFormat("#.##");
            time = Double.valueOf(df.format(tempTime));
        }

        int memory = 0;
        Double tempMemory = jsonObject.getDouble("memory");
        if (tempMemory != null) {
            memory = (int) Math.ceil(tempMemory/1000);
        }

        if (result == ResultEnum.CE) {
            // ce
            String errorMessage = jsonObject.getString("compile_output");
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.CE, errorMessage));
            return new ResponseEntity(0, 0, ResultEnum.CE, testCases);
        } else if (result == ResultEnum.RTE){
            // rte
            String errorMessage = jsonObject.getString("stderr");
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.RTE, errorMessage));
            return new ResponseEntity(time, memory, ResultEnum.RTE, testCases);
        } else if (result == ResultEnum.WA) {
            // wa
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.WA, ResultEnum.WA.getName()));
            return new ResponseEntity(time, memory, ResultEnum.WA, testCases);
        } else if (result == ResultEnum.TLE) {
            // tle
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.TLE, ResultEnum.TLE.getName()));
            return new ResponseEntity(REQUEST_ENTITY.getTimeLimit(), memory, ResultEnum.TLE, testCases);
        } else if (result == ResultEnum.AC) {
            // ac
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.AC, "null"));
            return new ResponseEntity(time, memory, ResultEnum.AC, testCases);
        } else {
            // se
            List<TestCaseResponseEntity> testCases = new ArrayList<>(1);
            testCases.add(new TestCaseResponseEntity(ResultEnum.SE, ResultEnum.SE.getName()));
            return new ResponseEntity(0, 0, ResultEnum.SE, testCases);
        }
    }

    private int getLanguageId(LanguageEnum lang) {
        switch (lang) {
            case JAVA8:
                return 27;
            case PYTHON35:
                return 35;
            case PYTHON27:
                return 36;
            case C:
                return 9;
            case CPP:
                return 15;
            default:
                return 34;
        }
    }

    private ResultEnum getResult(int status) {
        if (status == 3) {
            return ResultEnum.AC;
        } else if (status == 4) {
            return ResultEnum.WA;
        } else if (status == 5) {
            return ResultEnum.TLE;
        } else if (status == 6) {
            return ResultEnum.CE;
        } else if (status >=7 && status<=12) {
            return ResultEnum.RTE;
        } else {
            return ResultEnum.SE;
        }
    }
}
