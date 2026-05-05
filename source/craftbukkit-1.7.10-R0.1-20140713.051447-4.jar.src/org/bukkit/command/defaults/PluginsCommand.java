/*    */ package org.bukkit.command.defaults;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class PluginsCommand
/*    */   extends BukkitCommand {
/*    */   public PluginsCommand(String name) {
/* 12 */     super(name);
/* 13 */     this.description = "Gets a list of plugins running on the server";
/* 14 */     this.usageMessage = "/plugins";
/* 15 */     setPermission("bukkit.command.plugins");
/* 16 */     setAliases(Arrays.asList(new String[] { "pl" }));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean execute(CommandSender sender, String currentAlias, String[] args) {
/* 21 */     if (!testPermission(sender)) return true;
/*    */     
/* 23 */     sender.sendMessage("Plugins " + getPluginList());
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   private String getPluginList() {
/* 28 */     StringBuilder pluginList = new StringBuilder();
/* 29 */     Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
/*    */     
/* 31 */     for (Plugin plugin : plugins) {
/* 32 */       if (pluginList.length() > 0) {
/* 33 */         pluginList.append(ChatColor.WHITE);
/* 34 */         pluginList.append(", ");
/*    */       } 
/*    */       
/* 37 */       pluginList.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED);
/* 38 */       pluginList.append(plugin.getDescription().getName());
/*    */     } 
/*    */     
/* 41 */     return "(" + plugins.length + "): " + pluginList.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\defaults\PluginsCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */