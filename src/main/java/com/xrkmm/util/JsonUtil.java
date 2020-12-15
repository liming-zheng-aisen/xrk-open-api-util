package com.xrkmm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

/**
 * @Desc Json工具
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class JsonUtil {

    /**
     * JSON --》Map集合
     * @param json
     * @return Map集合
     */
    public static Map<String, Object> parseJsonToMap(String json) {
        return (Map<String, Object>) JSON.parse(json);
    }

    /**
     * JSON --》对象
     * @param json Json字符串
     * @param clazz 转换类型
     * @param <T> 指定泛型的类型
     * @return 指定的对象
     */
    public static <T> T parseBean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 对象 --》JSON
     * @param object 任意对象
     * @return JSON
     */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 对象 --》Map集合
     * @param obj 任意对象
     * @return Map集合
     */
    public static Map<String, Object> parseObjectToMap(Object obj) {
        return parseJsonToMap(toJsonString(obj));
    }

}
