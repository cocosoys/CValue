/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDBSParagus
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Cape;
/*     */   public ModelRenderer Cape2;
/*     */   public ModelRenderer ShoulderL;
/*     */   
/*     */   public ModelDBSParagus() {
/*  24 */     this.field_78090_t = 128;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.Beard = new ModelRenderer(this, 25, 1);
/*  27 */     this.Beard.func_78793_a(0.0F, -2.7F, -3.8F);
/*  28 */     this.Beard.func_78790_a(-3.0F, -0.1F, -0.25F, 6, 3, 0, 0.0F);
/*  29 */     this.Head = new ModelRenderer(this, 0, 0);
/*  30 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  31 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  32 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  33 */     this.ArmL.field_78809_i = true;
/*  34 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  35 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  36 */     this.Body = new ModelRenderer(this, 16, 16);
/*  37 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  39 */     this.ArmR = new ModelRenderer(this, 59, 15);
/*  40 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  41 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.4F, 4, 13, 5, 0.0F);
/*  42 */     this.Cape2 = new ModelRenderer(this, 80, 13);
/*  43 */     this.Cape2.func_78793_a(0.0F, 0.5F, -0.1F);
/*  44 */     this.Cape2.func_78790_a(-5.4F, -0.1F, -3.25F, 10, 16, 7, 0.0F);
/*  45 */     this.Hair = new ModelRenderer(this, 32, 0);
/*  46 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Hair.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.2F);
/*  48 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  49 */     this.LegR.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  50 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  51 */     this.Cape = new ModelRenderer(this, 79, 2);
/*  52 */     this.Cape.func_78793_a(0.0F, 0.3F, 0.0F);
/*  53 */     this.Cape.func_78790_a(-4.5F, -1.2F, -3.55F, 9, 2, 8, 0.0F);
/*  54 */     setRotateAngle(this.Cape, 0.091106184F, 0.0F, 0.0F);
/*  55 */     this.ShoulderL = new ModelRenderer(this, 0, 33);
/*  56 */     this.ShoulderL.field_78809_i = true;
/*  57 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.ShoulderL.func_78790_a(-1.1F, -2.1F, -2.4F, 5, 4, 5, 0.0F);
/*  59 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  60 */     this.LegL.field_78809_i = true;
/*  61 */     this.LegL.func_78793_a(2.0F, 12.0F, 0.0F);
/*  62 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  63 */     this.Head.func_78792_a(this.Beard);
/*  64 */     this.Hair.func_78792_a(this.Head);
/*  65 */     this.Body.func_78792_a(this.Cape2);
/*  66 */     this.Head.func_78792_a(this.Cape);
/*  67 */     this.ArmL.func_78792_a(this.ShoulderL);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  72 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  75 */     this.Hair.func_78785_a(f5);
/*  76 */     this.Body.func_78785_a(f5);
/*  77 */     this.ArmR.func_78785_a(f5);
/*  78 */     this.ArmL.func_78785_a(f5);
/*  79 */     this.LegL.func_78785_a(f5);
/*  80 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  89 */     modelRenderer.field_78795_f = x;
/*  90 */     modelRenderer.field_78796_g = y;
/*  91 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  95 */     int calc = par7Entity.field_70173_aa;
/*  96 */     if (calc > 100) calc -= 100; 
/*  97 */     float r = 360.0F;
/*  98 */     float r2 = 180.0F;
/*  99 */     float n4 = par4;
/* 100 */     float n5 = par5;
/*     */     
/* 102 */     this.Hair.field_78796_g = n4 / r2 / 3.1415927F;
/* 103 */     this.Hair.field_78795_f = n5 / r2 / 3.1415927F;
/* 104 */     float ex = par7Entity.field_70173_aa;
/* 105 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 106 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 108 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 109 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 158 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 159 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 160 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 0.3F * par2;
/* 161 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 163 */     this.LegR.field_78796_g = 0.0F;
/* 164 */     this.LegL.field_78796_g = 0.0F;
/* 165 */     this.ArmR.field_78796_g = 0.0F;
/* 166 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelDBSParagus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */