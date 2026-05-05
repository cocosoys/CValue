package com.avaje.ebeaninternal.server.lucene;

import com.avaje.ebeaninternal.server.el.ElPropertyValue;
import java.util.Set;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;

public interface LIndexField {
  String getName();
  
  DocFieldWriter createDocFieldWriter();
  
  void addIndexResolvePropertyNames(Set<String> paramSet);
  
  void addIndexRestorePropertyNames(Set<String> paramSet);
  
  void addIndexRequiredPropertyNames(Set<String> paramSet);
  
  String getSortableProperty();
  
  int getSortType();
  
  boolean isIndexed();
  
  boolean isStored();
  
  boolean isBeanProperty();
  
  ElPropertyValue getElBeanProperty();
  
  void readValue(Document paramDocument, Object paramObject);
  
  QueryParser createQueryParser();
  
  int getPropertyOrder();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexField.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */