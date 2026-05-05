/*    */ package net.minecraft.realms;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.lang.reflect.Constructor;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RealmsBridge extends RealmsScreen {
/* 12 */   private static final Logger LOGGER = LogManager.getLogger();
/*    */   private GuiScreen previousScreen;
/*    */   private static final String __OBFID = "CL_00001869";
/*    */   
/*    */   public void switchToRealms(GuiScreen p_switchToRealms_1_) {
/* 17 */     this.previousScreen = p_switchToRealms_1_;
/*    */     try {
/* 19 */       Class<?> clazz = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
/* 20 */       Constructor<?> constructor = clazz.getDeclaredConstructor(new Class[] { RealmsScreen.class });
/* 21 */       constructor.setAccessible(true);
/* 22 */       Object object = constructor.newInstance(new Object[] { this });
/* 23 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)((RealmsScreen)object).getProxy());
/* 24 */     } catch (Exception exception) {
/* 25 */       LOGGER.error("Realms module missing", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 31 */     Minecraft.func_71410_x().func_147108_a(this.previousScreen);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\realms\RealmsBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */