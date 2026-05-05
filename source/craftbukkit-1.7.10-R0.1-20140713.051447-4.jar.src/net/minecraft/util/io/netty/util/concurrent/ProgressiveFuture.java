package net.minecraft.util.io.netty.util.concurrent;

public interface ProgressiveFuture<V> extends Future<V> {
  ProgressiveFuture<V> addListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  ProgressiveFuture<V> addListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  ProgressiveFuture<V> removeListener(GenericFutureListener<? extends Future<? super V>> paramGenericFutureListener);
  
  ProgressiveFuture<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... paramVarArgs);
  
  ProgressiveFuture<V> sync() throws InterruptedException;
  
  ProgressiveFuture<V> syncUninterruptibly();
  
  ProgressiveFuture<V> await() throws InterruptedException;
  
  ProgressiveFuture<V> awaitUninterruptibly();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\nett\\util\concurrent\ProgressiveFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */