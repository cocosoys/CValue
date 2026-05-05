/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBCKiGui
/*     */   extends Gui
/*     */ {
/*  27 */   private Minecraft mc = JRMCoreClient.mc;
/*  28 */   private FontRenderer fontRenderer = this.mc.field_71466_p;
/*     */ 
/*     */   
/*     */   private DBCClientTickHandler tick;
/*     */ 
/*     */   
/*     */   private GuiIngame Guiingame;
/*     */ 
/*     */   
/*  37 */   public int itemKi = 0; private float xSize_lo; private float ySize_lo; protected int guiLeft; protected int guiTop; protected int xSize; protected int ySize; public int width; public int height; private int kihelp1; private int kihelp2; private short kihelp3; private double kihelp4; public double ret; public void initGui() {} public void drawScreen(int par1, int par2, float par3) { this.xSize_lo = par1; this.ySize_lo = par2; }
/*     */   public void setWorldAndResolution(Minecraft par1Minecraft, int par2, int par3) { this.width = par2; this.height = par3; initGui1(); }
/*     */   public void initGui1() { this.guiLeft = (this.width - this.xSize) / 2; this.guiTop = (this.height - this.ySize) / 2; }
/*     */   public void renderTest() { ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d); int width = res.func_78326_a(); int height = res.func_78328_b(); FontRenderer fontRender = this.mc.field_71466_p; int x = 100; int y = 200; int color = 16777215; }
/*     */   public void renderKiBar(int ki) { ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d); int var6 = var5.func_78326_a(); int var7 = var5.func_78328_b(); FontRenderer var8 = this.mc.field_71466_p; int var18 = var6 / 2 - 91; int var23 = var7 - 52 + 3; ki = JRMCoreH.kiAmount; int maxki = JRMCoreH.kiMax; int maxkiplus = JRMCoreH.kiChargRa; double kimult = JRMCoreH.kiMultip; int var51 = mod_DragonBC.cwfb + 10; int var61 = mod_DragonBC.chfb + 10; short var21 = 182; double width = 182.0D; double max = kimult; if (max < 1.0D)
/*     */       max = 1.0D;  double maxperc = width / max; double var22 = maxperc * ki; if (var22 > width)
/*     */       var22 = width;  this.kihelp1 = var51; this.kihelp2 = var61; this.kihelp3 = var21; this.kihelp4 = var22; boolean var11 = false; int var12 = var11 ? 16777215 : 8453920; String var34 = "" + ki; int var38 = mod_DragonBC.cwfn + ((int)width + var8.func_78256_a(var34)) / 2; int var37 = mod_DragonBC.chfn + 2; var8.func_78276_b(var34, var38 + 1, var37, 0); var8.func_78276_b(var34, var38 - 1, var37, 0); var8.func_78276_b(var34, var38, var37 + 1, 0); var8.func_78276_b(var34, var38, var37 - 1, 0); var8.func_78276_b(var34, var38, var37, 8388564); ki = JRMCoreH.dbcHealthCur; maxki = JRMCoreH.dbcHealth; var51 = var6 - 13; var61 = var7 / 2 + 33;
/*     */     var21 = 41;
/*     */     int height = 41;
/*     */     max = maxki;
/*     */     if (max < 1.0D)
/*     */       max = 1.0D; 
/*     */     maxperc = height / max;
/*     */     var22 = maxperc * ki;
/*     */     if (var22 > height)
/*     */       var22 = height; 
/*     */     ResourceLocation tx2 = new ResourceLocation("jinryuudragonbc:icons.png");
/*     */     this.mc.field_71446_o.func_110577_a(tx2);
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     func_73729_b(var51, var61, 0, 80, 11, var21);
/*     */     if (var22 > 0.0D)
/*     */       func_73729_b(var51, var61, 11, 80, 11, (int)var22); 
/*     */     var11 = false;
/*     */     var12 = var11 ? 16777215 : 8453920;
/*     */     var34 = "" + ki;
/*     */     var38 = var51 + 12 - var34.length() * 6;
/*     */     var37 = var61 + 45;
/*     */     var8.func_78276_b(var34, var38 + 1, var37, 0);
/*     */     var8.func_78276_b(var34, var38 - 1, var37, 0);
/*     */     var8.func_78276_b(var34, var38, var37 + 1, 0);
/*     */     var8.func_78276_b(var34, var38, var37 - 1, 0);
/*     */     var8.func_78276_b(var34, var38, var37, 8388564);
/*     */     kiBarHelper(this.kihelp1, this.kihelp2, this.kihelp3, this.kihelp4); }
/*  70 */   public DBCKiGui(int i) { this.xSize = 176;
/*     */ 
/*     */     
/*  73 */     this.ySize = 166;
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
/* 484 */     this.ret = 0.0D; this.itemKi = i; }
/*     */   public void kiBarHelper(int var51, int var61, int var21, double var22) { ResourceLocation tx = new ResourceLocation("jinryuudragonbc:icons.png"); this.mc.field_71446_o.func_110577_a(tx); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); func_73729_b(var51, var61, 0, 64, var21, 5); if (var22 > 0.0D) func_73729_b(var51, var61, 0, 69, (int)var22, 5);  }
/* 486 */   public void renderKiChrgBar() { ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d); int var6 = var5.func_78326_a(); int var7 = var5.func_78328_b(); FontRenderer var8 = this.mc.field_71466_p; ResourceLocation tx = new ResourceLocation("jinryuudragonbc:icons.png"); this.mc.field_71446_o.func_110577_a(tx); int ki = JRMCoreH.KACharge; int maxki = JRMCoreH.kiMax; int maxkiplus = JRMCoreH.kiChargRa; int selc = JRMCoreH.KASelected; int chrg = 0; if (selc == 1) chrg = 40;  if (selc == 2) chrg = 2;  if (selc == 3) chrg = 40;  if (selc == 4) chrg = 40;  if (selc == 5) chrg = 2;  if (selc == 6) chrg = 40;  if (selc == 7) chrg = 120;  if (selc == 8) chrg = 2;  if (selc == 9) chrg = 50;  if (selc == 10) chrg = 40;  if (selc == 11) chrg = 120;  if (selc == 12) chrg = 70;  if (selc == 13) chrg = 40;  if (selc == 14) chrg = 200;  if (selc == 15) chrg = 200;  int var51 = var6 / 2 - 30; int var61 = var7 / 2 + 60; short var21 = 60; double width = 60.0D; int maxchrg = chrg; if (maxchrg < 1) maxchrg = 1;  double maxperc = width / maxchrg; double var22 = maxperc * ki; if (var22 > width) var22 = width;  func_73729_b(var51, var61, 0, 0, var21, 10); if (var22 > 0.0D) func_73729_b(var51, var61, 0, 10, (int)var22, 10);  } public String KAcost(int par1) { int explevel = JRMCoreH.kiAscPow;
/* 487 */     if (JRMCoreH.armTypSS1On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 488 */       explevel *= 2;
/*     */     }
/* 490 */     if (JRMCoreH.armTypSS2On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 491 */       explevel *= 3;
/*     */     }
/* 493 */     if (JRMCoreH.armTypSS3On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 494 */       explevel *= 4;
/*     */     }
/*     */ 
/*     */     
/* 498 */     int evil = JRMCoreH.align;
/* 499 */     double evl2 = (100 - evil) * 0.01D;
/* 500 */     double good2 = evil * 0.01D;
/* 501 */     double evl = evl2 + 0.2D;
/* 502 */     double good = good2 + 0.2D;
/* 503 */     double neu = 1.0D - ((good2 - evl2 < 0.0D) ? ((good2 - evl2) * -1.0D) : (good2 - evl2)) + 0.2D;
/* 504 */     int maxki = JRMCoreH.kiMax;
/* 505 */     int cost = 0;
/* 506 */     int selct = par1;
/* 507 */     if (selct == 1) { this.ret = neu * 20.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 508 */      if (selct == 2) { this.ret = (3 * explevel); cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 509 */      if (selct == 3) { this.ret = good * 15.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 510 */      if (selct == 4) { this.ret = evl * 8.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 511 */      if (selct == 5) { this.ret = neu * 5.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 512 */      if (selct == 6) { this.ret = (10 * explevel); cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 513 */      if (selct == 7) { this.ret = neu * 16.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 514 */      if (selct == 8) { this.ret = evl * 6.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 515 */      if (selct == 9) { this.ret = neu * 9.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 516 */      if (selct == 10) { this.ret = good * 8.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 517 */      if (selct == 11) { this.ret = good * 19.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 518 */      if (selct == 12) { this.ret = neu * 11.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 519 */      if (selct == 13) { this.ret = good * 9.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 520 */      if (selct == 14) { this.ret = evl * 100.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 521 */      if (selct == 15) { this.ret = good * 80.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)((maxki * explevel) * 0.9D) : (int)this.ret; }
/* 522 */      if (selct == 16) cost = JRMCoreH.kiKaioKen; 
/* 523 */     return StatCollector.func_74838_a("dbc.itemKiAtt.line1") + cost + " Ki"; }
/*     */   public void renderTP(int tp) { ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d); int var6 = var5.func_78326_a(); int var7 = var5.func_78328_b(); FontRenderer var8 = this.mc.field_71466_p; String ic = "jinryuudragonbc:icons.png"; int xSize = 130; int ySize = 44; int guiLeft = var6 - xSize + 131; int guiTop = (var7 - ySize) / 2; float pitch = DBCClient.mc.field_71439_g.field_70125_A + 0.0F; if (pitch > 0.0F) { guiLeft -= (int)(pitch * 1.4F); } else { guiLeft -= 0; }  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); ResourceLocation tx = new ResourceLocation(ic); this.mc.field_71446_o.func_110577_a(tx); int d = JRMCoreH.KASelected; if (d != 0) { func_73729_b(guiLeft, guiTop, 0, 20, xSize, ySize); name(KAName(d), 3, 3, var8, guiLeft, guiTop); name(KAcost(d), 3, 13, var8, guiLeft, guiTop); if (d != 16) { name(KAdesc(d), 3, 23, var8, guiLeft, guiTop); name(KAdesc2(d), 3, 33, var8, guiLeft, guiTop); }  int x = 16; int y = 16; int Left = var6 - x; int Top = (var7 - y) / 2; String i = "jinryuudragonbc:KA/KA" + d + ".png"; GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); ResourceLocation tx2 = new ResourceLocation(i); this.mc.field_71446_o.func_110577_a(tx2); func_73729_b(Left - 1, Top - 33, 0, 0, x, y); }  }
/*     */   public void name(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) { int posX = var6 + posx; int posY = var7 + posy; var8.func_78276_b(var35, posX + 1, posY, 0); var8.func_78276_b(var35, posX - 1, posY, 0); var8.func_78276_b(var35, posX, posY + 1, 0); var8.func_78276_b(var35, posX, posY - 1, 0); var8.func_78276_b(var35, posX, posY, 8388564); }
/* 526 */   public String KAName(int par1) { String ret = ""; int selct = par1; if (selct == 1) ret = StatCollector.func_74838_a("dbc.KABigBang.name");  if (selct == 2) ret = StatCollector.func_74838_a("dbc.KABlast.name");  if (selct == 3) ret = StatCollector.func_74838_a("dbc.KABurningAtt.name");  if (selct == 4) ret = StatCollector.func_74838_a("dbc.KADeathBeam.name");  if (selct == 5) ret = StatCollector.func_74838_a("dbc.KADodon.name");  if (selct == 6) ret = StatCollector.func_74838_a("dbc.KAEnergyDisk.name");  if (selct == 7) ret = StatCollector.func_74838_a("dbc.KAFinalFlash.name");  if (selct == 8) ret = StatCollector.func_74838_a("dbc.KAFingerLeser.name");  if (selct == 9) ret = StatCollector.func_74838_a("dbc.KAGalicGun.name");  if (selct == 10) ret = StatCollector.func_74838_a("dbc.KAHame.name");  if (selct == 11) ret = StatCollector.func_74838_a("dbc.KAHame10x.name");  if (selct == 12) ret = StatCollector.func_74838_a("dbc.KAMakanko.name");  if (selct == 13) ret = StatCollector.func_74838_a("dbc.KAMasenko.name");  if (selct == 14) ret = StatCollector.func_74838_a("dbc.KAPlanetDest.name");  if (selct == 15) ret = StatCollector.func_74838_a("dbc.KASpiritbomb.name");  if (selct == 16) ret = StatCollector.func_74838_a("dbc.KTKaioken.name");  return ret; } public String KAdesc(int par1) { int explevel = JRMCoreH.kiAscPow;
/* 527 */     if (JRMCoreH.armTypSS1On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 528 */       explevel *= 2;
/*     */     }
/* 530 */     if (JRMCoreH.armTypSS2On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 531 */       explevel *= 3;
/*     */     }
/* 533 */     if (JRMCoreH.armTypSS3On((EntityPlayer)DBCClient.mc.field_71439_g)) {
/* 534 */       explevel *= 4;
/*     */     }
/*     */     
/* 537 */     int evil = JRMCoreH.align;
/* 538 */     double evl2 = (100 - evil) * 0.01D;
/* 539 */     double good2 = evil * 0.01D;
/* 540 */     double evl = evl2 + 0.2D;
/* 541 */     double good = good2 + 0.2D;
/* 542 */     double neu = 1.0D - ((good2 - evl2 < 0.0D) ? ((good2 - evl2) * -1.0D) : (good2 - evl2)) + 0.2D;
/* 543 */     double ret = 0.0D;
/* 544 */     int cost = 0;
/* 545 */     int maxki = JRMCoreH.kiMax;
/* 546 */     int selct = par1;
/* 547 */     if (selct == 1) { ret = neu * 15.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 548 */      if (selct == 2) { ret = 2.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 549 */      if (selct == 3) { ret = good * 13.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 550 */      if (selct == 4) { ret = evl * 5.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 551 */      if (selct == 5) { ret = neu * 4.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 552 */      if (selct == 6) { ret = 8.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 553 */      if (selct == 7) { ret = neu * 9.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 554 */      if (selct == 8) { ret = evl * 5.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 555 */      if (selct == 9) { ret = neu * 6.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 556 */      if (selct == 10) { ret = good * 5.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 557 */      if (selct == 11) { ret = good * 10.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 558 */      if (selct == 12) { ret = neu * 7.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 559 */      if (selct == 13) { ret = good * 5.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 560 */      if (selct == 14) { ret = evl * 50.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 561 */      if (selct == 15) { ret = good * 50.0D * explevel; cost = ((int)this.ret > maxki * explevel) ? (int)(ret * (maxki * explevel) / this.ret) : (int)ret; }
/* 562 */      if (selct == 16) ret = JRMCoreH.kiKaioKen;
/*     */     
/* 564 */     return StatCollector.func_74838_a("dbc.itemKiAtt.line2") + cost + StatCollector.func_74838_a("dbc.itemKiAtt.line2.2"); }
/*     */   
/*     */   public String KAdesc2(int par1) {
/* 567 */     if (par1 == 2 || par1 == 5 || par1 == 6 || par1 == 8 || par1 == 16) {
/* 568 */       return StatCollector.func_74838_a("dbc.itemKiAtt.line4");
/*     */     }
/* 570 */     return StatCollector.func_74838_a("dbc.itemKiAtt.line3");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCKiGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */