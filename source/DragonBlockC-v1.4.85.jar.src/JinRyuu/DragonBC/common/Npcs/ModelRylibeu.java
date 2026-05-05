/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRylibeu
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Wings;
/*     */   public ModelRenderer FeelerR;
/*     */   public ModelRenderer FeelerL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer WingL1;
/*     */   public ModelRenderer WingR1;
/*     */   public ModelRenderer WingR2;
/*     */   public ModelRenderer WingL2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelRylibeu() {
/*  30 */     this.field_78090_t = 128;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  33 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  34 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 5, 4, -0.2F);
/*  35 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  36 */     this.LegR.func_78793_a(-1.6F, 12.0F, 0.0F);
/*  37 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  38 */     this.Head = new ModelRenderer(this, 0, 0);
/*  39 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  40 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  41 */     this.ArmL = new ModelRenderer(this, 32, 29);
/*  42 */     this.ArmL.field_78809_i = true;
/*  43 */     this.ArmL.func_78793_a(4.3F, 2.5F, 0.0F);
/*  44 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
/*  45 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  46 */     this.WingL2 = new ModelRenderer(this, 85, 2);
/*  47 */     this.WingL2.field_78809_i = true;
/*  48 */     this.WingL2.func_78793_a(0.0F, -4.4F, 3.7F);
/*  49 */     this.WingL2.func_78790_a(-1.0F, -1.4F, 0.0F, 9, 24, 0, 0.0F);
/*  50 */     setRotateAngle(this.WingL2, 0.04886922F, -0.13665928F, -0.045727625F);
/*  51 */     this.FeelerL = new ModelRenderer(this, 29, 0);
/*  52 */     this.FeelerL.field_78809_i = true;
/*  53 */     this.FeelerL.func_78793_a(1.5F, -6.3F, -3.5F);
/*  54 */     this.FeelerL.func_78790_a(0.0F, -0.7F, -4.0F, 0, 2, 4, 0.0F);
/*  55 */     setRotateAngle(this.FeelerL, 0.0F, -0.54105204F, 0.0F);
/*  56 */     this.ArmR = new ModelRenderer(this, 32, 29);
/*  57 */     this.ArmR.func_78793_a(-4.3F, 2.5F, 0.0F);
/*  58 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 12, 4, -0.3F);
/*  59 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  60 */     this.WingR2 = new ModelRenderer(this, 85, 2);
/*  61 */     this.WingR2.func_78793_a(0.0F, -4.4F, 3.7F);
/*  62 */     this.WingR2.func_78790_a(-8.2F, -1.4F, 0.0F, 9, 24, 0, 0.0F);
/*  63 */     setRotateAngle(this.WingR2, 0.04886922F, 0.13665928F, 0.045727625F);
/*  64 */     this.Wings = new ModelRenderer(this, 0, 0);
/*  65 */     this.Wings.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Wings.func_78790_a(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
/*  67 */     this.EarL = new ModelRenderer(this, 38, 3);
/*  68 */     this.EarL.field_78809_i = true;
/*  69 */     this.EarL.func_78793_a(3.6F, -3.5F, 0.0F);
/*  70 */     this.EarL.func_78790_a(-0.5F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
/*  71 */     setRotateAngle(this.EarL, 0.0F, -0.43633232F, -0.2268928F);
/*  72 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  73 */     this.LegL.field_78809_i = true;
/*  74 */     this.LegL.func_78793_a(1.6F, 12.0F, 0.0F);
/*  75 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  76 */     this.EarR = new ModelRenderer(this, 38, 3);
/*  77 */     this.EarR.func_78793_a(-3.6F, -3.5F, 0.0F);
/*  78 */     this.EarR.func_78790_a(-4.4F, -1.5F, 0.0F, 5, 3, 0, 0.0F);
/*  79 */     setRotateAngle(this.EarR, 0.0F, 0.43633232F, 0.2268928F);
/*  80 */     this.Body3 = new ModelRenderer(this, 0, 35);
/*  81 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Body3.func_78790_a(-3.5F, 7.8F, -2.0F, 7, 3, 4, 0.0F);
/*  83 */     this.WingL1 = new ModelRenderer(this, 66, 2);
/*  84 */     this.WingL1.field_78809_i = true;
/*  85 */     this.WingL1.func_78793_a(0.0F, -4.4F, 3.7F);
/*  86 */     this.WingL1.func_78790_a(0.3F, -6.0F, 0.0F, 9, 24, 0, 0.0F);
/*  87 */     setRotateAngle(this.WingL1, 0.0F, 0.0F, -0.091106184F);
/*  88 */     this.WingR1 = new ModelRenderer(this, 66, 2);
/*  89 */     this.WingR1.func_78793_a(0.0F, -4.4F, 3.7F);
/*  90 */     this.WingR1.func_78790_a(-9.1F, -6.0F, 0.0F, 9, 24, 0, 0.0F);
/*  91 */     setRotateAngle(this.WingR1, 0.0F, 0.0F, 0.091106184F);
/*  92 */     this.FeelerR = new ModelRenderer(this, 29, 0);
/*  93 */     this.FeelerR.func_78793_a(-1.5F, -6.3F, -3.5F);
/*  94 */     this.FeelerR.func_78790_a(0.0F, -0.7F, -4.0F, 0, 2, 4, 0.0F);
/*  95 */     setRotateAngle(this.FeelerR, 0.0F, 0.54105204F, 0.0F);
/*  96 */     this.Body2 = new ModelRenderer(this, 0, 27);
/*  97 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Body2.func_78790_a(-3.0F, 4.3F, -1.6F, 6, 4, 3, 0.0F);
/*  99 */     this.Boobs = new ModelRenderer(this, 19, 27);
/* 100 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Boobs.func_78790_a(-3.0F, 1.8F, -0.7F, 6, 3, 2, 0.0F);
/* 102 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/* 103 */     this.Wings.func_78792_a(this.WingL2);
/* 104 */     this.Head.func_78792_a(this.FeelerL);
/* 105 */     this.Wings.func_78792_a(this.WingR2);
/* 106 */     this.Head.func_78792_a(this.Wings);
/* 107 */     this.Head.func_78792_a(this.EarL);
/* 108 */     this.Head.func_78792_a(this.EarR);
/* 109 */     this.Body2.func_78792_a(this.Body3);
/* 110 */     this.Wings.func_78792_a(this.WingL1);
/* 111 */     this.Wings.func_78792_a(this.WingR1);
/* 112 */     this.Head.func_78792_a(this.FeelerR);
/* 113 */     this.Body1.func_78792_a(this.Body2);
/* 114 */     this.Body1.func_78792_a(this.Boobs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 119 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 121 */     this.Body1.func_78785_a(f5);
/* 122 */     this.LegR.func_78785_a(f5);
/* 123 */     this.Head.func_78785_a(f5);
/* 124 */     this.ArmL.func_78785_a(f5);
/* 125 */     this.ArmR.func_78785_a(f5);
/* 126 */     this.LegL.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 132 */     modelRenderer.field_78795_f = x;
/* 133 */     modelRenderer.field_78796_g = y;
/* 134 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 138 */     int calc = par7Entity.field_70173_aa;
/* 139 */     if (calc > 100) calc -= 100; 
/* 140 */     float r = 360.0F;
/* 141 */     float r2 = 180.0F;
/* 142 */     float n4 = par4;
/* 143 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 147 */     float ex = par7Entity.field_70173_aa;
/* 148 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 149 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 151 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 152 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 202 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 203 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 204 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 206 */     this.LegR.field_78796_g = 0.0F;
/* 207 */     this.LegL.field_78796_g = 0.0F;
/* 208 */     this.ArmR.field_78796_g = 0.0F;
/* 209 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRylibeu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */