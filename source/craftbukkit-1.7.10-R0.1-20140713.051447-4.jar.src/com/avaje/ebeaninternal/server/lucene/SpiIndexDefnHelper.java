package com.avaje.ebeaninternal.server.lucene;

import com.avaje.ebean.config.lucene.IndexDefnBuilder;
import com.avaje.ebean.config.lucene.IndexFieldDefn;
import org.apache.lucene.document.Field;

public interface SpiIndexDefnHelper extends IndexDefnBuilder {
  IndexFieldDefn addPrefixField(String paramString1, String paramString2, Field.Store paramStore, Field.Index paramIndex, IndexFieldDefn.Sortable paramSortable);
  
  IndexFieldDefn addPrefixFieldConcat(String paramString1, String paramString2, Field.Store paramStore, Field.Index paramIndex, String[] paramArrayOfString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\SpiIndexDefnHelper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */