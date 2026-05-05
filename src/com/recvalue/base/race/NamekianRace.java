package com.recvalue.base.race;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 那美克星人种族的属性解析器。
 * Namekian race attribute resolver.
 */
public class NamekianRace extends SaiyanRace {
    /**
     * 那美克星人种族标签。
     * Namekian race label.
     */
    public static final String RaceName = "Namekian";

    /**
     * JRMCore 使用的那美克星人种族 id。
     * Namekian race id used by JRMCore.
     */
    public static final int RaceID = 3;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public NamekianRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public NamekianRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回那美克星人升阶偏好模式值。
     * Returns the Namekian transform-type mode value.
     */
    public int getNamekianTransformTypeMode() {
        return getPlayerSettingValue(1);
    }

    /**
     * 返回那美克星人升阶偏好形态 id。
     * Returns the preferred Namekian transformation form id.
     */
    public int getPreferredNamekianTransformationFormId() {
        return (getPlayerSettingValue(1) == 1) ? 3 : ((getPlayerSettingValue(1) == 0) ? 1 : 2);
    }

    /**
     * 返回那美克星人升阶偏好形态名称。
     * Returns the preferred Namekian transformation form name.
     */
    public String getPreferredNamekianTransformationFormName() {
        return JinRyuu.JRMCore.JRMCoreH.getTransformationName(
            RaceID,
            getPreferredNamekianTransformationFormId(),
            false,
            false,
            false,
            false
        );
    }

    /**
     * 返回那美克星人升阶偏好模式名称。
     * Returns the Namekian transform-type mode name.
     */
    public String getNamekianTransformTypeModeName() {
        return getPreferredNamekianTransformationFormName();
    }

    /**
     * 调用 JRMCore 的那美克星人属性公式。
     * Delegates Namekian-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeNamekian(
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
            hasGodOfDestructionStatus()
        );
        return applySharedAttributeBonuses(raceSpecificValue, attributeIndex);
    }
}
