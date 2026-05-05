/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelDBSParagus2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Hair;
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Beard;
/*     */   public ModelRenderer Bag;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer ShoulderR;
/*     */   
/*     */   public ModelDBSParagus2() {
/*  24 */     this.field_78090_t = 64;
/*  25 */     this.field_78089_u = 64;
/*  26 */     this.Beard = new ModelRenderer(this, 28, 1);
/*  27 */     this.Beard.func_78793_a(0.0F, -2.7F, -3.8F);
/*  28 */     this.Beard.func_78790_a(-3.0F, -0.1F, -0.25F, 6, 5, 0, 0.0F);
/*  29 */     this.ArmR = new ModelRenderer(this, 40, 16);
/*  30 */     this.ArmR.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  31 */     this.ArmR.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  32 */     this.ShoulderL = new ModelRenderer(this, 0, 33);
/*  33 */     this.ShoulderL.field_78809_i = true;
/*  34 */     this.ShoulderL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */     this.ShoulderL.func_78790_a(-1.1F, -2.1F, -2.5F, 6, 4, 5, 0.0F);
/*  36 */     this.ShoulderR = new ModelRenderer(this, 0, 33);
/*  37 */     this.ShoulderR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.ShoulderR.func_78790_a(-4.9F, -2.1F, -2.5F, 6, 4, 5, 0.0F);
/*  39 */     this.Hair = new ModelRenderer(this, 0, 43);
/*  40 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.Hair.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.2F);
/*  42 */     this.ArmL = new ModelRenderer(this, 40, 16);
/*  43 */     this.ArmL.field_78809_i = true;
/*  44 */     this.ArmL.func_78793_a(5.0F, 2.0F, 0.0F);
/*  45 */     this.ArmL.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  46 */     this.Head = new ModelRenderer(this, 0, 0);
/*  47 */     this.Head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
/*  49 */     this.Bag = new ModelRenderer(this, 39, 3);
/*  50 */     this.Bag.func_78793_a(3.5F, 9.0F, 0.0F);
/*  51 */     this.Bag.func_78790_a(-0.6F, -0.9F, -2.3F, 2, 4, 5, 0.0F);
/*  52 */     setRotateAngle(this.Bag, 0.0F, 0.0F, -0.09599311F);
/*  53 */     this.LegL = new ModelRenderer(this, 0, 16);
/*  54 */     this.LegL.field_78809_i = true;
/*  55 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  56 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  57 */     this.LegR = new ModelRenderer(this, 0, 16);
/*  58 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  59 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  60 */     this.Body = new ModelRenderer(this, 16, 16);
/*  61 */     this.Body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  63 */     this.Head.func_78792_a(this.Beard);
/*  64 */     this.ArmL.func_78792_a(this.ShoulderL);
/*  65 */     this.ArmR.func_78792_a(this.ShoulderR);
/*  66 */     this.Hair.func_78792_a(this.Head);
/*  67 */     this.Body.func_78792_a(this.Bag);
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
/* 160 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 161 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 163 */     this.LegR.field_78796_g = 0.0F;
/* 164 */     this.LegL.field_78796_g = 0.0F;
/* 165 */     this.ArmR.field_78796_g = 0.0F;
/* 166 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelDBSParagus2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */