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
public enum BuyerRoleType {
    NORMAL( (byte)0, "个人买家");

    private byte typeCode;
    private String typeValue;
    public static BuyerRoleType getByTypeCode(byte typeCode) {
        return Arrays.stream(BuyerRoleType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
