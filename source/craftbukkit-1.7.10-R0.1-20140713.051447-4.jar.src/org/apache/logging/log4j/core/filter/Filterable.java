package org.apache.logging.log4j.core.filter;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;

public interface Filterable {
  void addFilter(Filter paramFilter);
  
  void removeFilter(Filter paramFilter);
  
  Filter getFilter();
  
  boolean hasFilter();
  
  boolean isFiltered(LogEvent paramLogEvent);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\filter\Filterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */