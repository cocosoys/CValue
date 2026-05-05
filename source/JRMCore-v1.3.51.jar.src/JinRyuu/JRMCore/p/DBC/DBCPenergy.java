/*    */ package JinRyuu.JRMCore.p.DBC;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBC;
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class DBCPenergy implements IMessage {
/*    */   byte b;
/*    */   byte b2;
/*    */   
/*    */   public DBCPenergy() {}
/*    */   
/*    */   public DBCPenergy(byte b, byte b2) {
/* 17 */     this.b = b;
/* 18 */     this.b2 = b2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 23 */     buffer.writeByte(this.b);
/* 24 */     buffer.writeByte(this.b2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 29 */     this.b = buffer.readByte();
/* 30 */     this.b2 = buffer.readByte();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPenergy>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPenergy m, MessageContext ctx) {
/* 39 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPenergy m, MessageContext ctx) {
/* 44 */       DBC.phs.handleDBCenergy(m.b, m.b2, p);
/*    */ 
/*    */       
/* 47 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPenergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */