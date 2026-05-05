package cpw.mods.fml.client.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public interface ISimpleBlockRenderingHandler {
  void renderInventoryBlock(Block paramBlock, int paramInt1, int paramInt2, RenderBlocks paramRenderBlocks);
  
  boolean renderWorldBlock(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3, Block paramBlock, int paramInt4, RenderBlocks paramRenderBlocks);
  
  boolean shouldRender3DInInventory(int paramInt);
  
  int getRenderId();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\registry\ISimpleBlockRenderingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */