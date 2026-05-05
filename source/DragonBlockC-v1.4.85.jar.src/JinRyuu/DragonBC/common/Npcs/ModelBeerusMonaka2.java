/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBeerusMonaka2
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
/*     */   public ModelRenderer Cape1;
/*     */   public ModelRenderer CapeBack;
/*     */   public ModelRenderer CapeSideR;
/*     */   public ModelRenderer CapeSideL;
/*     */   public ModelRenderer CapeFront;
/*     */   public ModelRenderer LegR2;
/*     */   public ModelRenderer LegL2;
/*     */   
/*     */   public ModelBeerusMonaka2() {
/*  29 */     this.field_78090_t = 64;
/*  30 */     this.field_78089_u = 64;
/*  31 */     this.LegL2 = new ModelRenderer(this, 0, 55);
/*  32 */     this.LegL2.field_78809_i = true;
/*  33 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.LegL2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  35 */     this.earR = new ModelRenderer(this, 33, 4);
/*  36 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.earR.func_78790_a(-6.5F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
/*  38 */     setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
/*  39 */     this.Body1 = new ModelRenderer(this, 18, 23);
/*  40 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 8, 4, 0.0F);
/*  42 */     this.LegL = new ModelRenderer(this, 0, 39);
/*  43 */     this.LegL.field_78809_i = true;
/*  44 */     this.LegL.func_78793_a(2.1F, 12.0F, 0.0F);
/*  45 */     this.LegL.func_78790_a(-1.9F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  46 */     this.CapeSideR = new ModelRenderer(this, 47, 35);
/*  47 */     this.CapeSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.CapeSideR.func_78790_a(-4.7F, 8.1F, -4.9F, 2, 4, 5, 0.0F);
/*  49 */     this.CapeSideL = new ModelRenderer(this, 47, 35);
/*  50 */     this.CapeSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.CapeSideL.func_78790_a(2.7F, 8.2F, -4.9F, 2, 4, 5, 0.0F);
/*  52 */     this.Head = new ModelRenderer(this, 0, 0);
/*  53 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  54 */     this.Head.func_78790_a(-4.1F, -7.7F, -4.0F, 8, 8, 8, 0.0F);
/*  55 */     this.ArmL = new ModelRenderer(this, 2, 20);
/*  56 */     this.ArmL.field_78809_i = true;
/*  57 */     this.ArmL.func_78793_a(4.8F, 1.5F, 0.0F);
/*  58 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  59 */     this.CapeFront = new ModelRenderer(this, 45, 28);
/*  60 */     this.CapeFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.CapeFront.func_78790_a(-4.1F, 8.2F, -5.0F, 8, 5, 1, 0.0F);
/*  62 */     this.LegR2 = new ModelRenderer(this, 0, 55);
/*  63 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.LegR2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  65 */     this.LegR = new ModelRenderer(this, 0, 39);
/*  66 */     this.LegR.func_78793_a(-2.1F, 12.0F, 0.0F);
/*  67 */     this.LegR.func_78790_a(-2.1F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  68 */     this.CapeBack = new ModelRenderer(this, 43, 18);
/*  69 */     this.CapeBack.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.CapeBack.func_78790_a(-4.5F, 8.2F, -1.1F, 9, 8, 1, 0.0F);
/*  71 */     setRotateAngle(this.CapeBack, 0.09250245F, 0.0F, 0.0F);
/*  72 */     this.ArmR = new ModelRenderer(this, 2, 20);
/*  73 */     this.ArmR.func_78793_a(-4.8F, 1.5F, 0.0F);
/*  74 */     this.ArmR.func_78790_a(-2.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  75 */     this.earL = new ModelRenderer(this, 33, 4);
/*  76 */     this.earL.field_78809_i = true;
/*  77 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.earL.func_78790_a(3.3F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
/*  79 */     setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
/*  80 */     this.Body2 = new ModelRenderer(this, 17, 37);
/*  81 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.Body2.func_78790_a(-4.0F, 8.0F, -2.3F, 8, 4, 5, 0.0F);
/*  83 */     this.Cape1 = new ModelRenderer(this, 34, 8);
/*  84 */     this.Cape1.func_78793_a(0.0F, 0.3F, 2.3F);
/*  85 */     this.Cape1.func_78790_a(-4.5F, 5.3F, -5.2F, 9, 3, 6, 0.0F);
/*  86 */     this.Neck = new ModelRenderer(this, 23, 17);
/*  87 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.Neck.func_78790_a(-2.0F, -1.0F, -0.8F, 4, 2, 2, 0.0F);
/*  89 */     this.LegL.func_78792_a(this.LegL2);
/*  90 */     this.Head.func_78792_a(this.earR);
/*  91 */     this.Cape1.func_78792_a(this.CapeSideR);
/*  92 */     this.Cape1.func_78792_a(this.CapeSideL);
/*  93 */     this.Cape1.func_78792_a(this.CapeFront);
/*  94 */     this.LegR.func_78792_a(this.LegR2);
/*  95 */     this.Cape1.func_78792_a(this.CapeBack);
/*  96 */     this.Head.func_78792_a(this.earL);
/*  97 */     this.Body1.func_78792_a(this.Body2);
/*  98 */     this.Body1.func_78792_a(this.Cape1);
/*  99 */     this.Body1.func_78792_a(this.Neck);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 104 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 107 */     this.LegL.func_78785_a(f5);
/* 108 */     this.Head.func_78785_a(f5);
/* 109 */     this.ArmL.func_78785_a(f5);
/* 110 */     this.ArmR.func_78785_a(f5);
/* 111 */     this.Body1.func_78785_a(f5);
/* 112 */     this.LegR.func_78785_a(f5);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 146 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 147 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 148 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 149 */     this.LegR.field_78796_g = 0.0F;
/* 150 */     this.LegL.field_78796_g = 0.0F;
/* 151 */     this.ArmR.field_78796_g = 0.0F;
/* 152 */     this.ArmL.field_78796_g = 0.0F;
/* 153 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBeerusMonaka2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */