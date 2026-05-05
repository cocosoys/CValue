/*     */ package net.minecraft.client.particle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityFireworkSparkFX
/*     */   extends EntityFX
/*     */ {
/* 280 */   private int field_92049_a = 160;
/*     */   private boolean field_92054_ax;
/*     */   private boolean field_92048_ay;
/*     */   private final EffectRenderer field_92047_az;
/*     */   private float field_92050_aA;
/*     */   private float field_92051_aB;
/*     */   private float field_92052_aC;
/*     */   private boolean field_92053_aD;
/*     */   private static final String __OBFID = "CL_00000905";
/*     */   
/*     */   public EntityFireworkSparkFX(World p_i1207_1_, double p_i1207_2_, double p_i1207_4_, double p_i1207_6_, double p_i1207_8_, double p_i1207_10_, double p_i1207_12_, EffectRenderer p_i1207_14_) {
/* 291 */     super(p_i1207_1_, p_i1207_2_, p_i1207_4_, p_i1207_6_);
/* 292 */     this.field_70159_w = p_i1207_8_;
/* 293 */     this.field_70181_x = p_i1207_10_;
/* 294 */     this.field_70179_y = p_i1207_12_;
/* 295 */     this.field_92047_az = p_i1207_14_;
/*     */     
/* 297 */     this.field_70544_f *= 0.75F;
/*     */     
/* 299 */     this.field_70547_e = 48 + this.field_70146_Z.nextInt(12);
/* 300 */     this.field_70145_X = false;
/*     */   }
/*     */   
/*     */   public void func_92045_e(boolean p_92045_1_) {
/* 304 */     this.field_92054_ax = p_92045_1_;
/*     */   }
/*     */   
/*     */   public void func_92043_f(boolean p_92043_1_) {
/* 308 */     this.field_92048_ay = p_92043_1_;
/*     */   }
/*     */   
/*     */   public void func_92044_a(int p_92044_1_) {
/* 312 */     float f1 = ((p_92044_1_ & 0xFF0000) >> 16) / 255.0F;
/* 313 */     float f2 = ((p_92044_1_ & 0xFF00) >> 8) / 255.0F;
/* 314 */     float f3 = ((p_92044_1_ & 0xFF) >> 0) / 255.0F;
/* 315 */     float f4 = 1.0F;
/* 316 */     func_70538_b(f1 * f4, f2 * f4, f3 * f4);
/*     */   }
/*     */   
/*     */   public void func_92046_g(int p_92046_1_) {
/* 320 */     this.field_92050_aA = ((p_92046_1_ & 0xFF0000) >> 16) / 255.0F;
/* 321 */     this.field_92051_aB = ((p_92046_1_ & 0xFF00) >> 8) / 255.0F;
/* 322 */     this.field_92052_aC = ((p_92046_1_ & 0xFF) >> 0) / 255.0F;
/* 323 */     this.field_92053_aD = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/* 328 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/* 333 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 338 */     if (!this.field_92048_ay || this.field_70546_d < this.field_70547_e / 3 || (this.field_70546_d + this.field_70547_e) / 3 % 2 == 0) {
/* 339 */       super.func_70539_a(p_70539_1_, p_70539_2_, p_70539_3_, p_70539_4_, p_70539_5_, p_70539_6_, p_70539_7_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 345 */     this.field_70169_q = this.field_70165_t;
/* 346 */     this.field_70167_r = this.field_70163_u;
/* 347 */     this.field_70166_s = this.field_70161_v;
/*     */     
/* 349 */     if (this.field_70546_d++ >= this.field_70547_e) func_70106_y(); 
/* 350 */     if (this.field_70546_d > this.field_70547_e / 2) {
/* 351 */       func_82338_g(1.0F - (this.field_70546_d - (this.field_70547_e / 2)) / this.field_70547_e);
/*     */       
/* 353 */       if (this.field_92053_aD) {
/* 354 */         this.field_70552_h += (this.field_92050_aA - this.field_70552_h) * 0.2F;
/* 355 */         this.field_70553_i += (this.field_92051_aB - this.field_70553_i) * 0.2F;
/* 356 */         this.field_70551_j += (this.field_92052_aC - this.field_70551_j) * 0.2F;
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     func_70536_a(this.field_92049_a + 7 - this.field_70546_d * 8 / this.field_70547_e);
/*     */     
/* 362 */     this.field_70181_x -= 0.004D;
/* 363 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 364 */     this.field_70159_w *= 0.9100000262260437D;
/* 365 */     this.field_70181_x *= 0.9100000262260437D;
/* 366 */     this.field_70179_y *= 0.9100000262260437D;
/*     */     
/* 368 */     if (this.field_70122_E) {
/* 369 */       this.field_70159_w *= 0.699999988079071D;
/* 370 */       this.field_70179_y *= 0.699999988079071D;
/*     */     } 
/*     */     
/* 373 */     if (this.field_92054_ax && this.field_70546_d < this.field_70547_e / 2 && (this.field_70546_d + this.field_70547_e) % 2 == 0) {
/* 374 */       EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, this.field_92047_az);
/* 375 */       entityFireworkSparkFX.func_70538_b(this.field_70552_h, this.field_70553_i, this.field_70551_j);
/* 376 */       entityFireworkSparkFX.field_70546_d = entityFireworkSparkFX.field_70547_e / 2;
/* 377 */       if (this.field_92053_aD) {
/* 378 */         entityFireworkSparkFX.field_92053_aD = true;
/* 379 */         entityFireworkSparkFX.field_92050_aA = this.field_92050_aA;
/* 380 */         entityFireworkSparkFX.field_92051_aB = this.field_92051_aB;
/* 381 */         entityFireworkSparkFX.field_92052_aC = this.field_92052_aC;
/*     */       } 
/* 383 */       entityFireworkSparkFX.field_92048_ay = this.field_92048_ay;
/* 384 */       this.field_92047_az.func_78873_a(entityFireworkSparkFX);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70070_b(float p_70070_1_) {
/* 394 */     return 15728880;
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/* 399 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFireworkSparkFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */