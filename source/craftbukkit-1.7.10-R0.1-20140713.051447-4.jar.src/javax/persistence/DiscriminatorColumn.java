package javax.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiscriminatorColumn {
  String name() default "DTYPE";
  
  DiscriminatorType discriminatorType() default DiscriminatorType.STRING;
  
  String columnDefinition() default "";
  
  int length() default 31;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\DiscriminatorColumn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */