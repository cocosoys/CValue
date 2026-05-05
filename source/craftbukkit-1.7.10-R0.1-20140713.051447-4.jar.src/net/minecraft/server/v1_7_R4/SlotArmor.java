/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SlotArmor
/*    */   extends Slot
/*    */ {
/*    */   SlotArmor(ContainerPlayer paramContainerPlayer, IInventory paramIInventory, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 40 */     super(paramIInventory, paramInt1, paramInt2, paramInt3);
/*    */   }
/*    */   public int getMaxStackSize() {
/* 43 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isAllowed(ItemStack paramItemStack) {
/* 48 */     if (paramItemStack == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     if (paramItemStack.getItem() instanceof ItemArmor) {
/* 52 */       return (((ItemArmor)paramItemStack.getItem()).b == this.a);
/*    */     }
/* 54 */     if (paramItemStack.getItem() == Item.getItemOf(Blocks.PUMPKIN) || paramItemStack.getItem() == Items.SKULL) {
/* 55 */       return (this.a == 0);
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\SlotArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */