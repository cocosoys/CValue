/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelObni
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelObni() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.ArmR = new ModelRenderer(this, 45, 12);
/*  28 */     this.ArmR.func_78793_a(-5.0F, -2.0F, 0.0F);
/*  29 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 14, 4, 0.0F);
/*  30 */     this.EarL = new ModelRenderer(this, 51, 1);
/*  31 */     this.EarL.field_78809_i = true;
/*  32 */     this.EarL.func_78793_a(4.0F, -4.0F, 0.0F);
/*  33 */     this.EarL.func_78790_a(0.0F, -2.0F, -1.6F, 1, 4, 3, 0.0F);
/*  34 */     this.LegL = new ModelRenderer(this, 43, 32);
/*  35 */     this.LegL.field_78809_i = true;
/*  36 */     this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
/*  37 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  38 */     this.ArmL = new ModelRenderer(this, 45, 12);
/*  39 */     this.ArmL.field_78809_i = true;
/*  40 */     this.ArmL.func_78793_a(5.0F, -2.0F, 0.0F);
/*  41 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 14, 4, 0.0F);
/*  42 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  43 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Body2.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 4, 4, 0.0F);
/*  45 */     this.LegR = new ModelRenderer(this, 43, 32);
/*  46 */     this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
/*  47 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  48 */     this.Head = new ModelRenderer(this, 0, 0);
/*  49 */     this.Head.func_78793_a(0.0F, -4.0F, 0.0F);
/*  50 */     this.Head.func_78790_a(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
/*  51 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  52 */     this.Body1.func_78793_a(0.0F, -4.0F, 0.0F);
/*  53 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 7, 4, 0.0F);
/*  54 */     this.Nose = new ModelRenderer(this, 25, 2);
/*  55 */     this.Nose.func_78793_a(0.0F, -3.3F, -3.4F);
/*  56 */     this.Nose.func_78790_a(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
/*  57 */     setRotateAngle(this.Nose, -0.13665928F, 0.0F, 0.0F);
/*  58 */     this.Body3 = new ModelRenderer(this, 0, 39);
/*  59 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Body3.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 3, 4, 0.0F);
/*  61 */     this.EarR = new ModelRenderer(this, 51, 1);
/*  62 */     this.EarR.func_78793_a(-4.0F, -4.0F, 0.0F);
/*  63 */     this.EarR.func_78790_a(-1.0F, -2.0F, -1.6F, 1, 4, 3, 0.0F);
/*  64 */     this.Chest = new ModelRenderer(this, 26, 21);
/*  65 */     this.Chest.func_78793_a(0.0F, 3.3F, -1.0F);
/*  66 */     this.Chest.func_78790_a(-3.5F, -2.0F, -1.4F, 7, 4, 1, 0.0F);
/*  67 */     setRotateAngle(this.Chest, -0.06981317F, 0.0F, 0.0F);
/*  68 */     this.Hair = new ModelRenderer(this, 34, 2);
/*  69 */     this.Hair.func_78793_a(0.0F, 0.0F, 4.0F);
/*  70 */     this.Hair.func_78790_a(-4.0F, 0.0F, 0.0F, 8, 7, 0, 0.0F);
/*  71 */     this.Head.func_78792_a(this.EarL);
/*  72 */     this.Body1.func_78792_a(this.Body2);
/*  73 */     this.Head.func_78792_a(this.Nose);
/*  74 */     this.Body2.func_78792_a(this.Body3);
/*  75 */     this.Head.func_78792_a(this.EarR);
/*  76 */     this.Body1.func_78792_a(this.Chest);
/*  77 */     this.Head.func_78792_a(this.Hair);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  82 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  84 */     this.ArmR.func_78785_a(f5);
/*  85 */     this.LegL.func_78785_a(f5);
/*  86 */     this.ArmL.func_78785_a(f5);
/*  87 */     this.LegR.func_78785_a(f5);
/*  88 */     this.Head.func_78785_a(f5);
/*  89 */     this.Body1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  95 */     modelRenderer.field_78795_f = x;
/*  96 */     modelRenderer.field_78796_g = y;
/*  97 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 101 */     int calc = par7Entity.field_70173_aa;
/* 102 */     if (calc > 100) calc -= 100; 
/* 103 */     float r = 360.0F;
/* 104 */     float r2 = 180.0F;
/* 105 */     float n4 = par4;
/* 106 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 110 */     float ex = par7Entity.field_70173_aa;
/* 111 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 112 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 114 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 115 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 167 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 169 */     this.LegR.field_78796_g = 0.0F;
/* 170 */     this.LegL.field_78796_g = 0.0F;
/* 171 */     this.ArmR.field_78796_g = 0.0F;
/* 172 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelObni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */