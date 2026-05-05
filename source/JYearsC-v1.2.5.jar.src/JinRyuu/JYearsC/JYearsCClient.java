/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JYearsCClient
/*    */   extends JYearsC
/*    */ {
/*    */   public void initialize() {
/* 16 */     super.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void postInit() {
/* 26 */     super.postInit();
/* 27 */     FMLCommonHandler.instance().bus().register(new JYearsCCliTickH());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 32 */   public static Minecraft mc = Minecraft.func_71410_x();
/*    */   public static JYearsCGui JYCGui;
/*    */   
/*    */   public void registerRenderThings() {
/* 36 */     JYCGui = new JYearsCGui();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerKeys() {
/* 42 */     ClientRegistry.registerKeyBinding(JYearsCKeyHandler.Calendar);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityPlayer getPlayerEntity(MessageContext ctx) {
/* 58 */     return ctx.side.isClient() ? (EntityPlayer)mc.field_71439_g : super.getPlayerEntity(ctx);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */