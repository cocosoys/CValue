package javax.persistence;

import java.util.Map;

public interface EntityManagerFactory {
  EntityManager createEntityManager();
  
  EntityManager createEntityManager(Map paramMap);
  
  void close();
  
  boolean isOpen();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\EntityManagerFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */