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
/*    */ public class DBCPascendsound
/*    */   implements IMessage {
/*    */   int i;
/*    */   
/*    */   public DBCPascendsound(int i) {
/* 16 */     this.i = i;
/*    */   }
/*    */   public DBCPascendsound() {}
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
/*    */     extends BAmh<DBCPascendsound> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPascendsound m, MessageContext ctx) {
/* 32 */       DBCClient.phc.handleDBCascendsound(m.i, p);
/*    */ 
/*    */       
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPascendsound m, MessageContext ctx) {
/* 40 */       DBC.phs.handleDBCascendsound(m.i, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPascendsound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */