/*     */ package JinRyuu.JRMCore.client;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGRenderHelper
/*     */ {
/*  20 */   protected static RenderItem itemRender = new RenderItem();
/*     */ 
/*     */   
/*     */   public static void drawItem(Minecraft mc, float zLevel, FontRenderer fontRendererObj, ItemStack stack, int x, int y, float scale, int stackSize) {
/*  24 */     GL11.glPushMatrix();
/*  25 */     int k = 0;
/*  26 */     int l = 0;
/*  27 */     GL11.glDisable(32826);
/*  28 */     RenderHelper.func_74518_a();
/*  29 */     GL11.glDisable(2896);
/*  30 */     GL11.glDisable(2929);
/*  31 */     RenderHelper.func_74520_c();
/*  32 */     GL11.glPushMatrix();
/*  33 */     GL11.glTranslatef(k, l, 0.0F);
/*  34 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  35 */     GL11.glEnable(32826);
/*  36 */     short short1 = 240;
/*  37 */     short short2 = 240;
/*  38 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, short1 / 1.0F, short2 / 1.0F);
/*  39 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  41 */     GL11.glEnable(2896);
/*     */     
/*  43 */     String s = "";
/*     */ 
/*     */     
/*  46 */     if (stack.field_77994_a > 1) {
/*  47 */       s = "" + EnumChatFormatting.WHITE + stackSize;
/*     */     }
/*  49 */     drawItemStack(mc, zLevel, fontRendererObj, stack, x, y, s);
/*     */     
/*  51 */     GL11.glPopMatrix();
/*     */     
/*  53 */     GL11.glEnable(2896);
/*  54 */     GL11.glEnable(2929);
/*  55 */     RenderHelper.func_74518_a();
/*     */     
/*  57 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawItemStack(Minecraft mc, float zLevel, FontRenderer fontRendererObj, ItemStack stack, int x, int y, String s) {
/*  63 */     GL11.glPushMatrix();
/*  64 */     GL11.glTranslatef(0.0F, 0.0F, 32.0F);
/*  65 */     zLevel = 200.0F;
/*  66 */     itemRender.field_77023_b = 200.0F;
/*  67 */     FontRenderer font = null;
/*  68 */     if (stack != null) font = stack.func_77973_b().getFontRenderer(stack); 
/*  69 */     if (font == null) font = fontRendererObj; 
/*  70 */     itemRender.func_82406_b(font, mc.func_110434_K(), stack, x, y);
/*  71 */     itemRender.func_94148_a(font, mc.func_110434_K(), stack, x, y, s);
/*  72 */     zLevel = 0.0F;
/*  73 */     itemRender.field_77023_b = 0.0F;
/*  74 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  75 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void modelScalePositionHelper(float f) {
/*  82 */     GL11.glScalef(f, f, f);
/*  83 */     float ff1 = -2.45F;
/*  84 */     float ff2 = 0.6F;
/*  85 */     float diff = ff2 / f * ff1;
/*  86 */     GL11.glTranslatef(0.0F, (f - 1.0F) * diff, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor4f(int c, float a, float h1) {
/*  91 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/*  92 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/*  93 */     float h4 = (c & 0xFF) / 255.0F;
/*  94 */     GL11.glColor4f(h1 * h2 + 0.6F, h1 * h3 + 0.6F, h1 * h4 + 0.6F, a);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor4f(int c, float a) {
/*  99 */     float h2 = (c >> 16 & 0xFF) / 255.0F;
/* 100 */     float h3 = (c >> 8 & 0xFF) / 255.0F;
/* 101 */     float h4 = (c & 0xFF) / 255.0F;
/* 102 */     float h1 = 1.0F;
/* 103 */     GL11.glColor4f(h1 * h2, h1 * h3, h1 * h4, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cf(int x, int y, float a) {
/* 109 */     float h2 = (x >> 16 & 0xFF) / 255.0F;
/* 110 */     float h3 = (x >> 8 & 0xFF) / 255.0F;
/* 111 */     float h4 = (x & 0xFF) / 255.0F;
/* 112 */     float y2 = (y >> 16 & 0xFF) / 255.0F;
/* 113 */     float y3 = (y >> 8 & 0xFF) / 255.0F;
/* 114 */     float y4 = (y & 0xFF) / 255.0F;
/*     */     
/* 116 */     float pc = 0.5F;
/* 117 */     pc = (pc > 1.0F) ? 1.0F : pc;
/* 118 */     float pg = 1.0F - pc;
/* 119 */     float ga = h2 * pg + y2 * pc;
/* 120 */     float hr = h3 * pg + y3 * pc;
/* 121 */     float ah = h4 * pg + y4 * pc;
/*     */     
/* 123 */     h2 = ga;
/* 124 */     h3 = hr;
/* 125 */     h4 = ah;
/* 126 */     GL11.glColor4f(h2, h3, h4, a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void drawTexturedModalRect(float x, float y, int u, int v, float width, float height, float z) {
/* 133 */     float f = 0.00390625F;
/* 134 */     float f1 = 0.00390625F;
/* 135 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 136 */     tessellator.func_78382_b();
/* 137 */     tessellator.func_78374_a(x, (y + 0.0F), z, ((u + 0) * f), ((v + 0) * f1));
/* 138 */     tessellator.func_78374_a(x, (y + height), z, ((u + 0) * f), ((v + height) * f1));
/* 139 */     tessellator.func_78374_a((x + width), (y + height), z, ((u + width) * f), ((v + height) * f1));
/* 140 */     tessellator.func_78374_a((x + width), (y + 0.0F), z, ((u + width) * f), ((v + 0) * f1));
/* 141 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draw_tessellator2(Tessellator tessellator, int brightness, float particleWidth, float width2, float particleHeight, float height2, float red, float green, float blue, float alpha) {
/* 146 */     tessellator.func_78382_b();
/* 147 */     tessellator.func_78380_c(brightness);
/* 148 */     tessellator.func_78369_a(red, green, blue, alpha);
/* 149 */     tessellator.func_78374_a((-particleWidth - width2), (-particleHeight + height2), 0.0D, 0.0D, 0.0D);
/* 150 */     tessellator.func_78374_a((-particleWidth + width2), (particleHeight - height2), 0.0D, 0.0D, 1.0D);
/* 151 */     tessellator.func_78374_a((particleWidth + width2), (particleHeight - height2), 0.0D, 1.0D, 1.0D);
/* 152 */     tessellator.func_78374_a((particleWidth - width2), (-particleHeight + height2), 0.0D, 1.0D, 0.0D);
/* 153 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draw_tessellator(Tessellator tessellator, int brightness, float particleWidth, float width2, float particleHeight, float height2, float red, float green, float blue, float alpha) {
/* 158 */     tessellator.func_78382_b();
/* 159 */     tessellator.func_78380_c(brightness);
/* 160 */     tessellator.func_78369_a(red, green, blue, alpha);
/* 161 */     tessellator.func_78374_a((-particleWidth + width2), (-particleHeight + height2), 0.0D, 0.0D, 0.0D);
/* 162 */     tessellator.func_78374_a((-particleWidth + width2), (particleHeight + height2), 0.0D, 0.0D, 1.0D);
/* 163 */     tessellator.func_78374_a((particleWidth + width2), (particleHeight + height2), 0.0D, 1.0D, 1.0D);
/* 164 */     tessellator.func_78374_a((particleWidth + width2), (-particleHeight + height2), 0.0D, 1.0D, 0.0D);
/* 165 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draw_tessellator(Tessellator tessellator, int brightness, float particleWidth, float particleHeight, float red, float green, float blue, float alpha) {
/* 170 */     draw_tessellator(tessellator, brightness, particleWidth, 0.0F, particleHeight, 0.0F, red, green, blue, alpha);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void tex(RenderManager renderManager, int col) {
/* 177 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 178 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 179 */     float h4 = (col & 0xFF) / 255.0F;
/* 180 */     GL11.glColor4f(h2, h3, h4, 1.0F);
/*     */     
/* 182 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 183 */     renderManager.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void tex(RenderManager renderManager, int col, float v) {
/* 188 */     float h2 = (col >> 16 & 0xFF) / 255.0F;
/* 189 */     float h3 = (col >> 8 & 0xFF) / 255.0F;
/* 190 */     float h4 = (col & 0xFF) / 255.0F;
/*     */     
/* 192 */     GL11.glColor4f(h2, h3, h4, v);
/* 193 */     ResourceLocation txx = new ResourceLocation("jinryuumodscore:allw.png");
/* 194 */     renderManager.field_78724_e.func_110577_a(txx);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isClientPlayer(Entity entity) {
/* 200 */     return entity instanceof net.minecraft.client.entity.EntityPlayerSP;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\JGRenderHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */