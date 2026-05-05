/*     */ package JinRyuu.DragonBC.common.Npcs.dbbaba;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelGrandpaGohan
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Halo;
/*     */   public ModelRenderer Mask;
/*     */   public ModelRenderer ArmR2;
/*     */   public ModelRenderer ArmL2;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelGrandpaGohan() {
/*  27 */     this.field_78090_t = 64;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Head2 = new ModelRenderer(this, 0, 0);
/*  30 */     this.Head2.func_78793_a(0.0F, -7.0F, 0.0F);
/*  31 */     this.Head2.func_78790_a(-1.0F, -1.8F, -1.0F, 2, 2, 2, 0.0F);
/*  32 */     this.ArmR2 = new ModelRenderer(this, 27, 38);
/*  33 */     this.ArmR2.func_78793_a(-1.0F, 6.5F, 0.1F);
/*  34 */     this.ArmR2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  35 */     this.LegR = new ModelRenderer(this, 0, 40);
/*  36 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  37 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  38 */     this.Beard = new ModelRenderer(this, 27, 2);
/*  39 */     this.Beard.func_78793_a(0.0F, -2.0F, -3.4F);
/*  40 */     this.Beard.func_78790_a(-3.0F, -1.1F, 0.0F, 6, 4, 0, 0.0F);
/*  41 */     this.Halo = new ModelRenderer(this, 38, 1);
/*  42 */     this.Halo.func_78793_a(0.0F, -12.4F, 1.6F);
/*  43 */     this.Halo.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 0, 8, 0.0F);
/*  44 */     setRotateAngle(this.Halo, -0.4553564F, 0.0F, 0.0F);
/*  45 */     this.Mask = new ModelRenderer(this, 48, 11);
/*  46 */     this.Mask.func_78793_a(0.0F, -5.0F, -3.5F);
/*  47 */     this.Mask.func_78790_a(-3.5F, -4.6F, 0.0F, 7, 9, 0, 0.0F);
/*  48 */     this.ArmL2 = new ModelRenderer(this, 27, 38);
/*  49 */     this.ArmL2.field_78809_i = true;
/*  50 */     this.ArmL2.func_78793_a(1.1F, 6.4F, 0.1F);
/*  51 */     this.ArmL2.func_78790_a(-1.6F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
/*  52 */     this.FeetL = new ModelRenderer(this, 1, 54);
/*  53 */     this.FeetL.field_78809_i = true;
/*  54 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  56 */     this.ArmL = new ModelRenderer(this, 27, 24);
/*  57 */     this.ArmL.field_78809_i = true;
/*  58 */     this.ArmL.func_78793_a(4.6F, 5.5F, 0.1F);
/*  59 */     this.ArmL.func_78790_a(-1.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  60 */     this.LegL = new ModelRenderer(this, 0, 40);
/*  61 */     this.LegL.field_78809_i = true;
/*  62 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  63 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  64 */     this.Head = new ModelRenderer(this, 0, 0);
/*  65 */     this.Head.func_78793_a(0.0F, 4.7F, 0.0F);
/*  66 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  67 */     this.ArmR = new ModelRenderer(this, 27, 24);
/*  68 */     this.ArmR.func_78793_a(-4.6F, 5.5F, 0.1F);
/*  69 */     this.ArmR.func_78790_a(-3.0F, -1.7F, -2.0F, 4, 9, 4, -0.3F);
/*  70 */     this.FeetR = new ModelRenderer(this, 1, 54);
/*  71 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  73 */     this.Body = new ModelRenderer(this, 0, 23);
/*  74 */     this.Body.func_78793_a(0.0F, 4.0F, 0.1F);
/*  75 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.5F, 8, 11, 5, 0.0F);
/*  76 */     this.Head.func_78792_a(this.Head2);
/*  77 */     this.ArmR.func_78792_a(this.ArmR2);
/*  78 */     this.Head.func_78792_a(this.Beard);
/*  79 */     this.Head.func_78792_a(this.Halo);
/*  80 */     this.Head.func_78792_a(this.Mask);
/*  81 */     this.ArmL.func_78792_a(this.ArmL2);
/*  82 */     this.LegL.func_78792_a(this.FeetL);
/*  83 */     this.LegR.func_78792_a(this.FeetR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  88 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  90 */     this.Head.func_78785_a(f5);
/*     */     
/*  92 */     this.Body.func_78785_a(f5);
/*  93 */     this.ArmR.func_78785_a(f5);
/*  94 */     this.ArmL.func_78785_a(f5);
/*  95 */     this.LegL.func_78785_a(f5);
/*  96 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 106 */     modelRenderer.field_78795_f = x;
/* 107 */     modelRenderer.field_78796_g = y;
/* 108 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 112 */     int calc = par7Entity.field_70173_aa;
/* 113 */     if (calc > 100) calc -= 100; 
/* 114 */     float r = 360.0F;
/* 115 */     float r2 = 180.0F;
/* 116 */     float n4 = par4;
/* 117 */     float n5 = par5;
/*     */     
/* 119 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 120 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 121 */     float ex = par7Entity.field_70173_aa;
/* 122 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 123 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 125 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 126 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 176 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 177 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 178 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 180 */     this.LegR.field_78796_g = 0.0F;
/* 181 */     this.LegL.field_78796_g = 0.0F;
/* 182 */     this.ArmR.field_78796_g = 0.0F;
/* 183 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbbaba\ModelGrandpaGohan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */