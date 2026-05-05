package org.bukkit.block;

public interface Sign extends BlockState {
  String[] getLines();
  
  String getLine(int paramInt) throws IndexOutOfBoundsException;
  
  void setLine(int paramInt, String paramString) throws IndexOutOfBoundsException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\Sign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */