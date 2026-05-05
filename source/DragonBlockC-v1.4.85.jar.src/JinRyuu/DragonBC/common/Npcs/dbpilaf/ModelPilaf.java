/*     */ package JinRyuu.DragonBC.common.Npcs.dbpilaf;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelPilaf
/*     */   extends ModelBase {
/*     */   public ModelRenderer Head;
/*     */   public ModelRenderer Body;
/*     */   public ModelRenderer ArmL;
/*     */   public ModelRenderer ArmR;
/*     */   public ModelRenderer LegL;
/*     */   public ModelRenderer LegR;
/*     */   public ModelRenderer Head_1;
/*     */   public ModelRenderer EarR;
/*     */   public ModelRenderer EarL;
/*     */   public ModelRenderer Tuft;
/*     */   
/*     */   public ModelPilaf() {
/*  22 */     this.field_78090_t = 64;
/*  23 */     this.field_78089_u = 64;
/*  24 */     this.Head = new ModelRenderer(this, 0, 0);
/*  25 */     this.Head.func_78793_a(0.0F, 9.4F, 0.0F);
/*  26 */     this.Head.func_78790_a(-4.0F, -6.7F, -4.1F, 8, 7, 7, -0.2F);
/*  27 */     this.ArmR = new ModelRenderer(this, 17, 33);
/*  28 */     this.ArmR.func_78793_a(-4.5F, 10.7F, 0.5F);
/*  29 */     this.ArmR.func_78790_a(-1.5F, -0.6F, -1.4F, 2, 7, 3, 0.2F);
/*  30 */     setRotateAngle(this.ArmR, 0.0F, 0.0F, 0.04363323F);
/*  31 */     this.Head_1 = new ModelRenderer(this, 35, 0);
/*  32 */     this.Head_1.func_78793_a(0.0F, -6.3F, 0.0F);
/*  33 */     this.Head_1.func_78790_a(-1.0F, -1.8F, -1.1F, 2, 2, 2, 0.0F);
/*  34 */     this.LegL = new ModelRenderer(this, 1, 33);
/*  35 */     this.LegL.field_78809_i = true;
/*  36 */     this.LegL.func_78793_a(1.9F, 17.0F, 0.0F);
/*  37 */     this.LegL.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
/*  38 */     this.EarL = new ModelRenderer(this, 26, 0);
/*  39 */     this.EarL.field_78809_i = true;
/*  40 */     this.EarL.func_78793_a(3.2F, -2.7F, -1.8F);
/*  41 */     this.EarL.func_78790_a(0.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/*  42 */     setRotateAngle(this.EarL, 0.0F, -0.7853982F, 0.0F);
/*  43 */     this.EarR = new ModelRenderer(this, 26, 0);
/*  44 */     this.EarR.func_78793_a(-3.2F, -2.7F, -1.8F);
/*  45 */     this.EarR.func_78790_a(-4.0F, -3.0F, 0.0F, 4, 5, 0, 0.0F);
/*  46 */     setRotateAngle(this.EarR, 0.0F, 0.7853982F, 0.0F);
/*  47 */     this.Body = new ModelRenderer(this, 1, 15);
/*  48 */     this.Body.func_78793_a(0.0F, 8.0F, 0.0F);
/*  49 */     this.Body.func_78790_a(-4.0F, 1.0F, -3.0F, 8, 11, 6, 0.0F);
/*  50 */     this.ArmL = new ModelRenderer(this, 17, 33);
/*  51 */     this.ArmL.field_78809_i = true;
/*  52 */     this.ArmL.func_78793_a(4.5F, 10.7F, 0.5F);
/*  53 */     this.ArmL.func_78790_a(-0.6F, -0.6F, -1.5F, 2, 7, 3, 0.2F);
/*  54 */     setRotateAngle(this.ArmL, 0.0F, 0.0F, -0.04363323F);
/*  55 */     this.LegR = new ModelRenderer(this, 1, 33);
/*  56 */     this.LegR.func_78793_a(-1.9F, 17.0F, 0.0F);
/*  57 */     this.LegR.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
/*  58 */     this.Tuft = new ModelRenderer(this, 32, 5);
/*  59 */     this.Tuft.func_78793_a(0.0F, 0.7F, 3.0F);
/*  60 */     this.Tuft.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 3, 7, 0.0F);
/*  61 */     this.Head.func_78792_a(this.Head_1);
/*  62 */     this.Head.func_78792_a(this.EarL);
/*  63 */     this.Head.func_78792_a(this.EarR);
/*  64 */     this.Body.func_78792_a(this.Tuft);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  69 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*  71 */     this.Body.func_78785_a(f5);
/*  72 */     this.ArmR.func_78785_a(f5);
/*  73 */     this.ArmL.func_78785_a(f5);
/*  74 */     this.LegL.func_78785_a(f5);
/*  75 */     this.Head.func_78785_a(f5);
/*  76 */     this.LegR.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  83 */     modelRenderer.field_78795_f = x;
/*  84 */     modelRenderer.field_78796_g = y;
/*  85 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  89 */     int calc = par7Entity.field_70173_aa;
/*  90 */     if (calc > 100) calc -= 100; 
/*  91 */     float r = 360.0F;
/*  92 */     float r2 = 180.0F;
/*  93 */     float n4 = par4;
/*  94 */     float n5 = par5;
/*     */     
/*  96 */     this.Head.field_78796_g = n4 / r2 / 3.1415927F;
/*  97 */     this.Head.field_78795_f = n5 / r2 / 3.1415927F;
/*  98 */     float ex = par7Entity.field_70173_aa;
/*  99 */     float r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 100 */     float r4 = MathHelper.func_76134_b(ex / 8.0F) / 5.0F + 0.1F;
/*     */     
/* 102 */     r3 = MathHelper.func_76134_b(ex * 0.14F) * 0.1F;
/* 103 */     r4 = MathHelper.func_76134_b(ex / 8.0F) / 3.0F - 0.2F;
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
/* 152 */     this.LegR.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 153 */     this.LegL.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 154 */     this.ArmR.field_78795_f = -0.0F + MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/* 155 */     this.ArmL.field_78795_f = -0.0F - MathHelper.func_76134_b(par1 * 0.6662F) * 1.2F * par2;
/*     */     
/* 157 */     this.LegR.field_78796_g = 0.0F;
/* 158 */     this.LegL.field_78796_g = 0.0F;
/* 159 */     this.ArmR.field_78796_g = 0.0F;
/* 160 */     this.ArmL.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbpilaf\ModelPilaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */