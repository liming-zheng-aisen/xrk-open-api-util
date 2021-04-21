package com.xrkmm.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Desc 第三方服务数据签名
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class SignUtil {

    private final static String DEFAULT_SIGN_NAME ="sign";

    /**
     * 【加盐】
     * 将集合M参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串str
     * 在str尾部拼接上appKey(自己平台生成，双方持有的密钥需要一致)得到sign字符串，并对sign进行MD5加密，得到sign值
     * @param map 请求参数集合
     * @param appKey 第三方授权密钥
     * @return
     */
    public static String MD5Sign(Map<String, Object> map, String appKey) {
        StringBuffer sb = new StringBuffer();
        List<String> keyList = map.keySet().stream().sorted().collect(Collectors.toList());
        keyList.forEach(k -> {
            if (!DEFAULT_SIGN_NAME.equals(k)) {
                if (!isEmpty(map.get(k))) {
                    sb.append(k).append("=").append(map.get(k)).append("&");
                }
            }
        });
        String signStr = sb.deleteCharAt(sb.length() - 1).append(appKey).toString();
        return MD5Util.getMD5(signStr);
    }

    /**
     * 【空判断】-》【字符串】
     * 网络请求的空包含了null、""、"null"、undefined
     * @param str 字符串
     * @return true-空 false-非空
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str) || "null".equals(str) || "undefined".equals(str);
    }

    /**
     * 【空判断】-》【对象】
     * @param o 对象
     * @return true-空 false-非空
     */
    public static boolean isEmpty(Object o) {
        return o == null || isEmpty(o.toString());
    }
}
