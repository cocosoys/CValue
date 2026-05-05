/*     */ package cpw.mods.fml.relauncher;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.common.launcher.FMLTweaker;
/*     */ import java.io.File;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLLaunchHandler
/*     */ {
/*     */   private static FMLLaunchHandler INSTANCE;
/*     */   static Side side;
/*     */   private LaunchClassLoader classLoader;
/*     */   private FMLTweaker tweaker;
/*     */   private File minecraftHome;
/*     */   
/*     */   public static void configureForClientLaunch(LaunchClassLoader loader, FMLTweaker tweaker) {
/*  34 */     instance(loader, tweaker).setupClient();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void configureForServerLaunch(LaunchClassLoader loader, FMLTweaker tweaker) {
/*  39 */     instance(loader, tweaker).setupServer();
/*     */   }
/*     */ 
/*     */   
/*     */   private static FMLLaunchHandler instance(LaunchClassLoader launchLoader, FMLTweaker tweaker) {
/*  44 */     if (INSTANCE == null)
/*     */     {
/*  46 */       INSTANCE = new FMLLaunchHandler(launchLoader, tweaker);
/*     */     }
/*  48 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private FMLLaunchHandler(LaunchClassLoader launchLoader, FMLTweaker tweaker) {
/*  54 */     this.classLoader = launchLoader;
/*  55 */     this.tweaker = tweaker;
/*  56 */     this.minecraftHome = tweaker.getGameDir();
/*  57 */     this.classLoader.addClassLoaderExclusion("cpw.mods.fml.relauncher.");
/*  58 */     this.classLoader.addClassLoaderExclusion("net.minecraftforge.classloading.");
/*  59 */     this.classLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.deobf.");
/*  60 */     this.classLoader.addTransformerExclusion("cpw.mods.fml.common.patcher.");
/*     */   }
/*     */ 
/*     */   
/*     */   private void setupClient() {
/*  65 */     FMLRelaunchLog.side = Side.CLIENT;
/*  66 */     side = Side.CLIENT;
/*  67 */     setupHome();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setupServer() {
/*  72 */     FMLRelaunchLog.side = Side.SERVER;
/*  73 */     side = Side.SERVER;
/*  74 */     setupHome();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setupHome() {
/*  80 */     FMLInjectionData.build(this.minecraftHome, this.classLoader);
/*  81 */     FMLRelaunchLog.minecraftHome = this.minecraftHome;
/*  82 */     FMLRelaunchLog.info("Forge Mod Loader version %s.%s.%s.%s for Minecraft %s loading", new Object[] { FMLInjectionData.major, FMLInjectionData.minor, FMLInjectionData.rev, FMLInjectionData.build, FMLInjectionData.mccversion, FMLInjectionData.mcpversion });
/*     */     
/*  84 */     FMLRelaunchLog.info("Java is %s, version %s, running on %s:%s:%s, installed at %s", new Object[] { System.getProperty("java.vm.name"), System.getProperty("java.version"), System.getProperty("os.name"), System.getProperty("os.arch"), System.getProperty("os.version"), System.getProperty("java.home") });
/*  85 */     FMLRelaunchLog.fine("Java classpath at launch is %s", new Object[] { System.getProperty("java.class.path") });
/*  86 */     FMLRelaunchLog.fine("Java library path at launch is %s", new Object[] { System.getProperty("java.library.path") });
/*     */ 
/*     */     
/*     */     try {
/*  90 */       CoreModManager.handleLaunch(this.minecraftHome, this.classLoader, this.tweaker);
/*     */     }
/*  92 */     catch (Throwable t) {
/*     */       
/*  94 */       t.printStackTrace();
/*  95 */       FMLRelaunchLog.log(Level.ERROR, t, "An error occurred trying to configure the minecraft home at %s for Forge Mod Loader", new Object[] { this.minecraftHome.getAbsolutePath() });
/*  96 */       throw Throwables.propagate(t);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Side side() {
/* 102 */     return side;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void injectPostfixTransformers() {
/* 108 */     CoreModManager.injectTransformers(this.classLoader);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void appendCoreMods() {
/* 113 */     INSTANCE.injectPostfixTransformers();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FMLLaunchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */