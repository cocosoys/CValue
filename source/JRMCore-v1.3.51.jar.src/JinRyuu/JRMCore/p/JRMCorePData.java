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
/*    */ public class JRMCorePData
/*    */   implements IMessage {
/*    */   private int c;
/*    */   private String d;
/*    */   
/*    */   public JRMCorePData() {}
/*    */   
/*    */   public JRMCorePData(int c, String d) {
/* 19 */     this.c = c;
/* 20 */     this.d = d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     buffer.writeInt(this.c);
/*    */     
/* 27 */     ByteBufUtils.writeUTF8String(buffer, this.d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 33 */     this.c = buffer.readInt();
/* 34 */     this.d = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePData> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePData m, MessageContext ctx) {
/* 40 */       JRMCoreClient.phc.handleData(m.c, m.d, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePData m, MessageContext ctx) {
/* 48 */       JRMCore.phs.handleData(m.c, m.d, p);
/*    */ 
/*    */       
/* 51 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */