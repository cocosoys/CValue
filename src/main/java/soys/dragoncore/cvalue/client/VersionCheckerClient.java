package soys.dragoncore.cvalue.client;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import soys.dragoncore.cvalue.CValue_Mod;

public class VersionCheckerClient extends Thread{
    public void run(){
        try{
            EntityClientPlayerMP clientPlayerMP= Minecraft.getMinecraft().thePlayer;
        }catch (NoSuchMethodError noSuchMethodError){
            noSuchMethodError.printStackTrace();
        }
        EntityClientPlayerMP clientPlayerMP;
        while ((clientPlayerMP = (Minecraft.getMinecraft()).thePlayer) == null) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        ChatComponentTranslation message = new ChatComponentTranslation(LanguageRegistry.instance().getStringLocalization("cvalue.running.info"), CValue_Mod.VERSION);
        clientPlayerMP.addChatMessage(message);
    }
}
