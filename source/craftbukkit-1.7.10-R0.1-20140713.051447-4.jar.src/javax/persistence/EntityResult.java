package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityResult {
  Class entityClass();
  
  FieldResult[] fields() default {};
  
  String discriminatorColumn() default "";
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\EntityResult.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */