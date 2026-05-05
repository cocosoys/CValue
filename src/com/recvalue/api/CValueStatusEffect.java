package com.recvalue.api;

/**
 * CValue 门面层暴露的稳定状态效果标识。
 * Stable status-effect identifiers exposed by the CValue facade.
 */
public enum CValueStatusEffect {
    EVOLUTION(1, "evolution"),
    RAMPAGE(3, "rampage"),
    CHARGE(4, "charge"),
    KAIOKEN(5, "kaioken"),
    FLIGHT(6, "flight"),
    NIGHT(7, "night"),
    FUSION_A(10, "fusion_a"),
    FUSION_B(11, "fusion_b"),
    MAJIN(12, "majin"),
    MYSTIC(13, "mystic"),
    LEGENDARY(14, "legendary"),
    ROSE(17, "rose"),
    ULTRA_INSTINCT(19, "ultra_instinct"),
    GOD_OF_DESTRUCTION(20, "god_of_destruction");

    private final int id;
    private final String key;

    CValueStatusEffect(int id, String key) {
        this.id = id;
        this.key = key;
    }

    /**
     * 返回 JRMCore 使用的数字状态效果 id。
     * Returns the numeric JRMCore effect id.
     */
    public int id() {
        return id;
    }

    /**
     * 返回配置或界面可用的稳定文本 key。
     * Returns a stable text key for config or UI usage.
     */
    public String key() {
        return key;
    }

    /**
     * 按数字 id 查找状态效果枚举。
     * Looks up a status-effect enum by numeric id.
     */
    public static CValueStatusEffect fromId(int effectId) {
        for (CValueStatusEffect effect : values()) {
            if (effect.id == effectId) {
                return effect;
            }
        }
        return null;
    }

    /**
     * 按稳定 key 查找状态效果枚举。
     * Looks up a status-effect enum by stable key.
     */
    public static CValueStatusEffect fromKey(String effectKey) {
        if (effectKey == null) {
            return null;
        }
        for (CValueStatusEffect effect : values()) {
            if (effect.key.equalsIgnoreCase(effectKey)) {
                return effect;
            }
        }
        return null;
    }
}
