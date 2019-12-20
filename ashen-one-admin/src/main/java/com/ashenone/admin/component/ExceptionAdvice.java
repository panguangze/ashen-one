package com.ashenone.admin.component;

import com.ashenone.admin.exception.UsernameNotValidException;
import com.ashenone.common.response.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author panguangze
 * @date 2019/11/4
 * 全局的异常处理类
 */
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(UsernameNotValidException.class)
    @ResponseBody
    public ResponseResult handleException(UsernameNotValidException e) {
        return ResponseResult.error(e.errorCode(), e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseResult handleException(AuthenticationException e) {
        if(e instanceof UsernameNotFoundException) {
            return ResponseResult.error("11001", e.getMessage());
        } else {
            return ResponseResult.error("11002", e.getMessage());
        }
    }
}
