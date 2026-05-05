/*    */ package JinRyuu.JRMCore.p;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JRMCorePData3
/*    */   implements IMessage
/*    */ {
/*    */   private String title;
/*    */   private String description;
/*    */   private byte category;
/*    */   
/*    */   public JRMCorePData3(String title, String description, byte category, byte icon, byte renderLocation, int iconColor) {
/* 20 */     this.title = title;
/* 21 */     this.description = description;
/* 22 */     this.category = category;
/* 23 */     this.icon = icon;
/* 24 */     this.renderLocation = renderLocation;
/* 25 */     this.iconColor = iconColor;
/*    */   }
/*    */   private byte icon; private byte renderLocation; private int iconColor;
/*    */   public JRMCorePData3() {}
/*    */   public void toBytes(ByteBuf buffer) {
/* 30 */     ByteBufUtils.writeUTF8String(buffer, this.title);
/* 31 */     ByteBufUtils.writeUTF8String(buffer, this.description);
/* 32 */     buffer.writeByte(this.category);
/* 33 */     buffer.writeByte(this.icon);
/* 34 */     buffer.writeByte(this.renderLocation);
/* 35 */     buffer.writeInt(this.iconColor);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buffer) {
/* 41 */     this.title = ByteBufUtils.readUTF8String(buffer);
/* 42 */     this.description = ByteBufUtils.readUTF8String(buffer);
/* 43 */     this.category = buffer.readByte();
/* 44 */     this.icon = buffer.readByte();
/* 45 */     this.renderLocation = buffer.readByte();
/* 46 */     this.iconColor = buffer.readInt();
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     extends BAmh<JRMCorePData3>
/*    */   {
/*    */     public IMessage handleClientMessage(EntityPlayer p, JRMCorePData3 m, MessageContext ctx) {
/* 53 */       JRMCoreClient.phc.handleNotification(p, m.title, m.description, m.category, m.icon, m.renderLocation, m.iconColor);
/* 54 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public IMessage handleServerMessage(EntityPlayer p, JRMCorePData3 m, MessageContext ctx) {
/* 60 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\JRMCorePData3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */