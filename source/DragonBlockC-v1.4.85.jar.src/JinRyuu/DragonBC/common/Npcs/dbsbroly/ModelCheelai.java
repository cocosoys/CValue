/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelCheelai
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Bag;
/*     */   public ModelRenderer Scouter;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Boobs;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelCheelai() {
/*  23 */     this.field_78090_t = 64;
/*  24 */     this.field_78089_u = 64;
/*  25 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  26 */     this.LegL.field_78809_i = true;
/*  27 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  28 */     this.LegL.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  29 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  30 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  31 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.2F);
/*  32 */     this.Boobs = new ModelRenderer(this, 19, 31);
/*  33 */     this.Boobs.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Boobs.func_78790_a(-3.0F, 2.1F, -0.7F, 6, 3, 2, 0.0F);
/*  35 */     setRotateAngle(this.Boobs, -0.59184116F, 0.0F, 0.0F);
/*  36 */     this.ArmR = new ModelRenderer(this, 32, 35);
/*  37 */     this.ArmR.func_78793_a(-4.3F, 2.8F, 0.0F);
/*  38 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  39 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.06981317F);
/*  40 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  41 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  43 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  44 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  45 */     this.LegR.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  46 */     this.Bag = new ModelRenderer(this, 34, 3);
/*  47 */     this.Bag.func_78793_a(-2.5F, 10.4F, 0.0F);
/*  48 */     this.Bag.func_78790_a(-2.0F, -0.9F, -2.3F, 2, 4, 5, 0.0F);
/*  49 */     setRotateAngle(this.Bag, 0.0F, 0.0F, 0.20943952F);
/*  50 */     this.Head = new ModelRenderer(this, 0, 0);
/*  51 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  52 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  53 */     this.Scouter = new ModelRenderer(this, 51, 4);
/*  54 */     this.Scouter.func_78793_a(0.0F, 1.4F, 0.0F);
/*  55 */     this.Scouter.func_78790_a(2.2F, -6.5F, -1.6F, 2, 4, 3, 0.0F);
/*  56 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  57 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  59 */     this.ArmL = new ModelRenderer(this, 32, 35);
/*  60 */     this.ArmL.field_78809_i = true;
/*  61 */     this.ArmL.func_78793_a(4.3F, 2.8F, 0.0F);
/*  62 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  63 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.06981317F);
/*  64 */     this.Body1.func_78792_a(this.Boobs);
/*  65 */     this.Body2.func_78792_a(this.Body3);
/*  66 */     this.Body3.func_78792_a(this.Bag);
/*  67 */     this.Head.func_78792_a(this.Scouter);
/*  68 */     this.Body1.func_78792_a(this.Body2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  73 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  75 */     this.Body1.func_78785_a(f5);
/*  76 */     this.ArmR.func_78785_a(f5);
/*  77 */     this.ArmL.func_78785_a(f5);
/*  78 */     this.LegL.func_78785_a(f5);
/*  79 */     this.Head.func_78785_a(f5);
/*  80 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  86 */     modelRenderer.field_78795_f = x;
/*  87 */     modelRenderer.field_78796_g = y;
/*  88 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  92 */     int calc = par7Entity.field_70173_aa;
/*  93 */     if (calc > 100) calc -= 100; 
/*  94 */     float r = 360.0F;
/*  95 */     float r2 = 180.0F;
/*  96 */     float n4 = par4;
/*  97 */     float n5 = par5;
/*     */     
/*  99 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/* 100 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/* 101 */     float ex = par7Entity.field_70173_aa;
/* 102 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 103 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 105 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 106 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 155 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 156 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 157 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 158 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 160 */     this.LegR.field_78796_g = 0.0F;
/* 161 */     this.LegL.field_78796_g = 0.0F;
/* 162 */     this.ArmR.field_78796_g = 0.0F;
/* 163 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelCheelai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */