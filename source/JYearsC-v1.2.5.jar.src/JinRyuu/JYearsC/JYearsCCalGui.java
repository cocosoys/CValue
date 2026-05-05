/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JYearsCH;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import JinRyuu.JRMCore.p.YC.JYearsCP;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class JYearsCCalGui
/*     */   extends GuiScreen
/*     */ {
/*  23 */   public int jyc = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  33 */     this.field_146292_n.clear();
/*     */     
/*  35 */     int posX = this.field_146294_l / 2;
/*  36 */     int posY = this.field_146295_m / 2;
/*  37 */     this.field_146292_n.add(new JYearsCGuiButtons00(0, posX - 190, posY - 80, 60, 20, "ID Card"));
/*  38 */     this.field_146292_n.add(new JYearsCGuiButtons00(1, posX - 190, posY - 55, 60, 20, "Calendar"));
/*  39 */     this.field_146292_n.add(new JYearsCGuiButtons00(2, posX - 190, posY - 30, 60, 20, "The Days"));
/*  40 */     this.field_146292_n.add(new JYearsCGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X"));
/*     */     
/*  42 */     if (this.jyc == 0) {
/*  43 */       float A = 0.0F;
/*  44 */       if (JYearsCH.p != null && 
/*  45 */         JYearsCH.p.length > 0)
/*  46 */         for (String n : JYearsCH.p) {
/*  47 */           String[] m = n.split(";");
/*  48 */           if (this.field_146297_k.field_71439_g.getDisplayName().equals(m[0]))
/*  49 */             A = Float.parseFloat(m[1]); 
/*     */         }  
/*  51 */       if (A > 400.0F)
/*  52 */         this.field_146292_n.add(new JYearsCGuiButtons00(11, posX + 0, posY + 10, 60, 20, "Rebirth")); 
/*     */     } 
/*     */   }
/*     */   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/*     */     GuiButton ret;
/*  57 */     int selct = par1 - 20;
/*  58 */     int KA = 0;
/*     */     
/*  60 */     if (KA == 1) {
/*  61 */       ret = new JYearsCGuiButtons00(par1, par2, par3, par4, par5, par6Str);
/*     */     } else {
/*     */       
/*  64 */       ret = new JYearsCGuiButtons00(par1, par2, par3, par4, par5, par6Str);
/*     */     } 
/*  66 */     return ret;
/*     */   }
/*     */   
/*     */   public void func_146284_a(GuiButton button) {
/*  70 */     if (button.field_146127_k == 10) {
/*  71 */       this.field_146297_k.field_71439_g.func_71053_j();
/*     */     }
/*  73 */     if (button.field_146127_k == 0) {
/*  74 */       this.field_146297_k.field_71439_g.openGui(mod_JYearsC.instance, 0, (World)this.field_146297_k.field_71441_e, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
/*     */     }
/*     */     
/*  77 */     if (button.field_146127_k == 1) {
/*  78 */       this.field_146297_k.field_71439_g.openGui(mod_JYearsC.instance, 1, (World)this.field_146297_k.field_71441_e, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
/*     */     }
/*     */     
/*  81 */     if (button.field_146127_k == 2) {
/*  82 */       this.field_146297_k.field_71439_g.openGui(mod_JYearsC.instance, 2, (World)this.field_146297_k.field_71441_e, (int)this.field_146297_k.field_71439_g.field_70165_t, (int)this.field_146297_k.field_71439_g.field_70163_u, (int)this.field_146297_k.field_71439_g.field_70161_v);
/*     */     }
/*     */     
/*  85 */     if (button.field_146127_k == 11) {
/*  86 */       jyc(1);
/*  87 */       this.field_146297_k.field_71439_g.func_71053_j();
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
/*     */   public static void jyc(int py) {
/*  99 */     int jycdatey = 0;
/* 100 */     int jycdatem = 0;
/* 101 */     int jycdated = 0;
/* 102 */     int jycpy = py;
/* 103 */     String jycp = "";
/* 104 */     PD.sendToServer((IMessage)new JYearsCP(jycdatey, jycdatem, jycdated, jycp, jycpy));
/*     */   }
/*     */ 
/*     */   
/* 108 */   public static String[] dayNames = JYearsCH.dayNames;
/* 109 */   public static String[] monthNames = JYearsCH.monthNames;
/* 110 */   public static String[] monthInDays = JYearsCH.monthInDays; public int years; public int d;
/* 111 */   public static int[] mid = JYearsCH.mID; public int m;
/*     */   public JYearsCCalGui(int w) {
/* 113 */     this.years = JYearsCH.y;
/* 114 */     this.d = JYearsCH.d;
/* 115 */     this.m = JYearsCH.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     this.Process = "Something is Wrong";
/* 333 */     this.wid = 0;
/* 334 */     this.hei = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 375 */     this.textureFile = "jinryuudragonbc:sagas.png";
/*     */     this.jyc = w;
/*     */   }
/*     */   public void ScouterRenderBlur(int par1, int par2) {
/* 379 */     GL11.glDisable(2929);
/* 380 */     GL11.glDepthMask(false);
/* 381 */     GL11.glBlendFunc(770, 771);
/* 382 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 383 */     GL11.glDisable(3008);
/* 384 */     ResourceLocation tx = new ResourceLocation(this.textureFile);
/* 385 */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 386 */     Tessellator var3 = Tessellator.field_78398_a;
/* 387 */     var3.func_78382_b();
/* 388 */     var3.func_78374_a(0.0D, par2, -90.0D, 0.0D, 1.0D);
/* 389 */     var3.func_78374_a(par1, par2, -90.0D, 1.0D, 1.0D);
/* 390 */     var3.func_78374_a(par1, 0.0D, -90.0D, 1.0D, 0.0D);
/* 391 */     var3.func_78374_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
/* 392 */     var3.func_78381_a();
/* 393 */     GL11.glDepthMask(true);
/* 394 */     GL11.glEnable(2929);
/* 395 */     GL11.glEnable(3008);
/* 396 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public void func_73863_a(int x, int y, float f) {
/*     */     ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*     */     int var6 = var5.func_78326_a();
/*     */     int var7 = var5.func_78328_b();
/*     */     FontRenderer var8 = this.field_146297_k.field_71466_p;
/*     */     String wish = "jinryuujyearsc:cal.png";
/*     */     int xSize = 256;
/*     */     int ySize = 160;
/*     */     int guiLeft = (this.field_146294_l - xSize) / 2;
/*     */     int guiTop = (this.field_146295_m - ySize) / 2;
/*     */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     ResourceLocation guiLocation = new ResourceLocation(wish);
/*     */     this.field_146297_k.field_71446_o.func_110577_a(guiLocation);
/*     */     func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */     guiLeft += 5;
/*     */     guiTop = guiTop + 10 + 5;
/*     */     if (this.jyc == 0) {
/*     */       float A = 0.0F;
/*     */       if (JYearsCH.p != null && JYearsCH.p.length > 0)
/*     */         for (String n : JYearsCH.p) {
/*     */           String[] m = n.split(";");
/*     */           if (this.field_146297_k.field_71439_g.getDisplayName().equals(m[0]))
/*     */             A = Float.parseFloat(m[1]); 
/*     */         }  
/*     */       var8.func_78276_b("Name: §8" + this.field_146297_k.field_71439_g.getDisplayName(), guiLeft, guiTop, 0);
/*     */       var8.func_78276_b("Time Lived: §8" + (int)((A <= 46.0F) ? A : (A - (int)(A / 46.0F) * 46.0F)) + " Days " + ((A > 46.0F) ? ("and " + (int)(A / 46.0F) + " Minecraft Years") : ""), guiLeft, guiTop + 10, 0);
/*     */       var8.func_78276_b("Real Years Converted: §8" + (int)(6.0F + A * 10.0F / 46.0F) + " Years", guiLeft, guiTop + 20, 0);
/*     */       var8.func_78276_b("Grow Stage: §8" + ((A < 23.0F) ? "Child" : ((A < 46.0F) ? "Teen" : "Adult")), guiLeft, guiTop + 30, 0);
/*     */       if (A > 400.0F)
/*     */         var8.func_78276_b("Rebirth will cost an Emerald.", guiLeft + 20, guiTop + 65, 0); 
/*     */     } 
/*     */     int days = 0;
/*     */     int j2 = 0;
/*     */     for (int k = 0; k < this.years % dayNames.length + 1; k++) {
/*     */       for (int i = 0; i < mid.length; i++) {
/*     */         if (this.jyc == 2)
/*     */           var8.func_78276_b(monthNames[i], guiLeft + i * 61, guiTop, 0); 
/*     */         if (this.jyc == 1)
/*     */           var8.func_78276_b(monthNames[i], guiLeft + ((i == 0 || i == 2) ? 0 : 122), guiTop + ((i == 0 || i == 1) ? 0 : 80), 0); 
/*     */         for (int j = 0; j < mid[i]; j++) {
/*     */           if (days > 4)
/*     */             days = 0; 
/*     */           if (i == this.m && j == this.d)
/*     */             j2 = days; 
/*     */           if (k == this.years % dayNames.length) {
/*     */             if (this.jyc == 1) {
/*     */               int xS = 14;
/*     */               int yS = 12;
/*     */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               ResourceLocation tx = new ResourceLocation(wish);
/*     */               this.field_146297_k.field_71446_o.func_110577_a(tx);
/*     */               if (i == this.m && j == this.d)
/*     */                 func_73729_b(guiLeft - 4 + ((i == 0 || i == 2) ? ((j < 6) ? (j * 14) : ((j >= 9) ? (j * 14 - 84 - 0) : (j * 14 - 84))) : ((j < 6) ? (122 + j * 14) : ((j >= 9) ? (122 + j * 14 - 84 - 0) : (122 + j * 14 - 84)))), guiTop - 2 + 10 + ((i == 0 || i == 1) ? ((j > 5) ? 10 : 0) : ((j > 5) ? 90 : 80)), 0, 176, xS, yS); 
/*     */               var8.func_78276_b("§6" + (j + 1), guiLeft + ((i == 0 || i == 2) ? ((j < 6) ? (j * 14) : ((j >= 9) ? (j * 14 - 84 - 3) : (j * 14 - 84))) : ((j < 6) ? (122 + j * 14) : ((j >= 9) ? (122 + j * 14 - 84 - 3) : (122 + j * 14 - 84)))), guiTop + 10 + ((i == 0 || i == 1) ? ((j > 5) ? 10 : 0) : ((j > 5) ? 90 : 80)), 0);
/*     */             } 
/*     */             if (this.jyc == 2) {
/*     */               int xS = 64;
/*     */               int yS = 10;
/*     */               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */               ResourceLocation tx = new ResourceLocation(wish);
/*     */               this.field_146297_k.field_71446_o.func_110577_a(tx);
/*     */               if (i == this.m && j == this.d)
/*     */                 func_73729_b(guiLeft + i * 61 - 3, guiTop + 10 + j * 8 - 1, 0, 163, xS, yS); 
/*     */               var8.func_78276_b("§6" + (j + 1) + " " + "§8" + dayNames[days], guiLeft + i * 61, guiTop + 10 + j * 8, 0);
/*     */             } 
/*     */           } 
/*     */           days++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     String ks = "";
/*     */     if (this.d + 1 == 1)
/*     */       ks = "st"; 
/*     */     if (this.d + 1 == 2)
/*     */       ks = "nd"; 
/*     */     if (this.d + 1 == 3)
/*     */       ks = "rd"; 
/*     */     if (this.d + 1 > 3)
/*     */       ks = "th"; 
/*     */     String s = "§6" + (this.d + 1) + ks + " §0of §8" + monthNames[this.m] + " §0in " + "§8" + this.years;
/*     */     s = " §8" + monthNames[this.m] + ": " + "§6" + (this.d + 1) + ks + " §0of " + "§8" + this.years + "§0, " + dayNames[j2];
/*     */     var8.func_78276_b(s, guiLeft + (xSize / 2 - s.length()) / 2, guiTop - 10, 0);
/*     */     super.func_73863_a(x, y, f);
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void current(String var35, int posx, int posy, FontRenderer var8, int var6, int var7) {
/*     */     int wid = var8.func_78256_a(var35) / 2;
/*     */     int posX = var6 / 2 + posx - wid;
/*     */     int posY = var7 / 2 + posy + 8;
/*     */     var8.func_78276_b(var35, posX + 1, posY, 0);
/*     */     var8.func_78276_b(var35, posX - 1, posY, 0);
/*     */     var8.func_78276_b(var35, posX, posY + 1, 0);
/*     */     var8.func_78276_b(var35, posX, posY - 1, 0);
/*     */     var8.func_78276_b(var35, posX, posY, 8388564);
/*     */   }
/*     */   
/*     */   public static int count = 0;
/*     */   public static int warn = 0;
/*     */   public static int startcount = 0;
/*     */   private String Process;
/*     */   private int wid;
/*     */   private int hei;
/*     */   private String textureFile;
/*     */   
/*     */   public void SagasPage(int var6, int var7) {
/*     */     this.textureFile = "jinryuudragonbc:sagas.png";
/*     */     ScouterRenderBlur(var6, var7);
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
/*     */     func_73732_a(this.field_146297_k.field_71466_p, this.Process, width + this.wid, height + this.hei, 16768306);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCCalGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */