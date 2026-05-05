/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelMonaka
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer UpperBody;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer earR;
/*     */   public ModelRenderer earL;
/*     */   public ModelRenderer Lowerbody;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelMonaka() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  28 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */     this.Neck.func_78790_a(-1.5F, -0.8F, -0.8F, 3, 2, 2, 0.0F);
/*  30 */     this.UpperBody = new ModelRenderer(this, 3, 23);
/*  31 */     this.UpperBody.func_78793_a(0.0F, 4.0F, 0.0F);
/*  32 */     this.UpperBody.func_78790_a(-3.5F, 0.0F, -1.4F, 7, 7, 3, 0.0F);
/*  33 */     this.earR = new ModelRenderer(this, 33, 8);
/*  34 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.earR.func_78790_a(-5.4F, -4.5F, -2.7F, 3, 2, 1, 0.0F);
/*  36 */     setRotateAngle(this.earR, 0.0F, 0.4098033F, 0.0F);
/*  37 */     this.ArmL = new ModelRenderer(this, 30, 26);
/*  38 */     this.ArmL.field_78809_i = true;
/*  39 */     this.ArmL.func_78793_a(3.7F, 5.2F, 0.1F);
/*  40 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, -0.8F);
/*  41 */     this.ArmR = new ModelRenderer(this, 30, 26);
/*  42 */     this.ArmR.func_78793_a(-3.7F, 5.1F, 0.1F);
/*  43 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, -0.8F);
/*  44 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  45 */     this.LegL.field_78809_i = true;
/*  46 */     this.LegL.func_78793_a(1.9F, 13.7F, 0.0F);
/*  47 */     this.LegL.func_78790_a(-2.0F, -0.8F, -2.0F, 4, 10, 4, -0.8F);
/*  48 */     this.earL = new ModelRenderer(this, 33, 8);
/*  49 */     this.earL.field_78809_i = true;
/*  50 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.earL.func_78790_a(2.3F, -4.6F, -2.7F, 3, 2, 1, 0.0F);
/*  52 */     setRotateAngle(this.earL, 0.0F, -0.4098033F, 0.0F);
/*  53 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  54 */     this.LegR.func_78793_a(-1.9F, 13.7F, 0.0F);
/*  55 */     this.LegR.func_78790_a(-2.0F, -0.8F, -2.0F, 4, 10, 4, -0.8F);
/*  56 */     this.Head = new ModelRenderer(this, 0, 1);
/*  57 */     this.Head.func_78793_a(0.0F, 4.3F, 0.0F);
/*  58 */     this.Head.func_78790_a(-4.0F, -7.1F, -4.2F, 8, 7, 8, -0.6F);
/*  59 */     this.FeetR = new ModelRenderer(this, 17, 53);
/*  60 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.FeetR.func_78790_a(-1.5F, 8.3F, -2.5F, 3, 2, 4, 0.0F);
/*  62 */     this.FeetL = new ModelRenderer(this, 17, 53);
/*  63 */     this.FeetL.field_78809_i = true;
/*  64 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.FeetL.func_78790_a(-1.5F, 8.3F, -2.5F, 3, 2, 4, 0.0F);
/*  66 */     this.Lowerbody = new ModelRenderer(this, 4, 36);
/*  67 */     this.Lowerbody.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Lowerbody.func_78790_a(-3.5F, 6.8F, -2.0F, 7, 3, 4, 0.0F);
/*  69 */     this.UpperBody.func_78792_a(this.Neck);
/*  70 */     this.Head.func_78792_a(this.earR);
/*  71 */     this.Head.func_78792_a(this.earL);
/*  72 */     this.LegR.func_78792_a(this.FeetR);
/*  73 */     this.LegL.func_78792_a(this.FeetL);
/*  74 */     this.UpperBody.func_78792_a(this.Lowerbody);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  79 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  82 */     this.LegL.func_78785_a(f5);
/*  83 */     this.Head.func_78785_a(f5);
/*  84 */     this.ArmL.func_78785_a(f5);
/*  85 */     this.ArmR.func_78785_a(f5);
/*  86 */     this.UpperBody.func_78785_a(f5);
/*  87 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  92 */     modelRenderer.field_78795_f = x;
/*  93 */     modelRenderer.field_78796_g = y;
/*  94 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  98 */     int calc = par7Entity.field_70173_aa;
/*  99 */     if (calc > 100) calc -= 100; 
/* 100 */     float r = 360.0F;
/* 101 */     float r2 = 180.0F;
/* 102 */     float n4 = par4;
/* 103 */     float n5 = par5;
/*     */     
/* 105 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 106 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 107 */     float ex = par7Entity.field_70173_aa;
/* 108 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 109 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 121 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 122 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 123 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 124 */     this.LegR.field_78796_g = 0.0F;
/* 125 */     this.LegL.field_78796_g = 0.0F;
/* 126 */     this.ArmR.field_78796_g = 0.0F;
/* 127 */     this.ArmL.field_78796_g = 0.0F;
/* 128 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelMonaka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */