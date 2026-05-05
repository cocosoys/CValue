/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelEnergy
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
/*     */   public ModelEnergy() {
/*  39 */     this.field_78090_t = 128;
/*  40 */     this.field_78089_u = 128;
/*  41 */     this.aShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  42 */     this.aShape1.func_78789_a(-4.0F, -4.0F, 0.0F, 8, 8, 8);
/*  43 */     this.aShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.aShape1.func_78787_b(128, 128);
/*  45 */     setRotation(this.aShape1, 0.0F, 0.0F, 0.0F);
/*     */     
/*  47 */     this.aShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  48 */     this.aShape2.func_78789_a(-4.0F, -4.0F, -8.0F, 8, 8, 8);
/*  49 */     this.aShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.aShape2.func_78787_b(128, 128);
/*  51 */     setRotation(this.aShape2, 0.0F, 0.0F, 0.0F);
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
/*  76 */     this.bShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/*  77 */     this.bShape1.func_78789_a(-10.0F, -10.0F, -10.0F, 20, 20, 20);
/*  78 */     this.bShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.bShape1.func_78787_b(128, 128);
/*  80 */     setRotation(this.bShape1, 0.0F, 0.0F, 0.0F);
/*  81 */     this.bShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  82 */     this.bShape2.func_78789_a(-8.0F, -8.0F, -12.0F, 16, 16, 24);
/*  83 */     this.bShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.bShape2.func_78787_b(128, 128);
/*  85 */     setRotation(this.bShape2, 0.0F, 0.0F, 0.0F);
/*  86 */     this.bShape3 = new ModelRenderer((ModelBase)this, 0, 0);
/*  87 */     this.bShape3.func_78789_a(-4.0F, -4.0F, -14.0F, 8, 8, 28);
/*  88 */     this.bShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.bShape3.func_78787_b(128, 128);
/*  90 */     setRotation(this.bShape3, 0.0F, 0.0F, 0.0F);
/*  91 */     this.bShape4 = new ModelRenderer((ModelBase)this, 0, 0);
/*  92 */     this.bShape4.func_78789_a(-8.0F, -12.0F, -8.0F, 16, 24, 16);
/*  93 */     this.bShape4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.bShape4.func_78787_b(128, 128);
/*  95 */     setRotation(this.bShape4, 0.0F, 0.0F, 0.0F);
/*  96 */     this.bShape5 = new ModelRenderer((ModelBase)this, 0, 0);
/*  97 */     this.bShape5.func_78789_a(-4.0F, -14.0F, -4.0F, 8, 28, 8);
/*  98 */     this.bShape5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  99 */     this.bShape5.func_78787_b(128, 128);
/* 100 */     setRotation(this.bShape5, 0.0F, 0.0F, 0.0F);
/* 101 */     this.bShape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 102 */     this.bShape6.func_78789_a(-12.0F, -8.0F, -8.0F, 24, 16, 16);
/* 103 */     this.bShape6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.bShape6.func_78787_b(128, 128);
/* 105 */     setRotation(this.bShape6, 0.0F, 0.0F, 0.0F);
/* 106 */     this.bShape7 = new ModelRenderer((ModelBase)this, 0, 0);
/* 107 */     this.bShape7.func_78789_a(-14.0F, -4.0F, -4.0F, 28, 8, 8);
/* 108 */     this.bShape7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.bShape7.func_78787_b(128, 128);
/* 110 */     setRotation(this.bShape7, 0.0F, 0.0F, 0.0F);
/*     */     
/* 112 */     this.bShape1.func_78792_a(this.bShape2);
/* 113 */     this.bShape1.func_78792_a(this.bShape3);
/* 114 */     this.bShape1.func_78792_a(this.bShape4);
/* 115 */     this.bShape1.func_78792_a(this.bShape5);
/* 116 */     this.bShape1.func_78792_a(this.bShape6);
/* 117 */     this.bShape1.func_78792_a(this.bShape7);
/*     */ 
/*     */     
/* 120 */     this.cShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 121 */     this.cShape1.func_78789_a(-10.0F, -1.0F, -10.0F, 20, 2, 20);
/* 122 */     this.cShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     this.cShape1.func_78787_b(128, 32);
/* 124 */     setRotation(this.cShape1, 0.0F, 0.0F, 0.0F);
/* 125 */     this.cShape2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 126 */     this.cShape2.func_78789_a(-7.0F, -0.5F, -12.0F, 14, 1, 24);
/* 127 */     this.cShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.cShape2.func_78787_b(128, 32);
/* 129 */     setRotation(this.cShape2, 0.0F, 0.0F, 0.0F);
/* 130 */     this.cShape3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 131 */     this.cShape3.func_78789_a(-12.0F, -0.5F, -7.0F, 24, 1, 14);
/* 132 */     this.cShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.cShape3.func_78787_b(128, 32);
/* 134 */     setRotation(this.cShape3, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 137 */     this.cShape1.func_78792_a(this.cShape2);
/* 138 */     this.cShape1.func_78792_a(this.cShape3);
/*     */ 
/*     */     
/* 141 */     this.dShape1 = new ModelRenderer((ModelBase)this, 0, 0);
/* 142 */     this.dShape1.func_78789_a(-1.0F, -1.0F, -10.0F, 2, 2, 20);
/* 143 */     this.dShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.dShape1.func_78787_b(128, 128);
/* 145 */     setRotation(this.dShape1, 0.0F, 0.0F, 0.0F);
/*     */     
/* 147 */     this.eShape1 = new ModelRenderer((ModelBase)this, 0, 8);
/* 148 */     this.eShape1.func_78789_a(-3.0F, -3.0F, -7.0F, 6, 6, 14);
/* 149 */     this.eShape1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.eShape1.func_78787_b(128, 128);
/* 151 */     setRotation(this.eShape1, 0.0F, 0.0F, 0.0F);
/* 152 */     this.eShape2 = new ModelRenderer((ModelBase)this, 0, 8);
/* 153 */     this.eShape2.func_78789_a(-2.0F, -2.0F, -8.0F, 4, 4, 16);
/* 154 */     this.eShape2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.eShape2.func_78787_b(128, 128);
/* 156 */     setRotation(this.eShape2, 0.0F, 0.0F, 0.0F);
/* 157 */     this.eShape3 = new ModelRenderer((ModelBase)this, 0, 8);
/* 158 */     this.eShape3.func_78789_a(-2.0F, -4.0F, -6.0F, 4, 8, 12);
/* 159 */     this.eShape3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 160 */     this.eShape3.func_78787_b(128, 128);
/* 161 */     setRotation(this.eShape3, 0.0F, 0.0F, 0.0F);
/* 162 */     this.eShape4 = new ModelRenderer((ModelBase)this, 0, 8);
/* 163 */     this.eShape4.func_78789_a(-4.0F, -2.0F, -6.0F, 8, 4, 12);
/* 164 */     this.eShape4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 165 */     this.eShape4.func_78787_b(128, 128);
/* 166 */     setRotation(this.eShape4, 0.0F, 0.0F, 0.0F);
/* 167 */     this.eShape5 = new ModelRenderer((ModelBase)this, 0, 0);
/* 168 */     this.eShape5.func_78789_a(6.0F, -3.0F, -5.0F, 1, 6, 1);
/* 169 */     this.eShape5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 170 */     this.eShape5.func_78787_b(128, 128);
/* 171 */     setRotation(this.eShape5, -0.3490659F, 0.0F, 0.0F);
/* 172 */     this.eShape6 = new ModelRenderer((ModelBase)this, 0, 0);
/* 173 */     this.eShape6.func_78789_a(7.0F, -3.0F, -3.0F, 1, 6, 1);
/* 174 */     this.eShape6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.eShape6.func_78787_b(128, 128);
/* 176 */     setRotation(this.eShape6, -0.3490659F, 0.0F, -0.7853982F);
/* 177 */     this.eShape7 = new ModelRenderer((ModelBase)this, 0, 0);
/* 178 */     this.eShape7.func_78789_a(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
/* 179 */     this.eShape7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 180 */     this.eShape7.func_78787_b(128, 128);
/* 181 */     setRotation(this.eShape7, 0.0F, 0.4537856F, 0.0F);
/* 182 */     this.eShape8 = new ModelRenderer((ModelBase)this, 0, 0);
/* 183 */     this.eShape8.func_78789_a(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
/* 184 */     this.eShape8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 185 */     this.eShape8.func_78787_b(128, 128);
/* 186 */     setRotation(this.eShape8, 0.0F, 0.4014257F, -0.7853982F);
/* 187 */     this.eShape9 = new ModelRenderer((ModelBase)this, 0, 0);
/* 188 */     this.eShape9.func_78789_a(-7.0F, -3.0F, 3.0F, 1, 6, 1);
/* 189 */     this.eShape9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 190 */     this.eShape9.func_78787_b(128, 128);
/* 191 */     setRotation(this.eShape9, 0.3490659F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 194 */     this.eShape1.func_78792_a(this.eShape2);
/* 195 */     this.eShape1.func_78792_a(this.eShape3);
/* 196 */     this.eShape1.func_78792_a(this.eShape4);
/* 197 */     this.eShape7.func_78792_a(this.eShape5);
/* 198 */     this.eShape7.func_78792_a(this.eShape6);
/* 199 */     this.eShape7.func_78792_a(this.eShape8);
/* 200 */     this.eShape7.func_78792_a(this.eShape9);
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
/* 212 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 213 */     a.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 218 */     model.field_78795_f = x;
/* 219 */     model.field_78796_g = y;
/* 220 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
/* 226 */     float par3 = f2;
/* 227 */     float par31 = 1.0F;
/*     */     
/* 229 */     this.aShape1.field_78808_h = par3;
/* 230 */     this.aShape2.field_78808_h = par3;
/* 231 */     this.bShape1.field_78808_h = par3;
/* 232 */     this.bShape1.field_78796_g = par3;
/* 233 */     this.bShape1.field_78795_f = par3;
/* 234 */     this.cShape1.field_78796_g = par3;
/* 235 */     this.dShape1.field_78798_e = par3;
/* 236 */     this.dShape1.field_78808_h = par3;
/* 237 */     this.eShape7.field_78808_h = -par3 * 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderModel(byte type, Entity entity, float par8, float par9, float f, float r, boolean b) {
/* 242 */     ModelRenderer render = null;
/* 243 */     if (type == 0) render = b ? this.aShape1 : this.aShape2; 
/* 244 */     if (type == 1) render = this.bShape1; 
/* 245 */     if (type == 2) render = this.cShape1; 
/* 246 */     if (type == 3) render = this.dShape1; 
/* 247 */     if (type == 4) render = this.eShape7;
/*     */     
/* 249 */     render(render, entity, 0.0F, 0.0F, r, par8, par9, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelEnergy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */