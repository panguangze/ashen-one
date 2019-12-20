/**
 * @author panguangze
 * @date 2019/11/1
 */
public enum TypeEnum {
    AA((byte) 10, "ddd");

    private byte typeCode;
    private String typeValue;

    public byte getTypeCode() {
        return typeCode;
    }

    TypeEnum(byte typeCode, String typeValue) {
        this.typeCode = typeCode;
        this.typeValue = typeValue;
    }
}
