package com.avaje.ebean.config.lucene;

import java.util.List;
import org.apache.lucene.document.Field;

public interface IndexDefnBuilder {
  void addAllFields();
  
  IndexDefnBuilder assocOne(String paramString);
  
  IndexFieldDefn addField(IndexFieldDefn paramIndexFieldDefn);
  
  IndexFieldDefn addField(String paramString);
  
  IndexFieldDefn addField(String paramString, IndexFieldDefn.Sortable paramSortable);
  
  IndexFieldDefn addField(String paramString, Field.Store paramStore, Field.Index paramIndex, IndexFieldDefn.Sortable paramSortable);
  
  IndexFieldDefn addFieldConcat(String paramString, String... paramVarArgs);
  
  IndexFieldDefn addFieldConcat(String paramString, Field.Store paramStore, Field.Index paramIndex, String... paramVarArgs);
  
  IndexFieldDefn getField(String paramString);
  
  List<IndexFieldDefn> getFields();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\IndexDefnBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */