/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemMilkBucket
/*    */   extends Item
/*    */ {
/*    */   public ItemMilkBucket() {
/* 11 */     e(1);
/* 12 */     a(CreativeModeTab.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack b(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman) {
/* 17 */     if (!paramEntityHuman.abilities.canInstantlyBuild) paramItemStack.count--;
/*    */     
/* 19 */     if (!paramWorld.isStatic) {
/* 20 */       paramEntityHuman.removeAllEffects();
/*    */     }
/*    */     
/* 23 */     if (paramItemStack.count <= 0) {
/* 24 */       return new ItemStack(Items.BUCKET);
/*    */     }
/* 26 */     return paramItemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public int d_(ItemStack paramItemStack) {
/* 31 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumAnimation d(ItemStack paramItemStack) {
/* 36 */     return EnumAnimation.DRINK;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack a(ItemStack paramItemStack, World paramWorld, EntityHuman paramEntityHuman) {
/* 41 */     paramEntityHuman.a(paramItemStack, d_(paramItemStack));
/* 42 */     return paramItemStack;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ItemMilkBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */