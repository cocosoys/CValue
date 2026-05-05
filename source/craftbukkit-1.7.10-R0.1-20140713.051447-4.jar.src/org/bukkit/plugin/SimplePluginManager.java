/*     */ package org.bukkit.plugin;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ import java.util.logging.Level;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.PluginCommandYamlParser;
/*     */ import org.bukkit.command.SimpleCommandMap;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.HandlerList;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.permissions.Permissible;
/*     */ import org.bukkit.permissions.Permission;
/*     */ import org.bukkit.permissions.PermissionDefault;
/*     */ import org.bukkit.util.FileUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SimplePluginManager
/*     */   implements PluginManager
/*     */ {
/*     */   private final Server server;
/*  42 */   private final Map<Pattern, PluginLoader> fileAssociations = new HashMap<Pattern, PluginLoader>();
/*  43 */   private final List<Plugin> plugins = new ArrayList<Plugin>();
/*  44 */   private final Map<String, Plugin> lookupNames = new HashMap<String, Plugin>();
/*  45 */   private static File updateDirectory = null;
/*     */   private final SimpleCommandMap commandMap;
/*  47 */   private final Map<String, Permission> permissions = new HashMap<String, Permission>();
/*  48 */   private final Map<Boolean, Set<Permission>> defaultPerms = new LinkedHashMap<Boolean, Set<Permission>>();
/*  49 */   private final Map<String, Map<Permissible, Boolean>> permSubs = new HashMap<String, Map<Permissible, Boolean>>();
/*  50 */   private final Map<Boolean, Map<Permissible, Boolean>> defSubs = new HashMap<Boolean, Map<Permissible, Boolean>>();
/*     */   private boolean useTimings = false;
/*     */   
/*     */   public SimplePluginManager(Server instance, SimpleCommandMap commandMap) {
/*  54 */     this.server = instance;
/*  55 */     this.commandMap = commandMap;
/*     */     
/*  57 */     this.defaultPerms.put(Boolean.valueOf(true), new HashSet<Permission>());
/*  58 */     this.defaultPerms.put(Boolean.valueOf(false), new HashSet<Permission>());
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
/*     */   public void registerInterface(Class<? extends PluginLoader> loader) throws IllegalArgumentException {
/*     */     PluginLoader instance;
/*  71 */     if (PluginLoader.class.isAssignableFrom(loader)) {
/*     */ 
/*     */       
/*     */       try {
/*  75 */         Constructor<? extends PluginLoader> constructor = loader.getConstructor(new Class[] { Server.class });
/*  76 */         instance = constructor.newInstance(new Object[] { this.server });
/*  77 */       } catch (NoSuchMethodException ex) {
/*  78 */         String className = loader.getName();
/*     */         
/*  80 */         throw new IllegalArgumentException(String.format("Class %s does not have a public %s(Server) constructor", new Object[] { className, className }), ex);
/*  81 */       } catch (Exception ex) {
/*  82 */         throw new IllegalArgumentException(String.format("Unexpected exception %s while attempting to construct a new instance of %s", new Object[] { ex.getClass().getName(), loader.getName() }), ex);
/*     */       } 
/*     */     } else {
/*  85 */       throw new IllegalArgumentException(String.format("Class %s does not implement interface PluginLoader", new Object[] { loader.getName() }));
/*     */     } 
/*     */     
/*  88 */     Pattern[] patterns = instance.getPluginFileFilters();
/*     */     
/*  90 */     synchronized (this) {
/*  91 */       for (Pattern pattern : patterns) {
/*  92 */         this.fileAssociations.put(pattern, instance);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Plugin[] loadPlugins(File directory) {
/* 104 */     Validate.notNull(directory, "Directory cannot be null");
/* 105 */     Validate.isTrue(directory.isDirectory(), "Directory must be a directory");
/*     */     
/* 107 */     List<Plugin> result = new ArrayList<Plugin>();
/* 108 */     Set<Pattern> filters = this.fileAssociations.keySet();
/*     */     
/* 110 */     if (!this.server.getUpdateFolder().equals("")) {
/* 111 */       updateDirectory = new File(directory, this.server.getUpdateFolder());
/*     */     }
/*     */     
/* 114 */     Map<String, File> plugins = new HashMap<String, File>();
/* 115 */     Set<String> loadedPlugins = new HashSet<String>();
/* 116 */     Map<String, Collection<String>> dependencies = new HashMap<String, Collection<String>>();
/* 117 */     Map<String, Collection<String>> softDependencies = new HashMap<String, Collection<String>>();
/*     */ 
/*     */     
/* 120 */     for (File file : directory.listFiles()) {
/* 121 */       PluginLoader loader = null;
/* 122 */       for (Pattern filter : filters) {
/* 123 */         Matcher match = filter.matcher(file.getName());
/* 124 */         if (match.find()) {
/* 125 */           loader = this.fileAssociations.get(filter);
/*     */         }
/*     */       } 
/*     */       
/* 129 */       if (loader != null) {
/*     */         
/* 131 */         PluginDescriptionFile description = null;
/*     */         
/* 133 */         try { description = loader.getPluginDescription(file);
/* 134 */           String name = description.getName();
/* 135 */           if (name.equalsIgnoreCase("bukkit") || name.equalsIgnoreCase("minecraft") || name.equalsIgnoreCase("mojang")) {
/* 136 */             this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "': Restricted Name");
/*     */           } else {
/* 138 */             if (description.rawName.indexOf(' ') != -1) {
/* 139 */               this.server.getLogger().warning(String.format("Plugin `%s' uses the space-character (0x20) in its name `%s' - this is discouraged", new Object[] { description.getFullName(), description.rawName }));
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 150 */             File replacedFile = plugins.put(description.getName(), file);
/* 151 */             if (replacedFile != null) {
/* 152 */               this.server.getLogger().severe(String.format("Ambiguous plugin name `%s' for files `%s' and `%s' in `%s'", new Object[] { description.getName(), file.getPath(), replacedFile.getPath(), directory.getPath() }));
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 161 */             Collection<String> softDependencySet = description.getSoftDepend();
/* 162 */             if (softDependencySet != null && !softDependencySet.isEmpty()) {
/* 163 */               if (softDependencies.containsKey(description.getName())) {
/*     */                 
/* 165 */                 ((Collection<String>)softDependencies.get(description.getName())).addAll(softDependencySet);
/*     */               } else {
/* 167 */                 softDependencies.put(description.getName(), new LinkedList<String>(softDependencySet));
/*     */               } 
/*     */             }
/*     */             
/* 171 */             Collection<String> dependencySet = description.getDepend();
/* 172 */             if (dependencySet != null && !dependencySet.isEmpty()) {
/* 173 */               dependencies.put(description.getName(), new LinkedList<String>(dependencySet));
/*     */             }
/*     */             
/* 176 */             Collection<String> loadBeforeSet = description.getLoadBefore();
/* 177 */             if (loadBeforeSet != null && !loadBeforeSet.isEmpty())
/* 178 */               for (String loadBeforeTarget : loadBeforeSet) {
/* 179 */                 if (softDependencies.containsKey(loadBeforeTarget)) {
/* 180 */                   ((Collection<String>)softDependencies.get(loadBeforeTarget)).add(description.getName());
/*     */                   continue;
/*     */                 } 
/* 183 */                 Collection<String> shortSoftDependency = new LinkedList<String>();
/* 184 */                 shortSoftDependency.add(description.getName());
/* 185 */                 softDependencies.put(loadBeforeTarget, shortSoftDependency);
/*     */               }  
/*     */           }  }
/*     */         catch (InvalidDescriptionException ex) { this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "'", ex); }
/*     */       
/*     */       } 
/* 191 */     }  while (!plugins.isEmpty()) {
/* 192 */       boolean missingDependency = true;
/* 193 */       Iterator<String> pluginIterator = plugins.keySet().iterator();
/*     */       
/* 195 */       while (pluginIterator.hasNext()) {
/* 196 */         String plugin = pluginIterator.next();
/*     */         
/* 198 */         if (dependencies.containsKey(plugin)) {
/* 199 */           Iterator<String> dependencyIterator = ((Collection<String>)dependencies.get(plugin)).iterator();
/*     */           
/* 201 */           while (dependencyIterator.hasNext()) {
/* 202 */             String dependency = dependencyIterator.next();
/*     */ 
/*     */             
/* 205 */             if (loadedPlugins.contains(dependency)) {
/* 206 */               dependencyIterator.remove();
/*     */               continue;
/*     */             } 
/* 209 */             if (!plugins.containsKey(dependency)) {
/* 210 */               missingDependency = false;
/* 211 */               File file = plugins.get(plugin);
/* 212 */               pluginIterator.remove();
/* 213 */               softDependencies.remove(plugin);
/* 214 */               dependencies.remove(plugin);
/*     */               
/* 216 */               this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "'", new UnknownDependencyException(dependency));
/*     */ 
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 224 */           if (dependencies.containsKey(plugin) && ((Collection)dependencies.get(plugin)).isEmpty()) {
/* 225 */             dependencies.remove(plugin);
/*     */           }
/*     */         } 
/* 228 */         if (softDependencies.containsKey(plugin)) {
/* 229 */           Iterator<String> softDependencyIterator = ((Collection<String>)softDependencies.get(plugin)).iterator();
/*     */           
/* 231 */           while (softDependencyIterator.hasNext()) {
/* 232 */             String softDependency = softDependencyIterator.next();
/*     */ 
/*     */             
/* 235 */             if (!plugins.containsKey(softDependency)) {
/* 236 */               softDependencyIterator.remove();
/*     */             }
/*     */           } 
/*     */           
/* 240 */           if (((Collection)softDependencies.get(plugin)).isEmpty()) {
/* 241 */             softDependencies.remove(plugin);
/*     */           }
/*     */         } 
/* 244 */         if (!dependencies.containsKey(plugin) && !softDependencies.containsKey(plugin) && plugins.containsKey(plugin)) {
/*     */           
/* 246 */           File file = plugins.get(plugin);
/* 247 */           pluginIterator.remove();
/* 248 */           missingDependency = false;
/*     */           
/*     */           try {
/* 251 */             result.add(loadPlugin(file));
/* 252 */             loadedPlugins.add(plugin);
/*     */           }
/* 254 */           catch (InvalidPluginException ex) {
/* 255 */             this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "'", ex);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 260 */       if (missingDependency) {
/*     */ 
/*     */         
/* 263 */         pluginIterator = plugins.keySet().iterator();
/*     */         
/* 265 */         while (pluginIterator.hasNext()) {
/* 266 */           String plugin = pluginIterator.next();
/*     */           
/* 268 */           if (!dependencies.containsKey(plugin)) {
/* 269 */             softDependencies.remove(plugin);
/* 270 */             missingDependency = false;
/* 271 */             File file = plugins.get(plugin);
/* 272 */             pluginIterator.remove();
/*     */             
/*     */             try {
/* 275 */               result.add(loadPlugin(file));
/* 276 */               loadedPlugins.add(plugin);
/*     */               break;
/* 278 */             } catch (InvalidPluginException ex) {
/* 279 */               this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "'", ex);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 284 */         if (missingDependency) {
/* 285 */           softDependencies.clear();
/* 286 */           dependencies.clear();
/* 287 */           Iterator<File> failedPluginIterator = plugins.values().iterator();
/*     */           
/* 289 */           while (failedPluginIterator.hasNext()) {
/* 290 */             File file = failedPluginIterator.next();
/* 291 */             failedPluginIterator.remove();
/* 292 */             this.server.getLogger().log(Level.SEVERE, "Could not load '" + file.getPath() + "' in folder '" + directory.getPath() + "': circular dependency detected");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 298 */     return result.<Plugin>toArray(new Plugin[result.size()]);
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
/*     */   public synchronized Plugin loadPlugin(File file) throws InvalidPluginException, UnknownDependencyException {
/* 314 */     Validate.notNull(file, "File cannot be null");
/*     */     
/* 316 */     checkUpdate(file);
/*     */     
/* 318 */     Set<Pattern> filters = this.fileAssociations.keySet();
/* 319 */     Plugin result = null;
/*     */     
/* 321 */     for (Pattern filter : filters) {
/* 322 */       String name = file.getName();
/* 323 */       Matcher match = filter.matcher(name);
/*     */       
/* 325 */       if (match.find()) {
/* 326 */         PluginLoader loader = this.fileAssociations.get(filter);
/*     */         
/* 328 */         result = loader.loadPlugin(file);
/*     */       } 
/*     */     } 
/*     */     
/* 332 */     if (result != null) {
/* 333 */       this.plugins.add(result);
/* 334 */       this.lookupNames.put(result.getDescription().getName(), result);
/*     */     } 
/*     */     
/* 337 */     return result;
/*     */   }
/*     */   
/*     */   private void checkUpdate(File file) {
/* 341 */     if (updateDirectory == null || !updateDirectory.isDirectory()) {
/*     */       return;
/*     */     }
/*     */     
/* 345 */     File updateFile = new File(updateDirectory, file.getName());
/* 346 */     if (updateFile.isFile() && FileUtil.copy(updateFile, file)) {
/* 347 */       updateFile.delete();
/*     */     }
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
/*     */   public synchronized Plugin getPlugin(String name) {
/* 360 */     return this.lookupNames.get(name.replace(' ', '_'));
/*     */   }
/*     */   
/*     */   public synchronized Plugin[] getPlugins() {
/* 364 */     return this.plugins.<Plugin>toArray(new Plugin[0]);
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
/*     */   public boolean isPluginEnabled(String name) {
/* 376 */     Plugin plugin = getPlugin(name);
/*     */     
/* 378 */     return isPluginEnabled(plugin);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPluginEnabled(Plugin plugin) {
/* 388 */     if (plugin != null && this.plugins.contains(plugin)) {
/* 389 */       return plugin.isEnabled();
/*     */     }
/* 391 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void enablePlugin(Plugin plugin) {
/* 396 */     if (!plugin.isEnabled()) {
/* 397 */       List<Command> pluginCommands = PluginCommandYamlParser.parse(plugin);
/*     */       
/* 399 */       if (!pluginCommands.isEmpty()) {
/* 400 */         this.commandMap.registerAll(plugin.getDescription().getName(), pluginCommands);
/*     */       }
/*     */       
/*     */       try {
/* 404 */         plugin.getPluginLoader().enablePlugin(plugin);
/* 405 */       } catch (Throwable ex) {
/* 406 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while enabling " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/* 409 */       HandlerList.bakeAll();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void disablePlugins() {
/* 414 */     Plugin[] plugins = getPlugins();
/* 415 */     for (int i = plugins.length - 1; i >= 0; i--) {
/* 416 */       disablePlugin(plugins[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void disablePlugin(Plugin plugin) {
/* 421 */     if (plugin.isEnabled()) {
/*     */       try {
/* 423 */         plugin.getPluginLoader().disablePlugin(plugin);
/* 424 */       } catch (Throwable ex) {
/* 425 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while disabling " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/*     */       try {
/* 429 */         this.server.getScheduler().cancelTasks(plugin);
/* 430 */       } catch (Throwable ex) {
/* 431 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while cancelling tasks for " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/*     */       try {
/* 435 */         this.server.getServicesManager().unregisterAll(plugin);
/* 436 */       } catch (Throwable ex) {
/* 437 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while unregistering services for " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/*     */       try {
/* 441 */         HandlerList.unregisterAll(plugin);
/* 442 */       } catch (Throwable ex) {
/* 443 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while unregistering events for " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */       
/*     */       try {
/* 447 */         this.server.getMessenger().unregisterIncomingPluginChannel(plugin);
/* 448 */         this.server.getMessenger().unregisterOutgoingPluginChannel(plugin);
/* 449 */       } catch (Throwable ex) {
/* 450 */         this.server.getLogger().log(Level.SEVERE, "Error occurred (in the plugin loader) while unregistering plugin channels for " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearPlugins() {
/* 456 */     synchronized (this) {
/* 457 */       disablePlugins();
/* 458 */       this.plugins.clear();
/* 459 */       this.lookupNames.clear();
/* 460 */       HandlerList.unregisterAll();
/* 461 */       this.fileAssociations.clear();
/* 462 */       this.permissions.clear();
/* 463 */       ((Set)this.defaultPerms.get(Boolean.valueOf(true))).clear();
/* 464 */       ((Set)this.defaultPerms.get(Boolean.valueOf(false))).clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void callEvent(Event event) {
/* 476 */     if (event.isAsynchronous()) {
/* 477 */       if (Thread.holdsLock(this)) {
/* 478 */         throw new IllegalStateException(event.getEventName() + " cannot be triggered asynchronously from inside synchronized code.");
/*     */       }
/* 480 */       if (this.server.isPrimaryThread()) {
/* 481 */         throw new IllegalStateException(event.getEventName() + " cannot be triggered asynchronously from primary server thread.");
/*     */       }
/* 483 */       fireEvent(event);
/*     */     } else {
/* 485 */       synchronized (this) {
/* 486 */         fireEvent(event);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fireEvent(Event event) {
/* 492 */     HandlerList handlers = event.getHandlers();
/* 493 */     RegisteredListener[] listeners = handlers.getRegisteredListeners();
/*     */     
/* 495 */     for (RegisteredListener registration : listeners) {
/* 496 */       if (registration.getPlugin().isEnabled())
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 501 */           registration.callEvent(event);
/* 502 */         } catch (AuthorNagException ex) {
/* 503 */           Plugin plugin = registration.getPlugin();
/*     */           
/* 505 */           if (plugin.isNaggable()) {
/* 506 */             plugin.setNaggable(false);
/*     */             
/* 508 */             this.server.getLogger().log(Level.SEVERE, String.format("Nag author(s): '%s' of '%s' about the following: %s", new Object[] { plugin.getDescription().getAuthors(), plugin.getDescription().getFullName(), ex.getMessage() }));
/*     */ 
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/* 515 */         catch (Throwable ex) {
/* 516 */           this.server.getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to " + registration.getPlugin().getDescription().getFullName(), ex);
/*     */         }  
/*     */     } 
/*     */   }
/*     */   
/*     */   public void registerEvents(Listener listener, Plugin plugin) {
/* 522 */     if (!plugin.isEnabled()) {
/* 523 */       throw new IllegalPluginAccessException("Plugin attempted to register " + listener + " while not enabled");
/*     */     }
/*     */     
/* 526 */     for (Map.Entry<Class<? extends Event>, Set<RegisteredListener>> entry : plugin.getPluginLoader().createRegisteredListeners(listener, plugin).entrySet()) {
/* 527 */       getEventListeners(getRegistrationClass(entry.getKey())).registerAll(entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin) {
/* 533 */     registerEvent(event, listener, priority, executor, plugin, false);
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
/*     */   public void registerEvent(Class<? extends Event> event, Listener listener, EventPriority priority, EventExecutor executor, Plugin plugin, boolean ignoreCancelled) {
/* 549 */     Validate.notNull(listener, "Listener cannot be null");
/* 550 */     Validate.notNull(priority, "Priority cannot be null");
/* 551 */     Validate.notNull(executor, "Executor cannot be null");
/* 552 */     Validate.notNull(plugin, "Plugin cannot be null");
/*     */     
/* 554 */     if (!plugin.isEnabled()) {
/* 555 */       throw new IllegalPluginAccessException("Plugin attempted to register " + event + " while not enabled");
/*     */     }
/*     */     
/* 558 */     if (this.useTimings) {
/* 559 */       getEventListeners(event).register(new TimedRegisteredListener(listener, executor, priority, plugin, ignoreCancelled));
/*     */     } else {
/* 561 */       getEventListeners(event).register(new RegisteredListener(listener, executor, priority, plugin, ignoreCancelled));
/*     */     } 
/*     */   }
/*     */   
/*     */   private HandlerList getEventListeners(Class<? extends Event> type) {
/*     */     try {
/* 567 */       Method method = getRegistrationClass(type).getDeclaredMethod("getHandlerList", new Class[0]);
/* 568 */       method.setAccessible(true);
/* 569 */       return (HandlerList)method.invoke(null, new Object[0]);
/* 570 */     } catch (Exception e) {
/* 571 */       throw new IllegalPluginAccessException(e.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   private Class<? extends Event> getRegistrationClass(Class<? extends Event> clazz) {
/*     */     try {
/* 577 */       clazz.getDeclaredMethod("getHandlerList", new Class[0]);
/* 578 */       return clazz;
/* 579 */     } catch (NoSuchMethodException e) {
/* 580 */       if (clazz.getSuperclass() != null && !clazz.getSuperclass().equals(Event.class) && Event.class.isAssignableFrom(clazz.getSuperclass()))
/*     */       {
/*     */         
/* 583 */         return getRegistrationClass(clazz.getSuperclass().asSubclass(Event.class));
/*     */       }
/* 585 */       throw new IllegalPluginAccessException("Unable to find handler list for event " + clazz.getName());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Permission getPermission(String name) {
/* 591 */     return this.permissions.get(name.toLowerCase());
/*     */   }
/*     */   
/*     */   public void addPermission(Permission perm) {
/* 595 */     String name = perm.getName().toLowerCase();
/*     */     
/* 597 */     if (this.permissions.containsKey(name)) {
/* 598 */       throw new IllegalArgumentException("The permission " + name + " is already defined!");
/*     */     }
/*     */     
/* 601 */     this.permissions.put(name, perm);
/* 602 */     calculatePermissionDefault(perm);
/*     */   }
/*     */   
/*     */   public Set<Permission> getDefaultPermissions(boolean op) {
/* 606 */     return (Set<Permission>)ImmutableSet.copyOf(this.defaultPerms.get(Boolean.valueOf(op)));
/*     */   }
/*     */   
/*     */   public void removePermission(Permission perm) {
/* 610 */     removePermission(perm.getName());
/*     */   }
/*     */   
/*     */   public void removePermission(String name) {
/* 614 */     this.permissions.remove(name.toLowerCase());
/*     */   }
/*     */   
/*     */   public void recalculatePermissionDefaults(Permission perm) {
/* 618 */     if (this.permissions.containsValue(perm)) {
/* 619 */       ((Set)this.defaultPerms.get(Boolean.valueOf(true))).remove(perm);
/* 620 */       ((Set)this.defaultPerms.get(Boolean.valueOf(false))).remove(perm);
/*     */       
/* 622 */       calculatePermissionDefault(perm);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void calculatePermissionDefault(Permission perm) {
/* 627 */     if (perm.getDefault() == PermissionDefault.OP || perm.getDefault() == PermissionDefault.TRUE) {
/* 628 */       ((Set<Permission>)this.defaultPerms.get(Boolean.valueOf(true))).add(perm);
/* 629 */       dirtyPermissibles(true);
/*     */     } 
/* 631 */     if (perm.getDefault() == PermissionDefault.NOT_OP || perm.getDefault() == PermissionDefault.TRUE) {
/* 632 */       ((Set<Permission>)this.defaultPerms.get(Boolean.valueOf(false))).add(perm);
/* 633 */       dirtyPermissibles(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dirtyPermissibles(boolean op) {
/* 638 */     Set<Permissible> permissibles = getDefaultPermSubscriptions(op);
/*     */     
/* 640 */     for (Permissible p : permissibles) {
/* 641 */       p.recalculatePermissions();
/*     */     }
/*     */   }
/*     */   
/*     */   public void subscribeToPermission(String permission, Permissible permissible) {
/* 646 */     String name = permission.toLowerCase();
/* 647 */     Map<Permissible, Boolean> map = this.permSubs.get(name);
/*     */     
/* 649 */     if (map == null) {
/* 650 */       map = new WeakHashMap<Permissible, Boolean>();
/* 651 */       this.permSubs.put(name, map);
/*     */     } 
/*     */     
/* 654 */     map.put(permissible, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public void unsubscribeFromPermission(String permission, Permissible permissible) {
/* 658 */     String name = permission.toLowerCase();
/* 659 */     Map<Permissible, Boolean> map = this.permSubs.get(name);
/*     */     
/* 661 */     if (map != null) {
/* 662 */       map.remove(permissible);
/*     */       
/* 664 */       if (map.isEmpty()) {
/* 665 */         this.permSubs.remove(name);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set<Permissible> getPermissionSubscriptions(String permission) {
/* 671 */     String name = permission.toLowerCase();
/* 672 */     Map<Permissible, Boolean> map = this.permSubs.get(name);
/*     */     
/* 674 */     if (map == null) {
/* 675 */       return (Set<Permissible>)ImmutableSet.of();
/*     */     }
/* 677 */     return (Set<Permissible>)ImmutableSet.copyOf(map.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public void subscribeToDefaultPerms(boolean op, Permissible permissible) {
/* 682 */     Map<Permissible, Boolean> map = this.defSubs.get(Boolean.valueOf(op));
/*     */     
/* 684 */     if (map == null) {
/* 685 */       map = new WeakHashMap<Permissible, Boolean>();
/* 686 */       this.defSubs.put(Boolean.valueOf(op), map);
/*     */     } 
/*     */     
/* 689 */     map.put(permissible, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public void unsubscribeFromDefaultPerms(boolean op, Permissible permissible) {
/* 693 */     Map<Permissible, Boolean> map = this.defSubs.get(Boolean.valueOf(op));
/*     */     
/* 695 */     if (map != null) {
/* 696 */       map.remove(permissible);
/*     */       
/* 698 */       if (map.isEmpty()) {
/* 699 */         this.defSubs.remove(Boolean.valueOf(op));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set<Permissible> getDefaultPermSubscriptions(boolean op) {
/* 705 */     Map<Permissible, Boolean> map = this.defSubs.get(Boolean.valueOf(op));
/*     */     
/* 707 */     if (map == null) {
/* 708 */       return (Set<Permissible>)ImmutableSet.of();
/*     */     }
/* 710 */     return (Set<Permissible>)ImmutableSet.copyOf(map.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Permission> getPermissions() {
/* 715 */     return new HashSet<Permission>(this.permissions.values());
/*     */   }
/*     */   
/*     */   public boolean useTimings() {
/* 719 */     return this.useTimings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void useTimings(boolean use) {
/* 728 */     this.useTimings = use;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\SimplePluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */