package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public interface Nestable {
  Throwable getCause();
  
  String getMessage();
  
  String getMessage(int paramInt);
  
  String[] getMessages();
  
  Throwable getThrowable(int paramInt);
  
  int getThrowableCount();
  
  Throwable[] getThrowables();
  
  int indexOfThrowable(Class paramClass);
  
  int indexOfThrowable(Class paramClass, int paramInt);
  
  void printStackTrace(PrintWriter paramPrintWriter);
  
  void printStackTrace(PrintStream paramPrintStream);
  
  void printPartialStackTrace(PrintWriter paramPrintWriter);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\exception\Nestable.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */