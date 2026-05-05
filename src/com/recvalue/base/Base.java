package com.recvalue.base;

import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCGoD;
import JinRyuu.JRMCore.server.config.dbc.JGConfigDBCFormMastery;
import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
import com.recvalue.api.CValuePlayerSetting;
import com.recvalue.api.CValueTaskType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

/**
 * 核心的种族感知玩家数据包装器。
 * Core race-aware player data wrapper.
 *
 * <p>这个类负责维护共享的玩家上下文、通用派生数值，以及
 * JRMCore 在种族属性计算之后施加的公共后处理逻辑。
 * This class owns shared player context, common derived values, and the
 * post-processing that JRMCore applies after race-specific attribute resolution.</p>
 *
 * <p>具体种族只需要覆写 {@link #resolveAttributeValue(int)}，
 * 提供本种族的属性公式。
 * Concrete race classes only need to override
 * {@link #resolveAttributeValue(int)} with their own race formula.</p>
 */
public class Base {
    /**
     * 无法分派到具体种族时使用的默认种族名称。
     * Fallback race label used when no specific race wrapper is available.
     */
    public static final String RaceName = "Base";
    /**
     * 无法分派到具体种族时使用的默认种族 id。
     * Fallback race id used when no specific race wrapper is available.
     */
    public static final int RaceID = -1;

    /**
     * 当前正在读取数据的玩家对象。
     * Player whose values are being read.
     */
    public EntityPlayer entityPlayer;
    /**
     * 缓存的玩家 NBT 数据。
     * Cached player NBT data.
     */
    public NBTTagCompound entityNbt;
    /**
     * 从玩家 NBT 中读取到的持久化基础属性值。
     * Persisted/base attribute values read from the player NBT.
     */
    public int[] NBTAttributes;
    /**
     * 经过种族计算后的当前有效属性值。
     * Fully resolved current attribute values after race-specific logic.
     */
    public int[] Attributes;

    /**
     * 创建包装器，但不立即加载 NBT。
     * Creates a wrapper without immediately loading NBT data.
     */
    public Base(EntityPlayer entityPlayer) {
        this.entityPlayer = entityPlayer;
    }

    /**
     * 创建包装器，并按需要预加载 NBT 相关数据。
     * Creates a wrapper and optionally preloads NBT-backed values.
     */
    public Base(EntityPlayer entityPlayer, boolean getNBT) {
        this.entityPlayer = entityPlayer;
        if (getNBT) {
            connectBaseNBT();
        }
    }

    /**
     * 从玩家对象重新读取并刷新缓存的 NBT 与属性快照。
     * Refreshes the cached NBT and attribute snapshots from the player.
     */
    public void connectBaseNBT() {
        entityNbt = JRMCoreH.nbt(entityPlayer, "pres");
        NBTAttributes = JRMCoreH.PlyrAttrbts(entityPlayer);
        Attributes = resolveAttributes();
    }

    /**
     * 返回缓存的玩家 NBT；如果尚未加载则先加载。
     * Returns the cached player NBT, loading it first if needed.
     */
    public NBTTagCompound getEntityNbt() {
        ensureConnected();
        return entityNbt;
    }

    /**
     * 返回玩家当前解析后的有效属性数组。
     * Returns current resolved attributes for the player.
     */
    public int[] getAttributes() {
        ensureConnected();
        Attributes = resolveAttributes();
        return Attributes;
    }

    /**
     * 根据持久化属性计算当前玩家等级。
     * Returns the current player level computed from persisted attributes.
     */
    public int getLevel() {
        ensureConnected();
        return JRMCoreH.attrLvl(NBTAttributes);
    }

    /**
     * 返回距离下一级还差多少属性点。
     * Returns how many attribute points remain until the next level.
     */
    public int getLevelNext() {
        ensureConnected();
        if (getLevel() >= JRMCoreH.attrLvl(JRMCoreConfig.tmx * 6)) {
            return 0;
        }
        return JRMCoreH.attrLvlNext(NBTAttributes);
    }

    /**
     * 返回某个属性在角色创建时的起始值。
     * Returns the race/class-specific starting value of one attribute.
     */
    public int getStartAttributes(int attributeIndex) {
        if (attributeIndex < 0 || attributeIndex > 5) {
            return 0;
        }
        return JRMCoreH.attributeStart(getPowerType(), attributeIndex, getRace(), getClassId());
    }

    /**
     * 返回玩家当前最大气值容量。
     * Returns the maximum Ki capacity.
     */
    public int getEnergyMax() {
        ensureConnected();
        return JRMCoreH.stat(
            entityPlayer,
            5,
            getPowerType(),
            5,
            NBTAttributes[5],
            getRace(),
            getClassId(),
            JRMCoreH.SklLvl_KiBs(entityPlayer, getPowerType())
        );
    }

    /**
     * 兼容旧命名的最大气值读取入口。
     * Returns the maximum Ki capacity using the shorter legacy naming.
     */
    public int getMaxKi() {
        return getEnergyMax();
    }

    /**
     * 返回某个属性槽位在计算中使用的有效值。
     * Returns the effective attribute value used for one stat lane.
     */
    public int getAdditionAttribute(int attributeIndex) {
        ensureConnected();
        if (attributeIndex < 0 || attributeIndex >= NBTAttributes.length) {
            return 0;
        }
        switch (attributeIndex) {
            case 2:
            case 4:
            case 5:
                return NBTAttributes[attributeIndex];
            default:
                return Attributes[attributeIndex];
        }
    }

    /**
     * 返回属性对应的负重倍率。
     * Returns the weight multiplier applied to the given attribute lane.
     */
    public float getWeightMultiplier(int attributeIndex) {
        ensureConnected();
        if (attributeIndex < 0 || attributeIndex >= NBTAttributes.length) {
            return 0.0F;
        }
        return JRMCoreH.weightPerc(attributeIndex, entityPlayer);
    }

    /**
     * 返回推导后的伤害减免百分比。
     * Returns the derived damage-reduction percentage.
     */
    public int getDamageReduction() {
        ensureConnected();
        int baseCon = Math.max(1, NBTAttributes[2]);
        double ratio = 1.0D;
        int powerType = getPowerType();
        if (powerType > 0 && powerType != 3) {
            ratio = Math.max(Attributes[2], baseCon) / (double) baseCon;
        }
        return (int) ((1.0D - 1.0D / ratio) * 100.0D);
    }

    /**
     * 按索引读取一个当前有效属性值。
     * Returns one resolved current attribute value by index.
     */
    public int getAttributeValue(int attributeIndex) {
        ensureConnected();
        if (attributeIndex < 0 || attributeIndex >= Attributes.length) {
            return 0;
        }
        return Attributes[attributeIndex];
    }

    /**
     * 按索引读取一个持久化基础属性值。
     * Returns one persisted/base attribute value by index.
     */
    public int getBaseAttributeValue(int attributeIndex) {
        ensureConnected();
        if (attributeIndex < 0 || attributeIndex >= NBTAttributes.length) {
            return 0;
        }
        return NBTAttributes[attributeIndex];
    }

    /**
     * 返回当前有效属性快照。
     * Returns a snapshot of the resolved current attributes.
     */
    public int[] getResolvedAttributeSnapshot() {
        return getAttributes().clone();
    }

    /**
     * 返回持久化基础属性快照。
     * Returns a snapshot of the persisted base attributes.
     */
    public int[] getBaseAttributeSnapshot() {
        ensureConnected();
        return NBTAttributes.clone();
    }

    /**
     * 返回玩家最大耐力值。
     * Returns the maximum stamina value.
     */
    public int getMaxStamina() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, 2, getPowerType(), 3, NBTAttributes[2], getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回玩家最大体魄值。
     * Returns the maximum body value.
     */
    public int getMaxBody() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, 2, getPowerType(), 2, NBTAttributes[2], getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回玩家当前种族形态的熟练度。
     * Returns the mastery value of the player's current racial form.
     */
    public double getRaceFormMastery() {
        ensureConnected();
        int powerType = getPowerType();
        if (!JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType)) {
            return 0.0D;
        }
        return JRMCoreH.getFormMasteryValue(
            entityPlayer,
            getRace(),
            JRMCoreH.getInt(entityPlayer, "jrmcState"),
            JRMCoreH.getInt(entityPlayer, "jrmcState2"),
            hasStatusEffect(5),
            hasStatusEffect(13),
            hasStatusEffect(19),
            hasStatusEffect(20)
        );
    }

    /**
     * 返回指定形态名称的熟练度。
     * Returns the mastery value of a named form.
     */
    public double getFormMasteryValue(String formName) {
        ensureConnected();
        int powerType = getPowerType();
        if (!JGConfigDBCFormMastery.FM_Enabled && JRMCoreH.isPowerTypeKi(powerType)) {
            return 0.0D;
        }
        return JRMCoreH.getFormMasteryValue(entityPlayer, JRMCoreH.getFormID(formName, getRace()));
    }

    /**
     * 返回当前形态的熟练度。
     * Returns the mastery value of the current form.
     */
    public double getCurrentFormMastery() {
        return getRaceFormMastery();
    }

    /**
     * 返回完整 form mastery 数据字符串。
     * Returns the full form-mastery data payload.
     */
    public String getFormMasteryDataRaw() {
        ensureConnected();
        return JRMCoreH.getFormMasteryData(entityPlayer);
    }

    /**
     * 判断当前形态是否满足 mastery 要求。
     * Returns whether the current form satisfies its mastery requirements.
     */
    public boolean hasRequiredCurrentFormMasteries() {
        ensureConnected();
        return JRMCoreH.hasRequiredFormMasteries2(
            entityPlayer,
            getFormMasteryDataRaw(),
            getRace(),
            getCurrentState(),
            getCurrentState2(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 判断指定形态是否满足 mastery 要求。
     * Returns whether the requested form satisfies its mastery requirements.
     */
    public boolean hasRequiredFormMasteries(String formName) {
        ensureConnected();
        if (formName == null || formName.isEmpty()) {
            return false;
        }
        return JRMCoreH.hasRequiredFormMasteries(
            entityPlayer,
            getFormMasteryDataRaw(),
            getRace(),
            formName,
            false
        );
    }

    /**
     * 返回当前生命值。
     * Returns the current body/health value.
     */
    public int getCurrentBody() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcBdy");
    }

    /**
     * 返回当前气值。
     * Returns the current energy/Ki value.
     */
    public int getCurrentEnergy() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcEnrgy");
    }

    /**
     * 返回当前耐力值。
     * Returns the current stamina value.
     */
    public int getCurrentStamina() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcStamina");
    }

    /**
     * 返回当前生命百分比。
     * Returns the current body/health percentage.
     */
    public float getCurrentBodyPercentage() {
        int maxBody = getMaxBody();
        return maxBody <= 0 ? 0.0F : getCurrentBody() * 100.0F / maxBody;
    }

    /**
     * 返回当前气值百分比。
     * Returns the current energy/Ki percentage.
     */
    public float getCurrentEnergyPercentage() {
        int maxEnergy = getMaxKi();
        return maxEnergy <= 0 ? 0.0F : getCurrentEnergy() * 100.0F / maxEnergy;
    }

    /**
     * 返回当前耐力百分比。
     * Returns the current stamina percentage.
     */
    public float getCurrentStaminaPercentage() {
        int maxStamina = getMaxStamina();
        return maxStamina <= 0 ? 0.0F : getCurrentStamina() * 100.0F / maxStamina;
    }

    /**
     * 返回当前阵营值。
     * Returns the current alignment value.
     */
    public int getAlignment() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcAlign");
    }

    /**
     * 返回当前 karma 值。
     * Returns the current karma value.
     */
    public int getKarma() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcKarma");
    }

    /**
     * 返回当前训练点。
     * Returns the current training-point value.
     */
    public int getTrainingPoints() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcTpint");
    }

    /**
     * 返回当前变身计量条值。
     * Returns the current transformation-meter value.
     */
    public int getTransformationMeter() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcSaiRg");
    }

    /**
     * 返回任务同步版本字符串。
     * Returns the mission-sync version string.
     */
    public String getMissionSyncVersion() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "JRMCmissionSyncVers");
    }

    /**
     * 返回当前经验进度值。
     * Returns the current experience-progress value.
     */
    public int getExperience() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcExp");
    }

    /**
     * 返回当前属性点数。
     * Returns the current attribute-point value.
     */
    public int getAttributePoints() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcAp");
    }

    /**
     * 判断角色数据是否已完成接受/初始化。
     * Returns whether the character data has been accepted/initialized.
     */
    public boolean isCharacterAccepted() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcAccept") == 1;
    }

    /**
     * 返回当前难度值。
     * Returns the current difficulty value.
     */
    public int getDifficulty() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcDiff");
    }

    /**
     * 返回当前难度名称。
     * Returns the current difficulty name.
     */
    public String getDifficultyName() {
        int difficulty = getDifficulty();
        return difficulty >= 0 && difficulty < JRMCoreH.DifficultyNames.length ? JRMCoreH.DifficultyNames[difficulty] : String.valueOf(difficulty);
    }

    /**
     * 返回当前难度短名称。
     * Returns the current difficulty short name.
     */
    public String getDifficultyShortName() {
        int difficulty = getDifficulty();
        return difficulty >= 0 && difficulty < JRMCoreH.DifficultySNmes.length ? JRMCoreH.DifficultySNmes[difficulty] : String.valueOf(difficulty);
    }

    /**
     * 返回当前难度说明 key。
     * Returns the current difficulty description key.
     */
    public String getDifficultyDescriptionKey() {
        int difficulty = getDifficulty();
        return difficulty >= 0 && difficulty < JRMCoreH.DifficultyDesc.length ? JRMCoreH.DifficultyDesc[difficulty] : "";
    }

    /**
     * 返回善阵营击杀数。
     * Returns the good-alignment kill count.
     */
    public int getGoodKillCount() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcKillCountGood");
    }

    /**
     * 返回中立阵营击杀数。
     * Returns the neutral-alignment kill count.
     */
    public int getNeutralKillCount() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcKillCountNeut");
    }

    /**
     * 返回恶阵营击杀数。
     * Returns the evil-alignment kill count.
     */
    public int getEvilKillCount() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcKillCountEvil");
    }

    /**
     * 返回死亡次数。
     * Returns the death count.
     */
    public int getDeathCount() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcDiedTimes");
    }

    /**
     * 返回重力训练值。
     * Returns the gravity-training value.
     */
    public int getGravityTraining() {
        ensureConnected();
        return JRMCoreH.getShort(entityPlayer, "jrmcGTrnng");
    }

    /**
     * 返回 KO 倒计时。
     * Returns the KO timer value.
     */
    public int getKnockoutTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcHar4va");
    }

    /**
     * 返回自在极意功热量值。
     * Returns the Ultra Instinct heat value.
     */
    public int getUltraInstinctHeat() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcEf8slc");
    }

    /**
     * 返回自在极意功热量百分比。
     * Returns the Ultra Instinct heat percentage.
     */
    public float getUltraInstinctHeatPercentage() {
        ensureConnected();
        return JRMCoreH.getHeatPercentage(entityPlayer, (byte) getCurrentState2());
    }

    /**
     * 返回临时 strain 值。
     * Returns the temporary strain value.
     */
    public int getStrainTemp() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcStrainTemp");
    }

    /**
     * 返回当前 strain 值。
     * Returns the current strain value.
     */
    public int getStrain() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcStrain");
    }

    /**
     * 返回 strain 激活计时值。
     * Returns the strain-active timer value.
     */
    public int getStrainActiveTicks() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcStrainActv");
    }

    /**
     * 返回复活计时值。
     * Returns the revive-timer value.
     */
    public int getReviveTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcReviveTmer");
    }

    /**
     * 返回已达成的 UI 最高状态。
     * Returns the highest Ultra Instinct state reached.
     */
    public int getUIHighestStateReached() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcUIStateReach");
    }

    /**
     * 判断 UI 状态中是否记录过疼痛标记。
     * Returns whether the UI pain flag was recorded.
     */
    public boolean wasUIInPain() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcUIWasInPain") == 1;
    }

    /**
     * 返回 UI 疼痛持续值。
     * Returns the UI pain-duration value.
     */
    public int getUIWasInPainDuration() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcUIWasInPainDuration");
    }

    /**
     * 返回 God strain 值。
     * Returns the God strain value.
     */
    public int getGodStrain() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcGodStrain");
    }

    /**
     * 返回 God power 计时值。
     * Returns the God power timer value.
     */
    public int getGodPowerTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcGodPwr");
    }

    /**
     * 返回 Mystic 计时值。
     * Returns the Mystic timer value.
     */
    public int getMysticTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcUltmtTm");
    }

    /**
     * 返回 pain 计时值。
     * Returns the pain timer value.
     */
    public int getPainTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcGyJ7dp");
    }

    /**
     * 返回自在极意功热量伤害值。
     * Returns the Ultra Instinct heat-damage value.
     */
    public double getUltraInstinctHeatDamage() {
        ensureConnected();
        return getEntityNbt().func_74769_h("jrmcEf8slcD");
    }

    /**
     * 返回当前重力值。
     * Returns the current gravity-force value.
     */
    public float getGravityForce() {
        ensureConnected();
        return JRMCoreH.getFloat(entityPlayer, "jrmcGravForce");
    }

    /**
     * 返回上次造成伤害值。
     * Returns the last recorded damage dealt.
     */
    public int getLastDamageDealt() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcLastDamageDealt");
    }

    /**
     * 返回上次受到伤害值。
     * Returns the last recorded damage received.
     */
    public int getLastDamageReceived() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcLastDamageReceived");
    }

    /**
     * 返回瞬间移动计时原始字符串。
     * Returns the raw instant-transmission timer payload.
     */
    public String getInstantTransmissionTimersRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcInstantTransmissionTimers");
    }

    /**
     * 返回瞬间移动短计时值。
     * Returns the short instant-transmission timer value.
     */
    public int getInstantTransmissionShortTimer() {
        String raw = getInstantTransmissionTimersRaw();
        if (raw == null || raw.isEmpty()) {
            return 0;
        }
        String[] parts = raw.split(";", 2);
        try {
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException ignored) {
            return 0;
        }
    }

    /**
     * 返回瞬间移动长计时值。
     * Returns the long instant-transmission timer value.
     */
    public int getInstantTransmissionLongTimer() {
        String raw = getInstantTransmissionTimersRaw();
        if (raw == null || raw.isEmpty()) {
            return 0;
        }
        String[] parts = raw.split(";", 2);
        if (parts.length < 2) {
            return 0;
        }
        try {
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException ignored) {
            return 0;
        }
    }

    /**
     * 返回最近攻击者原始字符串。
     * Returns the raw last-attacker payload.
     */
    public String getLastAttackerRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcLastAttacker");
    }

    /**
     * 返回最近攻击者名称。
     * Returns the last attacker name.
     */
    public String getLastAttackerName() {
        String raw = getLastAttackerRaw();
        if (raw == null || raw.isEmpty()) {
            return "";
        }
        String[] parts = raw.split(";", 2);
        return parts.length > 0 ? parts[0] : "";
    }

    /**
     * 返回最近攻击者时间戳。
     * Returns the last attacker epoch value.
     */
    public long getLastAttackerEpoch() {
        String raw = getLastAttackerRaw();
        if (raw == null || raw.isEmpty()) {
            return 0L;
        }
        String[] parts = raw.split(";", 2);
        if (parts.length < 2) {
            return 0L;
        }
        try {
            return Long.parseLong(parts[1]);
        } catch (NumberFormatException ignored) {
            return 0L;
        }
    }

    /**
     * 返回原始状态效果字符串。
     * Returns the raw status-effect payload string.
     */
    public String getStatusEffectsRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcStatusEff");
    }

    /**
     * 返回融合原始数据字符串。
     * Returns the raw fusion payload string.
     */
    public String getFusionRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcFuzion");
    }

    /**
     * 返回是否存在可解析的融合数据。
     * Returns whether parseable fusion data is currently present.
     */
    public boolean hasFusionData() {
        String raw = getFusionRaw();
        return raw != null && !raw.trim().isEmpty() && !" ".equals(raw.trim());
    }

    /**
     * 返回融合参与者名称数组。
     * Returns the fusion participant-name array.
     */
    public String[] getFusionParticipants() {
        String raw = getFusionRaw();
        if (raw == null || raw.trim().isEmpty() || !raw.contains(",")) {
            return new String[0];
        }
        String[] parts = raw.split(",");
        if (parts.length < 2) {
            return new String[0];
        }
        return new String[] { parts[0], parts[1] };
    }

    /**
     * 返回第一个融合参与者名称。
     * Returns the first fusion participant name.
     */
    public String getFusionParticipantA() {
        String[] participants = getFusionParticipants();
        return participants.length > 0 ? participants[0] : "";
    }

    /**
     * 返回第二个融合参与者名称。
     * Returns the second fusion participant name.
     */
    public String getFusionParticipantB() {
        String[] participants = getFusionParticipants();
        return participants.length > 1 ? participants[1] : "";
    }

    /**
     * 返回融合参与者数量。
     * Returns the number of fusion participants.
     */
    public int getFusionParticipantCount() {
        return getFusionParticipants().length;
    }

    /**
     * 返回融合计时值。
     * Returns the fusion timer value.
     */
    public int getFusionTimer() {
        String raw = getFusionRaw();
        if (raw == null || raw.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException ignored) {
        }
        String[] parts = raw.split(",");
        if (parts.length < 3) {
            return 0;
        }
        try {
            return Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException ignored) {
            return 0;
        }
    }

    /**
     * 返回攻击计时值。
     * Returns the attack timer value.
     */
    public int getAttackTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcAttackTimer");
    }

    /**
     * 返回最近被攻击玩家计时值。
     * Returns the last-attacked-player timer value.
     */
    public int getLastAttackedPlayerTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcAttackLstPlyrTm");
    }

    /**
     * 返回最近被攻击玩家原始标识字符串。
     * Returns the raw last-attacked-player identifier.
     */
    public String getLastAttackedPlayerRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcAttackLstPlyrNam");
    }

    /**
     * 返回最近被攻击玩家标识。
     * Returns the last-attacked-player identifier.
     */
    public String getLastAttackedPlayerId() {
        return getLastAttackedPlayerRaw();
    }

    /**
     * 返回 Senzu 冷却值。
     * Returns the Senzu cooldown value.
     */
    public int getSenzuCooldown() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcSenzuCC");
    }

    /**
     * 判断 Senzu 是否仍在冷却中。
     * Returns whether the Senzu cooldown is still active.
     */
    public boolean isSenzuOnCooldown() {
        return getSenzuCooldown() > 0;
    }

    /**
     * 返回难度保护计时值。
     * Returns the difficulty-reduction timer value.
     */
    public int getDifficultyReductionTicks() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcDiffRed");
    }

    /**
     * 判断难度保护是否激活。
     * Returns whether difficulty protection is currently active.
     */
    public boolean isDifficultyReductionActive() {
        return getDifficultyReductionTicks() > 0;
    }

    /**
     * 返回原始设置字符串。
     * Returns the raw settings payload string.
     */
    public String getSettingsRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcSettings");
    }

    /**
     * 返回种族技能槽原始数据。
     * Returns the raw racial skill-slot payload.
     */
    public String getRacialSkillSlot() {
        ensureConnected();
        return getSkillXData();
    }

    /**
     * 返回核心技能槽原始数据。
     * Returns the raw core skill-slot payload.
     */
    public String getCoreSkillSlot() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcSSltY");
    }

    /**
     * 返回已学习技能的原始字符串。
     * Returns the raw learned-skills payload string.
     */
    public String getLearnedSkillsRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcSSlts");
    }

    /**
     * 返回已学习技能数量。
     * Returns the number of learned-skill entries.
     */
    public int getLearnedSkillCount() {
        return getLearnedSkills().length;
    }

    /**
     * 判断是否存在已学习技能条目。
     * Returns whether at least one learned-skill entry exists.
     */
    public boolean hasLearnedSkills() {
        return getLearnedSkillCount() > 0;
    }

    /**
     * 判断原始技能条目中是否包含指定片段。
     * Returns whether the learned-skill payload contains the given token.
     */
    public boolean hasLearnedSkillToken(String skillToken) {
        if (skillToken == null || skillToken.isEmpty()) {
            return false;
        }
        String[] learnedSkills = getLearnedSkills();
        for (String learnedSkill : learnedSkills) {
            if (learnedSkill != null && learnedSkill.contains(skillToken)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回属性 bonus 原始字符串。
     * Returns the raw bonus-attribute payload for the given attribute.
     */
    public String getAttributeBonusRaw(int attributeIndex) {
        ensureConnected();
        if (attributeIndex < 0 || attributeIndex > 5) {
            return "";
        }
        String[] attributeKeys = new String[] { "str", "dex", "con", "wil", "mnd", "spi" };
        return getEntityNbt().func_74779_i("jrmcAttrBonus" + attributeKeys[attributeIndex]);
    }

    /**
     * 判断指定属性是否存在 bonus 数据。
     * Returns whether the given attribute currently has bonus-attribute data.
     */
    public boolean hasAttributeBonus(int attributeIndex) {
        String raw = getAttributeBonusRaw(attributeIndex);
        return raw != null && raw.length() > 0 && !"n".equalsIgnoreCase(raw) && !"NONE".equalsIgnoreCase(raw);
    }

    /**
     * 返回指定属性的 bonus 条目数组。
     * Returns the parsed bonus-attribute entries for the given attribute.
     */
    public String[] getAttributeBonusEntries(int attributeIndex) {
        String raw = getAttributeBonusRaw(attributeIndex);
        if (raw == null || raw.length() == 0 || "n".equalsIgnoreCase(raw) || "NONE".equalsIgnoreCase(raw)) {
            return new String[0];
        }
        return raw.split("\\|");
    }

    /**
     * 返回指定属性 bonus 的名称数组。
     * Returns the bonus-name array for the given attribute.
     */
    public String[] getAttributeBonusNames(int attributeIndex) {
        String[] entries = getAttributeBonusEntries(attributeIndex);
        String[] names = new String[entries.length];
        for (int i = 0; i < entries.length; i++) {
            String[] parts = entries[i].split("\\;", 2);
            names[i] = parts.length > 0 ? parts[0] : "";
        }
        return names;
    }

    /**
     * 返回指定属性 bonus 的表达式数组。
     * Returns the bonus-expression array for the given attribute.
     */
    public String[] getAttributeBonusExpressions(int attributeIndex) {
        String[] entries = getAttributeBonusEntries(attributeIndex);
        String[] expressions = new String[entries.length];
        for (int i = 0; i < entries.length; i++) {
            String[] parts = entries[i].split("\\;", 2);
            expressions[i] = parts.length > 1 ? parts[1] : "";
        }
        return expressions;
    }

    /**
     * 返回指定属性 bonus 的运算符数组。
     * Returns the bonus-operator array for the given attribute.
     */
    public String[] getAttributeBonusOperators(int attributeIndex) {
        String[] expressions = getAttributeBonusExpressions(attributeIndex);
        String[] operators = new String[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            operators[i] = expressions[i].length() > 0 ? expressions[i].substring(0, 1) : "";
        }
        return operators;
    }

    /**
     * 返回指定属性 bonus 的数值数组。
     * Returns the numeric bonus-value array for the given attribute.
     */
    public double[] getAttributeBonusNumericValues(int attributeIndex) {
        String[] expressions = getAttributeBonusExpressions(attributeIndex);
        double[] values = new double[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            if (expressions[i].length() <= 1 || expressions[i].startsWith("nbt_") || expressions[i].startsWith("NBT_")) {
                values[i] = 0.0D;
                continue;
            }
            try {
                values[i] = Double.parseDouble(expressions[i].substring(1));
            } catch (NumberFormatException ignored) {
                values[i] = 0.0D;
            }
        }
        return values;
    }

    /**
     * 返回指定属性的 bonus 条目数量。
     * Returns the number of bonus-attribute entries for the given attribute.
     */
    public int getAttributeBonusEntryCount(int attributeIndex) {
        return getAttributeBonusEntries(attributeIndex).length;
    }

    /**
     * 返回当前任务同步原始字符串。
     * Returns the raw mission-sync payload string.
     */
    public String getMissionSyncData() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "JRMCmissionSync");
    }

    /**
     * 返回种族形态 mastery 的原始字符串。
     * Returns the raw racial-form mastery payload string.
     */
    public String getRacialFormMasteryRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, JRMCoreH.getNBTFormMasteryRacialKey(getRace()));
    }

    /**
     * 返回非种族形态 mastery 的原始字符串。
     * Returns the raw non-racial-form mastery payload string.
     */
    public String getNonRacialFormMasteryRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcFormMasteryNonRacial");
    }

    /**
     * 返回角色皮肤代码。
     * Returns the player's DNS/skin code.
     */
    public String getSkinCode() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcDNS");
    }

    /**
     * 返回角色发型代码。
     * Returns the player's hair code.
     */
    public String getHairCode() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcDNSH");
    }

    /**
     * 返回角色 aura 外观代码。
     * Returns the player's aura-appearance code.
     */
    public String getAuraCode() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "jrmcDNSAU");
    }

    /**
     * 返回 aura 颜色值。
     * Returns the aura-color value.
     */
    public int getAuraColor() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcAuraColor");
    }

    /**
     * 返回剧情主线 id。
     * Returns the main saga id.
     */
    public int getSagaMainId() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "DBCSagaSys");
    }

    /**
     * 返回剧情地组 id。
     * Returns the saga group id.
     */
    public int getSagaGroupId() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "JRMCGID");
    }

    /**
     * 返回剧情地组成员原始字符串。
     * Returns the raw saga group-member payload.
     */
    public String getSagaGroupMembersRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "JRMCGLIDs");
    }

    /**
     * 返回剧情地组成员名称数组。
     * Returns the saga group-member array.
     */
    public String[] getSagaGroupMembers() {
        String raw = getSagaGroupMembersRaw();
        if (raw == null || raw.trim().isEmpty() || " ".equals(raw)) {
            return new String[0];
        }
        String[] parts = raw.split(",");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }
        return parts;
    }

    /**
     * 返回剧情地组成员数量。
     * Returns the number of saga group members.
     */
    public int getSagaGroupMemberCount() {
        return getSagaGroupMembers().length;
    }

    /**
     * 判断当前是否处于剧情地组中。
     * Returns whether the player currently belongs to a saga group.
     */
    public boolean hasSagaGroup() {
        return getSagaGroupId() > 0 || getSagaGroupMemberCount() > 0;
    }

    /**
     * 返回剧情地组邀请原始字符串。
     * Returns the raw saga group-invite payload.
     */
    public String getSagaGroupInviteRaw() {
        ensureConnected();
        return JRMCoreH.getString(entityPlayer, "JRMCGIDis");
    }

    /**
     * 判断当前是否存在剧情地组邀请。
     * Returns whether a saga group invite is currently present.
     */
    public boolean hasSagaGroupInvite() {
        String raw = getSagaGroupInviteRaw();
        return raw != null && !raw.trim().isEmpty() && !" ".equals(raw.trim());
    }

    /**
     * 返回魔人吸收数据原始字符串。
     * Returns the raw Majin absorption payload.
     */
    public String getMajinAbsorptionDataRaw() {
        ensureConnected();
        return getMajinAbsorptionData();
    }

    /**
     * 返回魔人吸收计时值。
     * Returns the Majin absorption timer value.
     */
    public int getMajinAbsorptionTimer() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcMajinAbsorptionTimer");
    }

    /**
     * 返回魔人吸收值。
     * Returns the Majin absorption value.
     */
    public int getMajinAbsorptionValue() {
        ensureConnected();
        return JRMCoreH.getMajinAbsorptionValueS(getMajinAbsorptionDataRaw());
    }

    /**
     * 返回魔人吸收分段数组。
     * Returns the Majin absorption segments split by comma.
     */
    public String[] getMajinAbsorptionParts() {
        String raw = getMajinAbsorptionDataRaw();
        if (raw == null || raw.trim().isEmpty()) {
            return new String[0];
        }
        return raw.split(",");
    }

    /**
     * 返回指定索引的魔人吸收分段。
     * Returns the Majin absorption segment at the given index.
     */
    public String getMajinAbsorptionPart(int index) {
        String[] parts = getMajinAbsorptionParts();
        if (index < 0 || index >= parts.length) {
            return "";
        }
        return parts[index];
    }

    /**
     * 返回当前 Majin 形态 id。
     * Returns the current Majin form id.
     */
    public int getMajinFormId() {
        return JRMCoreH.getMajinFormID(
            getCurrentState(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 返回当前 Arcosian 形态 id。
     * Returns the current Arcosian form id.
     */
    public int getArcosianFormId() {
        return JRMCoreH.getArcosianFormID(
            getCurrentState(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 返回当前种族名称。
     * Returns the current race name.
     */
    public String getRaceName() {
        int race = getRace();
        return race >= 0 && race < JRMCoreH.Races.length ? JRMCoreH.Races[race] : String.valueOf(race);
    }

    /**
     * 返回当前职业名称。
     * Returns the current class name.
     */
    public String getClassName() {
        String[] classNames = JRMCoreH.cl(getPowerType());
        int classId = getClassId();
        return classNames != null && classId >= 0 && classId < classNames.length ? classNames[classId] : String.valueOf(classId);
    }

    /**
     * 返回当前力量体系名称。
     * Returns the current power-type name.
     */
    public String getPowerTypeName() {
        int powerType = getPowerType();
        return powerType >= 0 && powerType < JRMCoreH.Pwrtyps.length ? JRMCoreH.Pwrtyps[powerType] : String.valueOf(powerType);
    }

    /**
     * 返回当前力量体系说明 key。
     * Returns the current power-type description key.
     */
    public String getPowerTypeDescriptionKey() {
        int powerType = getPowerType();
        return powerType >= 0 && powerType < JRMCoreH.PwrtypDesc.length ? JRMCoreH.PwrtypDesc[powerType] : "";
    }

    /**
     * 返回当前力量体系允许域名称。
     * Returns the current power-type allow-domain name.
     */
    public String getPowerTypeAllowName() {
        int powerType = getPowerType();
        return powerType >= 0 && powerType < JRMCoreH.PwrtypAllow.length ? JRMCoreH.PwrtypAllow[powerType] : "";
    }

    /**
     * 返回当前职业说明 key。
     * Returns the current class-description key.
     */
    public String getClassDescriptionKey() {
        int powerType = getPowerType();
        int classId = getClassId();
        String[] descriptions = JRMCoreH.PwrtypAllow[powerType].contains("DBC")
            ? JRMCoreH.ClassesDBCDesc
            : (JRMCoreH.PwrtypAllow[powerType].contains("NC") ? JRMCoreH.ClansDesc : JRMCoreH.ClassesDesc);
        return descriptions != null && classId >= 0 && classId < descriptions.length ? descriptions[classId] : "";
    }

    /**
     * 返回当前职业分类名称。
     * Returns the current class-group name.
     */
    public String getClassGroupName() {
        int powerType = getPowerType();
        return powerType >= 0 && powerType < JRMCoreH.ClassNames.length ? JRMCoreH.ClassNames[powerType] : "";
    }

    /**
     * 判断是否为自然体系玩家。
     * Returns whether the player is using the nature power type.
     */
    public boolean isNatureUser() {
        return getPowerType() == 0;
    }

    /**
     * 判断是否为气体系玩家。
     * Returns whether the player is using the Ki power type.
     */
    public boolean isKiUser() {
        return getPowerType() == 1;
    }

    /**
     * 判断是否为查克拉体系玩家。
     * Returns whether the player is using the Chakra power type.
     */
    public boolean isChakraUser() {
        return getPowerType() == 2;
    }

    /**
     * 返回玩家设置槽位的当前值。
     * Returns the current value stored for the given player-setting slot.
     */
    public int getPlayerSettingValue(int settingIndex) {
        ensureConnected();
        return JRMCoreH.PlyrSettings(entityPlayer, settingIndex);
    }

    /**
     * 返回玩家设置枚举对应槽位的当前值。
     * Returns the current value stored for the given player-setting enum.
     */
    public int getPlayerSettingValue(CValuePlayerSetting setting) {
        if (setting == null) {
            return -1;
        }
        return getPlayerSettingValue(setting.index());
    }

    /**
     * 判断指定玩家设置槽位是否已启用。
     * Returns whether the given player-setting slot is enabled/present.
     */
    public boolean hasPlayerSetting(int settingIndex) {
        ensureConnected();
        return JRMCoreH.PlyrSettingsB(entityPlayer, settingIndex);
    }

    /**
     * 判断玩家设置枚举对应槽位是否已启用。
     * Returns whether the given player-setting enum is enabled/present.
     */
    public boolean hasPlayerSetting(CValuePlayerSetting setting) {
        return setting != null && hasPlayerSetting(setting.index());
    }

    /**
     * 返回当前已启用的已知玩家设置列表。
     * Returns the currently enabled known player-setting list.
     */
    public CValuePlayerSetting[] getEnabledKnownPlayerSettings() {
        java.util.ArrayList<CValuePlayerSetting> enabledSettings = new java.util.ArrayList<CValuePlayerSetting>();
        for (CValuePlayerSetting setting : CValuePlayerSetting.values()) {
            if (hasPlayerSetting(setting)) {
                enabledSettings.add(setting);
            }
        }
        return enabledSettings.toArray(new CValuePlayerSetting[enabledSettings.size()]);
    }

    /**
     * 判断界王拳设置位是否已启用。
     * Returns whether the Kaioken setting flag is enabled.
     */
    public boolean isKaiokenSettingEnabled() {
        return hasPlayerSetting(0);
    }

    /**
     * 判断 Mystic 设置位是否已启用。
     * Returns whether the Mystic setting flag is enabled.
     */
    public boolean isMysticSettingEnabled() {
        return hasPlayerSetting(6);
    }

    /**
     * 判断自在极意功设置位是否已启用。
     * Returns whether the Ultra Instinct setting flag is enabled.
     */
    public boolean isUltraInstinctSettingEnabled() {
        return hasPlayerSetting(11);
    }

    /**
     * 判断破坏神设置位是否已启用。
     * Returns whether the God of Destruction setting flag is enabled.
     */
    public boolean isGodOfDestructionSettingEnabled() {
        return hasPlayerSetting(16);
    }

    /**
     * 判断闪避/疾冲设置位是否已启用。
     * Returns whether the Dodge/Swoop setting flag is enabled.
     */
    public boolean isDodgeSwoopSettingEnabled() {
        return hasPlayerSetting(2);
    }

    /**
     * 判断融合设置位是否已启用。
     * Returns whether the Fusion setting flag is enabled.
     */
    public boolean isFusionSettingEnabled() {
        return hasPlayerSetting(4);
    }

    /**
     * 判断 Ki Fist 设置位是否已启用。
     * Returns whether the Ki Fist setting flag is enabled.
     */
    public boolean isKiFistSettingEnabled() {
        return hasPlayerSetting(9);
    }

    /**
     * 判断 Ki Protection 设置位是否已启用。
     * Returns whether the Ki Protection setting flag is enabled.
     */
    public boolean isKiProtectionSettingEnabled() {
        return hasPlayerSetting(10);
    }

    /**
     * 判断 Friendly Fist 设置位是否已启用。
     * Returns whether the Friendly Fist setting flag is enabled.
     */
    public boolean isFriendlyFistSettingEnabled() {
        return hasPlayerSetting(12);
    }

    /**
     * 判断 Ki Weapon 设置位是否已启用。
     * Returns whether the Ki Weapon setting flag is enabled.
     */
    public boolean hasKiWeaponSetting() {
        return hasPlayerSetting(13);
    }

    /**
     * 返回 Ki Weapon 模式值。
     * Returns the Ki Weapon mode value.
     */
    public int getKiWeaponMode() {
        return getPlayerSettingValue(13);
    }

    /**
     * 返回 Ki Weapon 模式名称。
     * Returns the Ki Weapon mode name.
     */
    public String getKiWeaponModeName() {
        if (isKiWeaponSwordMode()) {
            return JRMCoreH.trl("dbc", "KiSword");
        }
        if (isKiWeaponScytheMode()) {
            return JRMCoreH.trl("dbc", "KiScythe");
        }
        return JRMCoreH.trl("jrmc", "Off");
    }

    /**
     * 判断当前 Ki Weapon 是否为剑模式。
     * Returns whether the current Ki Weapon mode is sword mode.
     */
    public boolean isKiWeaponSwordMode() {
        return getKiWeaponMode() == 0;
    }

    /**
     * 判断当前 Ki Weapon 是否为镰刀模式。
     * Returns whether the current Ki Weapon mode is scythe mode.
     */
    public boolean isKiWeaponScytheMode() {
        return getKiWeaponMode() == 1;
    }

    /**
     * 返回瞬移短距离模式值。
     * Returns the Instant Transmission short-mode value.
     */
    public int getInstantTransmissionShortMode() {
        return getPlayerSettingValue(14);
    }

    /**
     * 返回瞬移短距离模式名称。
     * Returns the Instant Transmission short-mode name.
     */
    public String getInstantTransmissionShortModeName() {
        return JRMCoreH.trl("dbc", "InstantTransShortTPMode" + (getInstantTransmissionShortMode() + 1));
    }

    /**
     * 返回瞬移环绕模式值。
     * Returns the Instant Transmission surround-mode value.
     */
    public int getInstantTransmissionSurroundMode() {
        return getPlayerSettingValue(15);
    }

    /**
     * 返回瞬移环绕模式名称。
     * Returns the Instant Transmission surround-mode name.
     */
    public String getInstantTransmissionSurroundModeName() {
        return JRMCoreH.trl("dbc", "InstantTransSurroundMode" + (getInstantTransmissionSurroundMode() + 1));
    }

    /**
     * 返回尾巴模式值。
     * Returns the tail-mode value.
     */
    public int getTailMode() {
        ensureConnected();
        return JRMCoreH.getByte(entityPlayer, "jrmcTlmd");
    }

    /**
     * 判断当前是否拥有尾巴。
     * Returns whether the current tail-mode indicates a tail is present.
     */
    public boolean hasTail() {
        return JRMCoreH.tailHas(getTailMode());
    }

    /**
     * 返回阵营分类 id。
     * Returns the alignment category id.
     */
    public int getAlignmentCategory() {
        return JRMCoreH.Algnmnt(getAlignment());
    }

    /**
     * 判断是否为善阵营。
     * Returns whether the player is in the good alignment group.
     */
    public boolean isGoodAlignment() {
        return JRMCoreH.Algnmnt_Good(getAlignment());
    }

    /**
     * 判断是否为中立阵营。
     * Returns whether the player is in the neutral alignment group.
     */
    public boolean isNeutralAlignment() {
        return JRMCoreH.Algnmnt_Neut(getAlignment());
    }

    /**
     * 判断是否为恶阵营。
     * Returns whether the player is in the evil alignment group.
     */
    public boolean isEvilAlignment() {
        return JRMCoreH.Algnmnt_Evil(getAlignment());
    }

    /**
     * 返回总击杀数。
     * Returns the total kill count across alignments.
     */
    public int getTotalKillCount() {
        return getGoodKillCount() + getNeutralKillCount() + getEvilKillCount();
    }

    /**
     * 返回当前力量体系下的技能等级。
     * Returns one skill level using the player's current power type.
     */
    public int getCurrentPowerSkillLevel(int skillIndex) {
        return getSkillLevel(skillIndex);
    }

    /**
     * 返回当前装备负重值。
     * Returns the current carried-item weight value.
     */
    public float getItemWeight() {
        ensureConnected();
        return JRMCoreH.getItemWeight(entityPlayer);
    }

    /**
     * 返回角色体重权重值。
     * Returns the computed body-weight value.
     */
    public float getBodyWeight() {
        ensureConnected();
        return JRMCoreH.weightOfPlayerBody(NBTAttributes, hasFusionStatus());
    }

    /**
     * 返回额外负重值。
     * Returns the extra carried-weight value.
     */
    public float getExtraWeight() {
        ensureConnected();
        return JRMCoreH.weightExtra(NBTAttributes, getGravityForce(), entityPlayer);
    }

    /**
     * 返回训练点上限。
     * Returns the training-point cap.
     */
    public int getMaxTrainingPoints() {
        return JRMCoreH.getMaxTP();
    }

    /**
     * 返回第一训练点限制值。
     * Returns the first training-point limit value.
     */
    public int getTrainingPointLimit() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcTPlimit");
    }

    /**
     * 返回第二训练点限制值。
     * Returns the second training-point limit value.
     */
    public int getTrainingPointLimit2() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcTPlimit2");
    }

    /**
     * 返回剩余愿望次数。
     * Returns the current wish count.
     */
    public int getWishes() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcWishes");
    }

    /**
     * 返回龙球/神龙标记值。
     * Returns the dragon flag/count value.
     */
    public int getDragonCount() {
        ensureConnected();
        return JRMCoreH.getInt(entityPlayer, "jrmcDrgn");
    }

    /**
     * 返回当前形态名称。
     * Returns the current form name.
     */
    public String getCurrentFormName() {
        return JRMCoreH.getCurrentFormName(
            getRace(),
            getCurrentState(),
            getCurrentState2(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 按形态名称返回当前种族上下文中的 form id。
     * Returns the form id for the given form name in the current race context.
     */
    public int getFormIdByName(String formName) {
        if (formName == null || formName.isEmpty()) {
            return -1;
        }
        return JRMCoreH.getFormIDFromName(getRace(), formName);
    }

    /**
     * 返回当前形态 id。
     * Returns the current form id.
     */
    public int getCurrentFormId() {
        return JRMCoreH.getCurrentFormID(
            getRace(),
            getCurrentState(),
            getCurrentState2(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 判断当前是否处于指定形态。
     * Returns whether the player is currently in the requested form.
     */
    public boolean isCurrentForm(String formName) {
        if (formName == null || formName.isEmpty()) {
            return false;
        }
        return JRMCoreH.isCurrentFormID(
            formName,
            getRace(),
            getCurrentState(),
            getCurrentState2(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 判断当前形态是否为种族形态。
     * Returns whether the current form is racial.
     */
    public boolean isCurrentFormRacial() {
        return JRMCoreH.isCurrentFormRacial(
            getRace(),
            getCurrentState(),
            getCurrentState2(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus()
        );
    }

    /**
     * 判断当前形态是否为非种族形态。
     * Returns whether the current form is non-racial.
     */
    public boolean isCurrentFormNonRacial() {
        return !isCurrentFormRacial();
    }

    /**
     * 返回当前自在极意功等级。
     * Returns the current Ultra Instinct level.
     */
    public int getUltraInstinctLevel() {
        return JRMCoreH.state2UltraInstinct(hasKaiokenStatus(), (byte) getCurrentState2());
    }

    /**
     * 判断赛亚人是否处于 Full Power 分支。
     * Returns whether a Saiyan currently satisfies the Full Power branch.
     */
    public boolean isSaiyanSuperFullPower() {
        return JRMCoreH.isSaiyanSuperFullPower(getEntityNbt());
    }

    /**
     * 返回降阶时将回落到的形态 id。
     * Returns the form id used when descending from the current transformation.
     */
    public int getTransformationDescendFormId() {
        return JRMCoreH.getTransformationDescendToFormID(
            (byte) getRace(),
            (byte) getCurrentState(),
            isSaiyanSuperFullPower()
        );
    }

    /**
     * 返回阵营名称。
     * Returns the alignment-group name.
     */
    public String getAlignmentName() {
        int category = getAlignmentCategory();
        return category >= 0 && category < JRMCoreH.AlgnmntNms.length ? JRMCoreH.AlgnmntNms[category] : String.valueOf(category);
    }

    /**
     * 返回阵营颜色值。
     * Returns the alignment color value.
     */
    public int getAlignmentColor() {
        return JRMCoreH.Algnmnt_rc(getAlignment());
    }

    /**
     * 返回属性显示名称。
     * Returns the attribute display name.
     */
    public String getAttributeName(int attributeIndex) {
        if (attributeIndex < 0) {
            return "";
        }
        try {
            return JRMCoreH.attrNms(getPowerType(), attributeIndex);
        } catch (RuntimeException ignored) {
            return "";
        }
    }

    /**
     * 返回属性说明文本。
     * Returns the attribute description text.
     */
    public String getAttributeDescription(int attributeIndex) {
        if (attributeIndex < 0) {
            return "";
        }
        try {
            return JRMCoreH.attrDsc(getPowerType(), attributeIndex);
        } catch (RuntimeException ignored) {
            return "";
        }
    }

    /**
     * 返回当前力量体系下的属性名称数组。
     * Returns the attribute-name array for the current power type.
     */
    public String[] getAttributeNames() {
        String[] names = new String[6];
        for (int i = 0; i < names.length; i++) {
            names[i] = getAttributeName(i);
        }
        return names;
    }

    /**
     * 返回当前力量体系下的属性说明数组。
     * Returns the attribute-description array for the current power type.
     */
    public String[] getAttributeDescriptions() {
        String[] descriptions = new String[6];
        for (int i = 0; i < descriptions.length; i++) {
            descriptions[i] = getAttributeDescription(i);
        }
        return descriptions;
    }

    /**
     * 按稳定 key 检查状态效果是否激活。
     * Checks whether the status effect identified by key is active.
     */
    public boolean hasStatusEffect(String effectKey) {
        if (effectKey == null || effectKey.isEmpty()) {
            return false;
        }
        String normalizedKey = effectKey.trim().toLowerCase();
        if ("evolution".equals(normalizedKey)) return hasStatusEffect(1);
        if ("rampage".equals(normalizedKey)) return hasStatusEffect(3);
        if ("charge".equals(normalizedKey)) return hasStatusEffect(4);
        if ("kaioken".equals(normalizedKey)) return hasKaiokenStatus();
        if ("flight".equals(normalizedKey)) return hasStatusEffect(6);
        if ("night".equals(normalizedKey)) return hasStatusEffect(7);
        if ("fusion_a".equals(normalizedKey)) return hasStatusEffect(10);
        if ("fusion_b".equals(normalizedKey)) return hasStatusEffect(11);
        if ("majin".equals(normalizedKey)) return hasMajinStatus();
        if ("mystic".equals(normalizedKey)) return hasMysticStatus();
        if ("legendary".equals(normalizedKey)) return hasLegendaryStatus();
        if ("rose".equals(normalizedKey)) return hasStatusEffect(17);
        if ("ultra_instinct".equals(normalizedKey) || "ultrainstinct".equals(normalizedKey)) return hasUltraInstinctStatus();
        if ("god_of_destruction".equals(normalizedKey) || "godofdestruction".equals(normalizedKey)) return hasGodOfDestructionStatus();
        return false;
    }

    /**
     * 返回 DBC 技能表中的技能等级。
     * Returns one skill level from the DBC skill catalog.
     */
    public int getDbcSkillLevel(int skillIndex) {
        return getSkillLevelFromCatalog(skillIndex, JRMCoreH.DBCSkillsIDs);
    }

    /**
     * 返回 NC 技能表中的技能等级。
     * Returns one skill level from the NC skill catalog.
     */
    public int getNCSkillLevel(int skillIndex) {
        return getSkillLevelFromCatalog(skillIndex, JRMCoreH.NCSkillIDs);
    }

    /**
     * 判断传说状态是否激活。
     * Returns whether the legendary status is active.
     */
    public boolean isLegendaryActive() {
        return hasLegendaryStatus();
    }

    /**
     * 判断魔化状态是否激活。
     * Returns whether the Majin status is active.
     */
    public boolean isMajinActive() {
        return hasMajinStatus();
    }

    /**
     * 判断界王拳状态是否激活。
     * Returns whether the Kaioken status is active.
     */
    public boolean isKaiokenActive() {
        return hasKaiokenStatus();
    }

    /**
     * 判断 Mystic 状态是否激活。
     * Returns whether the Mystic status is active.
     */
    public boolean isMysticActive() {
        return hasMysticStatus();
    }

    /**
     * 判断自在极意功状态是否激活。
     * Returns whether the Ultra Instinct status is active.
     */
    public boolean isUltraInstinctActive() {
        return hasUltraInstinctStatus();
    }

    /**
     * 判断破坏神状态是否激活。
     * Returns whether the God of Destruction status is active.
     */
    public boolean isGodOfDestructionActive() {
        return hasGodOfDestructionStatus();
    }

    /**
     * 判断融合状态是否激活。
     * Returns whether any fusion status is active.
     */
    public boolean isFusionActive() {
        return hasFusionStatus();
    }

    /**
     * 检查给定状态效果 id 是否处于激活状态。
     * Checks whether a given status effect id is active.
     */
    public boolean hasStatusEffect(int effectId) {
        if (effectId < 0 || effectId >= JRMCoreH.StusEfcts.length) {
            return false;
        }
        return JRMCoreH.StusEfcts(effectId, JRMCoreH.getString(entityPlayer, "jrmcStatusEff"));
    }

    /**
     * 返回当前近战输出值。
     * Returns the current melee output.
     */
    public int getMelee() {
        ensureConnected();
        int release = JRMCoreH.getByte(entityPlayer, "jrmcRelease");
        int stat = JRMCoreH.stat(entityPlayer, 0, getPowerType(), 0, getAdditionAttribute(0), getRace(), getClassId(), getNCBonus());
        return (int) (stat * release * 0.01D * JRMCoreH.weightPerc(0, entityPlayer)) + getSTRSklks();
    }

    /**
     * 返回当前体魄强度值。
     * Returns the current body-strength value.
     */
    public int getBodyStrength() {
        return getCurrentAttributeValue(1);
    }

    /**
     * 返回体魄强度的最大输出值。
     * Returns the maximum body-strength output.
     */
    public int getMaxBodyStrength() {
        return getComputedStat(1);
    }

    /**
     * 返回由体魄强度推导出的被动防御。
     * Returns passive defense derived from body strength.
     */
    public int getPassive() {
        return (int) (getBodyStrength() * JRMCoreConfig.StatPasDef * 0.01F);
    }

    /**
     * 返回当前气功输出值。
     * Returns the current Ki damage output.
     */
    public int getKiPower() {
        return (int) (getMaxKiPower() * 0.01D * getCurrentRelease());
    }

    /**
     * 返回最大气功输出值。
     * Returns the maximum Ki damage output.
     */
    public int getMaxKiPower() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, 3, getPowerType(), 4, getAdditionAttribute(3), getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回生命再生率数值。
     * Returns the body-regeneration stat value.
     */
    public int getBodyRegenRate() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, -1, getPowerType(), 8, 100, getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回耐力再生率数值。
     * Returns the stamina-regeneration stat value.
     */
    public int getStaminaRegenRate() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, -1, getPowerType(), 9, 100, getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回气值再生率数值。
     * Returns the energy-regeneration stat value.
     */
    public int getEnergyRegenRate() {
        ensureConnected();
        return JRMCoreH.stat(entityPlayer, -1, getPowerType(), 10, 100, getRace(), getClassId(), 0.0F);
    }

    /**
     * 返回当前奔跑速度值。
     * Returns the current running-speed value.
     */
    public int getRunning() {
        ensureConnected();
        int speedSkillLevel = getSkillLevelFromCatalog(
            (getPowerType() == 1) ? 2 : 0,
            (getPowerType() == 1) ? JRMCoreH.DBCSkillsIDs : JRMCoreH.NCSkillIDs
        );
        return ((int) (JRMCoreH.spdFrm(Attributes[1], speedSkillLevel, 100.0F, true, false, getEffectiveState(), getCurrentState2(), getStatIncreaseMultiplier(7)) * 100.0F)) - 2;
    }

    /**
     * 返回当前飞行速度值。
     * Returns the current flying-speed value.
     */
    public int getFlying() {
        ensureConnected();
        int flyingSkillLevel = getSkillLevel(3);
        int offset = 3 - (flyingSkillLevel % 2);
        offset = flyingSkillLevel == 0 ? offset + 1 : (flyingSkillLevel == 5 ? offset - 1 : offset);
        return ((int) (JRMCoreH.spdFrm(NBTAttributes[4], getSkillLevelFromCatalog(3, JRMCoreH.DBCSkillsIDs), 100.0F, true, true, getEffectiveState(), getCurrentState2(), getStatIncreaseMultiplier(11)) * 100.0F)) - offset;
    }

    /**
     * 返回 Chakra 路线额外使用的加成值。
     * Returns the extra bonus used by Chakra routes.
     */
    public float getNCBonus() {
        int powerType = getPowerType();
        if (!JRMCoreH.isPowerTypeChakra(powerType)) {
            return 0.0F;
        }
        int ta = JRMCoreH.SklLvl(0, powerType, JRMCoreH.PlyrSkills(entityPlayer));
        int state = JRMCoreH.getInt(entityPlayer, "jrmcState");
        return ta * 0.04F + state * 0.25F;
    }

    /**
     * 返回参与派生公式计算的有效精神值。
     * Returns the effective spirit stat used by derived formulas.
     */
    public int getStatSPI() {
        ensureConnected();
        float bonus = (getPowerType() == 1) ? JRMCoreH.SklLvl_KiBs(entityPlayer, getPowerType()) : 0.0F;
        return JRMCoreH.stat(entityPlayer, 5, getPowerType(), 5, getAdditionAttribute(5), getRace(), getClassId(), bonus);
    }

    /**
     * 返回扣除技能槽消耗后的可用精神值。
     * Returns the currently available mind after skill-slot costs.
     */
    public int getAvailableMind() {
        ensureConnected();
        return NBTAttributes[4] - getSpentMindRequirement();
    }

    /**
     * 返回已装备技能总共消耗的精神需求。
     * Returns the total mind requirement consumed by equipped skills.
     */
    public int getSpentMindRequirement() {
        ensureConnected();
        String[] coreSkills;
        String[] skills;
        int[][] skillMindCosts;
        int[][] racialMindCosts = null;
        int[][] coreMindCosts = null;
        if (getPowerType() == 2) {
            coreSkills = JRMCoreH.ncCSkls;
            coreMindCosts = JRMCoreH.NCRacialSkillMindCost;
            skills = JRMCoreH.NCSkillIDs;
            skillMindCosts = JRMCoreH.NCSkillMindCost;
        } else {
            racialMindCosts = JRMCoreH.DBCRacialSkillMindCost;
            coreSkills = JRMCoreH.vlblCSkls;
            skills = JRMCoreH.DBCSkillsIDs;
            skillMindCosts = JRMCoreH.DBCSkillMindCost;
        }
        return JRMCoreH.skillSlot_SpentMindRequirement(getEntityNbt().func_74779_i("jrmcSSlts"), skills, skillMindCosts)
            + JRMCoreH.skillSlot_SpentMindRequirement_X(getSkillXData(), getRace(), racialMindCosts)
            + JRMCoreH.skillSlot_SpentMindRequirement(getEntityNbt().func_74779_i("jrmcSSltY"), coreSkills, coreMindCosts);
    }

    /**
     * 返回某个技能带来的属性加成值。
     * Returns the skill-based additive bonus for one stat lane.
     */
    public int getSklks(int skillId, double multiple) {
        ensureConnected();
        if (getPowerType() != 1) {
            return 0;
        }
        int skillLevel = JRMCoreH.SklLvl(skillId, entityPlayer);
        int release = JRMCoreH.getByte(entityPlayer, "jrmcRelease");
        return (int) (skillLevel * multiple * getStatSPI() * release * 0.01D);
    }

    /**
     * 返回力量路线的技能加成。
     * Returns the skill-based strength bonus.
     */
    public int getSTRSklks() {
        return getSklks(12, 0.0025D);
    }

    /**
     * 返回敏捷路线的技能加成。
     * Returns the skill-based dexterity bonus.
     */
    public int getDEXSklks() {
        return getSklks(11, 0.0050D);
    }

    /**
     * 返回与指定类型匹配的当前任务条目。
     * Returns the current mission entry matching the requested type.
     */
    public String[] getTask(String type) throws Exception {
        String missionSyncData = JRMCoreH.getString(entityPlayer, "JRMCmissionSync");
        if (missionSyncData == null || missionSyncData.isEmpty()) {
            throw new Exception("No mission data is available for this player.");
        }
        String[] taskEntries = missionSyncData.split(";");
        for (String entry : taskEntries) {
            String[] parts = entry.split(",");
            if (parts.length > 0 && parts[0].equals(type)) {
                return parts;
            }
        }
        throw new Exception("Requested mission type was not found.");
    }

    /**
     * 返回任务枚举对应的当前条目。
     * Returns the current task entry matching the requested task enum.
     */
    public String[] getTask(CValueTaskType taskType) throws Exception {
        if (taskType == null) {
            throw new Exception("Task type must not be null.");
        }
        return getTask(taskType.key());
    }

    /**
     * 返回任务条目数量。
     * Returns the number of mission/task entries.
     */
    public int getTaskCount() {
        String missionSyncData = getMissionSyncData();
        if (missionSyncData == null || missionSyncData.trim().isEmpty() || " ".equals(missionSyncData.trim())) {
            return 0;
        }
        String[] entries = missionSyncData.split(";");
        int count = 0;
        for (String entry : entries) {
            if (entry != null && entry.trim().length() > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 返回所有任务类型名称数组。
     * Returns the task-type array extracted from mission-sync data.
     */
    public String[] getTaskTypes() {
        String missionSyncData = getMissionSyncData();
        if (missionSyncData == null || missionSyncData.trim().isEmpty() || " ".equals(missionSyncData.trim())) {
            return new String[0];
        }
        String[] entries = missionSyncData.split(";");
        java.util.ArrayList<String> types = new java.util.ArrayList<String>();
        for (String entry : entries) {
            if (entry == null || entry.trim().isEmpty()) {
                continue;
            }
            String[] parts = entry.split(",");
            if (parts.length > 0 && parts[0].length() > 0) {
                types.add(parts[0]);
            }
        }
        return types.toArray(new String[types.size()]);
    }

    /**
     * 判断是否存在指定任务类型。
     * Returns whether the requested task type exists in mission-sync data.
     */
    public boolean hasTaskType(String type) {
        if (type == null || type.isEmpty()) {
            return false;
        }
        String[] taskTypes = getTaskTypes();
        for (String taskType : taskTypes) {
            if (type.equals(taskType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断任务枚举对应类型是否存在。
     * Returns whether the requested task enum exists in mission-sync data.
     */
    public boolean hasTaskType(CValueTaskType taskType) {
        return taskType != null && hasTaskType(taskType.key());
    }

    /**
     * 返回指定任务类型的原始条目字符串。
     * Returns the raw mission/task entry for the requested type.
     */
    public String getTaskEntryRaw(String type) throws Exception {
        return String.join(",", getTask(type));
    }

    /**
     * 返回任务枚举对应类型的原始条目字符串。
     * Returns the raw mission/task entry for the requested task enum.
     */
    public String getTaskEntryRaw(CValueTaskType taskType) throws Exception {
        if (taskType == null) {
            throw new Exception("Task type must not be null.");
        }
        return getTaskEntryRaw(taskType.key());
    }

    /**
     * 返回指定任务类型的目标数量。
     * Returns the target count for the requested task type.
     */
    public int getTaskTargetCount(String type) throws Exception {
        String[] task = getTask(type);
        return Math.max(0, task.length - 3);
    }

    /**
     * 返回任务枚举对应类型的目标数量。
     * Returns the target count for the requested task enum.
     */
    public int getTaskTargetCount(CValueTaskType taskType) throws Exception {
        if (taskType == null) {
            throw new Exception("Task type must not be null.");
        }
        return getTaskTargetCount(taskType.key());
    }

    /**
     * 返回指定任务类型的目标数组。
     * Returns the target array for the requested task type.
     */
    public String[] getTaskTargets(String type) throws Exception {
        String[] task = getTask(type);
        int targetCount = Math.max(0, task.length - 3);
        String[] targets = new String[targetCount];
        for (int i = 0; i < targetCount; i++) {
            targets[i] = task[i + 3];
        }
        return targets;
    }

    /**
     * 返回任务枚举对应类型的目标数组。
     * Returns the target array for the requested task enum.
     */
    public String[] getTaskTargets(CValueTaskType taskType) throws Exception {
        if (taskType == null) {
            throw new Exception("Task type must not be null.");
        }
        return getTaskTargets(taskType.key());
    }

    /**
     * 返回当前 Dragon Block C 主线任务 id。
     * Returns the current Dragon Block C task id.
     */
    public String getDragonBlockCTaskId() throws Exception {
        return getTask("mainDBC")[1];
    }

    /**
     * 返回当前 Dragon Block C 主线任务页码。
     * Returns the current Dragon Block C task page.
     */
    public String getDragonBlockCTaskPage() throws Exception {
        return getTask("mainDBC")[2];
    }

    /**
     * 返回指定索引的 Dragon Block C 主线任务目标。
     * Returns one indexed Dragon Block C task target.
     */
    public String getDragonBlockCTaskTarget(int targetIndex) throws Exception {
        String[] task = getTask("mainDBC");
        if (task.length < 4 + targetIndex) {
            throw new Exception("Task target index is out of range.");
        }
        return task[3 + targetIndex];
    }

    /**
     * 返回当前 Dragon Block C 主线任务目标数量。
     * Returns the current Dragon Block C task target count.
     */
    public int getDragonBlockCTaskTargetCount() throws Exception {
        return getTaskTargetCount("mainDBC");
    }

    /**
     * 返回当前 Dragon Block C 主线任务目标数组。
     * Returns the current Dragon Block C task targets array.
     */
    public String[] getDragonBlockCTaskTargets() throws Exception {
        return getTaskTargets("mainDBC");
    }

    /**
     * 确保缓存的 NBT 和属性数组已经初始化。
     * Ensures cached NBT and attribute arrays are initialized.
     */
    private void ensureConnected() {
        if (entityNbt == null || NBTAttributes == null || Attributes == null) {
            connectBaseNBT();
        }
    }

    /**
     * 重新构建当前有效属性数组。
     * Rebuilds the resolved current-attribute array.
     */
    private int[] resolveAttributes() {
        int[] attributes = new int[JRMCoreH.AttrbtNbtI.length];
        for (int i = 0; i < attributes.length; i++) {
            attributes[i] = resolveAttributeValue(i);
        }
        return attributes;
    }

    /**
     * 通过通用上游 helper 解析一个属性值。
     * Resolves one attribute value through the generic upstream helper.
     */
    protected int resolveAttributeValue(int attributeIndex) {
        return JRMCoreH.getPlayerAttribute(
            entityPlayer,
            getBaseAttributesForRaceCalculation(),
            attributeIndex,
            getCurrentState(),
            getCurrentState2(),
            getRace(),
            getSkillXData(),
            getCurrentRelease(),
            getArcReserve(),
            hasLegendaryStatus(),
            hasMajinStatus(),
            hasKaiokenStatus(),
            hasMysticStatus(),
            hasUltraInstinctStatus(),
            hasGodOfDestructionStatus(),
            getPowerType(),
            getLearnedSkills(),
            hasFusionStatus(),
            getMajinAbsorptionData()
        );
    }

    /**
     * 应用种族公式之后的共享加成，如 GoD、UI、Kaioken 和上限裁剪。
     * Applies post-race shared multipliers such as GoD, UI, Kaioken, and caps.
     */
    protected int applySharedAttributeBonuses(int raceSpecificValue, int attributeIndex) {
        int result = raceSpecificValue;
        int powerType = getPowerType();
        int state = getCurrentState();
        int state2 = getCurrentState2();
        int race = getRace();
        boolean kaiokenOn = hasKaiokenStatus();
        boolean mysticOn = hasMysticStatus();
        boolean ultraInstinctOn = hasUltraInstinctStatus();
        boolean godOfDestructionOn = hasGodOfDestructionStatus();

        if (powerType == 1 && godOfDestructionOn) {
            double formMasteryMulti = JRMCoreH.getFormMasteryAttributeMulti(entityPlayer, "GodOfDestruction", state, state2, race, kaiokenOn, mysticOn, ultraInstinctOn, godOfDestructionOn);
            result = (int) (result * (JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI * JGConfigDBCGoD.CONFIG_GOD_ATTRIBUTE_MULTI_RACE[race]) * formMasteryMulti);
        }

        if (powerType == 1 && ultraInstinctOn) {
            if (JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) {
                double formMasteryMulti = JRMCoreH.getFormMasteryAttributeMulti(entityPlayer, "UltraInstict", state, state2, race, kaiokenOn, mysticOn, ultraInstinctOn, godOfDestructionOn);
                int ultraInstinctLevel = JRMCoreH.state2UltraInstinct(false, (byte) state2);
                result = (int) (
                    result
                        * (JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI[ultraInstinctLevel] * 0.01F
                        * JGConfigUltraInstinct.CONFIG_UI_ATTRIBUTE_MULTI_RACE[ultraInstinctLevel][race])
                        * formMasteryMulti
                );
            }
        } else if (powerType == 1 && state2 < JRMCoreH.TransKaiDmg.length) {
            double formMasteryMulti = 1.0D;
            if (state2 > 0 && kaiokenOn) {
                formMasteryMulti = JRMCoreH.getFormMasteryAttributeMulti(entityPlayer, "Kaioken", state, state2, race, kaiokenOn, mysticOn, ultraInstinctOn, godOfDestructionOn);
            }
            result = (int) (
                result * JRMCoreH.TransKaiDmg[state2] * formMasteryMulti
                    + (hasMajinStatus() ? (result * JRMCoreConfig.mjn) * 0.01F : 0.0F)
                    + ((hasLegendaryStatus() && (JRMCoreH.lgndb(race, state) || mysticOn)) ? (result * JRMCoreConfig.lgnd) * 0.01F : 0.0F)
            );
        }

        if (powerType == 2 && state2 < JRMCoreH.TransGtsDmg.length) {
            result = (int) (result * JRMCoreH.TransGtsDmg[state2]);
        }

        if (!JRMCoreConfig.OverAtrLimit) {
            result = (result > JRMCoreH.checkLimit()) ? JRMCoreH.checkLimit() : result;
        }
        return (int) ((result > Double.MAX_VALUE) ? Double.MAX_VALUE : result);
    }

    /**
     * 提供种族计算所使用的基础属性数组。
     * Supplies the base attributes used by race-specific calculations.
     */
    protected int[] getBaseAttributesForRaceCalculation() {
        return NBTAttributes;
    }

    /**
     * 读取当前主形态状态值。
     * Reads the current form state.
     */
    public int getCurrentState() {
        return JRMCoreH.getInt(entityPlayer, "jrmcState");
    }

    /**
     * 读取当前副形态状态值。
     * Reads the secondary form state.
     */
    public int getCurrentState2() {
        return JRMCoreH.getInt(entityPlayer, "jrmcState2");
    }

    /**
     * 读取当前释放百分比。
     * Reads the current release percentage.
     */
    public int getCurrentRelease() {
        return JRMCoreH.getInt(entityPlayer, "jrmcRelease");
    }

    /**
     * 读取冰冻恶魔的储备值。
     * Reads the Arcosian reserve value.
     */
    public int getArcReserve() {
        return JRMCoreH.getInt(entityPlayer, "jrmcArcRsrv");
    }

    /**
     * 读取种族技能槽的原始数据。
     * Reads the racial skill slot payload.
     */
    public String getSkillXData() {
        return JRMCoreH.getString(entityPlayer, "jrmcSSltX");
    }

    /**
     * 读取当前已学习技能列表。
     * Reads the currently learned skill list.
     */
    public String[] getLearnedSkills() {
        return JRMCoreH.PlyrSkills(entityPlayer);
    }

    /**
     * 返回指定索引的已学习技能条目。
     * Returns the learned-skill entry at the given index.
     */
    public String getLearnedSkillAt(int index) {
        String[] learnedSkills = getLearnedSkills();
        if (learnedSkills == null || index < 0 || index >= learnedSkills.length) {
            return "";
        }
        return learnedSkills[index];
    }

    /**
     * 返回包含指定片段的已学习技能条目数组。
     * Returns the learned-skill entries containing the given token.
     */
    public String[] getLearnedSkillsContaining(String skillToken) {
        if (skillToken == null || skillToken.isEmpty()) {
            return new String[0];
        }
        String[] learnedSkills = getLearnedSkills();
        java.util.ArrayList<String> matches = new java.util.ArrayList<String>();
        for (String learnedSkill : learnedSkills) {
            if (learnedSkill != null && learnedSkill.contains(skillToken)) {
                matches.add(learnedSkill);
            }
        }
        return matches.toArray(new String[matches.size()]);
    }

    /**
     * 读取种族技能等级，用于种族属性公式。
     * Reads the resolved racial skill level used in race formulas.
     */
    public int getSkillXLevel() {
        return (getPowerType() == 1) ? (JRMCoreH.SklLvlX(1, getSkillXData()) - 1) : 0;
    }

    /**
     * 读取 Mystic 技能等级。
     * Reads the current Mystic skill level.
     */
    public int getMysticSkillLevel() {
        return (getPowerType() == 1) ? JRMCoreH.SklLvl(10, 1, getLearnedSkills()) : 0;
    }

    /**
     * 判断传奇状态是否激活。
     * Returns whether the legendary flag is currently active.
     */
    protected boolean hasLegendaryStatus() {
        return hasStatusEffect(14);
    }

    /**
     * 判断魔化状态是否激活。
     * Returns whether the Majin flag is currently active.
     */
    protected boolean hasMajinStatus() {
        return hasStatusEffect(12);
    }

    /**
     * 判断界王拳状态是否激活。
     * Returns whether the Kaioken flag is currently active.
     */
    protected boolean hasKaiokenStatus() {
        return hasStatusEffect(5);
    }

    /**
     * 判断 Mystic 状态是否激活。
     * Returns whether the Mystic flag is currently active.
     */
    protected boolean hasMysticStatus() {
        return hasStatusEffect(13);
    }

    /**
     * 判断自在极意功状态是否激活。
     * Returns whether the Ultra Instinct flag is currently active.
     */
    protected boolean hasUltraInstinctStatus() {
        return hasStatusEffect(19);
    }

    /**
     * 判断破坏神状态是否激活。
     * Returns whether the God of Destruction flag is currently active.
     */
    protected boolean hasGodOfDestructionStatus() {
        return hasStatusEffect(20);
    }

    /**
     * 判断任一融合状态是否激活。
     * Returns whether either fusion flag is currently active.
     */
    protected boolean hasFusionStatus() {
        return hasStatusEffect(10) || hasStatusEffect(11);
    }

    /**
     * 读取当前魔人吸收数据。
     * Reads the current Majin absorption payload.
     */
    public String getMajinAbsorptionData() {
        return JRMCoreH.getString(entityPlayer, "jrmcMajinAbsorptionData");
    }

    /**
     * 读取玩家当前力量体系类型。
     * Reads the player's current power type.
     */
    public int getPowerType() {
        return JRMCoreH.getInt(entityPlayer, "jrmcPwrtyp");
    }

    /**
     * 读取玩家当前种族 id。
     * Reads the player's current race id.
     */
    public int getRace() {
        return JRMCoreH.getInt(entityPlayer, "jrmcRace");
    }

    /**
     * 读取玩家当前职业 id。
     * Reads the player's current class id.
     */
    public int getClassId() {
        return JRMCoreH.getInt(entityPlayer, "jrmcClass");
    }

    /**
     * 解析某个 stat increase 条目的倍率。
     * Resolves one stat-increase multiplier entry.
     */
    protected float getStatIncreaseMultiplier(int statIncreaseIndex) {
        return JRMCoreH.statInc(getPowerType(), statIncreaseIndex, 100, getRace(), getClassId(), 0.0F) * 0.01F;
    }

    /**
     * 解析速度公式使用的有效形态状态。
     * Resolves the effective movement/combat state used by speed formulas.
     */
    protected int getEffectiveState() {
        if (getPowerType() == 1 && hasMysticStatus()) {
            return 1;
        }
        if (JRMCoreH.rc_humNam(getRace())) {
            return JRMCoreH.mstc_humnam();
        }
        if (JRMCoreH.rc_arc(getRace())) {
            return JRMCoreH.mstc_arc();
        }
        if (JRMCoreH.rc_sai(getRace())) {
            return JRMCoreH.mstc_sai(JRMCoreH.SklLvl(JRMCoreH.vlblRSkls, getSkillXData()) - 1);
        }
        return getCurrentState();
    }

    /**
     * 解析某个属性栏位的当前实时值。
     * Resolves the current live value of one attribute lane.
     */
    protected int getCurrentAttributeValue(int attributeIndex) {
        return (int) (getComputedStat(attributeIndex) * 0.01D * getCurrentRelease() * JRMCoreH.weightPerc(attributeIndex, entityPlayer))
            + getSkillStatBonus(attributeIndex);
    }

    /**
     * 解析某个属性栏位的最大输出值。
     * Resolves the maximum output value of one stat lane.
     */
    protected int getComputedStat(int statIndex) {
        float chakraBonus = 0.0F;
        if (getPowerType() == 2) {
            int taSkillLevel = JRMCoreH.SklLvl(0, 2, JRMCoreH.PlyrSkills);
            chakraBonus = taSkillLevel * 0.04F + getCurrentState() * 0.25F;
        }
        return JRMCoreH.stat(getPowerType(), statIndex, getAdditionAttribute(statIndex), getRace(), getClassId(), chakraBonus);
    }

    /**
     * 解析某个属性栏位由技能带来的附加值。
     * Resolves the additive bonus granted by skill levels for one attribute lane.
     */
    protected int getSkillStatBonus(int attributeIndex) {
        int spiritStat = JRMCoreH.stat(getPowerType(), 5, NBTAttributes[5], getRace(), getClassId(), (getPowerType() == 1) ? (getSkillLevel(13) * 0.01F) : 0.0F);
        if (getPowerType() == 1) {
            return (int) (getSkillLevel(12 - attributeIndex) * (0.0025D + attributeIndex * 0.0025D) * spiritStat * getCurrentRelease() * 0.01D);
        }
        return 0;
    }

    /**
     * 按玩家当前力量体系解析技能等级。
     * Resolves one skill level using the player's current power type.
     */
    public int getSkillLevel(int skillIndex) {
        switch (getPowerType()) {
            case 1:
                return getSkillLevelFromCatalog(skillIndex, JRMCoreH.DBCSkillsIDs);
            case 2:
                return getSkillLevelFromCatalog(skillIndex, JRMCoreH.NCSkillIDs);
            default:
                return 0;
        }
    }

    /**
     * 从指定技能表中解析一个技能等级。
     * Resolves one skill level from an explicit skill catalog.
     */
    protected int getSkillLevelFromCatalog(int skillIndex, String[] skillCatalog) {
        if (skillCatalog == null || skillIndex < 0 || skillIndex >= skillCatalog.length) {
            return 0;
        }
        return JRMCoreH.SklLvl(skillIndex, skillCatalog, getLearnedSkills());
    }
}
