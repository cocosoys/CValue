/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCClientTickHandler;
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtonC;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtons00;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtons01;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiButtonsA1;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiSlider00;
/*     */ import JinRyuu.JRMCore.JRMCoreGuiSliderX00;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.p.DBC.DBCPwish;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiIngame;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class DBCWishGui
/*     */   extends GuiScreen
/*     */ {
/*     */   private DBCClientTickHandler tick;
/*     */   private GuiIngame Guiingame;
/*     */   
/*     */   public void renderSuperProtect(int ki) {
/*  35 */     this.field_146292_n.clear();
/*  36 */     int posX = this.field_146294_l / 2;
/*  37 */     int posY = this.field_146295_m / 2;
/*  38 */     this.field_146292_n.add(new DBCGuiButtons01(100, posX - 0, posY - 0, 20, 20, "TEST"));
/*     */   }
/*     */   
/*  41 */   private int wishID = 0;
/*  42 */   private int prevwish = 0;
/*  43 */   private int wish = 0;
/*  44 */   private int KiColorSlcted = -1; boolean clicked;
/*     */   int wpp;
/*     */   String target;
/*     */   private int ipg;
/*     */   private float BrghtSlcted;
/*     */   private int scrollMouseJump;
/*     */   private int scroll;
/*     */   private float scrollSide;
/*     */   private boolean mousePressed;
/*     */   private int tickI;
/*     */   
/*     */   public void func_73866_w_() {
/*  56 */     this.field_146292_n.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146284_a(GuiButton button) {
/*  61 */     if (button.field_146127_k == -21) {
/*  62 */       int col = ((JRMCoreGuiButtonC)button).getBgCol();
/*  63 */       this.KiColorSlcted = col;
/*  64 */       this.wish = this.prevwish;
/*     */     } 
/*  66 */     if (button.field_146127_k == -20) this.BrghtSlcted = ((JRMCoreGuiSlider00)button).sliderValue; 
/*  67 */     if (button.field_146127_k == -3) this.ipg++; 
/*  68 */     if (button.field_146127_k == -4) this.ipg--; 
/*  69 */     if (button.field_146127_k == -5) this.wish = this.prevwish;
/*     */ 
/*     */     
/*  72 */     if (button.field_146127_k == -2) this.scroll -= 3; 
/*  73 */     if (button.field_146127_k == -1) this.scroll += 3; 
/*  74 */     if (button.field_146127_k >= 0) {
/*  75 */       boolean send = true;
/*  76 */       this.clicked = true;
/*  77 */       this.wishID = button.field_146127_k;
/*  78 */       if (this.wish == 1) {
/*  79 */         if (this.target.length() < 2 && ((
/*  80 */           (String)DBCH.wishS.get(button.field_146127_k)).equals("revive") || ((String)DBCH.wishS.get(button.field_146127_k)).equals("reviventp"))) {
/*  81 */           send = false;
/*  82 */           dbcWish(3, "");
/*  83 */           this.prevwish = this.wish;
/*  84 */           this.wishID = button.field_146127_k;
/*  85 */           this.wish = 10;
/*     */         } 
/*     */         
/*  88 */         if (this.KiColorSlcted == -1 && ((String)DBCH.wishS.get(button.field_146127_k)).equals("kicolor")) {
/*  89 */           send = false;
/*  90 */           this.prevwish = this.wish;
/*  91 */           this.wishID = button.field_146127_k;
/*  92 */           this.wish = 11;
/*     */         } 
/*     */       } 
/*  95 */       if (this.wish == 2) {
/*  96 */         if (this.target.length() < 2 && ((
/*  97 */           (String)DBCH.wishP.get(button.field_146127_k)).equals("revive") || ((String)DBCH.wishP.get(button.field_146127_k)).equals("reviventp"))) {
/*  98 */           send = false;
/*  99 */           dbcWish(3, "");
/* 100 */           this.prevwish = this.wish;
/* 101 */           this.wishID = button.field_146127_k;
/* 102 */           this.wish = 10;
/*     */         } 
/*     */         
/* 105 */         if (this.KiColorSlcted == -1 && ((String)DBCH.wishP.get(button.field_146127_k)).equals("kicolor")) {
/* 106 */           send = false;
/* 107 */           this.prevwish = this.wish;
/* 108 */           this.wishID = button.field_146127_k;
/* 109 */           this.wish = 11;
/*     */         } 
/*     */       } 
/*     */       
/* 113 */       if (send) {
/* 114 */         if (this.wish == 10) {
/* 115 */           int i = button.field_146127_k - 1000;
/* 116 */           this.target = playerlist[i];
/* 117 */           this.wish = this.prevwish;
/*     */         } else {
/* 119 */           dbcWish(0, this.wishID + ";" + ((this.KiColorSlcted >= 0) ? (String)Integer.valueOf(this.KiColorSlcted) : this.target));
/* 120 */           this.target = "";
/* 121 */           this.KiColorSlcted = -1;
/*     */         } 
/*     */       }
/* 124 */       DBCH.packDuo(-2, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void dbcWish(int id, String wish) {
/* 129 */     int dbcwish = id;
/* 130 */     PD.sendToServer((IMessage)new DBCPwish(id, wish));
/*     */   }
/* 132 */   public DBCWishGui(int w) { this.clicked = false;
/*     */     
/* 134 */     this.wpp = 6;
/* 135 */     this.target = "";
/*     */     
/* 137 */     this.BrghtSlcted = 0.8F;
/*     */     this.wish = w;
/*     */     this.scroll = 0;
/*     */     if (this.wish == 1 || this.wish == 2)
/*     */       DBCH.packDuo(-2, 0); 
/*     */     playerlist = null;
/* 143 */     this.target = ""; } public static String[] playerlist = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float f) {
/* 149 */     if (Mouse.isButtonDown(0)) {
/*     */ 
/*     */       
/* 152 */       this.mousePressed = true;
/* 153 */       this.scrollSide = JRMCoreGuiSliderX00.sliderValue;
/*     */     } else {
/*     */       
/* 156 */       this.mousePressed = false;
/* 157 */       while (Mouse.next()) {
/*     */         
/* 159 */         int mw = Mouse.getEventDWheel();
/* 160 */         if (mw != 0) {
/*     */           
/* 162 */           if (mw < 0) { this.scroll += this.scrollMouseJump; }
/* 163 */           else if (mw > 0 && this.scroll > 0) { this.scroll -= this.scrollMouseJump; }
/* 164 */            this.scrollMouseJump = 1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 170 */     this.tickI++;
/* 171 */     if (this.tickI > 20) this.tickI = 0;
/*     */     
/* 173 */     if (this.clicked && JRMCoreH.wishes <= 0) this.field_146297_k.field_71439_g.func_71053_j(); 
/* 174 */     this.field_146292_n.clear();
/* 175 */     FontRenderer var8 = this.field_146297_k.field_71466_p;
/* 176 */     ScaledResolution var5 = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 177 */     int var6 = var5.func_78326_a();
/* 178 */     int var7 = var5.func_78328_b();
/* 179 */     int posX = this.field_146294_l / 2;
/* 180 */     int posY = this.field_146295_m / 2;
/* 181 */     int xSize = 182;
/* 182 */     int ySize = 191;
/* 183 */     int guiLeft = (this.field_146294_l - xSize) / 2;
/* 184 */     int guiTop = (this.field_146295_m - ySize) / 2;
/*     */     
/* 186 */     String tex = "jinryuudragonbc:wish.png";
/* 187 */     this.wpp = 6;
/* 188 */     if (this.wish == 1) {
/* 189 */       tex = "jinryuudragonbc:wish.png";
/* 190 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 191 */       ResourceLocation tx = new ResourceLocation(tex);
/* 192 */       this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 193 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 195 */       int j = 0;
/* 196 */       int i2 = 0;
/* 197 */       int a = JRMCoreH.Algnmnt(JRMCoreH.align);
/* 198 */       i2 = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragon.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
/* 199 */       j += i2;
/*     */       
/* 201 */       int size = DBCH.wishS.size();
/*     */ 
/*     */ 
/*     */       
/* 205 */       int m1 = size;
/* 206 */       float m2 = 5.0F;
/* 207 */       int sz = 6;
/* 208 */       this.scrollMouseJump = 1;
/* 209 */       if (m1 > sz)
/* 210 */       { if (m1 - m2 < this.scroll) {
/* 211 */           this.scroll = (int)(m1 - m2);
/* 212 */         } else if (this.scroll < 0) {
/* 213 */           this.scroll = 0;
/* 214 */         }  if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
/* 215 */           this.scroll = (int)((m1 - m2) * this.scrollSide);
/*     */         } else {
/* 217 */           this.scrollSide = JRMCoreGuiSliderX00.sliderValue = this.scroll / (m1 - m2);
/*     */         }  }
/* 219 */       else { this.scroll = 0; }
/*     */       
/* 221 */       if (m1 > sz) {
/* 222 */         if (this.scrollSide > 0.0F) this.field_146292_n.add(new JRMCoreGuiButtonsA1(-2, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 - 70, "i")); 
/* 223 */         if (this.scrollSide < 1.0F) this.field_146292_n.add(new JRMCoreGuiButtonsA1(-1, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 + 60, "v")); 
/* 224 */         this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiTop + 25, this.mousePressed, this.scrollSide, 1.0F));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 229 */       for (int i = this.scroll; i < ((size > this.scroll + sz) ? (this.scroll + sz) : size); i++) {
/* 230 */         String o = ((String)DBCH.wishS.get(i)).replace(";+;", ";+");
/* 231 */         int pos = i - this.scroll;
/* 232 */         if (o.contains(";+")) {
/* 233 */           String[] sa = o.split(";+");
/* 234 */           String in = sa[0];
/* 235 */           int iz = Integer.parseInt(sa[1]);
/* 236 */           int im = Integer.parseInt(sa[2]);
/* 237 */           Item item = JRMCoreH.getItemByText(in);
/*     */           
/* 239 */           if (item != null) {
/* 240 */             ItemStack is = new ItemStack(item, iz, im);
/* 241 */             String n = is.field_77994_a + " " + item.func_77653_i(is);
/* 242 */             int fn = var8.func_78256_a(n);
/* 243 */             this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n));
/*     */           }
/*     */         
/* 246 */         } else if (this.KiColorSlcted >= 0 && o.equals("kicolor")) {
/* 247 */           int col = (this.KiColorSlcted > 0) ? this.KiColorSlcted : 11075583;
/* 248 */           String n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o), new Object[0]);
/* 249 */           int fn = var8.func_78256_a(n);
/* 250 */           this.field_146292_n.add(new JRMCoreGuiButtons00(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n, col));
/*     */         } else {
/* 252 */           String op = ((o.equals("revive") || o.equals("reviventp")) && this.target.length() > 2) ? "S" : "";
/*     */           
/* 254 */           Object arg1 = op.equals("S") ? this.target : JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
/* 255 */           String n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o + op), new Object[] { arg1 });
/* 256 */           int fn = var8.func_78256_a(n);
/* 257 */           this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n));
/*     */         } 
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
/* 281 */     if (this.wish == 2) {
/* 282 */       tex = "jinryuudragonbc:wish2.png";
/* 283 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 284 */       ResourceLocation tx = new ResourceLocation(tex);
/* 285 */       this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 286 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 288 */       int j = 0;
/* 289 */       int i2 = 0;
/* 290 */       int a = JRMCoreH.Algnmnt(JRMCoreH.align);
/* 291 */       i2 = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragonp.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
/* 292 */       j += i2;
/*     */       
/* 294 */       int size = DBCH.wishP.size();
/*     */ 
/*     */       
/* 297 */       int m1 = size;
/* 298 */       float m2 = 5.0F;
/* 299 */       int sz = 6;
/* 300 */       this.scrollMouseJump = 1;
/* 301 */       if (m1 > sz)
/* 302 */       { if (m1 - m2 < this.scroll) {
/* 303 */           this.scroll = (int)(m1 - m2);
/* 304 */         } else if (this.scroll < 0) {
/* 305 */           this.scroll = 0;
/* 306 */         }  if (this.mousePressed && !JRMCoreGuiButtonsA1.clicked) {
/* 307 */           this.scroll = (int)((m1 - m2) * this.scrollSide);
/*     */         } else {
/* 309 */           this.scrollSide = JRMCoreGuiSliderX00.sliderValue = this.scroll / (m1 - m2);
/*     */         }  }
/* 311 */       else { this.scroll = 0; }
/*     */       
/* 313 */       if (m1 > sz) {
/* 314 */         if (this.scrollSide > 0.0F) this.field_146292_n.add(new JRMCoreGuiButtonsA1(-2, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 - 70, "i")); 
/* 315 */         if (this.scrollSide < 1.0F) this.field_146292_n.add(new JRMCoreGuiButtonsA1(-1, guiLeft + xSize / 2 + 110 + 18, guiTop + 80 + 60, "v")); 
/* 316 */         this.field_146292_n.add(new JRMCoreGuiSliderX00(1000000, guiLeft + xSize / 2 + 110 + 18, guiTop + 25, this.mousePressed, this.scrollSide, 1.0F));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 323 */       for (int i = this.scroll; i < ((size > this.scroll + sz) ? (this.scroll + sz) : size); i++) {
/* 324 */         String o = ((String)DBCH.wishP.get(i)).replace(";+;", ";+");
/* 325 */         int pos = i - this.scroll;
/* 326 */         if (o.contains(";+")) {
/* 327 */           String[] sa = o.split(";+");
/* 328 */           String in = sa[0];
/* 329 */           int iz = Integer.parseInt(sa[1]);
/* 330 */           int im = Integer.parseInt(sa[2]);
/* 331 */           Item item = JRMCoreH.getItemByText(in);
/* 332 */           if (item != null) {
/* 333 */             ItemStack is = new ItemStack(item, iz, im);
/* 334 */             String n = is.field_77994_a + " " + item.func_77653_i(is);
/* 335 */             int fn = var8.func_78256_a(n);
/* 336 */             this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n));
/*     */           }
/*     */         
/*     */         }
/* 340 */         else if (this.KiColorSlcted >= 0 && o.equals("kicolor")) {
/* 341 */           int col = (this.KiColorSlcted > 0) ? this.KiColorSlcted : 11075583;
/* 342 */           String n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o), new Object[0]);
/* 343 */           int fn = var8.func_78256_a(n);
/* 344 */           this.field_146292_n.add(new JRMCoreGuiButtons00(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n, col));
/*     */         } else {
/* 346 */           String op = ((o.equals("revive") || o.equals("reviventp")) && this.target.length() > 2) ? "S" : "";
/* 347 */           Object arg1 = op.equals("S") ? this.target : JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
/* 348 */           String n = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + o + op), new Object[] { arg1 });
/* 349 */           int fn = var8.func_78256_a(n);
/* 350 */           this.field_146292_n.add(new DBCGuiButtons01(i, posX - fn / 2 - 5, guiTop + 5 + pos * 21 + j * 10, fn + 10, 20, n));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 355 */     if (this.wish == 10) {
/* 356 */       tex = "jinryuudragonbc:wish.png";
/* 357 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 358 */       ResourceLocation tx = new ResourceLocation(tex);
/* 359 */       this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 360 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 362 */       int j = 0;
/* 363 */       int i2 = 0;
/* 364 */       int a = JRMCoreH.Algnmnt(JRMCoreH.align);
/* 365 */       i2 = JRMCoreH.txt(JRMCoreH.trl("dbc", "selectplayer"), JRMCoreH.clb, 0, true, guiLeft + 5, guiTop + 5 + j * 10, 175);
/* 366 */       j += i2;
/*     */       
/* 368 */       int i21 = 0;
/* 369 */       if (playerlist != null && playerlist.length > 0) {
/* 370 */         for (int i = 0; i < playerlist.length; i++) {
/* 371 */           if (i21 <= 14 + this.ipg * 14 && i21 >= 0 + this.ipg * 14) {
/* 372 */             String n = playerlist[i];
/* 373 */             this.field_146292_n.add(new JRMCoreGuiButtons01(1000 + i, guiLeft + xSize / 2 - 80, guiTop + (ySize + 1) / 2 - 84 + i21 * 10 - this.ipg * 14 * 10, this.field_146289_q.func_78256_a(n), n, 0));
/* 374 */             i21++;
/*     */           } 
/*     */         } 
/*     */       }
/* 378 */       if (JRMCoreH.plyrs.length > 14 + this.ipg * 14) {
/* 379 */         String n = JRMCoreH.trl("jrmc", "Next");
/* 380 */         this.field_146292_n.add(new JRMCoreGuiButtons00(-3, guiLeft + xSize / 2 + 100, guiTop + (ySize + 1) / 2 + 15, this.field_146289_q.func_78256_a(n) + 8, 20, n, 0));
/* 381 */       }  if (this.ipg != 0) {
/* 382 */         String p = JRMCoreH.trl("jrmc", "Prev"); int pw = this.field_146289_q.func_78256_a(p) + 8;
/* 383 */         this.field_146292_n.add(new JRMCoreGuiButtons00(-4, guiLeft + xSize / 2 - 100 - pw, guiTop + (ySize + 1) / 2 + 15, pw, 20, p, 0));
/*     */       } 
/* 385 */       String s = JRMCoreH.trl("jrmc", "Back"); int sw = this.field_146289_q.func_78256_a(s) + 8;
/* 386 */       this.field_146292_n.add(new JRMCoreGuiButtons00(-5, guiLeft + xSize / 2 - 100 - sw, guiTop + (ySize + 1) / 2 + 40, sw, 20, s, 0));
/*     */     } 
/*     */ 
/*     */     
/* 390 */     if (this.wish == 11) {
/* 391 */       tex = "jinryuudragonbc:wish.png";
/* 392 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 393 */       ResourceLocation tx = new ResourceLocation(tex);
/* 394 */       this.field_146297_k.field_71446_o.func_110577_a(tx);
/* 395 */       func_73729_b(guiLeft, guiTop, 0, 0, xSize, ySize);
/*     */       
/* 397 */       int a = 0;
/*     */       
/* 399 */       for (int X = 0; X < 128; X++) {
/* 400 */         for (int Y = 0; Y < 128; Y++) {
/*     */ 
/*     */ 
/*     */           
/* 404 */           Color i = Color.getHSBColor(X * 2.0F / 255.0F, Y * 2.0F / 255.0F, this.BrghtSlcted);
/* 405 */           int cc = i.getRed() * 65536 + i.getGreen() * 256 + i.getBlue();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 410 */           if (cc == 0) {
/*     */             
/* 412 */             a = 11075583;
/* 413 */             if (JRMCoreH.align <= 66 && JRMCoreH.align >= 33) a = 14526719; 
/* 414 */             if (JRMCoreH.align < 33) a = 16646144; 
/* 415 */             this.field_146292_n.add(new JRMCoreGuiButtonC(-21, guiLeft + 5 + X, guiTop + 5 + Y, 1, 1, "", cc, a));
/*     */           } else {
/* 417 */             this.field_146292_n.add(new JRMCoreGuiButtonC(-21, guiLeft + 5 + X, guiTop + 5 + Y, 1, 1, "", cc));
/*     */           } 
/*     */         } 
/* 420 */       }  if (this.BrghtSlcted == 0.0F) {
/* 421 */         var8.func_78276_b(JRMCoreH.trl("jrmc", "AlignmentBased"), guiLeft + 5, guiTop + 140, 0);
/*     */       }
/*     */       
/* 424 */       this.field_146292_n.add(new JRMCoreGuiSlider00(-20, guiLeft + 135, guiTop + 5, "", this.BrghtSlcted, 1.0F));
/*     */       
/* 426 */       String n = JRMCoreH.trl("jrmc", "Back"); int nw = this.field_146289_q.func_78256_a(n) + 8;
/* 427 */       this.field_146292_n.add(new JRMCoreGuiButtons00(-5, posX - 130 - nw, posY + 65, nw, 20, n, 0));
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
/* 440 */     super.func_73863_a(x, y, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 445 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCWishGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */