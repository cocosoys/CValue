/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKefla
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer HairFrontL1;
/*     */   public ModelRenderer Hair3;
/*     */   public ModelRenderer Hair4;
/*     */   public ModelRenderer Hair5;
/*     */   public ModelRenderer HairBand;
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer Ponytail1;
/*     */   public ModelRenderer Ponytail2;
/*     */   public ModelRenderer Ponytail3;
/*     */   public ModelRenderer Ponytail4;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelKefla() {
/*  36 */     this.field_78090_t = 64;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.Head = new ModelRenderer(this, 0, 0);
/*  39 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  40 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  41 */     this.ArmR = new ModelRenderer(this, 32, 29);
/*  42 */     this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
/*  43 */     this.ArmR.func_78790_a(-2.8F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  44 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  45 */     this.ArmL = new ModelRenderer(this, 32, 29);
/*  46 */     this.ArmL.field_78809_i = true;
/*  47 */     this.ArmL.func_78793_a(4.4F, 2.5F, 0.0F);
/*  48 */     this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  49 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  50 */     this.Hair5 = new ModelRenderer(this, 33, 10);
/*  51 */     this.Hair5.func_78793_a(2.9F, -5.8F, -2.3F);
/*  52 */     this.Hair5.func_78790_a(-0.7F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
/*  53 */     setRotateAngle(this.Hair5, 0.0F, -0.27314404F, 0.3642502F);
/*  54 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  55 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  56 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
/*  57 */     this.Hair4 = new ModelRenderer(this, 45, 12);
/*  58 */     this.Hair4.func_78793_a(-2.6F, -6.2F, -0.8F);
/*  59 */     this.Hair4.func_78790_a(-4.7F, -1.6F, -1.4F, 5, 3, 3, 0.0F);
/*  60 */     setRotateAngle(this.Hair4, 0.0F, -0.13665928F, -0.31869712F);
/*  61 */     this.Ponytail4 = new ModelRenderer(this, 40, 18);
/*  62 */     this.Ponytail4.func_78793_a(-0.1F, 0.7F, 0.8F);
/*  63 */     this.Ponytail4.func_78790_a(-0.5F, -1.5F, 0.0F, 1, 3, 5, 0.0F);
/*  64 */     setRotateAngle(this.Ponytail4, -0.8651597F, 0.0F, 0.0F);
/*  65 */     this.Hair1 = new ModelRenderer(this, 36, 0);
/*  66 */     this.Hair1.func_78793_a(-0.4F, -7.1F, 0.3F);
/*  67 */     this.Hair1.func_78790_a(-1.0F, -6.2F, -1.1F, 2, 7, 2, 0.0F);
/*  68 */     setRotateAngle(this.Hair1, 0.4098033F, 0.0F, -0.27314404F);
/*  69 */     this.Ponytail2 = new ModelRenderer(this, 46, 19);
/*  70 */     this.Ponytail2.func_78793_a(1.4F, 0.0F, 0.8F);
/*  71 */     this.Ponytail2.func_78790_a(-0.9F, -1.5F, 0.0F, 2, 3, 7, 0.0F);
/*  72 */     setRotateAngle(this.Ponytail2, -0.18203785F, 0.091106184F, 0.0F);
/*  73 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  74 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
/*  76 */     this.Boobs = new ModelRenderer(this, 19, 27);
/*  77 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
/*  79 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  80 */     this.HairFrontR2 = new ModelRenderer(this, 56, 5);
/*  81 */     this.HairFrontR2.func_78793_a(0.4F, 0.0F, -1.7F);
/*  82 */     this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 4, 1, 0.0F);
/*  83 */     setRotateAngle(this.HairFrontR2, -0.8196066F, 0.0F, 0.0F);
/*  84 */     this.Ponytail1 = new ModelRenderer(this, 46, 19);
/*  85 */     this.Ponytail1.func_78793_a(-0.1F, 0.0F, 0.8F);
/*  86 */     this.Ponytail1.func_78790_a(-0.9F, -1.5F, 0.0F, 2, 3, 7, 0.0F);
/*  87 */     setRotateAngle(this.Ponytail1, 0.31869712F, 0.0F, 0.0F);
/*  88 */     this.Body3 = new ModelRenderer(this, 0, 35);
/*  89 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.Body3.func_78790_a(-3.5F, 7.9F, -1.9F, 7, 3, 4, 0.0F);
/*  91 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  92 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  93 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  94 */     this.HairFrontR1 = new ModelRenderer(this, 56, 1);
/*  95 */     this.HairFrontR1.func_78793_a(-1.5F, -6.0F, -3.8F);
/*  96 */     this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -1.7F, 2, 1, 2, 0.0F);
/*  97 */     setRotateAngle(this.HairFrontR1, 0.4098033F, 0.8651597F, 0.0F);
/*  98 */     this.Hair = new ModelRenderer(this, 0, 0);
/*  99 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.Hair.func_78790_a(0.0F, -1.2F, 0.0F, 1, 1, 1, 0.0F);
/* 101 */     this.Hair2 = new ModelRenderer(this, 45, 0);
/* 102 */     this.Hair2.func_78793_a(-1.1F, -6.5F, -2.3F);
/* 103 */     this.Hair2.func_78790_a(-1.1F, -6.5F, -1.5F, 2, 7, 3, 0.0F);
/* 104 */     setRotateAngle(this.Hair2, 0.91053826F, 0.91053826F, 0.0F);
/* 105 */     this.Hair3 = new ModelRenderer(this, 25, 0);
/* 106 */     this.Hair3.func_78793_a(0.7F, -5.0F, -1.0F);
/* 107 */     this.Hair3.func_78790_a(-1.9F, -6.5F, -2.0F, 3, 5, 2, 0.0F);
/* 108 */     setRotateAngle(this.Hair3, 0.18203785F, -0.18203785F, 0.5009095F);
/* 109 */     this.HairFrontL1 = new ModelRenderer(this, 56, 1);
/* 110 */     this.HairFrontL1.func_78793_a(1.4F, -6.1F, -3.4F);
/* 111 */     this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -2.0F, 2, 1, 2, 0.0F);
/* 112 */     setRotateAngle(this.HairFrontL1, 0.22759093F, -0.5462881F, 0.0F);
/* 113 */     this.LegL = new ModelRenderer(this, 0, 46);
/* 114 */     this.LegL.field_78809_i = true;
/* 115 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/* 116 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 117 */     this.HairBand = new ModelRenderer(this, 34, 15);
/* 118 */     this.HairBand.func_78793_a(-0.2F, -6.4F, 3.0F);
/* 119 */     this.HairBand.func_78790_a(-1.5F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
/* 120 */     setRotateAngle(this.HairBand, 0.5462881F, 0.0F, 0.0F);
/* 121 */     this.HairFrontL2 = new ModelRenderer(this, 56, 5);
/* 122 */     this.HairFrontL2.func_78793_a(0.1F, 0.1F, -1.7F);
/* 123 */     this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 5, 1, 0.0F);
/* 124 */     setRotateAngle(this.HairFrontL2, -0.5009095F, 0.0F, 0.0F);
/* 125 */     this.Ponytail3 = new ModelRenderer(this, 40, 18);
/* 126 */     this.Ponytail3.func_78793_a(-0.8F, 0.0F, 0.8F);
/* 127 */     this.Ponytail3.func_78790_a(-0.9F, -1.0F, 0.0F, 1, 2, 5, 0.0F);
/* 128 */     setRotateAngle(this.Ponytail3, 0.5462881F, -0.27314404F, -0.009075712F);
/* 129 */     this.Hair.func_78792_a(this.Hair5);
/* 130 */     this.Hair.func_78792_a(this.Hair4);
/* 131 */     this.HairBand.func_78792_a(this.Ponytail4);
/* 132 */     this.Hair.func_78792_a(this.Hair1);
/* 133 */     this.HairBand.func_78792_a(this.Ponytail2);
/* 134 */     this.Body1.func_78792_a(this.Body2);
/* 135 */     this.Body1.func_78792_a(this.Boobs);
/* 136 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 137 */     this.HairBand.func_78792_a(this.Ponytail1);
/* 138 */     this.Body2.func_78792_a(this.Body3);
/* 139 */     this.Hair.func_78792_a(this.HairFrontR1);
/* 140 */     this.Head.func_78792_a(this.Hair);
/* 141 */     this.Hair.func_78792_a(this.Hair2);
/* 142 */     this.Hair.func_78792_a(this.Hair3);
/* 143 */     this.Hair.func_78792_a(this.HairFrontL1);
/* 144 */     this.Hair.func_78792_a(this.HairBand);
/* 145 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 146 */     this.HairBand.func_78792_a(this.Ponytail3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 151 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 154 */     this.LegL.func_78785_a(f5);
/* 155 */     this.Head.func_78785_a(f5);
/* 156 */     this.ArmL.func_78785_a(f5);
/* 157 */     this.ArmR.func_78785_a(f5);
/* 158 */     this.Body1.func_78785_a(f5);
/* 159 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 165 */     modelRenderer.field_78795_f = x;
/* 166 */     modelRenderer.field_78796_g = y;
/* 167 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 171 */     int calc = par7Entity.field_70173_aa;
/* 172 */     if (calc > 100) calc -= 100; 
/* 173 */     float r = 360.0F;
/* 174 */     float r2 = 180.0F;
/* 175 */     float n4 = par4;
/* 176 */     float n5 = par5;
/*     */     
/* 178 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 179 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 180 */     float ex = par7Entity.field_70173_aa;
/* 181 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 182 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 184 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 185 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 231 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 234 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 236 */     this.LegR.field_78796_g = 0.0F;
/* 237 */     this.LegL.field_78796_g = 0.0F;
/* 238 */     this.ArmR.field_78796_g = 0.0F;
/* 239 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKefla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */