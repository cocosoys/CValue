package net.minecraft.util.gnu.trove.strategy;

import java.io.Serializable;

public interface HashingStrategy<T> extends Serializable {
  public static final long serialVersionUID = 5674097166776615540L;
  
  int computeHashCode(T paramT);
  
  boolean equals(T paramT1, T paramT2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\strategy\HashingStrategy.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */