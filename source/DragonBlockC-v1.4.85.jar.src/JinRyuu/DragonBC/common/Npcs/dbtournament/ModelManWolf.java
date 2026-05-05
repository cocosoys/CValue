/*     */ package JinRyuu.DragonBC.common.Npcs.dbtournament;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelManWolf
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR1;
/*     */   public ModelRenderer ArmL1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Nose;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer MuttonchopsR;
/*     */   public ModelRenderer MuttonchopsL;
/*     */   
/*     */   public ModelManWolf() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.ArmR1 = new ModelRenderer(this, 34, 16);
/*  27 */     this.ArmR1.func_78793_a(-6.5F, 2.0F, 1.0F);
/*  28 */     this.ArmR1.func_78790_a(-3.5F, -2.0F, -2.5F, 5, 12, 5, 0.0F);
/*  29 */     this.MuttonchopsR = new ModelRenderer(this, 55, 8);
/*  30 */     this.MuttonchopsR.func_78793_a(-3.5F, -3.5F, -2.1F);
/*  31 */     this.MuttonchopsR.func_78790_a(-2.0F, -0.4F, 0.0F, 2, 4, 0, 0.0F);
/*  32 */     setRotateAngle(this.MuttonchopsR, 0.0F, 0.6981317F, 0.08726646F);
/*  33 */     this.MuttonchopsL = new ModelRenderer(this, 55, 8);
/*  34 */     this.MuttonchopsL.field_78809_i = true;
/*  35 */     this.MuttonchopsL.func_78793_a(3.5F, -3.5F, -2.1F);
/*  36 */     this.MuttonchopsL.func_78790_a(0.0F, -0.2F, 0.0F, 2, 4, 0, 0.0F);
/*  37 */     setRotateAngle(this.MuttonchopsL, 0.0F, -0.6981317F, -0.08726646F);
/*  38 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  39 */     this.Body1.func_78793_a(0.0F, 0.0F, 1.0F);
/*  40 */     this.Body1.func_78790_a(-5.0F, 0.0F, -3.0F, 10, 12, 6, 0.0F);
/*  41 */     this.EarR = new ModelRenderer(this, 47, 8);
/*  42 */     this.EarR.func_78793_a(-3.6F, -4.0F, -1.0F);
/*  43 */     this.EarR.func_78790_a(-2.5F, -3.0F, 0.0F, 3, 4, 0, 0.0F);
/*  44 */     setRotateAngle(this.EarR, 0.0F, 0.34906584F, -0.04363323F);
/*  45 */     this.LegL = new ModelRenderer(this, 1, 40);
/*  46 */     this.LegL.field_78809_i = true;
/*  47 */     this.LegL.func_78793_a(2.6F, 12.0F, 1.0F);
/*  48 */     this.LegL.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.1F);
/*  49 */     this.EarL = new ModelRenderer(this, 47, 8);
/*  50 */     this.EarL.field_78809_i = true;
/*  51 */     this.EarL.func_78793_a(3.0F, -4.0F, -1.0F);
/*  52 */     this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 3, 4, 0, 0.0F);
/*  53 */     setRotateAngle(this.EarL, 0.0F, -0.34906584F, 0.04363323F);
/*  54 */     this.Head = new ModelRenderer(this, 0, 0);
/*  55 */     this.Head.func_78793_a(0.0F, 0.0F, 0.6F);
/*  56 */     this.Head.func_78790_a(-4.0F, -6.0F, -4.0F, 8, 6, 8, 0.0F);
/*  57 */     this.ArmL1 = new ModelRenderer(this, 34, 16);
/*  58 */     this.ArmL1.field_78809_i = true;
/*  59 */     this.ArmL1.func_78793_a(6.5F, 2.0F, 1.0F);
/*  60 */     this.ArmL1.func_78790_a(-1.5F, -2.0F, -2.5F, 5, 12, 5, 0.0F);
/*  61 */     this.LegR = new ModelRenderer(this, 1, 40);
/*  62 */     this.LegR.func_78793_a(-2.6F, 12.0F, 1.0F);
/*  63 */     this.LegR.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 12, 5, 0.1F);
/*  64 */     this.Nose = new ModelRenderer(this, 46, 0);
/*  65 */     this.Nose.func_78793_a(0.0F, -2.0F, -3.7F);
/*  66 */     this.Nose.func_78790_a(-2.0F, -1.0F, -2.9F, 4, 3, 3, 0.0F);
/*  67 */     this.Head.func_78792_a(this.MuttonchopsR);
/*  68 */     this.Head.func_78792_a(this.MuttonchopsL);
/*  69 */     this.Head.func_78792_a(this.EarR);
/*  70 */     this.Head.func_78792_a(this.EarL);
/*  71 */     this.Head.func_78792_a(this.Nose);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  76 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  78 */     this.Head.func_78785_a(f5);
/*     */     
/*  80 */     this.Body1.func_78785_a(f5);
/*  81 */     this.ArmR1.func_78785_a(f5);
/*  82 */     this.ArmL1.func_78785_a(f5);
/*  83 */     this.LegL.func_78785_a(f5);
/*  84 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  94 */     modelRenderer.field_78795_f = x;
/*  95 */     modelRenderer.field_78796_g = y;
/*  96 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 100 */     int calc = par7Entity.field_70173_aa;
/* 101 */     if (calc > 100) calc -= 100; 
/* 102 */     float r = 360.0F;
/* 103 */     float r2 = 180.0F;
/* 104 */     float n4 = par4;
/* 105 */     float n5 = par5;
/*     */     
/* 107 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 108 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 109 */     float ex = par7Entity.field_70173_aa;
/* 110 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 111 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 113 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 114 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 164 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 165 */     this.ArmR1.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 166 */     this.ArmL1.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 168 */     this.LegR.field_78796_g = 0.0F;
/* 169 */     this.LegL.field_78796_g = 0.0F;
/* 170 */     this.ArmR1.field_78796_g = 0.0F;
/* 171 */     this.ArmL1.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbtournament\ModelManWolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */