package com.CValue.base.race;

import com.CValue.base.Base;
import net.minecraft.entity.player.EntityPlayer;

public class HumanRace extends Base {
    public final static String RaceName="Human";
    public final static int RaceID=0;

    public HumanRace(EntityPlayer entityPlayer) {
        super(entityPlayer);
    }

    public HumanRace(EntityPlayer entityPlayer, boolean getNBT) {
        super(entityPlayer, getNBT);
    }
}
