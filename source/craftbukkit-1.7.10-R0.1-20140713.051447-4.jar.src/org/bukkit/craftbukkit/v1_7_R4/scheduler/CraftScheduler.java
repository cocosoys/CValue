/*     */ package org.bukkit.craftbukkit.v1_7_R4.scheduler;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.PriorityQueue;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import java.util.logging.Level;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.plugin.IllegalPluginAccessException;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.scheduler.BukkitTask;
/*     */ import org.bukkit.scheduler.BukkitWorker;
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
/*     */ public class CraftScheduler
/*     */   implements BukkitScheduler
/*     */ {
/*  47 */   private final AtomicInteger ids = new AtomicInteger(1);
/*     */ 
/*     */ 
/*     */   
/*  51 */   private volatile CraftTask head = new CraftTask();
/*     */ 
/*     */ 
/*     */   
/*  55 */   private final AtomicReference<CraftTask> tail = new AtomicReference<CraftTask>(this.head);
/*     */ 
/*     */ 
/*     */   
/*  59 */   private final PriorityQueue<CraftTask> pending = new PriorityQueue<CraftTask>(10, new Comparator<CraftTask>()
/*     */       {
/*     */         public int compare(CraftTask o1, CraftTask o2) {
/*  62 */           return (int)(o1.getNextRun() - o2.getNextRun());
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */   
/*  68 */   private final List<CraftTask> temp = new ArrayList<CraftTask>();
/*     */ 
/*     */ 
/*     */   
/*  72 */   private final ConcurrentHashMap<Integer, CraftTask> runners = new ConcurrentHashMap<Integer, CraftTask>();
/*  73 */   private volatile int currentTick = -1;
/*  74 */   private final Executor executor = Executors.newCachedThreadPool();
/*  75 */   private CraftAsyncDebugger debugHead = new CraftAsyncDebugger(-1, null, null) { StringBuilder debugTo(StringBuilder string) { return string; } }
/*  76 */   ; private CraftAsyncDebugger debugTail = this.debugHead;
/*     */ 
/*     */ 
/*     */   
/*  80 */   private static final int RECENT_TICKS = 30;
/*     */ 
/*     */   
/*     */   public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
/*  84 */     return scheduleSyncDelayedTask(plugin, task, 0L);
/*     */   }
/*     */   
/*     */   public BukkitTask runTask(Plugin plugin, Runnable runnable) {
/*  88 */     return runTaskLater(plugin, runnable, 0L);
/*     */   }
/*     */   
/*     */   public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
/*  92 */     return scheduleAsyncDelayedTask(plugin, task, 0L);
/*     */   }
/*     */   
/*     */   public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable runnable) {
/*  96 */     return runTaskLaterAsynchronously(plugin, runnable, 0L);
/*     */   }
/*     */   
/*     */   public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
/* 100 */     return scheduleSyncRepeatingTask(plugin, task, delay, -1L);
/*     */   }
/*     */   
/*     */   public BukkitTask runTaskLater(Plugin plugin, Runnable runnable, long delay) {
/* 104 */     return runTaskTimer(plugin, runnable, delay, -1L);
/*     */   }
/*     */   
/*     */   public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
/* 108 */     return scheduleAsyncRepeatingTask(plugin, task, delay, -1L);
/*     */   }
/*     */   
/*     */   public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long delay) {
/* 112 */     return runTaskTimerAsynchronously(plugin, runnable, delay, -1L);
/*     */   }
/*     */   
/*     */   public int scheduleSyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long period) {
/* 116 */     return runTaskTimer(plugin, runnable, delay, period).getTaskId();
/*     */   }
/*     */   
/*     */   public BukkitTask runTaskTimer(Plugin plugin, Runnable runnable, long delay, long period) {
/* 120 */     validate(plugin, runnable);
/* 121 */     if (delay < 0L) {
/* 122 */       delay = 0L;
/*     */     }
/* 124 */     if (period == 0L) {
/* 125 */       period = 1L;
/* 126 */     } else if (period < -1L) {
/* 127 */       period = -1L;
/*     */     } 
/* 129 */     return handle(new CraftTask(plugin, runnable, nextId(), period), delay);
/*     */   }
/*     */   
/*     */   public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable runnable, long delay, long period) {
/* 133 */     return runTaskTimerAsynchronously(plugin, runnable, delay, period).getTaskId();
/*     */   }
/*     */   
/*     */   public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long delay, long period) {
/* 137 */     validate(plugin, runnable);
/* 138 */     if (delay < 0L) {
/* 139 */       delay = 0L;
/*     */     }
/* 141 */     if (period == 0L) {
/* 142 */       period = 1L;
/* 143 */     } else if (period < -1L) {
/* 144 */       period = -1L;
/*     */     } 
/* 146 */     return handle(new CraftAsyncTask(this.runners, plugin, runnable, nextId(), period), delay);
/*     */   }
/*     */   
/*     */   public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
/* 150 */     validate(plugin, task);
/* 151 */     CraftFuture<T> future = new CraftFuture<T>(task, plugin, nextId());
/* 152 */     handle(future, 0L);
/* 153 */     return future;
/*     */   }
/*     */   
/*     */   public void cancelTask(final int taskId) {
/* 157 */     if (taskId <= 0) {
/*     */       return;
/*     */     }
/* 160 */     CraftTask task = this.runners.get(Integer.valueOf(taskId));
/* 161 */     if (task != null) {
/* 162 */       task.cancel0();
/*     */     }
/* 164 */     task = new CraftTask(new Runnable()
/*     */         {
/*     */           public void run() {
/* 167 */             if (!check(CraftScheduler.this.temp))
/* 168 */               check(CraftScheduler.this.pending); 
/*     */           }
/*     */           
/*     */           private boolean check(Iterable<CraftTask> collection) {
/* 172 */             Iterator<CraftTask> tasks = collection.iterator();
/* 173 */             while (tasks.hasNext()) {
/* 174 */               CraftTask task = tasks.next();
/* 175 */               if (task.getTaskId() == taskId) {
/* 176 */                 task.cancel0();
/* 177 */                 tasks.remove();
/* 178 */                 if (task.isSync()) {
/* 179 */                   CraftScheduler.this.runners.remove(Integer.valueOf(taskId));
/*     */                 }
/* 181 */                 return true;
/*     */               } 
/*     */             } 
/* 184 */             return false; }
/*     */         });
/* 186 */     handle(task, 0L);
/* 187 */     for (CraftTask taskPending = this.head.getNext(); taskPending != null; taskPending = taskPending.getNext()) {
/* 188 */       if (taskPending == task) {
/*     */         return;
/*     */       }
/* 191 */       if (taskPending.getTaskId() == taskId) {
/* 192 */         taskPending.cancel0();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelTasks(final Plugin plugin) {
/* 198 */     Validate.notNull(plugin, "Cannot cancel tasks of null plugin");
/* 199 */     CraftTask task = new CraftTask(new Runnable()
/*     */         {
/*     */           public void run() {
/* 202 */             check(CraftScheduler.this.pending);
/* 203 */             check(CraftScheduler.this.temp);
/*     */           }
/*     */           void check(Iterable<CraftTask> collection) {
/* 206 */             Iterator<CraftTask> tasks = collection.iterator();
/* 207 */             while (tasks.hasNext()) {
/* 208 */               CraftTask task = tasks.next();
/* 209 */               if (task.getOwner().equals(plugin)) {
/* 210 */                 task.cancel0();
/* 211 */                 tasks.remove();
/* 212 */                 if (task.isSync()) {
/* 213 */                   CraftScheduler.this.runners.remove(Integer.valueOf(task.getTaskId()));
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/* 219 */     handle(task, 0L);
/* 220 */     for (CraftTask taskPending = this.head.getNext(); taskPending != null; taskPending = taskPending.getNext()) {
/* 221 */       if (taskPending == task) {
/*     */         return;
/*     */       }
/* 224 */       if (taskPending.getTaskId() != -1 && taskPending.getOwner().equals(plugin)) {
/* 225 */         taskPending.cancel0();
/*     */       }
/*     */     } 
/* 228 */     for (CraftTask runner : this.runners.values()) {
/* 229 */       if (runner.getOwner().equals(plugin)) {
/* 230 */         runner.cancel0();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelAllTasks() {
/* 236 */     CraftTask task = new CraftTask(new Runnable()
/*     */         {
/*     */           public void run() {
/* 239 */             Iterator<CraftTask> it = CraftScheduler.this.runners.values().iterator();
/* 240 */             while (it.hasNext()) {
/* 241 */               CraftTask task = it.next();
/* 242 */               task.cancel0();
/* 243 */               if (task.isSync()) {
/* 244 */                 it.remove();
/*     */               }
/*     */             } 
/* 247 */             CraftScheduler.this.pending.clear();
/* 248 */             CraftScheduler.this.temp.clear();
/*     */           }
/*     */         });
/* 251 */     handle(task, 0L);
/* 252 */     for (CraftTask taskPending = this.head.getNext(); taskPending != null && 
/* 253 */       taskPending != task; taskPending = taskPending.getNext())
/*     */     {
/*     */       
/* 256 */       taskPending.cancel0();
/*     */     }
/* 258 */     for (CraftTask runner : this.runners.values()) {
/* 259 */       runner.cancel0();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isCurrentlyRunning(int taskId) {
/* 264 */     CraftTask task = this.runners.get(Integer.valueOf(taskId));
/* 265 */     if (task == null || task.isSync()) {
/* 266 */       return false;
/*     */     }
/* 268 */     CraftAsyncTask asyncTask = (CraftAsyncTask)task;
/* 269 */     synchronized (asyncTask.getWorkers()) {
/* 270 */       return asyncTask.getWorkers().isEmpty();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isQueued(int taskId) {
/* 275 */     if (taskId <= 0)
/* 276 */       return false; 
/*     */     CraftTask task;
/* 278 */     for (task = this.head.getNext(); task != null; task = task.getNext()) {
/* 279 */       if (task.getTaskId() == taskId) {
/* 280 */         return (task.getPeriod() >= -1L);
/*     */       }
/*     */     } 
/* 283 */     task = this.runners.get(Integer.valueOf(taskId));
/* 284 */     return (task != null && task.getPeriod() >= -1L);
/*     */   }
/*     */   
/*     */   public List<BukkitWorker> getActiveWorkers() {
/* 288 */     ArrayList<BukkitWorker> workers = new ArrayList<BukkitWorker>();
/* 289 */     for (CraftTask taskObj : this.runners.values()) {
/*     */       
/* 291 */       if (taskObj.isSync()) {
/*     */         continue;
/*     */       }
/* 294 */       CraftAsyncTask task = (CraftAsyncTask)taskObj;
/* 295 */       synchronized (task.getWorkers()) {
/*     */         
/* 297 */         workers.addAll(task.getWorkers());
/*     */       } 
/*     */     } 
/* 300 */     return workers;
/*     */   }
/*     */   
/*     */   public List<BukkitTask> getPendingTasks() {
/* 304 */     ArrayList<CraftTask> truePending = new ArrayList<CraftTask>();
/* 305 */     for (CraftTask task = this.head.getNext(); task != null; task = task.getNext()) {
/* 306 */       if (task.getTaskId() != -1)
/*     */       {
/* 308 */         truePending.add(task);
/*     */       }
/*     */     } 
/*     */     
/* 312 */     ArrayList<BukkitTask> pending = new ArrayList<BukkitTask>();
/* 313 */     for (CraftTask craftTask : this.runners.values()) {
/* 314 */       if (craftTask.getPeriod() >= -1L) {
/* 315 */         pending.add(craftTask);
/*     */       }
/*     */     } 
/*     */     
/* 319 */     for (CraftTask craftTask : truePending) {
/* 320 */       if (craftTask.getPeriod() >= -1L && !pending.contains(craftTask)) {
/* 321 */         pending.add(craftTask);
/*     */       }
/*     */     } 
/* 324 */     return pending;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mainThreadHeartbeat(int currentTick) {
/* 331 */     this.currentTick = currentTick;
/* 332 */     List<CraftTask> temp = this.temp;
/* 333 */     parsePending();
/* 334 */     while (isReady(currentTick)) {
/* 335 */       CraftTask task = this.pending.remove();
/* 336 */       if (task.getPeriod() < -1L) {
/* 337 */         if (task.isSync()) {
/* 338 */           this.runners.remove(Integer.valueOf(task.getTaskId()), task);
/*     */         }
/* 340 */         parsePending();
/*     */         continue;
/*     */       } 
/* 343 */       if (task.isSync()) {
/*     */         try {
/* 345 */           task.run();
/* 346 */         } catch (Throwable throwable) {
/* 347 */           task.getOwner().getLogger().log(Level.WARNING, String.format("Task #%s for %s generated an exception", new Object[] { Integer.valueOf(task.getTaskId()), task.getOwner().getDescription().getFullName() }), throwable);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 355 */         parsePending();
/*     */       } else {
/* 357 */         this.debugTail = this.debugTail.setNext(new CraftAsyncDebugger(currentTick + RECENT_TICKS, task.getOwner(), task.getTaskClass()));
/* 358 */         this.executor.execute(task);
/*     */       } 
/*     */ 
/*     */       
/* 362 */       long period = task.getPeriod();
/* 363 */       if (period > 0L) {
/* 364 */         task.setNextRun(currentTick + period);
/* 365 */         temp.add(task); continue;
/* 366 */       }  if (task.isSync()) {
/* 367 */         this.runners.remove(Integer.valueOf(task.getTaskId()));
/*     */       }
/*     */     } 
/* 370 */     this.pending.addAll(temp);
/* 371 */     temp.clear();
/* 372 */     this.debugHead = this.debugHead.getNextHead(currentTick);
/*     */   }
/*     */   
/*     */   private void addTask(CraftTask task) {
/* 376 */     AtomicReference<CraftTask> tail = this.tail;
/* 377 */     CraftTask tailTask = tail.get();
/* 378 */     while (!tail.compareAndSet(tailTask, task)) {
/* 379 */       tailTask = tail.get();
/*     */     }
/* 381 */     tailTask.setNext(task);
/*     */   }
/*     */   
/*     */   private CraftTask handle(CraftTask task, long delay) {
/* 385 */     task.setNextRun(this.currentTick + delay);
/* 386 */     addTask(task);
/* 387 */     return task;
/*     */   }
/*     */   
/*     */   private static void validate(Plugin plugin, Object task) {
/* 391 */     Validate.notNull(plugin, "Plugin cannot be null");
/* 392 */     Validate.notNull(task, "Task cannot be null");
/* 393 */     if (!plugin.isEnabled()) {
/* 394 */       throw new IllegalPluginAccessException("Plugin attempted to register task while disabled");
/*     */     }
/*     */   }
/*     */   
/*     */   private int nextId() {
/* 399 */     return this.ids.incrementAndGet();
/*     */   }
/*     */   
/*     */   private void parsePending() {
/* 403 */     CraftTask head = this.head;
/* 404 */     CraftTask task = head.getNext();
/* 405 */     CraftTask lastTask = head;
/* 406 */     for (; task != null; task = (lastTask = task).getNext()) {
/* 407 */       if (task.getTaskId() == -1) {
/* 408 */         task.run();
/* 409 */       } else if (task.getPeriod() >= -1L) {
/* 410 */         this.pending.add(task);
/* 411 */         this.runners.put(Integer.valueOf(task.getTaskId()), task);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 416 */     for (task = head; task != lastTask; task = head) {
/* 417 */       head = task.getNext();
/* 418 */       task.setNext(null);
/*     */     } 
/* 420 */     this.head = lastTask;
/*     */   }
/*     */   
/*     */   private boolean isReady(int currentTick) {
/* 424 */     return (!this.pending.isEmpty() && ((CraftTask)this.pending.peek()).getNextRun() <= currentTick);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 429 */     int debugTick = this.currentTick;
/* 430 */     StringBuilder string = (new StringBuilder("Recent tasks from ")).append(debugTick - RECENT_TICKS).append('-').append(debugTick).append('{');
/* 431 */     this.debugHead.debugTo(string);
/* 432 */     return string.append('}').toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\scheduler\CraftScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */