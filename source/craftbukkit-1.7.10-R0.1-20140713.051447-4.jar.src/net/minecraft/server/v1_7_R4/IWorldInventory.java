package net.minecraft.server.v1_7_R4;

public interface IWorldInventory extends IInventory {
  int[] getSlotsForFace(int paramInt);
  
  boolean canPlaceItemThroughFace(int paramInt1, ItemStack paramItemStack, int paramInt2);
  
  boolean canTakeItemThroughFace(int paramInt1, ItemStack paramItemStack, int paramInt2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\IWorldInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */