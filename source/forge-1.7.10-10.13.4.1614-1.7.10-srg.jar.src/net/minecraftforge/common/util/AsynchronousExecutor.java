/*     */ package net.minecraftforge.common.util;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AsynchronousExecutor<P, T, C, E extends Throwable>
/*     */ {
/*  61 */   static final AtomicIntegerFieldUpdater STATE_FIELD = AtomicIntegerFieldUpdater.newUpdater(Task.class, "state");
/*     */   final CallBackProvider<P, T, C, E> provider;
/*     */   
/*     */   private static boolean set(Task $this, int expected, int value) {
/*  65 */     return STATE_FIELD.compareAndSet($this, expected, value);
/*     */   }
/*     */   
/*     */   class Task
/*     */     implements Runnable {
/*     */     static final int PENDING = 0;
/*     */     static final int STAGE_1_ASYNC = 1;
/*     */     static final int STAGE_1_SYNC = 2;
/*     */     static final int STAGE_1_COMPLETE = 3;
/*     */     static final int FINISHED = 4;
/*  75 */     volatile int state = 0;
/*     */     final P parameter;
/*     */     T object;
/*  78 */     final List<C> callbacks = new LinkedList<C>();
/*  79 */     E t = null;
/*     */     
/*     */     Task(P parameter) {
/*  82 */       this.parameter = parameter;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: invokevirtual initAsync : ()Z
/*     */       //   4: ifeq -> 21
/*     */       //   7: aload_0
/*     */       //   8: getfield this$0 : Lnet/minecraftforge/common/util/AsynchronousExecutor;
/*     */       //   11: getfield finished : Ljava/util/Queue;
/*     */       //   14: aload_0
/*     */       //   15: invokeinterface add : (Ljava/lang/Object;)Z
/*     */       //   20: pop
/*     */       //   21: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #86	-> 0
/*     */       //   #87	-> 7
/*     */       //   #89	-> 21
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	22	0	this	Lnet/minecraftforge/common/util/AsynchronousExecutor$Task;
/*     */       // Local variable type table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	22	0	this	Lnet/minecraftforge/common/util/AsynchronousExecutor<TP;TT;TC;TE;>.Task;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean initAsync() {
/*  92 */       if (AsynchronousExecutor.set(this, 0, 1)) {
/*  93 */         boolean ret = true;
/*     */         
/*     */         try {
/*  96 */           init();
/*     */         } finally {
/*  98 */           if (!AsynchronousExecutor.set(this, 1, 3)) {
/*     */ 
/*     */ 
/*     */             
/* 102 */             synchronized (this) {
/* 103 */               if (this.state != 2)
/*     */               {
/* 105 */                 notifyAll();
/*     */               }
/*     */ 
/*     */               
/* 109 */               this.state = 3;
/*     */             } 
/*     */             
/* 112 */             ret = false;
/*     */           } 
/*     */         } 
/*     */         
/* 116 */         return ret;
/*     */       } 
/* 118 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void initSync() {
/* 123 */       if (AsynchronousExecutor.set(this, 0, 3)) {
/*     */         
/* 125 */         init();
/* 126 */       } else if (AsynchronousExecutor.set(this, 1, 2)) {
/*     */         
/* 128 */         synchronized (this) {
/* 129 */           if (AsynchronousExecutor.set(this, 2, 0))
/*     */           {
/* 131 */             while (this.state != 3) {
/*     */               try {
/* 133 */                 wait();
/* 134 */               } catch (InterruptedException e) {
/* 135 */                 Thread.currentThread().interrupt();
/* 136 */                 throw new RuntimeException("Unable to handle interruption on " + this.parameter, e);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void init() {
/*     */       try {
/* 151 */         this.object = (T)AsynchronousExecutor.this.provider.callStage1(this.parameter);
/* 152 */       } catch (Throwable t) {
/* 153 */         this.t = (E)t;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     T get() throws E {
/* 159 */       initSync();
/* 160 */       if (this.callbacks.isEmpty())
/*     */       {
/*     */         
/* 163 */         this.callbacks.add((C)this);
/*     */       }
/* 165 */       finish();
/* 166 */       return this.object;
/*     */     }
/*     */     
/*     */     void finish() throws E {
/* 170 */       switch (this.state) {
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 175 */           throw (E)new IllegalStateException("Attempting to finish unprepared(" + this.state + ") task(" + this.parameter + ")");
/*     */         case 3:
/*     */           try {
/* 178 */             if (this.t != null) {
/* 179 */               throw this.t;
/*     */             }
/* 181 */             if (this.callbacks.isEmpty()) {
/*     */               return;
/*     */             }
/*     */             
/* 185 */             AsynchronousExecutor.CallBackProvider<P, T, C, E> provider = AsynchronousExecutor.this.provider;
/* 186 */             P parameter = this.parameter;
/* 187 */             T object = this.object;
/*     */             
/* 189 */             provider.callStage2(parameter, object);
/* 190 */             for (C callback : this.callbacks) {
/* 191 */               if (callback == this) {
/*     */                 continue;
/*     */               }
/*     */ 
/*     */               
/* 196 */               provider.callStage3(parameter, object, callback);
/*     */             } 
/*     */           } finally {
/* 199 */             AsynchronousExecutor.this.tasks.remove(this.parameter);
/* 200 */             this.state = 4;
/*     */           } 
/*     */           break;
/*     */         case 4:
/*     */           break;
/*     */       } 
/*     */     } boolean drop() {
/* 207 */       if (AsynchronousExecutor.set(this, 0, 4)) {
/*     */         
/* 209 */         AsynchronousExecutor.this.tasks.remove(this.parameter);
/* 210 */         return true;
/*     */       } 
/*     */       
/* 213 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 219 */   final Queue<Task> finished = new ConcurrentLinkedQueue<Task>();
/* 220 */   final Map<P, Task> tasks = new HashMap<P, Task>();
/*     */ 
/*     */   
/*     */   final ThreadPoolExecutor pool;
/*     */ 
/*     */ 
/*     */   
/*     */   public AsynchronousExecutor(CallBackProvider<P, T, C, E> provider, int coreSize) {
/* 228 */     if (provider == null) {
/* 229 */       throw new IllegalArgumentException("Provider cannot be null");
/*     */     }
/* 231 */     this.provider = provider;
/*     */ 
/*     */     
/* 234 */     this.pool = new ThreadPoolExecutor(coreSize, 2147483647, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), provider);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(P parameter, C callback) {
/* 243 */     Task task = this.tasks.get(parameter);
/* 244 */     if (task == null) {
/* 245 */       this.tasks.put(parameter, task = new Task(parameter));
/* 246 */       this.pool.execute(task);
/*     */     } 
/* 248 */     task.callbacks.add(callback);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean drop(P parameter, C callback) throws IllegalStateException {
/* 267 */     Task task = this.tasks.get(parameter);
/* 268 */     if (task == null) {
/*     */ 
/*     */       
/* 271 */       FMLLog.info("Unknown %s", new Object[] { parameter });
/* 272 */       FMLLog.info("This should not happen. Please report this error to Forge.", new Object[0]);
/* 273 */       return false;
/*     */     } 
/* 275 */     if (!task.callbacks.remove(callback)) {
/* 276 */       throw new IllegalStateException("Unknown " + callback + " for " + parameter);
/*     */     }
/* 278 */     if (task.callbacks.isEmpty()) {
/* 279 */       return task.drop();
/*     */     }
/* 281 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(P parameter) throws E, IllegalStateException {
/* 291 */     Task task = this.tasks.get(parameter);
/* 292 */     if (task == null) {
/* 293 */       throw new IllegalStateException("Unknown " + parameter);
/*     */     }
/* 295 */     return task.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSkipQueue(P parameter) throws E {
/* 302 */     return skipQueue(parameter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSkipQueue(P parameter, C callback) throws E {
/* 309 */     T object = skipQueue(parameter);
/* 310 */     this.provider.callStage3(parameter, object, callback);
/* 311 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSkipQueue(P parameter, C... callbacks) throws E {
/* 318 */     CallBackProvider<P, T, C, E> provider = this.provider;
/* 319 */     T object = skipQueue(parameter);
/* 320 */     for (C callback : callbacks) {
/* 321 */       provider.callStage3(parameter, object, callback);
/*     */     }
/* 323 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T getSkipQueue(P parameter, Iterable<C> callbacks) throws E {
/* 330 */     CallBackProvider<P, T, C, E> provider = this.provider;
/* 331 */     T object = skipQueue(parameter);
/* 332 */     for (C callback : callbacks) {
/* 333 */       provider.callStage3(parameter, object, callback);
/*     */     }
/* 335 */     return object;
/*     */   }
/*     */   
/*     */   private T skipQueue(P parameter) throws E {
/* 339 */     Task task = this.tasks.get(parameter);
/* 340 */     if (task != null) {
/* 341 */       return task.get();
/*     */     }
/* 343 */     T object = this.provider.callStage1(parameter);
/* 344 */     this.provider.callStage2(parameter, object);
/* 345 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishActive() throws E {
/* 352 */     Queue<Task> finished = this.finished;
/* 353 */     while (!finished.isEmpty()) {
/* 354 */       ((Task)finished.poll()).finish();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setActiveThreads(int coreSize) {
/* 359 */     this.pool.setCorePoolSize(coreSize);
/*     */   }
/*     */   
/*     */   public static interface CallBackProvider<P, T, C, E extends Throwable> extends ThreadFactory {
/*     */     T callStage1(P param1P) throws E;
/*     */     
/*     */     void callStage2(P param1P, T param1T) throws E;
/*     */     
/*     */     void callStage3(P param1P, T param1T, C param1C) throws E;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\AsynchronousExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */