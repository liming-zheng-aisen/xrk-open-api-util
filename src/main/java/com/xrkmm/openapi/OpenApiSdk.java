package com.xrkmm.openapi;

import com.xrkmm.util.SignUtil;
import java.util.Map;

/**
 * @Desc 开放平台认证SDK
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class OpenApiSdk {

    /**超时时间默认十分钟*/
    private static final Integer OUT_TIME = 10 * 60;

    /***
     * 【请求信息鉴权】
     * 超过十分钟的数据不通过，签名不一致的不通过
     * @param accessData 发送的数据转成map
     * @param appKey 鉴权密钥
     * @return true - 通过 ， false -不通过
     */
    public static boolean isAccess(Map<String,Object> accessData, String appKey){
        if (null == accessData ||null == accessData.get(AccessKey.TIME) || SignUtil.isEmpty(accessData.get(AccessKey.SIGN)) || SignUtil.isEmpty(appKey)){
            return false;
        }
        //当前时间戳（秒）
        Long nowTime = System.currentTimeMillis() / 1000;
        //请求时间戳（秒）
        Long requestTime = Long.parseLong(String.valueOf(accessData.get(AccessKey.TIME)));
        //请求超时,不接受超过10分钟之后的请求
        if (nowTime - requestTime > OUT_TIME){
            return false;
        }
        String requestSign = String.valueOf(accessData.get(AccessKey.SIGN));
        String accessSign = SignUtil.MD5Sign(accessData,appKey);
        if (requestSign.equals(accessSign)){
            return true;
        }
        return false;
    }

    /**
     * 授权签名【发送数据方使用】
     * @param accessData 发送的数据转成map
     * @param appKey 鉴权密钥
     * @return
     */
    public static String accessSign(Map<String,Object> accessData, String appKey){
        if (null == accessData ||null == accessData.get(AccessKey.TIME) || SignUtil.isEmpty(appKey)){
            return null;
        }
        return SignUtil.MD5Sign(accessData,appKey);
    }

    /**【认证授权数据主要字段】*/
    public static class AccessKey{
        /**请求时间戳*/
        private static final String TIME = "time";
        /**签名*/
        private static final String SIGN = "sign";
    }
}
