/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CAmh<T extends IMessage>
/*    */   extends Amh<T>
/*    */ {
/*    */   public final IMessage handleServerMessage(EntityPlayer player, T message, MessageContext ctx) {
/* 17 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\CAmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */