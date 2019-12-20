package com.ashenone.db.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author panguangze
 * @date 2019/11/4
 */
@Setter
@Getter
public class UserDto {
    private String username;
    private  String password;
    private String phoneNum;
    private String email;
    private String validateCode;
}
