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
/*    */ public class JRMCorePData2
/*    */   implements IMessage {
/*    */   private String c;
/*    */   private String d;
/*    */   
/*    */   public JRMCorePData2() {}
/*    */   
/*    */   public JRMCorePData2(String c, String d) {
/* 19 */     this.c = c;
/* 20 */     this.d = d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     ByteBufUtils.writeUTF8String(buffer, this.c);
/* 26 */     ByteBufUtils.writeUTF8String(buffer, this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 31 */     this.c = ByteBufUtils.readUTF8String(buffer);
/* 32 */     this.d = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePData2> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePData2 m, MessageContext ctx) {
/* 38 */       JRMCoreClient.phc.handleData2(m.c, m.d, p);
/*    */ 
/*    */ 
/*    */       
/* 42 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePData2 m, MessageContext ctx) {
/* 47 */       JRMCore.phs.handleData2(m.c, m.d, p);
/*    */ 
/*    */ 
/*    */       
/* 51 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePData2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */