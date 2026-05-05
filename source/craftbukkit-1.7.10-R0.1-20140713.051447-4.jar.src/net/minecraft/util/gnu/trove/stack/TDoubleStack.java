package net.minecraft.util.gnu.trove.stack;

public interface TDoubleStack {
  double getNoEntryValue();
  
  void push(double paramDouble);
  
  double pop();
  
  double peek();
  
  int size();
  
  void clear();
  
  double[] toArray();
  
  void toArray(double[] paramArrayOfdouble);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\stack\TDoubleStack.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */