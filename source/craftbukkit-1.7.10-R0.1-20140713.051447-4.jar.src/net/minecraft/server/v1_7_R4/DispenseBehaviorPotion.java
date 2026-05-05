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
/*    */ final class DispenseBehaviorPotion
/*    */   implements IDispenseBehavior
/*    */ {
/* 59 */   private final DispenseBehaviorItem b = new DispenseBehaviorItem();
/*    */ 
/*    */   
/*    */   public ItemStack a(ISourceBlock paramISourceBlock, ItemStack paramItemStack) {
/* 63 */     if (ItemPotion.g(paramItemStack.getData())) {
/* 64 */       return (new DispenseBehaviorThrownPotion(this, paramItemStack)).a(paramISourceBlock, paramItemStack);
/*    */     }
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
/* 81 */     return this.b.a(paramISourceBlock, paramItemStack);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\DispenseBehaviorPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */