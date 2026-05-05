package com.avaje.ebean.annotation;

import com.avaje.ebean.Query;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheStrategy {
  boolean useBeanCache() default true;
  
  boolean readOnly() default false;
  
  String warmingQuery() default "";
  
  Query.UseIndex useIndex() default Query.UseIndex.DEFAULT;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\annotation\CacheStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */