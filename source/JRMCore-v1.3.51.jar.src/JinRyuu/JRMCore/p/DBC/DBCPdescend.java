/*    */ package JinRyuu.JRMCore.p.DBC;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBC;
/*    */ import JinRyuu.DragonBC.common.DBCClient;
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class DBCPdescend implements IMessage {
/*    */   byte i;
/*    */   
/*    */   public DBCPdescend() {}
/*    */   
/*    */   public DBCPdescend(byte i) {
/* 17 */     this.i = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 22 */     buffer.writeByte(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 27 */     this.i = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPdescend> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPdescend m, MessageContext ctx) {
/* 33 */       DBCClient.phc.handleDBCdescend(m.i, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPdescend m, MessageContext ctx) {
/* 41 */       DBC.phs.handleDBCdescend(m.i, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPdescend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */