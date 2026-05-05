/*     */ package JinRyuu.DragonBC.common.Npcs.dbz;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelOfficeOgre
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer HornM1;
/*     */   public ModelRenderer HornR1;
/*     */   public ModelRenderer HornL1;
/*     */   public ModelRenderer Glasses;
/*     */   public ModelRenderer HornM2;
/*     */   public ModelRenderer HornR2;
/*     */   public ModelRenderer HornL2;
/*     */   public ModelRenderer Tie;
/*     */   
/*     */   public ModelOfficeOgre() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Tie = new ModelRenderer(this, 1, 0);
/*  29 */     this.Tie.func_78793_a(0.0F, 0.0F, -2.2F);
/*  30 */     this.Tie.func_78790_a(-1.0F, 0.0F, 0.0F, 2, 7, 0, 0.0F);
/*  31 */     setRotateAngle(this.Tie, -0.017453292F, 0.0F, 0.0F);
/*  32 */     this.HornL1 = new ModelRenderer(this, 25, 0);
/*  33 */     this.HornL1.func_78793_a(3.0F, -7.4F, 0.0F);
/*  34 */     this.HornL1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
/*  35 */     setRotateAngle(this.HornL1, 0.0F, 0.0F, 0.4537856F);
/*  36 */     this.HornR2 = new ModelRenderer(this, 34, 0);
/*  37 */     this.HornR2.func_78793_a(0.0F, -1.7F, 0.0F);
/*  38 */     this.HornR2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
/*  39 */     this.LegR = new ModelRenderer(this, 0, 35);
/*  40 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  41 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  42 */     this.LegL = new ModelRenderer(this, 0, 35);
/*  43 */     this.LegL.field_78809_i = true;
/*  44 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  45 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  46 */     this.HornM1 = new ModelRenderer(this, 25, 4);
/*  47 */     this.HornM1.func_78793_a(0.0F, -8.0F, 0.0F);
/*  48 */     this.HornM1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
/*  49 */     this.ArmL = new ModelRenderer(this, 18, 35);
/*  50 */     this.ArmL.field_78809_i = true;
/*  51 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  52 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  53 */     this.HornL2 = new ModelRenderer(this, 34, 0);
/*  54 */     this.HornL2.func_78793_a(0.0F, -1.7F, 0.0F);
/*  55 */     this.HornL2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
/*  56 */     this.Body = new ModelRenderer(this, 0, 17);
/*  57 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  59 */     this.Glasses = new ModelRenderer(this, 29, 19);
/*  60 */     this.Glasses.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Glasses.func_78790_a(-4.5F, -5.3F, -4.3F, 9, 3, 7, 0.0F);
/*  62 */     this.ArmR = new ModelRenderer(this, 18, 35);
/*  63 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  64 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  65 */     this.HornR1 = new ModelRenderer(this, 25, 0);
/*  66 */     this.HornR1.func_78793_a(-3.0F, -7.4F, 0.0F);
/*  67 */     this.HornR1.func_78790_a(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
/*  68 */     setRotateAngle(this.HornR1, 0.0F, 0.0F, -0.4537856F);
/*  69 */     this.HornM2 = new ModelRenderer(this, 34, 4);
/*  70 */     this.HornM2.func_78793_a(0.0F, -1.7F, 0.0F);
/*  71 */     this.HornM2.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
/*  72 */     this.Head = new ModelRenderer(this, 0, 0);
/*  73 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  75 */     this.Body.func_78792_a(this.Tie);
/*  76 */     this.Head.func_78792_a(this.HornL1);
/*  77 */     this.HornR1.func_78792_a(this.HornR2);
/*  78 */     this.Head.func_78792_a(this.HornM1);
/*  79 */     this.HornL1.func_78792_a(this.HornL2);
/*  80 */     this.Head.func_78792_a(this.Glasses);
/*  81 */     this.Head.func_78792_a(this.HornR1);
/*  82 */     this.HornM1.func_78792_a(this.HornM2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  87 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  89 */     this.Head.func_78785_a(f5);
/*     */     
/*  91 */     this.Body.func_78785_a(f5);
/*  92 */     this.ArmR.func_78785_a(f5);
/*  93 */     this.ArmL.func_78785_a(f5);
/*  94 */     this.LegL.func_78785_a(f5);
/*  95 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 105 */     modelRenderer.field_78795_f = x;
/* 106 */     modelRenderer.field_78796_g = y;
/* 107 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 111 */     int calc = par7Entity.field_70173_aa;
/* 112 */     if (calc > 100) calc -= 100; 
/* 113 */     float r = 360.0F;
/* 114 */     float r2 = 180.0F;
/* 115 */     float n4 = par4;
/* 116 */     float n5 = par5;
/*     */     
/* 118 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 119 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 120 */     float ex = par7Entity.field_70173_aa;
/* 121 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 122 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 124 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 125 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 179 */     this.LegR.field_78796_g = 0.0F;
/* 180 */     this.LegL.field_78796_g = 0.0F;
/* 181 */     this.ArmR.field_78796_g = 0.0F;
/* 182 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbz\ModelOfficeOgre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */