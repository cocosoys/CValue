/*     */ package net.minecraft.command;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import net.minecraft.profiler.Profiler;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommandDebug
/*     */   extends CommandBase
/*     */ {
/*  20 */   private static final Logger field_147208_a = LogManager.getLogger();
/*     */   private long field_147206_b;
/*     */   private int field_147207_c;
/*     */   private static final String __OBFID = "CL_00000270";
/*     */   
/*     */   public String func_71517_b() {
/*  26 */     return "debug";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  31 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  36 */     return "commands.debug.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  41 */     if (p_71515_2_.length == 1) {
/*  42 */       if (p_71515_2_[0].equals("start")) {
/*  43 */         func_152373_a(p_71515_1_, this, "commands.debug.start", new Object[0]);
/*     */         
/*  45 */         MinecraftServer.func_71276_C().func_71223_ag();
/*  46 */         this.field_147206_b = MinecraftServer.func_130071_aq();
/*  47 */         this.field_147207_c = MinecraftServer.func_71276_C().func_71259_af(); return;
/*     */       } 
/*  49 */       if (p_71515_2_[0].equals("stop")) {
/*  50 */         if (!(MinecraftServer.func_71276_C()).field_71304_b.field_76327_a) {
/*  51 */           throw new CommandException("commands.debug.notStarted", new Object[0]);
/*     */         }
/*     */         
/*  54 */         long l1 = MinecraftServer.func_130071_aq();
/*  55 */         int i = MinecraftServer.func_71276_C().func_71259_af();
/*     */         
/*  57 */         long l2 = l1 - this.field_147206_b;
/*  58 */         int j = i - this.field_147207_c;
/*     */         
/*  60 */         func_147205_a(l2, j);
/*     */         
/*  62 */         (MinecraftServer.func_71276_C()).field_71304_b.field_76327_a = false;
/*  63 */         func_152373_a(p_71515_1_, this, "commands.debug.stop", new Object[] { Float.valueOf((float)l2 / 1000.0F), Integer.valueOf(j) });
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  68 */     throw new WrongUsageException("commands.debug.usage", new Object[0]);
/*     */   }
/*     */   
/*     */   private void func_147205_a(long p_147205_1_, int p_147205_3_) {
/*  72 */     File file = new File(MinecraftServer.func_71276_C().func_71209_f("debug"), "profile-results-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");
/*     */     
/*  74 */     file.getParentFile().mkdirs();
/*     */     
/*     */     try {
/*  77 */       FileWriter fileWriter = new FileWriter(file);
/*  78 */       fileWriter.write(func_147204_b(p_147205_1_, p_147205_3_));
/*  79 */       fileWriter.close();
/*  80 */     } catch (Throwable throwable) {
/*  81 */       field_147208_a.error("Could not save profiler results to " + file, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String func_147204_b(long p_147204_1_, int p_147204_3_) {
/*  86 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  88 */     stringBuilder.append("---- Minecraft Profiler Results ----\n");
/*  89 */     stringBuilder.append("// ");
/*  90 */     stringBuilder.append(func_147203_d());
/*  91 */     stringBuilder.append("\n\n");
/*     */     
/*  93 */     stringBuilder.append("Time span: ").append(p_147204_1_).append(" ms\n");
/*  94 */     stringBuilder.append("Tick span: ").append(p_147204_3_).append(" ticks\n");
/*  95 */     stringBuilder.append("// This is approximately ").append(String.format("%.2f", new Object[] { Float.valueOf(p_147204_3_ / (float)p_147204_1_ / 1000.0F) })).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
/*     */ 
/*     */     
/*  98 */     stringBuilder.append("--- BEGIN PROFILE DUMP ---\n\n");
/*     */     
/* 100 */     func_147202_a(0, "root", stringBuilder);
/*     */     
/* 102 */     stringBuilder.append("--- END PROFILE DUMP ---\n\n");
/*     */     
/* 104 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void func_147202_a(int p_147202_1_, String p_147202_2_, StringBuilder p_147202_3_) {
/* 108 */     List<Profiler.Result> list = (MinecraftServer.func_71276_C()).field_71304_b.func_76321_b(p_147202_2_);
/* 109 */     if (list == null || list.size() < 3)
/*     */       return; 
/* 111 */     for (byte b = 1; b < list.size(); b++) {
/* 112 */       Profiler.Result result = list.get(b);
/*     */       
/* 114 */       p_147202_3_.append(String.format("[%02d] ", new Object[] { Integer.valueOf(p_147202_1_) }));
/* 115 */       for (byte b1 = 0; b1 < p_147202_1_; b1++)
/* 116 */         p_147202_3_.append(" "); 
/* 117 */       p_147202_3_.append(result.field_76331_c);
/* 118 */       p_147202_3_.append(" - ");
/* 119 */       p_147202_3_.append(String.format("%.2f", new Object[] { Double.valueOf(result.field_76332_a) }));
/* 120 */       p_147202_3_.append("%/");
/* 121 */       p_147202_3_.append(String.format("%.2f", new Object[] { Double.valueOf(result.field_76330_b) }));
/* 122 */       p_147202_3_.append("%\n");
/*     */       
/* 124 */       if (!result.field_76331_c.equals("unspecified")) {
/*     */         try {
/* 126 */           func_147202_a(p_147202_1_ + 1, p_147202_2_ + "." + result.field_76331_c, p_147202_3_);
/* 127 */         } catch (Exception exception) {
/* 128 */           p_147202_3_.append("[[ EXCEPTION " + exception + " ]]");
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String func_147203_d() {
/* 136 */     String[] arrayOfString = { "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server." };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 143 */       return arrayOfString[(int)(System.nanoTime() % arrayOfString.length)];
/* 144 */     } catch (Throwable throwable) {
/* 145 */       return "Witty comment unavailable :(";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 151 */     if (p_71516_2_.length == 1) return func_71530_a(p_71516_2_, new String[] { "start", "stop" });
/*     */     
/* 153 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandDebug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */