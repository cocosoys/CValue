/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelCabba
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer ClothB;
/*     */   public ModelRenderer ClothF;
/*     */   public ModelRenderer ClothL;
/*     */   public ModelRenderer ClothR;
/*     */   public ModelRenderer gohan1;
/*     */   public ModelRenderer gohan7;
/*     */   public ModelRenderer gohan8;
/*     */   public ModelRenderer gohan10;
/*     */   public ModelRenderer gohan11;
/*     */   public ModelRenderer gohan12;
/*     */   public ModelRenderer gohan13;
/*     */   public ModelRenderer gohan14;
/*     */   public ModelRenderer gohan15;
/*     */   public ModelRenderer gohan16;
/*     */   public ModelRenderer gohan17;
/*     */   public ModelRenderer gohan18;
/*     */   public ModelRenderer gohan19;
/*     */   public ModelRenderer gohan20;
/*     */   public ModelRenderer gohan21;
/*     */   public ModelRenderer gohan22;
/*     */   
/*     */   public ModelCabba() {
/*  45 */     this.field_78090_t = 128;
/*  46 */     this.field_78089_u = 64;
/*  47 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  48 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Hair.func_78790_a(0.5F, -2.9F, -6.5F, 1, 2, 1, 0.0F);
/*  50 */     setRotateAngle(this.Hair, -0.4553564F, -0.22759093F, -0.15009831F);
/*  51 */     this.ClothR = new ModelRenderer(this, 30, 33);
/*  52 */     this.ClothR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.ClothR.func_78790_a(-3.3F, 9.2F, -1.4F, 1, 9, 3, 0.0F);
/*  54 */     setRotateAngle(this.ClothR, 0.0F, 0.0F, 0.04363323F);
/*  55 */     this.LegR = new ModelRenderer(this, 0, 17);
/*  56 */     this.LegR.func_78793_a(-2.0F, 13.0F, 0.0F);
/*  57 */     this.LegR.func_78790_a(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
/*  58 */     this.LegL = new ModelRenderer(this, 0, 17);
/*  59 */     this.LegL.field_78809_i = true;
/*  60 */     this.LegL.func_78793_a(2.0F, 13.0F, 0.0F);
/*  61 */     this.LegL.func_78790_a(-1.5F, 0.0F, -2.0F, 3, 11, 4, 0.0F);
/*  62 */     this.Head = new ModelRenderer(this, 0, 0);
/*  63 */     this.Head.func_78793_a(0.0F, 2.0F, 0.0F);
/*  64 */     this.Head.func_78790_a(-4.0F, -7.6F, -4.0F, 8, 8, 8, -0.3F);
/*  65 */     this.ClothB = new ModelRenderer(this, 20, 35);
/*  66 */     this.ClothB.func_78793_a(0.0F, 9.0F, 1.9F);
/*  67 */     this.ClothB.func_78790_a(-1.5F, 0.0F, -0.4F, 3, 9, 1, 0.0F);
/*  68 */     setRotateAngle(this.ClothB, 0.11868239F, 0.0F, 0.0F);
/*  69 */     this.ClothL = new ModelRenderer(this, 30, 33);
/*  70 */     this.ClothL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.ClothL.func_78790_a(2.6F, 9.0F, -1.4F, 1, 9, 3, 0.0F);
/*  72 */     setRotateAngle(this.ClothL, 0.0F, 0.0F, -0.04363323F);
/*  73 */     this.Body = new ModelRenderer(this, 16, 17);
/*  74 */     this.Body.func_78793_a(0.0F, 2.0F, 0.0F);
/*  75 */     this.Body.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 11, 4, 0.0F);
/*  76 */     this.ClothF = new ModelRenderer(this, 20, 35);
/*  77 */     this.ClothF.func_78793_a(0.0F, 9.0F, -1.9F);
/*  78 */     this.ClothF.func_78790_a(-1.5F, 0.0F, -0.4F, 3, 9, 1, 0.0F);
/*  79 */     setRotateAngle(this.ClothF, -0.11868239F, 0.0F, 0.0F);
/*  80 */     this.ArmL = new ModelRenderer(this, 40, 18);
/*  81 */     this.ArmL.field_78809_i = true;
/*  82 */     this.ArmL.func_78793_a(4.5F, 4.0F, 0.0F);
/*  83 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.5F, 3, 11, 3, 0.0F);
/*  84 */     this.ArmR = new ModelRenderer(this, 40, 18);
/*  85 */     this.ArmR.func_78793_a(-5.0F, 4.0F, 0.0F);
/*  86 */     this.ArmR.func_78790_a(-1.5F, -2.0F, -1.5F, 3, 11, 3, 0.0F);
/*     */ 
/*     */     
/*  89 */     this.gohan1 = new ModelRenderer(this, 64, 0);
/*  90 */     this.gohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4);
/*  91 */     this.gohan1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     setRotateAngle(this.gohan1, -0.1745329F, 0.0F, 0.0F);
/*  93 */     this.gohan7 = new ModelRenderer(this, 64, 0);
/*  94 */     this.gohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3);
/*  95 */     this.gohan7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     setRotateAngle(this.gohan7, -0.3665191F, 0.0F, 0.0F);
/*  97 */     this.gohan8 = new ModelRenderer(this, 64, 0);
/*  98 */     this.gohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2);
/*  99 */     this.gohan8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     setRotateAngle(this.gohan8, -0.5585054F, 0.0F, 0.0F);
/* 101 */     this.gohan10 = new ModelRenderer(this, 64, 0);
/* 102 */     this.gohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4);
/* 103 */     this.gohan10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     setRotateAngle(this.gohan10, -0.2617994F, 0.0F, -0.3665191F);
/* 105 */     this.gohan11 = new ModelRenderer(this, 64, 0);
/* 106 */     this.gohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4);
/* 107 */     this.gohan11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 108 */     setRotateAngle(this.gohan11, -0.418879F, 0.0F, -0.3316126F);
/* 109 */     this.gohan12 = new ModelRenderer(this, 64, 0);
/* 110 */     this.gohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3);
/* 111 */     this.gohan12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     setRotateAngle(this.gohan12, -0.5235988F, 0.0F, -0.2268928F);
/* 113 */     this.gohan13 = new ModelRenderer(this, 64, 0);
/* 114 */     this.gohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2);
/* 115 */     this.gohan13.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     setRotateAngle(this.gohan13, -0.6283185F, 0.0F, -0.0698132F);
/* 117 */     this.gohan14 = new ModelRenderer(this, 64, 0);
/* 118 */     this.gohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3);
/* 119 */     this.gohan14.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     setRotateAngle(this.gohan14, -0.2268928F, 0.0F, 0.4014257F);
/* 121 */     this.gohan15 = new ModelRenderer(this, 64, 0);
/* 122 */     this.gohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4);
/* 123 */     this.gohan15.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     setRotateAngle(this.gohan15, -0.4537856F, 0.0F, 0.2617994F);
/* 125 */     this.gohan16 = new ModelRenderer(this, 64, 0);
/* 126 */     this.gohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3);
/* 127 */     this.gohan16.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     setRotateAngle(this.gohan16, -0.5410521F, 0.0F, 0.1745329F);
/* 129 */     this.gohan17 = new ModelRenderer(this, 64, 0);
/* 130 */     this.gohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4);
/* 131 */     this.gohan17.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     setRotateAngle(this.gohan17, -0.2792527F, 0.0F, 0.0F);
/* 133 */     this.gohan18 = new ModelRenderer(this, 64, 0);
/* 134 */     this.gohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4);
/* 135 */     this.gohan18.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     setRotateAngle(this.gohan18, -0.2443461F, 0.2617994F, 0.0174533F);
/* 137 */     this.gohan19 = new ModelRenderer(this, 64, 0);
/* 138 */     this.gohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4);
/* 139 */     this.gohan19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     setRotateAngle(this.gohan19, -0.2443461F, -0.2617994F, 0.0174533F);
/* 141 */     this.gohan20 = new ModelRenderer(this, 64, 0);
/* 142 */     this.gohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4);
/* 143 */     this.gohan20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     setRotateAngle(this.gohan20, -0.1396263F, 0.0F, 0.0F);
/* 145 */     this.gohan21 = new ModelRenderer(this, 64, 0);
/* 146 */     this.gohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3);
/* 147 */     this.gohan21.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     setRotateAngle(this.gohan21, -0.122173F, 0.1745329F, 0.0F);
/* 149 */     this.gohan22 = new ModelRenderer(this, 64, 0);
/* 150 */     this.gohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3);
/* 151 */     this.gohan22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     setRotateAngle(this.gohan22, -0.2443461F, -0.2617994F, 0.0174533F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     this.Head.func_78792_a(this.Hair);
/* 160 */     this.Body.func_78792_a(this.ClothR);
/* 161 */     this.Body.func_78792_a(this.ClothB);
/* 162 */     this.Body.func_78792_a(this.ClothL);
/* 163 */     this.Body.func_78792_a(this.ClothF);
/*     */     
/* 165 */     this.Head.func_78792_a(this.gohan1);
/* 166 */     this.Head.func_78792_a(this.gohan7);
/* 167 */     this.Head.func_78792_a(this.gohan8);
/* 168 */     this.Head.func_78792_a(this.gohan10);
/* 169 */     this.Head.func_78792_a(this.gohan11);
/* 170 */     this.Head.func_78792_a(this.gohan12);
/* 171 */     this.Head.func_78792_a(this.gohan13);
/*     */     
/* 173 */     this.Head.func_78792_a(this.gohan15);
/* 174 */     this.Head.func_78792_a(this.gohan16);
/* 175 */     this.Head.func_78792_a(this.gohan17);
/* 176 */     this.Head.func_78792_a(this.gohan18);
/* 177 */     this.Head.func_78792_a(this.gohan19);
/* 178 */     this.Head.func_78792_a(this.gohan20);
/* 179 */     this.Head.func_78792_a(this.gohan21);
/* 180 */     this.Head.func_78792_a(this.gohan22);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 186 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 187 */     float F = 0.8F;
/* 188 */     GL11.glPushMatrix();
/* 189 */     GL11.glScalef(F, F, F);
/* 190 */     GL11.glTranslatef(0.0F, (F - 1.0F) * -0.74F * 3.0F, 0.0F);
/* 191 */     this.LegL.func_78785_a(f5);
/* 192 */     this.Head.func_78785_a(f5);
/* 193 */     this.ArmL.func_78785_a(f5);
/* 194 */     this.ArmR.func_78785_a(f5);
/* 195 */     this.Body.func_78785_a(f5);
/* 196 */     this.LegR.func_78785_a(f5);
/*     */     
/* 198 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 202 */     modelRenderer.field_78795_f = x;
/* 203 */     modelRenderer.field_78796_g = y;
/* 204 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 208 */     int calc = par7Entity.field_70173_aa;
/* 209 */     if (calc > 100) calc -= 100; 
/* 210 */     float r = 360.0F;
/* 211 */     float r2 = 180.0F;
/* 212 */     float n4 = par4;
/* 213 */     float n5 = par5;
/*     */     
/* 215 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 216 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 217 */     float ex = par7Entity.field_70173_aa;
/* 218 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 219 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 221 */     this.ClothF.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 222 */     if (this.ClothF.field_78795_f > 0.0F) this.ClothF.field_78795_f *= -1.0F; 
/* 223 */     this.ClothF.field_78796_g = 0.0F;
/*     */     
/* 225 */     this.ClothB.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 226 */     if (0.0F > this.ClothB.field_78795_f) this.ClothB.field_78795_f *= -1.0F; 
/* 227 */     this.ClothB.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 230 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 231 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 232 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 234 */     this.LegR.field_78796_g = 0.0F;
/* 235 */     this.LegL.field_78796_g = 0.0F;
/* 236 */     this.ArmR.field_78796_g = 0.0F;
/* 237 */     this.ArmL.field_78796_g = 0.0F;
/* 238 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelCabba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */