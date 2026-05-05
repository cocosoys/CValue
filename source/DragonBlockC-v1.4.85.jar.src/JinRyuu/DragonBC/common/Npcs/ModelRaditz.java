/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class ModelRaditz
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer body;
/*     */   ModelRenderer rightarm;
/*     */   ModelRenderer leftarm;
/*     */   ModelRenderer rightleg;
/*     */   ModelRenderer leftleg;
/*     */   ModelRenderer headhair;
/*     */   ModelRenderer leftarmshoulder;
/*     */   ModelRenderer rightarmshoulder;
/*     */   ModelRenderer cui1;
/*     */   ModelRenderer cui2;
/*     */   ModelRenderer spikes1;
/*     */   ModelRenderer spikes2;
/*     */   ModelRenderer spikes3;
/*     */   ModelRenderer spikes4;
/*     */   ModelRenderer spikes5;
/*     */   ModelRenderer spikes6;
/*     */   ModelRenderer spikes7;
/*     */   ModelRenderer spikes8;
/*     */   ModelRenderer ear1;
/*     */   ModelRenderer ear2;
/*     */   ModelRenderer horn2;
/*     */   ModelRenderer horn1;
/*     */   ModelRenderer appule;
/*     */   ModelRenderer Fhorn2;
/*     */   ModelRenderer Fhorn1;
/*     */   ModelRenderer Fhorn3;
/*     */   ModelRenderer Fhorn4;
/*     */   ModelRenderer F2horn1;
/*     */   ModelRenderer F2horn2;
/*     */   ModelRenderer tail1;
/*     */   ModelRenderer tail2;
/*     */   ModelRenderer body2;
/*     */   ModelRenderer rightarm2;
/*     */   ModelRenderer leftarm2;
/*     */   ModelRenderer rightleg2;
/*     */   ModelRenderer leftleg2;
/*     */   ModelRenderer celltail;
/*     */   ModelRenderer cellhead1;
/*     */   ModelRenderer cellhead2;
/*     */   ModelRenderer cellhead3;
/*     */   ModelRenderer cellhead4;
/*     */   ModelRenderer cell1head;
/*     */   ModelRenderer hair1;
/*     */   ModelRenderer hair2;
/*     */   ModelRenderer cape;
/*     */   ModelRenderer wing;
/*     */   ModelRenderer wing2;
/*     */   ModelRenderer c20;
/*     */   ModelRenderer c19;
/*     */   ModelRenderer puipui1;
/*     */   ModelRenderer puipui2;
/*     */   ModelRenderer puipui3;
/*     */   ModelRenderer puipui4;
/*     */   ModelRenderer Dear1;
/*     */   ModelRenderer Dear2;
/*  83 */   private float F = 1.0F;
/*     */   public ModelRaditz(float f) {
/*  85 */     this();
/*  86 */     this.F = f;
/*     */   }
/*     */   
/*     */   private boolean Y = false;
/*     */   
/*     */   public ModelRaditz(float f, boolean y) {
/*  92 */     this();
/*  93 */     this.F = f;
/*  94 */     this.Y = y;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean Y2 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRaditz(float f, boolean y, boolean y2) {
/* 110 */     this();
/* 111 */     this.F = f;
/* 112 */     this.Y = y;
/* 113 */     this.Y2 = y2;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelRaditz() {
/* 118 */     this.field_78090_t = 128;
/* 119 */     this.field_78089_u = 64;
/*     */     
/* 121 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/* 122 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/* 123 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     this.head.func_78787_b(128, 64);
/* 125 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/* 126 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/* 127 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.body.func_78787_b(128, 64);
/* 129 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/* 130 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/* 131 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 132 */     this.rightarm.func_78787_b(128, 64);
/* 133 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/* 134 */     this.leftarm.field_78809_i = true;
/* 135 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/* 136 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/* 137 */     this.leftarm.func_78787_b(128, 64);
/* 138 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/* 139 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/* 140 */     this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
/* 141 */     this.rightleg.func_78787_b(128, 64);
/* 142 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/* 143 */     this.leftleg.field_78809_i = true;
/* 144 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/* 145 */     this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
/* 146 */     this.leftleg.func_78787_b(128, 64);
/* 147 */     this.headhair = new ModelRenderer((ModelBase)this, 56, 0);
/* 148 */     this.headhair.func_78789_a(-5.0F, -9.0F, -5.0F, 10, 20, 10);
/* 149 */     this.headhair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 150 */     this.headhair.func_78787_b(128, 64);
/* 151 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 152 */     this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6);
/* 153 */     this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 154 */     this.rightarmshoulder.func_78787_b(128, 64);
/* 155 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 156 */     this.leftarmshoulder.field_78809_i = true;
/* 157 */     this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6);
/* 158 */     this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F);
/* 159 */     this.leftarmshoulder.func_78787_b(128, 64);
/* 160 */     this.cui1 = new ModelRenderer((ModelBase)this, 0, 32);
/* 161 */     this.cui1.func_78789_a(2.0F, -9.0F, -3.0F, 3, 3, 3);
/* 162 */     this.cui1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 163 */     this.cui1.func_78787_b(128, 64);
/* 164 */     this.cui1.field_78809_i = true;
/* 165 */     setRotation(this.cui1, 0.0F, 0.0F, 0.0F);
/* 166 */     this.cui2 = new ModelRenderer((ModelBase)this, 0, 32);
/* 167 */     this.cui2.func_78789_a(-5.0F, -9.0F, -3.0F, 3, 3, 3);
/* 168 */     this.cui2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 169 */     this.cui2.func_78787_b(128, 64);
/* 170 */     this.cui2.field_78809_i = true;
/* 171 */     setRotation(this.cui2, 0.0F, 0.0F, 0.0F);
/* 172 */     this.spikes1 = new ModelRenderer((ModelBase)this, 18, 32);
/* 173 */     this.spikes1.func_78789_a(0.0F, -10.0F, 0.0F, 1, 3, 1);
/* 174 */     this.spikes1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 175 */     this.spikes1.func_78787_b(128, 64);
/* 176 */     this.spikes1.field_78809_i = true;
/* 177 */     setRotation(this.spikes1, 0.0F, 0.0F, 0.0F);
/* 178 */     this.spikes2 = new ModelRenderer((ModelBase)this, 18, 32);
/* 179 */     this.spikes2.func_78789_a(3.0F, -10.0F, 1.0F, 1, 3, 1);
/* 180 */     this.spikes2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 181 */     this.spikes2.func_78787_b(128, 64);
/* 182 */     this.spikes2.field_78809_i = true;
/* 183 */     setRotation(this.spikes2, 0.0F, 0.0F, 0.0F);
/* 184 */     this.spikes3 = new ModelRenderer((ModelBase)this, 18, 32);
/* 185 */     this.spikes3.func_78789_a(2.0F, -10.0F, -3.0F, 1, 3, 1);
/* 186 */     this.spikes3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 187 */     this.spikes3.func_78787_b(128, 64);
/* 188 */     this.spikes3.field_78809_i = true;
/* 189 */     setRotation(this.spikes3, 0.0F, 0.0F, 0.0F);
/* 190 */     this.spikes4 = new ModelRenderer((ModelBase)this, 18, 32);
/* 191 */     this.spikes4.func_78789_a(-2.0F, -10.0F, -2.0F, 1, 3, 1);
/* 192 */     this.spikes4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 193 */     this.spikes4.func_78787_b(128, 64);
/* 194 */     this.spikes4.field_78809_i = true;
/* 195 */     setRotation(this.spikes4, 0.0F, 0.0F, 0.0F);
/* 196 */     this.spikes5 = new ModelRenderer((ModelBase)this, 18, 32);
/* 197 */     this.spikes5.func_78789_a(-3.0F, -10.0F, 2.0F, 1, 3, 1);
/* 198 */     this.spikes5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 199 */     this.spikes5.func_78787_b(128, 64);
/* 200 */     this.spikes5.field_78809_i = true;
/* 201 */     setRotation(this.spikes5, 0.0F, 0.0F, 0.0F);
/* 202 */     this.spikes6 = new ModelRenderer((ModelBase)this, 18, 32);
/* 203 */     this.spikes6.func_78789_a(1.0F, -10.0F, 3.0F, 1, 3, 1);
/* 204 */     this.spikes6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 205 */     this.spikes6.func_78787_b(128, 64);
/* 206 */     this.spikes6.field_78809_i = true;
/* 207 */     setRotation(this.spikes6, 0.0F, 0.0F, 0.0F);
/* 208 */     this.spikes7 = new ModelRenderer((ModelBase)this, 18, 32);
/* 209 */     this.spikes7.func_78789_a(-1.0F, -10.0F, -4.0F, 1, 3, 1);
/* 210 */     this.spikes7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 211 */     this.spikes7.func_78787_b(128, 64);
/* 212 */     this.spikes7.field_78809_i = true;
/* 213 */     setRotation(this.spikes7, 0.0F, 0.0F, 0.0F);
/* 214 */     this.spikes8 = new ModelRenderer((ModelBase)this, 18, 32);
/* 215 */     this.spikes8.func_78789_a(-4.0F, -10.0F, -1.0F, 1, 3, 1);
/* 216 */     this.spikes8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 217 */     this.spikes8.func_78787_b(128, 64);
/* 218 */     this.spikes8.field_78809_i = true;
/* 219 */     setRotation(this.spikes8, 0.0F, 0.0F, 0.0F);
/* 220 */     this.ear1 = new ModelRenderer((ModelBase)this, 12, 32);
/* 221 */     this.ear1.func_78789_a(-5.0F, -5.0F, -3.0F, 1, 3, 2);
/* 222 */     this.ear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 223 */     this.ear1.func_78787_b(128, 64);
/* 224 */     this.ear1.field_78809_i = true;
/* 225 */     setRotation(this.ear1, -0.4014257F, 0.0F, 0.0F);
/* 226 */     this.ear2 = new ModelRenderer((ModelBase)this, 12, 32);
/* 227 */     this.ear2.func_78789_a(4.0F, -5.0F, -3.0F, 1, 3, 2);
/* 228 */     this.ear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 229 */     this.ear2.func_78787_b(128, 64);
/* 230 */     this.ear2.field_78809_i = true;
/* 231 */     setRotation(this.ear2, -0.4014257F, 0.0F, 0.0F);
/* 232 */     this.horn2 = new ModelRenderer((ModelBase)this, 0, 38);
/* 233 */     this.horn2.func_78789_a(-2.5F, -11.0F, -3.5F, 2, 4, 2);
/* 234 */     this.horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 235 */     this.horn2.func_78787_b(128, 64);
/* 236 */     this.horn2.field_78809_i = true;
/* 237 */     setRotation(this.horn2, 0.0F, 0.0F, -0.2094395F);
/* 238 */     this.horn1 = new ModelRenderer((ModelBase)this, 0, 38);
/* 239 */     this.horn1.func_78789_a(0.5F, -11.0F, -3.5F, 2, 4, 2);
/* 240 */     this.horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 241 */     this.horn1.func_78787_b(128, 64);
/* 242 */     this.horn1.field_78809_i = true;
/* 243 */     setRotation(this.horn1, 0.0F, 0.0F, 0.2094395F);
/* 244 */     this.appule = new ModelRenderer((ModelBase)this, 0, 48);
/* 245 */     this.appule.func_78789_a(-4.0F, -8.0F, 4.0F, 8, 8, 8);
/* 246 */     this.appule.func_78793_a(0.0F, 0.0F, 0.0F);
/* 247 */     this.appule.func_78787_b(128, 64);
/* 248 */     this.appule.field_78809_i = true;
/* 249 */     setRotation(this.appule, 0.0F, 0.0F, 0.0F);
/* 250 */     this.Fhorn2 = new ModelRenderer((ModelBase)this, 8, 38);
/* 251 */     this.Fhorn2.func_78789_a(1.5F, -11.0F, -3.5F, 2, 4, 2);
/* 252 */     this.Fhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 253 */     this.Fhorn2.func_78787_b(128, 64);
/* 254 */     this.Fhorn2.field_78809_i = true;
/* 255 */     setRotation(this.Fhorn2, 0.0F, 0.0F, -0.7853982F);
/* 256 */     this.Fhorn1 = new ModelRenderer((ModelBase)this, 8, 38);
/* 257 */     this.Fhorn1.func_78789_a(-3.5F, -11.0F, -3.5F, 2, 4, 2);
/* 258 */     this.Fhorn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 259 */     this.Fhorn1.func_78787_b(128, 64);
/* 260 */     this.Fhorn1.field_78809_i = true;
/* 261 */     setRotation(this.Fhorn1, 0.0F, 0.0F, 0.7853982F);
/* 262 */     this.Fhorn3 = new ModelRenderer((ModelBase)this, 8, 38);
/* 263 */     this.Fhorn3.func_78789_a(2.5F, -14.0F, -3.5F, 2, 4, 2);
/* 264 */     this.Fhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 265 */     this.Fhorn3.func_78787_b(128, 64);
/* 266 */     this.Fhorn3.field_78809_i = true;
/* 267 */     setRotation(this.Fhorn3, 0.0F, 0.0F, 0.2094395F);
/* 268 */     this.Fhorn4 = new ModelRenderer((ModelBase)this, 8, 38);
/* 269 */     this.Fhorn4.func_78789_a(-4.5F, -14.0F, -3.5F, 2, 4, 2);
/* 270 */     this.Fhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 271 */     this.Fhorn4.func_78787_b(128, 64);
/* 272 */     this.Fhorn4.field_78809_i = true;
/* 273 */     setRotation(this.Fhorn4, 0.0F, 0.0F, -0.2094395F);
/* 274 */     this.F2horn1 = new ModelRenderer((ModelBase)this, 16, 38);
/* 275 */     this.F2horn1.func_78789_a(-3.5F, -11.0F, 6.5F, 2, 4, 2);
/* 276 */     this.F2horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 277 */     this.F2horn1.func_78787_b(128, 64);
/* 278 */     this.F2horn1.field_78809_i = true;
/* 279 */     setRotation(this.F2horn1, 0.0F, 0.0F, 0.7853982F);
/* 280 */     this.F2horn2 = new ModelRenderer((ModelBase)this, 16, 38);
/* 281 */     this.F2horn2.func_78789_a(1.5F, -11.0F, 6.5F, 2, 4, 2);
/* 282 */     this.F2horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 283 */     this.F2horn2.func_78787_b(128, 64);
/* 284 */     this.F2horn2.field_78809_i = true;
/* 285 */     setRotation(this.F2horn2, 0.0F, 0.0F, -0.7853982F);
/* 286 */     this.tail1 = new ModelRenderer((ModelBase)this, 32, 48);
/* 287 */     this.tail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12);
/* 288 */     this.tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 289 */     this.tail1.func_78787_b(128, 64);
/* 290 */     this.tail1.field_78809_i = true;
/* 291 */     setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
/* 292 */     this.tail2 = new ModelRenderer((ModelBase)this, 32, 48);
/* 293 */     this.tail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12);
/* 294 */     this.tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 295 */     this.tail2.func_78787_b(128, 64);
/* 296 */     this.tail2.field_78809_i = true;
/* 297 */     setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 299 */     this.celltail = new ModelRenderer((ModelBase)this, 32, 48);
/* 300 */     this.celltail.func_78789_a(-0.5F, 16.5F, 14.0F, 1, 1, 4);
/* 301 */     this.celltail.func_78793_a(0.0F, 0.0F, 0.0F);
/* 302 */     this.celltail.func_78787_b(128, 64);
/*     */     
/* 304 */     this.cellhead1 = new ModelRenderer((ModelBase)this, 108, 50);
/* 305 */     this.cellhead1.func_78789_a(-2.5F, -14.0F, -3.5F, 3, 7, 7);
/* 306 */     this.cellhead1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 307 */     this.cellhead1.func_78787_b(128, 64);
/* 308 */     setRotation(this.cellhead1, 0.0F, 0.0F, -0.2094395F);
/* 309 */     this.cellhead3 = new ModelRenderer((ModelBase)this, 108, 50);
/* 310 */     this.cellhead3.func_78789_a(-2.5F, -10.0F, -3.5F, 3, 3, 7);
/* 311 */     this.cellhead3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 312 */     this.cellhead3.func_78787_b(128, 64);
/* 313 */     setRotation(this.cellhead3, 0.0F, 0.0F, -0.2094395F);
/* 314 */     this.cellhead2 = new ModelRenderer((ModelBase)this, 108, 50);
/* 315 */     this.cellhead2.field_78809_i = true;
/* 316 */     this.cellhead2.func_78789_a(-0.5F, -14.0F, -3.5F, 3, 7, 7);
/* 317 */     this.cellhead2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 318 */     this.cellhead2.func_78787_b(128, 64);
/* 319 */     setRotation(this.cellhead2, 0.0F, 0.0F, 0.2094395F);
/* 320 */     this.cellhead4 = new ModelRenderer((ModelBase)this, 108, 50);
/* 321 */     this.cellhead4.field_78809_i = true;
/* 322 */     this.cellhead4.func_78789_a(-0.5F, -10.0F, -3.5F, 3, 3, 7);
/* 323 */     this.cellhead4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 324 */     this.cellhead4.func_78787_b(128, 64);
/* 325 */     setRotation(this.cellhead4, 0.0F, 0.0F, 0.2094395F);
/* 326 */     this.cell1head = new ModelRenderer((ModelBase)this, 108, 44);
/* 327 */     this.cell1head.func_78789_a(-5.0F, -10.0F, -6.5F, 10, 4, 2);
/* 328 */     this.cell1head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 329 */     this.cell1head.func_78787_b(128, 64);
/* 330 */     setRotation(this.cell1head, -0.3490659F, 0.0F, 0.0F);
/* 331 */     this.hair1 = new ModelRenderer((ModelBase)this, 82, 47);
/* 332 */     this.hair1.func_78789_a(2.0F, -8.0F, -4.5F, 4, 8, 9);
/* 333 */     this.hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 334 */     this.hair1.func_78787_b(128, 64);
/* 335 */     setRotation(this.hair1, 0.0F, 0.0174533F, -0.2617994F);
/* 336 */     this.hair2 = new ModelRenderer((ModelBase)this, 82, 47);
/* 337 */     this.hair2.field_78809_i = true;
/* 338 */     this.hair2.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9);
/* 339 */     this.hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 340 */     this.hair2.func_78787_b(128, 64);
/* 341 */     setRotation(this.hair2, 0.0F, 0.0F, 0.2617994F);
/* 342 */     this.cape = new ModelRenderer((ModelBase)this, 100, 0);
/* 343 */     this.cape.func_78789_a(-7.0F, 1.0F, 2.0F, 14, 20, 0);
/* 344 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/* 345 */     this.cape.func_78787_b(128, 64);
/* 346 */     setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
/* 347 */     this.wing = new ModelRenderer((ModelBase)this, 114, 20);
/* 348 */     this.wing.func_78789_a(-1.0F, 2.0F, 2.0F, 7, 20, 0);
/* 349 */     this.wing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 350 */     this.wing.func_78787_b(128, 64);
/* 351 */     setRotation(this.wing, 0.1570796F, 0.0349066F, -0.2792527F);
/* 352 */     this.wing2 = new ModelRenderer((ModelBase)this, 114, 20);
/* 353 */     this.wing2.field_78809_i = true;
/* 354 */     this.wing2.func_78789_a(-6.0F, 2.0F, 2.0F, 7, 20, 0);
/* 355 */     this.wing2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 356 */     this.wing2.func_78787_b(128, 64);
/* 357 */     setRotation(this.wing2, 0.1570796F, -0.0349066F, 0.2792527F);
/*     */     
/* 359 */     this.c20 = new ModelRenderer((ModelBase)this, 76, 35);
/* 360 */     this.c20.func_78789_a(-4.0F, -12.0F, -4.0F, 8, 4, 8);
/* 361 */     this.c20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 362 */     this.c20.func_78787_b(128, 64);
/* 363 */     this.c20.field_78809_i = true;
/* 364 */     setRotation(this.c20, 0.0F, 0.0F, 0.0F);
/* 365 */     this.c19 = new ModelRenderer((ModelBase)this, 106, 29);
/* 366 */     this.c19.func_78789_a(-1.0F, -11.0F, -0.5F, 2, 4, 2);
/* 367 */     this.c19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 368 */     this.c19.func_78787_b(128, 64);
/* 369 */     this.c19.field_78809_i = true;
/* 370 */     setRotation(this.c19, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 373 */     this.puipui1 = new ModelRenderer((ModelBase)this, 53, 48);
/* 374 */     this.puipui1.func_78789_a(0.5F, -8.0F, 2.5F, 2, 8, 2);
/* 375 */     this.puipui1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 376 */     this.puipui1.func_78787_b(128, 64);
/* 377 */     setRotation(this.puipui1, -1.047198F, 0.4363323F, 0.0F);
/* 378 */     this.puipui2 = new ModelRenderer((ModelBase)this, 53, 48);
/* 379 */     this.puipui2.func_78789_a(-2.5F, -8.0F, 2.5F, 2, 8, 2);
/* 380 */     this.puipui2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 381 */     this.puipui2.func_78787_b(128, 64);
/* 382 */     setRotation(this.puipui2, -1.047198F, -0.4363323F, 0.0F);
/* 383 */     this.puipui3 = new ModelRenderer((ModelBase)this, 53, 48);
/* 384 */     this.puipui3.func_78789_a(0.5F, -12.4F, -0.3F, 2, 4, 2);
/* 385 */     this.puipui3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 386 */     this.puipui3.func_78787_b(128, 64);
/* 387 */     setRotation(this.puipui3, -1.396263F, 0.4380776F, 0.0F);
/* 388 */     this.puipui4 = new ModelRenderer((ModelBase)this, 53, 48);
/* 389 */     this.puipui4.func_78789_a(-2.5F, -12.4F, -0.3F, 2, 4, 2);
/* 390 */     this.puipui4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 391 */     this.puipui4.func_78787_b(128, 64);
/* 392 */     setRotation(this.puipui4, -1.396263F, -0.4380776F, 0.0F);
/*     */     
/* 394 */     this.Dear1 = new ModelRenderer((ModelBase)this, 22, 29);
/* 395 */     this.Dear1.func_78789_a(-3.0F, -9.0F, -2.0F, 0, 6, 3);
/* 396 */     this.Dear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 397 */     setRotation(this.Dear1, -0.6981317F, -1.047198F, 0.0F);
/* 398 */     this.Dear2 = new ModelRenderer((ModelBase)this, 22, 29);
/* 399 */     this.Dear2.func_78789_a(3.0F, -9.0F, -2.0F, 0, 6, 3);
/* 400 */     this.Dear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 401 */     this.Dear2.field_78809_i = true;
/* 402 */     setRotation(this.Dear2, -0.6981317F, 1.047198F, 0.0F);
/*     */     
/* 404 */     this.body.func_78792_a(this.puipui1);
/* 405 */     this.body.func_78792_a(this.puipui2);
/* 406 */     this.body.func_78792_a(this.puipui3);
/* 407 */     this.body.func_78792_a(this.puipui4);
/* 408 */     this.head.func_78792_a(this.Dear1);
/* 409 */     this.head.func_78792_a(this.Dear2);
/*     */     
/* 411 */     this.head.func_78792_a(this.hair2);
/* 412 */     this.head.func_78792_a(this.hair1);
/* 413 */     this.head.func_78792_a(this.cell1head);
/*     */     
/* 415 */     this.head.func_78792_a(this.cellhead1);
/* 416 */     this.head.func_78792_a(this.cellhead2);
/* 417 */     this.head.func_78792_a(this.c20);
/* 418 */     this.head.func_78792_a(this.c19);
/* 419 */     this.tail2.func_78792_a(this.celltail);
/* 420 */     this.body.func_78792_a(this.wing);
/* 421 */     this.body.func_78792_a(this.wing2);
/* 422 */     this.body.func_78792_a(this.cape);
/*     */     
/* 424 */     this.head.func_78792_a(this.cui1);
/* 425 */     this.head.func_78792_a(this.cui2);
/* 426 */     this.head.func_78792_a(this.spikes1);
/* 427 */     this.head.func_78792_a(this.spikes2);
/* 428 */     this.head.func_78792_a(this.spikes3);
/* 429 */     this.head.func_78792_a(this.spikes4);
/* 430 */     this.head.func_78792_a(this.spikes5);
/* 431 */     this.head.func_78792_a(this.spikes6);
/* 432 */     this.head.func_78792_a(this.spikes7);
/* 433 */     this.head.func_78792_a(this.spikes8);
/* 434 */     this.head.func_78792_a(this.ear1);
/* 435 */     this.head.func_78792_a(this.ear2);
/* 436 */     this.head.func_78792_a(this.horn2);
/* 437 */     this.head.func_78792_a(this.horn1);
/* 438 */     this.head.func_78792_a(this.appule);
/* 439 */     this.head.func_78792_a(this.Fhorn2);
/* 440 */     this.head.func_78792_a(this.Fhorn1);
/* 441 */     this.head.func_78792_a(this.Fhorn3);
/* 442 */     this.head.func_78792_a(this.Fhorn4);
/* 443 */     this.head.func_78792_a(this.F2horn1);
/* 444 */     this.head.func_78792_a(this.F2horn2);
/* 445 */     this.body.func_78792_a(this.tail1);
/* 446 */     this.body.func_78792_a(this.tail2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 452 */     model.field_78795_f = x;
/* 453 */     model.field_78796_g = y;
/* 454 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 460 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 461 */     GL11.glPushMatrix();
/* 462 */     GL11.glScalef(this.F, this.F, this.F);
/*     */     
/* 464 */     if (!this.Y2) {
/* 465 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 466 */       if (this.Y) GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F * 3.65F, 0.0F);
/*     */     
/*     */     } else {
/* 469 */       float ff1 = -2.45F;
/* 470 */       float ff2 = 0.6F;
/* 471 */       float diff = ff2 / this.F * ff1;
/* 472 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * diff, 0.0F);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 479 */     this.head.func_78785_a(f5);
/* 480 */     if (this.Y) GL11.glScalef(this.F, this.F, this.F); 
/* 481 */     this.body.func_78785_a(f5);
/* 482 */     this.rightarm.func_78785_a(f5);
/* 483 */     this.leftarm.func_78785_a(f5);
/* 484 */     this.rightleg.func_78785_a(f5);
/* 485 */     this.leftleg.func_78785_a(f5);
/* 486 */     this.headhair.func_78785_a(f5);
/* 487 */     this.leftarmshoulder.func_78785_a(f5);
/* 488 */     this.rightarmshoulder.func_78785_a(f5);
/* 489 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 494 */     this.head.field_78796_g = par4 / 57.295776F;
/* 495 */     this.head.field_78795_f = par5 / 57.295776F;
/* 496 */     this.headhair.field_78796_g = this.head.field_78796_g;
/* 497 */     this.headhair.field_78795_f = this.head.field_78795_f;
/* 498 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 499 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 500 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 501 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 502 */     this.rightarm.field_78808_h = 0.0F;
/* 503 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 504 */     this.leftarm.field_78808_h = 0.0F;
/* 505 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 506 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 507 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 508 */     this.rightleg.field_78796_g = 0.0F;
/* 509 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 511 */     if (this.field_78093_q) {
/*     */       
/* 513 */       this.rightarm.field_78795_f += -0.62831855F;
/* 514 */       this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 515 */       this.leftarm.field_78795_f += -0.62831855F;
/* 516 */       this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 517 */       this.rightleg.field_78795_f = -1.2566371F;
/* 518 */       this.leftleg.field_78795_f = -1.2566371F;
/* 519 */       this.rightleg.field_78796_g = 0.31415927F;
/* 520 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 523 */     this.rightarm.field_78796_g = 0.0F;
/* 524 */     this.rightarmshoulder.field_78796_g = this.rightarm.field_78796_g;
/* 525 */     this.leftarm.field_78796_g = 0.0F;
/* 526 */     this.leftarmshoulder.field_78796_g = this.leftarm.field_78796_g;
/*     */ 
/*     */ 
/*     */     
/* 530 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 532 */       float var8 = this.field_78095_p;
/* 533 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 534 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 535 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 536 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 537 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 538 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 539 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 540 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 541 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 542 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 543 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 544 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 545 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g;
/* 546 */       this.leftarmshoulder.field_78796_g += this.body.field_78796_g;
/* 547 */       this.leftarmshoulder.field_78795_f += this.body.field_78796_g;
/* 548 */       var8 = 1.0F - this.field_78095_p;
/* 549 */       var8 *= var8;
/* 550 */       var8 *= var8;
/* 551 */       var8 = 1.0F - var8;
/* 552 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 553 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 554 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 555 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 556 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/* 557 */       this.rightarmshoulder.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 558 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g * 2.0F;
/* 559 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 563 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 564 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 565 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 566 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 567 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 568 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 569 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 570 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRaditz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */