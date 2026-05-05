/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelZeno
/*     */   extends ModelBase {
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   
/*     */   public ModelZeno() {
/*  23 */     this.field_78090_t = 64;
/*  24 */     this.field_78089_u = 32;
/*  25 */     this.Head = new ModelRenderer(this, 0, 0);
/*  26 */     this.Head.func_78793_a(0.0F, 8.2F, 0.0F);
/*  27 */     this.Head.func_78790_a(-4.0F, -5.6F, -3.6F, 8, 6, 7, -0.2F);
/*  28 */     this.LegR = new ModelRenderer(this, 30, 22);
/*  29 */     this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
/*  30 */     this.LegR.func_78790_a(-1.1F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
/*  31 */     this.ShoulderL = new ModelRenderer(this, 27, 13);
/*  32 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.ShoulderL.func_78790_a(3.1F, 1.0F, -1.9F, 3, 2, 4, 0.0F);
/*  34 */     setRotateAngle(this.ShoulderL, 0.0F, 0.0F, -0.13665928F);
/*  35 */     this.EarL = new ModelRenderer(this, 0, 0);
/*  36 */     this.EarL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.EarL.func_78790_a(3.7F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
/*  38 */     this.Body2 = new ModelRenderer(this, 37, 0);
/*  39 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Body2.func_78790_a(-4.0F, 4.1F, -2.4F, 8, 7, 5, 0.0F);
/*  41 */     this.EarR = new ModelRenderer(this, 0, 0);
/*  42 */     this.EarR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.EarR.func_78790_a(-4.7F, -3.1F, -1.0F, 1, 2, 2, 0.0F);
/*  44 */     this.ShoulderR = new ModelRenderer(this, 27, 13);
/*  45 */     this.ShoulderR.field_78809_i = true;
/*  46 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.ShoulderR.func_78790_a(-6.2F, 1.0F, -1.9F, 3, 2, 4, 0.0F);
/*  48 */     setRotateAngle(this.ShoulderR, 0.0F, 0.0F, 0.13665928F);
/*  49 */     this.ArmL = new ModelRenderer(this, 42, 22);
/*  50 */     this.ArmL.field_78809_i = true;
/*  51 */     this.ArmL.func_78793_a(4.2F, 9.5F, 0.1F);
/*  52 */     this.ArmL.func_78790_a(-0.6F, -0.6F, -1.6F, 2, 7, 3, 0.0F);
/*  53 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.15358898F);
/*  54 */     this.LegL = new ModelRenderer(this, 30, 22);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-1.1F, 0.0F, -1.5F, 2, 7, 3, 0.0F);
/*  58 */     this.Body1 = new ModelRenderer(this, 0, 14);
/*  59 */     this.Body1.func_78793_a(0.0F, 8.0F, 0.0F);
/*  60 */     this.Body1.func_78790_a(-4.0F, 0.3F, -2.4F, 8, 4, 5, -0.1F);
/*  61 */     this.ArmR = new ModelRenderer(this, 42, 22);
/*  62 */     this.ArmR.func_78793_a(-4.1F, 9.5F, 0.1F);
/*  63 */     this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 7, 3, 0.0F);
/*  64 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.15358898F);
/*  65 */     this.Body1.func_78792_a(this.ShoulderL);
/*  66 */     this.Head.func_78792_a(this.EarL);
/*  67 */     this.Body1.func_78792_a(this.Body2);
/*  68 */     this.Head.func_78792_a(this.EarR);
/*  69 */     this.Body1.func_78792_a(this.ShoulderR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  74 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  77 */     this.LegL.func_78785_a(f5);
/*  78 */     this.Head.func_78785_a(f5);
/*  79 */     this.ArmL.func_78785_a(f5);
/*  80 */     this.ArmR.func_78785_a(f5);
/*  81 */     this.Body1.func_78785_a(f5);
/*  82 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  87 */     modelRenderer.field_78795_f = x;
/*  88 */     modelRenderer.field_78796_g = y;
/*  89 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  93 */     int calc = par7Entity.field_70173_aa;
/*  94 */     if (calc > 100) calc -= 100; 
/*  95 */     float r = 360.0F;
/*  96 */     float r2 = 180.0F;
/*  97 */     float n4 = par4;
/*  98 */     float n5 = par5;
/*     */     
/* 100 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 101 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 102 */     float ex = par7Entity.field_70173_aa;
/* 103 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 104 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 116 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 117 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 118 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 119 */     this.LegR.field_78796_g = 0.0F;
/* 120 */     this.LegL.field_78796_g = 0.0F;
/* 121 */     this.ArmR.field_78796_g = 0.0F;
/* 122 */     this.ArmL.field_78796_g = 0.0F;
/* 123 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelZeno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */