/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class ModelKB extends ModelBase {
/*   8 */   private int type = 0;
/*     */   
/*     */   public ModelRenderer KiBlade1;
/*     */   
/*     */   public ModelRenderer KiBlade2;
/*     */   
/*     */   public ModelRenderer KiBlade3;
/*     */   
/*     */   public ModelRenderer KiBlade4;
/*     */   
/*     */   public ModelRenderer BaseHandle4;
/*     */   
/*     */   public ModelRenderer HandleBump4;
/*     */   
/*     */   public ModelRenderer BottomSpike1;
/*     */   
/*     */   public ModelRenderer Handle1;
/*     */   
/*     */   public ModelRenderer EdgeBase;
/*     */   
/*     */   public ModelRenderer BottomSpike2;
/*     */   
/*     */   public ModelRenderer HandleBump1;
/*     */   
/*     */   public ModelRenderer Handle2;
/*     */   
/*     */   public ModelRenderer HandleBump2;
/*     */   
/*     */   public ModelRenderer Handle3;
/*     */   
/*     */   public ModelRenderer HandleBump3;
/*     */   
/*     */   public ModelRenderer TopSpike1;
/*     */   
/*     */   public ModelRenderer Edge1;
/*     */   
/*     */   public ModelRenderer TopSpike2;
/*     */   
/*     */   public ModelRenderer Edge2;
/*     */   
/*     */   public ModelRenderer Edge3;
/*     */   
/*     */   public ModelRenderer Edge11;
/*     */   public ModelRenderer Edge33;
/*     */   public ModelRenderer Edge22;
/*     */   public ModelRenderer Edge4;
/*     */   public ModelRenderer Edge5;
/*     */   public ModelRenderer Edge6;
/*     */   public ModelRenderer Edge7;
/*     */   
/*     */   public ModelKB() {
/*  59 */     this.field_78090_t = 64;
/*  60 */     this.field_78089_u = 32;
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
/*  77 */     this.KiBlade4 = new ModelRenderer(this, 4, 22);
/*  78 */     this.KiBlade4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.KiBlade4.func_78790_a(-1.0F, 13.9F, -1.0F, 2, 2, 2, 0.0F);
/*  80 */     this.KiBlade2 = new ModelRenderer(this, 1, 9);
/*  81 */     this.KiBlade2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.KiBlade2.func_78790_a(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F);
/*  83 */     this.KiBlade1 = new ModelRenderer(this, 0, 0);
/*  84 */     this.KiBlade1.func_78793_a(0.0F, 2.0F, 0.0F);
/*  85 */     this.KiBlade1.func_78790_a(-2.5F, 7.2F, -2.5F, 5, 3, 5, 0.0F);
/*  86 */     this.KiBlade3 = new ModelRenderer(this, 2, 16);
/*  87 */     this.KiBlade3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.KiBlade3.func_78790_a(-1.5F, 12.0F, -1.5F, 3, 2, 3, 0.0F);
/*  89 */     this.KiBlade3.func_78792_a(this.KiBlade4);
/*  90 */     this.KiBlade1.func_78792_a(this.KiBlade2);
/*  91 */     this.KiBlade2.func_78792_a(this.KiBlade3);
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
/* 172 */     this.HandleBump1 = new ModelRenderer(this, 15, 10);
/* 173 */     this.HandleBump1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 174 */     this.HandleBump1.func_78790_a(-1.5F, -18.0F, -1.5F, 3, 1, 3, 0.0F);
/* 175 */     this.Edge3 = new ModelRenderer(this, 50, 14);
/* 176 */     this.Edge3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.Edge3.func_78790_a(23.3F, -26.8F, -0.5F, 6, 6, 1, 0.0F);
/* 178 */     this.Edge11 = new ModelRenderer(this, 48, 30);
/* 179 */     this.Edge11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 180 */     this.Edge11.func_78790_a(8.3F, -25.2F, -0.5F, 4, 1, 1, 0.0F);
/* 181 */     this.BaseHandle4 = new ModelRenderer(this, 1, 10);
/* 182 */     this.BaseHandle4.func_78793_a(0.0F, -4.1F, 0.0F);
/* 183 */     this.BaseHandle4.func_78790_a(-1.0F, -1.8F, -1.0F, 2, 20, 2, 0.0F);
/* 184 */     this.Handle2 = new ModelRenderer(this, 17, 0);
/* 185 */     this.Handle2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 186 */     this.Handle2.func_78790_a(-1.0F, -17.1F, -1.0F, 2, 7, 2, 0.0F);
/* 187 */     this.HandleBump4 = new ModelRenderer(this, 15, 10);
/* 188 */     this.HandleBump4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 189 */     this.HandleBump4.func_78790_a(-1.5F, 18.0F, -1.5F, 3, 1, 3, 0.0F);
/* 190 */     this.Edge7 = new ModelRenderer(this, 30, 24);
/* 191 */     this.Edge7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 192 */     this.Edge7.func_78790_a(33.5F, -3.2F, -0.5F, 3, 7, 1, 0.0F);
/* 193 */     this.Handle1 = new ModelRenderer(this, 17, 0);
/* 194 */     this.Handle1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 195 */     this.Handle1.func_78790_a(-1.0F, -24.9F, -1.0F, 2, 7, 2, 0.0F);
/* 196 */     this.EdgeBase = new ModelRenderer(this, 0, 0);
/* 197 */     this.EdgeBase.func_78793_a(0.0F, 0.0F, 0.0F);
/* 198 */     this.EdgeBase.func_78790_a(-1.5F, -31.6F, -1.5F, 3, 7, 3, 0.0F);
/* 199 */     this.Edge2 = new ModelRenderer(this, 40, 7);
/* 200 */     this.Edge2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 201 */     this.Edge2.func_78790_a(12.3F, -29.3F, -0.5F, 11, 6, 1, 0.0F);
/* 202 */     this.Edge4 = new ModelRenderer(this, 48, 21);
/* 203 */     this.Edge4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 204 */     this.Edge4.func_78790_a(27.0F, -20.9F, -0.5F, 7, 4, 1, 0.0F);
/* 205 */     this.Edge5 = new ModelRenderer(this, 36, 16);
/* 206 */     this.Edge5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 207 */     this.Edge5.func_78790_a(30.1F, -17.0F, -0.5F, 5, 7, 1, 0.0F);
/* 208 */     this.Edge6 = new ModelRenderer(this, 38, 24);
/* 209 */     this.Edge6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 210 */     this.Edge6.func_78790_a(32.0F, -10.1F, -0.5F, 4, 7, 1, 0.0F);
/* 211 */     this.Edge33 = new ModelRenderer(this, 48, 26);
/* 212 */     this.Edge33.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.Edge33.func_78790_a(29.3F, -23.8F, -0.5F, 3, 3, 1, 0.0F);
/* 214 */     this.BottomSpike1 = new ModelRenderer(this, 28, 12);
/* 215 */     this.BottomSpike1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 216 */     this.BottomSpike1.func_78790_a(-1.0F, 18.9F, -1.0F, 2, 4, 2, 0.0F);
/* 217 */     this.TopSpike1 = new ModelRenderer(this, 28, 5);
/* 218 */     this.TopSpike1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 219 */     this.TopSpike1.func_78790_a(-1.0F, -35.5F, -1.0F, 2, 4, 2, 0.0F);
/* 220 */     this.Edge1 = new ModelRenderer(this, 40, 0);
/* 221 */     this.Edge1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 222 */     this.Edge1.func_78790_a(1.4F, -31.0F, -0.5F, 11, 6, 1, 0.0F);
/* 223 */     this.BottomSpike2 = new ModelRenderer(this, 29, 19);
/* 224 */     this.BottomSpike2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 225 */     this.BottomSpike2.func_78790_a(-0.5F, 22.7F, -0.5F, 1, 3, 1, 0.0F);
/* 226 */     this.Handle3 = new ModelRenderer(this, 17, 0);
/* 227 */     this.Handle3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 228 */     this.Handle3.func_78790_a(-1.0F, -9.4F, -1.0F, 2, 7, 2, 0.0F);
/* 229 */     this.Edge22 = new ModelRenderer(this, 48, 30);
/* 230 */     this.Edge22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 231 */     this.Edge22.func_78790_a(19.4F, -23.4F, -0.5F, 4, 1, 1, 0.0F);
/* 232 */     this.HandleBump2 = new ModelRenderer(this, 15, 10);
/* 233 */     this.HandleBump2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 234 */     this.HandleBump2.func_78790_a(-1.5F, -10.3F, -1.5F, 3, 1, 3, 0.0F);
/* 235 */     this.HandleBump3 = new ModelRenderer(this, 15, 10);
/* 236 */     this.HandleBump3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 237 */     this.HandleBump3.func_78790_a(-1.5F, -2.6F, -1.5F, 3, 1, 3, 0.0F);
/* 238 */     this.TopSpike2 = new ModelRenderer(this, 29, 0);
/* 239 */     this.TopSpike2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 240 */     this.TopSpike2.func_78790_a(-0.5F, -38.4F, -0.5F, 1, 3, 1, 0.0F);
/* 241 */     this.Handle1.func_78792_a(this.HandleBump1);
/* 242 */     this.Edge2.func_78792_a(this.Edge3);
/* 243 */     this.Edge2.func_78792_a(this.Edge11);
/* 244 */     this.Handle1.func_78792_a(this.Handle2);
/* 245 */     this.BaseHandle4.func_78792_a(this.HandleBump4);
/* 246 */     this.Edge6.func_78792_a(this.Edge7);
/* 247 */     this.BaseHandle4.func_78792_a(this.Handle1);
/* 248 */     this.BaseHandle4.func_78792_a(this.EdgeBase);
/* 249 */     this.Edge1.func_78792_a(this.Edge2);
/* 250 */     this.Edge33.func_78792_a(this.Edge4);
/* 251 */     this.Edge4.func_78792_a(this.Edge5);
/* 252 */     this.Edge5.func_78792_a(this.Edge6);
/* 253 */     this.Edge3.func_78792_a(this.Edge33);
/* 254 */     this.BaseHandle4.func_78792_a(this.BottomSpike1);
/* 255 */     this.EdgeBase.func_78792_a(this.TopSpike1);
/* 256 */     this.EdgeBase.func_78792_a(this.Edge1);
/* 257 */     this.BottomSpike1.func_78792_a(this.BottomSpike2);
/* 258 */     this.Handle2.func_78792_a(this.Handle3);
/* 259 */     this.Edge3.func_78792_a(this.Edge22);
/* 260 */     this.Handle2.func_78792_a(this.HandleBump2);
/* 261 */     this.Handle3.func_78792_a(this.HandleBump3);
/* 262 */     this.TopSpike1.func_78792_a(this.TopSpike2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 270 */     if (this.type == 0) {
/* 271 */       this.KiBlade1.func_78785_a(f5);
/*     */     }
/* 273 */     else if (this.type == 1) {
/* 274 */       this.BaseHandle4.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(float f5, int type) {
/* 279 */     if (type == 0) {
/* 280 */       this.KiBlade1.func_78785_a(f5);
/*     */     }
/* 282 */     else if (type == 1) {
/* 283 */       this.BaseHandle4.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 291 */     modelRenderer.field_78795_f = x;
/* 292 */     modelRenderer.field_78796_g = y;
/* 293 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\ModelKB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */