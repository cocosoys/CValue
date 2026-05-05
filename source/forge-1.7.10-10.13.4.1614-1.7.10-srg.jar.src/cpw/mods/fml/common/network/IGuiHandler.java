package cpw.mods.fml.common.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IGuiHandler {
  Object getServerGuiElement(int paramInt1, EntityPlayer paramEntityPlayer, World paramWorld, int paramInt2, int paramInt3, int paramInt4);
  
  Object getClientGuiElement(int paramInt1, EntityPlayer paramEntityPlayer, World paramWorld, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\IGuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */