package com.recvalue.api;

import com.recvalue.base.Base;
import com.recvalue.base.race.ArcosianRace;
import com.recvalue.base.race.HalfSaiyanRace;
import com.recvalue.base.race.HumanRace;
import com.recvalue.base.race.MajinRace;
import com.recvalue.base.race.NamekianRace;
import com.recvalue.base.race.SaiyanRace;
import com.recvalue.util.SkinUtil;
import net.minecraft.entity.player.EntityPlayer;

/**
 * CValueAPI 的基础入口与实例分组基类。
 * Base entrypoints and instance-group base for CValueAPI.
 */
public class CValueAPIBase {
    /**
     * 绑定的玩家读取视图。
     * Bound player-scoped view.
     */
    protected final CValuePlayerView view;

    /**
     * 创建实例分组基类。
     * Creates the instance-group base.
     */
    protected CValueAPIBase(CValuePlayerView view) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.view = view;
    }

    /**
     * 创建按玩家绑定的 CValueAPI 实例。
     * Creates a player-bound CValueAPI instance.
     */
    public static CValueAPI of(EntityPlayer entityPlayer) {
        return new CValueAPI(entityPlayer);
    }

    /**
     * 创建按玩家绑定的底层视图。
     * Creates a player-bound underlying view.
     */
    public static CValuePlayerView viewOf(EntityPlayer entityPlayer) {
        return new CValuePlayerView(entityPlayer);
    }

    /**
     * 返回绑定的底层视图。
     * Returns the bound underlying view.
     */
    public CValuePlayerView view() {
        return view;
    }

    /**
     * 返回绑定的底层玩家对象。
     * Returns the bound underlying player.
     */
    public EntityPlayer entityPlayer() {
        return view.entityPlayer();
    }

    /**
     * 返回绑定的种族数据包装器。
     * Returns the bound race-aware wrapper.
     */
    public Base raceData() {
        return view.raceData();
    }

    /**
     * 刷新底层视图缓存。
     * Refreshes the underlying view cache.
     */
    public CValueAPI refresh() {
        view.refresh();
        return (CValueAPI)this;
    }

    /**
     * 以 CValuePlayerView 兼容视图返回当前 API。
     * Returns the current API as a compatible CValuePlayerView.
     */
    public CValuePlayerView playerView() {
        return view;
    }

    /**
     * 返回绑定的种族数据包装器。
     * Returns the bound race-aware wrapper.
     */
    public Base race() {
        return view.raceData();
    }

    public HumanRace humanRace() { return view.humanRace(); }
    public SaiyanRace saiyanRace() { return view.saiyanRace(); }
    public HalfSaiyanRace halfSaiyanRace() { return view.halfSaiyanRace(); }
    public NamekianRace namekianRace() { return view.namekianRace(); }
    public ArcosianRace arcosianRace() { return view.arcosianRace(); }
    public MajinRace majinRace() { return view.majinRace(); }
    public SkinUtil skin() { return view.skin(); }

    /**
     * 返回玩家对应的种族感知数据包装器。
     * Resolves the race-aware data wrapper for the player.
     */
    public static Base race(EntityPlayer entityPlayer) {
        return of(entityPlayer).raceData();
    }

    /**
     * 以 HumanRace 视图返回当前玩家。
     * Returns the current player as a HumanRace view.
     */
    public static HumanRace human(EntityPlayer entityPlayer) {
        return of(entityPlayer).humanRace();
    }

    /**
     * 以 SaiyanRace 视图返回当前玩家。
     * Returns the current player as a SaiyanRace view.
     */
    public static SaiyanRace saiyan(EntityPlayer entityPlayer) {
        return of(entityPlayer).saiyanRace();
    }

    /**
     * 以 HalfSaiyanRace 视图返回当前玩家。
     * Returns the current player as a HalfSaiyanRace view.
     */
    public static HalfSaiyanRace halfSaiyan(EntityPlayer entityPlayer) {
        return of(entityPlayer).halfSaiyanRace();
    }

    /**
     * 以 NamekianRace 视图返回当前玩家。
     * Returns the current player as a NamekianRace view.
     */
    public static NamekianRace namekian(EntityPlayer entityPlayer) {
        return of(entityPlayer).namekianRace();
    }

    /**
     * 以 ArcosianRace 视图返回当前玩家。
     * Returns the current player as an ArcosianRace view.
     */
    public static ArcosianRace arcosian(EntityPlayer entityPlayer) {
        return of(entityPlayer).arcosianRace();
    }

    /**
     * 以 MajinRace 视图返回当前玩家。
     * Returns the current player as a MajinRace view.
     */
    public static MajinRace majin(EntityPlayer entityPlayer) {
        return of(entityPlayer).majinRace();
    }

    /**
     * 返回外观字符串辅助器。
     * Wraps a DNS/skin string helper for appearance editing.
     */
    public static SkinUtil skin(String skinCode) {
        return new SkinUtil(skinCode);
    }

    /**
     * 返回全局最大能量伤害值。
     * Returns the global maximum energy-damage value.
     */
    public static float getMaxEnergyDamage() {
        return JinRyuu.JRMCore.JRMCoreH.getMaxEnergyDamage();
    }

    /**
     * 计算能量体缩放值。
     * Calculates the energy-entity scale value.
     */
    public static float calculateEnergyScale(float damage, float maxDamage, float percentage, byte[] states, byte density, float minScale, float maxScale) {
        return JinRyuu.JRMCore.JRMCoreH.calculateEnergyScale(damage, maxDamage, percentage, states, density, minScale, maxScale);
    }

    /**
     * 计算技术消耗值。
     * Calculates the technique cost value.
     */
    public static int getTechniqueCost(String[] techniqueData) {
        return JinRyuu.JRMCore.JRMCoreH.costEnAt(techniqueData);
    }

    /**
     * 按指定 men 计算技术消耗值。
     * Calculates the technique cost value using the provided men value.
     */
    public static int getTechniqueCost(String[] techniqueData, int men) {
        return JinRyuu.JRMCore.JRMCoreH.costEnAt(techniqueData, men);
    }

    /**
     * 返回训练选项名称。
     * Returns the training-option display name.
     */
    public static String getTrainingOptionName(int optionIndex) {
        return JinRyuu.JRMCore.JRMCoreH.TrnngOptnsNam(optionIndex);
    }

    /**
     * 返回训练选项说明。
     * Returns the training-option description.
     */
    public static String getTrainingOptionDescription(int optionIndex) {
        return JinRyuu.JRMCore.JRMCoreH.TrnngOptnsDesc(optionIndex);
    }

    /**
     * 返回对应力量体系的瞬移音效标识。
     * Returns the teleport-sound id for the given power type.
     */
    public static String getTeleportSound(int powerType) {
        return JinRyuu.JRMCore.JRMCoreH.TeleportSound(powerType);
    }

    /**
     * 使用玩家当前皮肤代码创建外观辅助器。
     * Creates a skin helper from the player's current DNS code.
     */
    public static SkinUtil skinOf(EntityPlayer entityPlayer) {
        return of(entityPlayer).skin();
    }

    /**
     * 以 HumanRace 视图返回当前玩家。
     * Returns the current player as a HumanRace view.
     */
    public HumanRace human() {
        return view.humanRace();
    }

    /**
     * 以 SaiyanRace 视图返回当前玩家。
     * Returns the current player as a SaiyanRace view.
     */
    public SaiyanRace saiyan() {
        return view.saiyanRace();
    }

    /**
     * 以 HalfSaiyanRace 视图返回当前玩家。
     * Returns the current player as a HalfSaiyanRace view.
     */
    public HalfSaiyanRace halfSaiyan() {
        return view.halfSaiyanRace();
    }

    /**
     * 以 NamekianRace 视图返回当前玩家。
     * Returns the current player as a NamekianRace view.
     */
    public NamekianRace namekian() {
        return view.namekianRace();
    }

    /**
     * 以 ArcosianRace 视图返回当前玩家。
     * Returns the current player as an ArcosianRace view.
     */
    public ArcosianRace arcosian() {
        return view.arcosianRace();
    }

    /**
     * 以 MajinRace 视图返回当前玩家。
     * Returns the current player as a MajinRace view.
     */
    public MajinRace majin() {
        return view.majinRace();
    }

    /**
     * 使用玩家当前皮肤代码创建外观辅助器。
     * Creates a skin helper from the player's current DNS code.
     */
    public SkinUtil skinOf() {
        return view.skin();
    }

}
