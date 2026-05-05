/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import JinRyuu.NarutoC.common.NC;
/*    */ import JinRyuu.NarutoC.common.NCClient;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class NCPData2 implements IMessage {
/*    */   int i;
/*    */   String s;
/*    */   
/*    */   public NCPData2() {}
/*    */   
/*    */   public NCPData2(int i, String s) {
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
/*    */     extends BAmh<NCPData2> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, NCPData2 m, MessageContext ctx) {
/* 38 */       NCClient.phc.handleJRNC(m.i, m.s, p);
/*    */ 
/*    */       
/* 41 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, NCPData2 m, MessageContext ctx) {
/* 46 */       NC.phs.handleJRNC(m.i, m.s, p);
/*    */ 
/*    */       
/* 49 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPData2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */