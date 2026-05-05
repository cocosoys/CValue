package net.minecraft.util.io.netty.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface Future<V> extends Future<V> {
  boolean isSuccess();
  
  boolean isCancellable();
  
  Throwable cause();
  
  Future<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  Future<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  Future<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  Future<V> sync() throws InterruptedException;
  
  Future<V> syncUninterruptibly();
  
  Future<V> await() throws InterruptedException;
  
  Future<V> awaitUninterruptibly();
  
  boolean await(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException;
  
  boolean await(long paramLong) throws InterruptedException;
  
  boolean awaitUninterruptibly(long paramLong, TimeUnit paramTimeUnit);
  
  boolean awaitUninterruptibly(long paramLong);
  
  V getNow();
  
  boolean cancel(boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\nett\\util\concurrent\Future.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */