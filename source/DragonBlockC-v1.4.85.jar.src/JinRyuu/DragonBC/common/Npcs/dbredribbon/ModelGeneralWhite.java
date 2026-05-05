/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGeneralWhite
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair1;
/*     */   public ModelRenderer Hair2;
/*     */   public ModelRenderer Ribbon;
/*     */   
/*     */   public ModelGeneralWhite() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.Ribbon = new ModelRenderer(this, 25, 0);
/*  25 */     this.Ribbon.func_78793_a(0.0F, 1.5F, -2.0F);
/*  26 */     this.Ribbon.func_78790_a(-3.5F, 0.0F, 0.0F, 7, 5, 0, 0.0F);
/*  27 */     setRotateAngle(this.Ribbon, -0.18203785F, 0.0F, 0.0F);
/*  28 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  29 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  30 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  31 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  32 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  33 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  34 */     this.Body = new ModelRenderer(this, 16, 16);
/*  35 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  37 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  38 */     this.ArmL.field_78809_i = true;
/*  39 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  40 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  41 */     this.Hair2 = new ModelRenderer(this, 0, 43);
/*  42 */     this.Hair2.func_78793_a(0.0F, -5.7F, 0.0F);
/*  43 */     this.Hair2.func_78790_a(-2.5F, -2.8F, -4.4F, 5, 3, 6, 0.0F);
/*  44 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  45 */     this.LegL.field_78809_i = true;
/*  46 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  47 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  48 */     this.Head = new ModelRenderer(this, 0, 0);
/*  49 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  51 */     this.Hair1 = new ModelRenderer(this, 0, 34);
/*  52 */     this.Hair1.func_78793_a(0.0F, -5.1F, 3.1F);
/*  53 */     this.Hair1.func_78790_a(-4.5F, -3.0F, -3.0F, 9, 4, 4, 0.0F);
/*  54 */     this.Body.func_78792_a(this.Ribbon);
/*  55 */     this.Head.func_78792_a(this.Hair2);
/*  56 */     this.Head.func_78792_a(this.Hair1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  61 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  63 */     this.Head.func_78785_a(f5);
/*     */     
/*  65 */     this.Body.func_78785_a(f5);
/*  66 */     this.ArmR.func_78785_a(f5);
/*  67 */     this.ArmL.func_78785_a(f5);
/*  68 */     this.LegL.func_78785_a(f5);
/*  69 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  78 */     modelRenderer.field_78795_f = x;
/*  79 */     modelRenderer.field_78796_g = y;
/*  80 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  84 */     int calc = par7Entity.field_70173_aa;
/*  85 */     if (calc > 100) calc -= 100; 
/*  86 */     float r = 360.0F;
/*  87 */     float r2 = 180.0F;
/*  88 */     float n4 = par4;
/*  89 */     float n5 = par5;
/*     */     
/*  91 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  92 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  93 */     float ex = par7Entity.field_70173_aa;
/*  94 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  95 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  97 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  98 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 148 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 149 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 150 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 152 */     this.LegR.field_78796_g = 0.0F;
/* 153 */     this.LegL.field_78796_g = 0.0F;
/* 154 */     this.ArmR.field_78796_g = 0.0F;
/* 155 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelGeneralWhite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */