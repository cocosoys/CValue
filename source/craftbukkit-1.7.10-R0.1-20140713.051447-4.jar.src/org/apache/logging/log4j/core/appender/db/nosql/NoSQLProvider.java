package org.apache.logging.log4j.core.appender.db.nosql;

public interface NoSQLProvider<C extends NoSQLConnection<?, ? extends NoSQLObject<?>>> {
  C getConnection();
  
  String toString();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\appender\db\nosql\NoSQLProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */