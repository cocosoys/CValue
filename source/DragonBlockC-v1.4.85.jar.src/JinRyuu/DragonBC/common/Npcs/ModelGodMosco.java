/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ModelGodMosco
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer HeadSpike1;
/*     */   public ModelRenderer HeadSideR;
/*     */   public ModelRenderer HeadSideL;
/*     */   public ModelRenderer HeadFront;
/*     */   public ModelRenderer HeadSpike2;
/*     */   public ModelRenderer FrontDoor;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmR4;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmL4;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   public ModelRenderer LegL4;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegR4;
/*     */   
/*     */   public ModelGodMosco() {
/*  43 */     this.field_78090_t = 128;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.ArmR3 = new ModelRenderer(this, 53, 23);
/*  46 */     this.ArmR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.ArmR3.func_78790_a(-4.7F, 6.1F, -3.0F, 5, 5, 6, 0.0F);
/*  48 */     setRotateAngle(this.ArmR3, 0.0F, 0.0F, -0.06981317F);
/*  49 */     this.HeadSideL = new ModelRenderer(this, 33, 0);
/*  50 */     this.HeadSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.HeadSideL.func_78790_a(3.9F, -4.1F, -1.9F, 1, 4, 3, 0.0F);
/*  52 */     this.LegL2 = new ModelRenderer(this, 81, 12);
/*  53 */     this.LegL2.field_78809_i = true;
/*  54 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.LegL2.func_78790_a(-1.5F, 1.1F, -2.0F, 3, 5, 4, 0.0F);
/*  56 */     setRotateAngle(this.LegL2, 0.0F, 0.0F, -0.054105207F);
/*  57 */     this.FrontDoor = new ModelRenderer(this, 0, 14);
/*  58 */     this.FrontDoor.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.FrontDoor.func_78790_a(-2.5F, 5.1F, -6.2F, 5, 4, 1, 0.0F);
/*  60 */     this.ArmL3 = new ModelRenderer(this, 53, 23);
/*  61 */     this.ArmL3.field_78809_i = true;
/*  62 */     this.ArmL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.ArmL3.func_78790_a(-0.4F, 6.1F, -3.0F, 5, 5, 6, 0.0F);
/*  64 */     setRotateAngle(this.ArmL3, 0.0F, 0.0F, 0.06981317F);
/*  65 */     this.ArmL2 = new ModelRenderer(this, 57, 13);
/*  66 */     this.ArmL2.field_78809_i = true;
/*  67 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.ArmL2.func_78790_a(0.0F, 1.7F, -2.0F, 3, 5, 4, 0.0F);
/*  69 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.1308997F);
/*  70 */     this.ArmL1 = new ModelRenderer(this, 51, 2);
/*  71 */     this.ArmL1.field_78809_i = true;
/*  72 */     this.ArmL1.func_78793_a(6.6F, -0.8F, -0.8F);
/*  73 */     this.ArmL1.func_78790_a(-0.6F, -2.2F, -3.0F, 4, 4, 6, 0.0F);
/*  74 */     this.Body3 = new ModelRenderer(this, 1, 47);
/*  75 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.Body3.func_78790_a(-6.0F, 12.0F, -5.0F, 12, 2, 9, 0.0F);
/*  77 */     this.ArmR4 = new ModelRenderer(this, 57, 35);
/*  78 */     this.ArmR4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.ArmR4.func_78790_a(-4.1F, 10.8F, -2.4F, 4, 4, 5, 0.0F);
/*  80 */     setRotateAngle(this.ArmR4, 0.0F, 0.0F, -0.013962634F);
/*  81 */     this.HeadFront = new ModelRenderer(this, 32, 8);
/*  82 */     this.HeadFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.HeadFront.func_78790_a(-1.5F, -3.7F, -4.7F, 3, 3, 1, 0.0F);
/*  84 */     this.Head = new ModelRenderer(this, 0, 0);
/*  85 */     this.Head.func_78793_a(0.0F, -2.9F, 0.0F);
/*  86 */     this.Head.func_78790_a(-4.0F, -5.1F, -3.9F, 8, 5, 7, 0.0F);
/*  87 */     this.HeadSpike2 = new ModelRenderer(this, 26, 4);
/*  88 */     this.HeadSpike2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.HeadSpike2.func_78790_a(-0.5F, -7.1F, -0.8F, 1, 1, 1, 0.0F);
/*  90 */     this.LegR1 = new ModelRenderer(this, 79, 2);
/*  91 */     this.LegR1.func_78793_a(-4.1F, 12.0F, -0.6F);
/*  92 */     this.LegR1.func_78790_a(-2.0F, -1.3F, -2.6F, 4, 3, 5, 0.0F);
/*  93 */     setRotateAngle(this.LegR1, 0.0F, 0.0F, 0.18203785F);
/*  94 */     this.ArmR1 = new ModelRenderer(this, 51, 2);
/*  95 */     this.ArmR1.func_78793_a(-6.6F, -0.8F, -0.8F);
/*  96 */     this.ArmR1.func_78790_a(-3.4F, -2.2F, -3.0F, 4, 4, 6, 0.0F);
/*  97 */     this.ClothF = new ModelRenderer(this, 60, 47);
/*  98 */     this.ClothF.func_78793_a(0.0F, 12.0F, -5.0F);
/*  99 */     this.ClothF.func_78790_a(-2.5F, 0.0F, -0.3F, 5, 8, 0, 0.0F);
/* 100 */     setRotateAngle(this.ClothF, -0.04363323F, 0.0F, 0.0F);
/* 101 */     this.HeadSideR = new ModelRenderer(this, 33, 0);
/* 102 */     this.HeadSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.HeadSideR.func_78790_a(-4.8F, -4.1F, -1.9F, 1, 4, 3, 0.0F);
/* 104 */     this.ArmL4 = new ModelRenderer(this, 57, 35);
/* 105 */     this.ArmL4.field_78809_i = true;
/* 106 */     this.ArmL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.ArmL4.func_78790_a(0.0F, 10.8F, -2.4F, 4, 4, 5, 0.0F);
/* 108 */     setRotateAngle(this.ArmL4, 0.0F, 0.0F, 0.013962634F);
/* 109 */     this.LegL1 = new ModelRenderer(this, 79, 2);
/* 110 */     this.LegL1.field_78809_i = true;
/* 111 */     this.LegL1.func_78793_a(4.1F, 12.0F, -0.6F);
/* 112 */     this.LegL1.func_78790_a(-2.0F, -1.3F, -2.6F, 4, 3, 5, 0.0F);
/* 113 */     setRotateAngle(this.LegL1, 0.0F, 0.0F, -0.18203785F);
/* 114 */     this.LegL3 = new ModelRenderer(this, 80, 22);
/* 115 */     this.LegL3.field_78809_i = true;
/* 116 */     this.LegL3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.LegL3.func_78790_a(-1.0F, 5.0F, -3.0F, 5, 7, 6, 0.0F);
/* 118 */     setRotateAngle(this.LegL3, 0.0F, 0.0F, 0.23387411F);
/* 119 */     this.LegR2 = new ModelRenderer(this, 81, 12);
/* 120 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.LegR2.func_78790_a(-1.5F, 1.1F, -2.0F, 3, 5, 4, 0.0F);
/* 122 */     setRotateAngle(this.LegR2, 0.0F, 0.0F, 0.054105207F);
/* 123 */     this.LegR4 = new ModelRenderer(this, 82, 36);
/* 124 */     this.LegR4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.LegR4.func_78790_a(-3.3F, 9.9F, -5.0F, 4, 2, 2, 0.0F);
/* 126 */     this.LegL4 = new ModelRenderer(this, 82, 36);
/* 127 */     this.LegL4.field_78809_i = true;
/* 128 */     this.LegL4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.LegL4.func_78790_a(-0.6F, 9.9F, -5.0F, 4, 2, 2, 0.0F);
/* 130 */     this.Body1 = new ModelRenderer(this, 5, 14);
/* 131 */     this.Body1.func_78793_a(0.0F, -3.0F, 0.0F);
/* 132 */     this.Body1.func_78790_a(-6.0F, 0.0F, -4.8F, 12, 5, 9, 0.0F);
/* 133 */     this.HeadSpike1 = new ModelRenderer(this, 24, 0);
/* 134 */     this.HeadSpike1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 135 */     this.HeadSpike1.func_78790_a(-1.0F, -6.1F, -1.3F, 2, 1, 2, 0.0F);
/* 136 */     this.Body4 = new ModelRenderer(this, 36, 51);
/* 137 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 138 */     this.Body4.func_78790_a(-3.0F, 13.8F, -5.0F, 6, 2, 8, 0.0F);
/* 139 */     this.ArmR2 = new ModelRenderer(this, 57, 13);
/* 140 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 141 */     this.ArmR2.func_78790_a(-3.1F, 1.7F, -2.0F, 3, 5, 4, 0.0F);
/* 142 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.1308997F);
/* 143 */     this.LegR3 = new ModelRenderer(this, 80, 22);
/* 144 */     this.LegR3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 145 */     this.LegR3.func_78790_a(-3.9F, 5.0F, -3.0F, 5, 7, 6, 0.0F);
/* 146 */     setRotateAngle(this.LegR3, 0.0F, 0.0F, -0.23387411F);
/* 147 */     this.Body2 = new ModelRenderer(this, 2, 29);
/* 148 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 149 */     this.Body2.func_78790_a(-6.0F, 5.0F, -5.4F, 12, 7, 10, 0.0F);
/* 150 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 151 */     this.Head.func_78792_a(this.HeadSideL);
/* 152 */     this.LegL1.func_78792_a(this.LegL2);
/* 153 */     this.Body1.func_78792_a(this.FrontDoor);
/* 154 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 155 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 156 */     this.Body2.func_78792_a(this.Body3);
/* 157 */     this.ArmR3.func_78792_a(this.ArmR4);
/* 158 */     this.Head.func_78792_a(this.HeadFront);
/* 159 */     this.HeadSpike1.func_78792_a(this.HeadSpike2);
/* 160 */     this.Body1.func_78792_a(this.ClothF);
/* 161 */     this.Head.func_78792_a(this.HeadSideR);
/* 162 */     this.ArmL3.func_78792_a(this.ArmL4);
/* 163 */     this.LegL2.func_78792_a(this.LegL3);
/* 164 */     this.LegR1.func_78792_a(this.LegR2);
/* 165 */     this.LegR3.func_78792_a(this.LegR4);
/* 166 */     this.LegL3.func_78792_a(this.LegL4);
/* 167 */     this.Head.func_78792_a(this.HeadSpike1);
/* 168 */     this.Body3.func_78792_a(this.Body4);
/* 169 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 170 */     this.LegR2.func_78792_a(this.LegR3);
/* 171 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 176 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 178 */     GL11.glPushMatrix();
/* 179 */     float F = 1.5F;
/* 180 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 182 */     this.LegL1.func_78785_a(f5);
/* 183 */     this.Head.func_78785_a(f5);
/* 184 */     this.ArmL1.func_78785_a(f5);
/* 185 */     this.ArmR1.func_78785_a(f5);
/* 186 */     this.Body1.func_78785_a(f5);
/* 187 */     this.LegR1.func_78785_a(f5);
/* 188 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 194 */     modelRenderer.field_78795_f = x;
/* 195 */     modelRenderer.field_78796_g = y;
/* 196 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 200 */     int calc = par7Entity.field_70173_aa;
/* 201 */     if (calc > 100) calc -= 100; 
/* 202 */     float r = 360.0F;
/* 203 */     float r2 = 180.0F;
/* 204 */     float n4 = par4;
/* 205 */     float n5 = par5;
/*     */     
/* 207 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 208 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 209 */     float ex = par7Entity.field_70173_aa;
/* 210 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 211 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 213 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 214 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 261 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 262 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 263 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 265 */     this.LegR1.field_78796_g = 0.0F;
/* 266 */     this.LegL1.field_78796_g = 0.0F;
/* 267 */     this.ArmR1.field_78796_g = 0.0F;
/* 268 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 271 */     this.ClothF.field_78795_f = -0.15F + this.LegR1.field_78795_f * ((this.LegR1.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 275 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodMosco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */