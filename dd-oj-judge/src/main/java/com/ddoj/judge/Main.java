package com.ddoj.judge;

import com.ddoj.judge.entity.RequestEntity;
import com.ddoj.judge.entity.ResponseEntity;
import com.ddoj.judge.judger.Judger;
import com.ddoj.judge.judger.dayday.Dayday;
import com.ddoj.judge.judger.judge0.Judge0;
import com.ddoj.judge.entity.TestCaseRequestEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengtt
 **/
public class Main {
    public static void main(String[] args) {
        List<TestCaseRequestEntity> list = new ArrayList<>(2);
        TestCaseRequestEntity testCaseRequestEntity1 = new TestCaseRequestEntity(null, "hll\n");
        TestCaseRequestEntity testCaseRequestEntity2 = new TestCaseRequestEntity(null, "hello");
        list.add(testCaseRequestEntity1);
        list.add(testCaseRequestEntity2);
        /*RequestEntity requestEntity = new RequestEntity(LanguageEnum.PYTHON35, "print(\"hello\")", 3,public class Main {public static void main(String[] args) {System.out.println(\"hll\");}}
                128, list);*/
        RequestEntity requestEntity = new RequestEntity(LanguageEnum.JAVA8, "public class Main {public static void main(String[] args) {System.out.println(\"hll\");}}", 3,
                128, list);
        Judger judger = dayday(requestEntity);
        ResponseEntity responseEntity = judger.judge();
    }

    private static Judger judge0(RequestEntity requestEntity) {
        return new Judger("http://www.funnytu.com:3000", requestEntity, new Judge0());
    }

    private static Judger dayday(RequestEntity requestEntity) {
        return new Judger("http://101.132.164.120:5000", requestEntity, new Dayday());
    }
}
