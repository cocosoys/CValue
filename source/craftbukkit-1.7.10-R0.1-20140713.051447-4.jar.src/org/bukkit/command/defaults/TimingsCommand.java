/*     */ package org.bukkit.command.defaults;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.RegisteredListener;
/*     */ import org.bukkit.plugin.TimedRegisteredListener;
/*     */ import org.bukkit.util.StringUtil;
/*     */ 
/*     */ public class TimingsCommand
/*     */   extends BukkitCommand
/*     */ {
/*  23 */   private static final List<String> TIMINGS_SUBCOMMANDS = (List<String>)ImmutableList.of("merged", "reset", "separate");
/*     */   
/*     */   public TimingsCommand(String name) {
/*  26 */     super(name);
/*  27 */     this.description = "Records timings for all plugin events";
/*  28 */     this.usageMessage = "/timings <reset|merged|separate>";
/*  29 */     setPermission("bukkit.command.timings");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean execute(CommandSender sender, String currentAlias, String[] args) {
/*  34 */     if (!testPermission(sender)) return true; 
/*  35 */     if (args.length != 1) {
/*  36 */       sender.sendMessage(ChatColor.RED + "Usage: " + this.usageMessage);
/*  37 */       return false;
/*     */     } 
/*  39 */     if (!sender.getServer().getPluginManager().useTimings()) {
/*  40 */       sender.sendMessage("Please enable timings by setting \"settings.plugin-profiling\" to true in bukkit.yml");
/*  41 */       return true;
/*     */     } 
/*     */     
/*  44 */     boolean separate = "separate".equals(args[0]);
/*  45 */     if ("reset".equals(args[0])) {
/*  46 */       for (HandlerList handlerList : HandlerList.getHandlerLists()) {
/*  47 */         for (RegisteredListener listener : handlerList.getRegisteredListeners()) {
/*  48 */           if (listener instanceof TimedRegisteredListener) {
/*  49 */             ((TimedRegisteredListener)listener).reset();
/*     */           }
/*     */         } 
/*     */       } 
/*  53 */       sender.sendMessage("Timings reset");
/*  54 */     } else if ("merged".equals(args[0]) || separate) {
/*     */       
/*  56 */       int index = 0;
/*  57 */       int pluginIdx = 0;
/*  58 */       File timingFolder = new File("timings");
/*  59 */       timingFolder.mkdirs();
/*  60 */       File timings = new File(timingFolder, "timings.txt");
/*  61 */       File names = null;
/*  62 */       for (; timings.exists(); timings = new File(timingFolder, "timings" + ++index + ".txt"));
/*  63 */       PrintStream fileTimings = null;
/*  64 */       PrintStream fileNames = null;
/*     */       
/*  66 */       try { fileTimings = new PrintStream(timings);
/*  67 */         if (separate) {
/*  68 */           names = new File(timingFolder, "names" + index + ".txt");
/*  69 */           fileNames = new PrintStream(names);
/*     */         } 
/*  71 */         for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
/*  72 */           pluginIdx++;
/*  73 */           long totalTime = 0L;
/*  74 */           if (separate) {
/*  75 */             fileNames.println(pluginIdx + " " + plugin.getDescription().getFullName());
/*  76 */             fileTimings.println("Plugin " + pluginIdx);
/*     */           } else {
/*  78 */             fileTimings.println(plugin.getDescription().getFullName());
/*  79 */           }  for (RegisteredListener listener : HandlerList.getRegisteredListeners(plugin)) {
/*  80 */             if (listener instanceof TimedRegisteredListener) {
/*  81 */               TimedRegisteredListener trl = (TimedRegisteredListener)listener;
/*  82 */               long time = trl.getTotalTime();
/*  83 */               int count = trl.getCount();
/*  84 */               if (count == 0)
/*  85 */                 continue;  long avg = time / count;
/*  86 */               totalTime += time;
/*  87 */               Class<? extends Event> eventClass = trl.getEventClass();
/*  88 */               if (count > 0 && eventClass != null) {
/*  89 */                 fileTimings.println("    " + eventClass.getSimpleName() + (trl.hasMultiple() ? " (and sub-classes)" : "") + " Time: " + time + " Count: " + count + " Avg: " + avg);
/*     */               }
/*     */             } 
/*     */           } 
/*  93 */           fileTimings.println("    Total time " + totalTime + " (" + (totalTime / 1000000000L) + "s)");
/*     */         } 
/*  95 */         sender.sendMessage("Timings written to " + timings.getPath());
/*  96 */         if (separate) sender.sendMessage("Names written to " + names.getPath());  }
/*  97 */       catch (IOException e) {  }
/*     */       finally
/*  99 */       { if (fileTimings != null) {
/* 100 */           fileTimings.close();
/*     */         }
/* 102 */         if (fileNames != null) {
/* 103 */           fileNames.close();
/*     */         } }
/*     */     
/*     */     } 
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
/* 112 */     Validate.notNull(sender, "Sender cannot be null");
/* 113 */     Validate.notNull(args, "Arguments cannot be null");
/* 114 */     Validate.notNull(alias, "Alias cannot be null");
/*     */     
/* 116 */     if (args.length == 1) {
/* 117 */       return (List<String>)StringUtil.copyPartialMatches(args[0], TIMINGS_SUBCOMMANDS, new ArrayList(TIMINGS_SUBCOMMANDS.size()));
/*     */     }
/* 119 */     return (List<String>)ImmutableList.of();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\defaults\TimingsCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */