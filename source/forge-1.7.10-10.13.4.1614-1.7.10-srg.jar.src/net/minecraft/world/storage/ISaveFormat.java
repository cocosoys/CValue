package net.minecraft.world.storage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.IProgressUpdate;

public interface ISaveFormat {
  @SideOnly(Side.CLIENT)
  String func_154333_a();
  
  ISaveHandler func_75804_a(String paramString, boolean paramBoolean);
  
  @SideOnly(Side.CLIENT)
  List func_75799_b() throws AnvilConverterException;
  
  void func_75800_d();
  
  @SideOnly(Side.CLIENT)
  WorldInfo func_75803_c(String paramString);
  
  @SideOnly(Side.CLIENT)
  boolean func_154335_d(String paramString);
  
  boolean func_75802_e(String paramString);
  
  @SideOnly(Side.CLIENT)
  void func_75806_a(String paramString1, String paramString2);
  
  @SideOnly(Side.CLIENT)
  boolean func_154334_a(String paramString);
  
  boolean func_75801_b(String paramString);
  
  boolean func_75805_a(String paramString, IProgressUpdate paramIProgressUpdate);
  
  @SideOnly(Side.CLIENT)
  boolean func_90033_f(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\ISaveFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */