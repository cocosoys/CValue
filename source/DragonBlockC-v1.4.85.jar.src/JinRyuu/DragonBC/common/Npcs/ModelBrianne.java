/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBrianne
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelBrianne() {
/*  27 */     this.field_78090_t = 128;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Head3 = new ModelRenderer(this, 39, 1);
/*  30 */     this.Head3.func_78793_a(0.0F, -3.4F, 0.0F);
/*  31 */     this.Head3.func_78790_a(-1.0F, -4.1F, -1.0F, 2, 5, 2, 0.0F);
/*  32 */     setRotateAngle(this.Head3, -1.3203416F, 0.0F, 0.0F);
/*  33 */     this.Body1 = new ModelRenderer(this, 32, 9);
/*  34 */     this.Body1.func_78793_a(0.0F, -0.5F, 0.0F);
/*  35 */     this.Body1.func_78790_a(-5.0F, 0.1F, -3.7F, 10, 5, 7, 0.0F);
/*  36 */     this.LegL = new ModelRenderer(this, 0, 42);
/*  37 */     this.LegL.field_78809_i = true;
/*  38 */     this.LegL.func_78793_a(2.4F, 12.0F, 0.0F);
/*  39 */     this.LegL.func_78790_a(-1.3F, 5.0F, -2.0F, 4, 7, 4, 0.0F);
/*  40 */     this.Head2 = new ModelRenderer(this, 26, 0);
/*  41 */     this.Head2.func_78793_a(0.0F, -6.3F, 0.0F);
/*  42 */     this.Head2.func_78790_a(-1.5F, -3.8F, -1.5F, 3, 5, 3, 0.0F);
/*  43 */     setRotateAngle(this.Head2, -0.5462881F, 0.0F, 0.0F);
/*  44 */     this.Boobs = new ModelRenderer(this, 0, 17);
/*  45 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Boobs.func_78790_a(-6.0F, 3.7F, -1.1F, 12, 4, 3, 0.0F);
/*  47 */     setRotateAngle(this.Boobs, -0.8110545F, 0.0F, 0.0F);
/*  48 */     this.Head4 = new ModelRenderer(this, 48, 2);
/*  49 */     this.Head4.func_78793_a(0.0F, -3.4F, 0.0F);
/*  50 */     this.Head4.func_78790_a(-0.5F, -2.9F, 0.1F, 1, 3, 1, 0.0F);
/*  51 */     setRotateAngle(this.Head4, 1.3203416F, 0.0F, 0.0F);
/*  52 */     this.LegR2 = new ModelRenderer(this, 0, 26);
/*  53 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.LegR2.func_78790_a(-3.3F, 0.6F, -3.0F, 6, 5, 6, 0.0F);
/*  55 */     this.ArmL = new ModelRenderer(this, 68, 2);
/*  56 */     this.ArmL.field_78809_i = true;
/*  57 */     this.ArmL.func_78793_a(6.0F, 1.9F, -0.2F);
/*  58 */     this.ArmL.func_78790_a(-0.9F, -1.7F, -1.8F, 4, 12, 4, 0.0F);
/*  59 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.19198622F);
/*  60 */     this.Head1 = new ModelRenderer(this, 0, 0);
/*  61 */     this.Head1.func_78793_a(0.0F, -0.3F, 0.0F);
/*  62 */     this.Head1.func_78790_a(-4.0F, -6.7F, -4.0F, 8, 7, 8, -0.4F);
/*  63 */     this.Body4 = new ModelRenderer(this, 67, 23);
/*  64 */     this.Body4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Body4.func_78790_a(-8.5F, 12.7F, -6.5F, 17, 5, 13, 0.0F);
/*  66 */     this.ArmR = new ModelRenderer(this, 68, 2);
/*  67 */     this.ArmR.func_78793_a(-6.2F, 1.9F, -0.2F);
/*  68 */     this.ArmR.func_78790_a(-2.9F, -1.7F, -1.8F, 4, 12, 4, 0.0F);
/*  69 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.19198622F);
/*  70 */     this.LegR = new ModelRenderer(this, 0, 42);
/*  71 */     this.LegR.func_78793_a(-2.6F, 12.0F, 0.0F);
/*  72 */     this.LegR.func_78790_a(-2.5F, 5.0F, -2.0F, 4, 7, 4, 0.0F);
/*  73 */     this.Body3 = new ModelRenderer(this, 26, 38);
/*  74 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.Body3.func_78790_a(-7.0F, 8.9F, -5.2F, 14, 4, 10, 0.0F);
/*  76 */     this.Body2 = new ModelRenderer(this, 30, 22);
/*  77 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.Body2.func_78790_a(-5.5F, 5.1F, -4.4F, 11, 4, 8, 0.0F);
/*  79 */     this.LegL2 = new ModelRenderer(this, 0, 26);
/*  80 */     this.LegL2.field_78809_i = true;
/*  81 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.LegL2.func_78790_a(-2.4F, 0.6F, -3.0F, 6, 5, 6, 0.0F);
/*  83 */     this.Head2.func_78792_a(this.Head3);
/*  84 */     this.Head1.func_78792_a(this.Head2);
/*  85 */     this.Body1.func_78792_a(this.Boobs);
/*  86 */     this.Head3.func_78792_a(this.Head4);
/*  87 */     this.LegR.func_78792_a(this.LegR2);
/*  88 */     this.Body3.func_78792_a(this.Body4);
/*  89 */     this.Body2.func_78792_a(this.Body3);
/*  90 */     this.Body1.func_78792_a(this.Body2);
/*  91 */     this.LegL.func_78792_a(this.LegL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  96 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  99 */     this.LegL.func_78785_a(f5);
/* 100 */     this.Head1.func_78785_a(f5);
/* 101 */     this.ArmL.func_78785_a(f5);
/* 102 */     this.ArmR.func_78785_a(f5);
/* 103 */     this.Body1.func_78785_a(f5);
/* 104 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 110 */     modelRenderer.field_78795_f = x;
/* 111 */     modelRenderer.field_78796_g = y;
/* 112 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 116 */     int calc = par7Entity.field_70173_aa;
/* 117 */     if (calc > 100) calc -= 100; 
/* 118 */     float r = 360.0F;
/* 119 */     float r2 = 180.0F;
/* 120 */     float n4 = par4;
/* 121 */     float n5 = par5;
/*     */     
/* 123 */     this.Head1.field_78796_g = n4 / r2 / 3.1415927F;
/* 124 */     this.Head1.field_78795_f = n5 / r2 / 3.1415927F;
/* 125 */     float ex = par7Entity.field_70173_aa;
/* 126 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 127 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 129 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 130 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 179 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 181 */     this.LegR.field_78796_g = 0.0F;
/* 182 */     this.LegL.field_78796_g = 0.0F;
/* 183 */     this.ArmR.field_78796_g = 0.0F;
/* 184 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBrianne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */