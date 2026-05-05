package com.recvalue.base.race;

import com.recvalue.base.Base;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 人类种族的属性解析器。
 * Human race attribute resolver.
 */
public class HumanRace extends Base {
    /**
     * 人类种族标签。
     * Human race label.
     */
    public static final String RaceName = "Human";

    /**
     * JRMCore 使用的人类种族 id。
     * Human race id used by JRMCore.
     */
    public static final int RaceID = 0;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public HumanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public HumanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回人类升阶偏好模式值。
     * Returns the Human transform-type mode value.
     */
    public int getHumanTransformTypeMode() {
        return getPlayerSettingValue(1);
    }

    /**
     * 返回人类升阶偏好形态 id。
     * Returns the preferred Human transformation form id.
     */
    public int getPreferredHumanTransformationFormId() {
        return (getPlayerSettingValue(1) == 1) ? 3 : ((getPlayerSettingValue(1) == 0) ? 1 : 2);
    }

    /**
     * 返回人类升阶偏好形态名称。
     * Returns the preferred Human transformation form name.
     */
    public String getPreferredHumanTransformationFormName() {
        return JinRyuu.JRMCore.JRMCoreH.getTransformationName(
            RaceID,
            getPreferredHumanTransformationFormId(),
            false,
            false,
            false,
            false
        );
    }

    /**
     * 返回人类升阶偏好模式名称。
     * Returns the Human transform-type mode name.
     */
    public String getHumanTransformTypeModeName() {
        return getPreferredHumanTransformationFormName();
    }

    /**
     * 调用 JRMCore 的人类属性公式。
     * Delegates human-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeHuman(
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
