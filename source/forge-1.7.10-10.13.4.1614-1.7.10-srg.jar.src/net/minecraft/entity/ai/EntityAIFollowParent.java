/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityAnimal;
/*    */ 
/*    */ public class EntityAIFollowParent
/*    */   extends EntityAIBase
/*    */ {
/*    */   EntityAnimal field_75348_a;
/*    */   EntityAnimal field_75346_b;
/*    */   
/*    */   public EntityAIFollowParent(EntityAnimal p_i1626_1_, double p_i1626_2_) {
/* 14 */     this.field_75348_a = p_i1626_1_;
/* 15 */     this.field_75347_c = p_i1626_2_;
/*    */   }
/*    */   double field_75347_c; private int field_75345_d; private static final String __OBFID = "CL_00001586";
/*    */   
/*    */   public boolean func_75250_a() {
/* 20 */     if (this.field_75348_a.func_70874_b() >= 0) return false;
/*    */     
/* 22 */     List list = this.field_75348_a.field_70170_p.func_72872_a(this.field_75348_a.getClass(), this.field_75348_a.field_70121_D.func_72314_b(8.0D, 4.0D, 8.0D));
/*    */     
/* 24 */     EntityAnimal entityAnimal = null;
/* 25 */     double d = Double.MAX_VALUE;
/* 26 */     for (EntityAnimal entityAnimal1 : list) {
/* 27 */       if (entityAnimal1.func_70874_b() < 0)
/* 28 */         continue;  double d1 = this.field_75348_a.func_70068_e((Entity)entityAnimal1);
/* 29 */       if (d1 > d)
/* 30 */         continue;  d = d1;
/* 31 */       entityAnimal = entityAnimal1;
/*    */     } 
/*    */     
/* 34 */     if (entityAnimal == null) return false; 
/* 35 */     if (d < 9.0D) return false; 
/* 36 */     this.field_75346_b = entityAnimal;
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 42 */     if (!this.field_75346_b.func_70089_S()) return false; 
/* 43 */     double d = this.field_75348_a.func_70068_e((Entity)this.field_75346_b);
/* 44 */     if (d < 9.0D || d > 256.0D) return false; 
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 50 */     this.field_75345_d = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 55 */     this.field_75346_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 60 */     if (--this.field_75345_d > 0)
/* 61 */       return;  this.field_75345_d = 10;
/* 62 */     this.field_75348_a.func_70661_as().func_75497_a((Entity)this.field_75346_b, this.field_75347_c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIFollowParent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */