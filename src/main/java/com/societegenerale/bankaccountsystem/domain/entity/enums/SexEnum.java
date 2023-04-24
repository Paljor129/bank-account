package com.societegenerale.bankaccountsystem.domain.entity.enums;

public enum SexEnum {
    MAN(0),
    WOMAN(1),
    OTHER(2);

    private final Byte value;

    /**
     * Constructor of the object.
     *
     * @param pValue a value
     */
    private SexEnum(int pValue) {
        this.value = (byte) pValue;
    }

    /**
     * Gets the value for this enum
     *
     * @return the value for this enum
     */
    public final Byte getValue() {
        return this.value;
    }

    /**
     * Gets the primitive value for this enum
     *
     * @return the primitive value for this enum
     */
    public final byte getPrimitiveValue() {
        return this.value.byteValue();
    }

    /**
     * Transform a value into an enum
     *
     * @param pValue a value
     * @return the enum. Default is OTHER
     */
    public static final SexEnum fromValue(Number pValue) {
        if (pValue != null) {
            if (pValue.byteValue() == MAN.getPrimitiveValue()) {
                return MAN;
            }
            if (pValue.byteValue() == WOMAN.getPrimitiveValue()) {
                return WOMAN;
            }
        }
        return OTHER;
    }

    /**
     * Checks if value is in supported enum values
     *
     * @param pValue a value
     * @return true this value is in supported enum value
     */
    public static final boolean inRange(Number pValue) {
        if (pValue == null) {
            return false;
        }
        SexEnum[] all = SexEnum.values();
        for (SexEnum elm : all) {
            if (elm.getPrimitiveValue() == pValue.byteValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isMan(Number aValue) {
        return aValue != null && aValue.byteValue() == SexEnum.MAN.getPrimitiveValue();
    }

    public static final boolean isWoman(Number aValue) {
        return aValue != null && aValue.byteValue() == SexEnum.WOMAN.getPrimitiveValue();
    }

    public static final boolean isOther(Number aValue) {
        return aValue != null && aValue.byteValue() == SexEnum.OTHER.getPrimitiveValue();
    }

    public static final boolean isMan(SexEnum aValue) {
        return SexEnum.MAN.equals(aValue);
    }

    public static final boolean isWoman(SexEnum aValue) {
        return SexEnum.WOMAN.equals(aValue);
    }

    public static final boolean isOther(SexEnum aValue) {
        return SexEnum.OTHER.equals(aValue);
    }
}
