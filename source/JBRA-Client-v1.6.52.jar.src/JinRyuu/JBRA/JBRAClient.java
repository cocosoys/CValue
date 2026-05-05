/*    */ package JinRyuu.JBRA;
/*    */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JBRAClient extends JBRA {
/*  9 */   public static Minecraft mc = Minecraft.func_71410_x();
/*    */   public void registerRenderThings() {
/* 11 */     RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, (Render)new RenderPlayerJBRA());
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerTicks() {
/* 16 */     FMLCommonHandler.instance().bus().register(new JBRACliTicH());
/*    */   }
/*    */ 
/*    */   
/*    */   public void postInit() {
/* 21 */     super.postInit();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRAClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */