/*    */ package org.bukkit.command.defaults;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ public class TestForCommand
/*    */   extends VanillaCommand {
/*    */   public TestForCommand() {
/*  9 */     super("testfor");
/* 10 */     this.description = "Tests whether a specifed player is online";
/* 11 */     this.usageMessage = "/testfor <player>";
/* 12 */     setPermission("bukkit.command.testfor");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean execute(CommandSender sender, String currentAlias, String[] args) {
/* 17 */     if (!testPermission(sender)) return true; 
/* 18 */     if (args.length < 1) {
/* 19 */       sender.sendMessage(ChatColor.RED + "Usage: " + this.usageMessage);
/* 20 */       return false;
/*    */     } 
/*    */     
/* 23 */     sender.sendMessage(ChatColor.RED + "/testfor is only usable by commandblocks with analog output.");
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\defaults\TestForCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */