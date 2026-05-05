/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.YC.JYearsCP;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JYearsC
/*    */ {
/*    */   public void initialize() {
/* 17 */     FMLCommonHandler.instance().bus().register(new JYearsCComTickH());
/*    */   }
/* 19 */   public static Class[] registerPackets = new Class[] { JYearsCP.class };
/*    */ 
/*    */ 
/*    */   
/*    */   public void postInit() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerTickHandler() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerRenderThings() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerKeys() {}
/*    */ 
/*    */   
/*    */   public EntityPlayer getPlayerEntity(MessageContext ctx) {
/* 39 */     return (EntityPlayer)(ctx.getServerHandler()).field_147369_b;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */