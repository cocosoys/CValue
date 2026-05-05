package com.recvalue.base.race;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 混血赛亚人种族的属性解析器。
 * Half-Saiyan race attribute resolver.
 */
public class HalfSaiyanRace extends SaiyanRace {
    /**
     * 混血赛亚人种族标签。
     * Half-Saiyan race label.
     */
    public static final String RaceName = "Half-Saiyan";

    /**
     * JRMCore 使用的混血赛亚人种族 id。
     * Half-Saiyan race id used by JRMCore.
     */
    public static final int RaceID = 2;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public HalfSaiyanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public HalfSaiyanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回混血赛亚人升阶偏好形态 id。
     * Returns the preferred Half-Saiyan transformation form id.
     */
    public int getPreferredHalfSaiyanTransformationFormId() {
        return getPreferredSaiyanTransformationFormId();
    }

    /**
     * 返回混血赛亚人升阶偏好形态名称。
     * Returns the preferred Half-Saiyan transformation form name.
     */
    public String getPreferredHalfSaiyanTransformationFormName() {
        return getPreferredSaiyanTransformationFormName();
    }

    /**
     * 返回混血赛亚人升阶偏好模式名称。
     * Returns the Half-Saiyan transform-type mode name.
     */
    public String getHalfSaiyanTransformTypeModeName() {
        return getPreferredHalfSaiyanTransformationFormName();
    }

    /**
     * 调用 JRMCore 的混血赛亚人属性公式。
     * Delegates Half-Saiyan-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeHalfSaiyan(
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
