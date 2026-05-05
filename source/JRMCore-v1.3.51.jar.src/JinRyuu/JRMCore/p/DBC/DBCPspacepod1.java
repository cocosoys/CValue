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
/*    */ public class DBCPspacepod1
/*    */   implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPspacepod1(int i) {
/* 16 */     this.i = i;
/*    */   }
/*    */   public DBCPspacepod1() {}
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
/*    */     extends BAmh<DBCPspacepod1>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPspacepod1 m, MessageContext ctx) {
/* 33 */       DBCClient.phc.handleDBCspacepod1(m.i, p);
/*    */ 
/*    */       
/* 36 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPspacepod1 m, MessageContext ctx) {
/* 41 */       DBC.phs.handleDBCspacepod1(m.i, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPspacepod1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */