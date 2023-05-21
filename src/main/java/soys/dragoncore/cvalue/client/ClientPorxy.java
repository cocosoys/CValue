package soys.dragoncore.cvalue.client;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import soys.dragoncore.cvalue.CValue_Mod;
import soys.dragoncore.cvalue.common.CommonProxy;

public class ClientPorxy extends CommonProxy {
    @Override
    public void load(FMLPreInitializationEvent event){
        if(CValue_Mod.update){
            (new VersionCheckerClient()).start();
        }
    }
}
