package com.recvalue.api;

/**
 * CValue 门面层使用的稳定属性索引映射。
 * Stable attribute index mapping used by the CValue facade.
 */
public enum CValueAttribute {
    STRENGTH(0),
    DEXTERITY(1),
    CONSTITUTION(2),
    WILLPOWER(3),
    MIND(4),
    SPIRIT(5);

    private final int index;

    CValueAttribute(int index) {
        this.index = index;
    }

    /**
     * 返回底层数组使用的零基属性槽位。
     * Returns the zero-based attribute slot used by the underlying arrays.
     */
    public int index() {
        return index;
    }
}
