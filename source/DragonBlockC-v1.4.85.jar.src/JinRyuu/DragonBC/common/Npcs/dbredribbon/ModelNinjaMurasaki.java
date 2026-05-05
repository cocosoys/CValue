/*     */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelNinjaMurasaki
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
/*     */   public ModelRenderer Sword1;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Sword2;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer LegL2;
/*     */   public ModelRenderer LegR2;
/*     */   
/*     */   public ModelNinjaMurasaki() {
/*  29 */     this.field_78090_t = 64;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.LegL = new ModelRenderer(this, 28, 34);
/*  32 */     this.LegL.field_78809_i = true;
/*  33 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  34 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
/*  35 */     this.ArmR2 = new ModelRenderer(this, 46, 29);
/*  36 */     this.ArmR2.func_78793_a(-1.1F, 5.0F, 0.0F);
/*  37 */     this.ArmR2.func_78790_a(-1.4F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
/*  38 */     this.Hair1 = new ModelRenderer(this, 28, 1);
/*  39 */     this.Hair1.func_78793_a(0.0F, -7.3F, 2.9F);
/*  40 */     this.Hair1.func_78790_a(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
/*  41 */     setRotateAngle(this.Hair1, -0.8651597F, 0.0F, 0.0F);
/*  42 */     this.ArmL = new ModelRenderer(this, 43, 16);
/*  43 */     this.ArmL.field_78809_i = true;
/*  44 */     this.ArmL.func_78793_a(5.0F, 3.0F, 0.0F);
/*  45 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F);
/*  46 */     this.ArmL2 = new ModelRenderer(this, 46, 29);
/*  47 */     this.ArmL2.field_78809_i = true;
/*  48 */     this.ArmL2.func_78793_a(0.9F, 5.0F, 0.0F);
/*  49 */     this.ArmL2.func_78790_a(-1.4F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
/*  50 */     this.LegR2 = new ModelRenderer(this, 28, 49);
/*  51 */     this.LegR2.func_78793_a(-0.1F, 10.0F, 0.0F);
/*  52 */     this.LegR2.func_78790_a(-1.4F, 0.0F, -2.9F, 3, 2, 5, 0.0F);
/*  53 */     this.Body = new ModelRenderer(this, 1, 19);
/*  54 */     this.Body.func_78793_a(0.0F, 1.0F, 0.0F);
/*  55 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F);
/*  56 */     this.Head = new ModelRenderer(this, 0, 0);
/*  57 */     this.Head.func_78793_a(0.0F, 1.0F, 0.0F);
/*  58 */     this.Head.func_78790_a(-4.0F, -8.5F, -4.0F, 8, 9, 8, -0.5F);
/*  59 */     this.Body2 = new ModelRenderer(this, 1, 32);
/*  60 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.Body2.func_78790_a(-3.5F, 8.0F, -1.5F, 7, 1, 3, 0.0F);
/*  62 */     this.LegR = new ModelRenderer(this, 28, 34);
/*  63 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  64 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
/*  65 */     this.Body3 = new ModelRenderer(this, 1, 38);
/*  66 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, 0.0F);
/*  68 */     this.Sword2 = new ModelRenderer(this, 17, 57);
/*  69 */     this.Sword2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.Sword2.func_78790_a(-2.8F, -2.0F, -0.7F, 0, 4, 2, 0.0F);
/*  71 */     this.Sword1 = new ModelRenderer(this, 22, 60);
/*  72 */     this.Sword1.func_78793_a(-2.5F, 2.6F, 2.6F);
/*  73 */     this.Sword1.func_78790_a(-8.8F, -1.0F, 0.2F, 21, 2, 0, 0.0F);
/*  74 */     setRotateAngle(this.Sword1, 0.0F, 0.034906585F, 0.7740535F);
/*  75 */     this.ArmR = new ModelRenderer(this, 43, 16);
/*  76 */     this.ArmR.func_78793_a(-5.0F, 3.0F, 0.0F);
/*  77 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F);
/*  78 */     this.LegL2 = new ModelRenderer(this, 28, 49);
/*  79 */     this.LegL2.field_78809_i = true;
/*  80 */     this.LegL2.func_78793_a(0.0F, 10.0F, 0.0F);
/*  81 */     this.LegL2.func_78790_a(-1.4F, 0.0F, -2.9F, 3, 2, 5, 0.0F);
/*  82 */     this.Hair2 = new ModelRenderer(this, 35, 1);
/*  83 */     this.Hair2.func_78793_a(0.0F, -4.1F, 0.0F);
/*  84 */     this.Hair2.func_78790_a(-3.0F, -3.1F, 0.0F, 6, 6, 0, 0.0F);
/*  85 */     setRotateAngle(this.Hair2, 1.5707964F, 0.0F, 0.0F);
/*  86 */     this.ArmR.func_78792_a(this.ArmR2);
/*  87 */     this.Head.func_78792_a(this.Hair1);
/*  88 */     this.ArmL.func_78792_a(this.ArmL2);
/*  89 */     this.LegR.func_78792_a(this.LegR2);
/*  90 */     this.Body.func_78792_a(this.Body2);
/*  91 */     this.Body2.func_78792_a(this.Body3);
/*  92 */     this.Sword1.func_78792_a(this.Sword2);
/*  93 */     this.Body.func_78792_a(this.Sword1);
/*  94 */     this.LegL.func_78792_a(this.LegL2);
/*  95 */     this.Hair1.func_78792_a(this.Hair2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 100 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 102 */     this.Head.func_78785_a(f5);
/*     */     
/* 104 */     this.Body.func_78785_a(f5);
/* 105 */     this.ArmR.func_78785_a(f5);
/* 106 */     this.ArmL.func_78785_a(f5);
/* 107 */     this.LegL.func_78785_a(f5);
/* 108 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 117 */     modelRenderer.field_78795_f = x;
/* 118 */     modelRenderer.field_78796_g = y;
/* 119 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 123 */     int calc = par7Entity.field_70173_aa;
/* 124 */     if (calc > 100) calc -= 100; 
/* 125 */     float r = 360.0F;
/* 126 */     float r2 = 180.0F;
/* 127 */     float n4 = par4;
/* 128 */     float n5 = par5;
/*     */     
/* 130 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 131 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 132 */     float ex = par7Entity.field_70173_aa;
/* 133 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 134 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 136 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 137 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 187 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 188 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 189 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 191 */     this.LegR.field_78796_g = 0.0F;
/* 192 */     this.LegL.field_78796_g = 0.0F;
/* 193 */     this.ArmR.field_78796_g = 0.0F;
/* 194 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\ModelNinjaMurasaki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */