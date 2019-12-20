package com.ashenone.admin.exception;

/**
 * Create by panguangze on 2019/11/5
 */
public class UsernameNotValidException extends BaseRuntimeException {

    @Override
    public String errorCode() {
        return "11002";
    }
    public UsernameNotValidException() {
        super("用户名已存在");
    }
}
