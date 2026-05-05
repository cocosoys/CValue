package com.CValue.base.race;

import net.minecraft.entity.player.EntityPlayer;

public class MajinRace extends SaiyanRace {
    public final static String RaceName="Majin";
    public final static int RaceID=5;

    public MajinRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public MajinRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }

}
