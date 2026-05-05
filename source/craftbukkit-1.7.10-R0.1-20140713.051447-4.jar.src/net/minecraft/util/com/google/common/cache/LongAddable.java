package net.minecraft.util.com.google.common.cache;

import net.minecraft.util.com.google.common.annotations.GwtCompatible;

@GwtCompatible
interface LongAddable {
  void increment();
  
  void add(long paramLong);
  
  long sum();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\cache\LongAddable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */