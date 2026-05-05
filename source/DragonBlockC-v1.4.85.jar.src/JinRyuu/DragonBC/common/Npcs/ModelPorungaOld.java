/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelPorungaOld extends ModelBiped {
/*     */   ModelRenderer dragon1;
/*     */   ModelRenderer dragon2;
/*     */   ModelRenderer dragon3;
/*     */   ModelRenderer dragon4;
/*     */   ModelRenderer dragon5;
/*     */   ModelRenderer dragon8;
/*     */   ModelRenderer dragon10;
/*     */   ModelRenderer dragon12;
/*     */   ModelRenderer dragon13;
/*     */   ModelRenderer dragon14;
/*     */   ModelRenderer dragon15;
/*     */   ModelRenderer dragon16;
/*     */   ModelRenderer dragon17;
/*     */   ModelRenderer dragon18;
/*     */   ModelRenderer dragon19;
/*     */   ModelRenderer dragon20;
/*     */   ModelRenderer dragon22;
/*     */   ModelRenderer dragon23;
/*     */   ModelRenderer dragon24;
/*     */   
/*     */   public ModelPorungaOld() {
/*  30 */     this.field_78090_t = 256;
/*  31 */     this.field_78089_u = 128;
/*     */     
/*  33 */     this.dragon1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  34 */     this.dragon1.func_78789_a(-4.0F, -4.0F, -4.0F, 8, 16, 8);
/*  35 */     this.dragon1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.dragon1.func_78787_b(256, 128);
/*  37 */     this.dragon1.field_78809_i = true;
/*  38 */     this.dragon2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  39 */     this.dragon2.func_78789_a(-4.0F, -18.0F, -3.0F, 8, 16, 8);
/*  40 */     this.dragon2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.dragon2.func_78787_b(256, 128);
/*  42 */     setRotation(this.dragon2, 0.4537856F, 0.0174533F, 0.0F);
/*  43 */     this.dragon3 = new ModelRenderer((ModelBase)this, 0, 0);
/*  44 */     this.dragon3.func_78789_a(-4.0F, -25.0F, -16.0F, 8, 16, 8);
/*  45 */     this.dragon3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.dragon3.func_78787_b(256, 128);
/*  47 */     setRotation(this.dragon3, -0.4363323F, 0.0F, 0.0F);
/*  48 */     this.dragon4 = new ModelRenderer((ModelBase)this, 40, 37);
/*  49 */     this.dragon4.func_78789_a(-3.0F, -91.0F, 11.0F, 11, 4, 4);
/*  50 */     this.dragon4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.dragon4.func_78787_b(256, 128);
/*  52 */     setRotation(this.dragon4, 0.2443461F, -0.3839724F, 0.0F);
/*  53 */     this.dragon5 = new ModelRenderer((ModelBase)this, 0, 47);
/*  54 */     this.dragon5.func_78789_a(-5.0F, -80.0F, 44.0F, 10, 10, 10);
/*  55 */     this.dragon5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.dragon5.func_78787_b(256, 128);
/*  57 */     setRotation(this.dragon5, 0.6806784F, 0.0F, 0.0F);
/*  58 */     this.dragon8 = new ModelRenderer((ModelBase)this, 152, 0);
/*  59 */     this.dragon8.func_78789_a(-17.0F, -85.0F, 13.0F, 36, 20, 16);
/*  60 */     this.dragon8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.dragon8.func_78787_b(256, 128);
/*  62 */     setRotation(this.dragon8, 0.2443461F, 0.0174533F, 0.0F);
/*  63 */     this.dragon10 = new ModelRenderer((ModelBase)this, 40, 37);
/*  64 */     this.dragon10.func_78789_a(-8.0F, -91.0F, 11.0F, 11, 4, 4);
/*  65 */     this.dragon10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.dragon10.func_78787_b(256, 128);
/*  67 */     setRotation(this.dragon10, 0.2443461F, 0.3839724F, 0.0F);
/*  68 */     this.dragon12 = new ModelRenderer((ModelBase)this, 0, 24);
/*  69 */     this.dragon12.func_78789_a(-3.0F, 7.0F, -6.0F, 6, 16, 6);
/*  70 */     this.dragon12.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.dragon12.func_78787_b(256, 128);
/*  72 */     setRotation(this.dragon12, 0.2617994F, 0.0F, 0.0F);
/*  73 */     this.dragon13 = new ModelRenderer((ModelBase)this, 40, 45);
/*  74 */     this.dragon13.func_78789_a(3.0F, -61.0F, 71.0F, 4, 4, 12);
/*  75 */     this.dragon13.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.dragon13.func_78787_b(256, 128);
/*  77 */     setRotation(this.dragon13, 0.9773844F, 0.2094395F, 0.0F);
/*  78 */     this.dragon14 = new ModelRenderer((ModelBase)this, 40, 45);
/*  79 */     this.dragon14.func_78789_a(-7.0F, -61.0F, 71.0F, 4, 4, 12);
/*  80 */     this.dragon14.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.dragon14.func_78787_b(256, 128);
/*  82 */     setRotation(this.dragon14, 0.9773844F, -0.2094395F, 0.0F);
/*  83 */     this.dragon15 = new ModelRenderer((ModelBase)this, 80, 0);
/*  84 */     this.dragon15.func_78789_a(-12.0F, -76.0F, -8.0F, 24, 24, 12);
/*  85 */     this.dragon15.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.dragon15.func_78787_b(256, 128);
/*  87 */     setRotation(this.dragon15, -0.0872665F, 0.0F, 0.0F);
/*  88 */     this.dragon16 = new ModelRenderer((ModelBase)this, 32, 0);
/*  89 */     this.dragon16.func_78789_a(-7.0F, -53.0F, -9.0F, 14, 27, 10);
/*  90 */     this.dragon16.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.dragon16.func_78787_b(256, 128);
/*  92 */     setRotation(this.dragon16, -0.122173F, 0.0F, 0.0F);
/*  93 */     this.dragon17 = new ModelRenderer((ModelBase)this, 0, 90);
/*  94 */     this.dragon17.func_78789_a(-43.0F, -58.0F, -19.0F, 13, 26, 12);
/*  95 */     this.dragon17.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.dragon17.func_78787_b(256, 128);
/*  97 */     setRotation(this.dragon17, -0.2617994F, -0.0174533F, 0.1745329F);
/*  98 */     this.dragon18 = new ModelRenderer((ModelBase)this, 50, 90);
/*  99 */     this.dragon18.func_78789_a(-43.0F, -84.0F, -4.0F, 13, 26, 12);
/* 100 */     this.dragon18.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.dragon18.func_78787_b(256, 128);
/* 102 */     setRotation(this.dragon18, 0.0F, 0.0F, 0.1745329F);
/* 103 */     this.dragon19 = new ModelRenderer((ModelBase)this, 50, 90);
/* 104 */     this.dragon19.field_78809_i = true;
/* 105 */     this.dragon19.func_78789_a(32.0F, -84.0F, -4.0F, 13, 26, 12);
/* 106 */     this.dragon19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.dragon19.func_78787_b(256, 128);
/* 108 */     setRotation(this.dragon19, 0.0F, 0.0F, -0.1745329F);
/* 109 */     this.dragon20 = new ModelRenderer((ModelBase)this, 0, 90);
/* 110 */     this.dragon20.field_78809_i = true;
/* 111 */     this.dragon20.func_78789_a(32.0F, -58.0F, -19.0F, 13, 26, 12);
/* 112 */     this.dragon20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.dragon20.func_78787_b(256, 128);
/* 114 */     setRotation(this.dragon20, -0.2617994F, 0.0174533F, -0.1745329F);
/* 115 */     this.dragon22 = new ModelRenderer((ModelBase)this, 116, 88);
/* 116 */     this.dragon22.func_78789_a(0.0F, -92.0F, 22.0F, 0, 27, 13);
/* 117 */     this.dragon22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.dragon22.func_78787_b(256, 128);
/* 119 */     setRotation(this.dragon22, 0.2443461F, 0.0174533F, 0.0F);
/* 120 */     this.dragon23 = new ModelRenderer((ModelBase)this, 100, 73);
/* 121 */     this.dragon23.func_78789_a(0.0F, -74.0F, -9.0F, 0, 47, 8);
/* 122 */     this.dragon23.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.dragon23.func_78787_b(256, 128);
/* 124 */     setRotation(this.dragon23, -0.2617994F, 0.0F, 0.0F);
/* 125 */     this.dragon24 = new ModelRenderer((ModelBase)this, 1, 52);
/* 126 */     this.dragon24.func_78789_a(-4.0F, -75.1F, 43.0F, 8, 5, 10);
/* 127 */     this.dragon24.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.dragon24.func_78787_b(256, 128);
/* 129 */     setRotation(this.dragon24, 0.6806784F, 0.0F, 0.0F);
/*     */     
/* 131 */     this.dragon1.func_78792_a(this.dragon2);
/* 132 */     this.dragon1.func_78792_a(this.dragon3);
/* 133 */     this.dragon1.func_78792_a(this.dragon4);
/* 134 */     this.dragon1.func_78792_a(this.dragon5);
/* 135 */     this.dragon1.func_78792_a(this.dragon8);
/* 136 */     this.dragon1.func_78792_a(this.dragon10);
/* 137 */     this.dragon1.func_78792_a(this.dragon12);
/* 138 */     this.dragon1.func_78792_a(this.dragon13);
/* 139 */     this.dragon1.func_78792_a(this.dragon14);
/* 140 */     this.dragon1.func_78792_a(this.dragon15);
/* 141 */     this.dragon1.func_78792_a(this.dragon16);
/* 142 */     this.dragon1.func_78792_a(this.dragon17);
/* 143 */     this.dragon1.func_78792_a(this.dragon18);
/* 144 */     this.dragon1.func_78792_a(this.dragon19);
/* 145 */     this.dragon1.func_78792_a(this.dragon20);
/* 146 */     this.dragon1.func_78792_a(this.dragon22);
/* 147 */     this.dragon1.func_78792_a(this.dragon23);
/* 148 */     this.dragon1.func_78792_a(this.dragon24);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 152 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 153 */     this.dragon1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 157 */     model.field_78795_f = x;
/* 158 */     model.field_78796_g = y;
/* 159 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {}
/*     */ 
/*     */   
/*     */   public void renderModel(Entity entity, float f) {
/* 168 */     func_78088_a(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelPorungaOld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */