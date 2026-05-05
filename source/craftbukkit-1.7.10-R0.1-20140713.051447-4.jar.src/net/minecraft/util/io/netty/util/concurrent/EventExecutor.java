package net.minecraft.util.io.netty.util.concurrent;

public interface EventExecutor extends EventExecutorGroup {
  EventExecutor next();
  
  EventExecutorGroup parent();
  
  boolean inEventLoop();
  
  boolean inEventLoop(Thread paramThread);
  
  <V> Promise<V> newPromise();
  
  <V> ProgressivePromise<V> newProgressivePromise();
  
  <V> Future<V> newSucceededFuture(V paramV);
  
  <V> Future<V> newFailedFuture(Throwable paramThrowable);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\nett\\util\concurrent\EventExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */