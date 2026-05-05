/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ public class ModelPS extends ModelBase {
/*     */   private int id;
/*     */   public ModelRenderer shape1;
/*     */   public ModelRenderer shape2;
/*     */   public ModelRenderer shape3;
/*     */   public ModelRenderer shape_1_1;
/*     */   public ModelRenderer shape_1_2;
/*     */   public ModelRenderer shape_1_3;
/*     */   public ModelRenderer shape_1_4;
/*     */   public ModelRenderer shape_1_5;
/*     */   public ModelRenderer shape_1_6;
/*     */   public ModelRenderer shape_2_1;
/*     */   public ModelRenderer shape_2_2;
/*     */   public ModelRenderer shape_2_3;
/*     */   public ModelRenderer shape_2_4;
/*     */   
/*     */   public ModelPS(int id) {
/*  20 */     this.id = id;
/*  21 */     this.field_78090_t = 64;
/*  22 */     this.field_78089_u = 32;
/*  23 */     if (id == 0) {
/*  24 */       this.shape1 = new ModelRenderer(this, 0, 0);
/*  25 */       this.shape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  26 */       this.shape1.func_78790_a(-1.4F, -2.0F, -1.5F, 3, 3, 3, 0.0F);
/*  27 */       this.shape3 = new ModelRenderer(this, 40, 0);
/*  28 */       this.shape3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  29 */       this.shape3.func_78790_a(-1.1F, 0.8F, -0.7F, 2, 3, 2, 0.0F);
/*  30 */       this.shape2 = new ModelRenderer(this, 21, 0);
/*  31 */       this.shape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  32 */       this.shape2.func_78790_a(-0.6F, -4.8F, -1.1F, 2, 3, 2, 0.0F);
/*     */     }
/*  34 */     else if (id == 1) {
/*  35 */       this.shape_1_1 = new ModelRenderer(this, 0, 0);
/*  36 */       this.shape_1_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  37 */       this.shape_1_1.func_78790_a(-1.4F, -2.0F, -1.5F, 3, 3, 3, 0.0F);
/*  38 */       this.shape_1_2 = new ModelRenderer(this, 21, 0);
/*  39 */       this.shape_1_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  40 */       this.shape_1_2.func_78790_a(-0.6F, -3.9F, -1.1F, 2, 2, 2, 0.0F);
/*  41 */       this.shape_1_3 = new ModelRenderer(this, 40, 0);
/*  42 */       this.shape_1_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */       this.shape_1_3.func_78790_a(-1.1F, 0.8F, -0.7F, 2, 1, 2, 0.0F);
/*  44 */       this.shape_1_5 = new ModelRenderer(this, 23, 15);
/*  45 */       this.shape_1_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */       this.shape_1_5.func_78790_a(-0.3F, -5.4F, -0.4F, 1, 2, 1, 0.0F);
/*  47 */       this.shape_1_4 = new ModelRenderer(this, 2, 14);
/*  48 */       this.shape_1_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  49 */       this.shape_1_4.func_78790_a(1.0F, -3.4F, -0.7F, 1, 4, 1, 0.0F);
/*  50 */       this.shape_1_6 = new ModelRenderer(this, 43, 16);
/*  51 */       this.shape_1_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */       this.shape_1_6.func_78790_a(-0.6F, 1.6F, -0.6F, 1, 1, 1, 0.0F);
/*     */     }
/*  54 */     else if (id == 2) {
/*  55 */       this.shape_2_4 = new ModelRenderer(this, 2, 14);
/*  56 */       this.shape_2_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */       this.shape_2_4.func_78790_a(1.0F, -3.0F, -0.7F, 1, 1, 1, 0.0F);
/*  58 */       this.shape_2_1 = new ModelRenderer(this, 0, 0);
/*  59 */       this.shape_2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */       this.shape_2_1.func_78790_a(-1.4F, -2.0F, -1.5F, 4, 4, 4, 0.0F);
/*  61 */       this.shape_2_2 = new ModelRenderer(this, 21, 0);
/*  62 */       this.shape_2_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */       this.shape_2_2.func_78790_a(-0.6F, -4.6F, -1.3F, 2, 3, 3, 0.0F);
/*  64 */       this.shape_2_6 = new ModelRenderer(this, 43, 16);
/*  65 */       this.shape_2_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */       this.shape_2_6.func_78790_a(-0.8F, -1.7F, -2.5F, 2, 3, 1, 0.0F);
/*  67 */       this.shape_2_3 = new ModelRenderer(this, 40, 0);
/*  68 */       this.shape_2_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */       this.shape_2_3.func_78790_a(-1.1F, 1.9F, -0.7F, 2, 1, 3, 0.0F);
/*  70 */       this.shape_2_5 = new ModelRenderer(this, 23, 15);
/*  71 */       this.shape_2_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */       this.shape_2_5.func_78790_a(-0.5F, -5.4F, -1.0F, 1, 1, 1, 0.0F);
/*     */     }
/*  74 */     else if (id == 3) {
/*  75 */       this.shape_3_4 = new ModelRenderer(this, 2, 14);
/*  76 */       this.shape_3_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */       this.shape_3_4.func_78790_a(0.5F, -5.0F, 1.5F, 1, 1, 1, 0.0F);
/*  78 */       this.shape_3_3 = new ModelRenderer(this, 40, 0);
/*  79 */       this.shape_3_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */       this.shape_3_3.func_78790_a(-1.1F, 1.9F, -0.7F, 3, 3, 2, 0.0F);
/*  81 */       this.shape_3_1 = new ModelRenderer(this, 0, 0);
/*  82 */       this.shape_3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */       this.shape_3_1.func_78790_a(-1.4F, -2.0F, -1.5F, 4, 4, 3, 0.0F);
/*  84 */       this.shape_3_2 = new ModelRenderer(this, 21, 0);
/*  85 */       this.shape_3_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */       this.shape_3_2.func_78790_a(-0.6F, -4.6F, -1.3F, 2, 3, 3, 0.0F);
/*  87 */       this.shape_3_6 = new ModelRenderer(this, 43, 16);
/*  88 */       this.shape_3_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */       this.shape_3_6.func_78790_a(-0.2F, -1.1F, -2.3F, 2, 2, 1, 0.0F);
/*  90 */       this.shape_3_5 = new ModelRenderer(this, 23, 15);
/*  91 */       this.shape_3_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */       this.shape_3_5.func_78790_a(-0.4F, -5.5F, 0.7F, 1, 2, 2, 0.0F);
/*     */     }
/*  94 */     else if (id == 4) {
/*  95 */       this.shape_4_4 = new ModelRenderer(this, 2, 14);
/*  96 */       this.shape_4_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */       this.shape_4_4.func_78790_a(0.5F, -2.6F, 1.1F, 1, 3, 2, 0.0F);
/*  98 */       this.shape_4_1 = new ModelRenderer(this, 0, 0);
/*  99 */       this.shape_4_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */       this.shape_4_1.func_78790_a(-1.4F, -2.0F, -1.5F, 4, 5, 4, 0.0F);
/* 101 */       this.shape_4_6 = new ModelRenderer(this, 43, 16);
/* 102 */       this.shape_4_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */       this.shape_4_6.func_78790_a(-0.2F, -1.1F, -2.3F, 2, 5, 1, 0.0F);
/* 104 */       this.shape_4_2 = new ModelRenderer(this, 21, 0);
/* 105 */       this.shape_4_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 106 */       this.shape_4_2.func_78790_a(-0.6F, -3.8F, -1.3F, 4, 2, 3, 0.0F);
/* 107 */       this.shape_4_3 = new ModelRenderer(this, 40, 0);
/* 108 */       this.shape_4_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */       this.shape_4_3.func_78790_a(-1.1F, 1.9F, -1.5F, 3, 5, 2, 0.0F);
/* 110 */       this.shape_4_5 = new ModelRenderer(this, 23, 15);
/* 111 */       this.shape_4_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */       this.shape_4_5.func_78790_a(0.9F, -5.6F, -0.9F, 2, 2, 2, 0.0F);
/*     */     } 
/*     */   }
/*     */   public ModelRenderer shape_2_5; public ModelRenderer shape_2_6; public ModelRenderer shape_3_1; public ModelRenderer shape_3_2; public ModelRenderer shape_3_3; public ModelRenderer shape_3_4; public ModelRenderer shape_3_5; public ModelRenderer shape_3_6; public ModelRenderer shape_4_1; public ModelRenderer shape_4_2; public ModelRenderer shape_4_3; public ModelRenderer shape_4_4; public ModelRenderer shape_4_5; public ModelRenderer shape_4_6;
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 118 */     if (this.id == 0) {
/* 119 */       this.shape1.func_78785_a(f5);
/* 120 */       this.shape2.func_78785_a(f5);
/* 121 */       this.shape3.func_78785_a(f5);
/*     */     } 
/* 123 */     if (this.id == 1) {
/* 124 */       this.shape_1_1.func_78785_a(f5);
/* 125 */       this.shape_1_2.func_78785_a(f5);
/* 126 */       this.shape_1_3.func_78785_a(f5);
/* 127 */       this.shape_1_4.func_78785_a(f5);
/* 128 */       this.shape_1_5.func_78785_a(f5);
/* 129 */       this.shape_1_6.func_78785_a(f5);
/*     */     } 
/* 131 */     if (this.id == 2) {
/* 132 */       this.shape_2_1.func_78785_a(f5);
/* 133 */       this.shape_2_2.func_78785_a(f5);
/* 134 */       this.shape_2_3.func_78785_a(f5);
/* 135 */       this.shape_2_4.func_78785_a(f5);
/* 136 */       this.shape_2_5.func_78785_a(f5);
/* 137 */       this.shape_2_6.func_78785_a(f5);
/*     */     } 
/* 139 */     if (this.id == 3) {
/* 140 */       this.shape_3_1.func_78785_a(f5);
/* 141 */       this.shape_3_2.func_78785_a(f5);
/* 142 */       this.shape_3_3.func_78785_a(f5);
/* 143 */       this.shape_3_4.func_78785_a(f5);
/* 144 */       this.shape_3_5.func_78785_a(f5);
/* 145 */       this.shape_3_6.func_78785_a(f5);
/*     */     } 
/* 147 */     if (this.id == 4) {
/* 148 */       this.shape_4_1.func_78785_a(f5);
/* 149 */       this.shape_4_2.func_78785_a(f5);
/* 150 */       this.shape_4_3.func_78785_a(f5);
/* 151 */       this.shape_4_4.func_78785_a(f5);
/* 152 */       this.shape_4_5.func_78785_a(f5);
/* 153 */       this.shape_4_6.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 161 */     modelRenderer.field_78795_f = x;
/* 162 */     modelRenderer.field_78796_g = y;
/* 163 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelPS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */