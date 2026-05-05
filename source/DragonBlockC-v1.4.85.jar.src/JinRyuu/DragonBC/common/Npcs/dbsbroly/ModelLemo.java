/*     */ package JinRyuu.DragonBC.common.Npcs.dbsbroly;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelLemo
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer Ear;
/*     */   public ModelRenderer Ear_1;
/*     */   public ModelRenderer Scouter;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Body3;
/*     */   
/*     */   public ModelLemo() {
/*  23 */     this.field_78090_t = 64;
/*  24 */     this.field_78089_u = 64;
/*  25 */     this.Body2 = new ModelRenderer(this, 0, 30);
/*  26 */     this.Body2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  27 */     this.Body2.func_78790_a(-3.0F, 5.8F, -1.6F, 6, 3, 3, 0.0F);
/*  28 */     this.Body1 = new ModelRenderer(this, 0, 18);
/*  29 */     this.Body1.func_78793_a(0.0F, 1.2F, 0.0F);
/*  30 */     this.Body1.func_78790_a(-3.5F, 0.0F, -2.0F, 7, 6, 4, -0.1F);
/*  31 */     this.ArmR = new ModelRenderer(this, 26, 21);
/*  32 */     this.ArmR.func_78793_a(-4.6F, 2.7F, 0.0F);
/*  33 */     this.ArmR.func_78790_a(-1.7F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  34 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.034906585F);
/*  35 */     this.ArmL = new ModelRenderer(this, 26, 21);
/*  36 */     this.ArmL.field_78809_i = true;
/*  37 */     this.ArmL.func_78793_a(4.6F, 2.7F, 0.0F);
/*  38 */     this.ArmL.func_78790_a(-1.3F, -1.4F, -1.8F, 3, 11, 4, -0.1F);
/*  39 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.034906585F);
/*  40 */     this.Scouter = new ModelRenderer(this, 25, 0);
/*  41 */     this.Scouter.func_78793_a(0.0F, 1.4F, 0.0F);
/*  42 */     this.Scouter.func_78790_a(2.2F, -6.5F, -1.8F, 2, 4, 3, 0.0F);
/*  43 */     this.LegR = new ModelRenderer(this, 0, 46);
/*  44 */     this.LegR.func_78793_a(-1.9F, 12.0F, 0.0F);
/*  45 */     this.LegR.func_78790_a(-2.0F, -0.3F, -2.0F, 4, 13, 4, -0.3F);
/*  46 */     this.Ear_1 = new ModelRenderer(this, 0, 0);
/*  47 */     this.Ear_1.func_78793_a(0.0F, 1.4F, 0.0F);
/*  48 */     this.Ear_1.func_78790_a(2.8F, -5.9F, -1.2F, 1, 3, 2, 0.0F);
/*  49 */     this.LegL = new ModelRenderer(this, 0, 46);
/*  50 */     this.LegL.field_78809_i = true;
/*  51 */     this.LegL.func_78793_a(1.9F, 12.0F, 0.0F);
/*  52 */     this.LegL.func_78790_a(-2.0F, -0.3F, -2.0F, 4, 13, 4, -0.3F);
/*  53 */     this.Head = new ModelRenderer(this, 0, 0);
/*  54 */     this.Head.func_78793_a(0.0F, 1.4F, 0.0F);
/*  55 */     this.Head.func_78790_a(-4.0F, -7.5F, -4.0F, 8, 8, 8, -0.5F);
/*  56 */     this.Body3 = new ModelRenderer(this, 0, 38);
/*  57 */     this.Body3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.Body3.func_78790_a(-3.5F, 8.8F, -2.0F, 7, 2, 4, 0.0F);
/*  59 */     this.Ear = new ModelRenderer(this, 0, 0);
/*  60 */     this.Ear.func_78793_a(0.0F, 1.4F, 0.0F);
/*  61 */     this.Ear.func_78790_a(-4.0F, -5.9F, -1.2F, 1, 3, 2, 0.0F);
/*  62 */     this.Body1.func_78792_a(this.Body2);
/*  63 */     this.Head.func_78792_a(this.Scouter);
/*  64 */     this.Head.func_78792_a(this.Ear_1);
/*  65 */     this.Body2.func_78792_a(this.Body3);
/*  66 */     this.Head.func_78792_a(this.Ear);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  71 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  73 */     this.Body1.func_78785_a(f5);
/*  74 */     this.ArmR.func_78785_a(f5);
/*  75 */     this.ArmL.func_78785_a(f5);
/*  76 */     this.LegL.func_78785_a(f5);
/*  77 */     this.Head.func_78785_a(f5);
/*  78 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  84 */     modelRenderer.field_78795_f = x;
/*  85 */     modelRenderer.field_78796_g = y;
/*  86 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  90 */     int calc = par7Entity.field_70173_aa;
/*  91 */     if (calc > 100) calc -= 100; 
/*  92 */     float r = 360.0F;
/*  93 */     float r2 = 180.0F;
/*  94 */     float n4 = par4;
/*  95 */     float n5 = par5;
/*     */     
/*  97 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  98 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  99 */     float ex = par7Entity.field_70173_aa;
/* 100 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 101 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 103 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 104 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 153 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 154 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 156 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 158 */     this.LegR.field_78796_g = 0.0F;
/* 159 */     this.LegL.field_78796_g = 0.0F;
/* 160 */     this.ArmR.field_78796_g = 0.0F;
/* 161 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbsbroly\ModelLemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */