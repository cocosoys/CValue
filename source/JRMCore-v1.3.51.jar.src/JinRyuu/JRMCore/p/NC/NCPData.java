/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import JinRyuu.NarutoC.common.NC;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class NCPData implements IMessage {
/*    */   byte b1;
/*    */   byte b2;
/*    */   
/*    */   public NCPData() {}
/*    */   
/*    */   public NCPData(byte b1, byte b2) {
/* 17 */     this.b1 = b1;
/* 18 */     this.b2 = b2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 23 */     buffer.writeByte(this.b1);
/* 24 */     buffer.writeByte(this.b2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 29 */     this.b1 = buffer.readByte();
/* 30 */     this.b2 = buffer.readByte();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<NCPData>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, NCPData m, MessageContext ctx) {
/* 39 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, NCPData m, MessageContext ctx) {
/* 44 */       NC.phs.handleJRNC(m.b1, m.b2, p);
/*    */ 
/*    */       
/* 47 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */