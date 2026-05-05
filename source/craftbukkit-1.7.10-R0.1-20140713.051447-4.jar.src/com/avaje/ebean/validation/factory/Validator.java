package com.avaje.ebean.validation.factory;

public interface Validator {
  String getKey();
  
  Object[] getAttributes();
  
  boolean isValid(Object paramObject);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\validation\factory\Validator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */