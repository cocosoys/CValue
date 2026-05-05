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
/*    */ public class DBCPdri implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPdri() {}
/*    */   
/*    */   public DBCPdri(int i) {
/* 17 */     this.i = i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 23 */     buffer.writeInt(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 28 */     this.i = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPdri> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPdri m, MessageContext ctx) {
/* 34 */       DBCClient.phc.handleDBCdri(m.i, p);
/*    */ 
/*    */       
/* 37 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPdri m, MessageContext ctx) {
/* 42 */       DBC.phs.handleDBCdri(m.i, p);
/*    */ 
/*    */       
/* 45 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPdri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */