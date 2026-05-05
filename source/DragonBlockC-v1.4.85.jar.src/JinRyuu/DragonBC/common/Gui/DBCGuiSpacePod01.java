/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClient;
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class DBCGuiSpacePod01 extends GuiScreen {
/*  24 */   public World world = (World)DBCClient.mc.field_71441_e;
/*  25 */   public EntityPlayer player = (EntityPlayer)DBCClient.mc.field_71439_g;
/*  26 */   public Minecraft field_146297_k = DBCClient.mc;
/*  27 */   public int planet20 = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   int px;
/*     */ 
/*     */ 
/*     */   
/*     */   int py;
/*     */ 
/*     */   
/*     */   int pz;
/*     */ 
/*     */   
/*  41 */   public static String guired = "jinryuudragonbc:guibutton05.png";
/*  42 */   public static String guigreen = "jinryuudragonbc:guibutton06.png";
/*  43 */   public static String buttontex = "";
/*     */   
/*     */   public void func_73866_w_() {
/*  46 */     this.field_146292_n.clear();
/*     */   }
/*     */   
/*  49 */   public static int spon = 0;
/*  50 */   public static int spoff = 0;
/*  51 */   public static int spstart = 0;
/*  52 */   public static int sp3 = 0;
/*  53 */   public static int sp2 = 0;
/*  54 */   public static int sp1 = 0;
/*     */   
/*  56 */   public static int ToNamek = 0;
/*  57 */   public static int ToVegeta = 0;
/*  58 */   public static int ToEarth = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int xSizeOfTexture = 400;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int ySizeOfTexture = 300;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed2(GuiButton button) {
/*  72 */     EntityClientPlayerMP entityClientPlayerMP = this.field_146297_k.field_71439_g;
/*  73 */     WorldClient worldClient = this.field_146297_k.field_71441_e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     if (button.field_146127_k == 0)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  85 */       if (spon == 0) {
/*  86 */         this; spon = 1;
/*     */       } else {
/*  88 */         spResetCounters();
/*     */       }  } 
/*  90 */     if (button.field_146127_k == 1) {
/*  91 */       spResetCounters();
/*  92 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */     } 
/*     */     
/*  95 */     if (button.field_146127_k == 2) {
/*     */       
/*  97 */       this; if (sp3 == 0) { this; if (sp2 == 0) { this; if (sp1 == 0)
/*  98 */           { this.field_146297_k.field_71439_g.func_71053_j();
/*  99 */             spResetCounters(); }  }
/*     */          }
/* 101 */        this; if (sp3 == 1) { this; if (sp2 == 0) { this; if (sp1 == 0)
/* 102 */           { this.field_146297_k.field_71439_g.func_71053_j();
/*     */             
/* 104 */             this; ToEarth = 1;
/* 105 */             this; ToNamek = 0;
/* 106 */             this; ToVegeta = 0;
/* 107 */             spResetCounters(); }  }
/*     */          }
/* 109 */        this; if (sp3 == 0) { this; if (sp2 == 1) { this; if (sp1 == 0)
/* 110 */           { this.field_146297_k.field_71439_g.func_71053_j();
/*     */ 
/*     */             
/* 113 */             this; ToEarth = 0;
/* 114 */             this; ToNamek = 0;
/* 115 */             this; ToVegeta = 1;
/* 116 */             spResetCounters(); }  }
/*     */          }
/* 118 */        this; if (sp3 == 0) { this; if (sp2 == 0) { this; if (sp1 == 1) {
/*     */             
/* 120 */             this.field_146297_k.field_71439_g.func_71053_j();
/*     */             
/* 122 */             this; ToEarth = 0;
/* 123 */             this; ToNamek = 1;
/* 124 */             this; ToVegeta = 0;
/* 125 */             spResetCounters();
/*     */           }  }
/*     */          }
/*     */       
/* 129 */       this; if (ToEarth == 1) {
/* 130 */         this; ToEarth = 0;
/* 131 */         this; ToNamek = 0;
/* 132 */         this; ToVegeta = 0;
/* 133 */         int dbcspacepod1 = 3;
/* 134 */         PD.sendToServer((IMessage)new DBCPspacepod1((byte)dbcspacepod1));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       this; if (ToVegeta == 1) {
/* 152 */         this; ToEarth = 0;
/* 153 */         this; ToNamek = 0;
/* 154 */         this; ToVegeta = 0;
/* 155 */         int dbcspacepod1 = 2;
/* 156 */         PD.sendToServer((IMessage)new DBCPspacepod1((byte)dbcspacepod1));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 173 */       this; if (ToNamek == 1) {
/* 174 */         this; ToEarth = 0;
/* 175 */         this; ToNamek = 0;
/* 176 */         this; ToVegeta = 0;
/* 177 */         int dbcspacepod1 = 1;
/* 178 */         PD.sendToServer((IMessage)new DBCPspacepod1((byte)dbcspacepod1));
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
/* 199 */     if (button.field_146127_k == 3) {
/* 200 */       this; sp3 = 1;
/* 201 */       this; sp2 = 0;
/* 202 */       this; sp1 = 0;
/*     */     } 
/* 204 */     if (button.field_146127_k == 4) {
/* 205 */       this; sp3 = 0;
/* 206 */       this; sp2 = 1;
/* 207 */       this; sp1 = 0;
/*     */     } 
/* 209 */     if (button.field_146127_k == 5) {
/* 210 */       this; sp3 = 0;
/* 211 */       this; sp2 = 0;
/* 212 */       this; sp1 = 1;
/*     */     } 
/* 214 */     if (button.field_146127_k == 6) {
/* 215 */       this; sp3 = 0;
/* 216 */       this; sp2 = 0;
/* 217 */       this; sp1 = 0;
/* 218 */       this; ToEarth = 0;
/* 219 */       this; ToNamek = 0;
/* 220 */       this; ToVegeta = 0;
/*     */     } 
/*     */   }
/*     */   public void spResetCounters() {
/* 224 */     this; spon = 0;
/* 225 */     this; spoff = 0;
/* 226 */     this; spstart = 0;
/* 227 */     this; sp3 = 0;
/* 228 */     this; sp2 = 0;
/* 229 */     this; sp1 = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DBCGuiSpacePod01(int x, int y, int z) {
/* 280 */     this.xSizeOfTexture = 400;
/* 281 */     this.ySizeOfTexture = 300;
/*     */     this.px = x;
/*     */     this.py = y;
/*     */     this.pz = z; } public void func_146284_a(GuiButton button) {
/* 285 */     if (button.field_146127_k == 1) {
/* 286 */       if (sc == -1) {
/* 287 */         loadtime = 10;
/* 288 */         sc = 0;
/*     */       } else {
/* 290 */         sc = -1;
/* 291 */         this.field_146297_k.field_71439_g.func_71053_j();
/*     */       }
/*     */     
/* 294 */     } else if (button.field_146127_k == 0) {
/* 295 */       if (sc == 2) {
/* 296 */         ss++;
/* 297 */         if (ss > ssl) ss = 0;
/*     */       
/*     */       } 
/* 300 */     } else if (button.field_146127_k == 2) {
/* 301 */       if (sc == 1) {
/* 302 */         sc = 2;
/*     */       }
/* 304 */       else if (sc == 2) {
/* 305 */         switch (ss) {
/*     */           case 0:
/* 307 */             sc = 1; break;
/*     */           case 1:
/* 309 */             PD.sendToServer((IMessage)new DBCPspacepod1(ssD));
/* 310 */             sc = 1;
/*     */             break;
/*     */           case 2:
/* 313 */             PD.sendToServer((IMessage)new DBCPspacepod1(ssD));
/* 314 */             sc = 1;
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 320 */       ss = 0;
/*     */     } 
/*     */   }
/*     */   
/* 324 */   public static int loadtime = 10;
/*     */   
/* 326 */   public static int sc = -1;
/*     */   
/* 328 */   public static int ss = 0;
/*     */   
/* 330 */   public static int ssl = 0;
/*     */   
/* 332 */   public static int ssD = 0;
/*     */   
/*     */   public static final int screen_OFF = -1;
/*     */   
/*     */   public static final int screen_Loading = 0;
/*     */   public static final int screen_MainMenu = 1;
/*     */   public static final int screen_Destinations = 2;
/*     */   public static final int screen_Travelling = 3;
/*     */   public static final int screen_Arrived = 4;
/*     */   public static final int panel_left_mode = 0;
/*     */   public static final int panel_mid_on = 1;
/*     */   public static final int panel_right_ok = 2;
/* 344 */   public static final ResourceLocation Panel = new ResourceLocation("jinryuudragonbc:sppanel.png");
/*     */   
/* 346 */   public static final int[] dests = new int[] { DBCConfig.planetEarth, DBCConfig.planetNamek, DBCConfig.planetVegeta };
/* 347 */   public static final int[] destsTP = new int[] { 3, 1, 2 };
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float f) {
/* 351 */     this.field_146292_n.clear();
/*     */     
/* 353 */     ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 354 */     int var6 = var5.func_78326_a();
/* 355 */     int var7 = var5.func_78328_b();
/* 356 */     FontRenderer var8 = this.field_146289_q;
/*     */     
/* 358 */     String spacepod = "jinryuudragonbc:spacepodGUI01.png";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 374 */     ResourceLocation tx = new ResourceLocation(spacepod);
/* 375 */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 376 */     Tessellator var3 = Tessellator.field_78398_a;
/* 377 */     var3.func_78382_b();
/* 378 */     var3.func_78374_a(0.0D, var7, -90.0D, 0.0D, 1.0D);
/* 379 */     var3.func_78374_a(var6, var7, -90.0D, 1.0D, 1.0D);
/* 380 */     var3.func_78374_a(var6, 0.0D, -90.0D, 1.0D, 0.0D);
/* 381 */     var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
/* 382 */     var3.func_78381_a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 390 */     int posX = this.field_146294_l / 2;
/* 391 */     int posY = this.field_146295_m / 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 409 */     int xSize = 140;
/* 410 */     int ySize = 70;
/* 411 */     int guiLeft = (this.field_146294_l - xSize) / 2;
/* 412 */     int guiTop = (this.field_146295_m - ySize) / 2;
/* 413 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 414 */     ResourceLocation guiLocation = Panel;
/* 415 */     this.field_146297_k.field_71446_o.func_110577_a(guiLocation);
/* 416 */     func_73729_b(posX - 90, posY - 44, 0, 0 + ((sc == -1) ? 0 : 70), xSize, ySize);
/*     */     
/* 418 */     this.field_146292_n.add(0, new DBCGuiButtonsC(0, posX - 90, posY + 29, 50, 15, "", guigreen));
/* 419 */     this.field_146292_n.add(1, new DBCGuiButtonsC(1, posX - 35, posY + 29, 30, 15, "On", guired));
/* 420 */     this.field_146292_n.add(2, new DBCGuiButtonsC(2, posX + 0, posY + 29, 50, 15, "", guigreen));
/* 421 */     if (sc == -1) {
/* 422 */       ((DBCGuiButtonsC)this.field_146292_n.get(0)).field_146126_j = "";
/* 423 */       ((DBCGuiButtonsC)this.field_146292_n.get(1)).field_146126_j = JRMCoreH.trl("jrmc", "On");
/* 424 */       ((DBCGuiButtonsC)this.field_146292_n.get(2)).field_146126_j = "";
/*     */     }
/* 426 */     else if (sc == 0) {
/* 427 */       if (loadtime > 0) {
/* 428 */         ((DBCGuiButtonsC)this.field_146292_n.get(0)).field_146126_j = "";
/* 429 */         ((DBCGuiButtonsC)this.field_146292_n.get(1)).field_146126_j = "";
/* 430 */         ((DBCGuiButtonsC)this.field_146292_n.get(2)).field_146126_j = "";
/* 431 */         loadtime--;
/* 432 */         var8.func_78276_b(JRMCoreH.cllg + "LOADING LAUNCHER", posX - 70, posY - 30, 0);
/*     */       } else {
/* 434 */         sc = 1;
/*     */       }
/*     */     
/* 437 */     } else if (sc == 1) {
/* 438 */       ((DBCGuiButtonsC)this.field_146292_n.get(0)).field_146126_j = JRMCoreH.trl("jrmc", "Select");
/* 439 */       ((DBCGuiButtonsC)this.field_146292_n.get(1)).field_146126_j = JRMCoreH.trl("jrmc", "Off");
/* 440 */       ((DBCGuiButtonsC)this.field_146292_n.get(2)).field_146126_j = JRMCoreH.trl("jrmc", "OK");
/*     */       
/* 442 */       var8.func_78276_b(JRMCoreH.cllg + JRMCoreH.trl("jrmc", "Planet") + ": " + JRMCoreH.cly + JRMCoreH.trl("dbc", (String)DBCH.plntNms.get(Integer.valueOf(DBCClient.mc.field_71439_g.field_71093_bK))), posX - 80, posY - 40, 0);
/*     */       
/* 444 */       ssl = 0;
/* 445 */       var8.func_78276_b(JRMCoreH.cllg + "> " + JRMCoreH.trl("jrmc", "Destinations"), posX - 70, posY - 20, 0);
/*     */     }
/* 447 */     else if (sc == 2) {
/* 448 */       ((DBCGuiButtonsC)this.field_146292_n.get(0)).field_146126_j = JRMCoreH.trl("jrmc", "Select");
/* 449 */       ((DBCGuiButtonsC)this.field_146292_n.get(1)).field_146126_j = JRMCoreH.trl("jrmc", "Off");
/* 450 */       ((DBCGuiButtonsC)this.field_146292_n.get(2)).field_146126_j = JRMCoreH.trl("jrmc", "OK");
/*     */       
/* 452 */       var8.func_78276_b(JRMCoreH.cllg + JRMCoreH.trl("jrmc", "Destinations"), posX - 80, posY - 40, 0);
/*     */       
/* 454 */       ssl = 2;
/* 455 */       var8.func_78276_b(JRMCoreH.cly + "> ", posX - 70, posY - 30 + ss * 10, 0);
/* 456 */       int i = 0;
/* 457 */       var8.func_78276_b(JRMCoreH.cly + JRMCoreH.trl("jrmc", "Back"), posX - 60, posY - 30 + i * 10, 0); i++;
/* 458 */       for (int j = 0; j < dests.length; j++) {
/* 459 */         if (DBCClient.mc.field_71439_g.field_71093_bK != dests[j]) {
/* 460 */           if (ss == i) ssD = destsTP[j]; 
/* 461 */           var8.func_78276_b(JRMCoreH.cllg + (String)DBCH.plntNms.get(Integer.valueOf(dests[j])), posX - 60, posY - 30 + i * 10, 0); i++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 480 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCGuiSpacePod01.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */