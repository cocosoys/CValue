/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIMoveTowardsRestriction extends EntityAIBase {
/*    */   private EntityCreature field_75436_a;
/*    */   private double field_75434_b;
/*    */   private double field_75435_c;
/*    */   private double field_75432_d;
/*    */   private double field_75433_e;
/*    */   private static final String __OBFID = "CL_00001598";
/*    */   
/*    */   public EntityAIMoveTowardsRestriction(EntityCreature p_i2347_1_, double p_i2347_2_) {
/* 16 */     this.field_75436_a = p_i2347_1_;
/* 17 */     this.field_75433_e = p_i2347_2_;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     if (this.field_75436_a.func_110173_bK()) return false; 
/* 24 */     ChunkCoordinates chunkCoordinates = this.field_75436_a.func_110172_bL();
/* 25 */     Vec3 vec3 = RandomPositionGenerator.func_75464_a(this.field_75436_a, 16, 7, Vec3.func_72443_a(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c));
/* 26 */     if (vec3 == null) return false; 
/* 27 */     this.field_75434_b = vec3.field_72450_a;
/* 28 */     this.field_75435_c = vec3.field_72448_b;
/* 29 */     this.field_75432_d = vec3.field_72449_c;
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 35 */     return !this.field_75436_a.func_70661_as().func_75500_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 40 */     this.field_75436_a.func_70661_as().func_75492_a(this.field_75434_b, this.field_75435_c, this.field_75432_d, this.field_75433_e);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIMoveTowardsRestriction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */