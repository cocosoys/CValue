package net.minecraft.client.audio;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.gui.IUpdatePlayerListBox;

@SideOnly(Side.CLIENT)
public interface ITickableSound extends ISound, IUpdatePlayerListBox {
  boolean func_147667_k();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\ITickableSound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */