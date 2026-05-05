package com.CValue.base.race;

import net.minecraft.entity.player.EntityPlayer;

public class HalfSaiyanRace extends SaiyanRace {
    public final static String RaceName="Half-Saiyan";
    public final static int RaceID=2;

    public HalfSaiyanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public HalfSaiyanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }
}
