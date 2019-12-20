package com.ashenone.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseResult {
    //响应状态
    private int status;
    //错误码
    private String errorCode;
    //错误信息
    private String errorMsg;
    //响应实体内容
    private Object data;

    private ResponseResult() {
    }

    private ResponseResult status(int statusCode) {
        this.status = statusCode;
        return this;
    }

    private ResponseResult errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    private ResponseResult errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    private ResponseResult data(Object obj) {
        this.data = obj;
        return this;
    }

    private static ResponseResult create() {
        return new ResponseResult();
    }

    /**
     * 成功的响应,关注结果
     * @param obj 响应结果
     * @return 响应
     */
    public static ResponseResult ok(Object obj) {
        return ResponseResult.create().data(obj);
    }

    /**
     * 成功的响应,不关注结果
     * @return 响应
     */
    public static ResponseResult success() {
        return ResponseResult.ok("success");
    }

    /**
     * 成功的响应,关注操作成功条目数
     * @param successNum 操作成功的条目数
     * @return 响应
     */
    public static ResponseResult success(int successNum) {
        Map<String, Integer> updateSuccessResponse = new HashMap<String, Integer>();
        updateSuccessResponse.put("count", successNum);
        return ResponseResult.ok(updateSuccessResponse);
    }

    /**
     * 失败的响应
     * @param status 状态码
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @return 响应
     */
    public static ResponseResult error(int status, String errorCode, String errorMsg) {
        return ResponseResult.create().status(status).errorCode(errorCode).errorMsg(errorMsg);
    }

    /**
     * 失败的响应
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @return 响应
     */
    public static ResponseResult error(String errorCode, String errorMsg) {
        return ResponseResult.create().errorCode(errorCode).errorMsg(errorMsg);
    }
}
