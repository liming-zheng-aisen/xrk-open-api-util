package com.xrkmm.openapi.data;

import com.xrkmm.openapi.data.base.BaseAccessData;

/**
 * @Desc 同步订单数据
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class SyncOrder extends BaseAccessData {
    /**
     * 订单编号【必填】
     */
    public String orderNo = "";
    /**
     * 用户手机号 【必填】
     */
    public String mobile = "";
    /**
     * 支付时间，单位秒 【必填】
     */
    public Long payTime;
    /**
     * 规格ID 【必填】
     */
    public String skuNo = "";
    /**
     * 规格名称
     */
    public String skuName = "";
    /**
     * 支付金额 【必填】
     */
    public Float payPrice;
    /**
     * 收货人
     */
    public String name = "";
    /**
     * 省
     */
    public String contactProvince = "";
    /**
     * 城市
     */
    public String contactCity = "";
    /**
     * 区县
     */
    public String contactArea = "";
    /**
     * 详细地址，格式：省市区+详细地址
     */
    public String address = "";
    /**
     * 联系电话
     */
    public String contact = "";
    /**
     * 创建时间,单位秒
     */
    public Long createdTime;
    /**
     * 备注
     */
    public String remark = "";



    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
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

    public Float getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Float payPrice) {
        this.payPrice = payPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactProvince() {
        return contactProvince;
    }

    public void setContactProvince(String contactProvince) {
        this.contactProvince = contactProvince;
    }

    public String getContactCity() {
        return contactCity;
    }

    public void setContactCity(String contactCity) {
        this.contactCity = contactCity;
    }

    public String getContactArea() {
        return contactArea;
    }

    public void setContactArea(String contactArea) {
        this.contactArea = contactArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
