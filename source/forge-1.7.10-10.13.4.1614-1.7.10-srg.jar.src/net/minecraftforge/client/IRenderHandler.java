package net.minecraftforge.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

public abstract class IRenderHandler {
  @SideOnly(Side.CLIENT)
  public abstract void render(float paramFloat, WorldClient paramWorldClient, Minecraft paramMinecraft);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\IRenderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */