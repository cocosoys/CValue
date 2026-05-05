package com.avaje.ebeaninternal.server.lucene;

public interface LIndexIoSearcher {
  void postCommit();
  
  void refresh(boolean paramBoolean);
  
  LIndexSearch getIndexSearch();
  
  LIndexVersion getLastestVersion();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexIoSearcher.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */