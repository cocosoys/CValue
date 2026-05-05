package com.avaje.ebeaninternal.server.persist.dmlbind;

import com.avaje.ebeaninternal.server.core.PersistRequestBean;

public interface BindableId extends Bindable {
  boolean isConcatenated();
  
  String getIdentityColumn();
  
  boolean deriveConcatenatedId(PersistRequestBean<?> paramPersistRequestBean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\persist\dmlbind\BindableId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */