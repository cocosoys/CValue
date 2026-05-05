package com.recvalue.api;

import net.minecraft.entity.player.EntityPlayer;

/**
 * CValue 的主门面。
 * Main facade for CValue.
 */
public final class CValueAPI extends CValueAPITasks {
    CValueAPI(EntityPlayer entityPlayer) {
        super(new CValuePlayerView(entityPlayer));
    }

    /**
     * 返回基础分组实例。
     * Returns the base group instance.
     */
    public CValueAPIBase base() {
        return this;
    }

    /**
     * 返回数值分组实例。
     * Returns the stats group instance.
     */
    public CValueAPIStats stats() {
        return this;
    }

    /**
     * 返回技能分组实例。
     * Returns the skills group instance.
     */
    public CValueAPISkills skills() {
        return this;
    }

    /**
     * 返回形态分组实例。
     * Returns the forms group instance.
     */
    public CValueAPIForms forms() {
        return this;
    }

    /**
     * 返回任务分组实例。
     * Returns the tasks group instance.
     */
    public CValueAPITasks tasks() {
        return this;
    }
}
