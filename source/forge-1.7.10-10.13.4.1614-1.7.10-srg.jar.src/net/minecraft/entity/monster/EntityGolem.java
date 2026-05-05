/*    */ package net.minecraft.entity.monster;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.passive.IAnimals;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class EntityGolem extends EntityCreature implements IAnimals {
/*    */   public EntityGolem(World p_i1686_1_) {
/*  8 */     super(p_i1686_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001644";
/*    */   
/*    */   protected void func_70069_a(float p_70069_1_) {}
/*    */   
/*    */   protected String func_70639_aQ() {
/* 17 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_70621_aR() {
/* 22 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_70673_aS() {
/* 27 */     return "none";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70627_aG() {
/* 32 */     return 120;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_70692_ba() {
/* 37 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */