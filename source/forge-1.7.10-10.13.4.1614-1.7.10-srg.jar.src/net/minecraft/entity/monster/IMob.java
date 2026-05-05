/*    */ package net.minecraft.entity.monster;
/*    */ 
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.IAnimals;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IMob
/*    */   extends IAnimals
/*    */ {
/* 13 */   public static final IEntitySelector field_82192_a = new IEntitySelector()
/*    */     {
/*    */       public boolean func_82704_a(Entity p_82704_1_) {
/* 16 */         return p_82704_1_ instanceof IMob;
/*    */       }
/*    */       
/*    */       private static final String __OBFID = "CL_00001688";
/*    */     };
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\IMob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */