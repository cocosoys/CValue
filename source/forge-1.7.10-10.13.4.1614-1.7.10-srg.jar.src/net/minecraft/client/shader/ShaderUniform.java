/*     */ package net.minecraft.client.shader;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import javax.vecmath.Matrix4f;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.BufferUtils;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ShaderUniform
/*     */ {
/*  16 */   private static final Logger field_148104_a = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   private int field_148102_b;
/*     */ 
/*     */   
/*     */   private final int field_148103_c;
/*     */ 
/*     */   
/*     */   private final int field_148100_d;
/*     */ 
/*     */   
/*     */   private final IntBuffer field_148101_e;
/*     */ 
/*     */   
/*     */   private final FloatBuffer field_148098_f;
/*     */ 
/*     */   
/*     */   private final String field_148099_g;
/*     */ 
/*     */   
/*     */   private boolean field_148105_h;
/*     */ 
/*     */   
/*     */   private final ShaderManager field_148106_i;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001046";
/*     */ 
/*     */   
/*     */   public ShaderUniform(String p_i45092_1_, int p_i45092_2_, int p_i45092_3_, ShaderManager p_i45092_4_) {
/*  47 */     this.field_148099_g = p_i45092_1_;
/*  48 */     this.field_148103_c = p_i45092_3_;
/*  49 */     this.field_148100_d = p_i45092_2_;
/*  50 */     this.field_148106_i = p_i45092_4_;
/*  51 */     if (p_i45092_2_ <= 3) {
/*  52 */       this.field_148101_e = BufferUtils.createIntBuffer(p_i45092_3_);
/*  53 */       this.field_148098_f = null;
/*     */     } else {
/*  55 */       this.field_148101_e = null;
/*  56 */       this.field_148098_f = BufferUtils.createFloatBuffer(p_i45092_3_);
/*     */     } 
/*  58 */     this.field_148102_b = -1;
/*  59 */     func_148096_h();
/*     */   }
/*     */   
/*     */   private void func_148096_h() {
/*  63 */     this.field_148105_h = true;
/*  64 */     if (this.field_148106_i != null) {
/*  65 */       this.field_148106_i.func_147985_d();
/*     */     }
/*     */   }
/*     */   
/*     */   public static int func_148085_a(String p_148085_0_) {
/*  70 */     byte b = -1;
/*     */     
/*  72 */     if (p_148085_0_.equals("int")) {
/*  73 */       b = 0;
/*  74 */     } else if (p_148085_0_.equals("float")) {
/*  75 */       b = 4;
/*  76 */     } else if (p_148085_0_.startsWith("matrix")) {
/*  77 */       if (p_148085_0_.endsWith("2x2")) {
/*  78 */         b = 8;
/*  79 */       } else if (p_148085_0_.endsWith("3x3")) {
/*  80 */         b = 9;
/*  81 */       } else if (p_148085_0_.endsWith("4x4")) {
/*  82 */         b = 10;
/*     */       } 
/*     */     } 
/*     */     
/*  86 */     return b;
/*     */   }
/*     */   
/*     */   public void func_148084_b(int p_148084_1_) {
/*  90 */     this.field_148102_b = p_148084_1_;
/*     */   }
/*     */   
/*     */   public String func_148086_a() {
/*  94 */     return this.field_148099_g;
/*     */   }
/*     */   
/*     */   public void func_148090_a(float p_148090_1_) {
/*  98 */     this.field_148098_f.position(0);
/*  99 */     this.field_148098_f.put(0, p_148090_1_);
/* 100 */     func_148096_h();
/*     */   }
/*     */   
/*     */   public void func_148087_a(float p_148087_1_, float p_148087_2_) {
/* 104 */     this.field_148098_f.position(0);
/* 105 */     this.field_148098_f.put(0, p_148087_1_);
/* 106 */     this.field_148098_f.put(1, p_148087_2_);
/* 107 */     func_148096_h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148095_a(float p_148095_1_, float p_148095_2_, float p_148095_3_) {
/* 124 */     this.field_148098_f.position(0);
/* 125 */     this.field_148098_f.put(0, p_148095_1_);
/* 126 */     this.field_148098_f.put(1, p_148095_2_);
/* 127 */     this.field_148098_f.put(2, p_148095_3_);
/* 128 */     func_148096_h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148081_a(float p_148081_1_, float p_148081_2_, float p_148081_3_, float p_148081_4_) {
/* 140 */     this.field_148098_f.position(0);
/* 141 */     this.field_148098_f.put(p_148081_1_);
/* 142 */     this.field_148098_f.put(p_148081_2_);
/* 143 */     this.field_148098_f.put(p_148081_3_);
/* 144 */     this.field_148098_f.put(p_148081_4_);
/* 145 */     this.field_148098_f.flip();
/* 146 */     func_148096_h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148092_b(float p_148092_1_, float p_148092_2_, float p_148092_3_, float p_148092_4_) {
/* 159 */     this.field_148098_f.position(0);
/* 160 */     if (this.field_148100_d >= 4) {
/* 161 */       this.field_148098_f.put(0, p_148092_1_);
/*     */     }
/* 163 */     if (this.field_148100_d >= 5) {
/* 164 */       this.field_148098_f.put(1, p_148092_2_);
/*     */     }
/* 166 */     if (this.field_148100_d >= 6) {
/* 167 */       this.field_148098_f.put(2, p_148092_3_);
/*     */     }
/* 169 */     if (this.field_148100_d >= 7) {
/* 170 */       this.field_148098_f.put(3, p_148092_4_);
/*     */     }
/* 172 */     func_148096_h();
/*     */   }
/*     */   
/*     */   public void func_148083_a(int p_148083_1_, int p_148083_2_, int p_148083_3_, int p_148083_4_) {
/* 176 */     this.field_148101_e.position(0);
/* 177 */     if (this.field_148100_d >= 0) {
/* 178 */       this.field_148101_e.put(0, p_148083_1_);
/*     */     }
/* 180 */     if (this.field_148100_d >= 1) {
/* 181 */       this.field_148101_e.put(1, p_148083_2_);
/*     */     }
/* 183 */     if (this.field_148100_d >= 2) {
/* 184 */       this.field_148101_e.put(2, p_148083_3_);
/*     */     }
/* 186 */     if (this.field_148100_d >= 3) {
/* 187 */       this.field_148101_e.put(3, p_148083_4_);
/*     */     }
/* 189 */     func_148096_h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148097_a(float[] p_148097_1_) {
/* 223 */     if (p_148097_1_.length < this.field_148103_c) {
/* 224 */       field_148104_a.warn("Uniform.set called with a too-small value array (expected " + this.field_148103_c + ", got " + p_148097_1_.length + "). Ignoring.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 229 */     this.field_148098_f.position(0);
/* 230 */     this.field_148098_f.put(p_148097_1_);
/* 231 */     this.field_148098_f.position(0);
/* 232 */     func_148096_h();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148094_a(float p_148094_1_, float p_148094_2_, float p_148094_3_, float p_148094_4_, float p_148094_5_, float p_148094_6_, float p_148094_7_, float p_148094_8_, float p_148094_9_, float p_148094_10_, float p_148094_11_, float p_148094_12_, float p_148094_13_, float p_148094_14_, float p_148094_15_, float p_148094_16_) {
/* 358 */     this.field_148098_f.position(0);
/* 359 */     this.field_148098_f.put(0, p_148094_1_);
/* 360 */     this.field_148098_f.put(1, p_148094_2_);
/* 361 */     this.field_148098_f.put(2, p_148094_3_);
/* 362 */     this.field_148098_f.put(3, p_148094_4_);
/* 363 */     this.field_148098_f.put(4, p_148094_5_);
/* 364 */     this.field_148098_f.put(5, p_148094_6_);
/* 365 */     this.field_148098_f.put(6, p_148094_7_);
/* 366 */     this.field_148098_f.put(7, p_148094_8_);
/* 367 */     this.field_148098_f.put(8, p_148094_9_);
/* 368 */     this.field_148098_f.put(9, p_148094_10_);
/* 369 */     this.field_148098_f.put(10, p_148094_11_);
/* 370 */     this.field_148098_f.put(11, p_148094_12_);
/* 371 */     this.field_148098_f.put(12, p_148094_13_);
/* 372 */     this.field_148098_f.put(13, p_148094_14_);
/* 373 */     this.field_148098_f.put(14, p_148094_15_);
/* 374 */     this.field_148098_f.put(15, p_148094_16_);
/* 375 */     func_148096_h();
/*     */   }
/*     */   
/*     */   public void func_148088_a(Matrix4f p_148088_1_) {
/* 379 */     func_148094_a(p_148088_1_.m00, p_148088_1_.m01, p_148088_1_.m02, p_148088_1_.m03, p_148088_1_.m10, p_148088_1_.m11, p_148088_1_.m12, p_148088_1_.m13, p_148088_1_.m20, p_148088_1_.m21, p_148088_1_.m22, p_148088_1_.m23, p_148088_1_.m30, p_148088_1_.m31, p_148088_1_.m32, p_148088_1_.m33);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_148093_b() {
/* 386 */     if (!this.field_148105_h);
/*     */ 
/*     */ 
/*     */     
/* 390 */     this.field_148105_h = false;
/*     */     
/* 392 */     if (this.field_148100_d <= 3) {
/* 393 */       func_148091_i();
/* 394 */     } else if (this.field_148100_d <= 7) {
/* 395 */       func_148089_j();
/* 396 */     } else if (this.field_148100_d <= 10) {
/* 397 */       func_148082_k();
/*     */     } else {
/* 399 */       field_148104_a.warn("Uniform.upload called, but type value (" + this.field_148100_d + ") is not " + "a valid type. Ignoring.");
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_148091_i() {
/* 405 */     switch (this.field_148100_d) {
/*     */       case 0:
/* 407 */         OpenGlHelper.func_153181_a(this.field_148102_b, this.field_148101_e);
/*     */         return;
/*     */       case 1:
/* 410 */         OpenGlHelper.func_153182_b(this.field_148102_b, this.field_148101_e);
/*     */         return;
/*     */       case 2:
/* 413 */         OpenGlHelper.func_153192_c(this.field_148102_b, this.field_148101_e);
/*     */         return;
/*     */       case 3:
/* 416 */         OpenGlHelper.func_153162_d(this.field_148102_b, this.field_148101_e);
/*     */         return;
/*     */     } 
/* 419 */     field_148104_a.warn("Uniform.upload called, but count value (" + this.field_148103_c + ") is " + " not in the range of 1 to 4. Ignoring.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_148089_j() {
/* 425 */     switch (this.field_148100_d) {
/*     */       case 4:
/* 427 */         OpenGlHelper.func_153168_a(this.field_148102_b, this.field_148098_f);
/*     */         return;
/*     */       case 5:
/* 430 */         OpenGlHelper.func_153177_b(this.field_148102_b, this.field_148098_f);
/*     */         return;
/*     */       case 6:
/* 433 */         OpenGlHelper.func_153191_c(this.field_148102_b, this.field_148098_f);
/*     */         return;
/*     */       case 7:
/* 436 */         OpenGlHelper.func_153159_d(this.field_148102_b, this.field_148098_f);
/*     */         return;
/*     */     } 
/* 439 */     field_148104_a.warn("Uniform.upload called, but count value (" + this.field_148103_c + ") is " + "not in the range of 1 to 4. Ignoring.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_148082_k() {
/* 445 */     switch (this.field_148100_d) {
/*     */       case 8:
/* 447 */         OpenGlHelper.func_153173_a(this.field_148102_b, true, this.field_148098_f);
/*     */         break;
/*     */       case 9:
/* 450 */         OpenGlHelper.func_153189_b(this.field_148102_b, true, this.field_148098_f);
/*     */         break;
/*     */       case 10:
/* 453 */         OpenGlHelper.func_153160_c(this.field_148102_b, true, this.field_148098_f);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\shader\ShaderUniform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */