package javax.persistence.spi;

import java.net.URL;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;

public interface PersistenceUnitInfo {
  String getPersistenceUnitName();
  
  String getPersistenceProviderClassName();
  
  PersistenceUnitTransactionType getTransactionType();
  
  DataSource getJtaDataSource();
  
  DataSource getNonJtaDataSource();
  
  List<String> getMappingFileNames();
  
  List<URL> getJarFileUrls();
  
  URL getPersistenceUnitRootUrl();
  
  List<String> getManagedClassNames();
  
  boolean excludeUnlistedClasses();
  
  Properties getProperties();
  
  ClassLoader getClassLoader();
  
  void addTransformer(ClassTransformer paramClassTransformer);
  
  ClassLoader getNewTempClassLoader();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\javax\persistence\spi\PersistenceUnitInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */