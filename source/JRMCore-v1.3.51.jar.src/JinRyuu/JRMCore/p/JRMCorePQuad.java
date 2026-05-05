/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePQuad
/*    */   implements IMessage {
/*    */   int b1;
/*    */   int b2;
/*    */   int b3;
/*    */   int b4;
/*    */   
/*    */   public JRMCorePQuad() {}
/*    */   
/*    */   public JRMCorePQuad(int b1, int b2, int b3, int b4) {
/* 20 */     this.b1 = b1;
/* 21 */     this.b2 = b2;
/* 22 */     this.b3 = b3;
/* 23 */     this.b4 = b4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 28 */     buffer.writeInt(this.b1);
/* 29 */     buffer.writeInt(this.b2);
/* 30 */     buffer.writeInt(this.b3);
/* 31 */     buffer.writeInt(this.b4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 36 */     this.b1 = buffer.readInt();
/* 37 */     this.b2 = buffer.readInt();
/* 38 */     this.b3 = buffer.readInt();
/* 39 */     this.b4 = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePQuad> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePQuad m, MessageContext ctx) {
/* 45 */       JRMCoreClient.phc.handleQuad(m.b1, m.b2, m.b3, m.b4, p);
/*    */ 
/*    */       
/* 48 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePQuad m, MessageContext ctx) {
/* 53 */       JRMCore.phs.handleQuad(m.b1, m.b2, m.b3, m.b4, p);
/*    */ 
/*    */       
/* 56 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePQuad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */