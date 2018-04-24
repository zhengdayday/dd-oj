package com.ddoj.web.util;

import com.ddoj.web.controller.exception.WebErrorException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageRowBounds;
import com.ddoj.web.controller.exception.WebErrorException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengtt
 **/
public class WebUtil {
    public static Map<String, Object> generatePageData(PageRowBounds pager, Object data) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("total", pager.getTotal());
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> generatePageData(Page pager, Object data) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("total", pager.getTotal());
        map.put("data", data);
        return map;
    }

    public static void assertNotNull(Object obj, String errorMessage) {
        if (obj == null) {
            throw new WebErrorException(errorMessage);
        }
    }

    public static void assertNull(Object obj, String errorMessage) {
        if (obj != null) {
            throw new WebErrorException(errorMessage);
        }
    }

    public static void assertIsSuccess(boolean flag, String errorMessage) {
        if (! flag) {
            throw new WebErrorException(errorMessage);
        }
    }
}
