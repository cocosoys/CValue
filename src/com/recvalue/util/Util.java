package com.recvalue.util;

import JinRyuu.JRMCore.JRMCoreH;
import com.recvalue.base.Base;
import com.recvalue.base.race.ArcosianRace;
import com.recvalue.base.race.HalfSaiyanRace;
import com.recvalue.base.race.HumanRace;
import com.recvalue.base.race.MajinRace;
import com.recvalue.base.race.NamekianRace;
import com.recvalue.base.race.SaiyanRace;
import net.minecraft.entity.player.EntityPlayer;

/**
 * 用于解析种族感知包装器的小型工厂辅助类。
 * Small factory helpers for resolving race-aware wrappers.
 */
public class Util {
    /**
     * 为指定玩家返回对应的种族基础包装器。
     * Returns the race-specific base wrapper for the provided player.
     */
    public static Base getRacePlayerNBT(EntityPlayer entityPlayer) {
        switch (JRMCoreH.getInt(entityPlayer, "jrmcRace")) {
            case 0:
                return new HumanRace(entityPlayer, true);
            case 1:
                return new SaiyanRace(entityPlayer, true);
            case 2:
                return new HalfSaiyanRace(entityPlayer, true);
            case 3:
                return new NamekianRace(entityPlayer, true);
            case 4:
                return new ArcosianRace(entityPlayer, true);
            case 5:
                return new MajinRace(entityPlayer, true);
            default:
                return new Base(entityPlayer, true);
        }
    }
}
