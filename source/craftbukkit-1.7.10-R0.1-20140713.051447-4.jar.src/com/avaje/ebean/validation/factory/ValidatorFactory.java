package com.avaje.ebean.validation.factory;

import java.lang.annotation.Annotation;

public interface ValidatorFactory {
  Validator create(Annotation paramAnnotation, Class<?> paramClass);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\validation\factory\ValidatorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */