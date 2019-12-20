package com.ashenone.admin.exception;

/**
 * Create by panguangze on 2019/11/5
 */
public class CaptchaErrorException extends BaseRuntimeException{
    @Override
    public String errorCode() {
        return "11004";
    }

    public CaptchaErrorException(){
        super("验证码错误");
    }
}
