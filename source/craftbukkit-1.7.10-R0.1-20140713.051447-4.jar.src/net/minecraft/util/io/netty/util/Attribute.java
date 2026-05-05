package net.minecraft.util.io.netty.util;

public interface Attribute<T> {
  AttributeKey<T> key();
  
  T get();
  
  void set(T paramT);
  
  T getAndSet(T paramT);
  
  T setIfAbsent(T paramT);
  
  T getAndRemove();
  
  boolean compareAndSet(T paramT1, T paramT2);
  
  void remove();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\nett\\util\Attribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */