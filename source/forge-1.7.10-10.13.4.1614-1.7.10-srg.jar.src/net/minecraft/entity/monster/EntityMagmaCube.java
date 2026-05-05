/*     */ package net.minecraft.entity.monster;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMagmaCube extends EntitySlime {
/*     */   public EntityMagmaCube(World p_i1737_1_) {
/*  10 */     super(p_i1737_1_);
/*  11 */     this.field_70178_ae = true;
/*     */   }
/*     */   private static final String __OBFID = "CL_00001691";
/*     */   
/*     */   protected void func_110147_ax() {
/*  16 */     super.func_110147_ax();
/*     */     
/*  18 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*  23 */     return (this.field_70170_p.field_73013_u != EnumDifficulty.PEACEFUL && this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70658_aO() {
/*  28 */     return func_70809_q() * 3;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/*  33 */     return 15728880;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/*  38 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70801_i() {
/*  43 */     return "flame";
/*     */   }
/*     */ 
/*     */   
/*     */   protected EntitySlime func_70802_j() {
/*  48 */     return new EntityMagmaCube(this.field_70170_p);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Item func_146068_u() {
/*  53 */     return Items.field_151064_bs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/*  58 */     Item item = func_146068_u();
/*  59 */     if (item != null && func_70809_q() > 1) {
/*  60 */       int i = this.field_70146_Z.nextInt(4) - 2;
/*  61 */       if (p_70628_2_ > 0) {
/*  62 */         i += this.field_70146_Z.nextInt(p_70628_2_ + 1);
/*     */       }
/*  64 */       for (byte b = 0; b < i; b++) {
/*  65 */         func_145779_a(item, 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70027_ad() {
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_70806_k() {
/*  77 */     return super.func_70806_k() * 4;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70808_l() {
/*  82 */     this.field_70813_a *= 0.9F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70664_aZ() {
/*  87 */     this.field_70181_x = (0.42F + func_70809_q() * 0.1F);
/*  88 */     this.field_70160_al = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float p_70069_1_) {}
/*     */ 
/*     */   
/*     */   protected boolean func_70800_m() {
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_70805_n() {
/* 102 */     return super.func_70805_n() + 2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70803_o() {
/* 107 */     if (func_70809_q() > 1) {
/* 108 */       return "mob.magmacube.big";
/*     */     }
/* 110 */     return "mob.magmacube.small";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70058_J() {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70804_p() {
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\monster\EntityMagmaCube.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */