/*     */ package net.minecraft.client.renderer.entity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class Render {
/*  23 */   private static final ResourceLocation field_110778_a = new ResourceLocation("textures/misc/shadow.png");
/*     */   
/*     */   protected RenderManager field_76990_c;
/*  26 */   protected RenderBlocks field_147909_c = new RenderBlocks();
/*     */   
/*     */   protected float field_76989_e;
/*  29 */   protected float field_76987_f = 1.0F;
/*     */   private boolean field_147908_f = false;
/*     */   private static final String __OBFID = "CL_00000992";
/*     */   
/*     */   public abstract void func_76986_a(Entity paramEntity, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2);
/*     */   
/*     */   protected abstract ResourceLocation func_110775_a(Entity paramEntity);
/*     */   
/*     */   public boolean func_147905_a() {
/*  38 */     return this.field_147908_f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110777_b(Entity p_110777_1_) {
/*  47 */     func_110776_a(func_110775_a(p_110777_1_));
/*     */   }
/*     */   
/*     */   protected void func_110776_a(ResourceLocation p_110776_1_) {
/*  51 */     this.field_76990_c.field_78724_e.func_110577_a(p_110776_1_);
/*     */   }
/*     */   
/*     */   private void func_76977_a(Entity p_76977_1_, double p_76977_2_, double p_76977_4_, double p_76977_6_, float p_76977_8_) {
/*  55 */     GL11.glDisable(2896);
/*     */     
/*  57 */     IIcon iIcon1 = Blocks.field_150480_ab.func_149840_c(0);
/*  58 */     IIcon iIcon2 = Blocks.field_150480_ab.func_149840_c(1);
/*     */     
/*  60 */     GL11.glPushMatrix();
/*  61 */     GL11.glTranslatef((float)p_76977_2_, (float)p_76977_4_, (float)p_76977_6_);
/*     */     
/*  63 */     float f1 = p_76977_1_.field_70130_N * 1.4F;
/*  64 */     GL11.glScalef(f1, f1, f1);
/*  65 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/*  67 */     float f2 = 0.5F;
/*  68 */     float f3 = 0.0F;
/*     */     
/*  70 */     float f4 = p_76977_1_.field_70131_O / f1;
/*  71 */     float f5 = (float)(p_76977_1_.field_70163_u - p_76977_1_.field_70121_D.field_72338_b);
/*     */     
/*  73 */     GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  74 */     GL11.glTranslatef(0.0F, 0.0F, -0.3F + (int)f4 * 0.02F);
/*  75 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  76 */     float f6 = 0.0F;
/*  77 */     byte b = 0;
/*  78 */     tessellator.func_78382_b();
/*  79 */     while (f4 > 0.0F) {
/*  80 */       IIcon iIcon = (b % 2 == 0) ? iIcon1 : iIcon2;
/*     */       
/*  82 */       func_110776_a(TextureMap.field_110575_b);
/*     */       
/*  84 */       float f7 = iIcon.func_94209_e();
/*  85 */       float f8 = iIcon.func_94206_g();
/*  86 */       float f9 = iIcon.func_94212_f();
/*  87 */       float f10 = iIcon.func_94210_h();
/*  88 */       if (b / 2 % 2 == 0) {
/*  89 */         float f = f9;
/*  90 */         f9 = f7;
/*  91 */         f7 = f;
/*     */       } 
/*  93 */       tessellator.func_78374_a((f2 - f3), (0.0F - f5), f6, f9, f10);
/*  94 */       tessellator.func_78374_a((-f2 - f3), (0.0F - f5), f6, f7, f10);
/*  95 */       tessellator.func_78374_a((-f2 - f3), (1.4F - f5), f6, f7, f8);
/*  96 */       tessellator.func_78374_a((f2 - f3), (1.4F - f5), f6, f9, f8);
/*  97 */       f4 -= 0.45F;
/*  98 */       f5 -= 0.45F;
/*  99 */       f2 *= 0.9F;
/* 100 */       f6 += 0.03F;
/* 101 */       b++;
/*     */     } 
/* 103 */     tessellator.func_78381_a();
/* 104 */     GL11.glPopMatrix();
/* 105 */     GL11.glEnable(2896);
/*     */   }
/*     */   
/*     */   private void func_76975_c(Entity p_76975_1_, double p_76975_2_, double p_76975_4_, double p_76975_6_, float p_76975_8_, float p_76975_9_) {
/* 109 */     GL11.glEnable(3042);
/* 110 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 112 */     this.field_76990_c.field_78724_e.func_110577_a(field_110778_a);
/*     */     
/* 114 */     World world = func_76982_b();
/*     */     
/* 116 */     GL11.glDepthMask(false);
/* 117 */     float f = this.field_76989_e;
/* 118 */     if (p_76975_1_ instanceof EntityLiving) {
/* 119 */       EntityLiving entityLiving = (EntityLiving)p_76975_1_;
/* 120 */       f *= entityLiving.func_70603_bj();
/*     */       
/* 122 */       if (entityLiving.func_70631_g_()) {
/* 123 */         f *= 0.5F;
/*     */       }
/*     */     } 
/*     */     
/* 127 */     double d1 = p_76975_1_.field_70142_S + (p_76975_1_.field_70165_t - p_76975_1_.field_70142_S) * p_76975_9_;
/* 128 */     double d2 = p_76975_1_.field_70137_T + (p_76975_1_.field_70163_u - p_76975_1_.field_70137_T) * p_76975_9_ + p_76975_1_.func_70053_R();
/* 129 */     double d3 = p_76975_1_.field_70136_U + (p_76975_1_.field_70161_v - p_76975_1_.field_70136_U) * p_76975_9_;
/*     */     
/* 131 */     int i = MathHelper.func_76128_c(d1 - f);
/* 132 */     int j = MathHelper.func_76128_c(d1 + f);
/* 133 */     int k = MathHelper.func_76128_c(d2 - f);
/* 134 */     int m = MathHelper.func_76128_c(d2);
/* 135 */     int n = MathHelper.func_76128_c(d3 - f);
/* 136 */     int i1 = MathHelper.func_76128_c(d3 + f);
/*     */     
/* 138 */     double d4 = p_76975_2_ - d1;
/* 139 */     double d5 = p_76975_4_ - d2;
/* 140 */     double d6 = p_76975_6_ - d3;
/*     */     
/* 142 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 143 */     tessellator.func_78382_b();
/* 144 */     for (int i2 = i; i2 <= j; i2++) {
/* 145 */       for (int i3 = k; i3 <= m; i3++) {
/* 146 */         for (int i4 = n; i4 <= i1; i4++) {
/* 147 */           Block block = world.func_147439_a(i2, i3 - 1, i4);
/* 148 */           if (block.func_149688_o() != Material.field_151579_a && world.func_72957_l(i2, i3, i4) > 3)
/* 149 */             func_147907_a(block, p_76975_2_, p_76975_4_ + p_76975_1_.func_70053_R(), p_76975_6_, i2, i3, i4, p_76975_8_, f, d4, d5 + p_76975_1_.func_70053_R(), d6); 
/*     */         } 
/*     */       } 
/* 152 */     }  tessellator.func_78381_a();
/*     */     
/* 154 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 155 */     GL11.glDisable(3042);
/* 156 */     GL11.glDepthMask(true);
/*     */   }
/*     */   
/*     */   private World func_76982_b() {
/* 160 */     return this.field_76990_c.field_78722_g;
/*     */   }
/*     */   
/*     */   private void func_147907_a(Block p_147907_1_, double p_147907_2_, double p_147907_4_, double p_147907_6_, int p_147907_8_, int p_147907_9_, int p_147907_10_, float p_147907_11_, float p_147907_12_, double p_147907_13_, double p_147907_15_, double p_147907_17_) {
/* 164 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 165 */     if (!p_147907_1_.func_149686_d())
/*     */       return; 
/* 167 */     double d1 = (p_147907_11_ - (p_147907_4_ - p_147907_9_ + p_147907_15_) / 2.0D) * 0.5D * func_76982_b().func_72801_o(p_147907_8_, p_147907_9_, p_147907_10_);
/* 168 */     if (d1 < 0.0D)
/* 169 */       return;  if (d1 > 1.0D) d1 = 1.0D; 
/* 170 */     tessellator.func_78369_a(1.0F, 1.0F, 1.0F, (float)d1);
/*     */     
/* 172 */     double d2 = p_147907_8_ + p_147907_1_.func_149704_x() + p_147907_13_;
/* 173 */     double d3 = p_147907_8_ + p_147907_1_.func_149753_y() + p_147907_13_;
/* 174 */     double d4 = p_147907_9_ + p_147907_1_.func_149665_z() + p_147907_15_ + 0.015625D;
/* 175 */     double d5 = p_147907_10_ + p_147907_1_.func_149706_B() + p_147907_17_;
/* 176 */     double d6 = p_147907_10_ + p_147907_1_.func_149693_C() + p_147907_17_;
/*     */     
/* 178 */     float f1 = (float)((p_147907_2_ - d2) / 2.0D / p_147907_12_ + 0.5D);
/* 179 */     float f2 = (float)((p_147907_2_ - d3) / 2.0D / p_147907_12_ + 0.5D);
/* 180 */     float f3 = (float)((p_147907_6_ - d5) / 2.0D / p_147907_12_ + 0.5D);
/* 181 */     float f4 = (float)((p_147907_6_ - d6) / 2.0D / p_147907_12_ + 0.5D);
/*     */     
/* 183 */     tessellator.func_78374_a(d2, d4, d5, f1, f3);
/* 184 */     tessellator.func_78374_a(d2, d4, d6, f1, f4);
/* 185 */     tessellator.func_78374_a(d3, d4, d6, f2, f4);
/* 186 */     tessellator.func_78374_a(d3, d4, d5, f2, f3);
/*     */   }
/*     */   
/*     */   public static void func_76978_a(AxisAlignedBB p_76978_0_, double p_76978_1_, double p_76978_3_, double p_76978_5_) {
/* 190 */     GL11.glDisable(3553);
/* 191 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 192 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 193 */     tessellator.func_78382_b();
/* 194 */     tessellator.func_78373_b(p_76978_1_, p_76978_3_, p_76978_5_);
/* 195 */     tessellator.func_78375_b(0.0F, 0.0F, -1.0F);
/* 196 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/* 197 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/* 198 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/* 199 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/*     */     
/* 201 */     tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
/* 202 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/* 203 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/* 204 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/* 205 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/*     */     
/* 207 */     tessellator.func_78375_b(0.0F, -1.0F, 0.0F);
/* 208 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/* 209 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/* 210 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/* 211 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/*     */     
/* 213 */     tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 214 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/* 215 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/* 216 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/* 217 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/*     */     
/* 219 */     tessellator.func_78375_b(-1.0F, 0.0F, 0.0F);
/* 220 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/* 221 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/* 222 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/* 223 */     tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/*     */     
/* 225 */     tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
/* 226 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
/* 227 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
/* 228 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
/* 229 */     tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
/* 230 */     tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 231 */     tessellator.func_78381_a();
/* 232 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public static void func_76980_a(AxisAlignedBB p_76980_0_) {
/* 236 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 237 */     tessellator.func_78382_b();
/* 238 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 239 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 240 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 241 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 242 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 243 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 244 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 245 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 246 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 247 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 248 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 249 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 250 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 251 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 252 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 253 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 254 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 255 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 256 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 257 */     tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 258 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
/* 259 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
/* 260 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
/* 261 */     tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
/* 262 */     tessellator.func_78381_a();
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
/*     */   public void func_76976_a(RenderManager p_76976_1_) {
/* 296 */     this.field_76990_c = p_76976_1_;
/*     */   }
/*     */   
/*     */   public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
/* 300 */     if (this.field_76990_c.field_78733_k.field_74347_j && this.field_76989_e > 0.0F && !p_76979_1_.func_82150_aj()) {
/* 301 */       double d = this.field_76990_c.func_78714_a(p_76979_1_.field_70165_t, p_76979_1_.field_70163_u, p_76979_1_.field_70161_v);
/* 302 */       float f = (float)((1.0D - d / 256.0D) * this.field_76987_f);
/* 303 */       if (f > 0.0F) {
/* 304 */         func_76975_c(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, f, p_76979_9_);
/*     */       }
/*     */     } 
/* 307 */     if (p_76979_1_.func_90999_ad()) func_76977_a(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_); 
/*     */   }
/*     */   
/*     */   public FontRenderer func_76983_a() {
/* 311 */     return this.field_76990_c.func_78716_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94143_a(IIconRegister p_94143_1_) {}
/*     */   
/*     */   protected void func_147906_a(Entity p_147906_1_, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
/* 318 */     double d = p_147906_1_.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/*     */     
/* 320 */     if (d > (p_147906_9_ * p_147906_9_)) {
/*     */       return;
/*     */     }
/*     */     
/* 324 */     FontRenderer fontRenderer = func_76983_a();
/*     */     
/* 326 */     float f1 = 1.6F;
/* 327 */     float f2 = 0.016666668F * f1;
/*     */     
/* 329 */     GL11.glPushMatrix();
/* 330 */     GL11.glTranslatef((float)p_147906_3_ + 0.0F, (float)p_147906_5_ + p_147906_1_.field_70131_O + 0.5F, (float)p_147906_7_);
/* 331 */     GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*     */     
/* 333 */     GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 334 */     GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */     
/* 336 */     GL11.glScalef(-f2, -f2, f2);
/* 337 */     GL11.glDisable(2896);
/*     */     
/* 339 */     GL11.glDepthMask(false);
/* 340 */     GL11.glDisable(2929);
/* 341 */     GL11.glEnable(3042);
/* 342 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 343 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 345 */     byte b = 0;
/* 346 */     if (p_147906_2_.equals("deadmau5")) b = -10;
/*     */     
/* 348 */     GL11.glDisable(3553);
/* 349 */     tessellator.func_78382_b();
/* 350 */     int i = fontRenderer.func_78256_a(p_147906_2_) / 2;
/* 351 */     tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 352 */     tessellator.func_78377_a((-i - 1), (-1 + b), 0.0D);
/* 353 */     tessellator.func_78377_a((-i - 1), (8 + b), 0.0D);
/* 354 */     tessellator.func_78377_a((i + 1), (8 + b), 0.0D);
/* 355 */     tessellator.func_78377_a((i + 1), (-1 + b), 0.0D);
/* 356 */     tessellator.func_78381_a();
/* 357 */     GL11.glEnable(3553);
/* 358 */     fontRenderer.func_78276_b(p_147906_2_, -fontRenderer.func_78256_a(p_147906_2_) / 2, b, 553648127);
/* 359 */     GL11.glEnable(2929);
/*     */     
/* 361 */     GL11.glDepthMask(true);
/* 362 */     fontRenderer.func_78276_b(p_147906_2_, -fontRenderer.func_78256_a(p_147906_2_) / 2, b, -1);
/* 363 */     GL11.glEnable(2896);
/* 364 */     GL11.glDisable(3042);
/* 365 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 366 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\Render.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */