/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePCol implements IMessage {
/*    */   int i;
/*    */   byte b;
/*    */   
/*    */   public JRMCorePCol() {}
/*    */   
/*    */   public JRMCorePCol(int i, byte b) {
/* 17 */     this.i = i;
/* 18 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 23 */     buffer.writeInt(this.i);
/* 24 */     buffer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 29 */     this.i = buffer.readInt();
/* 30 */     this.b = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePCol> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePCol m, MessageContext ctx) {
/* 36 */       JRMCoreClient.phc.handleCol(m.i, m.b, p);
/*    */ 
/*    */       
/* 39 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePCol m, MessageContext ctx) {
/* 44 */       JRMCore.phs.handleCol(m.i, m.b, p);
/*    */ 
/*    */       
/* 47 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePCol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */