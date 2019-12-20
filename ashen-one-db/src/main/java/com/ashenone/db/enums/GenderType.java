package com.ashenone.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum GenderType {
    MALE( (byte)0, "男"),
    FEMALE( (byte)1, "女");

    private byte typeCode;
    private String typeValue;
    public static GenderType getByTypeCode(byte typeCode) {
        return Arrays.stream(GenderType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
