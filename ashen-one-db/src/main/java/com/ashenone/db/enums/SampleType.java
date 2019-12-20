package com.ashenone.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SampleType {
    BLOOD((byte)0, "血液", "毫升");

    private byte typeCode;
    private String typeValue;
    private String unit;
    public static SampleType getByTypeCode(byte typeCode) {
        return Arrays.stream(SampleType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
