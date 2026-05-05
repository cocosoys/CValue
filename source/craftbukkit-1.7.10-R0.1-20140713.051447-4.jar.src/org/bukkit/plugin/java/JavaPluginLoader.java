/*     */ package org.bukkit.plugin.java;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.logging.Level;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Warning;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerializable;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerialization;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.EventException;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.server.PluginDisableEvent;
/*     */ import org.bukkit.event.server.PluginEnableEvent;
/*     */ import org.bukkit.plugin.AuthorNagException;
/*     */ import org.bukkit.plugin.EventExecutor;
/*     */ import org.bukkit.plugin.InvalidDescriptionException;
/*     */ import org.bukkit.plugin.InvalidPluginException;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ import org.bukkit.plugin.PluginLoader;
/*     */ import org.bukkit.plugin.RegisteredListener;
/*     */ import org.bukkit.plugin.TimedRegisteredListener;
/*     */ import org.bukkit.plugin.UnknownDependencyException;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JavaPluginLoader
/*     */   implements PluginLoader
/*     */ {
/*     */   final Server server;
/*  49 */   private final Pattern[] fileFilters = new Pattern[] { Pattern.compile("\\.jar$") };
/*  50 */   private final Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
/*  51 */   private final Map<String, PluginClassLoader> loaders = new LinkedHashMap<String, PluginClassLoader>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public JavaPluginLoader(Server instance) {
/*  58 */     Validate.notNull(instance, "Server cannot be null");
/*  59 */     this.server = instance;
/*     */   } public Plugin loadPlugin(File file) throws InvalidPluginException {
/*     */     PluginDescriptionFile description;
/*     */     PluginClassLoader loader;
/*  63 */     Validate.notNull(file, "File cannot be null");
/*     */     
/*  65 */     if (!file.exists()) {
/*  66 */       throw new InvalidPluginException(new FileNotFoundException(file.getPath() + " does not exist"));
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  71 */       description = getPluginDescription(file);
/*  72 */     } catch (InvalidDescriptionException ex) {
/*  73 */       throw new InvalidPluginException(ex);
/*     */     } 
/*     */     
/*  76 */     File parentFile = file.getParentFile();
/*  77 */     File dataFolder = new File(parentFile, description.getName());
/*     */     
/*  79 */     File oldDataFolder = new File(parentFile, description.getRawName());
/*     */ 
/*     */     
/*  82 */     if (!dataFolder.equals(oldDataFolder))
/*     */     {
/*  84 */       if (dataFolder.isDirectory() && oldDataFolder.isDirectory()) {
/*  85 */         this.server.getLogger().warning(String.format("While loading %s (%s) found old-data folder: `%s' next to the new one `%s'", new Object[] { description.getFullName(), file, oldDataFolder, dataFolder }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*  92 */       else if (oldDataFolder.isDirectory() && !dataFolder.exists()) {
/*  93 */         if (!oldDataFolder.renameTo(dataFolder)) {
/*  94 */           throw new InvalidPluginException("Unable to rename old data folder: `" + oldDataFolder + "' to: `" + dataFolder + "'");
/*     */         }
/*  96 */         this.server.getLogger().log(Level.INFO, String.format("While loading %s (%s) renamed data folder: `%s' to `%s'", new Object[] { description.getFullName(), file, oldDataFolder, dataFolder }));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (dataFolder.exists() && !dataFolder.isDirectory()) {
/* 106 */       throw new InvalidPluginException(String.format("Projected datafolder: `%s' for %s (%s) exists and is not a directory", new Object[] { dataFolder, description.getFullName(), file }));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     for (String pluginName : description.getDepend()) {
/* 115 */       if (this.loaders == null) {
/* 116 */         throw new UnknownDependencyException(pluginName);
/*     */       }
/* 118 */       PluginClassLoader current = this.loaders.get(pluginName);
/*     */       
/* 120 */       if (current == null) {
/* 121 */         throw new UnknownDependencyException(pluginName);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 127 */       loader = new PluginClassLoader(this, getClass().getClassLoader(), description, dataFolder, file);
/* 128 */     } catch (InvalidPluginException ex) {
/* 129 */       throw ex;
/* 130 */     } catch (Throwable ex) {
/* 131 */       throw new InvalidPluginException(ex);
/*     */     } 
/*     */     
/* 134 */     this.loaders.put(description.getName(), loader);
/*     */     
/* 136 */     return (Plugin)loader.plugin;
/*     */   }
/*     */   
/*     */   public PluginDescriptionFile getPluginDescription(File file) throws InvalidDescriptionException {
/* 140 */     Validate.notNull(file, "File cannot be null");
/*     */     
/* 142 */     JarFile jar = null;
/* 143 */     InputStream stream = null;
/*     */     
/*     */     try {
/* 146 */       jar = new JarFile(file);
/* 147 */       JarEntry entry = jar.getJarEntry("plugin.yml");
/*     */       
/* 149 */       if (entry == null) {
/* 150 */         throw new InvalidDescriptionException(new FileNotFoundException("Jar does not contain plugin.yml"));
/*     */       }
/*     */       
/* 153 */       stream = jar.getInputStream(entry);
/*     */       
/* 155 */       return new PluginDescriptionFile(stream);
/*     */     }
/* 157 */     catch (IOException ex) {
/* 158 */       throw new InvalidDescriptionException(ex);
/* 159 */     } catch (YAMLException ex) {
/* 160 */       throw new InvalidDescriptionException(ex);
/*     */     } finally {
/* 162 */       if (jar != null) {
/*     */         try {
/* 164 */           jar.close();
/* 165 */         } catch (IOException e) {}
/*     */       }
/*     */       
/* 168 */       if (stream != null) {
/*     */         try {
/* 170 */           stream.close();
/* 171 */         } catch (IOException e) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Pattern[] getPluginFileFilters() {
/* 178 */     return (Pattern[])this.fileFilters.clone();
/*     */   }
/*     */   
/*     */   Class<?> getClassByName(String name) {
/* 182 */     Class<?> cachedClass = this.classes.get(name);
/*     */     
/* 184 */     if (cachedClass != null) {
/* 185 */       return cachedClass;
/*     */     }
/* 187 */     for (String current : this.loaders.keySet()) {
/* 188 */       PluginClassLoader loader = this.loaders.get(current);
/*     */       
/*     */       try {
/* 191 */         cachedClass = loader.findClass(name, false);
/* 192 */       } catch (ClassNotFoundException cnfe) {}
/* 193 */       if (cachedClass != null) {
/* 194 */         return cachedClass;
/*     */       }
/*     */     } 
/*     */     
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   void setClass(String name, Class<?> clazz) {
/* 202 */     if (!this.classes.containsKey(name)) {
/* 203 */       this.classes.put(name, clazz);
/*     */       
/* 205 */       if (ConfigurationSerializable.class.isAssignableFrom(clazz)) {
/* 206 */         Class<? extends ConfigurationSerializable> serializable = clazz.asSubclass(ConfigurationSerializable.class);
/* 207 */         ConfigurationSerialization.registerClass(serializable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void removeClass(String name) {
/* 213 */     Class<?> clazz = this.classes.remove(name);
/*     */     
/*     */     try {
/* 216 */       if (clazz != null && ConfigurationSerializable.class.isAssignableFrom(clazz)) {
/* 217 */         Class<? extends ConfigurationSerializable> serializable = clazz.asSubclass(ConfigurationSerializable.class);
/* 218 */         ConfigurationSerialization.unregisterClass(serializable);
/*     */       } 
/* 220 */     } catch (NullPointerException ex) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<Class<? extends Event>, Set<RegisteredListener>> createRegisteredListeners(Listener listener, Plugin plugin) {
/*     */     Set<Method> methods;
/* 227 */     Validate.notNull(plugin, "Plugin can not be null");
/* 228 */     Validate.notNull(listener, "Listener can not be null");
/*     */     
/* 230 */     boolean useTimings = this.server.getPluginManager().useTimings();
/* 231 */     Map<Class<? extends Event>, Set<RegisteredListener>> ret = new HashMap<Class<? extends Event>, Set<RegisteredListener>>();
/*     */     
/*     */     try {
/* 234 */       Method[] publicMethods = listener.getClass().getMethods();
/* 235 */       methods = new HashSet<Method>(publicMethods.length, Float.MAX_VALUE);
/* 236 */       for (Method method : publicMethods) {
/* 237 */         methods.add(method);
/*     */       }
/* 239 */       for (Method method : listener.getClass().getDeclaredMethods()) {
/* 240 */         methods.add(method);
/*     */       }
/* 242 */     } catch (NoClassDefFoundError e) {
/* 243 */       plugin.getLogger().severe("Plugin " + plugin.getDescription().getFullName() + " has failed to register events for " + listener.getClass() + " because " + e.getMessage() + " does not exist.");
/* 244 */       return ret;
/*     */     } 
/*     */     
/* 247 */     for (Method method : methods) {
/* 248 */       EventHandler eh = method.<EventHandler>getAnnotation(EventHandler.class);
/* 249 */       if (eh == null)
/*     */         continue;  Class<?> checkClass;
/* 251 */       if ((method.getParameterTypes()).length != 1 || !Event.class.isAssignableFrom(checkClass = method.getParameterTypes()[0])) {
/* 252 */         plugin.getLogger().severe(plugin.getDescription().getFullName() + " attempted to register an invalid EventHandler method signature \"" + method.toGenericString() + "\" in " + listener.getClass());
/*     */         continue;
/*     */       } 
/* 255 */       final Class<? extends Event> eventClass = checkClass.asSubclass(Event.class);
/* 256 */       method.setAccessible(true);
/* 257 */       Set<RegisteredListener> eventSet = ret.get(eventClass);
/* 258 */       if (eventSet == null) {
/* 259 */         eventSet = new HashSet<RegisteredListener>();
/* 260 */         ret.put(eventClass, eventSet);
/*     */       } 
/*     */       
/* 263 */       for (Class<?> clazz = eventClass; Event.class.isAssignableFrom(clazz); clazz = clazz.getSuperclass()) {
/*     */         
/* 265 */         if (clazz.getAnnotation(Deprecated.class) != null) {
/* 266 */           Warning warning = clazz.<Warning>getAnnotation(Warning.class);
/* 267 */           Warning.WarningState warningState = this.server.getWarningState();
/* 268 */           if (!warningState.printFor(warning)) {
/*     */             break;
/*     */           }
/* 271 */           plugin.getLogger().log(Level.WARNING, String.format("\"%s\" has registered a listener for %s on method \"%s\", but the event is Deprecated. \"%s\"; please notify the authors %s.", new Object[] { plugin.getDescription().getFullName(), clazz.getName(), method.toGenericString(), (warning != null && warning.reason().length() != 0) ? warning.reason() : "Server performance will be affected", Arrays.toString(plugin.getDescription().getAuthors().toArray()) }), (warningState == Warning.WarningState.ON) ? (Throwable)new AuthorNagException(null) : null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 286 */       EventExecutor executor = new EventExecutor() {
/*     */           public void execute(Listener listener, Event event) throws EventException {
/*     */             try {
/* 289 */               if (!eventClass.isAssignableFrom(event.getClass())) {
/*     */                 return;
/*     */               }
/* 292 */               method.invoke(listener, new Object[] { event });
/* 293 */             } catch (InvocationTargetException ex) {
/* 294 */               throw new EventException(ex.getCause());
/* 295 */             } catch (Throwable t) {
/* 296 */               throw new EventException(t);
/*     */             } 
/*     */           }
/*     */         };
/* 300 */       if (useTimings) {
/* 301 */         eventSet.add(new TimedRegisteredListener(listener, executor, eh.priority(), plugin, eh.ignoreCancelled())); continue;
/*     */       } 
/* 303 */       eventSet.add(new RegisteredListener(listener, executor, eh.priority(), plugin, eh.ignoreCancelled()));
/*     */     } 
/*     */     
/* 306 */     return ret;
/*     */   }
/*     */   
/*     */   public void enablePlugin(Plugin plugin) {
/* 310 */     Validate.isTrue(plugin instanceof JavaPlugin, "Plugin is not associated with this PluginLoader");
/*     */     
/* 312 */     if (!plugin.isEnabled()) {
/* 313 */       plugin.getLogger().info("Enabling " + plugin.getDescription().getFullName());
/*     */       
/* 315 */       JavaPlugin jPlugin = (JavaPlugin)plugin;
/*     */       
/* 317 */       String pluginName = jPlugin.getDescription().getName();
/*     */       
/* 319 */       if (!this.loaders.containsKey(pluginName)) {
/* 320 */         this.loaders.put(pluginName, (PluginClassLoader)jPlugin.getClassLoader());
/*     */       }
/*     */       
/*     */       try {
/* 324 */         jPlugin.setEnabled(true);
/* 325 */       } catch (Throwable ex) {
/* 326 */         this.server.getLogger().log(Level.SEVERE, "Error occurred while enabling " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 331 */       this.server.getPluginManager().callEvent((Event)new PluginEnableEvent(plugin));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void disablePlugin(Plugin plugin) {
/* 336 */     Validate.isTrue(plugin instanceof JavaPlugin, "Plugin is not associated with this PluginLoader");
/*     */     
/* 338 */     if (plugin.isEnabled()) {
/* 339 */       String message = String.format("Disabling %s", new Object[] { plugin.getDescription().getFullName() });
/* 340 */       plugin.getLogger().info(message);
/*     */       
/* 342 */       this.server.getPluginManager().callEvent((Event)new PluginDisableEvent(plugin));
/*     */       
/* 344 */       JavaPlugin jPlugin = (JavaPlugin)plugin;
/* 345 */       ClassLoader cloader = jPlugin.getClassLoader();
/*     */       
/*     */       try {
/* 348 */         jPlugin.setEnabled(false);
/* 349 */       } catch (Throwable ex) {
/* 350 */         this.server.getLogger().log(Level.SEVERE, "Error occurred while disabling " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/* 353 */       this.loaders.remove(jPlugin.getDescription().getName());
/*     */       
/* 355 */       if (cloader instanceof PluginClassLoader) {
/* 356 */         PluginClassLoader loader = (PluginClassLoader)cloader;
/* 357 */         Set<String> names = loader.getClasses();
/*     */         
/* 359 */         for (String name : names)
/* 360 */           removeClass(name); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\java\JavaPluginLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */