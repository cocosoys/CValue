package com.recvalue.base.race;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 冰冻恶魔种族的属性解析器。
 * Arcosian race attribute resolver.
 */
public class ArcosianRace extends SaiyanRace {
    /**
     * 冰冻恶魔种族标签。
     * Arcosian race label.
     */
    public static final String RaceName = "Arcosian";

    /**
     * JRMCore 使用的冰冻恶魔种族 id。
     * Arcosian race id used by JRMCore.
     */
    public static final int RaceID = 4;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public ArcosianRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public ArcosianRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回冰冻恶魔的 Power Point 储备值。
     * Returns the Arcosian Power Point reserve value.
     */
    public int getPowerPointReserve() {
        return getArcReserve();
    }

    /**
     * 返回冰冻恶魔升阶偏好模式值。
     * Returns the Arcosian transform-type mode value.
     */
    public int getArcosianTransformTypeMode() {
        return getPlayerSettingValue(1);
    }

    /**
     * 返回冰冻恶魔升阶偏好形态 id。
     * Returns the preferred Arcosian transformation form id.
     */
    public int getPreferredArcosianTransformationFormId() {
        return (getPlayerSettingValue(1) == 1) ? 7 : ((getPlayerSettingValue(1) == 0) ? 6 : 5);
    }

    /**
     * 返回冰冻恶魔升阶偏好形态名称。
     * Returns the preferred Arcosian transformation form name.
     */
    public String getPreferredArcosianTransformationFormName() {
        return JinRyuu.JRMCore.JRMCoreH.getTransformationName(
            RaceID,
            getPreferredArcosianTransformationFormId(),
            false,
            false,
            false,
            false
        );
    }

    /**
     * 返回冰冻恶魔升阶偏好模式名称。
     * Returns the Arcosian transform-type mode name.
     */
    public String getArcosianTransformTypeModeName() {
        return getPreferredArcosianTransformationFormName();
    }

    /**
     * 调用 JRMCore 的冰冻恶魔属性公式。
     * Delegates Arcosian-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeArcosian(
            entityPlayer,
            getBaseAttributesForRaceCalculation(),
            attributeIndex,
            getCurrentState(),
            getCurrentRelease(),
            getArcReserve(),
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
