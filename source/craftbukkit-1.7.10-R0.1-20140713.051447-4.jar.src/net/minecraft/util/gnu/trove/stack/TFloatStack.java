package net.minecraft.util.gnu.trove.stack;

public interface TFloatStack {
  float getNoEntryValue();
  
  void push(float paramFloat);
  
  float pop();
  
  float peek();
  
  int size();
  
  void clear();
  
  float[] toArray();
  
  void toArray(float[] paramArrayOffloat);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\stack\TFloatStack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */