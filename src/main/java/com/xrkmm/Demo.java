package com.xrkmm;

import com.xrkmm.openapi.OpenApiSdk;
import com.xrkmm.openapi.data.AllowDownOrder;
import com.xrkmm.util.JsonUtil;

import java.util.UUID;

/**
 * @Desc 第三方服务鉴权测试案例
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class Demo {

    private final static String appKey = "b1efcae8-6897-476a-a2cf-6b73aa456a92";

    public static void main( String[] args ) {
        //模拟鉴权-【成功】
        //accessSuccess();

        //模拟鉴权-【失败】-【请求超时】
        //accessFailByTimeOut();

        //模拟鉴权-【失败】-【恶意请求】
        accessFailByBadRequest();
    }

    /**
     * 模拟鉴权-【成功】
     */
    public static void accessSuccess(){
        //假如这是客户端发来的数据
        AllowDownOrder allowDownOrder = initAllowDownOrder();
        //认证数据
        if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(allowDownOrder),appKey)){
            System.out.println("鉴权-【成功】");
        }else {
            System.out.println("鉴权-【失败】");
        }
    }

    /**
     * 模拟鉴权-【失败】-【超时】
     */
    public static void accessFailByTimeOut(){
        //假如这是客户端发来的数据
        AllowDownOrder allowDownOrder = initAllowDownOrderOutTime();
        //认证数据
        if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(allowDownOrder),appKey)){
            System.out.println("鉴权-【成功】");
        }else {
            System.out.println("鉴权-【失败】");
        }
    }

    /**
     * 模拟鉴权-【失败】-【恶意请求】
     */
    public static void accessFailByBadRequest(){
        //假如这是客户端发来的数据
        AllowDownOrder allowDownOrder = initAllowDownOrderBadRequest();
        //认证数据
        if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(allowDownOrder),appKey)){
            System.out.println("鉴权-【成功】");
        }else {
            System.out.println("鉴权-【失败】");
        }
    }

    public static AllowDownOrder initAllowDownOrder(){
        AllowDownOrder allow = new AllowDownOrder();
        allow.setMobile("15219264467");
        allow.setSkuNo("RXG100001");
        allow.setSkuName("数学S1");
        allow.setTime(System.currentTimeMillis()/1000);
        String sign = OpenApiSdk.accessSign(JsonUtil.parseObjectToMap(allow),appKey);
        allow.setSign(sign);
        return allow;
    }

    public static AllowDownOrder initAllowDownOrderOutTime(){
        AllowDownOrder allow = new AllowDownOrder();
        allow.setMobile("15219264467");
        allow.setSkuNo("RXG100001");
        allow.setSkuName("数学S1");
        //时间设为11分钟之前，模拟请求超时
        allow.setTime(System.currentTimeMillis()/1000 - (11*60));
        String sign = OpenApiSdk.accessSign(JsonUtil.parseObjectToMap(allow),appKey);
        allow.setSign(sign);
        return allow;
    }

    public static AllowDownOrder initAllowDownOrderBadRequest(){
        AllowDownOrder allow = new AllowDownOrder();
        allow.setMobile("15219264467");
        allow.setSkuNo("RXG100001");
        allow.setSkuName("数学S1");
        allow.setTime(System.currentTimeMillis()/1000);
        //随机密钥
        String sign = OpenApiSdk.accessSign(JsonUtil.parseObjectToMap(allow),UUID.randomUUID().toString());
        allow.setSign(sign);
        return allow;
    }
}
