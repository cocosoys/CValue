/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCore;
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePTech implements IMessage {
/*    */   byte b;
/*    */   String s;
/*    */   
/*    */   public JRMCorePTech() {}
/*    */   
/*    */   public JRMCorePTech(byte b, String s) {
/* 18 */     this.b = b;
/* 19 */     this.s = s;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 24 */     buffer.writeByte(this.b);
/* 25 */     ByteBufUtils.writeUTF8String(buffer, this.s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 30 */     this.b = buffer.readByte();
/* 31 */     this.s = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePTech> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePTech m, MessageContext ctx) {
/* 37 */       JRMCoreClient.phc.handleTech(m.b, m.s, p);
/*    */ 
/*    */       
/* 40 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePTech m, MessageContext ctx) {
/* 45 */       JRMCore.phs.handleTech(m.b, m.s, p);
/*    */ 
/*    */       
/* 48 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePTech.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */