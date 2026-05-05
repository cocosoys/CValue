/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SyncPlayerPropsMessage
/*    */   implements IMessage
/*    */ {
/*    */   private NBTTagCompound data;
/*    */   
/*    */   public SyncPlayerPropsMessage() {}
/*    */   
/*    */   public SyncPlayerPropsMessage(EntityPlayer player) {
/* 49 */     this.data = new NBTTagCompound();
/*    */     
/* 51 */     ExtendedPlayer.get(player).saveNBTData(this.data);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 57 */     this.data = ByteBufUtils.readTag(buffer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buffer) {
/* 63 */     ByteBufUtils.writeTag(buffer, this.data);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Handler
/*    */     extends CAmh<SyncPlayerPropsMessage>
/*    */   {
/*    */     @SideOnly(Side.CLIENT)
/*    */     public IMessage handleClientMessage(EntityPlayer player, SyncPlayerPropsMessage message, MessageContext ctx) {
/* 74 */       ExtendedPlayer.get(player).loadNBTData(message.data);
/* 75 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\SyncPlayerPropsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */