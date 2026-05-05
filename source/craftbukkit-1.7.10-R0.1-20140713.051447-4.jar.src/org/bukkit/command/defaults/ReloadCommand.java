/*    */ package org.bukkit.command.defaults;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ public class ReloadCommand
/*    */   extends BukkitCommand {
/*    */   public ReloadCommand(String name) {
/* 12 */     super(name);
/* 13 */     this.description = "Reloads the server configuration and plugins";
/* 14 */     this.usageMessage = "/reload";
/* 15 */     setPermission("bukkit.command.reload");
/* 16 */     setAliases(Arrays.asList(new String[] { "rl" }));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean execute(CommandSender sender, String currentAlias, String[] args) {
/* 21 */     if (!testPermission(sender)) return true;
/*    */     
/* 23 */     Bukkit.reload();
/* 24 */     Command.broadcastCommandMessage(sender, ChatColor.GREEN + "Reload complete.");
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\defaults\ReloadCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */