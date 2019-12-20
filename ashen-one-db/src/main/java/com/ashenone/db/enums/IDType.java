package com.ashenone.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum IDType {
    ID_CARD( (byte)0, "身份证");

    private byte typeCode;
    private String typeValue;

    public static IDType getByTypeCode(byte typeCode) {
        return Arrays.stream(IDType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
