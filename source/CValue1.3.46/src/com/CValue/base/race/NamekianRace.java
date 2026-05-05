package com.CValue.base.race;

import net.minecraft.entity.player.EntityPlayer;

public class NamekianRace extends SaiyanRace {
    public final static String RaceName="Namekian";
    public final static int RaceID=3;

    public NamekianRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public NamekianRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }
}
