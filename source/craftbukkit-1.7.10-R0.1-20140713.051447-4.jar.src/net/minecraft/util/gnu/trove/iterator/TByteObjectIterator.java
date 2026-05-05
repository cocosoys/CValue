package net.minecraft.util.gnu.trove.iterator;

public interface TByteObjectIterator<V> extends TAdvancingIterator {
  byte key();
  
  V value();
  
  V setValue(V paramV);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\iterator\TByteObjectIterator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */