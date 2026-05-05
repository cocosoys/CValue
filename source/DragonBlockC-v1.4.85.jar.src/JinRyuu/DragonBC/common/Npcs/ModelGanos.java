/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGanos
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hat1;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Hat2;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelGanos() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.Hat1 = new ModelRenderer(this, 32, 0);
/*  28 */     this.Hat1.func_78793_a(0.0F, -5.3F, 0.0F);
/*  29 */     this.Hat1.func_78790_a(-4.0F, -3.0F, -4.0F, 8, 3, 8, 0.0F);
/*  30 */     setRotateAngle(this.Hat1, -0.09128072F, 0.0F, 0.0F);
/*  31 */     this.Hair = new ModelRenderer(this, 39, 24);
/*  32 */     this.Hair.func_78793_a(0.0F, -4.0F, 3.5F);
/*  33 */     this.Hair.func_78790_a(-6.0F, -0.3F, 0.0F, 12, 7, 0, 0.0F);
/*  34 */     this.Body1 = new ModelRenderer(this, 1, 17);
/*  35 */     this.Body1.func_78793_a(0.0F, 2.0F, 0.0F);
/*  36 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, 0.0F);
/*  37 */     this.Hat2 = new ModelRenderer(this, 33, 12);
/*  38 */     this.Hat2.func_78793_a(0.0F, 0.0F, -3.5F);
/*  39 */     this.Hat2.func_78790_a(-3.5F, -0.8F, -0.7F, 7, 2, 8, 0.0F);
/*  40 */     setRotateAngle(this.Hat2, 0.036651913F, 0.0F, 0.0F);
/*  41 */     this.ArmR = new ModelRenderer(this, 23, 24);
/*  42 */     this.ArmR.func_78793_a(-4.3F, 3.3F, 0.0F);
/*  43 */     this.ArmR.func_78790_a(-2.2F, -1.3F, -1.8F, 3, 10, 4, 0.0F);
/*  44 */     this.Body3 = new ModelRenderer(this, 1, 35);
/*  45 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Body3.func_78790_a(-3.5F, 8.0F, -2.0F, 7, 2, 4, 0.0F);
/*  47 */     this.ArmL = new ModelRenderer(this, 23, 24);
/*  48 */     this.ArmL.field_78809_i = true;
/*  49 */     this.ArmL.func_78793_a(4.3F, 3.3F, 0.0F);
/*  50 */     this.ArmL.func_78790_a(-0.8F, -1.3F, -1.8F, 3, 10, 4, 0.0F);
/*  51 */     this.Body2 = new ModelRenderer(this, 3, 29);
/*  52 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Body2.func_78790_a(-3.0F, 6.0F, -1.6F, 6, 2, 3, 0.0F);
/*  54 */     this.LegR2 = new ModelRenderer(this, 18, 53);
/*  55 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.LegR2.func_78790_a(-1.5F, 5.0F, -1.4F, 3, 7, 4, 0.0F);
/*  57 */     this.LegL = new ModelRenderer(this, 0, 53);
/*  58 */     this.LegL.field_78809_i = true;
/*  59 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  60 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
/*  61 */     this.Head = new ModelRenderer(this, 0, 0);
/*  62 */     this.Head.func_78793_a(0.0F, 2.3F, 0.0F);
/*  63 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.7F);
/*  64 */     this.LegL2 = new ModelRenderer(this, 18, 53);
/*  65 */     this.LegL2.field_78809_i = true;
/*  66 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.LegL2.func_78790_a(-1.5F, 5.0F, -1.4F, 3, 7, 4, 0.0F);
/*  68 */     this.LegR = new ModelRenderer(this, 0, 53);
/*  69 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  70 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
/*  71 */     this.Head.func_78792_a(this.Hat1);
/*  72 */     this.Head.func_78792_a(this.Hair);
/*  73 */     this.Hat1.func_78792_a(this.Hat2);
/*  74 */     this.Body2.func_78792_a(this.Body3);
/*  75 */     this.Body1.func_78792_a(this.Body2);
/*  76 */     this.LegR.func_78792_a(this.LegR2);
/*  77 */     this.LegL.func_78792_a(this.LegL2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  82 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  84 */     this.Body1.func_78785_a(f5);
/*  85 */     this.ArmR.func_78785_a(f5);
/*  86 */     this.ArmL.func_78785_a(f5);
/*  87 */     this.LegL.func_78785_a(f5);
/*  88 */     this.Head.func_78785_a(f5);
/*  89 */     this.LegR.func_78785_a(f5);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGanos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */