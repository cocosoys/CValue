/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePAttck implements IMessage {
/*    */   byte b;
/*    */   
/*    */   public JRMCorePAttck() {}
/*    */   
/*    */   public JRMCorePAttck(byte b) {
/* 16 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.b = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePAttck> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePAttck m, MessageContext ctx) {
/* 32 */       JRMCoreClient.phc.handleAttck(m.b, p);
/*    */ 
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePAttck m, MessageContext ctx) {
/* 41 */       JRMCore.phs.handleAttck(m.b, p);
/*    */ 
/*    */ 
/*    */       
/* 45 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePAttck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */