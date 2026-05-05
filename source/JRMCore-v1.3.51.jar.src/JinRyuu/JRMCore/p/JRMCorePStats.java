/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JRMCorePStats
/*    */   implements IMessage {
/*    */   int curBody;
/*    */   int curEnergy;
/*    */   int curStamina;
/*    */   byte curRelease;
/*    */   byte b;
/*    */   
/*    */   public JRMCorePStats() {}
/*    */   
/*    */   public JRMCorePStats(int curBody, int curEnergy, int curStamina, byte curRelease, byte b) {
/* 20 */     this.curBody = curBody;
/* 21 */     this.curEnergy = curEnergy;
/* 22 */     this.curStamina = curStamina;
/* 23 */     this.curRelease = curRelease;
/* 24 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 29 */     buffer.writeInt(this.curBody);
/* 30 */     buffer.writeInt(this.curEnergy);
/* 31 */     buffer.writeInt(this.curStamina);
/* 32 */     buffer.writeByte(this.curRelease);
/* 33 */     buffer.writeByte(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 38 */     this.curBody = buffer.readInt();
/* 39 */     this.curEnergy = buffer.readInt();
/* 40 */     this.curStamina = buffer.readInt();
/* 41 */     this.curRelease = buffer.readByte();
/* 42 */     this.b = buffer.readByte();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePStats> {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePStats m, MessageContext ctx) {
/* 48 */       JRMCoreClient.phc.handleStats(m.curBody, m.curEnergy, m.curStamina, m.curRelease, m.b);
/*    */ 
/*    */       
/* 51 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePStats m, MessageContext ctx) {
/* 59 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */