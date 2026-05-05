/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBiarra
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR1;
/*     */   public ModelRenderer LegL1;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ChestJewelL;
/*     */   public ModelRenderer ChestJewelR;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body3_1;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmJewelR;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer ArmJewelL;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegR3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegL3;
/*     */   
/*     */   public ModelBiarra() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 64;
/*  38 */     this.Body3 = new ModelRenderer(this, 0, 48);
/*  39 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Body3.func_78790_a(-5.5F, 15.0F, -2.9F, 11, 6, 7, 0.0F);
/*  41 */     this.ArmL1 = new ModelRenderer(this, 101, 2);
/*  42 */     this.ArmL1.field_78809_i = true;
/*  43 */     this.ArmL1.func_78793_a(7.0F, -11.5F, 0.5F);
/*  44 */     this.ArmL1.func_78790_a(0.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/*  45 */     setRotateAngle(this.ArmL1, 0.04363323F, 0.0F, 0.0F);
/*  46 */     this.ChestJewelR = new ModelRenderer(this, 38, 0);
/*  47 */     this.ChestJewelR.func_78793_a(-5.6F, 8.8F, -3.3F);
/*  48 */     this.ChestJewelR.func_78790_a(-1.0F, -0.9F, -1.0F, 2, 2, 1, 0.0F);
/*  49 */     this.ArmJewelL = new ModelRenderer(this, 29, 0);
/*  50 */     this.ArmJewelL.field_78809_i = true;
/*  51 */     this.ArmJewelL.func_78793_a(2.8F, 4.7F, 0.4F);
/*  52 */     this.ArmJewelL.func_78790_a(0.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
/*  53 */     this.LegL2 = new ModelRenderer(this, 66, 17);
/*  54 */     this.LegL2.func_78793_a(0.0F, 7.0F, 0.0F);
/*  55 */     this.LegL2.func_78790_a(-3.0F, 0.0F, -2.6F, 6, 9, 6, 0.0F);
/*  56 */     setRotateAngle(this.LegL2, 0.04363323F, 0.0F, 0.02617994F);
/*  57 */     this.ChestJewelL = new ModelRenderer(this, 38, 0);
/*  58 */     this.ChestJewelL.func_78793_a(5.6F, 8.8F, -3.3F);
/*  59 */     this.ChestJewelL.func_78790_a(-1.0F, -0.9F, -1.0F, 2, 2, 1, 0.0F);
/*  60 */     this.LegR1 = new ModelRenderer(this, 67, 3);
/*  61 */     this.LegR1.func_78793_a(-3.2F, 6.5F, 0.0F);
/*  62 */     this.LegR1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 7, 6, 0.0F);
/*  63 */     setRotateAngle(this.LegR1, -0.04363323F, 0.0F, 0.05235988F);
/*  64 */     this.LegR3 = new ModelRenderer(this, 61, 35);
/*  65 */     this.LegR3.func_78793_a(0.0F, 8.9F, 0.0F);
/*  66 */     this.LegR3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 10, 0.0F);
/*  67 */     setRotateAngle(this.LegR3, 0.0F, 0.0F, -0.02617994F);
/*  68 */     this.ArmL2 = new ModelRenderer(this, 102, 15);
/*  69 */     this.ArmL2.field_78809_i = true;
/*  70 */     this.ArmL2.func_78793_a(3.0F, 2.9F, 0.0F);
/*  71 */     this.ArmL2.func_78790_a(-2.2F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
/*  72 */     setRotateAngle(this.ArmL2, 0.0F, 0.0F, -0.06981317F);
/*  73 */     this.LegL3 = new ModelRenderer(this, 61, 35);
/*  74 */     this.LegL3.func_78793_a(0.0F, 8.9F, 0.0F);
/*  75 */     this.LegL3.func_78790_a(-2.5F, 0.0F, -6.0F, 5, 2, 10, 0.0F);
/*  76 */     setRotateAngle(this.LegL3, 0.0F, 0.0F, 0.02617994F);
/*  77 */     this.LegL1 = new ModelRenderer(this, 67, 3);
/*  78 */     this.LegL1.field_78809_i = true;
/*  79 */     this.LegL1.func_78793_a(3.2F, 6.5F, 0.0F);
/*  80 */     this.LegL1.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 7, 6, 0.0F);
/*  81 */     setRotateAngle(this.LegL1, -0.04363323F, 0.0F, -0.05235988F);
/*  82 */     this.Body3_1 = new ModelRenderer(this, 32, 48);
/*  83 */     this.Body3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.Body3_1.func_78790_a(-4.0F, 11.8F, -3.6F, 8, 4, 1, 0.0F);
/*  85 */     this.Body1 = new ModelRenderer(this, 0, 13);
/*  86 */     this.Body1.func_78793_a(0.0F, -14.5F, 0.0F);
/*  87 */     this.Body1.func_78790_a(-7.0F, 0.0F, -3.8F, 14, 12, 9, 0.0F);
/*  88 */     this.Head2 = new ModelRenderer(this, 45, 4);
/*  89 */     this.Head2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.Head2.func_78790_a(-1.0F, -5.4F, -2.8F, 2, 1, 7, 0.0F);
/*  91 */     this.ArmR2 = new ModelRenderer(this, 102, 15);
/*  92 */     this.ArmR2.func_78793_a(-3.0F, 2.9F, 0.0F);
/*  93 */     this.ArmR2.func_78790_a(-2.7F, -0.1F, -2.5F, 5, 8, 5, 0.0F);
/*  94 */     setRotateAngle(this.ArmR2, 0.0F, 0.0F, 0.06981317F);
/*  95 */     this.ArmL3 = new ModelRenderer(this, 101, 29);
/*  96 */     this.ArmL3.field_78809_i = true;
/*  97 */     this.ArmL3.func_78793_a(0.0F, 7.3F, -0.5F);
/*  98 */     this.ArmL3.func_78790_a(-2.7F, 0.0F, -2.4F, 6, 13, 6, 0.0F);
/*  99 */     setRotateAngle(this.ArmL3, -0.2617994F, 0.0F, 0.034906585F);
/* 100 */     this.Head = new ModelRenderer(this, 0, 0);
/* 101 */     this.Head.func_78793_a(0.0F, -14.5F, -0.3F);
/* 102 */     this.Head.func_78790_a(-3.5F, -5.0F, -2.3F, 7, 5, 6, 0.0F);
/* 103 */     this.EarR = new ModelRenderer(this, 29, 5);
/* 104 */     this.EarR.func_78793_a(-3.5F, -3.0F, 0.4F);
/* 105 */     this.EarR.func_78790_a(-1.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
/* 106 */     this.LegR2 = new ModelRenderer(this, 66, 17);
/* 107 */     this.LegR2.func_78793_a(0.0F, 7.0F, 0.0F);
/* 108 */     this.LegR2.func_78790_a(-3.0F, 0.0F, -2.6F, 6, 9, 6, 0.0F);
/* 109 */     setRotateAngle(this.LegR2, 0.04363323F, 0.0F, -0.02617994F);
/* 110 */     this.ArmR3 = new ModelRenderer(this, 101, 29);
/* 111 */     this.ArmR3.func_78793_a(0.0F, 7.3F, -0.5F);
/* 112 */     this.ArmR3.func_78790_a(-3.2F, 0.0F, -2.4F, 6, 13, 6, 0.0F);
/* 113 */     setRotateAngle(this.ArmR3, -0.2617994F, 0.0F, -0.034906585F);
/* 114 */     this.Body2 = new ModelRenderer(this, 0, 36);
/* 115 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.Body2.func_78790_a(-6.0F, 12.0F, -3.0F, 12, 3, 7, 0.0F);
/* 117 */     this.ArmJewelR = new ModelRenderer(this, 29, 0);
/* 118 */     this.ArmJewelR.func_78793_a(-2.8F, 4.7F, 0.4F);
/* 119 */     this.ArmJewelR.func_78790_a(-1.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
/* 120 */     this.ArmR1 = new ModelRenderer(this, 101, 2);
/* 121 */     this.ArmR1.func_78793_a(-7.0F, -11.5F, 0.5F);
/* 122 */     this.ArmR1.func_78790_a(-6.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
/* 123 */     setRotateAngle(this.ArmR1, 0.04363323F, 0.0F, 0.0F);
/* 124 */     this.EarL = new ModelRenderer(this, 29, 5);
/* 125 */     this.EarL.field_78809_i = true;
/* 126 */     this.EarL.func_78793_a(3.5F, -3.0F, 0.4F);
/* 127 */     this.EarL.func_78790_a(0.0F, -0.9F, -1.0F, 1, 2, 2, 0.0F);
/* 128 */     this.Body2.func_78792_a(this.Body3);
/* 129 */     this.Body1.func_78792_a(this.ChestJewelR);
/* 130 */     this.ArmL3.func_78792_a(this.ArmJewelL);
/* 131 */     this.LegL1.func_78792_a(this.LegL2);
/* 132 */     this.Body1.func_78792_a(this.ChestJewelL);
/* 133 */     this.LegR2.func_78792_a(this.LegR3);
/* 134 */     this.ArmL1.func_78792_a(this.ArmL2);
/* 135 */     this.LegL2.func_78792_a(this.LegL3);
/* 136 */     this.Body3.func_78792_a(this.Body3_1);
/* 137 */     this.Head.func_78792_a(this.Head2);
/* 138 */     this.ArmR1.func_78792_a(this.ArmR2);
/* 139 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 140 */     this.Head.func_78792_a(this.EarR);
/* 141 */     this.LegR1.func_78792_a(this.LegR2);
/* 142 */     this.ArmR2.func_78792_a(this.ArmR3);
/* 143 */     this.Body1.func_78792_a(this.Body2);
/* 144 */     this.ArmR3.func_78792_a(this.ArmJewelR);
/* 145 */     this.Head.func_78792_a(this.EarL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 150 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 153 */     this.LegL1.func_78785_a(f5);
/* 154 */     this.Head.func_78785_a(f5);
/* 155 */     this.ArmL1.func_78785_a(f5);
/* 156 */     this.ArmR1.func_78785_a(f5);
/* 157 */     this.Body1.func_78785_a(f5);
/* 158 */     this.LegR1.func_78785_a(f5);
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
/* 230 */     this.LegR1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 231 */     this.LegL1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 232 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 233 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 235 */     this.LegR1.field_78796_g = 0.0F;
/* 236 */     this.LegL1.field_78796_g = 0.0F;
/* 237 */     this.ArmR1.field_78796_g = 0.0F;
/* 238 */     this.ArmL1.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBiarra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */