/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRedRibbonSoldierBazooka
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmR3;
/*     */   public ModelRenderer Bazooka1;
/*     */   public ModelRenderer Bazooka2;
/*     */   public ModelRenderer Bazooka3;
/*     */   public ModelRenderer Bazooka4;
/*     */   public ModelRenderer Bazooka5;
/*     */   public ModelRenderer Bazooka6;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmL3;
/*     */   public ModelRenderer Ribbon;
/*     */   
/*     */   public ModelRedRibbonSoldierBazooka() {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.Bazooka4 = new ModelRenderer(this, 49, 45);
/*  33 */     this.Bazooka4.func_78793_a(0.0F, 0.0F, 2.0F);
/*  34 */     this.Bazooka4.func_78790_a(-2.5F, -2.5F, 0.0F, 5, 5, 2, 0.0F);
/*  35 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  36 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  37 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  38 */     this.ArmR2 = new ModelRenderer(this, 0, 32);
/*  39 */     this.ArmR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.ArmR2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  41 */     setRotateAngle(this.ArmR2, -1.0871656F, -0.3642502F, 0.0F);
/*  42 */     this.Bazooka3 = new ModelRenderer(this, 49, 53);
/*  43 */     this.Bazooka3.func_78793_a(0.0F, -1.2F, 3.9F);
/*  44 */     this.Bazooka3.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 2, 0.0F);
/*  45 */     this.Body = new ModelRenderer(this, 16, 16);
/*  46 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  48 */     this.Bazooka2 = new ModelRenderer(this, 34, 55);
/*  49 */     this.Bazooka2.func_78793_a(0.0F, 1.1F, 0.8F);
/*  50 */     this.Bazooka2.func_78790_a(-0.9F, 0.4F, 0.0F, 2, 3, 1, 0.0F);
/*  51 */     this.ArmL2 = new ModelRenderer(this, 0, 43);
/*  52 */     this.ArmL2.field_78809_i = true;
/*  53 */     this.ArmL2.func_78793_a(-1.2F, 0.0F, 0.0F);
/*  54 */     this.ArmL2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
/*  55 */     setRotateAngle(this.ArmL2, -1.2292354F, 0.91053826F, 0.3642502F);
/*  56 */     this.ArmL = new ModelRenderer(this, 0, 0);
/*  57 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  58 */     this.ArmL.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  59 */     this.ArmR3 = new ModelRenderer(this, 17, 32);
/*  60 */     this.ArmR3.func_78793_a(-1.0F, 4.0F, 0.0F);
/*  61 */     this.ArmR3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  62 */     setRotateAngle(this.ArmR3, -1.1124729F, 0.091106184F, 0.0F);
/*  63 */     this.Ribbon = new ModelRenderer(this, 41, 20);
/*  64 */     this.Ribbon.func_78793_a(2.8F, 0.9F, 0.0F);
/*  65 */     this.Ribbon.func_78790_a(0.0F, -1.9F, 0.0F, 6, 5, 0, 0.0F);
/*  66 */     setRotateAngle(this.Ribbon, 0.0F, -0.95609134F, 0.0F);
/*  67 */     this.ArmR = new ModelRenderer(this, 0, 0);
/*  68 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  69 */     this.ArmR.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
/*  70 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  71 */     this.LegL.field_78809_i = true;
/*  72 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  73 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  74 */     this.Bazooka6 = new ModelRenderer(this, 51, 33);
/*  75 */     this.Bazooka6.func_78793_a(0.0F, 0.0F, 1.9F);
/*  76 */     this.Bazooka6.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
/*  77 */     this.ArmL3 = new ModelRenderer(this, 17, 43);
/*  78 */     this.ArmL3.field_78809_i = true;
/*  79 */     this.ArmL3.func_78793_a(1.0F, 4.0F, 0.0F);
/*  80 */     this.ArmL3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
/*  81 */     this.Bazooka5 = new ModelRenderer(this, 49, 38);
/*  82 */     this.Bazooka5.func_78793_a(0.0F, 0.0F, 1.9F);
/*  83 */     this.Bazooka5.func_78790_a(-2.0F, -2.0F, 0.0F, 4, 4, 2, 0.0F);
/*  84 */     this.Head = new ModelRenderer(this, 0, 0);
/*  85 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  87 */     this.Bazooka1 = new ModelRenderer(this, 27, 45);
/*  88 */     this.Bazooka1.func_78793_a(-0.2F, 4.1F, -2.0F);
/*  89 */     this.Bazooka1.func_78790_a(-1.5F, -1.5F, -10.2F, 3, 3, 15, 0.0F);
/*  90 */     setRotateAngle(this.Bazooka1, -0.9822713F, -0.22759093F, 0.18203785F);
/*  91 */     this.Bazooka3.func_78792_a(this.Bazooka4);
/*  92 */     this.ArmR.func_78792_a(this.ArmR2);
/*  93 */     this.Bazooka2.func_78792_a(this.Bazooka3);
/*  94 */     this.Bazooka1.func_78792_a(this.Bazooka2);
/*  95 */     this.ArmL.func_78792_a(this.ArmL2);
/*  96 */     this.ArmR2.func_78792_a(this.ArmR3);
/*  97 */     this.ArmL2.func_78792_a(this.Ribbon);
/*  98 */     this.Bazooka5.func_78792_a(this.Bazooka6);
/*  99 */     this.ArmL2.func_78792_a(this.ArmL3);
/* 100 */     this.Bazooka4.func_78792_a(this.Bazooka5);
/* 101 */     this.ArmR3.func_78792_a(this.Bazooka1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 106 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 108 */     this.Head.func_78785_a(f5);
/*     */     
/* 110 */     this.Body.func_78785_a(f5);
/* 111 */     this.ArmR.func_78785_a(f5);
/* 112 */     this.ArmL.func_78785_a(f5);
/* 113 */     this.LegL.func_78785_a(f5);
/* 114 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 123 */     modelRenderer.field_78795_f = x;
/* 124 */     modelRenderer.field_78796_g = y;
/* 125 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 129 */     int calc = par7Entity.field_70173_aa;
/* 130 */     if (calc > 100) calc -= 100; 
/* 131 */     float r = 360.0F;
/* 132 */     float r2 = 180.0F;
/* 133 */     float n4 = par4;
/* 134 */     float n5 = par5;
/*     */     
/* 136 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 137 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 138 */     float ex = par7Entity.field_70173_aa;
/* 139 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 140 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 142 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 143 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 193 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */ 
/*     */ 
/*     */     
/* 197 */     this.LegR.field_78796_g = 0.0F;
/* 198 */     this.LegL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelRedRibbonSoldierBazooka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */