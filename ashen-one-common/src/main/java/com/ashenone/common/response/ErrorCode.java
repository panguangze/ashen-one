package com.ashenone.common.response;

/**
 * 封装API的错误码
 * Created by panguangze on 2019/11/19.
 */
public interface ErrorCode {
    long getCode();

    String getMessage();
}
