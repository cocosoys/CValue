package com.recvalue.base.race;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 魔人种族的属性解析器。
 * Majin race attribute resolver.
 */
public class MajinRace extends SaiyanRace {
    /**
     * 魔人种族标签。
     * Majin race label.
     */
    public static final String RaceName = "Majin";

    /**
     * JRMCore 使用的魔人种族 id。
     * Majin race id used by JRMCore.
     */
    public static final int RaceID = 5;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public MajinRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public MajinRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回魔人吸收值。
     * Returns the Majin absorption value.
     */
    public int getAbsorptionValue() {
        return getMajinAbsorptionValue();
    }

    /**
     * 返回魔人吸收计时值。
     * Returns the Majin absorption timer value.
     */
    public int getAbsorptionTimer() {
        return getMajinAbsorptionTimer();
    }

    /**
     * 返回魔人吸收分段数组。
     * Returns the Majin absorption segments split by comma.
     */
    public String[] getAbsorptionParts() {
        return getMajinAbsorptionParts();
    }

    /**
     * 返回魔人升阶偏好模式值。
     * Returns the Majin transform-type mode value.
     */
    public int getMajinTransformTypeMode() {
        return getPlayerSettingValue(1);
    }

    /**
     * 返回魔人升阶偏好形态 id。
     * Returns the preferred Majin transformation form id.
     */
    public int getPreferredMajinTransformationFormId() {
        return (getPlayerSettingValue(1) == 1) ? 4 : ((getPlayerSettingValue(1) == 0) ? 3 : 1);
    }

    /**
     * 返回魔人升阶偏好形态名称。
     * Returns the preferred Majin transformation form name.
     */
    public String getPreferredMajinTransformationFormName() {
        return JinRyuu.JRMCore.JRMCoreH.getTransformationName(
            RaceID,
            getPreferredMajinTransformationFormId(),
            false,
            false,
            false,
            false
        );
    }

    /**
     * 返回魔人升阶偏好模式名称。
     * Returns the Majin transform-type mode name.
     */
    public String getMajinTransformTypeModeName() {
        return getPreferredMajinTransformationFormName();
    }

    /**
     * 调用 JRMCore 的魔人属性公式。
     * Delegates Majin-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeMajin(
            entityPlayer,
            getBaseAttributesForRaceCalculation(),
            attributeIndex,
            getCurrentState(),
            getSkillXLevel(),
            hasMysticStatus(),
            getMysticSkillLevel(),
            hasFusionStatus(),
            hasUltraInstinctStatus(),
            getPowerType(),
            hasGodOfDestructionStatus(),
            getMajinAbsorptionData()
        );
        return applySharedAttributeBonuses(raceSpecificValue, attributeIndex);
    }
}
