/*    */ package org.bukkit.command;
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
/*    */ public class CommandException
/*    */   extends RuntimeException
/*    */ {
/*    */   public CommandException() {}
/*    */   
/*    */   public CommandException(String msg) {
/* 22 */     super(msg);
/*    */   }
/*    */   
/*    */   public CommandException(String msg, Throwable cause) {
/* 26 */     super(msg, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\CommandException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */