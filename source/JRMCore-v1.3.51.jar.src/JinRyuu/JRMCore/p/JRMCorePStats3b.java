/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePStats3b
/*    */   implements IMessage {
/*    */   String PlyrSkills;
/*    */   String x;
/*    */   String y;
/*    */   String z;
/*    */   
/*    */   public JRMCorePStats3b() {}
/*    */   
/*    */   public JRMCorePStats3b(String PlyrSkills, String x, String y, String z) {
/* 20 */     this.PlyrSkills = PlyrSkills;
/* 21 */     this.x = x;
/* 22 */     this.y = y;
/* 23 */     this.z = z;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 28 */     ByteBufUtils.writeUTF8String(buffer, this.x);
/* 29 */     ByteBufUtils.writeUTF8String(buffer, this.y);
/* 30 */     ByteBufUtils.writeUTF8String(buffer, this.z);
/* 31 */     ByteBufUtils.writeUTF8String(buffer, this.PlyrSkills);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 36 */     this.x = ByteBufUtils.readUTF8String(buffer);
/* 37 */     this.y = ByteBufUtils.readUTF8String(buffer);
/* 38 */     this.z = ByteBufUtils.readUTF8String(buffer);
/* 39 */     this.PlyrSkills = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePStats3b> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePStats3b m, MessageContext ctx) {
/* 45 */       JRMCoreClient.phc.handleStats3(m.PlyrSkills, m.x, m.y, m.z, p);
/*    */ 
/*    */       
/* 48 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePStats3b m, MessageContext ctx) {
/* 56 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePStats3b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */