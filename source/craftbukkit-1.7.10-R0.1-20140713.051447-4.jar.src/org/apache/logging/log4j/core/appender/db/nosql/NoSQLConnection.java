package org.apache.logging.log4j.core.appender.db.nosql;

import java.io.Closeable;

public interface NoSQLConnection<W, T extends NoSQLObject<W>> extends Closeable {
  T createObject();
  
  T[] createList(int paramInt);
  
  void insertObject(NoSQLObject<W> paramNoSQLObject);
  
  void close();
  
  boolean isClosed();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\appender\db\nosql\NoSQLConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */