package org.apache.logging.log4j.message;

interface ThreadInformation {
  void printThreadInfo(StringBuilder paramStringBuilder);
  
  void printStack(StringBuilder paramStringBuilder, StackTraceElement[] paramArrayOfStackTraceElement);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\message\ThreadInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */