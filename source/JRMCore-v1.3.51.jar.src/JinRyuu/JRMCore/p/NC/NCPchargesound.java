/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import JinRyuu.NarutoC.common.NC;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class NCPchargesound implements IMessage {
/*    */   int i;
/*    */   
/*    */   public NCPchargesound() {}
/*    */   
/*    */   public NCPchargesound(int i) {
/* 16 */     this.i = i;
/*    */   }
/*    */ 
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
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<NCPchargesound>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, NCPchargesound m, MessageContext ctx) {
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, NCPchargesound m, MessageContext ctx) {
/* 40 */       NC.phs.handleNCchargesound(m.i, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPchargesound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */