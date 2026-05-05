/*     */ package JinRyuu.DragonBC.common.Render;
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
/*     */ public class SaibaiHatchedModel
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer bottom;
/*     */   ModelRenderer side1;
/*     */   ModelRenderer side2;
/*     */   ModelRenderer side3;
/*     */   ModelRenderer side4;
/*     */   ModelRenderer a1;
/*     */   ModelRenderer a2;
/*     */   ModelRenderer a3;
/*     */   ModelRenderer a4;
/*     */   
/*     */   public SaibaiHatchedModel() {
/*  33 */     this.field_78090_t = 128;
/*  34 */     this.field_78089_u = 32;
/*     */     
/*  36 */     this.bottom = new ModelRenderer(this, 0, 0);
/*  37 */     this.bottom.func_78789_a(-8.0F, -8.0F, -8.0F, 16, 8, 16);
/*  38 */     this.bottom.func_78793_a(0.0F, 24.0F, 0.0F);
/*  39 */     this.bottom.func_78787_b(64, 32);
/*  40 */     this.bottom.field_78809_i = true;
/*  41 */     setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
/*  42 */     this.side1 = new ModelRenderer(this, 64, 0);
/*  43 */     this.side1.func_78789_a(-8.0F, -7.0F, -8.0F, 16, 8, 1);
/*  44 */     this.side1.func_78793_a(0.0F, 15.0F, 0.0F);
/*  45 */     this.side1.func_78787_b(64, 32);
/*  46 */     this.side1.field_78809_i = true;
/*  47 */     setRotation(this.side1, 0.0F, 0.0F, 0.0F);
/*  48 */     this.side2 = new ModelRenderer(this, 64, 0);
/*  49 */     this.side2.func_78789_a(-8.0F, -7.0F, -8.0F, 16, 8, 1);
/*  50 */     this.side2.func_78793_a(0.0F, 15.0F, 15.0F);
/*  51 */     this.side2.func_78787_b(64, 32);
/*  52 */     this.side2.field_78809_i = true;
/*  53 */     setRotation(this.side2, 0.0F, 0.0F, 0.0F);
/*  54 */     this.side3 = new ModelRenderer(this, 98, 0);
/*  55 */     this.side3.func_78789_a(-8.0F, -7.0F, -8.0F, 1, 8, 14);
/*  56 */     this.side3.func_78793_a(15.0F, 15.0F, 1.0F);
/*  57 */     this.side3.func_78787_b(64, 32);
/*  58 */     this.side3.field_78809_i = true;
/*  59 */     setRotation(this.side3, 0.0F, 0.0F, 0.0F);
/*  60 */     this.side4 = new ModelRenderer(this, 98, 0);
/*  61 */     this.side4.func_78789_a(-8.0F, -7.0F, -8.0F, 1, 8, 14);
/*  62 */     this.side4.func_78793_a(0.0F, 15.0F, 1.0F);
/*  63 */     this.side4.func_78787_b(64, 32);
/*  64 */     this.side4.field_78809_i = true;
/*  65 */     setRotation(this.side4, 0.0F, 0.0F, 0.0F);
/*  66 */     this.a1 = new ModelRenderer(this, 50, 10);
/*  67 */     this.a1.func_78789_a(0.0F, 0.0F, 0.0F, 14, 0, 14);
/*  68 */     this.a1.func_78793_a(-7.0F, 8.0F, -7.0F);
/*  69 */     this.a1.func_78787_b(64, 32);
/*  70 */     this.a1.field_78809_i = true;
/*  71 */     setRotation(this.a1, -0.7853982F, 0.0F, 0.0F);
/*  72 */     this.a2 = new ModelRenderer(this, 50, 10);
/*  73 */     this.a2.func_78789_a(-14.0F, 0.0F, 0.0F, 14, 0, 14);
/*  74 */     this.a2.func_78793_a(7.0F, 8.0F, -7.0F);
/*  75 */     this.a2.func_78787_b(64, 32);
/*  76 */     this.a2.field_78809_i = true;
/*  77 */     setRotation(this.a2, 0.0F, 0.0F, -0.7853982F);
/*  78 */     this.a3 = new ModelRenderer(this, 50, 10);
/*  79 */     this.a3.func_78789_a(-14.0F, 0.0F, -14.0F, 14, 0, 14);
/*  80 */     this.a3.func_78793_a(7.0F, 8.0F, 7.0F);
/*  81 */     this.a3.func_78787_b(64, 32);
/*  82 */     this.a3.field_78809_i = true;
/*  83 */     setRotation(this.a3, 0.7853982F, 0.0F, 0.0F);
/*  84 */     this.a4 = new ModelRenderer(this, 50, 10);
/*  85 */     this.a4.func_78789_a(0.0F, 0.0F, -14.0F, 14, 0, 14);
/*  86 */     this.a4.func_78793_a(-7.0F, 8.0F, 7.0F);
/*  87 */     this.a4.func_78787_b(64, 32);
/*  88 */     this.a4.field_78809_i = true;
/*  89 */     setRotation(this.a4, 0.0F, 0.0F, 0.7853982F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  94 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  95 */     setRotationAngles(f, f1, f2, f3, f4, f5);
/*  96 */     this.bottom.func_78785_a(f5);
/*  97 */     this.side1.func_78785_a(f5);
/*  98 */     this.side2.func_78785_a(f5);
/*  99 */     this.side3.func_78785_a(f5);
/* 100 */     this.side4.func_78785_a(f5);
/* 101 */     this.a1.func_78785_a(f5);
/* 102 */     this.a2.func_78785_a(f5);
/* 103 */     this.a3.func_78785_a(f5);
/* 104 */     this.a4.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   public void renderModel(float f5) {
/* 108 */     this.bottom.func_78785_a(f5);
/* 109 */     this.side1.func_78785_a(f5);
/* 110 */     this.side2.func_78785_a(f5);
/* 111 */     this.side3.func_78785_a(f5);
/* 112 */     this.side4.func_78785_a(f5);
/* 113 */     this.a1.func_78785_a(f5);
/* 114 */     this.a2.func_78785_a(f5);
/* 115 */     this.a3.func_78785_a(f5);
/* 116 */     this.a4.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 120 */     model.field_78795_f = x;
/* 121 */     model.field_78796_g = y;
/* 122 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
/* 127 */     func_78087_a(f, f1, f2, f3, f4, f5, null);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SaibaiHatchedModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */