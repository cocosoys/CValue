/*    */ package net.minecraft.entity.item;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.entity.projectile.EntityThrowable;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityEnderPearl extends EntityThrowable {
/*    */   public EntityEnderPearl(World p_i1782_1_) {
/* 12 */     super(p_i1782_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001725";
/*    */   public EntityEnderPearl(World p_i1783_1_, EntityLivingBase p_i1783_2_) {
/* 16 */     super(p_i1783_1_, p_i1783_2_);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EntityEnderPearl(World p_i1784_1_, double p_i1784_2_, double p_i1784_4_, double p_i1784_6_) {
/* 20 */     super(p_i1784_1_, p_i1784_2_, p_i1784_4_, p_i1784_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70184_a(MovingObjectPosition p_70184_1_) {
/* 25 */     if (p_70184_1_.field_72308_g != null) {
/* 26 */       p_70184_1_.field_72308_g.func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)func_85052_h()), 0.0F);
/*    */     }
/* 28 */     for (byte b = 0; b < 32; b++) {
/* 29 */       this.field_70170_p.func_72869_a("portal", this.field_70165_t, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0D, this.field_70161_v, this.field_70146_Z.nextGaussian(), 0.0D, this.field_70146_Z.nextGaussian());
/*    */     }
/*    */     
/* 32 */     if (!this.field_70170_p.field_72995_K) {
/* 33 */       if (func_85052_h() != null && func_85052_h() instanceof EntityPlayerMP) {
/* 34 */         EntityPlayerMP entityPlayerMP = (EntityPlayerMP)func_85052_h();
/*    */         
/* 36 */         if (entityPlayerMP.field_71135_a.func_147362_b().func_150724_d() && entityPlayerMP.field_70170_p == this.field_70170_p) {
/* 37 */           if (func_85052_h().func_70115_ae()) {
/* 38 */             func_85052_h().func_70078_a(null);
/*    */           }
/* 40 */           func_85052_h().func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 41 */           (func_85052_h()).field_70143_R = 0.0F;
/* 42 */           func_85052_h().func_70097_a(DamageSource.field_76379_h, 5.0F);
/*    */         } 
/*    */       } 
/* 45 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityEnderPearl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */