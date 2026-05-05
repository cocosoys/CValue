/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class EntityAIOpenDoor
/*    */   extends EntityAIDoorInteract {
/*    */   boolean field_75361_i;
/*    */   
/*    */   public EntityAIOpenDoor(EntityLiving p_i1644_1_, boolean p_i1644_2_) {
/* 10 */     super(p_i1644_1_);
/* 11 */     this.field_75356_a = p_i1644_1_;
/* 12 */     this.field_75361_i = p_i1644_2_;
/*    */   }
/*    */   int field_75360_j; private static final String __OBFID = "CL_00001603";
/*    */   
/*    */   public boolean func_75253_b() {
/* 17 */     return (this.field_75361_i && this.field_75360_j > 0 && super.func_75253_b());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 22 */     this.field_75360_j = 20;
/* 23 */     this.field_151504_e.func_150014_a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 28 */     if (this.field_75361_i) {
/* 29 */       this.field_151504_e.func_150014_a(this.field_75356_a.field_70170_p, this.field_75354_b, this.field_75355_c, this.field_75352_d, false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 35 */     this.field_75360_j--;
/* 36 */     super.func_75246_d();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIOpenDoor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */