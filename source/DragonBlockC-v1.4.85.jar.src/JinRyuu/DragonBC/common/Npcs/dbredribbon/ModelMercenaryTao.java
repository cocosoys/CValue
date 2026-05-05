/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMercenaryTao
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Cloth2;
/*     */   
/*     */   public ModelMercenaryTao() {
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 64;
/*  23 */     this.Cloth1 = new ModelRenderer(this, 0, 52);
/*  24 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.2F);
/*  25 */     this.Cloth1.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
/*  26 */     setRotateAngle(this.Cloth1, -0.045378562F, 0.0F, 0.0F);
/*  27 */     this.Head = new ModelRenderer(this, 0, 0);
/*  28 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  30 */     this.ArmL = new ModelRenderer(this, 26, 19);
/*  31 */     this.ArmL.field_78809_i = true;
/*  32 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  33 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  34 */     this.ArmR = new ModelRenderer(this, 26, 19);
/*  35 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  36 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  37 */     this.LegL = new ModelRenderer(this, 0, 35);
/*  38 */     this.LegL.field_78809_i = true;
/*  39 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  40 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  41 */     this.Body = new ModelRenderer(this, 0, 17);
/*  42 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  44 */     this.LegR = new ModelRenderer(this, 0, 35);
/*  45 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  46 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  47 */     this.Cloth2 = new ModelRenderer(this, 23, 52);
/*  48 */     this.Cloth2.func_78793_a(0.0F, 10.1F, 1.2F);
/*  49 */     this.Cloth2.func_78790_a(-4.5F, 0.0F, -1.0F, 9, 9, 2, 0.0F);
/*  50 */     setRotateAngle(this.Cloth2, 0.045378562F, 0.0F, 0.0F);
/*  51 */     this.Hair = new ModelRenderer(this, 35, 3);
/*  52 */     this.Hair.func_78793_a(0.0F, -1.2F, 4.0F);
/*  53 */     this.Hair.func_78790_a(-1.5F, 0.0F, 0.0F, 3, 10, 0, 0.0F);
/*  54 */     setRotateAngle(this.Hair, 0.045553092F, 0.0F, 0.0F);
/*  55 */     this.Body.func_78792_a(this.Cloth1);
/*  56 */     this.Body.func_78792_a(this.Cloth2);
/*  57 */     this.Head.func_78792_a(this.Hair);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  62 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  64 */     this.Head.func_78785_a(f5);
/*     */     
/*  66 */     this.Body.func_78785_a(f5);
/*  67 */     this.ArmR.func_78785_a(f5);
/*  68 */     this.ArmL.func_78785_a(f5);
/*  69 */     this.LegL.func_78785_a(f5);
/*  70 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  93 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  94 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
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
/* 132 */     this.Hair.field_78795_f = 0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.5F * par2;
/* 133 */     if (0.0F > this.Hair.field_78795_f) this.Hair.field_78795_f *= -1.0F; 
/* 134 */     this.Hair.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 156 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 157 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 159 */     this.LegR.field_78796_g = 0.0F;
/* 160 */     this.LegL.field_78796_g = 0.0F;
/* 161 */     this.ArmR.field_78796_g = 0.0F;
/* 162 */     this.ArmL.field_78796_g = 0.0F;
/*     */     
/* 164 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */     
/* 166 */     this.Cloth2.field_78795_f = 0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? true : -1) * 1.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelMercenaryTao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */