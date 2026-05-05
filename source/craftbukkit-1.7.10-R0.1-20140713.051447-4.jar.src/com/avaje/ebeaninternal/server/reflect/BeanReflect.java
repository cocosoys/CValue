package com.avaje.ebeaninternal.server.reflect;

public interface BeanReflect {
  Object createEntityBean();
  
  Object createVanillaBean();
  
  boolean isVanillaOnly();
  
  BeanReflectGetter getGetter(String paramString);
  
  BeanReflectSetter getSetter(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\reflect\BeanReflect.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */