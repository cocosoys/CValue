/*     */ package net.minecraft.enchantment;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnchantmentProtection
/*     */   extends Enchantment
/*     */ {
/*  14 */   private static final String[] field_77354_A = new String[] { "all", "fire", "fall", "explosion", "projectile" };
/*     */ 
/*     */ 
/*     */   
/*  18 */   private static final int[] field_77355_B = new int[] { 1, 10, 5, 5, 3 };
/*     */ 
/*     */ 
/*     */   
/*  22 */   private static final int[] field_77357_C = new int[] { 11, 8, 6, 8, 6 };
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final int[] field_77353_D = new int[] { 20, 12, 10, 12, 15 };
/*     */   
/*     */   public final int field_77356_a;
/*     */   
/*     */   private static final String __OBFID = "CL_00000121";
/*     */   
/*     */   public EnchantmentProtection(int p_i1936_1_, int p_i1936_2_, int p_i1936_3_) {
/*  33 */     super(p_i1936_1_, p_i1936_2_, EnumEnchantmentType.armor);
/*  34 */     this.field_77356_a = p_i1936_3_;
/*     */     
/*  36 */     if (p_i1936_3_ == 2) {
/*  37 */       this.field_77351_y = EnumEnchantmentType.armor_feet;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77321_a(int p_77321_1_) {
/*  43 */     return field_77355_B[this.field_77356_a] + (p_77321_1_ - 1) * field_77357_C[this.field_77356_a];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77317_b(int p_77317_1_) {
/*  48 */     return func_77321_a(p_77317_1_) + field_77353_D[this.field_77356_a];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77325_b() {
/*  53 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77318_a(int p_77318_1_, DamageSource p_77318_2_) {
/*  58 */     if (p_77318_2_.func_76357_e()) return 0;
/*     */     
/*  60 */     float f = (6 + p_77318_1_ * p_77318_1_) / 3.0F;
/*     */     
/*  62 */     if (this.field_77356_a == 0) return MathHelper.func_76141_d(f * 0.75F); 
/*  63 */     if (this.field_77356_a == 1 && p_77318_2_.func_76347_k()) return MathHelper.func_76141_d(f * 1.25F); 
/*  64 */     if (this.field_77356_a == 2 && p_77318_2_ == DamageSource.field_76379_h) return MathHelper.func_76141_d(f * 2.5F); 
/*  65 */     if (this.field_77356_a == 3 && p_77318_2_.func_94541_c()) return MathHelper.func_76141_d(f * 1.5F); 
/*  66 */     if (this.field_77356_a == 4 && p_77318_2_.func_76352_a()) return MathHelper.func_76141_d(f * 1.5F); 
/*  67 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77320_a() {
/*  72 */     return "enchantment.protect." + field_77354_A[this.field_77356_a];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77326_a(Enchantment p_77326_1_) {
/*  77 */     if (p_77326_1_ instanceof EnchantmentProtection) {
/*  78 */       EnchantmentProtection enchantmentProtection = (EnchantmentProtection)p_77326_1_;
/*     */       
/*  80 */       if (enchantmentProtection.field_77356_a == this.field_77356_a) {
/*  81 */         return false;
/*     */       }
/*  83 */       if (this.field_77356_a == 2 || enchantmentProtection.field_77356_a == 2) {
/*  84 */         return true;
/*     */       }
/*  86 */       return false;
/*     */     } 
/*  88 */     return super.func_77326_a(p_77326_1_);
/*     */   }
/*     */   
/*     */   public static int func_92093_a(Entity p_92093_0_, int p_92093_1_) {
/*  92 */     int i = EnchantmentHelper.func_77511_a(Enchantment.field_77329_d.field_77352_x, p_92093_0_.func_70035_c());
/*     */     
/*  94 */     if (i > 0) {
/*  95 */       p_92093_1_ -= MathHelper.func_76141_d(p_92093_1_ * i * 0.15F);
/*     */     }
/*     */     
/*  98 */     return p_92093_1_;
/*     */   }
/*     */   
/*     */   public static double func_92092_a(Entity p_92092_0_, double p_92092_1_) {
/* 102 */     int i = EnchantmentHelper.func_77511_a(Enchantment.field_77327_f.field_77352_x, p_92092_0_.func_70035_c());
/*     */     
/* 104 */     if (i > 0) {
/* 105 */       p_92092_1_ -= MathHelper.func_76128_c(p_92092_1_ * (i * 0.15F));
/*     */     }
/*     */     
/* 108 */     return p_92092_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\enchantment\EnchantmentProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */