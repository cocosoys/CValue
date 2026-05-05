package net.minecraft.util.com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.minecraft.util.com.google.common.annotations.Beta;

@Beta
public interface CheckedFuture<V, X extends Exception> extends ListenableFuture<V> {
  V checkedGet() throws X;
  
  V checkedGet(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, X;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\commo\\util\concurrent\CheckedFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */