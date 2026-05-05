package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.SortedMap;

@Beta
@GwtCompatible
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
  SortedMap<K, V> entriesOnlyOnLeft();
  
  SortedMap<K, V> entriesOnlyOnRight();
  
  SortedMap<K, V> entriesInCommon();
  
  SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\collect\SortedMapDifference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */