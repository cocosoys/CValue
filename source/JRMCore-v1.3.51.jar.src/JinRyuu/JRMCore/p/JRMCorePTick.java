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
/*    */ public class JRMCorePTick
/*    */   implements IMessage {
/*    */   private int c;
/*    */   private String d;
/*    */   
/*    */   public JRMCorePTick() {}
/*    */   
/*    */   public JRMCorePTick(int c, String d) {
/* 19 */     this.c = c;
/* 20 */     this.d = d;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     buffer.writeInt(this.c);
/* 26 */     ByteBufUtils.writeUTF8String(buffer, this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 31 */     this.c = buffer.readInt();
/* 32 */     this.d = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePTick> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePTick m, MessageContext ctx) {
/* 38 */       JRMCoreClient.phc.handleTick(m.c, m.d, p);
/*    */ 
/*    */       
/* 41 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePTick m, MessageContext ctx) {
/* 46 */       JRMCore.phs.handleTick(m.c, m.d, p);
/*    */ 
/*    */       
/* 49 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePTick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */