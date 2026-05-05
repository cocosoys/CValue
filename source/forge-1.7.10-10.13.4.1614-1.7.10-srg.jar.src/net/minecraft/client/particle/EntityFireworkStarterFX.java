/*     */ package net.minecraft.client.particle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityFireworkStarterFX
/*     */   extends EntityFX {
/*     */   private int field_92042_ax;
/*     */   private final EffectRenderer field_92040_ay;
/*     */   private NBTTagList field_92039_az;
/*     */   boolean field_92041_a;
/*     */   private static final String __OBFID = "CL_00000906";
/*     */   
/*     */   public EntityFireworkStarterFX(World p_i1208_1_, double p_i1208_2_, double p_i1208_4_, double p_i1208_6_, double p_i1208_8_, double p_i1208_10_, double p_i1208_12_, EffectRenderer p_i1208_14_, NBTTagCompound p_i1208_15_) {
/*  22 */     super(p_i1208_1_, p_i1208_2_, p_i1208_4_, p_i1208_6_, 0.0D, 0.0D, 0.0D);
/*  23 */     this.field_70159_w = p_i1208_8_;
/*  24 */     this.field_70181_x = p_i1208_10_;
/*  25 */     this.field_70179_y = p_i1208_12_;
/*  26 */     this.field_92040_ay = p_i1208_14_;
/*  27 */     this.field_70547_e = 8;
/*     */     
/*  29 */     if (p_i1208_15_ != null) {
/*  30 */       this.field_92039_az = p_i1208_15_.func_150295_c("Explosions", 10);
/*  31 */       if (this.field_92039_az.func_74745_c() == 0) {
/*  32 */         this.field_92039_az = null;
/*     */       } else {
/*  34 */         this.field_70547_e = this.field_92039_az.func_74745_c() * 2 - 1;
/*     */ 
/*     */         
/*  37 */         for (byte b = 0; b < this.field_92039_az.func_74745_c(); b++) {
/*  38 */           NBTTagCompound nBTTagCompound = this.field_92039_az.func_150305_b(b);
/*  39 */           if (nBTTagCompound.func_74767_n("Flicker")) {
/*  40 */             this.field_92041_a = true;
/*  41 */             this.field_70547_e += 15;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70539_a(Tessellator p_70539_1_, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  57 */     if (this.field_92042_ax == 0 && this.field_92039_az != null) {
/*  58 */       boolean bool = func_92037_i();
/*     */       
/*  60 */       boolean bool1 = false;
/*  61 */       if (this.field_92039_az.func_74745_c() >= 3) {
/*  62 */         bool1 = true;
/*     */       } else {
/*  64 */         for (byte b = 0; b < this.field_92039_az.func_74745_c(); b++) {
/*  65 */           NBTTagCompound nBTTagCompound = this.field_92039_az.func_150305_b(b);
/*  66 */           if (nBTTagCompound.func_74771_c("Type") == 1) {
/*  67 */             bool1 = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*  73 */       String str = "fireworks." + (bool1 ? "largeBlast" : "blast") + (bool ? "_far" : "");
/*  74 */       this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, str, 20.0F, 0.95F + this.field_70146_Z.nextFloat() * 0.1F, true);
/*     */     } 
/*     */     
/*  77 */     if (this.field_92042_ax % 2 == 0 && this.field_92039_az != null && this.field_92042_ax / 2 < this.field_92039_az.func_74745_c()) {
/*     */ 
/*     */       
/*  80 */       int i = this.field_92042_ax / 2;
/*  81 */       NBTTagCompound nBTTagCompound = this.field_92039_az.func_150305_b(i);
/*     */       
/*  83 */       byte b = nBTTagCompound.func_74771_c("Type");
/*  84 */       boolean bool1 = nBTTagCompound.func_74767_n("Trail");
/*  85 */       boolean bool2 = nBTTagCompound.func_74767_n("Flicker");
/*  86 */       int[] arrayOfInt1 = nBTTagCompound.func_74759_k("Colors");
/*  87 */       int[] arrayOfInt2 = nBTTagCompound.func_74759_k("FadeColors");
/*     */       
/*  89 */       if (b == 1) {
/*     */         
/*  91 */         func_92035_a(0.5D, 4, arrayOfInt1, arrayOfInt2, bool1, bool2);
/*  92 */       } else if (b == 2) {
/*     */         
/*  94 */         func_92038_a(0.5D, new double[][] { { 0.0D, 1.0D }, , { 0.3455D, 0.309D }, , { 0.9511D, 0.309D }, , { 0.3795918367346939D, -0.12653061224489795D }, , { 0.6122448979591837D, -0.8040816326530612D }, , { 0.0D, -0.35918367346938773D },  }, arrayOfInt1, arrayOfInt2, bool1, bool2, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 109 */       else if (b == 3) {
/*     */         
/* 111 */         func_92038_a(0.5D, new double[][] { { 0.0D, 0.2D }, , { 0.2D, 0.2D }, , { 0.2D, 0.6D }, , { 0.6D, 0.6D }, , { 0.6D, 0.2D }, , { 0.2D, 0.2D }, , { 0.2D, 0.0D }, , { 0.4D, 0.0D }, , { 0.4D, -0.6D }, , { 0.2D, -0.6D }, , { 0.2D, -0.4D }, , { 0.0D, -0.4D },  }, arrayOfInt1, arrayOfInt2, bool1, bool2, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 138 */       else if (b == 4) {
/* 139 */         func_92036_a(arrayOfInt1, arrayOfInt2, bool1, bool2);
/*     */       } else {
/*     */         
/* 142 */         func_92035_a(0.25D, 2, arrayOfInt1, arrayOfInt2, bool1, bool2);
/*     */       } 
/*     */       
/* 145 */       int j = arrayOfInt1[0];
/* 146 */       float f1 = ((j & 0xFF0000) >> 16) / 255.0F;
/* 147 */       float f2 = ((j & 0xFF00) >> 8) / 255.0F;
/* 148 */       float f3 = ((j & 0xFF) >> 0) / 255.0F;
/* 149 */       EntityFireworkOverlayFX entityFireworkOverlayFX = new EntityFireworkOverlayFX(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 150 */       entityFireworkOverlayFX.func_70538_b(f1, f2, f3);
/* 151 */       this.field_92040_ay.func_78873_a(entityFireworkOverlayFX);
/*     */     } 
/*     */     
/* 154 */     this.field_92042_ax++;
/* 155 */     if (this.field_92042_ax > this.field_70547_e) {
/* 156 */       if (this.field_92041_a) {
/* 157 */         boolean bool = func_92037_i();
/* 158 */         String str = "fireworks." + (bool ? "twinkle_far" : "twinkle");
/* 159 */         this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, str, 20.0F, 0.9F + this.field_70146_Z.nextFloat() * 0.15F, true);
/*     */       } 
/*     */       
/* 162 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_92037_i() {
/* 167 */     Minecraft minecraft = Minecraft.func_71410_x();
/* 168 */     if (minecraft != null && minecraft.field_71451_h != null && 
/* 169 */       minecraft.field_71451_h.func_70092_e(this.field_70165_t, this.field_70163_u, this.field_70161_v) < 256.0D) {
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     return true;
/*     */   }
/*     */   
/*     */   private void func_92034_a(double p_92034_1_, double p_92034_3_, double p_92034_5_, double p_92034_7_, double p_92034_9_, double p_92034_11_, int[] p_92034_13_, int[] p_92034_14_, boolean p_92034_15_, boolean p_92034_16_) {
/* 177 */     EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(this.field_70170_p, p_92034_1_, p_92034_3_, p_92034_5_, p_92034_7_, p_92034_9_, p_92034_11_, this.field_92040_ay);
/* 178 */     entityFireworkSparkFX.func_92045_e(p_92034_15_);
/* 179 */     entityFireworkSparkFX.func_92043_f(p_92034_16_);
/*     */     
/* 181 */     int i = this.field_70146_Z.nextInt(p_92034_13_.length);
/* 182 */     entityFireworkSparkFX.func_92044_a(p_92034_13_[i]);
/* 183 */     if (p_92034_14_ != null && p_92034_14_.length > 0) {
/* 184 */       entityFireworkSparkFX.func_92046_g(p_92034_14_[this.field_70146_Z.nextInt(p_92034_14_.length)]);
/*     */     }
/* 186 */     this.field_92040_ay.func_78873_a(entityFireworkSparkFX);
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_92035_a(double p_92035_1_, int p_92035_3_, int[] p_92035_4_, int[] p_92035_5_, boolean p_92035_6_, boolean p_92035_7_) {
/* 191 */     double d1 = this.field_70165_t;
/* 192 */     double d2 = this.field_70163_u;
/* 193 */     double d3 = this.field_70161_v;
/*     */     
/* 195 */     for (int i = -p_92035_3_; i <= p_92035_3_; i++) {
/* 196 */       for (int j = -p_92035_3_; j <= p_92035_3_; j++) {
/* 197 */         for (int k = -p_92035_3_; k <= p_92035_3_; k++) {
/* 198 */           double d4 = j + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
/* 199 */           double d5 = i + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
/* 200 */           double d6 = k + (this.field_70146_Z.nextDouble() - this.field_70146_Z.nextDouble()) * 0.5D;
/* 201 */           double d7 = MathHelper.func_76133_a(d4 * d4 + d5 * d5 + d6 * d6) / p_92035_1_ + this.field_70146_Z.nextGaussian() * 0.05D;
/*     */           
/* 203 */           func_92034_a(d1, d2, d3, d4 / d7, d5 / d7, d6 / d7, p_92035_4_, p_92035_5_, p_92035_6_, p_92035_7_);
/*     */           
/* 205 */           if (i != -p_92035_3_ && i != p_92035_3_ && j != -p_92035_3_ && j != p_92035_3_) {
/* 206 */             k += p_92035_3_ * 2 - 1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_92038_a(double p_92038_1_, double[][] p_92038_3_, int[] p_92038_4_, int[] p_92038_5_, boolean p_92038_6_, boolean p_92038_7_, boolean p_92038_8_) {
/* 215 */     double d1 = p_92038_3_[0][0];
/* 216 */     double d2 = p_92038_3_[0][1];
/*     */ 
/*     */     
/* 219 */     func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d1 * p_92038_1_, d2 * p_92038_1_, 0.0D, p_92038_4_, p_92038_5_, p_92038_6_, p_92038_7_);
/*     */ 
/*     */     
/* 222 */     float f = this.field_70146_Z.nextFloat() * 3.1415927F;
/* 223 */     double d3 = p_92038_8_ ? 0.034D : 0.34D;
/* 224 */     for (byte b = 0; b < 3; b++) {
/* 225 */       double d4 = f + (b * 3.1415927F) * d3;
/*     */       
/* 227 */       double d5 = d1;
/* 228 */       double d6 = d2;
/*     */       
/* 230 */       for (byte b1 = 1; b1 < p_92038_3_.length; b1++) {
/*     */         
/* 232 */         double d7 = p_92038_3_[b1][0];
/* 233 */         double d8 = p_92038_3_[b1][1];
/*     */         double d9;
/* 235 */         for (d9 = 0.25D; d9 <= 1.0D; d9 += 0.25D) {
/*     */           
/* 237 */           double d10 = (d5 + (d7 - d5) * d9) * p_92038_1_;
/* 238 */           double d11 = (d6 + (d8 - d6) * d9) * p_92038_1_;
/*     */           
/* 240 */           double d12 = d10 * Math.sin(d4);
/* 241 */           d10 *= Math.cos(d4);
/*     */           double d13;
/* 243 */           for (d13 = -1.0D; d13 <= 1.0D; d13 += 2.0D) {
/* 244 */             func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d10 * d13, d11, d12 * d13, p_92038_4_, p_92038_5_, p_92038_6_, p_92038_7_);
/*     */           }
/*     */         } 
/* 247 */         d5 = d7;
/* 248 */         d6 = d8;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_92036_a(int[] p_92036_1_, int[] p_92036_2_, boolean p_92036_3_, boolean p_92036_4_) {
/* 257 */     double d1 = this.field_70146_Z.nextGaussian() * 0.05D;
/* 258 */     double d2 = this.field_70146_Z.nextGaussian() * 0.05D;
/*     */     
/* 260 */     for (byte b = 0; b < 70; b++) {
/*     */       
/* 262 */       double d3 = this.field_70159_w * 0.5D + this.field_70146_Z.nextGaussian() * 0.15D + d1;
/* 263 */       double d4 = this.field_70179_y * 0.5D + this.field_70146_Z.nextGaussian() * 0.15D + d2;
/* 264 */       double d5 = this.field_70181_x * 0.5D + this.field_70146_Z.nextDouble() * 0.5D;
/*     */       
/* 266 */       func_92034_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, d3, d5, d4, p_92036_1_, p_92036_2_, p_92036_3_, p_92036_4_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_70537_b() {
/* 274 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EntityFireworkStarterFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */