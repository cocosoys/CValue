/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGodRumsshi
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer tail;
/*     */   public ModelRenderer Trunk1;
/*     */   public ModelRenderer TuskR1;
/*     */   public ModelRenderer TuskL1;
/*     */   public ModelRenderer EarR1;
/*     */   public ModelRenderer EarL1;
/*     */   public ModelRenderer Trunk2;
/*     */   public ModelRenderer Trunk3;
/*     */   public ModelRenderer Trunk4;
/*     */   public ModelRenderer TuskR2;
/*     */   public ModelRenderer TuskR3;
/*     */   public ModelRenderer TuskL2;
/*     */   public ModelRenderer TuskL3;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarR3;
/*     */   public ModelRenderer EarL2;
/*     */   public ModelRenderer Earing;
/*     */   public ModelRenderer EarL3;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ArmR_1;
/*     */   public ModelRenderer ArmL_1;
/*     */   public ModelRenderer tail_1;
/*     */   public ModelRenderer tail_2;
/*     */   public ModelRenderer tail_3;
/*     */   public ModelRenderer tail_4;
/*     */   
/*     */   public ModelGodRumsshi() {
/*  51 */     this.field_78090_t = 64;
/*  52 */     this.field_78089_u = 64;
/*  53 */     this.ArmL = new ModelRenderer(this, 49, 18);
/*  54 */     this.ArmL.field_78809_i = true;
/*  55 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  56 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 10, 4, 0.0F);
/*  57 */     this.Trunk3 = new ModelRenderer(this, 24, 48);
/*  58 */     this.Trunk3.func_78793_a(0.0F, 0.0F, -1.5F);
/*  59 */     this.Trunk3.func_78790_a(-0.9F, -0.8F, -2.9F, 2, 3, 3, 0.0F);
/*  60 */     setRotateAngle(this.Trunk3, 0.22759093F, 0.0F, 0.0F);
/*  61 */     this.Head = new ModelRenderer(this, 0, 0);
/*  62 */     this.Head.func_78793_a(0.0F, -1.2F, 0.0F);
/*  63 */     this.Head.func_78790_a(-3.5F, -7.0F, -4.3F, 7, 7, 8, 0.0F);
/*  64 */     this.ArmR = new ModelRenderer(this, 49, 18);
/*  65 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  66 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 10, 4, 0.0F);
/*  67 */     this.tail_2 = new ModelRenderer(this, 38, 1);
/*  68 */     this.tail_2.func_78793_a(0.0F, 2.6F, 0.0F);
/*  69 */     this.tail_2.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  70 */     setRotateAngle(this.tail_2, -0.18203785F, 0.0F, 0.0F);
/*  71 */     this.tail_4 = new ModelRenderer(this, 43, 1);
/*  72 */     this.tail_4.func_78793_a(0.0F, 2.6F, 0.0F);
/*  73 */     this.tail_4.func_78790_a(-1.0F, -0.1F, -0.5F, 2, 2, 1, 0.0F);
/*  74 */     setRotateAngle(this.tail_4, 0.27314404F, 0.0F, 0.0F);
/*  75 */     this.EarL1 = new ModelRenderer(this, 24, 54);
/*  76 */     this.EarL1.field_78809_i = true;
/*  77 */     this.EarL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.EarL1.func_78790_a(-4.5F, -7.7F, -1.4F, 6, 2, 1, 0.0F);
/*  79 */     setRotateAngle(this.EarL1, 0.0F, 0.091106184F, 1.0471976F);
/*  80 */     this.Body3 = new ModelRenderer(this, 21, 38);
/*  81 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Body3.func_78790_a(-3.5F, 8.0F, -2.9F, 7, 4, 5, 0.0F);
/*  83 */     this.EarR3 = new ModelRenderer(this, 24, 60);
/*  84 */     this.EarR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.EarR3.func_78790_a(-1.9F, -4.2F, -2.0F, 4, 2, 1, 0.0F);
/*  86 */     setRotateAngle(this.EarR3, 0.0F, 0.0F, -0.19128808F);
/*  87 */     this.tail_1 = new ModelRenderer(this, 38, 1);
/*  88 */     this.tail_1.func_78793_a(0.0F, 2.6F, 0.0F);
/*  89 */     this.tail_1.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/*  90 */     setRotateAngle(this.tail_1, -0.18203785F, 0.0F, 0.0F);
/*  91 */     this.EarL2 = new ModelRenderer(this, 24, 57);
/*  92 */     this.EarL2.field_78809_i = true;
/*  93 */     this.EarL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.EarL2.func_78790_a(-4.1F, -6.0F, -1.6F, 6, 2, 1, 0.0F);
/*  95 */     setRotateAngle(this.EarL2, 0.0F, 0.0F, 0.073303826F);
/*  96 */     this.EarR2 = new ModelRenderer(this, 24, 57);
/*  97 */     this.EarR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.EarR2.func_78790_a(-2.1F, -5.8F, -1.6F, 6, 2, 1, 0.0F);
/*  99 */     setRotateAngle(this.EarR2, 0.0F, 0.0F, -0.073303826F);
/* 100 */     this.tail_3 = new ModelRenderer(this, 38, 1);
/* 101 */     this.tail_3.func_78793_a(0.0F, 2.6F, 0.0F);
/* 102 */     this.tail_3.func_78790_a(-0.5F, -0.1F, -0.5F, 1, 3, 1, 0.0F);
/* 103 */     setRotateAngle(this.tail_3, 0.27314404F, 0.0F, 0.0F);
/* 104 */     this.LegL = new ModelRenderer(this, 0, 33);
/* 105 */     this.LegL.field_78809_i = true;
/* 106 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/* 107 */     this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/* 108 */     this.ArmL_1 = new ModelRenderer(this, 46, 33);
/* 109 */     this.ArmL_1.field_78809_i = true;
/* 110 */     this.ArmL_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.ArmL_1.func_78790_a(-1.5F, 8.0F, -2.3F, 4, 3, 5, 0.0F);
/* 112 */     this.LegL2 = new ModelRenderer(this, 0, 16);
/* 113 */     this.LegL2.field_78809_i = true;
/* 114 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 116 */     this.TuskR1 = new ModelRenderer(this, 1, 54);
/* 117 */     this.TuskR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.TuskR1.func_78790_a(-1.9F, -0.1F, -5.8F, 2, 3, 2, 0.0F);
/* 119 */     setRotateAngle(this.TuskR1, -0.68294734F, 0.18203785F, 0.0F);
/* 120 */     this.TuskR2 = new ModelRenderer(this, 10, 54);
/* 121 */     this.TuskR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.TuskR2.func_78790_a(-1.6F, 2.8F, -5.7F, 1, 3, 2, 0.0F);
/* 123 */     this.Body2 = new ModelRenderer(this, 23, 29);
/* 124 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.Body2.func_78790_a(-3.5F, 5.0F, -3.1F, 7, 3, 5, 0.0F);
/* 126 */     this.Trunk4 = new ModelRenderer(this, 35, 48);
/* 127 */     this.Trunk4.func_78793_a(0.0F, 0.4F, -2.5F);
/* 128 */     this.Trunk4.func_78790_a(-0.9F, -0.8F, -2.6F, 2, 2, 3, 0.0F);
/* 129 */     setRotateAngle(this.Trunk4, -0.5009095F, 0.0F, 0.0F);
/* 130 */     this.Cloth1 = new ModelRenderer(this, 54, 0);
/* 131 */     this.Cloth1.func_78793_a(0.0F, 9.9F, -2.7F);
/* 132 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.3F, 5, 10, 0, 0.0F);
/* 133 */     setRotateAngle(this.Cloth1, -0.04712389F, 0.0F, 0.0F);
/* 134 */     this.TuskL2 = new ModelRenderer(this, 10, 54);
/* 135 */     this.TuskL2.field_78809_i = true;
/* 136 */     this.TuskL2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.TuskL2.func_78790_a(0.6F, 2.8F, -5.7F, 1, 3, 2, 0.0F);
/* 138 */     this.TuskL1 = new ModelRenderer(this, 1, 54);
/* 139 */     this.TuskL1.field_78809_i = true;
/* 140 */     this.TuskL1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.TuskL1.func_78790_a(-0.1F, -0.1F, -5.8F, 2, 3, 2, 0.0F);
/* 142 */     setRotateAngle(this.TuskL1, -0.68294734F, -0.18203785F, 0.0F);
/* 143 */     this.LegR2 = new ModelRenderer(this, 0, 16);
/* 144 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 146 */     this.Neck = new ModelRenderer(this, 42, 6);
/* 147 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.Neck.func_78790_a(-2.0F, -1.6F, -0.8F, 4, 2, 2, 0.0F);
/* 149 */     this.LegR = new ModelRenderer(this, 0, 33);
/* 150 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/* 151 */     this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/* 152 */     this.Trunk2 = new ModelRenderer(this, 13, 49);
/* 153 */     this.Trunk2.func_78793_a(0.0F, 0.2F, -2.4F);
/* 154 */     this.Trunk2.func_78790_a(-1.5F, -0.8F, -1.7F, 3, 3, 2, 0.0F);
/* 155 */     setRotateAngle(this.Trunk2, 0.4098033F, 0.0F, 0.0F);
/* 156 */     this.Earing = new ModelRenderer(this, 28, 0);
/* 157 */     this.Earing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.Earing.func_78790_a(-1.0F, -7.9F, -1.9F, 1, 1, 2, 0.0F);
/* 159 */     this.tail = new ModelRenderer(this, 38, 1);
/* 160 */     this.tail.func_78793_a(0.0F, 10.3F, 1.9F);
/* 161 */     this.tail.func_78790_a(-0.5F, -0.3F, -0.5F, 1, 3, 1, 0.0F);
/* 162 */     setRotateAngle(this.tail, 1.0011208F, 0.0F, 0.0F);
/* 163 */     this.Trunk1 = new ModelRenderer(this, 0, 48);
/* 164 */     this.Trunk1.func_78793_a(0.0F, -3.1F, -4.3F);
/* 165 */     this.Trunk1.func_78790_a(-1.5F, -0.7F, -2.5F, 3, 2, 3, 0.0F);
/* 166 */     setRotateAngle(this.Trunk1, 0.95609134F, 0.0F, 0.0F);
/* 167 */     this.EarR1 = new ModelRenderer(this, 24, 54);
/* 168 */     this.EarR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.EarR1.func_78790_a(-1.5F, -7.6F, -1.4F, 6, 2, 1, 0.0F);
/* 170 */     setRotateAngle(this.EarR1, 0.0F, -0.091106184F, -1.0471976F);
/* 171 */     this.Body1 = new ModelRenderer(this, 20, 18);
/* 172 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 5, 4, 0.0F);
/* 174 */     this.TuskL3 = new ModelRenderer(this, 17, 55);
/* 175 */     this.TuskL3.field_78809_i = true;
/* 176 */     this.TuskL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.TuskL3.func_78790_a(0.6F, 6.7F, -3.1F, 1, 2, 2, 0.0F);
/* 178 */     setRotateAngle(this.TuskL3, -0.4098033F, 0.0F, 0.0F);
/* 179 */     this.EarL3 = new ModelRenderer(this, 24, 60);
/* 180 */     this.EarL3.field_78809_i = true;
/* 181 */     this.EarL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.EarL3.func_78790_a(-2.6F, -4.4F, -2.0F, 4, 2, 1, 0.0F);
/* 183 */     setRotateAngle(this.EarL3, 0.0F, 0.0F, 0.19128808F);
/* 184 */     this.ArmR_1 = new ModelRenderer(this, 46, 33);
/* 185 */     this.ArmR_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.ArmR_1.func_78790_a(-2.5F, 8.0F, -2.3F, 4, 3, 5, 0.0F);
/* 187 */     this.TuskR3 = new ModelRenderer(this, 17, 55);
/* 188 */     this.TuskR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 189 */     this.TuskR3.func_78790_a(-1.6F, 6.7F, -3.1F, 1, 2, 2, 0.0F);
/* 190 */     setRotateAngle(this.TuskR3, -0.4098033F, 0.0F, 0.0F);
/* 191 */     this.Trunk2.func_78792_a(this.Trunk3);
/* 192 */     this.tail_1.func_78792_a(this.tail_2);
/* 193 */     this.tail_3.func_78792_a(this.tail_4);
/* 194 */     this.Head.func_78792_a(this.EarL1);
/* 195 */     this.Body2.func_78792_a(this.Body3);
/* 196 */     this.EarR2.func_78792_a(this.EarR3);
/* 197 */     this.tail.func_78792_a(this.tail_1);
/* 198 */     this.EarL1.func_78792_a(this.EarL2);
/* 199 */     this.EarR1.func_78792_a(this.EarR2);
/* 200 */     this.tail_2.func_78792_a(this.tail_3);
/* 201 */     this.ArmL.func_78792_a(this.ArmL_1);
/* 202 */     this.LegL.func_78792_a(this.LegL2);
/* 203 */     this.Head.func_78792_a(this.TuskR1);
/* 204 */     this.TuskR1.func_78792_a(this.TuskR2);
/* 205 */     this.Body1.func_78792_a(this.Body2);
/* 206 */     this.Trunk3.func_78792_a(this.Trunk4);
/* 207 */     this.Body1.func_78792_a(this.Cloth1);
/* 208 */     this.TuskL1.func_78792_a(this.TuskL2);
/* 209 */     this.Head.func_78792_a(this.TuskL1);
/* 210 */     this.LegR.func_78792_a(this.LegR2);
/* 211 */     this.Body1.func_78792_a(this.Neck);
/* 212 */     this.Trunk1.func_78792_a(this.Trunk2);
/* 213 */     this.EarL1.func_78792_a(this.Earing);
/* 214 */     this.Head.func_78792_a(this.Trunk1);
/* 215 */     this.Head.func_78792_a(this.EarR1);
/* 216 */     this.TuskL2.func_78792_a(this.TuskL3);
/* 217 */     this.EarL2.func_78792_a(this.EarL3);
/* 218 */     this.ArmR.func_78792_a(this.ArmR_1);
/* 219 */     this.TuskR2.func_78792_a(this.TuskR3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 224 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 226 */     GL11.glPushMatrix();
/* 227 */     float F = 1.2F;
/* 228 */     JGRenderHelper.modelScalePositionHelper(1.2F);
/*     */     
/* 230 */     this.LegL.func_78785_a(f5);
/* 231 */     this.Head.func_78785_a(f5);
/* 232 */     this.ArmL.func_78785_a(f5);
/* 233 */     this.ArmR.func_78785_a(f5);
/* 234 */     this.Body1.func_78785_a(f5);
/* 235 */     this.LegR.func_78785_a(f5);
/* 236 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 242 */     modelRenderer.field_78795_f = x;
/* 243 */     modelRenderer.field_78796_g = y;
/* 244 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 248 */     int calc = par7Entity.field_70173_aa;
/* 249 */     if (calc > 100) calc -= 100; 
/* 250 */     float r = 360.0F;
/* 251 */     float r2 = 180.0F;
/* 252 */     float n4 = par4;
/* 253 */     float n5 = par5;
/*     */     
/* 255 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 256 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 257 */     float ex = par7Entity.field_70173_aa;
/* 258 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 259 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 261 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 262 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 308 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 309 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 310 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 311 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 313 */     this.LegR.field_78796_g = 0.0F;
/* 314 */     this.LegL.field_78796_g = 0.0F;
/* 315 */     this.ArmR.field_78796_g = 0.0F;
/* 316 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 319 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 323 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodRumsshi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */