/*     */ package JinRyuu.FamilyC;
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
/*     */ public class ModelJFC
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
/*     */   ModelRenderer cell1head;
/*     */   ModelRenderer hair1;
/*     */   ModelRenderer hair2;
/*     */   ModelRenderer cape;
/*     */   ModelRenderer wing;
/*     */   ModelRenderer wing2;
/*     */   ModelRenderer c20;
/*     */   ModelRenderer c19;
/*  63 */   private float F = 1.0F;
/*     */   public ModelJFC(float f) {
/*  65 */     this();
/*  66 */     this.F = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelJFC() {
/*  71 */     this.field_78090_t = 128;
/*  72 */     this.field_78089_u = 64;
/*     */     
/*  74 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  75 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  76 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.head.func_78787_b(128, 64);
/*  78 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/*  79 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/*  80 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.body.func_78787_b(128, 64);
/*  82 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  83 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/*  84 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  85 */     this.rightarm.func_78787_b(128, 64);
/*  86 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  87 */     this.leftarm.field_78809_i = true;
/*  88 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/*  89 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/*  90 */     this.leftarm.func_78787_b(128, 64);
/*  91 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  92 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  93 */     this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  94 */     this.rightleg.func_78787_b(128, 64);
/*  95 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  96 */     this.leftleg.field_78809_i = true;
/*  97 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  98 */     this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
/*  99 */     this.leftleg.func_78787_b(128, 64);
/* 100 */     this.headhair = new ModelRenderer((ModelBase)this, 56, 0);
/* 101 */     this.headhair.func_78789_a(-5.0F, -9.0F, -5.0F, 10, 20, 10);
/* 102 */     this.headhair.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.headhair.func_78787_b(128, 64);
/* 104 */     this.rightarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 105 */     this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6);
/* 106 */     this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 107 */     this.rightarmshoulder.func_78787_b(128, 64);
/* 108 */     this.leftarmshoulder = new ModelRenderer((ModelBase)this, 40, 32);
/* 109 */     this.leftarmshoulder.field_78809_i = true;
/* 110 */     this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6);
/* 111 */     this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F);
/* 112 */     this.leftarmshoulder.func_78787_b(128, 64);
/* 113 */     this.cui1 = new ModelRenderer((ModelBase)this, 0, 32);
/* 114 */     this.cui1.func_78789_a(2.0F, -9.0F, -3.0F, 3, 3, 3);
/* 115 */     this.cui1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.cui1.func_78787_b(128, 64);
/* 117 */     this.cui1.field_78809_i = true;
/* 118 */     setRotation(this.cui1, 0.0F, 0.0F, 0.0F);
/* 119 */     this.cui2 = new ModelRenderer((ModelBase)this, 0, 32);
/* 120 */     this.cui2.func_78789_a(-5.0F, -9.0F, -3.0F, 3, 3, 3);
/* 121 */     this.cui2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 122 */     this.cui2.func_78787_b(128, 64);
/* 123 */     this.cui2.field_78809_i = true;
/* 124 */     setRotation(this.cui2, 0.0F, 0.0F, 0.0F);
/* 125 */     this.spikes1 = new ModelRenderer((ModelBase)this, 18, 32);
/* 126 */     this.spikes1.func_78789_a(0.0F, -10.0F, 0.0F, 1, 3, 1);
/* 127 */     this.spikes1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.spikes1.func_78787_b(128, 64);
/* 129 */     this.spikes1.field_78809_i = true;
/* 130 */     setRotation(this.spikes1, 0.0F, 0.0F, 0.0F);
/* 131 */     this.spikes2 = new ModelRenderer((ModelBase)this, 18, 32);
/* 132 */     this.spikes2.func_78789_a(3.0F, -10.0F, 1.0F, 1, 3, 1);
/* 133 */     this.spikes2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.spikes2.func_78787_b(128, 64);
/* 135 */     this.spikes2.field_78809_i = true;
/* 136 */     setRotation(this.spikes2, 0.0F, 0.0F, 0.0F);
/* 137 */     this.spikes3 = new ModelRenderer((ModelBase)this, 18, 32);
/* 138 */     this.spikes3.func_78789_a(2.0F, -10.0F, -3.0F, 1, 3, 1);
/* 139 */     this.spikes3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.spikes3.func_78787_b(128, 64);
/* 141 */     this.spikes3.field_78809_i = true;
/* 142 */     setRotation(this.spikes3, 0.0F, 0.0F, 0.0F);
/* 143 */     this.spikes4 = new ModelRenderer((ModelBase)this, 18, 32);
/* 144 */     this.spikes4.func_78789_a(-2.0F, -10.0F, -2.0F, 1, 3, 1);
/* 145 */     this.spikes4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 146 */     this.spikes4.func_78787_b(128, 64);
/* 147 */     this.spikes4.field_78809_i = true;
/* 148 */     setRotation(this.spikes4, 0.0F, 0.0F, 0.0F);
/* 149 */     this.spikes5 = new ModelRenderer((ModelBase)this, 18, 32);
/* 150 */     this.spikes5.func_78789_a(-3.0F, -10.0F, 2.0F, 1, 3, 1);
/* 151 */     this.spikes5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 152 */     this.spikes5.func_78787_b(128, 64);
/* 153 */     this.spikes5.field_78809_i = true;
/* 154 */     setRotation(this.spikes5, 0.0F, 0.0F, 0.0F);
/* 155 */     this.spikes6 = new ModelRenderer((ModelBase)this, 18, 32);
/* 156 */     this.spikes6.func_78789_a(1.0F, -10.0F, 3.0F, 1, 3, 1);
/* 157 */     this.spikes6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.spikes6.func_78787_b(128, 64);
/* 159 */     this.spikes6.field_78809_i = true;
/* 160 */     setRotation(this.spikes6, 0.0F, 0.0F, 0.0F);
/* 161 */     this.spikes7 = new ModelRenderer((ModelBase)this, 18, 32);
/* 162 */     this.spikes7.func_78789_a(-1.0F, -10.0F, -4.0F, 1, 3, 1);
/* 163 */     this.spikes7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.spikes7.func_78787_b(128, 64);
/* 165 */     this.spikes7.field_78809_i = true;
/* 166 */     setRotation(this.spikes7, 0.0F, 0.0F, 0.0F);
/* 167 */     this.spikes8 = new ModelRenderer((ModelBase)this, 18, 32);
/* 168 */     this.spikes8.func_78789_a(-4.0F, -10.0F, -1.0F, 1, 3, 1);
/* 169 */     this.spikes8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 170 */     this.spikes8.func_78787_b(128, 64);
/* 171 */     this.spikes8.field_78809_i = true;
/* 172 */     setRotation(this.spikes8, 0.0F, 0.0F, 0.0F);
/* 173 */     this.ear1 = new ModelRenderer((ModelBase)this, 12, 32);
/* 174 */     this.ear1.func_78789_a(-5.0F, -5.0F, -3.0F, 1, 3, 2);
/* 175 */     this.ear1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 176 */     this.ear1.func_78787_b(128, 64);
/* 177 */     this.ear1.field_78809_i = true;
/* 178 */     setRotation(this.ear1, -0.4014257F, 0.0F, 0.0F);
/* 179 */     this.ear2 = new ModelRenderer((ModelBase)this, 12, 32);
/* 180 */     this.ear2.func_78789_a(4.0F, -5.0F, -3.0F, 1, 3, 2);
/* 181 */     this.ear2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.ear2.func_78787_b(128, 64);
/* 183 */     this.ear2.field_78809_i = true;
/* 184 */     setRotation(this.ear2, -0.4014257F, 0.0F, 0.0F);
/* 185 */     this.horn2 = new ModelRenderer((ModelBase)this, 0, 38);
/* 186 */     this.horn2.func_78789_a(-2.5F, -11.0F, -3.5F, 2, 4, 2);
/* 187 */     this.horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 188 */     this.horn2.func_78787_b(128, 64);
/* 189 */     this.horn2.field_78809_i = true;
/* 190 */     setRotation(this.horn2, 0.0F, 0.0F, -0.2094395F);
/* 191 */     this.horn1 = new ModelRenderer((ModelBase)this, 0, 38);
/* 192 */     this.horn1.func_78789_a(0.5F, -11.0F, -3.5F, 2, 4, 2);
/* 193 */     this.horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 194 */     this.horn1.func_78787_b(128, 64);
/* 195 */     this.horn1.field_78809_i = true;
/* 196 */     setRotation(this.horn1, 0.0F, 0.0F, 0.2094395F);
/* 197 */     this.appule = new ModelRenderer((ModelBase)this, 0, 48);
/* 198 */     this.appule.func_78789_a(-4.0F, -8.0F, 4.0F, 8, 8, 8);
/* 199 */     this.appule.func_78793_a(0.0F, 0.0F, 0.0F);
/* 200 */     this.appule.func_78787_b(128, 64);
/* 201 */     this.appule.field_78809_i = true;
/* 202 */     setRotation(this.appule, 0.0F, 0.0F, 0.0F);
/* 203 */     this.Fhorn2 = new ModelRenderer((ModelBase)this, 8, 38);
/* 204 */     this.Fhorn2.func_78789_a(1.5F, -11.0F, -3.5F, 2, 4, 2);
/* 205 */     this.Fhorn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 206 */     this.Fhorn2.func_78787_b(128, 64);
/* 207 */     this.Fhorn2.field_78809_i = true;
/* 208 */     setRotation(this.Fhorn2, 0.0F, 0.0F, -0.7853982F);
/* 209 */     this.Fhorn1 = new ModelRenderer((ModelBase)this, 8, 38);
/* 210 */     this.Fhorn1.func_78789_a(-3.5F, -11.0F, -3.5F, 2, 4, 2);
/* 211 */     this.Fhorn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 212 */     this.Fhorn1.func_78787_b(128, 64);
/* 213 */     this.Fhorn1.field_78809_i = true;
/* 214 */     setRotation(this.Fhorn1, 0.0F, 0.0F, 0.7853982F);
/* 215 */     this.Fhorn3 = new ModelRenderer((ModelBase)this, 8, 38);
/* 216 */     this.Fhorn3.func_78789_a(2.5F, -14.0F, -3.5F, 2, 4, 2);
/* 217 */     this.Fhorn3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 218 */     this.Fhorn3.func_78787_b(128, 64);
/* 219 */     this.Fhorn3.field_78809_i = true;
/* 220 */     setRotation(this.Fhorn3, 0.0F, 0.0F, 0.2094395F);
/* 221 */     this.Fhorn4 = new ModelRenderer((ModelBase)this, 8, 38);
/* 222 */     this.Fhorn4.func_78789_a(-4.5F, -14.0F, -3.5F, 2, 4, 2);
/* 223 */     this.Fhorn4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 224 */     this.Fhorn4.func_78787_b(128, 64);
/* 225 */     this.Fhorn4.field_78809_i = true;
/* 226 */     setRotation(this.Fhorn4, 0.0F, 0.0F, -0.2094395F);
/* 227 */     this.F2horn1 = new ModelRenderer((ModelBase)this, 16, 38);
/* 228 */     this.F2horn1.func_78789_a(-3.5F, -11.0F, 6.5F, 2, 4, 2);
/* 229 */     this.F2horn1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 230 */     this.F2horn1.func_78787_b(128, 64);
/* 231 */     this.F2horn1.field_78809_i = true;
/* 232 */     setRotation(this.F2horn1, 0.0F, 0.0F, 0.7853982F);
/* 233 */     this.F2horn2 = new ModelRenderer((ModelBase)this, 16, 38);
/* 234 */     this.F2horn2.func_78789_a(1.5F, -11.0F, 6.5F, 2, 4, 2);
/* 235 */     this.F2horn2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 236 */     this.F2horn2.func_78787_b(128, 64);
/* 237 */     this.F2horn2.field_78809_i = true;
/* 238 */     setRotation(this.F2horn2, 0.0F, 0.0F, -0.7853982F);
/* 239 */     this.tail1 = new ModelRenderer((ModelBase)this, 32, 48);
/* 240 */     this.tail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12);
/* 241 */     this.tail1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 242 */     this.tail1.func_78787_b(128, 64);
/* 243 */     this.tail1.field_78809_i = true;
/* 244 */     setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
/* 245 */     this.tail2 = new ModelRenderer((ModelBase)this, 32, 48);
/* 246 */     this.tail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12);
/* 247 */     this.tail2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 248 */     this.tail2.func_78787_b(128, 64);
/* 249 */     this.tail2.field_78809_i = true;
/* 250 */     setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
/*     */     
/* 252 */     this.celltail = new ModelRenderer((ModelBase)this, 32, 48);
/* 253 */     this.celltail.func_78789_a(-0.5F, 16.5F, 14.0F, 1, 1, 4);
/* 254 */     this.celltail.func_78793_a(0.0F, 0.0F, 0.0F);
/* 255 */     this.celltail.func_78787_b(128, 64);
/*     */     
/* 257 */     this.cellhead1 = new ModelRenderer((ModelBase)this, 108, 50);
/* 258 */     this.cellhead1.func_78789_a(-2.5F, -14.0F, -3.5F, 3, 7, 7);
/* 259 */     this.cellhead1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 260 */     this.cellhead1.func_78787_b(128, 64);
/* 261 */     setRotation(this.cellhead1, 0.0F, 0.0F, -0.2094395F);
/* 262 */     this.cellhead2 = new ModelRenderer((ModelBase)this, 108, 50);
/* 263 */     this.cellhead2.field_78809_i = true;
/* 264 */     this.cellhead2.func_78789_a(-0.5F, -14.0F, -3.5F, 3, 7, 7);
/* 265 */     this.cellhead2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 266 */     this.cellhead2.func_78787_b(128, 64);
/* 267 */     setRotation(this.cellhead2, 0.0F, 0.0F, 0.2094395F);
/* 268 */     this.cell1head = new ModelRenderer((ModelBase)this, 108, 44);
/* 269 */     this.cell1head.func_78789_a(-5.0F, -10.0F, -6.5F, 10, 4, 2);
/* 270 */     this.cell1head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 271 */     this.cell1head.func_78787_b(128, 64);
/* 272 */     setRotation(this.cell1head, -0.3490659F, 0.0F, 0.0F);
/* 273 */     this.hair1 = new ModelRenderer((ModelBase)this, 82, 47);
/* 274 */     this.hair1.func_78789_a(2.0F, -8.0F, -4.5F, 4, 8, 9);
/* 275 */     this.hair1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 276 */     this.hair1.func_78787_b(128, 64);
/* 277 */     setRotation(this.hair1, 0.0F, 0.0174533F, -0.2617994F);
/* 278 */     this.hair2 = new ModelRenderer((ModelBase)this, 82, 47);
/* 279 */     this.hair2.field_78809_i = true;
/* 280 */     this.hair2.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9);
/* 281 */     this.hair2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 282 */     this.hair2.func_78787_b(128, 64);
/* 283 */     setRotation(this.hair2, 0.0F, 0.0F, 0.2617994F);
/* 284 */     this.cape = new ModelRenderer((ModelBase)this, 100, 0);
/* 285 */     this.cape.func_78789_a(-7.0F, 1.0F, 2.0F, 14, 20, 0);
/* 286 */     this.cape.func_78793_a(0.0F, 0.0F, 0.0F);
/* 287 */     this.cape.func_78787_b(128, 64);
/* 288 */     setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
/* 289 */     this.wing = new ModelRenderer((ModelBase)this, 114, 20);
/* 290 */     this.wing.func_78789_a(-1.0F, 2.0F, 2.0F, 7, 20, 0);
/* 291 */     this.wing.func_78793_a(0.0F, 0.0F, 0.0F);
/* 292 */     this.wing.func_78787_b(128, 64);
/* 293 */     setRotation(this.wing, 0.1570796F, 0.0349066F, -0.2792527F);
/* 294 */     this.wing2 = new ModelRenderer((ModelBase)this, 114, 20);
/* 295 */     this.wing2.field_78809_i = true;
/* 296 */     this.wing2.func_78789_a(-6.0F, 2.0F, 2.0F, 7, 20, 0);
/* 297 */     this.wing2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 298 */     this.wing2.func_78787_b(128, 64);
/* 299 */     setRotation(this.wing2, 0.1570796F, -0.0349066F, 0.2792527F);
/*     */     
/* 301 */     this.c20 = new ModelRenderer((ModelBase)this, 76, 35);
/* 302 */     this.c20.func_78789_a(-4.0F, -12.0F, -4.0F, 8, 4, 8);
/* 303 */     this.c20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 304 */     this.c20.func_78787_b(128, 64);
/* 305 */     this.c20.field_78809_i = true;
/* 306 */     setRotation(this.c20, 0.0F, 0.0F, 0.0F);
/* 307 */     this.c19 = new ModelRenderer((ModelBase)this, 106, 29);
/* 308 */     this.c19.func_78789_a(-1.0F, -11.0F, -0.5F, 2, 4, 2);
/* 309 */     this.c19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 310 */     this.c19.func_78787_b(128, 64);
/* 311 */     this.c19.field_78809_i = true;
/* 312 */     setRotation(this.c19, 0.0F, 0.0F, 0.0F);
/*     */     
/* 314 */     this.head.func_78792_a(this.hair2);
/* 315 */     this.head.func_78792_a(this.hair1);
/* 316 */     this.head.func_78792_a(this.cell1head);
/* 317 */     this.head.func_78792_a(this.cellhead1);
/* 318 */     this.head.func_78792_a(this.cellhead2);
/* 319 */     this.head.func_78792_a(this.c20);
/* 320 */     this.head.func_78792_a(this.c19);
/* 321 */     this.tail2.func_78792_a(this.celltail);
/* 322 */     this.body.func_78792_a(this.wing);
/* 323 */     this.body.func_78792_a(this.wing2);
/* 324 */     this.body.func_78792_a(this.cape);
/*     */     
/* 326 */     this.head.func_78792_a(this.cui1);
/* 327 */     this.head.func_78792_a(this.cui2);
/* 328 */     this.head.func_78792_a(this.spikes1);
/* 329 */     this.head.func_78792_a(this.spikes2);
/* 330 */     this.head.func_78792_a(this.spikes3);
/* 331 */     this.head.func_78792_a(this.spikes4);
/* 332 */     this.head.func_78792_a(this.spikes5);
/* 333 */     this.head.func_78792_a(this.spikes6);
/* 334 */     this.head.func_78792_a(this.spikes7);
/* 335 */     this.head.func_78792_a(this.spikes8);
/* 336 */     this.head.func_78792_a(this.ear1);
/* 337 */     this.head.func_78792_a(this.ear2);
/* 338 */     this.head.func_78792_a(this.horn2);
/* 339 */     this.head.func_78792_a(this.horn1);
/* 340 */     this.head.func_78792_a(this.appule);
/* 341 */     this.head.func_78792_a(this.Fhorn2);
/* 342 */     this.head.func_78792_a(this.Fhorn1);
/* 343 */     this.head.func_78792_a(this.Fhorn3);
/* 344 */     this.head.func_78792_a(this.Fhorn4);
/* 345 */     this.head.func_78792_a(this.F2horn1);
/* 346 */     this.head.func_78792_a(this.F2horn2);
/* 347 */     this.body.func_78792_a(this.tail1);
/* 348 */     this.body.func_78792_a(this.tail2);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 353 */     model.field_78795_f = x;
/* 354 */     model.field_78796_g = y;
/* 355 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 361 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 362 */     GL11.glPushMatrix();
/* 363 */     GL11.glScalef(this.F, this.F, this.F);
/* 364 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/* 365 */     this.head.func_78785_a(f5);
/* 366 */     this.body.func_78785_a(f5);
/* 367 */     this.rightarm.func_78785_a(f5);
/* 368 */     this.leftarm.func_78785_a(f5);
/* 369 */     this.rightleg.func_78785_a(f5);
/* 370 */     this.leftleg.func_78785_a(f5);
/* 371 */     this.headhair.func_78785_a(f5);
/* 372 */     this.leftarmshoulder.func_78785_a(f5);
/* 373 */     this.rightarmshoulder.func_78785_a(f5);
/* 374 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 380 */     this.head.field_78796_g = par4 / 57.295776F;
/* 381 */     this.head.field_78795_f = par5 / 57.295776F;
/* 382 */     this.headhair.field_78796_g = this.head.field_78796_g;
/* 383 */     this.headhair.field_78795_f = this.head.field_78795_f;
/* 384 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 385 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 386 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 387 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 388 */     this.rightarm.field_78808_h = 0.0F;
/* 389 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 390 */     this.leftarm.field_78808_h = 0.0F;
/* 391 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 392 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 393 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 394 */     this.rightleg.field_78796_g = 0.0F;
/* 395 */     this.leftleg.field_78796_g = 0.0F;
/*     */     
/* 397 */     if (this.field_78093_q) {
/*     */       
/* 399 */       this.rightarm.field_78795_f += -0.62831855F;
/* 400 */       this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 401 */       this.leftarm.field_78795_f += -0.62831855F;
/* 402 */       this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/* 403 */       this.rightleg.field_78795_f = -1.2566371F;
/* 404 */       this.leftleg.field_78795_f = -1.2566371F;
/* 405 */       this.rightleg.field_78796_g = 0.31415927F;
/* 406 */       this.leftleg.field_78796_g = -0.31415927F;
/*     */     } 
/*     */     
/* 409 */     this.rightarm.field_78796_g = 0.0F;
/* 410 */     this.rightarmshoulder.field_78796_g = this.rightarm.field_78796_g;
/* 411 */     this.leftarm.field_78796_g = 0.0F;
/* 412 */     this.leftarmshoulder.field_78796_g = this.leftarm.field_78796_g;
/*     */ 
/*     */ 
/*     */     
/* 416 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 418 */       float var8 = this.field_78095_p;
/* 419 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 420 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 421 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 422 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 423 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 424 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/* 425 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/* 426 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/* 427 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 428 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 429 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/* 430 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/* 431 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g;
/* 432 */       this.leftarmshoulder.field_78796_g += this.body.field_78796_g;
/* 433 */       this.leftarmshoulder.field_78795_f += this.body.field_78796_g;
/* 434 */       var8 = 1.0F - this.field_78095_p;
/* 435 */       var8 *= var8;
/* 436 */       var8 *= var8;
/* 437 */       var8 = 1.0F - var8;
/* 438 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 439 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/* 440 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 441 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/* 442 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/* 443 */       this.rightarmshoulder.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/* 444 */       this.rightarmshoulder.field_78796_g += this.body.field_78796_g * 2.0F;
/* 445 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */ 
/*     */     
/* 449 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 450 */     this.rightarmshoulder.field_78808_h = this.rightarm.field_78808_h;
/* 451 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 452 */     this.leftarmshoulder.field_78808_h = this.leftarm.field_78808_h;
/* 453 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 454 */     this.rightarmshoulder.field_78795_f = this.rightarm.field_78795_f;
/* 455 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 456 */     this.leftarmshoulder.field_78795_f = this.leftarm.field_78795_f;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\ModelJFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */