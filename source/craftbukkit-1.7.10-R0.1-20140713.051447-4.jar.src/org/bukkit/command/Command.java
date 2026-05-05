/*     */ package org.bukkit.command;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.minecart.CommandMinecart;
/*     */ import org.bukkit.permissions.Permissible;
/*     */ import org.bukkit.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Command
/*     */ {
/*     */   private final String name;
/*     */   private String nextLabel;
/*     */   private String label;
/*     */   private List<String> aliases;
/*     */   private List<String> activeAliases;
/*  29 */   private CommandMap commandMap = null;
/*  30 */   protected String description = "";
/*     */   protected String usageMessage;
/*     */   private String permission;
/*     */   private String permissionMessage;
/*     */   
/*     */   protected Command(String name) {
/*  36 */     this(name, "", "/" + name, new ArrayList<String>());
/*     */   }
/*     */   
/*     */   protected Command(String name, String description, String usageMessage, List<String> aliases) {
/*  40 */     this.name = name;
/*  41 */     this.nextLabel = name;
/*  42 */     this.label = name;
/*  43 */     this.description = description;
/*  44 */     this.usageMessage = usageMessage;
/*  45 */     this.aliases = aliases;
/*  46 */     this.activeAliases = new ArrayList<String>(aliases);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean execute(CommandSender paramCommandSender, String paramString, String[] paramArrayOfString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public List<String> tabComplete(CommandSender sender, String[] args) {
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
/*  79 */     Validate.notNull(sender, "Sender cannot be null");
/*  80 */     Validate.notNull(args, "Arguments cannot be null");
/*  81 */     Validate.notNull(alias, "Alias cannot be null");
/*     */     
/*  83 */     if (args.length == 0) {
/*  84 */       return (List<String>)ImmutableList.of();
/*     */     }
/*     */     
/*  87 */     String lastWord = args[args.length - 1];
/*     */     
/*  89 */     Player senderPlayer = (sender instanceof Player) ? (Player)sender : null;
/*     */     
/*  91 */     ArrayList<String> matchedPlayers = new ArrayList<String>();
/*  92 */     for (Player player : sender.getServer().getOnlinePlayers()) {
/*  93 */       String name = player.getName();
/*  94 */       if ((senderPlayer == null || senderPlayer.canSee(player)) && StringUtil.startsWithIgnoreCase(name, lastWord)) {
/*  95 */         matchedPlayers.add(name);
/*     */       }
/*     */     } 
/*     */     
/*  99 */     Collections.sort(matchedPlayers, String.CASE_INSENSITIVE_ORDER);
/* 100 */     return matchedPlayers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 109 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPermission() {
/* 119 */     return this.permission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPermission(String permission) {
/* 129 */     this.permission = permission;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean testPermission(CommandSender target) {
/* 143 */     if (testPermissionSilent(target)) {
/* 144 */       return true;
/*     */     }
/*     */     
/* 147 */     if (this.permissionMessage == null) {
/* 148 */       target.sendMessage(ChatColor.RED + "I'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
/* 149 */     } else if (this.permissionMessage.length() != 0) {
/* 150 */       for (String line : this.permissionMessage.replace("<permission>", this.permission).split("\n")) {
/* 151 */         target.sendMessage(line);
/*     */       }
/*     */     } 
/*     */     
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean testPermissionSilent(CommandSender target) {
/* 168 */     if (this.permission == null || this.permission.length() == 0) {
/* 169 */       return true;
/*     */     }
/*     */     
/* 172 */     for (String p : this.permission.split(";")) {
/* 173 */       if (target.hasPermission(p)) {
/* 174 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 187 */     return this.label;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setLabel(String name) {
/* 201 */     this.nextLabel = name;
/* 202 */     if (!isRegistered()) {
/* 203 */       this.label = name;
/* 204 */       return true;
/*     */     } 
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean register(CommandMap commandMap) {
/* 218 */     if (allowChangesFrom(commandMap)) {
/* 219 */       this.commandMap = commandMap;
/* 220 */       return true;
/*     */     } 
/*     */     
/* 223 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unregister(CommandMap commandMap) {
/* 236 */     if (allowChangesFrom(commandMap)) {
/* 237 */       this.commandMap = null;
/* 238 */       this.activeAliases = new ArrayList<String>(this.aliases);
/* 239 */       this.label = this.nextLabel;
/* 240 */       return true;
/*     */     } 
/*     */     
/* 243 */     return false;
/*     */   }
/*     */   
/*     */   private boolean allowChangesFrom(CommandMap commandMap) {
/* 247 */     return (null == this.commandMap || this.commandMap == commandMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRegistered() {
/* 256 */     return (null != this.commandMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getAliases() {
/* 265 */     return this.activeAliases;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPermissionMessage() {
/* 275 */     return this.permissionMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 284 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsage() {
/* 293 */     return this.usageMessage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Command setAliases(List<String> aliases) {
/* 306 */     this.aliases = aliases;
/* 307 */     if (!isRegistered()) {
/* 308 */       this.activeAliases = new ArrayList<String>(aliases);
/*     */     }
/* 310 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Command setDescription(String description) {
/* 322 */     this.description = description;
/* 323 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Command setPermissionMessage(String permissionMessage) {
/* 334 */     this.permissionMessage = permissionMessage;
/* 335 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Command setUsage(String usage) {
/* 345 */     this.usageMessage = usage;
/* 346 */     return this;
/*     */   }
/*     */   
/*     */   public static void broadcastCommandMessage(CommandSender source, String message) {
/* 350 */     broadcastCommandMessage(source, message, true);
/*     */   }
/*     */   
/*     */   public static void broadcastCommandMessage(CommandSender source, String message, boolean sendToSource) {
/* 354 */     String result = source.getName() + ": " + message;
/*     */     
/* 356 */     if (source instanceof BlockCommandSender) {
/* 357 */       BlockCommandSender blockCommandSender = (BlockCommandSender)source;
/*     */       
/* 359 */       if (blockCommandSender.getBlock().getWorld().getGameRuleValue("commandBlockOutput").equalsIgnoreCase("false")) {
/* 360 */         Bukkit.getConsoleSender().sendMessage(result);
/*     */         return;
/*     */       } 
/* 363 */     } else if (source instanceof CommandMinecart) {
/* 364 */       CommandMinecart commandMinecart = (CommandMinecart)source;
/*     */       
/* 366 */       if (commandMinecart.getWorld().getGameRuleValue("commandBlockOutput").equalsIgnoreCase("false")) {
/* 367 */         Bukkit.getConsoleSender().sendMessage(result);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 372 */     Set<Permissible> users = Bukkit.getPluginManager().getPermissionSubscriptions("bukkit.broadcast.admin");
/* 373 */     String colored = ChatColor.GRAY + "" + ChatColor.ITALIC + "[" + result + ChatColor.GRAY + ChatColor.ITALIC + "]";
/*     */     
/* 375 */     if (sendToSource && !(source instanceof ConsoleCommandSender)) {
/* 376 */       source.sendMessage(message);
/*     */     }
/*     */     
/* 379 */     for (Permissible user : users) {
/* 380 */       if (user instanceof CommandSender) {
/* 381 */         CommandSender target = (CommandSender)user;
/*     */         
/* 383 */         if (target instanceof ConsoleCommandSender) {
/* 384 */           target.sendMessage(result); continue;
/* 385 */         }  if (target != source) {
/* 386 */           target.sendMessage(colored);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 394 */     return getClass().getName() + '(' + this.name + ')';
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */