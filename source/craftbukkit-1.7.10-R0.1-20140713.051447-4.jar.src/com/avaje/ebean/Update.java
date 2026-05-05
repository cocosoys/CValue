package com.avaje.ebean;

public interface Update<T> {
  String getName();
  
  Update<T> setNotifyCache(boolean paramBoolean);
  
  Update<T> setTimeout(int paramInt);
  
  int execute();
  
  Update<T> set(int paramInt, Object paramObject);
  
  Update<T> setParameter(int paramInt, Object paramObject);
  
  Update<T> setNull(int paramInt1, int paramInt2);
  
  Update<T> setNullParameter(int paramInt1, int paramInt2);
  
  Update<T> set(String paramString, Object paramObject);
  
  Update<T> setParameter(String paramString, Object paramObject);
  
  Update<T> setNull(String paramString, int paramInt);
  
  Update<T> setNullParameter(String paramString, int paramInt);
  
  String getGeneratedSql();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\Update.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */