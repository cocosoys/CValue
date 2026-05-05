/*    */ package net.minecraft.entity.projectile;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityLargeFireball extends EntityFireball {
/* 12 */   public int field_92057_e = 1; private static final String __OBFID = "CL_00001719";
/*    */   
/*    */   public EntityLargeFireball(World p_i1767_1_) {
/* 15 */     super(p_i1767_1_);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EntityLargeFireball(World p_i1768_1_, double p_i1768_2_, double p_i1768_4_, double p_i1768_6_, double p_i1768_8_, double p_i1768_10_, double p_i1768_12_) {
/* 19 */     super(p_i1768_1_, p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_, p_i1768_10_, p_i1768_12_);
/*    */   }
/*    */   
/*    */   public EntityLargeFireball(World p_i1769_1_, EntityLivingBase p_i1769_2_, double p_i1769_3_, double p_i1769_5_, double p_i1769_7_) {
/* 23 */     super(p_i1769_1_, p_i1769_2_, p_i1769_3_, p_i1769_5_, p_i1769_7_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70227_a(MovingObjectPosition p_70227_1_) {
/* 28 */     if (!this.field_70170_p.field_72995_K) {
/* 29 */       if (p_70227_1_.field_72308_g != null) {
/* 30 */         p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76362_a(this, (Entity)this.field_70235_a), 6.0F);
/*    */       }
/* 32 */       this.field_70170_p.func_72885_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_92057_e, true, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/* 33 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 39 */     super.func_70014_b(p_70014_1_);
/* 40 */     p_70014_1_.func_74768_a("ExplosionPower", this.field_92057_e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 45 */     super.func_70037_a(p_70037_1_);
/* 46 */     if (p_70037_1_.func_150297_b("ExplosionPower", 99)) this.field_92057_e = p_70037_1_.func_74762_e("ExplosionPower"); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityLargeFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */