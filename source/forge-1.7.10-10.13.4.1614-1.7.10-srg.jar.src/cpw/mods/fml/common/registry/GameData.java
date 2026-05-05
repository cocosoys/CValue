/*      */ package cpw.mods.fml.common.registry;
/*      */ 
/*      */ import com.google.common.base.Charsets;
/*      */ import com.google.common.base.Joiner;
/*      */ import com.google.common.collect.BiMap;
/*      */ import com.google.common.collect.HashBasedTable;
/*      */ import com.google.common.collect.HashBiMap;
/*      */ import com.google.common.collect.ImmutableList;
/*      */ import com.google.common.collect.ImmutableListMultimap;
/*      */ import com.google.common.collect.ImmutableMap;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.common.collect.Sets;
/*      */ import com.google.common.collect.Table;
/*      */ import com.google.common.io.Files;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.FMLLog;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.common.ModContainer;
/*      */ import cpw.mods.fml.common.StartupQuery;
/*      */ import cpw.mods.fml.common.ZipperUtil;
/*      */ import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.BitSet;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemBlock;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import org.apache.logging.log4j.Level;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GameData
/*      */ {
/*      */   static final int MIN_BLOCK_ID = 0;
/*      */   static final int MAX_BLOCK_ID = 4095;
/*      */   static final int MIN_ITEM_ID = 4096;
/*      */   static final int MAX_ITEM_ID = 31999;
/*   66 */   private static final GameData mainData = new GameData();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*   72 */   public static final FMLControlledNamespacedRegistry<Block> blockRegistry = getBlockRegistry();
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*   77 */   public static final FMLControlledNamespacedRegistry<Item> itemRegistry = getItemRegistry();
/*      */   
/*   79 */   private static Table<String, String, ItemStack> customItemStacks = (Table<String, String, ItemStack>)HashBasedTable.create();
/*   80 */   private static Map<GameRegistry.UniqueIdentifier, ModContainer> customOwners = Maps.newHashMap();
/*      */   
/*      */   private static GameData frozen;
/*      */   private final FMLControlledNamespacedRegistry<Block> iBlockRegistry;
/*      */   private final FMLControlledNamespacedRegistry<Item> iItemRegistry;
/*      */   private final BitSet availabilityMap;
/*      */   private final Set<Integer> blockedIds;
/*      */   private BiMap<String, Item> itemSubstitutions;
/*      */   private BiMap<String, Block> blockSubstitutions;
/*      */   
/*      */   public static FMLControlledNamespacedRegistry<Block> getBlockRegistry() {
/*   91 */     return (getMain()).iBlockRegistry;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FMLControlledNamespacedRegistry<Item> getItemRegistry() {
/*  100 */     return (getMain()).iItemRegistry;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static ModContainer findModOwner(String string) {
/*  109 */     GameRegistry.UniqueIdentifier ui = new GameRegistry.UniqueIdentifier(string);
/*  110 */     if (customOwners.containsKey(ui))
/*      */     {
/*  112 */       return customOwners.get(ui);
/*      */     }
/*  114 */     return (ModContainer)Loader.instance().getIndexedModList().get(ui.modId);
/*      */   }
/*      */ 
/*      */   
/*      */   public static class GameDataSnapshot
/*      */   {
/*      */     public final Map<String, Integer> idMap;
/*      */     public final Set<String> blockSubstitutions;
/*      */     public final Set<String> itemSubstitutions;
/*      */     
/*      */     public GameDataSnapshot(Map<String, Integer> idMap, Set<String> blockSubstitutions, Set<String> itemSubstitutions) {
/*  125 */       this.idMap = idMap;
/*  126 */       this.blockSubstitutions = blockSubstitutions;
/*  127 */       this.itemSubstitutions = itemSubstitutions;
/*      */     }
/*      */   }
/*      */   
/*      */   public static GameDataSnapshot buildItemDataList() {
/*  132 */     Map<String, Integer> idMapping = Maps.newHashMap();
/*  133 */     (getMain()).iBlockRegistry.serializeInto(idMapping);
/*  134 */     (getMain()).iItemRegistry.serializeInto(idMapping);
/*  135 */     Set<String> blockSubs = Sets.newHashSet();
/*  136 */     (getMain()).iBlockRegistry.serializeSubstitutions(blockSubs);
/*  137 */     Set<String> itemSubs = Sets.newHashSet();
/*  138 */     (getMain()).iItemRegistry.serializeSubstitutions(itemSubs);
/*  139 */     return new GameDataSnapshot(idMapping, blockSubs, itemSubs);
/*      */   }
/*      */ 
/*      */   
/*      */   public static int[] getBlockedIds() {
/*  144 */     int[] ret = new int[(getMain()).blockedIds.size()];
/*  145 */     int index = 0;
/*      */     
/*  147 */     for (Iterator<Integer> iterator = (getMain()).blockedIds.iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/*      */       
/*  149 */       ret[index] = id;
/*  150 */       index++; }
/*      */ 
/*      */     
/*  153 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dumpRegistry(File minecraftDir) {
/*  158 */     if (customItemStacks == null) {
/*      */       return;
/*      */     }
/*      */     
/*  162 */     if (Boolean.valueOf(System.getProperty("fml.dumpRegistry", "false")).booleanValue()) {
/*      */       
/*  164 */       ImmutableListMultimap.Builder<String, String> builder = ImmutableListMultimap.builder();
/*  165 */       for (String modId : customItemStacks.rowKeySet())
/*      */       {
/*  167 */         builder.putAll(modId, customItemStacks.row(modId).keySet());
/*      */       }
/*      */       
/*  170 */       File f = new File(minecraftDir, "itemStackRegistry.csv");
/*  171 */       Joiner.MapJoiner mapJoiner = Joiner.on("\n").withKeyValueSeparator(",");
/*      */       
/*      */       try {
/*  174 */         Files.write(mapJoiner.join((Iterable)builder.build().entries()), f, Charsets.UTF_8);
/*  175 */         FMLLog.log(Level.INFO, "Dumped item registry data to %s", new Object[] { f.getAbsolutePath() });
/*      */       }
/*  177 */       catch (IOException e) {
/*      */         
/*  179 */         FMLLog.log(Level.ERROR, e, "Failed to write registry data to %s", new Object[] { f.getAbsolutePath() });
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   static Item findItem(String modId, String name) {
/*  186 */     return (getMain()).iItemRegistry.getObject(modId + ":" + name);
/*      */   }
/*      */ 
/*      */   
/*      */   static Block findBlock(String modId, String name) {
/*  191 */     String key = modId + ":" + name;
/*  192 */     return (getMain()).iBlockRegistry.containsKey(key) ? (getMain()).iBlockRegistry.getObject(key) : null;
/*      */   }
/*      */ 
/*      */   
/*      */   static ItemStack findItemStack(String modId, String name) {
/*  197 */     ItemStack is = (ItemStack)customItemStacks.get(modId, name);
/*  198 */     if (is == null) {
/*      */       
/*  200 */       Item i = findItem(modId, name);
/*  201 */       if (i != null)
/*      */       {
/*  203 */         is = new ItemStack(i, 0, 0);
/*      */       }
/*      */     } 
/*  206 */     if (is == null) {
/*      */       
/*  208 */       Block b = findBlock(modId, name);
/*  209 */       if (b != null)
/*      */       {
/*  211 */         is = new ItemStack(b, 0, 32767);
/*      */       }
/*      */     } 
/*  214 */     return is;
/*      */   }
/*      */ 
/*      */   
/*      */   static void registerCustomItemStack(String name, ItemStack itemStack) {
/*  219 */     customItemStacks.put(Loader.instance().activeModContainer().getModId(), name, itemStack);
/*      */   }
/*      */ 
/*      */   
/*      */   static GameRegistry.UniqueIdentifier getUniqueName(Block block) {
/*  224 */     if (block == null) return null; 
/*  225 */     String name = (getMain()).iBlockRegistry.getNameForObject(block);
/*  226 */     GameRegistry.UniqueIdentifier ui = new GameRegistry.UniqueIdentifier(name);
/*  227 */     if (customItemStacks.contains(ui.modId, ui.name))
/*      */     {
/*  229 */       return null;
/*      */     }
/*      */     
/*  232 */     return ui;
/*      */   }
/*      */ 
/*      */   
/*      */   static GameRegistry.UniqueIdentifier getUniqueName(Item item) {
/*  237 */     if (item == null) return null; 
/*  238 */     String name = (getMain()).iItemRegistry.getNameForObject(item);
/*  239 */     GameRegistry.UniqueIdentifier ui = new GameRegistry.UniqueIdentifier(name);
/*  240 */     if (customItemStacks.contains(ui.modId, ui.name))
/*      */     {
/*  242 */       return null;
/*      */     }
/*      */     
/*  245 */     return ui;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void fixBrokenIds(Map<String, Integer> dataList, Set<Integer> blockedIds) {
/*  258 */     BitSet availabilityMap = new BitSet(32000);
/*      */ 
/*      */     
/*  261 */     for (Map.Entry<String, Integer> entry : dataList.entrySet()) {
/*      */       
/*  263 */       String itemName = entry.getKey();
/*      */       
/*  265 */       String realName = itemName.substring(1);
/*      */       
/*  267 */       if (itemName.charAt(0) == '\001')
/*      */       {
/*  269 */         availabilityMap.set(((Integer)entry.getValue()).intValue());
/*      */       }
/*      */     } 
/*      */     
/*  273 */     Set<Integer> newBlockedIds = new HashSet<Integer>();
/*  274 */     Set<String> itemsToRemove = new HashSet<String>();
/*  275 */     Map<String, Integer> itemsToRelocate = new HashMap<String, Integer>();
/*      */ 
/*      */     
/*  278 */     for (Map.Entry<String, Integer> entry : dataList.entrySet()) {
/*      */       
/*  280 */       String itemName = entry.getKey();
/*      */       
/*  282 */       if (itemName.charAt(0) != '\001') {
/*      */         
/*  284 */         int oldId = ((Integer)entry.getValue()).intValue();
/*  285 */         String realName = itemName.substring(1);
/*  286 */         String blockName = '\001' + realName;
/*  287 */         Item item = (getMain()).iItemRegistry.getRaw(realName);
/*  288 */         boolean blockThisId = false;
/*      */         
/*  290 */         if (item == null) {
/*      */ 
/*      */           
/*  293 */           FMLLog.warning("Item %s (old id %d) is no longer available and thus can't be fixed.", new Object[] { realName, Integer.valueOf(oldId) });
/*  294 */           itemsToRemove.add(itemName);
/*  295 */           blockThisId = true;
/*      */         }
/*  297 */         else if (item instanceof ItemBlock) {
/*      */           
/*  299 */           if (dataList.containsKey(blockName))
/*      */           {
/*  301 */             int blockId = ((Integer)dataList.get(blockName)).intValue();
/*      */             
/*  303 */             if (blockId != oldId)
/*      */             {
/*      */               
/*  306 */               FMLLog.warning("ItemBlock %s (old id %d) doesn't have the same id as its block (%d).", new Object[] { realName, Integer.valueOf(oldId), Integer.valueOf(blockId) });
/*  307 */               itemsToRelocate.put(entry.getKey(), Integer.valueOf(blockId));
/*  308 */               blockThisId = true;
/*      */             }
/*      */             else
/*      */             {
/*  312 */               availabilityMap.set(oldId);
/*      */             }
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  318 */             FMLLog.warning("Item %s (old id %d) has been migrated to an ItemBlock and can't be fixed.", new Object[] { realName, Integer.valueOf(oldId) });
/*  319 */             itemsToRemove.add(itemName);
/*  320 */             blockThisId = true;
/*      */           }
/*      */         
/*  323 */         } else if (availabilityMap.get(oldId)) {
/*      */ 
/*      */           
/*  326 */           FMLLog.warning("Item %s (old id %d) is conflicting with another block/item and can't be fixed.", new Object[] { realName, Integer.valueOf(oldId) });
/*  327 */           itemsToRemove.add(itemName);
/*      */         }
/*      */         else {
/*      */           
/*  331 */           availabilityMap.set(oldId);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  336 */         if (blockThisId && !availabilityMap.get(oldId)) {
/*      */ 
/*      */ 
/*      */           
/*  340 */           newBlockedIds.add(Integer.valueOf(oldId));
/*  341 */           availabilityMap.set(oldId);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  346 */     if (itemsToRemove.isEmpty() && itemsToRelocate.isEmpty()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  355 */     String text = "Forge Mod Loader detected that this save is damaged.\n\nIt's likely that an automatic repair can successfully restore\nmost of it, except some items which may get swapped with others.\n\nA world backup will be created as a zip file in your saves\ndirectory automatically.\n\n" + itemsToRemove.size() + " items need to be removed.\n" + itemsToRelocate.size() + " items need to be relocated.";
/*      */     
/*  357 */     boolean confirmed = StartupQuery.confirm(text);
/*  358 */     if (!confirmed) StartupQuery.abort();
/*      */ 
/*      */     
/*  361 */     Set<String> modsMissing = new HashSet<String>();
/*      */     
/*  363 */     for (String itemName : itemsToRemove)
/*      */     {
/*  365 */       modsMissing.add(itemName.substring(1, itemName.indexOf(':')));
/*      */     }
/*      */     Iterator<String> it;
/*  368 */     for (it = modsMissing.iterator(); it.hasNext(); ) {
/*      */       
/*  370 */       String mod = it.next();
/*      */       
/*  372 */       if (mod.equals("minecraft") || Loader.isModLoaded(mod)) it.remove();
/*      */     
/*      */     } 
/*  375 */     if (!modsMissing.isEmpty()) {
/*      */       
/*  377 */       text = "Forge Mod Loader detected that " + modsMissing.size() + " mods are missing.\n\n" + "If you continue items previously provided by those mods will be\n" + "removed while repairing this world save.\n\n" + "Missing mods:\n";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  382 */       for (it = modsMissing.iterator(); it.hasNext(); ) { String mod = it.next(); text = text + mod + "\n"; }
/*      */       
/*  384 */       confirmed = StartupQuery.confirm(text);
/*  385 */       if (!confirmed) StartupQuery.abort();
/*      */     
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  391 */       String skip = System.getProperty("fml.doNotBackup");
/*  392 */       if (skip == null || !"true".equals(skip)) {
/*      */         
/*  394 */         ZipperUtil.backupWorld();
/*      */       }
/*      */       else {
/*      */         
/*  398 */         for (int x = 0; x < 10; x++) {
/*  399 */           FMLLog.severe("!!!!!!!!!! UPDATING WORLD WITHOUT DOING BACKUP !!!!!!!!!!!!!!!!", new Object[0]);
/*      */         }
/*      */       } 
/*  402 */     } catch (IOException e) {
/*      */       
/*  404 */       StartupQuery.notify("The world backup couldn't be created.\n\n" + e);
/*  405 */       StartupQuery.abort();
/*      */     } 
/*      */ 
/*      */     
/*  409 */     for (it = itemsToRemove.iterator(); it.hasNext(); ) { String itemName = it.next();
/*      */       
/*  411 */       int id = ((Integer)dataList.remove(itemName)).intValue();
/*      */       
/*  413 */       FMLLog.warning("Removed Item %s, old id %d.", new Object[] { itemName.substring(1), Integer.valueOf(id) }); }
/*      */ 
/*      */     
/*  416 */     for (it = itemsToRelocate.entrySet().iterator(); it.hasNext(); ) { Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
/*      */       
/*  418 */       String itemName = entry.getKey();
/*  419 */       int newId = ((Integer)entry.getValue()).intValue();
/*      */       
/*  421 */       int oldId = ((Integer)dataList.put(itemName, Integer.valueOf(newId))).intValue();
/*      */       
/*  423 */       FMLLog.warning("Remapped Item %s to id %d, old id %d.", new Object[] { itemName.substring(1), Integer.valueOf(newId), Integer.valueOf(oldId) }); }
/*      */ 
/*      */     
/*  426 */     blockedIds.addAll(newBlockedIds);
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<String> injectWorldIDMap(Map<String, Integer> dataList, Set<String> blockSubstitutions, Set<String> itemSubstitutions, boolean injectFrozenData, boolean isLocalWorld) {
/*  431 */     return injectWorldIDMap(dataList, new HashSet<Integer>(), new HashMap<String, String>(), new HashMap<String, String>(), blockSubstitutions, itemSubstitutions, injectFrozenData, isLocalWorld);
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<String> injectWorldIDMap(Map<String, Integer> dataList, Set<Integer> blockedIds, Map<String, String> blockAliases, Map<String, String> itemAliases, Set<String> blockSubstitutions, Set<String> itemSubstitutions, boolean injectFrozenData, boolean isLocalWorld) {
/*  436 */     FMLLog.info("Injecting existing block and item data into this %s instance", new Object[] { FMLCommonHandler.instance().getEffectiveSide().isServer() ? "server" : "client" });
/*  437 */     Map<String, Integer[]> remaps = Maps.newHashMap();
/*  438 */     LinkedHashMap<String, Integer> missingMappings = new LinkedHashMap<String, Integer>();
/*  439 */     getMain().testConsistency();
/*  440 */     (getMain()).iBlockRegistry.dump();
/*  441 */     (getMain()).iItemRegistry.dump();
/*      */     
/*  443 */     (getMain()).iItemRegistry.resetSubstitutionDelegates();
/*  444 */     GameData newData = new GameData();
/*      */     
/*  446 */     for (null = blockedIds.iterator(); null.hasNext(); ) { int id = ((Integer)null.next()).intValue();
/*      */       
/*  448 */       newData.block(id); }
/*      */ 
/*      */     
/*  451 */     for (Map.Entry<String, String> entry : blockAliases.entrySet())
/*      */     {
/*  453 */       newData.iBlockRegistry.addAlias(entry.getKey(), entry.getValue());
/*      */     }
/*      */     
/*  456 */     for (Map.Entry<String, String> entry : itemAliases.entrySet())
/*      */     {
/*  458 */       newData.iItemRegistry.addAlias(entry.getKey(), entry.getValue());
/*      */     }
/*      */     
/*  461 */     for (String entry : blockSubstitutions)
/*      */     {
/*  463 */       newData.iBlockRegistry.activateSubstitution(entry);
/*      */     }
/*  465 */     for (String entry : itemSubstitutions)
/*      */     {
/*  467 */       newData.iItemRegistry.activateSubstitution(entry);
/*      */     }
/*  469 */     if (injectFrozenData) {
/*      */       
/*  471 */       for (String newBlockSubstitution : (getMain()).blockSubstitutions.keySet()) {
/*      */         
/*  473 */         if (!blockSubstitutions.contains(newBlockSubstitution))
/*      */         {
/*  475 */           newData.iBlockRegistry.activateSubstitution(newBlockSubstitution);
/*      */         }
/*      */       } 
/*  478 */       for (String newItemSubstitution : (getMain()).itemSubstitutions.keySet()) {
/*      */         
/*  480 */         if (!itemSubstitutions.contains(newItemSubstitution))
/*      */         {
/*  482 */           newData.iItemRegistry.activateSubstitution(newItemSubstitution);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  488 */     for (int pass = 0; pass < 2; pass++) {
/*      */       
/*  490 */       boolean isBlock = (pass == 0);
/*      */       
/*  492 */       for (Map.Entry<String, Integer> entry : dataList.entrySet()) {
/*      */         
/*  494 */         String itemName = entry.getKey();
/*  495 */         int newId = ((Integer)entry.getValue()).intValue();
/*      */ 
/*      */         
/*  498 */         if (((itemName.charAt(0) == '\001')) != isBlock)
/*      */           continue; 
/*  500 */         itemName = itemName.substring(1);
/*  501 */         int currId = isBlock ? (getMain()).iBlockRegistry.getId(itemName) : (getMain()).iItemRegistry.getId(itemName);
/*      */         
/*  503 */         if (currId == -1) {
/*      */           
/*  505 */           FMLLog.info("Found a missing id from the world %s", new Object[] { itemName });
/*  506 */           missingMappings.put(entry.getKey(), Integer.valueOf(newId));
/*      */           continue;
/*      */         } 
/*  509 */         if (currId != newId) {
/*      */           
/*  511 */           FMLLog.fine("Fixed %s id mismatch %s: %d (init) -> %d (map).", new Object[] { isBlock ? "block" : "item", itemName, Integer.valueOf(currId), Integer.valueOf(newId) });
/*  512 */           remaps.put(itemName, new Integer[] { Integer.valueOf(currId), Integer.valueOf(newId) });
/*      */         } 
/*      */ 
/*      */         
/*  516 */         if (isBlock) {
/*      */           
/*  518 */           currId = newData.registerBlock((getMain()).iBlockRegistry.getRaw(itemName), itemName, newId);
/*      */         }
/*      */         else {
/*      */           
/*  522 */           currId = newData.registerItem((getMain()).iItemRegistry.getRaw(itemName), itemName, newId);
/*      */         } 
/*      */         
/*  525 */         if (currId != newId)
/*      */         {
/*  527 */           throw new IllegalStateException(String.format("Can't map %s %s to id %d (seen at: %d), already occupied by %s, blocked %b, ItemBlock %b", new Object[] { isBlock ? "block" : "item", itemName, 
/*      */ 
/*      */                   
/*  530 */                   Integer.valueOf(newId), 
/*  531 */                   Integer.valueOf(currId), isBlock ? newData.iBlockRegistry
/*  532 */                   .getRaw(newId) : newData.iItemRegistry.getRaw(newId), 
/*  533 */                   Boolean.valueOf(newData.blockedIds.contains(Integer.valueOf(newId))), 
/*  534 */                   Boolean.valueOf(isBlock ? false : ((getMain()).iItemRegistry.getRaw(currId) instanceof ItemBlock)) }));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  539 */     List<String> missedMappings = Loader.instance().fireMissingMappingEvent(missingMappings, isLocalWorld, newData, remaps);
/*  540 */     if (!missedMappings.isEmpty()) return missedMappings;
/*      */     
/*  542 */     if (injectFrozenData) {
/*      */       
/*  544 */       Map<String, Integer> missingBlocks = frozen.iBlockRegistry.getEntriesNotIn(newData.iBlockRegistry);
/*  545 */       Map<String, Integer> missingItems = frozen.iItemRegistry.getEntriesNotIn(newData.iItemRegistry);
/*      */       
/*  547 */       if (!missingBlocks.isEmpty() || !missingItems.isEmpty()) {
/*      */         
/*  549 */         FMLLog.info("Injecting new block and item data into this server instance.", new Object[0]);
/*      */         
/*  551 */         for (int i = 0; i < 2; i++) {
/*      */           
/*  553 */           boolean isBlock = (i == 0);
/*  554 */           Map<String, Integer> missing = (i == 0) ? missingBlocks : missingItems;
/*      */           
/*  556 */           for (Map.Entry<String, Integer> entry : missing.entrySet()) {
/*      */             int newId;
/*  558 */             String itemName = entry.getKey();
/*  559 */             int currId = ((Integer)entry.getValue()).intValue();
/*      */ 
/*      */             
/*  562 */             if (isBlock) {
/*      */               
/*  564 */               newId = newData.registerBlock(frozen.iBlockRegistry.getRaw(itemName), itemName, currId);
/*      */             }
/*      */             else {
/*      */               
/*  568 */               newId = newData.registerItem(frozen.iItemRegistry.getRaw(itemName), itemName, currId);
/*      */             } 
/*      */             
/*  571 */             FMLLog.info("Injected new block/item %s: %d (init) -> %d (map).", new Object[] { itemName, Integer.valueOf(currId), Integer.valueOf(newId) });
/*      */             
/*  573 */             if (newId != currId)
/*      */             {
/*  575 */               remaps.put(itemName, new Integer[] { entry.getValue(), Integer.valueOf(newId) });
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  582 */     newData.testConsistency();
/*  583 */     getMain().set(newData);
/*      */     
/*  585 */     (getMain()).iBlockRegistry.dump();
/*  586 */     (getMain()).iItemRegistry.dump();
/*  587 */     Loader.instance().fireRemapEvent(remaps);
/*      */     
/*  589 */     ObjectHolderRegistry.INSTANCE.applyObjectHolders();
/*  590 */     return (List<String>)ImmutableList.of();
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<String> processIdRematches(Iterable<FMLMissingMappingsEvent.MissingMapping> missedMappings, boolean isLocalWorld, GameData gameData, Map<String, Integer[]> remaps) {
/*  595 */     List<String> failed = Lists.newArrayList();
/*  596 */     List<String> ignored = Lists.newArrayList();
/*  597 */     List<String> warned = Lists.newArrayList();
/*  598 */     List<String> defaulted = Lists.newArrayList();
/*      */     
/*  600 */     for (FMLMissingMappingsEvent.MissingMapping remap : missedMappings) {
/*      */       
/*  602 */       FMLMissingMappingsEvent.Action action = remap.getAction();
/*      */       
/*  604 */       if (action == FMLMissingMappingsEvent.Action.REMAP) {
/*      */         int currId;
/*      */         
/*      */         int newId;
/*      */         
/*      */         String newName;
/*  610 */         if (remap.type == GameRegistry.Type.BLOCK) {
/*      */           
/*  612 */           currId = (getMain()).iBlockRegistry.getId((Block)remap.getTarget());
/*  613 */           newName = (getMain()).iBlockRegistry.getNameForObject(remap.getTarget());
/*  614 */           FMLLog.fine("The Block %s is being remapped to %s.", new Object[] { remap.name, newName });
/*      */           
/*  616 */           newId = gameData.registerBlock((Block)remap.getTarget(), newName, remap.id);
/*  617 */           gameData.iBlockRegistry.addAlias(remap.name, newName);
/*      */         }
/*      */         else {
/*      */           
/*  621 */           currId = (getMain()).iItemRegistry.getId((Item)remap.getTarget());
/*  622 */           newName = (getMain()).iItemRegistry.getNameForObject(remap.getTarget());
/*  623 */           FMLLog.fine("The Item %s is being remapped to %s.", new Object[] { remap.name, newName });
/*      */           
/*  625 */           newId = gameData.registerItem((Item)remap.getTarget(), newName, remap.id);
/*  626 */           gameData.iItemRegistry.addAlias(remap.name, newName);
/*      */         } 
/*      */         
/*  629 */         if (newId != remap.id) throw new IllegalStateException();
/*      */         
/*  631 */         if (currId != newId) {
/*      */           
/*  633 */           FMLLog.info("Fixed %s id mismatch %s: %d (init) -> %d (map).", new Object[] { (remap.type == GameRegistry.Type.BLOCK) ? "block" : "item", newName, Integer.valueOf(currId), Integer.valueOf(newId) });
/*  634 */           remaps.put(newName, new Integer[] { Integer.valueOf(currId), Integer.valueOf(newId) });
/*      */         }  continue;
/*      */       } 
/*  637 */       if (action == FMLMissingMappingsEvent.Action.BLOCKONLY) {
/*      */ 
/*      */ 
/*      */         
/*  641 */         FMLLog.fine("The ItemBlock %s is no longer present in the game. The residual block will remain", new Object[] { remap.name });
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  646 */       if (action == FMLMissingMappingsEvent.Action.DEFAULT) {
/*      */         
/*  648 */         defaulted.add(remap.name);
/*      */       }
/*  650 */       else if (action == FMLMissingMappingsEvent.Action.IGNORE) {
/*      */         
/*  652 */         ignored.add(remap.name);
/*      */       }
/*  654 */       else if (action == FMLMissingMappingsEvent.Action.FAIL) {
/*      */         
/*  656 */         failed.add(remap.name);
/*      */       }
/*  658 */       else if (action == FMLMissingMappingsEvent.Action.WARN) {
/*      */         
/*  660 */         warned.add(remap.name);
/*      */       } 
/*      */       
/*  663 */       gameData.block(remap.id);
/*      */     } 
/*      */ 
/*      */     
/*  667 */     if (!defaulted.isEmpty()) {
/*      */ 
/*      */       
/*  670 */       String text = "Forge Mod Loader detected missing blocks/items.\n\nThere are " + defaulted.size() + " missing blocks and items in this save.\n" + "If you continue the missing blocks/items will get removed.\n" + "A world backup will be automatically created in your saves directory.\n\n" + "Missing Blocks/Items:\n";
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  675 */       for (String s : defaulted) text = text + s + "\n";
/*      */       
/*  677 */       boolean confirmed = StartupQuery.confirm(text);
/*  678 */       if (!confirmed) StartupQuery.abort();
/*      */ 
/*      */       
/*      */       try {
/*  682 */         String skip = System.getProperty("fml.doNotBackup");
/*  683 */         if (skip == null || !"true".equals(skip)) {
/*      */           
/*  685 */           ZipperUtil.backupWorld();
/*      */         }
/*      */         else {
/*      */           
/*  689 */           for (int x = 0; x < 10; x++) {
/*  690 */             FMLLog.severe("!!!!!!!!!! UPDATING WORLD WITHOUT DOING BACKUP !!!!!!!!!!!!!!!!", new Object[0]);
/*      */           }
/*      */         } 
/*  693 */       } catch (IOException e) {
/*      */         
/*  695 */         StartupQuery.notify("The world backup couldn't be created.\n\n" + e);
/*  696 */         StartupQuery.abort();
/*      */       } 
/*      */       
/*  699 */       warned.addAll(defaulted);
/*      */     } 
/*  701 */     if (!failed.isEmpty()) {
/*      */       
/*  703 */       FMLLog.severe("This world contains blocks and items that refuse to be remapped. The world will not be loaded", new Object[0]);
/*  704 */       return failed;
/*      */     } 
/*  706 */     if (!warned.isEmpty()) {
/*      */       
/*  708 */       FMLLog.severe("This world contains block and item mappings that may cause world breakage", new Object[0]);
/*  709 */       return failed;
/*      */     } 
/*  711 */     if (!ignored.isEmpty())
/*      */     {
/*  713 */       FMLLog.fine("There were %d missing mappings that have been ignored", new Object[] { Integer.valueOf(ignored.size()) });
/*      */     }
/*  715 */     return failed;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void freezeData() {
/*  720 */     FMLLog.fine("Freezing block and item id maps", new Object[0]);
/*      */     
/*  722 */     getMain().testConsistency();
/*  723 */     frozen = new GameData(getMain());
/*  724 */     frozen.testConsistency();
/*      */   }
/*      */ 
/*      */   
/*      */   public static void revertToFrozen() {
/*  729 */     if (frozen == null) {
/*      */       
/*  731 */       FMLLog.warning("Can't revert to frozen GameData state without freezing first.", new Object[0]);
/*      */     }
/*      */     else {
/*      */       
/*  735 */       FMLLog.fine("Reverting to frozen data state.", new Object[0]);
/*      */       
/*  737 */       getMain().set(frozen);
/*      */     } 
/*      */     
/*  740 */     Loader.instance().fireRemapEvent((Map)ImmutableMap.of());
/*      */     
/*  742 */     ObjectHolderRegistry.INSTANCE.applyObjectHolders();
/*      */   }
/*      */ 
/*      */   
/*      */   protected static boolean isFrozen(FMLControlledNamespacedRegistry<?> registry) {
/*  747 */     return (frozen != null && ((getMain()).iBlockRegistry == registry || (getMain()).iItemRegistry == registry));
/*      */   }
/*      */ 
/*      */   
/*      */   protected static GameData getMain() {
/*  752 */     return mainData;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private GameData() {
/* 1021 */     this.itemSubstitutions = (BiMap<String, Item>)HashBiMap.create();
/* 1022 */     this.blockSubstitutions = (BiMap<String, Block>)HashBiMap.create();
/*      */     this.iBlockRegistry = new FMLControlledNamespacedRegistry<Block>("minecraft:air", 4095, 0, Block.class, '\001');
/*      */     this.iItemRegistry = new FMLControlledNamespacedRegistry<Item>(null, 31999, 4096, Item.class, '\002');
/*      */     this.availabilityMap = new BitSet(32000);
/* 1026 */     this.blockedIds = new HashSet<Integer>(); } <T> BiMap<String, T> getPersistentSubstitutionMap(Class<T> type) { if (type.equals(Item.class))
/*      */     {
/* 1028 */       return (BiMap)this.itemSubstitutions;
/*      */     }
/* 1030 */     if (type.equals(Block.class))
/*      */     {
/* 1032 */       return (BiMap)this.blockSubstitutions;
/*      */     }
/*      */ 
/*      */     
/* 1036 */     throw new RuntimeException("WHAT?"); }
/*      */ 
/*      */   
/*      */   private GameData(GameData data) {
/*      */     this();
/*      */     set(data);
/*      */   }
/*      */   
/*      */   private void set(GameData data) {
/*      */     this.iBlockRegistry.set(data.iBlockRegistry);
/*      */     this.iItemRegistry.set(data.iItemRegistry);
/*      */     this.availabilityMap.clear();
/*      */     this.availabilityMap.or(data.availabilityMap);
/*      */     this.blockedIds.clear();
/*      */     this.blockedIds.addAll(data.blockedIds);
/*      */   }
/*      */   
/*      */   int register(Object obj, String name, int idHint) {
/*      */     name = addPrefix(name);
/*      */     if (obj instanceof Block)
/*      */       return registerBlock((Block)obj, name, idHint); 
/*      */     if (obj instanceof Item)
/*      */       return registerItem((Item)obj, name, idHint); 
/*      */     throw new IllegalArgumentException("An invalid registry object is to be added, only instances of Block or Item are allowed.");
/*      */   }
/*      */   
/*      */   int registerItem(Item item, String name) {
/*      */     int index = name.indexOf(':');
/*      */     if (name.indexOf(':') != -1)
/*      */       FMLLog.bigWarning("Illegal extra prefix %s for name %s, invalid registry invocation/invalid name?", new Object[] { name.substring(0, index), name }); 
/*      */     name = addPrefix(name);
/*      */     return registerItem(item, name, -1);
/*      */   }
/*      */   
/*      */   private int registerItem(Item item, String name, int idHint) {
/*      */     if (item instanceof ItemBlock) {
/*      */       Block block = ((ItemBlock)item).field_150939_a;
/*      */       if (idHint != -1 && (getMain()).blockSubstitutions.containsKey(name))
/*      */         block = (Block)(getMain()).blockSubstitutions.get(name); 
/*      */       int id = this.iBlockRegistry.getId(block);
/*      */       if (id == -1) {
/*      */         if (idHint < 0 || this.availabilityMap.get(idHint) || idHint > 4095) {
/*      */           id = this.availabilityMap.nextClearBit(0);
/*      */           if (id > 4095)
/*      */             throw new RuntimeException(String.format("Invalid id %d - maximum id range exceeded.", new Object[] { Integer.valueOf(id) })); 
/*      */           FMLLog.fine("Allocated id %d for ItemBlock %s in the block id range, original id requested: %d.", new Object[] { Integer.valueOf(id), name, Integer.valueOf(idHint) });
/*      */         } else {
/*      */           id = idHint;
/*      */         } 
/*      */       } else {
/*      */         if (FMLControlledNamespacedRegistry.DEBUG)
/*      */           FMLLog.fine("Found matching Block %s for ItemBlock %s at id %d, original id requested: %d", new Object[] { block, item, Integer.valueOf(id), Integer.valueOf(idHint) }); 
/*      */         freeSlot(id, item);
/*      */       } 
/*      */       idHint = id;
/*      */     } 
/*      */     int itemId = this.iItemRegistry.add(idHint, name, item, this.availabilityMap);
/*      */     if (item instanceof ItemBlock) {
/*      */       if (itemId != idHint)
/*      */         throw new IllegalStateException(String.format("ItemBlock at block id %d insertion failed, got id %d.", new Object[] { Integer.valueOf(idHint), Integer.valueOf(itemId) })); 
/*      */       verifyItemBlockName((ItemBlock)item);
/*      */     } 
/*      */     useSlot(itemId);
/*      */     ((RegistryDelegate.Delegate)item.delegate).setName(name);
/*      */     return itemId;
/*      */   }
/*      */   
/*      */   int registerBlock(Block block, String name) {
/*      */     int index = name.indexOf(':');
/*      */     if (name.indexOf(':') != -1)
/*      */       FMLLog.bigWarning("Illegal extra prefix %s for name %s, invalid registry invocation/invalid name?", new Object[] { name.substring(0, index), name }); 
/*      */     name = addPrefix(name);
/*      */     return registerBlock(block, name, -1);
/*      */   }
/*      */   
/*      */   private int registerBlock(Block block, String name, int idHint) {
/*      */     ItemBlock itemBlock = null;
/*      */     for (Item item : this.iItemRegistry.typeSafeIterable()) {
/*      */       if (item instanceof ItemBlock && ((ItemBlock)item).field_150939_a == block) {
/*      */         itemBlock = (ItemBlock)item;
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     if (itemBlock != null) {
/*      */       idHint = this.iItemRegistry.getId(itemBlock);
/*      */       FMLLog.fine("Found matching ItemBlock %s for Block %s at id %d", new Object[] { itemBlock, block, Integer.valueOf(idHint) });
/*      */       freeSlot(idHint, block);
/*      */     } 
/*      */     int blockId = this.iBlockRegistry.add(idHint, name, block, this.availabilityMap);
/*      */     if (itemBlock != null) {
/*      */       if (blockId != idHint)
/*      */         throw new IllegalStateException(String.format("Block at itemblock id %d insertion failed, got id %d.", new Object[] { Integer.valueOf(idHint), Integer.valueOf(blockId) })); 
/*      */       verifyItemBlockName(itemBlock);
/*      */     } 
/*      */     useSlot(blockId);
/*      */     ((RegistryDelegate.Delegate)block.delegate).setName(name);
/*      */     return blockId;
/*      */   }
/*      */   
/*      */   private void block(int id) {
/*      */     this.blockedIds.add(Integer.valueOf(id));
/*      */     useSlot(id);
/*      */   }
/*      */   
/*      */   private void useSlot(int id) {
/*      */     this.availabilityMap.set(id);
/*      */   }
/*      */   
/*      */   private void freeSlot(int id, Object obj) {
/*      */     FMLControlledNamespacedRegistry<?> registry = (obj instanceof Block) ? this.iBlockRegistry : this.iItemRegistry;
/*      */     Object thing = registry.getRaw(id);
/*      */     if (thing != null && thing != obj)
/*      */       throw new IllegalStateException(String.format("Can't free registry slot %d occupied by %s", new Object[] { Integer.valueOf(id), thing })); 
/*      */     this.availabilityMap.clear(id);
/*      */   }
/*      */   
/*      */   private String addPrefix(String name) {
/*      */     String prefix;
/*      */     int index = name.lastIndexOf(':');
/*      */     String oldPrefix = (index == -1) ? "" : name.substring(0, index);
/*      */     ModContainer mc = Loader.instance().activeModContainer();
/*      */     if (mc != null) {
/*      */       prefix = mc.getModId();
/*      */     } else {
/*      */       prefix = "minecraft";
/*      */     } 
/*      */     if (!oldPrefix.equals(prefix))
/*      */       name = prefix + ":" + name; 
/*      */     return name;
/*      */   }
/*      */   
/*      */   private void verifyItemBlockName(ItemBlock item) {
/*      */     String blockName = this.iBlockRegistry.getNameForObject(item.field_150939_a);
/*      */     String itemName = this.iItemRegistry.getNameForObject(item);
/*      */     if (blockName != null && !blockName.equals(itemName))
/*      */       FMLLog.bigWarning("Block <-> ItemBlock name mismatch, block name %s, item name %s", new Object[] { blockName, itemName }); 
/*      */   }
/*      */   
/*      */   private void testConsistency() {
/*      */     for (int i = this.availabilityMap.nextSetBit(0); i >= 0; i = this.availabilityMap.nextSetBit(i + 1)) {
/*      */       if (this.iBlockRegistry.getRaw(i) == null && this.iItemRegistry.getRaw(i) == null && !this.blockedIds.contains(Integer.valueOf(i)))
/*      */         throw new IllegalStateException(String.format("availabilityMap references empty entries for id %d.", new Object[] { Integer.valueOf(i) })); 
/*      */     } 
/*      */     for (int pass = 0; pass < 2; pass++) {
/*      */       boolean isBlock = (pass == 0);
/*      */       String type = isBlock ? "block" : "item";
/*      */       FMLControlledNamespacedRegistry<?> registry = isBlock ? this.iBlockRegistry : this.iItemRegistry;
/*      */       registry.validateContent(isBlock ? 4095 : 31999, type, this.availabilityMap, this.blockedIds, this.iBlockRegistry);
/*      */     } 
/*      */     FMLLog.fine("Registry consistency check successful", new Object[0]);
/*      */   }
/*      */   
/*      */   void registerSubstitutionAlias(String nameToSubstitute, GameRegistry.Type type, Object toReplace) throws ExistingSubstitutionException {
/*      */     type.getRegistry().addSubstitutionAlias(Loader.instance().activeModContainer().getModId(), nameToSubstitute, toReplace);
/*      */     type.getRegistry().activateSubstitution(nameToSubstitute);
/*      */   }
/*      */   
/*      */   static <T> RegistryDelegate<T> buildDelegate(T referant, Class<T> type) {
/*      */     return new RegistryDelegate.Delegate<T>(referant, type);
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\GameData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */