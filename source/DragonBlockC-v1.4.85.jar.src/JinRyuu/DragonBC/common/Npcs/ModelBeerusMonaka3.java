/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBeerusMonaka3
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer earR;
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
/*     */   public ModelBeerusMonaka3() {
/*  28 */     this.field_78090_t = 64;
/*  29 */     this.field_78089_u = 64;
/*  30 */     this.Head = new ModelRenderer(this, 0, 0);
/*  31 */     this.Head.func_78793_a(0.0F, -0.6F, 0.0F);
/*  32 */     this.Head.func_78790_a(-4.1F, -7.7F, -4.0F, 8, 8, 8, 0.0F);
/*  33 */     this.Body2 = new ModelRenderer(this, 17, 37);
/*  34 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.Body2.func_78790_a(-4.0F, 8.0F, -2.3F, 8, 4, 5, 0.0F);
/*  36 */     this.CapeBack = new ModelRenderer(this, 43, 18);
/*  37 */     this.CapeBack.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.CapeBack.func_78790_a(-4.5F, 8.2F, -1.1F, 9, 8, 1, 0.0F);
/*  39 */     setRotateAngle(this.CapeBack, 0.09250245F, 0.0F, 0.0F);
/*  40 */     this.ArmL = new ModelRenderer(this, 33, 47);
/*  41 */     this.ArmL.field_78809_i = true;
/*  42 */     this.ArmL.func_78793_a(4.8F, 1.5F, 0.0F);
/*  43 */     this.ArmL.func_78790_a(-1.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  44 */     this.CapeSideR = new ModelRenderer(this, 47, 35);
/*  45 */     this.CapeSideR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.CapeSideR.func_78790_a(-4.7F, 8.1F, -4.9F, 2, 4, 5, 0.0F);
/*  47 */     this.Body1 = new ModelRenderer(this, 18, 23);
/*  48 */     this.Body1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 8, 4, 0.0F);
/*  50 */     this.LegL = new ModelRenderer(this, 0, 39);
/*  51 */     this.LegL.field_78809_i = true;
/*  52 */     this.LegL.func_78793_a(2.1F, 12.0F, 0.0F);
/*  53 */     this.LegL.func_78790_a(-1.9F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  54 */     this.ArmR = new ModelRenderer(this, 17, 47);
/*  55 */     this.ArmR.func_78793_a(-4.8F, 1.5F, 0.0F);
/*  56 */     this.ArmR.func_78790_a(-2.0F, -1.6F, -1.8F, 3, 12, 4, -0.2F);
/*  57 */     this.CapeSideL = new ModelRenderer(this, 47, 35);
/*  58 */     this.CapeSideL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.CapeSideL.func_78790_a(2.7F, 8.2F, -4.9F, 2, 4, 5, 0.0F);
/*  60 */     this.earR = new ModelRenderer(this, 33, 4);
/*  61 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.earR.func_78790_a(-6.5F, -4.5F, -2.2F, 3, 2, 1, 0.0F);
/*  63 */     setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
/*  64 */     this.Neck = new ModelRenderer(this, 23, 17);
/*  65 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.Neck.func_78790_a(-2.0F, -1.0F, -0.8F, 4, 2, 2, 0.0F);
/*  67 */     this.LegL2 = new ModelRenderer(this, 0, 55);
/*  68 */     this.LegL2.field_78809_i = true;
/*  69 */     this.LegL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.LegL2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  71 */     this.Cape1 = new ModelRenderer(this, 34, 8);
/*  72 */     this.Cape1.func_78793_a(0.0F, 0.3F, 2.3F);
/*  73 */     this.Cape1.func_78790_a(-4.5F, 5.3F, -5.2F, 9, 3, 6, 0.0F);
/*  74 */     this.CapeFront = new ModelRenderer(this, 45, 28);
/*  75 */     this.CapeFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.CapeFront.func_78790_a(-4.1F, 8.2F, -5.0F, 8, 5, 1, 0.0F);
/*  77 */     this.LegR = new ModelRenderer(this, 0, 39);
/*  78 */     this.LegR.func_78793_a(-2.1F, 12.0F, 0.0F);
/*  79 */     this.LegR.func_78790_a(-2.1F, -0.5F, -2.0F, 4, 11, 4, -0.4F);
/*  80 */     this.LegR2 = new ModelRenderer(this, 0, 55);
/*  81 */     this.LegR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.LegR2.func_78790_a(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
/*  83 */     this.Body1.func_78792_a(this.Body2);
/*  84 */     this.Cape1.func_78792_a(this.CapeBack);
/*  85 */     this.Cape1.func_78792_a(this.CapeSideR);
/*  86 */     this.Cape1.func_78792_a(this.CapeSideL);
/*  87 */     this.Head.func_78792_a(this.earR);
/*  88 */     this.Body1.func_78792_a(this.Neck);
/*  89 */     this.LegL.func_78792_a(this.LegL2);
/*  90 */     this.Body1.func_78792_a(this.Cape1);
/*  91 */     this.Cape1.func_78792_a(this.CapeFront);
/*  92 */     this.LegR.func_78792_a(this.LegR2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  97 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/* 100 */     this.LegL.func_78785_a(f5);
/* 101 */     this.Head.func_78785_a(f5);
/* 102 */     this.ArmL.func_78785_a(f5);
/* 103 */     this.ArmR.func_78785_a(f5);
/* 104 */     this.Body1.func_78785_a(f5);
/* 105 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 110 */     modelRenderer.field_78795_f = x;
/* 111 */     modelRenderer.field_78796_g = y;
/* 112 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 116 */     int calc = par7Entity.field_70173_aa;
/* 117 */     if (calc > 100) calc -= 100; 
/* 118 */     float r = 360.0F;
/* 119 */     float r2 = 180.0F;
/* 120 */     float n4 = par4;
/* 121 */     float n5 = par5;
/*     */     
/* 123 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 124 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 125 */     float ex = par7Entity.field_70173_aa;
/* 126 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 127 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 139 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 140 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 141 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 142 */     this.LegR.field_78796_g = 0.0F;
/* 143 */     this.LegL.field_78796_g = 0.0F;
/* 144 */     this.ArmR.field_78796_g = 0.0F;
/* 145 */     this.ArmL.field_78796_g = 0.0F;
/* 146 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBeerusMonaka3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */