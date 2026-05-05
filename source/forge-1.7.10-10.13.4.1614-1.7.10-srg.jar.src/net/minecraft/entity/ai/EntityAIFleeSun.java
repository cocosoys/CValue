/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIFleeSun extends EntityAIBase {
/*    */   private EntityCreature field_75372_a;
/*    */   private double field_75370_b;
/*    */   private double field_75371_c;
/*    */   private double field_75368_d;
/*    */   private double field_75369_e;
/*    */   private World field_75367_f;
/*    */   private static final String __OBFID = "CL_00001583";
/*    */   
/*    */   public EntityAIFleeSun(EntityCreature p_i1623_1_, double p_i1623_2_) {
/* 19 */     this.field_75372_a = p_i1623_1_;
/* 20 */     this.field_75369_e = p_i1623_2_;
/* 21 */     this.field_75367_f = p_i1623_1_.field_70170_p;
/* 22 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 27 */     if (!this.field_75367_f.func_72935_r()) return false; 
/* 28 */     if (!this.field_75372_a.func_70027_ad()) return false; 
/* 29 */     if (!this.field_75367_f.func_72937_j(MathHelper.func_76128_c(this.field_75372_a.field_70165_t), (int)this.field_75372_a.field_70121_D.field_72338_b, MathHelper.func_76128_c(this.field_75372_a.field_70161_v))) return false;
/*    */     
/* 31 */     Vec3 vec3 = func_75366_f();
/* 32 */     if (vec3 == null) return false; 
/* 33 */     this.field_75370_b = vec3.field_72450_a;
/* 34 */     this.field_75371_c = vec3.field_72448_b;
/* 35 */     this.field_75368_d = vec3.field_72449_c;
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 41 */     return !this.field_75372_a.func_70661_as().func_75500_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 46 */     this.field_75372_a.func_70661_as().func_75492_a(this.field_75370_b, this.field_75371_c, this.field_75368_d, this.field_75369_e);
/*    */   }
/*    */   
/*    */   private Vec3 func_75366_f() {
/* 50 */     Random random = this.field_75372_a.func_70681_au();
/* 51 */     for (byte b = 0; b < 10; b++) {
/* 52 */       int i = MathHelper.func_76128_c(this.field_75372_a.field_70165_t + random.nextInt(20) - 10.0D);
/* 53 */       int j = MathHelper.func_76128_c(this.field_75372_a.field_70121_D.field_72338_b + random.nextInt(6) - 3.0D);
/* 54 */       int k = MathHelper.func_76128_c(this.field_75372_a.field_70161_v + random.nextInt(20) - 10.0D);
/* 55 */       if (!this.field_75367_f.func_72937_j(i, j, k) && this.field_75372_a.func_70783_a(i, j, k) < 0.0F) return Vec3.func_72443_a(i, j, k); 
/*    */     } 
/* 57 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIFleeSun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */