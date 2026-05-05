/*     */ package net.minecraft.crash;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.RuntimeMXBean;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.world.gen.layer.IntCache;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class CrashReport {
/*  18 */   private static final Logger field_147150_a = LogManager.getLogger();
/*     */   private final String field_71513_a;
/*     */   private final Throwable field_71511_b;
/*  21 */   private final CrashReportCategory field_85061_c = new CrashReportCategory(this, "System Details");
/*  22 */   private final List field_71512_c = new ArrayList();
/*     */   private File field_71510_d;
/*     */   private boolean field_85059_f = true;
/*  25 */   private StackTraceElement[] field_85060_g = new StackTraceElement[0]; private static final String __OBFID = "CL_00000990";
/*     */   
/*     */   public CrashReport(String p_i1348_1_, Throwable p_i1348_2_) {
/*  28 */     this.field_71513_a = p_i1348_1_;
/*  29 */     this.field_71511_b = p_i1348_2_;
/*     */     
/*  31 */     func_71504_g();
/*     */   }
/*     */   
/*     */   private void func_71504_g() {
/*  35 */     this.field_85061_c.func_71500_a("Minecraft Version", new Callable(this) { private static final String __OBFID = "CL_00001197";
/*     */           
/*     */           public String call() {
/*  38 */             return "1.7.10";
/*     */           } }
/*     */       );
/*     */     
/*  42 */     this.field_85061_c.func_71500_a("Operating System", new Callable(this) { private static final String __OBFID = "CL_00001222";
/*     */           
/*     */           public String call() {
/*  45 */             return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
/*     */           } }
/*     */       );
/*     */     
/*  49 */     this.field_85061_c.func_71500_a("Java Version", new Callable(this) { private static final String __OBFID = "CL_00001248";
/*     */           
/*     */           public String call() {
/*  52 */             return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
/*     */           } }
/*     */       );
/*     */     
/*  56 */     this.field_85061_c.func_71500_a("Java VM Version", new Callable(this) { private static final String __OBFID = "CL_00001275";
/*     */           
/*     */           public String call() {
/*  59 */             return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
/*     */           } }
/*     */       );
/*     */     
/*  63 */     this.field_85061_c.func_71500_a("Memory", new Callable(this) { private static final String __OBFID = "CL_00001302";
/*     */           
/*     */           public String call() {
/*  66 */             Runtime runtime = Runtime.getRuntime();
/*  67 */             long l1 = runtime.maxMemory();
/*  68 */             long l2 = runtime.totalMemory();
/*  69 */             long l3 = runtime.freeMemory();
/*  70 */             long l4 = l1 / 1024L / 1024L;
/*  71 */             long l5 = l2 / 1024L / 1024L;
/*  72 */             long l6 = l3 / 1024L / 1024L;
/*     */             
/*  74 */             return l3 + " bytes (" + l6 + " MB) / " + l2 + " bytes (" + l5 + " MB) up to " + l1 + " bytes (" + l4 + " MB)";
/*     */           } }
/*     */       );
/*     */     
/*  78 */     this.field_85061_c.func_71500_a("JVM Flags", new Callable(this) { private static final String __OBFID = "CL_00001329";
/*     */           
/*     */           public String call() {
/*  81 */             RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
/*  82 */             List<String> list = runtimeMXBean.getInputArguments();
/*  83 */             byte b = 0;
/*  84 */             StringBuilder stringBuilder = new StringBuilder();
/*     */             
/*  86 */             for (String str : list) {
/*  87 */               if (str.startsWith("-X")) {
/*  88 */                 if (b++ > 0) {
/*  89 */                   stringBuilder.append(" ");
/*     */                 }
/*     */                 
/*  92 */                 stringBuilder.append(str);
/*     */               } 
/*     */             } 
/*     */             
/*  96 */             return String.format("%d total; %s", new Object[] { Integer.valueOf(b), stringBuilder.toString() });
/*     */           } }
/*     */       );
/*     */     
/* 100 */     this.field_85061_c.func_71500_a("AABB Pool Size", new Callable(this) { private static final String __OBFID = "CL_00001355";
/*     */           
/*     */           public String call() {
/* 103 */             byte b1 = 0;
/* 104 */             int i = 56 * b1;
/* 105 */             int j = i / 1024 / 1024;
/* 106 */             byte b2 = 0;
/* 107 */             int k = 56 * b2;
/* 108 */             int m = k / 1024 / 1024;
/*     */             
/* 110 */             return b1 + " (" + i + " bytes; " + j + " MB) allocated, " + b2 + " (" + k + " bytes; " + m + " MB) used";
/*     */           } }
/*     */       );
/*     */     
/* 114 */     this.field_85061_c.func_71500_a("IntCache", new Callable(this) { private static final String __OBFID = "CL_00001382";
/*     */           
/*     */           public String call() throws SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
/* 117 */             return IntCache.func_85144_b();
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   public String func_71501_a() {
/* 123 */     return this.field_71513_a;
/*     */   }
/*     */   
/*     */   public Throwable func_71505_b() {
/* 127 */     return this.field_71511_b;
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
/*     */   public void func_71506_a(StringBuilder p_71506_1_) {
/* 139 */     if ((this.field_85060_g == null || this.field_85060_g.length <= 0) && this.field_71512_c.size() > 0) {
/* 140 */       this.field_85060_g = (StackTraceElement[])ArrayUtils.subarray((Object[])((CrashReportCategory)this.field_71512_c.get(0)).func_147152_a(), 0, 1);
/*     */     }
/*     */     
/* 143 */     if (this.field_85060_g != null && this.field_85060_g.length > 0) {
/* 144 */       p_71506_1_.append("-- Head --\n");
/* 145 */       p_71506_1_.append("Stacktrace:\n");
/*     */       
/* 147 */       for (StackTraceElement stackTraceElement : this.field_85060_g) {
/* 148 */         p_71506_1_.append("\t").append("at ").append(stackTraceElement.toString());
/* 149 */         p_71506_1_.append("\n");
/*     */       } 
/*     */       
/* 152 */       p_71506_1_.append("\n");
/*     */     } 
/*     */     
/* 155 */     for (CrashReportCategory crashReportCategory : this.field_71512_c) {
/* 156 */       crashReportCategory.func_85072_a(p_71506_1_);
/* 157 */       p_71506_1_.append("\n\n");
/*     */     } 
/*     */     
/* 160 */     this.field_85061_c.func_85072_a(p_71506_1_);
/*     */   }
/*     */   
/*     */   public String func_71498_d() {
/* 164 */     StringWriter stringWriter = null;
/* 165 */     PrintWriter printWriter = null;
/* 166 */     Throwable throwable = this.field_71511_b;
/*     */     
/* 168 */     if (throwable.getMessage() == null) {
/*     */       
/* 170 */       if (throwable instanceof NullPointerException) {
/* 171 */         throwable = new NullPointerException(this.field_71513_a);
/* 172 */       } else if (throwable instanceof StackOverflowError) {
/* 173 */         throwable = new StackOverflowError(this.field_71513_a);
/* 174 */       } else if (throwable instanceof OutOfMemoryError) {
/* 175 */         throwable = new OutOfMemoryError(this.field_71513_a);
/*     */       } 
/*     */       
/* 178 */       throwable.setStackTrace(this.field_71511_b.getStackTrace());
/*     */     } 
/*     */     
/* 181 */     String str = throwable.toString();
/*     */     
/*     */     try {
/* 184 */       stringWriter = new StringWriter();
/* 185 */       printWriter = new PrintWriter(stringWriter);
/* 186 */       throwable.printStackTrace(printWriter);
/* 187 */       str = stringWriter.toString();
/*     */     } finally {
/* 189 */       IOUtils.closeQuietly(stringWriter);
/* 190 */       IOUtils.closeQuietly(printWriter);
/*     */     } 
/*     */     
/* 193 */     return str;
/*     */   }
/*     */   
/*     */   public String func_71502_e() {
/* 197 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 199 */     stringBuilder.append("---- Minecraft Crash Report ----\n");
/* 200 */     stringBuilder.append("// ");
/* 201 */     stringBuilder.append(func_71503_h());
/* 202 */     stringBuilder.append("\n\n");
/*     */     
/* 204 */     stringBuilder.append("Time: ");
/* 205 */     stringBuilder.append((new SimpleDateFormat()).format(new Date()));
/* 206 */     stringBuilder.append("\n");
/*     */     
/* 208 */     stringBuilder.append("Description: ");
/* 209 */     stringBuilder.append(this.field_71513_a);
/* 210 */     stringBuilder.append("\n\n");
/*     */     
/* 212 */     stringBuilder.append(func_71498_d());
/* 213 */     stringBuilder.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
/*     */     
/* 215 */     for (byte b = 0; b < 87; b++) {
/* 216 */       stringBuilder.append("-");
/*     */     }
/* 218 */     stringBuilder.append("\n\n");
/* 219 */     func_71506_a(stringBuilder);
/*     */     
/* 221 */     return stringBuilder.toString();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public File func_71497_f() {
/* 225 */     return this.field_71510_d;
/*     */   }
/*     */   
/*     */   public boolean func_147149_a(File p_147149_1_) {
/* 229 */     if (this.field_71510_d != null) return false; 
/* 230 */     if (p_147149_1_.getParentFile() != null) p_147149_1_.getParentFile().mkdirs();
/*     */     
/*     */     try {
/* 233 */       FileWriter fileWriter = new FileWriter(p_147149_1_);
/* 234 */       fileWriter.write(func_71502_e());
/* 235 */       fileWriter.close();
/*     */       
/* 237 */       this.field_71510_d = p_147149_1_;
/* 238 */       return true;
/* 239 */     } catch (Throwable throwable) {
/* 240 */       field_147150_a.error("Could not save crash report to " + p_147149_1_, throwable);
/* 241 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public CrashReportCategory func_85056_g() {
/* 246 */     return this.field_85061_c;
/*     */   }
/*     */   
/*     */   public CrashReportCategory func_85058_a(String p_85058_1_) {
/* 250 */     return func_85057_a(p_85058_1_, 1);
/*     */   }
/*     */   
/*     */   public CrashReportCategory func_85057_a(String p_85057_1_, int p_85057_2_) {
/* 254 */     CrashReportCategory crashReportCategory = new CrashReportCategory(this, p_85057_1_);
/*     */     
/* 256 */     if (this.field_85059_f) {
/* 257 */       int i = crashReportCategory.func_85073_a(p_85057_2_);
/* 258 */       StackTraceElement[] arrayOfStackTraceElement = this.field_71511_b.getStackTrace();
/* 259 */       StackTraceElement stackTraceElement1 = null;
/* 260 */       StackTraceElement stackTraceElement2 = null;
/*     */       
/* 262 */       int j = arrayOfStackTraceElement.length - i;
/* 263 */       if (j < 0) {
/* 264 */         System.out.println("Negative index in crash report handler (" + arrayOfStackTraceElement.length + "/" + i + ")");
/*     */       }
/*     */       
/* 267 */       if (arrayOfStackTraceElement != null && 0 <= j && j < arrayOfStackTraceElement.length) {
/* 268 */         stackTraceElement1 = arrayOfStackTraceElement[j];
/*     */         
/* 270 */         if (arrayOfStackTraceElement.length + 1 - i < arrayOfStackTraceElement.length) {
/* 271 */           stackTraceElement2 = arrayOfStackTraceElement[arrayOfStackTraceElement.length + 1 - i];
/*     */         }
/*     */       } 
/*     */       
/* 275 */       this.field_85059_f = crashReportCategory.func_85069_a(stackTraceElement1, stackTraceElement2);
/*     */       
/* 277 */       if (i > 0 && !this.field_71512_c.isEmpty()) {
/* 278 */         CrashReportCategory crashReportCategory1 = this.field_71512_c.get(this.field_71512_c.size() - 1);
/* 279 */         crashReportCategory1.func_85070_b(i);
/* 280 */       } else if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length >= i && 0 <= j && j < arrayOfStackTraceElement.length) {
/* 281 */         this.field_85060_g = new StackTraceElement[j];
/* 282 */         System.arraycopy(arrayOfStackTraceElement, 0, this.field_85060_g, 0, this.field_85060_g.length);
/*     */       } else {
/* 284 */         this.field_85059_f = false;
/*     */       } 
/*     */     } 
/*     */     
/* 288 */     this.field_71512_c.add(crashReportCategory);
/* 289 */     return crashReportCategory;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String func_71503_h() {
/* 294 */     String[] arrayOfString = { "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!", "But it works on my machine." };
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
/*     */     try {
/* 332 */       return arrayOfString[(int)(System.nanoTime() % arrayOfString.length)];
/* 333 */     } catch (Throwable throwable) {
/* 334 */       return "Witty comment unavailable :(";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static CrashReport func_85055_a(Throwable p_85055_0_, String p_85055_1_) {
/*     */     CrashReport crashReport;
/* 341 */     if (p_85055_0_ instanceof ReportedException) {
/* 342 */       crashReport = ((ReportedException)p_85055_0_).func_71575_a();
/*     */     } else {
/* 344 */       crashReport = new CrashReport(p_85055_1_, p_85055_0_);
/*     */     } 
/*     */     
/* 347 */     return crashReport;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\crash\CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */