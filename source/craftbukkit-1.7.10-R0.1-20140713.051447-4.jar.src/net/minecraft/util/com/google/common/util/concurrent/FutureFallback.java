package net.minecraft.util.com.google.common.util.concurrent;

import net.minecraft.util.com.google.common.annotations.Beta;

@Beta
public interface FutureFallback<V> {
  ListenableFuture<V> create(Throwable paramThrowable) throws Exception;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\commo\\util\concurrent\FutureFallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */