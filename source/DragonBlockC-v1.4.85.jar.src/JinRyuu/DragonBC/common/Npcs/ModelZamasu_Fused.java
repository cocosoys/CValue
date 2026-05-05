/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelZamasu_Fused
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer HairBase;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer HairR;
/*     */   public ModelRenderer HairL;
/*     */   public ModelRenderer HairB1;
/*     */   public ModelRenderer HairF1;
/*     */   public ModelRenderer HairM1;
/*     */   public ModelRenderer HairB2;
/*     */   public ModelRenderer HairB3;
/*     */   public ModelRenderer HairB4;
/*     */   public ModelRenderer HairF2;
/*     */   public ModelRenderer HairF3;
/*     */   public ModelRenderer HairF4;
/*     */   public ModelRenderer HairF6;
/*     */   public ModelRenderer HairF5;
/*     */   public ModelRenderer HairM2;
/*     */   public ModelRenderer earR2;
/*     */   public ModelRenderer earL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer BarrierofLight;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelZamasu_Fused() {
/*  42 */     this.field_78090_t = 128;
/*  43 */     this.field_78089_u = 64;
/*  44 */     this.Body1 = new ModelRenderer(this, 20, 23);
/*  45 */     this.Body1.func_78793_a(0.0F, -1.0F, 0.0F);
/*  46 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 7, 4, 0.0F);
/*  47 */     this.ShoulderL = new ModelRenderer(this, 3, 18);
/*  48 */     this.ShoulderL.field_78809_i = true;
/*  49 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.ShoulderL.func_78790_a(-1.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/*  51 */     this.HairB3 = new ModelRenderer(this, 45, 26);
/*  52 */     this.HairB3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.HairB3.func_78790_a(-2.8F, -7.0F, -0.1F, 5, 3, 3, 0.0F);
/*  54 */     setRotateAngle(this.HairB3, 0.0F, 0.0F, 0.59184116F);
/*  55 */     this.HairM2 = new ModelRenderer(this, 36, 13);
/*  56 */     this.HairM2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.HairM2.func_78790_a(-3.3F, -12.8F, -3.3F, 2, 7, 3, 0.0F);
/*  58 */     setRotateAngle(this.HairM2, 0.0F, 0.0F, 0.040142573F);
/*  59 */     this.HairF1 = new ModelRenderer(this, 48, 33);
/*  60 */     this.HairF1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.HairF1.func_78790_a(-3.3F, -9.8F, -5.4F, 2, 4, 3, 0.0F);
/*  62 */     setRotateAngle(this.HairF1, 0.0F, 0.0F, -0.13665928F);
/*  63 */     this.HairL = new ModelRenderer(this, 47, 13);
/*  64 */     this.HairL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.HairL.func_78790_a(2.0F, -11.5F, -3.9F, 2, 7, 5, 0.0F);
/*  66 */     setRotateAngle(this.HairL, 0.0F, 0.045378562F, 0.07853982F);
/*  67 */     this.BarrierofLight = new ModelRenderer(this, 62, 9);
/*  68 */     this.BarrierofLight.func_78793_a(0.0F, 0.0F, 7.8F);
/*  69 */     this.BarrierofLight.func_78790_a(-16.5F, -22.6F, 0.0F, 33, 42, 0, 0.0F);
/*  70 */     setRotateAngle(this.BarrierofLight, -0.06981317F, 0.0F, 0.0F);
/*  71 */     this.Head = new ModelRenderer(this, 0, 0);
/*  72 */     this.Head.func_78793_a(0.0F, -1.2F, 0.0F);
/*  73 */     this.Head.func_78790_a(-4.0F, -7.3F, -4.0F, 8, 8, 8, -0.5F);
/*  74 */     this.earR = new ModelRenderer(this, 0, 1);
/*  75 */     this.earR.func_78793_a(-3.2F, -1.9F, -1.5F);
/*  76 */     this.earR.func_78790_a(-4.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/*  77 */     setRotateAngle(this.earR, 0.1134464F, 0.5235988F, 0.34906584F);
/*  78 */     this.HairF6 = new ModelRenderer(this, 50, 46);
/*  79 */     this.HairF6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.HairF6.func_78790_a(1.5F, -7.3F, -6.1F, 2, 3, 1, 0.0F);
/*  81 */     setRotateAngle(this.HairF6, 0.14137167F, 0.0F, 0.0F);
/*  82 */     this.LegL = new ModelRenderer(this, 0, 45);
/*  83 */     this.LegL.field_78809_i = true;
/*  84 */     this.LegL.func_78793_a(2.1F, 11.0F, 0.0F);
/*  85 */     this.LegL.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/*  86 */     this.HairF2 = new ModelRenderer(this, 48, 33);
/*  87 */     this.HairF2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.HairF2.func_78790_a(1.0F, -8.7F, -5.5F, 2, 3, 3, 0.0F);
/*  89 */     setRotateAngle(this.HairF2, 0.0F, 0.0F, 0.22759093F);
/*  90 */     this.ShoulderR = new ModelRenderer(this, 3, 18);
/*  91 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.ShoulderR.func_78790_a(-5.0F, -0.9F, -1.8F, 6, 4, 4, 0.0F);
/*  93 */     this.Body3 = new ModelRenderer(this, 20, 43);
/*  94 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  96 */     this.ArmL = new ModelRenderer(this, 0, 27);
/*  97 */     this.ArmL.field_78809_i = true;
/*  98 */     this.ArmL.func_78793_a(5.0F, -0.1F, 0.0F);
/*  99 */     this.ArmL.func_78790_a(-1.2F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
/* 100 */     this.earL2 = new ModelRenderer(this, 30, 1);
/* 101 */     this.earL2.field_78809_i = true;
/* 102 */     this.earL2.func_78793_a(0.3F, 1.2F, 0.0F);
/* 103 */     this.earL2.func_78790_a(-0.5F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/* 104 */     setRotateAngle(this.earL2, 0.0F, 0.34906584F, 0.34906584F);
/* 105 */     this.HairR = new ModelRenderer(this, 47, 13);
/* 106 */     this.HairR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.HairR.func_78790_a(-3.9F, -11.4F, -3.3F, 2, 7, 5, 0.0F);
/* 108 */     setRotateAngle(this.HairR, 0.0F, -0.045378562F, -0.08028515F);
/* 109 */     this.HairF5 = new ModelRenderer(this, 50, 46);
/* 110 */     this.HairF5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.HairF5.func_78790_a(-4.0F, -7.1F, -6.1F, 2, 5, 1, 0.0F);
/* 112 */     setRotateAngle(this.HairF5, 0.27314404F, 0.0F, 0.0F);
/* 113 */     this.ArmR = new ModelRenderer(this, 0, 27);
/* 114 */     this.ArmR.func_78793_a(-5.0F, -0.1F, 0.0F);
/* 115 */     this.ArmR.func_78790_a(-1.9F, -0.8F, -1.8F, 3, 12, 4, -0.1F);
/* 116 */     this.earR2 = new ModelRenderer(this, 30, 1);
/* 117 */     this.earR2.func_78793_a(-0.5F, 1.2F, 0.0F);
/* 118 */     this.earR2.func_78790_a(-0.4F, -0.4F, -0.5F, 1, 1, 1, 0.0F);
/* 119 */     setRotateAngle(this.earR2, 0.0F, -0.34906584F, -0.34906584F);
/* 120 */     this.HairF4 = new ModelRenderer(this, 49, 41);
/* 121 */     this.HairF4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.HairF4.func_78790_a(-3.3F, -6.2F, -6.9F, 2, 2, 2, 0.0F);
/* 123 */     setRotateAngle(this.HairF4, -0.17453292F, 0.0F, 0.31869712F);
/* 124 */     this.LegR = new ModelRenderer(this, 0, 45);
/* 125 */     this.LegR.func_78793_a(-2.1F, 11.0F, 0.0F);
/* 126 */     this.LegR.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 13, 4, 0.0F);
/* 127 */     this.Body2 = new ModelRenderer(this, 23, 36);
/* 128 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 129 */     this.Body2.func_78790_a(-3.5F, 7.0F, -1.7F, 7, 2, 3, 0.0F);
/* 130 */     this.HairB1 = new ModelRenderer(this, 36, 13);
/* 131 */     this.HairB1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.HairB1.func_78790_a(-2.8F, -12.3F, -0.3F, 2, 7, 3, 0.0F);
/* 133 */     setRotateAngle(this.HairB1, 0.0F, 0.0F, -0.13665928F);
/* 134 */     this.HairBase = new ModelRenderer(this, 33, 0);
/* 135 */     this.HairBase.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     this.HairBase.func_78790_a(-2.9F, -11.6F, -4.0F, 6, 6, 7, 0.0F);
/* 137 */     setRotateAngle(this.HairBase, -0.18203785F, 0.0F, 0.0F);
/* 138 */     this.HairB2 = new ModelRenderer(this, 36, 13);
/* 139 */     this.HairB2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.HairB2.func_78790_a(1.5F, -12.2F, -0.4F, 2, 7, 3, 0.0F);
/* 141 */     setRotateAngle(this.HairB2, 0.0F, 0.0F, 0.2268928F);
/* 142 */     this.HairB4 = new ModelRenderer(this, 45, 26);
/* 143 */     this.HairB4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.HairB4.func_78790_a(-1.9F, -7.3F, -0.1F, 5, 3, 3, 0.0F);
/* 145 */     setRotateAngle(this.HairB4, 0.0F, 0.0F, -0.3577925F);
/* 146 */     this.HairM1 = new ModelRenderer(this, 49, 53);
/* 147 */     this.HairM1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.HairM1.func_78790_a(-0.6F, -14.1F, -2.4F, 3, 3, 4, 0.0F);
/* 149 */     this.earL = new ModelRenderer(this, 0, 4);
/* 150 */     this.earL.func_78793_a(3.2F, -1.9F, -1.5F);
/* 151 */     this.earL.func_78790_a(0.2F, -2.1F, 0.0F, 4, 3, 0, 0.0F);
/* 152 */     setRotateAngle(this.earL, 0.1134464F, -0.5235988F, -0.34906584F);
/* 153 */     this.HairF3 = new ModelRenderer(this, 49, 41);
/* 154 */     this.HairF3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.HairF3.func_78790_a(0.8F, -7.3F, -6.2F, 2, 2, 2, 0.0F);
/* 156 */     this.ArmL.func_78792_a(this.ShoulderL);
/* 157 */     this.HairB1.func_78792_a(this.HairB3);
/* 158 */     this.HairM1.func_78792_a(this.HairM2);
/* 159 */     this.HairBase.func_78792_a(this.HairF1);
/* 160 */     this.HairBase.func_78792_a(this.HairL);
/* 161 */     this.Body1.func_78792_a(this.BarrierofLight);
/* 162 */     this.Head.func_78792_a(this.earR);
/* 163 */     this.HairF3.func_78792_a(this.HairF6);
/* 164 */     this.HairF1.func_78792_a(this.HairF2);
/* 165 */     this.ArmR.func_78792_a(this.ShoulderR);
/* 166 */     this.Body2.func_78792_a(this.Body3);
/* 167 */     this.earL.func_78792_a(this.earL2);
/* 168 */     this.HairBase.func_78792_a(this.HairR);
/* 169 */     this.HairF4.func_78792_a(this.HairF5);
/* 170 */     this.earR.func_78792_a(this.earR2);
/* 171 */     this.HairF1.func_78792_a(this.HairF4);
/* 172 */     this.Body1.func_78792_a(this.Body2);
/* 173 */     this.HairBase.func_78792_a(this.HairB1);
/* 174 */     this.Head.func_78792_a(this.HairBase);
/* 175 */     this.HairB1.func_78792_a(this.HairB2);
/* 176 */     this.HairB1.func_78792_a(this.HairB4);
/* 177 */     this.HairBase.func_78792_a(this.HairM1);
/* 178 */     this.Head.func_78792_a(this.earL);
/* 179 */     this.HairF1.func_78792_a(this.HairF3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 184 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 187 */     this.LegL.func_78785_a(f5);
/* 188 */     this.Head.func_78785_a(f5);
/* 189 */     this.ArmL.func_78785_a(f5);
/* 190 */     this.ArmR.func_78785_a(f5);
/* 191 */     this.Body1.func_78785_a(f5);
/* 192 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 197 */     modelRenderer.field_78795_f = x;
/* 198 */     modelRenderer.field_78796_g = y;
/* 199 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 203 */     int calc = par7Entity.field_70173_aa;
/* 204 */     if (calc > 100) calc -= 100; 
/* 205 */     float r = 360.0F;
/* 206 */     float r2 = 180.0F;
/* 207 */     float n4 = par4;
/* 208 */     float n5 = par5;
/*     */     
/* 210 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 211 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 212 */     float ex = par7Entity.field_70173_aa;
/* 213 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 214 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 226 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 227 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 228 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 229 */     this.LegR.field_78796_g = 0.0F;
/* 230 */     this.LegL.field_78796_g = 0.0F;
/* 231 */     this.ArmR.field_78796_g = 0.0F;
/* 232 */     this.ArmL.field_78796_g = 0.0F;
/* 233 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelZamasu_Fused.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */