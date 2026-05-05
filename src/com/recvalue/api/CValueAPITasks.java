package com.recvalue.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CValueAPI 的任务与剧情分组。
 * Task and mission group for CValueAPI.
 */
public class CValueAPITasks extends CValueAPIForms {
    /**
     * 创建按玩家绑定的分组视图。
     * Creates a player-bound grouped view.
     */
    protected CValueAPITasks(CValuePlayerView view) {
        super(view);
    }

    /**
     * 读取任务同步版本字符串。
     * Reads the mission-sync version string.
     */
    public static String getMissionSyncVersion(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMissionSyncVersion();
    }

    /**
     * 读取当前任务同步原始字符串。
     * Reads the raw mission-sync payload string.
     */
    public static String getMissionSyncData(EntityPlayer entityPlayer) {
        return of(entityPlayer).getMissionSyncData();
    }

    /**
     * 读取任务条目数量。
     * Reads the number of mission/task entries.
     */
    public static int getTaskCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTaskCount();
    }

    /**
     * 读取所有任务类型名称数组。
     * Reads the task-type array extracted from mission-sync data.
     */
    public static String[] getTaskTypes(EntityPlayer entityPlayer) {
        return of(entityPlayer).getTaskTypes();
    }

    /**
     * 判断是否存在指定任务类型。
     * Returns whether the requested task type exists in mission-sync data.
     */
    public static boolean hasTaskType(EntityPlayer entityPlayer, String type) {
        return of(entityPlayer).hasTaskType(type);
    }

    /**
     * 判断任务枚举对应类型是否存在。
     * Returns whether the requested task enum exists in mission-sync data.
     */
    public static boolean hasTaskType(EntityPlayer entityPlayer, CValueTaskType taskType) {
        return of(entityPlayer).hasTaskType(taskType);
    }

    /**
     * 读取剧情主线 id。
     * Reads the main saga id.
     */
    public static int getSagaMainId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaMainId();
    }

    /**
     * 读取剧情地组 id。
     * Reads the saga group id.
     */
    public static int getSagaGroupId(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaGroupId();
    }

    /**
     * 读取剧情地组成员原始字符串。
     * Reads the raw saga group-member payload.
     */
    public static String getSagaGroupMembersRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaGroupMembersRaw();
    }

    /**
     * 读取剧情地组成员名称数组。
     * Reads the saga group-member array.
     */
    public static String[] getSagaGroupMembers(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaGroupMembers();
    }

    /**
     * 读取剧情地组成员数量。
     * Reads the number of saga group members.
     */
    public static int getSagaGroupMemberCount(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaGroupMemberCount();
    }

    /**
     * 判断当前是否处于剧情地组中。
     * Returns whether the player currently belongs to a saga group.
     */
    public static boolean hasSagaGroup(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasSagaGroup();
    }

    /**
     * 读取剧情地组邀请原始字符串。
     * Reads the raw saga group-invite payload.
     */
    public static String getSagaGroupInviteRaw(EntityPlayer entityPlayer) {
        return of(entityPlayer).getSagaGroupInviteRaw();
    }

    /**
     * 判断当前是否存在剧情地组邀请。
     * Returns whether a saga group invite is currently present.
     */
    public static boolean hasSagaGroupInvite(EntityPlayer entityPlayer) {
        return of(entityPlayer).hasSagaGroupInvite();
    }

    /**
     * 读取任务同步版本字符串。
     * Reads the mission-sync version string.
     */
    public String getMissionSyncVersion() {
        return view.getMissionSyncVersion();
    }

    /**
     * 读取当前任务同步原始字符串。
     * Reads the raw mission-sync payload string.
     */
    public String getMissionSyncData() {
        return view.getMissionSyncData();
    }

    /**
     * 读取任务条目数量。
     * Reads the number of mission/task entries.
     */
    public int getTaskCount() {
        return view.getTaskCount();
    }

    /**
     * 读取所有任务类型名称数组。
     * Reads the task-type array extracted from mission-sync data.
     */
    public String[] getTaskTypes() {
        return view.getTaskTypes();
    }

    /**
     * 判断是否存在指定任务类型。
     * Returns whether the requested task type exists in mission-sync data.
     */
    public boolean hasTaskType(String type) {
        return view.hasTaskType(type);
    }

    /**
     * 判断任务枚举对应类型是否存在。
     * Returns whether the requested task enum exists in mission-sync data.
     */
    public boolean hasTaskType(CValueTaskType taskType) {
        return view.hasTaskType(taskType);
    }

    /**
     * 读取剧情主线 id。
     * Reads the main saga id.
     */
    public int getSagaMainId() {
        return view.getSagaMainId();
    }

    /**
     * 读取剧情地组 id。
     * Reads the saga group id.
     */
    public int getSagaGroupId() {
        return view.getSagaGroupId();
    }

    /**
     * 读取剧情地组成员原始字符串。
     * Reads the raw saga group-member payload.
     */
    public String getSagaGroupMembersRaw() {
        return view.getSagaGroupMembersRaw();
    }

    /**
     * 读取剧情地组成员名称数组。
     * Reads the saga group-member array.
     */
    public String[] getSagaGroupMembers() {
        return view.getSagaGroupMembers();
    }

    /**
     * 读取剧情地组成员数量。
     * Reads the number of saga group members.
     */
    public int getSagaGroupMemberCount() {
        return view.getSagaGroupMemberCount();
    }

    /**
     * 判断当前是否处于剧情地组中。
     * Returns whether the player currently belongs to a saga group.
     */
    public boolean hasSagaGroup() {
        return view.hasSagaGroup();
    }

    /**
     * 读取剧情地组邀请原始字符串。
     * Reads the raw saga group-invite payload.
     */
    public String getSagaGroupInviteRaw() {
        return view.getSagaGroupInviteRaw();
    }

    /**
     * 判断当前是否存在剧情地组邀请。
     * Returns whether a saga group invite is currently present.
     */
    public boolean hasSagaGroupInvite() {
        return view.hasSagaGroupInvite();
    }

}
