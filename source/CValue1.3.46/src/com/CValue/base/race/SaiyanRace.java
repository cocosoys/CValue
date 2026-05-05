package com.CValue.base.race;

import net.minecraft.entity.player.EntityPlayer;

public class SaiyanRace extends HumanRace {
    public final static String RaceName="Saiyan";
    public final static int RaceID=1;

    public SaiyanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public SaiyanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }
}
