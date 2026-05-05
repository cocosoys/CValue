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
/*    */ public class DBCPduo implements IMessage {
/*    */   int i;
/*    */   int i2;
/*    */   
/*    */   public DBCPduo() {}
/*    */   
/*    */   public DBCPduo(int i, int i2) {
/* 18 */     this.i = i;
/* 19 */     this.i2 = i2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 24 */     buffer.writeInt(this.i);
/* 25 */     buffer.writeInt(this.i2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 30 */     this.i = buffer.readInt();
/* 31 */     this.i2 = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPduo> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPduo m, MessageContext ctx) {
/* 37 */       DBCClient.phc.handleDBCjumpsound(m.i, m.i2, p);
/*    */ 
/*    */       
/* 40 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPduo m, MessageContext ctx) {
/* 45 */       DBC.phs.handleDBCjumpsound(m.i, m.i2, p);
/*    */ 
/*    */       
/* 48 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPduo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */