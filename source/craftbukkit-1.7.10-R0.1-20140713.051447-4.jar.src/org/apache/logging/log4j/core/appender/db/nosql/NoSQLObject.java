package org.apache.logging.log4j.core.appender.db.nosql;

public interface NoSQLObject<W> {
  void set(String paramString, Object paramObject);
  
  void set(String paramString, NoSQLObject<W> paramNoSQLObject);
  
  void set(String paramString, Object[] paramArrayOfObject);
  
  void set(String paramString, NoSQLObject<W>[] paramArrayOfNoSQLObject);
  
  W unwrap();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\appender\db\nosql\NoSQLObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */