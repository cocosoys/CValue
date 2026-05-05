/*     */ package net.minecraft.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.realms.RealmsBridge;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.demo.DemoWorldServer;
/*     */ import net.minecraft.world.storage.ISaveFormat;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GLContext;
/*     */ import org.lwjgl.util.glu.Project;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiMainMenu
/*     */   extends GuiScreen implements GuiYesNoCallback {
/*  35 */   private static final Logger field_146974_g = LogManager.getLogger();
/*  36 */   private static final Random field_73976_a = new Random();
/*     */ 
/*     */   
/*     */   private float field_73974_b;
/*     */ 
/*     */   
/*     */   private String field_73975_c;
/*     */ 
/*     */   
/*     */   private GuiButton field_73973_d;
/*     */ 
/*     */   
/*     */   private int field_73979_m;
/*     */ 
/*     */   
/*     */   private DynamicTexture field_73977_n;
/*     */ 
/*     */   
/*  54 */   private final Object field_104025_t = new Object();
/*     */   private String field_92025_p;
/*  56 */   private String field_146972_A = field_96138_a;
/*     */   
/*     */   private String field_104024_v;
/*  59 */   private static final ResourceLocation field_110353_x = new ResourceLocation("texts/splashes.txt");
/*  60 */   private static final ResourceLocation field_110352_y = new ResourceLocation("textures/gui/title/minecraft.png");
/*  61 */   private static final ResourceLocation[] field_73978_o = new ResourceLocation[] { new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png") };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
/*     */   
/*     */   private int field_92024_r;
/*     */   
/*     */   private int field_92023_s;
/*     */   
/*     */   private int field_92022_t;
/*     */   private int field_92021_u;
/*     */   
/*     */   public GuiMainMenu() {
/*  79 */     this.field_73975_c = "missingno";
/*     */     
/*  81 */     BufferedReader bufferedReader = null;
/*     */     
/*  83 */     try { ArrayList<String> arrayList = new ArrayList();
/*  84 */       bufferedReader = new BufferedReader(new InputStreamReader(Minecraft.func_71410_x().func_110442_L().func_110536_a(field_110353_x).func_110527_b(), Charsets.UTF_8));
/*     */       String str;
/*  86 */       while ((str = bufferedReader.readLine()) != null) {
/*  87 */         str = str.trim();
/*  88 */         if (!str.isEmpty()) {
/*  89 */           arrayList.add(str);
/*     */         }
/*     */       } 
/*     */       
/*  93 */       if (!arrayList.isEmpty()) {
/*     */         
/*     */         do {
/*     */           
/*  97 */           this.field_73975_c = arrayList.get(field_73976_a.nextInt(arrayList.size()));
/*  98 */         } while (this.field_73975_c.hashCode() == 125780783);
/*     */       } }
/* 100 */     catch (IOException iOException) {  }
/*     */     finally
/* 102 */     { if (bufferedReader != null) {
/*     */         try {
/* 104 */           bufferedReader.close();
/* 105 */         } catch (IOException iOException) {}
/*     */       } }
/*     */ 
/*     */ 
/*     */     
/* 110 */     this.field_73974_b = field_73976_a.nextFloat();
/*     */     
/* 112 */     this.field_92025_p = "";
/* 113 */     if (!(GLContext.getCapabilities()).OpenGL20 && !OpenGlHelper.func_153193_b()) {
/* 114 */       this.field_92025_p = I18n.func_135052_a("title.oldgl1", new Object[0]);
/* 115 */       this.field_146972_A = I18n.func_135052_a("title.oldgl2", new Object[0]);
/* 116 */       this.field_104024_v = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
/*     */     } 
/*     */   }
/*     */   private int field_92020_v; private int field_92019_w; private ResourceLocation field_110351_G; private static final String __OBFID = "CL_00001154";
/*     */   
/*     */   public void func_73876_c() {
/* 122 */     this.field_73979_m++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 136 */     this.field_73977_n = new DynamicTexture(256, 256);
/* 137 */     this.field_110351_G = this.field_146297_k.func_110434_K().func_110578_a("background", this.field_73977_n);
/*     */     
/* 139 */     Calendar calendar = Calendar.getInstance();
/* 140 */     calendar.setTime(new Date());
/*     */     
/* 142 */     if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
/* 143 */       this.field_73975_c = "Happy birthday, ez!";
/* 144 */     } else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
/* 145 */       this.field_73975_c = "Happy birthday, Notch!";
/* 146 */     } else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
/* 147 */       this.field_73975_c = "Merry X-mas!";
/* 148 */     } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
/* 149 */       this.field_73975_c = "Happy new year!";
/* 150 */     } else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31) {
/* 151 */       this.field_73975_c = "OOoooOOOoooo! Spooky!";
/*     */     } 
/*     */     
/* 154 */     byte b = 24;
/* 155 */     int i = this.field_146295_m / 4 + 48;
/*     */     
/* 157 */     if (this.field_146297_k.func_71355_q()) {
/* 158 */       func_73972_b(i, 24);
/*     */     } else {
/* 160 */       func_73969_a(i, 24);
/*     */     } 
/*     */     
/* 163 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 100, i + 72 + 12, 98, 20, I18n.func_135052_a("menu.options", new Object[0])));
/* 164 */     this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 + 2, i + 72 + 12, 98, 20, I18n.func_135052_a("menu.quit", new Object[0])));
/* 165 */     this.field_146292_n.add(new GuiButtonLanguage(5, this.field_146294_l / 2 - 124, i + 72 + 12));
/*     */     
/* 167 */     synchronized (this.field_104025_t) {
/* 168 */       this.field_92023_s = this.field_146289_q.func_78256_a(this.field_92025_p);
/* 169 */       this.field_92024_r = this.field_146289_q.func_78256_a(this.field_146972_A);
/*     */       
/* 171 */       int j = Math.max(this.field_92023_s, this.field_92024_r);
/* 172 */       this.field_92022_t = (this.field_146294_l - j) / 2;
/* 173 */       this.field_92021_u = ((GuiButton)this.field_146292_n.get(0)).field_146129_i - 24;
/* 174 */       this.field_92020_v = this.field_92022_t + j;
/* 175 */       this.field_92019_w = this.field_92021_u + 24;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_73969_a(int p_73969_1_, int p_73969_2_) {
/* 180 */     this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, p_73969_1_, I18n.func_135052_a("menu.singleplayer", new Object[0])));
/* 181 */     this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, p_73969_1_ + p_73969_2_ * 1, I18n.func_135052_a("menu.multiplayer", new Object[0])));
/* 182 */     this.field_146292_n.add(new GuiButton(14, this.field_146294_l / 2 - 100, p_73969_1_ + p_73969_2_ * 2, I18n.func_135052_a("menu.online", new Object[0])));
/*     */   }
/*     */   
/*     */   private void func_73972_b(int p_73972_1_, int p_73972_2_) {
/* 186 */     this.field_146292_n.add(new GuiButton(11, this.field_146294_l / 2 - 100, p_73972_1_, I18n.func_135052_a("menu.playdemo", new Object[0])));
/* 187 */     this.field_146292_n.add(this.field_73973_d = new GuiButton(12, this.field_146294_l / 2 - 100, p_73972_1_ + p_73972_2_ * 1, I18n.func_135052_a("menu.resetdemo", new Object[0])));
/*     */     
/* 189 */     ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 190 */     WorldInfo worldInfo = iSaveFormat.func_75803_c("Demo_World");
/* 191 */     if (worldInfo == null) {
/* 192 */       this.field_73973_d.field_146124_l = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 198 */     if (p_146284_1_.field_146127_k == 0) {
/* 199 */       this.field_146297_k.func_147108_a(new GuiOptions(this, this.field_146297_k.field_71474_y));
/*     */     }
/* 201 */     if (p_146284_1_.field_146127_k == 5) {
/* 202 */       this.field_146297_k.func_147108_a(new GuiLanguage(this, this.field_146297_k.field_71474_y, this.field_146297_k.func_135016_M()));
/*     */     }
/* 204 */     if (p_146284_1_.field_146127_k == 1) {
/* 205 */       this.field_146297_k.func_147108_a(new GuiSelectWorld(this));
/*     */     }
/* 207 */     if (p_146284_1_.field_146127_k == 2) {
/* 208 */       this.field_146297_k.func_147108_a(new GuiMultiplayer(this));
/*     */     }
/* 210 */     if (p_146284_1_.field_146127_k == 14) {
/* 211 */       func_140005_i();
/*     */     }
/* 213 */     if (p_146284_1_.field_146127_k == 4) {
/* 214 */       this.field_146297_k.func_71400_g();
/*     */     }
/* 216 */     if (p_146284_1_.field_146127_k == 11) {
/* 217 */       this.field_146297_k.func_71371_a("Demo_World", "Demo_World", DemoWorldServer.field_73071_a);
/*     */     }
/* 219 */     if (p_146284_1_.field_146127_k == 12) {
/* 220 */       ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 221 */       WorldInfo worldInfo = iSaveFormat.func_75803_c("Demo_World");
/* 222 */       if (worldInfo != null) {
/* 223 */         GuiYesNo guiYesNo = GuiSelectWorld.func_152129_a(this, worldInfo.func_76065_j(), 12);
/* 224 */         this.field_146297_k.func_147108_a(guiYesNo);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_140005_i() {
/* 230 */     RealmsBridge realmsBridge = new RealmsBridge();
/* 231 */     realmsBridge.switchToRealms(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 236 */     if (p_73878_1_ && p_73878_2_ == 12) {
/* 237 */       ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 238 */       iSaveFormat.func_75800_d();
/* 239 */       iSaveFormat.func_75802_e("Demo_World");
/*     */       
/* 241 */       this.field_146297_k.func_147108_a(this);
/* 242 */     } else if (p_73878_2_ == 13) {
/* 243 */       if (p_73878_1_) {
/*     */         try {
/* 245 */           Class<?> clazz = Class.forName("java.awt.Desktop");
/* 246 */           Object object = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 247 */           clazz.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { new URI(this.field_104024_v) });
/* 248 */         } catch (Throwable throwable) {
/* 249 */           field_146974_g.error("Couldn't open link", throwable);
/*     */         } 
/*     */       }
/*     */       
/* 253 */       this.field_146297_k.func_147108_a(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_73970_b(int p_73970_1_, int p_73970_2_, float p_73970_3_) {
/* 258 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 260 */     GL11.glMatrixMode(5889);
/* 261 */     GL11.glPushMatrix();
/* 262 */     GL11.glLoadIdentity();
/*     */     
/* 264 */     Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
/*     */     
/* 266 */     GL11.glMatrixMode(5888);
/* 267 */     GL11.glPushMatrix();
/* 268 */     GL11.glLoadIdentity();
/* 269 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 271 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 272 */     GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
/* 273 */     GL11.glEnable(3042);
/* 274 */     GL11.glDisable(3008);
/* 275 */     GL11.glDisable(2884);
/* 276 */     GL11.glDepthMask(false);
/* 277 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 278 */     byte b1 = 8;
/*     */     
/* 280 */     for (byte b2 = 0; b2 < b1 * b1; b2++) {
/* 281 */       GL11.glPushMatrix();
/* 282 */       float f1 = ((b2 % b1) / b1 - 0.5F) / 64.0F;
/* 283 */       float f2 = ((b2 / b1) / b1 - 0.5F) / 64.0F;
/* 284 */       float f3 = 0.0F;
/* 285 */       GL11.glTranslatef(f1, f2, f3);
/*     */       
/* 287 */       GL11.glRotatef(MathHelper.func_76126_a((this.field_73979_m + p_73970_3_) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
/* 288 */       GL11.glRotatef(-(this.field_73979_m + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 290 */       for (byte b = 0; b < 6; b++) {
/* 291 */         GL11.glPushMatrix();
/* 292 */         if (b == 1) GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); 
/* 293 */         if (b == 2) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F); 
/* 294 */         if (b == 3) GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F); 
/* 295 */         if (b == 4) GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F); 
/* 296 */         if (b == 5) GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F); 
/* 297 */         this.field_146297_k.func_110434_K().func_110577_a(field_73978_o[b]);
/* 298 */         tessellator.func_78382_b();
/* 299 */         tessellator.func_78384_a(16777215, 255 / (b2 + 1));
/* 300 */         float f = 0.0F;
/* 301 */         tessellator.func_78374_a(-1.0D, -1.0D, 1.0D, (0.0F + f), (0.0F + f));
/* 302 */         tessellator.func_78374_a(1.0D, -1.0D, 1.0D, (1.0F - f), (0.0F + f));
/* 303 */         tessellator.func_78374_a(1.0D, 1.0D, 1.0D, (1.0F - f), (1.0F - f));
/* 304 */         tessellator.func_78374_a(-1.0D, 1.0D, 1.0D, (0.0F + f), (1.0F - f));
/* 305 */         tessellator.func_78381_a();
/* 306 */         GL11.glPopMatrix();
/*     */       } 
/* 308 */       GL11.glPopMatrix();
/* 309 */       GL11.glColorMask(true, true, true, false);
/*     */     } 
/* 311 */     tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 312 */     GL11.glColorMask(true, true, true, true);
/*     */     
/* 314 */     GL11.glMatrixMode(5889);
/* 315 */     GL11.glPopMatrix();
/* 316 */     GL11.glMatrixMode(5888);
/* 317 */     GL11.glPopMatrix();
/* 318 */     GL11.glDepthMask(true);
/* 319 */     GL11.glEnable(2884);
/*     */     
/* 321 */     GL11.glEnable(2929);
/*     */   }
/*     */   
/*     */   private void func_73968_a(float p_73968_1_) {
/* 325 */     this.field_146297_k.func_110434_K().func_110577_a(this.field_110351_G);
/* 326 */     GL11.glTexParameteri(3553, 10241, 9729);
/* 327 */     GL11.glTexParameteri(3553, 10240, 9729);
/* 328 */     GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
/*     */     
/* 330 */     GL11.glEnable(3042);
/* 331 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 332 */     GL11.glColorMask(true, true, true, false);
/* 333 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 334 */     tessellator.func_78382_b();
/*     */     
/* 336 */     GL11.glDisable(3008);
/* 337 */     byte b1 = 3;
/* 338 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 339 */       tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F / (b2 + 1));
/* 340 */       int i = this.field_146294_l;
/* 341 */       int j = this.field_146295_m;
/* 342 */       float f = (b2 - b1 / 2) / 256.0F;
/* 343 */       tessellator.func_78374_a(i, j, this.field_73735_i, (0.0F + f), 1.0D);
/* 344 */       tessellator.func_78374_a(i, 0.0D, this.field_73735_i, (1.0F + f), 1.0D);
/* 345 */       tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, (1.0F + f), 0.0D);
/* 346 */       tessellator.func_78374_a(0.0D, j, this.field_73735_i, (0.0F + f), 0.0D);
/*     */     } 
/* 348 */     tessellator.func_78381_a();
/* 349 */     GL11.glEnable(3008);
/*     */     
/* 351 */     GL11.glColorMask(true, true, true, true);
/*     */   }
/*     */   
/*     */   private void func_73971_c(int p_73971_1_, int p_73971_2_, float p_73971_3_) {
/* 355 */     this.field_146297_k.func_147110_a().func_147609_e();
/* 356 */     GL11.glViewport(0, 0, 256, 256);
/* 357 */     func_73970_b(p_73971_1_, p_73971_2_, p_73971_3_);
/*     */     
/* 359 */     func_73968_a(p_73971_3_);
/* 360 */     func_73968_a(p_73971_3_);
/* 361 */     func_73968_a(p_73971_3_);
/* 362 */     func_73968_a(p_73971_3_);
/* 363 */     func_73968_a(p_73971_3_);
/* 364 */     func_73968_a(p_73971_3_);
/* 365 */     func_73968_a(p_73971_3_);
/* 366 */     this.field_146297_k.func_147110_a().func_147610_a(true);
/* 367 */     GL11.glViewport(0, 0, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*     */     
/* 369 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 370 */     tessellator.func_78382_b();
/*     */     
/* 372 */     float f1 = (this.field_146294_l > this.field_146295_m) ? (120.0F / this.field_146294_l) : (120.0F / this.field_146295_m);
/* 373 */     float f2 = this.field_146295_m * f1 / 256.0F;
/* 374 */     float f3 = this.field_146294_l * f1 / 256.0F;
/* 375 */     tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
/* 376 */     int i = this.field_146294_l;
/* 377 */     int j = this.field_146295_m;
/* 378 */     tessellator.func_78374_a(0.0D, j, this.field_73735_i, (0.5F - f2), (0.5F + f3));
/* 379 */     tessellator.func_78374_a(i, j, this.field_73735_i, (0.5F - f2), (0.5F - f3));
/* 380 */     tessellator.func_78374_a(i, 0.0D, this.field_73735_i, (0.5F + f2), (0.5F - f3));
/* 381 */     tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, (0.5F + f2), (0.5F + f3));
/* 382 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 387 */     GL11.glDisable(3008);
/* 388 */     func_73971_c(p_73863_1_, p_73863_2_, p_73863_3_);
/* 389 */     GL11.glEnable(3008);
/* 390 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 392 */     char c = 'Ē';
/* 393 */     int i = this.field_146294_l / 2 - c / 2;
/* 394 */     byte b = 30;
/*     */     
/* 396 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, -2130706433, 16777215);
/* 397 */     func_73733_a(0, 0, this.field_146294_l, this.field_146295_m, 0, -2147483648);
/*     */     
/* 399 */     this.field_146297_k.func_110434_K().func_110577_a(field_110352_y);
/* 400 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 402 */     if (this.field_73974_b < 1.0E-4D) {
/* 403 */       func_73729_b(i + 0, b + 0, 0, 0, 99, 44);
/* 404 */       func_73729_b(i + 99, b + 0, 129, 0, 27, 44);
/* 405 */       func_73729_b(i + 99 + 26, b + 0, 126, 0, 3, 44);
/* 406 */       func_73729_b(i + 99 + 26 + 3, b + 0, 99, 0, 26, 44);
/* 407 */       func_73729_b(i + 155, b + 0, 0, 45, 155, 44);
/*     */     } else {
/* 409 */       func_73729_b(i + 0, b + 0, 0, 0, 155, 44);
/* 410 */       func_73729_b(i + 155, b + 0, 0, 45, 155, 44);
/*     */     } 
/*     */     
/* 413 */     tessellator.func_78378_d(-1);
/* 414 */     GL11.glPushMatrix();
/* 415 */     GL11.glTranslatef((this.field_146294_l / 2 + 90), 70.0F, 0.0F);
/*     */     
/* 417 */     GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
/* 418 */     float f = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a((float)(Minecraft.func_71386_F() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
/*     */     
/* 420 */     f = f * 100.0F / (this.field_146289_q.func_78256_a(this.field_73975_c) + 32);
/* 421 */     GL11.glScalef(f, f, f);
/* 422 */     func_73732_a(this.field_146289_q, this.field_73975_c, 0, -8, -256);
/* 423 */     GL11.glPopMatrix();
/*     */     
/* 425 */     String str1 = "Minecraft 1.7.10";
/* 426 */     if (this.field_146297_k.func_71355_q()) {
/* 427 */       str1 = str1 + " Demo";
/*     */     }
/*     */     
/* 430 */     func_73731_b(this.field_146289_q, str1, 2, this.field_146295_m - 10, -1);
/* 431 */     String str2 = "Copyright Mojang AB. Do not distribute!";
/* 432 */     func_73731_b(this.field_146289_q, str2, this.field_146294_l - this.field_146289_q.func_78256_a(str2) - 2, this.field_146295_m - 10, -1);
/*     */     
/* 434 */     if (this.field_92025_p != null && this.field_92025_p.length() > 0) {
/* 435 */       func_73734_a(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
/*     */       
/* 437 */       func_73731_b(this.field_146289_q, this.field_92025_p, this.field_92022_t, this.field_92021_u, -1);
/* 438 */       func_73731_b(this.field_146289_q, this.field_146972_A, (this.field_146294_l - this.field_92024_r) / 2, ((GuiButton)this.field_146292_n.get(0)).field_146129_i - 12, -1);
/*     */     } 
/*     */     
/* 441 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 446 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */     
/* 448 */     synchronized (this.field_104025_t) {
/* 449 */       if (this.field_92025_p.length() > 0 && p_73864_1_ >= this.field_92022_t && p_73864_1_ <= this.field_92020_v && p_73864_2_ >= this.field_92021_u && p_73864_2_ <= this.field_92019_w) {
/* 450 */         GuiConfirmOpenLink guiConfirmOpenLink = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
/* 451 */         guiConfirmOpenLink.func_146358_g();
/* 452 */         this.field_146297_k.func_147108_a(guiConfirmOpenLink);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiMainMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */