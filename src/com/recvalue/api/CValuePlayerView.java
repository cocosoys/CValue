package com.recvalue.api;

import com.recvalue.base.Base;
import com.recvalue.base.race.ArcosianRace;
import com.recvalue.base.race.HalfSaiyanRace;
import com.recvalue.base.race.HumanRace;
import com.recvalue.base.race.MajinRace;
import com.recvalue.base.race.NamekianRace;
import com.recvalue.base.race.SaiyanRace;
import com.recvalue.util.SkinUtil;
import com.recvalue.util.Util;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 面向单个玩家的 CValue 读取视图。
 * Player-scoped facade that exposes race-aware CValue reads.
 */
public final class CValuePlayerView {
    /**
     * 当前正在读取的玩家对象。
     * Player being inspected.
     */
    protected final EntityPlayer entityPlayer;

    /**
     * 缓存的种族感知数据包装器。
     * Cached race-aware data wrapper.
     */
    protected Base baseData;

    /**
     * 为一个玩家创建读取视图。
     * Creates a view bound to one player.
     */
    public CValuePlayerView(EntityPlayer entityPlayer) {
        if (entityPlayer == null) {
            throw new IllegalArgumentException("entityPlayer must not be null");
        }
        this.entityPlayer = entityPlayer;
    }

    /**
     * 返回底层 Minecraft 玩家对象。
     * Returns the underlying Minecraft player instance.
     */
    public EntityPlayer entityPlayer() {
        return entityPlayer;
    }

    /**
     * 刷新底层缓存后的种族数据包装器。
     * Rebuilds the cached race-aware data wrapper from the current player state.
     */
    public CValuePlayerView refresh() {
        baseData = Util.getRacePlayerNBT(entityPlayer);
        return (CValuePlayerView)this;
    }

    /**
     * 解析并缓存种族感知数据包装器。
     * Resolves and caches the race-aware data wrapper.
     */
    public Base raceData() {
        if (baseData == null) {
            baseData = Util.getRacePlayerNBT(entityPlayer);
        }
        return baseData;
    }

    /**
     * 以 HumanRace 视图返回当前玩家。
     * Returns the current player as a HumanRace view.
     */
    public HumanRace humanRace() {
        return expectRaceData(HumanRace.class, HumanRace.RaceID, "Human");
    }

    /**
     * 以 SaiyanRace 视图返回当前玩家。
     * Returns the current player as a SaiyanRace view.
     */
    public SaiyanRace saiyanRace() {
        return expectRaceData(SaiyanRace.class, SaiyanRace.RaceID, "Saiyan");
    }

    /**
     * 以 HalfSaiyanRace 视图返回当前玩家。
     * Returns the current player as a HalfSaiyanRace view.
     */
    public HalfSaiyanRace halfSaiyanRace() {
        return expectRaceData(HalfSaiyanRace.class, HalfSaiyanRace.RaceID, "Half-Saiyan");
    }

    /**
     * 以 NamekianRace 视图返回当前玩家。
     * Returns the current player as a NamekianRace view.
     */
    public NamekianRace namekianRace() {
        return expectRaceData(NamekianRace.class, NamekianRace.RaceID, "Namekian");
    }

    /**
     * 以 ArcosianRace 视图返回当前玩家。
     * Returns the current player as an ArcosianRace view.
     */
    public ArcosianRace arcosianRace() {
        return expectRaceData(ArcosianRace.class, ArcosianRace.RaceID, "Arcosian");
    }

    /**
     * 以 MajinRace 视图返回当前玩家。
     * Returns the current player as a MajinRace view.
     */
    public MajinRace majinRace() {
        return expectRaceData(MajinRace.class, MajinRace.RaceID, "Majin");
    }

    /**
     * 确保当前缓存对象同时匹配预期种族 id 和包装类。
     * Ensures the cached wrapper matches both the expected race id and wrapper type.
     */
    protected <T extends Base> T expectRaceData(Class<T> raceType, int raceId, String raceName) {
        Base data = raceData();
        if (!raceType.isInstance(data) || data.getRace() != raceId) {
            throw new IllegalStateException("entityPlayer is not " + raceName);
        }
        return raceType.cast(data);
    }




    /**
     * 读取玩家等级。
     * Reads the player level.
     */
    public int getLevel() {
        return raceData().getLevel();
    }
    /**
     * 读取距离下一级还差多少属性点。
     * Reads how many attribute points remain until the next level.
     */
    public int getLevelNext() {
        return raceData().getLevelNext();
    }
    /**
     * 读取玩家最大气值。
     * Reads the player's maximum Ki value.
     */
    public int getMaxKi() {
        return raceData().getMaxKi();
    }
    /**
     * 读取玩家最大体魄值。
     * Reads the player's maximum body value.
     */
    public int getMaxBody() {
        return raceData().getMaxBody();
    }
    /**
     * 读取玩家最大耐力值。
     * Reads the player's maximum stamina value.
     */
    public int getMaxStamina() {
        return raceData().getMaxStamina();
    }
    /**
     * 读取当前近战输出。
     * Reads the current melee output.
     */
    public int getMelee() {
        return raceData().getMelee();
    }
    /**
     * 读取当前体魄强度值。
     * Reads the current body-strength value.
     */
    public int getBodyStrength() {
        return raceData().getBodyStrength();
    }
    /**
     * 读取当前装备负重值。
     * Reads the current carried-item weight value.
     */
    public float getItemWeight() {
        return raceData().getItemWeight();
    }
    /**
     * 读取角色体重权重值。
     * Reads the computed body-weight value.
     */
    public float getBodyWeight() {
        return raceData().getBodyWeight();
    }
    /**
     * 读取额外负重值。
     * Reads the extra carried-weight value.
     */
    public float getExtraWeight() {
        return raceData().getExtraWeight();
    }
    /**
     * 读取由体魄强度推导出的被动防御。
     * Reads the passive-defense value derived from body strength.
     */
    public int getPassive() {
        return raceData().getPassive();
    }
    /**
     * 读取当前气功输出。
     * Reads the current Ki damage output.
     */
    public int getKiPower() {
        return raceData().getKiPower();
    }
    /**
     * 读取最大气功输出。
     * Reads the maximum Ki damage output.
     */
    public int getMaxKiPower() {
        return raceData().getMaxKiPower();
    }
    /**
     * 读取生命再生率数值。
     * Reads the body-regeneration stat value.
     */
    public int getBodyRegenRate() {
        return raceData().getBodyRegenRate();
    }
    /**
     * 读取耐力再生率数值。
     * Reads the stamina-regeneration stat value.
     */
    public int getStaminaRegenRate() {
        return raceData().getStaminaRegenRate();
    }
    /**
     * 读取气值再生率数值。
     * Reads the energy-regeneration stat value.
     */
    public int getEnergyRegenRate() {
        return raceData().getEnergyRegenRate();
    }
    /**
     * 读取当前奔跑速度值。
     * Reads the current running-speed value.
     */
    public int getRunning() {
        return raceData().getRunning();
    }
    /**
     * 读取当前飞行速度值。
     * Reads the current flying-speed value.
     */
    public int getFlying() {
        return raceData().getFlying();
    }
    /**
     * 读取推导后的伤害减免百分比。
     * Reads the derived damage-reduction percentage.
     */
    public int getDamageReduction() {
        return raceData().getDamageReduction();
    }
    /**
     * 读取扣除技能槽消耗后的可用精神。
     * Reads the currently available mind after skill-slot costs.
     */
    public int getAvailableMind() {
        return raceData().getAvailableMind();
    }
    /**
     * 读取当前生命值。
     * Reads the current body/health value.
     */
    public int getCurrentBody() {
        return raceData().getCurrentBody();
    }
    /**
     * 读取当前气值。
     * Reads the current energy/Ki value.
     */
    public int getCurrentEnergy() {
        return raceData().getCurrentEnergy();
    }
    /**
     * 读取当前耐力值。
     * Reads the current stamina value.
     */
    public int getCurrentStamina() {
        return raceData().getCurrentStamina();
    }
    /**
     * 读取当前生命百分比。
     * Reads the current body/health percentage.
     */
    public float getCurrentBodyPercentage() {
        return raceData().getCurrentBodyPercentage();
    }
    /**
     * 读取当前气值百分比。
     * Reads the current energy/Ki percentage.
     */
    public float getCurrentEnergyPercentage() {
        return raceData().getCurrentEnergyPercentage();
    }
    /**
     * 读取当前耐力百分比。
     * Reads the current stamina percentage.
     */
    public float getCurrentStaminaPercentage() {
        return raceData().getCurrentStaminaPercentage();
    }
    /**
     * 读取当前释放百分比。
     * Reads the current release percentage.
     */
    public int getRelease() {
        return raceData().getCurrentRelease();
    }
    /**
     * 读取冰冻恶魔的储备值。
     * Reads the current Arcosian reserve value.
     */
    public int getArcReserve() {
        return raceData().getArcReserve();
    }
    /**
     * 读取当前属性点数。
     * Reads the current attribute-point value.
     */
    public int getAttributePoints() {
        return raceData().getAttributePoints();
    }
    /**
     * 读取善阵营击杀数。
     * Reads the good-alignment kill count.
     */
    public int getGoodKillCount() {
        return raceData().getGoodKillCount();
    }
    /**
     * 读取中立阵营击杀数。
     * Reads the neutral-alignment kill count.
     */
    public int getNeutralKillCount() {
        return raceData().getNeutralKillCount();
    }
    /**
     * 读取恶阵营击杀数。
     * Reads the evil-alignment kill count.
     */
    public int getEvilKillCount() {
        return raceData().getEvilKillCount();
    }
    /**
     * 读取上次造成伤害值。
     * Reads the last recorded damage dealt.
     */
    public int getLastDamageDealt() {
        return raceData().getLastDamageDealt();
    }
    /**
     * 读取上次受到伤害值。
     * Reads the last recorded damage received.
     */
    public int getLastDamageReceived() {
        return raceData().getLastDamageReceived();
    }
    /**
     * 判断是否为气体系玩家。
     * Returns whether the player is using the Ki power type.
     */
    public boolean isKiUser() {
        return raceData().isKiUser();
    }
    /**
     * 判断 Ki Fist 设置位是否已启用。
     * Returns whether the Ki Fist setting flag is enabled.
     */
    public boolean isKiFistSettingEnabled() {
        return raceData().isKiFistSettingEnabled();
    }
    /**
     * 判断 Ki Protection 设置位是否已启用。
     * Returns whether the Ki Protection setting flag is enabled.
     */
    public boolean isKiProtectionSettingEnabled() {
        return raceData().isKiProtectionSettingEnabled();
    }
    /**
     * 读取总击杀数。
     * Reads the total kill count across alignments.
     */
    public int getTotalKillCount() {
        return raceData().getTotalKillCount();
    }
    /**
     * 读取指定属性的起始值。
     * Reads the starting value of the given attribute.
     */
    public int getStartAttribute(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getStartAttributes(attribute.index());
    }
    /**
     * 读取指定属性在派生公式中使用的有效值。
     * Reads the effective attribute value used by derived formulas.
     */
    public int getAdditionAttribute(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAdditionAttribute(attribute.index());
    }
    /**
     * 读取属性对应的负重倍率。
     * Reads the weight multiplier applied to the given attribute lane.
     */
    public float getWeightMultiplier(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getWeightMultiplier(attribute.index());
    }
    /**
     * 读取当前有效属性快照。
     * Reads a snapshot of the resolved current attributes.
     */
    public int[] getResolvedAttributes() {
        return raceData().getResolvedAttributeSnapshot();
    }
    /**
     * 读取基础属性快照。
     * Reads a snapshot of the base attributes.
     */
    public int[] getBaseAttributes() {
        return raceData().getBaseAttributeSnapshot();
    }
    /**
     * 读取最大体魄强度。
     * Reads the maximum body-strength value.
     */
    public int getMaxBodyStrength() {
        return raceData().getMaxBodyStrength();
    }
    /**
     * 读取精神属性派生值。
     * Reads the derived spirit-stat value.
     */
    public int getSpiritStat() {
        return raceData().getStatSPI();
    }
    /**
     * 读取技能槽总精神消耗。
     * Reads the total mind requirement consumed by equipped skills.
     */
    public int getSpentMindRequirement() {
        return raceData().getSpentMindRequirement();
    }
    /**
     * 按枚举读取当前有效属性值。
     * Reads a resolved current attribute value by enum.
     */
    public int getAttribute(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeValue(attribute.index());
    }
    /**
     * 按枚举读取持久化基础属性值。
     * Reads a persisted/base attribute value by enum.
     */
    public int getBaseAttribute(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getBaseAttributeValue(attribute.index());
    }
    /**
     * 读取属性显示名称。
     * Reads the attribute display name.
     */
    public String getAttributeName(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeName(attribute.index());
    }
    /**
     * 读取属性说明文本。
     * Reads the attribute description text.
     */
    public String getAttributeDescription(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeDescription(attribute.index());
    }
    /**
     * 读取当前力量体系下的属性名称数组。
     * Reads the attribute-name array for the current power type.
     */
    public String[] getAttributeNames() {
        return raceData().getAttributeNames();
    }
    /**
     * 读取当前力量体系下的属性说明数组。
     * Reads the attribute-description array for the current power type.
     */
    public String[] getAttributeDescriptions() {
        return raceData().getAttributeDescriptions();
    }


    /**
     * 读取种族技能等级。
     * Reads the current racial-skill level.
     */
    public int getRacialSkillLevel() {
        return raceData().getSkillXLevel();
    }
    /**
     * 读取 Mystic 技能等级。
     * Reads the current Mystic skill level.
     */
    public int getMysticSkillLevel() {
        return raceData().getMysticSkillLevel();
    }
    /**
     * 读取当前力量体系下的技能等级。
     * Reads one skill level using the player's current power type.
     */
    public int getSkillLevel(int skillIndex) {
        return raceData().getCurrentPowerSkillLevel(skillIndex);
    }
    /**
     * 读取 DBC 技能表中的技能等级。
     * Reads one skill level from the DBC skill catalog.
     */
    public int getDbcSkillLevel(int skillIndex) {
        return raceData().getDbcSkillLevel(skillIndex);
    }
    /**
     * 读取 NC 技能表中的技能等级。
     * Reads one skill level from the NC skill catalog.
     */
    public int getNCSkillLevel(int skillIndex) {
        return raceData().getNCSkillLevel(skillIndex);
    }
    /**
     * 读取种族技能槽原始数据。
     * Reads the raw racial skill-slot payload.
     */
    public String getRacialSkillSlot() {
        return raceData().getRacialSkillSlot();
    }
    /**
     * 读取核心技能槽原始数据。
     * Reads the raw core skill-slot payload.
     */
    public String getCoreSkillSlot() {
        return raceData().getCoreSkillSlot();
    }
    /**
     * 读取已学习技能的原始字符串。
     * Reads the raw learned-skills payload string.
     */
    public String getLearnedSkillsRaw() {
        return raceData().getLearnedSkillsRaw();
    }
    /**
     * 读取已学习技能数组。
     * Reads the learned-skills array.
     */
    public String[] getLearnedSkills() {
        String[] learnedSkills = raceData().getLearnedSkills();
        return learnedSkills == null ? new String[0] : learnedSkills.clone();
    }
    /**
     * 读取指定索引的已学习技能条目。
     * Reads the learned-skill entry at the given index.
     */
    public String getLearnedSkillAt(int index) {
        return raceData().getLearnedSkillAt(index);
    }
    /**
     * 读取包含指定片段的已学习技能条目数组。
     * Reads the learned-skill entries containing the given token.
     */
    public String[] getLearnedSkillsContaining(String skillToken) {
        return raceData().getLearnedSkillsContaining(skillToken);
    }
    /**
     * 读取已学习技能数量。
     * Reads the number of learned-skill entries.
     */
    public int getLearnedSkillCount() {
        return raceData().getLearnedSkillCount();
    }
    /**
     * 判断是否存在已学习技能条目。
     * Returns whether at least one learned-skill entry exists.
     */
    public boolean hasLearnedSkills() {
        return raceData().hasLearnedSkills();
    }
    /**
     * 判断原始技能条目中是否包含指定片段。
     * Returns whether the learned-skill payload contains the given token.
     */
    public boolean hasLearnedSkillToken(String skillToken) {
        return raceData().hasLearnedSkillToken(skillToken);
    }
    /**
     * 读取属性 bonus 原始字符串。
     * Reads the raw bonus-attribute payload for the given attribute.
     */
    public String getAttributeBonusRaw(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusRaw(attribute.index());
    }
    /**
     * 判断指定属性是否存在 bonus 数据。
     * Returns whether the given attribute currently has bonus-attribute data.
     */
    public boolean hasAttributeBonus(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().hasAttributeBonus(attribute.index());
    }
    /**
     * 读取指定属性的 bonus 条目数组。
     * Returns the parsed bonus-attribute entries for the given attribute.
     */
    public String[] getAttributeBonusEntries(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusEntries(attribute.index());
    }
    /**
     * 读取指定属性 bonus 的名称数组。
     * Reads the bonus-name array for the given attribute.
     */
    public String[] getAttributeBonusNames(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusNames(attribute.index());
    }
    /**
     * 读取指定属性 bonus 的表达式数组。
     * Reads the bonus-expression array for the given attribute.
     */
    public String[] getAttributeBonusExpressions(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusExpressions(attribute.index());
    }
    /**
     * 读取指定属性 bonus 的运算符数组。
     * Reads the bonus-operator array for the given attribute.
     */
    public String[] getAttributeBonusOperators(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusOperators(attribute.index());
    }
    /**
     * 读取指定属性 bonus 的数值数组。
     * Reads the numeric bonus-value array for the given attribute.
     */
    public double[] getAttributeBonusNumericValues(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusNumericValues(attribute.index());
    }
    /**
     * 读取指定属性的 bonus 条目数量。
     * Returns the number of bonus-attribute entries for the given attribute.
     */
    public int getAttributeBonusEntryCount(CValueAttribute attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException("attribute must not be null");
        }
        return raceData().getAttributeBonusEntryCount(attribute.index());
    }
    /**
     * 读取玩家设置槽位的当前值。
     * Reads the current value stored for the given player-setting slot.
     */
    public int getPlayerSettingValue(int settingIndex) {
        return raceData().getPlayerSettingValue(settingIndex);
    }
    /**
     * 读取玩家设置枚举对应槽位的当前值。
     * Reads the current value stored for the given player-setting enum.
     */
    public int getPlayerSettingValue(CValuePlayerSetting setting) {
        return raceData().getPlayerSettingValue(setting);
    }
    /**
     * 判断指定玩家设置槽位是否已启用。
     * Returns whether the given player-setting slot is enabled/present.
     */
    public boolean hasPlayerSetting(int settingIndex) {
        return raceData().hasPlayerSetting(settingIndex);
    }
    /**
     * 判断玩家设置枚举对应槽位是否已启用。
     * Returns whether the given player-setting enum is enabled/present.
     */
    public boolean hasPlayerSetting(CValuePlayerSetting setting) {
        return raceData().hasPlayerSetting(setting);
    }
    /**
     * 返回当前已启用的已知玩家设置列表。
     * Returns the currently enabled known player-setting list.
     */
    public CValuePlayerSetting[] getEnabledKnownPlayerSettings() {
        return raceData().getEnabledKnownPlayerSettings();
    }
    /**
     * 判断 Ki Weapon 设置位是否已启用。
     * Returns whether the Ki Weapon setting flag is enabled.
     */
    public boolean hasKiWeaponSetting() {
        return raceData().hasKiWeaponSetting();
    }
    /**
     * 读取 Ki Weapon 模式值。
     * Reads the Ki Weapon mode value.
     */
    public int getKiWeaponMode() {
        return raceData().getKiWeaponMode();
    }
    /**
     * 读取 Ki Weapon 模式名称。
     * Reads the Ki Weapon mode name.
     */
    public String getKiWeaponModeName() {
        return raceData().getKiWeaponModeName();
    }
    /**
     * 判断当前 Ki Weapon 是否为剑模式。
     * Returns whether the current Ki Weapon mode is sword mode.
     */
    public boolean isKiWeaponSwordMode() {
        return raceData().isKiWeaponSwordMode();
    }
    /**
     * 判断当前 Ki Weapon 是否为镰刀模式。
     * Returns whether the current Ki Weapon mode is scythe mode.
     */
    public boolean isKiWeaponScytheMode() {
        return raceData().isKiWeaponScytheMode();
    }
    /**
     * 读取瞬移短距离模式值。
     * Reads the Instant Transmission short-mode value.
     */
    public int getInstantTransmissionShortMode() {
        return raceData().getInstantTransmissionShortMode();
    }
    /**
     * 读取瞬移短距离模式名称。
     * Reads the Instant Transmission short-mode name.
     */
    public String getInstantTransmissionShortModeName() {
        return raceData().getInstantTransmissionShortModeName();
    }
    /**
     * 读取瞬移环绕模式值。
     * Reads the Instant Transmission surround-mode value.
     */
    public int getInstantTransmissionSurroundMode() {
        return raceData().getInstantTransmissionSurroundMode();
    }
    /**
     * 读取瞬移环绕模式名称。
     * Reads the Instant Transmission surround-mode name.
     */
    public String getInstantTransmissionSurroundModeName() {
        return raceData().getInstantTransmissionSurroundModeName();
    }
    /**
     * 读取力量路线技能加成。
     * Reads the skill-based strength bonus.
     */
    public int getStrengthSkillBonus() {
        return raceData().getSTRSklks();
    }
    /**
     * 读取敏捷路线技能加成。
     * Reads the skill-based dexterity bonus.
     */
    public int getDexteritySkillBonus() {
        return raceData().getDEXSklks();
    }


    /**
     * 读取当前力量体系 id。
     * Reads the current power-type id.
     */
    public int getPowerType() {
        return raceData().getPowerType();
    }
    /**
     * 读取当前种族 id。
     * Reads the current race id.
     */
    public int getRaceId() {
        return raceData().getRace();
    }
    /**
     * 读取当前职业 id。
     * Reads the current class id.
     */
    public int getClassId() {
        return raceData().getClassId();
    }
    /**
     * 读取当前主形态状态值。
     * Reads the current primary form state value.
     */
    public int getState() {
        return raceData().getCurrentState();
    }
    /**
     * 读取当前副形态状态值。
     * Reads the current secondary form state value.
     */
    public int getState2() {
        return raceData().getCurrentState2();
    }
    /**
     * 读取原始状态效果字符串。
     * Reads the raw status-effect payload string.
     */
    public String getStatusEffectsRaw() {
        return raceData().getStatusEffectsRaw();
    }
    /**
     * 读取融合原始数据字符串。
     * Reads the raw fusion payload string.
     */
    public String getFusionRaw() {
        return raceData().getFusionRaw();
    }
    /**
     * 判断是否存在可解析的融合数据。
     * Returns whether parseable fusion data is currently present.
     */
    public boolean hasFusionData() {
        return raceData().hasFusionData();
    }
    /**
     * 读取融合参与者名称数组。
     * Reads the fusion participant-name array.
     */
    public String[] getFusionParticipants() {
        return raceData().getFusionParticipants();
    }
    /**
     * 读取第一个融合参与者名称。
     * Reads the first fusion participant name.
     */
    public String getFusionParticipantA() {
        return raceData().getFusionParticipantA();
    }
    /**
     * 读取第二个融合参与者名称。
     * Reads the second fusion participant name.
     */
    public String getFusionParticipantB() {
        return raceData().getFusionParticipantB();
    }
    /**
     * 读取融合参与者数量。
     * Reads the number of fusion participants.
     */
    public int getFusionParticipantCount() {
        return raceData().getFusionParticipantCount();
    }
    /**
     * 读取融合计时值。
     * Reads the fusion timer value.
     */
    public int getFusionTimer() {
        return raceData().getFusionTimer();
    }
    /**
     * 读取攻击计时值。
     * Reads the attack timer value.
     */
    public int getAttackTimer() {
        return raceData().getAttackTimer();
    }
    /**
     * 读取最近被攻击玩家计时值。
     * Reads the last-attacked-player timer value.
     */
    public int getLastAttackedPlayerTimer() {
        return raceData().getLastAttackedPlayerTimer();
    }
    /**
     * 读取最近被攻击玩家原始标识字符串。
     * Reads the raw last-attacked-player identifier.
     */
    public String getLastAttackedPlayerRaw() {
        return raceData().getLastAttackedPlayerRaw();
    }
    /**
     * 读取最近被攻击玩家标识。
     * Reads the last-attacked-player identifier.
     */
    public String getLastAttackedPlayerId() {
        return raceData().getLastAttackedPlayerId();
    }
    /**
     * 读取 Senzu 冷却值。
     * Reads the Senzu cooldown value.
     */
    public int getSenzuCooldown() {
        return raceData().getSenzuCooldown();
    }
    /**
     * 判断 Senzu 是否仍在冷却中。
     * Returns whether the Senzu cooldown is still active.
     */
    public boolean isSenzuOnCooldown() {
        return raceData().isSenzuOnCooldown();
    }
    /**
     * 读取难度保护计时值。
     * Reads the difficulty-reduction timer value.
     */
    public int getDifficultyReductionTicks() {
        return raceData().getDifficultyReductionTicks();
    }
    /**
     * 判断难度保护是否激活。
     * Returns whether difficulty protection is currently active.
     */
    public boolean isDifficultyReductionActive() {
        return raceData().isDifficultyReductionActive();
    }
    /**
     * 读取原始设置字符串。
     * Reads the raw settings payload string.
     */
    public String getSettingsRaw() {
        return raceData().getSettingsRaw();
    }
    /**
     * 读取当前训练点。
     * Reads the current training-point value.
     */
    public int getTrainingPoints() {
        return raceData().getTrainingPoints();
    }
    /**
     * 读取当前变身计量条值。
     * Reads the current transformation-meter value.
     */
    public int getTransformationMeter() {
        return raceData().getTransformationMeter();
    }
    /**
     * 读取当前阵营值。
     * Reads the current alignment value.
     */
    public int getAlignment() {
        return raceData().getAlignment();
    }
    /**
     * 读取当前 karma 值。
     * Reads the current karma value.
     */
    public int getKarma() {
        return raceData().getKarma();
    }
    /**
     * 读取当前经验进度值。
     * Reads the current experience-progress value.
     */
    public int getExperience() {
        return raceData().getExperience();
    }
    /**
     * 判断角色数据是否已完成接受/初始化。
     * Returns whether the character data has been accepted/initialized.
     */
    public boolean isCharacterAccepted() {
        return raceData().isCharacterAccepted();
    }
    /**
     * 读取当前难度值。
     * Reads the current difficulty value.
     */
    public int getDifficulty() {
        return raceData().getDifficulty();
    }
    /**
     * 读取当前难度名称。
     * Reads the current difficulty name.
     */
    public String getDifficultyName() {
        return raceData().getDifficultyName();
    }
    /**
     * 读取当前难度短名称。
     * Reads the current difficulty short name.
     */
    public String getDifficultyShortName() {
        return raceData().getDifficultyShortName();
    }
    /**
     * 读取当前难度说明 key。
     * Reads the current difficulty description key.
     */
    public String getDifficultyDescriptionKey() {
        return raceData().getDifficultyDescriptionKey();
    }
    /**
     * 读取死亡次数。
     * Reads the death count.
     */
    public int getDeathCount() {
        return raceData().getDeathCount();
    }
    /**
     * 读取重力训练值。
     * Reads the gravity-training value.
     */
    public int getGravityTraining() {
        return raceData().getGravityTraining();
    }
    /**
     * 读取 KO 倒计时。
     * Reads the KO timer value.
     */
    public int getKnockoutTimer() {
        return raceData().getKnockoutTimer();
    }
    /**
     * 读取自在极意功热量值。
     * Reads the Ultra Instinct heat value.
     */
    public int getUltraInstinctHeat() {
        return raceData().getUltraInstinctHeat();
    }
    /**
     * 读取自在极意功热量百分比。
     * Reads the Ultra Instinct heat percentage.
     */
    public float getUltraInstinctHeatPercentage() {
        return raceData().getUltraInstinctHeatPercentage();
    }
    /**
     * 读取临时 strain 值。
     * Reads the temporary strain value.
     */
    public int getStrainTemp() {
        return raceData().getStrainTemp();
    }
    /**
     * 读取当前 strain 值。
     * Reads the current strain value.
     */
    public int getStrain() {
        return raceData().getStrain();
    }
    /**
     * 读取 strain 激活计时值。
     * Reads the strain-active timer value.
     */
    public int getStrainActiveTicks() {
        return raceData().getStrainActiveTicks();
    }
    /**
     * 读取复活计时值。
     * Reads the revive-timer value.
     */
    public int getReviveTimer() {
        return raceData().getReviveTimer();
    }
    /**
     * 读取已达成的 UI 最高状态。
     * Reads the highest Ultra Instinct state reached.
     */
    public int getUIHighestStateReached() {
        return raceData().getUIHighestStateReached();
    }
    /**
     * 判断 UI 状态中是否记录过疼痛标记。
     * Returns whether the UI pain flag was recorded.
     */
    public boolean wasUIInPain() {
        return raceData().wasUIInPain();
    }
    /**
     * 读取 UI 疼痛持续值。
     * Reads the UI pain-duration value.
     */
    public int getUIWasInPainDuration() {
        return raceData().getUIWasInPainDuration();
    }
    /**
     * 读取 God strain 值。
     * Reads the God strain value.
     */
    public int getGodStrain() {
        return raceData().getGodStrain();
    }
    /**
     * 读取 God power 计时值。
     * Reads the God power timer value.
     */
    public int getGodPowerTimer() {
        return raceData().getGodPowerTimer();
    }
    /**
     * 读取 Mystic 计时值。
     * Reads the Mystic timer value.
     */
    public int getMysticTimer() {
        return raceData().getMysticTimer();
    }
    /**
     * 读取 pain 计时值。
     * Reads the pain timer value.
     */
    public int getPainTimer() {
        return raceData().getPainTimer();
    }
    /**
     * 读取自在极意功热量伤害值。
     * Reads the Ultra Instinct heat-damage value.
     */
    public double getUltraInstinctHeatDamage() {
        return raceData().getUltraInstinctHeatDamage();
    }
    /**
     * 读取当前重力值。
     * Reads the current gravity-force value.
     */
    public float getGravityForce() {
        return raceData().getGravityForce();
    }
    /**
     * 读取瞬间移动计时原始字符串。
     * Reads the raw instant-transmission timer payload.
     */
    public String getInstantTransmissionTimersRaw() {
        return raceData().getInstantTransmissionTimersRaw();
    }
    /**
     * 读取瞬间移动短计时值。
     * Reads the short instant-transmission timer value.
     */
    public int getInstantTransmissionShortTimer() {
        return raceData().getInstantTransmissionShortTimer();
    }
    /**
     * 读取瞬间移动长计时值。
     * Reads the long instant-transmission timer value.
     */
    public int getInstantTransmissionLongTimer() {
        return raceData().getInstantTransmissionLongTimer();
    }
    /**
     * 读取最近攻击者原始字符串。
     * Reads the raw last-attacker payload.
     */
    public String getLastAttackerRaw() {
        return raceData().getLastAttackerRaw();
    }
    /**
     * 读取最近攻击者名称。
     * Reads the last attacker name.
     */
    public String getLastAttackerName() {
        return raceData().getLastAttackerName();
    }
    /**
     * 读取最近攻击者时间戳。
     * Reads the last attacker epoch value.
     */
    public long getLastAttackerEpoch() {
        return raceData().getLastAttackerEpoch();
    }
    /**
     * 读取种族形态 mastery 的原始字符串。
     * Reads the raw racial-form mastery payload string.
     */
    public String getRacialFormMasteryRaw() {
        return raceData().getRacialFormMasteryRaw();
    }
    /**
     * 读取非种族形态 mastery 的原始字符串。
     * Reads the raw non-racial-form mastery payload string.
     */
    public String getNonRacialFormMasteryRaw() {
        return raceData().getNonRacialFormMasteryRaw();
    }
    /**
     * 读取魔人吸收数据原始字符串。
     * Reads the raw Majin absorption payload.
     */
    public String getMajinAbsorptionData() {
        return raceData().getMajinAbsorptionDataRaw();
    }
    /**
     * 读取当前种族名称。
     * Reads the current race name.
     */
    public String getRaceName() {
        return raceData().getRaceName();
    }
    /**
     * 读取当前职业名称。
     * Reads the current class name.
     */
    public String getClassName() {
        return raceData().getClassName();
    }
    /**
     * 读取当前力量体系名称。
     * Reads the current power-type name.
     */
    public String getPowerTypeName() {
        return raceData().getPowerTypeName();
    }
    /**
     * 读取当前力量体系说明 key。
     * Reads the current power-type description key.
     */
    public String getPowerTypeDescriptionKey() {
        return raceData().getPowerTypeDescriptionKey();
    }
    /**
     * 读取当前职业说明 key。
     * Reads the current class-description key.
     */
    public String getClassDescriptionKey() {
        return raceData().getClassDescriptionKey();
    }
    /**
     * 读取当前力量体系允许域名称。
     * Reads the current power-type allow-domain name.
     */
    public String getPowerTypeAllowName() {
        return raceData().getPowerTypeAllowName();
    }
    /**
     * 读取当前职业分类名称。
     * Reads the current class-group name.
     */
    public String getClassGroupName() {
        return raceData().getClassGroupName();
    }
    /**
     * 判断是否为自然体系玩家。
     * Returns whether the player is using the nature power type.
     */
    public boolean isNatureUser() {
        return raceData().isNatureUser();
    }
    /**
     * 判断是否为查克拉体系玩家。
     * Returns whether the player is using the Chakra power type.
     */
    public boolean isChakraUser() {
        return raceData().isChakraUser();
    }
    /**
     * 判断界王拳设置位是否已启用。
     * Returns whether the Kaioken setting flag is enabled.
     */
    public boolean isKaiokenSettingEnabled() {
        return raceData().isKaiokenSettingEnabled();
    }
    /**
     * 判断 Mystic 设置位是否已启用。
     * Returns whether the Mystic setting flag is enabled.
     */
    public boolean isMysticSettingEnabled() {
        return raceData().isMysticSettingEnabled();
    }
    /**
     * 判断自在极意功设置位是否已启用。
     * Returns whether the Ultra Instinct setting flag is enabled.
     */
    public boolean isUltraInstinctSettingEnabled() {
        return raceData().isUltraInstinctSettingEnabled();
    }
    /**
     * 判断破坏神设置位是否已启用。
     * Returns whether the God of Destruction setting flag is enabled.
     */
    public boolean isGodOfDestructionSettingEnabled() {
        return raceData().isGodOfDestructionSettingEnabled();
    }
    /**
     * 判断闪避/疾冲设置位是否已启用。
     * Returns whether the Dodge/Swoop setting flag is enabled.
     */
    public boolean isDodgeSwoopSettingEnabled() {
        return raceData().isDodgeSwoopSettingEnabled();
    }
    /**
     * 判断融合设置位是否已启用。
     * Returns whether the Fusion setting flag is enabled.
     */
    public boolean isFusionSettingEnabled() {
        return raceData().isFusionSettingEnabled();
    }
    /**
     * 判断 Friendly Fist 设置位是否已启用。
     * Returns whether the Friendly Fist setting flag is enabled.
     */
    public boolean isFriendlyFistSettingEnabled() {
        return raceData().isFriendlyFistSettingEnabled();
    }
    /**
     * 读取阵营分类 id。
     * Reads the alignment category id.
     */
    public int getAlignmentCategory() {
        return raceData().getAlignmentCategory();
    }
    /**
     * 判断是否为善阵营。
     * Returns whether the player is in the good alignment group.
     */
    public boolean isGoodAlignment() {
        return raceData().isGoodAlignment();
    }
    /**
     * 判断是否为中立阵营。
     * Returns whether the player is in the neutral alignment group.
     */
    public boolean isNeutralAlignment() {
        return raceData().isNeutralAlignment();
    }
    /**
     * 判断是否为恶阵营。
     * Returns whether the player is in the evil alignment group.
     */
    public boolean isEvilAlignment() {
        return raceData().isEvilAlignment();
    }
    /**
     * 读取皮肤代码。
     * Reads the player's DNS/skin code.
     */
    public String getSkinCode() {
        return raceData().getSkinCode();
    }
    /**
     * 读取发型代码。
     * Reads the player's hair code.
     */
    public String getHairCode() {
        return raceData().getHairCode();
    }
    /**
     * 读取 aura 外观代码。
     * Reads the player's aura-appearance code.
     */
    public String getAuraCode() {
        return raceData().getAuraCode();
    }
    /**
     * 读取 aura 颜色值。
     * Reads the aura-color value.
     */
    public int getAuraColor() {
        return raceData().getAuraColor();
    }
    /**
     * 读取训练点上限。
     * Reads the training-point cap.
     */
    public int getMaxTrainingPoints() {
        return raceData().getMaxTrainingPoints();
    }
    /**
     * 读取第一训练点限制值。
     * Reads the first training-point limit value.
     */
    public int getTrainingPointLimit() {
        return raceData().getTrainingPointLimit();
    }
    /**
     * 读取第二训练点限制值。
     * Reads the second training-point limit value.
     */
    public int getTrainingPointLimit2() {
        return raceData().getTrainingPointLimit2();
    }
    /**
     * 读取剩余愿望次数。
     * Reads the current wish count.
     */
    public int getWishes() {
        return raceData().getWishes();
    }
    /**
     * 读取龙球/神龙标记值。
     * Reads the dragon flag/count value.
     */
    public int getDragonCount() {
        return raceData().getDragonCount();
    }
    /**
     * 读取魔人吸收计时值。
     * Reads the Majin absorption timer value.
     */
    public int getMajinAbsorptionTimer() {
        return raceData().getMajinAbsorptionTimer();
    }
    /**
     * 读取魔人吸收值。
     * Reads the Majin absorption value.
     */
    public int getMajinAbsorptionValue() {
        return raceData().getMajinAbsorptionValue();
    }
    /**
     * 读取魔人吸收分段数组。
     * Reads the Majin absorption segments split by comma.
     */
    public String[] getMajinAbsorptionParts() {
        return raceData().getMajinAbsorptionParts();
    }
    /**
     * 读取指定索引的魔人吸收分段。
     * Reads the Majin absorption segment at the given index.
     */
    public String getMajinAbsorptionPart(int index) {
        return raceData().getMajinAbsorptionPart(index);
    }
    /**
     * 读取当前 Majin 形态 id。
     * Reads the current Majin form id.
     */
    public int getMajinFormId() {
        return raceData().getMajinFormId();
    }
    /**
     * 读取当前 Arcosian 形态 id。
     * Reads the current Arcosian form id.
     */
    public int getArcosianFormId() {
        return raceData().getArcosianFormId();
    }
    /**
     * 读取当前形态熟练度。
     * Reads the mastery value of the current form.
     */
    public double getCurrentFormMastery() {
        return raceData().getCurrentFormMastery();
    }
    /**
     * 读取完整 form mastery 数据字符串。
     * Reads the full form-mastery data payload.
     */
    public String getFormMasteryDataRaw() {
        return raceData().getFormMasteryDataRaw();
    }
    /**
     * 判断当前形态是否满足 mastery 要求。
     * Returns whether the current form satisfies its mastery requirements.
     */
    public boolean hasRequiredCurrentFormMasteries() {
        return raceData().hasRequiredCurrentFormMasteries();
    }
    /**
     * 判断指定形态是否满足 mastery 要求。
     * Returns whether the requested form satisfies its mastery requirements.
     */
    public boolean hasRequiredFormMasteries(String formName) {
        return raceData().hasRequiredFormMasteries(formName);
    }
    /**
     * 读取当前形态名称。
     * Reads the current form name.
     */
    public String getCurrentFormName() {
        return raceData().getCurrentFormName();
    }
    /**
     * 按形态名称返回当前种族上下文中的 form id。
     * Returns the form id for the given form name in the current race context.
     */
    public int getFormIdByName(String formName) {
        return raceData().getFormIdByName(formName);
    }
    /**
     * 读取当前形态 id。
     * Reads the current form id.
     */
    public int getCurrentFormId() {
        return raceData().getCurrentFormId();
    }
    /**
     * 判断当前是否处于指定形态。
     * Returns whether the player is currently in the requested form.
     */
    public boolean isCurrentForm(String formName) {
        return raceData().isCurrentForm(formName);
    }
    /**
     * 读取当前自在极意功等级。
     * Reads the current Ultra Instinct level.
     */
    public int getUltraInstinctLevel() {
        return raceData().getUltraInstinctLevel();
    }
    /**
     * 判断赛亚人是否处于 Full Power 分支。
     * Returns whether a Saiyan currently satisfies the Full Power branch.
     */
    public boolean isSaiyanSuperFullPower() {
        return raceData().isSaiyanSuperFullPower();
    }
    /**
     * 读取降阶时将回落到的形态 id。
     * Reads the form id used when descending from the current transformation.
     */
    public int getTransformationDescendFormId() {
        return raceData().getTransformationDescendFormId();
    }
    /**
     * 读取阵营名称。
     * Reads the alignment-group name.
     */
    public String getAlignmentName() {
        return raceData().getAlignmentName();
    }
    /**
     * 读取尾巴模式值。
     * Reads the tail-mode value.
     */
    public int getTailMode() {
        return raceData().getTailMode();
    }
    /**
     * 判断当前是否拥有尾巴。
     * Returns whether the current tail-mode indicates a tail is present.
     */
    public boolean hasTail() {
        return raceData().hasTail();
    }
    /**
     * 判断当前形态是否为种族形态。
     * Returns whether the current form is racial.
     */
    public boolean isCurrentFormRacial() {
        return raceData().isCurrentFormRacial();
    }
    /**
     * 判断当前形态是否为非种族形态。
     * Returns whether the current form is non-racial.
     */
    public boolean isCurrentFormNonRacial() {
        return raceData().isCurrentFormNonRacial();
    }
    /**
     * 读取阵营颜色值。
     * Reads the alignment color value.
     */
    public int getAlignmentColor() {
        return raceData().getAlignmentColor();
    }
    /**
     * 使用玩家当前皮肤代码创建外观辅助器。
     * Creates a skin helper from the player's current DNS code.
     */
    public SkinUtil skin() {
        return new SkinUtil(getSkinCode());
    }
    /**
     * 读取玩家当前种族形态的熟练度。
     * Reads the mastery value of the player's current racial form.
     */
    public double getRaceFormMastery() {
        return raceData().getRaceFormMastery();
    }
    /**
     * 读取指定形态名称的熟练度。
     * Reads the mastery value of a named form.
     */
    public double getFormMasteryValue(String formName) {
        return raceData().getFormMasteryValue(formName);
    }
    /**
     * 读取 Chakra 路线额外加成。
     * Reads the extra bonus used by Chakra routes.
     */
    public float getChakraBonus() {
        return raceData().getNCBonus();
    }
    /**
     * 检查指定状态效果 id 是否激活。
     * Checks whether the given status effect id is active.
     */
    public boolean hasStatusEffect(int effectId) {
        return raceData().hasStatusEffect(effectId);
    }
    /**
     * 检查指定状态效果枚举是否激活。
     * Checks whether the given status effect enum entry is active.
     */
    public boolean hasStatusEffect(CValueStatusEffect effect) {
        if (effect == null) {
            throw new IllegalArgumentException("effect must not be null");
        }
        return hasStatusEffect(effect.id());
    }
    /**
     * 按稳定 key 检查状态效果是否激活。
     * Checks whether the status effect identified by key is active.
     */
    public boolean hasStatusEffect(String effectKey) {
        return raceData().hasStatusEffect(effectKey);
    }
    /**
     * 返回当前已知且激活的状态效果列表。
     * Returns the currently active known status effects.
     */
    public CValueStatusEffect[] getKnownActiveStatusEffects() {
        ArrayList<CValueStatusEffect> activeEffects = new ArrayList<CValueStatusEffect>();
        for (CValueStatusEffect effect : CValueStatusEffect.values()) {
            if (hasStatusEffect(effect)) {
                activeEffects.add(effect);
            }
        }
        return activeEffects.toArray(new CValueStatusEffect[activeEffects.size()]);
    }
    /**
     * 返回当前已知且激活的状态效果 key 列表。
     * Returns the keys of the currently active known status effects.
     */
    public String[] getKnownActiveStatusEffectKeys() {
        CValueStatusEffect[] activeEffects = getKnownActiveStatusEffects();
        String[] keys = new String[activeEffects.length];
        for (int i = 0; i < activeEffects.length; i++) {
            keys[i] = activeEffects[i].key();
        }
        return keys;
    }
    /**
     * 返回当前已知且激活的状态效果数量。
     * Returns the count of currently active known status effects.
     */
    public int getKnownActiveStatusEffectCount() {
        return getKnownActiveStatusEffects().length;
    }
    /**
     * 判断是否存在已知且激活的状态效果。
     * Returns whether any known status effect is currently active.
     */
    public boolean hasKnownActiveStatusEffects() {
        return getKnownActiveStatusEffectCount() > 0;
    }
    /**
     * 返回当前已知且激活的状态效果 id 列表。
     * Returns the ids of the currently active known status effects.
     */
    public int[] getKnownActiveStatusEffectIds() {
        CValueStatusEffect[] activeEffects = getKnownActiveStatusEffects();
        int[] ids = new int[activeEffects.length];
        for (int i = 0; i < activeEffects.length; i++) {
            ids[i] = activeEffects[i].id();
        }
        return ids;
    }
    /**
     * 判断传说状态是否激活。
     * Returns whether the legendary status is active.
     */
    public boolean isLegendaryActive() {
        return raceData().isLegendaryActive();
    }
    /**
     * 判断魔化状态是否激活。
     * Returns whether the Majin status is active.
     */
    public boolean isMajinActive() {
        return raceData().isMajinActive();
    }
    /**
     * 判断界王拳状态是否激活。
     * Returns whether the Kaioken status is active.
     */
    public boolean isKaiokenActive() {
        return raceData().isKaiokenActive();
    }
    /**
     * 判断 Mystic 状态是否激活。
     * Returns whether the Mystic status is active.
     */
    public boolean isMysticActive() {
        return raceData().isMysticActive();
    }
    /**
     * 判断自在极意功状态是否激活。
     * Returns whether the Ultra Instinct status is active.
     */
    public boolean isUltraInstinctActive() {
        return raceData().isUltraInstinctActive();
    }
    /**
     * 判断破坏神状态是否激活。
     * Returns whether the God of Destruction status is active.
     */
    public boolean isGodOfDestructionActive() {
        return raceData().isGodOfDestructionActive();
    }
    /**
     * 判断融合状态是否激活。
     * Returns whether any fusion status is active.
     */
    public boolean isFusionActive() {
        return raceData().isFusionActive();
    }


    /**
     * 读取任务同步版本字符串。
     * Reads the mission-sync version string.
     */
    public String getMissionSyncVersion() {
        return raceData().getMissionSyncVersion();
    }
    /**
     * 读取当前任务同步原始字符串。
     * Reads the raw mission-sync payload string.
     */
    public String getMissionSyncData() {
        return raceData().getMissionSyncData();
    }
    /**
     * 读取任务条目数量。
     * Reads the number of mission/task entries.
     */
    public int getTaskCount() {
        return raceData().getTaskCount();
    }
    /**
     * 读取所有任务类型名称数组。
     * Reads the task-type array extracted from mission-sync data.
     */
    public String[] getTaskTypes() {
        return raceData().getTaskTypes();
    }
    /**
     * 判断是否存在指定任务类型。
     * Returns whether the requested task type exists in mission-sync data.
     */
    public boolean hasTaskType(String type) {
        return raceData().hasTaskType(type);
    }
    /**
     * 判断任务枚举对应类型是否存在。
     * Returns whether the requested task enum exists in mission-sync data.
     */
    public boolean hasTaskType(CValueTaskType taskType) {
        return raceData().hasTaskType(taskType);
    }
    /**
     * 读取剧情主线 id。
     * Reads the main saga id.
     */
    public int getSagaMainId() {
        return raceData().getSagaMainId();
    }
    /**
     * 读取剧情地组 id。
     * Reads the saga group id.
     */
    public int getSagaGroupId() {
        return raceData().getSagaGroupId();
    }
    /**
     * 读取剧情地组成员原始字符串。
     * Reads the raw saga group-member payload.
     */
    public String getSagaGroupMembersRaw() {
        return raceData().getSagaGroupMembersRaw();
    }
    /**
     * 读取剧情地组成员名称数组。
     * Reads the saga group-member array.
     */
    public String[] getSagaGroupMembers() {
        return raceData().getSagaGroupMembers();
    }
    /**
     * 读取剧情地组成员数量。
     * Reads the number of saga group members.
     */
    public int getSagaGroupMemberCount() {
        return raceData().getSagaGroupMemberCount();
    }
    /**
     * 判断当前是否处于剧情地组中。
     * Returns whether the player currently belongs to a saga group.
     */
    public boolean hasSagaGroup() {
        return raceData().hasSagaGroup();
    }
    /**
     * 读取剧情地组邀请原始字符串。
     * Reads the raw saga group-invite payload.
     */
    public String getSagaGroupInviteRaw() {
        return raceData().getSagaGroupInviteRaw();
    }
    /**
     * 判断当前是否存在剧情地组邀请。
     * Returns whether a saga group invite is currently present.
     */
    public boolean hasSagaGroupInvite() {
        return raceData().hasSagaGroupInvite();
    }
    /**
     * 读取指定类型的任务条目。
     * Reads the mission entry of the requested type.
     */
    public String[] getTask(String type) throws Exception {
        return raceData().getTask(type);
    }
    /**
     * 读取任务枚举对应的当前条目。
     * Reads the current task entry matching the requested task enum.
     */
    public String[] getTask(CValueTaskType taskType) throws Exception {
        return raceData().getTask(taskType);
    }
    /**
     * 读取当前 Dragon Block C 任务 id。
     * Reads the current Dragon Block C task id.
     */
    public String getTaskId() throws Exception {
        return raceData().getDragonBlockCTaskId();
    }
    /**
     * 读取当前 Dragon Block C 任务页码。
     * Reads the current Dragon Block C task page.
     */
    public String getTaskPage() throws Exception {
        return raceData().getDragonBlockCTaskPage();
    }
    /**
     * 读取指定索引的 Dragon Block C 任务目标。
     * Reads one indexed Dragon Block C task target.
     */
    public String getTaskTarget(int index) throws Exception {
        return raceData().getDragonBlockCTaskTarget(index);
    }
    /**
     * 读取当前 Dragon Block C 主线任务目标数量。
     * Reads the current Dragon Block C task target count.
     */
    public int getTaskTargetCount() throws Exception {
        return raceData().getDragonBlockCTaskTargetCount();
    }
    /**
     * 读取当前 Dragon Block C 主线任务目标数组。
     * Reads the current Dragon Block C task targets array.
     */
    public String[] getTaskTargets() throws Exception {
        return raceData().getDragonBlockCTaskTargets();
    }
    /**
     * 读取指定任务类型的原始条目字符串。
     * Reads the raw mission/task entry for the requested type.
     */
    public String getTaskEntryRaw(String type) throws Exception {
        return raceData().getTaskEntryRaw(type);
    }
    /**
     * 读取任务枚举对应类型的原始条目字符串。
     * Reads the raw mission/task entry for the requested task enum.
     */
    public String getTaskEntryRaw(CValueTaskType taskType) throws Exception {
        return raceData().getTaskEntryRaw(taskType);
    }
    /**
     * 读取指定任务类型的目标数量。
     * Reads the target count for the requested task type.
     */
    public int getTaskTargetCount(String type) throws Exception {
        return raceData().getTaskTargetCount(type);
    }
    /**
     * 读取任务枚举对应类型的目标数量。
     * Reads the target count for the requested task enum.
     */
    public int getTaskTargetCount(CValueTaskType taskType) throws Exception {
        return raceData().getTaskTargetCount(taskType);
    }
    /**
     * 读取指定任务类型的目标数组。
     * Reads the target array for the requested task type.
     */
    public String[] getTaskTargets(String type) throws Exception {
        return raceData().getTaskTargets(type);
    }
    /**
     * 读取任务枚举对应类型的目标数组。
     * Reads the target array for the requested task enum.
     */
    public String[] getTaskTargets(CValueTaskType taskType) throws Exception {
        return raceData().getTaskTargets(taskType);
    }
}
