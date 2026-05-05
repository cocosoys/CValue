/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class JRMCoreGuiScreenE
/*    */   extends GuiScreen
/*    */ {
/* 19 */   int guiWidth = 256;
/* 20 */   int guiHeight = 256;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   @SubscribeEvent
/*    */   public void hideHealth(RenderGameOverlayEvent e) {
/* 25 */     if (e != null) {
/*    */       
/* 27 */       if (e.type.equals(RenderGameOverlayEvent.ElementType.ALL));
/*    */       
/* 29 */       if (e.type.equals(RenderGameOverlayEvent.ElementType.HEALTH) && e.isCancelable() && (JRMCoreH.Pwrtyp == 1 || JRMCoreH.Pwrtyp == 2 || JRMCoreH.Pwrtyp == 3))
/*    */       {
/* 31 */         e.setCanceled(true);
/*    */       }
/*    */       
/* 34 */       if (e.type == RenderGameOverlayEvent.ElementType.TEXT);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 39 */       if (e.type == RenderGameOverlayEvent.ElementType.TEXT) {
/*    */         
/* 41 */         EntityLivingBase entityLivingBase = JRMCoreCliTicH.lockOn;
/* 42 */         if (entityLivingBase == null || !JRMCoreConfig.lockon)
/*    */           return; 
/* 44 */         Minecraft mc = JRMCoreClient.mc;
/* 45 */         EntityClientPlayerMP entityClientPlayerMP = mc.field_71439_g;
/* 46 */         float reduction = 4.0F;
/* 47 */         int screenWidth = e.resolution.func_78326_a();
/* 48 */         int screenHeight = e.resolution.func_78328_b();
/*    */         
/* 50 */         double distanceSq = entityClientPlayerMP.func_70032_d((Entity)entityLivingBase);
/* 51 */         float scale = (float)(10.0D / distanceSq);
/* 52 */         GL11.glPushMatrix();
/* 53 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 54 */         GL11.glEnable(3042);
/* 55 */         GL11.glBlendFunc(770, 771);
/* 56 */         GL11.glTranslatef((screenWidth / 2) - (this.guiWidth / 2) * scale / reduction, (screenHeight / 2) - (this.guiHeight / 2) * scale / reduction, 0.0F);
/* 57 */         GL11.glScalef(scale / reduction, scale / reduction, scale / reduction);
/*    */ 
/*    */         
/* 60 */         if (entityLivingBase != null) {
/*    */           
/* 62 */           mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjjrmc, "gui/lo/" + JGConfigClientSettings.get_hud_lockon() + ".png"));
/* 63 */           func_73729_b(0, 0, 0, 0, this.guiWidth, this.guiHeight);
/*    */         } 
/* 65 */         GL11.glDisable(3042);
/* 66 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiScreenE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */