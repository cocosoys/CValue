package cpw.mods.fml.repackage.com.nothome.delta;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface SeekableSource extends Closeable {
  void seek(long paramLong) throws IOException;
  
  int read(ByteBuffer paramByteBuffer) throws IOException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\SeekableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */