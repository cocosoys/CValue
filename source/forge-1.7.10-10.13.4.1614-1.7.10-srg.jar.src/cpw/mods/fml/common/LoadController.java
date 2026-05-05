/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.Collections2;
/*     */ import com.google.common.collect.ImmutableBiMap;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import com.google.common.eventbus.Subscribe;
/*     */ import cpw.mods.fml.common.event.FMLEvent;
/*     */ import cpw.mods.fml.common.event.FMLLoadEvent;
/*     */ import cpw.mods.fml.common.event.FMLModDisabledEvent;
/*     */ import cpw.mods.fml.common.event.FMLStateEvent;
/*     */ import cpw.mods.fml.common.functions.ArtifactVersionNameFunction;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoadController
/*     */ {
/*     */   private Loader loader;
/*     */   private EventBus masterChannel;
/*     */   private ImmutableMap<String, EventBus> eventChannels;
/*     */   private LoaderState state;
/*  55 */   private Multimap<String, LoaderState.ModState> modStates = (Multimap<String, LoaderState.ModState>)ArrayListMultimap.create();
/*  56 */   private Multimap<String, Throwable> errors = (Multimap<String, Throwable>)ArrayListMultimap.create();
/*  57 */   private List<ModContainer> activeModList = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */   
/*     */   private ModContainer activeContainer;
/*     */ 
/*     */   
/*     */   private BiMap<ModContainer, Object> modObjectList;
/*     */ 
/*     */   
/*     */   private ListMultimap<String, ModContainer> packageOwners;
/*     */ 
/*     */   
/*     */   private FMLSecurityManager accessibleManager;
/*     */ 
/*     */ 
/*     */   
/*     */   void disableMod(ModContainer mod) {
/*  75 */     HashMap<String, EventBus> temporary = Maps.newHashMap((Map)this.eventChannels);
/*  76 */     String modId = mod.getModId();
/*  77 */     EventBus bus = temporary.remove(modId);
/*  78 */     bus.post(new FMLModDisabledEvent());
/*  79 */     if (this.errors.get(modId).isEmpty()) {
/*     */       
/*  81 */       this.eventChannels = ImmutableMap.copyOf(temporary);
/*  82 */       this.modStates.put(modId, LoaderState.ModState.DISABLED);
/*  83 */       this.modObjectList.remove(mod);
/*  84 */       this.activeModList.remove(mod);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Subscribe
/*     */   public void buildModList(FMLLoadEvent event) {
/*  90 */     ImmutableMap.Builder<String, EventBus> eventBus = ImmutableMap.builder();
/*     */     
/*  92 */     for (ModContainer mod : this.loader.getModList()) {
/*     */ 
/*     */       
/*  95 */       EventBus bus = new EventBus(mod.getModId());
/*  96 */       boolean isActive = mod.registerBus(bus, this);
/*  97 */       if (isActive) {
/*     */         
/*  99 */         this.activeModList.add(mod);
/* 100 */         this.modStates.put(mod.getModId(), LoaderState.ModState.UNLOADED);
/* 101 */         eventBus.put(mod.getModId(), bus);
/* 102 */         FMLCommonHandler.instance().addModToResourcePack(mod);
/*     */         
/*     */         continue;
/*     */       } 
/* 106 */       FMLLog.log(mod.getModId(), Level.WARN, "Mod %s has been disabled through configuration", new Object[] { mod.getModId() });
/* 107 */       this.modStates.put(mod.getModId(), LoaderState.ModState.UNLOADED);
/* 108 */       this.modStates.put(mod.getModId(), LoaderState.ModState.DISABLED);
/*     */     } 
/*     */ 
/*     */     
/* 112 */     this.eventChannels = eventBus.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public void distributeStateMessage(LoaderState state, Object... eventData) {
/* 117 */     if (state.hasEvent())
/*     */     {
/* 119 */       this.masterChannel.post(state.getEvent(eventData));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void transition(LoaderState desiredState, boolean forceState) {
/* 125 */     LoaderState oldState = this.state;
/* 126 */     this.state = this.state.transition(!this.errors.isEmpty());
/* 127 */     if (this.state != desiredState && !forceState) {
/*     */       
/* 129 */       Throwable toThrow = null;
/* 130 */       FMLLog.severe("Fatal errors were detected during the transition from %s to %s. Loading cannot continue", new Object[] { oldState, desiredState });
/* 131 */       StringBuilder sb = new StringBuilder();
/* 132 */       printModStates(sb);
/* 133 */       FMLLog.severe("%s", new Object[] { sb.toString() });
/* 134 */       if (this.errors.size() > 0) {
/*     */         
/* 136 */         FMLLog.severe("The following problems were captured during this phase", new Object[0]);
/* 137 */         for (Map.Entry<String, Throwable> error : (Iterable<Map.Entry<String, Throwable>>)this.errors.entries())
/*     */         {
/* 139 */           FMLLog.log(Level.ERROR, error.getValue(), "Caught exception from %s", new Object[] { error.getKey() });
/* 140 */           if (error.getValue() instanceof IFMLHandledException) {
/*     */             
/* 142 */             toThrow = error.getValue(); continue;
/*     */           } 
/* 144 */           if (toThrow == null)
/*     */           {
/* 146 */             toThrow = error.getValue();
/*     */           }
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 152 */         FMLLog.severe("The ForgeModLoader state engine has become corrupted. Probably, a state was missed by and invalid modification to a base classForgeModLoader depends on. This is a critical error and not recoverable. Investigate any modifications to base classes outside ofForgeModLoader, especially Optifine, to see if there are fixes available.", new Object[0]);
/*     */ 
/*     */         
/* 155 */         throw new RuntimeException("The ForgeModLoader state engine is invalid");
/*     */       } 
/* 157 */       if (toThrow != null && toThrow instanceof RuntimeException)
/*     */       {
/* 159 */         throw (RuntimeException)toThrow;
/*     */       }
/*     */ 
/*     */       
/* 163 */       throw new LoaderException(toThrow);
/*     */     } 
/*     */     
/* 166 */     if (this.state != desiredState && forceState) {
/*     */       
/* 168 */       FMLLog.info("The state engine was in incorrect state %s and forced into state %s. Errors may have been discarded.", new Object[] { this.state, desiredState });
/* 169 */       forceState(desiredState);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModContainer activeContainer() {
/* 176 */     return (this.activeContainer != null) ? this.activeContainer : findActiveContainerFromStack();
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void propogateStateMessage(FMLEvent stateEvent) {
/* 182 */     if (stateEvent instanceof cpw.mods.fml.common.event.FMLPreInitializationEvent)
/*     */     {
/* 184 */       this.modObjectList = (BiMap<ModContainer, Object>)buildModObjectList();
/*     */     }
/* 186 */     ProgressManager.ProgressBar bar = ProgressManager.push(stateEvent.description(), this.activeModList.size(), true);
/* 187 */     for (ModContainer mc : this.activeModList) {
/*     */       
/* 189 */       bar.step(mc.getName());
/* 190 */       sendEventToModContainer(stateEvent, mc);
/*     */     } 
/* 192 */     ProgressManager.pop(bar);
/*     */   }
/*     */ 
/*     */   
/*     */   private void sendEventToModContainer(FMLEvent stateEvent, ModContainer mc) {
/* 197 */     String modId = mc.getModId();
/* 198 */     Collection<String> requirements = Collections2.transform(mc.getRequirements(), (Function)new ArtifactVersionNameFunction());
/* 199 */     for (ArtifactVersion av : mc.getDependencies()) {
/*     */       
/* 201 */       if (av.getLabel() != null && requirements.contains(av.getLabel()) && this.modStates.containsEntry(av.getLabel(), LoaderState.ModState.ERRORED)) {
/*     */         
/* 203 */         FMLLog.log(modId, Level.ERROR, "Skipping event %s and marking errored mod %s since required dependency %s has errored", new Object[] { stateEvent.getEventType(), modId, av.getLabel() });
/* 204 */         this.modStates.put(modId, LoaderState.ModState.ERRORED);
/*     */         return;
/*     */       } 
/*     */     } 
/* 208 */     this.activeContainer = mc;
/* 209 */     stateEvent.applyModContainer(activeContainer());
/* 210 */     ThreadContext.put("mod", modId);
/* 211 */     FMLLog.log(modId, Level.TRACE, "Sending event %s to mod %s", new Object[] { stateEvent.getEventType(), modId });
/* 212 */     ((EventBus)this.eventChannels.get(modId)).post(stateEvent);
/* 213 */     FMLLog.log(modId, Level.TRACE, "Sent event %s to mod %s", new Object[] { stateEvent.getEventType(), modId });
/* 214 */     ThreadContext.remove("mod");
/* 215 */     this.activeContainer = null;
/* 216 */     if (stateEvent instanceof FMLStateEvent)
/*     */     {
/* 218 */       if (!this.errors.containsKey(modId)) {
/*     */         
/* 220 */         this.modStates.put(modId, ((FMLStateEvent)stateEvent).getModState());
/*     */       }
/*     */       else {
/*     */         
/* 224 */         this.modStates.put(modId, LoaderState.ModState.ERRORED);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ImmutableBiMap<ModContainer, Object> buildModObjectList() {
/* 231 */     ImmutableBiMap.Builder<ModContainer, Object> builder = ImmutableBiMap.builder();
/* 232 */     for (ModContainer mc : this.activeModList) {
/*     */       
/* 234 */       if (!mc.isImmutable() && mc.getMod() != null) {
/*     */         
/* 236 */         builder.put(mc, mc.getMod());
/* 237 */         List<String> packages = mc.getOwnedPackages();
/* 238 */         for (String pkg : packages)
/*     */         {
/* 240 */           this.packageOwners.put(pkg, mc);
/*     */         }
/*     */       } 
/* 243 */       if (mc.getMod() == null && !mc.isImmutable() && this.state != LoaderState.CONSTRUCTING) {
/*     */         
/* 245 */         FMLLog.severe("There is a severe problem with %s - it appears not to have constructed correctly", new Object[] { mc.getModId() });
/* 246 */         if (this.state != LoaderState.CONSTRUCTING)
/*     */         {
/* 248 */           errorOccurred(mc, new RuntimeException());
/*     */         }
/*     */       } 
/*     */     } 
/* 252 */     return builder.build();
/*     */   }
/*     */ 
/*     */   
/*     */   public void errorOccurred(ModContainer modContainer, Throwable exception) {
/* 257 */     if (exception instanceof InvocationTargetException) {
/*     */       
/* 259 */       this.errors.put(modContainer.getModId(), ((InvocationTargetException)exception).getCause());
/*     */     }
/*     */     else {
/*     */       
/* 263 */       this.errors.put(modContainer.getModId(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void printModStates(StringBuilder ret) {
/* 269 */     ret.append("\n\tStates:");
/* 270 */     for (LoaderState.ModState state : LoaderState.ModState.values()) {
/* 271 */       ret.append(" '").append(state.getMarker()).append("' = ").append(state.toString());
/*     */     }
/* 273 */     for (ModContainer mc : this.loader.getModList()) {
/*     */       
/* 275 */       ret.append("\n\t");
/* 276 */       for (LoaderState.ModState state : this.modStates.get(mc.getModId())) {
/* 277 */         ret.append(state.getMarker());
/*     */       }
/* 279 */       ret.append("\t").append(mc.getModId()).append("{").append(mc.getVersion()).append("} [").append(mc.getName()).append("] (").append(mc.getSource().getName()).append(") ");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ModContainer> getActiveModList() {
/* 285 */     return this.activeModList;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoaderState.ModState getModState(ModContainer selectedMod) {
/* 290 */     return (LoaderState.ModState)Iterables.getLast(this.modStates.get(selectedMod.getModId()), LoaderState.ModState.AVAILABLE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void distributeStateMessage(Class<?> customEvent) {
/*     */     try {
/* 297 */       this.masterChannel.post(customEvent.newInstance());
/*     */     }
/* 299 */     catch (Exception e) {
/*     */       
/* 301 */       FMLLog.log(Level.ERROR, e, "An unexpected exception", new Object[0]);
/* 302 */       throw new LoaderException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BiMap<ModContainer, Object> getModObjectList() {
/* 308 */     if (this.modObjectList == null) {
/*     */       
/* 310 */       FMLLog.severe("Detected an attempt by a mod %s to perform game activity during mod construction. This is a serious programming error.", new Object[] { this.activeContainer });
/* 311 */       return (BiMap<ModContainer, Object>)buildModObjectList();
/*     */     } 
/* 313 */     return (BiMap<ModContainer, Object>)ImmutableBiMap.copyOf((Map)this.modObjectList);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInState(LoaderState state) {
/* 318 */     return (this.state == state);
/*     */   }
/*     */   
/*     */   boolean hasReachedState(LoaderState state) {
/* 322 */     return (this.state.ordinal() >= state.ordinal() && this.state != LoaderState.ERRORED);
/*     */   }
/*     */ 
/*     */   
/*     */   void forceState(LoaderState newState) {
/* 327 */     this.state = newState;
/*     */   }
/*     */ 
/*     */   
/*     */   private ModContainer findActiveContainerFromStack() {
/* 332 */     for (Class<?> c : getCallingStack()) {
/*     */       
/* 334 */       int idx = c.getName().lastIndexOf('.');
/* 335 */       if (idx != -1) {
/*     */ 
/*     */ 
/*     */         
/* 339 */         String pkg = c.getName().substring(0, idx);
/* 340 */         if (this.packageOwners.containsKey(pkg))
/*     */         {
/* 342 */           return this.packageOwners.get(pkg).get(0);
/*     */         }
/*     */       } 
/*     */     } 
/* 346 */     return null;
/*     */   }
/* 348 */   public LoadController(Loader loader) { this.accessibleManager = new FMLSecurityManager();
/*     */     this.loader = loader;
/*     */     this.masterChannel = new EventBus("FMLMainChannel");
/*     */     this.masterChannel.register(this);
/*     */     this.state = LoaderState.NOINIT;
/*     */     this.packageOwners = (ListMultimap<String, ModContainer>)ArrayListMultimap.create(); } class FMLSecurityManager extends SecurityManager { Class<?>[] getStackClasses() {
/* 354 */       return getClassContext();
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   Class<?>[] getCallingStack() {
/* 360 */     return this.accessibleManager.getStackClasses();
/*     */   }
/*     */ 
/*     */   
/*     */   LoaderState getState() {
/* 365 */     return this.state;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\LoadController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */