/*     */ package net.minecraft.client.renderer.entity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderItem extends Render {
/*  30 */   private static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*     */   
/*  32 */   private RenderBlocks field_147913_i = new RenderBlocks();
/*  33 */   private Random field_77025_h = new Random(); public boolean field_77024_a = true;
/*     */   public float field_77023_b;
/*     */   public static boolean field_82407_g;
/*     */   private static final String __OBFID = "CL_00001003";
/*     */   
/*     */   public RenderItem() {
/*  39 */     this.field_76989_e = 0.15F;
/*  40 */     this.field_76987_f = 0.75F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityItem p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  45 */     ItemStack itemStack = p_76986_1_.func_92059_d();
/*  46 */     if (itemStack.func_77973_b() == null)
/*     */       return; 
/*  48 */     func_110777_b((Entity)p_76986_1_);
/*  49 */     TextureUtil.func_152777_a(false, false, 1.0F);
/*     */     
/*  51 */     this.field_77025_h.setSeed(187L);
/*     */     
/*  53 */     GL11.glPushMatrix();
/*  54 */     float f1 = MathHelper.func_76126_a((p_76986_1_.field_70292_b + p_76986_9_) / 10.0F + p_76986_1_.field_70290_d) * 0.1F + 0.1F;
/*  55 */     float f2 = ((p_76986_1_.field_70292_b + p_76986_9_) / 20.0F + p_76986_1_.field_70290_d) * 57.295776F;
/*     */     
/*  57 */     byte b = 1;
/*  58 */     if ((p_76986_1_.func_92059_d()).field_77994_a > 1) b = 2; 
/*  59 */     if ((p_76986_1_.func_92059_d()).field_77994_a > 5) b = 3; 
/*  60 */     if ((p_76986_1_.func_92059_d()).field_77994_a > 20) b = 4; 
/*  61 */     if ((p_76986_1_.func_92059_d()).field_77994_a > 40) b = 5;
/*     */     
/*  63 */     GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + f1, (float)p_76986_6_);
/*  64 */     GL11.glEnable(32826);
/*     */     
/*  66 */     if (itemStack.func_94608_d() == 0 && itemStack.func_77973_b() instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(itemStack.func_77973_b()).func_149645_b())) {
/*  67 */       Block block = Block.func_149634_a(itemStack.func_77973_b());
/*  68 */       GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
/*     */       
/*  70 */       if (field_82407_g) {
/*  71 */         GL11.glScalef(1.25F, 1.25F, 1.25F);
/*  72 */         GL11.glTranslatef(0.0F, 0.05F, 0.0F);
/*  73 */         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*     */       } 
/*     */       
/*  76 */       float f = 0.25F;
/*  77 */       int i = block.func_149645_b();
/*  78 */       if (i == 1 || i == 19 || i == 12 || i == 2) {
/*  79 */         f = 0.5F;
/*     */       }
/*     */       
/*  82 */       if (block.func_149701_w() > 0) {
/*  83 */         GL11.glAlphaFunc(516, 0.1F);
/*  84 */         GL11.glEnable(3042);
/*  85 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       } 
/*  87 */       GL11.glScalef(f, f, f);
/*  88 */       for (byte b1 = 0; b1 < b; b1++) {
/*  89 */         GL11.glPushMatrix();
/*  90 */         if (b1 > 0) {
/*  91 */           float f3 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f;
/*  92 */           float f4 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f;
/*  93 */           float f5 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f;
/*  94 */           GL11.glTranslatef(f3, f4, f5);
/*     */         } 
/*     */         
/*  97 */         this.field_147913_i.func_147800_a(block, itemStack.func_77960_j(), 1.0F);
/*  98 */         GL11.glPopMatrix();
/*     */       } 
/* 100 */       if (block.func_149701_w() > 0) {
/* 101 */         GL11.glDisable(3042);
/*     */       }
/* 103 */     } else if (itemStack.func_94608_d() == 1 && itemStack.func_77973_b().func_77623_v()) {
/* 104 */       if (field_82407_g) {
/* 105 */         GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
/* 106 */         GL11.glTranslatef(0.0F, -0.05F, 0.0F);
/*     */       } else {
/* 108 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */       } 
/*     */       
/* 111 */       for (byte b1 = 0; b1 <= 1; b1++) {
/* 112 */         this.field_77025_h.setSeed(187L);
/* 113 */         IIcon iIcon = itemStack.func_77973_b().func_77618_c(itemStack.func_77960_j(), b1);
/*     */         
/* 115 */         if (this.field_77024_a) {
/* 116 */           int i = itemStack.func_77973_b().func_82790_a(itemStack, b1);
/* 117 */           float f3 = (i >> 16 & 0xFF) / 255.0F;
/* 118 */           float f4 = (i >> 8 & 0xFF) / 255.0F;
/* 119 */           float f5 = (i & 0xFF) / 255.0F;
/*     */           
/* 121 */           GL11.glColor4f(f3, f4, f5, 1.0F);
/* 122 */           func_77020_a(p_76986_1_, iIcon, b, p_76986_9_, f3, f4, f5);
/*     */         } else {
/* 124 */           func_77020_a(p_76986_1_, iIcon, b, p_76986_9_, 1.0F, 1.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 128 */       if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemCloth) {
/* 129 */         GL11.glAlphaFunc(516, 0.1F);
/* 130 */         GL11.glEnable(3042);
/* 131 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       } 
/*     */       
/* 134 */       if (field_82407_g) {
/* 135 */         GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
/* 136 */         GL11.glTranslatef(0.0F, -0.05F, 0.0F);
/*     */       } else {
/* 138 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/*     */       } 
/*     */       
/* 141 */       IIcon iIcon = itemStack.func_77954_c();
/* 142 */       if (this.field_77024_a) {
/* 143 */         int i = itemStack.func_77973_b().func_82790_a(itemStack, 0);
/* 144 */         float f3 = (i >> 16 & 0xFF) / 255.0F;
/* 145 */         float f4 = (i >> 8 & 0xFF) / 255.0F;
/* 146 */         float f5 = (i & 0xFF) / 255.0F;
/*     */         
/* 148 */         func_77020_a(p_76986_1_, iIcon, b, p_76986_9_, f3, f4, f5);
/*     */       } else {
/* 150 */         func_77020_a(p_76986_1_, iIcon, b, p_76986_9_, 1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */       
/* 153 */       if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemCloth) {
/* 154 */         GL11.glDisable(3042);
/*     */       }
/*     */     } 
/*     */     
/* 158 */     GL11.glDisable(32826);
/* 159 */     GL11.glPopMatrix();
/* 160 */     func_110777_b((Entity)p_76986_1_);
/* 161 */     TextureUtil.func_147945_b();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityItem p_110775_1_) {
/* 166 */     return this.field_76990_c.field_78724_e.func_130087_a(p_110775_1_.func_92059_d().func_94608_d());
/*     */   }
/*     */   private void func_77020_a(EntityItem p_77020_1_, IIcon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_) {
/*     */     TextureAtlasSprite textureAtlasSprite;
/* 170 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 172 */     if (p_77020_2_ == null) {
/*     */       
/* 174 */       TextureManager textureManager = Minecraft.func_71410_x().func_110434_K();
/* 175 */       ResourceLocation resourceLocation = textureManager.func_130087_a(p_77020_1_.func_92059_d().func_94608_d());
/*     */       
/* 177 */       textureAtlasSprite = ((TextureMap)textureManager.func_110581_b(resourceLocation)).func_110572_b("missingno");
/*     */     } 
/*     */     
/* 180 */     float f1 = textureAtlasSprite.func_94209_e();
/* 181 */     float f2 = textureAtlasSprite.func_94212_f();
/* 182 */     float f3 = textureAtlasSprite.func_94206_g();
/* 183 */     float f4 = textureAtlasSprite.func_94210_h();
/*     */     
/* 185 */     float f5 = 1.0F;
/* 186 */     float f6 = 0.5F;
/* 187 */     float f7 = 0.25F;
/*     */     
/* 189 */     if (this.field_76990_c.field_78733_k.field_74347_j) {
/* 190 */       GL11.glPushMatrix();
/* 191 */       if (field_82407_g) {
/* 192 */         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*     */       } else {
/* 194 */         GL11.glRotatef(((p_77020_1_.field_70292_b + p_77020_4_) / 20.0F + p_77020_1_.field_70290_d) * 57.295776F, 0.0F, 1.0F, 0.0F);
/*     */       } 
/*     */       
/* 197 */       float f8 = 0.0625F;
/* 198 */       float f9 = 0.021875F;
/* 199 */       ItemStack itemStack = p_77020_1_.func_92059_d();
/* 200 */       int i = itemStack.field_77994_a;
/*     */       
/* 202 */       if (i < 2) {
/* 203 */         p_77020_3_ = 1;
/* 204 */       } else if (i < 16) {
/* 205 */         p_77020_3_ = 2;
/* 206 */       } else if (i < 32) {
/* 207 */         p_77020_3_ = 3;
/*     */       } else {
/* 209 */         p_77020_3_ = 4;
/*     */       } 
/*     */       
/* 212 */       GL11.glTranslatef(-f6, -f7, -((f8 + f9) * p_77020_3_ / 2.0F));
/*     */       
/* 214 */       for (byte b = 0; b < p_77020_3_; b++) {
/* 215 */         GL11.glTranslatef(0.0F, 0.0F, f8 + f9);
/*     */         
/* 217 */         if (itemStack.func_94608_d() == 0) {
/* 218 */           func_110776_a(TextureMap.field_110575_b);
/*     */         } else {
/* 220 */           func_110776_a(TextureMap.field_110576_c);
/*     */         } 
/* 222 */         GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
/* 223 */         ItemRenderer.func_78439_a(tessellator, f2, f3, f1, f4, textureAtlasSprite.func_94211_a(), textureAtlasSprite.func_94216_b(), f8);
/*     */         
/* 225 */         if (itemStack.func_77962_s()) {
/* 226 */           GL11.glDepthFunc(514);
/* 227 */           GL11.glDisable(2896);
/*     */           
/* 229 */           this.field_76990_c.field_78724_e.func_110577_a(field_110798_h);
/* 230 */           GL11.glEnable(3042);
/* 231 */           GL11.glBlendFunc(768, 1);
/* 232 */           float f10 = 0.76F;
/* 233 */           GL11.glColor4f(0.5F * f10, 0.25F * f10, 0.8F * f10, 1.0F);
/* 234 */           GL11.glMatrixMode(5890);
/* 235 */           GL11.glPushMatrix();
/* 236 */           float f11 = 0.125F;
/* 237 */           GL11.glScalef(f11, f11, f11);
/* 238 */           float f12 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 239 */           GL11.glTranslatef(f12, 0.0F, 0.0F);
/* 240 */           GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/*     */           
/* 242 */           ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f8);
/* 243 */           GL11.glPopMatrix();
/* 244 */           GL11.glPushMatrix();
/* 245 */           GL11.glScalef(f11, f11, f11);
/* 246 */           f12 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 247 */           GL11.glTranslatef(-f12, 0.0F, 0.0F);
/* 248 */           GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 249 */           ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f8);
/* 250 */           GL11.glPopMatrix();
/* 251 */           GL11.glMatrixMode(5888);
/* 252 */           GL11.glDisable(3042);
/* 253 */           GL11.glEnable(2896);
/* 254 */           GL11.glDepthFunc(515);
/*     */         } 
/*     */       } 
/*     */       
/* 258 */       GL11.glPopMatrix();
/*     */     } else {
/* 260 */       for (byte b = 0; b < p_77020_3_; b++) {
/* 261 */         GL11.glPushMatrix();
/* 262 */         if (b > 0) {
/* 263 */           float f8 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
/* 264 */           float f9 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
/* 265 */           float f10 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
/* 266 */           GL11.glTranslatef(f8, f9, f10);
/*     */         } 
/*     */         
/* 269 */         if (!field_82407_g) GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F); 
/* 270 */         GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
/* 271 */         tessellator.func_78382_b();
/* 272 */         tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 273 */         tessellator.func_78374_a((0.0F - f6), (0.0F - f7), 0.0D, f1, f4);
/* 274 */         tessellator.func_78374_a((f5 - f6), (0.0F - f7), 0.0D, f2, f4);
/* 275 */         tessellator.func_78374_a((f5 - f6), (1.0F - f7), 0.0D, f2, f3);
/* 276 */         tessellator.func_78374_a((0.0F - f6), (1.0F - f7), 0.0D, f1, f3);
/* 277 */         tessellator.func_78381_a();
/* 278 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_77015_a(FontRenderer p_77015_1_, TextureManager p_77015_2_, ItemStack p_77015_3_, int p_77015_4_, int p_77015_5_) {
/* 284 */     int i = p_77015_3_.func_77960_j();
/* 285 */     IIcon iIcon = p_77015_3_.func_77954_c();
/*     */     
/* 287 */     if (p_77015_3_.func_94608_d() == 0 && RenderBlocks.func_147739_a(Block.func_149634_a(p_77015_3_.func_77973_b()).func_149645_b())) {
/* 288 */       p_77015_2_.func_110577_a(TextureMap.field_110575_b);
/*     */       
/* 290 */       Block block = Block.func_149634_a(p_77015_3_.func_77973_b());
/*     */       
/* 292 */       GL11.glEnable(3008);
/*     */       
/* 294 */       if (block.func_149701_w() != 0) {
/* 295 */         GL11.glAlphaFunc(516, 0.1F);
/* 296 */         GL11.glEnable(3042);
/* 297 */         OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       } else {
/* 299 */         GL11.glAlphaFunc(516, 0.5F);
/* 300 */         GL11.glDisable(3042);
/*     */       } 
/*     */       
/* 303 */       GL11.glPushMatrix();
/* 304 */       GL11.glTranslatef((p_77015_4_ - 2), (p_77015_5_ + 3), -3.0F + this.field_77023_b);
/* 305 */       GL11.glScalef(10.0F, 10.0F, 10.0F);
/* 306 */       GL11.glTranslatef(1.0F, 0.5F, 1.0F);
/* 307 */       GL11.glScalef(1.0F, 1.0F, -1.0F);
/* 308 */       GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
/* 309 */       GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 311 */       int j = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, 0);
/* 312 */       float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 313 */       float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 314 */       float f3 = (j & 0xFF) / 255.0F;
/*     */       
/* 316 */       if (this.field_77024_a) GL11.glColor4f(f1, f2, f3, 1.0F); 
/* 317 */       GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 318 */       this.field_147913_i.field_147844_c = this.field_77024_a;
/* 319 */       this.field_147913_i.func_147800_a(block, i, 1.0F);
/* 320 */       this.field_147913_i.field_147844_c = true;
/*     */       
/* 322 */       if (block.func_149701_w() == 0) {
/* 323 */         GL11.glAlphaFunc(516, 0.1F);
/*     */       }
/*     */       
/* 326 */       GL11.glPopMatrix();
/* 327 */     } else if (p_77015_3_.func_77973_b().func_77623_v()) {
/*     */       
/* 329 */       GL11.glDisable(2896);
/* 330 */       GL11.glEnable(3008);
/* 331 */       p_77015_2_.func_110577_a(TextureMap.field_110576_c);
/*     */ 
/*     */       
/* 334 */       GL11.glDisable(3008);
/* 335 */       GL11.glDisable(3553);
/* 336 */       GL11.glEnable(3042);
/* 337 */       OpenGlHelper.func_148821_a(0, 0, 0, 0);
/* 338 */       GL11.glColorMask(false, false, false, true);
/* 339 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 340 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 341 */       tessellator.func_78382_b();
/* 342 */       tessellator.func_78378_d(-1);
/* 343 */       tessellator.func_78377_a((p_77015_4_ - 2), (p_77015_5_ + 18), this.field_77023_b);
/* 344 */       tessellator.func_78377_a((p_77015_4_ + 18), (p_77015_5_ + 18), this.field_77023_b);
/* 345 */       tessellator.func_78377_a((p_77015_4_ + 18), (p_77015_5_ - 2), this.field_77023_b);
/* 346 */       tessellator.func_78377_a((p_77015_4_ - 2), (p_77015_5_ - 2), this.field_77023_b);
/* 347 */       tessellator.func_78381_a();
/* 348 */       GL11.glColorMask(true, true, true, true);
/* 349 */       GL11.glEnable(3553);
/* 350 */       GL11.glEnable(3008);
/*     */       
/* 352 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 353 */       for (byte b = 0; b <= 1; b++) {
/* 354 */         IIcon iIcon1 = p_77015_3_.func_77973_b().func_77618_c(i, b);
/*     */         
/* 356 */         int j = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, b);
/* 357 */         float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 358 */         float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 359 */         float f3 = (j & 0xFF) / 255.0F;
/*     */         
/* 361 */         if (this.field_77024_a) GL11.glColor4f(f1, f2, f3, 1.0F); 
/* 362 */         func_94149_a(p_77015_4_, p_77015_5_, iIcon1, 16, 16);
/*     */       } 
/*     */       
/* 365 */       GL11.glEnable(2896);
/*     */     } else {
/* 367 */       TextureAtlasSprite textureAtlasSprite; GL11.glDisable(2896);
/*     */       
/* 369 */       GL11.glEnable(3042);
/* 370 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */       
/* 372 */       ResourceLocation resourceLocation = p_77015_2_.func_130087_a(p_77015_3_.func_94608_d());
/* 373 */       p_77015_2_.func_110577_a(resourceLocation);
/*     */       
/* 375 */       if (iIcon == null) {
/* 376 */         textureAtlasSprite = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(resourceLocation)).func_110572_b("missingno");
/*     */       }
/*     */       
/* 379 */       int j = p_77015_3_.func_77973_b().func_82790_a(p_77015_3_, 0);
/* 380 */       float f1 = (j >> 16 & 0xFF) / 255.0F;
/* 381 */       float f2 = (j >> 8 & 0xFF) / 255.0F;
/* 382 */       float f3 = (j & 0xFF) / 255.0F;
/*     */       
/* 384 */       if (this.field_77024_a) GL11.glColor4f(f1, f2, f3, 1.0F); 
/* 385 */       func_94149_a(p_77015_4_, p_77015_5_, (IIcon)textureAtlasSprite, 16, 16);
/* 386 */       GL11.glEnable(2896);
/*     */       
/* 388 */       GL11.glDisable(3042);
/*     */     } 
/* 390 */     GL11.glEnable(2884);
/*     */   }
/*     */   
/*     */   public void func_82406_b(FontRenderer p_82406_1_, TextureManager p_82406_2_, ItemStack p_82406_3_, int p_82406_4_, int p_82406_5_) {
/* 394 */     if (p_82406_3_ == null) {
/*     */       return;
/*     */     }
/*     */     
/* 398 */     this.field_77023_b += 50.0F;
/*     */     try {
/* 400 */       func_77015_a(p_82406_1_, p_82406_2_, p_82406_3_, p_82406_4_, p_82406_5_);
/* 401 */     } catch (Throwable throwable) {
/* 402 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering item");
/* 403 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Item being rendered");
/*     */       
/* 405 */       crashReportCategory.func_71500_a("Item Type", new Callable(this, p_82406_3_) { private static final String __OBFID = "CL_00001004";
/*     */             
/*     */             public String call() {
/* 408 */               return String.valueOf(this.field_147929_a.func_77973_b());
/*     */             } }
/*     */         );
/*     */       
/* 412 */       crashReportCategory.func_71500_a("Item Aux", new Callable(this, p_82406_3_) { private static final String __OBFID = "CL_00001005";
/*     */             
/*     */             public String call() {
/* 415 */               return String.valueOf(this.field_147926_a.func_77960_j());
/*     */             } }
/*     */         );
/*     */       
/* 419 */       crashReportCategory.func_71500_a("Item NBT", new Callable(this, p_82406_3_) { private static final String __OBFID = "CL_00001006";
/*     */             
/*     */             public String call() {
/* 422 */               return String.valueOf(this.field_147935_a.func_77978_p());
/*     */             } }
/*     */         );
/*     */       
/* 426 */       crashReportCategory.func_71500_a("Item Foil", new Callable(this, p_82406_3_) { private static final String __OBFID = "CL_00001007";
/*     */             
/*     */             public String call() {
/* 429 */               return String.valueOf(this.field_147932_a.func_77962_s());
/*     */             } }
/*     */         );
/*     */       
/* 433 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 436 */     if (p_82406_3_.func_77962_s()) {
/* 437 */       GL11.glDepthFunc(514);
/* 438 */       GL11.glDisable(2896);
/* 439 */       GL11.glDepthMask(false);
/* 440 */       p_82406_2_.func_110577_a(field_110798_h);
/* 441 */       GL11.glEnable(3008);
/* 442 */       GL11.glEnable(3042);
/* 443 */       GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
/* 444 */       func_77018_a(p_82406_4_ * 431278612 + p_82406_5_ * 32178161, p_82406_4_ - 2, p_82406_5_ - 2, 20, 20);
/* 445 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 446 */       GL11.glDepthMask(true);
/* 447 */       GL11.glEnable(2896);
/* 448 */       GL11.glDepthFunc(515);
/*     */     } 
/* 450 */     this.field_77023_b -= 50.0F;
/*     */   }
/*     */   
/*     */   private void func_77018_a(int p_77018_1_, int p_77018_2_, int p_77018_3_, int p_77018_4_, int p_77018_5_) {
/* 454 */     for (byte b = 0; b < 2; b++) {
/* 455 */       OpenGlHelper.func_148821_a(772, 1, 0, 0);
/* 456 */       float f1 = 0.00390625F;
/* 457 */       float f2 = 0.00390625F;
/* 458 */       float f3 = (float)(Minecraft.func_71386_F() % (3000 + b * 1873)) / (3000.0F + (b * 1873)) * 256.0F;
/* 459 */       float f4 = 0.0F;
/* 460 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 461 */       float f5 = 4.0F;
/* 462 */       if (b == 1) f5 = -1.0F; 
/* 463 */       tessellator.func_78382_b();
/* 464 */       tessellator.func_78374_a((p_77018_2_ + 0), (p_77018_3_ + p_77018_5_), this.field_77023_b, ((f3 + p_77018_5_ * f5) * f1), ((f4 + p_77018_5_) * f2));
/* 465 */       tessellator.func_78374_a((p_77018_2_ + p_77018_4_), (p_77018_3_ + p_77018_5_), this.field_77023_b, ((f3 + p_77018_4_ + p_77018_5_ * f5) * f1), ((f4 + p_77018_5_) * f2));
/* 466 */       tessellator.func_78374_a((p_77018_2_ + p_77018_4_), (p_77018_3_ + 0), this.field_77023_b, ((f3 + p_77018_4_) * f1), ((f4 + 0.0F) * f2));
/* 467 */       tessellator.func_78374_a((p_77018_2_ + 0), (p_77018_3_ + 0), this.field_77023_b, ((f3 + 0.0F) * f1), ((f4 + 0.0F) * f2));
/* 468 */       tessellator.func_78381_a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_77021_b(FontRenderer p_77021_1_, TextureManager p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_) {
/* 473 */     func_94148_a(p_77021_1_, p_77021_2_, p_77021_3_, p_77021_4_, p_77021_5_, (String)null);
/*     */   }
/*     */   
/*     */   public void func_94148_a(FontRenderer p_94148_1_, TextureManager p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_) {
/* 477 */     if (p_94148_3_ == null) {
/*     */       return;
/*     */     }
/*     */     
/* 481 */     if (p_94148_3_.field_77994_a > 1 || p_94148_6_ != null) {
/* 482 */       String str = (p_94148_6_ == null) ? String.valueOf(p_94148_3_.field_77994_a) : p_94148_6_;
/* 483 */       GL11.glDisable(2896);
/* 484 */       GL11.glDisable(2929);
/* 485 */       GL11.glDisable(3042);
/* 486 */       p_94148_1_.func_78261_a(str, p_94148_4_ + 19 - 2 - p_94148_1_.func_78256_a(str), p_94148_5_ + 6 + 3, 16777215);
/* 487 */       GL11.glEnable(2896);
/* 488 */       GL11.glEnable(2929);
/*     */     } 
/*     */     
/* 491 */     if (p_94148_3_.func_77951_h()) {
/* 492 */       int i = (int)Math.round(13.0D - p_94148_3_.func_77952_i() * 13.0D / p_94148_3_.func_77958_k());
/* 493 */       int j = (int)Math.round(255.0D - p_94148_3_.func_77952_i() * 255.0D / p_94148_3_.func_77958_k());
/* 494 */       GL11.glDisable(2896);
/* 495 */       GL11.glDisable(2929);
/* 496 */       GL11.glDisable(3553);
/* 497 */       GL11.glDisable(3008);
/* 498 */       GL11.glDisable(3042);
/*     */       
/* 500 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/* 502 */       int k = 255 - j << 16 | j << 8;
/* 503 */       int m = (255 - j) / 4 << 16 | 0x3F00;
/* 504 */       func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
/* 505 */       func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, m);
/* 506 */       func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, i, 1, k);
/*     */       
/* 508 */       GL11.glEnable(3042);
/* 509 */       GL11.glEnable(3008);
/* 510 */       GL11.glEnable(3553);
/* 511 */       GL11.glEnable(2896);
/* 512 */       GL11.glEnable(2929);
/* 513 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_77017_a(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_) {
/* 518 */     p_77017_1_.func_78382_b();
/* 519 */     p_77017_1_.func_78378_d(p_77017_6_);
/* 520 */     p_77017_1_.func_78377_a((p_77017_2_ + 0), (p_77017_3_ + 0), 0.0D);
/* 521 */     p_77017_1_.func_78377_a((p_77017_2_ + 0), (p_77017_3_ + p_77017_5_), 0.0D);
/* 522 */     p_77017_1_.func_78377_a((p_77017_2_ + p_77017_4_), (p_77017_3_ + p_77017_5_), 0.0D);
/* 523 */     p_77017_1_.func_78377_a((p_77017_2_ + p_77017_4_), (p_77017_3_ + 0), 0.0D);
/* 524 */     p_77017_1_.func_78381_a();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94149_a(int p_94149_1_, int p_94149_2_, IIcon p_94149_3_, int p_94149_4_, int p_94149_5_) {
/* 540 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 541 */     tessellator.func_78382_b();
/* 542 */     tessellator.func_78374_a((p_94149_1_ + 0), (p_94149_2_ + p_94149_5_), this.field_77023_b, p_94149_3_.func_94209_e(), p_94149_3_.func_94210_h());
/* 543 */     tessellator.func_78374_a((p_94149_1_ + p_94149_4_), (p_94149_2_ + p_94149_5_), this.field_77023_b, p_94149_3_.func_94212_f(), p_94149_3_.func_94210_h());
/* 544 */     tessellator.func_78374_a((p_94149_1_ + p_94149_4_), (p_94149_2_ + 0), this.field_77023_b, p_94149_3_.func_94212_f(), p_94149_3_.func_94206_g());
/* 545 */     tessellator.func_78374_a((p_94149_1_ + 0), (p_94149_2_ + 0), this.field_77023_b, p_94149_3_.func_94209_e(), p_94149_3_.func_94206_g());
/* 546 */     tessellator.func_78381_a();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */