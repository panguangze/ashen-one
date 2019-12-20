package com.ashenone.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum SampleStatusType {
    POSTED((byte)0, "已邮寄"),
    SAMPLE_RECEIVING((byte)1, "收样中"),
    SAMPLE_RECEIVED((byte)2, "已收样");

    private int typeCode;
    private String typeValue;

    public static SampleStatusType getByTypeCode(byte typeCode) {
        return Arrays.stream(SampleStatusType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
