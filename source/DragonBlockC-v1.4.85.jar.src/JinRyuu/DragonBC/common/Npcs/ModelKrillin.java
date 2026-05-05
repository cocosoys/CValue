/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelKrillin
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer UpperBody;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Belt;
/*     */   public ModelRenderer Lowerbody;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Belt2;
/*     */   public ModelRenderer Belt3;
/*     */   public ModelRenderer FeetR;
/*     */   public ModelRenderer FeetL;
/*     */   
/*     */   public ModelKrillin() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.FeetR = new ModelRenderer(this, 17, 53);
/*  28 */     this.FeetR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */     this.FeetR.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  30 */     this.ArmL = new ModelRenderer(this, 30, 26);
/*  31 */     this.ArmL.field_78809_i = true;
/*  32 */     this.ArmL.func_78793_a(4.3F, 5.6F, 0.4F);
/*  33 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  34 */     this.LegR = new ModelRenderer(this, 0, 49);
/*  35 */     this.LegR.func_78793_a(-1.9F, 14.0F, 0.0F);
/*  36 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  37 */     this.Belt3 = new ModelRenderer(this, 1, 35);
/*  38 */     this.Belt3.func_78793_a(0.3F, 6.4F, -1.9F);
/*  39 */     this.Belt3.func_78790_a(-0.4F, 0.0F, 0.0F, 1, 5, 0, 0.0F);
/*  40 */     setRotateAngle(this.Belt3, -0.28274333F, -0.13665928F, -0.0418879F);
/*  41 */     this.Head = new ModelRenderer(this, 0, 0);
/*  42 */     this.Head.func_78793_a(0.0F, 4.0F, 0.0F);
/*  43 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, -0.7F);
/*  44 */     this.ArmR = new ModelRenderer(this, 30, 26);
/*  45 */     this.ArmR.func_78793_a(-4.3F, 5.6F, 0.4F);
/*  46 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 11, 4, -0.6F);
/*  47 */     this.Lowerbody = new ModelRenderer(this, 4, 41);
/*  48 */     this.Lowerbody.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.Lowerbody.func_78790_a(-3.5F, 7.0F, -2.0F, 7, 3, 4, 0.0F);
/*  50 */     this.Belt2 = new ModelRenderer(this, 1, 35);
/*  51 */     this.Belt2.func_78793_a(-0.4F, 6.4F, -1.9F);
/*  52 */     this.Belt2.func_78790_a(-0.6F, 0.0F, 0.0F, 1, 5, 0, 0.0F);
/*  53 */     setRotateAngle(this.Belt2, -0.3036873F, 0.0F, 0.0418879F);
/*  54 */     this.LegL = new ModelRenderer(this, 0, 49);
/*  55 */     this.LegL.field_78809_i = true;
/*  56 */     this.LegL.func_78793_a(1.9F, 14.0F, 0.0F);
/*  57 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F);
/*  58 */     this.Belt = new ModelRenderer(this, 6, 35);
/*  59 */     this.Belt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.Belt.func_78790_a(-3.1F, 5.5F, -1.7F, 6, 2, 3, 0.0F);
/*  61 */     this.FeetL = new ModelRenderer(this, 17, 53);
/*  62 */     this.FeetL.field_78809_i = true;
/*  63 */     this.FeetL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.FeetL.func_78790_a(-1.5F, 8.0F, -2.5F, 3, 2, 4, 0.0F);
/*  65 */     this.Neck = new ModelRenderer(this, 7, 17);
/*  66 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.Neck.func_78790_a(-2.0F, -1.2F, -1.0F, 4, 2, 3, 0.0F);
/*  68 */     this.UpperBody = new ModelRenderer(this, 3, 23);
/*  69 */     this.UpperBody.func_78793_a(0.0F, 4.0F, 0.0F);
/*  70 */     this.UpperBody.func_78790_a(-4.0F, 0.0F, -2.3F, 8, 6, 5, 0.0F);
/*  71 */     this.LegR.func_78792_a(this.FeetR);
/*  72 */     this.Belt.func_78792_a(this.Belt3);
/*  73 */     this.UpperBody.func_78792_a(this.Lowerbody);
/*  74 */     this.Belt.func_78792_a(this.Belt2);
/*  75 */     this.UpperBody.func_78792_a(this.Belt);
/*  76 */     this.LegL.func_78792_a(this.FeetL);
/*  77 */     this.UpperBody.func_78792_a(this.Neck);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  82 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  85 */     this.LegL.func_78785_a(f5);
/*  86 */     this.Head.func_78785_a(f5);
/*  87 */     this.ArmL.func_78785_a(f5);
/*  88 */     this.ArmR.func_78785_a(f5);
/*  89 */     this.UpperBody.func_78785_a(f5);
/*  90 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  95 */     modelRenderer.field_78795_f = x;
/*  96 */     modelRenderer.field_78796_g = y;
/*  97 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 101 */     int calc = par7Entity.field_70173_aa;
/* 102 */     if (calc > 100) calc -= 100; 
/* 103 */     float r = 360.0F;
/* 104 */     float r2 = 180.0F;
/* 105 */     float n4 = par4;
/* 106 */     float n5 = par5;
/*     */     
/* 108 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 109 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 110 */     float ex = par7Entity.field_70173_aa;
/* 111 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 112 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 114 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 115 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelKrillin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */