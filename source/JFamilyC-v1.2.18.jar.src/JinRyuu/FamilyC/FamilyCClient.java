/*    */ package JinRyuu.FamilyC;
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ 
/*    */ public class FamilyCClient extends FamilyC {
/*  9 */   public static Minecraft mc = Minecraft.func_71410_x();
/*    */   
/*    */   public static FamilyCGui JFCGui;
/*    */   
/*    */   public void registerRenderThings() {
/* 14 */     RenderingRegistry.registerEntityRenderingHandler(EntityNPC.class, (Render)new RenderJFC());
/*    */     
/* 16 */     JFCGui = new FamilyCGui();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerKeys() {
/* 22 */     ClientRegistry.registerKeyBinding(FamilyCKeyHandler.Interact);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerTicks() {
/* 28 */     super.registerTicks();
/* 29 */     FMLCommonHandler.instance().bus().register(new FamilyCCliTicH());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void postInit() {
/* 35 */     super.postInit();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */