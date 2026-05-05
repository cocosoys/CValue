/*    */ package JinRyuu.JRMCore.p.NC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import JinRyuu.NarutoC.common.NC;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class NCPjumpsound implements IMessage {
/*    */   int i;
/*    */   
/*    */   public NCPjumpsound() {}
/*    */   
/*    */   public NCPjumpsound(int i) {
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
/*    */     extends BAmh<NCPjumpsound>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, NCPjumpsound m, MessageContext ctx) {
/* 35 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, NCPjumpsound m, MessageContext ctx) {
/* 40 */       NC.phs.handleNCjumpsound(m.i, p);
/*    */ 
/*    */       
/* 43 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\NC\NCPjumpsound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */