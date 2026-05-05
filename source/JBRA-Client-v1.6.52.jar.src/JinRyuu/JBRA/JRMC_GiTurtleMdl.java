/*     */ package JinRyuu.JBRA;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJYC;
/*     */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JRMC_GiTurtleMdl
/*     */   extends ModelBipedBody
/*     */ {
/*  18 */   private final int VANITY_CRISTMAS_0 = 0; private final int VANITY_CRISTMAS_1 = 1; private final int VANITY_CRISTMAS_2 = 2; private final int VANITY_CRISTMAS_3 = 3; private final int VANITY_CRISTMAS_4 = 4;
/*  19 */   public int id = -1;
/*     */   
/*     */   public ModelRenderer Head;
/*     */   
/*     */   public ModelRenderer Head2;
/*     */   
/*     */   public ModelRenderer Head3;
/*     */   
/*     */   public ModelRenderer HeadTail1;
/*     */   
/*     */   public ModelRenderer HeadTail2;
/*     */   
/*     */   public ModelRenderer Larm_1;
/*     */   
/*     */   public ModelRenderer Rarm_1;
/*     */   
/*     */   public ModelRenderer Body_1;
/*     */   
/*     */   public ModelRenderer Larm2_1;
/*     */   
/*     */   public ModelRenderer Rarm2_1;
/*     */   public ModelRenderer Body2_1;
/*     */   public ModelRenderer Body3_1;
/*     */   public ModelRenderer Larm_2;
/*     */   public ModelRenderer Rarm_2;
/*     */   public ModelRenderer Body_2;
/*     */   public ModelRenderer Larm2_2;
/*     */   public ModelRenderer Rarm2_2;
/*     */   public ModelRenderer Body2_2;
/*     */   public ModelRenderer Body4_2;
/*     */   public ModelRenderer Body3_2;
/*     */   public ModelRenderer Lleg_3;
/*     */   public ModelRenderer RLeg_3;
/*     */   public ModelRenderer Body_3;
/*     */   public ModelRenderer Body2_3;
/*     */   public ModelRenderer Lleg_4;
/*     */   public ModelRenderer RLeg_4;
/*     */   public ModelRenderer Lleg2_4;
/*     */   public ModelRenderer RLeg2_4;
/*     */   private float size;
/*     */   
/*     */   public JRMC_GiTurtleMdl(int id) {
/*  61 */     super(0.1F);
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
/* 199 */     this.size = 1.0F; this.id = id; if (id == 0) { this.field_78090_t = 64; this.field_78089_u = 32; this.Head2 = new ModelRenderer((ModelBase)this, 0, 15); this.Head2.func_78793_a(0.0F, 0.0F, 0.0F); this.Head2.func_78790_a(-4.5F, -6.4F, -5.0F, 9, 2, 9, 0.01F); setRotateAngle(this.Head2, -0.09773844F, 0.0F, 0.0F); this.HeadTail2 = new ModelRenderer((ModelBase)this, 51, 22); this.HeadTail2.func_78793_a(0.0F, 0.0F, 0.0F); this.HeadTail2.func_78790_a(-1.0F, -1.3F, 3.2F, 2, 2, 2, 0.01F); this.HeadTail1 = new ModelRenderer((ModelBase)this, 48, 15); this.HeadTail1.func_78793_a(0.2F, -7.5F, 4.6F); this.HeadTail1.func_78790_a(-1.5F, -0.7F, -0.8F, 3, 1, 4, 0.01F); setRotateAngle(this.HeadTail1, -0.7285004F, 0.0F, 0.0F); this.Head = new ModelRenderer((ModelBase)this, 0, 0); this.Head.func_78793_a(0.0F, 0.0F, 0.0F); this.Head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.03F); this.Head3 = new ModelRenderer((ModelBase)this, 35, 0); this.Head3.func_78793_a(0.0F, 0.0F, 0.0F); this.Head3.func_78790_a(-3.0F, -8.9F, -2.1F, 6, 2, 7, 0.01F); this.Head.func_78792_a(this.Head2); this.HeadTail1.func_78792_a(this.HeadTail2); this.Head3.func_78792_a(this.HeadTail1); this.Head.func_78792_a(this.Head3); } else if (id == 1) { this.field_78090_t = 64; this.field_78089_u = 32; this.Larm_1 = new ModelRenderer((ModelBase)this, 31, 4); this.Larm_1.field_78809_i = true; this.Larm_1.func_78793_a(5.0F, 2.0F, 0.0F); this.Larm_1.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.02F); this.Body_1 = new ModelRenderer((ModelBase)this, 0, 0); this.Body_1.func_78793_a(0.0F, 0.0F, 0.0F); this.Body_1.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.02F); this.Body2_1 = new ModelRenderer((ModelBase)this, 0, 25); this.Body2_1.func_78793_a(0.0F, 0.0F, 0.0F); this.Body2_1.func_78790_a(-4.5F, 10.6F, -2.5F, 9, 2, 5, 0.01F); this.Rarm_1 = new ModelRenderer((ModelBase)this, 31, 4); this.Rarm_1.func_78793_a(-5.0F, 2.0F, 0.0F); this.Rarm_1.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.02F); this.Body3_1 = new ModelRenderer((ModelBase)this, 0, 17); this.Body3_1.func_78793_a(0.0F, 0.0F, 0.0F); this.Body3_1.func_78790_a(-4.5F, -0.6F, -2.5F, 9, 2, 5, 0.01F); this.Rarm2_1 = new ModelRenderer((ModelBase)this, 30, 17); this.Rarm2_1.func_78793_a(0.0F, 0.0F, 0.0F); this.Rarm2_1.func_78790_a(-3.7F, 5.5F, -2.5F, 5, 2, 5, 0.01F); this.Larm2_1 = new ModelRenderer((ModelBase)this, 30, 17); this.Larm2_1.field_78809_i = true; this.Larm2_1.func_78793_a(0.0F, 0.0F, 0.0F); this.Larm2_1.func_78790_a(-1.3F, 5.5F, -2.5F, 5, 2, 5, 0.01F); this.Body_1.func_78792_a(this.Body2_1); this.Body_1.func_78792_a(this.Body3_1); this.Rarm_1.func_78792_a(this.Rarm2_1); this.Larm_1.func_78792_a(this.Larm2_1); }
/*     */     else if (id == 2) { this.field_78090_t = 64; this.field_78089_u = 32; this.Larm2_2 = new ModelRenderer((ModelBase)this, 36, 21); this.Larm2_2.field_78809_i = true; this.Larm2_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Larm2_2.func_78790_a(-1.3F, 5.5F, -2.5F, 5, 2, 5, 0.01F); this.Body2_2 = new ModelRenderer((ModelBase)this, 0, 16); this.Body2_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body2_2.func_78790_a(-4.5F, 10.6F, -2.5F, 9, 2, 5, 0.01F); this.Rarm2_2 = new ModelRenderer((ModelBase)this, 36, 21); this.Rarm2_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Rarm2_2.func_78790_a(-3.7F, 5.5F, -2.5F, 5, 2, 5, 0.01F); this.Body4_2 = new ModelRenderer((ModelBase)this, 24, 0); this.Body4_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body4_2.func_78790_a(-4.5F, -0.6F, -2.5F, 9, 2, 5, 0.01F); this.Body3_2 = new ModelRenderer((ModelBase)this, 0, 23); this.Body3_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body3_2.func_78790_a(-5.0F, 11.8F, -3.0F, 10, 2, 6, 0.01F); this.Larm_2 = new ModelRenderer((ModelBase)this, 38, 8); this.Larm_2.field_78809_i = true; this.Larm_2.func_78793_a(5.0F, 2.0F, 0.0F); this.Larm_2.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.02F); this.Body_2 = new ModelRenderer((ModelBase)this, 0, 0); this.Body_2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body_2.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.03F); this.Rarm_2 = new ModelRenderer((ModelBase)this, 38, 8); this.Rarm_2.func_78793_a(-5.0F, 2.0F, 0.0F); this.Rarm_2.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.02F); this.Larm_2.func_78792_a(this.Larm2_2); this.Body_2.func_78792_a(this.Body2_2); this.Rarm_2.func_78792_a(this.Rarm2_2); this.Body_2.func_78792_a(this.Body4_2); this.Body2_2.func_78792_a(this.Body3_2); }
/*     */     else if (id == 3) { this.field_78090_t = 64; this.field_78089_u = 32; this.Body_3 = new ModelRenderer((ModelBase)this, 0, 0); this.Body_3.func_78793_a(0.0F, 0.0F, 0.0F); this.Body_3.func_78790_a(-4.0F, 8.1F, -2.0F, 8, 4, 4, 0.01F); this.RLeg_3 = new ModelRenderer((ModelBase)this, 0, 16); this.RLeg_3.func_78793_a(-1.9F, 12.0F, 0.0F); this.RLeg_3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.01F); this.Lleg_3 = new ModelRenderer((ModelBase)this, 0, 16); this.Lleg_3.field_78809_i = true; this.Lleg_3.func_78793_a(1.9F, 12.0F, 0.0F); this.Lleg_3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.01F); this.Body2_3 = new ModelRenderer((ModelBase)this, 0, 8); this.Body2_3.func_78793_a(0.0F, 0.0F, 0.0F); this.Body2_3.func_78790_a(-4.5F, 7.4F, -2.5F, 9, 2, 5, 0.01F); this.Body_3.func_78792_a(this.Body2_3); }
/*     */     else if (id == 4) { this.field_78090_t = 64; this.field_78089_u = 32; this.Lleg2_4 = new ModelRenderer((ModelBase)this, 1, 1); this.Lleg2_4.field_78809_i = true; this.Lleg2_4.func_78793_a(0.0F, 0.0F, 0.0F); this.Lleg2_4.func_78790_a(-2.3F, 6.4F, -2.5F, 5, 2, 5, 0.01F); this.RLeg2_4 = new ModelRenderer((ModelBase)this, 1, 1); this.RLeg2_4.func_78793_a(0.0F, 0.0F, 0.0F); this.RLeg2_4.func_78790_a(-2.7F, 6.4F, -2.5F, 5, 2, 5, 0.01F); this.Lleg_4 = new ModelRenderer((ModelBase)this, 1, 10); this.Lleg_4.field_78809_i = true; this.Lleg_4.func_78793_a(1.9F, 12.0F, 0.0F); this.Lleg_4.func_78790_a(-2.0F, 8.0F, -2.0F, 4, 4, 4, 0.02F); this.RLeg_4 = new ModelRenderer((ModelBase)this, 1, 10); this.RLeg_4.func_78793_a(-1.9F, 12.0F, 0.0F); this.RLeg_4.func_78790_a(-2.0F, 8.0F, -2.0F, 4, 4, 4, 0.02F); this.Lleg_4.func_78792_a(this.Lleg2_4); this.RLeg_4.func_78792_a(this.RLeg2_4); }
/* 203 */      } public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 204 */     GL11.glPushMatrix();
/* 205 */     float f6 = this.size;
/* 206 */     if (JRMCoreH.JYC()) {
/* 207 */       float age = JRMCoreHJYC.JYCAge((EntityPlayer)entity);
/* 208 */       float childScl = JRMCoreHJYC.JYCsizeBasedOnAge((EntityPlayer)entity);
/* 209 */       childScl = 3.0F - childScl * 2.0F;
/* 210 */       this.size = childScl;
/*     */     } 
/*     */ 
/*     */     
/* 214 */     if (this.id == 0) {
/* 215 */       GL11.glScalef(0.5F + 0.5F / f6, 0.5F + 0.5F / f6, 0.5F + 0.5F / f6);
/* 216 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 217 */       GL11.glPushMatrix();
/* 218 */       GL11.glScalef(1.1F, 1.1F, 1.1F);
/* 219 */       this.Head.func_78785_a(f5);
/* 220 */       GL11.glPopMatrix();
/*     */     }
/* 222 */     else if (this.id == 1) {
/* 223 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 224 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 225 */       this.Larm_1.func_78785_a(f5);
/* 226 */       this.Body_1.func_78785_a(f5);
/* 227 */       this.Rarm_1.func_78785_a(f5);
/*     */     }
/* 229 */     else if (this.id == 2) {
/* 230 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 231 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 232 */       this.Larm_2.func_78785_a(f5);
/* 233 */       this.Body_2.func_78785_a(f5);
/* 234 */       this.Rarm_2.func_78785_a(f5);
/*     */     }
/* 236 */     else if (this.id == 3) {
/* 237 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 238 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 239 */       this.Body_3.func_78785_a(f5);
/* 240 */       this.RLeg_3.func_78785_a(f5);
/* 241 */       this.Lleg_3.func_78785_a(f5);
/*     */     }
/* 243 */     else if (this.id == 4) {
/* 244 */       GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/* 245 */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 246 */       this.Lleg_4.func_78785_a(f5);
/* 247 */       this.RLeg_4.func_78785_a(f5);
/*     */     } 
/*     */     
/* 250 */     GL11.glPopMatrix(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 258 */     modelRenderer.field_78795_f = x;
/* 259 */     modelRenderer.field_78796_g = y;
/* 260 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
/* 264 */     super.func_78087_a(par1, par2, par3, par4, par5, par6, entity);
/* 265 */     if (this.id == 0) {
/* 266 */       this.Head.field_78798_e = this.field_78116_c.field_78798_e;
/* 267 */       this.Head.field_78797_d = this.field_78116_c.field_78797_d;
/* 268 */       this.Head.field_78800_c = this.field_78116_c.field_78800_c;
/*     */       
/* 270 */       this.Head.field_78808_h = this.field_78116_c.field_78808_h;
/* 271 */       this.Head.field_78796_g = this.field_78116_c.field_78796_g;
/* 272 */       this.Head.field_78795_f = this.field_78116_c.field_78795_f;
/*     */       
/* 274 */       float s = 0.0F;
/* 275 */       float s2 = MathHelper.func_76134_b(par1 * 0.6662F) * 1.0F * par2;
/* 276 */       float s3 = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.0F * par2;
/* 277 */       this.HeadTail1.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 4.0F - 0.7285004F;
/* 278 */       this.HeadTail2.field_78795_f = ((s3 + s > s) ? (s3 + s) : ((s2 + s > s) ? (s2 + s) : s)) / 4.0F;
/*     */     
/*     */     }
/* 281 */     else if (this.id == 1) {
/* 282 */       this.Larm_1.field_78798_e = this.field_78113_g.field_78798_e;
/* 283 */       this.Larm_1.field_78797_d = this.field_78113_g.field_78797_d;
/* 284 */       this.Larm_1.field_78800_c = this.field_78113_g.field_78800_c;
/*     */       
/* 286 */       this.Larm_1.field_78808_h = this.field_78113_g.field_78808_h;
/* 287 */       this.Larm_1.field_78796_g = this.field_78113_g.field_78796_g;
/* 288 */       this.Larm_1.field_78795_f = this.field_78113_g.field_78795_f;
/*     */ 
/*     */       
/* 291 */       this.Rarm_1.field_78798_e = this.field_78112_f.field_78798_e;
/* 292 */       this.Rarm_1.field_78797_d = this.field_78112_f.field_78797_d;
/* 293 */       this.Rarm_1.field_78800_c = this.field_78112_f.field_78800_c;
/*     */       
/* 295 */       this.Rarm_1.field_78808_h = this.field_78112_f.field_78808_h;
/* 296 */       this.Rarm_1.field_78796_g = this.field_78112_f.field_78796_g;
/* 297 */       this.Rarm_1.field_78795_f = this.field_78112_f.field_78795_f;
/*     */ 
/*     */       
/* 300 */       this.Body_1.field_78798_e = this.field_78115_e.field_78798_e;
/* 301 */       this.Body_1.field_78797_d = this.field_78115_e.field_78797_d;
/* 302 */       this.Body_1.field_78800_c = this.field_78115_e.field_78800_c;
/*     */       
/* 304 */       this.Body_1.field_78808_h = this.field_78115_e.field_78808_h;
/* 305 */       this.Body_1.field_78796_g = this.field_78115_e.field_78796_g;
/* 306 */       this.Body_1.field_78795_f = this.field_78115_e.field_78795_f;
/*     */     
/*     */     }
/* 309 */     else if (this.id == 2) {
/* 310 */       this.Larm_2.field_78798_e = this.field_78113_g.field_78798_e;
/* 311 */       this.Larm_2.field_78797_d = this.field_78113_g.field_78797_d;
/* 312 */       this.Larm_2.field_78800_c = this.field_78113_g.field_78800_c;
/*     */       
/* 314 */       this.Larm_2.field_78808_h = this.field_78113_g.field_78808_h;
/* 315 */       this.Larm_2.field_78796_g = this.field_78113_g.field_78796_g;
/* 316 */       this.Larm_2.field_78795_f = this.field_78113_g.field_78795_f;
/*     */ 
/*     */       
/* 319 */       this.Rarm_2.field_78798_e = this.field_78112_f.field_78798_e;
/* 320 */       this.Rarm_2.field_78797_d = this.field_78112_f.field_78797_d;
/* 321 */       this.Rarm_2.field_78800_c = this.field_78112_f.field_78800_c;
/*     */       
/* 323 */       this.Rarm_2.field_78808_h = this.field_78112_f.field_78808_h;
/* 324 */       this.Rarm_2.field_78796_g = this.field_78112_f.field_78796_g;
/* 325 */       this.Rarm_2.field_78795_f = this.field_78112_f.field_78795_f;
/*     */ 
/*     */       
/* 328 */       this.Body_2.field_78798_e = this.field_78115_e.field_78798_e;
/* 329 */       this.Body_2.field_78797_d = this.field_78115_e.field_78797_d;
/* 330 */       this.Body_2.field_78800_c = this.field_78115_e.field_78800_c;
/*     */       
/* 332 */       this.Body_2.field_78808_h = this.field_78115_e.field_78808_h;
/* 333 */       this.Body_2.field_78796_g = this.field_78115_e.field_78796_g;
/* 334 */       this.Body_2.field_78795_f = this.field_78115_e.field_78795_f;
/*     */     
/*     */     }
/* 337 */     else if (this.id == 3) {
/* 338 */       this.Body_3.field_78798_e = this.field_78115_e.field_78798_e;
/* 339 */       this.Body_3.field_78797_d = this.field_78115_e.field_78797_d;
/* 340 */       this.Body_3.field_78800_c = this.field_78115_e.field_78800_c;
/*     */       
/* 342 */       this.Body_3.field_78808_h = this.field_78115_e.field_78808_h;
/* 343 */       this.Body_3.field_78796_g = this.field_78115_e.field_78796_g;
/* 344 */       this.Body_3.field_78795_f = this.field_78115_e.field_78795_f;
/*     */ 
/*     */       
/* 347 */       this.RLeg_3.field_78798_e = this.field_78123_h.field_78798_e;
/* 348 */       this.RLeg_3.field_78797_d = this.field_78123_h.field_78797_d;
/* 349 */       this.RLeg_3.field_78800_c = this.field_78123_h.field_78800_c;
/*     */       
/* 351 */       this.RLeg_3.field_78808_h = this.field_78123_h.field_78808_h;
/* 352 */       this.RLeg_3.field_78796_g = this.field_78123_h.field_78796_g;
/* 353 */       this.RLeg_3.field_78795_f = this.field_78123_h.field_78795_f;
/*     */ 
/*     */       
/* 356 */       this.Lleg_3.field_78798_e = this.field_78124_i.field_78798_e;
/* 357 */       this.Lleg_3.field_78797_d = this.field_78124_i.field_78797_d;
/* 358 */       this.Lleg_3.field_78800_c = this.field_78124_i.field_78800_c;
/*     */       
/* 360 */       this.Lleg_3.field_78808_h = this.field_78124_i.field_78808_h;
/* 361 */       this.Lleg_3.field_78796_g = this.field_78124_i.field_78796_g;
/* 362 */       this.Lleg_3.field_78795_f = this.field_78124_i.field_78795_f;
/*     */     
/*     */     }
/* 365 */     else if (this.id == 4) {
/* 366 */       this.RLeg_4.field_78798_e = this.field_78123_h.field_78798_e;
/* 367 */       this.RLeg_4.field_78797_d = this.field_78123_h.field_78797_d;
/* 368 */       this.RLeg_4.field_78800_c = this.field_78123_h.field_78800_c;
/*     */       
/* 370 */       this.RLeg_4.field_78808_h = this.field_78123_h.field_78808_h;
/* 371 */       this.RLeg_4.field_78796_g = this.field_78123_h.field_78796_g;
/* 372 */       this.RLeg_4.field_78795_f = this.field_78123_h.field_78795_f;
/*     */ 
/*     */       
/* 375 */       this.Lleg_4.field_78798_e = this.field_78124_i.field_78798_e;
/* 376 */       this.Lleg_4.field_78797_d = this.field_78124_i.field_78797_d;
/* 377 */       this.Lleg_4.field_78800_c = this.field_78124_i.field_78800_c;
/*     */       
/* 379 */       this.Lleg_4.field_78808_h = this.field_78124_i.field_78808_h;
/* 380 */       this.Lleg_4.field_78796_g = this.field_78124_i.field_78796_g;
/* 381 */       this.Lleg_4.field_78795_f = this.field_78124_i.field_78795_f;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JRMC_GiTurtleMdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */