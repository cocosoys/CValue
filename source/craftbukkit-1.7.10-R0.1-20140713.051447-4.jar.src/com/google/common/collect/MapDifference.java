package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public interface MapDifference<K, V> {
  boolean areEqual();
  
  Map<K, V> entriesOnlyOnLeft();
  
  Map<K, V> entriesOnlyOnRight();
  
  Map<K, V> entriesInCommon();
  
  Map<K, ValueDifference<V>> entriesDiffering();
  
  boolean equals(@Nullable Object paramObject);
  
  int hashCode();
  
  public static interface ValueDifference<V> {
    V leftValue();
    
    V rightValue();
    
    boolean equals(@Nullable Object param1Object);
    
    int hashCode();
  }
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\collect\MapDifference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */