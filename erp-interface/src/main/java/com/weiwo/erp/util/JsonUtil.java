package com.weiwo.erp.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karen on 2018/3/28.
 */
public class JsonUtil {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * 对象转换
     *
     * @param obj
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T convertEntity(Object obj, T a) {
        if (obj == null) {
            return null;
        }
        a = JSONObject.parseObject(JSONObject.toJSONString(obj), (Class<T>) a.getClass());
        return a;
    }


    public static <T> List<T> convertList(List objs, T a) {
        if (objs == null) {
            return null;
        }
        List<T> list = new ArrayList();
        JSONObject.toJSONString(objs);
        list = JSONObject.parseArray(JSONObject.toJSONString(objs), (Class<T>) a.getClass());
        return list;
    }

    public static <T> List<T> fromListJson(String str, Class<T> clazz) {
        return JSONArray.parseArray(str, clazz);
    }
}
