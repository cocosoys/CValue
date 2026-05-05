/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemDoor
/*    */   extends Item
/*    */ {
/*    */   private Material a;
/*    */   
/*    */   public ItemDoor(Material paramMaterial) {
/* 15 */     this.a = paramMaterial;
/* 16 */     this.maxStackSize = 1;
/* 17 */     a(CreativeModeTab.d);
/*    */   }
/*    */   
/*    */   public boolean interactWith(ItemStack paramItemStack, EntityHuman paramEntityHuman, World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*    */     Block block;
/* 22 */     if (paramInt4 != 1) return false; 
/* 23 */     paramInt2++;
/*    */ 
/*    */ 
/*    */     
/* 27 */     if (this.a == Material.WOOD) { block = Blocks.WOODEN_DOOR; }
/* 28 */     else { block = Blocks.IRON_DOOR_BLOCK; }
/*    */     
/* 30 */     if (!paramEntityHuman.a(paramInt1, paramInt2, paramInt3, paramInt4, paramItemStack) || !paramEntityHuman.a(paramInt1, paramInt2 + 1, paramInt3, paramInt4, paramItemStack)) return false; 
/* 31 */     if (!block.canPlace(paramWorld, paramInt1, paramInt2, paramInt3)) return false;
/*    */     
/* 33 */     int i = MathHelper.floor(((paramEntityHuman.yaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 0x3;
/*    */     
/* 35 */     place(paramWorld, paramInt1, paramInt2, paramInt3, i, block);
/*    */     
/* 37 */     paramItemStack.count--;
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void place(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Block paramBlock) {
/* 43 */     byte b1 = 0;
/* 44 */     byte b2 = 0;
/* 45 */     if (paramInt4 == 0) b2 = 1; 
/* 46 */     if (paramInt4 == 1) b1 = -1; 
/* 47 */     if (paramInt4 == 2) b2 = -1; 
/* 48 */     if (paramInt4 == 3) b1 = 1;
/*    */     
/* 50 */     int i = (paramWorld.getType(paramInt1 - b1, paramInt2, paramInt3 - b2).r() ? 1 : 0) + (paramWorld.getType(paramInt1 - b1, paramInt2 + 1, paramInt3 - b2).r() ? 1 : 0);
/* 51 */     int j = (paramWorld.getType(paramInt1 + b1, paramInt2, paramInt3 + b2).r() ? 1 : 0) + (paramWorld.getType(paramInt1 + b1, paramInt2 + 1, paramInt3 + b2).r() ? 1 : 0);
/*    */     
/* 53 */     boolean bool1 = (paramWorld.getType(paramInt1 - b1, paramInt2, paramInt3 - b2) == paramBlock || paramWorld.getType(paramInt1 - b1, paramInt2 + 1, paramInt3 - b2) == paramBlock) ? true : false;
/* 54 */     boolean bool2 = (paramWorld.getType(paramInt1 + b1, paramInt2, paramInt3 + b2) == paramBlock || paramWorld.getType(paramInt1 + b1, paramInt2 + 1, paramInt3 + b2) == paramBlock) ? true : false;
/*    */     
/* 56 */     boolean bool3 = false;
/* 57 */     if (bool1 && !bool2) { bool3 = true; }
/* 58 */     else if (j > i) { bool3 = true; }
/*    */     
/* 60 */     paramWorld.setTypeAndData(paramInt1, paramInt2, paramInt3, paramBlock, paramInt4, 2);
/* 61 */     paramWorld.setTypeAndData(paramInt1, paramInt2 + 1, paramInt3, paramBlock, 0x8 | (bool3 ? 1 : 0), 2);
/* 62 */     paramWorld.applyPhysics(paramInt1, paramInt2, paramInt3, paramBlock);
/* 63 */     paramWorld.applyPhysics(paramInt1, paramInt2 + 1, paramInt3, paramBlock);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ItemDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */