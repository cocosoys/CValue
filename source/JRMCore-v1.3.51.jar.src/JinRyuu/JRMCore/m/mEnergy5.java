/*     */ package JinRyuu.JRMCore.m;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class mEnergy5
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Base1;
/*     */   public ModelRenderer Base1Front;
/*     */   public ModelRenderer Base1Back;
/*     */   public ModelRenderer Base1Side_Ball;
/*     */   public ModelRenderer Base1Side_Jobb;
/*     */   public ModelRenderer Base1Top;
/*     */   public ModelRenderer Base1Bottom;
/*     */   public ModelRenderer Base1Front2;
/*     */   public ModelRenderer Base1Back2;
/*     */   public ModelRenderer Base1Side_Ball2;
/*     */   public ModelRenderer Base1Side_Jobb2;
/*     */   public ModelRenderer Base1Top2;
/*     */   public ModelRenderer Base1Bottom2;
/*     */   
/*     */   public mEnergy5() {
/*  27 */     this.field_78090_t = 128;
/*  28 */     this.field_78089_u = 64;
/*  29 */     this.Base1Bottom = new ModelRenderer(this, 38, 36);
/*  30 */     this.Base1Bottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  31 */     this.Base1Bottom.func_78790_a(-3.0F, 3.0F, -3.0F, 6, 2, 6, 0.0F);
/*  32 */     this.Base1Side_Jobb2 = new ModelRenderer(this, 19, 45);
/*  33 */     this.Base1Side_Jobb2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.Base1Side_Jobb2.func_78790_a(-2.0F, -2.0F, 3.5F, 4, 4, 2, 0.0F);
/*  35 */     this.Base1Side_Ball = new ModelRenderer(this, 19, 20);
/*  36 */     this.Base1Side_Ball.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */     this.Base1Side_Ball.func_78790_a(-3.0F, -3.0F, -5.0F, 6, 6, 2, 0.0F);
/*  38 */     this.Base1Side_Ball2 = new ModelRenderer(this, 19, 29);
/*  39 */     this.Base1Side_Ball2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */     this.Base1Side_Ball2.func_78790_a(-2.0F, -2.0F, -5.5F, 4, 4, 2, 0.0F);
/*  41 */     this.Base1Front2 = new ModelRenderer(this, 0, 30);
/*  42 */     this.Base1Front2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.Base1Front2.func_78790_a(-5.5F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
/*  44 */     setRotateAngle(this.Base1Front2, 0.0F, -0.008901179F, 0.0F);
/*  45 */     this.Base1Front = new ModelRenderer(this, 0, 17);
/*  46 */     this.Base1Front.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.Base1Front.func_78790_a(-5.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/*  48 */     this.Base1Side_Jobb = new ModelRenderer(this, 19, 36);
/*  49 */     this.Base1Side_Jobb.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.Base1Side_Jobb.func_78790_a(-3.0F, -3.0F, 3.0F, 6, 6, 2, 0.0F);
/*  51 */     this.Base1Bottom2 = new ModelRenderer(this, 38, 45);
/*  52 */     this.Base1Bottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.Base1Bottom2.func_78790_a(-2.0F, 3.5F, -2.0F, 4, 2, 4, 0.0F);
/*  54 */     this.Base1Back2 = new ModelRenderer(this, 0, 52);
/*  55 */     this.Base1Back2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.Base1Back2.func_78790_a(3.5F, -2.0F, -2.0F, 2, 4, 4, 0.0F);
/*  57 */     this.Base1Top2 = new ModelRenderer(this, 38, 29);
/*  58 */     this.Base1Top2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.Base1Top2.func_78790_a(-2.0F, -5.5F, -2.0F, 4, 2, 4, 0.0F);
/*  60 */     this.Base1Top = new ModelRenderer(this, 38, 20);
/*  61 */     this.Base1Top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.Base1Top.func_78790_a(-3.0F, -5.0F, -3.0F, 6, 2, 6, 0.0F);
/*  63 */     this.Base1Back = new ModelRenderer(this, 0, 39);
/*  64 */     this.Base1Back.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.Base1Back.func_78790_a(3.0F, -3.0F, -3.0F, 2, 6, 6, 0.0F);
/*  66 */     this.Base1 = new ModelRenderer(this, 0, 0);
/*  67 */     this.Base1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.Base1.func_78790_a(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
/*  69 */     this.Base1.func_78792_a(this.Base1Bottom);
/*  70 */     this.Base1Side_Jobb.func_78792_a(this.Base1Side_Jobb2);
/*  71 */     this.Base1.func_78792_a(this.Base1Side_Ball);
/*  72 */     this.Base1Side_Ball.func_78792_a(this.Base1Side_Ball2);
/*  73 */     this.Base1Front.func_78792_a(this.Base1Front2);
/*  74 */     this.Base1.func_78792_a(this.Base1Front);
/*  75 */     this.Base1.func_78792_a(this.Base1Side_Jobb);
/*  76 */     this.Base1Bottom.func_78792_a(this.Base1Bottom2);
/*  77 */     this.Base1Back.func_78792_a(this.Base1Back2);
/*  78 */     this.Base1Top.func_78792_a(this.Base1Top2);
/*  79 */     this.Base1.func_78792_a(this.Base1Top);
/*  80 */     this.Base1.func_78792_a(this.Base1Back);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  86 */     this.Base1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void render() {
/*  90 */     float f5 = 0.0625F;
/*  91 */     this.Base1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  98 */     modelRenderer.field_78795_f = x;
/*  99 */     modelRenderer.field_78796_g = y;
/* 100 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 104 */     float par3 = f2;
/* 105 */     float par31 = 1.0F;
/* 106 */     this.Base1.field_78808_h = par3;
/* 107 */     this.Base1.field_78796_g = par3;
/* 108 */     this.Base1.field_78795_f = par3;
/*     */   }
/*     */   public void renderModel(Entity entity, float par8, float par9, float f, float r) {
/* 111 */     func_78088_a(entity, 0.0F, 0.0F, r, par8, par9, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mEnergy5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */