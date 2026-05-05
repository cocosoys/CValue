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
/*    */ public class DBCPscouter1 implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPscouter1() {}
/*    */   
/*    */   public DBCPscouter1(int i) {
/* 17 */     this.i = i;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 22 */     buffer.writeInt(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 27 */     this.i = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPscouter1> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPscouter1 m, MessageContext ctx) {
/* 33 */       DBCClient.phc.handleDBCscouter1(m.i, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPscouter1 m, MessageContext ctx) {
/* 41 */       DBC.phs.handleDBCscouter1(m.i, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPscouter1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */