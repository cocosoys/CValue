/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelColonelViolet
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Googles;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Holster;
/*     */   
/*     */   public ModelColonelViolet() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.Googles = new ModelRenderer(this, 26, 2);
/*  27 */     this.Googles.func_78793_a(0.0F, 0.7F, -1.7F);
/*  28 */     this.Googles.func_78790_a(-3.0F, 0.0F, 0.0F, 6, 3, 0, 0.0F);
/*  29 */     setRotateAngle(this.Googles, -0.5691519F, 0.0F, 0.0F);
/*  30 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  31 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  33 */     this.ArmR = new ModelRenderer(this, 18, 47);
/*  34 */     this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
/*  35 */     this.ArmR.func_78790_a(-1.9F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  36 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  37 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  39 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  40 */     this.Boobs.func_78793_a(0.0F, -0.5F, 0.0F);
/*  41 */     this.Boobs.func_78790_a(-3.0F, 2.0F, -0.6F, 6, 3, 2, 0.0F);
/*  42 */     setRotateAngle(this.Boobs, -0.59864795F, 0.0F, 0.0F);
/*  43 */     this.Holster = new ModelRenderer(this, 34, 7);
/*  44 */     this.Holster.func_78793_a(-2.4F, 8.5F, -0.4F);
/*  45 */     this.Holster.func_78790_a(-1.5F, -1.6F, -1.3F, 1, 5, 3, 0.0F);
/*  46 */     setRotateAngle(this.Holster, 0.5462881F, 0.0F, 0.22759093F);
/*  47 */     this.Head = new ModelRenderer(this, 0, 0);
/*  48 */     this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
/*  49 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  50 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  51 */     this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
/*  52 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  53 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  54 */     this.LegL.field_78809_i = true;
/*  55 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  56 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  57 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  58 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  59 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  60 */     this.ArmL = new ModelRenderer(this, 18, 47);
/*  61 */     this.ArmL.field_78809_i = true;
/*  62 */     this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
/*  63 */     this.ArmL.func_78790_a(-1.1F, -1.5F, -1.8F, 3, 11, 4, -0.1F);
/*  64 */     this.Body1.func_78792_a(this.Googles);
/*  65 */     this.Body2.func_78792_a(this.Body3);
/*  66 */     this.Body1.func_78792_a(this.Body2);
/*  67 */     this.Body1.func_78792_a(this.Boobs);
/*  68 */     this.Body3.func_78792_a(this.Holster);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  73 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  75 */     this.Head.func_78785_a(f5);
/*     */     
/*  77 */     this.Body1.func_78785_a(f5);
/*  78 */     this.ArmR.func_78785_a(f5);
/*  79 */     this.ArmL.func_78785_a(f5);
/*  80 */     this.LegL.func_78785_a(f5);
/*  81 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  90 */     modelRenderer.field_78795_f = x;
/*  91 */     modelRenderer.field_78796_g = y;
/*  92 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  96 */     int calc = par7Entity.field_70173_aa;
/*  97 */     if (calc > 100) calc -= 100; 
/*  98 */     float r = 360.0F;
/*  99 */     float r2 = 180.0F;
/* 100 */     float n4 = par4;
/* 101 */     float n5 = par5;
/*     */     
/* 103 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 104 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 105 */     float ex = par7Entity.field_70173_aa;
/* 106 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 107 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 109 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 110 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 160 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 162 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 164 */     this.LegR.field_78796_g = 0.0F;
/* 165 */     this.LegL.field_78796_g = 0.0F;
/* 166 */     this.ArmR.field_78796_g = 0.0F;
/* 167 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelColonelViolet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */