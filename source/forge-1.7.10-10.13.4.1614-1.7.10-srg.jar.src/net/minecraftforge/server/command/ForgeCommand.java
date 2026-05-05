/*     */ package net.minecraftforge.server.command;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.text.DecimalFormat;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ import net.minecraftforge.server.ForgeTimeTracker;
/*     */ 
/*     */ public class ForgeCommand extends CommandBase {
/*  15 */   private static final DecimalFormat timeFormatter = new DecimalFormat("########0.000");
/*     */   
/*     */   private WeakReference<MinecraftServer> server;
/*     */   
/*     */   public ForgeCommand(MinecraftServer server) {
/*  20 */     this.server = new WeakReference<MinecraftServer>(server);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommandName() {
/*  26 */     return "forge";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommandUsage(ICommandSender icommandsender) {
/*  32 */     return "commands.forge.usage";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRequiredPermissionLevel() {
/*  41 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void processCommand(ICommandSender sender, String[] args) {
/*  46 */     if (args.length == 0)
/*     */     {
/*  48 */       throw new WrongUsageException("commands.forge.usage", new Object[0]);
/*     */     }
/*  50 */     if ("help".equals(args[0]))
/*     */     {
/*  52 */       throw new WrongUsageException("commands.forge.usage", new Object[0]);
/*     */     }
/*  54 */     if ("tps".equals(args[0])) {
/*     */       
/*  56 */       displayTPS(sender, args);
/*     */     }
/*  58 */     else if ("tpslog".equals(args[0])) {
/*     */       
/*  60 */       doTPSLog(sender, args);
/*     */     }
/*  62 */     else if ("track".equals(args[0])) {
/*     */       
/*  64 */       handleTracking(sender, args);
/*     */     }
/*     */     else {
/*     */       
/*  68 */       throw new WrongUsageException("commands.forge.usage", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleTracking(ICommandSender sender, String[] args) {
/*  74 */     if (args.length != 3)
/*     */     {
/*  76 */       throw new WrongUsageException("commands.forge.usage.tracking", new Object[0]);
/*     */     }
/*  78 */     String type = args[1];
/*  79 */     int duration = parseIntBounded(sender, args[2], 1, 60);
/*     */     
/*  81 */     if ("te".equals(type)) {
/*     */       
/*  83 */       doTurnOnTileEntityTracking(sender, duration);
/*     */     }
/*     */     else {
/*     */       
/*  87 */       throw new WrongUsageException("commands.forge.usage.tracking", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void doTurnOnTileEntityTracking(ICommandSender sender, int duration) {
/*  93 */     ForgeTimeTracker.tileEntityTrackingDuration = duration;
/*  94 */     ForgeTimeTracker.tileEntityTracking = true;
/*  95 */     sender.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.forge.tracking.te.enabled", new Object[] { Integer.valueOf(duration) }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doTPSLog(ICommandSender sender, String[] args) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void displayTPS(ICommandSender sender, String[] args) {
/* 105 */     int dim = 0;
/* 106 */     boolean summary = true;
/* 107 */     if (args.length > 1) {
/*     */       
/* 109 */       dim = parseInt(sender, args[1]);
/* 110 */       summary = false;
/*     */     } 
/* 112 */     if (summary) {
/*     */       
/* 114 */       for (Integer dimId : DimensionManager.getIDs()) {
/*     */         
/* 116 */         double worldTickTime = mean((long[])(getServer()).worldTickTimes.get(dimId)) * 1.0E-6D;
/* 117 */         double worldTPS = Math.min(1000.0D / worldTickTime, 20.0D);
/* 118 */         sender.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.forge.tps.summary", new Object[] { String.format("Dim %d", new Object[] { dimId }), timeFormatter.format(worldTickTime), timeFormatter.format(worldTPS) }));
/*     */       } 
/* 120 */       double meanTickTime = mean((getServer()).tickTimeArray) * 1.0E-6D;
/* 121 */       double meanTPS = Math.min(1000.0D / meanTickTime, 20.0D);
/* 122 */       sender.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.forge.tps.summary", new Object[] { "Overall", timeFormatter.format(meanTickTime), timeFormatter.format(meanTPS) }));
/*     */     }
/*     */     else {
/*     */       
/* 126 */       double worldTickTime = mean((long[])(getServer()).worldTickTimes.get(Integer.valueOf(dim))) * 1.0E-6D;
/* 127 */       double worldTPS = Math.min(1000.0D / worldTickTime, 20.0D);
/* 128 */       sender.addChatMessage((IChatComponent)new ChatComponentTranslation("commands.forge.tps.summary", new Object[] { String.format("Dim %d", new Object[] { Integer.valueOf(dim) }), timeFormatter.format(worldTickTime), timeFormatter.format(worldTPS) }));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static long mean(long[] values) {
/* 134 */     long sum = 0L;
/* 135 */     for (long v : values)
/*     */     {
/* 137 */       sum += v;
/*     */     }
/*     */     
/* 140 */     return sum / values.length;
/*     */   }
/*     */ 
/*     */   
/*     */   private MinecraftServer getServer() {
/* 145 */     return this.server.get();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\server\command\ForgeCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */