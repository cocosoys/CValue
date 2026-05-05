package com.recvalue.api;

/**
 * CValue 门面层公开的稳定玩家设置位标识。
 * Stable player-setting identifiers exposed by the CValue facade.
 */
public enum CValuePlayerSetting {
    KAIOKEN(0),
    TRANSFORM_TYPE(1),
    DODGE_SWOOP(2),
    FUSION(4),
    MYSTIC(6),
    KI_FIST(9),
    KI_PROTECTION(10),
    ULTRA_INSTINCT(11),
    FRIENDLY_FIST(12),
    KI_WEAPON(13),
    INSTANT_TRANSMISSION_SHORT_MODE(14),
    INSTANT_TRANSMISSION_SURROUND_MODE(15),
    GOD_OF_DESTRUCTION(16);

    private final int index;

    CValuePlayerSetting(int index) {
        this.index = index;
    }

    /**
     * 返回底层 JRMCore 使用的设置位索引。
     * Returns the underlying JRMCore player-setting slot index.
     */
    public int index() {
        return index;
    }
}
