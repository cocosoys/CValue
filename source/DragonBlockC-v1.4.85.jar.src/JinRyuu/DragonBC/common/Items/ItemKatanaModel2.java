/*     */ package JinRyuu.DragonBC.common.Items;
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
/*     */ public class ItemKatanaModel2
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Hilt;
/*     */   public ModelRenderer PommelDeco1;
/*     */   public ModelRenderer Guard1;
/*     */   public ModelRenderer Edge1;
/*     */   public ModelRenderer PommelDeco2;
/*     */   public ModelRenderer GuardSide1;
/*     */   public ModelRenderer GuardSide2;
/*     */   public ModelRenderer Edge2;
/*     */   public ModelRenderer Edge3;
/*     */   public ModelRenderer Edge4;
/*     */   public ModelRenderer Edge5;
/*     */   
/*     */   public ItemKatanaModel2() {
/*  81 */     this.field_78090_t = 64;
/*  82 */     this.field_78089_u = 32;
/*  83 */     this.PommelDeco1 = new ModelRenderer(this, 0, 15);
/*  84 */     this.PommelDeco1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.PommelDeco1.func_78790_a(-1.5F, 4.9F, -1.5F, 3, 1, 3, 0.0F);
/*  86 */     this.GuardSide2 = new ModelRenderer(this, 37, 3);
/*  87 */     this.GuardSide2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.GuardSide2.func_78790_a(4.6F, -3.8F, -1.0F, 3, 1, 2, 0.0F);
/*  89 */     setRotateAngle(this.GuardSide2, 0.0F, 0.0F, -0.31869712F);
/*  90 */     this.PommelDeco2 = new ModelRenderer(this, 0, 20);
/*  91 */     this.PommelDeco2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.PommelDeco2.func_78790_a(-0.5F, 5.8F, -0.5F, 1, 1, 1, 0.0F);
/*  93 */     this.Edge4 = new ModelRenderer(this, 36, 19);
/*  94 */     this.Edge4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  95 */     this.Edge4.func_78790_a(-1.5F, -27.7F, -0.5F, 3, 8, 1, 0.0F);
/*  96 */     this.Guard1 = new ModelRenderer(this, 18, 0);
/*  97 */     this.Guard1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.Guard1.func_78790_a(-3.5F, -5.1F, -1.5F, 7, 1, 3, 0.0F);
/*  99 */     this.Edge3 = new ModelRenderer(this, 25, 17);
/* 100 */     this.Edge3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.Edge3.func_78790_a(-2.0F, -19.7F, -0.5F, 4, 11, 1, 0.0F);
/* 102 */     this.Hilt = new ModelRenderer(this, 0, 0);
/* 103 */     this.Hilt.func_78793_a(0.0F, 13.0F, 0.0F);
/* 104 */     this.Hilt.func_78790_a(-1.0F, -5.7F, -1.0F, 2, 12, 2, 0.0F);
/* 105 */     this.Edge5 = new ModelRenderer(this, 45, 18);
/* 106 */     this.Edge5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.Edge5.func_78790_a(-1.0F, -37.7F, -0.5F, 2, 10, 1, 0.0F);
/* 108 */     this.Edge1 = new ModelRenderer(this, 8, 24);
/* 109 */     this.Edge1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.Edge1.func_78790_a(-1.0F, -7.7F, -0.5F, 2, 2, 1, 0.0F);
/* 111 */     this.Edge2 = new ModelRenderer(this, 16, 25);
/* 112 */     this.Edge2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.Edge2.func_78790_a(-1.5F, -8.7F, -0.5F, 3, 1, 1, 0.0F);
/* 114 */     this.GuardSide1 = new ModelRenderer(this, 9, 3);
/* 115 */     this.GuardSide1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.GuardSide1.func_78790_a(-7.6F, -3.8F, -1.0F, 3, 1, 2, 0.0F);
/* 117 */     setRotateAngle(this.GuardSide1, 0.0F, 0.0F, 0.31869712F);
/* 118 */     this.Hilt.func_78792_a(this.PommelDeco1);
/* 119 */     this.Guard1.func_78792_a(this.GuardSide2);
/* 120 */     this.PommelDeco1.func_78792_a(this.PommelDeco2);
/* 121 */     this.Edge3.func_78792_a(this.Edge4);
/* 122 */     this.Hilt.func_78792_a(this.Guard1);
/* 123 */     this.Edge2.func_78792_a(this.Edge3);
/* 124 */     this.Edge4.func_78792_a(this.Edge5);
/* 125 */     this.Hilt.func_78792_a(this.Edge1);
/* 126 */     this.Edge1.func_78792_a(this.Edge2);
/* 127 */     this.Guard1.func_78792_a(this.GuardSide1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 132 */     this.Hilt.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 137 */     float par1 = 0.0625F;
/* 138 */     this.Hilt.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 145 */     modelRenderer.field_78795_f = x;
/* 146 */     modelRenderer.field_78796_g = y;
/* 147 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemKatanaModel2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */