/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIWander
/*    */   extends EntityAIBase {
/*    */   private EntityCreature field_75457_a;
/*    */   private double field_75455_b;
/*    */   private double field_75456_c;
/*    */   private double field_75453_d;
/*    */   private double field_75454_e;
/*    */   private static final String __OBFID = "CL_00001608";
/*    */   
/*    */   public EntityAIWander(EntityCreature p_i1648_1_, double p_i1648_2_) {
/* 16 */     this.field_75457_a = p_i1648_1_;
/* 17 */     this.field_75454_e = p_i1648_2_;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     if (this.field_75457_a.func_70654_ax() >= 100) return false; 
/* 24 */     if (this.field_75457_a.func_70681_au().nextInt(120) != 0) return false;
/*    */     
/* 26 */     Vec3 vec3 = RandomPositionGenerator.func_75463_a(this.field_75457_a, 10, 7);
/* 27 */     if (vec3 == null) return false; 
/* 28 */     this.field_75455_b = vec3.field_72450_a;
/* 29 */     this.field_75456_c = vec3.field_72448_b;
/* 30 */     this.field_75453_d = vec3.field_72449_c;
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 36 */     return !this.field_75457_a.func_70661_as().func_75500_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 41 */     this.field_75457_a.func_70661_as().func_75492_a(this.field_75455_b, this.field_75456_c, this.field_75453_d, this.field_75454_e);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIWander.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */