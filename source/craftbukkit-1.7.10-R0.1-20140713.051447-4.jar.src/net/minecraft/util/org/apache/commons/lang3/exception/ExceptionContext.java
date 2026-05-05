package net.minecraft.util.org.apache.commons.lang3.exception;

import java.util.List;
import java.util.Set;
import net.minecraft.util.org.apache.commons.lang3.tuple.Pair;

public interface ExceptionContext {
  ExceptionContext addContextValue(String paramString, Object paramObject);
  
  ExceptionContext setContextValue(String paramString, Object paramObject);
  
  List<Object> getContextValues(String paramString);
  
  Object getFirstContextValue(String paramString);
  
  Set<String> getContextLabels();
  
  List<Pair<String, Object>> getContextEntries();
  
  String getFormattedExceptionMessage(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\lang3\exception\ExceptionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */