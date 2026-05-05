package com.recvalue.base.race;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 赛亚人种族的属性解析器。
 * Saiyan race attribute resolver.
 */
public class SaiyanRace extends HumanRace {
    /**
     * 赛亚人种族标签。
     * Saiyan race label.
     */
    public static final String RaceName = "Saiyan";

    /**
     * JRMCore 使用的赛亚人种族 id。
     * Saiyan race id used by JRMCore.
     */
    public static final int RaceID = 1;

    /**
     * 创建包装器，但不立即读取 NBT。
     * Creates a race wrapper without immediately loading NBT data.
     */
    public SaiyanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    /**
     * 创建包装器，并按需预加载 NBT。
     * Creates a race wrapper and optionally preloads NBT-backed values.
     */
    public SaiyanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

    /**
     * 返回赛亚人变身计量条值。
     * Returns the Saiyan transformation-meter value.
     */
    public int getSaiyanTransformationMeter() {
        return getTransformationMeter();
    }

    /**
     * 返回赛亚人升阶偏好模式值。
     * Returns the Saiyan transform-type mode value.
     */
    public int getSaiyanTransformTypeMode() {
        return getPlayerSettingValue(1);
    }

    /**
     * 判断是否选择了常规升阶路线。
     * Returns whether the normal Saiyan transform route is selected.
     */
    public boolean isSaiyanTransformTypeNormalSelected() {
        return JinRyuu.JRMCore.JRMCoreH.PlyrSettingsI(entityPlayer, 1, 0);
    }

    /**
     * 判断是否选择了神路线。
     * Returns whether the Saiyan God route is selected.
     */
    public boolean isSaiyanTransformTypeGodSelected() {
        return JinRyuu.JRMCore.JRMCoreH.PlyrSettingsI(entityPlayer, 1, 1);
    }

    /**
     * 判断是否选择了蓝路线。
     * Returns whether the Saiyan Blue route is selected.
     */
    public boolean isSaiyanTransformTypeBlueSelected() {
        return JinRyuu.JRMCore.JRMCoreH.PlyrSettingsI(entityPlayer, 1, 2);
    }

    /**
     * 判断是否选择了超四路线。
     * Returns whether the Saiyan Super Saiyan 4 route is selected.
     */
    public boolean isSaiyanTransformTypeSuperSaiyan4Selected() {
        return JinRyuu.JRMCore.JRMCoreH.PlyrSettingsI(entityPlayer, 1, 3);
    }

    /**
     * 返回赛亚人升阶偏好形态 id。
     * Returns the preferred Saiyan transformation form id.
     */
    public int getPreferredSaiyanTransformationFormId() {
        if (isSaiyanTransformTypeBlueSelected()) {
            return 10;
        }
        if (isSaiyanTransformTypeGodSelected()) {
            return 9;
        }
        if (isSaiyanTransformTypeNormalSelected()) {
            return 5;
        }
        if (isSaiyanTransformTypeSuperSaiyan4Selected()) {
            return 14;
        }
        return 2;
    }

    /**
     * 返回赛亚人升阶偏好形态名称。
     * Returns the preferred Saiyan transformation form name.
     */
    public String getPreferredSaiyanTransformationFormName() {
        return JinRyuu.JRMCore.JRMCoreH.getTransformationName(
            RaceID,
            getPreferredSaiyanTransformationFormId(),
            hasStatusEffect(17),
            false,
            false,
            false
        );
    }

    /**
     * 返回赛亚人升阶偏好模式名称。
     * Returns the Saiyan transform-type mode name.
     */
    public String getSaiyanTransformTypeModeName() {
        return getPreferredSaiyanTransformationFormName();
    }

    /**
     * 调用 JRMCore 的赛亚人属性公式。
     * Delegates Saiyan-specific attribute resolution to the matching JRMCore helper.
     */
    @Override
    protected int resolveAttributeValue(int attributeIndex) {
        int raceSpecificValue = JinRyuu.JRMCore.JRMCoreH.getAttributeSaiyan(
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
