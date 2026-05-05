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
/*    */ final class EntitySelectorChickenJockey
/*    */   implements IEntitySelector
/*    */ {
/*    */   public boolean a(Entity paramEntity) {
/* 17 */     return (paramEntity.isAlive() && paramEntity.passenger == null && paramEntity.vehicle == null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntitySelectorChickenJockey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */