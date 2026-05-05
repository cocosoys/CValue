/*    */ package JinRyuu.JRMCore.p.YC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.BAmh;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class JYearsCPData
/*    */   implements IMessage {
/*    */   public static int i;
/*    */   public static String s;
/*    */   
/*    */   public JYearsCPData() {}
/*    */   
/*    */   public JYearsCPData(int i, String s) {
/* 18 */     this; JYearsCPData.i = i;
/* 19 */     this; JYearsCPData.s = s;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 24 */     buffer.writeInt(i);
/* 25 */     ByteBufUtils.writeUTF8String(buffer, s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 30 */     this; i = buffer.readInt();
/* 31 */     this; s = ByteBufUtils.readUTF8String(buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JYearsCPData>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer player, JYearsCPData m, MessageContext ctx) {
/* 39 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer Player, JYearsCPData m, MessageContext ctx) {
/* 46 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\YC\JYearsCPData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */