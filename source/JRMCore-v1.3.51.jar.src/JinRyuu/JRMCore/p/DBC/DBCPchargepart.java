/*    */ package JinRyuu.JRMCore.p.DBC;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBC;
/*    */ import JinRyuu.DragonBC.common.DBCClient;
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class DBCPchargepart implements IMessage {
/*    */   byte dbcchargepart;
/*    */   String dbcCharger;
/*    */   
/*    */   public DBCPchargepart() {}
/*    */   
/*    */   public DBCPchargepart(byte dbcchargepart, String dbcCharger) {
/* 19 */     this.dbcchargepart = dbcchargepart;
/* 20 */     this.dbcCharger = dbcCharger;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 26 */     buffer.writeByte(this.dbcchargepart);
/* 27 */     ByteBufUtils.writeUTF8String(buffer, this.dbcCharger);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 32 */     this.dbcchargepart = buffer.readByte();
/* 33 */     this.dbcCharger = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPchargepart> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPchargepart m, MessageContext ctx) {
/* 39 */       DBCClient.phc.handleDBCchargepart(m.dbcchargepart, m.dbcCharger, p);
/*    */ 
/*    */       
/* 42 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPchargepart m, MessageContext ctx) {
/* 47 */       DBC.phs.handleDBCchargepart(m.dbcchargepart, m.dbcCharger, p);
/*    */ 
/*    */       
/* 50 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPchargepart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */