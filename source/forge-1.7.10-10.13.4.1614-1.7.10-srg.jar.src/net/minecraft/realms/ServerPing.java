/*   */ package net.minecraft.realms;
/*   */ import cpw.mods.fml.relauncher.Side;
/*   */ 
/*   */ @SideOnly(Side.CLIENT)
/*   */ public class ServerPing {
/* 6 */   public volatile String nrOfPlayers = "0";
/* 7 */   public volatile long lastPingSnapshot = 0L;
/*   */   private static final String __OBFID = "CL_00001860";
/*   */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\ServerPing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */