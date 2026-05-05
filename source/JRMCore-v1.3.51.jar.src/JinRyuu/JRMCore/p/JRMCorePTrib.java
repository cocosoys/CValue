/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JRMCorePTrib
/*    */   implements IMessage
/*    */ {
/*    */   public void toBytes(ByteBuf buffer) {
/* 18 */     switch (FMLCommonHandler.instance().getEffectiveSide()) {
/*    */     
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     JRMCoreH.configToClient(buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 34 */     switch (FMLCommonHandler.instance().getEffectiveSide()) {
/*    */     
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 46 */     JRMCoreClient.phc.handleTri(buffer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePTrib>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePTrib m, MessageContext ctx) {
/* 55 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePTrib m, MessageContext ctx) {
/* 63 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePTrib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */