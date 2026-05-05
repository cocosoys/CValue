/*    */ package org.bukkit.command;
/*    */ 
/*    */ 
/*    */ public class MultipleCommandAlias
/*    */   extends Command
/*    */ {
/*    */   private Command[] commands;
/*    */   
/*    */   public MultipleCommandAlias(String name, Command[] commands) {
/* 10 */     super(name);
/* 11 */     this.commands = commands;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Command[] getCommands() {
/* 20 */     return this.commands;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean execute(CommandSender sender, String commandLabel, String[] args) {
/* 25 */     boolean result = false;
/*    */     
/* 27 */     for (Command command : this.commands) {
/* 28 */       result |= command.execute(sender, commandLabel, args);
/*    */     }
/*    */     
/* 31 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\MultipleCommandAlias.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */