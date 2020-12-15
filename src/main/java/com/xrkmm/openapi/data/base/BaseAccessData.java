package com.xrkmm.openapi.data.base;

/**
 * @Desc 基础数据
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class BaseAccessData {
    /**时间戳，单位秒,允许客户端请求时间误差为10分钟*/
    protected Long time;
    /**签名*/
    protected String sign;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
