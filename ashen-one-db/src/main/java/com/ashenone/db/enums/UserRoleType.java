package com.ashenone.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author panguangze
 * @date 2019/10/31
 */
@Getter
@AllArgsConstructor
public enum UserRoleType {
    PLATFORM((byte) 0, "平台"),
    BUSINESSES((byte) 1, "商家");

    private byte typeCode;
    private String typeName;

    public static UserRoleType getByTypeCode(byte typeCode) {
        return Arrays.stream(UserRoleType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
