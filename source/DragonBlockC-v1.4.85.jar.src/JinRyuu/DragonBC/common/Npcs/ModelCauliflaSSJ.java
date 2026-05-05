/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCauliflaSSJ
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer HairR2;
/*     */   public ModelRenderer HairR1;
/*     */   public ModelRenderer HairFrontL1;
/*     */   public ModelRenderer HairL1;
/*     */   public ModelRenderer HairR3;
/*     */   public ModelRenderer HairL2;
/*     */   public ModelRenderer HairL3;
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelCauliflaSSJ() {
/*  36 */     this.field_78090_t = 64;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.LegL2 = new ModelRenderer(this, 0, 46);
/*  39 */     this.LegL2.field_78809_i = true;
/*  40 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
/*  42 */     this.Body3 = new ModelRenderer(this, 0, 35);
/*  43 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Body3.func_78790_a(-3.5F, 7.9F, -2.0F, 7, 3, 4, 0.0F);
/*  45 */     this.HairFrontL1 = new ModelRenderer(this, 54, 1);
/*  46 */     this.HairFrontL1.func_78793_a(1.3F, -0.4F, -2.7F);
/*  47 */     this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  48 */     setRotateAngle(this.HairFrontL1, 0.27314404F, -0.3000221F, -0.22759093F);
/*  49 */     this.Boobs = new ModelRenderer(this, 19, 27);
/*  50 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.Boobs.func_78790_a(-3.0F, 1.6F, -0.9F, 6, 3, 2, 0.0F);
/*  52 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  53 */     this.FeetL = new ModelRenderer(this, 17, 58);
/*  54 */     this.FeetL.field_78809_i = true;
/*  55 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.FeetL.func_78790_a(-1.5F, 10.0F, -2.5F, 3, 2, 4, 0.0F);
/*  57 */     this.HairR3 = new ModelRenderer(this, 50, 12);
/*  58 */     this.HairR3.func_78793_a(-3.2F, 1.7F, 2.7F);
/*  59 */     this.HairR3.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
/*  60 */     setRotateAngle(this.HairR3, 0.715585F, -0.5009095F, -0.4098033F);
/*  61 */     this.HairR1 = new ModelRenderer(this, 37, 0);
/*  62 */     this.HairR1.func_78793_a(-1.1F, -0.2F, -0.4F);
/*  63 */     this.HairR1.func_78790_a(-2.6F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
/*  64 */     setRotateAngle(this.HairR1, -0.40142572F, -0.13665928F, -0.2268928F);
/*  65 */     this.HairL2 = new ModelRenderer(this, 31, 12);
/*  66 */     this.HairL2.func_78793_a(2.9F, -0.1F, -0.1F);
/*  67 */     this.HairL2.func_78790_a(-3.3F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
/*  68 */     setRotateAngle(this.HairL2, 0.6981317F, 0.6981317F, 0.2268928F);
/*  69 */     this.HairFrontL2 = new ModelRenderer(this, 54, 5);
/*  70 */     this.HairFrontL2.func_78793_a(0.1F, 0.1F, -0.8F);
/*  71 */     this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
/*  72 */     setRotateAngle(this.HairFrontL2, 0.0F, 0.0F, -0.31869712F);
/*  73 */     this.LegL = new ModelRenderer(this, 0, 54);
/*  74 */     this.LegL.field_78809_i = true;
/*  75 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  76 */     this.LegL.func_78790_a(-1.8F, 3.7F, -2.0F, 4, 6, 4, 0.3F);
/*  77 */     this.Hair = new ModelRenderer(this, 26, 0);
/*  78 */     this.Hair.func_78793_a(0.0F, -4.6F, -1.1F);
/*  79 */     this.Hair.func_78790_a(-1.5F, -7.0F, -2.6F, 3, 6, 2, 0.0F);
/*  80 */     setRotateAngle(this.Hair, -0.53215086F, 0.045553092F, 0.0F);
/*  81 */     this.HairFrontR1 = new ModelRenderer(this, 54, 1);
/*  82 */     this.HairFrontR1.func_78793_a(-0.9F, 0.1F, -2.8F);
/*  83 */     this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 1, 1, 0.0F);
/*  84 */     setRotateAngle(this.HairFrontR1, 0.045553092F, 0.091106184F, -0.05863736F);
/*  85 */     this.HairL1 = new ModelRenderer(this, 37, 0);
/*  86 */     this.HairL1.func_78793_a(1.4F, -0.3F, 0.2F);
/*  87 */     this.HairL1.func_78790_a(-1.9F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
/*  88 */     setRotateAngle(this.HairL1, -0.40142572F, 0.045553092F, 0.2268928F);
/*  89 */     this.HairL3 = new ModelRenderer(this, 50, 12);
/*  90 */     this.HairL3.func_78793_a(2.7F, 1.7F, 2.7F);
/*  91 */     this.HairL3.func_78790_a(-2.0F, -1.0F, -1.0F, 3, 2, 4, 0.0F);
/*  92 */     setRotateAngle(this.HairL3, 0.715585F, 0.5009095F, 0.4098033F);
/*  93 */     this.ArmR = new ModelRenderer(this, 32, 29);
/*  94 */     this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
/*  95 */     this.ArmR.func_78790_a(-1.7F, -1.3F, -1.8F, 3, 12, 4, -0.3F);
/*  96 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  97 */     this.ArmL = new ModelRenderer(this, 32, 29);
/*  98 */     this.ArmL.field_78809_i = true;
/*  99 */     this.ArmL.func_78793_a(4.3F, 2.5F, 0.0F);
/* 100 */     this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 3, 12, 4, -0.3F);
/* 101 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/* 102 */     this.Body2 = new ModelRenderer(this, 0, 27);
/* 103 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.7F, 6, 4, 3, 0.0F);
/* 105 */     this.FeetR = new ModelRenderer(this, 17, 58);
/* 106 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.FeetR.func_78790_a(-1.5F, 10.0F, -2.5F, 3, 2, 4, 0.0F);
/* 108 */     this.Head = new ModelRenderer(this, 0, 0);
/* 109 */     this.Head.func_78793_a(0.0F, 1.6F, 0.0F);
/* 110 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.7F);
/* 111 */     this.Body1 = new ModelRenderer(this, 0, 17);
/* 112 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/* 113 */     this.Body1.func_78790_a(-3.5F, 0.0F, -1.9F, 7, 5, 4, -0.2F);
/* 114 */     this.LegR = new ModelRenderer(this, 0, 54);
/* 115 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/* 116 */     this.LegR.func_78790_a(-2.2F, 3.7F, -2.0F, 4, 6, 4, 0.3F);
/* 117 */     this.HairR2 = new ModelRenderer(this, 31, 12);
/* 118 */     this.HairR2.func_78793_a(-2.7F, -0.1F, -0.1F);
/* 119 */     this.HairR2.func_78790_a(-1.0F, -1.9F, -0.5F, 4, 4, 5, 0.0F);
/* 120 */     setRotateAngle(this.HairR2, 0.6981317F, -0.6981317F, -0.2268928F);
/* 121 */     this.HairFrontR2 = new ModelRenderer(this, 54, 5);
/* 122 */     this.HairFrontR2.func_78793_a(-0.4F, -0.3F, -0.1F);
/* 123 */     this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.8F, 2, 4, 1, 0.0F);
/* 124 */     setRotateAngle(this.HairFrontR2, -0.07679449F, -0.13665928F, 2.6406832F);
/* 125 */     this.LegR2 = new ModelRenderer(this, 0, 46);
/* 126 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
/* 128 */     this.LegL.func_78792_a(this.LegL2);
/* 129 */     this.Body2.func_78792_a(this.Body3);
/* 130 */     this.Hair.func_78792_a(this.HairFrontL1);
/* 131 */     this.Body1.func_78792_a(this.Boobs);
/* 132 */     this.LegL.func_78792_a(this.FeetL);
/* 133 */     this.Hair.func_78792_a(this.HairR3);
/* 134 */     this.Hair.func_78792_a(this.HairR1);
/* 135 */     this.Hair.func_78792_a(this.HairL2);
/* 136 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 137 */     this.Head.func_78792_a(this.Hair);
/* 138 */     this.Hair.func_78792_a(this.HairFrontR1);
/* 139 */     this.Hair.func_78792_a(this.HairL1);
/* 140 */     this.Hair.func_78792_a(this.HairL3);
/* 141 */     this.Body1.func_78792_a(this.Body2);
/* 142 */     this.LegR.func_78792_a(this.FeetR);
/* 143 */     this.Hair.func_78792_a(this.HairR2);
/* 144 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 145 */     this.LegR.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 150 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 153 */     this.LegL.func_78785_a(f5);
/* 154 */     this.Head.func_78785_a(f5);
/* 155 */     this.ArmL.func_78785_a(f5);
/* 156 */     this.ArmR.func_78785_a(f5);
/* 157 */     this.Body1.func_78785_a(f5);
/* 158 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 164 */     modelRenderer.field_78795_f = x;
/* 165 */     modelRenderer.field_78796_g = y;
/* 166 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 170 */     int calc = par7Entity.field_70173_aa;
/* 171 */     if (calc > 100) calc -= 100; 
/* 172 */     float r = 360.0F;
/* 173 */     float r2 = 180.0F;
/* 174 */     float n4 = par4;
/* 175 */     float n5 = par5;
/*     */     
/* 177 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 178 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 179 */     float ex = par7Entity.field_70173_aa;
/* 180 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 181 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 183 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 184 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 231 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 235 */     this.LegR.field_78796_g = 0.0F;
/* 236 */     this.LegL.field_78796_g = 0.0F;
/* 237 */     this.ArmR.field_78796_g = 0.0F;
/* 238 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelCauliflaSSJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */