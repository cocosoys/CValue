package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public interface Predicate<T> {
  boolean apply(@Nullable T paramT);
  
  boolean equals(@Nullable Object paramObject);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\base\Predicate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */