/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.common.event.FMLConstructionEvent;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartedEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStoppedEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStoppingEvent;
/*     */ import cpw.mods.fml.common.event.FMLStateEvent;
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
/*     */ public enum LoaderState
/*     */ {
/*  36 */   NOINIT("Uninitialized", null),
/*  37 */   LOADING("Loading", null),
/*  38 */   CONSTRUCTING("Constructing mods", (Class)FMLConstructionEvent.class),
/*  39 */   PREINITIALIZATION("Pre-initializing mods", (Class)FMLPreInitializationEvent.class),
/*  40 */   INITIALIZATION("Initializing mods", (Class)FMLInitializationEvent.class),
/*  41 */   POSTINITIALIZATION("Post-initializing mods", (Class)FMLPostInitializationEvent.class),
/*  42 */   AVAILABLE("Mod loading complete", (Class)FMLLoadCompleteEvent.class),
/*  43 */   SERVER_ABOUT_TO_START("Server about to start", (Class)FMLServerAboutToStartEvent.class),
/*  44 */   SERVER_STARTING("Server starting", (Class)FMLServerStartingEvent.class),
/*  45 */   SERVER_STARTED("Server started", (Class)FMLServerStartedEvent.class),
/*  46 */   SERVER_STOPPING("Server stopping", (Class)FMLServerStoppingEvent.class),
/*  47 */   SERVER_STOPPED("Server stopped", (Class)FMLServerStoppedEvent.class),
/*  48 */   ERRORED("Mod Loading errored", null);
/*     */ 
/*     */   
/*     */   private Class<? extends FMLStateEvent> eventClass;
/*     */   
/*     */   private String name;
/*     */ 
/*     */   
/*     */   LoaderState(String name, Class<? extends FMLStateEvent> event) {
/*  57 */     this.name = name;
/*  58 */     this.eventClass = event;
/*     */   }
/*     */ 
/*     */   
/*     */   public LoaderState transition(boolean errored) {
/*  63 */     if (errored)
/*     */     {
/*  65 */       return ERRORED;
/*     */     }
/*     */     
/*  68 */     if (this == SERVER_STOPPED)
/*     */     {
/*  70 */       return AVAILABLE;
/*     */     }
/*  72 */     return values()[(ordinal() < (values()).length) ? (ordinal() + 1) : ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEvent() {
/*  77 */     return (this.eventClass != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FMLStateEvent getEvent(Object... eventData) {
/*     */     try {
/*  84 */       return this.eventClass.getConstructor(new Class[] { Object[].class }).newInstance(new Object[] { eventData });
/*     */     }
/*  86 */     catch (Exception e) {
/*     */       
/*  88 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public LoaderState requiredState() {
/*  93 */     if (this == NOINIT) return NOINIT; 
/*  94 */     return values()[ordinal() - 1];
/*     */   }
/*     */   
/*     */   public enum ModState {
/*  98 */     UNLOADED("Unloaded", "U"),
/*  99 */     LOADED("Loaded", "L"),
/* 100 */     CONSTRUCTED("Constructed", "C"),
/* 101 */     PREINITIALIZED("Pre-initialized", "H"),
/* 102 */     INITIALIZED("Initialized", "I"),
/* 103 */     POSTINITIALIZED("Post-initialized", "J"),
/* 104 */     AVAILABLE("Available", "A"),
/* 105 */     DISABLED("Disabled", "D"),
/* 106 */     ERRORED("Errored", "E");
/*     */     
/*     */     private String label;
/*     */     
/*     */     private String marker;
/*     */     
/*     */     ModState(String label, String marker) {
/* 113 */       this.label = label;
/* 114 */       this.marker = marker;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 120 */       return this.label;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getMarker() {
/* 125 */       return this.marker;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\LoaderState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */