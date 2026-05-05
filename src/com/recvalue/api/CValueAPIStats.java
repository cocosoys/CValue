package com.recvalue.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CValueAPI 的数值与属性分组。
 * Stats and attribute group for CValueAPI.
 */
public class CValueAPIStats extends CValueAPIBase {
    /**
     * 创建按玩家绑定的分组视图。
     * Creates a player-bound grouped view.
     */
    protected CValueAPIStats(CValuePlayerView view) {
        super(view);
    }

    /**
     * 读取玩家等级。
     * Reads the player level.
     */
    public static int getLevel(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLevel();
    }

    /**
     * 读取距离下一级还差多少属性点。
     * Reads how many attribute points remain until the next level.
     */
    public static int getLevelNext(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLevelNext();
    }

    /**
     * 读取玩家最大气值。
     * Reads the player's maximum Ki value.
     */
    public static int getMaxKi(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxKi();
    }

    /**
     * 读取玩家最大体魄值。
     * Reads the player's maximum body value.
     */
    public static int getMaxBody(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxBody();
    }

    /**
     * 读取玩家最大耐力值。
     * Reads the player's maximum stamina value.
     */
    public static int getMaxStamina(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxStamina();
    }

    /**
     * 读取当前近战输出。
     * Reads the current melee output.
     */
    public static int getMelee(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMelee();
    }

    /**
     * 读取当前体魄强度值。
     * Reads the current body-strength value.
     */
    public static int getBodyStrength(EntityPlayer entityPlayer) {
        return of(entityPlayer).getBodyStrength();
    }

    /**
     * 读取当前装备负重值。
     * Reads the current carried-item weight value.
     */
    public static float getItemWeight(EntityPlayer entityPlayer) {
        return of(entityPlayer).getItemWeight();
    }

    /**
     * 读取角色体重权重值。
     * Reads the computed body-weight value.
     */
    public static float getBodyWeight(EntityPlayer entityPlayer) {
        return of(entityPlayer).getBodyWeight();
    }

    /**
     * 读取额外负重值。
     * Reads the extra carried-weight value.
     */
    public static float getExtraWeight(EntityPlayer entityPlayer) {
        return of(entityPlayer).getExtraWeight();
    }

    /**
     * 读取由体魄强度推导出的被动防御。
     * Reads the passive-defense value derived from body strength.
     */
    public static int getPassive(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPassive();
    }

    /**
     * 读取当前气功输出。
     * Reads the current Ki damage output.
     */
    public static int getKiPower(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKiPower();
    }

    /**
     * 读取最大气功输出。
     * Reads the maximum Ki damage output.
     */
    public static int getMaxKiPower(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxKiPower();
    }

    /**
     * 读取生命再生率数值。
     * Reads the body-regeneration stat value.
     */
    public static int getBodyRegenRate(EntityPlayer entityPlayer) {
        return of(entityPlayer).getBodyRegenRate();
    }

    /**
     * 读取耐力再生率数值。
     * Reads the stamina-regeneration stat value.
     */
    public static int getStaminaRegenRate(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStaminaRegenRate();
    }

    /**
     * 读取气值再生率数值。
     * Reads the energy-regeneration stat value.
     */
    public static int getEnergyRegenRate(EntityPlayer entityPlayer) {
        return of(entityPlayer).getEnergyRegenRate();
    }

    /**
     * 读取当前奔跑速度值。
     * Reads the current running-speed value.
     */
    public static int getRunning(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRunning();
    }

    /**
     * 读取当前飞行速度值。
     * Reads the current flying-speed value.
     */
    public static int getFlying(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFlying();
    }

    /**
     * 读取推导后的伤害减免百分比。
     * Reads the derived damage-reduction percentage.
     */
    public static int getDamageReduction(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDamageReduction();
    }

    /**
     * 读取扣除技能槽消耗后的可用精神。
     * Reads the currently available mind after skill-slot costs.
     */
    public static int getAvailableMind(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAvailableMind();
    }

    /**
     * 读取当前生命值。
     * Reads the current body/health value.
     */
    public static int getCurrentBody(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentBody();
    }

    /**
     * 读取当前气值。
     * Reads the current energy/Ki value.
     */
    public static int getCurrentEnergy(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentEnergy();
    }

    /**
     * 读取当前耐力值。
     * Reads the current stamina value.
     */
    public static int getCurrentStamina(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentStamina();
    }

    /**
     * 读取当前生命百分比。
     * Reads the current body/health percentage.
     */
    public static float getCurrentBodyPercentage(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentBodyPercentage();
    }

    /**
     * 读取当前气值百分比。
     * Reads the current energy/Ki percentage.
     */
    public static float getCurrentEnergyPercentage(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentEnergyPercentage();
    }

