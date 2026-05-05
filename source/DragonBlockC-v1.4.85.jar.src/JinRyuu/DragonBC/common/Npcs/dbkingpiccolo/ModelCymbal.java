/*     */ package JinRyuu.DragonBC.common.Npcs.dbkingpiccolo;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRenderHelper;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class ModelCymbal
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer tail1;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer HornR;
/*     */   public ModelRenderer HornL;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer HornR2;
/*     */   public ModelRenderer HornR3;
/*     */   public ModelRenderer HornL2;
/*     */   public ModelRenderer HornL3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer WingR;
/*     */   public ModelRenderer WingL;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer tail2;
/*     */   public ModelRenderer tail3;
/*     */   public ModelRenderer tail4;
/*     */   public ModelRenderer tail5;
/*     */   
/*     */   public ModelCymbal() {
/*  45 */     this.field_78090_t = 128;
/*  46 */     this.field_78089_u = 128;
/*  47 */     this.tail3 = new ModelRenderer(this, 88, 116);
/*  48 */     this.tail3.func_78793_a(0.0F, 0.0F, 4.9F);
/*  49 */     this.tail3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 6, 0.0F);
/*  50 */     this.Nose = new ModelRenderer(this, 1, 16);
/*  51 */     this.Nose.func_78793_a(0.0F, -2.5F, -3.9F);
/*  52 */     this.Nose.func_78790_a(-3.0F, -1.0F, -2.9F, 6, 4, 5, 0.0F);
/*  53 */     this.HornR3 = new ModelRenderer(this, 51, 9);
/*  54 */     this.HornR3.func_78793_a(0.0F, -3.2F, 0.0F);
/*  55 */     this.HornR3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
/*  56 */     setRotateAngle(this.HornR3, -0.08726646F, 0.0F, -0.08726646F);
/*  57 */     this.HornL2 = new ModelRenderer(this, 42, 8);
/*  58 */     this.HornL2.field_78809_i = true;
/*  59 */     this.HornL2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  60 */     this.HornL2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
/*  61 */     setRotateAngle(this.HornL2, -0.12217305F, 0.0F, 0.12217305F);
/*  62 */     this.Body3 = new ModelRenderer(this, 0, 73);
/*  63 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.Body3.func_78790_a(-7.0F, 18.0F, -3.2F, 14, 2, 9, 0.0F);
/*  65 */     this.Chest = new ModelRenderer(this, 53, 43);
/*  66 */     this.Chest.func_78793_a(0.0F, 4.2F, -1.7F);
/*  67 */     this.Chest.func_78790_a(-7.0F, -2.1F, -1.4F, 14, 5, 2, 0.0F);
/*  68 */     setRotateAngle(this.Chest, -0.091106184F, 0.0F, 0.0F);
/*  69 */     this.ArmR = new ModelRenderer(this, 92, 3);
/*  70 */     this.ArmR.func_78793_a(-8.8F, 0.0F, 2.0F);
/*  71 */     this.ArmR.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/*  72 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.38397244F);
/*  73 */     this.EarL = new ModelRenderer(this, 32, 1);
/*  74 */     this.EarL.field_78809_i = true;
/*  75 */     this.EarL.func_78793_a(4.3F, -4.4F, -1.0F);
/*  76 */     this.EarL.func_78790_a(0.0F, -2.4F, 0.0F, 4, 5, 0, 0.0F);
/*  77 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.04363323F);
/*  78 */     this.ArmR2 = new ModelRenderer(this, 90, 19);
/*  79 */     this.ArmR2.func_78793_a(-0.6F, 7.1F, -0.3F);
/*  80 */     this.ArmR2.func_78790_a(-3.5F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  81 */     setRotateAngle(this.ArmR2, -0.4098033F, 0.0F, -0.08726646F);
/*  82 */     this.HornR2 = new ModelRenderer(this, 42, 8);
/*  83 */     this.HornR2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  84 */     this.HornR2.func_78790_a(-1.0F, -2.8F, -1.0F, 2, 3, 2, 0.0F);
/*  85 */     setRotateAngle(this.HornR2, -0.12217305F, 0.0F, -0.13665928F);
/*  86 */     this.LegL2 = new ModelRenderer(this, 91, 64);
/*  87 */     this.LegL2.func_78793_a(0.0F, 10.0F, 1.9F);
/*  88 */     this.LegL2.func_78790_a(-3.5F, 0.0F, -5.8F, 7, 3, 9, 0.0F);
/*  89 */     this.ArmL2 = new ModelRenderer(this, 90, 19);
/*  90 */     this.ArmL2.field_78809_i = true;
/*  91 */     this.ArmL2.func_78793_a(0.8F, 7.1F, -0.3F);
/*  92 */     this.ArmL2.func_78790_a(-2.8F, -0.5F, -2.5F, 6, 9, 6, 0.0F);
/*  93 */     setRotateAngle(this.ArmL2, -0.4098033F, 0.0F, 0.08726646F);
/*  94 */     this.tail2 = new ModelRenderer(this, 67, 116);
/*  95 */     this.tail2.func_78793_a(0.0F, -0.2F, 5.9F);
/*  96 */     this.tail2.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 5, 0.0F);
/*  97 */     this.Body = new ModelRenderer(this, 0, 26);
/*  98 */     this.Body.func_78793_a(0.0F, -2.9F, 0.0F);
/*  99 */     this.Body.func_78790_a(-8.0F, 0.0F, -2.4F, 16, 7, 9, 0.0F);
/* 100 */     this.LegR = new ModelRenderer(this, 91, 43);
/* 101 */     this.LegR.func_78793_a(-7.2F, 11.0F, 1.0F);
/* 102 */     this.LegR.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 10, 8, 0.0F);
/* 103 */     this.Head = new ModelRenderer(this, 0, 0);
/* 104 */     this.Head.func_78793_a(0.0F, -2.2F, 0.2F);
/* 105 */     this.Head.func_78790_a(-4.5F, -7.2F, -4.0F, 9, 7, 8, 0.0F);
/* 106 */     this.LegL = new ModelRenderer(this, 91, 43);
/* 107 */     this.LegL.field_78809_i = true;
/* 108 */     this.LegL.func_78793_a(7.2F, 11.0F, 1.0F);
/* 109 */     this.LegL.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 10, 8, 0.0F);
/* 110 */     this.HornL3 = new ModelRenderer(this, 51, 9);
/* 111 */     this.HornL3.field_78809_i = true;
/* 112 */     this.HornL3.func_78793_a(0.0F, -3.2F, 0.0F);
/* 113 */     this.HornL3.func_78790_a(-0.6F, -2.6F, -0.5F, 1, 3, 1, 0.0F);
/* 114 */     setRotateAngle(this.HornL3, -0.08726646F, 0.0F, 0.08726646F);
/* 115 */     this.ArmL = new ModelRenderer(this, 92, 3);
/* 116 */     this.ArmL.field_78809_i = true;
/* 117 */     this.ArmL.func_78793_a(8.8F, 0.0F, 2.0F);
/* 118 */     this.ArmL.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 9, 5, 0.0F);
/* 119 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.38397244F);
/* 120 */     this.tail1 = new ModelRenderer(this, 42, 114);
/* 121 */     this.tail1.func_78793_a(0.0F, 11.5F, 6.5F);
/* 122 */     this.tail1.func_78790_a(-3.0F, -3.0F, 0.0F, 6, 6, 6, 0.0F);
/* 123 */     this.WingL = new ModelRenderer(this, 0, 106);
/* 124 */     this.WingL.field_78809_i = true;
/* 125 */     this.WingL.func_78793_a(2.9F, 4.0F, 6.9F);
/* 126 */     this.WingL.func_78790_a(0.0F, -10.7F, 0.0F, 21, 22, 0, 0.0F);
/* 127 */     setRotateAngle(this.WingL, 0.0F, -0.17453292F, 0.0F);
/* 128 */     this.LegR2 = new ModelRenderer(this, 91, 64);
/* 129 */     this.LegR2.func_78793_a(0.0F, 10.0F, 1.9F);
/* 130 */     this.LegR2.func_78790_a(-3.5F, 0.0F, -5.8F, 7, 3, 9, 0.0F);
/* 131 */     this.EarR = new ModelRenderer(this, 32, 1);
/* 132 */     this.EarR.func_78793_a(-4.5F, -4.4F, -1.0F);
/* 133 */     this.EarR.func_78790_a(-3.9F, -2.4F, 0.0F, 4, 5, 0, 0.0F);
/* 134 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, -0.04363323F);
/* 135 */     this.tail4 = new ModelRenderer(this, 109, 117);
/* 136 */     this.tail4.func_78793_a(0.0F, 0.0F, 5.9F);
/* 137 */     this.tail4.func_78790_a(-1.5F, -1.5F, 0.0F, 3, 3, 6, 0.0F);
/* 138 */     this.HornL = new ModelRenderer(this, 42, 1);
/* 139 */     this.HornL.field_78809_i = true;
/* 140 */     this.HornL.func_78793_a(2.1F, -5.7F, -1.3F);
/* 141 */     this.HornL.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
/* 142 */     setRotateAngle(this.HornL, -0.43633232F, 0.0F, 0.08726646F);
/* 143 */     this.tail5 = new ModelRenderer(this, 111, 109);
/* 144 */     this.tail5.func_78793_a(0.0F, 0.0F, 5.9F);
/* 145 */     this.tail5.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
/* 146 */     this.HornR = new ModelRenderer(this, 42, 1);
/* 147 */     this.HornR.func_78793_a(-2.1F, -5.7F, -1.3F);
/* 148 */     this.HornR.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 3, 3, 0.0F);
/* 149 */     setRotateAngle(this.HornR, -0.43633232F, 0.0F, -0.04363323F);
/* 150 */     this.Body2 = new ModelRenderer(this, 0, 46);
/* 151 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.Body2.func_78790_a(-9.0F, 7.0F, -4.1F, 18, 11, 11, 0.0F);
/* 153 */     this.WingR = new ModelRenderer(this, 0, 106);
/* 154 */     this.WingR.func_78793_a(-2.9F, 4.0F, 6.9F);
/* 155 */     this.WingR.func_78790_a(-19.0F, -10.7F, 0.0F, 21, 22, 0, 0.0F);
/* 156 */     setRotateAngle(this.WingR, 0.0F, 0.17453292F, 0.0F);
/* 157 */     this.tail2.func_78792_a(this.tail3);
/* 158 */     this.Head.func_78792_a(this.Nose);
/* 159 */     this.HornR2.func_78792_a(this.HornR3);
/* 160 */     this.HornL.func_78792_a(this.HornL2);
/* 161 */     this.Body2.func_78792_a(this.Body3);
/* 162 */     this.Body.func_78792_a(this.Chest);
/* 163 */     this.Head.func_78792_a(this.EarL);
/* 164 */     this.ArmR.func_78792_a(this.ArmR2);
/* 165 */     this.HornR.func_78792_a(this.HornR2);
/* 166 */     this.LegL.func_78792_a(this.LegL2);
/* 167 */     this.ArmL.func_78792_a(this.ArmL2);
/* 168 */     this.tail1.func_78792_a(this.tail2);
/* 169 */     this.HornL2.func_78792_a(this.HornL3);
/* 170 */     this.Body.func_78792_a(this.WingL);
/* 171 */     this.LegR.func_78792_a(this.LegR2);
/* 172 */     this.Head.func_78792_a(this.EarR);
/* 173 */     this.tail3.func_78792_a(this.tail4);
/* 174 */     this.Head.func_78792_a(this.HornL);
/* 175 */     this.tail4.func_78792_a(this.tail5);
/* 176 */     this.Head.func_78792_a(this.HornR);
/* 177 */     this.Body.func_78792_a(this.Body2);
/* 178 */     this.Body.func_78792_a(this.WingR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 183 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 185 */     GL11.glPushMatrix();
/* 186 */     float F = 1.5F;
/* 187 */     JGRenderHelper.modelScalePositionHelper(1.5F);
/*     */     
/* 189 */     this.Head.func_78785_a(f5);
/* 190 */     this.Body.func_78785_a(f5);
/* 191 */     this.ArmR.func_78785_a(f5);
/* 192 */     this.ArmL.func_78785_a(f5);
/* 193 */     this.LegL.func_78785_a(f5);
/* 194 */     this.LegR.func_78785_a(f5);
/* 195 */     this.tail1.func_78785_a(f5);
/*     */     
/* 197 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 201 */     modelRenderer.field_78795_f = x;
/* 202 */     modelRenderer.field_78796_g = y;
/* 203 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 207 */     int calc = par7Entity.field_70173_aa;
/* 208 */     if (calc > 100) calc -= 100; 
/* 209 */     float r = 360.0F;
/* 210 */     float r2 = 180.0F;
/* 211 */     float n4 = par4;
/* 212 */     float n5 = par5;
/*     */     
/* 214 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 215 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 216 */     float ex = par7Entity.field_70173_aa;
/* 217 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 218 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 220 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 221 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */     
/* 223 */     this.tail1.field_78795_f = 0.2F;
/* 224 */     this.tail1.field_78795_f += r4 / 2.0F;
/*     */     
/* 226 */     this.tail2.field_78795_f = 0.2F;
/* 227 */     this.tail2.field_78795_f += r4 / 2.0F;
/*     */     
/* 229 */     this.tail3.field_78795_f = 0.2F;
/* 230 */     this.tail3.field_78795_f += r4 / 2.0F;
/*     */     
/* 232 */     this.tail4.field_78795_f = 0.2F;
/* 233 */     this.tail4.field_78795_f += r4 / 2.0F;
/*     */     
/* 235 */     this.tail5.field_78796_g = 0.2F;
/* 236 */     this.tail5.field_78796_g += r4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 270 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 271 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 272 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 273 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 275 */     this.LegR.field_78796_g = 0.0F;
/* 276 */     this.LegL.field_78796_g = 0.0F;
/* 277 */     this.ArmR.field_78796_g = 0.0F;
/* 278 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbkingpiccolo\ModelCymbal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */