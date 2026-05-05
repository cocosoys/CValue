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
/*     */ public class ModelRaditz2
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
/*  72 */   private float F = 1.0F;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean Y = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public ModelRaditz2(float f, boolean y) {
/*  81 */     this();
/*  82 */     this.F = f;
/*  83 */     this.Y = y;
/*     */   }
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
/*     */   private boolean Y2 = false;
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
/*     */   public ModelRaditz2() {
/* 107 */     this.field_78090_t = 128;
/* 108 */     this.field_78089_u = 64;
/*     */     
/* 110 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/* 111 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/* 112 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.head.func_78787_b(128, 64);
/* 114 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/* 115 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/* 116 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.body.func_78787_b(128, 64);
/* 118 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/* 119 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/* 120 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 121 */     this.rightarm.func_78787_b(128, 64);
/* 122 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/* 123 */     this.leftarm.field_78809_i = true;
/* 124 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/* 125 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/* 126 */     this.leftarm.func_78787_b(128, 64);
/* 127 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/* 128 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/* 129 */     this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
/* 130 */     this.rightleg.func_78787_b(128, 64);
/* 131 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/* 132 */     this.leftleg.field_78809_i = true;
/* 133 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/* 134 */     this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
/* 135 */     this.leftleg.func_78787_b(128, 64);
/* 136 */     this.headhair = new ModelRenderer((ModelBase)this, 56, 0);
/* 137 */     this.headhair.func_78789_a(-5.0F, -9.0F, -5.0F, 10, 20, 10);
/* 138 */     this.headhair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 139 */     this.headhair.func_78787_b(128, 64);
/* 140 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 141 */     this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6);
/* 142 */     this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 143 */     this.rightarmshoulder.func_78787_b(128, 64);
/* 144 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 145 */     this.leftarmshoulder.field_78809_i = true;
/* 146 */     this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6);
/* 147 */     this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F);
/* 148 */     this.leftarmshoulder.func_78787_b(128, 64);
/* 149 */     this.cui1 = new ModelRenderer((ModelBase)this, 0, 32);
/* 150 */     this.cui1.func_78789_a(2.0F, -9.0F, -3.0F, 3, 3, 3);
/* 151 */     this.cui1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.cui1.func_78787_b(128, 64);
/* 153 */     this.cui1.field_78809_i = true;
/* 154 */     setRotation(this.cui1, 0.0F, 0.0F, 0.0F);
/* 155 */     this.cui2 = new ModelRenderer((ModelBase)this, 0, 32);
/* 156 */     this.cui2.func_78789_a(-5.0F, -9.0F, -3.0F, 3, 3, 3);
/* 157 */     this.cui2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.cui2.func_78787_b(128, 64);
/* 159 */     this.cui2.field_78809_i = true;
/* 160 */     setRotation(this.cui2, 0.0F, 0.0F, 0.0F);
/* 161 */     this.spikes1 = new ModelRenderer((ModelBase)this, 18, 32);
/* 162 */     this.spikes1.func_78789_a(0.0F, -10.0F, 0.0F, 1, 3, 1);
/* 163 */     this.spikes1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.spikes1.func_78787_b(128, 64);
/* 165 */     this.spikes1.field_78809_i = true;
/* 166 */     setRotation(this.spikes1, 0.0F, 0.0F, 0.0F);
/* 167 */     this.spikes2 = new ModelRenderer((ModelBase)this, 18, 32);
/* 168 */     this.spikes2.func_78789_a(3.0F, -10.0F, 1.0F, 1, 3, 1);
/* 169 */     this.spikes2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 170 */     this.spikes2.func_78787_b(128, 64);
/* 171 */     this.spikes2.field_78809_i = true;
/* 172 */     setRotation(this.spikes2, 0.0F, 0.0F, 0.0F);
/* 173 */     this.spikes3 = new ModelRenderer((ModelBase)this, 18, 32);
/* 174 */     this.spikes3.func_78789_a(2.0F, -10.0F, -3.0F, 1, 3, 1);
/* 175 */     this.spikes3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 176 */     this.spikes3.func_78787_b(128, 64);
/* 177 */     this.spikes3.field_78809_i = true;
/* 178 */     setRotation(this.spikes3, 0.0F, 0.0F, 0.0F);
/* 179 */     this.spikes4 = new ModelRenderer((ModelBase)this, 18, 32);
/* 180 */     this.spikes4.func_78789_a(-2.0F, -10.0F, -2.0F, 1, 3, 1);
/* 181 */     this.spikes4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.spikes4.func_78787_b(128, 64);
/* 183 */     this.spikes4.field_78809_i = true;
/* 184 */     setRotation(this.spikes4, 0.0F, 0.0F, 0.0F);
/* 185 */     this.spikes5 = new ModelRenderer((ModelBase)this, 18, 32);
/* 186 */     this.spikes5.func_78789_a(-3.0F, -10.0F, 2.0F, 1, 3, 1);
/* 187 */     this.spikes5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 188 */     this.spikes5.func_78787_b(128, 64);
/* 189 */     this.spikes5.field_78809_i = true;
/* 190 */     setRotation(this.spikes5, 0.0F, 0.0F, 0.0F);
/* 191 */     this.spikes6 = new ModelRenderer((ModelBase)this, 18, 32);
/* 192 */     this.spikes6.func_78789_a(1.0F, -10.0F, 3.0F, 1, 3, 1);
/* 193 */     this.spikes6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 194 */     this.spikes6.func_78787_b(128, 64);
/* 195 */     this.spikes6.field_78809_i = true;
/* 196 */     setRotation(this.spikes6, 0.0F, 0.0F, 0.0F);
/* 197 */     this.spikes7 = new ModelRenderer((ModelBase)this, 18, 32);
/* 198 */     this.spikes7.func_78789_a(-1.0F, -10.0F, -4.0F, 1, 3, 1);
/* 199 */     this.spikes7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.spikes7.func_78787_b(128, 64);
/* 201 */     this.spikes7.field_78809_i = true;
/* 202 */     setRotation(this.spikes7, 0.0F, 0.0F, 0.0F);
/* 203 */     this.spikes8 = new ModelRenderer((ModelBase)this, 18, 32);
/* 204 */     this.spikes8.func_78789_a(-4.0F, -10.0F, -1.0F, 1, 3, 1);
/* 205 */     this.spikes8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 206 */     this.spikes8.func_78787_b(128, 64);
/* 207 */     this.spikes8.field_78809_i = true;
/* 208 */     setRotation(this.spikes8, 0.0F, 0.0F, 0.0F);
/* 209 */     this.ear1 = new ModelRenderer((ModelBase)this, 12, 32);
/* 210 */     this.ear1.func_78789_a(-5.0F, -5.0F, -3.0F, 1, 3, 2);
/* 211 */     this.ear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 212 */     this.ear1.func_78787_b(128, 64);
/* 213 */     this.ear1.field_78809_i = true;
/* 214 */     setRotation(this.ear1, -0.4014257F, 0.0F, 0.0F);
/* 215 */     this.ear2 = new ModelRenderer((ModelBase)this, 12, 32);
/* 216 */     this.ear2.func_78789_a(4.0F, -5.0F, -3.0F, 1, 3, 2);
/* 217 */     this.ear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 218 */     this.ear2.func_78787_b(128, 64);
/* 219 */     this.ear2.field_78809_i = true;
/* 220 */     setRotation(this.ear2, -0.4014257F, 0.0F, 0.0F);
/* 221 */     this.horn2 = new ModelRenderer((ModelBase)this, 0, 38);
/* 222 */     this.horn2.func_78789_a(-2.5F, -11.0F, -3.5F, 2, 4, 2);
/* 223 */     this.horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 224 */     this.horn2.func_78787_b(128, 64);
/* 225 */     this.horn2.field_78809_i = true;
/* 226 */     setRotation(this.horn2, 0.0F, 0.0F, -0.2094395F);
/* 227 */     this.horn1 = new ModelRenderer((ModelBase)this, 0, 38);
/* 228 */     this.horn1.func_78789_a(0.5F, -11.0F, -3.5F, 2, 4, 2);
/* 229 */     this.horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.horn1.func_78787_b(128, 64);
/* 231 */     this.horn1.field_78809_i = true;
/* 232 */     setRotation(this.horn1, 0.0F, 0.0F, 0.2094395F);
/* 233 */     this.appule = new ModelRenderer((ModelBase)this, 0, 48);
/* 234 */     this.appule.func_78789_a(-4.0F, -8.0F, 4.0F, 8, 8, 8);
/* 235 */     this.appule.func_78793_a(0.0F, 0.0F, 0.0F);
/* 236 */     this.appule.func_78787_b(128, 64);
/* 237 */     this.appule.field_78809_i = true;
/* 238 */     setRotation(this.appule, 0.0F, 0.0F, 0.0F);
/* 239 */     this.Fhorn2 = new ModelRenderer((ModelBase)this, 8, 38);
/* 240 */     this.Fhorn2.func_78789_a(1.5F, -11.0F, -3.5F, 2, 4, 2);
/* 241 */     this.Fhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 242 */     this.Fhorn2.func_78787_b(128, 64);
/* 243 */     this.Fhorn2.field_78809_i = true;
/* 244 */     setRotation(this.Fhorn2, 0.0F, 0.0F, -0.7853982F);
/* 245 */     this.Fhorn1 = new ModelRenderer((ModelBase)this, 8, 38);
/* 246 */     this.Fhorn1.func_78789_a(-3.5F, -11.0F, -3.5F, 2, 4, 2);
/* 247 */     this.Fhorn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 248 */     this.Fhorn1.func_78787_b(128, 64);
/* 249 */     this.Fhorn1.field_78809_i = true;
/* 250 */     setRotation(this.Fhorn1, 0.0F, 0.0F, 0.7853982F);
/* 251 */     this.Fhorn3 = new ModelRenderer((ModelBase)this, 8, 38);
/* 252 */     this.Fhorn3.func_78789_a(2.5F, -14.0F, -3.5F, 2, 4, 2);
/* 253 */     this.Fhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 254 */     this.Fhorn3.func_78787_b(128, 64);
/* 255 */     this.Fhorn3.field_78809_i = true;
/* 256 */     setRotation(this.Fhorn3, 0.0F, 0.0F, 0.2094395F);
/* 257 */     this.Fhorn4 = new ModelRenderer((ModelBase)this, 8, 38);
/* 258 */     this.Fhorn4.func_78789_a(-4.5F, -14.0F, -3.5F, 2, 4, 2);
/* 259 */     this.Fhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 260 */     this.Fhorn4.func_78787_b(128, 64);
/* 261 */     this.Fhorn4.field_78809_i = true;
/* 262 */     setRotation(this.Fhorn4, 0.0F, 0.0F, -0.2094395F);
/* 263 */     this.F2horn1 = new ModelRenderer((ModelBase)this, 16, 38);
/* 264 */     this.F2horn1.func_78789_a(-3.5F, -11.0F, 6.5F, 2, 4, 2);
/* 265 */     this.F2horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 266 */     this.F2horn1.func_78787_b(128, 64);
/* 267 */     this.F2horn1.field_78809_i = true;
/* 268 */     setRotation(this.F2horn1, 0.0F, 0.0F, 0.7853982F);
/* 269 */     this.F2horn2 = new ModelRenderer((ModelBase)this, 16, 38);
/* 270 */     this.F2horn2.func_78789_a(1.5F, -11.0F, 6.5F, 2, 4, 2);
/* 271 */     this.F2horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 272 */     this.F2horn2.func_78787_b(128, 64);
/* 273 */     this.F2horn2.field_78809_i = true;
/* 274 */     setRotation(this.F2horn2, 0.0F, 0.0F, -0.7853982F);
/* 275 */     this.tail1 = new ModelRenderer((ModelBase)this, 32, 48);
/* 276 */     this.tail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12);
/* 277 */     this.tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 278 */     this.tail1.func_78787_b(128, 64);
/* 279 */     this.tail1.field_78809_i = true;
/* 280 */     setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
/* 281 */     this.tail2 = new ModelRenderer((ModelBase)this, 32, 48);
/* 282 */     this.tail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12);
/* 283 */     this.tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 284 */     this.tail2.func_78787_b(128, 64);
/* 285 */     this.tail2.field_78809_i = true;
/* 286 */     setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 288 */     this.celltail = new ModelRenderer((ModelBase)this, 32, 48);
/* 289 */     this.celltail.func_78789_a(-0.5F, 16.5F, 14.0F, 1, 1, 4);
/* 290 */     this.celltail.func_78793_a(0.0F, 0.0F, 0.0F);
/* 291 */     this.celltail.func_78787_b(128, 64);
/*     */     
/* 293 */     this.cellhead1 = new ModelRenderer((ModelBase)this, 108, 50);
/* 294 */     this.cellhead1.func_78789_a(-2.5F, -14.0F, -3.5F, 3, 7, 7);
/* 295 */     this.cellhead1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 296 */     this.cellhead1.func_78787_b(128, 64);
/* 297 */     setRotation(this.cellhead1, 0.0F, 0.0F, -0.2094395F);
/* 298 */     this.cellhead3 = new ModelRenderer((ModelBase)this, 108, 50);
/* 299 */     this.cellhead3.func_78789_a(-2.5F, -10.0F, -3.5F, 3, 3, 7);
/* 300 */     this.cellhead3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 301 */     this.cellhead3.func_78787_b(128, 64);
/* 302 */     setRotation(this.cellhead3, 0.0F, 0.0F, -0.2094395F);
/* 303 */     this.cellhead2 = new ModelRenderer((ModelBase)this, 108, 50);
/* 304 */     this.cellhead2.field_78809_i = true;
/* 305 */     this.cellhead2.func_78789_a(-0.5F, -14.0F, -3.5F, 3, 7, 7);
/* 306 */     this.cellhead2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 307 */     this.cellhead2.func_78787_b(128, 64);
/* 308 */     setRotation(this.cellhead2, 0.0F, 0.0F, 0.2094395F);
/* 309 */     this.cellhead4 = new ModelRenderer((ModelBase)this, 108, 50);
/* 310 */     this.cellhead4.field_78809_i = true;
/* 311 */     this.cellhead4.func_78789_a(-0.5F, -10.0F, -3.5F, 3, 3, 7);
/* 312 */     this.cellhead4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 313 */     this.cellhead4.func_78787_b(128, 64);
/* 314 */     setRotation(this.cellhead4, 0.0F, 0.0F, 0.2094395F);
/* 315 */     this.cell1head = new ModelRenderer((ModelBase)this, 108, 44);
/* 316 */     this.cell1head.func_78789_a(-5.0F, -10.0F, -6.5F, 10, 4, 2);
/* 317 */     this.cell1head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 318 */     this.cell1head.func_78787_b(128, 64);
/* 319 */     setRotation(this.cell1head, -0.3490659F, 0.0F, 0.0F);
/* 320 */     this.hair1 = new ModelRenderer((ModelBase)this, 82, 47);
/* 321 */     this.hair1.func_78789_a(2.0F, -8.0F, -4.5F, 4, 8, 9);
/* 322 */     this.hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 323 */     this.hair1.func_78787_b(128, 64);
/* 324 */     setRotation(this.hair1, 0.0F, 0.0174533F, -0.2617994F);
/* 325 */     this.hair2 = new ModelRenderer((ModelBase)this, 82, 47);
/* 326 */     this.hair2.field_78809_i = true;
/* 327 */     this.hair2.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9);
/* 328 */     this.hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 329 */     this.hair2.func_78787_b(128, 64);
/* 330 */     setRotation(this.hair2, 0.0F, 0.0F, 0.2617994F);
/* 331 */     this.cape = new ModelRenderer((ModelBase)this, 100, 0);
/* 332 */     this.cape.func_78789_a(-7.0F, 1.0F, 2.0F, 14, 20, 0);
/* 333 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/* 334 */     this.cape.func_78787_b(128, 64);
/* 335 */     setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
/* 336 */     this.wing = new ModelRenderer((ModelBase)this, 114, 20);
/* 337 */     this.wing.func_78789_a(-1.0F, 2.0F, 2.0F, 7, 20, 0);
/* 338 */     this.wing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 339 */     this.wing.func_78787_b(128, 64);
/* 340 */     setRotation(this.wing, 0.1570796F, 0.0349066F, -0.2792527F);
/* 341 */     this.wing2 = new ModelRenderer((ModelBase)this, 114, 20);
/* 342 */     this.wing2.field_78809_i = true;
/* 343 */     this.wing2.func_78789_a(-6.0F, 2.0F, 2.0F, 7, 20, 0);
/* 344 */     this.wing2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 345 */     this.wing2.func_78787_b(128, 64);
/* 346 */     setRotation(this.wing2, 0.1570796F, -0.0349066F, 0.2792527F);
/*     */     
/* 348 */     this.c20 = new ModelRenderer((ModelBase)this, 76, 35);
/* 349 */     this.c20.func_78789_a(-4.0F, -12.0F, -4.0F, 8, 4, 8);
/* 350 */     this.c20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 351 */     this.c20.func_78787_b(128, 64);
/* 352 */     this.c20.field_78809_i = true;
/* 353 */     setRotation(this.c20, 0.0F, 0.0F, 0.0F);
/* 354 */     this.c19 = new ModelRenderer((ModelBase)this, 106, 29);
/* 355 */     this.c19.func_78789_a(-1.0F, -11.0F, -0.5F, 2, 4, 2);
/* 356 */     this.c19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 357 */     this.c19.func_78787_b(128, 64);
/* 358 */     this.c19.field_78809_i = true;
/* 359 */     setRotation(this.c19, 0.0F, 0.0F, 0.0F);
/*     */ 
/*     */     
/* 362 */     this.puipui1 = new ModelRenderer((ModelBase)this, 53, 48);
/* 363 */     this.puipui1.func_78789_a(0.5F, -8.0F, 2.5F, 2, 8, 2);
/* 364 */     this.puipui1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 365 */     this.puipui1.func_78787_b(128, 64);
/* 366 */     setRotation(this.puipui1, -1.047198F, 0.4363323F, 0.0F);
/* 367 */     this.puipui2 = new ModelRenderer((ModelBase)this, 53, 48);
/* 368 */     this.puipui2.func_78789_a(-2.5F, -8.0F, 2.5F, 2, 8, 2);
/* 369 */     this.puipui2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 370 */     this.puipui2.func_78787_b(128, 64);
/* 371 */     setRotation(this.puipui2, -1.047198F, -0.4363323F, 0.0F);
/* 372 */     this.puipui3 = new ModelRenderer((ModelBase)this, 53, 48);
/* 373 */     this.puipui3.func_78789_a(0.5F, -12.4F, -0.3F, 2, 4, 2);
/* 374 */     this.puipui3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 375 */     this.puipui3.func_78787_b(128, 64);
/* 376 */     setRotation(this.puipui3, -1.396263F, 0.4380776F, 0.0F);
/* 377 */     this.puipui4 = new ModelRenderer((ModelBase)this, 53, 48);
/* 378 */     this.puipui4.func_78789_a(-2.5F, -12.4F, -0.3F, 2, 4, 2);
/* 379 */     this.puipui4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 380 */     this.puipui4.func_78787_b(128, 64);
/* 381 */     setRotation(this.puipui4, -1.396263F, -0.4380776F, 0.0F);
/*     */     
/* 383 */     this.Dear1 = new ModelRenderer((ModelBase)this, 22, 29);
/* 384 */     this.Dear1.func_78789_a(-3.0F, -9.0F, -2.0F, 0, 6, 3);
/* 385 */     this.Dear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 386 */     setRotation(this.Dear1, -0.6981317F, -1.047198F, 0.0F);
/* 387 */     this.Dear2 = new ModelRenderer((ModelBase)this, 22, 29);
/* 388 */     this.Dear2.func_78789_a(3.0F, -9.0F, -2.0F, 0, 6, 3);
/* 389 */     this.Dear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 390 */     this.Dear2.field_78809_i = true;
/* 391 */     setRotation(this.Dear2, -0.6981317F, 1.047198F, 0.0F);
/*     */     
/* 393 */     this.body.func_78792_a(this.puipui1);
/* 394 */     this.body.func_78792_a(this.puipui2);
/* 395 */     this.body.func_78792_a(this.puipui3);
/* 396 */     this.body.func_78792_a(this.puipui4);
/* 397 */     this.head.func_78792_a(this.Dear1);
/* 398 */     this.head.func_78792_a(this.Dear2);
/*     */     
/* 400 */     this.head.func_78792_a(this.hair2);
/* 401 */     this.head.func_78792_a(this.hair1);
/* 402 */     this.head.func_78792_a(this.cell1head);
/*     */ 
/*     */     
/* 405 */     this.head.func_78792_a(this.cellhead3);
/* 406 */     this.head.func_78792_a(this.cellhead4);
/*     */     
/* 408 */     this.head.func_78792_a(this.c20);
/* 409 */     this.head.func_78792_a(this.c19);
/* 410 */     this.tail2.func_78792_a(this.celltail);
/* 411 */     this.body.func_78792_a(this.wing);
/* 412 */     this.body.func_78792_a(this.wing2);
/* 413 */     this.body.func_78792_a(this.cape);
/*     */     
/* 415 */     this.head.func_78792_a(this.cui1);
/* 416 */     this.head.func_78792_a(this.cui2);
/* 417 */     this.head.func_78792_a(this.spikes1);
/* 418 */     this.head.func_78792_a(this.spikes2);
/* 419 */     this.head.func_78792_a(this.spikes3);
/* 420 */     this.head.func_78792_a(this.spikes4);
/* 421 */     this.head.func_78792_a(this.spikes5);
/* 422 */     this.head.func_78792_a(this.spikes6);
/* 423 */     this.head.func_78792_a(this.spikes7);
/* 424 */     this.head.func_78792_a(this.spikes8);
/* 425 */     this.head.func_78792_a(this.ear1);
/* 426 */     this.head.func_78792_a(this.ear2);
/* 427 */     this.head.func_78792_a(this.horn2);
/* 428 */     this.head.func_78792_a(this.horn1);
/* 429 */     this.head.func_78792_a(this.appule);
/* 430 */     this.head.func_78792_a(this.Fhorn2);
/* 431 */     this.head.func_78792_a(this.Fhorn1);
/* 432 */     this.head.func_78792_a(this.Fhorn3);
/* 433 */     this.head.func_78792_a(this.Fhorn4);
/* 434 */     this.head.func_78792_a(this.F2horn1);
/* 435 */     this.head.func_78792_a(this.F2horn2);
/* 436 */     this.body.func_78792_a(this.tail1);
/* 437 */     this.body.func_78792_a(this.tail2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 443 */     model.field_78795_f = x;
/* 444 */     model.field_78796_g = y;
/* 445 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 451 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 452 */     GL11.glPushMatrix();
/* 453 */     GL11.glScalef(this.F, this.F, this.F);
/*     */     
/* 455 */     if (!this.Y2) {
/* 456 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 457 */       if (this.Y) GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F * 3.65F, 0.0F);
/*     */     
/*     */     } else {
/* 460 */       float ff1 = -2.45F;
/* 461 */       float ff2 = 0.6F;
/* 462 */       float diff = ff2 / this.F * ff1;
/* 463 */       GL11.glTranslatef(0.0F, (this.F - 1.0F) * diff, 0.0F);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 470 */     this.head.func_78785_a(f5);
/* 471 */     if (this.Y) GL11.glScalef(this.F, this.F, this.F); 
/* 472 */     this.body.func_78785_a(f5);
/* 473 */     this.rightarm.func_78785_a(f5);
/* 474 */     this.leftarm.func_78785_a(f5);
/* 475 */     this.rightleg.func_78785_a(f5);
/* 476 */     this.leftleg.func_78785_a(f5);
/* 477 */     this.headhair.func_78785_a(f5);
/* 478 */     this.leftarmshoulder.func_78785_a(f5);
/* 479 */     this.rightarmshoulder.func_78785_a(f5);
/* 480 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 485 */     this.head.field_78796_g = par4 / 57.295776F;
/* 486 */     this.head.field_78795_f = par5 / 57.295776F;
/* 487 */     this.headhair.field_78796_g = this.head.field_78796_g;
/* 488 */     this.headhair.field_78795_f = this.head.field_78795_f;
/* 489 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 490 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 491 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 492 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 493 */     this.rightarm.field_78808_h = 0.0F;
/* 494 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 495 */     this.leftarm.field_78808_h = 0.0F;
/* 496 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 497 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 498 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 499 */     this.rightleg.field_78796_g = 0.0F;
/* 500 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 502 */     if (this.field_78093_q) {
/*     */       
/* 504 */       this.rightarm.field_78795_f += -0.62831855F;
/* 505 */       this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 506 */       this.leftarm.field_78795_f += -0.62831855F;
/* 507 */       this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 508 */       this.rightleg.field_78795_f = -1.2566371F;
/* 509 */       this.leftleg.field_78795_f = -1.2566371F;
/* 510 */       this.rightleg.field_78796_g = 0.31415927F;
/* 511 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 514 */     this.rightarm.field_78796_g = 0.0F;
/* 515 */     this.rightarmshoulder.field_78796_g = this.rightarm.field_78796_g;
/* 516 */     this.leftarm.field_78796_g = 0.0F;
/* 517 */     this.leftarmshoulder.field_78796_g = this.leftarm.field_78796_g;
/*     */ 
/*     */ 
/*     */     
/* 521 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 523 */       float var8 = this.field_78095_p;
/* 524 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 525 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 526 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 527 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 528 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 529 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 530 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 531 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 532 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 533 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 534 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 535 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 536 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g;
/* 537 */       this.leftarmshoulder.field_78796_g += this.body.field_78796_g;
/* 538 */       this.leftarmshoulder.field_78795_f += this.body.field_78796_g;
/* 539 */       var8 = 1.0F - this.field_78095_p;
/* 540 */       var8 *= var8;
/* 541 */       var8 *= var8;
/* 542 */       var8 = 1.0F - var8;
/* 543 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 544 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 545 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 546 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 547 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/* 548 */       this.rightarmshoulder.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 549 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g * 2.0F;
/* 550 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 554 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 555 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 556 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 557 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 558 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 559 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 560 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 561 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelRaditz2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */