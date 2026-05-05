/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiUtils
/*     */ {
/*     */   public static final String UNDO_CHAR = "↶";
/*     */   public static final String RESET_CHAR = "☄";
/*     */   public static final String VALID = "✔";
/*     */   public static final String INVALID = "✕";
/*  34 */   private static int[] colorCodes = new int[] { 0, 170, 43520, 43690, 11141120, 11141290, 16755200, 11184810, 5592405, 5592575, 5635925, 5636095, 16733525, 16733695, 16777045, 16777215, 0, 42, 10752, 10794, 2752512, 2752554, 2763264, 2763306, 1381653, 1381695, 1392405, 1392447, 4134165, 4134207, 4144917, 4144959 };
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getColorCode(char c, boolean isLighter) {
/*  39 */     return colorCodes[isLighter ? "0123456789abcdef".indexOf(c) : ("0123456789abcdef".indexOf(c) + 16)];
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
/*     */   public static void drawContinuousTexturedBox(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int borderSize, float zLevel) {
/*  60 */     drawContinuousTexturedBox(x, y, u, v, width, height, textureWidth, textureHeight, borderSize, borderSize, borderSize, borderSize, zLevel);
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
/*     */   public static void drawContinuousTexturedBox(ResourceLocation res, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int borderSize, float zLevel) {
/*  83 */     drawContinuousTexturedBox(res, x, y, u, v, width, height, textureWidth, textureHeight, borderSize, borderSize, borderSize, borderSize, zLevel);
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
/*     */   public static void drawContinuousTexturedBox(ResourceLocation res, int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int topBorder, int bottomBorder, int leftBorder, int rightBorder, float zLevel) {
/* 109 */     Minecraft.getMinecraft().getTextureManager().bindTexture(res);
/* 110 */     drawContinuousTexturedBox(x, y, u, v, width, height, textureWidth, textureHeight, topBorder, bottomBorder, leftBorder, rightBorder, zLevel);
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
/*     */   public static void drawContinuousTexturedBox(int x, int y, int u, int v, int width, int height, int textureWidth, int textureHeight, int topBorder, int bottomBorder, int leftBorder, int rightBorder, float zLevel) {
/* 135 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 136 */     GL11.glEnable(3042);
/* 137 */     OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 138 */     GL11.glBlendFunc(770, 771);
/*     */     
/* 140 */     int fillerWidth = textureWidth - leftBorder - rightBorder;
/* 141 */     int fillerHeight = textureHeight - topBorder - bottomBorder;
/* 142 */     int canvasWidth = width - leftBorder - rightBorder;
/* 143 */     int canvasHeight = height - topBorder - bottomBorder;
/* 144 */     int xPasses = canvasWidth / fillerWidth;
/* 145 */     int remainderWidth = canvasWidth % fillerWidth;
/* 146 */     int yPasses = canvasHeight / fillerHeight;
/* 147 */     int remainderHeight = canvasHeight % fillerHeight;
/*     */ 
/*     */ 
/*     */     
/* 151 */     drawTexturedModalRect(x, y, u, v, leftBorder, topBorder, zLevel);
/*     */     
/* 153 */     drawTexturedModalRect(x + leftBorder + canvasWidth, y, u + leftBorder + fillerWidth, v, rightBorder, topBorder, zLevel);
/*     */     
/* 155 */     drawTexturedModalRect(x, y + topBorder + canvasHeight, u, v + topBorder + fillerHeight, leftBorder, bottomBorder, zLevel);
/*     */     
/* 157 */     drawTexturedModalRect(x + leftBorder + canvasWidth, y + topBorder + canvasHeight, u + leftBorder + fillerWidth, v + topBorder + fillerHeight, rightBorder, bottomBorder, zLevel);
/*     */     
/* 159 */     for (int i = 0; i < xPasses + ((remainderWidth > 0) ? 1 : 0); ) {
/*     */ 
/*     */       
/* 162 */       drawTexturedModalRect(x + leftBorder + i * fillerWidth, y, u + leftBorder, v, (i == xPasses) ? remainderWidth : fillerWidth, topBorder, zLevel);
/*     */       
/* 164 */       drawTexturedModalRect(x + leftBorder + i * fillerWidth, y + topBorder + canvasHeight, u + leftBorder, v + topBorder + fillerHeight, (i == xPasses) ? remainderWidth : fillerWidth, bottomBorder, zLevel);
/*     */ 
/*     */       
/* 167 */       int k = 0; for (;; i++) { if (k < yPasses + ((remainderHeight > 0) ? 1 : 0)) {
/* 168 */           drawTexturedModalRect(x + leftBorder + i * fillerWidth, y + topBorder + k * fillerHeight, u + leftBorder, v + topBorder, (i == xPasses) ? remainderWidth : fillerWidth, (k == yPasses) ? remainderHeight : fillerHeight, zLevel); k++; continue;
/*     */         }  }
/*     */     
/*     */     } 
/* 172 */     for (int j = 0; j < yPasses + ((remainderHeight > 0) ? 1 : 0); j++) {
/*     */ 
/*     */       
/* 175 */       drawTexturedModalRect(x, y + topBorder + j * fillerHeight, u, v + topBorder, leftBorder, (j == yPasses) ? remainderHeight : fillerHeight, zLevel);
/*     */       
/* 177 */       drawTexturedModalRect(x + leftBorder + canvasWidth, y + topBorder + j * fillerHeight, u + leftBorder + fillerWidth, v + topBorder, rightBorder, (j == yPasses) ? remainderHeight : fillerHeight, zLevel);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawTexturedModalRect(int x, int y, int u, int v, int width, int height, float zLevel) {
/* 183 */     float var7 = 0.00390625F;
/* 184 */     float var8 = 0.00390625F;
/* 185 */     Tessellator tessellator = Tessellator.instance;
/* 186 */     tessellator.startDrawingQuads();
/* 187 */     tessellator.addVertexWithUV((x + 0), (y + height), zLevel, ((u + 0) * var7), ((v + height) * var8));
/* 188 */     tessellator.addVertexWithUV((x + width), (y + height), zLevel, ((u + width) * var7), ((v + height) * var8));
/* 189 */     tessellator.addVertexWithUV((x + width), (y + 0), zLevel, ((u + width) * var7), ((v + 0) * var8));
/* 190 */     tessellator.addVertexWithUV((x + 0), (y + 0), zLevel, ((u + 0) * var7), ((v + 0) * var8));
/* 191 */     tessellator.draw();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */