package com.avaje.ebean.config;

public interface Encryptor {
  byte[] encrypt(byte[] paramArrayOfbyte, EncryptKey paramEncryptKey);
  
  byte[] decrypt(byte[] paramArrayOfbyte, EncryptKey paramEncryptKey);
  
  byte[] encryptString(String paramString, EncryptKey paramEncryptKey);
  
  String decryptString(byte[] paramArrayOfbyte, EncryptKey paramEncryptKey);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\Encryptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */