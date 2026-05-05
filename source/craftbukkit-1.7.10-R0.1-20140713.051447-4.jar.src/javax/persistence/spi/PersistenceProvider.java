package javax.persistence.spi;

import java.util.Map;
import javax.persistence.EntityManagerFactory;

public interface PersistenceProvider {
  EntityManagerFactory createEntityManagerFactory(String paramString, Map paramMap);
  
  EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo paramPersistenceUnitInfo, Map paramMap);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\spi\PersistenceProvider.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */