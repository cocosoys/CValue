/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class ProgressManager
/*     */ {
/*  15 */   private static final List<ProgressBar> bars = new CopyOnWriteArrayList<ProgressBar>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static ProgressBar push(String title, int steps) {
/*  23 */     return push(title, steps, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static ProgressBar push(String title, int steps, boolean timeEachStep) {
/*  31 */     ProgressBar bar = new ProgressBar(title, steps);
/*  32 */     bars.add(bar);
/*  33 */     if (timeEachStep)
/*     */     {
/*  35 */       bar.timeEachStep();
/*     */     }
/*  37 */     FMLCommonHandler.instance().processWindowMessages();
/*  38 */     return bar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void pop(ProgressBar bar) {
/*  47 */     if (bar.getSteps() != bar.getStep()) throw new IllegalStateException("can't pop unfinished ProgressBar " + bar.getTitle()); 
/*  48 */     bars.remove(bar);
/*  49 */     if (bar.getSteps() != 0) {
/*     */       
/*  51 */       long newTime = System.nanoTime();
/*  52 */       if (bar.timeEachStep)
/*  53 */         FMLLog.fine("Bar Step: %s - %s took %.3fs", new Object[] { bar.getTitle(), bar.getMessage(), Float.valueOf((float)(newTime - ProgressBar.access$200(bar)) / 1000000.0F / 1000.0F) }); 
/*  54 */       if (bar.getSteps() == 1) {
/*  55 */         FMLLog.fine("Bar Finished: %s - %s took %.3fs", new Object[] { bar.getTitle(), bar.getMessage(), Float.valueOf((float)(newTime - ProgressBar.access$300(bar)) / 1000000.0F / 1000.0F) });
/*     */       } else {
/*  57 */         FMLLog.fine("Bar Finished: %s took %.3fs", new Object[] { bar.getTitle(), Float.valueOf((float)(newTime - ProgressBar.access$300(bar)) / 1000000.0F / 1000.0F) });
/*     */       } 
/*  59 */     }  FMLCommonHandler.instance().processWindowMessages();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Iterator<ProgressBar> barIterator() {
/*  67 */     return bars.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class ProgressBar
/*     */   {
/*     */     private final String title;
/*     */     
/*     */     private final int steps;
/*     */     
/*  78 */     private volatile int step = 0;
/*  79 */     private volatile String message = "";
/*     */     private boolean timeEachStep = false;
/*  81 */     private long startTime = System.nanoTime();
/*  82 */     private long lastTime = this.startTime;
/*     */ 
/*     */     
/*     */     private ProgressBar(String title, int steps) {
/*  86 */       this.title = title;
/*  87 */       this.steps = steps;
/*     */     }
/*     */ 
/*     */     
/*     */     public void step(Class<?> classToName, String... extra) {
/*  92 */       step(ClassNameUtils.shortName(classToName) + Joiner.on(' ').join((Object[])extra));
/*     */     }
/*     */ 
/*     */     
/*     */     public void step(String message) {
/*  97 */       if (this.step >= this.steps) throw new IllegalStateException("too much steps for ProgressBar " + this.title); 
/*  98 */       if (this.timeEachStep && this.step != 0) {
/*     */         
/* 100 */         long newTime = System.nanoTime();
/* 101 */         FMLLog.fine("Bar Step: %s - %s took %.3fs", new Object[] { getTitle(), getMessage(), Float.valueOf((float)(newTime - this.lastTime) / 1000000.0F / 1000.0F) });
/* 102 */         this.lastTime = newTime;
/*     */       } 
/* 104 */       this.step++;
/* 105 */       this.message = FMLCommonHandler.instance().stripSpecialChars(message);
/* 106 */       FMLCommonHandler.instance().processWindowMessages();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getTitle() {
/* 111 */       return this.title;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSteps() {
/* 116 */       return this.steps;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getStep() {
/* 121 */       return this.step;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMessage() {
/* 126 */       return this.message;
/*     */     }
/*     */ 
/*     */     
/*     */     public void timeEachStep() {
/* 131 */       this.timeEachStep = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ProgressManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */