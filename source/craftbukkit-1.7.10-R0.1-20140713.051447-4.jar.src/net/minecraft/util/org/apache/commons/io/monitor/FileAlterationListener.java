package net.minecraft.util.org.apache.commons.io.monitor;

import java.io.File;

public interface FileAlterationListener {
  void onStart(FileAlterationObserver paramFileAlterationObserver);
  
  void onDirectoryCreate(File paramFile);
  
  void onDirectoryChange(File paramFile);
  
  void onDirectoryDelete(File paramFile);
  
  void onFileCreate(File paramFile);
  
  void onFileChange(File paramFile);
  
  void onFileDelete(File paramFile);
  
  void onStop(FileAlterationObserver paramFileAlterationObserver);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\io\monitor\FileAlterationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */