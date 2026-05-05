package com.avaje.ebean;

import java.beans.PropertyChangeListener;
import java.util.Set;

public interface BeanState {
  boolean isReference();
  
  boolean isNew();
  
  boolean isNewOrDirty();
  
  boolean isDirty();
  
  Set<String> getLoadedProps();
  
  Set<String> getChangedProps();
  
  boolean isReadOnly();
  
  void setReadOnly(boolean paramBoolean);
  
  boolean isSharedInstance();
  
  void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener);
  
  void setReference();
  
  void setLoaded(Set<String> paramSet);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\BeanState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */