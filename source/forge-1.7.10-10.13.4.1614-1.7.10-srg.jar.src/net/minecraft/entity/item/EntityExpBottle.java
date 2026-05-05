/*    */ package net.minecraft.entity.item;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.projectile.EntityThrowable;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityExpBottle
/*    */   extends EntityThrowable {
/*    */   public EntityExpBottle(World p_i1785_1_) {
/* 11 */     super(p_i1785_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001726";
/*    */   public EntityExpBottle(World p_i1786_1_, EntityLivingBase p_i1786_2_) {
/* 15 */     super(p_i1786_1_, p_i1786_2_);
/*    */   }
/*    */   
/*    */   public EntityExpBottle(World p_i1787_1_, double p_i1787_2_, double p_i1787_4_, double p_i1787_6_) {
/* 19 */     super(p_i1787_1_, p_i1787_2_, p_i1787_4_, p_i1787_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_70185_h() {
/* 24 */     return 0.07F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_70182_d() {
/* 29 */     return 0.7F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected float func_70183_g() {
/* 34 */     return -20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
/* 40 */     if (!this.field_70170_p.field_72995_K) {
/* 41 */       this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
/*    */       
/* 43 */       int i = 3 + this.field_70170_p.field_73012_v.nextInt(5) + this.field_70170_p.field_73012_v.nextInt(5);
/* 44 */       while (i > 0) {
/* 45 */         int j = EntityXPOrb.func_70527_a(i);
/* 46 */         i -= j;
/* 47 */         this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
/*    */       } 
/*    */       
/* 50 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityExpBottle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */