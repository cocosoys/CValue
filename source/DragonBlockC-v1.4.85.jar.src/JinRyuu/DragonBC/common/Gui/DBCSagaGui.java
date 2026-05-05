/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL14;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBCSagaGui
/*     */   extends Gui
/*     */ {
/*  22 */   private Minecraft mc = JRMCoreClient.mc;
/*  23 */   private FontRenderer fontRenderer = this.mc.field_71466_p;
/*     */   
/*     */   public void renderDragonRadar() {
/*  26 */     ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/*  27 */     int var6 = var5.func_78326_a();
/*  28 */     int var7 = var5.func_78328_b();
/*  29 */     FontRenderer var8 = this.mc.field_71466_p;
/*  30 */     this.mc.field_71460_t.func_78478_c();
/*  31 */     GL11.glEnable(3042);
/*     */     
/*  33 */     GL11.glBlendFunc(770, 771);
/*     */     
/*  35 */     DragonSys(var6, var7);
/*     */ 
/*     */     
/*  38 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public void DragonSys(int var6, int var7) {
/*  42 */     DragonBack(var6, var7);
/*     */   }
/*     */   
/*     */   public void DragonBack(int var6, int var7) {
/*  46 */     int width = var6;
/*  47 */     int height = var7;
/*  48 */     int xSize = 146;
/*  49 */     int ySize = 166;
/*  50 */     int guiLeft = (width - xSize / 4) / 1;
/*  51 */     int guiTop = (height - ySize / 4) / 1;
/*  52 */     int guiLeft2 = (width + xSize / 4) / 1;
/*  53 */     int guiTop2 = (int)((height + ySize / 3.1F) / 1.0F);
/*     */ 
/*     */     
/*  56 */     String var4 = "jinryuudragonbc:radar.png";
/*  57 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  58 */     ResourceLocation tx = new ResourceLocation(var4);
/*  59 */     this.mc.field_71446_o.func_110577_a(tx);
/*     */     
/*  61 */     double heading = Math.toRadians(this.mc.field_71439_g.field_70177_z) + 1.5707963267948966D;
/*  62 */     int pitch = (int)this.mc.field_71439_g.field_70125_A + 60;
/*  63 */     if (pitch > 0) {
/*  64 */       func_73729_b(guiLeft - pitch, guiTop - pitch, 0, 0, xSize, ySize);
/*  65 */       this; drawArrow((guiLeft2 - pitch), (guiTop2 - pitch), heading, 10.0D, Color.GREEN.getRGB());
/*     */     } else {
/*  67 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*  68 */       this; drawArrow(guiLeft2, guiTop2, heading, 10.0D, Color.GREEN.getRGB());
/*     */     } 
/*     */   }
/*     */   public void DragonBackMask(int var6, int var7) {
/*  72 */     int width = var6;
/*  73 */     int height = var7;
/*  74 */     int xSize = 146;
/*  75 */     int ySize = 166;
/*  76 */     int guiLeft = (width - xSize / 4) / 1;
/*  77 */     int guiTop = (height - ySize / 4) / 1;
/*  78 */     int guiLeft2 = (width + xSize / 4) / 1;
/*  79 */     int guiTop2 = (int)((height + ySize / 4.1D) / 1.0D);
/*     */ 
/*     */     
/*  82 */     String var4 = "jinryuudragonbc:radarm.png";
/*  83 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  84 */     ResourceLocation tx = new ResourceLocation(var4);
/*  85 */     this.mc.field_71446_o.func_110577_a(tx);
/*     */     
/*  87 */     double heading = Math.toRadians(this.mc.field_71439_g.field_70177_z) + 1.5707963267948966D;
/*  88 */     int pitch = (int)this.mc.field_71439_g.field_70125_A + 60;
/*  89 */     if (pitch > 0) {
/*  90 */       func_73729_b(guiLeft - pitch, guiTop - pitch, 0, 0, xSize, ySize);
/*     */     } else {
/*  92 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void drawArrow(double x, double y, double angle, double length, int color) {
/*  97 */     double arrowBackAngle = 2.356194490192345D;
/*  98 */     double[] coords = new double[8];
/*     */     
/* 100 */     coords[0] = x + length * Math.cos(angle);
/* 101 */     coords[1] = y + length * Math.sin(angle);
/* 102 */     coords[2] = x + length * 0.5D * Math.cos(angle - arrowBackAngle);
/* 103 */     coords[3] = y + length * 0.5D * Math.sin(angle - arrowBackAngle);
/* 104 */     coords[4] = x;
/* 105 */     coords[5] = y;
/* 106 */     coords[6] = x + length * 0.5D * Math.cos(angle + arrowBackAngle);
/* 107 */     coords[7] = y + length * 0.5D * Math.sin(angle + arrowBackAngle);
/*     */     
/* 109 */     setColor(color);
/* 110 */     drawColoredQuad(coords);
/* 111 */     resetColor();
/*     */   }
/*     */   public static void setColor(int color) {
/* 114 */     float A = (color >> 24 & 0xFF) / 255.0F;
/* 115 */     float R = (color >> 16 & 0xFF) / 255.0F;
/* 116 */     float G = (color >> 8 & 0xFF) / 255.0F;
/* 117 */     float B = (color >> 0 & 0xFF) / 255.0F;
/* 118 */     GL11.glColor4f(R, G, B, A);
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
/*     */   public static void drawColoredQuad(double[] coords) {
/* 130 */     GL11.glEnable(3042);
/* 131 */     GL11.glDisable(3553);
/* 132 */     GL11.glBlendFunc(770, 771);
/* 133 */     Tessellator tes = Tessellator.field_78398_a;
/* 134 */     tes.func_78382_b();
/* 135 */     tes.func_78377_a(coords[0], coords[1], zDepth);
/* 136 */     tes.func_78377_a(coords[2], coords[3], zDepth);
/* 137 */     tes.func_78377_a(coords[4], coords[5], zDepth);
/* 138 */     tes.func_78377_a(coords[6], coords[7], zDepth);
/* 139 */     tes.func_78381_a();
/* 140 */     GL11.glEnable(3553);
/* 141 */     GL11.glDisable(3042);
/*     */   }
/* 143 */   private static double zDepth = 0.0D;
/*     */   public static void setZDepth(double z) {
/* 145 */     zDepth = z;
/*     */   }
/*     */   public static void resetColor() {
/* 148 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void DragonDetect(double x, double y, float f) {
/* 152 */     EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
/* 153 */     ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
/* 154 */     int width = scaledresolution.func_78326_a();
/* 155 */     int height = scaledresolution.func_78328_b();
/*     */     
/* 157 */     int xSize = 8;
/* 158 */     int ySize = 8;
/* 159 */     int guiLeft = (width + 32 + 1) / 1;
/* 160 */     int guiTop = (height + 36 + 14) / 1;
/*     */     
/* 162 */     String ic = "jinryuumodscore:icons.png";
/* 163 */     String ic2 = "jinryuudragonbc:icons3.png";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     GL11.glPushMatrix();
/* 169 */     GL11.glEnable(3042);
/*     */ 
/*     */ 
/*     */     
/* 173 */     GL14.glBlendFuncSeparate(0, 1, 771, 0);
/*     */ 
/*     */ 
/*     */     
/* 177 */     DBCClient.SagaSys.DragonBackMask(width, height);
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
/* 197 */     GL11.glBlendFunc(773, 772);
/*     */ 
/*     */     
/* 200 */     String var4 = "jinryuudragonbc:detect.png";
/* 201 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 202 */     ResourceLocation tx = new ResourceLocation(var4);
/* 203 */     this.mc.field_71446_o.func_110577_a(tx);
/* 204 */     func_73729_b((int)(guiLeft + x - f), (int)(guiTop + y - f), 0, 0, xSize, ySize);
/*     */     
/* 206 */     GL11.glDisable(3042);
/* 207 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCSagaGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */