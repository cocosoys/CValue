package org.bukkit;

public interface BlockChangeDelegate {
  @Deprecated
  boolean setRawTypeId(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Deprecated
  boolean setRawTypeIdAndData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @Deprecated
  boolean setTypeId(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Deprecated
  boolean setTypeIdAndData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  @Deprecated
  int getTypeId(int paramInt1, int paramInt2, int paramInt3);
  
  int getHeight();
  
  boolean isEmpty(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\BlockChangeDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */