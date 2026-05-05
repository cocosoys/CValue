/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelRoasie
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Head4;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelRoasie() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  29 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  31 */     this.Body1 = new ModelRenderer(this, 0, 17);
/*  32 */     this.Body1.func_78793_a(0.0F, 1.3F, 0.0F);
/*  33 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 8, 4, -0.2F);
/*  34 */     this.Head = new ModelRenderer(this, 0, 0);
/*  35 */     this.Head.func_78793_a(0.0F, 1.5F, 0.0F);
/*  36 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  37 */     this.Head2 = new ModelRenderer(this, 39, 0);
/*  38 */     this.Head2.func_78793_a(0.0F, -6.4F, -1.3F);
/*  39 */     this.Head2.func_78790_a(-1.5F, -5.7F, -1.1F, 3, 7, 3, 0.0F);
/*  40 */     setRotateAngle(this.Head2, -0.95609134F, 0.0F, 0.0F);
/*  41 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  42 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Body2.func_78790_a(-3.0F, 7.8F, -1.6F, 6, 1, 3, 0.0F);
/*  44 */     this.ArmR = new ModelRenderer(this, 32, 35);
/*  45 */     this.ArmR.func_78793_a(-4.3F, 3.0F, 0.0F);
/*  46 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  47 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  48 */     this.Head3 = new ModelRenderer(this, 40, 11);
/*  49 */     this.Head3.func_78793_a(0.0F, -5.0F, 0.1F);
/*  50 */     this.Head3.func_78790_a(-1.0F, -6.4F, -1.1F, 2, 7, 2, 0.0F);
/*  51 */     setRotateAngle(this.Head3, -0.95609134F, 0.0F, 0.0F);
/*  52 */     this.Head4 = new ModelRenderer(this, 42, 21);
/*  53 */     this.Head4.func_78793_a(0.0F, -6.4F, 0.0F);
/*  54 */     this.Head4.func_78790_a(-0.5F, -4.5F, -0.7F, 1, 5, 1, 0.0F);
/*  55 */     setRotateAngle(this.Head4, 0.68294734F, 0.0F, 0.0F);
/*  56 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  57 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  58 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  59 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, -0.1F);
/*  63 */     this.EarR = new ModelRenderer(this, 28, 1);
/*  64 */     this.EarR.func_78793_a(-3.0F, -3.0F, -0.5F);
/*  65 */     this.EarR.func_78790_a(-1.1F, -2.0F, -0.3F, 1, 3, 2, 0.0F);
/*  66 */     this.ArmL = new ModelRenderer(this, 32, 35);
/*  67 */     this.ArmL.field_78809_i = true;
/*  68 */     this.ArmL.func_78793_a(4.3F, 3.0F, 0.0F);
/*  69 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  70 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  71 */     this.EarL = new ModelRenderer(this, 28, 1);
/*  72 */     this.EarL.field_78809_i = true;
/*  73 */     this.EarL.func_78793_a(3.0F, -3.0F, -0.5F);
/*  74 */     this.EarL.func_78790_a(0.2F, -2.0F, -0.3F, 1, 3, 2, 0.0F);
/*  75 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  76 */     this.Boobs.func_78793_a(0.0F, -0.3F, 0.0F);
/*  77 */     this.Boobs.func_78790_a(-2.5F, 1.8F, -0.5F, 5, 3, 2, 0.0F);
/*  78 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  79 */     this.Body2.func_78792_a(this.Body3);
/*  80 */     this.Head.func_78792_a(this.Head2);
/*  81 */     this.Body1.func_78792_a(this.Body2);
/*  82 */     this.Head2.func_78792_a(this.Head3);
/*  83 */     this.Head3.func_78792_a(this.Head4);
/*  84 */     this.Head.func_78792_a(this.EarR);
/*  85 */     this.Head.func_78792_a(this.EarL);
/*  86 */     this.Body1.func_78792_a(this.Boobs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  91 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  93 */     this.Body1.func_78785_a(f5);
/*  94 */     this.ArmR.func_78785_a(f5);
/*  95 */     this.ArmL.func_78785_a(f5);
/*  96 */     this.LegL.func_78785_a(f5);
/*  97 */     this.Head.func_78785_a(f5);
/*  98 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 104 */     modelRenderer.field_78795_f = x;
/* 105 */     modelRenderer.field_78796_g = y;
/* 106 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 110 */     int calc = par7Entity.field_70173_aa;
/* 111 */     if (calc > 100) calc -= 100; 
/* 112 */     float r = 360.0F;
/* 113 */     float r2 = 180.0F;
/* 114 */     float n4 = par4;
/* 115 */     float n5 = par5;
/*     */ 
/*     */ 
/*     */     
/* 119 */     float ex = par7Entity.field_70173_aa;
/* 120 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 121 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 123 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 124 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 174 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 175 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 178 */     this.LegR.field_78796_g = 0.0F;
/* 179 */     this.LegL.field_78796_g = 0.0F;
/* 180 */     this.ArmR.field_78796_g = 0.0F;
/* 181 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRoasie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */