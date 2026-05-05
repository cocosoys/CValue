/*     */ package org.bukkit.command;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.defaults.AchievementCommand;
/*     */ import org.bukkit.command.defaults.GiveCommand;
/*     */ import org.bukkit.command.defaults.KillCommand;
/*     */ import org.bukkit.command.defaults.OpCommand;
/*     */ import org.bukkit.command.defaults.SaveOnCommand;
/*     */ import org.bukkit.command.defaults.TeleportCommand;
/*     */ import org.bukkit.command.defaults.TimingsCommand;
/*     */ import org.bukkit.command.defaults.WhitelistCommand;
/*     */ 
/*     */ public class SimpleCommandMap implements CommandMap {
/*  21 */   private static final Pattern PATTERN_ON_SPACE = Pattern.compile(" ", 16);
/*  22 */   protected final Map<String, Command> knownCommands = new HashMap<String, Command>();
/*     */   private final Server server;
/*     */   
/*     */   public SimpleCommandMap(Server server) {
/*  26 */     this.server = server;
/*  27 */     setDefaultCommands();
/*     */   }
/*     */   
/*     */   private void setDefaultCommands() {
/*  31 */     register("bukkit", (Command)new SaveCommand());
/*  32 */     register("bukkit", (Command)new SaveOnCommand());
/*  33 */     register("bukkit", (Command)new SaveOffCommand());
/*  34 */     register("bukkit", (Command)new StopCommand());
/*  35 */     register("bukkit", (Command)new VersionCommand("version"));
/*  36 */     register("bukkit", (Command)new ReloadCommand("reload"));
/*  37 */     register("bukkit", (Command)new PluginsCommand("plugins"));
/*  38 */     register("bukkit", (Command)new TimingsCommand("timings"));
/*     */   }
/*     */   
/*     */   public void setFallbackCommands() {
/*  42 */     register("bukkit", (Command)new ListCommand());
/*  43 */     register("bukkit", (Command)new OpCommand());
/*  44 */     register("bukkit", (Command)new DeopCommand());
/*  45 */     register("bukkit", (Command)new BanIpCommand());
/*  46 */     register("bukkit", (Command)new PardonIpCommand());
/*  47 */     register("bukkit", (Command)new BanCommand());
/*  48 */     register("bukkit", (Command)new PardonCommand());
/*  49 */     register("bukkit", (Command)new KickCommand());
/*  50 */     register("bukkit", (Command)new TeleportCommand());
/*  51 */     register("bukkit", (Command)new GiveCommand());
/*  52 */     register("bukkit", (Command)new TimeCommand());
/*  53 */     register("bukkit", (Command)new SayCommand());
/*  54 */     register("bukkit", (Command)new WhitelistCommand());
/*  55 */     register("bukkit", (Command)new TellCommand());
/*  56 */     register("bukkit", (Command)new MeCommand());
/*  57 */     register("bukkit", (Command)new KillCommand());
/*  58 */     register("bukkit", (Command)new GameModeCommand());
/*  59 */     register("bukkit", (Command)new HelpCommand());
/*  60 */     register("bukkit", (Command)new ExpCommand());
/*  61 */     register("bukkit", (Command)new ToggleDownfallCommand());
/*  62 */     register("bukkit", (Command)new BanListCommand());
/*  63 */     register("bukkit", (Command)new DefaultGameModeCommand());
/*  64 */     register("bukkit", (Command)new SeedCommand());
/*  65 */     register("bukkit", (Command)new DifficultyCommand());
/*  66 */     register("bukkit", (Command)new WeatherCommand());
/*  67 */     register("bukkit", (Command)new SpawnpointCommand());
/*  68 */     register("bukkit", (Command)new ClearCommand());
/*  69 */     register("bukkit", (Command)new GameRuleCommand());
/*  70 */     register("bukkit", (Command)new EnchantCommand());
/*  71 */     register("bukkit", (Command)new TestForCommand());
/*  72 */     register("bukkit", (Command)new EffectCommand());
/*  73 */     register("bukkit", (Command)new ScoreboardCommand());
/*  74 */     register("bukkit", (Command)new PlaySoundCommand());
/*  75 */     register("bukkit", (Command)new SpreadPlayersCommand());
/*  76 */     register("bukkit", (Command)new SetWorldSpawnCommand());
/*  77 */     register("bukkit", (Command)new SetIdleTimeoutCommand());
/*  78 */     register("bukkit", (Command)new AchievementCommand());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerAll(String fallbackPrefix, List<Command> commands) {
/*  85 */     if (commands != null) {
/*  86 */       for (Command c : commands) {
/*  87 */         register(fallbackPrefix, c);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean register(String fallbackPrefix, Command command) {
/*  96 */     return register(command.getName(), fallbackPrefix, command);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean register(String label, String fallbackPrefix, Command command) {
/* 103 */     label = label.toLowerCase().trim();
/* 104 */     fallbackPrefix = fallbackPrefix.toLowerCase().trim();
/* 105 */     boolean registered = register(label, command, false, fallbackPrefix);
/*     */     
/* 107 */     Iterator<String> iterator = command.getAliases().iterator();
/* 108 */     while (iterator.hasNext()) {
/* 109 */       if (!register(iterator.next(), command, true, fallbackPrefix)) {
/* 110 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 115 */     if (!registered) {
/* 116 */       command.setLabel(fallbackPrefix + ":" + label);
/*     */     }
/*     */ 
/*     */     
/* 120 */     command.register(this);
/*     */     
/* 122 */     return registered;
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
/*     */   private synchronized boolean register(String label, Command command, boolean isAlias, String fallbackPrefix) {
/* 137 */     this.knownCommands.put(fallbackPrefix + ":" + label, command);
/* 138 */     if ((command instanceof org.bukkit.command.defaults.VanillaCommand || isAlias) && this.knownCommands.containsKey(label))
/*     */     {
/*     */ 
/*     */       
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     boolean registered = true;
/*     */ 
/*     */     
/* 148 */     Command conflict = this.knownCommands.get(label);
/* 149 */     if (conflict != null && conflict.getLabel().equals(label)) {
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     if (!isAlias) {
/* 154 */       command.setLabel(label);
/*     */     }
/* 156 */     this.knownCommands.put(label, command);
/*     */     
/* 158 */     return registered;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dispatch(CommandSender sender, String commandLine) throws CommandException {
/* 165 */     String[] args = PATTERN_ON_SPACE.split(commandLine);
/*     */     
/* 167 */     if (args.length == 0) {
/* 168 */       return false;
/*     */     }
/*     */     
/* 171 */     String sentCommandLabel = args[0].toLowerCase();
/* 172 */     Command target = getCommand(sentCommandLabel);
/*     */     
/* 174 */     if (target == null) {
/* 175 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 180 */       target.execute(sender, sentCommandLabel, (String[])Java15Compat.Arrays_copyOfRange((Object[])args, 1, args.length));
/* 181 */     } catch (CommandException ex) {
/* 182 */       throw ex;
/* 183 */     } catch (Throwable ex) {
/* 184 */       throw new CommandException("Unhandled exception executing '" + commandLine + "' in " + target, ex);
/*     */     } 
/*     */ 
/*     */     
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   public synchronized void clearCommands() {
/* 192 */     for (Map.Entry<String, Command> entry : this.knownCommands.entrySet()) {
/* 193 */       ((Command)entry.getValue()).unregister(this);
/*     */     }
/* 195 */     this.knownCommands.clear();
/* 196 */     setDefaultCommands();
/*     */   }
/*     */   
/*     */   public Command getCommand(String name) {
/* 200 */     Command target = this.knownCommands.get(name.toLowerCase());
/* 201 */     return target;
/*     */   }
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String cmdLine) {
/* 205 */     Validate.notNull(sender, "Sender cannot be null");
/* 206 */     Validate.notNull(cmdLine, "Command line cannot null");
/*     */     
/* 208 */     int spaceIndex = cmdLine.indexOf(' ');
/*     */     
/* 210 */     if (spaceIndex == -1) {
/* 211 */       ArrayList<String> completions = new ArrayList<String>();
/* 212 */       Map<String, Command> knownCommands = this.knownCommands;
/*     */       
/* 214 */       String prefix = (sender instanceof org.bukkit.entity.Player) ? "/" : "";
/*     */       
/* 216 */       for (Map.Entry<String, Command> commandEntry : knownCommands.entrySet()) {
/* 217 */         Command command = commandEntry.getValue();
/*     */         
/* 219 */         if (!command.testPermissionSilent(sender)) {
/*     */           continue;
/*     */         }
/*     */         
/* 223 */         String name = commandEntry.getKey();
/*     */         
/* 225 */         if (StringUtil.startsWithIgnoreCase(name, cmdLine)) {
/* 226 */           completions.add(prefix + name);
/*     */         }
/*     */       } 
/*     */       
/* 230 */       Collections.sort(completions, String.CASE_INSENSITIVE_ORDER);
/* 231 */       return completions;
/*     */     } 
/*     */     
/* 234 */     String commandName = cmdLine.substring(0, spaceIndex);
/* 235 */     Command target = getCommand(commandName);
/*     */     
/* 237 */     if (target == null) {
/* 238 */       return null;
/*     */     }
/*     */     
/* 241 */     if (!target.testPermissionSilent(sender)) {
/* 242 */       return null;
/*     */     }
/*     */     
/* 245 */     String argLine = cmdLine.substring(spaceIndex + 1, cmdLine.length());
/* 246 */     String[] args = PATTERN_ON_SPACE.split(argLine, -1);
/*     */     
/*     */     try {
/* 249 */       return target.tabComplete(sender, commandName, args);
/* 250 */     } catch (CommandException ex) {
/* 251 */       throw ex;
/* 252 */     } catch (Throwable ex) {
/* 253 */       throw new CommandException("Unhandled exception executing tab-completer for '" + cmdLine + "' in " + target, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Collection<Command> getCommands() {
/* 258 */     return Collections.unmodifiableCollection(this.knownCommands.values());
/*     */   }
/*     */   
/*     */   public void registerServerAliases() {
/* 262 */     Map<String, String[]> values = this.server.getCommandAliases();
/*     */     
/* 264 */     for (String alias : values.keySet()) {
/* 265 */       if (alias.contains(":") || alias.contains(" ")) {
/* 266 */         this.server.getLogger().warning("Could not register alias " + alias + " because it contains illegal characters");
/*     */         
/*     */         continue;
/*     */       } 
/* 270 */       String[] commandStrings = values.get(alias);
/* 271 */       List<String> targets = new ArrayList<String>();
/* 272 */       StringBuilder bad = new StringBuilder();
/*     */       
/* 274 */       for (String commandString : commandStrings) {
/* 275 */         String[] commandArgs = commandString.split(" ");
/* 276 */         Command command = getCommand(commandArgs[0]);
/*     */         
/* 278 */         if (command == null) {
/* 279 */           if (bad.length() > 0) {
/* 280 */             bad.append(", ");
/*     */           }
/* 282 */           bad.append(commandString);
/*     */         } else {
/* 284 */           targets.add(commandString);
/*     */         } 
/*     */       } 
/*     */       
/* 288 */       if (bad.length() > 0) {
/* 289 */         this.server.getLogger().warning("Could not register alias " + alias + " because it contains commands that do not exist: " + bad);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 294 */       if (targets.size() > 0) {
/* 295 */         this.knownCommands.put(alias.toLowerCase(), new FormattedCommandAlias(alias.toLowerCase(), targets.<String>toArray(new String[targets.size()]))); continue;
/*     */       } 
/* 297 */       this.knownCommands.remove(alias.toLowerCase());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\SimpleCommandMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */