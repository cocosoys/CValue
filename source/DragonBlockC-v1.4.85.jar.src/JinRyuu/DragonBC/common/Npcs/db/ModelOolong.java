/*     */ package JinRyuu.DragonBC.common.Npcs.db;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelOolong
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer EarR1;
/*     */   public ModelRenderer EarL1;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer EarR2;
/*     */   public ModelRenderer EarL2;
/*     */   
/*     */   public ModelOolong() {
/*  23 */     this.field_78090_t = 64;
/*  24 */     this.field_78089_u = 64;
/*  25 */     this.Head_1 = new ModelRenderer(this, 35, 0);
/*  26 */     this.Head_1.func_78793_a(0.0F, -3.0F, -2.8F);
/*  27 */     this.Head_1.func_78790_a(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
/*  28 */     this.ArmR = new ModelRenderer(this, 17, 33);
/*  29 */     this.ArmR.func_78793_a(-5.0F, 8.0F, 0.0F);
/*  30 */     this.ArmR.func_78790_a(-2.0F, -0.6F, -1.4F, 3, 8, 3, 0.2F);
/*  31 */     this.Head = new ModelRenderer(this, 0, 0);
/*  32 */     this.Head.func_78793_a(0.0F, 7.2F, 0.0F);
/*  33 */     this.Head.func_78790_a(-4.0F, -8.1F, -3.6F, 8, 8, 7, 0.0F);
/*  34 */     this.EarR1 = new ModelRenderer(this, 31, 24);
/*  35 */     this.EarR1.func_78793_a(-3.9F, -6.6F, 0.0F);
/*  36 */     this.EarR1.func_78790_a(-2.0F, -2.5F, 0.0F, 4, 4, 1, 0.0F);
/*  37 */     setRotateAngle(this.EarR1, 0.13665928F, 0.18203785F, -0.91053826F);
/*  38 */     this.EarR2 = new ModelRenderer(this, 31, 31);
/*  39 */     this.EarR2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  40 */     this.EarR2.func_78790_a(-2.0F, -0.5F, -3.0F, 4, 1, 4, 0.0F);
/*  41 */     this.EarL2 = new ModelRenderer(this, 31, 31);
/*  42 */     this.EarL2.field_78809_i = true;
/*  43 */     this.EarL2.func_78793_a(0.0F, -3.0F, 0.0F);
/*  44 */     this.EarL2.func_78790_a(-2.0F, -0.5F, -3.0F, 4, 1, 4, 0.0F);
/*  45 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  46 */     this.LegL.field_78809_i = true;
/*  47 */     this.LegL.func_78793_a(2.0F, 16.5F, 0.0F);
/*  48 */     this.LegL.func_78790_a(-2.1F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  49 */     this.Body = new ModelRenderer(this, 1, 15);
/*  50 */     this.Body.func_78793_a(0.0F, 7.1F, 0.0F);
/*  51 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F);
/*  52 */     this.ArmL = new ModelRenderer(this, 17, 33);
/*  53 */     this.ArmL.field_78809_i = true;
/*  54 */     this.ArmL.func_78793_a(5.0F, 8.0F, 0.0F);
/*  55 */     this.ArmL.func_78790_a(-1.0F, -0.6F, -1.5F, 3, 8, 3, 0.2F);
/*  56 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  57 */     this.LegR.func_78793_a(-2.0F, 16.5F, 0.0F);
/*  58 */     this.LegR.func_78790_a(-1.9F, -0.4F, -2.0F, 4, 8, 4, 0.0F);
/*  59 */     this.EarL1 = new ModelRenderer(this, 31, 24);
/*  60 */     this.EarL1.field_78809_i = true;
/*  61 */     this.EarL1.func_78793_a(3.9F, -6.6F, 0.0F);
/*  62 */     this.EarL1.func_78790_a(-2.0F, -2.5F, 0.0F, 4, 4, 1, 0.0F);
/*  63 */     setRotateAngle(this.EarL1, 0.13665928F, -0.18203785F, 0.91053826F);
/*  64 */     this.Head.func_78792_a(this.Head_1);
/*  65 */     this.Head.func_78792_a(this.EarR1);
/*  66 */     this.EarR1.func_78792_a(this.EarR2);
/*  67 */     this.EarL1.func_78792_a(this.EarL2);
/*  68 */     this.Head.func_78792_a(this.EarL1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  73 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  75 */     this.Head.func_78785_a(f5);
/*     */     
/*  77 */     this.Body.func_78785_a(f5);
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
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  91 */     modelRenderer.field_78795_f = x;
/*  92 */     modelRenderer.field_78796_g = y;
/*  93 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  97 */     int calc = par7Entity.field_70173_aa;
/*  98 */     if (calc > 100) calc -= 100; 
/*  99 */     float r = 360.0F;
/* 100 */     float r2 = 180.0F;
/* 101 */     float n4 = par4;
/* 102 */     float n5 = par5;
/*     */     
/* 104 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 105 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 106 */     float ex = par7Entity.field_70173_aa;
/* 107 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 108 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 110 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 111 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 162 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 163 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 165 */     this.LegR.field_78796_g = 0.0F;
/* 166 */     this.LegL.field_78796_g = 0.0F;
/* 167 */     this.ArmR.field_78796_g = 0.0F;
/* 168 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\ModelOolong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */