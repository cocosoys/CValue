/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.collect.HashMultiset;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.MapMaker;
/*     */ import com.google.common.collect.Multiset;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.BitSet;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.IWorldAccess;
/*     */ import net.minecraft.world.MinecraftException;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldManager;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldProviderEnd;
/*     */ import net.minecraft.world.WorldProviderHell;
/*     */ import net.minecraft.world.WorldProviderSurface;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldServerMulti;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ import net.minecraft.world.storage.SaveHandler;
/*     */ import net.minecraftforge.event.world.WorldEvent;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ public class DimensionManager
/*     */ {
/*  40 */   private static Hashtable<Integer, Class<? extends WorldProvider>> providers = new Hashtable<Integer, Class<? extends WorldProvider>>();
/*  41 */   private static Hashtable<Integer, Boolean> spawnSettings = new Hashtable<Integer, Boolean>();
/*  42 */   private static Hashtable<Integer, WorldServer> worlds = new Hashtable<Integer, WorldServer>();
/*     */   private static boolean hasInit = false;
/*  44 */   private static Hashtable<Integer, Integer> dimensions = new Hashtable<Integer, Integer>();
/*  45 */   private static ArrayList<Integer> unloadQueue = new ArrayList<Integer>();
/*  46 */   private static BitSet dimensionMap = new BitSet(1024);
/*  47 */   private static ConcurrentMap<World, World> weakWorldMap = (new MapMaker()).weakKeys().weakValues().makeMap();
/*  48 */   private static Multiset<Integer> leakedWorlds = (Multiset<Integer>)HashMultiset.create();
/*     */ 
/*     */   
/*     */   public static boolean registerProviderType(int id, Class<? extends WorldProvider> provider, boolean keepLoaded) {
/*  52 */     if (providers.containsKey(Integer.valueOf(id)))
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     providers.put(Integer.valueOf(id), provider);
/*  57 */     spawnSettings.put(Integer.valueOf(id), Boolean.valueOf(keepLoaded));
/*  58 */     return true;
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
/*     */   public static int[] unregisterProviderType(int id) {
/*  73 */     if (!providers.containsKey(Integer.valueOf(id)))
/*     */     {
/*  75 */       return new int[0];
/*     */     }
/*  77 */     providers.remove(Integer.valueOf(id));
/*  78 */     spawnSettings.remove(Integer.valueOf(id));
/*     */     
/*  80 */     int[] ret = new int[dimensions.size()];
/*  81 */     int x = 0;
/*  82 */     for (Map.Entry<Integer, Integer> ent : dimensions.entrySet()) {
/*     */       
/*  84 */       if (((Integer)ent.getValue()).intValue() == id)
/*     */       {
/*  86 */         ret[x++] = ((Integer)ent.getKey()).intValue();
/*     */       }
/*     */     } 
/*     */     
/*  90 */     return Arrays.copyOf(ret, x);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void init() {
/*  95 */     if (hasInit) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 100 */     hasInit = true;
/*     */     
/* 102 */     registerProviderType(0, (Class)WorldProviderSurface.class, true);
/* 103 */     registerProviderType(-1, (Class)WorldProviderHell.class, true);
/* 104 */     registerProviderType(1, (Class)WorldProviderEnd.class, false);
/* 105 */     registerDimension(0, 0);
/* 106 */     registerDimension(-1, -1);
/* 107 */     registerDimension(1, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerDimension(int id, int providerType) {
/* 112 */     if (!providers.containsKey(Integer.valueOf(providerType)))
/*     */     {
/* 114 */       throw new IllegalArgumentException(String.format("Failed to register dimension for id %d, provider type %d does not exist", new Object[] { Integer.valueOf(id), Integer.valueOf(providerType) }));
/*     */     }
/* 116 */     if (dimensions.containsKey(Integer.valueOf(id)))
/*     */     {
/* 118 */       throw new IllegalArgumentException(String.format("Failed to register dimension for id %d, One is already registered", new Object[] { Integer.valueOf(id) }));
/*     */     }
/* 120 */     dimensions.put(Integer.valueOf(id), Integer.valueOf(providerType));
/* 121 */     if (id >= 0)
/*     */     {
/* 123 */       dimensionMap.set(id);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregisterDimension(int id) {
/* 132 */     if (!dimensions.containsKey(Integer.valueOf(id)))
/*     */     {
/* 134 */       throw new IllegalArgumentException(String.format("Failed to unregister dimension for id %d; No provider registered", new Object[] { Integer.valueOf(id) }));
/*     */     }
/* 136 */     dimensions.remove(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isDimensionRegistered(int dim) {
/* 141 */     return dimensions.containsKey(Integer.valueOf(dim));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getProviderType(int dim) {
/* 146 */     if (!dimensions.containsKey(Integer.valueOf(dim)))
/*     */     {
/* 148 */       throw new IllegalArgumentException(String.format("Could not get provider type for dimension %d, does not exist", new Object[] { Integer.valueOf(dim) }));
/*     */     }
/* 150 */     return ((Integer)dimensions.get(Integer.valueOf(dim))).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldProvider getProvider(int dim) {
/* 155 */     return (getWorld(dim)).provider;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Integer[] getIDs(boolean check) {
/* 160 */     if (check) {
/*     */       
/* 162 */       List<World> allWorlds = Lists.newArrayList(weakWorldMap.keySet());
/* 163 */       allWorlds.removeAll(worlds.values());
/* 164 */       for (ListIterator<World> li = allWorlds.listIterator(); li.hasNext(); ) {
/*     */         
/* 166 */         World w = li.next();
/* 167 */         leakedWorlds.add(Integer.valueOf(System.identityHashCode(w)));
/*     */       } 
/* 169 */       for (World w : allWorlds) {
/*     */         
/* 171 */         int leakCount = leakedWorlds.count(Integer.valueOf(System.identityHashCode(w)));
/* 172 */         if (leakCount == 5) {
/*     */           
/* 174 */           FMLLog.fine("The world %x (%s) may have leaked: first encounter (5 occurences).\n", new Object[] { Integer.valueOf(System.identityHashCode(w)), w.getWorldInfo().getWorldName() }); continue;
/*     */         } 
/* 176 */         if (leakCount % 5 == 0)
/*     */         {
/* 178 */           FMLLog.fine("The world %x (%s) may have leaked: seen %d times.\n", new Object[] { Integer.valueOf(System.identityHashCode(w)), w.getWorldInfo().getWorldName(), Integer.valueOf(leakCount) });
/*     */         }
/*     */       } 
/*     */     } 
/* 182 */     return getIDs();
/*     */   }
/*     */   
/*     */   public static Integer[] getIDs() {
/* 186 */     return (Integer[])worlds.keySet().toArray((Object[])new Integer[worlds.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setWorld(int id, WorldServer world) {
/* 191 */     if (world != null) {
/*     */       
/* 193 */       worlds.put(Integer.valueOf(id), world);
/* 194 */       weakWorldMap.put(world, world);
/* 195 */       (MinecraftServer.getServer()).worldTickTimes.put(Integer.valueOf(id), new long[100]);
/* 196 */       FMLLog.info("Loading dimension %d (%s) (%s)", new Object[] { Integer.valueOf(id), world.getWorldInfo().getWorldName(), world.func_73046_m() });
/*     */     }
/*     */     else {
/*     */       
/* 200 */       worlds.remove(Integer.valueOf(id));
/* 201 */       (MinecraftServer.getServer()).worldTickTimes.remove(Integer.valueOf(id));
/* 202 */       FMLLog.info("Unloading dimension %d", new Object[] { Integer.valueOf(id) });
/*     */     } 
/*     */     
/* 205 */     ArrayList<WorldServer> tmp = new ArrayList<WorldServer>();
/* 206 */     if (worlds.get(Integer.valueOf(0)) != null)
/* 207 */       tmp.add(worlds.get(Integer.valueOf(0))); 
/* 208 */     if (worlds.get(Integer.valueOf(-1)) != null)
/* 209 */       tmp.add(worlds.get(Integer.valueOf(-1))); 
/* 210 */     if (worlds.get(Integer.valueOf(1)) != null) {
/* 211 */       tmp.add(worlds.get(Integer.valueOf(1)));
/*     */     }
/* 213 */     for (Map.Entry<Integer, WorldServer> entry : worlds.entrySet()) {
/*     */       
/* 215 */       int dim = ((Integer)entry.getKey()).intValue();
/* 216 */       if (dim >= -1 && dim <= 1) {
/*     */         continue;
/*     */       }
/*     */       
/* 220 */       tmp.add(entry.getValue());
/*     */     } 
/*     */     
/* 223 */     (MinecraftServer.getServer()).worldServers = tmp.<WorldServer>toArray(new WorldServer[tmp.size()]);
/*     */   }
/*     */   
/*     */   public static void initDimension(int dim) {
/* 227 */     WorldServer overworld = getWorld(0);
/* 228 */     if (overworld == null)
/*     */     {
/* 230 */       throw new RuntimeException("Cannot Hotload Dim: Overworld is not Loaded!");
/*     */     }
/*     */     
/*     */     try {
/* 234 */       getProviderType(dim);
/*     */     }
/* 236 */     catch (Exception e) {
/*     */       
/* 238 */       System.err.println("Cannot Hotload Dim: " + e.getMessage());
/*     */       return;
/*     */     } 
/* 241 */     MinecraftServer mcServer = overworld.func_73046_m();
/* 242 */     ISaveHandler savehandler = overworld.getSaveHandler();
/* 243 */     WorldSettings worldSettings = new WorldSettings(overworld.getWorldInfo());
/*     */     
/* 245 */     WorldServer world = (dim == 0) ? overworld : (WorldServer)new WorldServerMulti(mcServer, savehandler, overworld.getWorldInfo().getWorldName(), dim, worldSettings, overworld, mcServer.theProfiler);
/* 246 */     world.addWorldAccess((IWorldAccess)new WorldManager(mcServer, world));
/* 247 */     MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Load((World)world));
/* 248 */     if (!mcServer.isSinglePlayer())
/*     */     {
/* 250 */       world.getWorldInfo().setGameType(mcServer.getGameType());
/*     */     }
/*     */     
/* 253 */     mcServer.func_147139_a(mcServer.func_147135_j());
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldServer getWorld(int id) {
/* 258 */     return worlds.get(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldServer[] getWorlds() {
/* 263 */     return (WorldServer[])worlds.values().toArray((Object[])new WorldServer[worlds.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean shouldLoadSpawn(int dim) {
/* 268 */     int id = getProviderType(dim);
/* 269 */     return (spawnSettings.containsKey(Integer.valueOf(id)) && ((Boolean)spawnSettings.get(Integer.valueOf(id))).booleanValue());
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 274 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Integer[] getStaticDimensionIDs() {
/* 283 */     return (Integer[])dimensions.keySet().toArray((Object[])new Integer[dimensions.keySet().size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static WorldProvider createProviderFor(int dim) {
/*     */     try {
/* 289 */       if (dimensions.containsKey(Integer.valueOf(dim))) {
/*     */         
/* 291 */         WorldProvider provider = ((Class<WorldProvider>)providers.get(Integer.valueOf(getProviderType(dim)))).newInstance();
/* 292 */         provider.setDimension(dim);
/* 293 */         return provider;
/*     */       } 
/*     */ 
/*     */       
/* 297 */       throw new RuntimeException(String.format("No WorldProvider bound for dimension %d", new Object[] { Integer.valueOf(dim) }));
/*     */     
/*     */     }
/* 300 */     catch (Exception e) {
/*     */       
/* 302 */       FMLCommonHandler.instance().getFMLLogger().log(Level.ERROR, String.format("An error occured trying to create an instance of WorldProvider %d (%s)", new Object[] {
/* 303 */               Integer.valueOf(dim), ((Class)providers.get(Integer.valueOf(getProviderType(dim)))).getSimpleName() }), e);
/* 304 */       throw new RuntimeException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void unloadWorld(int id) {
/* 309 */     unloadQueue.add(Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unloadWorlds(Hashtable<Integer, long[]> worldTickTimes) {
/* 316 */     for (Iterator<Integer> iterator = unloadQueue.iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/* 317 */       WorldServer w = worlds.get(Integer.valueOf(id));
/*     */       try {
/* 319 */         if (w != null) {
/*     */           
/* 321 */           w.saveAllChunks(true, null);
/*     */         }
/*     */         else {
/*     */           
/* 325 */           FMLLog.warning("Unexpected world unload - world %d is already unloaded", new Object[] { Integer.valueOf(id) });
/*     */         } 
/* 327 */       } catch (MinecraftException e) {
/* 328 */         e.printStackTrace();
/*     */       }
/*     */       finally {
/*     */         
/* 332 */         if (w != null) {
/*     */           
/* 334 */           MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.Unload((World)w));
/* 335 */           w.flush();
/* 336 */           setWorld(id, null);
/*     */         } 
/*     */       }  }
/*     */     
/* 340 */     unloadQueue.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getNextFreeDimId() {
/* 349 */     int next = 0;
/*     */     
/*     */     while (true) {
/* 352 */       next = dimensionMap.nextClearBit(next);
/* 353 */       if (dimensions.containsKey(Integer.valueOf(next))) {
/*     */         
/* 355 */         dimensionMap.set(next); continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 359 */     return next;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NBTTagCompound saveDimensionDataMap() {
/* 366 */     int[] data = new int[(dimensionMap.length() + 32 - 1) / 32];
/* 367 */     NBTTagCompound dimMap = new NBTTagCompound();
/* 368 */     for (int i = 0; i < data.length; i++) {
/*     */       
/* 370 */       int val = 0;
/* 371 */       for (int j = 0; j < 32; j++)
/*     */       {
/* 373 */         val |= dimensionMap.get(i * 32 + j) ? (1 << j) : 0;
/*     */       }
/* 375 */       data[i] = val;
/*     */     } 
/* 377 */     dimMap.setIntArray("DimensionArray", data);
/* 378 */     return dimMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void loadDimensionDataMap(NBTTagCompound compoundTag) {
/* 383 */     dimensionMap.clear();
/* 384 */     if (compoundTag == null) {
/*     */       
/* 386 */       for (Integer id : dimensions.keySet())
/*     */       {
/* 388 */         if (id.intValue() >= 0)
/*     */         {
/* 390 */           dimensionMap.set(id.intValue());
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 396 */       int[] intArray = compoundTag.getIntArray("DimensionArray");
/* 397 */       for (int i = 0; i < intArray.length; i++) {
/*     */         
/* 399 */         for (int j = 0; j < 32; j++)
/*     */         {
/* 401 */           dimensionMap.set(i * 32 + j, ((intArray[i] & 1 << j) != 0));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getCurrentSaveRootDirectory() {
/* 413 */     if (getWorld(0) != null)
/*     */     {
/* 415 */       return ((SaveHandler)getWorld(0).getSaveHandler()).getWorldDirectory();
/*     */     }
/* 417 */     if (MinecraftServer.getServer() != null) {
/*     */       
/* 419 */       MinecraftServer srv = MinecraftServer.getServer();
/* 420 */       SaveHandler saveHandler = (SaveHandler)srv.getActiveAnvilConverter().getSaveLoader(srv.getFolderName(), false);
/* 421 */       return saveHandler.getWorldDirectory();
/*     */     } 
/*     */ 
/*     */     
/* 425 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\DimensionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */