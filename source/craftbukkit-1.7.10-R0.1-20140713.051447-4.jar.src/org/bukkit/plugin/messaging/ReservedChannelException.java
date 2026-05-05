/*    */ package org.bukkit.plugin.messaging;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReservedChannelException
/*    */   extends RuntimeException
/*    */ {
/*    */   public ReservedChannelException() {
/* 10 */     this("Attempted to register for a reserved channel name.");
/*    */   }
/*    */   
/*    */   public ReservedChannelException(String name) {
/* 14 */     super("Attempted to register for a reserved channel name ('" + name + "')");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\messaging\ReservedChannelException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */