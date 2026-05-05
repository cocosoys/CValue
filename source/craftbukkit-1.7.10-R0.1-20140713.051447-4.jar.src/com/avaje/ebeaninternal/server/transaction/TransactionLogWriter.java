package com.avaje.ebeaninternal.server.transaction;

public interface TransactionLogWriter {
  void log(TransactionLogBuffer paramTransactionLogBuffer);
  
  void shutdown();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\transaction\TransactionLogWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */