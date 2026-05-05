/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIOcelotAttack
/*    */   extends EntityAIBase {
/*    */   World field_75411_a;
/*    */   EntityLiving field_75409_b;
/*    */   EntityLivingBase field_75410_c;
/*    */   int field_75408_d;
/*    */   private static final String __OBFID = "CL_00001600";
/*    */   
/*    */   public EntityAIOcelotAttack(EntityLiving p_i1641_1_) {
/* 17 */     this.field_75409_b = p_i1641_1_;
/* 18 */     this.field_75411_a = p_i1641_1_.field_70170_p;
/* 19 */     func_75248_a(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 24 */     EntityLivingBase entityLivingBase = this.field_75409_b.func_70638_az();
/* 25 */     if (entityLivingBase == null) return false; 
/* 26 */     this.field_75410_c = entityLivingBase;
/* 27 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 32 */     if (!this.field_75410_c.func_70089_S()) return false; 
/* 33 */     if (this.field_75409_b.func_70068_e((Entity)this.field_75410_c) > 225.0D) return false; 
/* 34 */     return (!this.field_75409_b.func_70661_as().func_75500_f() || func_75250_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 39 */     this.field_75410_c = null;
/* 40 */     this.field_75409_b.func_70661_as().func_75499_g();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 45 */     this.field_75409_b.func_70671_ap().func_75651_a((Entity)this.field_75410_c, 30.0F, 30.0F);
/*    */     
/* 47 */     double d1 = (this.field_75409_b.field_70130_N * 2.0F * this.field_75409_b.field_70130_N * 2.0F);
/* 48 */     double d2 = this.field_75409_b.func_70092_e(this.field_75410_c.field_70165_t, this.field_75410_c.field_70121_D.field_72338_b, this.field_75410_c.field_70161_v);
/*    */     
/* 50 */     double d3 = 0.8D;
/* 51 */     if (d2 > d1 && d2 < 16.0D) { d3 = 1.33D; }
/* 52 */     else if (d2 < 225.0D) { d3 = 0.6D; }
/*    */     
/* 54 */     this.field_75409_b.func_70661_as().func_75497_a((Entity)this.field_75410_c, d3);
/*    */     
/* 56 */     this.field_75408_d = Math.max(this.field_75408_d - 1, 0);
/*    */     
/* 58 */     if (d2 > d1)
/* 59 */       return;  if (this.field_75408_d > 0)
/* 60 */       return;  this.field_75408_d = 20;
/* 61 */     this.field_75409_b.func_70652_k((Entity)this.field_75410_c);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIOcelotAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */