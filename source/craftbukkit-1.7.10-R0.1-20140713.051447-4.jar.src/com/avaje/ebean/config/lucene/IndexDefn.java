package com.avaje.ebean.config.lucene;

import java.util.List;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriter;

public interface IndexDefn<T> {
  void initialise(IndexDefnBuilder paramIndexDefnBuilder);
  
  String getDefaultField();
  
  List<IndexFieldDefn> getFields();
  
  boolean isUpdateSinceSupported();
  
  String[] getUpdateSinceProperties();
  
  Analyzer getAnalyzer();
  
  IndexWriter.MaxFieldLength getMaxFieldLength();
  
  int getMaxBufferedDocs();
  
  double getRAMBufferSizeMB();
  
  int getTermIndexInterval();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\IndexDefn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */