/*     */ package net.minecraft.entity.projectile;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityWitherSkull
/*     */   extends EntityFireball {
/*     */   private static final String __OBFID = "CL_00001728";
/*     */   
/*     */   public EntityWitherSkull(World p_i1793_1_) {
/*  21 */     super(p_i1793_1_);
/*  22 */     func_70105_a(0.3125F, 0.3125F);
/*     */   }
/*     */   
/*     */   public EntityWitherSkull(World p_i1794_1_, EntityLivingBase p_i1794_2_, double p_i1794_3_, double p_i1794_5_, double p_i1794_7_) {
/*  26 */     super(p_i1794_1_, p_i1794_2_, p_i1794_3_, p_i1794_5_, p_i1794_7_);
/*     */     
/*  28 */     func_70105_a(0.3125F, 0.3125F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_82341_c() {
/*  33 */     return func_82342_d() ? 0.73F : super.func_82341_c();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityWitherSkull(World p_i1795_1_, double p_i1795_2_, double p_i1795_4_, double p_i1795_6_, double p_i1795_8_, double p_i1795_10_, double p_i1795_12_) {
/*  37 */     super(p_i1795_1_, p_i1795_2_, p_i1795_4_, p_i1795_6_, p_i1795_8_, p_i1795_10_, p_i1795_12_);
/*  38 */     func_70105_a(0.3125F, 0.3125F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70027_ad() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_145772_a(Explosion p_145772_1_, World p_145772_2_, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block p_145772_6_) {
/*  48 */     float f = super.func_145772_a(p_145772_1_, p_145772_2_, p_145772_3_, p_145772_4_, p_145772_5_, p_145772_6_);
/*     */     
/*  50 */     if (func_82342_d() && p_145772_6_ != Blocks.field_150357_h && p_145772_6_ != Blocks.field_150384_bq && p_145772_6_ != Blocks.field_150378_br && p_145772_6_ != Blocks.field_150483_bI) {
/*  51 */       f = Math.min(0.8F, f);
/*     */     }
/*     */     
/*  54 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70227_a(MovingObjectPosition p_70227_1_) {
/*  59 */     if (!this.field_70170_p.field_72995_K) {
/*  60 */       if (p_70227_1_.field_72308_g != null) {
/*  61 */         if (this.field_70235_a != null) {
/*  62 */           if (p_70227_1_.field_72308_g.func_70097_a(DamageSource.func_76358_a(this.field_70235_a), 8.0F) && 
/*  63 */             !p_70227_1_.field_72308_g.func_70089_S()) {
/*  64 */             this.field_70235_a.func_70691_i(5.0F);
/*     */           }
/*     */         } else {
/*     */           
/*  68 */           p_70227_1_.field_72308_g.func_70097_a(DamageSource.field_76376_m, 5.0F);
/*     */         } 
/*  70 */         if (p_70227_1_.field_72308_g instanceof EntityLivingBase) {
/*  71 */           byte b = 0;
/*  72 */           if (this.field_70170_p.field_73013_u == EnumDifficulty.NORMAL) {
/*  73 */             b = 10;
/*  74 */           } else if (this.field_70170_p.field_73013_u == EnumDifficulty.HARD) {
/*  75 */             b = 40;
/*     */           } 
/*  77 */           if (b > 0) {
/*  78 */             ((EntityLivingBase)p_70227_1_.field_72308_g).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 20 * b, 1));
/*     */           }
/*     */         } 
/*     */       } 
/*  82 */       this.field_70170_p.func_72885_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, false, this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/*  83 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  94 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  99 */     this.field_70180_af.func_75682_a(10, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public boolean func_82342_d() {
/* 103 */     return (this.field_70180_af.func_75683_a(10) == 1);
/*     */   }
/*     */   
/*     */   public void func_82343_e(boolean p_82343_1_) {
/* 107 */     this.field_70180_af.func_75692_b(10, Byte.valueOf(p_82343_1_ ? 1 : 0));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\projectile\EntityWitherSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */