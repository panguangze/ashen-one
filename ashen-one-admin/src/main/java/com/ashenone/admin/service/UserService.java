package com.ashenone.admin.service;

import com.ashenone.db.dto.UserDto;
import com.ashenone.db.entity.UserEntity;

/**
 * @author panguangze
 * @date 2019/10/31
 */
public interface UserService {
    UserEntity getUserByName(String username);
    String register(UserDto userDto);
    /**
     * 登录接口，返回一个token
     */
    String login(String username, String password);

    /**
     * 注册成功以后直接生成token并且登录
     * @return
     */
    void checkUsername(String username);

    /**
     * 发送验证码
     */
    void getCaptcha(String receiver);
}
