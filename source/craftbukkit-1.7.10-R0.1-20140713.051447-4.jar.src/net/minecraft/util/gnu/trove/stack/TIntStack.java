package net.minecraft.util.gnu.trove.stack;

public interface TIntStack {
  int getNoEntryValue();
  
  void push(int paramInt);
  
  int pop();
  
  int peek();
  
  int size();
  
  void clear();
  
  int[] toArray();
  
  void toArray(int[] paramArrayOfint);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\stack\TIntStack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */