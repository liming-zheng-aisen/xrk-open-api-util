package com.xrkmm.openapi.response;

import java.io.Serializable;

/**
 * @Desc 响应信息
 * @Author LiMing.Zheng
 * @Email 1308404897@qq.com
 * @Date 2020/12/15
 */
public class ApiResponse implements Serializable {
    /**
     * 错误原因，用途，方便开发人员追查数据过程发送异常的错误原因
     */
    private String errorCause;
    /**
     * 响应码，默认0为成功，其他为失败
     */
    private Integer code;
    /**
     * 友好提示-用于用户端提示，【必须得通俗易懂，20个字以内，不得出现敏感词】
     */
    private String friendlyMessage;

    public static ApiResponse ok() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(0);
        return apiResponse;
    }

    public static ApiResponse error(Integer code, String errorCause,String friendlyMessage) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setErrorCause(errorCause);
        apiResponse.setErrorCause(friendlyMessage);
        return apiResponse;
    }

    public String getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(String errorCause) {
        this.errorCause = errorCause;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFriendlyMessage() {
        return friendlyMessage;
    }

    public void setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }
}
