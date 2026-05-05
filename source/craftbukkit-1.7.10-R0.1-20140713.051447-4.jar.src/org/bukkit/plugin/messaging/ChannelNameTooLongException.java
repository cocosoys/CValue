/*    */ package org.bukkit.plugin.messaging;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChannelNameTooLongException
/*    */   extends RuntimeException
/*    */ {
/*    */   public ChannelNameTooLongException() {
/*  9 */     super("Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may be is 16 chars.");
/*    */   }
/*    */   
/*    */   public ChannelNameTooLongException(String channel) {
/* 13 */     super("Attempted to send a Plugin Message to a channel that was too large. The maximum length a channel may be is 16 chars (attempted " + channel.length() + " - '" + channel + ".");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\messaging\ChannelNameTooLongException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */