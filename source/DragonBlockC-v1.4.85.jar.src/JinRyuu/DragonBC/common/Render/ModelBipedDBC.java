/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
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
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBipedDBC
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer bipedHead;
/*     */   public ModelRenderer bipedBody;
/*     */   public ModelRenderer bipedRightArm;
/*     */   public ModelRenderer bipedLeftArm;
/*     */   public ModelRenderer bipedRightLeg;
/*     */   public ModelRenderer bipedLeftLeg;
/*     */   public ModelRenderer bipedEars;
/*     */   public ModelRenderer bipedCloak;
/*     */   public ModelRenderer leftarmshoulder;
/*     */   public ModelRenderer rightarmshoulder;
/*     */   public ModelRenderer goku1;
/*     */   public ModelRenderer goku2;
/*     */   public ModelRenderer goku3;
/*     */   public ModelRenderer goku4;
/*     */   public ModelRenderer goku5;
/*     */   public ModelRenderer goku6;
/*     */   public ModelRenderer goku7;
/*     */   public ModelRenderer goku8;
/*     */   public ModelRenderer goku9;
/*     */   public ModelRenderer goku10;
/*     */   public ModelRenderer goku11;
/*     */   public ModelRenderer goku12;
/*     */   public ModelRenderer goku13;
/*     */   public ModelRenderer goku14;
/*     */   public ModelRenderer goku15;
/*     */   public ModelRenderer goku16;
/*     */   public ModelRenderer sgoku1;
/*     */   public ModelRenderer sgoku2;
/*     */   public ModelRenderer sgoku3;
/*     */   public ModelRenderer sgoku4;
/*     */   public ModelRenderer sgoku5;
/*     */   public ModelRenderer sgoku6;
/*     */   public ModelRenderer sgoku7;
/*     */   public ModelRenderer sgoku8;
/*     */   public ModelRenderer sgoku9;
/*     */   public ModelRenderer sgoku10;
/*     */   public ModelRenderer sgoku11;
/*     */   public ModelRenderer sgoku12;
/*     */   public ModelRenderer sgoku13;
/*     */   public ModelRenderer sgoku14;
/*     */   public ModelRenderer sgoku15;
/*     */   public ModelRenderer sgoku16;
/*     */   public ModelRenderer sgoku17;
/*     */   public ModelRenderer sgoku18;
/*     */   public ModelRenderer sgoku19;
/*     */   public ModelRenderer sgoku20;
/*     */   public ModelRenderer sgoku21;
/*     */   public ModelRenderer sgoku22;
/*     */   public ModelRenderer sgoku23;
/*     */   public ModelRenderer sgoku24;
/*     */   public ModelRenderer sgoku25;
/*     */   public ModelRenderer sgoku26;
/*     */   public ModelRenderer trunk1;
/*     */   public ModelRenderer trunk2;
/*     */   public ModelRenderer trunk3;
/*     */   public ModelRenderer trunk4;
/*     */   public ModelRenderer trunk5;
/*     */   public ModelRenderer trunk6;
/*     */   public ModelRenderer trunk7;
/*     */   public ModelRenderer trunk8;
/*     */   public ModelRenderer trunk9;
/*     */   public ModelRenderer strunk1;
/*     */   public ModelRenderer strunk2;
/*     */   public ModelRenderer strunk3;
/*     */   public ModelRenderer strunk4;
/*     */   public ModelRenderer strunk5;
/*     */   public ModelRenderer strunk6;
/*     */   public ModelRenderer strunk7;
/*     */   public ModelRenderer strunk8;
/*     */   public ModelRenderer strunk9;
/*     */   public ModelRenderer strunk10;
/*     */   public ModelRenderer strunk11;
/*     */   public ModelRenderer strunk12;
/*     */   public ModelRenderer strunk13;
/*     */   public ModelRenderer strunk14;
/*     */   public ModelRenderer strunk15;
/*     */   public ModelRenderer strunk16;
/*     */   public ModelRenderer strunk17;
/*     */   public int heldItemLeft;
/*     */   public int heldItemRight;
/*     */   public boolean isSneak;
/*     */   public boolean aimedBow;
/*     */   
/*     */   public ModelBipedDBC() {
/* 115 */     this(0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedDBC(float par1) {
/* 120 */     this(par1, 0.0F, 64, 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModelBipedDBC(float par1, float par2, int par3, int par4) {
/* 125 */     this.heldItemLeft = 0;
/* 126 */     this.heldItemRight = 0;
/* 127 */     this.isSneak = false;
/* 128 */     this.aimedBow = false;
/* 129 */     this.field_78090_t = 128;
/* 130 */     this.field_78089_u = 64;
/* 131 */     this.bipedCloak = new ModelRenderer(this, 0, 0);
/* 132 */     this.bipedCloak.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1);
/* 133 */     this.bipedEars = new ModelRenderer(this, 24, 0);
/* 134 */     this.bipedEars.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1);
/* 135 */     this.bipedHead = new ModelRenderer(this, 0, 0);
/* 136 */     this.bipedHead.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.02F);
/* 137 */     this.bipedHead.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/*     */ 
/*     */ 
/*     */     
/* 141 */     this.bipedBody = new ModelRenderer(this, 16, 16);
/* 142 */     this.bipedBody.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
/* 143 */     this.bipedBody.func_78793_a(0.0F, 0.0F + par2, 0.0F);
/* 144 */     this.bipedRightArm = new ModelRenderer(this, 40, 16);
/* 145 */     this.bipedRightArm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
/* 146 */     this.bipedRightArm.func_78793_a(-5.0F, 2.0F + par2, 0.0F);
/* 147 */     this.bipedLeftArm = new ModelRenderer(this, 40, 16);
/* 148 */     this.bipedLeftArm.field_78809_i = true;
/* 149 */     this.bipedLeftArm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
/* 150 */     this.bipedLeftArm.func_78793_a(5.0F, 2.0F + par2, 0.0F);
/* 151 */     this.bipedRightLeg = new ModelRenderer(this, 0, 16);
/* 152 */     this.bipedRightLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
/* 153 */     this.bipedRightLeg.func_78793_a(-1.9F, 12.0F + par2, 0.0F);
/* 154 */     this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
/* 155 */     this.bipedLeftLeg.field_78809_i = true;
/* 156 */     this.bipedLeftLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
/* 157 */     this.bipedLeftLeg.func_78793_a(1.9F, 12.0F + par2, 0.0F);
/* 158 */     this.rightarmshoulder = new ModelRenderer(this, 40, 32);
/* 159 */     this.rightarmshoulder.func_78789_a(-6.0F, -4.0F, -3.0F, 7, 4, 6);
/* 160 */     this.rightarmshoulder.func_78793_a(-5.0F, 3.0F, 0.0F);
/* 161 */     this.rightarmshoulder.func_78787_b(128, 64);
/* 162 */     this.leftarmshoulder = new ModelRenderer(this, 40, 32);
/* 163 */     this.leftarmshoulder.field_78809_i = true;
/* 164 */     this.leftarmshoulder.func_78789_a(-1.0F, -4.0F, -3.0F, 7, 4, 6);
/* 165 */     this.leftarmshoulder.func_78793_a(5.0F, 3.0F, 0.0F);
/* 166 */     this.leftarmshoulder.func_78787_b(128, 64);
/*     */     
/* 168 */     this.goku1 = new ModelRenderer(this, 64, 0);
/* 169 */     this.goku1.func_78789_a(-1.0F, -10.0F, 0.0F, 4, 4, 4);
/* 170 */     this.goku1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.goku1.func_78787_b(128, 64);
/* 172 */     this.goku1.field_78809_i = true;
/* 173 */     setRotation(this.goku1, 0.1745329F, 0.0F, -0.4363323F);
/* 174 */     this.goku2 = new ModelRenderer(this, 64, 0);
/* 175 */     this.goku2.func_78789_a(-8.0F, -4.5F, 0.0F, 4, 3, 3);
/* 176 */     this.goku2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 177 */     this.goku2.func_78787_b(128, 64);
/* 178 */     this.goku2.field_78809_i = true;
/* 179 */     setRotation(this.goku2, 0.0F, -0.1745329F, 0.3490659F);
/* 180 */     this.goku3 = new ModelRenderer(this, 64, 0);
/* 181 */     this.goku3.func_78789_a(-7.0F, -2.6F, 1.0F, 4, 2, 2);
/* 182 */     this.goku3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 183 */     this.goku3.func_78787_b(128, 64);
/* 184 */     this.goku3.field_78809_i = true;
/* 185 */     setRotation(this.goku3, 0.0F, -0.2617994F, 0.1943133F);
/* 186 */     this.goku4 = new ModelRenderer(this, 64, 0);
/* 187 */     this.goku4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3);
/* 188 */     this.goku4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 189 */     this.goku4.func_78787_b(128, 64);
/* 190 */     this.goku4.field_78809_i = true;
/* 191 */     setRotation(this.goku4, 0.0F, 0.1745329F, -0.3490659F);
/* 192 */     this.goku5 = new ModelRenderer(this, 64, 0);
/* 193 */     this.goku5.func_78789_a(3.0F, -2.3F, 0.7F, 3, 2, 2);
/* 194 */     this.goku5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 195 */     this.goku5.func_78787_b(128, 64);
/* 196 */     this.goku5.field_78809_i = true;
/* 197 */     setRotation(this.goku5, 0.0F, 0.1745329F, -0.1151917F);
/* 198 */     this.goku6 = new ModelRenderer(this, 64, 0);
/* 199 */     this.goku6.func_78789_a(5.0F, -4.3F, 1.5F, 3, 2, 2);
/* 200 */     this.goku6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 201 */     this.goku6.func_78787_b(128, 64);
/* 202 */     this.goku6.field_78809_i = true;
/* 203 */     setRotation(this.goku6, 0.0F, 0.3490659F, -0.2617994F);
/* 204 */     this.goku7 = new ModelRenderer(this, 64, 0);
/* 205 */     this.goku7.func_78789_a(1.0F, -11.0F, 2.0F, 3, 3, 3);
/* 206 */     this.goku7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 207 */     this.goku7.func_78787_b(128, 64);
/* 208 */     this.goku7.field_78809_i = true;
/* 209 */     setRotation(this.goku7, 0.3490659F, 0.0F, -0.6108652F);
/* 210 */     this.goku8 = new ModelRenderer(this, 64, 0);
/* 211 */     this.goku8.func_78789_a(3.0F, -12.0F, 4.0F, 2, 3, 2);
/* 212 */     this.goku8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 213 */     this.goku8.func_78787_b(128, 64);
/* 214 */     this.goku8.field_78809_i = true;
/* 215 */     setRotation(this.goku8, 0.5235988F, 0.0F, -0.7853982F);
/* 216 */     this.goku9 = new ModelRenderer(this, 64, 0);
/* 217 */     this.goku9.func_78789_a(-9.0F, -4.7F, 1.5F, 3, 2, 2);
/* 218 */     this.goku9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 219 */     this.goku9.func_78787_b(128, 64);
/* 220 */     this.goku9.field_78809_i = true;
/* 221 */     setRotation(this.goku9, 0.0F, -0.3490659F, 0.2617994F);
/* 222 */     this.goku10 = new ModelRenderer(this, 64, 0);
/* 223 */     this.goku10.func_78789_a(-10.0F, -4.8F, 1.0F, 5, 2, 2);
/* 224 */     this.goku10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 225 */     this.goku10.func_78787_b(128, 64);
/* 226 */     this.goku10.field_78809_i = true;
/* 227 */     setRotation(this.goku10, 0.0F, -0.3839724F, 0.5270894F);
/* 228 */     this.goku11 = new ModelRenderer(this, 64, 0);
/* 229 */     this.goku11.func_78789_a(1.0F, -8.0F, 5.0F, 1, 4, 1);
/* 230 */     this.goku11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 231 */     this.goku11.func_78787_b(128, 64);
/* 232 */     this.goku11.field_78809_i = true;
/* 233 */     setRotation(this.goku11, 0.6806784F, 0.0F, -0.1745329F);
/* 234 */     this.goku12 = new ModelRenderer(this, 64, 0);
/* 235 */     this.goku12.func_78789_a(-3.5F, -7.0F, -5.0F, 2, 3, 3);
/* 236 */     this.goku12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 237 */     this.goku12.func_78787_b(128, 64);
/* 238 */     this.goku12.field_78809_i = true;
/* 239 */     setRotation(this.goku12, 0.0F, 0.0F, 0.4014257F);
/* 240 */     this.goku13 = new ModelRenderer(this, 64, 0);
/* 241 */     this.goku13.func_78789_a(-6.2F, -5.5F, -5.0F, 2, 3, 2);
/* 242 */     this.goku13.func_78793_a(0.0F, 0.0F, 0.0F);
/* 243 */     this.goku13.func_78787_b(128, 64);
/* 244 */     this.goku13.field_78809_i = true;
/* 245 */     setRotation(this.goku13, 0.0F, 0.0F, 0.5235988F);
/* 246 */     this.goku14 = new ModelRenderer(this, 64, 0);
/* 247 */     this.goku14.func_78789_a(-7.5F, -4.0F, -5.0F, 1, 3, 2);
/* 248 */     this.goku14.func_78793_a(0.0F, 0.0F, 0.0F);
/* 249 */     this.goku14.func_78787_b(128, 64);
/* 250 */     this.goku14.field_78809_i = true;
/* 251 */     setRotation(this.goku14, 0.0F, 0.0F, 0.6108652F);
/* 252 */     this.goku15 = new ModelRenderer(this, 64, 0);
/* 253 */     this.goku15.func_78789_a(3.2F, -6.5F, -5.0F, 2, 3, 2);
/* 254 */     this.goku15.func_78793_a(0.0F, 0.0F, 0.0F);
/* 255 */     this.goku15.func_78787_b(128, 64);
/* 256 */     this.goku15.field_78809_i = true;
/* 257 */     setRotation(this.goku15, 0.0F, 0.0F, -0.3490659F);
/* 258 */     this.goku16 = new ModelRenderer(this, 64, 0);
/* 259 */     this.goku16.func_78789_a(6.5F, -4.5F, -5.0F, 1, 3, 2);
/* 260 */     this.goku16.func_78793_a(0.0F, 0.0F, 0.0F);
/* 261 */     this.goku16.func_78787_b(128, 64);
/* 262 */     this.goku16.field_78809_i = true;
/* 263 */     setRotation(this.goku16, 0.0F, 0.0F, -0.6108652F);
/*     */     
/* 265 */     this.sgoku1 = new ModelRenderer(this, 80, 0);
/* 266 */     this.sgoku1.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 4, 4);
/* 267 */     this.sgoku1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 268 */     this.sgoku1.func_78787_b(128, 64);
/* 269 */     this.sgoku1.field_78809_i = true;
/* 270 */     setRotation(this.sgoku1, -0.3141593F, 0.0F, 0.0F);
/* 271 */     this.sgoku2 = new ModelRenderer(this, 80, 0);
/* 272 */     this.sgoku2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3);
/* 273 */     this.sgoku2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 274 */     this.sgoku2.func_78787_b(128, 64);
/* 275 */     this.sgoku2.field_78809_i = true;
/* 276 */     setRotation(this.sgoku2, 0.0F, 0.1745329F, 0.5759587F);
/* 277 */     this.sgoku3 = new ModelRenderer(this, 80, 0);
/* 278 */     this.sgoku3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2);
/* 279 */     this.sgoku3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 280 */     this.sgoku3.func_78787_b(128, 64);
/* 281 */     this.sgoku3.field_78809_i = true;
/* 282 */     setRotation(this.sgoku3, 0.0F, 0.2617994F, 0.5061455F);
/* 283 */     this.sgoku4 = new ModelRenderer(this, 80, 0);
/* 284 */     this.sgoku4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3);
/* 285 */     this.sgoku4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 286 */     this.sgoku4.func_78787_b(128, 64);
/* 287 */     this.sgoku4.field_78809_i = true;
/* 288 */     setRotation(this.sgoku4, 0.0F, -0.1745329F, -0.6108652F);
/* 289 */     this.sgoku5 = new ModelRenderer(this, 80, 0);
/* 290 */     this.sgoku5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2);
/* 291 */     this.sgoku5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 292 */     this.sgoku5.func_78787_b(128, 64);
/* 293 */     this.sgoku5.field_78809_i = true;
/* 294 */     setRotation(this.sgoku5, 0.0F, -0.1745329F, -0.5061455F);
/* 295 */     this.sgoku6 = new ModelRenderer(this, 80, 0);
/* 296 */     this.sgoku6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2);
/* 297 */     this.sgoku6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 298 */     this.sgoku6.func_78787_b(128, 64);
/* 299 */     this.sgoku6.field_78809_i = true;
/* 300 */     setRotation(this.sgoku6, 0.0F, -0.3490659F, -0.9250245F);
/* 301 */     this.sgoku7 = new ModelRenderer(this, 80, 0);
/* 302 */     this.sgoku7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3);
/* 303 */     this.sgoku7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 304 */     this.sgoku7.func_78787_b(128, 64);
/* 305 */     this.sgoku7.field_78809_i = true;
/* 306 */     setRotation(this.sgoku7, -0.4363323F, 0.0F, 0.0F);
/* 307 */     this.sgoku8 = new ModelRenderer(this, 80, 0);
/* 308 */     this.sgoku8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2);
/* 309 */     this.sgoku8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 310 */     this.sgoku8.func_78787_b(128, 64);
/* 311 */     this.sgoku8.field_78809_i = true;
/* 312 */     setRotation(this.sgoku8, -0.5934119F, 0.0F, 0.0F);
/* 313 */     this.sgoku9 = new ModelRenderer(this, 80, 0);
/* 314 */     this.sgoku9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2);
/* 315 */     this.sgoku9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 316 */     this.sgoku9.func_78787_b(128, 64);
/* 317 */     this.sgoku9.field_78809_i = true;
/* 318 */     setRotation(this.sgoku9, 0.0F, 0.3490659F, 0.8901179F);
/* 319 */     this.sgoku10 = new ModelRenderer(this, 80, 0);
/* 320 */     this.sgoku10.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 6, 4);
/* 321 */     this.sgoku10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 322 */     this.sgoku10.func_78787_b(128, 64);
/* 323 */     this.sgoku10.field_78809_i = true;
/* 324 */     setRotation(this.sgoku10, -0.4363323F, 0.0F, -0.4014257F);
/* 325 */     this.sgoku11 = new ModelRenderer(this, 80, 0);
/* 326 */     this.sgoku11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3);
/* 327 */     this.sgoku11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 328 */     this.sgoku11.func_78787_b(128, 64);
/* 329 */     this.sgoku11.field_78809_i = true;
/* 330 */     setRotation(this.sgoku11, -0.5410521F, 0.0F, -0.3665191F);
/* 331 */     this.sgoku12 = new ModelRenderer(this, 80, 0);
/* 332 */     this.sgoku12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3);
/* 333 */     this.sgoku12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 334 */     this.sgoku12.func_78787_b(128, 64);
/* 335 */     this.sgoku12.field_78809_i = true;
/* 336 */     setRotation(this.sgoku12, -0.6108652F, 0.0F, -0.2443461F);
/* 337 */     this.sgoku13 = new ModelRenderer(this, 80, 0);
/* 338 */     this.sgoku13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2);
/* 339 */     this.sgoku13.func_78793_a(0.0F, 0.0F, 0.0F);
/* 340 */     this.sgoku13.func_78787_b(128, 64);
/* 341 */     this.sgoku13.field_78809_i = true;
/* 342 */     setRotation(this.sgoku13, -0.6981317F, 0.0F, -0.122173F);
/* 343 */     this.sgoku14 = new ModelRenderer(this, 80, 0);
/* 344 */     this.sgoku14.func_78789_a(-1.5F, -9.0F, -5.0F, 3, 5, 3);
/* 345 */     this.sgoku14.func_78793_a(0.0F, 0.0F, 0.0F);
/* 346 */     this.sgoku14.func_78787_b(128, 64);
/* 347 */     this.sgoku14.field_78809_i = true;
/* 348 */     setRotation(this.sgoku14, -0.3665191F, 0.0F, 0.4363323F);
/* 349 */     this.sgoku15 = new ModelRenderer(this, 80, 0);
/* 350 */     this.sgoku15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3);
/* 351 */     this.sgoku15.func_78793_a(0.0F, 0.0F, 0.0F);
/* 352 */     this.sgoku15.func_78787_b(128, 64);
/* 353 */     this.sgoku15.field_78809_i = true;
/* 354 */     setRotation(this.sgoku15, -0.5410521F, 0.0F, 0.2455096F);
/* 355 */     this.sgoku16 = new ModelRenderer(this, 80, 0);
/* 356 */     this.sgoku16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3);
/* 357 */     this.sgoku16.func_78793_a(0.0F, 0.0F, 0.0F);
/* 358 */     this.sgoku16.func_78787_b(128, 64);
/* 359 */     this.sgoku16.field_78809_i = true;
/* 360 */     setRotation(this.sgoku16, -0.5759587F, 0.0F, 0.1396263F);
/* 361 */     this.sgoku17 = new ModelRenderer(this, 80, 0);
/* 362 */     this.sgoku17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4);
/* 363 */     this.sgoku17.func_78793_a(0.0F, 0.0F, 0.0F);
/* 364 */     this.sgoku17.func_78787_b(128, 64);
/* 365 */     this.sgoku17.field_78809_i = true;
/* 366 */     setRotation(this.sgoku17, -0.2792527F, 0.0F, 0.0F);
/* 367 */     this.sgoku18 = new ModelRenderer(this, 80, 0);
/* 368 */     this.sgoku18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4);
/* 369 */     this.sgoku18.func_78793_a(0.0F, 0.0F, 0.0F);
/* 370 */     this.sgoku18.func_78787_b(128, 64);
/* 371 */     this.sgoku18.field_78809_i = true;
/* 372 */     setRotation(this.sgoku18, -0.2443461F, 0.2617994F, 0.0174533F);
/* 373 */     this.sgoku19 = new ModelRenderer(this, 80, 0);
/* 374 */     this.sgoku19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4);
/* 375 */     this.sgoku19.func_78793_a(0.0F, 0.0F, 0.0F);
/* 376 */     this.sgoku19.func_78787_b(128, 64);
/* 377 */     this.sgoku19.field_78809_i = true;
/* 378 */     setRotation(this.sgoku19, -0.2443461F, -0.2617994F, 0.0174533F);
/* 379 */     this.sgoku20 = new ModelRenderer(this, 80, 0);
/* 380 */     this.sgoku20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4);
/* 381 */     this.sgoku20.func_78793_a(0.0F, 0.0F, 0.0F);
/* 382 */     this.sgoku20.func_78787_b(128, 64);
/* 383 */     this.sgoku20.field_78809_i = true;
/* 384 */     setRotation(this.sgoku20, -0.1396263F, 0.0F, 0.0F);
/* 385 */     this.sgoku21 = new ModelRenderer(this, 80, 0);
/* 386 */     this.sgoku21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3);
/* 387 */     this.sgoku21.func_78793_a(0.0F, 0.0F, 0.0F);
/* 388 */     this.sgoku21.func_78787_b(128, 64);
/* 389 */     this.sgoku21.field_78809_i = true;
/* 390 */     setRotation(this.sgoku21, -0.122173F, 0.1745329F, 0.0F);
/* 391 */     this.sgoku22 = new ModelRenderer(this, 80, 0);
/* 392 */     this.sgoku22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3);
/* 393 */     this.sgoku22.func_78793_a(0.0F, 0.0F, 0.0F);
/* 394 */     this.sgoku22.func_78787_b(128, 64);
/* 395 */     this.sgoku22.field_78809_i = true;
/* 396 */     setRotation(this.sgoku22, -0.2443461F, -0.2617994F, 0.0174533F);
/* 397 */     this.sgoku23 = new ModelRenderer(this, 80, 0);
/* 398 */     this.sgoku23.func_78789_a(2.466667F, -6.5F, -5.333333F, 2, 3, 3);
/* 399 */     this.sgoku23.func_78793_a(0.0F, 0.0F, 0.0F);
/* 400 */     this.sgoku23.func_78787_b(128, 64);
/* 401 */     this.sgoku23.field_78809_i = true;
/* 402 */     setRotation(this.sgoku23, 0.0F, 0.0F, -0.4014257F);
/* 403 */     this.sgoku24 = new ModelRenderer(this, 80, 0);
/* 404 */     this.sgoku24.func_78789_a(-3.7F, -6.7F, -5.533333F, 2, 3, 3);
/* 405 */     this.sgoku24.func_78793_a(0.0F, 0.0F, 0.0F);
/* 406 */     this.sgoku24.func_78787_b(128, 64);
/* 407 */     this.sgoku24.field_78809_i = true;
/* 408 */     setRotation(this.sgoku24, 0.0F, 0.0F, 0.3665191F);
/* 409 */     this.sgoku25 = new ModelRenderer(this, 80, 0);
/* 410 */     this.sgoku25.func_78789_a(-7.0F, -4.5F, -5.0F, 2, 3, 3);
/* 411 */     this.sgoku25.func_78793_a(0.0F, 0.0F, 0.0F);
/* 412 */     this.sgoku25.func_78787_b(128, 64);
/* 413 */     this.sgoku25.field_78809_i = true;
/* 414 */     setRotation(this.sgoku25, 0.0F, 0.0F, 0.6806784F);
/* 415 */     this.sgoku26 = new ModelRenderer(this, 80, 0);
/* 416 */     this.sgoku26.func_78789_a(5.3F, -4.5F, -5.266667F, 2, 3, 3);
/* 417 */     this.sgoku26.func_78793_a(0.0F, 0.0F, 0.0F);
/* 418 */     this.sgoku26.func_78787_b(128, 64);
/* 419 */     this.sgoku26.field_78809_i = true;
/* 420 */     setRotation(this.sgoku26, 0.0F, 0.0F, -0.5934119F);
/*     */     
/* 422 */     this.trunk1 = new ModelRenderer(this, 98, 47);
/* 423 */     this.trunk1.func_78789_a(4.7F, -6.4F, -4.2F, 4, 6, 3);
/* 424 */     this.trunk1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 425 */     this.trunk1.func_78787_b(128, 64);
/* 426 */     this.trunk1.field_78809_i = true;
/* 427 */     setRotation(this.trunk1, 0.1745329F, 0.0F, -0.8028515F);
/* 428 */     this.trunk2 = new ModelRenderer(this, 98, 47);
/* 429 */     this.trunk2.func_78789_a(-8.733334F, -6.4F, -4.0F, 4, 6, 3);
/* 430 */     this.trunk2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 431 */     this.trunk2.func_78787_b(128, 64);
/* 432 */     this.trunk2.field_78809_i = true;
/* 433 */     setRotation(this.trunk2, 0.1745329F, 0.0F, 0.8028515F);
/* 434 */     this.trunk3 = new ModelRenderer(this, 98, 47);
/* 435 */     this.trunk3.func_78789_a(3.0F, -8.0F, -1.2F, 4, 6, 3);
/* 436 */     this.trunk3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 437 */     this.trunk3.func_78787_b(128, 64);
/* 438 */     this.trunk3.field_78809_i = true;
/* 439 */     setRotation(this.trunk3, 0.1745329F, -0.0872665F, -0.4014257F);
/* 440 */     this.trunk4 = new ModelRenderer(this, 98, 47);
/* 441 */     this.trunk4.func_78789_a(3.0F, -7.6F, 1.6F, 4, 6, 3);
/* 442 */     this.trunk4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 443 */     this.trunk4.func_78787_b(128, 64);
/* 444 */     this.trunk4.field_78809_i = true;
/* 445 */     setRotation(this.trunk4, 0.1745329F, -0.0174533F, -0.4014257F);
/* 446 */     this.trunk5 = new ModelRenderer(this, 98, 47);
/* 447 */     this.trunk5.func_78789_a(-7.0F, -7.6F, 1.8F, 4, 6, 3);
/* 448 */     this.trunk5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 449 */     this.trunk5.func_78787_b(128, 64);
/* 450 */     this.trunk5.field_78809_i = true;
/* 451 */     setRotation(this.trunk5, 0.1745329F, -0.0174533F, 0.4014257F);
/* 452 */     this.trunk6 = new ModelRenderer(this, 98, 47);
/* 453 */     this.trunk6.func_78789_a(-7.0F, -8.0F, -1.2F, 4, 6, 3);
/* 454 */     this.trunk6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 455 */     this.trunk6.func_78787_b(128, 64);
/* 456 */     this.trunk6.field_78809_i = true;
/* 457 */     setRotation(this.trunk6, 0.1745329F, 0.0872665F, 0.4014257F);
/* 458 */     this.trunk7 = new ModelRenderer(this, 98, 47);
/* 459 */     this.trunk7.func_78789_a(4.4F, -7.0F, 0.6F, 4, 5, 3);
/* 460 */     this.trunk7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 461 */     this.trunk7.func_78787_b(128, 64);
/* 462 */     this.trunk7.field_78809_i = true;
/* 463 */     setRotation(this.trunk7, 0.0F, -0.6457718F, -0.3665191F);
/* 464 */     this.trunk8 = new ModelRenderer(this, 98, 47);
/* 465 */     this.trunk8.func_78789_a(-8.4F, -7.0F, 0.6F, 4, 5, 3);
/* 466 */     this.trunk8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 467 */     this.trunk8.func_78787_b(128, 64);
/* 468 */     this.trunk8.field_78809_i = true;
/* 469 */     setRotation(this.trunk8, 0.0F, 0.6457718F, 0.3665191F);
/* 470 */     this.trunk9 = new ModelRenderer(this, 98, 47);
/* 471 */     this.trunk9.func_78789_a(-2.5F, -7.0F, 4.0F, 5, 4, 3);
/* 472 */     this.trunk9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 473 */     this.trunk9.func_78787_b(128, 64);
/* 474 */     this.trunk9.field_78809_i = true;
/* 475 */     setRotation(this.trunk9, 0.08F, 0.0F, 0.0F);
/*     */     
/* 477 */     this.strunk1 = new ModelRenderer(this, 78, 47);
/* 478 */     this.strunk1.func_78789_a(-2.0F, -9.0F, -4.933333F, 6, 3, 4);
/* 479 */     this.strunk1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 480 */     this.strunk1.func_78787_b(128, 64);
/* 481 */     this.strunk1.field_78809_i = true;
/* 482 */     setRotation(this.strunk1, -0.0872665F, 0.0F, 0.2443461F);
/* 483 */     this.strunk2 = new ModelRenderer(this, 78, 47);
/* 484 */     this.strunk2.func_78789_a(-4.0F, -9.0F, -5.0F, 6, 3, 4);
/* 485 */     this.strunk2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 486 */     this.strunk2.func_78787_b(128, 64);
/* 487 */     this.strunk2.field_78809_i = true;
/* 488 */     setRotation(this.strunk2, -0.0872665F, 0.0F, -0.2443461F);
/* 489 */     this.strunk3 = new ModelRenderer(this, 78, 47);
/* 490 */     this.strunk3.func_78789_a(-7.0F, -9.0F, -2.0F, 6, 3, 3);
/* 491 */     this.strunk3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 492 */     this.strunk3.func_78787_b(128, 64);
/* 493 */     this.strunk3.field_78809_i = true;
/* 494 */     setRotation(this.strunk3, -0.0872665F, 0.0F, 0.1745329F);
/* 495 */     this.strunk4 = new ModelRenderer(this, 78, 47);
/* 496 */     this.strunk4.func_78789_a(1.0F, -9.0F, -2.0F, 6, 3, 3);
/* 497 */     this.strunk4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 498 */     this.strunk4.func_78787_b(128, 64);
/* 499 */     this.strunk4.field_78809_i = true;
/* 500 */     setRotation(this.strunk4, -0.0872665F, 0.0F, -0.1745329F);
/* 501 */     this.strunk5 = new ModelRenderer(this, 78, 47);
/* 502 */     this.strunk5.func_78789_a(3.0F, -9.0F, 1.0F, 6, 3, 3);
/* 503 */     this.strunk5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 504 */     this.strunk5.func_78787_b(128, 64);
/* 505 */     this.strunk5.field_78809_i = true;
/* 506 */     setRotation(this.strunk5, -0.0872665F, 0.0F, -0.3490659F);
/* 507 */     this.strunk6 = new ModelRenderer(this, 78, 47);
/* 508 */     this.strunk6.func_78789_a(-9.0F, -9.0F, 1.0F, 6, 3, 3);
/* 509 */     this.strunk6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 510 */     this.strunk6.func_78787_b(128, 64);
/* 511 */     this.strunk6.field_78809_i = true;
/* 512 */     setRotation(this.strunk6, -0.0872665F, 0.0F, 0.3490659F);
/* 513 */     this.strunk7 = new ModelRenderer(this, 78, 47);
/* 514 */     this.strunk7.func_78789_a(-1.0F, -11.46667F, -2.0F, 3, 6, 3);
/* 515 */     this.strunk7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 516 */     this.strunk7.func_78787_b(128, 64);
/* 517 */     this.strunk7.field_78809_i = true;
/* 518 */     setRotation(this.strunk7, -0.1745329F, 0.0F, -0.5235988F);
/* 519 */     this.strunk8 = new ModelRenderer(this, 78, 47);
/* 520 */     this.strunk8.func_78789_a(-2.0F, -11.46667F, -2.0F, 3, 6, 3);
/* 521 */     this.strunk8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 522 */     this.strunk8.func_78787_b(128, 64);
/* 523 */     this.strunk8.field_78809_i = true;
/* 524 */     setRotation(this.strunk8, -0.1745329F, 0.0F, 0.5235988F);
/* 525 */     this.strunk9 = new ModelRenderer(this, 78, 47);
/* 526 */     this.strunk9.func_78789_a(-1.0F, -13.46667F, 0.0F, 3, 8, 3);
/* 527 */     this.strunk9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 528 */     this.strunk9.func_78787_b(128, 64);
/* 529 */     this.strunk9.field_78809_i = true;
/* 530 */     setRotation(this.strunk9, -0.1745329F, 0.0F, 0.3490659F);
/* 531 */     this.strunk10 = new ModelRenderer(this, 78, 47);
/* 532 */     this.strunk10.func_78789_a(-2.0F, -13.46667F, 0.0F, 3, 8, 3);
/* 533 */     this.strunk10.func_78793_a(0.0F, 0.0F, 0.0F);
/* 534 */     this.strunk10.func_78787_b(128, 64);
/* 535 */     this.strunk10.field_78809_i = true;
/* 536 */     setRotation(this.strunk10, -0.1745329F, 0.0F, -0.3490659F);
/* 537 */     this.strunk11 = new ModelRenderer(this, 78, 47);
/* 538 */     this.strunk11.func_78789_a(-3.0F, -4.0F, 5.2F, 4, 3, 3);
/* 539 */     this.strunk11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 540 */     this.strunk11.func_78787_b(128, 64);
/* 541 */     this.strunk11.field_78809_i = true;
/* 542 */     setRotation(this.strunk11, 0.5934119F, -0.6108652F, 0.0F);
/* 543 */     this.strunk12 = new ModelRenderer(this, 78, 47);
/* 544 */     this.strunk12.func_78789_a(-7.0F, -7.0F, -0.9333333F, 3, 3, 4);
/* 545 */     this.strunk12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 546 */     this.strunk12.func_78787_b(128, 64);
/* 547 */     this.strunk12.field_78809_i = true;
/* 548 */     setRotation(this.strunk12, -0.0872665F, 0.0F, 0.2094395F);
/* 549 */     this.strunk13 = new ModelRenderer(this, 78, 47);
/* 550 */     this.strunk13.func_78789_a(4.133333F, -7.0F, -1.0F, 3, 3, 4);
/* 551 */     this.strunk13.func_78793_a(0.0F, 0.0F, 0.0F);
/* 552 */     this.strunk13.func_78787_b(128, 64);
/* 553 */     this.strunk13.field_78809_i = true;
/* 554 */     setRotation(this.strunk13, -0.0872665F, 0.0F, -0.2443461F);
/* 555 */     this.strunk14 = new ModelRenderer(this, 78, 47);
/* 556 */     this.strunk14.func_78789_a(-1.133333F, -4.0F, 5.2F, 4, 3, 3);
/* 557 */     this.strunk14.func_78793_a(0.0F, 0.0F, 0.0F);
/* 558 */     this.strunk14.func_78787_b(128, 64);
/* 559 */     this.strunk14.field_78809_i = true;
/* 560 */     setRotation(this.strunk14, 0.5934119F, 0.6108652F, 0.0F);
/* 561 */     this.strunk15 = new ModelRenderer(this, 78, 47);
/* 562 */     this.strunk15.func_78789_a(-3.133333F, -4.466667F, 4.933333F, 6, 3, 3);
/* 563 */     this.strunk15.func_78793_a(0.0F, 0.0F, 0.0F);
/* 564 */     this.strunk15.func_78787_b(128, 64);
/* 565 */     this.strunk15.field_78809_i = true;
/* 566 */     setRotation(this.strunk15, 0.5934119F, 0.0F, 0.0F);
/* 567 */     this.strunk16 = new ModelRenderer(this, 78, 47);
/* 568 */     this.strunk16.func_78789_a(-1.6F, -11.86667F, 1.0F, 2, 4, 2);
/* 569 */     this.strunk16.func_78793_a(0.0F, 0.0F, 0.0F);
/* 570 */     this.strunk16.func_78787_b(128, 64);
/* 571 */     this.strunk16.field_78809_i = true;
/* 572 */     setRotation(this.strunk16, -0.2792527F, 0.0F, 0.5235988F);
/* 573 */     this.strunk17 = new ModelRenderer(this, 78, 47);
/* 574 */     this.strunk17.func_78789_a(-0.4666667F, -11.86667F, 1.0F, 2, 4, 2);
/* 575 */     this.strunk17.func_78793_a(0.0F, 0.0F, 0.0F);
/* 576 */     this.strunk17.func_78787_b(128, 64);
/* 577 */     this.strunk17.field_78809_i = true;
/* 578 */     setRotation(this.strunk17, -0.2617994F, 0.0F, -0.5235988F);
/*     */     
/* 580 */     this.bipedHead.func_78792_a(this.goku1);
/* 581 */     this.bipedHead.func_78792_a(this.goku2);
/* 582 */     this.bipedHead.func_78792_a(this.goku3);
/* 583 */     this.bipedHead.func_78792_a(this.goku4);
/* 584 */     this.bipedHead.func_78792_a(this.goku5);
/* 585 */     this.bipedHead.func_78792_a(this.goku6);
/* 586 */     this.bipedHead.func_78792_a(this.goku7);
/* 587 */     this.bipedHead.func_78792_a(this.goku8);
/* 588 */     this.bipedHead.func_78792_a(this.goku9);
/* 589 */     this.bipedHead.func_78792_a(this.goku10);
/* 590 */     this.bipedHead.func_78792_a(this.goku11);
/* 591 */     this.bipedHead.func_78792_a(this.goku12);
/* 592 */     this.bipedHead.func_78792_a(this.goku13);
/* 593 */     this.bipedHead.func_78792_a(this.goku14);
/* 594 */     this.bipedHead.func_78792_a(this.goku15);
/* 595 */     this.bipedHead.func_78792_a(this.goku16);
/*     */     
/* 597 */     this.bipedHead.func_78792_a(this.sgoku1);
/* 598 */     this.bipedHead.func_78792_a(this.sgoku2);
/* 599 */     this.bipedHead.func_78792_a(this.sgoku3);
/* 600 */     this.bipedHead.func_78792_a(this.sgoku4);
/* 601 */     this.bipedHead.func_78792_a(this.sgoku5);
/* 602 */     this.bipedHead.func_78792_a(this.sgoku6);
/* 603 */     this.bipedHead.func_78792_a(this.sgoku7);
/* 604 */     this.bipedHead.func_78792_a(this.sgoku8);
/* 605 */     this.bipedHead.func_78792_a(this.sgoku9);
/* 606 */     this.bipedHead.func_78792_a(this.sgoku10);
/* 607 */     this.bipedHead.func_78792_a(this.sgoku11);
/* 608 */     this.bipedHead.func_78792_a(this.sgoku12);
/* 609 */     this.bipedHead.func_78792_a(this.sgoku13);
/* 610 */     this.bipedHead.func_78792_a(this.sgoku14);
/* 611 */     this.bipedHead.func_78792_a(this.sgoku15);
/* 612 */     this.bipedHead.func_78792_a(this.sgoku16);
/* 613 */     this.bipedHead.func_78792_a(this.sgoku17);
/* 614 */     this.bipedHead.func_78792_a(this.sgoku18);
/* 615 */     this.bipedHead.func_78792_a(this.sgoku19);
/* 616 */     this.bipedHead.func_78792_a(this.sgoku20);
/* 617 */     this.bipedHead.func_78792_a(this.sgoku21);
/* 618 */     this.bipedHead.func_78792_a(this.sgoku22);
/* 619 */     this.bipedHead.func_78792_a(this.sgoku23);
/* 620 */     this.bipedHead.func_78792_a(this.sgoku24);
/* 621 */     this.bipedHead.func_78792_a(this.sgoku25);
/* 622 */     this.bipedHead.func_78792_a(this.sgoku26);
/*     */     
/* 624 */     this.bipedHead.func_78792_a(this.trunk1);
/* 625 */     this.bipedHead.func_78792_a(this.trunk2);
/* 626 */     this.bipedHead.func_78792_a(this.trunk3);
/* 627 */     this.bipedHead.func_78792_a(this.trunk4);
/* 628 */     this.bipedHead.func_78792_a(this.trunk5);
/* 629 */     this.bipedHead.func_78792_a(this.trunk6);
/* 630 */     this.bipedHead.func_78792_a(this.trunk7);
/* 631 */     this.bipedHead.func_78792_a(this.trunk8);
/* 632 */     this.bipedHead.func_78792_a(this.trunk9);
/*     */     
/* 634 */     this.bipedHead.func_78792_a(this.strunk1);
/* 635 */     this.bipedHead.func_78792_a(this.strunk2);
/* 636 */     this.bipedHead.func_78792_a(this.strunk3);
/* 637 */     this.bipedHead.func_78792_a(this.strunk4);
/* 638 */     this.bipedHead.func_78792_a(this.strunk5);
/* 639 */     this.bipedHead.func_78792_a(this.strunk6);
/* 640 */     this.bipedHead.func_78792_a(this.strunk7);
/* 641 */     this.bipedHead.func_78792_a(this.strunk8);
/* 642 */     this.bipedHead.func_78792_a(this.strunk9);
/* 643 */     this.bipedHead.func_78792_a(this.strunk10);
/* 644 */     this.bipedHead.func_78792_a(this.strunk11);
/* 645 */     this.bipedHead.func_78792_a(this.strunk12);
/* 646 */     this.bipedHead.func_78792_a(this.strunk13);
/* 647 */     this.bipedHead.func_78792_a(this.strunk14);
/* 648 */     this.bipedHead.func_78792_a(this.strunk15);
/* 649 */     this.bipedHead.func_78792_a(this.strunk16);
/* 650 */     this.bipedHead.func_78792_a(this.strunk17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 658 */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/*     */     
/* 660 */     float f5 = par7;
/* 661 */     if (this.field_78091_s) {
/*     */       
/* 663 */       float var8 = 2.0F;
/* 664 */       GL11.glPushMatrix();
/* 665 */       GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
/* 666 */       GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
/* 667 */       this.bipedHead.func_78785_a(par7);
/* 668 */       GL11.glPopMatrix();
/* 669 */       GL11.glPushMatrix();
/* 670 */       GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
/* 671 */       GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
/* 672 */       this.bipedBody.func_78785_a(par7);
/* 673 */       this.bipedRightArm.func_78785_a(par7);
/* 674 */       this.bipedLeftArm.func_78785_a(par7);
/* 675 */       this.bipedRightLeg.func_78785_a(par7);
/* 676 */       this.bipedLeftLeg.func_78785_a(par7);
/*     */       
/* 678 */       this.leftarmshoulder.func_78785_a(f5);
/* 679 */       this.rightarmshoulder.func_78785_a(f5);
/*     */ 
/*     */       
/* 682 */       GL11.glPopMatrix();
/*     */     }
/*     */     else {
/*     */       
/* 686 */       this.bipedHead.func_78785_a(par7);
/* 687 */       this.bipedBody.func_78785_a(par7);
/* 688 */       this.bipedRightArm.func_78785_a(par7);
/* 689 */       this.bipedLeftArm.func_78785_a(par7);
/* 690 */       this.bipedRightLeg.func_78785_a(par7);
/* 691 */       this.bipedLeftLeg.func_78785_a(par7);
/*     */       
/* 693 */       this.leftarmshoulder.func_78785_a(f5);
/* 694 */       this.rightarmshoulder.func_78785_a(f5);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 701 */     model.field_78795_f = x;
/* 702 */     model.field_78796_g = y;
/* 703 */     model.field_78808_h = z;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 713 */     this.bipedHead.field_78796_g = par4 / 57.295776F;
/* 714 */     this.bipedHead.field_78795_f = par5 / 57.295776F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 719 */     this.bipedRightArm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 720 */     this.bipedLeftArm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/* 721 */     this.bipedRightArm.field_78808_h = 0.0F;
/* 722 */     this.bipedLeftArm.field_78808_h = 0.0F;
/* 723 */     this.bipedRightLeg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 724 */     this.bipedLeftLeg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/* 725 */     this.bipedRightLeg.field_78796_g = 0.0F;
/* 726 */     this.bipedLeftLeg.field_78796_g = 0.0F;
/*     */     
/* 728 */     this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 729 */     this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/* 730 */     this.rightarmshoulder.field_78808_h = this.bipedRightArm.field_78808_h;
/* 731 */     this.leftarmshoulder.field_78808_h = this.bipedLeftArm.field_78808_h;
/*     */     
/* 733 */     if (this.field_78093_q) {
/*     */       
/* 735 */       this.bipedRightArm.field_78795_f += -0.62831855F;
/* 736 */       this.bipedLeftArm.field_78795_f += -0.62831855F;
/* 737 */       this.bipedRightLeg.field_78795_f = -1.2566371F;
/* 738 */       this.bipedLeftLeg.field_78795_f = -1.2566371F;
/* 739 */       this.bipedRightLeg.field_78796_g = 0.31415927F;
/* 740 */       this.bipedLeftLeg.field_78796_g = -0.31415927F;
/*     */       
/* 742 */       this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 743 */       this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/*     */     } 
/*     */     
/* 746 */     if (this.heldItemLeft != 0)
/*     */     {
/* 748 */       this.bipedLeftArm.field_78795_f = this.bipedLeftArm.field_78795_f * 0.5F - 0.31415927F * this.heldItemLeft;
/*     */     }
/*     */     
/* 751 */     if (this.heldItemRight != 0)
/*     */     {
/* 753 */       this.bipedRightArm.field_78795_f = this.bipedRightArm.field_78795_f * 0.5F - 0.31415927F * this.heldItemRight;
/*     */     }
/*     */     
/* 756 */     this.bipedRightArm.field_78796_g = 0.0F;
/* 757 */     this.bipedLeftArm.field_78796_g = 0.0F;
/*     */ 
/*     */ 
/*     */     
/* 761 */     this.rightarmshoulder.field_78796_g = this.bipedRightArm.field_78796_g;
/* 762 */     this.leftarmshoulder.field_78796_g = this.bipedLeftArm.field_78796_g;
/*     */     
/* 764 */     if (this.field_78095_p > -9990.0F) {
/*     */       
/* 766 */       float var8 = this.field_78095_p;
/* 767 */       this.bipedBody.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/* 768 */       this.bipedRightArm.field_78798_e = MathHelper.func_76126_a(this.bipedBody.field_78796_g) * 5.0F;
/* 769 */       this.bipedRightArm.field_78800_c = -MathHelper.func_76134_b(this.bipedBody.field_78796_g) * 5.0F;
/* 770 */       this.bipedLeftArm.field_78798_e = -MathHelper.func_76126_a(this.bipedBody.field_78796_g) * 5.0F;
/* 771 */       this.bipedLeftArm.field_78800_c = MathHelper.func_76134_b(this.bipedBody.field_78796_g) * 5.0F;
/* 772 */       this.bipedRightArm.field_78796_g += this.bipedBody.field_78796_g;
/* 773 */       this.bipedLeftArm.field_78796_g += this.bipedBody.field_78796_g;
/* 774 */       this.bipedLeftArm.field_78795_f += this.bipedBody.field_78796_g;
/*     */       
/* 776 */       this.rightarmshoulder.field_78798_e = MathHelper.func_76126_a(this.bipedBody.field_78796_g) * 5.0F;
/* 777 */       this.rightarmshoulder.field_78800_c = -MathHelper.func_76134_b(this.bipedBody.field_78796_g) * 5.0F;
/* 778 */       this.leftarmshoulder.field_78798_e = -MathHelper.func_76126_a(this.bipedBody.field_78796_g) * 5.0F;
/* 779 */       this.leftarmshoulder.field_78800_c = MathHelper.func_76134_b(this.bipedBody.field_78796_g) * 5.0F;
/* 780 */       this.rightarmshoulder.field_78796_g += this.bipedBody.field_78796_g;
/* 781 */       this.leftarmshoulder.field_78796_g += this.bipedBody.field_78796_g;
/* 782 */       this.leftarmshoulder.field_78795_f += this.bipedBody.field_78796_g;
/*     */       
/* 784 */       var8 = 1.0F - this.field_78095_p;
/* 785 */       var8 *= var8;
/* 786 */       var8 *= var8;
/* 787 */       var8 = 1.0F - var8;
/* 788 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/* 789 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.bipedHead.field_78795_f - 0.7F) * 0.75F;
/* 790 */       this.bipedRightArm.field_78795_f = (float)(this.bipedRightArm.field_78795_f - var9 * 1.2D + var10);
/* 791 */       this.bipedRightArm.field_78796_g += this.bipedBody.field_78796_g * 2.0F;
/* 792 */       this.bipedRightArm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */       
/* 794 */       this.rightarmshoulder.field_78795_f = (float)(this.bipedRightArm.field_78795_f - var9 * 1.2D + var10);
/* 795 */       this.rightarmshoulder.field_78796_g += this.bipedBody.field_78796_g * 2.0F;
/* 796 */       this.rightarmshoulder.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*     */     } 
/*     */     
/* 799 */     if (this.isSneak) {
/*     */       
/* 801 */       this.bipedBody.field_78795_f = 0.5F;
/* 802 */       this.bipedRightArm.field_78795_f += 0.4F;
/* 803 */       this.bipedLeftArm.field_78795_f += 0.4F;
/* 804 */       this.bipedRightLeg.field_78798_e = 4.0F;
/* 805 */       this.bipedLeftLeg.field_78798_e = 4.0F;
/* 806 */       this.bipedRightLeg.field_78797_d = 9.0F;
/* 807 */       this.bipedLeftLeg.field_78797_d = 9.0F;
/* 808 */       this.bipedHead.field_78797_d = 1.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 813 */       this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 814 */       this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/*     */     }
/*     */     else {
/*     */       
/* 818 */       this.bipedBody.field_78795_f = 0.0F;
/* 819 */       this.bipedRightLeg.field_78798_e = 0.1F;
/* 820 */       this.bipedLeftLeg.field_78798_e = 0.1F;
/* 821 */       this.bipedRightLeg.field_78797_d = 12.0F;
/* 822 */       this.bipedLeftLeg.field_78797_d = 12.0F;
/* 823 */       this.bipedHead.field_78797_d = 0.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 828 */     this.bipedRightArm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 829 */     this.bipedLeftArm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 830 */     this.bipedRightArm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 831 */     this.bipedLeftArm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */     
/* 833 */     this.rightarmshoulder.field_78808_h = this.bipedRightArm.field_78808_h;
/* 834 */     this.leftarmshoulder.field_78808_h = this.bipedLeftArm.field_78808_h;
/* 835 */     this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 836 */     this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/*     */     
/* 838 */     if (this.aimedBow) {
/*     */       
/* 840 */       float var8 = 0.0F;
/* 841 */       float var9 = 0.0F;
/* 842 */       this.bipedRightArm.field_78808_h = 0.0F;
/* 843 */       this.bipedLeftArm.field_78808_h = 0.0F;
/*     */       
/* 845 */       this.rightarmshoulder.field_78808_h = this.bipedRightArm.field_78808_h;
/* 846 */       this.leftarmshoulder.field_78808_h = this.bipedLeftArm.field_78808_h;
/*     */       
/* 848 */       this.bipedRightArm.field_78796_g = -(0.1F - var8 * 0.6F) + this.bipedHead.field_78796_g;
/* 849 */       this.bipedLeftArm.field_78796_g = 0.1F - var8 * 0.6F + this.bipedHead.field_78796_g + 0.4F;
/* 850 */       this.bipedRightArm.field_78795_f = -1.5707964F + this.bipedHead.field_78795_f;
/* 851 */       this.bipedLeftArm.field_78795_f = -1.5707964F + this.bipedHead.field_78795_f;
/* 852 */       this.bipedRightArm.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/* 853 */       this.bipedLeftArm.field_78795_f -= var8 * 1.2F - var9 * 0.4F;
/*     */       
/* 855 */       this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 856 */       this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/*     */       
/* 858 */       this.bipedRightArm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 859 */       this.bipedLeftArm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 860 */       this.bipedRightArm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 861 */       this.bipedLeftArm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */       
/* 863 */       this.rightarmshoulder.field_78796_g = this.bipedRightArm.field_78796_g;
/* 864 */       this.leftarmshoulder.field_78796_g = this.bipedLeftArm.field_78796_g;
/* 865 */       this.rightarmshoulder.field_78808_h = this.bipedRightArm.field_78808_h;
/* 866 */       this.leftarmshoulder.field_78808_h = this.bipedLeftArm.field_78808_h;
/* 867 */       this.rightarmshoulder.field_78795_f = this.bipedRightArm.field_78795_f;
/* 868 */       this.leftarmshoulder.field_78795_f = this.bipedLeftArm.field_78795_f;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderEars(float par1) {
/* 877 */     this.bipedEars.field_78796_g = this.bipedHead.field_78796_g;
/* 878 */     this.bipedEars.field_78795_f = this.bipedHead.field_78795_f;
/* 879 */     this.bipedEars.field_78800_c = 0.0F;
/* 880 */     this.bipedEars.field_78797_d = 0.0F;
/* 881 */     this.bipedEars.func_78785_a(par1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderCloak(float par1) {
/* 889 */     this.bipedCloak.func_78785_a(par1);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ModelBipedDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */