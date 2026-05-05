/*     */ package JinRyuu.DragonBC.common.Entitys;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
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
/*     */ public class ModelKiHame
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Shape2;
/*     */   ModelRenderer Shape3;
/*     */   ModelRenderer Shape4;
/*     */   ModelRenderer Shape5;
/*     */   ModelRenderer Shape6;
/*     */   ModelRenderer Shape7;
/*     */   ModelRenderer Shape1;
/*     */   public String textureFile;
/*     */   
/*     */   public ModelKiHame(String file) {
/*  32 */     this.textureFile = file;
/*     */   }
/*     */   
/*     */   public ModelKiHame() {
/*  36 */     this.field_78090_t = 128;
/*  37 */     this.field_78089_u = 64;
/*     */ 
/*     */     
/*  40 */     this.Shape2 = new ModelRenderer(this, 0, 0);
/*  41 */     this.Shape2.func_78789_a(0.0F, 0.0F, 0.0F, 25, 15, 15);
/*  42 */     this.Shape2.func_78793_a(2.5F, -5.0F, -5.0F);
/*  43 */     this.Shape2.func_78787_b(128, 64);
/*  44 */     this.Shape2.field_78809_i = true;
/*  45 */     setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
/*  46 */     this.Shape3 = new ModelRenderer(this, 0, 0);
/*  47 */     this.Shape3.func_78789_a(0.0F, 0.0F, 0.0F, 5, 30, 5);
/*  48 */     this.Shape3.func_78793_a(12.5F, -12.5F, 0.0F);
/*  49 */     this.Shape3.func_78787_b(128, 64);
/*  50 */     this.Shape3.field_78809_i = true;
/*  51 */     setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
/*  52 */     this.Shape4 = new ModelRenderer(this, 0, 0);
/*  53 */     this.Shape4.func_78789_a(0.0F, 0.0F, 0.0F, 5, 5, 30);
/*  54 */     this.Shape4.func_78793_a(12.5F, 0.0F, -12.5F);
/*  55 */     this.Shape4.func_78787_b(128, 64);
/*  56 */     this.Shape4.field_78809_i = true;
/*  57 */     setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
/*  58 */     this.Shape5 = new ModelRenderer(this, 0, 0);
/*  59 */     this.Shape5.func_78789_a(0.0F, 0.0F, 0.0F, 15, 25, 15);
/*  60 */     this.Shape5.func_78793_a(7.5F, -10.0F, -5.0F);
/*  61 */     this.Shape5.func_78787_b(128, 64);
/*  62 */     this.Shape5.field_78809_i = true;
/*  63 */     setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
/*  64 */     this.Shape6 = new ModelRenderer(this, 0, 0);
/*  65 */     this.Shape6.func_78789_a(0.0F, 0.0F, 0.0F, 15, 15, 25);
/*  66 */     this.Shape6.func_78793_a(7.5F, -5.0F, -10.0F);
/*  67 */     this.Shape6.func_78787_b(128, 64);
/*  68 */     this.Shape6.field_78809_i = true;
/*  69 */     setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
/*  70 */     this.Shape7 = new ModelRenderer(this, 0, 0);
/*  71 */     this.Shape7.func_78789_a(0.0F, 0.0F, 0.0F, 20, 20, 20);
/*  72 */     this.Shape7.func_78793_a(5.0F, -7.5F, -7.5F);
/*  73 */     this.Shape7.func_78787_b(128, 64);
/*  74 */     this.Shape7.field_78809_i = true;
/*  75 */     setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
/*  76 */     this.Shape1 = new ModelRenderer(this, 0, 0);
/*  77 */     this.Shape1.func_78789_a(0.0F, 0.0F, 0.0F, 30, 5, 5);
/*  78 */     this.Shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.Shape1.func_78787_b(128, 64);
/*  80 */     this.Shape1.field_78809_i = true;
/*  81 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  86 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  87 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/*  88 */     this.Shape2.func_78785_a(f5);
/*  89 */     this.Shape3.func_78785_a(f5);
/*  90 */     this.Shape4.func_78785_a(f5);
/*  91 */     this.Shape5.func_78785_a(f5);
/*  92 */     this.Shape6.func_78785_a(f5);
/*  93 */     this.Shape7.func_78785_a(f5);
/*  94 */     this.Shape1.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  99 */     model.field_78795_f = x;
/* 100 */     model.field_78796_g = y;
/* 101 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
/* 106 */     func_78087_a(f, f1, f2, f3, f4, f5, null);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Entitys\ModelKiHame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */