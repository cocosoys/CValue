/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBerryblue
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer BodyLower;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Skirt;
/*     */   public ModelRenderer UpperBody;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer GrannyBoobs;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ShoulderR;
/*     */   
/*     */   public ModelBerryblue() {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     this.Skirt = new ModelRenderer(this, 3, 37);
/*  28 */     this.Skirt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */     this.Skirt.func_78790_a(-4.5F, 6.0F, -3.5F, 9, 7, 7, 0.0F);
/*  30 */     this.LegR = new ModelRenderer(this, 4, 52);
/*  31 */     this.LegR.func_78793_a(-1.9F, 15.0F, 0.0F);
/*  32 */     this.LegR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
/*  33 */     this.ShoulderR = new ModelRenderer(this, 33, 9);
/*  34 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.ShoulderR.func_78790_a(-3.6F, -1.2F, -2.0F, 4, 2, 4, 0.0F);
/*  36 */     setRotateAngle(this.ShoulderR, 0.0F, 0.0F, -0.10471976F);
/*  37 */     this.LegL = new ModelRenderer(this, 4, 52);
/*  38 */     this.LegL.field_78809_i = true;
/*  39 */     this.LegL.func_78793_a(1.9F, 15.0F, 0.0F);
/*  40 */     this.LegL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
/*  41 */     this.ArmL = new ModelRenderer(this, 46, 21);
/*  42 */     this.ArmL.field_78809_i = true;
/*  43 */     this.ArmL.func_78793_a(4.6F, 9.2F, 0.8F);
/*  44 */     this.ArmL.func_78790_a(-0.6F, -0.9F, -1.5F, 2, 7, 3, 0.0F);
/*  45 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.1308997F);
/*  46 */     this.Neck = new ModelRenderer(this, 6, 14);
/*  47 */     this.Neck.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Neck.func_78790_a(-2.0F, -0.5F, -1.3F, 4, 1, 3, 0.0F);
/*  49 */     this.Head = new ModelRenderer(this, 0, 0);
/*  50 */     this.Head.func_78793_a(0.0F, 8.0F, 0.0F);
/*  51 */     this.Head.func_78790_a(-4.0F, -6.1F, -3.5F, 8, 6, 7, 0.0F);
/*  52 */     this.BodyLower = new ModelRenderer(this, 1, 27);
/*  53 */     this.BodyLower.func_78793_a(0.0F, 8.0F, 0.0F);
/*  54 */     this.BodyLower.func_78790_a(-4.0F, 3.0F, -3.0F, 8, 3, 6, 0.0F);
/*  55 */     this.GrannyBoobs = new ModelRenderer(this, 24, 24);
/*  56 */     this.GrannyBoobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.GrannyBoobs.func_78790_a(-3.5F, 0.9F, -0.8F, 7, 4, 3, 0.0F);
/*  58 */     setRotateAngle(this.GrannyBoobs, -0.7740535F, 0.0F, 0.0F);
/*  59 */     this.UpperBody = new ModelRenderer(this, 3, 19);
/*  60 */     this.UpperBody.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.UpperBody.func_78790_a(-4.0F, 0.0F, -1.2F, 8, 3, 4, 0.0F);
/*  62 */     this.ShoulderL = new ModelRenderer(this, 33, 9);
/*  63 */     this.ShoulderL.field_78809_i = true;
/*  64 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.ShoulderL.func_78790_a(-0.6F, -1.2F, -2.0F, 4, 2, 4, 0.0F);
/*  66 */     setRotateAngle(this.ShoulderL, 0.0F, 0.0F, 0.10471976F);
/*  67 */     this.ArmR = new ModelRenderer(this, 46, 21);
/*  68 */     this.ArmR.func_78793_a(-4.4F, 9.2F, 0.8F);
/*  69 */     this.ArmR.func_78790_a(-1.5F, -0.9F, -1.5F, 2, 7, 3, 0.0F);
/*  70 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.1308997F);
/*  71 */     this.BodyLower.func_78792_a(this.Skirt);
/*  72 */     this.ArmR.func_78792_a(this.ShoulderR);
/*  73 */     this.UpperBody.func_78792_a(this.Neck);
/*  74 */     this.UpperBody.func_78792_a(this.GrannyBoobs);
/*  75 */     this.BodyLower.func_78792_a(this.UpperBody);
/*  76 */     this.ArmL.func_78792_a(this.ShoulderL);
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
/*  88 */     this.BodyLower.func_78785_a(f5);
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
/*     */     
/* 121 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 122 */     this.LegL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 123 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 124 */     this.ArmL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.2F * par2;
/* 125 */     this.LegR.field_78796_g = 0.0F;
/* 126 */     this.LegL.field_78796_g = 0.0F;
/* 127 */     this.ArmR.field_78796_g = 0.0F;
/* 128 */     this.ArmL.field_78796_g = 0.0F;
/* 129 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelBerryblue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */