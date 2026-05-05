/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodArak
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer WhiskersR1;
/*     */   public ModelRenderer WhiskersR1_1;
/*     */   public ModelRenderer WhiskersR2;
/*     */   public ModelRenderer WhiskersR3;
/*     */   public ModelRenderer WhiskersR4;
/*     */   public ModelRenderer WhiskersR2_1;
/*     */   public ModelRenderer WhiskersR3_1;
/*     */   public ModelRenderer WhiskersR4_1;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer ArmRingR1;
/*     */   public ModelRenderer ArmRingR2;
/*     */   public ModelRenderer ArmRingL1;
/*     */   public ModelRenderer ArmRingL2;
/*     */   
/*     */   public ModelGodArak() {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 64;
/*  39 */     this.WhiskersR1_1 = new ModelRenderer(this, 31, 1);
/*  40 */     this.WhiskersR1_1.func_78793_a(3.8F, -3.1F, -0.7F);
/*  41 */     this.WhiskersR1_1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
/*  42 */     setRotateAngle(this.WhiskersR1_1, 0.27314404F, -0.4553564F, -1.1383038F);
/*  43 */     this.ArmR = new ModelRenderer(this, 50, 16);
/*  44 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  45 */     this.ArmR.func_78790_a(-2.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/*  46 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  47 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Body2.func_78790_a(-3.5F, 5.0F, -3.1F, 7, 3, 5, 0.0F);
/*  49 */     this.ArmRingL2 = new ModelRenderer(this, 25, 51);
/*  50 */     this.ArmRingL2.field_78809_i = true;
/*  51 */     this.ArmRingL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.ArmRingL2.func_78790_a(-0.4F, 7.4F, -2.3F, 4, 1, 5, 0.0F);
/*  53 */     setRotateAngle(this.ArmRingL2, 0.0F, 0.0F, 0.10471976F);
/*  54 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-1.8F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/*  58 */     this.Hair = new ModelRenderer(this, 0, 45);
/*  59 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Hair.func_78790_a(-3.5F, -11.8F, -2.6F, 7, 5, 6, 0.0F);
/*  61 */     setRotateAngle(this.Hair, -0.034906585F, 0.0F, 0.0F);
/*  62 */     this.LegL2 = new ModelRenderer(this, 0, 16);
/*  63 */     this.LegL2.field_78809_i = true;
/*  64 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.LegL2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  66 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  67 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 5, 4, 0.0F);
/*  69 */     this.WhiskersR3 = new ModelRenderer(this, 31, 1);
/*  70 */     this.WhiskersR3.func_78793_a(0.8F, 0.0F, -0.2F);
/*  71 */     this.WhiskersR3.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
/*  72 */     setRotateAngle(this.WhiskersR3, 0.0F, 0.091106184F, -0.13665928F);
/*  73 */     this.ArmRingL1 = new ModelRenderer(this, 25, 51);
/*  74 */     this.ArmRingL1.field_78809_i = true;
/*  75 */     this.ArmRingL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.ArmRingL1.func_78790_a(-1.3F, 6.4F, -2.3F, 4, 1, 5, 0.0F);
/*  77 */     this.Body3 = new ModelRenderer(this, 21, 38);
/*  78 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Body3.func_78790_a(-3.5F, 8.0F, -2.9F, 7, 4, 5, 0.0F);
/*  80 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  81 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  82 */     this.LegR.func_78790_a(-2.3F, 1.4F, -2.0F, 4, 6, 4, 0.3F);
/*  83 */     this.Neck = new ModelRenderer(this, 42, 6);
/*  84 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.Neck.func_78790_a(-2.0F, -1.6F, -0.8F, 4, 2, 2, 0.0F);
/*  86 */     this.WhiskersR1 = new ModelRenderer(this, 31, 1);
/*  87 */     this.WhiskersR1.func_78793_a(-3.8F, -3.1F, -0.7F);
/*  88 */     this.WhiskersR1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
/*  89 */     setRotateAngle(this.WhiskersR1, 0.27314404F, 0.4553564F, 1.1383038F);
/*  90 */     this.Cloth1 = new ModelRenderer(this, 47, 51);
/*  91 */     this.Cloth1.func_78793_a(0.0F, 9.9F, -2.5F);
/*  92 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 8, 0, 0.0F);
/*  93 */     setRotateAngle(this.Cloth1, -0.057595864F, 0.0F, 0.0F);
/*  94 */     this.Head = new ModelRenderer(this, 0, 0);
/*  95 */     this.Head.func_78793_a(0.0F, -1.2F, 0.0F);
/*  96 */     this.Head.func_78790_a(-4.0F, -7.0F, -4.3F, 8, 7, 8, 0.0F);
/*  97 */     this.WhiskersR3_1 = new ModelRenderer(this, 31, 1);
/*  98 */     this.WhiskersR3_1.func_78793_a(-0.9F, 0.0F, -0.2F);
/*  99 */     this.WhiskersR3_1.func_78790_a(-0.6F, 0.0F, -0.2F, 1, 3, 0, 0.0F);
/* 100 */     setRotateAngle(this.WhiskersR3_1, 0.0F, 0.098087505F, 0.12967797F);
/* 101 */     this.ArmL = new ModelRenderer(this, 50, 16);
/* 102 */     this.ArmL.field_78809_i = true;
/* 103 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/* 104 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 3, 12, 4, 0.0F);
/* 105 */     this.WhiskersR2 = new ModelRenderer(this, 31, 1);
/* 106 */     this.WhiskersR2.func_78793_a(1.2F, 0.5F, 0.1F);
/* 107 */     this.WhiskersR2.func_78790_a(-0.7F, -0.1F, -0.3F, 1, 3, 0, 0.0F);
/* 108 */     setRotateAngle(this.WhiskersR2, 0.0F, 0.045553092F, -0.091106184F);
/* 109 */     this.LegR2 = new ModelRenderer(this, 0, 16);
/* 110 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.LegR2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/* 112 */     this.WhiskersR4 = new ModelRenderer(this, 31, 1);
/* 113 */     this.WhiskersR4.func_78793_a(1.0F, 0.0F, -0.1F);
/* 114 */     this.WhiskersR4.func_78790_a(-0.6F, 0.1F, -0.2F, 1, 3, 0, 0.0F);
/* 115 */     setRotateAngle(this.WhiskersR4, 0.0F, 0.0F, -0.18203785F);
/* 116 */     this.WhiskersR4_1 = new ModelRenderer(this, 31, 1);
/* 117 */     this.WhiskersR4_1.func_78793_a(-0.8F, 0.0F, -0.1F);
/* 118 */     this.WhiskersR4_1.func_78790_a(-0.6F, 0.1F, -0.2F, 1, 3, 0, 0.0F);
/* 119 */     setRotateAngle(this.WhiskersR4_1, 0.0F, 0.0F, 0.12618731F);
/* 120 */     this.WhiskersR2_1 = new ModelRenderer(this, 31, 1);
/* 121 */     this.WhiskersR2_1.func_78793_a(-0.9F, 0.3F, 0.1F);
/* 122 */     this.WhiskersR2_1.func_78790_a(-0.7F, -0.1F, -0.3F, 1, 3, 0, 0.0F);
/* 123 */     setRotateAngle(this.WhiskersR2_1, 0.0F, -0.026005406F, 0.06667158F);
/* 124 */     this.ArmRingR2 = new ModelRenderer(this, 25, 51);
/* 125 */     this.ArmRingR2.field_78809_i = true;
/* 126 */     this.ArmRingR2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.ArmRingR2.func_78790_a(-3.6F, 7.4F, -2.3F, 4, 1, 5, 0.0F);
/* 128 */     setRotateAngle(this.ArmRingR2, 0.0F, 0.0F, -0.10471976F);
/* 129 */     this.ArmRingR1 = new ModelRenderer(this, 25, 51);
/* 130 */     this.ArmRingR1.field_78809_i = true;
/* 131 */     this.ArmRingR1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.ArmRingR1.func_78790_a(-2.7F, 6.4F, -2.3F, 4, 1, 5, 0.0F);
/* 133 */     this.Head.func_78792_a(this.WhiskersR1_1);
/* 134 */     this.Body1.func_78792_a(this.Body2);
/* 135 */     this.ArmRingL1.func_78792_a(this.ArmRingL2);
/* 136 */     this.Head.func_78792_a(this.Hair);
/* 137 */     this.LegL.func_78792_a(this.LegL2);
/* 138 */     this.WhiskersR2.func_78792_a(this.WhiskersR3);
/* 139 */     this.ArmL.func_78792_a(this.ArmRingL1);
/* 140 */     this.Body2.func_78792_a(this.Body3);
/* 141 */     this.Body1.func_78792_a(this.Neck);
/* 142 */     this.Head.func_78792_a(this.WhiskersR1);
/* 143 */     this.Body1.func_78792_a(this.Cloth1);
/* 144 */     this.WhiskersR2_1.func_78792_a(this.WhiskersR3_1);
/* 145 */     this.WhiskersR1.func_78792_a(this.WhiskersR2);
/* 146 */     this.LegR.func_78792_a(this.LegR2);
/* 147 */     this.WhiskersR3.func_78792_a(this.WhiskersR4);
/* 148 */     this.WhiskersR3_1.func_78792_a(this.WhiskersR4_1);
/* 149 */     this.WhiskersR1_1.func_78792_a(this.WhiskersR2_1);
/* 150 */     this.ArmRingR1.func_78792_a(this.ArmRingR2);
/* 151 */     this.ArmR.func_78792_a(this.ArmRingR1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 156 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 159 */     this.LegL.func_78785_a(f5);
/* 160 */     this.Head.func_78785_a(f5);
/* 161 */     this.ArmL.func_78785_a(f5);
/* 162 */     this.ArmR.func_78785_a(f5);
/* 163 */     this.Body1.func_78785_a(f5);
/* 164 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 170 */     modelRenderer.field_78795_f = x;
/* 171 */     modelRenderer.field_78796_g = y;
/* 172 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 176 */     int calc = par7Entity.field_70173_aa;
/* 177 */     if (calc > 100) calc -= 100; 
/* 178 */     float r = 360.0F;
/* 179 */     float r2 = 180.0F;
/* 180 */     float n4 = par4;
/* 181 */     float n5 = par5;
/*     */     
/* 183 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 184 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 185 */     float ex = par7Entity.field_70173_aa;
/* 186 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 187 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 189 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 190 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 237 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 238 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 239 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 241 */     this.LegR.field_78796_g = 0.0F;
/* 242 */     this.LegL.field_78796_g = 0.0F;
/* 243 */     this.ArmR.field_78796_g = 0.0F;
/* 244 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 247 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 251 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodArak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */