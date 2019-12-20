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
public enum ProductStatusType {
    ONLINE((byte)0, "已上线"),
    OFFLINE((byte)1, "已下线"),
    DELETED( (byte)2, "已删除");

    private byte typeCode;
    private String typeValue;
    public static ProductStatusType getByTypeCode(byte typeCode) {
        return Arrays.stream(ProductStatusType.values()).filter(o -> o.getTypeCode() == typeCode).findFirst().orElse(null);
    }
}
