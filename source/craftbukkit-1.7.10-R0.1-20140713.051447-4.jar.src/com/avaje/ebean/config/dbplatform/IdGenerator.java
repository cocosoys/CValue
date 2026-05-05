package com.avaje.ebean.config.dbplatform;

import com.avaje.ebean.Transaction;

public interface IdGenerator {
  public static final String AUTO_UUID = "auto.uuid";
  
  String getName();
  
  boolean isDbSequence();
  
  Object nextId(Transaction paramTransaction);
  
  void preAllocateIds(int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\IdGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */