package com.avaje.ebean.config.lucene;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface IndexUpdateFuture {
  Class<?> getBeanType();
  
  boolean isCancelled();
  
  boolean cancel(boolean paramBoolean);
  
  Integer get() throws InterruptedException, ExecutionException;
  
  Integer get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException;
  
  boolean isDone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\IndexUpdateFuture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */