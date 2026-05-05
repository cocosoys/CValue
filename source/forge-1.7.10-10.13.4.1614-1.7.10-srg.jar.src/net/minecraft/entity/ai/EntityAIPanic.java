/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIPanic
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature field_75267_a;
/*    */   private double field_75265_b;
/*    */   private double field_75266_c;
/*    */   
/*    */   public EntityAIPanic(EntityCreature p_i1645_1_, double p_i1645_2_) {
/* 14 */     this.field_75267_a = p_i1645_1_;
/* 15 */     this.field_75265_b = p_i1645_2_;
/* 16 */     func_75248_a(1);
/*    */   }
/*    */   private double field_75263_d; private double field_75264_e; private static final String __OBFID = "CL_00001604";
/*    */   
/*    */   public boolean func_75250_a() {
/* 21 */     if (this.field_75267_a.func_70643_av() == null && !this.field_75267_a.func_70027_ad()) return false; 
/* 22 */     Vec3 vec3 = RandomPositionGenerator.func_75463_a(this.field_75267_a, 5, 4);
/* 23 */     if (vec3 == null) return false; 
/* 24 */     this.field_75266_c = vec3.field_72450_a;
/* 25 */     this.field_75263_d = vec3.field_72448_b;
/* 26 */     this.field_75264_e = vec3.field_72449_c;
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 32 */     this.field_75267_a.func_70661_as().func_75492_a(this.field_75266_c, this.field_75263_d, this.field_75264_e, this.field_75265_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 37 */     return !this.field_75267_a.func_70661_as().func_75500_f();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIPanic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */