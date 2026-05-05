/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKunshi
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelKunshi() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  25 */     this.LegR.func_78793_a(-2.0F, 14.0F, 0.0F);
/*  26 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
/*  27 */     this.EarR = new ModelRenderer(this, 28, 1);
/*  28 */     this.EarR.func_78793_a(-3.0F, -2.5F, -0.5F);
/*  29 */     this.EarR.func_78790_a(-5.0F, -1.5F, -0.3F, 5, 3, 0, 0.0F);
/*  30 */     setRotateAngle(this.EarR, 0.0F, 0.6981317F, 0.0F);
/*  31 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  32 */     this.ArmL.field_78809_i = true;
/*  33 */     this.ArmL.func_78793_a(6.0F, 6.0F, 0.0F);
/*  34 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F);
/*  35 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  36 */     this.LegL.field_78809_i = true;
/*  37 */     this.LegL.func_78793_a(2.0F, 14.0F, 0.0F);
/*  38 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
/*  39 */     this.Body2 = new ModelRenderer(this, 2, 27);
/*  40 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Body2.func_78790_a(-4.5F, 5.0F, -2.0F, 9, 1, 4, 0.0F);
/*  42 */     this.EarL = new ModelRenderer(this, 28, 1);
/*  43 */     this.EarL.field_78809_i = true;
/*  44 */     this.EarL.func_78793_a(3.0F, -2.5F, -0.5F);
/*  45 */     this.EarL.func_78790_a(0.0F, -1.5F, -0.3F, 5, 3, 0, 0.0F);
/*  46 */     setRotateAngle(this.EarL, 0.0F, -0.6981317F, 0.0F);
/*  47 */     this.Head = new ModelRenderer(this, 0, 0);
/*  48 */     this.Head.func_78793_a(0.0F, 4.3F, 0.0F);
/*  49 */     this.Head.func_78790_a(-4.0F, -5.5F, -4.0F, 8, 6, 8, 0.0F);
/*  50 */     this.Body1 = new ModelRenderer(this, 1, 16);
/*  51 */     this.Body1.func_78793_a(0.0F, 4.0F, 0.0F);
/*  52 */     this.Body1.func_78790_a(-5.0F, 0.0F, -2.2F, 10, 5, 5, 0.0F);
/*  53 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  54 */     this.ArmR.func_78793_a(-5.9F, 6.0F, 0.0F);
/*  55 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -1.8F, 4, 10, 4, 0.0F);
/*  56 */     this.Body3 = new ModelRenderer(this, 2, 34);
/*  57 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body3.func_78790_a(-4.0F, 6.0F, -2.0F, 8, 4, 4, 0.0F);
/*  59 */     this.Head.func_78792_a(this.EarR);
/*  60 */     this.Body1.func_78792_a(this.Body2);
/*  61 */     this.Head.func_78792_a(this.EarL);
/*  62 */     this.Body2.func_78792_a(this.Body3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  67 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  69 */     this.ArmR.func_78785_a(f5);
/*  70 */     this.Head.func_78785_a(f5);
/*  71 */     this.ArmL.func_78785_a(f5);
/*  72 */     this.Body1.func_78785_a(f5);
/*  73 */     this.LegL.func_78785_a(f5);
/*  74 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  80 */     modelRenderer.field_78795_f = x;
/*  81 */     modelRenderer.field_78796_g = y;
/*  82 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  86 */     int calc = par7Entity.field_70173_aa;
/*  87 */     if (calc > 100) calc -= 100; 
/*  88 */     float r = 360.0F;
/*  89 */     float r2 = 180.0F;
/*  90 */     float n4 = par4;
/*  91 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/*  95 */     float ex = par7Entity.field_70173_aa;
/*  96 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  97 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  99 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 100 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 150 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 151 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 152 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 154 */     this.LegR.field_78796_g = 0.0F;
/* 155 */     this.LegL.field_78796_g = 0.0F;
/* 156 */     this.ArmR.field_78796_g = 0.0F;
/* 157 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKunshi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */