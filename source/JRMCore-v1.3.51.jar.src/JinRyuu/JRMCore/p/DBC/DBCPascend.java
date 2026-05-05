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
/*    */ public class DBCPascend
/*    */   implements IMessage {
/*    */   byte i;
/*    */   
/*    */   public DBCPascend(byte i) {
/* 16 */     this.i = i;
/*    */   }
/*    */   public DBCPascend() {}
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeByte(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.i = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPascend> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPascend m, MessageContext ctx) {
/* 32 */       DBCClient.phc.handleDBCascend(m.i, p);
/*    */ 
/*    */       
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPascend m, MessageContext ctx) {
/* 40 */       DBC.phs.handleDBCascend(m.i, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPascend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */