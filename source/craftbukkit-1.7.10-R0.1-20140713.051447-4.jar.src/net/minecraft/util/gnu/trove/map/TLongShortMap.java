package net.minecraft.util.gnu.trove.map;

import java.util.Map;
import net.minecraft.util.gnu.trove.TShortCollection;
import net.minecraft.util.gnu.trove.function.TShortFunction;
import net.minecraft.util.gnu.trove.iterator.TLongShortIterator;
import net.minecraft.util.gnu.trove.procedure.TLongProcedure;
import net.minecraft.util.gnu.trove.procedure.TLongShortProcedure;
import net.minecraft.util.gnu.trove.procedure.TShortProcedure;
import net.minecraft.util.gnu.trove.set.TLongSet;

public interface TLongShortMap {
  long getNoEntryKey();
  
  short getNoEntryValue();
  
  short put(long paramLong, short paramShort);
  
  short putIfAbsent(long paramLong, short paramShort);
  
  void putAll(Map<? extends Long, ? extends Short> paramMap);
  
  void putAll(TLongShortMap paramTLongShortMap);
  
  short get(long paramLong);
  
  void clear();
  
  boolean isEmpty();
  
  short remove(long paramLong);
  
  int size();
  
  TLongSet keySet();
  
  long[] keys();
  
  long[] keys(long[] paramArrayOflong);
  
  TShortCollection valueCollection();
  
  short[] values();
  
  short[] values(short[] paramArrayOfshort);
  
  boolean containsValue(short paramShort);
  
  boolean containsKey(long paramLong);
  
  TLongShortIterator iterator();
  
  boolean forEachKey(TLongProcedure paramTLongProcedure);
  
  boolean forEachValue(TShortProcedure paramTShortProcedure);
  
  boolean forEachEntry(TLongShortProcedure paramTLongShortProcedure);
  
  void transformValues(TShortFunction paramTShortFunction);
  
  boolean retainEntries(TLongShortProcedure paramTLongShortProcedure);
  
  boolean increment(long paramLong);
  
  boolean adjustValue(long paramLong, short paramShort);
  
  short adjustOrPutValue(long paramLong, short paramShort1, short paramShort2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\map\TLongShortMap.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */