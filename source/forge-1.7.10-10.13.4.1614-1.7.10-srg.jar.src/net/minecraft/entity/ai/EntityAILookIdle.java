/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class EntityAILookIdle extends EntityAIBase {
/*    */   private EntityLiving field_75258_a;
/*    */   private double field_75256_b;
/*    */   private double field_75257_c;
/*    */   private int field_75255_d;
/*    */   private static final String __OBFID = "CL_00001607";
/*    */   
/*    */   public EntityAILookIdle(EntityLiving p_i1647_1_) {
/* 13 */     this.field_75258_a = p_i1647_1_;
/* 14 */     func_75248_a(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 19 */     return (this.field_75258_a.func_70681_au().nextFloat() < 0.02F);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 24 */     return (this.field_75255_d >= 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 29 */     double d = 6.283185307179586D * this.field_75258_a.func_70681_au().nextDouble();
/* 30 */     this.field_75256_b = Math.cos(d);
/* 31 */     this.field_75257_c = Math.sin(d);
/* 32 */     this.field_75255_d = 20 + this.field_75258_a.func_70681_au().nextInt(20);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 37 */     this.field_75255_d--;
/* 38 */     this.field_75258_a.func_70671_ap().func_75650_a(this.field_75258_a.field_70165_t + this.field_75256_b, this.field_75258_a.field_70163_u + this.field_75258_a.func_70047_e(), this.field_75258_a.field_70161_v + this.field_75257_c, 10.0F, this.field_75258_a.func_70646_bf());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAILookIdle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */