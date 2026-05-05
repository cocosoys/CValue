/*     */ package cpw.mods.fml.common.launcher;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.FMLLaunchHandler;
/*     */ import cpw.mods.fml.relauncher.FMLSecurityManager;
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.launchwrapper.ITweaker;
/*     */ import net.minecraft.launchwrapper.Launch;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLTweaker
/*     */   implements ITweaker
/*     */ {
/*     */   private File gameDir;
/*     */   private Map<String, String> launchArgs;
/*     */   private List<String> standaloneArgs;
/*     */   private static URI jarLocation;
/*     */   
/*     */   public FMLTweaker() {
/*  32 */     System.setProperty("java.net.preferIPv4Stack", "true");
/*     */     
/*     */     try {
/*  35 */       System.setSecurityManager((SecurityManager)new FMLSecurityManager());
/*     */     }
/*  37 */     catch (SecurityException se) {
/*     */       
/*  39 */       throw new RuntimeException("FML was unable to install the security manager. The game will not start", se);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
/*  46 */     this.gameDir = (gameDir == null) ? new File(".") : gameDir;
/*     */     
/*  48 */     this.launchArgs = (Map<String, String>)Launch.blackboard.get("launchArgs");
/*     */     
/*  50 */     this.standaloneArgs = Lists.newArrayList();
/*  51 */     if (this.launchArgs == null) {
/*     */       
/*  53 */       this.launchArgs = Maps.newHashMap();
/*  54 */       Launch.blackboard.put("launchArgs", this.launchArgs);
/*     */     } 
/*     */     
/*  57 */     String classifier = null;
/*     */     
/*  59 */     for (String arg : args) {
/*     */       
/*  61 */       if (arg.startsWith("-")) {
/*     */         
/*  63 */         if (classifier != null) {
/*     */           
/*  65 */           classifier = this.launchArgs.put(classifier, ""); continue;
/*     */         } 
/*  67 */         if (arg.contains("=")) {
/*     */           
/*  69 */           classifier = this.launchArgs.put(arg.substring(0, arg.indexOf('=')), arg.substring(arg.indexOf('=') + 1));
/*     */           
/*     */           continue;
/*     */         } 
/*  73 */         classifier = arg;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*  78 */       if (classifier != null) {
/*     */         
/*  80 */         classifier = this.launchArgs.put(classifier, arg);
/*     */         
/*     */         continue;
/*     */       } 
/*  84 */       this.standaloneArgs.add(arg);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (!this.launchArgs.containsKey("--version"))
/*     */     {
/*  91 */       this.launchArgs.put("--version", (profile != null) ? profile : "UnknownFMLProfile");
/*     */     }
/*     */     
/*  94 */     if (!this.launchArgs.containsKey("--gameDir") && gameDir != null)
/*     */     {
/*  96 */       this.launchArgs.put("--gameDir", gameDir.getAbsolutePath());
/*     */     }
/*     */     
/*  99 */     if (!this.launchArgs.containsKey("--assetsDir") && assetsDir != null)
/*     */     {
/* 101 */       this.launchArgs.put("--assetsDir", assetsDir.getAbsolutePath());
/*     */     }
/*     */     
/* 104 */     Yggdrasil.login(this.launchArgs);
/*     */ 
/*     */     
/*     */     try {
/* 108 */       jarLocation = getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
/*     */     }
/* 110 */     catch (URISyntaxException e) {
/*     */       
/* 112 */       LogManager.getLogger("FMLTWEAK").log(Level.ERROR, "Missing URI information for FML tweak");
/* 113 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void injectIntoClassLoader(LaunchClassLoader classLoader) {
/* 120 */     classLoader.addClassLoaderExclusion("org.apache.");
/* 121 */     classLoader.addClassLoaderExclusion("com.google.common.");
/* 122 */     classLoader.addTransformerExclusion("cpw.mods.fml.repackage.");
/* 123 */     classLoader.addTransformerExclusion("cpw.mods.fml.relauncher.");
/* 124 */     classLoader.addTransformerExclusion("cpw.mods.fml.common.asm.transformers.");
/* 125 */     classLoader.addClassLoaderExclusion("LZMA.");
/* 126 */     FMLLaunchHandler.configureForClientLaunch(classLoader, this);
/* 127 */     FMLLaunchHandler.appendCoreMods();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLaunchTarget() {
/* 135 */     Map<String, String> args = (Map<String, String>)Launch.blackboard.get("launchArgs");
/* 136 */     args.remove("--modListFile");
/* 137 */     args.remove("--mods");
/* 138 */     return "net.minecraft.client.main.Main";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getLaunchArguments() {
/* 144 */     List<String> args = Lists.newArrayList();
/* 145 */     args.addAll(this.standaloneArgs);
/*     */     
/* 147 */     for (Map.Entry<String, String> arg : this.launchArgs.entrySet()) {
/*     */       
/* 149 */       args.add(arg.getKey());
/* 150 */       args.add(arg.getValue());
/*     */     } 
/* 152 */     this.launchArgs.clear();
/*     */     
/* 154 */     return args.<String>toArray(new String[args.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public File getGameDir() {
/* 159 */     return this.gameDir;
/*     */   }
/*     */ 
/*     */   
/*     */   public static URI getJarLocation() {
/* 164 */     return jarLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void injectCascadingTweak(String tweakClassName) {
/* 170 */     List<String> tweakClasses = (List<String>)Launch.blackboard.get("TweakClasses");
/* 171 */     tweakClasses.add(tweakClassName);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\FMLTweaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */