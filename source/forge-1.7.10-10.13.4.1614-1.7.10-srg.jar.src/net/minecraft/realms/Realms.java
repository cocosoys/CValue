/*    */ package net.minecraft.realms;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.util.Session;
/*    */ import net.minecraft.world.WorldSettings;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Realms {
/*    */   public static boolean isTouchScreen() {
/* 14 */     return (Minecraft.func_71410_x()).field_71474_y.field_85185_A;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001892";
/*    */   public static Proxy getProxy() {
/* 18 */     return Minecraft.func_71410_x().func_110437_J();
/*    */   }
/*    */   
/*    */   public static String sessionId() {
/* 22 */     Session session = Minecraft.func_71410_x().func_110432_I();
/* 23 */     if (session == null) {
/* 24 */       return null;
/*    */     }
/* 26 */     return session.func_111286_b();
/*    */   }
/*    */   
/*    */   public static String userName() {
/* 30 */     Session session = Minecraft.func_71410_x().func_110432_I();
/* 31 */     if (session == null) {
/* 32 */       return null;
/*    */     }
/* 34 */     return session.func_111285_a();
/*    */   }
/*    */   
/*    */   public static long currentTimeMillis() {
/* 38 */     return Minecraft.func_71386_F();
/*    */   }
/*    */   
/*    */   public static String getSessionId() {
/* 42 */     return Minecraft.func_71410_x().func_110432_I().func_111286_b();
/*    */   }
/*    */   
/*    */   public static String getName() {
/* 46 */     return Minecraft.func_71410_x().func_110432_I().func_111285_a();
/*    */   }
/*    */   
/*    */   public static String uuidToName(String p_uuidToName_0_) {
/* 50 */     return Minecraft.func_71410_x().func_152347_ac().fillProfileProperties(new GameProfile(UUID.fromString(p_uuidToName_0_.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5")), null), false).getName();
/*    */   }
/*    */   
/*    */   public static void setScreen(RealmsScreen p_setScreen_0_) {
/* 54 */     Minecraft.func_71410_x().func_147108_a((GuiScreen)p_setScreen_0_.getProxy());
/*    */   }
/*    */   
/*    */   public static String getGameDirectoryPath() {
/* 58 */     return (Minecraft.func_71410_x()).field_71412_D.getAbsolutePath();
/*    */   }
/*    */   
/*    */   public static int survivalId() {
/* 62 */     return WorldSettings.GameType.SURVIVAL.func_77148_a();
/*    */   }
/*    */   
/*    */   public static int creativeId() {
/* 66 */     return WorldSettings.GameType.CREATIVE.func_77148_a();
/*    */   }
/*    */   
/*    */   public static int adventureId() {
/* 70 */     return WorldSettings.GameType.ADVENTURE.func_77148_a();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\Realms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */