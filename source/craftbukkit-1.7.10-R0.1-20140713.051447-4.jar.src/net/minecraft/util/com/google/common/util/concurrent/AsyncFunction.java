package net.minecraft.util.com.google.common.util.concurrent;

public interface AsyncFunction<I, O> {
  ListenableFuture<O> apply(I paramI) throws Exception;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\commo\\util\concurrent\AsyncFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */