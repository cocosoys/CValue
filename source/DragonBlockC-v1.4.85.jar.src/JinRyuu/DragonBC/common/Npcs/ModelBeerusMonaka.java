/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBeerusMonaka
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Belt;
/*     */   public ModelRenderer NeckCape;
/*     */   public ModelRenderer CapeBase;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelBeerusMonaka() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.earR = new ModelRenderer(this, 33, 4);
/*  30 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  31 */     this.earR.func_78790_a(-6.5F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
/*  32 */     setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
/*  33 */     this.Head = new ModelRenderer(this, 0, 0);
/*  34 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  35 */     this.Head.func_78790_a(-4.1F, -7.7F, -4.0F, 8, 8, 8, 0.0F);
/*  36 */     this.NeckCape = new ModelRenderer(this, 37, 8);
/*  37 */     this.NeckCape.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.NeckCape.func_78790_a(-4.5F, -2.7F, 0.1F, 9, 3, 4, 0.0F);
/*  39 */     this.LegR = new ModelRenderer(this, 0, 39);
/*  40 */     this.LegR.func_78793_a(-2.1F, 12.0F, 0.0F);
/*  41 */     this.LegR.func_78790_a(-2.1F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  42 */     this.Belt = new ModelRenderer(this, 40, 36);
/*  43 */     this.Belt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.Belt.func_78790_a(-2.0F, 4.9F, -2.6F, 4, 4, 1, 0.0F);
/*  45 */     this.ArmR = new ModelRenderer(this, 2, 20);
/*  46 */     this.ArmR.func_78793_a(-4.8F, 1.5F, 0.0F);
/*  47 */     this.ArmR.func_78790_a(-2.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  48 */     this.Body2 = new ModelRenderer(this, 17, 37);
/*  49 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Body2.func_78790_a(-4.0F, 8.0F, -2.3F, 8, 4, 5, 0.0F);
/*  51 */     this.LegR2 = new ModelRenderer(this, 0, 55);
/*  52 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.LegR2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  54 */     this.ArmL = new ModelRenderer(this, 2, 20);
/*  55 */     this.ArmL.field_78809_i = true;
/*  56 */     this.ArmL.func_78793_a(4.8F, 1.5F, 0.0F);
/*  57 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  58 */     this.Neck = new ModelRenderer(this, 23, 17);
/*  59 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Neck.func_78790_a(-2.0F, -1.0F, -0.8F, 4, 2, 2, 0.0F);
/*  61 */     this.CapeBase = new ModelRenderer(this, 43, 16);
/*  62 */     this.CapeBase.func_78793_a(0.0F, 0.3F, 2.3F);
/*  63 */     this.CapeBase.func_78790_a(-4.5F, 0.0F, -0.4F, 9, 15, 1, 0.0F);
/*  64 */     setRotateAngle(this.CapeBase, 0.090757124F, 0.0F, 0.0F);
/*  65 */     this.LegL2 = new ModelRenderer(this, 0, 55);
/*  66 */     this.LegL2.field_78809_i = true;
/*  67 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.LegL2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  69 */     this.Body1 = new ModelRenderer(this, 18, 23);
/*  70 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 8, 4, 0.0F);
/*  72 */     this.earL = new ModelRenderer(this, 33, 4);
/*  73 */     this.earL.field_78809_i = true;
/*  74 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.earL.func_78790_a(3.3F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
/*  76 */     setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
/*  77 */     this.LegL = new ModelRenderer(this, 0, 39);
/*  78 */     this.LegL.field_78809_i = true;
/*  79 */     this.LegL.func_78793_a(2.1F, 12.0F, 0.0F);
/*  80 */     this.LegL.func_78790_a(-1.9F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  81 */     this.Head.func_78792_a(this.earR);
/*  82 */     this.Body1.func_78792_a(this.NeckCape);
/*  83 */     this.Body1.func_78792_a(this.Belt);
/*  84 */     this.Body1.func_78792_a(this.Body2);
/*  85 */     this.LegR.func_78792_a(this.LegR2);
/*  86 */     this.Body1.func_78792_a(this.Neck);
/*  87 */     this.NeckCape.func_78792_a(this.CapeBase);
/*  88 */     this.LegL.func_78792_a(this.LegL2);
/*  89 */     this.Head.func_78792_a(this.earL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  94 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  97 */     this.LegL.func_78785_a(f5);
/*  98 */     this.Head.func_78785_a(f5);
/*  99 */     this.ArmL.func_78785_a(f5);
/* 100 */     this.ArmR.func_78785_a(f5);
/* 101 */     this.Body1.func_78785_a(f5);
/* 102 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 107 */     modelRenderer.field_78795_f = x;
/* 108 */     modelRenderer.field_78796_g = y;
/* 109 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 113 */     int calc = par7Entity.field_70173_aa;
/* 114 */     if (calc > 100) calc -= 100; 
/* 115 */     float r = 360.0F;
/* 116 */     float r2 = 180.0F;
/* 117 */     float n4 = par4;
/* 118 */     float n5 = par5;
/*     */     
/* 120 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 121 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 122 */     float ex = par7Entity.field_70173_aa;
/* 123 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 124 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     this.CapeBase.field_78795_f = -0.15F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 131 */     if (0.0F > this.CapeBase.field_78795_f) this.CapeBase.field_78795_f *= -1.0F; 
/* 132 */     this.CapeBase.field_78796_g = 0.0F;
/*     */ 
/*     */     
/* 135 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 136 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 137 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 138 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 139 */     this.LegR.field_78796_g = 0.0F;
/* 140 */     this.LegL.field_78796_g = 0.0F;
/* 141 */     this.ArmR.field_78796_g = 0.0F;
/* 142 */     this.ArmL.field_78796_g = 0.0F;
/* 143 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBeerusMonaka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */