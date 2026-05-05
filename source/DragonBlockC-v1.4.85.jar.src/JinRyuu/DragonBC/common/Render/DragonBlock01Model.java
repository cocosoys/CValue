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
/*     */ public class DragonBlock01Model
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer starblock;
/*     */   ModelRenderer Shape11;
/*     */   ModelRenderer Shape12;
/*     */   ModelRenderer Shape13;
/*     */   ModelRenderer Shape14;
/*     */   ModelRenderer Shape15;
/*     */   ModelRenderer Shape16;
/*     */   ModelRenderer Shape17;
/*     */   ModelRenderer Shape18;
/*     */   ModelRenderer Shape19;
/*     */   ModelRenderer Shape110;
/*     */   ModelRenderer Shape111;
/*     */   ModelRenderer Shape112;
/*     */   ModelRenderer Shape113;
/*     */   ModelRenderer Shape114;
/*     */   ModelRenderer Shape115;
/*     */   ModelRenderer Shape116;
/*     */   ModelRenderer Shape117;
/*     */   ModelRenderer Shape118;
/*     */   ModelRenderer Shape119;
/*     */   ModelRenderer Shape120;
/*     */   ModelRenderer Shape121;
/*     */   ModelRenderer Shape122;
/*     */   ModelRenderer Shape123;
/*     */   ModelRenderer Shape124;
/*     */   ModelRenderer Shape125;
/*     */   ModelRenderer Shape126;
/*     */   ModelRenderer Shape127;
/*     */   ModelRenderer Shape128;
/*     */   ModelRenderer Shape129;
/*     */   ModelRenderer Shape130;
/*     */   ModelRenderer Shape131;
/*     */   
/*     */   public DragonBlock01Model() {
/*  56 */     this.field_78090_t = 64;
/*  57 */     this.field_78089_u = 32;
/*     */     
/*  59 */     this.starblock = new ModelRenderer(this, 16, 0);
/*  60 */     this.starblock.func_78789_a(-1.0F, -4.0F, -1.0F, 2, 2, 2);
/*  61 */     this.starblock.func_78793_a(0.0F, 24.0F, 0.0F);
/*  62 */     this.starblock.func_78787_b(64, 32);
/*  63 */     this.starblock.field_78809_i = true;
/*  64 */     setRotation(this.starblock, 0.0F, 0.0F, 0.0F);
/*  65 */     this.Shape11 = new ModelRenderer(this, 0, 0);
/*  66 */     this.Shape11.func_78789_a(3.0F, -5.0F, -2.0F, 0, 4, 4);
/*  67 */     this.Shape11.func_78793_a(0.0F, 24.0F, 0.0F);
/*  68 */     this.Shape11.func_78787_b(64, 32);
/*  69 */     this.Shape11.field_78809_i = true;
/*  70 */     setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
/*  71 */     this.Shape12 = new ModelRenderer(this, 0, 0);
/*  72 */     this.Shape12.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 0, 4);
/*  73 */     this.Shape12.func_78793_a(0.0F, 24.0F, 0.0F);
/*  74 */     this.Shape12.func_78787_b(64, 32);
/*  75 */     this.Shape12.field_78809_i = true;
/*  76 */     setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
/*  77 */     this.Shape13 = new ModelRenderer(this, 0, 0);
/*  78 */     this.Shape13.func_78789_a(-2.0F, -5.0F, 3.0F, 4, 4, 0);
/*  79 */     this.Shape13.func_78793_a(0.0F, 24.0F, 0.0F);
/*  80 */     this.Shape13.func_78787_b(64, 32);
/*  81 */     this.Shape13.field_78809_i = true;
/*  82 */     setRotation(this.Shape13, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Shape14 = new ModelRenderer(this, 0, 0);
/*  84 */     this.Shape14.func_78789_a(-3.0F, -5.0F, -2.0F, 0, 4, 4);
/*  85 */     this.Shape14.func_78793_a(0.0F, 24.0F, 0.0F);
/*  86 */     this.Shape14.func_78787_b(64, 32);
/*  87 */     this.Shape14.field_78809_i = true;
/*  88 */     setRotation(this.Shape14, 0.0F, 0.0F, 0.0F);
/*  89 */     this.Shape15 = new ModelRenderer(this, 0, 0);
/*  90 */     this.Shape15.func_78789_a(-2.0F, -1.0F, 2.0F, 4, 0, 1);
/*  91 */     this.Shape15.func_78793_a(0.0F, 24.0F, 0.0F);
/*  92 */     this.Shape15.func_78787_b(64, 32);
/*  93 */     this.Shape15.field_78809_i = true;
/*  94 */     setRotation(this.Shape15, 0.0F, 0.0F, 0.0F);
/*  95 */     this.Shape16 = new ModelRenderer(this, 0, 0);
/*  96 */     this.Shape16.func_78789_a(-2.0F, -1.0F, 2.0F, 4, 1, 0);
/*  97 */     this.Shape16.func_78793_a(0.0F, 24.0F, 0.0F);
/*  98 */     this.Shape16.func_78787_b(64, 32);
/*  99 */     this.Shape16.field_78809_i = true;
/* 100 */     setRotation(this.Shape16, 0.0F, 0.0F, 0.0F);
/* 101 */     this.Shape17 = new ModelRenderer(this, 0, 0);
/* 102 */     this.Shape17.func_78789_a(2.0F, -6.0F, -2.0F, 0, 1, 4);
/* 103 */     this.Shape17.func_78793_a(0.0F, 24.0F, 0.0F);
/* 104 */     this.Shape17.func_78787_b(64, 32);
/* 105 */     this.Shape17.field_78809_i = true;
/* 106 */     setRotation(this.Shape17, 0.0F, 0.0F, 0.0F);
/* 107 */     this.Shape18 = new ModelRenderer(this, 0, 0);
/* 108 */     this.Shape18.func_78789_a(2.0F, -5.0F, -3.0F, 0, 4, 1);
/* 109 */     this.Shape18.func_78793_a(0.0F, 24.0F, 0.0F);
/* 110 */     this.Shape18.func_78787_b(64, 32);
/* 111 */     this.Shape18.field_78809_i = true;
/* 112 */     setRotation(this.Shape18, 0.0F, 0.0F, 0.0F);
/* 113 */     this.Shape19 = new ModelRenderer(this, 0, 0);
/* 114 */     this.Shape19.func_78789_a(-2.0F, -1.0F, -2.0F, 0, 1, 4);
/* 115 */     this.Shape19.func_78793_a(0.0F, 24.0F, 0.0F);
/* 116 */     this.Shape19.func_78787_b(64, 32);
/* 117 */     this.Shape19.field_78809_i = true;
/* 118 */     setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
/* 119 */     this.Shape110 = new ModelRenderer(this, 0, 0);
/* 120 */     this.Shape110.func_78789_a(2.0F, -1.0F, -2.0F, 0, 1, 4);
/* 121 */     this.Shape110.func_78793_a(0.0F, 24.0F, 0.0F);
/* 122 */     this.Shape110.func_78787_b(64, 32);
/* 123 */     this.Shape110.field_78809_i = true;
/* 124 */     setRotation(this.Shape110, 0.0F, 0.0F, 0.0F);
/* 125 */     this.Shape111 = new ModelRenderer(this, 0, 0);
/* 126 */     this.Shape111.func_78789_a(-3.0F, -5.0F, 2.0F, 1, 4, 0);
/* 127 */     this.Shape111.func_78793_a(0.0F, 24.0F, 0.0F);
/* 128 */     this.Shape111.func_78787_b(64, 32);
/* 129 */     this.Shape111.field_78809_i = true;
/* 130 */     setRotation(this.Shape111, 0.0F, 0.0F, 0.0F);
/* 131 */     this.Shape112 = new ModelRenderer(this, 0, 0);
/* 132 */     this.Shape112.func_78789_a(-2.0F, -6.0F, -2.0F, 4, 1, 0);
/* 133 */     this.Shape112.func_78793_a(0.0F, 24.0F, 0.0F);
/* 134 */     this.Shape112.func_78787_b(64, 32);
/* 135 */     this.Shape112.field_78809_i = true;
/* 136 */     setRotation(this.Shape112, 0.0F, 0.0F, 0.0F);
/* 137 */     this.Shape113 = new ModelRenderer(this, 0, 0);
/* 138 */     this.Shape113.func_78789_a(-2.0F, -6.0F, 2.0F, 4, 1, 0);
/* 139 */     this.Shape113.func_78793_a(0.0F, 24.0F, 0.0F);
/* 140 */     this.Shape113.func_78787_b(64, 32);
/* 141 */     this.Shape113.field_78809_i = true;
/* 142 */     setRotation(this.Shape113, 0.0F, 0.0F, 0.0F);
/* 143 */     this.Shape114 = new ModelRenderer(this, 0, 0);
/* 144 */     this.Shape114.func_78789_a(-2.0F, -6.0F, 2.0F, 4, 1, 0);
/* 145 */     this.Shape114.func_78793_a(0.0F, 24.0F, 0.0F);
/* 146 */     this.Shape114.func_78787_b(64, 32);
/* 147 */     this.Shape114.field_78809_i = true;
/* 148 */     setRotation(this.Shape114, 0.0F, 0.0F, 0.0F);
/* 149 */     this.Shape115 = new ModelRenderer(this, 0, 0);
/* 150 */     this.Shape115.func_78789_a(-2.0F, -1.0F, -2.0F, 4, 1, 0);
/* 151 */     this.Shape115.func_78793_a(0.0F, 24.0F, 0.0F);
/* 152 */     this.Shape115.func_78787_b(64, 32);
/* 153 */     this.Shape115.field_78809_i = true;
/* 154 */     setRotation(this.Shape115, 0.0F, 0.0F, 0.0F);
/* 155 */     this.Shape116 = new ModelRenderer(this, 0, 0);
/* 156 */     this.Shape116.func_78789_a(-2.0F, -6.0F, -2.0F, 0, 1, 4);
/* 157 */     this.Shape116.func_78793_a(0.0F, 24.0F, 0.0F);
/* 158 */     this.Shape116.func_78787_b(64, 32);
/* 159 */     this.Shape116.field_78809_i = true;
/* 160 */     setRotation(this.Shape116, 0.0F, 0.0F, 0.0F);
/* 161 */     this.Shape117 = new ModelRenderer(this, 0, 0);
/* 162 */     this.Shape117.func_78789_a(-2.0F, -5.0F, -3.0F, 0, 4, 1);
/* 163 */     this.Shape117.func_78793_a(0.0F, 24.0F, 0.0F);
/* 164 */     this.Shape117.func_78787_b(64, 32);
/* 165 */     this.Shape117.field_78809_i = true;
/* 166 */     setRotation(this.Shape117, 0.0F, 0.0F, 0.0F);
/* 167 */     this.Shape118 = new ModelRenderer(this, 0, 0);
/* 168 */     this.Shape118.func_78789_a(-2.0F, -5.0F, 2.0F, 0, 4, 1);
/* 169 */     this.Shape118.func_78793_a(0.0F, 24.0F, 0.0F);
/* 170 */     this.Shape118.func_78787_b(64, 32);
/* 171 */     this.Shape118.field_78809_i = true;
/* 172 */     setRotation(this.Shape118, 0.0F, 0.0F, 0.0F);
/* 173 */     this.Shape119 = new ModelRenderer(this, 0, 0);
/* 174 */     this.Shape119.func_78789_a(2.0F, -5.0F, 2.0F, 0, 4, 1);
/* 175 */     this.Shape119.func_78793_a(0.0F, 24.0F, 0.0F);
/* 176 */     this.Shape119.func_78787_b(64, 32);
/* 177 */     this.Shape119.field_78809_i = true;
/* 178 */     setRotation(this.Shape119, 0.0F, 0.0F, 0.0F);
/* 179 */     this.Shape120 = new ModelRenderer(this, 0, 0);
/* 180 */     this.Shape120.func_78789_a(-2.0F, -5.0F, -3.0F, 4, 4, 0);
/* 181 */     this.Shape120.func_78793_a(0.0F, 24.0F, 0.0F);
/* 182 */     this.Shape120.func_78787_b(64, 32);
/* 183 */     this.Shape120.field_78809_i = true;
/* 184 */     setRotation(this.Shape120, 0.0F, 0.0F, 0.0F);
/* 185 */     this.Shape121 = new ModelRenderer(this, 0, 0);
/* 186 */     this.Shape121.func_78789_a(-3.0F, -5.0F, -2.0F, 1, 4, 0);
/* 187 */     this.Shape121.func_78793_a(0.0F, 24.0F, 0.0F);
/* 188 */     this.Shape121.func_78787_b(64, 32);
/* 189 */     this.Shape121.field_78809_i = true;
/* 190 */     setRotation(this.Shape121, 0.0F, 0.0F, 0.0F);
/* 191 */     this.Shape122 = new ModelRenderer(this, 0, 0);
/* 192 */     this.Shape122.func_78789_a(2.0F, -5.0F, -2.0F, 1, 4, 0);
/* 193 */     this.Shape122.func_78793_a(0.0F, 24.0F, 0.0F);
/* 194 */     this.Shape122.func_78787_b(64, 32);
/* 195 */     this.Shape122.field_78809_i = true;
/* 196 */     setRotation(this.Shape122, 0.0F, 0.0F, 0.0F);
/* 197 */     this.Shape123 = new ModelRenderer(this, 0, 0);
/* 198 */     this.Shape123.func_78789_a(2.0F, -5.0F, 2.0F, 1, 4, 0);
/* 199 */     this.Shape123.func_78793_a(0.0F, 24.0F, 0.0F);
/* 200 */     this.Shape123.func_78787_b(64, 32);
/* 201 */     this.Shape123.field_78809_i = true;
/* 202 */     setRotation(this.Shape123, 0.0F, 0.0F, 0.0F);
/* 203 */     this.Shape124 = new ModelRenderer(this, 0, 0);
/* 204 */     this.Shape124.func_78789_a(-2.0F, -6.0F, -2.0F, 4, 0, 4);
/* 205 */     this.Shape124.func_78793_a(0.0F, 24.0F, 0.0F);
/* 206 */     this.Shape124.func_78787_b(64, 32);
/* 207 */     this.Shape124.field_78809_i = true;
/* 208 */     setRotation(this.Shape124, 0.0F, 0.0F, 0.0F);
/* 209 */     this.Shape125 = new ModelRenderer(this, 0, 0);
/* 210 */     this.Shape125.func_78789_a(-3.0F, -5.0F, -2.0F, 1, 0, 4);
/* 211 */     this.Shape125.func_78793_a(0.0F, 24.0F, 0.0F);
/* 212 */     this.Shape125.func_78787_b(64, 32);
/* 213 */     this.Shape125.field_78809_i = true;
/* 214 */     setRotation(this.Shape125, 0.0F, 0.0F, 0.0F);
/* 215 */     this.Shape126 = new ModelRenderer(this, 0, 0);
/* 216 */     this.Shape126.func_78789_a(-3.0F, -1.0F, -2.0F, 1, 0, 4);
/* 217 */     this.Shape126.func_78793_a(0.0F, 24.0F, 0.0F);
/* 218 */     this.Shape126.func_78787_b(64, 32);
/* 219 */     this.Shape126.field_78809_i = true;
/* 220 */     setRotation(this.Shape126, 0.0F, 0.0F, 0.0F);
/* 221 */     this.Shape127 = new ModelRenderer(this, 0, 0);
/* 222 */     this.Shape127.func_78789_a(2.0F, -1.0F, -2.0F, 1, 0, 4);
/* 223 */     this.Shape127.func_78793_a(0.0F, 24.0F, 0.0F);
/* 224 */     this.Shape127.func_78787_b(64, 32);
/* 225 */     this.Shape127.field_78809_i = true;
/* 226 */     setRotation(this.Shape127, 0.0F, 0.0F, 0.0F);
/* 227 */     this.Shape128 = new ModelRenderer(this, 0, 0);
/* 228 */     this.Shape128.func_78789_a(2.0F, -5.0F, -2.0F, 1, 0, 4);
/* 229 */     this.Shape128.func_78793_a(0.0F, 24.0F, 0.0F);
/* 230 */     this.Shape128.func_78787_b(64, 32);
/* 231 */     this.Shape128.field_78809_i = true;
/* 232 */     setRotation(this.Shape128, 0.0F, 0.0F, 0.0F);
/* 233 */     this.Shape129 = new ModelRenderer(this, 0, 0);
/* 234 */     this.Shape129.func_78789_a(-2.0F, -5.0F, 2.0F, 4, 0, 1);
/* 235 */     this.Shape129.func_78793_a(0.0F, 24.0F, 0.0F);
/* 236 */     this.Shape129.func_78787_b(64, 32);
/* 237 */     this.Shape129.field_78809_i = true;
/* 238 */     setRotation(this.Shape129, 0.0F, 0.0F, 0.0F);
/* 239 */     this.Shape130 = new ModelRenderer(this, 0, 0);
/* 240 */     this.Shape130.func_78789_a(-2.0F, -1.0F, -3.0F, 4, 0, 1);
/* 241 */     this.Shape130.func_78793_a(0.0F, 24.0F, 0.0F);
/* 242 */     this.Shape130.func_78787_b(64, 32);
/* 243 */     this.Shape130.field_78809_i = true;
/* 244 */     setRotation(this.Shape130, 0.0F, 0.0F, 0.0F);
/* 245 */     this.Shape131 = new ModelRenderer(this, 0, 0);
/* 246 */     this.Shape131.func_78789_a(-2.0F, -5.0F, -3.0F, 4, 0, 1);
/* 247 */     this.Shape131.func_78793_a(0.0F, 24.0F, 0.0F);
/* 248 */     this.Shape131.func_78787_b(64, 32);
/* 249 */     this.Shape131.field_78809_i = true;
/* 250 */     setRotation(this.Shape131, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 255 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 256 */     this.starblock.func_78785_a(f5);
/* 257 */     this.Shape11.func_78785_a(f5);
/* 258 */     this.Shape12.func_78785_a(f5);
/* 259 */     this.Shape13.func_78785_a(f5);
/* 260 */     this.Shape14.func_78785_a(f5);
/* 261 */     this.Shape15.func_78785_a(f5);
/* 262 */     this.Shape16.func_78785_a(f5);
/* 263 */     this.Shape17.func_78785_a(f5);
/* 264 */     this.Shape18.func_78785_a(f5);
/* 265 */     this.Shape19.func_78785_a(f5);
/* 266 */     this.Shape110.func_78785_a(f5);
/* 267 */     this.Shape111.func_78785_a(f5);
/* 268 */     this.Shape112.func_78785_a(f5);
/* 269 */     this.Shape113.func_78785_a(f5);
/* 270 */     this.Shape114.func_78785_a(f5);
/* 271 */     this.Shape115.func_78785_a(f5);
/* 272 */     this.Shape116.func_78785_a(f5);
/* 273 */     this.Shape117.func_78785_a(f5);
/* 274 */     this.Shape118.func_78785_a(f5);
/* 275 */     this.Shape119.func_78785_a(f5);
/* 276 */     this.Shape120.func_78785_a(f5);
/* 277 */     this.Shape121.func_78785_a(f5);
/* 278 */     this.Shape122.func_78785_a(f5);
/* 279 */     this.Shape123.func_78785_a(f5);
/* 280 */     this.Shape124.func_78785_a(f5);
/* 281 */     this.Shape125.func_78785_a(f5);
/* 282 */     this.Shape126.func_78785_a(f5);
/* 283 */     this.Shape127.func_78785_a(f5);
/* 284 */     this.Shape128.func_78785_a(f5);
/* 285 */     this.Shape129.func_78785_a(f5);
/* 286 */     this.Shape130.func_78785_a(f5);
/* 287 */     this.Shape131.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 292 */     model.field_78795_f = x;
/* 293 */     model.field_78796_g = y;
/* 294 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderModel(float f) {
/* 304 */     func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*     */   }
/*     */   public void render() {
/* 307 */     func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlock01Model.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */