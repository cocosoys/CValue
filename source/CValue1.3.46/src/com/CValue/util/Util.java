package com.CValue.util;

import JinRyuu.JRMCore.JRMCoreH;
import com.CValue.base.Base;
import com.CValue.base.race.*;
import net.minecraft.entity.player.EntityPlayer;

public class Util {
    public static Base getRacePlayerNBT(EntityPlayer entityPlayer){
        Base base=new Base(entityPlayer,true);
        switch (JRMCoreH.getInt(base.entityPlayer,"jrmcRace")){
            case 0:
                base=new HumanRace(base.entityPlayer,true);
                break;
            case 1:
                base=new SaiyanRace(base.entityPlayer,true);
                break;
            case 2:
                base=new HalfSaiyanRace(base.entityPlayer,true);
                break;
            case 3:
                base=new NamekianRace(base.entityPlayer,true);
                break;
            case 4:
                base=new ArcosianRace(base.entityPlayer,true);
                break;
            case 5:
                base=new MajinRace(base.entityPlayer,true);
                break;
            default:
        }
        return base;
    }
}
