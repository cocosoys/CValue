package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IProgressUpdate {
  void func_73720_a(String paramString);
  
  @SideOnly(Side.CLIENT)
  void func_73721_b(String paramString);
  
  void func_73719_c(String paramString);
  
  void func_73718_a(int paramInt);
  
  @SideOnly(Side.CLIENT)
  void func_146586_a();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\IProgressUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */