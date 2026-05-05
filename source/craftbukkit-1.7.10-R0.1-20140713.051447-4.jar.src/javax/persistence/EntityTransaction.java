package javax.persistence;

public interface EntityTransaction {
  void begin();
  
  void commit();
  
  void rollback();
  
  void setRollbackOnly();
  
  boolean getRollbackOnly();
  
  boolean isActive();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\EntityTransaction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */