/*     */ package JinRyuu.JRMCore.m;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class mEnergy
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer aShape1;
/*     */   ModelRenderer aShape2;
/*     */   ModelRenderer aShape3;
/*     */   ModelRenderer aShape4;
/*     */   ModelRenderer bShape1;
/*     */   ModelRenderer bShape2;
/*     */   ModelRenderer bShape3;
/*     */   ModelRenderer bShape4;
/*     */   ModelRenderer bShape5;
/*     */   ModelRenderer bShape6;
/*     */   ModelRenderer bShape7;
/*     */   ModelRenderer cShape1;
/*     */   ModelRenderer cShape2;
/*     */   ModelRenderer cShape3;
/*     */   ModelRenderer dShape1;
/*     */   ModelRenderer eShape1;
/*     */   ModelRenderer eShape2;
/*     */   ModelRenderer eShape3;
/*     */   ModelRenderer eShape4;
/*     */   ModelRenderer eShape5;
/*     */   ModelRenderer eShape6;
/*     */   ModelRenderer eShape7;
/*     */   ModelRenderer eShape8;
/*     */   ModelRenderer eShape9;
/*     */   
/*     */   public mEnergy() {
/*  37 */     this.field_78090_t = 128;
/*  38 */     this.field_78089_u = 128;
/*  39 */     this.aShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  40 */     this.aShape1.func_78789_a(-4.0F, -4.0F, 0.0F, 8, 8, 8);
/*  41 */     this.aShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */     this.aShape1.func_78787_b(128, 128);
/*  43 */     setRotation(this.aShape1, 0.0F, 0.0F, 0.0F);
/*     */     
/*  45 */     this.aShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  46 */     this.aShape2.func_78789_a(-4.0F, -4.0F, -8.0F, 8, 8, 8);
/*  47 */     this.aShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.aShape2.func_78787_b(128, 128);
/*  49 */     setRotation(this.aShape2, 0.0F, 0.0F, 0.0F);
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
/*  74 */     this.bShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  75 */     this.bShape1.func_78789_a(-10.0F, -10.0F, -10.0F, 20, 20, 20);
/*  76 */     this.bShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.bShape1.func_78787_b(128, 128);
/*  78 */     setRotation(this.bShape1, 0.0F, 0.0F, 0.0F);
/*  79 */     this.bShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  80 */     this.bShape2.func_78789_a(-8.0F, -8.0F, -12.0F, 16, 16, 24);
/*  81 */     this.bShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.bShape2.func_78787_b(128, 128);
/*  83 */     setRotation(this.bShape2, 0.0F, 0.0F, 0.0F);
/*  84 */     this.bShape3 = new ModelRenderer((ModelBase)this, 0, 0);
/*  85 */     this.bShape3.func_78789_a(-4.0F, -4.0F, -14.0F, 8, 8, 28);
/*  86 */     this.bShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.bShape3.func_78787_b(128, 128);
/*  88 */     setRotation(this.bShape3, 0.0F, 0.0F, 0.0F);
/*  89 */     this.bShape4 = new ModelRenderer((ModelBase)this, 0, 0);
/*  90 */     this.bShape4.func_78789_a(-8.0F, -12.0F, -8.0F, 16, 24, 16);
/*  91 */     this.bShape4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.bShape4.func_78787_b(128, 128);
/*  93 */     setRotation(this.bShape4, 0.0F, 0.0F, 0.0F);
/*  94 */     this.bShape5 = new ModelRenderer((ModelBase)this, 0, 0);
/*  95 */     this.bShape5.func_78789_a(-4.0F, -14.0F, -4.0F, 8, 28, 8);
/*  96 */     this.bShape5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.bShape5.func_78787_b(128, 128);
/*  98 */     setRotation(this.bShape5, 0.0F, 0.0F, 0.0F);
/*  99 */     this.bShape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 100 */     this.bShape6.func_78789_a(-12.0F, -8.0F, -8.0F, 24, 16, 16);
/* 101 */     this.bShape6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.bShape6.func_78787_b(128, 128);
/* 103 */     setRotation(this.bShape6, 0.0F, 0.0F, 0.0F);
/* 104 */     this.bShape7 = new ModelRenderer((ModelBase)this, 0, 0);
/* 105 */     this.bShape7.func_78789_a(-14.0F, -4.0F, -4.0F, 28, 8, 8);
/* 106 */     this.bShape7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.bShape7.func_78787_b(128, 128);
/* 108 */     setRotation(this.bShape7, 0.0F, 0.0F, 0.0F);
/*     */     
/* 110 */     this.bShape1.func_78792_a(this.bShape2);
/* 111 */     this.bShape1.func_78792_a(this.bShape3);
/* 112 */     this.bShape1.func_78792_a(this.bShape4);
/* 113 */     this.bShape1.func_78792_a(this.bShape5);
/* 114 */     this.bShape1.func_78792_a(this.bShape6);
/* 115 */     this.bShape1.func_78792_a(this.bShape7);
/*     */ 
/*     */     
/* 118 */     this.cShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 119 */     this.cShape1.func_78789_a(-10.0F, -1.0F, -10.0F, 20, 2, 20);
/* 120 */     this.cShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.cShape1.func_78787_b(128, 32);
/* 122 */     setRotation(this.cShape1, 0.0F, 0.0F, 0.0F);
/* 123 */     this.cShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 124 */     this.cShape2.func_78789_a(-7.0F, -0.5F, -12.0F, 14, 1, 24);
/* 125 */     this.cShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.cShape2.func_78787_b(128, 32);
/* 127 */     setRotation(this.cShape2, 0.0F, 0.0F, 0.0F);
/* 128 */     this.cShape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 129 */     this.cShape3.func_78789_a(-12.0F, -0.5F, -7.0F, 24, 1, 14);
/* 130 */     this.cShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 131 */     this.cShape3.func_78787_b(128, 32);
/* 132 */     setRotation(this.cShape3, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 135 */     this.cShape1.func_78792_a(this.cShape2);
/* 136 */     this.cShape1.func_78792_a(this.cShape3);
/*     */ 
/*     */     
/* 139 */     this.dShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 140 */     this.dShape1.func_78789_a(-1.0F, -1.0F, -10.0F, 2, 2, 20);
/* 141 */     this.dShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.dShape1.func_78787_b(128, 128);
/* 143 */     setRotation(this.dShape1, 0.0F, 0.0F, 0.0F);
/*     */     
/* 145 */     this.eShape1 = new ModelRenderer((ModelBase)this, 0, 8);
/* 146 */     this.eShape1.func_78789_a(-3.0F, -3.0F, -7.0F, 6, 6, 14);
/* 147 */     this.eShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 148 */     this.eShape1.func_78787_b(128, 128);
/* 149 */     setRotation(this.eShape1, 0.0F, 0.0F, 0.0F);
/* 150 */     this.eShape2 = new ModelRenderer((ModelBase)this, 0, 8);
/* 151 */     this.eShape2.func_78789_a(-2.0F, -2.0F, -8.0F, 4, 4, 16);
/* 152 */     this.eShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 153 */     this.eShape2.func_78787_b(128, 128);
/* 154 */     setRotation(this.eShape2, 0.0F, 0.0F, 0.0F);
/* 155 */     this.eShape3 = new ModelRenderer((ModelBase)this, 0, 8);
/* 156 */     this.eShape3.func_78789_a(-2.0F, -4.0F, -6.0F, 4, 8, 12);
/* 157 */     this.eShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.eShape3.func_78787_b(128, 128);
/* 159 */     setRotation(this.eShape3, 0.0F, 0.0F, 0.0F);
/* 160 */     this.eShape4 = new ModelRenderer((ModelBase)this, 0, 8);
/* 161 */     this.eShape4.func_78789_a(-4.0F, -2.0F, -6.0F, 8, 4, 12);
/* 162 */     this.eShape4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.eShape4.func_78787_b(128, 128);
/* 164 */     setRotation(this.eShape4, 0.0F, 0.0F, 0.0F);
/* 165 */     this.eShape5 = new ModelRenderer((ModelBase)this, 0, 0);
/* 166 */     this.eShape5.func_78789_a(6.0F, -3.0F, -5.0F, 1, 6, 1);
/* 167 */     this.eShape5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 168 */     this.eShape5.func_78787_b(128, 128);
/* 169 */     setRotation(this.eShape5, -0.3490659F, 0.0F, 0.0F);
/* 170 */     this.eShape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 171 */     this.eShape6.func_78789_a(7.0F, -3.0F, -3.0F, 1, 6, 1);
/* 172 */     this.eShape6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.eShape6.func_78787_b(128, 128);
/* 174 */     setRotation(this.eShape6, -0.3490659F, 0.0F, -0.7853982F);
/* 175 */     this.eShape7 = new ModelRenderer((ModelBase)this, 0, 0);
/* 176 */     this.eShape7.func_78789_a(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
/* 177 */     this.eShape7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 178 */     this.eShape7.func_78787_b(128, 128);
/* 179 */     setRotation(this.eShape7, 0.0F, 0.4537856F, 0.0F);
/* 180 */     this.eShape8 = new ModelRenderer((ModelBase)this, 0, 0);
/* 181 */     this.eShape8.func_78789_a(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
/* 182 */     this.eShape8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.eShape8.func_78787_b(128, 128);
/* 184 */     setRotation(this.eShape8, 0.0F, 0.4014257F, -0.7853982F);
/* 185 */     this.eShape9 = new ModelRenderer((ModelBase)this, 0, 0);
/* 186 */     this.eShape9.func_78789_a(-7.0F, -3.0F, 3.0F, 1, 6, 1);
/* 187 */     this.eShape9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 188 */     this.eShape9.func_78787_b(128, 128);
/* 189 */     setRotation(this.eShape9, 0.3490659F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 192 */     this.eShape1.func_78792_a(this.eShape2);
/* 193 */     this.eShape1.func_78792_a(this.eShape3);
/* 194 */     this.eShape1.func_78792_a(this.eShape4);
/* 195 */     this.eShape7.func_78792_a(this.eShape5);
/* 196 */     this.eShape7.func_78792_a(this.eShape6);
/* 197 */     this.eShape7.func_78792_a(this.eShape8);
/* 198 */     this.eShape7.func_78792_a(this.eShape9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ModelRenderer a, Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 210 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 211 */     a.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 216 */     model.field_78795_f = x;
/* 217 */     model.field_78796_g = y;
/* 218 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 223 */     float par3 = f2;
/* 224 */     float par31 = 1.0F;
/*     */     
/* 226 */     this.aShape1.field_78808_h = par3;
/* 227 */     this.aShape2.field_78808_h = par3;
/*     */     
/* 229 */     this.bShape1.field_78808_h = par3;
/* 230 */     this.bShape1.field_78796_g = par3;
/* 231 */     this.bShape1.field_78795_f = par3;
/*     */     
/* 233 */     this.cShape1.field_78796_g = par3;
/*     */     
/* 235 */     this.dShape1.field_78798_e = par3;
/* 236 */     this.dShape1.field_78808_h = par3;
/*     */     
/* 238 */     this.eShape7.field_78808_h = par3;
/*     */   }
/*     */   
/*     */   public void renderModel(byte type, Entity entity, float par8, float par9, float f, float r, boolean b) {
/* 242 */     ModelRenderer render = null;
/* 243 */     if (type == 0) render = b ? this.aShape1 : this.aShape2; 
/* 244 */     if (type == 1) render = this.bShape1; 
/* 245 */     if (type == 2) render = this.cShape1; 
/* 246 */     if (type == 3) render = this.dShape1; 
/* 247 */     if (type == 4) render = this.eShape7; 
/* 248 */     render(render, entity, 0.0F, 0.0F, r, par8, par9, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\m\mEnergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */