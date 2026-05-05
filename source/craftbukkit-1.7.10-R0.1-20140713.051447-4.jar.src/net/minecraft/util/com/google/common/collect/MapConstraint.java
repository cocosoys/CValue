package net.minecraft.util.com.google.common.collect;

import javax.annotation.Nullable;
import net.minecraft.util.com.google.common.annotations.Beta;
import net.minecraft.util.com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public interface MapConstraint<K, V> {
  void checkKeyValue(@Nullable K paramK, @Nullable V paramV);
  
  String toString();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\collect\MapConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */