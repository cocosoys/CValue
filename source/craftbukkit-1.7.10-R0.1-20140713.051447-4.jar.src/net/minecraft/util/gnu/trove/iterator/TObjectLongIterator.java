package net.minecraft.util.gnu.trove.iterator;

public interface TObjectLongIterator<K> extends TAdvancingIterator {
  K key();
  
  long value();
  
  long setValue(long paramLong);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\iterator\TObjectLongIterator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */