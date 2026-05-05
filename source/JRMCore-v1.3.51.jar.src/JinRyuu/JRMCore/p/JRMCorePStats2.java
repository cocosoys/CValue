/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class JRMCorePStats2
/*    */   implements IMessage
/*    */ {
/*    */   int curTP;
/*    */   int curExp;
/*    */   byte align;
/* 17 */   int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];
/*    */   
/*    */   public JRMCorePStats2(int curTP2, int curExp2, byte align, int[] plyrAttrbts2) {
/* 20 */     this.curTP = curTP2;
/* 21 */     this.curExp = curExp2;
/* 22 */     this.align = align;
/* 23 */     this.PlyrAttrbts = plyrAttrbts2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 28 */     int[] PlyrAttrbts = new int[this.PlyrAttrbts.length];
/* 29 */     buffer.writeInt(this.curTP);
/* 30 */     buffer.writeInt(this.curExp);
/* 31 */     buffer.writeByte(this.align);
/* 32 */     for (int i = 0; i < PlyrAttrbts.length; ) { buffer.writeInt(this.PlyrAttrbts[i]); i++; }
/* 33 */      this.PlyrAttrbts = PlyrAttrbts;
/*    */   }
/*    */   public JRMCorePStats2() {}
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 38 */     this.curTP = buffer.readInt();
/* 39 */     this.curExp = buffer.readInt();
/* 40 */     this.align = buffer.readByte();
/* 41 */     for (int i = 0; i < this.PlyrAttrbts.length; ) { this.PlyrAttrbts[i] = buffer.readInt(); i++; }
/*    */   
/*    */   }
/*    */   
/*    */   public static class Handler extends BAmh<JRMCorePStats2> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePStats2 m, MessageContext ctx) {
/* 47 */       JRMCoreClient.phc.handleStats2(m.curTP, m.curExp, m.align, m.PlyrAttrbts, p);
/*    */ 
/*    */       
/* 50 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePStats2 m, MessageContext ctx) {
/* 58 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePStats2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */