/*     */ package net.minecraft.block.material;
/*     */ 
/*     */ public class Material {
/*   4 */   public static final Material field_151579_a = new MaterialTransparent(MapColor.field_151660_b);
/*   5 */   public static final Material field_151577_b = new Material(MapColor.field_151661_c);
/*   6 */   public static final Material field_151578_c = new Material(MapColor.field_151664_l);
/*   7 */   public static final Material field_151575_d = (new Material(MapColor.field_151663_o)).func_76226_g();
/*   8 */   public static final Material field_151576_e = (new Material(MapColor.field_151665_m)).func_76221_f();
/*   9 */   public static final Material field_151573_f = (new Material(MapColor.field_151668_h)).func_76221_f();
/*  10 */   public static final Material field_151574_g = (new Material(MapColor.field_151668_h)).func_76221_f().func_76225_o();
/*  11 */   public static final Material field_151586_h = (new MaterialLiquid(MapColor.field_151662_n)).func_76219_n();
/*  12 */   public static final Material field_151587_i = (new MaterialLiquid(MapColor.field_151656_f)).func_76219_n();
/*  13 */   public static final Material field_151584_j = (new Material(MapColor.field_151669_i)).func_76226_g().func_76223_p().func_76219_n();
/*  14 */   public static final Material field_151585_k = (new MaterialLogic(MapColor.field_151669_i)).func_76219_n();
/*  15 */   public static final Material field_151582_l = (new MaterialLogic(MapColor.field_151669_i)).func_76226_g().func_76219_n().func_76231_i();
/*  16 */   public static final Material field_151583_m = new Material(MapColor.field_151659_e);
/*  17 */   public static final Material field_151580_n = (new Material(MapColor.field_151659_e)).func_76226_g();
/*  18 */   public static final Material field_151581_o = (new MaterialTransparent(MapColor.field_151660_b)).func_76219_n();
/*  19 */   public static final Material field_151595_p = new Material(MapColor.field_151658_d);
/*  20 */   public static final Material field_151594_q = (new MaterialLogic(MapColor.field_151660_b)).func_76219_n();
/*  21 */   public static final Material field_151593_r = (new MaterialLogic(MapColor.field_151659_e)).func_76226_g();
/*  22 */   public static final Material field_151592_s = (new Material(MapColor.field_151660_b)).func_76223_p().func_85158_p();
/*  23 */   public static final Material field_151591_t = (new Material(MapColor.field_151660_b)).func_85158_p();
/*  24 */   public static final Material field_151590_u = (new Material(MapColor.field_151656_f)).func_76226_g().func_76223_p();
/*  25 */   public static final Material field_151589_v = (new Material(MapColor.field_151669_i)).func_76219_n();
/*  26 */   public static final Material field_151588_w = (new Material(MapColor.field_151657_g)).func_76223_p().func_85158_p();
/*  27 */   public static final Material field_151598_x = (new Material(MapColor.field_151657_g)).func_85158_p();
/*  28 */   public static final Material field_151597_y = (new MaterialLogic(MapColor.field_151666_j)).func_76231_i().func_76223_p().func_76221_f().func_76219_n();
/*  29 */   public static final Material field_151596_z = (new Material(MapColor.field_151666_j)).func_76221_f();
/*  30 */   public static final Material field_151570_A = (new Material(MapColor.field_151669_i)).func_76223_p().func_76219_n();
/*  31 */   public static final Material field_151571_B = new Material(MapColor.field_151667_k);
/*  32 */   public static final Material field_151572_C = (new Material(MapColor.field_151669_i)).func_76219_n();
/*  33 */   public static final Material field_151566_D = (new Material(MapColor.field_151669_i)).func_76219_n();
/*  34 */   public static final Material field_151567_E = (new MaterialPortal(MapColor.field_151660_b)).func_76225_o();
/*  35 */   public static final Material field_151568_F = (new Material(MapColor.field_151660_b)).func_76219_n();
/*  36 */   public static final Material field_151569_G = (new Material(MapColor.field_151659_e)
/*     */     {
/*     */       public boolean func_76230_c() {
/*  39 */         return false;
/*     */       } private static final String __OBFID = "CL_00000543";
/*     */     }).func_76221_f().func_76219_n();
/*  42 */   public static final Material field_76233_E = (new Material(MapColor.field_151665_m)).func_76225_o();
/*     */   
/*     */   private boolean field_76235_G;
/*     */   
/*     */   private boolean field_76239_H;
/*     */   
/*     */   private boolean field_76240_I;
/*     */   private final MapColor field_76234_F;
/*     */   private boolean field_76241_J = true;
/*     */   private int field_76242_K;
/*     */   private boolean field_85159_M;
/*     */   private static final String __OBFID = "CL_00000542";
/*     */   
/*     */   public Material(MapColor p_i2116_1_) {
/*  56 */     this.field_76234_F = p_i2116_1_;
/*     */   }
/*     */   
/*     */   public boolean func_76224_d() {
/*  60 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76220_a() {
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_76228_b() {
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_76230_c() {
/*  76 */     return true;
/*     */   }
/*     */   
/*     */   private Material func_76223_p() {
/*  80 */     this.field_76240_I = true;
/*  81 */     return this;
/*     */   }
/*     */   
/*     */   protected Material func_76221_f() {
/*  85 */     this.field_76241_J = false;
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   protected Material func_76226_g() {
/*  90 */     this.field_76235_G = true;
/*  91 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_76217_h() {
/*  95 */     return this.field_76235_G;
/*     */   }
/*     */   
/*     */   public Material func_76231_i() {
/*  99 */     this.field_76239_H = true;
/* 100 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_76222_j() {
/* 104 */     return this.field_76239_H;
/*     */   }
/*     */   
/*     */   public boolean func_76218_k() {
/* 108 */     if (this.field_76240_I) return false; 
/* 109 */     return func_76230_c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76229_l() {
/* 115 */     return this.field_76241_J;
/*     */   }
/*     */   
/*     */   public int func_76227_m() {
/* 119 */     return this.field_76242_K;
/*     */   }
/*     */   
/*     */   protected Material func_76219_n() {
/* 123 */     this.field_76242_K = 1;
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   protected Material func_76225_o() {
/* 128 */     this.field_76242_K = 2;
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   protected Material func_85158_p() {
/* 133 */     this.field_85159_M = true;
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public boolean func_85157_q() {
/* 138 */     return this.field_85159_M;
/*     */   }
/*     */   
/*     */   public MapColor func_151565_r() {
/* 142 */     return this.field_76234_F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\material\Material.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */