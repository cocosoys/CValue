/*     */ package net.minecraft.client.renderer;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.storage.MapData;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ItemRenderer {
/*  28 */   private static final ResourceLocation field_110930_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*  29 */   private static final ResourceLocation field_110931_c = new ResourceLocation("textures/map/map_background.png");
/*  30 */   private static final ResourceLocation field_110929_d = new ResourceLocation("textures/misc/underwater.png");
/*     */   
/*     */   private Minecraft field_78455_a;
/*     */   private ItemStack field_78453_b;
/*     */   private float field_78454_c;
/*     */   private float field_78451_d;
/*  36 */   private RenderBlocks field_147720_h = new RenderBlocks();
/*     */   
/*     */   private int field_78450_g;
/*     */   
/*     */   private static final String __OBFID = "CL_00000953";
/*     */   
/*     */   public void func_78443_a(EntityLivingBase p_78443_1_, ItemStack p_78443_2_, int p_78443_3_) {
/*  43 */     GL11.glPushMatrix();
/*  44 */     TextureManager textureManager = this.field_78455_a.func_110434_K();
/*     */     
/*  46 */     Item item = p_78443_2_.func_77973_b();
/*  47 */     Block block = Block.func_149634_a(item);
/*     */     
/*  49 */     if (p_78443_2_ != null && block != null && block.func_149701_w() != 0) {
/*  50 */       GL11.glEnable(3042);
/*  51 */       GL11.glEnable(2884);
/*  52 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     } 
/*     */     
/*  55 */     if (p_78443_2_.func_94608_d() == 0 && item instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(block.func_149645_b())) {
/*  56 */       textureManager.func_110577_a(textureManager.func_130087_a(0));
/*  57 */       if (p_78443_2_ != null && block != null && block.func_149701_w() != 0) {
/*  58 */         GL11.glDepthMask(false);
/*  59 */         this.field_147720_h.func_147800_a(block, p_78443_2_.func_77960_j(), 1.0F);
/*  60 */         GL11.glDepthMask(true);
/*     */       } else {
/*  62 */         this.field_147720_h.func_147800_a(block, p_78443_2_.func_77960_j(), 1.0F);
/*     */       } 
/*     */     } else {
/*  65 */       IIcon iIcon = p_78443_1_.func_70620_b(p_78443_2_, p_78443_3_);
/*  66 */       if (iIcon == null) {
/*  67 */         GL11.glPopMatrix();
/*     */         
/*     */         return;
/*     */       } 
/*  71 */       textureManager.func_110577_a(textureManager.func_130087_a(p_78443_2_.func_94608_d()));
/*  72 */       TextureUtil.func_152777_a(false, false, 1.0F);
/*     */       
/*  74 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */ 
/*     */ 
/*     */       
/*  78 */       float f1 = iIcon.func_94209_e();
/*  79 */       float f2 = iIcon.func_94212_f();
/*  80 */       float f3 = iIcon.func_94206_g();
/*  81 */       float f4 = iIcon.func_94210_h();
/*     */       
/*  83 */       float f5 = 0.0F;
/*  84 */       float f6 = 0.3F;
/*     */       
/*  86 */       GL11.glEnable(32826);
/*  87 */       GL11.glTranslatef(-f5, -f6, 0.0F);
/*  88 */       float f7 = 1.5F;
/*  89 */       GL11.glScalef(f7, f7, f7);
/*     */       
/*  91 */       GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/*  92 */       GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
/*  93 */       GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
/*     */       
/*  95 */       func_78439_a(tessellator, f2, f3, f1, f4, iIcon.func_94211_a(), iIcon.func_94216_b(), 0.0625F);
/*     */       
/*  97 */       if (p_78443_2_.func_77962_s() && p_78443_3_ == 0) {
/*  98 */         GL11.glDepthFunc(514);
/*  99 */         GL11.glDisable(2896);
/* 100 */         textureManager.func_110577_a(field_110930_b);
/* 101 */         GL11.glEnable(3042);
/* 102 */         OpenGlHelper.func_148821_a(768, 1, 1, 0);
/* 103 */         float f8 = 0.76F;
/* 104 */         GL11.glColor4f(0.5F * f8, 0.25F * f8, 0.8F * f8, 1.0F);
/* 105 */         GL11.glMatrixMode(5890);
/* 106 */         GL11.glPushMatrix();
/* 107 */         float f9 = 0.125F;
/* 108 */         GL11.glScalef(f9, f9, f9);
/* 109 */         float f10 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 110 */         GL11.glTranslatef(f10, 0.0F, 0.0F);
/* 111 */         GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/*     */         
/* 113 */         func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 114 */         GL11.glPopMatrix();
/* 115 */         GL11.glPushMatrix();
/* 116 */         GL11.glScalef(f9, f9, f9);
/* 117 */         f10 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 118 */         GL11.glTranslatef(-f10, 0.0F, 0.0F);
/* 119 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 120 */         func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 121 */         GL11.glPopMatrix();
/* 122 */         GL11.glMatrixMode(5888);
/* 123 */         GL11.glDisable(3042);
/* 124 */         GL11.glEnable(2896);
/* 125 */         GL11.glDepthFunc(515);
/*     */       } 
/*     */       
/* 128 */       GL11.glDisable(32826);
/* 129 */       textureManager.func_110577_a(textureManager.func_130087_a(p_78443_2_.func_94608_d()));
/* 130 */       TextureUtil.func_147945_b();
/*     */     } 
/*     */     
/* 133 */     if (p_78443_2_ != null && block != null && block.func_149701_w() != 0) {
/* 134 */       GL11.glDisable(3042);
/*     */     }
/*     */     
/* 137 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void func_78439_a(Tessellator p_78439_0_, float p_78439_1_, float p_78439_2_, float p_78439_3_, float p_78439_4_, int p_78439_5_, int p_78439_6_, float p_78439_7_) {
/* 142 */     p_78439_0_.func_78382_b();
/* 143 */     p_78439_0_.func_78375_b(0.0F, 0.0F, 1.0F);
/* 144 */     p_78439_0_.func_78374_a(0.0D, 0.0D, 0.0D, p_78439_1_, p_78439_4_);
/* 145 */     p_78439_0_.func_78374_a(1.0D, 0.0D, 0.0D, p_78439_3_, p_78439_4_);
/* 146 */     p_78439_0_.func_78374_a(1.0D, 1.0D, 0.0D, p_78439_3_, p_78439_2_);
/* 147 */     p_78439_0_.func_78374_a(0.0D, 1.0D, 0.0D, p_78439_1_, p_78439_2_);
/* 148 */     p_78439_0_.func_78381_a();
/*     */     
/* 150 */     p_78439_0_.func_78382_b();
/* 151 */     p_78439_0_.func_78375_b(0.0F, 0.0F, -1.0F);
/* 152 */     p_78439_0_.func_78374_a(0.0D, 1.0D, (0.0F - p_78439_7_), p_78439_1_, p_78439_2_);
/* 153 */     p_78439_0_.func_78374_a(1.0D, 1.0D, (0.0F - p_78439_7_), p_78439_3_, p_78439_2_);
/* 154 */     p_78439_0_.func_78374_a(1.0D, 0.0D, (0.0F - p_78439_7_), p_78439_3_, p_78439_4_);
/* 155 */     p_78439_0_.func_78374_a(0.0D, 0.0D, (0.0F - p_78439_7_), p_78439_1_, p_78439_4_);
/* 156 */     p_78439_0_.func_78381_a();
/*     */     
/* 158 */     float f1 = 0.5F * (p_78439_1_ - p_78439_3_) / p_78439_5_;
/* 159 */     float f2 = 0.5F * (p_78439_4_ - p_78439_2_) / p_78439_6_;
/*     */     
/* 161 */     p_78439_0_.func_78382_b();
/* 162 */     p_78439_0_.func_78375_b(-1.0F, 0.0F, 0.0F); byte b;
/* 163 */     for (b = 0; b < p_78439_5_; b++) {
/* 164 */       float f3 = b / p_78439_5_;
/* 165 */       float f4 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f3 - f1;
/* 166 */       float f5 = f3;
/* 167 */       p_78439_0_.func_78374_a(f5, 0.0D, (0.0F - p_78439_7_), f4, p_78439_4_);
/* 168 */       p_78439_0_.func_78374_a(f5, 0.0D, 0.0D, f4, p_78439_4_);
/* 169 */       p_78439_0_.func_78374_a(f5, 1.0D, 0.0D, f4, p_78439_2_);
/* 170 */       p_78439_0_.func_78374_a(f5, 1.0D, (0.0F - p_78439_7_), f4, p_78439_2_);
/*     */     } 
/* 172 */     p_78439_0_.func_78381_a();
/*     */     
/* 174 */     p_78439_0_.func_78382_b();
/* 175 */     p_78439_0_.func_78375_b(1.0F, 0.0F, 0.0F);
/* 176 */     for (b = 0; b < p_78439_5_; b++) {
/* 177 */       float f3 = b / p_78439_5_;
/* 178 */       float f4 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f3 - f1;
/* 179 */       float f5 = f3 + 1.0F / p_78439_5_;
/* 180 */       p_78439_0_.func_78374_a(f5, 1.0D, (0.0F - p_78439_7_), f4, p_78439_2_);
/* 181 */       p_78439_0_.func_78374_a(f5, 1.0D, 0.0D, f4, p_78439_2_);
/* 182 */       p_78439_0_.func_78374_a(f5, 0.0D, 0.0D, f4, p_78439_4_);
/* 183 */       p_78439_0_.func_78374_a(f5, 0.0D, (0.0F - p_78439_7_), f4, p_78439_4_);
/*     */     } 
/* 185 */     p_78439_0_.func_78381_a();
/*     */     
/* 187 */     p_78439_0_.func_78382_b();
/* 188 */     p_78439_0_.func_78375_b(0.0F, 1.0F, 0.0F);
/* 189 */     for (b = 0; b < p_78439_6_; b++) {
/* 190 */       float f3 = b / p_78439_6_;
/* 191 */       float f4 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f3 - f2;
/* 192 */       float f5 = f3 + 1.0F / p_78439_6_;
/* 193 */       p_78439_0_.func_78374_a(0.0D, f5, 0.0D, p_78439_1_, f4);
/* 194 */       p_78439_0_.func_78374_a(1.0D, f5, 0.0D, p_78439_3_, f4);
/* 195 */       p_78439_0_.func_78374_a(1.0D, f5, (0.0F - p_78439_7_), p_78439_3_, f4);
/* 196 */       p_78439_0_.func_78374_a(0.0D, f5, (0.0F - p_78439_7_), p_78439_1_, f4);
/*     */     } 
/* 198 */     p_78439_0_.func_78381_a();
/*     */     
/* 200 */     p_78439_0_.func_78382_b();
/* 201 */     p_78439_0_.func_78375_b(0.0F, -1.0F, 0.0F);
/* 202 */     for (b = 0; b < p_78439_6_; b++) {
/* 203 */       float f3 = b / p_78439_6_;
/* 204 */       float f4 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f3 - f2;
/* 205 */       float f5 = f3;
/* 206 */       p_78439_0_.func_78374_a(1.0D, f5, 0.0D, p_78439_3_, f4);
/* 207 */       p_78439_0_.func_78374_a(0.0D, f5, 0.0D, p_78439_1_, f4);
/* 208 */       p_78439_0_.func_78374_a(0.0D, f5, (0.0F - p_78439_7_), p_78439_1_, f4);
/* 209 */       p_78439_0_.func_78374_a(1.0D, f5, (0.0F - p_78439_7_), p_78439_3_, f4);
/*     */     } 
/* 211 */     p_78439_0_.func_78381_a();
/*     */   }
/*     */   
/*     */   public void func_78440_a(float p_78440_1_) {
/* 215 */     float f1 = this.field_78451_d + (this.field_78454_c - this.field_78451_d) * p_78440_1_;
/* 216 */     EntityClientPlayerMP entityClientPlayerMP = this.field_78455_a.field_71439_g;
/*     */     
/* 218 */     float f2 = ((AbstractClientPlayer)entityClientPlayerMP).field_70127_C + (((AbstractClientPlayer)entityClientPlayerMP).field_70125_A - ((AbstractClientPlayer)entityClientPlayerMP).field_70127_C) * p_78440_1_;
/*     */     
/* 220 */     GL11.glPushMatrix();
/* 221 */     GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
/* 222 */     GL11.glRotatef(((AbstractClientPlayer)entityClientPlayerMP).field_70126_B + (((AbstractClientPlayer)entityClientPlayerMP).field_70177_z - ((AbstractClientPlayer)entityClientPlayerMP).field_70126_B) * p_78440_1_, 0.0F, 1.0F, 0.0F);
/* 223 */     RenderHelper.func_74519_b();
/* 224 */     GL11.glPopMatrix();
/*     */     
/* 226 */     EntityPlayerSP entityPlayerSP = (EntityPlayerSP)entityClientPlayerMP;
/* 227 */     float f3 = entityPlayerSP.field_71164_i + (entityPlayerSP.field_71155_g - entityPlayerSP.field_71164_i) * p_78440_1_;
/* 228 */     float f4 = entityPlayerSP.field_71163_h + (entityPlayerSP.field_71154_f - entityPlayerSP.field_71163_h) * p_78440_1_;
/* 229 */     GL11.glRotatef((((AbstractClientPlayer)entityClientPlayerMP).field_70125_A - f3) * 0.1F, 1.0F, 0.0F, 0.0F);
/* 230 */     GL11.glRotatef((((AbstractClientPlayer)entityClientPlayerMP).field_70177_z - f4) * 0.1F, 0.0F, 1.0F, 0.0F);
/*     */     
/* 232 */     ItemStack itemStack = this.field_78453_b;
/*     */     
/* 234 */     if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemCloth) {
/* 235 */       GL11.glEnable(3042);
/* 236 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     } 
/*     */     
/* 239 */     int i = this.field_78455_a.field_71441_e.func_72802_i(MathHelper.func_76128_c(((AbstractClientPlayer)entityClientPlayerMP).field_70165_t), MathHelper.func_76128_c(((AbstractClientPlayer)entityClientPlayerMP).field_70163_u), MathHelper.func_76128_c(((AbstractClientPlayer)entityClientPlayerMP).field_70161_v), 0);
/* 240 */     int j = i % 65536;
/* 241 */     int k = i / 65536;
/* 242 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/* 243 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 244 */     if (itemStack != null) {
/* 245 */       int m = itemStack.func_77973_b().func_82790_a(itemStack, 0);
/* 246 */       float f5 = (m >> 16 & 0xFF) / 255.0F;
/* 247 */       float f6 = (m >> 8 & 0xFF) / 255.0F;
/* 248 */       float f7 = (m & 0xFF) / 255.0F;
/*     */       
/* 250 */       GL11.glColor4f(f5, f6, f7, 1.0F);
/*     */     } else {
/*     */       
/* 253 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */     
/* 256 */     if (itemStack != null && itemStack.func_77973_b() == Items.field_151098_aY) {
/* 257 */       GL11.glPushMatrix();
/* 258 */       float f5 = 0.8F;
/*     */ 
/*     */       
/* 261 */       float f6 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/*     */       
/* 263 */       float f8 = MathHelper.func_76126_a(f6 * 3.1415927F);
/* 264 */       float f9 = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F);
/* 265 */       GL11.glTranslatef(-f9 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F * 2.0F) * 0.2F, -f8 * 0.2F);
/*     */ 
/*     */       
/* 268 */       f6 = 1.0F - f2 / 45.0F + 0.1F;
/* 269 */       if (f6 < 0.0F) f6 = 0.0F; 
/* 270 */       if (f6 > 1.0F) f6 = 1.0F; 
/* 271 */       f6 = -MathHelper.func_76134_b(f6 * 3.1415927F) * 0.5F + 0.5F;
/*     */       
/* 273 */       GL11.glTranslatef(0.0F, 0.0F * f5 - (1.0F - f1) * 1.2F - f6 * 0.5F + 0.04F, -0.9F * f5);
/*     */       
/* 275 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 276 */       GL11.glRotatef(f6 * -85.0F, 0.0F, 0.0F, 1.0F);
/* 277 */       GL11.glEnable(32826);
/*     */ 
/*     */       
/* 280 */       this.field_78455_a.func_110434_K().func_110577_a(entityClientPlayerMP.func_110306_p());
/* 281 */       for (byte b1 = 0; b1 < 2; b1++) {
/* 282 */         int m = b1 * 2 - 1;
/* 283 */         GL11.glPushMatrix();
/*     */         
/* 285 */         GL11.glTranslatef(-0.0F, -0.6F, 1.1F * m);
/* 286 */         GL11.glRotatef((-45 * m), 1.0F, 0.0F, 0.0F);
/* 287 */         GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 288 */         GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
/* 289 */         GL11.glRotatef((-65 * m), 0.0F, 1.0F, 0.0F);
/*     */         
/* 291 */         Render render = RenderManager.field_78727_a.func_78713_a((Entity)this.field_78455_a.field_71439_g);
/* 292 */         RenderPlayer renderPlayer = (RenderPlayer)render;
/* 293 */         float f = 1.0F;
/* 294 */         GL11.glScalef(f, f, f);
/* 295 */         renderPlayer.func_82441_a((EntityPlayer)this.field_78455_a.field_71439_g);
/* 296 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 299 */       float f7 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/* 300 */       f9 = MathHelper.func_76126_a(f7 * f7 * 3.1415927F);
/* 301 */       float f10 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * 3.1415927F);
/* 302 */       GL11.glRotatef(-f9 * 20.0F, 0.0F, 1.0F, 0.0F);
/* 303 */       GL11.glRotatef(-f10 * 20.0F, 0.0F, 0.0F, 1.0F);
/* 304 */       GL11.glRotatef(-f10 * 80.0F, 1.0F, 0.0F, 0.0F);
/*     */       
/* 306 */       float f11 = 0.38F;
/* 307 */       GL11.glScalef(f11, f11, f11);
/*     */       
/* 309 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 310 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/* 312 */       GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/*     */       
/* 314 */       float f12 = 0.015625F;
/* 315 */       GL11.glScalef(f12, f12, f12);
/*     */       
/* 317 */       this.field_78455_a.func_110434_K().func_110577_a(field_110931_c);
/* 318 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/* 320 */       GL11.glNormal3f(0.0F, 0.0F, -1.0F);
/* 321 */       tessellator.func_78382_b();
/* 322 */       byte b2 = 7;
/* 323 */       tessellator.func_78374_a((0 - b2), (128 + b2), 0.0D, 0.0D, 1.0D);
/* 324 */       tessellator.func_78374_a((128 + b2), (128 + b2), 0.0D, 1.0D, 1.0D);
/* 325 */       tessellator.func_78374_a((128 + b2), (0 - b2), 0.0D, 1.0D, 0.0D);
/* 326 */       tessellator.func_78374_a((0 - b2), (0 - b2), 0.0D, 0.0D, 0.0D);
/* 327 */       tessellator.func_78381_a();
/*     */       
/* 329 */       MapData mapData = Items.field_151098_aY.func_77873_a(itemStack, (World)this.field_78455_a.field_71441_e);
/* 330 */       if (mapData != null) this.field_78455_a.field_71460_t.func_147701_i().func_148250_a(mapData, false);
/*     */       
/* 332 */       GL11.glPopMatrix();
/* 333 */     } else if (itemStack != null) {
/* 334 */       GL11.glPushMatrix();
/* 335 */       float f5 = 0.8F;
/*     */       
/* 337 */       if (entityClientPlayerMP.func_71052_bv() > 0) {
/* 338 */         EnumAction enumAction = itemStack.func_77975_n();
/* 339 */         if (enumAction == EnumAction.eat || enumAction == EnumAction.drink) {
/* 340 */           float f10 = entityClientPlayerMP.func_71052_bv() - p_78440_1_ + 1.0F;
/*     */           
/* 342 */           float f11 = 1.0F - f10 / itemStack.func_77988_m();
/* 343 */           float f12 = 1.0F - f11;
/* 344 */           f12 = f12 * f12 * f12;
/* 345 */           f12 = f12 * f12 * f12;
/* 346 */           f12 = f12 * f12 * f12;
/* 347 */           float f13 = 1.0F - f12;
/* 348 */           GL11.glTranslatef(0.0F, MathHelper.func_76135_e(MathHelper.func_76134_b(f10 / 4.0F * 3.1415927F) * 0.1F) * ((f11 > 0.2D) ? true : false), 0.0F);
/* 349 */           GL11.glTranslatef(f13 * 0.6F, -f13 * 0.5F, 0.0F);
/* 350 */           GL11.glRotatef(f13 * 90.0F, 0.0F, 1.0F, 0.0F);
/* 351 */           GL11.glRotatef(f13 * 10.0F, 1.0F, 0.0F, 0.0F);
/* 352 */           GL11.glRotatef(f13 * 30.0F, 0.0F, 0.0F, 1.0F);
/*     */         } 
/*     */       } else {
/*     */         
/* 356 */         float f10 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/*     */         
/* 358 */         float f11 = MathHelper.func_76126_a(f10 * 3.1415927F);
/* 359 */         float f12 = MathHelper.func_76126_a(MathHelper.func_76129_c(f10) * 3.1415927F);
/* 360 */         GL11.glTranslatef(-f12 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f10) * 3.1415927F * 2.0F) * 0.2F, -f11 * 0.2F);
/*     */       } 
/*     */       
/* 363 */       GL11.glTranslatef(0.7F * f5, -0.65F * f5 - (1.0F - f1) * 0.6F, -0.9F * f5);
/*     */       
/* 365 */       GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 366 */       GL11.glEnable(32826);
/* 367 */       float f6 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/* 368 */       float f7 = MathHelper.func_76126_a(f6 * f6 * 3.1415927F);
/* 369 */       float f8 = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F);
/* 370 */       GL11.glRotatef(-f7 * 20.0F, 0.0F, 1.0F, 0.0F);
/* 371 */       GL11.glRotatef(-f8 * 20.0F, 0.0F, 0.0F, 1.0F);
/* 372 */       GL11.glRotatef(-f8 * 80.0F, 1.0F, 0.0F, 0.0F);
/* 373 */       float f9 = 0.4F;
/* 374 */       GL11.glScalef(f9, f9, f9);
/* 375 */       if (entityClientPlayerMP.func_71052_bv() > 0) {
/* 376 */         EnumAction enumAction = itemStack.func_77975_n();
/* 377 */         if (enumAction == EnumAction.block) {
/* 378 */           GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
/* 379 */           GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
/* 380 */           GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
/* 381 */           GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/* 383 */         else if (enumAction == EnumAction.bow) {
/*     */           
/* 385 */           GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
/* 386 */           GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
/* 387 */           GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
/* 388 */           GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
/* 389 */           float f10 = itemStack.func_77988_m() - entityClientPlayerMP.func_71052_bv() - p_78440_1_ + 1.0F;
/* 390 */           float f11 = f10 / 20.0F;
/* 391 */           f11 = (f11 * f11 + f11 * 2.0F) / 3.0F;
/* 392 */           if (f11 > 1.0F) f11 = 1.0F; 
/* 393 */           if (f11 > 0.1F) {
/* 394 */             GL11.glTranslatef(0.0F, MathHelper.func_76126_a((f10 - 0.1F) * 1.3F) * 0.01F * (f11 - 0.1F), 0.0F);
/*     */           }
/* 396 */           GL11.glTranslatef(0.0F, 0.0F, f11 * 0.1F);
/*     */           
/* 398 */           GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
/* 399 */           GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
/* 400 */           GL11.glTranslatef(0.0F, 0.5F, 0.0F);
/* 401 */           float f12 = 1.0F + f11 * 0.2F;
/* 402 */           GL11.glScalef(1.0F, 1.0F, f12);
/* 403 */           GL11.glTranslatef(0.0F, -0.5F, 0.0F);
/* 404 */           GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/* 405 */           GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
/*     */         } 
/*     */       } 
/*     */       
/* 409 */       if (itemStack.func_77973_b().func_77629_n_()) {
/* 410 */         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*     */       }
/* 412 */       if (itemStack.func_77973_b().func_77623_v()) {
/*     */ 
/*     */         
/* 415 */         func_78443_a((EntityLivingBase)entityClientPlayerMP, itemStack, 0);
/*     */         
/* 417 */         int m = itemStack.func_77973_b().func_82790_a(itemStack, 1);
/* 418 */         float f10 = (m >> 16 & 0xFF) / 255.0F;
/* 419 */         float f11 = (m >> 8 & 0xFF) / 255.0F;
/* 420 */         float f12 = (m & 0xFF) / 255.0F;
/*     */         
/* 422 */         GL11.glColor4f(1.0F * f10, 1.0F * f11, 1.0F * f12, 1.0F);
/*     */         
/* 424 */         func_78443_a((EntityLivingBase)entityClientPlayerMP, itemStack, 1);
/*     */       } else {
/* 426 */         func_78443_a((EntityLivingBase)entityClientPlayerMP, itemStack, 0);
/*     */       } 
/* 428 */       GL11.glPopMatrix();
/* 429 */     } else if (!entityClientPlayerMP.func_82150_aj()) {
/* 430 */       GL11.glPushMatrix();
/* 431 */       float f5 = 0.8F;
/*     */ 
/*     */       
/* 434 */       float f6 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/*     */       
/* 436 */       float f7 = MathHelper.func_76126_a(f6 * 3.1415927F);
/* 437 */       float f8 = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F);
/* 438 */       GL11.glTranslatef(-f8 * 0.3F, MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F * 2.0F) * 0.4F, -f7 * 0.4F);
/*     */ 
/*     */       
/* 441 */       GL11.glTranslatef(0.8F * f5, -0.75F * f5 - (1.0F - f1) * 0.6F, -0.9F * f5);
/*     */       
/* 443 */       GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 444 */       GL11.glEnable(32826);
/* 445 */       f6 = entityClientPlayerMP.func_70678_g(p_78440_1_);
/* 446 */       f7 = MathHelper.func_76126_a(f6 * f6 * 3.1415927F);
/* 447 */       f8 = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F);
/* 448 */       GL11.glRotatef(f8 * 70.0F, 0.0F, 1.0F, 0.0F);
/* 449 */       GL11.glRotatef(-f7 * 20.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */       
/* 452 */       this.field_78455_a.func_110434_K().func_110577_a(entityClientPlayerMP.func_110306_p());
/* 453 */       GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
/* 454 */       GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
/* 455 */       GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
/* 456 */       GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
/* 457 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 458 */       GL11.glTranslatef(5.6F, 0.0F, 0.0F);
/*     */       
/* 460 */       Render render = RenderManager.field_78727_a.func_78713_a((Entity)this.field_78455_a.field_71439_g);
/* 461 */       RenderPlayer renderPlayer = (RenderPlayer)render;
/* 462 */       float f9 = 1.0F;
/* 463 */       GL11.glScalef(f9, f9, f9);
/* 464 */       renderPlayer.func_82441_a((EntityPlayer)this.field_78455_a.field_71439_g);
/* 465 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/* 468 */     if (itemStack != null && itemStack.func_77973_b() instanceof net.minecraft.item.ItemCloth) {
/* 469 */       GL11.glDisable(3042);
/*     */     }
/*     */     
/* 472 */     GL11.glDisable(32826);
/* 473 */     RenderHelper.func_74518_a();
/*     */   }
/*     */   
/*     */   public void func_78447_b(float p_78447_1_) {
/* 477 */     GL11.glDisable(3008);
/* 478 */     if (this.field_78455_a.field_71439_g.func_70027_ad()) {
/* 479 */       func_78442_d(p_78447_1_);
/*     */     }
/*     */     
/* 482 */     if (this.field_78455_a.field_71439_g.func_70094_T()) {
/* 483 */       int i = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70165_t);
/* 484 */       int j = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70163_u);
/* 485 */       int k = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70161_v);
/*     */       
/* 487 */       Block block = this.field_78455_a.field_71441_e.func_147439_a(i, j, k);
/* 488 */       if (this.field_78455_a.field_71441_e.func_147439_a(i, j, k).func_149721_r()) {
/* 489 */         func_78446_a(p_78447_1_, block.func_149733_h(2));
/*     */       } else {
/* 491 */         for (byte b = 0; b < 8; b++) {
/* 492 */           float f1 = (((b >> 0) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
/* 493 */           float f2 = (((b >> 1) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70131_O * 0.2F;
/* 494 */           float f3 = (((b >> 2) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
/* 495 */           int m = MathHelper.func_76141_d(i + f1);
/* 496 */           int n = MathHelper.func_76141_d(j + f2);
/* 497 */           int i1 = MathHelper.func_76141_d(k + f3);
/* 498 */           if (this.field_78455_a.field_71441_e.func_147439_a(m, n, i1).func_149721_r()) {
/* 499 */             block = this.field_78455_a.field_71441_e.func_147439_a(m, n, i1);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 504 */       if (block.func_149688_o() != Material.field_151579_a) {
/* 505 */         func_78446_a(p_78447_1_, block.func_149733_h(2));
/*     */       }
/*     */     } 
/*     */     
/* 509 */     if (this.field_78455_a.field_71439_g.func_70055_a(Material.field_151586_h)) {
/* 510 */       func_78448_c(p_78447_1_);
/*     */     }
/* 512 */     GL11.glEnable(3008);
/*     */   }
/*     */   
/*     */   private void func_78446_a(float p_78446_1_, IIcon p_78446_2_) {
/* 516 */     this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
/*     */     
/* 518 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 520 */     float f1 = 0.1F;
/* 521 */     GL11.glColor4f(f1, f1, f1, 0.5F);
/*     */     
/* 523 */     GL11.glPushMatrix();
/*     */     
/* 525 */     float f2 = -1.0F;
/* 526 */     float f3 = 1.0F;
/* 527 */     float f4 = -1.0F;
/* 528 */     float f5 = 1.0F;
/* 529 */     float f6 = -0.5F;
/*     */     
/* 531 */     float f7 = p_78446_2_.func_94209_e();
/* 532 */     float f8 = p_78446_2_.func_94212_f();
/* 533 */     float f9 = p_78446_2_.func_94206_g();
/* 534 */     float f10 = p_78446_2_.func_94210_h();
/*     */     
/* 536 */     tessellator.func_78382_b();
/* 537 */     tessellator.func_78374_a(f2, f4, f6, f8, f10);
/* 538 */     tessellator.func_78374_a(f3, f4, f6, f7, f10);
/* 539 */     tessellator.func_78374_a(f3, f5, f6, f7, f9);
/* 540 */     tessellator.func_78374_a(f2, f5, f6, f8, f9);
/* 541 */     tessellator.func_78381_a();
/* 542 */     GL11.glPopMatrix();
/*     */     
/* 544 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private void func_78448_c(float p_78448_1_) {
/* 548 */     this.field_78455_a.func_110434_K().func_110577_a(field_110929_d);
/*     */     
/* 550 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 552 */     float f1 = this.field_78455_a.field_71439_g.func_70013_c(p_78448_1_);
/* 553 */     GL11.glColor4f(f1, f1, f1, 0.5F);
/* 554 */     GL11.glEnable(3042);
/* 555 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/* 557 */     GL11.glPushMatrix();
/*     */     
/* 559 */     float f2 = 4.0F;
/*     */     
/* 561 */     float f3 = -1.0F;
/* 562 */     float f4 = 1.0F;
/* 563 */     float f5 = -1.0F;
/* 564 */     float f6 = 1.0F;
/* 565 */     float f7 = -0.5F;
/*     */     
/* 567 */     float f8 = -this.field_78455_a.field_71439_g.field_70177_z / 64.0F;
/* 568 */     float f9 = this.field_78455_a.field_71439_g.field_70125_A / 64.0F;
/*     */     
/* 570 */     tessellator.func_78382_b();
/* 571 */     tessellator.func_78374_a(f3, f5, f7, (f2 + f8), (f2 + f9));
/* 572 */     tessellator.func_78374_a(f4, f5, f7, (0.0F + f8), (f2 + f9));
/* 573 */     tessellator.func_78374_a(f4, f6, f7, (0.0F + f8), (0.0F + f9));
/* 574 */     tessellator.func_78374_a(f3, f6, f7, (f2 + f8), (0.0F + f9));
/* 575 */     tessellator.func_78381_a();
/* 576 */     GL11.glPopMatrix();
/*     */     
/* 578 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 579 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   private void func_78442_d(float p_78442_1_) {
/* 583 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 584 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
/* 585 */     GL11.glEnable(3042);
/* 586 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*     */     
/* 588 */     float f = 1.0F;
/* 589 */     for (byte b = 0; b < 2; b++) {
/* 590 */       GL11.glPushMatrix();
/*     */       
/* 592 */       IIcon iIcon = Blocks.field_150480_ab.func_149840_c(1);
/* 593 */       this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
/*     */       
/* 595 */       float f1 = iIcon.func_94209_e();
/* 596 */       float f2 = iIcon.func_94212_f();
/* 597 */       float f3 = iIcon.func_94206_g();
/* 598 */       float f4 = iIcon.func_94210_h();
/*     */       
/* 600 */       float f5 = (0.0F - f) / 2.0F;
/* 601 */       float f6 = f5 + f;
/* 602 */       float f7 = 0.0F - f / 2.0F;
/* 603 */       float f8 = f7 + f;
/* 604 */       float f9 = -0.5F;
/* 605 */       GL11.glTranslatef(-(b * 2 - 1) * 0.24F, -0.3F, 0.0F);
/* 606 */       GL11.glRotatef((b * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 608 */       tessellator.func_78382_b();
/* 609 */       tessellator.func_78374_a(f5, f7, f9, f2, f4);
/* 610 */       tessellator.func_78374_a(f6, f7, f9, f1, f4);
/* 611 */       tessellator.func_78374_a(f6, f8, f9, f1, f3);
/* 612 */       tessellator.func_78374_a(f5, f8, f9, f2, f3);
/* 613 */       tessellator.func_78381_a();
/* 614 */       GL11.glPopMatrix();
/*     */     } 
/* 616 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 617 */     GL11.glDisable(3042);
/*     */   }
/*     */   public ItemRenderer(Minecraft p_i1247_1_) {
/* 620 */     this.field_78450_g = -1;
/*     */     this.field_78455_a = p_i1247_1_;
/*     */   } public void func_78441_a() {
/* 623 */     this.field_78451_d = this.field_78454_c;
/*     */     
/* 625 */     EntityClientPlayerMP entityClientPlayerMP = this.field_78455_a.field_71439_g;
/*     */     
/* 627 */     ItemStack itemStack = ((EntityPlayer)entityClientPlayerMP).field_71071_by.func_70448_g();
/*     */     
/* 629 */     boolean bool = (this.field_78450_g == ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c && itemStack == this.field_78453_b) ? true : false;
/* 630 */     if (this.field_78453_b == null && itemStack == null) {
/* 631 */       bool = true;
/*     */     }
/* 633 */     if (itemStack != null && this.field_78453_b != null && itemStack != this.field_78453_b && itemStack.func_77973_b() == this.field_78453_b.func_77973_b() && itemStack.func_77960_j() == this.field_78453_b.func_77960_j()) {
/* 634 */       this.field_78453_b = itemStack;
/* 635 */       bool = true;
/*     */     } 
/*     */     
/* 638 */     float f1 = 0.4F;
/* 639 */     float f2 = bool ? 1.0F : 0.0F;
/* 640 */     float f3 = f2 - this.field_78454_c;
/* 641 */     if (f3 < -f1) f3 = -f1; 
/* 642 */     if (f3 > f1) f3 = f1;
/*     */     
/* 644 */     this.field_78454_c += f3;
/* 645 */     if (this.field_78454_c < 0.1F) {
/* 646 */       this.field_78453_b = itemStack;
/* 647 */       this.field_78450_g = ((EntityPlayer)entityClientPlayerMP).field_71071_by.field_70461_c;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78444_b() {
/* 652 */     this.field_78454_c = 0.0F;
/*     */   }
/*     */   
/*     */   public void func_78445_c() {
/* 656 */     this.field_78454_c = 0.0F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\ItemRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */