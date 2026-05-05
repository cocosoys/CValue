package net.minecraft.util.org.apache.commons.io.filefilter;

import java.util.List;

public interface ConditionalFileFilter {
  void addFileFilter(IOFileFilter paramIOFileFilter);
  
  List<IOFileFilter> getFileFilters();
  
  boolean removeFileFilter(IOFileFilter paramIOFileFilter);
  
  void setFileFilters(List<IOFileFilter> paramList);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\io\filefilter\ConditionalFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */