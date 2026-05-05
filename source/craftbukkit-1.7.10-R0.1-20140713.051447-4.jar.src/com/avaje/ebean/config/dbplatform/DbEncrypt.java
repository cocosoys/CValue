package com.avaje.ebean.config.dbplatform;

public interface DbEncrypt {
  DbEncryptFunction getDbEncryptFunction(int paramInt);
  
  int getEncryptDbType();
  
  boolean isBindEncryptDataFirst();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\DbEncrypt.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */