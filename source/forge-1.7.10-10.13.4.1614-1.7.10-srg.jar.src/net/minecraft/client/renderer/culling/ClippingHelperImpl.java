/*     */ package net.minecraft.client.renderer.culling;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.FloatBuffer;
/*     */ import net.minecraft.client.renderer.GLAllocation;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class ClippingHelperImpl
/*     */   extends ClippingHelper
/*     */ {
/*  31 */   private static ClippingHelperImpl field_78563_e = new ClippingHelperImpl();
/*     */   
/*     */   public static ClippingHelper func_78558_a() {
/*  34 */     field_78563_e.func_78560_b();
/*  35 */     return field_78563_e;
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
/*     */   private void func_78559_a(float[][] p_78559_1_, int p_78559_2_) {
/*  48 */     float f = MathHelper.func_76129_c(p_78559_1_[p_78559_2_][0] * p_78559_1_[p_78559_2_][0] + p_78559_1_[p_78559_2_][1] * p_78559_1_[p_78559_2_][1] + p_78559_1_[p_78559_2_][2] * p_78559_1_[p_78559_2_][2]);
/*     */ 
/*     */ 
/*     */     
/*  52 */     p_78559_1_[p_78559_2_][0] = p_78559_1_[p_78559_2_][0] / f;
/*  53 */     p_78559_1_[p_78559_2_][1] = p_78559_1_[p_78559_2_][1] / f;
/*  54 */     p_78559_1_[p_78559_2_][2] = p_78559_1_[p_78559_2_][2] / f;
/*  55 */     p_78559_1_[p_78559_2_][3] = p_78559_1_[p_78559_2_][3] / f;
/*     */   }
/*     */   
/*  58 */   private FloatBuffer field_78561_f = GLAllocation.func_74529_h(16);
/*  59 */   private FloatBuffer field_78562_g = GLAllocation.func_74529_h(16);
/*  60 */   private FloatBuffer field_78564_h = GLAllocation.func_74529_h(16);
/*     */   
/*     */   private void func_78560_b() {
/*  63 */     this.field_78561_f.clear();
/*  64 */     this.field_78562_g.clear();
/*  65 */     this.field_78564_h.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     GL11.glGetFloat(2983, this.field_78561_f);
/*     */ 
/*     */ 
/*     */     
/*  74 */     GL11.glGetFloat(2982, this.field_78562_g);
/*     */     
/*  76 */     this.field_78561_f.flip().limit(16);
/*  77 */     this.field_78561_f.get(this.field_78555_b);
/*  78 */     this.field_78562_g.flip().limit(16);
/*  79 */     this.field_78562_g.get(this.field_78556_c);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     this.field_78554_d[0] = this.field_78556_c[0] * this.field_78555_b[0] + this.field_78556_c[1] * this.field_78555_b[4] + this.field_78556_c[2] * this.field_78555_b[8] + this.field_78556_c[3] * this.field_78555_b[12];
/*  85 */     this.field_78554_d[1] = this.field_78556_c[0] * this.field_78555_b[1] + this.field_78556_c[1] * this.field_78555_b[5] + this.field_78556_c[2] * this.field_78555_b[9] + this.field_78556_c[3] * this.field_78555_b[13];
/*  86 */     this.field_78554_d[2] = this.field_78556_c[0] * this.field_78555_b[2] + this.field_78556_c[1] * this.field_78555_b[6] + this.field_78556_c[2] * this.field_78555_b[10] + this.field_78556_c[3] * this.field_78555_b[14];
/*  87 */     this.field_78554_d[3] = this.field_78556_c[0] * this.field_78555_b[3] + this.field_78556_c[1] * this.field_78555_b[7] + this.field_78556_c[2] * this.field_78555_b[11] + this.field_78556_c[3] * this.field_78555_b[15];
/*     */     
/*  89 */     this.field_78554_d[4] = this.field_78556_c[4] * this.field_78555_b[0] + this.field_78556_c[5] * this.field_78555_b[4] + this.field_78556_c[6] * this.field_78555_b[8] + this.field_78556_c[7] * this.field_78555_b[12];
/*  90 */     this.field_78554_d[5] = this.field_78556_c[4] * this.field_78555_b[1] + this.field_78556_c[5] * this.field_78555_b[5] + this.field_78556_c[6] * this.field_78555_b[9] + this.field_78556_c[7] * this.field_78555_b[13];
/*  91 */     this.field_78554_d[6] = this.field_78556_c[4] * this.field_78555_b[2] + this.field_78556_c[5] * this.field_78555_b[6] + this.field_78556_c[6] * this.field_78555_b[10] + this.field_78556_c[7] * this.field_78555_b[14];
/*  92 */     this.field_78554_d[7] = this.field_78556_c[4] * this.field_78555_b[3] + this.field_78556_c[5] * this.field_78555_b[7] + this.field_78556_c[6] * this.field_78555_b[11] + this.field_78556_c[7] * this.field_78555_b[15];
/*     */     
/*  94 */     this.field_78554_d[8] = this.field_78556_c[8] * this.field_78555_b[0] + this.field_78556_c[9] * this.field_78555_b[4] + this.field_78556_c[10] * this.field_78555_b[8] + this.field_78556_c[11] * this.field_78555_b[12];
/*  95 */     this.field_78554_d[9] = this.field_78556_c[8] * this.field_78555_b[1] + this.field_78556_c[9] * this.field_78555_b[5] + this.field_78556_c[10] * this.field_78555_b[9] + this.field_78556_c[11] * this.field_78555_b[13];
/*  96 */     this.field_78554_d[10] = this.field_78556_c[8] * this.field_78555_b[2] + this.field_78556_c[9] * this.field_78555_b[6] + this.field_78556_c[10] * this.field_78555_b[10] + this.field_78556_c[11] * this.field_78555_b[14];
/*  97 */     this.field_78554_d[11] = this.field_78556_c[8] * this.field_78555_b[3] + this.field_78556_c[9] * this.field_78555_b[7] + this.field_78556_c[10] * this.field_78555_b[11] + this.field_78556_c[11] * this.field_78555_b[15];
/*     */     
/*  99 */     this.field_78554_d[12] = this.field_78556_c[12] * this.field_78555_b[0] + this.field_78556_c[13] * this.field_78555_b[4] + this.field_78556_c[14] * this.field_78555_b[8] + this.field_78556_c[15] * this.field_78555_b[12];
/* 100 */     this.field_78554_d[13] = this.field_78556_c[12] * this.field_78555_b[1] + this.field_78556_c[13] * this.field_78555_b[5] + this.field_78556_c[14] * this.field_78555_b[9] + this.field_78556_c[15] * this.field_78555_b[13];
/* 101 */     this.field_78554_d[14] = this.field_78556_c[12] * this.field_78555_b[2] + this.field_78556_c[13] * this.field_78555_b[6] + this.field_78556_c[14] * this.field_78555_b[10] + this.field_78556_c[15] * this.field_78555_b[14];
/* 102 */     this.field_78554_d[15] = this.field_78556_c[12] * this.field_78555_b[3] + this.field_78556_c[13] * this.field_78555_b[7] + this.field_78556_c[14] * this.field_78555_b[11] + this.field_78556_c[15] * this.field_78555_b[15];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     this.field_78557_a[0][0] = this.field_78554_d[3] - this.field_78554_d[0];
/* 109 */     this.field_78557_a[0][1] = this.field_78554_d[7] - this.field_78554_d[4];
/* 110 */     this.field_78557_a[0][2] = this.field_78554_d[11] - this.field_78554_d[8];
/* 111 */     this.field_78557_a[0][3] = this.field_78554_d[15] - this.field_78554_d[12];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     func_78559_a(this.field_78557_a, 0);
/*     */ 
/*     */     
/* 120 */     this.field_78557_a[1][0] = this.field_78554_d[3] + this.field_78554_d[0];
/* 121 */     this.field_78557_a[1][1] = this.field_78554_d[7] + this.field_78554_d[4];
/* 122 */     this.field_78557_a[1][2] = this.field_78554_d[11] + this.field_78554_d[8];
/* 123 */     this.field_78557_a[1][3] = this.field_78554_d[15] + this.field_78554_d[12];
/*     */ 
/*     */     
/* 126 */     func_78559_a(this.field_78557_a, 1);
/*     */ 
/*     */     
/* 129 */     this.field_78557_a[2][0] = this.field_78554_d[3] + this.field_78554_d[1];
/* 130 */     this.field_78557_a[2][1] = this.field_78554_d[7] + this.field_78554_d[5];
/* 131 */     this.field_78557_a[2][2] = this.field_78554_d[11] + this.field_78554_d[9];
/* 132 */     this.field_78557_a[2][3] = this.field_78554_d[15] + this.field_78554_d[13];
/*     */ 
/*     */     
/* 135 */     func_78559_a(this.field_78557_a, 2);
/*     */ 
/*     */     
/* 138 */     this.field_78557_a[3][0] = this.field_78554_d[3] - this.field_78554_d[1];
/* 139 */     this.field_78557_a[3][1] = this.field_78554_d[7] - this.field_78554_d[5];
/* 140 */     this.field_78557_a[3][2] = this.field_78554_d[11] - this.field_78554_d[9];
/* 141 */     this.field_78557_a[3][3] = this.field_78554_d[15] - this.field_78554_d[13];
/*     */ 
/*     */     
/* 144 */     func_78559_a(this.field_78557_a, 3);
/*     */ 
/*     */     
/* 147 */     this.field_78557_a[4][0] = this.field_78554_d[3] - this.field_78554_d[2];
/* 148 */     this.field_78557_a[4][1] = this.field_78554_d[7] - this.field_78554_d[6];
/* 149 */     this.field_78557_a[4][2] = this.field_78554_d[11] - this.field_78554_d[10];
/* 150 */     this.field_78557_a[4][3] = this.field_78554_d[15] - this.field_78554_d[14];
/*     */ 
/*     */     
/* 153 */     func_78559_a(this.field_78557_a, 4);
/*     */ 
/*     */     
/* 156 */     this.field_78557_a[5][0] = this.field_78554_d[3] + this.field_78554_d[2];
/* 157 */     this.field_78557_a[5][1] = this.field_78554_d[7] + this.field_78554_d[6];
/* 158 */     this.field_78557_a[5][2] = this.field_78554_d[11] + this.field_78554_d[10];
/* 159 */     this.field_78557_a[5][3] = this.field_78554_d[15] + this.field_78554_d[14];
/*     */ 
/*     */     
/* 162 */     func_78559_a(this.field_78557_a, 5);
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000975";
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\culling\ClippingHelperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */