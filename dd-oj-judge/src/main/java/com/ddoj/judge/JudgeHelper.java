package com.ddoj.judge;

import com.alibaba.fastjson.JSONArray;

/**
 * @author zhengtt
 **/
public class JudgeHelper {
    public static JSONArray getAllLanguages() {
        JSONArray array = new JSONArray();
        for (LanguageEnum lang: LanguageEnum.values()) {
            array.add(lang);
        }
        return array;
    }
}
