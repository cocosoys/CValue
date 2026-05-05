/*    */ package org.bukkit.craftbukkit.v1_7_R4.scheduler;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitTask;
/*    */ 
/*    */ class CraftTask
/*    */   implements BukkitTask, Runnable
/*    */ {
/* 10 */   private volatile CraftTask next = null;
/*    */ 
/*    */   
/*    */   private volatile long period;
/*    */ 
/*    */   
/*    */   private long nextRun;
/*    */   
/*    */   private final Runnable task;
/*    */   
/*    */   private final Plugin plugin;
/*    */   
/*    */   private final int id;
/*    */ 
/*    */   
/*    */   CraftTask() {
/* 26 */     this(null, null, -1, -1L);
/*    */   }
/*    */   
/*    */   CraftTask(Runnable task) {
/* 30 */     this(null, task, -1, -1L);
/*    */   }
/*    */   
/*    */   CraftTask(Plugin plugin, Runnable task, int id, long period) {
/* 34 */     this.plugin = plugin;
/* 35 */     this.task = task;
/* 36 */     this.id = id;
/* 37 */     this.period = period;
/*    */   }
/*    */   
/*    */   public final int getTaskId() {
/* 41 */     return this.id;
/*    */   }
/*    */   
/*    */   public final Plugin getOwner() {
/* 45 */     return this.plugin;
/*    */   }
/*    */   
/*    */   public boolean isSync() {
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public void run() {
/* 53 */     this.task.run();
/*    */   }
/*    */   
/*    */   long getPeriod() {
/* 57 */     return this.period;
/*    */   }
/*    */   
/*    */   void setPeriod(long period) {
/* 61 */     this.period = period;
/*    */   }
/*    */   
/*    */   long getNextRun() {
/* 65 */     return this.nextRun;
/*    */   }
/*    */   
/*    */   void setNextRun(long nextRun) {
/* 69 */     this.nextRun = nextRun;
/*    */   }
/*    */   
/*    */   CraftTask getNext() {
/* 73 */     return this.next;
/*    */   }
/*    */   
/*    */   void setNext(CraftTask next) {
/* 77 */     this.next = next;
/*    */   }
/*    */   
/*    */   Class<? extends Runnable> getTaskClass() {
/* 81 */     return (Class)this.task.getClass();
/*    */   }
/*    */   
/*    */   public void cancel() {
/* 85 */     Bukkit.getScheduler().cancelTask(this.id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean cancel0() {
/* 94 */     setPeriod(-2L);
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\scheduler\CraftTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */