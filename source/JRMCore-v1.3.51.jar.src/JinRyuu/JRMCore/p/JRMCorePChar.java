/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePChar
/*    */   implements IMessage {
/*    */   byte b;
/*    */   int b2;
/*    */   
/*    */   public JRMCorePChar() {}
/*    */   
/*    */   public JRMCorePChar(byte b, int b2) {
/* 18 */     this.b = b;
/* 19 */     this.b2 = b2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 24 */     buffer.writeByte(this.b);
/* 25 */     buffer.writeInt(this.b2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 31 */     this.b = buffer.readByte();
/* 32 */     this.b2 = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePChar>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePChar m, MessageContext ctx) {
/* 39 */       JRMCoreClient.phc.handleChar(m.b, m.b2, p);
/*    */ 
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePChar m, MessageContext ctx) {
/* 48 */       JRMCore.phs.handleChar(m.b, m.b2, p);
/*    */ 
/*    */ 
/*    */       
/* 52 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePChar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */