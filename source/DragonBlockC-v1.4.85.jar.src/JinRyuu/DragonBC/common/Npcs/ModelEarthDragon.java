/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelEarthDragon
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer head;
/*     */   ModelRenderer Tail27;
/*     */   ModelRenderer Tail26;
/*     */   ModelRenderer Tail25;
/*     */   ModelRenderer Tail24;
/*     */   ModelRenderer Tail23;
/*     */   ModelRenderer Tail22;
/*     */   ModelRenderer Tail21;
/*     */   ModelRenderer Tail20;
/*     */   ModelRenderer Tail19;
/*     */   ModelRenderer Tail18;
/*     */   ModelRenderer Tail17;
/*     */   ModelRenderer Tail16;
/*     */   ModelRenderer Tail15;
/*     */   ModelRenderer Tail14;
/*     */   ModelRenderer Tail13;
/*     */   ModelRenderer Tail12;
/*     */   ModelRenderer Tail11;
/*     */   ModelRenderer Tail10;
/*     */   ModelRenderer Tail9;
/*     */   ModelRenderer Tail8;
/*     */   ModelRenderer Tail7;
/*     */   ModelRenderer Tail6;
/*     */   ModelRenderer Tail5;
/*     */   ModelRenderer Tail4;
/*     */   ModelRenderer Tail3;
/*     */   ModelRenderer Tail2;
/*     */   ModelRenderer Tail1;
/*     */   ModelRenderer HornHori1;
/*     */   ModelRenderer HornVer1;
/*     */   ModelRenderer HornHori2;
/*     */   ModelRenderer HornVer2;
/*     */   ModelRenderer Arm1;
/*     */   ModelRenderer HAnd1;
/*     */   ModelRenderer Claw11;
/*     */   ModelRenderer Claw12;
/*     */   ModelRenderer Claw13;
/*     */   ModelRenderer Claw14;
/*     */   ModelRenderer Arm2;
/*     */   ModelRenderer HAnd2;
/*     */   ModelRenderer Claw21;
/*     */   ModelRenderer Claw22;
/*     */   ModelRenderer Claw23;
/*     */   ModelRenderer Claw24;
/*     */   ModelRenderer Arm3;
/*     */   ModelRenderer HAnd3;
/*     */   ModelRenderer Claw31;
/*     */   ModelRenderer Claw32;
/*     */   ModelRenderer Claw33;
/*     */   ModelRenderer Claw34;
/*     */   ModelRenderer Arm4;
/*     */   ModelRenderer HAnd4;
/*     */   ModelRenderer Claw41;
/*     */   ModelRenderer Claw42;
/*     */   ModelRenderer Claw43;
/*     */   ModelRenderer Claw44;
/*     */   ModelRenderer Fin1;
/*     */   ModelRenderer Fin2;
/*     */   ModelRenderer Fin3;
/*     */   ModelRenderer Fin4;
/*     */   ModelRenderer Fin5;
/*     */   ModelRenderer Fin6;
/*     */   ModelRenderer Fin7;
/*     */   ModelRenderer Fin8;
/*     */   ModelRenderer Fin9;
/*     */   ModelRenderer Fin10;
/*     */   ModelRenderer Fin11;
/*     */   ModelRenderer Fin12;
/*     */   ModelRenderer Fin13;
/*     */   ModelRenderer Fin14;
/*     */   ModelRenderer Fin15;
/*     */   ModelRenderer Fin16;
/*     */   ModelRenderer Fin17;
/*     */   ModelRenderer Fin18;
/*     */   ModelRenderer Fin19;
/*     */   ModelRenderer Fin20;
/*     */   ModelRenderer Fin21;
/*     */   ModelRenderer Fin22;
/*     */   ModelRenderer Fin23;
/*     */   ModelRenderer Fin24;
/*     */   ModelRenderer Wisker1;
/*     */   ModelRenderer Wisker2;
/*     */   ModelRenderer FaceFin1;
/*     */   ModelRenderer FaceFin2;
/*     */   ModelRenderer dragon5;
/*     */   ModelRenderer dragon7;
/*     */   ModelRenderer dragon6;
/*     */   ModelRenderer dragon12;
/*     */   
/*     */   public ModelEarthDragon() {
/* 107 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelEarthDragon(float par1) {
/* 112 */     this(par1, 0.0F, 64, 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelEarthDragon(float par1, float par2, int par3, int par4) {
/* 117 */     this.field_78090_t = 128;
/* 118 */     this.field_78089_u = 64;
/*     */     
/* 120 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/* 121 */     this.head.func_78789_a(0.0F, 0.0F, 0.0F, 1, 1, 1);
/* 122 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/* 123 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*     */     
/* 125 */     this.dragon5 = new ModelRenderer((ModelBase)this, 30, 47);
/* 126 */     this.dragon5.func_78789_a(7.0F, -55.0F, 36.0F, 10, 7, 10);
/* 127 */     this.dragon5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     setRotation(this.dragon5, 0.6806784F, 0.0F, 0.0F);
/* 129 */     this.dragon7 = new ModelRenderer((ModelBase)this, 0, 23);
/* 130 */     this.dragon7.func_78789_a(9.0F, -54.0F, 28.0F, 6, 2, 8);
/* 131 */     this.dragon7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     setRotation(this.dragon7, 0.6632251F, 0.0F, 0.0F);
/* 133 */     this.dragon6 = new ModelRenderer((ModelBase)this, 0, 33);
/* 134 */     this.dragon6.func_78789_a(9.0F, -44.0F, 38.0F, 6, 2, 8);
/* 135 */     this.dragon6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     setRotation(this.dragon6, 0.8726646F, 0.0F, 0.0F);
/* 137 */     this.dragon12 = new ModelRenderer((ModelBase)this, 85, 0);
/* 138 */     this.dragon12.func_78789_a(-3.0F, 7.0F, -7.0F, 6, 16, 6);
/* 139 */     this.dragon12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     setRotation(this.dragon12, 0.2617994F, 0.0F, 0.0F);
/*     */     
/* 142 */     this.Tail27 = new ModelRenderer((ModelBase)this, 32, 0);
/* 143 */     this.Tail27.func_78789_a(0.0F, 0.0F, 0.0F, 10, 8, 8);
/* 144 */     this.Tail27.func_78793_a(7.0F, -65.0F, -2.0F);
/* 145 */     setRotation(this.Tail27, 1.047198F, -0.0174533F, 0.0F);
/* 146 */     this.Tail26 = new ModelRenderer((ModelBase)this, 32, 0);
/* 147 */     this.Tail26.func_78789_a(0.0F, 0.0F, 0.0F, 10, 4, 8);
/* 148 */     this.Tail26.func_78793_a(7.0F, -68.0F, 1.0F);
/* 149 */     setRotation(this.Tail26, 0.0F, 0.0174533F, 0.0F);
/* 150 */     this.Tail25 = new ModelRenderer((ModelBase)this, 32, 0);
/* 151 */     this.Tail25.func_78789_a(0.0F, 0.0F, -1.0F, 10, 10, 8);
/* 152 */     this.Tail25.func_78793_a(7.0F, -67.0F, 2.0F);
/* 153 */     setRotation(this.Tail25, 0.0F, 0.0174533F, 0.296706F);
/* 154 */     this.Tail24 = new ModelRenderer((ModelBase)this, 32, 0);
/* 155 */     this.Tail24.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 156 */     this.Tail24.func_78793_a(9.0F, -64.0F, 1.0F);
/* 157 */     setRotation(this.Tail24, 0.0F, 0.0F, 1.117011F);
/* 158 */     this.Tail23 = new ModelRenderer((ModelBase)this, 32, 0);
/* 159 */     this.Tail23.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 160 */     this.Tail23.func_78793_a(4.0F, -58.0F, 1.0F);
/* 161 */     setRotation(this.Tail23, 0.0F, 0.0174533F, 1.919862F);
/* 162 */     this.Tail22 = new ModelRenderer((ModelBase)this, 32, 0);
/* 163 */     this.Tail22.func_78789_a(0.0F, 0.0F, 0.0F, 10, 13, 8);
/* 164 */     this.Tail22.func_78793_a(-4.0F, -59.0F, 1.0F);
/* 165 */     setRotation(this.Tail22, 0.0F, 0.0F, 2.617994F);
/* 166 */     this.Tail21 = new ModelRenderer((ModelBase)this, 32, 0);
/* 167 */     this.Tail21.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 168 */     this.Tail21.func_78793_a(-11.0F, -70.0F, 1.0F);
/* 169 */     setRotation(this.Tail21, 0.0F, 0.0174533F, 2.164208F);
/* 170 */     this.Tail20 = new ModelRenderer((ModelBase)this, 32, 0);
/* 171 */     this.Tail20.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 172 */     this.Tail20.func_78793_a(-23.2F, -78.0F, 1.0F);
/* 173 */     setRotation(this.Tail20, 0.0F, 0.0F, 1.22173F);
/* 174 */     this.Tail19 = new ModelRenderer((ModelBase)this, 32, 0);
/* 175 */     this.Tail19.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 176 */     this.Tail19.func_78793_a(-37.0F, -72.0F, 1.0F);
/* 177 */     setRotation(this.Tail19, 0.0F, 0.0174533F, 0.4363323F);
/* 178 */     this.Tail18 = new ModelRenderer((ModelBase)this, 32, 0);
/* 179 */     this.Tail18.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 180 */     this.Tail18.func_78793_a(-43.0F, -58.0F, 1.0F);
/* 181 */     setRotation(this.Tail18, 0.0F, 0.0F, -0.1745329F);
/* 182 */     this.Tail17 = new ModelRenderer((ModelBase)this, 32, 0);
/* 183 */     this.Tail17.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 184 */     this.Tail17.func_78793_a(-40.0F, -44.0F, 1.0F);
/* 185 */     setRotation(this.Tail17, 0.0F, 0.0174533F, -0.6981317F);
/* 186 */     this.Tail16 = new ModelRenderer((ModelBase)this, 32, 0);
/* 187 */     this.Tail16.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 188 */     this.Tail16.func_78793_a(-30.0F, -33.0F, 1.0F);
/* 189 */     setRotation(this.Tail16, 0.0F, 0.0F, -1.22173F);
/* 190 */     this.Tail15 = new ModelRenderer((ModelBase)this, 32, 0);
/* 191 */     this.Tail15.func_78789_a(0.0F, 0.0F, 0.0F, 10, 12, 8);
/* 192 */     this.Tail15.func_78793_a(-16.0F, -28.0F, 1.0F);
/* 193 */     setRotation(this.Tail15, 0.0F, 0.0174533F, -1.658063F);
/* 194 */     this.Tail14 = new ModelRenderer((ModelBase)this, 32, 0);
/* 195 */     this.Tail14.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 196 */     this.Tail14.func_78793_a(-4.0F, -29.0F, 1.0F);
/* 197 */     setRotation(this.Tail14, 0.0F, 0.0F, -1.919862F);
/* 198 */     this.Tail13 = new ModelRenderer((ModelBase)this, 32, 0);
/* 199 */     this.Tail13.func_78789_a(0.0F, 0.0F, 0.0F, 10, 24, 8);
/* 200 */     this.Tail13.func_78793_a(10.0F, -34.0F, 1.0F);
/* 201 */     setRotation(this.Tail13, 0.0F, 0.0174533F, -2.234021F);
/* 202 */     this.Tail12 = new ModelRenderer((ModelBase)this, 32, 0);
/* 203 */     this.Tail12.func_78789_a(0.0F, 0.0F, 0.0F, 10, 12, 8);
/* 204 */     this.Tail12.func_78793_a(25.0F, -47.0F, 1.0F);
/* 205 */     setRotation(this.Tail12, 0.0F, 0.0F, -1.919862F);
/* 206 */     this.Tail11 = new ModelRenderer((ModelBase)this, 32, 0);
/* 207 */     this.Tail11.func_78789_a(0.0F, 0.0F, 0.0F, 10, 18, 8);
/* 208 */     this.Tail11.func_78793_a(30.5F, -51.5F, 1.0F);
/* 209 */     setRotation(this.Tail11, 0.0F, 0.0174533F, -1.343904F);
/* 210 */     this.Tail10 = new ModelRenderer((ModelBase)this, 32, 0);
/* 211 */     this.Tail10.func_78789_a(0.0F, 0.0F, 0.0F, 10, 18, 8);
/* 212 */     this.Tail10.func_78793_a(41.0F, -54.0F, 1.0F);
/* 213 */     setRotation(this.Tail10, 0.0F, 0.0F, -0.3490659F);
/* 214 */     this.Tail9 = new ModelRenderer((ModelBase)this, 32, 0);
/* 215 */     this.Tail9.func_78789_a(0.0F, 0.0F, 0.0F, 10, 14, 8);
/* 216 */     this.Tail9.func_78793_a(47.0F, -42.7F, 1.0F);
/* 217 */     setRotation(this.Tail9, 0.0F, 0.0174533F, 0.1745329F);
/* 218 */     this.Tail8 = new ModelRenderer((ModelBase)this, 32, 0);
/* 219 */     this.Tail8.func_78789_a(0.0F, 0.0F, 0.0F, 10, 14, 8);
/* 220 */     this.Tail8.func_78793_a(48.0F, -35.0F, 1.0F);
/* 221 */     setRotation(this.Tail8, 0.0F, 0.0F, 0.8726646F);
/* 222 */     this.Tail7 = new ModelRenderer((ModelBase)this, 32, 0);
/* 223 */     this.Tail7.func_78789_a(0.0F, 0.0F, 0.0F, 10, 9, 8);
/* 224 */     this.Tail7.func_78793_a(44.0F, -28.0F, 1.0F);
/* 225 */     setRotation(this.Tail7, 0.0F, 0.0174533F, 1.570796F);
/* 226 */     this.Tail6 = new ModelRenderer((ModelBase)this, 32, 0);
/* 227 */     this.Tail6.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 228 */     this.Tail6.func_78793_a(39.0F, -27.0F, 1.0F);
/* 229 */     setRotation(this.Tail6, 0.0F, 0.0F, 1.919862F);
/* 230 */     this.Tail5 = new ModelRenderer((ModelBase)this, 32, 0);
/* 231 */     this.Tail5.func_78789_a(0.0F, 0.0F, 0.0F, 10, 18, 8);
/* 232 */     this.Tail5.func_78793_a(25.0F, -32.0F, 1.0F);
/* 233 */     setRotation(this.Tail5, 0.0174533F, 0.0F, 1.308997F);
/* 234 */     this.Tail4 = new ModelRenderer((ModelBase)this, 32, 0);
/* 235 */     this.Tail4.func_78789_a(0.0F, 0.0F, 0.0F, 10, 15, 8);
/* 236 */     this.Tail4.func_78793_a(8.0F, -27.0F, 1.0F);
/* 237 */     setRotation(this.Tail4, 0.0F, 0.0F, 0.8552113F);
/* 238 */     this.Tail3 = new ModelRenderer((ModelBase)this, 0, 0);
/* 239 */     this.Tail3.func_78789_a(0.0F, 0.0F, 0.0F, 8, 15, 8);
/* 240 */     this.Tail3.func_78793_a(-3.3F, -17.0F, 1.0F);
/* 241 */     setRotation(this.Tail3, -0.0349066F, 0.0F, 0.0523599F);
/* 242 */     this.Tail2 = new ModelRenderer((ModelBase)this, 0, 0);
/* 243 */     this.Tail2.func_78789_a(0.0F, 0.0F, 0.0F, 8, 15, 8);
/* 244 */     this.Tail2.func_78793_a(-4.0F, -5.0F, 1.0F);
/* 245 */     setRotation(this.Tail2, -0.4363323F, 0.0F, 0.0F);
/* 246 */     this.HornHori1 = new ModelRenderer((ModelBase)this, 50, 34);
/* 247 */     this.HornHori1.func_78789_a(0.0F, 0.0F, 0.0F, 5, 2, 1);
/* 248 */     this.HornHori1.func_78793_a(5.5F, -74.0F, 5.0F);
/* 249 */     setRotation(this.HornHori1, -0.6283185F, 0.0F, -0.4120629F);
/* 250 */     this.HornVer1 = new ModelRenderer((ModelBase)this, 31, 34);
/* 251 */     this.HornVer1.func_78789_a(0.0F, 0.0F, 0.0F, 2, 2, 7);
/* 252 */     this.HornVer1.func_78793_a(8.0F, -71.0F, 1.0F);
/* 253 */     setRotation(this.HornVer1, 0.8726646F, 0.0F, -0.3490659F);
/* 254 */     this.HornHori2 = new ModelRenderer((ModelBase)this, 50, 34);
/* 255 */     this.HornHori2.func_78789_a(0.0F, 0.0F, 0.0F, 5, 2, 1);
/* 256 */     this.HornHori2.func_78793_a(13.7F, -75.5F, 6.0F);
/* 257 */     setRotation(this.HornHori2, -0.6283185F, 0.0F, 0.4014257F);
/* 258 */     this.HornVer2 = new ModelRenderer((ModelBase)this, 31, 34);
/* 259 */     this.HornVer2.func_78789_a(0.0F, 0.0F, 0.0F, 2, 2, 7);
/* 260 */     this.HornVer2.func_78793_a(14.0F, -71.0F, 1.0F);
/* 261 */     setRotation(this.HornVer2, 0.8726646F, 0.0F, 0.3490659F);
/* 262 */     this.Arm1 = new ModelRenderer((ModelBase)this, 14, 44);
/* 263 */     this.Arm1.func_78789_a(0.0F, 0.0F, 0.0F, 6, 2, 2);
/* 264 */     this.Arm1.func_78793_a(-26.0F, -26.0F, 4.0F);
/* 265 */     setRotation(this.Arm1, 0.0F, 0.0F, -1.22173F);
/* 266 */     this.HAnd1 = new ModelRenderer((ModelBase)this, 0, 44);
/* 267 */     this.HAnd1.func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 2);
/* 268 */     this.HAnd1.func_78793_a(-27.0F, -27.0F, 4.0F);
/* 269 */     setRotation(this.HAnd1, 0.0F, 0.0F, -0.2617994F);
/* 270 */     this.Claw11 = new ModelRenderer((ModelBase)this, 0, 51);
/* 271 */     this.Claw11.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 272 */     this.Claw11.func_78793_a(-24.0F, -26.0F, 4.0F);
/* 273 */     setRotation(this.Claw11, 0.0F, 0.0F, 0.8726646F);
/* 274 */     this.Claw12 = new ModelRenderer((ModelBase)this, 0, 51);
/* 275 */     this.Claw12.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 276 */     this.Claw12.func_78793_a(-29.5F, -24.5F, 4.0F);
/* 277 */     setRotation(this.Claw12, 0.0F, 0.0F, -0.5410521F);
/* 278 */     this.Claw13 = new ModelRenderer((ModelBase)this, 0, 51);
/* 279 */     this.Claw13.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 280 */     this.Claw13.func_78793_a(-25.0F, -25.0F, 4.0F);
/* 281 */     setRotation(this.Claw13, 0.0F, 0.0F, 1.745329F);
/* 282 */     this.Claw14 = new ModelRenderer((ModelBase)this, 0, 51);
/* 283 */     this.Claw14.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 284 */     this.Claw14.func_78793_a(-26.0F, -26.0F, 4.0F);
/* 285 */     setRotation(this.Claw14, 0.0F, 0.0F, -2.984513F);
/* 286 */     this.Arm2 = new ModelRenderer((ModelBase)this, 14, 44);
/* 287 */     this.Arm2.func_78789_a(0.0F, 0.0F, 0.0F, 6, 2, 2);
/* 288 */     this.Arm2.func_78793_a(-21.0F, -39.0F, 4.0F);
/* 289 */     setRotation(this.Arm2, 0.0F, 0.0F, -1.22173F);
/* 290 */     this.HAnd2 = new ModelRenderer((ModelBase)this, 0, 44);
/* 291 */     this.HAnd2.func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 2);
/* 292 */     this.HAnd2.func_78793_a(-19.5F, -46.0F, 4.0F);
/* 293 */     setRotation(this.HAnd2, 0.0F, 0.0F, -0.2617994F);
/* 294 */     this.Claw21 = new ModelRenderer((ModelBase)this, 0, 51);
/* 295 */     this.Claw21.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 296 */     this.Claw21.func_78793_a(-16.5F, -44.8F, 4.0F);
/* 297 */     setRotation(this.Claw21, 0.0F, 0.0F, -0.2708875F);
/* 298 */     this.Claw22 = new ModelRenderer((ModelBase)this, 0, 51);
/* 299 */     this.Claw22.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 300 */     this.Claw22.func_78793_a(-17.0F, -46.0F, 4.0F);
/* 301 */     setRotation(this.Claw22, 0.0F, 0.0F, -0.5410521F);
/* 302 */     this.Claw23 = new ModelRenderer((ModelBase)this, 0, 51);
/* 303 */     this.Claw23.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 304 */     this.Claw23.func_78793_a(-18.0F, -50.0F, 4.0F);
/* 305 */     setRotation(this.Claw23, 0.0F, 0.0F, 1.361357F);
/* 306 */     this.Claw24 = new ModelRenderer((ModelBase)this, 0, 51);
/* 307 */     this.Claw24.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 308 */     this.Claw24.func_78793_a(-18.93333F, -45.0F, 4.0F);
/* 309 */     setRotation(this.Claw24, 0.0F, 0.0F, -2.600541F);
/* 310 */     this.Arm3 = new ModelRenderer((ModelBase)this, 14, 44);
/* 311 */     this.Arm3.func_78789_a(0.0F, 0.0F, 0.0F, 6, 2, 2);
/* 312 */     this.Arm3.func_78793_a(23.0F, -18.0F, 4.0F);
/* 313 */     setRotation(this.Arm3, 0.0F, 0.0F, -0.6806784F);
/* 314 */     this.HAnd3 = new ModelRenderer((ModelBase)this, 0, 44);
/* 315 */     this.HAnd3.func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 2);
/* 316 */     this.HAnd3.func_78793_a(21.5F, -18.0F, 4.0F);
/* 317 */     setRotation(this.HAnd3, 0.0F, 0.0F, 0.0698132F);
/* 318 */     this.Claw31 = new ModelRenderer((ModelBase)this, 0, 51);
/* 319 */     this.Claw31.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 320 */     this.Claw31.func_78793_a(22.0F, -17.0F, 4.0F);
/* 321 */     setRotation(this.Claw31, 0.0F, 0.0F, 2.941758F);
/* 322 */     this.Claw32 = new ModelRenderer((ModelBase)this, 0, 51);
/* 323 */     this.Claw32.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 324 */     this.Claw32.func_78793_a(24.3F, -15.0F, 4.0F);
/* 325 */     setRotation(this.Claw32, 0.0F, 0.0F, 1.429414F);
/* 326 */     this.Claw33 = new ModelRenderer((ModelBase)this, 0, 51);
/* 327 */     this.Claw33.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 328 */     this.Claw33.func_78793_a(22.0F, -15.5F, 4.0F);
/* 329 */     setRotation(this.Claw33, 0.0F, 0.0F, 2.588251F);
/* 330 */     this.Claw34 = new ModelRenderer((ModelBase)this, 0, 51);
/* 331 */     this.Claw34.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 332 */     this.Claw34.func_78793_a(23.0F, -15.0F, 4.0F);
/* 333 */     setRotation(this.Claw34, 0.0F, 0.0F, 1.972429F);
/* 334 */     this.Arm4 = new ModelRenderer((ModelBase)this, 14, 44);
/* 335 */     this.Arm4.func_78789_a(0.0F, 0.0F, 0.0F, 6, 2, 2);
/* 336 */     this.Arm4.func_78793_a(28.0F, -31.0F, 4.0F);
/* 337 */     setRotation(this.Arm4, 0.0F, 0.0F, -0.6806784F);
/* 338 */     this.HAnd4 = new ModelRenderer((ModelBase)this, 0, 44);
/* 339 */     this.HAnd4.func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 2);
/* 340 */     this.HAnd4.func_78793_a(32.5F, -36.0F, 4.0F);
/* 341 */     setRotation(this.HAnd4, 0.0F, 0.0F, 0.0698132F);
/* 342 */     this.Claw41 = new ModelRenderer((ModelBase)this, 0, 51);
/* 343 */     this.Claw41.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 344 */     this.Claw41.func_78793_a(32.5F, -35.5F, 4.0F);
/* 345 */     setRotation(this.Claw41, 0.0F, 0.0F, -1.296604F);
/* 346 */     this.Claw42 = new ModelRenderer((ModelBase)this, 0, 51);
/* 347 */     this.Claw42.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 348 */     this.Claw42.func_78793_a(35.0F, -33.7F, 4.0F);
/* 349 */     setRotation(this.Claw42, 0.0F, 0.0F, -0.2808018F);
/* 350 */     this.Claw43 = new ModelRenderer((ModelBase)this, 0, 51);
/* 351 */     this.Claw43.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 352 */     this.Claw43.func_78793_a(39.0F, -36.0F, 4.0F);
/* 353 */     setRotation(this.Claw43, 0.0F, 0.0F, 2.774144F);
/* 354 */     this.Claw44 = new ModelRenderer((ModelBase)this, 0, 51);
/* 355 */     this.Claw44.func_78789_a(0.0F, 0.0F, 0.0F, 4, 1, 2);
/* 356 */     this.Claw44.func_78793_a(36.5F, -38.8F, 4.0F);
/* 357 */     setRotation(this.Claw44, 0.0F, 0.0F, 2.009607F);
/* 358 */     this.Fin1 = new ModelRenderer((ModelBase)this, 70, 21);
/* 359 */     this.Fin1.func_78789_a(0.0F, 0.0F, 0.0F, 0, 20, 6);
/* 360 */     this.Fin1.func_78793_a(0.0F, 1.0F, 5.5F);
/* 361 */     setRotation(this.Fin1, -0.3346075F, 0.0F, 0.0F);
/* 362 */     this.Fin2 = new ModelRenderer((ModelBase)this, 70, 0);
/* 363 */     this.Fin2.func_78789_a(0.0F, 0.0F, 0.0F, 0, 15, 4);
/* 364 */     this.Fin2.func_78793_a(0.0F, -12.0F, 7.0F);
/* 365 */     setRotation(this.Fin2, 0.0F, 0.0F, 0.0F);
/* 366 */     this.Fin3 = new ModelRenderer((ModelBase)this, 70, 0);
/* 367 */     this.Fin3.func_78789_a(0.0F, 0.0F, 0.0F, 0, 15, 4);
/* 368 */     this.Fin3.func_78793_a(0.0F, -12.0F, 7.0F);
/* 369 */     setRotation(this.Fin3, 0.0F, 0.0F, -2.398021F);
/* 370 */     this.Fin4 = new ModelRenderer((ModelBase)this, 70, 0);
/* 371 */     this.Fin4.func_78789_a(0.0F, 0.0F, 0.0F, 0, 15, 4);
/* 372 */     this.Fin4.func_78793_a(10.3F, -23.0F, 7.0F);
/* 373 */     setRotation(this.Fin4, 0.0F, 0.0F, -1.840341F);
/* 374 */     this.Fin5 = new ModelRenderer((ModelBase)this, 70, 0);
/* 375 */     this.Fin5.func_78789_a(0.0F, 0.0F, 0.0F, 0, 15, 4);
/* 376 */     this.Fin5.func_78793_a(25.0F, -27.0F, 7.0F);
/* 377 */     setRotation(this.Fin5, 0.0F, 0.0F, -1.245484F);
/* 378 */     this.Fin6 = new ModelRenderer((ModelBase)this, 70, 0);
/* 379 */     this.Fin6.func_78789_a(0.0F, 0.0F, 0.0F, 0, 15, 4);
/* 380 */     this.Fin6.func_78793_a(39.0F, -22.0F, 7.0F);
/* 381 */     setRotation(this.Fin6, 0.0F, 0.0F, -2.286485F);
/* 382 */     this.Fin7 = new ModelRenderer((ModelBase)this, 70, 0);
/* 383 */     this.Fin7.func_78789_a(0.0F, 0.0F, 0.0F, 0, 10, 4);
/* 384 */     this.Fin7.func_78793_a(50.5F, -31.7F, 7.0F);
/* 385 */     setRotation(this.Fin7, 0.0F, 0.0F, -3.067235F);
/* 386 */     this.Fin8 = new ModelRenderer((ModelBase)this, 70, 0);
/* 387 */     this.Fin8.func_78789_a(0.0F, 0.0F, 0.0F, 0, 13, 4);
/* 388 */     this.Fin8.func_78793_a(51.5F, -41.5F, 7.0F);
/* 389 */     setRotation(this.Fin8, 0.0F, 0.0F, 2.769806F);
/* 390 */     this.Fin9 = new ModelRenderer((ModelBase)this, 70, 0);
/* 391 */     this.Fin9.func_78789_a(0.0F, 0.0F, 0.0F, 0, 12, 4);
/* 392 */     this.Fin9.func_78793_a(46.5F, -53.5F, 7.0F);
/* 393 */     setRotation(this.Fin9, 0.0F, 0.0F, 1.765984F);
/* 394 */     this.Fin10 = new ModelRenderer((ModelBase)this, 70, 0);
/* 395 */     this.Fin10.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 396 */     this.Fin10.func_78793_a(35.0F, -55.7F, 7.0F);
/* 397 */     setRotation(this.Fin10, 0.0F, 0.0F, 1.208305F);
/* 398 */     this.Fin11 = new ModelRenderer((ModelBase)this, 70, 0);
/* 399 */     this.Fin11.func_78789_a(0.0F, 0.0F, 0.0F, 0, 23, 4);
/* 400 */     this.Fin11.func_78793_a(25.0F, -51.8F, 7.0F);
/* 401 */     setRotation(this.Fin11, 0.0F, 0.0F, 0.9480546F);
/* 402 */     this.Fin12 = new ModelRenderer((ModelBase)this, 70, 0);
/* 403 */     this.Fin12.func_78789_a(0.0F, 0.0F, 0.0F, 0, 13, 4);
/* 404 */     this.Fin12.func_78793_a(6.5F, -38.3F, 7.0F);
/* 405 */     setRotation(this.Fin12, 0.0F, 0.0F, 1.282662F);
/* 406 */     this.Fin13 = new ModelRenderer((ModelBase)this, 70, 0);
/* 407 */     this.Fin13.func_78789_a(0.0F, 0.0F, 0.0F, 0, 13, 4);
/* 408 */     this.Fin13.func_78793_a(-6.0F, -34.5F, 7.0F);
/* 409 */     setRotation(this.Fin13, 0.0F, 0.0F, 1.580091F);
/* 410 */     this.Fin14 = new ModelRenderer((ModelBase)this, 70, 0);
/* 411 */     this.Fin14.func_78789_a(0.0F, 0.0F, 0.0F, 0, 13, 4);
/* 412 */     this.Fin14.func_78793_a(-19.0F, -34.5F, 7.0F);
/* 413 */     setRotation(this.Fin14, 0.0F, 0.0F, 1.989056F);
/* 414 */     this.Fin15 = new ModelRenderer((ModelBase)this, 70, 0);
/* 415 */     this.Fin15.func_78789_a(0.0F, 0.0F, 0.0F, 0, 10, 4);
/* 416 */     this.Fin15.func_78793_a(-30.7F, -39.5F, 7.0F);
/* 417 */     setRotation(this.Fin15, 0.0F, 0.0F, 2.583914F);
/* 418 */     this.Fin16 = new ModelRenderer((ModelBase)this, 70, 0);
/* 419 */     this.Fin16.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 420 */     this.Fin16.func_78793_a(-36.1F, -47.9F, 7.0F);
/* 421 */     setRotation(this.Fin16, 0.0F, 0.0F, 2.9557F);
/* 422 */     this.Fin17 = new ModelRenderer((ModelBase)this, 70, 0);
/* 423 */     this.Fin17.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 424 */     this.Fin17.func_78793_a(-38.3F, -58.8F, 7.0F);
/* 425 */     setRotation(this.Fin17, 0.0F, 0.0F, -2.732628F);
/* 426 */     this.Fin18 = new ModelRenderer((ModelBase)this, 70, 0);
/* 427 */     this.Fin18.func_78789_a(0.0F, 0.0F, -1.0F, 0, 11, 4);
/* 428 */     this.Fin18.func_78793_a(-33.8F, -68.7F, 8.0F);
/* 429 */     setRotation(this.Fin18, 0.0F, 0.0F, -1.989056F);
/* 430 */     this.Fin19 = new ModelRenderer((ModelBase)this, 70, 0);
/* 431 */     this.Fin19.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 432 */     this.Fin19.func_78793_a(-24.0F, -73.0F, 7.0F);
/* 433 */     setRotation(this.Fin19, 0.0F, 0.0F, -1.022412F);
/* 434 */     this.Fin20 = new ModelRenderer((ModelBase)this, 70, 0);
/* 435 */     this.Fin20.func_78789_a(0.0F, 0.0F, 0.0F, 0, 13, 4);
/* 436 */     this.Fin20.func_78793_a(-15.0F, -67.4F, 7.0F);
/* 437 */     setRotation(this.Fin20, 0.0F, 0.0F, -0.6134471F);
/* 438 */     this.Fin21 = new ModelRenderer((ModelBase)this, 70, 0);
/* 439 */     this.Fin21.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 440 */     this.Fin21.func_78793_a(-7.6F, -56.7F, 7.0F);
/* 441 */     setRotation(this.Fin21, 0.0F, 0.0F, -1.394198F);
/* 442 */     this.Fin22 = new ModelRenderer((ModelBase)this, 70, 0);
/* 443 */     this.Fin22.func_78789_a(0.0F, 0.0F, 0.0F, 0, 11, 4);
/* 444 */     this.Fin22.func_78793_a(3.0F, -54.8F, 7.0F);
/* 445 */     setRotation(this.Fin22, 0.0F, 0.0F, -2.249306F);
/* 446 */     this.Fin23 = new ModelRenderer((ModelBase)this, 70, 0);
/* 447 */     this.Fin23.func_78789_a(0.0F, 0.0F, 0.0F, 0, 7, 4);
/* 448 */     this.Fin23.func_78793_a(11.6F, -61.5F, 7.0F);
/* 449 */     setRotation(this.Fin23, 0.0F, 0.0F, -3.086961F);
/* 450 */     this.Fin24 = new ModelRenderer((ModelBase)this, 70, 0);
/* 451 */     this.Fin24.func_78789_a(0.0F, 0.0F, 0.0F, 0, 9, 4);
/* 452 */     this.Fin24.func_78793_a(12.0F, -65.0F, 8.8F);
/* 453 */     setRotation(this.Fin24, -1.003822F, 0.0F, -3.104414F);
/* 454 */     this.Wisker1 = new ModelRenderer((ModelBase)this, 80, 0);
/* 455 */     this.Wisker1.func_78789_a(0.0F, 0.0F, 0.0F, 1, 14, 1);
/* 456 */     this.Wisker1.func_78793_a(9.0F, -61.0F, -8.5F);
/* 457 */     setRotation(this.Wisker1, -0.0698132F, 0.0F, 0.6632251F);
/* 458 */     this.Wisker2 = new ModelRenderer((ModelBase)this, 80, 0);
/* 459 */     this.Wisker2.func_78789_a(0.0F, 0.0F, 0.0F, 1, 14, 1);
/* 460 */     this.Wisker2.func_78793_a(14.0F, -61.0F, -8.5F);
/* 461 */     setRotation(this.Wisker2, 0.0698132F, 0.0F, -0.6632251F);
/* 462 */     this.FaceFin2 = new ModelRenderer((ModelBase)this, 15, 50);
/* 463 */     this.FaceFin2.func_78789_a(0.0F, 0.0F, 0.0F, 6, 9, 0);
/* 464 */     this.FaceFin2.func_78793_a(14.0F, -69.0F, -2.0F);
/* 465 */     setRotation(this.FaceFin2, 0.2268928F, 0.0F, 0.0F);
/* 466 */     this.FaceFin1 = new ModelRenderer((ModelBase)this, 15, 50);
/* 467 */     this.FaceFin1.func_78789_a(0.0F, 0.0F, 0.0F, 6, 9, 0);
/* 468 */     this.FaceFin1.func_78793_a(4.0F, -69.0F, -2.0F);
/* 469 */     setRotation(this.FaceFin1, 0.2268928F, 0.0F, 0.0F);
/*     */     
/* 471 */     this.head.func_78792_a(this.dragon5);
/* 472 */     this.head.func_78792_a(this.dragon7);
/* 473 */     this.head.func_78792_a(this.dragon6);
/* 474 */     this.head.func_78792_a(this.dragon12);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 479 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 480 */     this.head.func_78785_a(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 485 */     model.field_78795_f = x;
/* 486 */     model.field_78796_g = y;
/* 487 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderModel(Entity entity, float f) {
/* 498 */     func_78088_a(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelEarthDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */