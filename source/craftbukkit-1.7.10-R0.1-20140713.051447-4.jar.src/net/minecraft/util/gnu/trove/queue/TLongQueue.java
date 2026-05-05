package net.minecraft.util.gnu.trove.queue;

import net.minecraft.util.gnu.trove.TLongCollection;

public interface TLongQueue extends TLongCollection {
  long element();
  
  boolean offer(long paramLong);
  
  long peek();
  
  long poll();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\queue\TLongQueue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */