/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGodGiin
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Cloth1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelGodGiin() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Neck = new ModelRenderer(this, 33, 10);
/*  29 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Neck.func_78790_a(-2.5F, -0.9F, -1.2F, 5, 2, 3, 0.0F);
/*  31 */     this.EarL = new ModelRenderer(this, 33, 2);
/*  32 */     this.EarL.func_78793_a(3.5F, -4.0F, -1.2F);
/*  33 */     this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/*  34 */     setRotateAngle(this.EarL, 0.0F, -0.7853982F, 0.0F);
/*  35 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  36 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.Body1.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 5, 5, 0.0F);
/*  38 */     this.ArmR = new ModelRenderer(this, 48, 16);
/*  39 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.3F);
/*  40 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -1.8F, 4, 12, 4, 0.0F);
/*  41 */     this.Cloth1 = new ModelRenderer(this, 27, 48);
/*  42 */     this.Cloth1.func_78793_a(0.0F, 10.0F, -1.5F);
/*  43 */     this.Cloth1.func_78790_a(-2.5F, 0.0F, -0.5F, 5, 10, 0, 0.0F);
/*  44 */     setRotateAngle(this.Cloth1, -0.090757124F, 0.0F, 0.0F);
/*  45 */     this.LegL = new ModelRenderer(this, 3, 36);
/*  46 */     this.LegL.field_78809_i = true;
/*  47 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  48 */     this.LegL.func_78790_a(-1.7F, 2.1F, -2.0F, 4, 5, 4, 0.3F);
/*  49 */     this.Body3 = new ModelRenderer(this, 20, 38);
/*  50 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.Body3.func_78790_a(-4.0F, 8.0F, -2.0F, 8, 4, 4, 0.0F);
/*  52 */     this.ArmL = new ModelRenderer(this, 48, 16);
/*  53 */     this.ArmL.field_78809_i = true;
/*  54 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.3F);
/*  55 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -1.8F, 4, 12, 4, 0.0F);
/*  56 */     this.LegL2 = new ModelRenderer(this, 3, 46);
/*  57 */     this.LegL2.field_78809_i = true;
/*  58 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.LegL2.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  60 */     this.Head = new ModelRenderer(this, 0, 0);
/*  61 */     this.Head.func_78793_a(0.0F, -0.3F, 0.0F);
/*  62 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.3F);
/*  63 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  64 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Body2.func_78790_a(-3.5F, 4.0F, -2.3F, 7, 4, 4, 0.0F);
/*  66 */     this.LegR2 = new ModelRenderer(this, 3, 46);
/*  67 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.LegR2.func_78790_a(-2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  69 */     this.LegR = new ModelRenderer(this, 3, 36);
/*  70 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  71 */     this.LegR.func_78790_a(-2.4F, 2.1F, -2.0F, 4, 5, 4, 0.3F);
/*  72 */     this.EarR = new ModelRenderer(this, 33, 2);
/*  73 */     this.EarR.field_78809_i = true;
/*  74 */     this.EarR.func_78793_a(-3.5F, -4.0F, -1.2F);
/*  75 */     this.EarR.func_78790_a(-4.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/*  76 */     setRotateAngle(this.EarR, 0.0F, 0.7853982F, 0.0F);
/*  77 */     this.Body1.func_78792_a(this.Neck);
/*  78 */     this.Head.func_78792_a(this.EarL);
/*  79 */     this.Body1.func_78792_a(this.Cloth1);
/*  80 */     this.Body2.func_78792_a(this.Body3);
/*  81 */     this.LegL.func_78792_a(this.LegL2);
/*  82 */     this.Body1.func_78792_a(this.Body2);
/*  83 */     this.LegR.func_78792_a(this.LegR2);
/*  84 */     this.Head.func_78792_a(this.EarR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  89 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  92 */     this.LegL.func_78785_a(f5);
/*  93 */     this.Head.func_78785_a(f5);
/*  94 */     this.ArmL.func_78785_a(f5);
/*  95 */     this.ArmR.func_78785_a(f5);
/*  96 */     this.Body1.func_78785_a(f5);
/*  97 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 103 */     modelRenderer.field_78795_f = x;
/* 104 */     modelRenderer.field_78796_g = y;
/* 105 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 109 */     int calc = par7Entity.field_70173_aa;
/* 110 */     if (calc > 100) calc -= 100; 
/* 111 */     float r = 360.0F;
/* 112 */     float r2 = 180.0F;
/* 113 */     float n4 = par4;
/* 114 */     float n5 = par5;
/*     */     
/* 116 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 117 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 118 */     float ex = par7Entity.field_70173_aa;
/* 119 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 120 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 122 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 123 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 170 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 171 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 172 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 174 */     this.LegR.field_78796_g = 0.0F;
/* 175 */     this.LegL.field_78796_g = 0.0F;
/* 176 */     this.ArmR.field_78796_g = 0.0F;
/* 177 */     this.ArmL.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 180 */     this.Cloth1.field_78795_f = -0.15F + this.LegR.field_78795_f * ((this.LegR.field_78795_f >= 0.0F) ? -1 : true) * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 184 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelGodGiin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */