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
/*    */ public class DBCPchargesound implements IMessage {
/*    */   int i;
/*    */   String s;
/*    */   
/*    */   public DBCPchargesound() {}
/*    */   
/*    */   public DBCPchargesound(int i, String s) {
/* 19 */     this.i = i;
/* 20 */     this.s = s;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 25 */     buffer.writeInt(this.i);
/* 26 */     ByteBufUtils.writeUTF8String(buffer, this.s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 31 */     this.i = buffer.readInt();
/* 32 */     this.s = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<DBCPchargesound> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, DBCPchargesound m, MessageContext ctx) {
/* 38 */       DBCClient.phc.handleDBCchargesound(m.i, m.s, p);
/*    */ 
/*    */       
/* 41 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, DBCPchargesound m, MessageContext ctx) {
/* 46 */       DBC.phs.handleDBCchargesound(m.i, m.s, p);
/*    */ 
/*    */       
/* 49 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\DBC\DBCPchargesound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */