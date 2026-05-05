/*    */ package net.minecraft.entity.projectile;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityChicken;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityEgg extends EntityThrowable {
/*    */   public EntityEgg(World p_i1779_1_) {
/* 12 */     super(p_i1779_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001724";
/*    */   public EntityEgg(World p_i1780_1_, EntityLivingBase p_i1780_2_) {
/* 16 */     super(p_i1780_1_, p_i1780_2_);
/*    */   }
/*    */   
/*    */   public EntityEgg(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
/* 20 */     super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
/* 25 */     if (p_70184_1_.field_72308_g != null) {
/* 26 */       p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, (Entity)func_85052_h()), 0.0F);
/*    */     }
/* 28 */     if (!this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(8) == 0) {
/* 29 */       byte b1 = 1;
/* 30 */       if (this.field_70146_Z.nextInt(32) == 0) b1 = 4; 
/* 31 */       for (byte b2 = 0; b2 < b1; b2++) {
/* 32 */         EntityChicken entityChicken = new EntityChicken(this.field_70170_p);
/* 33 */         entityChicken.func_70873_a(-24000);
/*    */         
/* 35 */         entityChicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0F);
/* 36 */         this.field_70170_p.func_72838_d((Entity)entityChicken);
/*    */       } 
/*    */     } 
/*    */     
/* 40 */     for (byte b = 0; b < 8; b++) {
/* 41 */       this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
/*    */     }
/* 43 */     if (!this.field_70170_p.field_72995_K)
/* 44 */       func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */