package com.avaje.ebeaninternal.server.type;

import com.avaje.ebeaninternal.server.type.reflect.CheckImmutableResponse;

public interface TypeManager {
  CheckImmutableResponse checkImmutable(Class<?> paramClass);
  
  ScalarDataReader<?> recursiveCreateScalarDataReader(Class<?> paramClass);
  
  ScalarType<?> recursiveCreateScalarTypes(Class<?> paramClass);
  
  void add(ScalarType<?> paramScalarType);
  
  CtCompoundType<?> getCompoundType(Class<?> paramClass);
  
  ScalarType<?> getScalarType(int paramInt);
  
  <T> ScalarType<T> getScalarType(Class<T> paramClass);
  
  <T> ScalarType<T> getScalarType(Class<T> paramClass, int paramInt);
  
  ScalarType<?> createEnumScalarType(Class<?> paramClass);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\TypeManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */