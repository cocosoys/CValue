/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKeflaSSJ
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
/*     */   public ModelRenderer HairFrontR1;
/*     */   public ModelRenderer Hair6;
/*     */   public ModelRenderer Hair7;
/*     */   public ModelRenderer Hair8;
/*     */   public ModelRenderer Hair9;
/*     */   public ModelRenderer Hair10;
/*     */   public ModelRenderer Hair11;
/*     */   public ModelRenderer HairFrontL2;
/*     */   public ModelRenderer HairFrontR2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelKeflaSSJ() {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 64;
/*  39 */     this.Hair1 = new ModelRenderer(this, 36, 0);
/*  40 */     this.Hair1.field_78809_i = true;
/*  41 */     this.Hair1.func_78793_a(-0.2F, -7.0F, -0.3F);
/*  42 */     this.Hair1.func_78790_a(-1.0F, -6.2F, -1.1F, 2, 7, 2, 0.0F);
/*  43 */     setRotateAngle(this.Hair1, 0.4098033F, 0.0F, -0.27314404F);
/*  44 */     this.HairFrontR1 = new ModelRenderer(this, 56, 1);
/*  45 */     this.HairFrontR1.func_78793_a(-1.5F, -6.0F, -3.8F);
/*  46 */     this.HairFrontR1.func_78790_a(-1.0F, -0.3F, -1.7F, 2, 1, 2, 0.0F);
/*  47 */     setRotateAngle(this.HairFrontR1, 0.4098033F, 0.8651597F, 0.0F);
/*  48 */     this.Hair4 = new ModelRenderer(this, 45, 12);
/*  49 */     this.Hair4.func_78793_a(-2.6F, -6.2F, -0.8F);
/*  50 */     this.Hair4.func_78790_a(-4.7F, -1.6F, -1.4F, 5, 3, 3, 0.0F);
/*  51 */     setRotateAngle(this.Hair4, 0.0F, -0.13665928F, -0.31869712F);
/*  52 */     this.Hair2 = new ModelRenderer(this, 45, 0);
/*  53 */     this.Hair2.func_78793_a(-1.1F, -6.5F, -2.3F);
/*  54 */     this.Hair2.func_78790_a(-1.1F, -6.5F, -1.5F, 2, 7, 3, 0.0F);
/*  55 */     setRotateAngle(this.Hair2, 0.91053826F, 0.91053826F, 0.0F);
/*  56 */     this.Hair7 = new ModelRenderer(this, 46, 30);
/*  57 */     this.Hair7.func_78793_a(-1.1F, -7.3F, 0.7F);
/*  58 */     this.Hair7.func_78790_a(-2.6F, -6.3F, -2.0F, 4, 7, 4, 0.0F);
/*  59 */     setRotateAngle(this.Hair7, -0.40142572F, -0.13665928F, -0.2268928F);
/*  60 */     this.Hair9 = new ModelRenderer(this, 44, 19);
/*  61 */     this.Hair9.func_78793_a(2.9F, -4.1F, -0.1F);
/*  62 */     this.Hair9.func_78790_a(-3.3F, -1.9F, -0.7F, 4, 4, 6, 0.0F);
/*  63 */     setRotateAngle(this.Hair9, 0.6981317F, 0.6981317F, 0.2268928F);
/*  64 */     this.ArmL = new ModelRenderer(this, 23, 33);
/*  65 */     this.ArmL.field_78809_i = true;
/*  66 */     this.ArmL.func_78793_a(4.4F, 2.5F, 0.0F);
/*  67 */     this.ArmL.func_78790_a(-1.3F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  68 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  69 */     this.ArmR = new ModelRenderer(this, 23, 33);
/*  70 */     this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
/*  71 */     this.ArmR.func_78790_a(-2.8F, -1.3F, -1.8F, 4, 12, 4, -0.3F);
/*  72 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  73 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  74 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
/*  76 */     this.HairFrontR2 = new ModelRenderer(this, 56, 5);
/*  77 */     this.HairFrontR2.func_78793_a(0.4F, 0.0F, -1.7F);
/*  78 */     this.HairFrontR2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 4, 1, 0.0F);
/*  79 */     setRotateAngle(this.HairFrontR2, -0.8196066F, 0.0F, 0.0F);
/*  80 */     this.Hair3 = new ModelRenderer(this, 25, 0);
/*  81 */     this.Hair3.func_78793_a(0.7F, -5.0F, -1.0F);
/*  82 */     this.Hair3.func_78790_a(-1.9F, -6.5F, -2.0F, 3, 5, 2, 0.0F);
/*  83 */     setRotateAngle(this.Hair3, 0.18203785F, -0.18203785F, 0.5009095F);
/*  84 */     this.Hair11 = new ModelRenderer(this, 34, 18);
/*  85 */     this.Hair11.func_78793_a(-2.1F, -1.8F, 0.4F);
/*  86 */     this.Hair11.func_78790_a(-1.0F, -0.6F, 0.1F, 2, 1, 4, 0.0F);
/*  87 */     setRotateAngle(this.Hair11, 0.3642502F, -0.5009095F, -0.4098033F);
/*  88 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  89 */     this.LegL.field_78809_i = true;
/*  90 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  91 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  92 */     this.Hair10 = new ModelRenderer(this, 34, 18);
/*  93 */     this.Hair10.field_78809_i = true;
/*  94 */     this.Hair10.func_78793_a(2.5F, -2.0F, 0.4F);
/*  95 */     this.Hair10.func_78790_a(-1.0F, -1.0F, -0.1F, 2, 1, 4, 0.0F);
/*  96 */     setRotateAngle(this.Hair10, 0.045553092F, 0.5009095F, 0.4098033F);
/*  97 */     this.HairFrontL2 = new ModelRenderer(this, 56, 5);
/*  98 */     this.HairFrontL2.func_78793_a(0.1F, 0.1F, -1.7F);
/*  99 */     this.HairFrontL2.func_78790_a(-1.0F, -0.3F, -0.5F, 2, 5, 1, 0.0F);
/* 100 */     setRotateAngle(this.HairFrontL2, -0.5009095F, 0.0F, 0.0F);
/* 101 */     this.Body3 = new ModelRenderer(this, 0, 35);
/* 102 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.Body3.func_78790_a(-3.5F, 7.9F, -1.9F, 7, 3, 4, 0.0F);
/* 104 */     this.Head = new ModelRenderer(this, 0, 0);
/* 105 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/* 106 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/* 107 */     this.Hair = new ModelRenderer(this, 0, 0);
/* 108 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.Hair.func_78790_a(0.0F, -1.2F, 0.0F, 1, 1, 1, 0.0F);
/* 110 */     this.Hair8 = new ModelRenderer(this, 46, 30);
/* 111 */     this.Hair8.func_78793_a(1.4F, -6.3F, 0.7F);
/* 112 */     this.Hair8.func_78790_a(-1.9F, -6.5F, -2.0F, 4, 7, 4, 0.0F);
/* 113 */     setRotateAngle(this.Hair8, -0.40142572F, 0.045553092F, 0.2268928F);
/* 114 */     this.Boobs = new ModelRenderer(this, 19, 27);
/* 115 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
/* 117 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/* 118 */     this.Hair6 = new ModelRenderer(this, 44, 19);
/* 119 */     this.Hair6.func_78793_a(-2.7F, -4.3F, -0.1F);
/* 120 */     this.Hair6.func_78790_a(-1.0F, -1.9F, -0.5F, 4, 4, 6, 0.0F);
/* 121 */     setRotateAngle(this.Hair6, 0.6981317F, -0.6981317F, -0.2268928F);
/* 122 */     this.Body1 = new ModelRenderer(this, 0, 17);
/* 123 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/* 124 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
/* 125 */     this.HairFrontL1 = new ModelRenderer(this, 56, 1);
/* 126 */     this.HairFrontL1.func_78793_a(1.4F, -6.1F, -3.4F);
/* 127 */     this.HairFrontL1.func_78790_a(-1.0F, -0.3F, -2.0F, 2, 1, 2, 0.0F);
/* 128 */     setRotateAngle(this.HairFrontL1, 0.22759093F, -0.5462881F, 0.0F);
/* 129 */     this.Hair5 = new ModelRenderer(this, 33, 10);
/* 130 */     this.Hair5.func_78793_a(2.9F, -5.8F, -2.3F);
/* 131 */     this.Hair5.func_78790_a(-0.7F, -1.0F, -1.0F, 5, 2, 2, 0.0F);
/* 132 */     setRotateAngle(this.Hair5, 0.0F, -0.27314404F, 0.3642502F);
/* 133 */     this.LegR = new ModelRenderer(this, 0, 46);
/* 134 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/* 135 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 136 */     this.Hair.func_78792_a(this.Hair1);
/* 137 */     this.Hair.func_78792_a(this.HairFrontR1);
/* 138 */     this.Hair.func_78792_a(this.Hair4);
/* 139 */     this.Hair.func_78792_a(this.Hair2);
/* 140 */     this.Hair.func_78792_a(this.Hair7);
/* 141 */     this.Hair.func_78792_a(this.Hair9);
/* 142 */     this.Body1.func_78792_a(this.Body2);
/* 143 */     this.HairFrontR1.func_78792_a(this.HairFrontR2);
/* 144 */     this.Hair.func_78792_a(this.Hair3);
/* 145 */     this.Hair.func_78792_a(this.Hair11);
/* 146 */     this.Hair.func_78792_a(this.Hair10);
/* 147 */     this.HairFrontL1.func_78792_a(this.HairFrontL2);
/* 148 */     this.Body2.func_78792_a(this.Body3);
/* 149 */     this.Head.func_78792_a(this.Hair);
/* 150 */     this.Hair.func_78792_a(this.Hair8);
/* 151 */     this.Body1.func_78792_a(this.Boobs);
/* 152 */     this.Hair.func_78792_a(this.Hair6);
/* 153 */     this.Hair.func_78792_a(this.HairFrontL1);
/* 154 */     this.Hair.func_78792_a(this.Hair5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 159 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 162 */     this.LegL.func_78785_a(f5);
/* 163 */     this.Head.func_78785_a(f5);
/* 164 */     this.ArmL.func_78785_a(f5);
/* 165 */     this.ArmR.func_78785_a(f5);
/* 166 */     this.Body1.func_78785_a(f5);
/* 167 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 173 */     modelRenderer.field_78795_f = x;
/* 174 */     modelRenderer.field_78796_g = y;
/* 175 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 179 */     int calc = par7Entity.field_70173_aa;
/* 180 */     if (calc > 100) calc -= 100; 
/* 181 */     float r = 360.0F;
/* 182 */     float r2 = 180.0F;
/* 183 */     float n4 = par4;
/* 184 */     float n5 = par5;
/*     */     
/* 186 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 187 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 188 */     float ex = par7Entity.field_70173_aa;
/* 189 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 190 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 192 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 193 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 240 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 241 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 242 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 244 */     this.LegR.field_78796_g = 0.0F;
/* 245 */     this.LegL.field_78796_g = 0.0F;
/* 246 */     this.ArmR.field_78796_g = 0.0F;
/* 247 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKeflaSSJ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */