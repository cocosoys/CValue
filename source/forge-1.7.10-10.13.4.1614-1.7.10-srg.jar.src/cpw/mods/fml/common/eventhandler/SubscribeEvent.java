package cpw.mods.fml.common.eventhandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SubscribeEvent {
  EventPriority priority() default EventPriority.NORMAL;
  
  boolean receiveCanceled() default false;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\SubscribeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */