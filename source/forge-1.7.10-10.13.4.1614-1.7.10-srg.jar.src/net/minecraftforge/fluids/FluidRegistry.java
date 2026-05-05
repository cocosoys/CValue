/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.registry.RegistryDelegate;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagString;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ public abstract class FluidRegistry
/*     */ {
/*  39 */   static int maxID = 0;
/*     */   
/*  41 */   static BiMap<String, Fluid> fluids = (BiMap<String, Fluid>)HashBiMap.create();
/*  42 */   static BiMap<Fluid, Integer> fluidIDs = (BiMap<Fluid, Integer>)HashBiMap.create();
/*  43 */   static BiMap<Integer, String> fluidNames = (BiMap<Integer, String>)HashBiMap.create();
/*     */   
/*     */   static BiMap<Block, Fluid> fluidBlocks;
/*     */   
/*  47 */   static BiMap<String, Fluid> masterFluidReference = (BiMap<String, Fluid>)HashBiMap.create();
/*  48 */   static BiMap<String, String> defaultFluidName = (BiMap<String, String>)HashBiMap.create();
/*  49 */   static Map<Fluid, FluidDelegate> delegates = Maps.newHashMap();
/*     */   
/*  51 */   public static final Fluid WATER = (new Fluid("water")
/*     */     {
/*     */       public String getLocalizedName() {
/*  54 */         return StatCollector.translateToLocal("tile.water.name");
/*     */       }
/*  56 */     }).setBlock(Blocks.water).setUnlocalizedName(Blocks.water.getUnlocalizedName());
/*     */   
/*  58 */   public static final Fluid LAVA = (new Fluid("lava")
/*     */     {
/*     */       public String getLocalizedName() {
/*  61 */         return StatCollector.translateToLocal("tile.lava.name");
/*     */       }
/*  63 */     }).setBlock(Blocks.lava).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300).setUnlocalizedName(Blocks.lava.getUnlocalizedName());
/*     */   
/*  65 */   public static int renderIdFluid = -1;
/*     */ 
/*     */   
/*     */   static {
/*  69 */     registerFluid(WATER);
/*  70 */     registerFluid(LAVA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initFluidIDs(BiMap<Fluid, Integer> newfluidIDs, Set<String> defaultNames) {
/*  81 */     maxID = newfluidIDs.size();
/*  82 */     loadFluidDefaults(newfluidIDs, defaultNames);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void loadFluidDefaults(BiMap<Fluid, Integer> localFluidIDs, Set<String> defaultNames) {
/*  93 */     if (defaultNames.isEmpty()) {
/*  94 */       defaultNames.addAll(defaultFluidName.values());
/*     */     }
/*  96 */     HashBiMap hashBiMap1 = HashBiMap.create((Map)fluids);
/*  97 */     for (String defaultName : defaultNames) {
/*     */       
/*  99 */       Fluid fluid = (Fluid)masterFluidReference.get(defaultName);
/* 100 */       if (fluid == null) {
/* 101 */         String derivedName = defaultName.split(":", 2)[1];
/* 102 */         String localDefault = (String)defaultFluidName.get(derivedName);
/* 103 */         if (localDefault == null) {
/* 104 */           FMLLog.getLogger().log(Level.ERROR, "The fluid {} (specified as {}) is missing from this instance - it will be removed", new Object[] { derivedName, defaultName });
/*     */           continue;
/*     */         } 
/* 107 */         fluid = (Fluid)masterFluidReference.get(localDefault);
/* 108 */         FMLLog.getLogger().log(Level.ERROR, "The fluid {} specified as default is not present - it will be reverted to default {}", new Object[] { defaultName, localDefault });
/*     */       } 
/* 110 */       FMLLog.getLogger().log(Level.DEBUG, "The fluid {} has been selected as the default fluid for {}", new Object[] { defaultName, fluid.getName() });
/* 111 */       Fluid oldFluid = (Fluid)hashBiMap1.put(fluid.getName(), fluid);
/* 112 */       Integer id = (Integer)localFluidIDs.remove(oldFluid);
/* 113 */       localFluidIDs.put(fluid, id);
/*     */     } 
/* 115 */     HashBiMap hashBiMap2 = HashBiMap.create();
/* 116 */     for (Map.Entry<Fluid, Integer> e : (Iterable<Map.Entry<Fluid, Integer>>)localFluidIDs.entrySet()) {
/* 117 */       hashBiMap2.put(e.getValue(), ((Fluid)e.getKey()).getName());
/*     */     }
/* 119 */     fluidIDs = localFluidIDs;
/* 120 */     fluids = (BiMap<String, Fluid>)hashBiMap1;
/* 121 */     fluidNames = (BiMap<Integer, String>)hashBiMap2;
/* 122 */     fluidBlocks = null;
/* 123 */     for (FluidDelegate fd : delegates.values())
/*     */     {
/* 125 */       fd.rebind();
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
/*     */   
/*     */   public static boolean registerFluid(Fluid fluid) {
/* 139 */     masterFluidReference.put(uniqueName(fluid), fluid);
/* 140 */     delegates.put(fluid, new FluidDelegate(fluid, fluid.getName()));
/* 141 */     if (fluids.containsKey(fluid.getName()))
/*     */     {
/* 143 */       return false;
/*     */     }
/* 145 */     fluids.put(fluid.getName(), fluid);
/* 146 */     maxID++;
/* 147 */     fluidIDs.put(fluid, Integer.valueOf(maxID));
/* 148 */     fluidNames.put(Integer.valueOf(maxID), fluid.getName());
/* 149 */     defaultFluidName.put(fluid.getName(), uniqueName(fluid));
/*     */     
/* 151 */     MinecraftForge.EVENT_BUS.post(new FluidRegisterEvent(fluid.getName(), maxID));
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String uniqueName(Fluid fluid) {
/* 157 */     ModContainer activeModContainer = Loader.instance().activeModContainer();
/* 158 */     String activeModContainerName = (activeModContainer == null) ? "minecraft" : activeModContainer.getModId();
/* 159 */     return activeModContainerName + ":" + fluid.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFluidDefault(Fluid fluid) {
/* 169 */     return fluids.containsValue(fluid);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isFluidRegistered(Fluid fluid) {
/* 179 */     return (fluid != null && fluids.containsKey(fluid.getName()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isFluidRegistered(String fluidName) {
/* 184 */     return fluids.containsKey(fluidName);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Fluid getFluid(String fluidName) {
/* 189 */     return (Fluid)fluids.get(fluidName);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Fluid getFluid(int fluidID) {
/* 194 */     return (Fluid)fluidIDs.inverse().get(Integer.valueOf(fluidID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getFluidID(Fluid fluid) {
/* 199 */     return ((Integer)fluidIDs.get(fluid)).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getFluidID(String fluidName) {
/* 204 */     return ((Integer)fluidIDs.get(getFluid(fluidName))).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static String getFluidName(int fluidID) {
/* 210 */     return (String)fluidNames.get(Integer.valueOf(fluidID));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getFluidName(Fluid fluid) {
/* 215 */     return (String)fluids.inverse().get(fluid);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getFluidName(FluidStack stack) {
/* 220 */     return getFluidName(stack.getFluid());
/*     */   }
/*     */ 
/*     */   
/*     */   public static FluidStack getFluidStack(String fluidName, int amount) {
/* 225 */     if (!fluids.containsKey(fluidName))
/*     */     {
/* 227 */       return null;
/*     */     }
/* 229 */     return new FluidStack(getFluid(fluidName), amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<String, Fluid> getRegisteredFluids() {
/* 237 */     return (Map<String, Fluid>)ImmutableMap.copyOf((Map)fluids);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static Map<String, Integer> getRegisteredFluidIDs() {
/* 246 */     return (Map<String, Integer>)ImmutableMap.copyOf((Map)fluidNames.inverse());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<Fluid, Integer> getRegisteredFluidIDsByFluid() {
/* 255 */     return (Map<Fluid, Integer>)ImmutableMap.copyOf((Map)fluidIDs);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Fluid lookupFluidForBlock(Block block) {
/* 260 */     if (fluidBlocks == null) {
/*     */       
/* 262 */       HashBiMap hashBiMap = HashBiMap.create();
/* 263 */       for (Fluid fluid : fluids.values()) {
/*     */         
/* 265 */         if (fluid.canBePlacedInWorld() && fluid.getBlock() != null)
/*     */         {
/* 267 */           hashBiMap.put(fluid.getBlock(), fluid);
/*     */         }
/*     */       } 
/* 270 */       fluidBlocks = (BiMap<Block, Fluid>)hashBiMap;
/*     */     } 
/* 272 */     return (Fluid)fluidBlocks.get(block);
/*     */   }
/*     */   
/*     */   public static class FluidRegisterEvent
/*     */     extends Event
/*     */   {
/*     */     public final String fluidName;
/*     */     public final int fluidID;
/*     */     
/*     */     public FluidRegisterEvent(String fluidName, int fluidID) {
/* 282 */       this.fluidName = fluidName;
/* 283 */       this.fluidID = fluidID;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMaxID() {
/* 289 */     return maxID;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getDefaultFluidName(Fluid key) {
/* 294 */     String name = (String)masterFluidReference.inverse().get(key);
/* 295 */     if (Strings.isNullOrEmpty(name)) {
/* 296 */       FMLLog.getLogger().log(Level.ERROR, "The fluid registry is corrupted. A fluid {} {} is not properly registered. The mod that registered this is broken", new Object[] { key.getClass().getName(), key.getName() });
/* 297 */       throw new IllegalStateException("The fluid registry is corrupted");
/*     */     } 
/* 299 */     return name;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadFluidDefaults(NBTTagCompound tag) {
/* 304 */     Set<String> defaults = Sets.newHashSet();
/* 305 */     if (tag.hasKey("DefaultFluidList", 9)) {
/*     */       
/* 307 */       FMLLog.getLogger().log(Level.DEBUG, "Loading persistent fluid defaults from world");
/* 308 */       NBTTagList tl = tag.getTagList("DefaultFluidList", 8);
/* 309 */       for (int i = 0; i < tl.tagCount(); i++)
/*     */       {
/* 311 */         defaults.add(tl.getStringTagAt(i));
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 316 */       FMLLog.getLogger().log(Level.DEBUG, "World is missing persistent fluid defaults - using local defaults");
/*     */     } 
/* 318 */     loadFluidDefaults((BiMap<Fluid, Integer>)HashBiMap.create((Map)fluidIDs), defaults);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void writeDefaultFluidList(NBTTagCompound forgeData) {
/* 323 */     NBTTagList tagList = new NBTTagList();
/*     */     
/* 325 */     for (Map.Entry<String, Fluid> def : (Iterable<Map.Entry<String, Fluid>>)fluids.entrySet())
/*     */     {
/* 327 */       tagList.appendTag((NBTBase)new NBTTagString(getDefaultFluidName(def.getValue())));
/*     */     }
/*     */     
/* 330 */     forgeData.setTag("DefaultFluidList", (NBTBase)tagList);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateFluidRegistry() {
/* 335 */     Set<Fluid> illegalFluids = Sets.newHashSet();
/* 336 */     for (Fluid f : fluids.values()) {
/*     */       
/* 338 */       if (!masterFluidReference.containsValue(f))
/*     */       {
/* 340 */         illegalFluids.add(f);
/*     */       }
/*     */     } 
/*     */     
/* 344 */     if (!illegalFluids.isEmpty()) {
/*     */       
/* 346 */       FMLLog.getLogger().log(Level.FATAL, "The fluid registry is corrupted. Something has inserted a fluid without registering it");
/* 347 */       FMLLog.getLogger().log(Level.FATAL, "There is {} unregistered fluids", new Object[] { Integer.valueOf(illegalFluids.size()) });
/* 348 */       for (Fluid f : illegalFluids) {
/*     */         
/* 350 */         FMLLog.getLogger().log(Level.FATAL, "  Fluid name : {}, type: {}", new Object[] { f.getName(), f.getClass().getName() });
/*     */       } 
/* 352 */       FMLLog.getLogger().log(Level.FATAL, "The mods that own these fluids need to register them properly");
/* 353 */       throw new IllegalStateException("The fluid map contains fluids unknown to the master fluid registry");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static RegistryDelegate<Fluid> makeDelegate(Fluid fl) {
/* 359 */     return delegates.get(fl);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class FluidDelegate
/*     */     implements RegistryDelegate<Fluid>
/*     */   {
/*     */     private String name;
/*     */     private Fluid fluid;
/*     */     
/*     */     FluidDelegate(Fluid fluid, String name) {
/* 370 */       this.fluid = fluid;
/* 371 */       this.name = name;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Fluid get() {
/* 377 */       return this.fluid;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String name() {
/* 383 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Class<Fluid> type() {
/* 389 */       return Fluid.class;
/*     */     }
/*     */ 
/*     */     
/*     */     void rebind() {
/* 394 */       this.fluid = (Fluid)FluidRegistry.fluids.get(this.name);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\FluidRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */