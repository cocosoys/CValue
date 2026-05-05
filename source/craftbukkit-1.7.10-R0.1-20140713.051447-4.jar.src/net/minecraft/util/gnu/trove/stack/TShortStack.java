package net.minecraft.util.gnu.trove.stack;

public interface TShortStack {
  short getNoEntryValue();
  
  void push(short paramShort);
  
  short pop();
  
  short peek();
  
  int size();
  
  void clear();
  
  short[] toArray();
  
  void toArray(short[] paramArrayOfshort);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\stack\TShortStack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */