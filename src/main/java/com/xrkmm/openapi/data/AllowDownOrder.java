package com.xrkmm.openapi.data;

import com.xrkmm.openapi.data.base.BaseAccessData;

/**
 * @Desc 支付拦截校验信息
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class AllowDownOrder extends BaseAccessData {

    /**用户的手机区号*/
    private String mobileArea;
    /**用户的手机号码*/
    private String mobile;
    /**规格编号*/
    private String skuNo;
    /**规格名称*/
    private String skuName;

    public String getMobileArea() {
        return mobileArea;
    }

    public void setMobileArea(String mobileArea) {
        this.mobileArea = mobileArea;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
}
