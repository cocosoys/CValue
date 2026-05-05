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
/*    */ public class DBCPscouter4
/*    */   implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPscouter4(int i) {
/* 16 */     this.i = i;
/*    */   }
/*    */   public DBCPscouter4() {}
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 21 */     buffer.writeInt(this.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 26 */     this.i = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPscouter4>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPscouter4 m, MessageContext ctx) {
/* 33 */       DBCClient.phc.handleDBCscouter4(m.i, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPscouter4 m, MessageContext ctx) {
/* 41 */       DBC.phs.handleDBCscouter4(m.i, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPscouter4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */