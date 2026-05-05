package cpw.mods.fml.repackage.com.nothome.delta;

import java.io.Closeable;
import java.io.IOException;

public interface DiffWriter extends Closeable {
  void addCopy(long paramLong, int paramInt) throws IOException;
  
  void addData(byte paramByte) throws IOException;
  
  void flush() throws IOException;
  
  void close() throws IOException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\DiffWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */