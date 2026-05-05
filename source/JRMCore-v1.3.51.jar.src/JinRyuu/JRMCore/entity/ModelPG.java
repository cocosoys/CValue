/*     */ package JinRyuu.JRMCore.entity;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelPG extends ModelBase {
/*     */   private int id;
/*     */   public ModelRenderer shape1;
/*     */   public ModelRenderer shape2;
/*     */   public ModelRenderer shape3;
/*     */   public ModelRenderer shape4;
/*     */   public ModelRenderer shape_1_1;
/*     */   public ModelRenderer shape_1_2;
/*     */   public ModelRenderer shape_1_3;
/*     */   public ModelRenderer shape_1_4;
/*     */   public ModelRenderer shape_1_5;
/*     */   public ModelRenderer shape_2_1;
/*     */   public ModelRenderer shape_2_2;
/*     */   
/*     */   public ModelPG(int id) {
/*  20 */     this.id = id;
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 32;
/*  23 */     if (id == 0) {
/*  24 */       this.shape3 = new ModelRenderer(this, 26, 0);
/*  25 */       this.shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  26 */       this.shape3.func_78790_a(-0.8F, -7.8F, -1.0F, 2, 2, 2, 0.0F);
/*  27 */       this.shape1 = new ModelRenderer(this, 0, 0);
/*  28 */       this.shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */       this.shape1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
/*  30 */       this.shape4 = new ModelRenderer(this, 41, 0);
/*  31 */       this.shape4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */       this.shape4.func_78790_a(-2.4F, 3.8F, -1.0F, 2, 2, 2, 0.0F);
/*  33 */       this.shape2 = new ModelRenderer(this, 13, 0);
/*  34 */       this.shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  35 */       this.shape2.func_78790_a(0.4F, -5.9F, -1.0F, 2, 5, 2, 0.0F);
/*     */     }
/*  37 */     else if (id == 1) {
/*  38 */       this.shape_1_4 = new ModelRenderer(this, 36, 0);
/*  39 */       this.shape_1_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */       this.shape_1_4.func_78790_a(0.1F, 3.8F, -1.0F, 2, 2, 2, 0.0F);
/*  41 */       this.shape_1_1 = new ModelRenderer(this, 0, 0);
/*  42 */       this.shape_1_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */       this.shape_1_1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
/*  44 */       this.shape_1_3 = new ModelRenderer(this, 24, 0);
/*  45 */       this.shape_1_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */       this.shape_1_3.func_78790_a(-0.8F, -6.3F, -1.0F, 2, 2, 2, 0.0F);
/*  47 */       this.shape_1_5 = new ModelRenderer(this, 49, 0);
/*  48 */       this.shape_1_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */       this.shape_1_5.func_78790_a(1.6F, 5.8F, -1.0F, 2, 2, 2, 0.0F);
/*  50 */       this.shape_1_2 = new ModelRenderer(this, 12, 0);
/*  51 */       this.shape_1_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */       this.shape_1_2.func_78790_a(0.4F, -4.6F, -1.0F, 2, 4, 2, 0.0F);
/*     */     }
/*  54 */     else if (id == 2) {
/*  55 */       this.shape_2_5 = new ModelRenderer(this, 39, 0);
/*  56 */       this.shape_2_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */       this.shape_2_5.func_78790_a(1.3F, 5.4F, 1.4F, 2, 2, 3, 0.0F);
/*  58 */       this.shape_2_1 = new ModelRenderer(this, 0, 0);
/*  59 */       this.shape_2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */       this.shape_2_1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
/*  61 */       this.shape_2_3 = new ModelRenderer(this, 19, 0);
/*  62 */       this.shape_2_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */       this.shape_2_3.func_78790_a(-0.8F, -6.3F, -3.6F, 2, 2, 2, 0.0F);
/*  64 */       this.shape_2_2 = new ModelRenderer(this, 9, 0);
/*  65 */       this.shape_2_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */       this.shape_2_2.func_78790_a(0.4F, -4.6F, -2.1F, 2, 4, 2, 0.0F);
/*  67 */       this.shape_2_4 = new ModelRenderer(this, 29, 0);
/*  68 */       this.shape_2_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */       this.shape_2_4.func_78790_a(0.0F, 3.7F, 0.2F, 2, 2, 2, 0.0F);
/*     */     }
/*  71 */     else if (id == 3) {
/*  72 */       this.shape_3_1 = new ModelRenderer(this, 0, 0);
/*  73 */       this.shape_3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */       this.shape_3_1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
/*  75 */       this.shape_3_5 = new ModelRenderer(this, 39, 0);
/*  76 */       this.shape_3_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */       this.shape_3_5.func_78790_a(1.0F, 6.3F, 1.3F, 2, 4, 2, 0.0F);
/*  78 */       this.shape_3_3 = new ModelRenderer(this, 19, 0);
/*  79 */       this.shape_3_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */       this.shape_3_3.func_78790_a(-0.8F, -5.3F, -4.1F, 2, 4, 2, 0.0F);
/*  81 */       this.shape_3_4 = new ModelRenderer(this, 29, 0);
/*  82 */       this.shape_3_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */       this.shape_3_4.func_78790_a(-0.1F, 3.5F, 0.1F, 2, 3, 2, 0.0F);
/*  84 */       this.shape_3_2 = new ModelRenderer(this, 9, 0);
/*  85 */       this.shape_3_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */       this.shape_3_2.func_78790_a(0.4F, -2.2F, -2.8F, 2, 2, 3, 0.0F);
/*     */     }
/*  88 */     else if (id == 4) {
/*  89 */       this.shape_4_3 = new ModelRenderer(this, 25, 0);
/*  90 */       this.shape_4_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */       this.shape_4_3.func_78790_a(-0.8F, -3.5F, -4.1F, 2, 2, 2, 0.0F);
/*  92 */       this.shape_4_1 = new ModelRenderer(this, 0, 0);
/*  93 */       this.shape_4_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */       this.shape_4_1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
/*  95 */       this.shape_4_2 = new ModelRenderer(this, 12, 0);
/*  96 */       this.shape_4_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */       this.shape_4_2.func_78790_a(0.4F, -2.2F, -2.8F, 2, 2, 3, 0.0F);
/*  98 */       this.shape_4_5 = new ModelRenderer(this, 52, 0);
/*  99 */       this.shape_4_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */       this.shape_4_5.func_78790_a(1.0F, 3.9F, 2.4F, 2, 2, 2, 0.0F);
/* 101 */       this.shape_4_4 = new ModelRenderer(this, 37, 0);
/* 102 */       this.shape_4_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */       this.shape_4_4.func_78790_a(-0.1F, 2.3F, 0.1F, 2, 2, 3, 0.0F);
/*     */     } 
/*     */   }
/*     */   public ModelRenderer shape_2_3; public ModelRenderer shape_2_4; public ModelRenderer shape_2_5; public ModelRenderer shape_3_1; public ModelRenderer shape_3_2; public ModelRenderer shape_3_3; public ModelRenderer shape_3_4; public ModelRenderer shape_3_5; public ModelRenderer shape_4_1; public ModelRenderer shape_4_2; public ModelRenderer shape_4_3; public ModelRenderer shape_4_4; public ModelRenderer shape_4_5;
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 109 */     if (this.id == 0) {
/* 110 */       this.shape1.func_78785_a(f5);
/* 111 */       this.shape2.func_78785_a(f5);
/* 112 */       this.shape3.func_78785_a(f5);
/* 113 */       this.shape4.func_78785_a(f5);
/*     */     } 
/* 115 */     if (this.id == 1) {
/* 116 */       this.shape_1_1.func_78785_a(f5);
/* 117 */       this.shape_1_2.func_78785_a(f5);
/* 118 */       this.shape_1_3.func_78785_a(f5);
/* 119 */       this.shape_1_4.func_78785_a(f5);
/* 120 */       this.shape_1_5.func_78785_a(f5);
/*     */     } 
/* 122 */     if (this.id == 2) {
/* 123 */       this.shape_2_1.func_78785_a(f5);
/* 124 */       this.shape_2_2.func_78785_a(f5);
/* 125 */       this.shape_2_3.func_78785_a(f5);
/* 126 */       this.shape_2_4.func_78785_a(f5);
/* 127 */       this.shape_2_5.func_78785_a(f5);
/*     */     } 
/* 129 */     if (this.id == 3) {
/* 130 */       this.shape_3_1.func_78785_a(f5);
/* 131 */       this.shape_3_2.func_78785_a(f5);
/* 132 */       this.shape_3_3.func_78785_a(f5);
/* 133 */       this.shape_3_4.func_78785_a(f5);
/* 134 */       this.shape_3_5.func_78785_a(f5);
/*     */     } 
/* 136 */     if (this.id == 4) {
/* 137 */       this.shape_4_1.func_78785_a(f5);
/* 138 */       this.shape_4_2.func_78785_a(f5);
/* 139 */       this.shape_4_3.func_78785_a(f5);
/* 140 */       this.shape_4_4.func_78785_a(f5);
/* 141 */       this.shape_4_5.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 149 */     modelRenderer.field_78795_f = x;
/* 150 */     modelRenderer.field_78796_g = y;
/* 151 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelPG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */