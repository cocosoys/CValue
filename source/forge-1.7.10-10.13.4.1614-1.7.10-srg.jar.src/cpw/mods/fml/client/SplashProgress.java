/*     */ package cpw.mods.fml.client;
/*     */ 
/*     */ import cpw.mods.fml.common.EnhancedRuntimeException;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ICrashCallable;
/*     */ import cpw.mods.fml.common.ProgressManager;
/*     */ import cpw.mods.fml.common.asm.FMLSanityChecker;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.concurrent.Semaphore;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.FileResourcePack;
/*     */ import net.minecraft.client.resources.FolderResourcePack;
/*     */ import net.minecraft.client.resources.IResourcePack;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.launchwrapper.Launch;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.LWJGLException;
/*     */ import org.lwjgl.opengl.Display;
/*     */ import org.lwjgl.opengl.Drawable;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.SharedDrawable;
/*     */ import org.lwjgl.util.glu.GLU;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class SplashProgress
/*     */ {
/*     */   private static Drawable d;
/*     */   private static volatile boolean pause = false;
/*     */   private static volatile boolean done = false;
/*     */   private static Thread thread;
/*     */   private static volatile Throwable threadError;
/*  66 */   private static int angle = 0;
/*  67 */   private static final Lock lock = new ReentrantLock(true);
/*     */   
/*     */   private static SplashFontRenderer fontRenderer;
/*  70 */   private static final IResourcePack mcPack = (IResourcePack)(Minecraft.getMinecraft()).mcDefaultResourcePack;
/*  71 */   private static final IResourcePack fmlPack = createResourcePack(FMLSanityChecker.fmlLocation);
/*     */   
/*     */   private static IResourcePack miscPack;
/*     */   
/*     */   private static Texture fontTexture;
/*     */   
/*     */   private static Texture logoTexture;
/*     */   private static Texture forgeTexture;
/*     */   private static Properties config;
/*     */   private static boolean enabled;
/*     */   private static boolean rotate;
/*     */   private static int logoOffset;
/*     */   private static int backgroundColor;
/*     */   private static int fontColor;
/*     */   private static int barBorderColor;
/*     */   private static int barColor;
/*     */   private static int barBackgroundColor;
/*  88 */   static final Semaphore mutex = new Semaphore(1);
/*     */ 
/*     */   
/*     */   private static String getString(String name, String def) {
/*  92 */     String value = config.getProperty(name, def);
/*  93 */     config.setProperty(name, value);
/*  94 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean getBool(String name, boolean def) {
/*  99 */     return Boolean.parseBoolean(getString(name, Boolean.toString(def)));
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getInt(String name, int def) {
/* 104 */     return Integer.decode(getString(name, Integer.toString(def))).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getHex(String name, int def) {
/* 109 */     return Integer.decode(getString(name, "0x" + Integer.toString(def, 16).toUpperCase())).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void start() {
/* 114 */     File configFile = new File((Minecraft.getMinecraft()).mcDataDir, "config/splash.properties");
/* 115 */     FileReader r = null;
/* 116 */     config = new Properties();
/*     */     
/*     */     try {
/* 119 */       r = new FileReader(configFile);
/* 120 */       config.load(r);
/*     */     }
/* 122 */     catch (IOException e) {
/*     */       
/* 124 */       FMLLog.info("Could not load splash.properties, will create a default one", new Object[0]);
/*     */     }
/*     */     finally {
/*     */       
/* 128 */       IOUtils.closeQuietly(r);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 133 */     enabled = (getBool("enabled", true) && (!FMLClientHandler.instance().hasOptifine() || Launch.blackboard.containsKey("optifine.ForgeSplashCompatible")));
/* 134 */     rotate = getBool("rotate", false);
/* 135 */     logoOffset = getInt("logoOffset", 0);
/* 136 */     backgroundColor = getHex("background", 16777215);
/* 137 */     fontColor = getHex("font", 0);
/* 138 */     barBorderColor = getHex("barBorder", 12632256);
/* 139 */     barColor = getHex("bar", 13319477);
/* 140 */     barBackgroundColor = getHex("barBackground", 16777215);
/*     */     
/* 142 */     final ResourceLocation fontLoc = new ResourceLocation(getString("fontTexture", "textures/font/ascii.png"));
/* 143 */     final ResourceLocation logoLoc = new ResourceLocation(getString("logoTexture", "textures/gui/title/mojang.png"));
/* 144 */     final ResourceLocation forgeLoc = new ResourceLocation(getString("forgeTexture", "fml:textures/gui/forge.gif"));
/*     */     
/* 146 */     File miscPackFile = new File((Minecraft.getMinecraft()).mcDataDir, getString("resourcePackPath", "resources"));
/*     */     
/* 148 */     FileWriter w = null;
/*     */     
/*     */     try {
/* 151 */       w = new FileWriter(configFile);
/* 152 */       config.store(w, "Splash screen properties");
/*     */     }
/* 154 */     catch (IOException e) {
/*     */       
/* 156 */       FMLLog.log(Level.ERROR, e, "Could not save the splash.properties file", new Object[0]);
/*     */     }
/*     */     finally {
/*     */       
/* 160 */       IOUtils.closeQuietly(w);
/*     */     } 
/*     */     
/* 163 */     miscPack = createResourcePack(miscPackFile);
/*     */     
/* 165 */     if (!enabled)
/*     */       return; 
/* 167 */     FMLCommonHandler.instance().registerCrashCallable(new ICrashCallable()
/*     */         {
/*     */           public String call() throws Exception
/*     */           {
/* 171 */             return "' Vendor: '" + GL11.glGetString(7936) + "' Version: '" + 
/* 172 */               GL11.glGetString(7938) + "' Renderer: '" + 
/* 173 */               GL11.glGetString(7937) + "'";
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public String getLabel() {
/* 179 */             return "GL info";
/*     */           }
/*     */         });
/* 182 */     CrashReport report = CrashReport.makeCrashReport(new Throwable() {
/*     */           public String getMessage() {
/* 184 */             return "This is just a prompt for computer specs to be printed. THIS IS NOT A ERROR";
/* 185 */           } public void printStackTrace(PrintWriter s) { s.println(getMessage()); }
/* 186 */           public void printStackTrace(PrintStream s) { s.println(getMessage()); }
/*     */         },  "Loading screen debug info");
/* 188 */     System.out.println(report.getCompleteReport());
/*     */ 
/*     */     
/*     */     try {
/* 192 */       d = (Drawable)new SharedDrawable(Display.getDrawable());
/* 193 */       Display.getDrawable().releaseContext();
/* 194 */       d.makeCurrent();
/*     */     }
/* 196 */     catch (LWJGLException e) {
/*     */       
/* 198 */       e.printStackTrace();
/* 199 */       throw new RuntimeException(e);
/*     */     } 
/* 201 */     Thread mainThread = Thread.currentThread();
/* 202 */     thread = new Thread(new Runnable()
/*     */         {
/* 204 */           private final int barWidth = 400;
/* 205 */           private final int barHeight = 20;
/* 206 */           private final int textHeight2 = 20;
/* 207 */           private final int barOffset = 55;
/*     */ 
/*     */           
/*     */           public void run() {
/* 211 */             setGL();
/* 212 */             SplashProgress.fontTexture = new SplashProgress.Texture(fontLoc);
/* 213 */             SplashProgress.logoTexture = new SplashProgress.Texture(logoLoc);
/* 214 */             SplashProgress.forgeTexture = new SplashProgress.Texture(forgeLoc);
/* 215 */             GL11.glEnable(3553);
/* 216 */             SplashProgress.fontRenderer = new SplashProgress.SplashFontRenderer();
/* 217 */             GL11.glDisable(3553);
/* 218 */             while (!SplashProgress.done) {
/*     */               
/* 220 */               ProgressManager.ProgressBar first = null, penult = null, last = null;
/* 221 */               Iterator<ProgressManager.ProgressBar> i = ProgressManager.barIterator();
/* 222 */               while (i.hasNext()) {
/*     */                 
/* 224 */                 if (first == null) { first = i.next();
/*     */                   continue; }
/*     */                 
/* 227 */                 penult = last;
/* 228 */                 last = i.next();
/*     */               } 
/*     */ 
/*     */               
/* 232 */               GL11.glClear(16384);
/*     */ 
/*     */               
/* 235 */               int w = Display.getWidth();
/* 236 */               int h = Display.getHeight();
/* 237 */               GL11.glViewport(0, 0, w, h);
/* 238 */               GL11.glMatrixMode(5889);
/* 239 */               GL11.glLoadIdentity();
/* 240 */               GL11.glOrtho((320 - w / 2), (320 + w / 2), (240 + h / 2), (240 - h / 2), -1.0D, 1.0D);
/* 241 */               GL11.glMatrixMode(5888);
/* 242 */               GL11.glLoadIdentity();
/*     */ 
/*     */               
/* 245 */               setColor(SplashProgress.backgroundColor);
/* 246 */               GL11.glEnable(3553);
/* 247 */               SplashProgress.logoTexture.bind();
/* 248 */               GL11.glBegin(7);
/* 249 */               SplashProgress.logoTexture.texCoord(0, 0.0F, 0.0F);
/* 250 */               GL11.glVertex2f(64.0F, -16.0F);
/* 251 */               SplashProgress.logoTexture.texCoord(0, 0.0F, 1.0F);
/* 252 */               GL11.glVertex2f(64.0F, 496.0F);
/* 253 */               SplashProgress.logoTexture.texCoord(0, 1.0F, 1.0F);
/* 254 */               GL11.glVertex2f(576.0F, 496.0F);
/* 255 */               SplashProgress.logoTexture.texCoord(0, 1.0F, 0.0F);
/* 256 */               GL11.glVertex2f(576.0F, -16.0F);
/* 257 */               GL11.glEnd();
/* 258 */               GL11.glDisable(3553);
/*     */ 
/*     */               
/* 261 */               if (first != null) {
/*     */                 
/* 263 */                 GL11.glPushMatrix();
/* 264 */                 GL11.glTranslatef(120.0F, 310.0F, 0.0F);
/* 265 */                 drawBar(first);
/* 266 */                 if (penult != null) {
/*     */                   
/* 268 */                   GL11.glTranslatef(0.0F, 55.0F, 0.0F);
/* 269 */                   drawBar(penult);
/*     */                 } 
/* 271 */                 if (last != null) {
/*     */                   
/* 273 */                   GL11.glTranslatef(0.0F, 55.0F, 0.0F);
/* 274 */                   drawBar(last);
/*     */                 } 
/* 276 */                 GL11.glPopMatrix();
/*     */               } 
/*     */               
/* 279 */               SplashProgress.angle = SplashProgress.angle + 1;
/*     */ 
/*     */               
/* 282 */               setColor(SplashProgress.backgroundColor);
/* 283 */               float fw = SplashProgress.forgeTexture.getWidth() / 2.0F / 2.0F;
/* 284 */               float fh = SplashProgress.forgeTexture.getHeight() / 2.0F / 2.0F;
/* 285 */               if (SplashProgress.rotate) {
/*     */                 
/* 287 */                 float sh = Math.max(fw, fh);
/* 288 */                 GL11.glTranslatef((320 + w / 2) - sh - SplashProgress.logoOffset, (240 + h / 2) - sh - SplashProgress.logoOffset, 0.0F);
/* 289 */                 GL11.glRotatef(SplashProgress.angle, 0.0F, 0.0F, 1.0F);
/*     */               }
/*     */               else {
/*     */                 
/* 293 */                 GL11.glTranslatef((320 + w / 2) - fw - SplashProgress.logoOffset, (240 + h / 2) - fh - SplashProgress.logoOffset, 0.0F);
/*     */               } 
/* 295 */               int f = SplashProgress.angle / 10 % SplashProgress.forgeTexture.getFrames();
/* 296 */               GL11.glEnable(3553);
/* 297 */               SplashProgress.forgeTexture.bind();
/* 298 */               GL11.glBegin(7);
/* 299 */               SplashProgress.forgeTexture.texCoord(f, 0.0F, 0.0F);
/* 300 */               GL11.glVertex2f(-fw, -fh);
/* 301 */               SplashProgress.forgeTexture.texCoord(f, 0.0F, 1.0F);
/* 302 */               GL11.glVertex2f(-fw, fh);
/* 303 */               SplashProgress.forgeTexture.texCoord(f, 1.0F, 1.0F);
/* 304 */               GL11.glVertex2f(fw, fh);
/* 305 */               SplashProgress.forgeTexture.texCoord(f, 1.0F, 0.0F);
/* 306 */               GL11.glVertex2f(fw, -fh);
/* 307 */               GL11.glEnd();
/* 308 */               GL11.glDisable(3553);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 315 */               SplashProgress.mutex.acquireUninterruptibly();
/* 316 */               Display.update();
/*     */ 
/*     */               
/* 319 */               SplashProgress.mutex.release();
/* 320 */               if (SplashProgress.pause) {
/*     */                 
/* 322 */                 clearGL();
/* 323 */                 setGL();
/*     */               } 
/* 325 */               Display.sync(100);
/*     */             } 
/* 327 */             clearGL();
/*     */           }
/*     */ 
/*     */           
/*     */           private void setColor(int color) {
/* 332 */             GL11.glColor3ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color & 0xFF));
/*     */           }
/*     */ 
/*     */           
/*     */           private void drawBox(int w, int h) {
/* 337 */             GL11.glBegin(7);
/* 338 */             GL11.glVertex2f(0.0F, 0.0F);
/* 339 */             GL11.glVertex2f(0.0F, h);
/* 340 */             GL11.glVertex2f(w, h);
/* 341 */             GL11.glVertex2f(w, 0.0F);
/* 342 */             GL11.glEnd();
/*     */           }
/*     */ 
/*     */           
/*     */           private void drawBar(ProgressManager.ProgressBar b) {
/* 347 */             GL11.glPushMatrix();
/*     */             
/* 349 */             setColor(SplashProgress.fontColor);
/* 350 */             GL11.glScalef(2.0F, 2.0F, 1.0F);
/* 351 */             GL11.glEnable(3553);
/* 352 */             SplashProgress.fontRenderer.drawString(b.getTitle() + " - " + b.getMessage(), 0, 0, 0);
/* 353 */             GL11.glDisable(3553);
/* 354 */             GL11.glPopMatrix();
/*     */             
/* 356 */             GL11.glPushMatrix();
/* 357 */             GL11.glTranslatef(0.0F, 20.0F, 0.0F);
/* 358 */             setColor(SplashProgress.barBorderColor);
/* 359 */             drawBox(400, 20);
/*     */             
/* 361 */             setColor(SplashProgress.barBackgroundColor);
/* 362 */             GL11.glTranslatef(1.0F, 1.0F, 0.0F);
/* 363 */             drawBox(398, 18);
/*     */             
/* 365 */             setColor(SplashProgress.barColor);
/* 366 */             drawBox(398 * (b.getStep() + 1) / (b.getSteps() + 1), 18);
/*     */             
/* 368 */             String progress = "" + b.getStep() + "/" + b.getSteps();
/* 369 */             GL11.glTranslatef(199.0F - SplashProgress.fontRenderer.getStringWidth(progress), 2.0F, 0.0F);
/* 370 */             setColor(SplashProgress.fontColor);
/* 371 */             GL11.glScalef(2.0F, 2.0F, 1.0F);
/* 372 */             GL11.glEnable(3553);
/* 373 */             SplashProgress.fontRenderer.drawString(progress, 0, 0, 0);
/* 374 */             GL11.glPopMatrix();
/*     */           }
/*     */ 
/*     */           
/*     */           private void setGL() {
/* 379 */             SplashProgress.lock.lock();
/*     */             
/*     */             try {
/* 382 */               Display.getDrawable().makeCurrent();
/*     */             }
/* 384 */             catch (LWJGLException e) {
/*     */               
/* 386 */               e.printStackTrace();
/* 387 */               throw new RuntimeException(e);
/*     */             } 
/* 389 */             GL11.glClearColor((SplashProgress.backgroundColor >> 16 & 0xFF) / 255.0F, (SplashProgress.backgroundColor >> 8 & 0xFF) / 255.0F, (SplashProgress.backgroundColor & 0xFF) / 255.0F, 1.0F);
/* 390 */             GL11.glDisable(2896);
/* 391 */             GL11.glDisable(2929);
/* 392 */             GL11.glEnable(3042);
/* 393 */             GL11.glBlendFunc(770, 771);
/*     */           }
/*     */ 
/*     */           
/*     */           private void clearGL() {
/* 398 */             Minecraft mc = Minecraft.getMinecraft();
/* 399 */             mc.displayWidth = Display.getWidth();
/* 400 */             mc.displayHeight = Display.getHeight();
/* 401 */             mc.resize(mc.displayWidth, mc.displayHeight);
/* 402 */             GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
/* 403 */             GL11.glEnable(2929);
/* 404 */             GL11.glDepthFunc(515);
/* 405 */             GL11.glEnable(3008);
/* 406 */             GL11.glAlphaFunc(516, 0.1F);
/*     */             
/*     */             try {
/* 409 */               Display.getDrawable().releaseContext();
/*     */             }
/* 411 */             catch (LWJGLException e) {
/*     */               
/* 413 */               e.printStackTrace();
/* 414 */               throw new RuntimeException(e);
/*     */             }
/*     */             finally {
/*     */               
/* 418 */               SplashProgress.lock.unlock();
/*     */             } 
/*     */           }
/*     */         });
/* 422 */     thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */         {
/*     */           public void uncaughtException(Thread t, Throwable e)
/*     */           {
/* 426 */             FMLLog.log(Level.ERROR, e, "Splash thread Exception", new Object[0]);
/* 427 */             SplashProgress.threadError = e;
/*     */           }
/*     */         });
/* 430 */     thread.start();
/* 431 */     checkThreadState();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void checkThreadState() {
/* 436 */     if (thread.getState() == Thread.State.TERMINATED || threadError != null)
/*     */     {
/* 438 */       throw new IllegalStateException("Splash thread", threadError);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void pause() {
/* 450 */     if (!enabled)
/* 451 */       return;  checkThreadState();
/* 452 */     pause = true;
/* 453 */     lock.lock();
/*     */     
/*     */     try {
/* 456 */       d.releaseContext();
/* 457 */       Display.getDrawable().makeCurrent();
/*     */     }
/* 459 */     catch (LWJGLException e) {
/*     */       
/* 461 */       e.printStackTrace();
/* 462 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void resume() {
/* 472 */     if (!enabled)
/* 473 */       return;  checkThreadState();
/* 474 */     pause = false;
/*     */     
/*     */     try {
/* 477 */       Display.getDrawable().releaseContext();
/* 478 */       d.makeCurrent();
/*     */     }
/* 480 */     catch (LWJGLException e) {
/*     */       
/* 482 */       e.printStackTrace();
/* 483 */       throw new RuntimeException(e);
/*     */     } 
/* 485 */     lock.unlock();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void finish() {
/* 490 */     if (!enabled)
/*     */       return; 
/*     */     try {
/* 493 */       checkThreadState();
/* 494 */       done = true;
/* 495 */       thread.join();
/* 496 */       d.releaseContext();
/* 497 */       Display.getDrawable().makeCurrent();
/* 498 */       fontTexture.delete();
/* 499 */       logoTexture.delete();
/* 500 */       forgeTexture.delete();
/*     */     }
/* 502 */     catch (Exception e) {
/*     */       
/* 504 */       e.printStackTrace();
/* 505 */       if (disableSplash())
/*     */       {
/* 507 */         throw new EnhancedRuntimeException(e)
/*     */           {
/*     */             
/*     */             protected void printStackTrace(EnhancedRuntimeException.WrappedPrintStream stream)
/*     */             {
/* 512 */               stream.println("SplashProgress has detected a error loading Minecraft.");
/* 513 */               stream.println("This can sometimes be caused by bad video drivers.");
/* 514 */               stream.println("We have automatically disabeled the new Splash Screen in config/splash.properties.");
/* 515 */               stream.println("Try reloading minecraft before reporting any errors.");
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */       
/* 521 */       throw new EnhancedRuntimeException(e)
/*     */         {
/*     */           
/*     */           protected void printStackTrace(EnhancedRuntimeException.WrappedPrintStream stream)
/*     */           {
/* 526 */             stream.println("SplashProgress has detected a error loading Minecraft.");
/* 527 */             stream.println("This can sometimes be caused by bad video drivers.");
/* 528 */             stream.println("Please try disabeling the new Splash Screen in config/splash.properties.");
/* 529 */             stream.println("After doing so, try reloading minecraft before reporting any errors.");
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean disableSplash() {
/* 538 */     File configFile = new File((Minecraft.getMinecraft()).mcDataDir, "config/splash.properties");
/* 539 */     File parent = configFile.getParentFile();
/* 540 */     if (!parent.exists()) {
/* 541 */       parent.mkdirs();
/*     */     }
/* 543 */     FileReader r = null;
/* 544 */     enabled = false;
/* 545 */     config.setProperty("enabled", "false");
/*     */     
/* 547 */     FileWriter w = null;
/*     */     
/*     */     try {
/* 550 */       w = new FileWriter(configFile);
/* 551 */       config.store(w, "Splash screen properties");
/*     */     }
/* 553 */     catch (IOException e) {
/*     */       
/* 555 */       FMLLog.log(Level.ERROR, e, "Could not save the splash.properties file", new Object[0]);
/* 556 */       return false;
/*     */     }
/*     */     finally {
/*     */       
/* 560 */       IOUtils.closeQuietly(w);
/*     */     } 
/* 562 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static IResourcePack createResourcePack(File file) {
/* 567 */     if (file.isDirectory())
/*     */     {
/* 569 */       return (IResourcePack)new FolderResourcePack(file);
/*     */     }
/*     */ 
/*     */     
/* 573 */     return (IResourcePack)new FileResourcePack(file);
/*     */   }
/*     */ 
/*     */   
/* 577 */   private static final IntBuffer buf = BufferUtils.createIntBuffer(4194304);
/*     */ 
/*     */   
/*     */   private static class Texture
/*     */   {
/*     */     private final ResourceLocation location;
/*     */     private final int name;
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final int frames;
/*     */     private final int size;
/*     */     
/*     */     public Texture(ResourceLocation location) {
/* 590 */       InputStream s = null;
/*     */       
/*     */       try {
/* 593 */         this.location = location;
/* 594 */         s = SplashProgress.open(location);
/* 595 */         ImageInputStream stream = ImageIO.createImageInputStream(s);
/* 596 */         Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
/* 597 */         if (!readers.hasNext()) throw new IOException("No suitable reader found for image" + location); 
/* 598 */         ImageReader reader = readers.next();
/* 599 */         reader.setInput(stream);
/* 600 */         this.frames = reader.getNumImages(true);
/* 601 */         BufferedImage[] images = new BufferedImage[this.frames];
/* 602 */         for (int i = 0; i < this.frames; i++)
/*     */         {
/* 604 */           images[i] = reader.read(i);
/*     */         }
/* 606 */         reader.dispose();
/* 607 */         int size = 1;
/* 608 */         this.width = images[0].getWidth();
/* 609 */         this.height = images[0].getHeight();
/* 610 */         for (; size / this.width * size / this.height < this.frames; size *= 2);
/* 611 */         this.size = size;
/* 612 */         GL11.glEnable(3553);
/* 613 */         synchronized (SplashProgress.class) {
/*     */           
/* 615 */           this.name = GL11.glGenTextures();
/* 616 */           GL11.glBindTexture(3553, this.name);
/*     */         } 
/* 618 */         GL11.glTexParameteri(3553, 10241, 9728);
/* 619 */         GL11.glTexParameteri(3553, 10240, 9728);
/* 620 */         GL11.glTexImage2D(3553, 0, 6408, size, size, 0, 32993, 33639, (IntBuffer)null);
/* 621 */         SplashProgress.checkGLError("Texture creation");
/* 622 */         for (int j = 0; j * size / this.width < this.frames; j++) {
/*     */           
/* 624 */           for (int k = 0; j * size / this.width + k < this.frames && k < size / this.width; k++) {
/*     */             
/* 626 */             SplashProgress.buf.clear();
/* 627 */             BufferedImage image = images[j * size / this.width + k];
/* 628 */             for (int m = 0; m < this.height; m++) {
/*     */               
/* 630 */               for (int l = 0; l < this.width; l++)
/*     */               {
/* 632 */                 SplashProgress.buf.put(image.getRGB(l, m));
/*     */               }
/*     */             } 
/* 635 */             SplashProgress.buf.position(0).limit(this.width * this.height);
/* 636 */             GL11.glTexSubImage2D(3553, 0, k * this.width, j * this.height, this.width, this.height, 32993, 33639, SplashProgress.buf);
/* 637 */             SplashProgress.checkGLError("Texture uploading");
/*     */           } 
/*     */         } 
/* 640 */         GL11.glBindTexture(3553, 0);
/* 641 */         GL11.glDisable(3553);
/*     */       }
/* 643 */       catch (IOException e) {
/*     */         
/* 645 */         e.printStackTrace();
/* 646 */         throw new RuntimeException(e);
/*     */       }
/*     */       finally {
/*     */         
/* 650 */         IOUtils.closeQuietly(s);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ResourceLocation getLocation() {
/* 656 */       return this.location;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getName() {
/* 661 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getWidth() {
/* 666 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getHeight() {
/* 671 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getFrames() {
/* 676 */       return this.frames;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 681 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public void bind() {
/* 686 */       GL11.glBindTexture(3553, this.name);
/*     */     }
/*     */ 
/*     */     
/*     */     public void delete() {
/* 691 */       GL11.glDeleteTextures(this.name);
/*     */     }
/*     */ 
/*     */     
/*     */     public float getU(int frame, float u) {
/* 696 */       return this.width * ((frame % this.size / this.width) + u) / this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public float getV(int frame, float v) {
/* 701 */       return this.height * ((frame / this.size / this.width) + v) / this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public void texCoord(int frame, float u, float v) {
/* 706 */       GL11.glTexCoord2f(getU(frame, u), getV(frame, v));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SplashFontRenderer
/*     */     extends FontRenderer
/*     */   {
/*     */     public SplashFontRenderer() {
/* 714 */       super((Minecraft.getMinecraft()).gameSettings, SplashProgress.fontTexture.getLocation(), null, false);
/* 715 */       onResourceManagerReload(null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void bindTexture(ResourceLocation location) {
/* 721 */       if (location != this.locationFontTexture) throw new IllegalArgumentException(); 
/* 722 */       SplashProgress.fontTexture.bind();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected InputStream getResourceInputStream(ResourceLocation location) throws IOException {
/* 728 */       return (Minecraft.getMinecraft()).mcDefaultResourcePack.getInputStream(location);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawVanillaScreen() throws LWJGLException {
/* 734 */     if (!enabled)
/*     */     {
/* 736 */       Minecraft.getMinecraft().loadScreen();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void clearVanillaResources(TextureManager renderEngine, ResourceLocation mojangLogo) {
/* 742 */     if (!enabled)
/*     */     {
/* 744 */       renderEngine.deleteTexture(mojangLogo);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkGLError(String where) {
/* 750 */     int err = GL11.glGetError();
/* 751 */     if (err != 0)
/*     */     {
/* 753 */       throw new IllegalStateException(where + ": " + GLU.gluErrorString(err));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static InputStream open(ResourceLocation loc) throws IOException {
/* 759 */     if (miscPack.resourceExists(loc))
/*     */     {
/* 761 */       return miscPack.getInputStream(loc);
/*     */     }
/* 763 */     if (fmlPack.resourceExists(loc))
/*     */     {
/* 765 */       return fmlPack.getInputStream(loc);
/*     */     }
/* 767 */     return mcPack.getInputStream(loc);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\SplashProgress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */