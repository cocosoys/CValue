/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCocotte
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelCocotte() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  27 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  28 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  29 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  30 */     this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
/*  31 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  32 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  33 */     this.Boobs.func_78793_a(0.0F, -0.3F, 0.0F);
/*  34 */     this.Boobs.func_78790_a(-3.0F, 2.0F, -0.7F, 6, 3, 2, 0.0F);
/*  35 */     setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
/*  36 */     this.ArmR = new ModelRenderer(this, 32, 35);
/*  37 */     this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
/*  38 */     this.ArmR.func_78790_a(-1.7F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  39 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  40 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  41 */     this.LegL.field_78809_i = true;
/*  42 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  43 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  44 */     this.EarR = new ModelRenderer(this, 28, 1);
/*  45 */     this.EarR.func_78793_a(-3.0F, -3.4F, -0.5F);
/*  46 */     this.EarR.func_78790_a(-5.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
/*  47 */     setRotateAngle(this.EarR, 0.0F, 0.6981317F, 0.0F);
/*  48 */     this.Hair = new ModelRenderer(this, 39, 1);
/*  49 */     this.Hair.func_78793_a(0.0F, -0.1F, 3.0F);
/*  50 */     this.Hair.func_78790_a(-3.5F, -0.3F, 0.0F, 7, 7, 0, 0.0F);
/*  51 */     this.EarL = new ModelRenderer(this, 28, 1);
/*  52 */     this.EarL.field_78809_i = true;
/*  53 */     this.EarL.func_78793_a(3.0F, -3.4F, -0.5F);
/*  54 */     this.EarL.func_78790_a(0.0F, -2.0F, -0.3F, 5, 5, 0, 0.0F);
/*  55 */     setRotateAngle(this.EarL, 0.0F, -0.6981317F, 0.0F);
/*  56 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  57 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  59 */     this.ArmL = new ModelRenderer(this, 32, 35);
/*  60 */     this.ArmL.field_78809_i = true;
/*  61 */     this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
/*  62 */     this.ArmL.func_78790_a(-1.3F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  63 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  64 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  65 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  66 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  67 */     this.Head = new ModelRenderer(this, 0, 0);
/*  68 */     this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
/*  69 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  70 */     this.Body2.func_78792_a(this.Body3);
/*  71 */     this.Body1.func_78792_a(this.Boobs);
/*  72 */     this.Head.func_78792_a(this.EarR);
/*  73 */     this.Head.func_78792_a(this.Hair);
/*  74 */     this.Head.func_78792_a(this.EarL);
/*  75 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  80 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  82 */     this.ArmR.func_78785_a(f5);
/*  83 */     this.Head.func_78785_a(f5);
/*  84 */     this.ArmL.func_78785_a(f5);
/*  85 */     this.Body1.func_78785_a(f5);
/*  86 */     this.LegL.func_78785_a(f5);
/*  87 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  93 */     modelRenderer.field_78795_f = x;
/*  94 */     modelRenderer.field_78796_g = y;
/*  95 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  99 */     int calc = par7Entity.field_70173_aa;
/* 100 */     if (calc > 100) calc -= 100; 
/* 101 */     float r = 360.0F;
/* 102 */     float r2 = 180.0F;
/* 103 */     float n4 = par4;
/* 104 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 108 */     float ex = par7Entity.field_70173_aa;
/* 109 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 110 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 112 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 113 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 163 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 164 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 167 */     this.LegR.field_78796_g = 0.0F;
/* 168 */     this.LegL.field_78796_g = 0.0F;
/* 169 */     this.ArmR.field_78796_g = 0.0F;
/* 170 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelCocotte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */