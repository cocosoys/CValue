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
/*    */ public class DBCPwish
/*    */   implements IMessage
/*    */ {
/*    */   int i;
/*    */   
/*    */   public DBCPwish(int i, String s) {
/* 18 */     this.i = i;
/* 19 */     this.s = s;
/*    */   }
/*    */   String s;
/*    */   public DBCPwish() {}
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     buffer.writeInt(this.i);
/*    */     
/* 27 */     ByteBufUtils.writeUTF8String(buffer, this.s);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 33 */     this.i = buffer.readInt();
/* 34 */     this.s = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPwish>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPwish m, MessageContext ctx) {
/* 41 */       DBCClient.phc.handleDBCwish(m.i, m.s, p);
/*    */ 
/*    */       
/* 44 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPwish m, MessageContext ctx) {
/* 49 */       DBC.phs.handleDBCwish(m.i, m.s, p);
/*    */ 
/*    */       
/* 52 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPwish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */