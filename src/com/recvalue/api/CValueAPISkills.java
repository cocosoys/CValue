package com.recvalue.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CValueAPI 的技能、设置与奖励分组。
 * Skills, settings, and bonus group for CValueAPI.
 */
public class CValueAPISkills extends CValueAPIStats {
    /**
     * 创建按玩家绑定的分组视图。
     * Creates a player-bound grouped view.
     */
    protected CValueAPISkills(CValuePlayerView view) {
        super(view);
    }

    /**
     * 读取种族技能等级。
     * Reads the current racial-skill level.
     */
    public static int getRacialSkillLevel(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRacialSkillLevel();
    }

    /**
     * 读取 Mystic 技能等级。
     * Reads the current Mystic skill level.
     */
    public static int getMysticSkillLevel(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMysticSkillLevel();
    }

    /**
     * 读取当前力量体系下的技能等级。
     * Reads one skill level using the player's current power type.
     */
    public static int getSkillLevel(EntityPlayer entityPlayer, int skillIndex) {
        return of(entityPlayer).getSkillLevel(skillIndex);
    }

    /**
     * 读取 DBC 技能表中的技能等级。
     * Reads one skill level from the DBC skill catalog.
     */
    public static int getDbcSkillLevel(EntityPlayer entityPlayer, int skillIndex) {
        return of(entityPlayer).getDbcSkillLevel(skillIndex);
    }

    /**
     * 读取 NC 技能表中的技能等级。
     * Reads one skill level from the NC skill catalog.
     */
    public static int getNCSkillLevel(EntityPlayer entityPlayer, int skillIndex) {
        return of(entityPlayer).getNCSkillLevel(skillIndex);
    }

    /**
     * 读取种族技能槽原始数据。
     * Reads the raw racial skill-slot payload.
     */
    public static String getRacialSkillSlot(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRacialSkillSlot();
    }

    /**
     * 读取核心技能槽原始数据。
     * Reads the raw core skill-slot payload.
     */
    public static String getCoreSkillSlot(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCoreSkillSlot();
    }

    /**
     * 读取已学习技能的原始字符串。
     * Reads the raw learned-skills payload string.
     */
    public static String getLearnedSkillsRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLearnedSkillsRaw();
    }

    /**
     * 读取已学习技能数组。
     * Reads the learned-skills array.
     */
    public static String[] getLearnedSkills(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLearnedSkills();
    }

    /**
     * 读取指定索引的已学习技能条目。
     * Reads the learned-skill entry at the given index.
     */
    public static String getLearnedSkillAt(EntityPlayer entityPlayer, int index) {
        return of(entityPlayer).getLearnedSkillAt(index);
    }

    /**
     * 读取包含指定片段的已学习技能条目数组。
     * Reads the learned-skill entries containing the given token.
     */
    public static String[] getLearnedSkillsContaining(EntityPlayer entityPlayer, String skillToken) {
        return of(entityPlayer).getLearnedSkillsContaining(skillToken);
    }

    /**
     * 读取已学习技能数量。
     * Reads the number of learned-skill entries.
     */
    public static int getLearnedSkillCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLearnedSkillCount();
    }

    /**
     * 判断是否存在已学习技能条目。
     * Returns whether at least one learned-skill entry exists.
     */
    public static boolean hasLearnedSkills(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasLearnedSkills();
    }

    /**
     * 判断原始技能条目中是否包含指定片段。
     * Returns whether the learned-skill payload contains the given token.
     */
    public static boolean hasLearnedSkillToken(EntityPlayer entityPlayer, String skillToken) {
        return of(entityPlayer).hasLearnedSkillToken(skillToken);
    }

    /**
     * 读取属性 bonus 原始字符串。
     * Reads the raw bonus-attribute payload for the given attribute.
     */
    public static String getAttributeBonusRaw(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusRaw(attribute);
    }

    /**
     * 判断指定属性是否存在 bonus 数据。
     * Returns whether the given attribute currently has bonus-attribute data.
     */
    public static boolean hasAttributeBonus(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).hasAttributeBonus(attribute);
    }

    /**
     * 读取指定属性的 bonus 条目数组。
     * Returns the parsed bonus-attribute entries for the given attribute.
     */
    public static String[] getAttributeBonusEntries(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusEntries(attribute);
    }

    /**
     * 读取指定属性 bonus 的名称数组。
     * Reads the bonus-name array for the given attribute.
     */
    public static String[] getAttributeBonusNames(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusNames(attribute);
    }

    /**
     * 读取指定属性 bonus 的表达式数组。
     * Reads the bonus-expression array for the given attribute.
     */
    public static String[] getAttributeBonusExpressions(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusExpressions(attribute);
    }

    /**
     * 读取指定属性 bonus 的运算符数组。
     * Reads the bonus-operator array for the given attribute.
     */
    public static String[] getAttributeBonusOperators(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusOperators(attribute);
    }

    /**
     * 读取指定属性 bonus 的数值数组。
     * Reads the numeric bonus-value array for the given attribute.
     */
    public static double[] getAttributeBonusNumericValues(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusNumericValues(attribute);
    }

    /**
     * 读取指定属性的 bonus 条目数量。
     * Returns the number of bonus-attribute entries for the given attribute.
     */
    public static int getAttributeBonusEntryCount(EntityPlayer entityPlayer, CValueAttribute attribute) {
        return of(entityPlayer).getAttributeBonusEntryCount(attribute);
    }

    /**
     * 读取玩家设置槽位的当前值。
     * Reads the current value stored for the given player-setting slot.
     */
    public static int getPlayerSettingValue(EntityPlayer entityPlayer, int settingIndex) {
        return of(entityPlayer).getPlayerSettingValue(settingIndex);
    }

    /**
     * 读取玩家设置枚举对应槽位的当前值。
     * Reads the current value stored for the given player-setting enum.
     */
    public static int getPlayerSettingValue(EntityPlayer entityPlayer, CValuePlayerSetting setting) {
        return of(entityPlayer).getPlayerSettingValue(setting);
    }

    /**
     * 判断指定玩家设置槽位是否已启用。
     * Returns whether the given player-setting slot is enabled/present.
     */
    public static boolean hasPlayerSetting(EntityPlayer entityPlayer, int settingIndex) {
        return of(entityPlayer).hasPlayerSetting(settingIndex);
    }

    /**
     * 判断玩家设置枚举对应槽位是否已启用。
     * Returns whether the given player-setting enum is enabled/present.
     */
    public static boolean hasPlayerSetting(EntityPlayer entityPlayer, CValuePlayerSetting setting) {
        return of(entityPlayer).hasPlayerSetting(setting);
    }

    /**
     * 返回当前已启用的已知玩家设置列表。
     * Returns the currently enabled known player-setting list.
     */
    public static CValuePlayerSetting[] getEnabledKnownPlayerSettings(EntityPlayer entityPlayer) {
        return of(entityPlayer).getEnabledKnownPlayerSettings();
    }

    /**
     * 判断 Ki Weapon 设置位是否已启用。
     * Returns whether the Ki Weapon setting flag is enabled.
     */
    public static boolean hasKiWeaponSetting(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasKiWeaponSetting();
    }

    /**
     * 读取 Ki Weapon 模式值。
     * Reads the Ki Weapon mode value.
     */
    public static int getKiWeaponMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKiWeaponMode();
    }

    /**
     * 读取 Ki Weapon 模式名称。
     * Reads the Ki Weapon mode name.
     */
    public static String getKiWeaponModeName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKiWeaponModeName();
    }

    /**
     * 判断当前 Ki Weapon 是否为剑模式。
     * Returns whether the current Ki Weapon mode is sword mode.
     */
    public static boolean isKiWeaponSwordMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKiWeaponSwordMode();
    }

    /**
     * 判断当前 Ki Weapon 是否为镰刀模式。
     * Returns whether the current Ki Weapon mode is scythe mode.
     */
    public static boolean isKiWeaponScytheMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKiWeaponScytheMode();
    }

    /**
     * 读取瞬移短距离模式值。
     * Reads the Instant Transmission short-mode value.
     */
    public static int getInstantTransmissionShortMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionShortMode();
    }

    /**
     * 读取瞬移短距离模式名称。
     * Reads the Instant Transmission short-mode name.
     */
    public static String getInstantTransmissionShortModeName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionShortModeName();
    }

    /**
     * 读取瞬移环绕模式值。
     * Reads the Instant Transmission surround-mode value.
     */
    public static int getInstantTransmissionSurroundMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionSurroundMode();
    }

    /**
     * 读取力量路线技能加成。
     * Reads the skill-based strength bonus.
     */
    public static int getStrengthSkillBonus(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStrengthSkillBonus();
    }

    /**
     * 读取敏捷路线技能加成。
     * Reads the skill-based dexterity bonus.
     */
    public static int getDexteritySkillBonus(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDexteritySkillBonus();
    }

    /**
     * 读取种族技能等级。
     * Reads the current racial-skill level.
     */
    public int getRacialSkillLevel() {
        return view.getRacialSkillLevel();
    }

    /**
     * 读取 Mystic 技能等级。
     * Reads the current Mystic skill level.
     */
    public int getMysticSkillLevel() {
        return view.getMysticSkillLevel();
    }

    /**
     * 读取当前力量体系下的技能等级。
     * Reads one skill level using the player's current power type.
     */
    public int getSkillLevel(int skillIndex) {
        return view.getSkillLevel(skillIndex);
    }

    /**
     * 读取 DBC 技能表中的技能等级。
     * Reads one skill level from the DBC skill catalog.
     */
    public int getDbcSkillLevel(int skillIndex) {
        return view.getDbcSkillLevel(skillIndex);
    }

    /**
     * 读取 NC 技能表中的技能等级。
     * Reads one skill level from the NC skill catalog.
     */
    public int getNCSkillLevel(int skillIndex) {
        return view.getNCSkillLevel(skillIndex);
    }

    /**
     * 读取种族技能槽原始数据。
     * Reads the raw racial skill-slot payload.
     */
    public String getRacialSkillSlot() {
        return view.getRacialSkillSlot();
    }

    /**
     * 读取核心技能槽原始数据。
     * Reads the raw core skill-slot payload.
     */
    public String getCoreSkillSlot() {
        return view.getCoreSkillSlot();
    }

    /**
     * 读取已学习技能的原始字符串。
     * Reads the raw learned-skills payload string.
     */
    public String getLearnedSkillsRaw() {
        return view.getLearnedSkillsRaw();
    }

    /**
     * 读取已学习技能数组。
     * Reads the learned-skills array.
     */
    public String[] getLearnedSkills() {
        return view.getLearnedSkills();
    }

    /**
     * 读取指定索引的已学习技能条目。
     * Reads the learned-skill entry at the given index.
     */
    public String getLearnedSkillAt(int index) {
        return view.getLearnedSkillAt(index);
    }

    /**
     * 读取包含指定片段的已学习技能条目数组。
     * Reads the learned-skill entries containing the given token.
     */
    public String[] getLearnedSkillsContaining(String skillToken) {
        return view.getLearnedSkillsContaining(skillToken);
    }

    /**
     * 读取已学习技能数量。
     * Reads the number of learned-skill entries.
     */
    public int getLearnedSkillCount() {
        return view.getLearnedSkillCount();
    }

    /**
     * 判断是否存在已学习技能条目。
     * Returns whether at least one learned-skill entry exists.
     */
    public boolean hasLearnedSkills() {
        return view.hasLearnedSkills();
    }

    /**
     * 判断原始技能条目中是否包含指定片段。
     * Returns whether the learned-skill payload contains the given token.
     */
    public boolean hasLearnedSkillToken(String skillToken) {
        return view.hasLearnedSkillToken(skillToken);
    }

    /**
     * 读取属性 bonus 原始字符串。
     * Reads the raw bonus-attribute payload for the given attribute.
     */
    public String getAttributeBonusRaw(CValueAttribute attribute) {
        return view.getAttributeBonusRaw(attribute);
    }

    /**
     * 判断指定属性是否存在 bonus 数据。
     * Returns whether the given attribute currently has bonus-attribute data.
     */
    public boolean hasAttributeBonus(CValueAttribute attribute) {
        return view.hasAttributeBonus(attribute);
    }

    /**
     * 读取指定属性的 bonus 条目数组。
     * Returns the parsed bonus-attribute entries for the given attribute.
     */
    public String[] getAttributeBonusEntries(CValueAttribute attribute) {
        return view.getAttributeBonusEntries(attribute);
    }

    /**
     * 读取指定属性 bonus 的名称数组。
     * Reads the bonus-name array for the given attribute.
     */
    public String[] getAttributeBonusNames(CValueAttribute attribute) {
        return view.getAttributeBonusNames(attribute);
    }

    /**
     * 读取指定属性 bonus 的表达式数组。
     * Reads the bonus-expression array for the given attribute.
     */
    public String[] getAttributeBonusExpressions(CValueAttribute attribute) {
        return view.getAttributeBonusExpressions(attribute);
    }

    /**
     * 读取指定属性 bonus 的运算符数组。
     * Reads the bonus-operator array for the given attribute.
     */
    public String[] getAttributeBonusOperators(CValueAttribute attribute) {
        return view.getAttributeBonusOperators(attribute);
    }

    /**
     * 读取指定属性 bonus 的数值数组。
     * Reads the numeric bonus-value array for the given attribute.
     */
    public double[] getAttributeBonusNumericValues(CValueAttribute attribute) {
        return view.getAttributeBonusNumericValues(attribute);
    }

    /**
     * 读取指定属性的 bonus 条目数量。
     * Returns the number of bonus-attribute entries for the given attribute.
     */
    public int getAttributeBonusEntryCount(CValueAttribute attribute) {
        return view.getAttributeBonusEntryCount(attribute);
    }

    /**
     * 读取玩家设置槽位的当前值。
     * Reads the current value stored for the given player-setting slot.
     */
    public int getPlayerSettingValue(int settingIndex) {
        return view.getPlayerSettingValue(settingIndex);
    }

    /**
     * 读取玩家设置枚举对应槽位的当前值。
     * Reads the current value stored for the given player-setting enum.
     */
    public int getPlayerSettingValue(CValuePlayerSetting setting) {
        return view.getPlayerSettingValue(setting);
    }

    /**
     * 判断指定玩家设置槽位是否已启用。
     * Returns whether the given player-setting slot is enabled/present.
     */
    public boolean hasPlayerSetting(int settingIndex) {
        return view.hasPlayerSetting(settingIndex);
    }

    /**
     * 判断玩家设置枚举对应槽位是否已启用。
     * Returns whether the given player-setting enum is enabled/present.
     */
    public boolean hasPlayerSetting(CValuePlayerSetting setting) {
        return view.hasPlayerSetting(setting);
    }

    /**
     * 返回当前已启用的已知玩家设置列表。
     * Returns the currently enabled known player-setting list.
     */
    public CValuePlayerSetting[] getEnabledKnownPlayerSettings() {
        return view.getEnabledKnownPlayerSettings();
    }

    /**
     * 判断 Ki Weapon 设置位是否已启用。
     * Returns whether the Ki Weapon setting flag is enabled.
     */
    public boolean hasKiWeaponSetting() {
        return view.hasKiWeaponSetting();
    }

    /**
     * 读取 Ki Weapon 模式值。
     * Reads the Ki Weapon mode value.
     */
    public int getKiWeaponMode() {
        return view.getKiWeaponMode();
    }

    /**
     * 读取 Ki Weapon 模式名称。
     * Reads the Ki Weapon mode name.
     */
    public String getKiWeaponModeName() {
        return view.getKiWeaponModeName();
    }

    /**
     * 判断当前 Ki Weapon 是否为剑模式。
     * Returns whether the current Ki Weapon mode is sword mode.
     */
    public boolean isKiWeaponSwordMode() {
        return view.isKiWeaponSwordMode();
    }

    /**
     * 判断当前 Ki Weapon 是否为镰刀模式。
     * Returns whether the current Ki Weapon mode is scythe mode.
     */
    public boolean isKiWeaponScytheMode() {
        return view.isKiWeaponScytheMode();
    }

    /**
     * 读取瞬移短距离模式值。
     * Reads the Instant Transmission short-mode value.
     */
    public int getInstantTransmissionShortMode() {
        return view.getInstantTransmissionShortMode();
    }

    /**
     * 读取瞬移短距离模式名称。
     * Reads the Instant Transmission short-mode name.
     */
    public String getInstantTransmissionShortModeName() {
        return view.getInstantTransmissionShortModeName();
    }

    /**
     * 读取瞬移环绕模式值。
     * Reads the Instant Transmission surround-mode value.
     */
    public int getInstantTransmissionSurroundMode() {
        return view.getInstantTransmissionSurroundMode();
    }

    /**
     * 读取力量路线技能加成。
     * Reads the skill-based strength bonus.
     */
    public int getStrengthSkillBonus() {
        return view.getStrengthSkillBonus();
    }

    /**
     * 读取敏捷路线技能加成。
     * Reads the skill-based dexterity bonus.
     */
    public int getDexteritySkillBonus() {
        return view.getDexteritySkillBonus();
    }

}
