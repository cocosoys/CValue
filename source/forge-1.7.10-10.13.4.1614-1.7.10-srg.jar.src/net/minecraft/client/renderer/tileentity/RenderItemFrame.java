/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*     */ import net.minecraft.client.renderer.texture.TextureCompass;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityItemFrame;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderItemFrame extends Render {
/*  22 */   private static final ResourceLocation field_110789_a = new ResourceLocation("textures/map/map_background.png");
/*  23 */   private final RenderBlocks field_147916_f = new RenderBlocks();
/*  24 */   private final Minecraft field_147917_g = Minecraft.func_71410_x();
/*     */   private IIcon field_94147_f;
/*     */   private static final String __OBFID = "CL_00001002";
/*     */   
/*     */   public void func_94143_a(IIconRegister p_94143_1_) {
/*  29 */     this.field_94147_f = p_94143_1_.func_94245_a("itemframe_background");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityItemFrame p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  34 */     GL11.glPushMatrix();
/*  35 */     double d1 = p_76986_1_.field_70165_t - p_76986_2_ - 0.5D;
/*  36 */     double d2 = p_76986_1_.field_70163_u - p_76986_4_ - 0.5D;
/*  37 */     double d3 = p_76986_1_.field_70161_v - p_76986_6_ - 0.5D;
/*     */     
/*  39 */     int i = p_76986_1_.field_146063_b + Direction.field_71583_a[p_76986_1_.field_82332_a];
/*  40 */     int j = p_76986_1_.field_146064_c;
/*  41 */     int k = p_76986_1_.field_146062_d + Direction.field_71581_b[p_76986_1_.field_82332_a];
/*     */     
/*  43 */     GL11.glTranslated(i - d1, j - d2, k - d3);
/*     */     
/*  45 */     if (p_76986_1_.func_82335_i() != null && p_76986_1_.func_82335_i().func_77973_b() == Items.field_151098_aY) {
/*  46 */       func_147915_b(p_76986_1_);
/*     */     } else {
/*  48 */       func_82403_a(p_76986_1_);
/*     */     } 
/*     */     
/*  51 */     func_82402_b(p_76986_1_);
/*     */     
/*  53 */     GL11.glPopMatrix();
/*  54 */     func_147914_a(p_76986_1_, p_76986_2_ + (Direction.field_71583_a[p_76986_1_.field_82332_a] * 0.3F), p_76986_4_ - 0.25D, p_76986_6_ + (Direction.field_71581_b[p_76986_1_.field_82332_a] * 0.3F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityItemFrame p_110775_1_) {
/*  60 */     return null;
/*     */   }
/*     */   
/*     */   private void func_147915_b(EntityItemFrame p_147915_1_) {
/*  64 */     GL11.glPushMatrix();
/*  65 */     GL11.glRotatef(p_147915_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */     
/*  67 */     this.field_76990_c.field_78724_e.func_110577_a(TextureMap.field_110575_b);
/*  68 */     Block block = Blocks.field_150344_f;
/*  69 */     float f1 = 0.0625F;
/*  70 */     float f2 = 1.0F;
/*  71 */     float f3 = f2 / 2.0F;
/*     */ 
/*     */     
/*  74 */     GL11.glPushMatrix();
/*  75 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3 + 0.0625F), (0.5F - f3 + 0.0625F), f1, (0.5F + f3 - 0.0625F), (0.5F + f3 - 0.0625F));
/*  76 */     this.field_147916_f.func_147757_a(this.field_94147_f);
/*  77 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/*  78 */     this.field_147916_f.func_147771_a();
/*  79 */     this.field_147916_f.func_147762_c();
/*  80 */     GL11.glPopMatrix();
/*     */     
/*  82 */     this.field_147916_f.func_147757_a(Blocks.field_150344_f.func_149691_a(1, 2));
/*     */     
/*  84 */     GL11.glPushMatrix();
/*  85 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F - f3), (f1 + 1.0E-4F), (f1 + 0.5F - f3), (0.5F + f3));
/*  86 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/*  87 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/*  90 */     GL11.glPushMatrix();
/*  91 */     this.field_147916_f.func_147770_b(0.0D, (0.5F + f3 - f1), (0.5F - f3), (f1 + 1.0E-4F), (0.5F + f3), (0.5F + f3));
/*  92 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/*  93 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/*  96 */     GL11.glPushMatrix();
/*  97 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F - f3), f1, (0.5F + f3), (f1 + 0.5F - f3));
/*  98 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/*  99 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 102 */     GL11.glPushMatrix();
/* 103 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F + f3 - f1), f1, (0.5F + f3), (0.5F + f3));
/* 104 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 105 */     GL11.glPopMatrix();
/*     */     
/* 107 */     this.field_147916_f.func_147762_c();
/* 108 */     this.field_147916_f.func_147771_a();
/*     */     
/* 110 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_82403_a(EntityItemFrame p_82403_1_) {
/* 115 */     GL11.glPushMatrix();
/* 116 */     GL11.glRotatef(p_82403_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */     
/* 118 */     this.field_76990_c.field_78724_e.func_110577_a(TextureMap.field_110575_b);
/* 119 */     Block block = Blocks.field_150344_f;
/* 120 */     float f1 = 0.0625F;
/* 121 */     float f2 = 0.75F;
/* 122 */     float f3 = f2 / 2.0F;
/*     */ 
/*     */     
/* 125 */     GL11.glPushMatrix();
/* 126 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3 + 0.0625F), (0.5F - f3 + 0.0625F), (f1 * 0.5F), (0.5F + f3 - 0.0625F), (0.5F + f3 - 0.0625F));
/* 127 */     this.field_147916_f.func_147757_a(this.field_94147_f);
/* 128 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 129 */     this.field_147916_f.func_147771_a();
/* 130 */     this.field_147916_f.func_147762_c();
/* 131 */     GL11.glPopMatrix();
/*     */     
/* 133 */     this.field_147916_f.func_147757_a(Blocks.field_150344_f.func_149691_a(1, 2));
/*     */     
/* 135 */     GL11.glPushMatrix();
/* 136 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F - f3), (f1 + 1.0E-4F), (f1 + 0.5F - f3), (0.5F + f3));
/* 137 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 138 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 141 */     GL11.glPushMatrix();
/* 142 */     this.field_147916_f.func_147770_b(0.0D, (0.5F + f3 - f1), (0.5F - f3), (f1 + 1.0E-4F), (0.5F + f3), (0.5F + f3));
/* 143 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 144 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 147 */     GL11.glPushMatrix();
/* 148 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F - f3), f1, (0.5F + f3), (f1 + 0.5F - f3));
/* 149 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 150 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 153 */     GL11.glPushMatrix();
/* 154 */     this.field_147916_f.func_147770_b(0.0D, (0.5F - f3), (0.5F + f3 - f1), f1, (0.5F + f3), (0.5F + f3));
/* 155 */     this.field_147916_f.func_147800_a(block, 0, 1.0F);
/* 156 */     GL11.glPopMatrix();
/*     */     
/* 158 */     this.field_147916_f.func_147762_c();
/* 159 */     this.field_147916_f.func_147771_a();
/*     */     
/* 161 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void func_82402_b(EntityItemFrame p_82402_1_) {
/* 165 */     ItemStack itemStack = p_82402_1_.func_82335_i();
/* 166 */     if (itemStack == null)
/*     */       return; 
/* 168 */     EntityItem entityItem = new EntityItem(p_82402_1_.field_70170_p, 0.0D, 0.0D, 0.0D, itemStack);
/* 169 */     Item item = entityItem.func_92059_d().func_77973_b();
/* 170 */     (entityItem.func_92059_d()).field_77994_a = 1;
/* 171 */     entityItem.field_70290_d = 0.0F;
/*     */     
/* 173 */     GL11.glPushMatrix();
/*     */     
/* 175 */     GL11.glTranslatef(-0.453125F * Direction.field_71583_a[p_82402_1_.field_82332_a], -0.18F, -0.453125F * Direction.field_71581_b[p_82402_1_.field_82332_a]);
/* 176 */     GL11.glRotatef(180.0F + p_82402_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 177 */     GL11.glRotatef((-90 * p_82402_1_.func_82333_j()), 0.0F, 0.0F, 1.0F);
/*     */     
/* 179 */     switch (p_82402_1_.func_82333_j()) {
/*     */       case 1:
/* 181 */         GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
/*     */         break;
/*     */       case 2:
/* 184 */         GL11.glTranslatef(0.0F, -0.32F, 0.0F);
/*     */         break;
/*     */       case 3:
/* 187 */         GL11.glTranslatef(0.16F, -0.16F, 0.0F);
/*     */         break;
/*     */     } 
/*     */     
/* 191 */     if (item == Items.field_151098_aY) {
/* 192 */       this.field_76990_c.field_78724_e.func_110577_a(field_110789_a);
/* 193 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/* 195 */       GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 196 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 197 */       float f = 0.0078125F;
/* 198 */       GL11.glScalef(f, f, f);
/*     */ 
/*     */       
/* 201 */       switch (p_82402_1_.func_82333_j()) {
/*     */         case 0:
/* 203 */           GL11.glTranslatef(-64.0F, -87.0F, -1.5F);
/*     */           break;
/*     */         case 1:
/* 206 */           GL11.glTranslatef(-66.5F, -84.5F, -1.5F);
/*     */           break;
/*     */         case 2:
/* 209 */           GL11.glTranslatef(-64.0F, -82.0F, -1.5F);
/*     */           break;
/*     */         case 3:
/* 212 */           GL11.glTranslatef(-61.5F, -84.5F, -1.5F);
/*     */           break;
/*     */       } 
/* 215 */       GL11.glNormal3f(0.0F, 0.0F, -1.0F);
/*     */       
/* 217 */       MapData mapData = Items.field_151098_aY.func_77873_a(entityItem.func_92059_d(), p_82402_1_.field_70170_p);
/* 218 */       GL11.glTranslatef(0.0F, 0.0F, -1.0F);
/* 219 */       if (mapData != null) this.field_147917_g.field_71460_t.func_147701_i().func_148250_a(mapData, true);
/*     */     
/*     */     } else {
/* 222 */       if (item == Items.field_151111_aL) {
/* 223 */         TextureManager textureManager = Minecraft.func_71410_x().func_110434_K();
/* 224 */         textureManager.func_110577_a(TextureMap.field_110576_c);
/*     */         
/* 226 */         TextureAtlasSprite textureAtlasSprite = ((TextureMap)textureManager.func_110581_b(TextureMap.field_110576_c)).func_110572_b(Items.field_151111_aL.func_77650_f(entityItem.func_92059_d()).func_94215_i());
/*     */         
/* 228 */         if (textureAtlasSprite instanceof TextureCompass) {
/* 229 */           TextureCompass textureCompass = (TextureCompass)textureAtlasSprite;
/*     */           
/* 231 */           double d1 = textureCompass.field_94244_i;
/* 232 */           double d2 = textureCompass.field_94242_j;
/* 233 */           textureCompass.field_94244_i = 0.0D;
/* 234 */           textureCompass.field_94242_j = 0.0D;
/* 235 */           textureCompass.func_94241_a(p_82402_1_.field_70170_p, p_82402_1_.field_70165_t, p_82402_1_.field_70161_v, MathHelper.func_76142_g((180 + p_82402_1_.field_82332_a * 90)), false, true);
/* 236 */           textureCompass.field_94244_i = d1;
/* 237 */           textureCompass.field_94242_j = d2;
/*     */         } 
/*     */       } 
/*     */       
/* 241 */       RenderItem.field_82407_g = true;
/* 242 */       RenderManager.field_78727_a.func_147940_a((Entity)entityItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/* 243 */       RenderItem.field_82407_g = false;
/*     */ 
/*     */       
/* 246 */       if (item == Items.field_151111_aL) {
/* 247 */         TextureAtlasSprite textureAtlasSprite = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110576_c)).func_110572_b(Items.field_151111_aL.func_77650_f(entityItem.func_92059_d()).func_94215_i());
/* 248 */         if (textureAtlasSprite.func_110970_k() > 0) {
/* 249 */           textureAtlasSprite.func_94219_l();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   protected void func_147914_a(EntityItemFrame p_147914_1_, double p_147914_2_, double p_147914_4_, double p_147914_6_) {
/* 258 */     if (Minecraft.func_71382_s() && p_147914_1_.func_82335_i() != null && p_147914_1_.func_82335_i().func_82837_s() && this.field_76990_c.field_147941_i == p_147914_1_) {
/* 259 */       float f1 = 1.6F;
/* 260 */       float f2 = 0.016666668F * f1;
/* 261 */       double d = p_147914_1_.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/*     */       
/* 263 */       float f3 = p_147914_1_.func_70093_af() ? 32.0F : 64.0F;
/*     */       
/* 265 */       if (d < (f3 * f3)) {
/* 266 */         String str = p_147914_1_.func_82335_i().func_82833_r();
/*     */         
/* 268 */         if (p_147914_1_.func_70093_af()) {
/* 269 */           FontRenderer fontRenderer = func_76983_a();
/* 270 */           GL11.glPushMatrix();
/* 271 */           GL11.glTranslatef((float)p_147914_2_ + 0.0F, (float)p_147914_4_ + p_147914_1_.field_70131_O + 0.5F, (float)p_147914_6_);
/* 272 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*     */           
/* 274 */           GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 275 */           GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */           
/* 277 */           GL11.glScalef(-f2, -f2, f2);
/* 278 */           GL11.glDisable(2896);
/*     */           
/* 280 */           GL11.glTranslatef(0.0F, 0.25F / f2, 0.0F);
/* 281 */           GL11.glDepthMask(false);
/* 282 */           GL11.glEnable(3042);
/* 283 */           GL11.glBlendFunc(770, 771);
/* 284 */           Tessellator tessellator = Tessellator.field_78398_a;
/*     */           
/* 286 */           GL11.glDisable(3553);
/* 287 */           tessellator.func_78382_b();
/* 288 */           int i = fontRenderer.func_78256_a(str) / 2;
/* 289 */           tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 290 */           tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/* 291 */           tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/* 292 */           tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/* 293 */           tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/* 294 */           tessellator.func_78381_a();
/* 295 */           GL11.glEnable(3553);
/* 296 */           GL11.glDepthMask(true);
/* 297 */           fontRenderer.func_78276_b(str, -fontRenderer.func_78256_a(str) / 2, 0, 553648127);
/* 298 */           GL11.glEnable(2896);
/* 299 */           GL11.glDisable(3042);
/* 300 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 301 */           GL11.glPopMatrix();
/*     */         } else {
/* 303 */           func_147906_a((Entity)p_147914_1_, str, p_147914_2_, p_147914_4_, p_147914_6_, 64);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\RenderItemFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */