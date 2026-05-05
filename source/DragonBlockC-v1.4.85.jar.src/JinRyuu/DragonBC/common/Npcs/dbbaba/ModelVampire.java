/*     */ package JinRyuu.DragonBC.common.Npcs.dbbaba;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelVampire
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   
/*     */   public ModelVampire() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.Body = new ModelRenderer(this, 17, 16);
/*  31 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F);
/*  33 */     this.ArmL2 = new ModelRenderer(this, 0, 54);
/*  34 */     this.ArmL2.field_78809_i = true;
/*  35 */     this.ArmL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  37 */     setRotateAngle(this.ArmL2, -0.6981317F, 0.12217305F, 0.0F);
/*  38 */     this.Head = new ModelRenderer(this, 0, 0);
/*  39 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  41 */     this.LegR = new ModelRenderer(this, 0, 19);
/*  42 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  43 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  44 */     this.Hair = new ModelRenderer(this, 32, 0);
/*  45 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.Hair.func_78790_a(-4.0F, -12.0F, -4.0F, 8, 4, 8, 0.0F);
/*  47 */     this.ArmR = new ModelRenderer(this, 0, 0);
/*  48 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  49 */     this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  50 */     this.ArmR2 = new ModelRenderer(this, 0, 43);
/*  51 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  53 */     setRotateAngle(this.ArmR2, -0.6981317F, -0.12217305F, 0.0F);
/*  54 */     this.LegL = new ModelRenderer(this, 0, 19);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  58 */     this.ArmL3 = new ModelRenderer(this, 17, 54);
/*  59 */     this.ArmL3.field_78809_i = true;
/*  60 */     this.ArmL3.func_78793_a(1.0F, 4.0F, -1.5F);
/*  61 */     this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  62 */     setRotateAngle(this.ArmL3, -1.6580628F, 0.034906585F, 0.0F);
/*  63 */     this.Body3 = new ModelRenderer(this, 17, 35);
/*  64 */     this.Body3.func_78793_a(0.0F, 3.0F, 0.0F);
/*  65 */     this.Body3.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 3, 4, 0.0F);
/*  66 */     this.EarR = new ModelRenderer(this, 1, 2);
/*  67 */     this.EarR.func_78793_a(-3.8F, -4.4F, -1.5F);
/*  68 */     this.EarR.func_78790_a(-3.0F, -3.7F, 0.0F, 3, 5, 0, 0.0F);
/*  69 */     setRotateAngle(this.EarR, 0.0F, 0.87266463F, 0.0F);
/*  70 */     this.Body2 = new ModelRenderer(this, 18, 27);
/*  71 */     this.Body2.func_78793_a(0.0F, 6.0F, 0.0F);
/*  72 */     this.Body2.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 3, 4, 0.0F);
/*  73 */     this.ArmR3 = new ModelRenderer(this, 17, 43);
/*  74 */     this.ArmR3.func_78793_a(-1.0F, 4.0F, -1.5F);
/*  75 */     this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  76 */     setRotateAngle(this.ArmR3, -1.6580628F, -0.034906585F, 0.0F);
/*  77 */     this.ArmL = new ModelRenderer(this, 0, 0);
/*  78 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  79 */     this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  80 */     this.EarL = new ModelRenderer(this, 1, 2);
/*  81 */     this.EarL.field_78809_i = true;
/*  82 */     this.EarL.func_78793_a(3.8F, -4.4F, -1.5F);
/*  83 */     this.EarL.func_78790_a(0.0F, -3.7F, 0.0F, 3, 5, 0, 0.0F);
/*  84 */     setRotateAngle(this.EarL, 0.0F, -0.87266463F, 0.0F);
/*  85 */     this.ArmL.func_78792_a(this.ArmL2);
/*  86 */     this.Head.func_78792_a(this.Hair);
/*  87 */     this.ArmR.func_78792_a(this.ArmR2);
/*  88 */     this.ArmL2.func_78792_a(this.ArmL3);
/*  89 */     this.Body2.func_78792_a(this.Body3);
/*  90 */     this.Head.func_78792_a(this.EarR);
/*  91 */     this.Body.func_78792_a(this.Body2);
/*  92 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  93 */     this.Head.func_78792_a(this.EarL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  98 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 100 */     this.Head.func_78785_a(f5);
/*     */     
/* 102 */     this.Body.func_78785_a(f5);
/* 103 */     this.ArmR.func_78785_a(f5);
/* 104 */     this.ArmL.func_78785_a(f5);
/* 105 */     this.LegL.func_78785_a(f5);
/* 106 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 115 */     modelRenderer.field_78795_f = x;
/* 116 */     modelRenderer.field_78796_g = y;
/* 117 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 121 */     int calc = par7Entity.field_70173_aa;
/* 122 */     if (calc > 100) calc -= 100; 
/* 123 */     float r = 360.0F;
/* 124 */     float r2 = 180.0F;
/* 125 */     float n4 = par4;
/* 126 */     float n5 = par5;
/*     */     
/* 128 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 129 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 130 */     float ex = par7Entity.field_70173_aa;
/* 131 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 132 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 134 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 135 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 185 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 186 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 189 */     this.LegR.field_78796_g = 0.0F;
/* 190 */     this.LegL.field_78796_g = 0.0F;
/* 191 */     this.ArmR.field_78796_g = 0.0F;
/* 192 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbbaba\ModelVampire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */