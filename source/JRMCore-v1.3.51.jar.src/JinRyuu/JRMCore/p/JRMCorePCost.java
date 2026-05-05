/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePCost implements IMessage {
/*    */   short b;
/*    */   
/*    */   public JRMCorePCost() {}
/*    */   
/*    */   public JRMCorePCost(short b) {
/* 16 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeShort(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.b = buffer.readShort();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePCost> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePCost m, MessageContext ctx) {
/* 32 */       JRMCoreClient.phc.handleCost(m.b, p);
/*    */ 
/*    */       
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePCost m, MessageContext ctx) {
/* 40 */       JRMCore.phs.handleCost(m.b, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePCost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */