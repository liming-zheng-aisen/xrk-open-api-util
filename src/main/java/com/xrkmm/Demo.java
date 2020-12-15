package com.xrkmm;

import com.xrkmm.openapi.OpenApiSdk;
import com.xrkmm.openapi.data.AllowDownOrder;
import com.xrkmm.openapi.data.SyncOrder;
import com.xrkmm.openapi.response.ApiResponse;
import com.xrkmm.util.JsonUtil;
import com.xrkmm.util.SignUtil;

import java.awt.*;
import java.util.Date;
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
        //模拟下单拦截接口
        ApiResponse apiResponse =  isAllowDownOrder(initAllowDownOrder());
        System.out.println(JsonUtil.toJsonString(apiResponse));

        //模拟同步订单接口
        ApiResponse apiResponse2 =  syncOrder(initSyncOrder());
        System.out.println(JsonUtil.toJsonString(apiResponse2));

    }

    /**
     * 模拟【下单拦截接口】
     * @param allowDownOrder
     * @return
     */
    public static ApiResponse isAllowDownOrder(AllowDownOrder allowDownOrder){
        try {
            if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(allowDownOrder),appKey)){
                //TODO 写自己的业务，判断是否允许下单
                //...............
                return ApiResponse.ok();
            }else {
                return ApiResponse.error(30001,"鉴权失败，超时或密钥过时","请稍等重试～");
            }
        }catch (Exception e){
            return ApiResponse.error(40004,e.getMessage(),"哦豁，服务器开小差了～");
        }
    }

    /**
     * 模拟【订单同步】
     * @param syncOrder
     * @return
     */
    public static ApiResponse syncOrder(SyncOrder syncOrder){
        try {
            if (OpenApiSdk.isAccess(JsonUtil.parseObjectToMap(syncOrder),appKey)){
                //TODO 写自己的业务,同步订单
                //...............
                return ApiResponse.ok();
            }else {
                return ApiResponse.error(30001,"鉴权失败，超时或密钥过时",null);
            }
        }catch (Exception e){
            return ApiResponse.error(40004,e.getMessage(),null);
        }
    }

    /**
     * 模拟正常订单请求数据
     * @return
     */
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

    /**
     * 模拟超时订单请求数据
     * @return
     */
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

    /**
     * 模拟恶意请求数据，恶意请求包括：参数不规范、密钥不一致
     * @return
     */
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

    /**
     * 模拟同步订单数据
     * @return
     */
    public static SyncOrder initSyncOrder(){
        SyncOrder syncOrder = new SyncOrder();
        syncOrder.setOrderNo("10000001142521");
        syncOrder.setMobile("15219264467");
        syncOrder.setPayPrice(9.9F);
        syncOrder.setPayTime((System.currentTimeMillis() /1000));
        syncOrder.setSkuNo("RXG100001");
        syncOrder.setSkuName("数学S1");
        syncOrder.setCreatedTime((System.currentTimeMillis() /1000));
        syncOrder.setTime((System.currentTimeMillis() /1000));
        String sign = SignUtil.MD5Sign(JsonUtil.parseObjectToMap(syncOrder),appKey);
        syncOrder.setSign(sign);
        return syncOrder;
    }
}
