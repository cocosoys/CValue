/*     */ package net.minecraft.client.renderer.entity;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBox;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class RendererLivingEntity extends Render {
/*  23 */   private static final Logger field_147923_a = LogManager.getLogger();
/*  24 */   private static final ResourceLocation field_110814_a = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*     */   
/*     */   protected ModelBase field_77045_g;
/*     */   protected ModelBase field_77046_h;
/*     */   private static final String __OBFID = "CL_00001012";
/*     */   
/*     */   public RendererLivingEntity(ModelBase p_i1261_1_, float p_i1261_2_) {
/*  31 */     this.field_77045_g = p_i1261_1_;
/*  32 */     this.field_76989_e = p_i1261_2_;
/*     */   }
/*     */   
/*     */   public void func_77042_a(ModelBase p_77042_1_) {
/*  36 */     this.field_77046_h = p_77042_1_;
/*     */   }
/*     */   
/*     */   private float func_77034_a(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
/*  40 */     float f = p_77034_2_ - p_77034_1_;
/*  41 */     while (f < -180.0F)
/*  42 */       f += 360.0F; 
/*  43 */     while (f >= 180.0F)
/*  44 */       f -= 360.0F; 
/*  45 */     return p_77034_1_ + p_77034_3_ * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  50 */     GL11.glPushMatrix();
/*  51 */     GL11.glDisable(2884);
/*     */     
/*  53 */     this.field_77045_g.field_78095_p = func_77040_d(p_76986_1_, p_76986_9_);
/*  54 */     if (this.field_77046_h != null) this.field_77046_h.field_78095_p = this.field_77045_g.field_78095_p; 
/*  55 */     this.field_77045_g.field_78093_q = p_76986_1_.func_70115_ae();
/*  56 */     if (this.field_77046_h != null) this.field_77046_h.field_78093_q = this.field_77045_g.field_78093_q; 
/*  57 */     this.field_77045_g.field_78091_s = p_76986_1_.func_70631_g_();
/*  58 */     if (this.field_77046_h != null) this.field_77046_h.field_78091_s = this.field_77045_g.field_78091_s;
/*     */ 
/*     */     
/*     */     try {
/*  62 */       float f1 = func_77034_a(p_76986_1_.field_70760_ar, p_76986_1_.field_70761_aq, p_76986_9_);
/*  63 */       float f2 = func_77034_a(p_76986_1_.field_70758_at, p_76986_1_.field_70759_as, p_76986_9_);
/*     */       
/*  65 */       if (p_76986_1_.func_70115_ae() && p_76986_1_.field_70154_o instanceof EntityLivingBase) {
/*  66 */         EntityLivingBase entityLivingBase = (EntityLivingBase)p_76986_1_.field_70154_o;
/*  67 */         f1 = func_77034_a(entityLivingBase.field_70760_ar, entityLivingBase.field_70761_aq, p_76986_9_);
/*     */         
/*  69 */         float f = MathHelper.func_76142_g(f2 - f1);
/*  70 */         if (f < -85.0F) f = -85.0F; 
/*  71 */         if (f >= 85.0F) f = 85.0F; 
/*  72 */         f1 = f2 - f;
/*  73 */         if (f * f > 2500.0F) {
/*  74 */           f1 += f * 0.2F;
/*     */         }
/*     */       } 
/*     */       
/*  78 */       float f3 = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
/*     */       
/*  80 */       func_77039_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
/*     */       
/*  82 */       float f4 = func_77044_a(p_76986_1_, p_76986_9_);
/*  83 */       func_77043_a(p_76986_1_, f4, f1, p_76986_9_);
/*     */       
/*  85 */       float f5 = 0.0625F;
/*  86 */       GL11.glEnable(32826);
/*  87 */       GL11.glScalef(-1.0F, -1.0F, 1.0F);
/*     */       
/*  89 */       func_77041_b(p_76986_1_, p_76986_9_);
/*  90 */       GL11.glTranslatef(0.0F, -24.0F * f5 - 0.0078125F, 0.0F);
/*     */       
/*  92 */       float f6 = p_76986_1_.field_70722_aY + (p_76986_1_.field_70721_aZ - p_76986_1_.field_70722_aY) * p_76986_9_;
/*  93 */       float f7 = p_76986_1_.field_70754_ba - p_76986_1_.field_70721_aZ * (1.0F - p_76986_9_);
/*  94 */       if (p_76986_1_.func_70631_g_()) {
/*  95 */         f7 *= 3.0F;
/*     */       }
/*     */       
/*  98 */       if (f6 > 1.0F) f6 = 1.0F;
/*     */       
/* 100 */       GL11.glEnable(3008);
/* 101 */       this.field_77045_g.func_78086_a(p_76986_1_, f7, f6, p_76986_9_);
/* 102 */       func_77036_a(p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/*     */       
/* 104 */       for (byte b = 0; b < 4; b++) {
/* 105 */         int j = func_77032_a(p_76986_1_, b, p_76986_9_);
/* 106 */         if (j > 0) {
/* 107 */           this.field_77046_h.func_78086_a(p_76986_1_, f7, f6, p_76986_9_);
/* 108 */           this.field_77046_h.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/* 109 */           if ((j & 0xF0) == 16) {
/* 110 */             func_82408_c(p_76986_1_, b, p_76986_9_);
/* 111 */             this.field_77046_h.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/*     */           } 
/* 113 */           if ((j & 0xF) == 15) {
/*     */             
/* 115 */             float f9 = p_76986_1_.field_70173_aa + p_76986_9_;
/* 116 */             func_110776_a(field_110814_a);
/* 117 */             GL11.glEnable(3042);
/* 118 */             float f10 = 0.5F;
/* 119 */             GL11.glColor4f(f10, f10, f10, 1.0F);
/* 120 */             GL11.glDepthFunc(514);
/* 121 */             GL11.glDepthMask(false);
/*     */             
/* 123 */             for (byte b1 = 0; b1 < 2; b1++) {
/* 124 */               GL11.glDisable(2896);
/* 125 */               float f11 = 0.76F;
/* 126 */               GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
/* 127 */               GL11.glBlendFunc(768, 1);
/* 128 */               GL11.glMatrixMode(5890);
/* 129 */               GL11.glLoadIdentity();
/* 130 */               float f12 = f9 * (0.001F + b1 * 0.003F) * 20.0F;
/* 131 */               float f13 = 0.33333334F;
/* 132 */               GL11.glScalef(f13, f13, f13);
/* 133 */               GL11.glRotatef(30.0F - b1 * 60.0F, 0.0F, 0.0F, 1.0F);
/* 134 */               GL11.glTranslatef(0.0F, f12, 0.0F);
/* 135 */               GL11.glMatrixMode(5888);
/* 136 */               this.field_77046_h.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/*     */             } 
/*     */             
/* 139 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 140 */             GL11.glMatrixMode(5890);
/* 141 */             GL11.glDepthMask(true);
/* 142 */             GL11.glLoadIdentity();
/* 143 */             GL11.glMatrixMode(5888);
/* 144 */             GL11.glEnable(2896);
/* 145 */             GL11.glDisable(3042);
/* 146 */             GL11.glDepthFunc(515);
/*     */           } 
/*     */           
/* 149 */           GL11.glDisable(3042);
/* 150 */           GL11.glEnable(3008);
/*     */         } 
/*     */       } 
/* 153 */       GL11.glDepthMask(true);
/*     */       
/* 155 */       func_77029_c(p_76986_1_, p_76986_9_);
/* 156 */       float f8 = p_76986_1_.func_70013_c(p_76986_9_);
/* 157 */       int i = func_77030_a(p_76986_1_, f8, p_76986_9_);
/* 158 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 159 */       GL11.glDisable(3553);
/* 160 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/*     */       
/* 162 */       if ((i >> 24 & 0xFF) > 0 || p_76986_1_.field_70737_aN > 0 || p_76986_1_.field_70725_aQ > 0) {
/* 163 */         GL11.glDisable(3553);
/* 164 */         GL11.glDisable(3008);
/* 165 */         GL11.glEnable(3042);
/* 166 */         GL11.glBlendFunc(770, 771);
/* 167 */         GL11.glDepthFunc(514);
/*     */         
/* 169 */         if (p_76986_1_.field_70737_aN > 0 || p_76986_1_.field_70725_aQ > 0) {
/* 170 */           GL11.glColor4f(f8, 0.0F, 0.0F, 0.4F);
/* 171 */           this.field_77045_g.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/* 172 */           for (byte b1 = 0; b1 < 4; b1++) {
/* 173 */             if (func_77035_b(p_76986_1_, b1, p_76986_9_) >= 0) {
/* 174 */               GL11.glColor4f(f8, 0.0F, 0.0F, 0.4F);
/* 175 */               this.field_77046_h.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 180 */         if ((i >> 24 & 0xFF) > 0) {
/* 181 */           float f9 = (i >> 16 & 0xFF) / 255.0F;
/* 182 */           float f10 = (i >> 8 & 0xFF) / 255.0F;
/* 183 */           float f11 = (i & 0xFF) / 255.0F;
/* 184 */           float f12 = (i >> 24 & 0xFF) / 255.0F;
/* 185 */           GL11.glColor4f(f9, f10, f11, f12);
/* 186 */           this.field_77045_g.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/* 187 */           for (byte b1 = 0; b1 < 4; b1++) {
/* 188 */             if (func_77035_b(p_76986_1_, b1, p_76986_9_) >= 0) {
/* 189 */               GL11.glColor4f(f9, f10, f11, f12);
/* 190 */               this.field_77046_h.func_78088_a((Entity)p_76986_1_, f7, f6, f4, f2 - f1, f3, f5);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 195 */         GL11.glDepthFunc(515);
/* 196 */         GL11.glDisable(3042);
/* 197 */         GL11.glEnable(3008);
/* 198 */         GL11.glEnable(3553);
/*     */       } 
/* 200 */       GL11.glDisable(32826);
/* 201 */     } catch (Exception exception) {
/* 202 */       field_147923_a.error("Couldn't render entity", exception);
/*     */     } 
/* 204 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 205 */     GL11.glEnable(3553);
/* 206 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/* 207 */     GL11.glEnable(2884);
/*     */     
/* 209 */     GL11.glPopMatrix();
/*     */     
/* 211 */     func_77033_b(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_);
/*     */   }
/*     */   
/*     */   protected void func_77036_a(EntityLivingBase p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
/* 215 */     func_110777_b((Entity)p_77036_1_);
/* 216 */     if (!p_77036_1_.func_82150_aj()) {
/* 217 */       this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/* 218 */     } else if (!p_77036_1_.func_98034_c((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g)) {
/* 219 */       GL11.glPushMatrix();
/* 220 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
/* 221 */       GL11.glDepthMask(false);
/* 222 */       GL11.glEnable(3042);
/* 223 */       GL11.glBlendFunc(770, 771);
/* 224 */       GL11.glAlphaFunc(516, 0.003921569F);
/* 225 */       this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/* 226 */       GL11.glDisable(3042);
/* 227 */       GL11.glAlphaFunc(516, 0.1F);
/* 228 */       GL11.glPopMatrix();
/* 229 */       GL11.glDepthMask(true);
/*     */     } else {
/* 231 */       this.field_77045_g.func_78087_a(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, (Entity)p_77036_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 236 */     GL11.glTranslatef((float)p_77039_2_, (float)p_77039_4_, (float)p_77039_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 241 */     GL11.glRotatef(180.0F - p_77043_3_, 0.0F, 1.0F, 0.0F);
/* 242 */     if (p_77043_1_.field_70725_aQ > 0) {
/* 243 */       float f = (p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
/* 244 */       f = MathHelper.func_76129_c(f);
/* 245 */       if (f > 1.0F) f = 1.0F; 
/* 246 */       GL11.glRotatef(f * func_77037_a(p_77043_1_), 0.0F, 0.0F, 1.0F);
/*     */     } else {
/* 248 */       String str = EnumChatFormatting.func_110646_a(p_77043_1_.func_70005_c_());
/* 249 */       if ((str.equals("Dinnerbone") || str.equals("Grumm")) && (
/* 250 */         !(p_77043_1_ instanceof EntityPlayer) || !((EntityPlayer)p_77043_1_).func_82238_cc())) {
/* 251 */         GL11.glTranslatef(0.0F, p_77043_1_.field_70131_O + 0.1F, 0.0F);
/* 252 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_77040_d(EntityLivingBase p_77040_1_, float p_77040_2_) {
/* 259 */     return p_77040_1_.func_70678_g(p_77040_2_);
/*     */   }
/*     */   
/*     */   protected float func_77044_a(EntityLivingBase p_77044_1_, float p_77044_2_) {
/* 263 */     return p_77044_1_.field_70173_aa + p_77044_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {}
/*     */ 
/*     */   
/*     */   protected void func_85093_e(EntityLivingBase p_85093_1_, float p_85093_2_) {
/* 271 */     int i = p_85093_1_.func_85035_bI();
/* 272 */     if (i > 0) {
/* 273 */       EntityArrow entityArrow = new EntityArrow(p_85093_1_.field_70170_p, p_85093_1_.field_70165_t, p_85093_1_.field_70163_u, p_85093_1_.field_70161_v);
/* 274 */       Random random = new Random(p_85093_1_.func_145782_y());
/* 275 */       RenderHelper.func_74518_a();
/* 276 */       for (byte b = 0; b < i; b++) {
/* 277 */         GL11.glPushMatrix();
/* 278 */         ModelRenderer modelRenderer = this.field_77045_g.func_85181_a(random);
/* 279 */         ModelBox modelBox = modelRenderer.field_78804_l.get(random.nextInt(modelRenderer.field_78804_l.size()));
/* 280 */         modelRenderer.func_78794_c(0.0625F);
/* 281 */         float f1 = random.nextFloat();
/* 282 */         float f2 = random.nextFloat();
/* 283 */         float f3 = random.nextFloat();
/* 284 */         float f4 = (modelBox.field_78252_a + (modelBox.field_78248_d - modelBox.field_78252_a) * f1) / 16.0F;
/* 285 */         float f5 = (modelBox.field_78250_b + (modelBox.field_78249_e - modelBox.field_78250_b) * f2) / 16.0F;
/* 286 */         float f6 = (modelBox.field_78251_c + (modelBox.field_78246_f - modelBox.field_78251_c) * f3) / 16.0F;
/* 287 */         GL11.glTranslatef(f4, f5, f6);
/* 288 */         f1 = f1 * 2.0F - 1.0F;
/* 289 */         f2 = f2 * 2.0F - 1.0F;
/* 290 */         f3 = f3 * 2.0F - 1.0F;
/*     */         
/* 292 */         f1 *= -1.0F;
/* 293 */         f2 *= -1.0F;
/* 294 */         f3 *= -1.0F;
/*     */         
/* 296 */         float f7 = MathHelper.func_76129_c(f1 * f1 + f3 * f3);
/* 297 */         ((Entity)entityArrow).field_70126_B = ((Entity)entityArrow).field_70177_z = (float)(Math.atan2(f1, f3) * 180.0D / 3.1415927410125732D);
/* 298 */         ((Entity)entityArrow).field_70127_C = ((Entity)entityArrow).field_70125_A = (float)(Math.atan2(f2, f7) * 180.0D / 3.1415927410125732D);
/* 299 */         double d1 = 0.0D;
/* 300 */         double d2 = 0.0D;
/* 301 */         double d3 = 0.0D;
/* 302 */         float f8 = 0.0F;
/* 303 */         this.field_76990_c.func_147940_a((Entity)entityArrow, d1, d2, d3, f8, p_85093_2_);
/* 304 */         GL11.glPopMatrix();
/*     */       } 
/* 306 */       RenderHelper.func_74519_b();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_77035_b(EntityLivingBase p_77035_1_, int p_77035_2_, float p_77035_3_) {
/* 312 */     return func_77032_a(p_77035_1_, p_77035_2_, p_77035_3_);
/*     */   }
/*     */   
/*     */   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 316 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_) {}
/*     */   
/*     */   protected float func_77037_a(EntityLivingBase p_77037_1_) {
/* 323 */     return 90.0F;
/*     */   }
/*     */   
/*     */   protected int func_77030_a(EntityLivingBase p_77030_1_, float p_77030_2_, float p_77030_3_) {
/* 327 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {}
/*     */   
/*     */   protected void func_77033_b(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
/* 334 */     GL11.glAlphaFunc(516, 0.1F);
/* 335 */     if (func_110813_b(p_77033_1_)) {
/* 336 */       float f1 = 1.6F;
/* 337 */       float f2 = 0.016666668F * f1;
/* 338 */       double d = p_77033_1_.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/*     */       
/* 340 */       float f3 = p_77033_1_.func_70093_af() ? 32.0F : 64.0F;
/*     */       
/* 342 */       if (d < (f3 * f3)) {
/* 343 */         String str = p_77033_1_.func_145748_c_().func_150254_d();
/*     */         
/* 345 */         if (p_77033_1_.func_70093_af()) {
/* 346 */           FontRenderer fontRenderer = func_76983_a();
/* 347 */           GL11.glPushMatrix();
/* 348 */           GL11.glTranslatef((float)p_77033_2_ + 0.0F, (float)p_77033_4_ + p_77033_1_.field_70131_O + 0.5F, (float)p_77033_6_);
/* 349 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*     */           
/* 351 */           GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 352 */           GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */           
/* 354 */           GL11.glScalef(-f2, -f2, f2);
/* 355 */           GL11.glDisable(2896);
/*     */           
/* 357 */           GL11.glTranslatef(0.0F, 0.25F / f2, 0.0F);
/* 358 */           GL11.glDepthMask(false);
/* 359 */           GL11.glEnable(3042);
/* 360 */           OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 361 */           Tessellator tessellator = Tessellator.field_78398_a;
/*     */           
/* 363 */           GL11.glDisable(3553);
/* 364 */           tessellator.func_78382_b();
/* 365 */           int i = fontRenderer.func_78256_a(str) / 2;
/* 366 */           tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 367 */           tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/* 368 */           tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/* 369 */           tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/* 370 */           tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/* 371 */           tessellator.func_78381_a();
/* 372 */           GL11.glEnable(3553);
/* 373 */           GL11.glDepthMask(true);
/* 374 */           fontRenderer.func_78276_b(str, -fontRenderer.func_78256_a(str) / 2, 0, 553648127);
/* 375 */           GL11.glEnable(2896);
/* 376 */           GL11.glDisable(3042);
/* 377 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 378 */           GL11.glPopMatrix();
/*     */         } else {
/* 380 */           func_96449_a(p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_, str, f2, d);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean func_110813_b(EntityLivingBase p_110813_1_) {
/* 387 */     return (Minecraft.func_71382_s() && p_110813_1_ != this.field_76990_c.field_78734_h && !p_110813_1_.func_98034_c((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g) && p_110813_1_.field_70153_n == null);
/*     */   }
/*     */   
/*     */   protected void func_96449_a(EntityLivingBase p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
/* 391 */     if (p_96449_1_.func_70608_bn()) {
/* 392 */       func_147906_a((Entity)p_96449_1_, p_96449_8_, p_96449_2_, p_96449_4_ - 1.5D, p_96449_6_, 64);
/*     */     } else {
/* 394 */       func_147906_a((Entity)p_96449_1_, p_96449_8_, p_96449_2_, p_96449_4_, p_96449_6_, 64);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RendererLivingEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */