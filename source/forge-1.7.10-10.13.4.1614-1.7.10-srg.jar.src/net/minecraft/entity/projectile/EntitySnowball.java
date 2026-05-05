/*    */ package net.minecraft.entity.projectile;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntitySnowball
/*    */   extends EntityThrowable {
/*    */   public EntitySnowball(World p_i1773_1_) {
/* 12 */     super(p_i1773_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001722";
/*    */   public EntitySnowball(World p_i1774_1_, EntityLivingBase p_i1774_2_) {
/* 16 */     super(p_i1774_1_, p_i1774_2_);
/*    */   }
/*    */   
/*    */   public EntitySnowball(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_) {
/* 20 */     super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
/* 25 */     if (p_70184_1_.field_72308_g != null) {
/* 26 */       byte b1 = 0;
/* 27 */       if (p_70184_1_.field_72308_g instanceof net.minecraft.entity.monster.EntityBlaze) {
/* 28 */         b1 = 3;
/*    */       }
/* 30 */       p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, (Entity)func_85052_h()), b1);
/*    */     } 
/* 32 */     for (byte b = 0; b < 8; b++)
/* 33 */       this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D); 
/* 34 */     if (!this.field_70170_p.field_72995_K)
/* 35 */       func_70106_y(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntitySnowball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */