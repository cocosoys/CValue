/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePUpgrade implements IMessage {
/*    */   byte b;
/*    */   
/*    */   public JRMCorePUpgrade() {}
/*    */   
/*    */   public JRMCorePUpgrade(byte b) {
/* 15 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 20 */     buffer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 25 */     this.b = buffer.readByte();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePUpgrade>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePUpgrade m, MessageContext ctx) {
/* 34 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePUpgrade m, MessageContext ctx) {
/* 39 */       JRMCore.phs.handleUpgrade(m.b, p);
/*    */ 
/*    */       
/* 42 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePUpgrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */