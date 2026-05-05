/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class JRMCoreGuiSCM
/*     */   extends GuiScreen
/*     */ {
/*  15 */   public static Minecraft mc = Minecraft.func_71410_x();
/*     */   protected int guiLeft;
/*     */   protected int guiTop;
/*  18 */   protected int xSize = 256;
/*  19 */   protected int ySize = 159;
/*     */   private float xSize_lo;
/*     */   private float ySize_lo;
/*  22 */   int id = 0;
/*  23 */   private int tick = 0;
/*     */   
/*  25 */   private int guiID = 0;
/*  26 */   private int ipg = 0;
/*  27 */   private int lp = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  33 */     this.field_146292_n.clear();
/*  34 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  35 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */     
/*  37 */     int posX = this.field_146294_l / 2;
/*  38 */     int posY = this.field_146295_m / 2;
/*  39 */     JRMCoreH.jrmct(1);
/*  40 */     JRMCoreH.jrmct(3);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object actionPerformed(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/*     */     GuiButton ret;
/*  46 */     int selct = par1 - 20;
/*  47 */     int KA = 0;
/*     */     
/*  49 */     if (KA == 1) {
/*     */       
/*  51 */       ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
/*     */     }
/*     */     else {
/*     */       
/*  55 */       ret = new JRMCoreGuiButtons00(par1, par2, par3, par4, par5, par6Str, 0);
/*     */     } 
/*  57 */     return ret;
/*     */   }
/*     */   
/*     */   public void func_146284_a(GuiButton button) {
/*  61 */     if (button.field_146127_k == 0) this.id = 0;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float f) {
/*  68 */     this.xSize_lo = x;
/*  69 */     this.ySize_lo = y;
/*  70 */     this; this; this; ScaledResolution var5 = new ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/*  71 */     int var6 = var5.func_78326_a();
/*  72 */     int var7 = var5.func_78328_b();
/*  73 */     this; FontRenderer var8 = mc.field_71466_p;
/*  74 */     String wish = "jinryuumodscore:gui.png";
/*  75 */     String icons = "jinryuumodscore:icons.png";
/*     */     
/*  77 */     this.field_146292_n.clear();
/*  78 */     this.tick++;
/*  79 */     if (this.tick >= 20) { this.tick = 0; JRMCoreH.jrmct(1); JRMCoreH.jrmct(3); }
/*     */     
/*  81 */     this.guiLeft = (this.field_146294_l - this.xSize) / 2;
/*  82 */     this.guiTop = (this.field_146295_m - this.ySize) / 2;
/*     */     
/*  84 */     int posX = this.field_146294_l / 2;
/*  85 */     int posY = this.field_146295_m / 2;
/*     */     
/*  87 */     byte pwr = JRMCoreH.Pwrtyp;
/*     */ 
/*     */     
/*  90 */     if (this.guiID == 11) {
/*     */       String[] rSkls; int[][] rSklsLvl; String[] rSklsNms, cSkls; int[][] cSklsLvl; String[] cSklsNms, skls; int[][] sklsLvl; String sklsNms[], mod;
/*  92 */       int xSize = 256;
/*  93 */       int ySize = 159;
/*  94 */       int guiLeft = (this.field_146294_l - xSize) / 2;
/*  95 */       int guiTop = (this.field_146295_m - ySize) / 2;
/*  96 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  97 */       ResourceLocation guiLocation = new ResourceLocation(wish);
/*  98 */       this; mc.field_71446_o.func_110577_a(guiLocation);
/*  99 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 101 */       this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
/* 102 */       this.field_146292_n.add(new JRMCoreGuiButtons00(100, posX - 120, posY + 85, 80, 20, JRMCoreH.trl("jrmc", "MainAttributes"), 0));
/* 103 */       this.field_146292_n.add(new JRMCoreGuiButtons00(101, posX - 35, posY + 85, 80, 20, JRMCoreH.trl("jrmc", "Skills"), 0));
/* 104 */       this.field_146292_n.add(new JRMCoreGuiButtons00(102, posX + 50, posY + 85, 80, 20, (JRMCoreH.Pwrtyp == 1) ? JRMCoreH.trl("jrmc", "KiTechniques") : JRMCoreH.trl("jrmc", "Jutsu"), 0));
/*     */       
/* 106 */       if (JRMCoreH.Pwrtyp == 2) {
/* 107 */         String l = JRMCoreH.trl("jrmc", "Learn");
/* 108 */         int lw = this.field_146289_q.func_78256_a(l);
/* 109 */         this.field_146292_n.add(new JRMCoreGuiButtons01(-200, guiLeft + 250 - lw, guiTop + 5, lw, l, JRMCoreH.techNCCol[1]));
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
/*     */ 
/*     */ 
/*     */       
/* 129 */       if (JRMCoreH.Pwrtyp == 2) {
/* 130 */         rSkls = JRMCoreH.ncRSkls;
/* 131 */         rSklsLvl = JRMCoreH.ncRSklsLvl;
/* 132 */         rSklsNms = JRMCoreH.ncRSklsNms;
/* 133 */         cSkls = JRMCoreH.ncCSkls;
/* 134 */         cSklsLvl = JRMCoreH.NCRacialSkillTPCost;
/* 135 */         cSklsNms = JRMCoreH.NCRacialSkillAbilityNames;
/* 136 */         skls = JRMCoreH.NCSkillIDs;
/* 137 */         sklsLvl = JRMCoreH.NCSkillTPCost;
/* 138 */         sklsNms = JRMCoreH.NCSkillNames;
/* 139 */         mod = "nc";
/*     */       } else {
/* 141 */         rSkls = JRMCoreH.vlblRSkls;
/* 142 */         rSklsLvl = JRMCoreH.DBCRacialSkillTPCost;
/* 143 */         rSklsNms = JRMCoreH.vlblRSklsNms;
/* 144 */         cSkls = JRMCoreH.vlblCSkls;
/* 145 */         cSklsLvl = JRMCoreH.vlblCSklsLvl;
/* 146 */         cSklsNms = JRMCoreH.vlblCSklsNms;
/* 147 */         skls = JRMCoreH.DBCSkillsIDs;
/* 148 */         sklsLvl = JRMCoreH.DBCSkillTPCost;
/* 149 */         sklsNms = JRMCoreH.DBCSkillNames;
/* 150 */         mod = "dbc";
/*     */       } 
/*     */       
/* 153 */       byte b = 0;
/*     */       
/* 155 */       if (JRMCoreH.PlyrSkillX != null && !JRMCoreH.PlyrSkillX.contains("pty") && JRMCoreH.PlyrSkillX.length() > 1) {
/*     */         
/* 157 */         b = (byte)(b + 1);
/* 158 */         String name = JRMCoreH.trl(mod, JRMCoreH.SklName(JRMCoreH.PlyrSkillX, rSkls, rSklsNms, JRMCoreH.Race));
/* 159 */         int n = Integer.parseInt(JRMCoreH.PlyrSkillX.substring(2));
/*     */         
/* 161 */         var8.func_78276_b("§0" + name + ((n < 6) ? (" §8lvl: " + n) : ""), guiLeft + 5, guiTop + 15 + b * 10, 0);
/* 162 */         if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && n < 6)
/* 163 */           this.field_146292_n.add(new JRMCoreGuiButtonsA3(340, guiLeft - 10, guiTop + 15 + b * 10, 10, 2)); 
/* 164 */         if (JRMCoreH.Race == 4 && n < 4)
/* 165 */           this.field_146292_n.add(new JRMCoreGuiButtonsA3(340, guiLeft - 10, guiTop + 15 + b * 10, 10, 2)); 
/* 166 */         if ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.PlyrSkillY != null && JRMCoreH.PlyrSkillY.contains("Sai") && n >= 5) {
/* 167 */           this.field_146292_n.add(new JRMCoreGuiButtonsA3(JRMCoreH.PlyrSkillY.contains("R") ? 343 : 342, guiLeft + 10 + var8.func_78256_a(name + ((n < 6) ? (" §8lvl: " + n) : "")), guiTop + 15 + b * 10, 20, JRMCoreH.PlyrSkillY.contains("R") ? 0 : 1));
/*     */         }
/*     */         
/* 170 */         int tpLevelCost = 0;
/* 171 */         if (mod.equals("dbc")) {
/*     */           
/* 173 */           tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, rSklsLvl);
/*     */         }
/*     */         else {
/*     */           
/* 177 */           tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillY, JRMCoreH.Race, cSklsLvl);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 196 */         if (JRMCoreH.Race == 1 || JRMCoreH.Race == 2 || JRMCoreH.Race == 4) {
/*     */           
/* 198 */           String s = (n < ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) ? 6 : ((JRMCoreH.Race == 4) ? 4 : 0))) ? ((tpLevelCost == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : ("TP: " + tpLevelCost)) : JRMCoreH.trl("jrmc", "Maxed");
/* 199 */           var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
/*     */         } else {
/* 201 */           String s = JRMCoreH.trl("jrmc", "NoUpgrade");
/* 202 */           var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
/*     */         } 
/* 204 */       }  if (JRMCoreH.PlyrSkillY != null && !JRMCoreH.PlyrSkillY.contains("pty") && !JRMCoreH.PlyrSkillY.contains("Sai") && JRMCoreH.Race != 1 && JRMCoreH.Race != 2 && JRMCoreH.PlyrSkillY.length() > 1) {
/*     */         
/* 206 */         b = (byte)(b + 1);
/* 207 */         String name = JRMCoreH.SklName(JRMCoreH.PlyrSkillY, cSkls, cSklsNms);
/*     */         
/* 209 */         int n = Integer.parseInt(JRMCoreH.PlyrSkillY.substring(2));
/* 210 */         var8.func_78276_b("§0" + ((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) ? JRMCoreH.TransSaiUpNam[n] : (name + " §8lvl: " + (n + 1))), guiLeft + 5, guiTop + 15 + b * 10, 0);
/* 211 */         if (n <= 8) this.field_146292_n.add(new JRMCoreGuiButtonsA3(341, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
/*     */         
/* 213 */         int tpLevelCost = 0;
/* 214 */         if (mod.equals("dbc")) {
/*     */           
/* 216 */           tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillX, JRMCoreH.Race, rSklsLvl);
/*     */         }
/*     */         else {
/*     */           
/* 220 */           tpLevelCost = JRMCoreH.skillTPCost_X(JRMCoreH.PlyrSkillY, JRMCoreH.Race, cSklsLvl);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 234 */         String s = (n <= 8) ? ((tpLevelCost == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : ("TP: " + tpLevelCost)) : JRMCoreH.trl("jrmc", "Maxed");
/* 235 */         var8.func_78276_b(s, guiLeft + 250 - var8.func_78256_a(s), guiTop + 15 + b * 10, 0);
/*     */       } 
/* 237 */       if (JRMCoreH.PlyrSkills != null) {
/*     */         
/* 239 */         int s = 0; byte i;
/* 240 */         for (i = 0; i < JRMCoreH.PlyrSkills.length; i = (byte)(i + 1)) {
/*     */           
/* 242 */           String currentSkill = JRMCoreH.PlyrSkills[i];
/* 243 */           if (!currentSkill.contains("pty") && currentSkill.length() > 2)
/*     */           
/* 245 */           { b = (byte)(b + 1);
/* 246 */             String name = (JRMCoreH.Pwrtyp == 1) ? JRMCoreH.trl("dbc", JRMCoreH.SklName(currentSkill, skls, sklsNms)) : JRMCoreH.trl("nc", JRMCoreH.SklName(currentSkill, skls, sklsNms));
/* 247 */             int n = Integer.parseInt(currentSkill.substring(2));
/* 248 */             var8.func_78276_b("§0" + name + " §8lvl: " + (n + 1), guiLeft + 5, guiTop + 15 + b * 10, 0);
/*     */             
/* 250 */             this.field_146292_n.add(new JRMCoreGuiButtonsA3(300 + i, guiLeft + 255, guiTop + 15 + b * 10, 10, 3));
/* 251 */             if (n <= 8) this.field_146292_n.add(new JRMCoreGuiButtonsA3(320 + i, guiLeft - 10, guiTop + 15 + b * 10, 10, 2));
/*     */             
/* 253 */             int tpLevelCost = JRMCoreH.skillTPCost(currentSkill, skls, sklsLvl);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 265 */             String st = (n <= 8) ? ((tpLevelCost == -1) ? JRMCoreH.trl("jrmc", "UpgradeLocked") : ("TP: " + tpLevelCost)) : JRMCoreH.trl("jrmc", "Maxed");
/* 266 */             var8.func_78276_b(st, guiLeft + 250 - var8.func_78256_a(st), guiTop + 15 + b * 10, 0); }
/* 267 */           else { s++; }
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 275 */     if (this.guiID == 16)
/*     */     { String SklsNms[], mod;
/* 277 */       int xSize = 256;
/* 278 */       int ySize = 159;
/* 279 */       int guiLeft = (this.field_146294_l - xSize) / 2;
/* 280 */       int guiTop = (this.field_146295_m - ySize) / 2;
/* 281 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 282 */       ResourceLocation guiLocation = new ResourceLocation(wish);
/* 283 */       this; mc.field_71446_o.func_110577_a(guiLocation);
/* 284 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 286 */       this.field_146292_n.add(new JRMCoreGuiButtons00(10, posX - 150, posY + 65, 20, 20, "X", 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       if (pwr == 2) {
/* 293 */         SklsNms = JRMCoreH.NCSkillNames;
/* 294 */         int[][] SklsLvl = JRMCoreH.NCSkillTPCost;
/*     */         
/* 296 */         mod = "nc";
/*     */       } else {
/* 298 */         SklsNms = JRMCoreH.DBCSkillNames;
/* 299 */         int[][] SklsLvl = JRMCoreH.DBCSkillTPCost;
/*     */         
/* 301 */         mod = "dbc";
/*     */       } 
/*     */       
/* 304 */       var8.func_78276_b(JRMCoreH.numSep(JRMCoreH.curTP) + " " + "Training Points", guiLeft + 10, guiTop + 5, 0);
/* 305 */       int i2 = 0;
/* 306 */       int nms = SklsNms.length; byte i;
/* 307 */       for (i = 0; i < nms; i = (byte)(i + 1)) {
/*     */         
/* 309 */         if (i2 <= 13 + this.ipg * 13 && i2 >= 0 + this.ipg * 13) {
/*     */           
/* 311 */           String fn = JRMCoreH.trl(mod, SklsNms[i]);
/* 312 */           int fnw = this.field_146289_q.func_78256_a(fn);
/* 313 */           var8.func_78276_b(fn, guiLeft + xSize / 2 - 122, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, 0);
/* 314 */           String on = (JRMCoreH.SklLvl(i, pwr) < 1) ? "" : (" " + JRMCoreH.trl("jrmc", "Owned"));
/* 315 */           int onw = this.field_146289_q.func_78256_a(on);
/* 316 */           var8.func_78276_b(on, guiLeft + xSize / 2 - 122 + fnw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
/* 317 */           if (JRMCoreH.SklLvl(i, pwr) < 1) {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 322 */             int tpCost = JRMCoreH.getSkillTPCost(i, 0, JRMCoreH.isPowerTypeKi());
/*     */             
/* 324 */             String n = " " + tpCost + " tp";
/* 325 */             int nw = this.field_146289_q.func_78256_a(fn);
/*     */             
/* 327 */             if (tpCost != -1 && JRMCoreH.curTP >= tpCost) {
/*     */               
/* 329 */               this.field_146292_n.add(new JRMCoreGuiButtons01((JRMCoreH.SklLvl(i, pwr) < 1) ? (4000 + i) : -1, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, nw, n, JRMCoreH.techNCCol[1]));
/*     */             } else {
/* 331 */               var8.func_78276_b(n, guiLeft + xSize / 2 - 122 + fnw + onw, guiTop + (ySize + 1) / 2 - 64 + i * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 336 */         i2++;
/*     */       } 
/* 338 */       if (i2 > 13 + this.lp * 13) {
/*     */         
/* 340 */         String n = JRMCoreH.trl("jrmc", "Next");
/* 341 */         this.field_146292_n.add(new JRMCoreGuiButtons00(88, guiLeft + xSize / 2 + 130, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(n) + 8, 20, n, 0));
/*     */       } 
/* 343 */       if (this.lp != 0) {
/*     */         
/* 345 */         String p = JRMCoreH.trl("jrmc", "Prev"); int pw = this.field_146289_q.func_78256_a(p) + 8;
/* 346 */         this.field_146292_n.add(new JRMCoreGuiButtons00(89, guiLeft + xSize / 2 - 130 - pw, guiTop + (ySize + 1) / 2 + 15, pw, 20, p, 0));
/*     */       }  }
/* 348 */     else { this.lp = 0; }
/* 349 */      super.func_73863_a(x, y, f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 356 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiSCM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */