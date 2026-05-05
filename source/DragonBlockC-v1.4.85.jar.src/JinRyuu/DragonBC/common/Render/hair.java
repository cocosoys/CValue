/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class hair
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape1;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape8;
/*     */   ModelRenderer Shape9;
/*     */   
/*     */   public hair() {
/*  21 */     this.field_78090_t = 128;
/*  22 */     this.field_78089_u = 128;
/*     */     
/*  24 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  25 */     this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 16, 16, 16);
/*  26 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  27 */     this.Shape1.func_78787_b(128, 128);
/*  28 */     this.Shape1.field_78809_i = true;
/*  29 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*  30 */     this.Shape5 = new ModelRenderer(this, 0, 32);
/*  31 */     this.Shape5.func_78789_a(0.0F, 0.0F, 0.0F, 7, 7, 10);
/*  32 */     this.Shape5.func_78793_a(6.0F, 0.0F, 9.0F);
/*  33 */     this.Shape5.func_78787_b(128, 128);
/*  34 */     this.Shape5.field_78809_i = true;
/*  35 */     setRotation(this.Shape5, 1.27409F, 0.3141593F, 0.0F);
/*     */     
/*  37 */     this.Shape3 = new ModelRenderer(this, 64, 0);
/*  38 */     this.Shape3.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 10);
/*  39 */     this.Shape3.func_78793_a(8.0F, 4.0F, -6.0F);
/*  40 */     this.Shape3.func_78787_b(128, 128);
/*  41 */     this.Shape3.field_78809_i = true;
/*  42 */     setRotation(this.Shape3, -0.2268928F, -0.2617994F, 0.0F);
/*  43 */     this.Shape3.field_78809_i = false;
/*  44 */     this.Shape4 = new ModelRenderer(this, 64, 0);
/*  45 */     this.Shape4.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 10);
/*  46 */     this.Shape4.func_78793_a(7.0F, 10.0F, -7.0F);
/*  47 */     this.Shape4.func_78787_b(128, 128);
/*  48 */     this.Shape4.field_78809_i = true;
/*  49 */     setRotation(this.Shape4, -0.1047198F, -0.1396263F, 0.0F);
/*  50 */     this.Shape6 = new ModelRenderer(this, 0, 32);
/*  51 */     this.Shape6.func_78789_a(0.0F, 0.0F, 0.0F, 7, 7, 10);
/*  52 */     this.Shape6.func_78793_a(6.0F, 2.0F, 12.0F);
/*  53 */     this.Shape6.func_78787_b(128, 128);
/*  54 */     this.Shape6.field_78809_i = true;
/*  55 */     setRotation(this.Shape6, 0.5410521F, 0.296706F, 0.0F);
/*  56 */     this.Shape7 = new ModelRenderer(this, 0, 49);
/*  57 */     this.Shape7.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 8);
/*  58 */     this.Shape7.func_78793_a(6.0F, 8.0F, 15.0F);
/*  59 */     this.Shape7.func_78787_b(128, 128);
/*  60 */     this.Shape7.field_78809_i = true;
/*  61 */     setRotation(this.Shape7, 0.0698132F, 0.296706F, 0.0F);
/*  62 */     this.Shape8 = new ModelRenderer(this, 0, 62);
/*  63 */     this.Shape8.func_78789_a(0.0F, 0.0F, 0.0F, 4, 4, 8);
/*  64 */     this.Shape8.func_78793_a(8.0F, -8.0F, 12.0F);
/*  65 */     this.Shape8.func_78787_b(128, 128);
/*  66 */     this.Shape8.field_78809_i = true;
/*  67 */     setRotation(this.Shape8, 0.8028515F, 0.296706F, 0.0F);
/*  68 */     this.Shape9 = new ModelRenderer(this, 0, 62);
/*  69 */     this.Shape9.func_78789_a(0.0F, 0.0F, 0.0F, 4, 4, 8);
/*  70 */     this.Shape9.func_78793_a(10.0F, -2.0F, 19.0F);
/*  71 */     this.Shape9.func_78787_b(128, 128);
/*  72 */     this.Shape9.field_78809_i = true;
/*  73 */     setRotation(this.Shape9, 0.2094395F, 0.296706F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  78 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*     */     
/*  80 */     this.Shape1.func_78785_a(f5);
/*  81 */     this.Shape5.func_78785_a(f5);
/*  82 */     this.Shape3.func_78785_a(f5);
/*  83 */     this.Shape4.func_78785_a(f5);
/*  84 */     this.Shape6.func_78785_a(f5);
/*  85 */     this.Shape7.func_78785_a(f5);
/*  86 */     this.Shape8.func_78785_a(f5);
/*  87 */     this.Shape9.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void renderModel(float f1) {
/*  91 */     this.Shape1.func_78785_a(f1);
/*  92 */     this.Shape3.func_78785_a(f1);
/*  93 */     this.Shape4.func_78785_a(f1);
/*  94 */     this.Shape5.func_78785_a(f1);
/*  95 */     this.Shape6.func_78785_a(f1);
/*  96 */     this.Shape7.func_78785_a(f1);
/*  97 */     this.Shape8.func_78785_a(f1);
/*  98 */     this.Shape9.func_78785_a(f1);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 103 */     model.field_78795_f = x;
/* 104 */     model.field_78796_g = y;
/* 105 */     model.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\hair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */