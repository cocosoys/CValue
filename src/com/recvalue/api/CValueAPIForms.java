package com.recvalue.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CValueAPI 的形态、状态与元数据分组。
 * Form, status, and metadata group for CValueAPI.
 */
public class CValueAPIForms extends CValueAPISkills {
    /**
     * 创建按玩家绑定的分组视图。
     * Creates a player-bound grouped view.
     */
    protected CValueAPIForms(CValuePlayerView view) {
        super(view);
    }

    /**
     * 读取当前力量体系 id。
     * Reads the current power-type id.
     */
    public static int getPowerType(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPowerType();
    }

    /**
     * 读取当前种族 id。
     * Reads the current race id.
     */
    public static int getRaceId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRaceId();
    }

    /**
     * 读取当前职业 id。
     * Reads the current class id.
     */
    public static int getClassId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getClassId();
    }

    /**
     * 读取当前主形态状态值。
     * Reads the current primary form state value.
     */
    public static int getState(EntityPlayer entityPlayer) {
        return of(entityPlayer).getState();
    }

    /**
     * 读取当前副形态状态值。
     * Reads the current secondary form state value.
     */
    public static int getState2(EntityPlayer entityPlayer) {
        return of(entityPlayer).getState2();
    }

    /**
     * 读取当前训练点。
     * Reads the current training-point value.
     */
    public static int getTrainingPoints(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTrainingPoints();
    }

    /**
     * 读取当前变身计量条值。
     * Reads the current transformation-meter value.
     */
    public static int getTransformationMeter(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTransformationMeter();
    }

    /**
     * 读取当前阵营值。
     * Reads the current alignment value.
     */
    public static int getAlignment(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAlignment();
    }

    /**
     * 读取当前 karma 值。
     * Reads the current karma value.
     */
    public static int getKarma(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKarma();
    }

    /**
     * 读取当前经验进度值。
     * Reads the current experience-progress value.
     */
    public static int getExperience(EntityPlayer entityPlayer) {
        return of(entityPlayer).getExperience();
    }

    /**
     * 判断角色数据是否已完成接受/初始化。
     * Returns whether the character data has been accepted/initialized.
     */
    public static boolean isCharacterAccepted(EntityPlayer entityPlayer) {
        return of(entityPlayer).isCharacterAccepted();
    }

    /**
     * 读取当前难度值。
     * Reads the current difficulty value.
     */
    public static int getDifficulty(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDifficulty();
    }

    /**
     * 读取当前难度名称。
     * Reads the current difficulty name.
     */
    public static String getDifficultyName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDifficultyName();
    }

    /**
     * 读取当前难度短名称。
     * Reads the current difficulty short name.
     */
    public static String getDifficultyShortName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDifficultyShortName();
    }

    /**
     * 读取当前难度说明 key。
     * Reads the current difficulty description key.
     */
    public static String getDifficultyDescriptionKey(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDifficultyDescriptionKey();
    }

    /**
     * 读取死亡次数。
     * Reads the death count.
     */
    public static int getDeathCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDeathCount();
    }

    /**
     * 读取重力训练值。
     * Reads the gravity-training value.
     */
    public static int getGravityTraining(EntityPlayer entityPlayer) {
        return of(entityPlayer).getGravityTraining();
    }

    /**
     * 读取 KO 倒计时。
     * Reads the KO timer value.
     */
    public static int getKnockoutTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKnockoutTimer();
    }

    /**
     * 读取自在极意功热量值。
     * Reads the Ultra Instinct heat value.
     */
    public static int getUltraInstinctHeat(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUltraInstinctHeat();
    }

    /**
     * 读取自在极意功热量百分比。
     * Reads the Ultra Instinct heat percentage.
     */
    public static float getUltraInstinctHeatPercentage(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUltraInstinctHeatPercentage();
    }

    /**
     * 读取临时 strain 值。
     * Reads the temporary strain value.
     */
    public static int getStrainTemp(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStrainTemp();
    }

    /**
     * 读取当前 strain 值。
     * Reads the current strain value.
     */
    public static int getStrain(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStrain();
    }

    /**
     * 读取 strain 激活计时值。
     * Reads the strain-active timer value.
     */
    public static int getStrainActiveTicks(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStrainActiveTicks();
    }

    /**
     * 读取复活计时值。
     * Reads the revive-timer value.
     */
    public static int getReviveTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getReviveTimer();
    }

    /**
     * 读取已达成的 UI 最高状态。
     * Reads the highest Ultra Instinct state reached.
     */
    public static int getUIHighestStateReached(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUIHighestStateReached();
    }

    /**
     * 判断 UI 状态中是否记录过疼痛标记。
     * Returns whether the UI pain flag was recorded.
     */
    public static boolean wasUIInPain(EntityPlayer entityPlayer) {
        return of(entityPlayer).wasUIInPain();
    }

    /**
     * 读取 UI 疼痛持续值。
     * Reads the UI pain-duration value.
     */
    public static int getUIWasInPainDuration(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUIWasInPainDuration();
    }

    /**
     * 读取 God strain 值。
     * Reads the God strain value.
     */
    public static int getGodStrain(EntityPlayer entityPlayer) {
        return of(entityPlayer).getGodStrain();
    }

    /**
     * 读取 God power 计时值。
     * Reads the God power timer value.
     */
    public static int getGodPowerTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getGodPowerTimer();
    }

    /**
     * 读取 Mystic 计时值。
     * Reads the Mystic timer value.
     */
    public static int getMysticTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMysticTimer();
    }

    /**
     * 读取 pain 计时值。
     * Reads the pain timer value.
     */
    public static int getPainTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPainTimer();
    }

    /**
     * 读取自在极意功热量伤害值。
     * Reads the Ultra Instinct heat-damage value.
     */
    public static double getUltraInstinctHeatDamage(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUltraInstinctHeatDamage();
    }

    /**
     * 读取当前重力值。
     * Reads the current gravity-force value.
     */
    public static float getGravityForce(EntityPlayer entityPlayer) {
        return of(entityPlayer).getGravityForce();
    }

    /**
     * 读取瞬间移动计时原始字符串。
     * Reads the raw instant-transmission timer payload.
     */
    public static String getInstantTransmissionTimersRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionTimersRaw();
    }

    /**
     * 读取瞬间移动短计时值。
     * Reads the short instant-transmission timer value.
     */
    public static int getInstantTransmissionShortTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionShortTimer();
    }

    /**
     * 读取瞬间移动长计时值。
     * Reads the long instant-transmission timer value.
     */
    public static int getInstantTransmissionLongTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getInstantTransmissionLongTimer();
    }

    /**
     * 读取最近攻击者原始字符串。
     * Reads the raw last-attacker payload.
     */
    public static String getLastAttackerRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackerRaw();
    }

    /**
     * 读取最近攻击者名称。
     * Reads the last attacker name.
     */
    public static String getLastAttackerName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackerName();
    }

    /**
     * 读取最近攻击者时间戳。
     * Reads the last attacker epoch value.
     */
    public static long getLastAttackerEpoch(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackerEpoch();
    }

    /**
     * 读取原始状态效果字符串。
     * Reads the raw status-effect payload string.
     */
    public static String getStatusEffectsRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getStatusEffectsRaw();
    }

    /**
     * 读取融合原始数据字符串。
     * Reads the raw fusion payload string.
     */
    public static String getFusionRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionRaw();
    }

    /**
     * 判断是否存在可解析的融合数据。
     * Returns whether parseable fusion data is currently present.
     */
    public static boolean hasFusionData(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasFusionData();
    }

    /**
     * 读取融合参与者名称数组。
     * Reads the fusion participant-name array.
     */
    public static String[] getFusionParticipants(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionParticipants();
    }

    /**
     * 读取第一个融合参与者名称。
     * Reads the first fusion participant name.
     */
    public static String getFusionParticipantA(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionParticipantA();
    }

    /**
     * 读取第二个融合参与者名称。
     * Reads the second fusion participant name.
     */
    public static String getFusionParticipantB(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionParticipantB();
    }

    /**
     * 读取融合参与者数量。
     * Reads the number of fusion participants.
     */
    public static int getFusionParticipantCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionParticipantCount();
    }

    /**
     * 读取融合计时值。
     * Reads the fusion timer value.
     */
    public static int getFusionTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFusionTimer();
    }

    /**
     * 读取攻击计时值。
     * Reads the attack timer value.
     */
    public static int getAttackTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAttackTimer();
    }

    /**
     * 读取最近被攻击玩家计时值。
     * Reads the last-attacked-player timer value.
     */
    public static int getLastAttackedPlayerTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackedPlayerTimer();
    }

    /**
     * 读取最近被攻击玩家原始标识字符串。
     * Reads the raw last-attacked-player identifier.
     */
    public static String getLastAttackedPlayerRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackedPlayerRaw();
    }

    /**
     * 读取最近被攻击玩家标识。
     * Reads the last-attacked-player identifier.
     */
    public static String getLastAttackedPlayerId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getLastAttackedPlayerId();
    }

    /**
     * 读取 Senzu 冷却值。
     * Reads the Senzu cooldown value.
     */
    public static int getSenzuCooldown(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSenzuCooldown();
    }

    /**
     * 判断 Senzu 是否仍在冷却中。
     * Returns whether the Senzu cooldown is still active.
     */
    public static boolean isSenzuOnCooldown(EntityPlayer entityPlayer) {
        return of(entityPlayer).isSenzuOnCooldown();
    }

    /**
     * 读取难度保护计时值。
     * Reads the difficulty-reduction timer value.
     */
    public static int getDifficultyReductionTicks(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDifficultyReductionTicks();
    }

    /**
     * 判断难度保护是否激活。
     * Returns whether difficulty protection is currently active.
     */
    public static boolean isDifficultyReductionActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isDifficultyReductionActive();
    }

    /**
     * 读取原始设置字符串。
     * Reads the raw settings payload string.
     */
    public static String getSettingsRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSettingsRaw();
    }

    /**
     * 读取种族形态 mastery 的原始字符串。
     * Reads the raw racial-form mastery payload string.
     */
    public static String getRacialFormMasteryRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRacialFormMasteryRaw();
    }

    /**
     * 读取非种族形态 mastery 的原始字符串。
     * Reads the raw non-racial-form mastery payload string.
     */
    public static String getNonRacialFormMasteryRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getNonRacialFormMasteryRaw();
    }

    /**
     * 读取魔人吸收数据原始字符串。
     * Reads the raw Majin absorption payload.
     */
    public static String getMajinAbsorptionData(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMajinAbsorptionData();
    }

    /**
     * 读取当前种族名称。
     * Reads the current race name.
     */
    public static String getRaceName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRaceName();
    }

    /**
     * 读取当前职业名称。
     * Reads the current class name.
     */
    public static String getClassName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getClassName();
    }

    /**
     * 读取当前力量体系名称。
     * Reads the current power-type name.
     */
    public static String getPowerTypeName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPowerTypeName();
    }

    /**
     * 读取当前力量体系说明 key。
     * Reads the current power-type description key.
     */
    public static String getPowerTypeDescriptionKey(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPowerTypeDescriptionKey();
    }

    /**
     * 读取当前职业说明 key。
     * Reads the current class-description key.
     */
    public static String getClassDescriptionKey(EntityPlayer entityPlayer) {
        return of(entityPlayer).getClassDescriptionKey();
    }

    /**
     * 读取当前力量体系允许域名称。
     * Reads the current power-type allow-domain name.
     */
    public static String getPowerTypeAllowName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getPowerTypeAllowName();
    }

    /**
     * 读取当前职业分类名称。
     * Reads the current class-group name.
     */
    public static String getClassGroupName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getClassGroupName();
    }

    /**
     * 判断是否为自然体系玩家。
     * Returns whether the player is using the nature power type.
     */
    public static boolean isNatureUser(EntityPlayer entityPlayer) {
        return of(entityPlayer).isNatureUser();
    }

    /**
     * 判断是否为查克拉体系玩家。
     * Returns whether the player is using the Chakra power type.
     */
    public static boolean isChakraUser(EntityPlayer entityPlayer) {
        return of(entityPlayer).isChakraUser();
    }

    /**
     * 判断界王拳设置位是否已启用。
     * Returns whether the Kaioken setting flag is enabled.
     */
    public static boolean isKaiokenSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKaiokenSettingEnabled();
    }

    /**
     * 判断 Mystic 设置位是否已启用。
     * Returns whether the Mystic setting flag is enabled.
     */
    public static boolean isMysticSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isMysticSettingEnabled();
    }

    /**
     * 判断自在极意功设置位是否已启用。
     * Returns whether the Ultra Instinct setting flag is enabled.
     */
    public static boolean isUltraInstinctSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isUltraInstinctSettingEnabled();
    }

    /**
     * 判断破坏神设置位是否已启用。
     * Returns whether the God of Destruction setting flag is enabled.
     */
    public static boolean isGodOfDestructionSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isGodOfDestructionSettingEnabled();
    }

    /**
     * 判断闪避/疾冲设置位是否已启用。
     * Returns whether the Dodge/Swoop setting flag is enabled.
     */
    public static boolean isDodgeSwoopSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isDodgeSwoopSettingEnabled();
    }

    /**
     * 判断融合设置位是否已启用。
     * Returns whether the Fusion setting flag is enabled.
     */
    public static boolean isFusionSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isFusionSettingEnabled();
    }

    /**
     * 判断 Friendly Fist 设置位是否已启用。
     * Returns whether the Friendly Fist setting flag is enabled.
     */
    public static boolean isFriendlyFistSettingEnabled(EntityPlayer entityPlayer) {
        return of(entityPlayer).isFriendlyFistSettingEnabled();
    }

    /**
     * 读取阵营分类 id。
     * Reads the alignment category id.
     */
    public static int getAlignmentCategory(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAlignmentCategory();
    }

    /**
     * 判断是否为善阵营。
     * Returns whether the player is in the good alignment group.
     */
    public static boolean isGoodAlignment(EntityPlayer entityPlayer) {
        return of(entityPlayer).isGoodAlignment();
    }

    /**
     * 判断是否为中立阵营。
     * Returns whether the player is in the neutral alignment group.
     */
    public static boolean isNeutralAlignment(EntityPlayer entityPlayer) {
        return of(entityPlayer).isNeutralAlignment();
    }

    /**
     * 判断是否为恶阵营。
     * Returns whether the player is in the evil alignment group.
     */
    public static boolean isEvilAlignment(EntityPlayer entityPlayer) {
        return of(entityPlayer).isEvilAlignment();
    }

    /**
     * 读取皮肤代码。
     * Reads the player's DNS/skin code.
     */
    public static String getSkinCode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSkinCode();
    }

    /**
     * 读取发型代码。
     * Reads the player's hair code.
     */
    public static String getHairCode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getHairCode();
    }

    /**
     * 读取 aura 外观代码。
     * Reads the player's aura-appearance code.
     */
    public static String getAuraCode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAuraCode();
    }

    /**
     * 读取 aura 颜色值。
     * Reads the aura-color value.
     */
    public static int getAuraColor(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAuraColor();
    }

    /**
     * 读取训练点上限。
     * Reads the training-point cap.
     */
    public static int getMaxTrainingPoints(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMaxTrainingPoints();
    }

    /**
     * 返回全局训练点上限。
     * Returns the global training-point cap.
     */
    public static int getMaxTrainingPoints() {
        return JinRyuu.JRMCore.JRMCoreH.getMaxTP();
    }

    /**
     * 读取第一训练点限制值。
     * Reads the first training-point limit value.
     */
    public static int getTrainingPointLimit(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTrainingPointLimit();
    }

    /**
     * 读取第二训练点限制值。
     * Reads the second training-point limit value.
     */
    public static int getTrainingPointLimit2(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTrainingPointLimit2();
    }

    /**
     * 读取剩余愿望次数。
     * Reads the current wish count.
     */
    public static int getWishes(EntityPlayer entityPlayer) {
        return of(entityPlayer).getWishes();
    }

    /**
     * 读取龙球/神龙标记值。
     * Reads the dragon flag/count value.
     */
    public static int getDragonCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getDragonCount();
    }

    /**
     * 读取魔人吸收计时值。
     * Reads the Majin absorption timer value.
     */
    public static int getMajinAbsorptionTimer(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMajinAbsorptionTimer();
    }

    /**
     * 读取魔人吸收值。
     * Reads the Majin absorption value.
     */
    public static int getMajinAbsorptionValue(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMajinAbsorptionValue();
    }

    /**
     * 读取魔人吸收分段数组。
     * Reads the Majin absorption segments split by comma.
     */
    public static String[] getMajinAbsorptionParts(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMajinAbsorptionParts();
    }

    /**
     * 读取指定索引的魔人吸收分段。
     * Reads the Majin absorption segment at the given index.
     */
    public static String getMajinAbsorptionPart(EntityPlayer entityPlayer, int index) {
        return of(entityPlayer).getMajinAbsorptionPart(index);
    }

    /**
     * 读取当前 Majin 形态 id。
     * Reads the current Majin form id.
     */
    public static int getMajinFormId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMajinFormId();
    }

    /**
     * 读取当前 Arcosian 形态 id。
     * Reads the current Arcosian form id.
     */
    public static int getArcosianFormId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getArcosianFormId();
    }

    /**
     * 读取当前形态熟练度。
     * Reads the mastery value of the current form.
     */
    public static double getCurrentFormMastery(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentFormMastery();
    }

    /**
     * 读取完整 form mastery 数据字符串。
     * Reads the full form-mastery data payload.
     */
    public static String getFormMasteryDataRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getFormMasteryDataRaw();
    }

    /**
     * 判断当前形态是否满足 mastery 要求。
     * Returns whether the current form satisfies its mastery requirements.
     */
    public static boolean hasRequiredCurrentFormMasteries(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasRequiredCurrentFormMasteries();
    }

    /**
     * 判断指定形态是否满足 mastery 要求。
     * Returns whether the requested form satisfies its mastery requirements.
     */
    public static boolean hasRequiredFormMasteries(EntityPlayer entityPlayer, String formName) {
        return of(entityPlayer).hasRequiredFormMasteries(formName);
    }

    /**
     * 读取当前形态名称。
     * Reads the current form name.
     */
    public static String getCurrentFormName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentFormName();
    }

    /**
     * 按形态名称返回当前种族上下文中的 form id。
     * Returns the form id for the given form name in the current race context.
     */
    public static int getFormIdByName(EntityPlayer entityPlayer, String formName) {
        return of(entityPlayer).getFormIdByName(formName);
    }

    /**
     * 读取当前形态 id。
     * Reads the current form id.
     */
    public static int getCurrentFormId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getCurrentFormId();
    }

    /**
     * 判断当前是否处于指定形态。
     * Returns whether the player is currently in the requested form.
     */
    public static boolean isCurrentForm(EntityPlayer entityPlayer, String formName) {
        return of(entityPlayer).isCurrentForm(formName);
    }

    /**
     * 读取当前自在极意功等级。
     * Reads the current Ultra Instinct level.
     */
    public static int getUltraInstinctLevel(EntityPlayer entityPlayer) {
        return of(entityPlayer).getUltraInstinctLevel();
    }

    /**
     * 判断赛亚人是否处于 Full Power 分支。
     * Returns whether a Saiyan currently satisfies the Full Power branch.
     */
    public static boolean isSaiyanSuperFullPower(EntityPlayer entityPlayer) {
        return of(entityPlayer).isSaiyanSuperFullPower();
    }

    /**
     * 读取降阶时将回落到的形态 id。
     * Reads the form id used when descending from the current transformation.
     */
    public static int getTransformationDescendFormId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTransformationDescendFormId();
    }

    /**
     * 读取阵营名称。
     * Reads the alignment-group name.
     */
    public static String getAlignmentName(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAlignmentName();
    }

    /**
     * 读取阵营颜色值。
     * Reads the alignment color value.
     */
    public static int getAlignmentColor(EntityPlayer entityPlayer) {
        return of(entityPlayer).getAlignmentColor();
    }

    /**
     * 读取尾巴模式值。
     * Reads the tail-mode value.
     */
    public static int getTailMode(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTailMode();
    }

    /**
     * 判断当前是否拥有尾巴。
     * Returns whether the current tail-mode indicates a tail is present.
     */
    public static boolean hasTail(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasTail();
    }

    /**
     * 判断当前形态是否为种族形态。
     * Returns whether the current form is racial.
     */
    public static boolean isCurrentFormRacial(EntityPlayer entityPlayer) {
        return of(entityPlayer).isCurrentFormRacial();
    }

    /**
     * 判断当前形态是否为非种族形态。
     * Returns whether the current form is non-racial.
     */
    public static boolean isCurrentFormNonRacial(EntityPlayer entityPlayer) {
        return of(entityPlayer).isCurrentFormNonRacial();
    }

    /**
     * 读取玩家当前种族形态的熟练度。
     * Reads the mastery value of the player's current racial form.
     */
    public static double getRaceFormMastery(EntityPlayer entityPlayer) {
        return of(entityPlayer).getRaceFormMastery();
    }

    /**
     * 读取指定形态名称的熟练度。
     * Reads the mastery value of a named form.
     */
    public static double getFormMasteryValue(EntityPlayer entityPlayer, String formName) {
        return of(entityPlayer).getFormMasteryValue(formName);
    }

    /**
     * 读取 Chakra 路线额外加成。
     * Reads the extra bonus used by Chakra routes.
     */
    public static float getChakraBonus(EntityPlayer entityPlayer) {
        return of(entityPlayer).getChakraBonus();
    }

    /**
     * 检查指定状态效果 id 是否激活。
     * Checks whether the given status effect id is active.
     */
    public static boolean hasStatusEffect(EntityPlayer entityPlayer, int effectId) {
        return of(entityPlayer).hasStatusEffect(effectId);
    }

    /**
     * 检查指定状态效果枚举是否激活。
     * Checks whether the given status effect enum entry is active.
     */
    public static boolean hasStatusEffect(EntityPlayer entityPlayer, CValueStatusEffect effect) {
        return of(entityPlayer).hasStatusEffect(effect);
    }

    /**
     * 按稳定 key 检查状态效果是否激活。
     * Checks whether the status effect identified by key is active.
     */
    public static boolean hasStatusEffect(EntityPlayer entityPlayer, String effectKey) {
        return of(entityPlayer).hasStatusEffect(effectKey);
    }

    /**
     * 返回当前已知且激活的状态效果列表。
     * Returns the currently active known status effects.
     */
    public static CValueStatusEffect[] getKnownActiveStatusEffects(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKnownActiveStatusEffects();
    }

    /**
     * 返回当前已知且激活的状态效果 key 列表。
     * Returns the keys of the currently active known status effects.
     */
    public static String[] getKnownActiveStatusEffectKeys(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKnownActiveStatusEffectKeys();
    }

    /**
     * 返回当前已知且激活的状态效果数量。
     * Returns the count of currently active known status effects.
     */
    public static int getKnownActiveStatusEffectCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKnownActiveStatusEffectCount();
    }

    /**
     * 判断是否存在已知且激活的状态效果。
     * Returns whether any known status effect is currently active.
     */
    public static boolean hasKnownActiveStatusEffects(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasKnownActiveStatusEffects();
    }

    /**
     * 返回当前已知且激活的状态效果 id 列表。
     * Returns the ids of the currently active known status effects.
     */
    public static int[] getKnownActiveStatusEffectIds(EntityPlayer entityPlayer) {
        return of(entityPlayer).getKnownActiveStatusEffectIds();
    }

    /**
     * 判断传说状态是否激活。
     * Returns whether the legendary status is active.
     */
    public static boolean isLegendaryActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isLegendaryActive();
    }

    /**
     * 判断魔化状态是否激活。
     * Returns whether the Majin status is active.
     */
    public static boolean isMajinActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isMajinActive();
    }

    /**
     * 判断界王拳状态是否激活。
     * Returns whether the Kaioken status is active.
     */
    public static boolean isKaiokenActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isKaiokenActive();
    }

    /**
     * 判断 Mystic 状态是否激活。
     * Returns whether the Mystic status is active.
     */
    public static boolean isMysticActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isMysticActive();
    }

    /**
     * 判断自在极意功状态是否激活。
     * Returns whether the Ultra Instinct status is active.
     */
    public static boolean isUltraInstinctActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isUltraInstinctActive();
    }

    /**
     * 判断破坏神状态是否激活。
     * Returns whether the God of Destruction status is active.
     */
    public static boolean isGodOfDestructionActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isGodOfDestructionActive();
    }

    /**
     * 判断融合状态是否激活。
     * Returns whether any fusion status is active.
     */
    public static boolean isFusionActive(EntityPlayer entityPlayer) {
        return of(entityPlayer).isFusionActive();
    }

    /**
     * 读取当前力量体系 id。
     * Reads the current power-type id.
     */
    public int getPowerType() {
        return view.getPowerType();
    }

    /**
     * 读取当前种族 id。
     * Reads the current race id.
     */
    public int getRaceId() {
        return view.getRaceId();
    }

    /**
     * 读取当前职业 id。
     * Reads the current class id.
     */
    public int getClassId() {
        return view.getClassId();
    }

    /**
     * 读取当前主形态状态值。
     * Reads the current primary form state value.
     */
    public int getState() {
        return view.getState();
    }

    /**
     * 读取当前副形态状态值。
     * Reads the current secondary form state value.
     */
    public int getState2() {
        return view.getState2();
    }

    /**
     * 读取当前训练点。
     * Reads the current training-point value.
     */
    public int getTrainingPoints() {
        return view.getTrainingPoints();
    }

    /**
     * 读取当前变身计量条值。
     * Reads the current transformation-meter value.
     */
    public int getTransformationMeter() {
        return view.getTransformationMeter();
    }

    /**
     * 读取当前阵营值。
     * Reads the current alignment value.
     */
    public int getAlignment() {
        return view.getAlignment();
    }

    /**
     * 读取当前 karma 值。
     * Reads the current karma value.
     */
    public int getKarma() {
        return view.getKarma();
    }

    /**
     * 读取当前经验进度值。
     * Reads the current experience-progress value.
     */
    public int getExperience() {
        return view.getExperience();
    }

    /**
     * 判断角色数据是否已完成接受/初始化。
     * Returns whether the character data has been accepted/initialized.
     */
    public boolean isCharacterAccepted() {
        return view.isCharacterAccepted();
    }

    /**
     * 读取当前难度值。
     * Reads the current difficulty value.
     */
    public int getDifficulty() {
        return view.getDifficulty();
    }

    /**
     * 读取当前难度名称。
     * Reads the current difficulty name.
     */
    public String getDifficultyName() {
        return view.getDifficultyName();
    }

    /**
     * 读取当前难度短名称。
     * Reads the current difficulty short name.
     */
    public String getDifficultyShortName() {
        return view.getDifficultyShortName();
    }

    /**
     * 读取当前难度说明 key。
     * Reads the current difficulty description key.
     */
    public String getDifficultyDescriptionKey() {
        return view.getDifficultyDescriptionKey();
    }

    /**
     * 读取死亡次数。
     * Reads the death count.
     */
    public int getDeathCount() {
        return view.getDeathCount();
    }

    /**
     * 读取重力训练值。
     * Reads the gravity-training value.
     */
    public int getGravityTraining() {
        return view.getGravityTraining();
    }

    /**
     * 读取 KO 倒计时。
     * Reads the KO timer value.
     */
    public int getKnockoutTimer() {
        return view.getKnockoutTimer();
    }

    /**
     * 读取自在极意功热量值。
     * Reads the Ultra Instinct heat value.
     */
    public int getUltraInstinctHeat() {
        return view.getUltraInstinctHeat();
    }

    /**
     * 读取自在极意功热量百分比。
     * Reads the Ultra Instinct heat percentage.
     */
    public float getUltraInstinctHeatPercentage() {
        return view.getUltraInstinctHeatPercentage();
    }

    /**
     * 读取临时 strain 值。
     * Reads the temporary strain value.
     */
    public int getStrainTemp() {
        return view.getStrainTemp();
    }

    /**
     * 读取当前 strain 值。
     * Reads the current strain value.
     */
    public int getStrain() {
        return view.getStrain();
    }

    /**
     * 读取 strain 激活计时值。
     * Reads the strain-active timer value.
     */
    public int getStrainActiveTicks() {
        return view.getStrainActiveTicks();
    }

    /**
     * 读取复活计时值。
     * Reads the revive-timer value.
     */
    public int getReviveTimer() {
        return view.getReviveTimer();
    }

    /**
     * 读取已达成的 UI 最高状态。
     * Reads the highest Ultra Instinct state reached.
     */
    public int getUIHighestStateReached() {
        return view.getUIHighestStateReached();
    }

    /**
     * 判断 UI 状态中是否记录过疼痛标记。
     * Returns whether the UI pain flag was recorded.
     */
    public boolean wasUIInPain() {
        return view.wasUIInPain();
    }

    /**
     * 读取 UI 疼痛持续值。
     * Reads the UI pain-duration value.
     */
    public int getUIWasInPainDuration() {
        return view.getUIWasInPainDuration();
    }

    /**
     * 读取 God strain 值。
     * Reads the God strain value.
     */
    public int getGodStrain() {
        return view.getGodStrain();
    }

    /**
     * 读取 God power 计时值。
     * Reads the God power timer value.
     */
    public int getGodPowerTimer() {
        return view.getGodPowerTimer();
    }

    /**
     * 读取 Mystic 计时值。
     * Reads the Mystic timer value.
     */
    public int getMysticTimer() {
        return view.getMysticTimer();
    }

    /**
     * 读取 pain 计时值。
     * Reads the pain timer value.
     */
    public int getPainTimer() {
        return view.getPainTimer();
    }

    /**
     * 读取自在极意功热量伤害值。
     * Reads the Ultra Instinct heat-damage value.
     */
    public double getUltraInstinctHeatDamage() {
        return view.getUltraInstinctHeatDamage();
    }

    /**
     * 读取当前重力值。
     * Reads the current gravity-force value.
     */
    public float getGravityForce() {
        return view.getGravityForce();
    }

    /**
     * 读取瞬间移动计时原始字符串。
     * Reads the raw instant-transmission timer payload.
     */
    public String getInstantTransmissionTimersRaw() {
        return view.getInstantTransmissionTimersRaw();
    }

    /**
     * 读取瞬间移动短计时值。
     * Reads the short instant-transmission timer value.
     */
    public int getInstantTransmissionShortTimer() {
        return view.getInstantTransmissionShortTimer();
    }

    /**
     * 读取瞬间移动长计时值。
     * Reads the long instant-transmission timer value.
     */
    public int getInstantTransmissionLongTimer() {
        return view.getInstantTransmissionLongTimer();
    }

    /**
     * 读取最近攻击者原始字符串。
     * Reads the raw last-attacker payload.
     */
    public String getLastAttackerRaw() {
        return view.getLastAttackerRaw();
    }

    /**
     * 读取最近攻击者名称。
     * Reads the last attacker name.
     */
    public String getLastAttackerName() {
        return view.getLastAttackerName();
    }

    /**
     * 读取最近攻击者时间戳。
     * Reads the last attacker epoch value.
     */
    public long getLastAttackerEpoch() {
        return view.getLastAttackerEpoch();
    }

    /**
     * 读取原始状态效果字符串。
     * Reads the raw status-effect payload string.
     */
    public String getStatusEffectsRaw() {
        return view.getStatusEffectsRaw();
    }

    /**
     * 读取融合原始数据字符串。
     * Reads the raw fusion payload string.
     */
    public String getFusionRaw() {
        return view.getFusionRaw();
    }

    /**
     * 判断是否存在可解析的融合数据。
     * Returns whether parseable fusion data is currently present.
     */
    public boolean hasFusionData() {
        return view.hasFusionData();
    }

    /**
     * 读取融合参与者名称数组。
     * Reads the fusion participant-name array.
     */
    public String[] getFusionParticipants() {
        return view.getFusionParticipants();
    }

    /**
     * 读取第一个融合参与者名称。
     * Reads the first fusion participant name.
     */
    public String getFusionParticipantA() {
        return view.getFusionParticipantA();
    }

    /**
     * 读取第二个融合参与者名称。
     * Reads the second fusion participant name.
     */
    public String getFusionParticipantB() {
        return view.getFusionParticipantB();
    }

    /**
     * 读取融合参与者数量。
     * Reads the number of fusion participants.
     */
    public int getFusionParticipantCount() {
        return view.getFusionParticipantCount();
    }

    /**
     * 读取融合计时值。
     * Reads the fusion timer value.
     */
    public int getFusionTimer() {
        return view.getFusionTimer();
    }

    /**
     * 读取攻击计时值。
     * Reads the attack timer value.
     */
    public int getAttackTimer() {
        return view.getAttackTimer();
    }

    /**
     * 读取最近被攻击玩家计时值。
     * Reads the last-attacked-player timer value.
     */
    public int getLastAttackedPlayerTimer() {
        return view.getLastAttackedPlayerTimer();
    }

    /**
     * 读取最近被攻击玩家原始标识字符串。
     * Reads the raw last-attacked-player identifier.
     */
    public String getLastAttackedPlayerRaw() {
        return view.getLastAttackedPlayerRaw();
    }

    /**
     * 读取最近被攻击玩家标识。
     * Reads the last-attacked-player identifier.
     */
    public String getLastAttackedPlayerId() {
        return view.getLastAttackedPlayerId();
    }

    /**
     * 读取 Senzu 冷却值。
     * Reads the Senzu cooldown value.
     */
    public int getSenzuCooldown() {
        return view.getSenzuCooldown();
    }

    /**
     * 判断 Senzu 是否仍在冷却中。
     * Returns whether the Senzu cooldown is still active.
     */
    public boolean isSenzuOnCooldown() {
        return view.isSenzuOnCooldown();
    }

    /**
     * 读取难度保护计时值。
     * Reads the difficulty-reduction timer value.
     */
    public int getDifficultyReductionTicks() {
        return view.getDifficultyReductionTicks();
    }

    /**
     * 判断难度保护是否激活。
     * Returns whether difficulty protection is currently active.
     */
    public boolean isDifficultyReductionActive() {
        return view.isDifficultyReductionActive();
    }

    /**
     * 读取原始设置字符串。
     * Reads the raw settings payload string.
     */
    public String getSettingsRaw() {
        return view.getSettingsRaw();
    }

    /**
     * 读取种族形态 mastery 的原始字符串。
     * Reads the raw racial-form mastery payload string.
     */
    public String getRacialFormMasteryRaw() {
        return view.getRacialFormMasteryRaw();
    }

    /**
     * 读取非种族形态 mastery 的原始字符串。
     * Reads the raw non-racial-form mastery payload string.
     */
    public String getNonRacialFormMasteryRaw() {
        return view.getNonRacialFormMasteryRaw();
    }

    /**
     * 读取魔人吸收数据原始字符串。
     * Reads the raw Majin absorption payload.
     */
    public String getMajinAbsorptionData() {
        return view.getMajinAbsorptionData();
    }

    /**
     * 读取当前种族名称。
     * Reads the current race name.
     */
    public String getRaceName() {
        return view.getRaceName();
    }

    /**
     * 读取当前职业名称。
     * Reads the current class name.
     */
    public String getClassName() {
        return view.getClassName();
    }

    /**
     * 读取当前力量体系名称。
     * Reads the current power-type name.
     */
    public String getPowerTypeName() {
        return view.getPowerTypeName();
    }

    /**
     * 读取当前力量体系说明 key。
     * Reads the current power-type description key.
     */
    public String getPowerTypeDescriptionKey() {
        return view.getPowerTypeDescriptionKey();
    }

    /**
     * 读取当前职业说明 key。
     * Reads the current class-description key.
     */
    public String getClassDescriptionKey() {
        return view.getClassDescriptionKey();
    }

    /**
     * 读取当前力量体系允许域名称。
     * Reads the current power-type allow-domain name.
     */
    public String getPowerTypeAllowName() {
        return view.getPowerTypeAllowName();
    }

    /**
     * 读取当前职业分类名称。
     * Reads the current class-group name.
     */
    public String getClassGroupName() {
        return view.getClassGroupName();
    }

    /**
     * 判断是否为自然体系玩家。
     * Returns whether the player is using the nature power type.
     */
    public boolean isNatureUser() {
        return view.isNatureUser();
    }

    /**
     * 判断是否为查克拉体系玩家。
     * Returns whether the player is using the Chakra power type.
     */
    public boolean isChakraUser() {
        return view.isChakraUser();
    }

    /**
     * 判断界王拳设置位是否已启用。
     * Returns whether the Kaioken setting flag is enabled.
     */
    public boolean isKaiokenSettingEnabled() {
        return view.isKaiokenSettingEnabled();
    }

    /**
     * 判断 Mystic 设置位是否已启用。
     * Returns whether the Mystic setting flag is enabled.
     */
    public boolean isMysticSettingEnabled() {
        return view.isMysticSettingEnabled();
    }

    /**
     * 判断自在极意功设置位是否已启用。
     * Returns whether the Ultra Instinct setting flag is enabled.
     */
    public boolean isUltraInstinctSettingEnabled() {
        return view.isUltraInstinctSettingEnabled();
    }

    /**
     * 判断破坏神设置位是否已启用。
     * Returns whether the God of Destruction setting flag is enabled.
     */
    public boolean isGodOfDestructionSettingEnabled() {
        return view.isGodOfDestructionSettingEnabled();
    }

    /**
     * 判断闪避/疾冲设置位是否已启用。
     * Returns whether the Dodge/Swoop setting flag is enabled.
     */
    public boolean isDodgeSwoopSettingEnabled() {
        return view.isDodgeSwoopSettingEnabled();
    }

    /**
     * 判断融合设置位是否已启用。
     * Returns whether the Fusion setting flag is enabled.
     */
    public boolean isFusionSettingEnabled() {
        return view.isFusionSettingEnabled();
    }

    /**
     * 判断 Friendly Fist 设置位是否已启用。
     * Returns whether the Friendly Fist setting flag is enabled.
     */
    public boolean isFriendlyFistSettingEnabled() {
        return view.isFriendlyFistSettingEnabled();
    }

    /**
     * 读取阵营分类 id。
     * Reads the alignment category id.
     */
    public int getAlignmentCategory() {
        return view.getAlignmentCategory();
    }

    /**
     * 判断是否为善阵营。
     * Returns whether the player is in the good alignment group.
     */
    public boolean isGoodAlignment() {
        return view.isGoodAlignment();
    }

    /**
     * 判断是否为中立阵营。
     * Returns whether the player is in the neutral alignment group.
     */
    public boolean isNeutralAlignment() {
        return view.isNeutralAlignment();
    }

    /**
     * 判断是否为恶阵营。
     * Returns whether the player is in the evil alignment group.
     */
    public boolean isEvilAlignment() {
        return view.isEvilAlignment();
    }

    /**
     * 读取皮肤代码。
     * Reads the player's DNS/skin code.
     */
    public String getSkinCode() {
        return view.getSkinCode();
    }

    /**
     * 读取发型代码。
     * Reads the player's hair code.
     */
    public String getHairCode() {
        return view.getHairCode();
    }

    /**
     * 读取 aura 外观代码。
     * Reads the player's aura-appearance code.
     */
    public String getAuraCode() {
        return view.getAuraCode();
    }

    /**
     * 读取 aura 颜色值。
     * Reads the aura-color value.
     */
    public int getAuraColor() {
        return view.getAuraColor();
    }

    /**
     * 读取第一训练点限制值。
     * Reads the first training-point limit value.
     */
    public int getTrainingPointLimit() {
        return view.getTrainingPointLimit();
    }

    /**
     * 读取第二训练点限制值。
     * Reads the second training-point limit value.
     */
    public int getTrainingPointLimit2() {
        return view.getTrainingPointLimit2();
    }

    /**
     * 读取剩余愿望次数。
     * Reads the current wish count.
     */
    public int getWishes() {
        return view.getWishes();
    }

    /**
     * 读取龙球/神龙标记值。
     * Reads the dragon flag/count value.
     */
    public int getDragonCount() {
        return view.getDragonCount();
    }

    /**
     * 读取魔人吸收计时值。
     * Reads the Majin absorption timer value.
     */
    public int getMajinAbsorptionTimer() {
        return view.getMajinAbsorptionTimer();
    }

    /**
     * 读取魔人吸收值。
     * Reads the Majin absorption value.
     */
    public int getMajinAbsorptionValue() {
        return view.getMajinAbsorptionValue();
    }

    /**
     * 读取魔人吸收分段数组。
     * Reads the Majin absorption segments split by comma.
     */
    public String[] getMajinAbsorptionParts() {
        return view.getMajinAbsorptionParts();
    }

    /**
     * 读取指定索引的魔人吸收分段。
     * Reads the Majin absorption segment at the given index.
     */
    public String getMajinAbsorptionPart(int index) {
        return view.getMajinAbsorptionPart(index);
    }

    /**
     * 读取当前 Majin 形态 id。
     * Reads the current Majin form id.
     */
    public int getMajinFormId() {
        return view.getMajinFormId();
    }

    /**
     * 读取当前 Arcosian 形态 id。
     * Reads the current Arcosian form id.
     */
    public int getArcosianFormId() {
        return view.getArcosianFormId();
    }

    /**
     * 读取当前形态熟练度。
     * Reads the mastery value of the current form.
     */
    public double getCurrentFormMastery() {
        return view.getCurrentFormMastery();
    }

    /**
     * 读取完整 form mastery 数据字符串。
     * Reads the full form-mastery data payload.
     */
    public String getFormMasteryDataRaw() {
        return view.getFormMasteryDataRaw();
    }

    /**
     * 判断当前形态是否满足 mastery 要求。
     * Returns whether the current form satisfies its mastery requirements.
     */
    public boolean hasRequiredCurrentFormMasteries() {
        return view.hasRequiredCurrentFormMasteries();
    }

    /**
     * 判断指定形态是否满足 mastery 要求。
     * Returns whether the requested form satisfies its mastery requirements.
     */
    public boolean hasRequiredFormMasteries(String formName) {
        return view.hasRequiredFormMasteries(formName);
    }

    /**
     * 读取当前形态名称。
     * Reads the current form name.
     */
    public String getCurrentFormName() {
        return view.getCurrentFormName();
    }

    /**
     * 按形态名称返回当前种族上下文中的 form id。
     * Returns the form id for the given form name in the current race context.
     */
    public int getFormIdByName(String formName) {
        return view.getFormIdByName(formName);
    }

    /**
     * 读取当前形态 id。
     * Reads the current form id.
     */
    public int getCurrentFormId() {
        return view.getCurrentFormId();
    }

    /**
     * 判断当前是否处于指定形态。
     * Returns whether the player is currently in the requested form.
     */
    public boolean isCurrentForm(String formName) {
        return view.isCurrentForm(formName);
    }

    /**
     * 读取当前自在极意功等级。
     * Reads the current Ultra Instinct level.
     */
    public int getUltraInstinctLevel() {
        return view.getUltraInstinctLevel();
    }

    /**
     * 判断赛亚人是否处于 Full Power 分支。
     * Returns whether a Saiyan currently satisfies the Full Power branch.
     */
    public boolean isSaiyanSuperFullPower() {
        return view.isSaiyanSuperFullPower();
    }

    /**
     * 读取降阶时将回落到的形态 id。
     * Reads the form id used when descending from the current transformation.
     */
    public int getTransformationDescendFormId() {
        return view.getTransformationDescendFormId();
    }

    /**
     * 读取阵营名称。
     * Reads the alignment-group name.
     */
    public String getAlignmentName() {
        return view.getAlignmentName();
    }

    /**
     * 读取阵营颜色值。
     * Reads the alignment color value.
     */
    public int getAlignmentColor() {
        return view.getAlignmentColor();
    }

    /**
     * 读取尾巴模式值。
     * Reads the tail-mode value.
     */
    public int getTailMode() {
        return view.getTailMode();
    }

    /**
     * 判断当前是否拥有尾巴。
     * Returns whether the current tail-mode indicates a tail is present.
     */
    public boolean hasTail() {
        return view.hasTail();
    }

    /**
     * 判断当前形态是否为种族形态。
     * Returns whether the current form is racial.
     */
    public boolean isCurrentFormRacial() {
        return view.isCurrentFormRacial();
    }

    /**
     * 判断当前形态是否为非种族形态。
     * Returns whether the current form is non-racial.
     */
    public boolean isCurrentFormNonRacial() {
        return view.isCurrentFormNonRacial();
    }

    /**
     * 读取玩家当前种族形态的熟练度。
     * Reads the mastery value of the player's current racial form.
     */
    public double getRaceFormMastery() {
        return view.getRaceFormMastery();
    }

    /**
     * 读取指定形态名称的熟练度。
     * Reads the mastery value of a named form.
     */
    public double getFormMasteryValue(String formName) {
        return view.getFormMasteryValue(formName);
    }

    /**
     * 读取 Chakra 路线额外加成。
     * Reads the extra bonus used by Chakra routes.
     */
    public float getChakraBonus() {
        return view.getChakraBonus();
    }

    /**
     * 检查指定状态效果 id 是否激活。
     * Checks whether the given status effect id is active.
     */
    public boolean hasStatusEffect(int effectId) {
        return view.hasStatusEffect(effectId);
    }

    /**
     * 检查指定状态效果枚举是否激活。
     * Checks whether the given status effect enum entry is active.
     */
    public boolean hasStatusEffect(CValueStatusEffect effect) {
        return view.hasStatusEffect(effect);
    }

    /**
     * 按稳定 key 检查状态效果是否激活。
     * Checks whether the status effect identified by key is active.
     */
    public boolean hasStatusEffect(String effectKey) {
        return view.hasStatusEffect(effectKey);
    }

    /**
     * 返回当前已知且激活的状态效果列表。
     * Returns the currently active known status effects.
     */
    public CValueStatusEffect[] getKnownActiveStatusEffects() {
        return view.getKnownActiveStatusEffects();
    }

    /**
     * 返回当前已知且激活的状态效果 key 列表。
     * Returns the keys of the currently active known status effects.
     */
    public String[] getKnownActiveStatusEffectKeys() {
        return view.getKnownActiveStatusEffectKeys();
    }

    /**
     * 返回当前已知且激活的状态效果数量。
     * Returns the count of currently active known status effects.
     */
    public int getKnownActiveStatusEffectCount() {
        return view.getKnownActiveStatusEffectCount();
    }

    /**
     * 判断是否存在已知且激活的状态效果。
     * Returns whether any known status effect is currently active.
     */
    public boolean hasKnownActiveStatusEffects() {
        return view.hasKnownActiveStatusEffects();
    }

    /**
     * 返回当前已知且激活的状态效果 id 列表。
     * Returns the ids of the currently active known status effects.
     */
    public int[] getKnownActiveStatusEffectIds() {
        return view.getKnownActiveStatusEffectIds();
    }

    /**
     * 判断传说状态是否激活。
     * Returns whether the legendary status is active.
     */
    public boolean isLegendaryActive() {
        return view.isLegendaryActive();
    }

    /**
     * 判断魔化状态是否激活。
     * Returns whether the Majin status is active.
     */
    public boolean isMajinActive() {
        return view.isMajinActive();
    }

    /**
     * 判断界王拳状态是否激活。
     * Returns whether the Kaioken status is active.
     */
    public boolean isKaiokenActive() {
        return view.isKaiokenActive();
    }

    /**
     * 判断 Mystic 状态是否激活。
     * Returns whether the Mystic status is active.
     */
    public boolean isMysticActive() {
        return view.isMysticActive();
    }

    /**
     * 判断自在极意功状态是否激活。
     * Returns whether the Ultra Instinct status is active.
     */
    public boolean isUltraInstinctActive() {
        return view.isUltraInstinctActive();
    }

    /**
     * 判断破坏神状态是否激活。
     * Returns whether the God of Destruction status is active.
     */
    public boolean isGodOfDestructionActive() {
        return view.isGodOfDestructionActive();
    }

    /**
     * 判断融合状态是否激活。
     * Returns whether any fusion status is active.
     */
    public boolean isFusionActive() {
        return view.isFusionActive();
    }

}
