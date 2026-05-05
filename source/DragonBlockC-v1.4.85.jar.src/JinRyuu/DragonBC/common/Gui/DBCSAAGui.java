/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DBCSAAGui
/*     */   extends GuiScreen
/*     */ {
/*     */   private DBCClientTickHandler tick;
/*     */   private GuiIngame Guiingame;
/*     */   
/*     */   public void renderSuperProtect(int ki) {
/*  43 */     this.field_146292_n.clear();
/*  44 */     int posX = this.field_146294_l / 2;
/*  45 */     int posY = this.field_146295_m / 2;
/*  46 */     this.field_146292_n.add(new DBCGuiButtons02(100, posX - 0, posY - 0, 20, 20, "TEST"));
/*     */   }
/*     */   
/*  49 */   public int saa = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  58 */     this.field_146292_n.clear();
/*     */     
/*  60 */     int posX = this.field_146294_l / 2;
/*  61 */     int posY = this.field_146295_m / 2;
/*     */ 
/*     */ 
/*     */     
/*  65 */     this.field_146292_n.add(new DBCGuiButtons02(-1, posX + 130, posY - 70, 70, 20, StatCollector.func_74838_a("dbc.saagui.abilities")));
/*  66 */     this.field_146292_n.add(new DBCGuiButtons02(-2, posX + 130, posY - 45, 70, 20, StatCollector.func_74838_a("dbc.saagui.sagasystem")));
/*     */     
/*  68 */     if (JRMCoreH.NC()) {
/*  69 */       this.field_146292_n.add(new DBCGuiButtons02(-1, posX - 200, posY - 70, 70, 20, "Dragon Block C"));
/*  70 */       this.field_146292_n.add(new DBCGuiButtons02(-3, posX - 200, posY - 45, 70, 20, "Naruto C"));
/*     */     } 
/*     */     
/*  73 */     if (this.saa == 1) {
/*  74 */       this.field_146292_n.add(new DBCGuiButtons02(0, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.saagui.body")));
/*  75 */       this.field_146292_n.add(new DBCGuiButtons02(1, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.saagui.trainingpoints")));
/*  76 */       this.field_146292_n.add(new DBCGuiButtons02(2, posX - 82, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.saagui.maxki")));
/*  77 */       this.field_146292_n.add(new DBCGuiButtons02(3, posX + 2, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.saagui.chargeki")));
/*  78 */       this.field_146292_n.add(new DBCGuiButtons02(4, posX - 82, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.saagui.dash")));
/*  79 */       this.field_146292_n.add(new DBCGuiButtons02(5, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.saagui.punch")));
/*  80 */       this.field_146292_n.add(new DBCGuiButtons02(6, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.saagui.jump")));
/*  81 */       this.field_146292_n.add(new DBCGuiButtons02(7, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.saagui.fly")));
/*  82 */       this.field_146292_n.add(new DBCGuiButtons02(8, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.saagui.ascending")));
/*  83 */       this.field_146292_n.add(new DBCGuiButtons02(9, posX + 2, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.saagui.attackpower")));
/*  84 */       this.field_146292_n.add(new DBCGuiButtons01(10, posX - 10, posY + 65, 20, 20, "X"));
/*  85 */       if (!JRMCoreH.HairExists((EntityPlayer)DBCClient.mc.field_71439_g))
/*  86 */         this.field_146292_n.add(new DBCGuiButtons01(200, posX + 55, posY + 65, 70, 20, StatCollector.func_74838_a("dbc.saagui.selecthair"))); 
/*     */     } 
/*  88 */     if (this.saa == 2) {
/*  89 */       posY -= 10;
/*  90 */       this.field_146292_n.add(actionPerformed(21, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KABigBang.name")));
/*  91 */       this.field_146292_n.add(actionPerformed(22, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KABlast.name")));
/*  92 */       this.field_146292_n.add(actionPerformed(23, posX - 82, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.KABurningAtt.name")));
/*  93 */       this.field_146292_n.add(actionPerformed(24, posX + 2, posY - 35, 83, 20, StatCollector.func_74838_a("dbc.KADeathBeam.name")));
/*  94 */       this.field_146292_n.add(actionPerformed(25, posX - 82, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KADodon.name")));
/*  95 */       this.field_146292_n.add(actionPerformed(26, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KAEnergyDisk.name")));
/*  96 */       this.field_146292_n.add(actionPerformed(27, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAFinalFlash.name")));
/*  97 */       this.field_146292_n.add(actionPerformed(28, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAFingerLeser.name")));
/*  98 */       this.field_146292_n.add(actionPerformed(29, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAGalicGun.name")));
/*  99 */       this.field_146292_n.add(actionPerformed(30, posX + 2, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAHame.name")));
/*     */       
/* 101 */       this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
/*     */       
/* 103 */       this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
/* 104 */       this.field_146292_n.add(new DBCGuiButtons01(101, posX + 85, posY + 65, 40, 20, StatCollector.func_74838_a("dbc.saagui.next")));
/*     */     } 
/* 106 */     if (this.saa == 3) {
/* 107 */       posY -= 10;
/*     */       
/* 109 */       this.field_146292_n.add(actionPerformed(31, posX + 2, posY - 10, 83, 20, StatCollector.func_74838_a("dbc.KAHame10x.name")));
/* 110 */       this.field_146292_n.add(actionPerformed(32, posX - 82, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAMakanko.name")));
/* 111 */       this.field_146292_n.add(actionPerformed(33, posX + 2, posY + 15, 83, 20, StatCollector.func_74838_a("dbc.KAMasenko.name")));
/* 112 */       this.field_146292_n.add(actionPerformed(34, posX - 82, posY + 40, 83, 20, StatCollector.func_74838_a("dbc.KAPlanetDest.name")));
/*     */ 
/*     */       
/* 115 */       this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
/*     */       
/* 117 */       this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
/* 118 */       this.field_146292_n.add(new DBCGuiButtons01(102, posX - 125, posY + 65, 40, 20, StatCollector.func_74838_a("dbc.saagui.back")));
/*     */     } 
/* 120 */     if (this.saa == 4) {
/* 121 */       posY -= 10;
/* 122 */       this.field_146292_n.add(actionPerformed(36, posX - 82, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KTKaioken.name")));
/* 123 */       this.field_146292_n.add(actionPerformed(35, posX + 2, posY - 60, 83, 20, StatCollector.func_74838_a("dbc.KASpiritbomb.name")));
/*     */       
/* 125 */       this.field_146292_n.add(new DBCGuiButtons01(100, posX - 80, posY + 65, 160, 20, StatCollector.func_74838_a("dbc.saagui.forgetattacks")));
/*     */       
/* 127 */       this.field_146292_n.add(new DBCGuiButtons01(10, posX + 100, posY - 80, 20, 20, "X"));
/*     */     } 
/* 129 */     if (this.saa == 5) {
/* 130 */       this.field_146292_n.add(new DBCGuiButtons00(200, posX - 83, posY - 83, 83, 83, ""));
/* 131 */       this.field_146292_n.add(new DBCGuiButtons00(201, posX + 0, posY - 83, 83, 83, ""));
/* 132 */       this.field_146292_n.add(new DBCGuiButtons00(202, posX - 83, posY + 0, 83, 83, ""));
/* 133 */       this.field_146292_n.add(new DBCGuiButtons00(203, posX + 0, posY + 0, 83, 83, ""));
/*     */       
/* 135 */       this.field_146292_n.add(new DBCGuiButtons06(210, posX + 85, posY - 75, 40, 15, StatCollector.func_74838_a("dbc.saagui.Black")));
/* 136 */       this.field_146292_n.add(new DBCGuiButtons06(211, posX + 85, posY - 60, 40, 15, StatCollector.func_74838_a("dbc.saagui.White")));
/* 137 */       this.field_146292_n.add(new DBCGuiButtons06(212, posX + 85, posY - 45, 40, 15, StatCollector.func_74838_a("dbc.saagui.Purple")));
/* 138 */       this.field_146292_n.add(new DBCGuiButtons06(213, posX + 85, posY - 30, 40, 15, StatCollector.func_74838_a("dbc.saagui.Red")));
/* 139 */       this.field_146292_n.add(new DBCGuiButtons06(214, posX + 85, posY - 15, 40, 15, StatCollector.func_74838_a("dbc.saagui.Brown")));
/* 140 */       this.field_146292_n.add(new DBCGuiButtons06(215, posX + 85, posY + 0, 40, 15, StatCollector.func_74838_a("dbc.saagui.Orange")));
/* 141 */       this.field_146292_n.add(new DBCGuiButtons06(216, posX + 85, posY + 15, 40, 15, StatCollector.func_74838_a("dbc.saagui.Green")));
/* 142 */       this.field_146292_n.add(new DBCGuiButtons06(217, posX + 85, posY + 30, 40, 15, StatCollector.func_74838_a("dbc.saagui.Cyan")));
/* 143 */       this.field_146292_n.add(new DBCGuiButtons06(218, posX + 85, posY + 45, 40, 15, StatCollector.func_74838_a("dbc.saagui.Blue")));
/*     */       
/* 145 */       this.field_146292_n.add(new DBCGuiButtons01(10, posX - 10, posY + 65, 20, 20, "X"));
/* 146 */       this.field_146292_n.add(new DBCGuiButtons01(220, posX + 83, posY + 65, 43, 20, StatCollector.func_74838_a("dbc.saagui.accept")));
/*     */     } 
/*     */   }
/*     */   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/*     */     GuiButton ret;
/* 151 */     int selct = par1 - 20;
/* 152 */     int KA = 0;
/* 153 */     if (selct == 1) KA = JRMCoreH.KABigBang; 
/* 154 */     if (selct == 2) KA = JRMCoreH.KABlast; 
/* 155 */     if (selct == 3) KA = JRMCoreH.KABurningAtt; 
/* 156 */     if (selct == 4) KA = JRMCoreH.KADeathBeam; 
/* 157 */     if (selct == 5) KA = JRMCoreH.KADodon; 
/* 158 */     if (selct == 6) KA = JRMCoreH.KAEnergyDisk; 
/* 159 */     if (selct == 7) KA = JRMCoreH.KAFinalFlash; 
/* 160 */     if (selct == 8) KA = JRMCoreH.KAFingerLaser; 
/* 161 */     if (selct == 9) KA = JRMCoreH.KAGalicGun; 
/* 162 */     if (selct == 10) KA = JRMCoreH.KAKameHame; 
/* 163 */     if (selct == 11) KA = JRMCoreH.KAKameHame10x; 
/* 164 */     if (selct == 12) KA = JRMCoreH.KAMakanko; 
/* 165 */     if (selct == 13) KA = JRMCoreH.KAMasenko; 
/* 166 */     if (selct == 14) KA = JRMCoreH.KAPlanetDest; 
/* 167 */     if (selct == 15) KA = JRMCoreH.KASpiritBomb; 
/* 168 */     if (selct == 16) KA = JRMCoreH.KTKaioken;
/*     */     
/* 170 */     if (KA == 1) {
/* 171 */       ret = new DBCGuiButtons02(par1, par2, par3, par4, par5, par6Str);
/*     */     } else {
/*     */       
/* 174 */       ret = new DBCGuiButtons01(par1, par2, par3, par4, par5, par6Str);
/*     */     } 
/* 176 */     return ret;
/*     */   }
/*     */   
/*     */   public void func_146284_a(GuiButton button) {
/* 180 */     if (button.field_146127_k == -1) {
/* 181 */       this.field_146297_k.field_71439_g.openGui(mod_DragonBC.instance, 6, this.field_146297_k.field_71439_g.field_70170_p, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
/*     */     }
/* 183 */     if (button.field_146127_k == -2) {
/* 184 */       this.field_146297_k.field_71439_g.openGui(mod_DragonBC.instance, 5, this.field_146297_k.field_71439_g.field_70170_p, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
/*     */     }
/* 186 */     if (button.field_146127_k == -3);
/*     */ 
/*     */     
/* 189 */     if (button.field_146127_k == 0) {
/* 190 */       dbcSAA(20, button.field_146127_k);
/* 191 */       player();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 203 */     if (button.field_146127_k == 10) {
/* 204 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */     }
/* 206 */     if (button.field_146127_k == 21 || button.field_146127_k == 22 || button.field_146127_k == 23 || button.field_146127_k == 24 || button.field_146127_k == 25 || button.field_146127_k == 26 || button.field_146127_k == 27 || button.field_146127_k == 28 || button.field_146127_k == 29 || button.field_146127_k == 30 || button.field_146127_k == 31 || button.field_146127_k == 32 || button.field_146127_k == 33 || button.field_146127_k == 34 || button.field_146127_k == 35 || button.field_146127_k == 36 || button.field_146127_k == 100) {
/*     */ 
/*     */ 
/*     */       
/* 210 */       dbcSAA(button.field_146127_k);
/* 211 */       this.field_146297_k.field_71439_g.func_71053_j();
/* 212 */       if (button.field_146127_k != 100) {
/* 213 */         this.field_146297_k.field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(StatCollector.func_74838_a("dbc.saagui.newskill")));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     if (button.field_146127_k == 220) {
/* 284 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */       
/* 286 */       dbcHair(JRMCoreH.Har + JRMCoreH.Col);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void player() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static void dbcSAA(int num, int saa) {
/* 298 */     mod_DragonBC.logger.info("dbcsaa channel is has not been set in DBCSAAGui " + num + " " + saa);
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
/*     */   public static void dbcSAA(int num) {
/* 317 */     int dbctick = num + 100;
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
/*     */   public static void dbcHair(String hair) {
/* 350 */     String dbchalo = hair;
/* 351 */     mod_DragonBC.logger.info("dbchalo channel is has not been set in DBCSAAGui " + dbchalo);
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
/*     */   public void func_73863_a(int x, int y, float f) {
/* 369 */     ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 370 */     int var6 = var5.func_78326_a();
/* 371 */     int var7 = var5.func_78328_b();
/* 372 */     FontRenderer var8 = this.field_146297_k.field_71466_p;
/*     */     
/* 374 */     String wish = "jinryuudragonbc:saa.png";
/* 375 */     String ww = "jinryuudragonbc:saa2.png";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 383 */     int xSize = 256;
/* 384 */     int ySize = 160;
/* 385 */     int guiLeft = (this.field_146294_l - xSize) / 2;
/* 386 */     int guiTop = (this.field_146295_m - ySize) / 2;
/*     */ 
/*     */     
/* 389 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 390 */     ResourceLocation tx = new ResourceLocation(wish);
/* 391 */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 392 */     func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */     
/* 394 */     if (this.saa == 5) {
/* 395 */       wish = "jinryuudragonbc:gui/hairs.png";
/* 396 */       int j = 0;
/* 397 */       if (JRMCoreH.Col == "_C0") j = 0; 
/* 398 */       if (JRMCoreH.Col == "_C1") j = 16777200; 
/* 399 */       if (JRMCoreH.Col == "_C2") j = 9265576; 
/* 400 */       if (JRMCoreH.Col == "_C3") j = 16766976; 
/* 401 */       if (JRMCoreH.Col == "_C4") j = 16724787; 
/* 402 */       if (JRMCoreH.Col == "_C5") j = 6045747; 
/* 403 */       if (JRMCoreH.Col == "_C6") j = 16744192; 
/* 404 */       if (JRMCoreH.Col == "_C7") j = 25600; 
/* 405 */       if (JRMCoreH.Col == "_C8") j = 5956839; 
/* 406 */       if (JRMCoreH.Col == "_C9") j = 5683455;
/*     */       
/* 408 */       float h2 = (j >> 16 & 0xFF) / 255.0F;
/* 409 */       float h3 = (j >> 8 & 0xFF) / 255.0F;
/* 410 */       float h4 = (j & 0xFF) / 255.0F;
/* 411 */       float h1 = 1.0F;
/* 412 */       GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4);
/* 413 */       ResourceLocation tx2 = new ResourceLocation(wish);
/* 414 */       this.field_146297_k.field_71446_o.func_110577_a(tx2);
/* 415 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 420 */     if (this.saa == 1) {
/*     */ 
/*     */       
/* 423 */       int ySize2 = ySize - 10;
/* 424 */       int guiLeft2 = (this.field_146294_l - xSize) / 2;
/* 425 */       int guiTop2 = (this.field_146295_m - ySize2) / 2;
/* 426 */       func_73729_b(guiLeft2, guiTop2, 0, 169, xSize, 5);
/*     */ 
/*     */       
/* 429 */       int max = xSize - 20;
/* 430 */       if (max < 1) {
/* 431 */         max = 1;
/*     */       }
/*     */       
/* 434 */       double maxperc = max * 0.01D;
/* 435 */       int var22 = (int)(maxperc * JRMCoreH.dbcEvilness);
/* 436 */       if (var22 > xSize) {
/* 437 */         var22 = xSize;
/*     */       }
/*     */       
/* 440 */       int xSize2 = 5;
/* 441 */       int ySize3 = ySize - 10;
/* 442 */       int guiLeft3 = (this.field_146294_l - xSize2) / 2 - max / 2 + var22;
/* 443 */       int guiTop3 = guiTop2 - 1;
/* 444 */       func_73729_b(guiLeft3, guiTop3, 0, 175, xSize2, 7);
/*     */       
/* 446 */       String s = "";
/* 447 */       if (JRMCoreH.dbcBP != null && 
/* 448 */         JRMCoreH.dbcBP.length > 0)
/* 449 */         for (String n : JRMCoreH.dbcBP) {
/* 450 */           String[] m = n.split(";");
/* 451 */           if (this.field_146297_k.field_71439_g.func_70005_c_().equals(m[0]))
/* 452 */             s = m[1]; 
/*     */         }  
/* 454 */       current("BP: " + s, 0, -71, var8, var6, var7);
/*     */ 
/*     */       
/* 457 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 458 */       ResourceLocation tx3 = new ResourceLocation(ww);
/* 459 */       this.field_146297_k.field_71446_o.func_110577_a(tx3);
/* 460 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */ 
/*     */       
/* 463 */       int tp = JRMCoreH.dbcTrainPoint;
/* 464 */       int ex = JRMCoreH.jrmcExp;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 469 */       boolean var11 = false;
/* 470 */       int var12 = var11 ? 16777215 : 8453920;
/* 471 */       String var34 = StatCollector.func_74838_a("dbc.saagui.curexp") + " " + ex;
/*     */       
/* 473 */       int var38 = 5;
/* 474 */       int var37 = 5;
/* 475 */       var8.func_78276_b(var34, var38 + 1, var37, 0);
/* 476 */       var8.func_78276_b(var34, var38 - 1, var37, 0);
/* 477 */       var8.func_78276_b(var34, var38, var37 + 1, 0);
/* 478 */       var8.func_78276_b(var34, var38, var37 - 1, 0);
/* 479 */       var8.func_78276_b(var34, var38, var37, 8388564);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 489 */       current("" + JRMCoreH.kiPunch, 105, -10, var8, var6, var7);
/* 490 */       current("" + JRMCoreH.kiDash, -105, -10, var8, var6, var7);
/* 491 */       current("" + JRMCoreH.kiMax, -105, -35, var8, var6, var7);
/* 492 */       current("" + JRMCoreH.kiChargRa, 105, -35, var8, var6, var7);
/* 493 */       current("" + JRMCoreH.kiJump, -105, 15, var8, var6, var7);
/* 494 */       current("" + JRMCoreH.kiFly, 105, 15, var8, var6, var7);
/* 495 */       current("" + JRMCoreH.kiAsclvl, -105, 40, var8, var6, var7);
/* 496 */       current("" + JRMCoreH.kiAscPow, 105, 40, var8, var6, var7);
/* 497 */       current("" + JRMCoreH.dbcTrainPoint, 105, -60, var8, var6, var7);
/* 498 */       current("" + JRMCoreH.dbcHealth, -105, -60, var8, var6, var7);
/*     */ 
/*     */       
/* 501 */       current2("" + JRMCoreH.kiPunch + "TP", 105, -10, var8, var6, var7);
/* 502 */       current2("" + JRMCoreH.kiDash + "TP", -105, -10, var8, var6, var7);
/* 503 */       current2("" + ((JRMCoreH.kiMax / 50 <= 0) ? 1 : (JRMCoreH.kiMax / 50)) + "TP", -105, -35, var8, var6, var7);
/* 504 */       current2("" + JRMCoreH.kiChargRa + "TP", 105, -35, var8, var6, var7);
/* 505 */       current2("" + JRMCoreH.kiJump + "TP", -105, 15, var8, var6, var7);
/* 506 */       current2("" + JRMCoreH.kiFly + "TP", 105, 15, var8, var6, var7);
/* 507 */       current2("" + (JRMCoreH.kiAsclvl * 20) + "TP", -105, 40, var8, var6, var7);
/* 508 */       current2("" + JRMCoreH.kiAscPow + "TP", 105, 40, var8, var6, var7);
/* 509 */       current2("5DBCxp", 106, -60, var8, var6, var7);
/* 510 */       current2("" + ((JRMCoreH.dbcHealth / 50 <= 0) ? 1 : (JRMCoreH.dbcHealth / 50)) + "TP", -105, -60, var8, var6, var7);
/*     */     } 
/*     */     
/* 513 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 518 */     return false;
/*     */   }
/*     */   
/*     */   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
/* 522 */     int wid = var8.func_78256_a(var35) / 2;
/* 523 */     int posX = var6 / 2 + posx - wid;
/* 524 */     int posY = var7 / 2 + posy + 8 - 6;
/* 525 */     var8.func_78276_b(var35, posX + 1, posY, 0);
/* 526 */     var8.func_78276_b(var35, posX - 1, posY, 0);
/* 527 */     var8.func_78276_b(var35, posX, posY + 1, 0);
/* 528 */     var8.func_78276_b(var35, posX, posY - 1, 0);
/* 529 */     var8.func_78276_b(var35, posX, posY, 8388564);
/*     */   }
/*     */   public void current2(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
/* 532 */     int wid = var8.func_78256_a(var35) / 2;
/* 533 */     int posX = var6 / 2 + posx - wid;
/* 534 */     int posY = var7 / 2 + posy + 8 + 10 - 6;
/* 535 */     var8.func_78276_b(var35, posX + 1, posY, 0);
/* 536 */     var8.func_78276_b(var35, posX - 1, posY, 0);
/* 537 */     var8.func_78276_b(var35, posX, posY + 1, 0);
/* 538 */     var8.func_78276_b(var35, posX, posY - 1, 0);
/* 539 */     var8.func_78276_b(var35, posX, posY, 8388564);
/*     */   }
/*     */ 
/*     */   
/* 543 */   public static int count = 0;
/* 544 */   public static int warn = 0; private String Process; private int wid;
/* 545 */   public static int startcount = 0; private int hei; private String textureFile;
/*     */   
/*     */   public void SagasPage(int var6, int var7) {
/* 548 */     this.textureFile = "jinryuudragonbc:sagas.png";
/* 549 */     ScouterRenderBlur(var6, var7);
/*     */   }
/*     */   
/* 552 */   public DBCSAAGui(int w) { this.Process = "Something is Wrong";
/* 553 */     this.wid = 0;
/* 554 */     this.hei = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 595 */     this.textureFile = "jinryuudragonbc:sagas.png";
/*     */     this.saa = w; }
/*     */   
/*     */   public void ScouterRenderBlur(int par1, int par2) {
/* 599 */     GL11.glDisable(2929);
/* 600 */     GL11.glDepthMask(false);
/* 601 */     GL11.glBlendFunc(770, 771);
/* 602 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 603 */     GL11.glDisable(3008);
/* 604 */     ResourceLocation tx = new ResourceLocation(this.textureFile);
/* 605 */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 606 */     Tessellator var3 = Tessellator.field_78398_a;
/* 607 */     var3.func_78382_b();
/* 608 */     var3.func_78374_a(0.0D, par2, -90.0D, 0.0D, 1.0D);
/* 609 */     var3.func_78374_a(par1, par2, -90.0D, 1.0D, 1.0D);
/* 610 */     var3.func_78374_a(par1, 0.0D, -90.0D, 1.0D, 0.0D);
/* 611 */     var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
/* 612 */     var3.func_78381_a();
/* 613 */     GL11.glDepthMask(true);
/* 614 */     GL11.glEnable(2929);
/* 615 */     GL11.glEnable(3008);
/* 616 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void SagasPrint() {
/*     */     func_73866_w_();
/*     */     Minecraft minecraft = this.field_146297_k;
/*     */     WorldClient worldClient = minecraft.field_71441_e;
/*     */     EntityClientPlayerMP entityClientPlayerMP = minecraft.field_71439_g;
/*     */     ScaledResolution scaledresolution = new ScaledResolution(minecraft, minecraft.field_71443_c, minecraft.field_71440_d);
/*     */     int width = scaledresolution.func_78326_a() / 2;
/*     */     int height = scaledresolution.func_78328_b() / 2;
/*     */     int widthplus = 8;
/*     */     GL11.glEnable(3042);
/*     */     GL11.glEnable(32826);
/*     */     RenderHelper.func_74519_b();
/*     */     RenderHelper.func_74518_a();
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     func_73732_a(this.field_146289_q, this.Process, width + this.wid, height + this.hei, 16768306);
/*     */     GL11.glDisable(32826);
/*     */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public void SagasBack(int var6, int var7) {
/*     */     int width = var6;
/*     */     int height = var7;
/*     */     int xSize = 182;
/*     */     int ySize = 191;
/*     */     int guiLeft = (width - xSize) / 2;
/*     */     int guiTop = (height - ySize) / 2;
/*     */     String var4 = "jinryuudragonbc:sagas.png";
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     ResourceLocation tx = new ResourceLocation(var4);
/*     */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/*     */     func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCSAAGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */