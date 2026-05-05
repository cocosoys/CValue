/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelTagoma
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer NeckGuard1;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer NeckGuard2;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelTagoma() {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*  28 */     this.Body3 = new ModelRenderer(this, 20, 37);
/*  29 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  30 */     this.Body3.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, 0.0F);
/*  31 */     this.Body1 = new ModelRenderer(this, 20, 18);
/*  32 */     this.Body1.func_78793_a(0.0F, -2.0F, 0.0F);
/*  33 */     this.Body1.func_78790_a(-4.0F, 0.0F, -1.8F, 8, 5, 4, 0.0F);
/*  34 */     this.Neck = new ModelRenderer(this, 7, 22);
/*  35 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.Neck.func_78790_a(-2.0F, -0.4F, -0.8F, 4, 1, 2, 0.0F);
/*  37 */     this.Body2 = new ModelRenderer(this, 23, 29);
/*  38 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.Body2.func_78790_a(-3.5F, 5.0F, -1.5F, 7, 4, 3, 0.0F);
/*  40 */     this.NeckGuard1 = new ModelRenderer(this, 0, 55);
/*  41 */     this.NeckGuard1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.NeckGuard1.func_78790_a(-4.0F, -1.0F, -0.3F, 8, 3, 4, 0.0F);
/*  43 */     this.LegR = new ModelRenderer(this, 0, 33);
/*  44 */     this.LegR.func_78793_a(-1.9F, 10.0F, 0.0F);
/*  45 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  46 */     this.ShoulderL = new ModelRenderer(this, 33, 8);
/*  47 */     this.ShoulderL.field_78809_i = true;
/*  48 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */     this.ShoulderL.func_78790_a(-1.0F, -1.5F, -1.8F, 6, 3, 4, 0.0F);
/*  50 */     this.LegL = new ModelRenderer(this, 0, 33);
/*  51 */     this.LegL.field_78809_i = true;
/*  52 */     this.LegL.func_78793_a(1.9F, 10.0F, 0.0F);
/*  53 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F);
/*  54 */     this.NeckGuard2 = new ModelRenderer(this, 25, 56);
/*  55 */     this.NeckGuard2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.NeckGuard2.func_78790_a(-4.0F, -3.0F, 1.7F, 8, 2, 3, 0.0F);
/*  57 */     this.ShoulderR = new ModelRenderer(this, 33, 8);
/*  58 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.ShoulderR.func_78790_a(-5.0F, -1.5F, -1.8F, 6, 3, 4, 0.0F);
/*  60 */     this.ArmL = new ModelRenderer(this, 47, 19);
/*  61 */     this.ArmL.field_78809_i = true;
/*  62 */     this.ArmL.func_78793_a(5.0F, -0.7F, 0.0F);
/*  63 */     this.ArmL.func_78790_a(-1.1F, -1.3F, -1.8F, 3, 12, 4, -0.1F);
/*  64 */     this.ArmR = new ModelRenderer(this, 47, 19);
/*  65 */     this.ArmR.func_78793_a(-5.0F, -0.7F, 0.0F);
/*  66 */     this.ArmR.func_78790_a(-1.9F, -1.3F, -1.8F, 3, 12, 4, -0.1F);
/*  67 */     this.Head = new ModelRenderer(this, 0, 0);
/*  68 */     this.Head.func_78793_a(0.0F, -2.1F, 0.0F);
/*  69 */     this.Head.func_78790_a(-4.0F, -7.7F, -4.0F, 8, 8, 8, -0.5F);
/*  70 */     this.Body2.func_78792_a(this.Body3);
/*  71 */     this.Body1.func_78792_a(this.Neck);
/*  72 */     this.Body1.func_78792_a(this.Body2);
/*  73 */     this.Body1.func_78792_a(this.NeckGuard1);
/*  74 */     this.ArmL.func_78792_a(this.ShoulderL);
/*  75 */     this.NeckGuard1.func_78792_a(this.NeckGuard2);
/*  76 */     this.ArmR.func_78792_a(this.ShoulderR);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  81 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  84 */     this.LegL.func_78785_a(f5);
/*  85 */     this.Head.func_78785_a(f5);
/*  86 */     this.ArmL.func_78785_a(f5);
/*  87 */     this.ArmR.func_78785_a(f5);
/*  88 */     this.Body1.func_78785_a(f5);
/*  89 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  94 */     modelRenderer.field_78795_f = x;
/*  95 */     modelRenderer.field_78796_g = y;
/*  96 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 100 */     int calc = par7Entity.field_70173_aa;
/* 101 */     if (calc > 100) calc -= 100; 
/* 102 */     float r = 360.0F;
/* 103 */     float r2 = 180.0F;
/* 104 */     float n4 = par4;
/* 105 */     float n5 = par5;
/*     */     
/* 107 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 108 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 109 */     float ex = par7Entity.field_70173_aa;
/* 110 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 111 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelTagoma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */