/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePStats3
/*    */   implements IMessage {
/*    */   byte b;
/*    */   byte b2;
/*    */   byte b3;
/*    */   
/*    */   public JRMCorePStats3() {}
/*    */   
/*    */   public JRMCorePStats3(byte b, byte b2, byte b3) {
/* 18 */     this.b = b;
/* 19 */     this.b2 = b2;
/* 20 */     this.b3 = b3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     buffer.writeByte(this.b);
/* 26 */     buffer.writeByte(this.b2);
/* 27 */     buffer.writeByte(this.b3);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 32 */     this.b = buffer.readByte();
/* 33 */     this.b2 = buffer.readByte();
/* 34 */     this.b3 = buffer.readByte();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePStats3>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePStats3 m, MessageContext ctx) {
/* 43 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePStats3 m, MessageContext ctx) {
/* 48 */       JRMCore.phs.handleStats3(m.b, m.b2, m.b3, p);
/*    */ 
/*    */       
/* 51 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePStats3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */