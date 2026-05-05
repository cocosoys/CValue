/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePQuadI
/*    */   implements IMessage {
/*    */   byte b1;
/*    */   int b2;
/*    */   int b3;
/*    */   int b4;
/*    */   
/*    */   public JRMCorePQuadI() {}
/*    */   
/*    */   public JRMCorePQuadI(byte b1, int b2, int b3, int b4) {
/* 20 */     this.b1 = b1;
/* 21 */     this.b2 = b2;
/* 22 */     this.b3 = b3;
/* 23 */     this.b4 = b4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 28 */     buffer.writeByte(this.b1);
/* 29 */     buffer.writeInt(this.b2);
/* 30 */     buffer.writeInt(this.b3);
/* 31 */     buffer.writeInt(this.b4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 36 */     this.b1 = buffer.readByte();
/* 37 */     this.b2 = buffer.readInt();
/* 38 */     this.b3 = buffer.readInt();
/* 39 */     this.b4 = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler extends BAmh<JRMCorePQuadI> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePQuadI m, MessageContext ctx) {
/* 44 */       JRMCoreClient.phc.handleQuadI(m.b1, m.b2, m.b3, m.b4);
/*    */ 
/*    */       
/* 47 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePQuadI m, MessageContext ctx) {
/* 52 */       JRMCore.phs.handleQuadI(m.b1, m.b2, m.b3, m.b4);
/*    */ 
/*    */       
/* 55 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePQuadI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */