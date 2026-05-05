/*    */ package net.minecraftforge.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.ChatComponentTranslation;
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
/*    */ @Cancelable
/*    */ public class ServerChatEvent
/*    */   extends Event
/*    */ {
/*    */   public final String message;
/*    */   public final String username;
/*    */   public final EntityPlayerMP player;
/*    */   public ChatComponentTranslation component;
/*    */   
/*    */   public ServerChatEvent(EntityPlayerMP player, String message, ChatComponentTranslation component) {
/* 34 */     this.message = message;
/* 35 */     this.player = player;
/* 36 */     this.username = player.getGameProfile().getName();
/* 37 */     this.component = component;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\ServerChatEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */