/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGeneralBlue
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Hat;
/*     */   public ModelRenderer Tie;
/*     */   
/*     */   public ModelGeneralBlue() {
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 32;
/*  23 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  24 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  25 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  26 */     this.Tie = new ModelRenderer(this, 0, 0);
/*  27 */     this.Tie.func_78793_a(0.0F, 0.0F, -2.0F);
/*  28 */     this.Tie.func_78790_a(-1.0F, 0.0F, 0.0F, 2, 7, 0, 0.0F);
/*  29 */     setRotateAngle(this.Tie, -0.033161256F, 0.0F, 0.0F);
/*  30 */     this.Body = new ModelRenderer(this, 16, 16);
/*  31 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  33 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  34 */     this.LegL.field_78809_i = true;
/*  35 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  36 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  37 */     this.Head = new ModelRenderer(this, 0, 0);
/*  38 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  40 */     this.Hat = new ModelRenderer(this, 24, 2);
/*  41 */     this.Hat.func_78793_a(0.0F, -5.0F, -4.4F);
/*  42 */     this.Hat.func_78790_a(-4.0F, 0.0F, -1.6F, 8, 0, 2, 0.0F);
/*  43 */     setRotateAngle(this.Hat, 0.2617994F, 0.0F, 0.0F);
/*  44 */     this.ArmL = new ModelRenderer(this, 40, 0);
/*  45 */     this.ArmL.field_78809_i = true;
/*  46 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  47 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  48 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  49 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  50 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  51 */     this.Body.func_78792_a(this.Tie);
/*  52 */     this.Head.func_78792_a(this.Hat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  57 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  59 */     this.Head.func_78785_a(f5);
/*     */     
/*  61 */     this.Body.func_78785_a(f5);
/*  62 */     this.ArmR.func_78785_a(f5);
/*  63 */     this.ArmL.func_78785_a(f5);
/*  64 */     this.LegL.func_78785_a(f5);
/*  65 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  74 */     modelRenderer.field_78795_f = x;
/*  75 */     modelRenderer.field_78796_g = y;
/*  76 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  80 */     int calc = par7Entity.field_70173_aa;
/*  81 */     if (calc > 100) calc -= 100; 
/*  82 */     float r = 360.0F;
/*  83 */     float r2 = 180.0F;
/*  84 */     float n4 = par4;
/*  85 */     float n5 = par5;
/*     */     
/*  87 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  88 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  89 */     float ex = par7Entity.field_70173_aa;
/*  90 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  91 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/*  93 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/*  94 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 144 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 145 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 146 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 148 */     this.LegR.field_78796_g = 0.0F;
/* 149 */     this.LegL.field_78796_g = 0.0F;
/* 150 */     this.ArmR.field_78796_g = 0.0F;
/* 151 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelGeneralBlue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */