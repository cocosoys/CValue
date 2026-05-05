/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import JinRyuu.NarutoC.common.NC;
/*    */ import JinRyuu.NarutoC.common.NCClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class NCPDou implements IMessage {
/*    */   byte b1;
/*    */   
/*    */   public NCPDou() {}
/*    */   
/*    */   public NCPDou(byte b1) {
/* 17 */     this.b1 = b1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 22 */     buffer.writeByte(this.b1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 27 */     this.b1 = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<NCPDou> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, NCPDou m, MessageContext ctx) {
/* 33 */       NCClient.phc.handleNCdou(m.b1, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, NCPDou m, MessageContext ctx) {
/* 41 */       NC.phs.handleNCdou(m.b1, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPDou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */