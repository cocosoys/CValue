/*    */ package net.minecraft.entity.monster;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.IRangedAttackMob;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.EntityAIBase;
/*    */ import net.minecraft.entity.ai.EntityAILookIdle;
/*    */ import net.minecraft.entity.ai.EntityAIWander;
/*    */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*    */ import net.minecraft.entity.projectile.EntitySnowball;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntitySnowman extends EntityGolem implements IRangedAttackMob {
/*    */   public EntitySnowman(World p_i1692_1_) {
/* 20 */     super(p_i1692_1_);
/* 21 */     func_70105_a(0.4F, 1.8F);
/*    */     
/* 23 */     func_70661_as().func_75491_a(true);
/* 24 */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
/* 25 */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWander(this, 1.0D));
/* 26 */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/* 27 */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*    */     
/* 29 */     this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true, false, IMob.field_82192_a));
/*    */   }
/*    */   private static final String __OBFID = "CL_00001650";
/*    */   
/*    */   public boolean func_70650_aV() {
/* 34 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 39 */     super.func_110147_ax();
/*    */     
/* 41 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4.0D);
/* 42 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70636_d() {
/* 47 */     super.func_70636_d();
/* 48 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 49 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 50 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/*    */     
/* 52 */     if (func_70026_G()) {
/* 53 */       func_70097_a(DamageSource.field_76369_e, 1.0F);
/*    */     }
/*    */     
/* 56 */     if (this.field_70170_p.func_72807_a(i, k).func_150564_a(i, j, k) > 1.0F) {
/* 57 */       func_70097_a(DamageSource.field_76370_b, 1.0F);
/*    */     }
/*    */     
/* 60 */     for (byte b = 0; b < 4; b++) {
/* 61 */       i = MathHelper.func_76128_c(this.field_70165_t + ((b % 2 * 2 - 1) * 0.25F));
/* 62 */       j = MathHelper.func_76128_c(this.field_70163_u);
/* 63 */       k = MathHelper.func_76128_c(this.field_70161_v + ((b / 2 % 2 * 2 - 1) * 0.25F));
/* 64 */       if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && 
/* 65 */         this.field_70170_p.func_72807_a(i, k).func_150564_a(i, j, k) < 0.8F && 
/* 66 */         Blocks.field_150431_aC.func_149742_c(this.field_70170_p, i, j, k)) {
/* 67 */         this.field_70170_p.func_147449_b(i, j, k, Blocks.field_150431_aC);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Item func_146068_u() {
/* 76 */     return Items.field_151126_ay;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 82 */     int i = this.field_70146_Z.nextInt(16);
/* 83 */     for (byte b = 0; b < i; b++) {
/* 84 */       func_145779_a(Items.field_151126_ay, 1);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
/* 90 */     EntitySnowball entitySnowball = new EntitySnowball(this.field_70170_p, (EntityLivingBase)this);
/* 91 */     double d1 = p_82196_1_.field_70165_t - this.field_70165_t;
/* 92 */     double d2 = p_82196_1_.field_70163_u + p_82196_1_.func_70047_e() - 1.100000023841858D - entitySnowball.field_70163_u;
/* 93 */     double d3 = p_82196_1_.field_70161_v - this.field_70161_v;
/* 94 */     float f = MathHelper.func_76133_a(d1 * d1 + d3 * d3) * 0.2F;
/* 95 */     entitySnowball.func_70186_c(d1, d2 + f, d3, 1.6F, 12.0F);
/*    */     
/* 97 */     func_85030_a("random.bow", 1.0F, 1.0F / (func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 98 */     this.field_70170_p.func_72838_d((Entity)entitySnowball);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntitySnowman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */