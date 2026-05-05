/*     */ package net.minecraft.util;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FoodStats
/*     */ {
/*  24 */   private int field_75127_a = 20;
/*  25 */   private int field_75124_e = 20;
/*  26 */   private float field_75125_b = 5.0F;
/*     */   private float field_75126_c;
/*     */   
/*     */   public void func_75122_a(int p_75122_1_, float p_75122_2_) {
/*  30 */     this.field_75127_a = Math.min(p_75122_1_ + this.field_75127_a, 20);
/*  31 */     this.field_75125_b = Math.min(this.field_75125_b + p_75122_1_ * p_75122_2_ * 2.0F, this.field_75127_a);
/*     */   }
/*     */   private int field_75123_d; private static final String __OBFID = "CL_00001729";
/*     */   public void func_151686_a(ItemFood p_151686_1_, ItemStack p_151686_2_) {
/*  35 */     func_75122_a(p_151686_1_.func_150905_g(p_151686_2_), p_151686_1_.func_150906_h(p_151686_2_));
/*     */   }
/*     */   
/*     */   public void func_75118_a(EntityPlayer p_75118_1_) {
/*  39 */     EnumDifficulty enumDifficulty = p_75118_1_.field_70170_p.field_73013_u;
/*     */     
/*  41 */     this.field_75124_e = this.field_75127_a;
/*     */     
/*  43 */     if (this.field_75126_c > 4.0F) {
/*  44 */       this.field_75126_c -= 4.0F;
/*     */       
/*  46 */       if (this.field_75125_b > 0.0F) {
/*  47 */         this.field_75125_b = Math.max(this.field_75125_b - 1.0F, 0.0F);
/*  48 */       } else if (enumDifficulty != EnumDifficulty.PEACEFUL) {
/*  49 */         this.field_75127_a = Math.max(this.field_75127_a - 1, 0);
/*     */       } 
/*     */     } 
/*     */     
/*  53 */     if (p_75118_1_.field_70170_p.func_82736_K().func_82766_b("naturalRegeneration") && this.field_75127_a >= 18 && p_75118_1_.func_70996_bM()) {
/*  54 */       this.field_75123_d++;
/*  55 */       if (this.field_75123_d >= 80) {
/*  56 */         p_75118_1_.func_70691_i(1.0F);
/*  57 */         func_75113_a(3.0F);
/*  58 */         this.field_75123_d = 0;
/*     */       } 
/*  60 */     } else if (this.field_75127_a <= 0) {
/*  61 */       this.field_75123_d++;
/*  62 */       if (this.field_75123_d >= 80) {
/*  63 */         if (p_75118_1_.func_110143_aJ() > 10.0F || enumDifficulty == EnumDifficulty.HARD || (p_75118_1_.func_110143_aJ() > 1.0F && enumDifficulty == EnumDifficulty.NORMAL)) {
/*  64 */           p_75118_1_.func_70097_a(DamageSource.field_76366_f, 1.0F);
/*     */         }
/*  66 */         this.field_75123_d = 0;
/*     */       } 
/*     */     } else {
/*  69 */       this.field_75123_d = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75112_a(NBTTagCompound p_75112_1_) {
/*  76 */     if (p_75112_1_.func_150297_b("foodLevel", 99)) {
/*  77 */       this.field_75127_a = p_75112_1_.func_74762_e("foodLevel");
/*  78 */       this.field_75123_d = p_75112_1_.func_74762_e("foodTickTimer");
/*  79 */       this.field_75125_b = p_75112_1_.func_74760_g("foodSaturationLevel");
/*  80 */       this.field_75126_c = p_75112_1_.func_74760_g("foodExhaustionLevel");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_75117_b(NBTTagCompound p_75117_1_) {
/*  85 */     p_75117_1_.func_74768_a("foodLevel", this.field_75127_a);
/*  86 */     p_75117_1_.func_74768_a("foodTickTimer", this.field_75123_d);
/*  87 */     p_75117_1_.func_74776_a("foodSaturationLevel", this.field_75125_b);
/*  88 */     p_75117_1_.func_74776_a("foodExhaustionLevel", this.field_75126_c);
/*     */   }
/*     */   
/*     */   public int func_75116_a() {
/*  92 */     return this.field_75127_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_75120_b() {
/*  96 */     return this.field_75124_e;
/*     */   }
/*     */   
/*     */   public boolean func_75121_c() {
/* 100 */     return (this.field_75127_a < 20);
/*     */   }
/*     */   
/*     */   public void func_75113_a(float p_75113_1_) {
/* 104 */     this.field_75126_c = Math.min(this.field_75126_c + p_75113_1_, 40.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_75115_e() {
/* 112 */     return this.field_75125_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75114_a(int p_75114_1_) {
/* 116 */     this.field_75127_a = p_75114_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75119_b(float p_75119_1_) {
/* 120 */     this.field_75125_b = p_75119_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\FoodStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */