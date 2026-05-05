package net.minecraft.util.com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.util.com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
  V put(@Nullable K paramK, @Nullable V paramV);
  
  V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  void putAll(Map<? extends K, ? extends V> paramMap);
  
  Set<V> values();
  
  BiMap<V, K> inverse();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\collect\BiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */