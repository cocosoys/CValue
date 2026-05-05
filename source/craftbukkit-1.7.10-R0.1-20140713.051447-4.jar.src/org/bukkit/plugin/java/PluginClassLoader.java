/*     */ package org.bukkit.plugin.java;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.plugin.InvalidPluginException;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PluginClassLoader
/*     */   extends URLClassLoader
/*     */ {
/*     */   private final JavaPluginLoader loader;
/*  20 */   private final Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
/*     */   private final PluginDescriptionFile description;
/*     */   private final File dataFolder;
/*     */   private final File file;
/*     */   final JavaPlugin plugin;
/*     */   private JavaPlugin pluginInit;
/*     */   private IllegalStateException pluginState;
/*     */   
/*     */   PluginClassLoader(JavaPluginLoader loader, ClassLoader parent, PluginDescriptionFile description, File dataFolder, File file) throws InvalidPluginException, MalformedURLException {
/*  29 */     super(new URL[] { file.toURI().toURL() }, parent);
/*  30 */     Validate.notNull(loader, "Loader cannot be null");
/*     */     
/*  32 */     this.loader = loader;
/*  33 */     this.description = description;
/*  34 */     this.dataFolder = dataFolder;
/*  35 */     this.file = file;
/*     */     try {
/*     */       Class<?> jarClass;
/*     */       Class<? extends JavaPlugin> pluginClass;
/*     */       try {
/*  40 */         jarClass = Class.forName(description.getMain(), true, this);
/*  41 */       } catch (ClassNotFoundException ex) {
/*  42 */         throw new InvalidPluginException("Cannot find main class `" + description.getMain() + "'", ex);
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/*  47 */         pluginClass = jarClass.asSubclass(JavaPlugin.class);
/*  48 */       } catch (ClassCastException ex) {
/*  49 */         throw new InvalidPluginException("main class `" + description.getMain() + "' does not extend JavaPlugin", ex);
/*     */       } 
/*     */       
/*  52 */       this.plugin = pluginClass.newInstance();
/*  53 */     } catch (IllegalAccessException ex) {
/*  54 */       throw new InvalidPluginException("No public constructor", ex);
/*  55 */     } catch (InstantiationException ex) {
/*  56 */       throw new InvalidPluginException("Abnormal plugin type", ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Class<?> findClass(String name) throws ClassNotFoundException {
/*  62 */     return findClass(name, true);
/*     */   }
/*     */   
/*     */   Class<?> findClass(String name, boolean checkGlobal) throws ClassNotFoundException {
/*  66 */     if (name.startsWith("org.bukkit.") || name.startsWith("net.minecraft.")) {
/*  67 */       throw new ClassNotFoundException(name);
/*     */     }
/*  69 */     Class<?> result = this.classes.get(name);
/*     */     
/*  71 */     if (result == null) {
/*  72 */       if (checkGlobal) {
/*  73 */         result = this.loader.getClassByName(name);
/*     */       }
/*     */       
/*  76 */       if (result == null) {
/*  77 */         result = super.findClass(name);
/*     */         
/*  79 */         if (result != null) {
/*  80 */           this.loader.setClass(name, result);
/*     */         }
/*     */       } 
/*     */       
/*  84 */       this.classes.put(name, result);
/*     */     } 
/*     */     
/*  87 */     return result;
/*     */   }
/*     */   
/*     */   Set<String> getClasses() {
/*  91 */     return this.classes.keySet();
/*     */   }
/*     */   
/*     */   synchronized void initialize(JavaPlugin javaPlugin) {
/*  95 */     Validate.notNull(javaPlugin, "Initializing plugin cannot be null");
/*  96 */     Validate.isTrue((javaPlugin.getClass().getClassLoader() == this), "Cannot initialize plugin outside of this class loader");
/*  97 */     if (this.plugin != null || this.pluginInit != null) {
/*  98 */       throw new IllegalArgumentException("Plugin already initialized!", this.pluginState);
/*     */     }
/*     */     
/* 101 */     this.pluginState = new IllegalStateException("Initial initialization");
/* 102 */     this.pluginInit = javaPlugin;
/*     */     
/* 104 */     javaPlugin.init(this.loader, this.loader.server, this.description, this.dataFolder, this.file, this);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\java\PluginClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */