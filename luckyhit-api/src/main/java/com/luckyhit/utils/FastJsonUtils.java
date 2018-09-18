package com.luckyhit.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class FastJsonUtils {
    public static <T> String pubOrPubsToJson(T t)
    {
        return JSONObject.toJSONString(t);
    }

    public static <T> T jsonToPub(String jsonString, Class<T> cls) {
        return JSONObject.parseObject(jsonString, cls);
    }

    public static <T> List<T> jsonToPubs(String jsonString, Class<T> cls) {
        return JSONObject.parseArray(jsonString, cls);
    }
}
