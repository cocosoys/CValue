package org.bukkit.craftbukkit.libs.jline.console.history;

import java.io.IOException;

public interface PersistentHistory extends History {
  void flush() throws IOException;
  
  void purge() throws IOException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\jline\console\history\PersistentHistory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */