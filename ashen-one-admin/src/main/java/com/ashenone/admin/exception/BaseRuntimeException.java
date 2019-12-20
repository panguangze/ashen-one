package com.ashenone.admin.exception;

/**
 * Create by  panguangze at 2019/11/5
 * 所有自定义运行时异常的基类
 */
public abstract class BaseRuntimeException extends RuntimeException {
    /**
     * @return 异常的错误码
     */
    public abstract String errorCode();
    public BaseRuntimeException(){
    }
    public BaseRuntimeException(String message){
        super(message);
    }
}