    /**
     * 读取当前耐力百分比。
     * Reads the current stamina percentage.
     */
    public static float getCurrentStaminaPercentage(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentStaminaPercentage();
    }

    /**
     * 读取当前释放百分比。
     * Reads the current release percentage.
     */
    public static int getRelease(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRelease();
    }

    /**
     * 读取冰冻恶魔的储备值。
     * Reads the current Arcosian reserve value.
     */
    public static int getArcReserve(EntityPlayer entityPlayer) {
        return of(entityPlayer).getArcReserve();
    }

    /**
     * 读取当前属性点数。
     * Reads the current attribute-point value.
     */
    public static int getAttributePoints(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAttributePoints();
    }

    /**
     * 读取善阵营击杀数。
     * Reads the good-alignment kill count.
     */
    public static int getGoodKillCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getGoodKillCount();
    }

    /**
     * 读取中立阵营击杀数。
     * Reads the neutral-alignment kill count.
     */
    public static int getNeutralKillCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getNeutralKillCount();
    }

    /**
     * 读取恶阵营击杀数。
     * Reads the evil-alignment kill count.
     */
    public static int getEvilKillCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getEvilKillCount();
    }

    /**
     * 读取上次造成伤害值。
     * Reads the last recorded damage dealt.
     */
    public static int getLastDamageDealt(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastDamageDealt();
    }

    /**
     * 读取上次受到伤害值。
     * Reads the last recorded damage received.
     */
    public static int getLastDamageReceived(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastDamageReceived();
    }

    /**
     * 判断是否为气体系玩家。
     * Returns whether the player is using the Ki power type.
     */
    public static boolean isKiUser(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKiUser();
    }

    /**
     * 判断 Ki Fist 设置位是否已启用。
     * Returns whether the Ki Fist setting flag is enabled.
     */
    public static boolean isKiFistSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKiFistSettingEnabled();
    }

    /**
     * 判断 Ki Protection 设置位是否已启用。
     * Returns whether the Ki Protection setting flag is enabled.
     */
    public static boolean isKiProtectionSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKiProtectionSettingEnabled();
    }

    /**
     * 读取总击杀数。
     * Reads the total kill count across alignments.
     */
    public static int getTotalKillCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTotalKillCount();
    }

    /**
     * 读取指定属性的起始值。
     * Reads the starting value of the given attribute.
     */
    public static int getStartAttribute(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getStartAttribute(attribute);
    }

    /**
     * 读取指定属性在派生公式中使用的有效值。
     * Reads the effective attribute value used by derived formulas.
     */
    public static int getAdditionAttribute(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAdditionAttribute(attribute);
    }

    /**
     * 读取属性对应的负重倍率。
     * Reads the weight multiplier applied to the given attribute lane.
     */
    public static float getWeightMultiplier(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getWeightMultiplier(attribute);
    }

    /**
     * 读取当前有效属性快照。
     * Reads a snapshot of the resolved current attributes.
     */
    public static int[] getResolvedAttributes(EntityPlayer entityPlayer) {
        return of(entityPlayer).getResolvedAttributes();
    }

    /**
     * 读取基础属性快照。
     * Reads a snapshot of the base attributes.
     */
    public static int[] getBaseAttributes(EntityPlayer entityPlayer) {
        return of(entityPlayer).getBaseAttributes();
    }

    /**
     * 读取最大体魄强度。
     * Reads the maximum body-strength value.
     */
    public static int getMaxBodyStrength(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxBodyStrength();
    }

    /**
     * 读取精神属性派生值。
     * Reads the derived spirit-stat value.
     */
    public static int getSpiritStat(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSpiritStat();
    }

    /**
     * 读取技能槽总精神消耗。
     * Reads the total mind requirement consumed by equipped skills.
     */
    public static int getSpentMindRequirement(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSpentMindRequirement();
    }

    /**
     * 按枚举读取当前有效属性值。
     * Reads a resolved current attribute value by enum.
     */
    public static int getAttribute(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttribute(attribute);
    }

    /**
     * 按枚举读取持久化基础属性值。
     * Reads a persisted/base attribute value by enum.
     */
    public static int getBaseAttribute(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getBaseAttribute(attribute);
    }

    /**
     * 读取属性显示名称。
     * Reads the attribute display name.
     */
    public static String getAttributeName(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeName(attribute);
    }

    /**
     * 读取属性说明文本。
     * Reads the attribute description text.
     */
    public static String getAttributeDescription(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeDescription(attribute);
    }

    /**
     * 读取当前力量体系下的属性名称数组。
     * Reads the attribute-name array for the current power type.
     */
    public static String[] getAttributeNames(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAttributeNames();
    }

    /**
     * 读取当前力量体系下的属性说明数组。
     * Reads the attribute-description array for the current power type.
     */
    public static String[] getAttributeDescriptions(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAttributeDescriptions();
    }

    /**
     * 读取玩家等级。
     * Reads the player level.
     */
    public int getLevel() {
        return view.getLevel();
    }

    /**
     * 读取距离下一级还差多少属性点。
     * Reads how many attribute points remain until the next level.
     */
    public int getLevelNext() {
        return view.getLevelNext();
    }

    /**
     * 读取玩家最大气值。
     * Reads the player's maximum Ki value.
     */
    public int getMaxKi() {
        return view.getMaxKi();
    }

    /**
     * 读取玩家最大体魄值。
     * Reads the player's maximum body value.
     */
    public int getMaxBody() {
        return view.getMaxBody();
    }

    /**
     * 读取玩家最大耐力值。
     * Reads the player's maximum stamina value.
     */
    public int getMaxStamina() {
        return view.getMaxStamina();
    }

    /**
     * 读取当前近战输出。
     * Reads the current melee output.
     */
    public int getMelee() {
        return view.getMelee();
    }

    /**
     * 读取当前体魄强度值。
     * Reads the current body-strength value.
     */
    public int getBodyStrength() {
        return view.getBodyStrength();
    }

    /**
     * 读取当前装备负重值。
     * Reads the current carried-item weight value.
     */
    public float getItemWeight() {
        return view.getItemWeight();
    }

    /**
     * 读取角色体重权重值。
     * Reads the computed body-weight value.
     */
    public float getBodyWeight() {
        return view.getBodyWeight();
    }

    /**
     * 读取额外负重值。
     * Reads the extra carried-weight value.
     */
    public float getExtraWeight() {
        return view.getExtraWeight();
    }

    /**
     * 读取由体魄强度推导出的被动防御。
     * Reads the passive-defense value derived from body strength.
     */
    public int getPassive() {
        return view.getPassive();
    }

    /**
     * 读取当前气功输出。
     * Reads the current Ki damage output.
     */
    public int getKiPower() {
        return view.getKiPower();
    }

    /**
     * 读取最大气功输出。
     * Reads the maximum Ki damage output.
     */
    public int getMaxKiPower() {
        return view.getMaxKiPower();
    }

    /**
     * 读取生命再生率数值。
     * Reads the body-regeneration stat value.
     */
    public int getBodyRegenRate() {
        return view.getBodyRegenRate();
    }

    /**
     * 读取耐力再生率数值。
     * Reads the stamina-regeneration stat value.
     */
    public int getStaminaRegenRate() {
        return view.getStaminaRegenRate();
    }

    /**
     * 读取气值再生率数值。
     * Reads the energy-regeneration stat value.
     */
    public int getEnergyRegenRate() {
        return view.getEnergyRegenRate();
    }

    /**
     * 读取当前奔跑速度值。
     * Reads the current running-speed value.
     */
    public int getRunning() {
        return view.getRunning();
    }

    /**
     * 读取当前飞行速度值。
     * Reads the current flying-speed value.
     */
    public int getFlying() {
        return view.getFlying();
    }

    /**
     * 读取推导后的伤害减免百分比。
     * Reads the derived damage-reduction percentage.
     */
    public int getDamageReduction() {
        return view.getDamageReduction();
    }

    /**
     * 读取扣除技能槽消耗后的可用精神。
     * Reads the currently available mind after skill-slot costs.
     */
    public int getAvailableMind() {
        return view.getAvailableMind();
    }

    /**
     * 读取当前生命值。
     * Reads the current body/health value.
     */
    public int getCurrentBody() {
        return view.getCurrentBody();
    }

    /**
     * 读取当前气值。
     * Reads the current energy/Ki value.
     */
    public int getCurrentEnergy() {
        return view.getCurrentEnergy();
    }

    /**
     * 读取当前耐力值。
     * Reads the current stamina value.
     */
    public int getCurrentStamina() {
        return view.getCurrentStamina();
    }

    /**
     * 读取当前生命百分比。
     * Reads the current body/health percentage.
     */
    public float getCurrentBodyPercentage() {
        return view.getCurrentBodyPercentage();
    }

    /**
     * 读取当前气值百分比。
     * Reads the current energy/Ki percentage.
     */
    public float getCurrentEnergyPercentage() {
        return view.getCurrentEnergyPercentage();
    }

    /**
     * 读取当前耐力百分比。
     * Reads the current stamina percentage.
     */
    public float getCurrentStaminaPercentage() {
        return view.getCurrentStaminaPercentage();
    }

    /**
     * 读取当前释放百分比。
     * Reads the current release percentage.
     */
    public int getRelease() {
        return view.getRelease();
    }

    /**
     * 读取冰冻恶魔的储备值。
     * Reads the current Arcosian reserve value.
     */
    public int getArcReserve() {
        return view.getArcReserve();
    }

    /**
     * 读取当前属性点数。
     * Reads the current attribute-point value.
     */
    public int getAttributePoints() {
        return view.getAttributePoints();
    }

    /**
     * 读取善阵营击杀数。
     * Reads the good-alignment kill count.
     */
    public int getGoodKillCount() {
        return view.getGoodKillCount();
    }

    /**
     * 读取中立阵营击杀数。
     * Reads the neutral-alignment kill count.
     */
    public int getNeutralKillCount() {
        return view.getNeutralKillCount();
    }

    /**
     * 读取恶阵营击杀数。
     * Reads the evil-alignment kill count.
     */
    public int getEvilKillCount() {
        return view.getEvilKillCount();
    }

    /**
     * 读取上次造成伤害值。
     * Reads the last recorded damage dealt.
     */
    public int getLastDamageDealt() {
        return view.getLastDamageDealt();
    }

    /**
     * 读取上次受到伤害值。
     * Reads the last recorded damage received.
     */
    public int getLastDamageReceived() {
        return view.getLastDamageReceived();
    }

    /**
     * 判断是否为气体系玩家。
     * Returns whether the player is using the Ki power type.
     */
    public boolean isKiUser() {
        return view.isKiUser();
    }

    /**
     * 判断 Ki Fist 设置位是否已启用。
     * Returns whether the Ki Fist setting flag is enabled.
     */
    public boolean isKiFistSettingEnabled() {
        return view.isKiFistSettingEnabled();
    }

    /**
     * 判断 Ki Protection 设置位是否已启用。
     * Returns whether the Ki Protection setting flag is enabled.
     */
    public boolean isKiProtectionSettingEnabled() {
        return view.isKiProtectionSettingEnabled();
    }

    /**
     * 读取总击杀数。
     * Reads the total kill count across alignments.
     */
    public int getTotalKillCount() {
        return view.getTotalKillCount();
    }

    /**
     * 读取指定属性的起始值。
     * Reads the starting value of the given attribute.
     */
    public int getStartAttribute(CValueAttribute attribute) {
        return view.getStartAttribute(attribute);
    }

    /**
     * 读取指定属性在派生公式中使用的有效值。
     * Reads the effective attribute value used by derived formulas.
     */
    public int getAdditionAttribute(CValueAttribute attribute) {
        return view.getAdditionAttribute(attribute);
    }

    /**
     * 读取属性对应的负重倍率。
     * Reads the weight multiplier applied to the given attribute lane.
     */
    public float getWeightMultiplier(CValueAttribute attribute) {
        return view.getWeightMultiplier(attribute);
    }

    /**
     * 读取当前有效属性快照。
     * Reads a snapshot of the resolved current attributes.
     */
    public int[] getResolvedAttributes() {
        return view.getResolvedAttributes();
    }

    /**
     * 读取基础属性快照。
     * Reads a snapshot of the base attributes.
     */
    public int[] getBaseAttributes() {
        return view.getBaseAttributes();
    }

    /**
     * 读取最大体魄强度。
     * Reads the maximum body-strength value.
     */
    public int getMaxBodyStrength() {
        return view.getMaxBodyStrength();
    }

    /**
     * 读取精神属性派生值。
     * Reads the derived spirit-stat value.
     */
    public int getSpiritStat() {
        return view.getSpiritStat();
    }

    /**
     * 读取技能槽总精神消耗。
     * Reads the total mind requirement consumed by equipped skills.
     */
    public int getSpentMindRequirement() {
        return view.getSpentMindRequirement();
    }

    /**
     * 按枚举读取当前有效属性值。
     * Reads a resolved current attribute value by enum.
     */
    public int getAttribute(CValueAttribute attribute) {
        return view.getAttribute(attribute);
    }

    /**
     * 按枚举读取持久化基础属性值。
     * Reads a persisted/base attribute value by enum.
     */
    public int getBaseAttribute(CValueAttribute attribute) {
        return view.getBaseAttribute(attribute);
    }

    /**
     * 读取属性显示名称。
     * Reads the attribute display name.
     */
    public String getAttributeName(CValueAttribute attribute) {
        return view.getAttributeName(attribute);
    }

    /**
     * 读取属性说明文本。
     * Reads the attribute description text.
     */
    public String getAttributeDescription(CValueAttribute attribute) {
        return view.getAttributeDescription(attribute);
    }

    /**
     * 读取当前力量体系下的属性名称数组。
     * Reads the attribute-name array for the current power type.
     */
    public String[] getAttributeNames() {
        return view.getAttributeNames();
    }

    /**
     * 读取当前力量体系下的属性说明数组。
     * Reads the attribute-description array for the current power type.
     */
    public String[] getAttributeDescriptions() {
        return view.getAttributeDescriptions();
    }

}
