/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import com.google.common.eventbus.Subscribe;
/*     */ import cpw.mods.fml.client.FMLFileResourcePack;
/*     */ import cpw.mods.fml.client.FMLFolderResourcePack;
/*     */ import cpw.mods.fml.common.asm.FMLSanityChecker;
/*     */ import cpw.mods.fml.common.event.FMLConstructionEvent;
/*     */ import cpw.mods.fml.common.network.NetworkCheckHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
/*     */ import cpw.mods.fml.common.registry.GameData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.File;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.storage.SaveHandler;
/*     */ import net.minecraft.world.storage.WorldInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLContainer
/*     */   extends DummyModContainer
/*     */   implements WorldAccessContainer
/*     */ {
/*     */   public FMLContainer() {
/*  57 */     super(new ModMetadata());
/*  58 */     ModMetadata meta = getMetadata();
/*  59 */     meta.modId = "FML";
/*  60 */     meta.name = "Forge Mod Loader";
/*  61 */     meta.version = Loader.instance().getFMLVersionString();
/*  62 */     meta.credits = "Made possible with help from many people";
/*  63 */     meta.authorList = Arrays.asList(new String[] { "cpw", "LexManos", "Player" });
/*  64 */     meta.description = "The Forge Mod Loader provides the ability for systems to load mods from the file system. It also provides key capabilities for mods to be able to cooperate and provide a good modding environment. ";
/*     */ 
/*     */     
/*  67 */     meta.url = "https://github.com/MinecraftForge/FML/wiki";
/*  68 */     meta.updateUrl = "https://github.com/MinecraftForge/FML/wiki";
/*  69 */     meta.screenshots = new String[0];
/*  70 */     meta.logoFile = "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerBus(EventBus bus, LoadController controller) {
/*  76 */     bus.register(this);
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void modConstruction(FMLConstructionEvent evt) {
/*  83 */     NetworkRegistry.INSTANCE.register(this, getClass(), null, evt.getASMHarvestedData());
/*  84 */     FMLNetworkHandler.registerChannel(this, evt.getSide());
/*     */   }
/*     */ 
/*     */   
/*     */   @NetworkCheckHandler
/*     */   public boolean checkModLists(Map<String, String> modList, Side side) {
/*  90 */     return Loader.instance().checkRemoteModList(modList, side);
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound getDataForWriting(SaveHandler handler, WorldInfo info) {
/*  95 */     NBTTagCompound fmlData = new NBTTagCompound();
/*  96 */     NBTTagList list = new NBTTagList();
/*  97 */     for (ModContainer mc : Loader.instance().getActiveModList()) {
/*     */       
/*  99 */       NBTTagCompound mod = new NBTTagCompound();
/* 100 */       mod.setString("ModId", mc.getModId());
/* 101 */       mod.setString("ModVersion", mc.getVersion());
/* 102 */       list.appendTag((NBTBase)mod);
/*     */     } 
/* 104 */     fmlData.setTag("ModList", (NBTBase)list);
/*     */     
/* 106 */     NBTTagList dataList = new NBTTagList();
/* 107 */     FMLLog.fine("Gathering id map for writing to world save %s", new Object[] { info.getWorldName() });
/* 108 */     GameData.GameDataSnapshot dataSnapshot = GameData.buildItemDataList();
/* 109 */     for (Map.Entry<String, Integer> item : (Iterable<Map.Entry<String, Integer>>)dataSnapshot.idMap.entrySet()) {
/*     */       
/* 111 */       NBTTagCompound tag = new NBTTagCompound();
/* 112 */       tag.setString("K", item.getKey());
/* 113 */       tag.setInteger("V", ((Integer)item.getValue()).intValue());
/* 114 */       dataList.appendTag((NBTBase)tag);
/*     */     } 
/* 116 */     fmlData.setTag("ItemData", (NBTBase)dataList);
/*     */     
/* 118 */     fmlData.setIntArray("BlockedItemIds", GameData.getBlockedIds());
/*     */     
/* 120 */     NBTTagList blockAliasList = new NBTTagList();
/* 121 */     for (Map.Entry<String, String> entry : (Iterable<Map.Entry<String, String>>)GameData.getBlockRegistry().getAliases().entrySet()) {
/*     */       
/* 123 */       NBTTagCompound tag = new NBTTagCompound();
/* 124 */       tag.setString("K", entry.getKey());
/* 125 */       tag.setString("V", entry.getValue());
/* 126 */       blockAliasList.appendTag((NBTBase)tag);
/*     */     } 
/* 128 */     fmlData.setTag("BlockAliases", (NBTBase)blockAliasList);
/* 129 */     NBTTagList blockSubstitutionsList = new NBTTagList();
/* 130 */     for (String entry : dataSnapshot.blockSubstitutions) {
/*     */       
/* 132 */       NBTTagCompound tag = new NBTTagCompound();
/* 133 */       tag.setString("K", entry);
/* 134 */       blockSubstitutionsList.appendTag((NBTBase)tag);
/*     */     } 
/* 136 */     fmlData.setTag("BlockSubstitutions", (NBTBase)blockSubstitutionsList);
/*     */     
/* 138 */     NBTTagList itemAliasList = new NBTTagList();
/* 139 */     for (Map.Entry<String, String> entry : (Iterable<Map.Entry<String, String>>)GameData.getItemRegistry().getAliases().entrySet()) {
/*     */       
/* 141 */       NBTTagCompound tag = new NBTTagCompound();
/* 142 */       tag.setString("K", entry.getKey());
/* 143 */       tag.setString("V", entry.getValue());
/* 144 */       itemAliasList.appendTag((NBTBase)tag);
/*     */     } 
/* 146 */     fmlData.setTag("ItemAliases", (NBTBase)itemAliasList);
/*     */     
/* 148 */     NBTTagList itemSubstitutionsList = new NBTTagList();
/* 149 */     for (String entry : dataSnapshot.itemSubstitutions) {
/*     */       
/* 151 */       NBTTagCompound tag = new NBTTagCompound();
/* 152 */       tag.setString("K", entry);
/* 153 */       itemSubstitutionsList.appendTag((NBTBase)tag);
/*     */     } 
/* 155 */     fmlData.setTag("ItemSubstitutions", (NBTBase)itemSubstitutionsList);
/* 156 */     return fmlData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readData(SaveHandler handler, WorldInfo info, Map<String, NBTBase> propertyMap, NBTTagCompound tag) {
/* 162 */     if (tag.hasKey("ModList")) {
/*     */       
/* 164 */       NBTTagList modList = tag.getTagList("ModList", 10);
/* 165 */       for (int i = 0; i < modList.tagCount(); i++) {
/*     */         
/* 167 */         NBTTagCompound mod = modList.getCompoundTagAt(i);
/* 168 */         String modId = mod.getString("ModId");
/* 169 */         String modVersion = mod.getString("ModVersion");
/* 170 */         ModContainer container = Loader.instance().getIndexedModList().get(modId);
/* 171 */         if (container == null) {
/*     */           
/* 173 */           FMLLog.log("fml.ModTracker", Level.ERROR, "This world was saved with mod %s which appears to be missing, things may not work well", new Object[] { modId });
/*     */         
/*     */         }
/* 176 */         else if (!modVersion.equals(container.getVersion())) {
/*     */           
/* 178 */           FMLLog.log("fml.ModTracker", Level.INFO, "This world was saved with mod %s version %s and it is now at version %s, things may not work well", new Object[] { modId, modVersion, container.getVersion() });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     List<String> failedElements = null;
/*     */     
/* 185 */     if (tag.hasKey("ModItemData")) {
/*     */       
/* 187 */       FMLLog.info("Attempting to convert old world data to new system. This may be trouble!", new Object[0]);
/* 188 */       NBTTagList modList = tag.getTagList("ModItemData", 10);
/* 189 */       Map<String, Integer> dataList = Maps.newLinkedHashMap();
/* 190 */       for (int i = 0; i < modList.tagCount(); i++) {
/*     */         
/* 192 */         NBTTagCompound itemTag = modList.getCompoundTagAt(i);
/* 193 */         String modId = itemTag.getString("ModId");
/* 194 */         String itemType = itemTag.getString("ItemType");
/* 195 */         int itemId = itemTag.getInteger("ItemId");
/* 196 */         int ordinal = itemTag.getInteger("ordinal");
/* 197 */         String forcedModId = itemTag.hasKey("ForcedModId") ? itemTag.getString("ForcedModId") : null;
/* 198 */         String forcedName = itemTag.hasKey("ForcedName") ? itemTag.getString("ForcedName") : null;
/* 199 */         if (forcedName == null) {
/*     */           
/* 201 */           FMLLog.warning("Found unlabelled item in world save, this may cause problems. The item type %s:%d will not be present", new Object[] { itemType, Integer.valueOf(ordinal) });
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 206 */           String itemLabel = String.format("%c%s:%s", new Object[] { Character.valueOf('\002'), (forcedModId != null) ? forcedModId : modId, forcedName });
/* 207 */           dataList.put(itemLabel, Integer.valueOf(itemId));
/*     */         } 
/*     */       } 
/* 210 */       failedElements = GameData.injectWorldIDMap(dataList, (Set)ImmutableSet.of(), (Set)ImmutableSet.of(), true, true);
/*     */     
/*     */     }
/* 213 */     else if (tag.hasKey("ItemData")) {
/*     */ 
/*     */       
/* 216 */       NBTTagList list = tag.getTagList("ItemData", 10);
/* 217 */       Map<String, Integer> dataList = Maps.newLinkedHashMap();
/* 218 */       for (int i = 0; i < list.tagCount(); i++) {
/*     */         
/* 220 */         NBTTagCompound dataTag = list.getCompoundTagAt(i);
/* 221 */         dataList.put(dataTag.getString("K"), Integer.valueOf(dataTag.getInteger("V")));
/*     */       } 
/*     */       
/* 224 */       Set<Integer> blockedIds = new HashSet<Integer>();
/*     */       
/* 226 */       if (!tag.hasKey("BlockedItemIds"))
/*     */       {
/*     */ 
/*     */         
/* 230 */         GameData.fixBrokenIds(dataList, blockedIds);
/*     */       }
/*     */ 
/*     */       
/* 234 */       for (int id : tag.getIntArray("BlockedItemIds"))
/*     */       {
/* 236 */         blockedIds.add(Integer.valueOf(id));
/*     */       }
/*     */       
/* 239 */       Map<String, String> blockAliases = new HashMap<String, String>();
/* 240 */       list = tag.getTagList("BlockAliases", 10);
/* 241 */       for (int j = 0; j < list.tagCount(); j++) {
/*     */         
/* 243 */         NBTTagCompound dataTag = list.getCompoundTagAt(j);
/* 244 */         blockAliases.put(dataTag.getString("K"), dataTag.getString("V"));
/*     */       } 
/* 246 */       Set<String> blockSubstitutions = Sets.newHashSet();
/* 247 */       if (tag.hasKey("BlockSubstitutions", 9)) {
/*     */         
/* 249 */         list = tag.getTagList("BlockSubstitutions", 10);
/* 250 */         for (int m = 0; m < list.tagCount(); m++) {
/*     */           
/* 252 */           NBTTagCompound dataTag = list.getCompoundTagAt(m);
/* 253 */           blockSubstitutions.add(dataTag.getString("K"));
/*     */         } 
/*     */       } 
/*     */       
/* 257 */       Map<String, String> itemAliases = new HashMap<String, String>();
/* 258 */       list = tag.getTagList("ItemAliases", 10);
/* 259 */       for (int k = 0; k < list.tagCount(); k++) {
/*     */         
/* 261 */         NBTTagCompound dataTag = list.getCompoundTagAt(k);
/* 262 */         itemAliases.put(dataTag.getString("K"), dataTag.getString("V"));
/*     */       } 
/*     */       
/* 265 */       Set<String> itemSubstitutions = Sets.newHashSet();
/* 266 */       if (tag.hasKey("ItemSubstitutions", 9)) {
/*     */         
/* 268 */         list = tag.getTagList("ItemSubstitutions", 10);
/* 269 */         for (int m = 0; m < list.tagCount(); m++) {
/*     */           
/* 271 */           NBTTagCompound dataTag = list.getCompoundTagAt(m);
/* 272 */           itemSubstitutions.add(dataTag.getString("K"));
/*     */         } 
/*     */       } 
/*     */       
/*     */       try {
/* 277 */         failedElements = GameData.injectWorldIDMap(dataList, blockedIds, blockAliases, itemAliases, blockSubstitutions, itemSubstitutions, true, true);
/* 278 */       } catch (IllegalStateException ex) {
/*     */ 
/*     */         
/* 281 */         String msg = "The world state is utterly corrupted and this save is NOT loadable\n\nThere is a high probability that a mod has broken the\nID map and there is\nNOTHING FML or Forge can do to recover this save.\n\nIf you changed your mods, try reverting the change";
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 286 */         FMLLog.log(Level.FATAL, ex, msg, new Object[0]);
/* 287 */         StartupQuery.notify(msg);
/* 288 */         StartupQuery.abort();
/*     */       } 
/*     */     } 
/*     */     
/* 292 */     if (failedElements != null && !failedElements.isEmpty()) {
/*     */ 
/*     */       
/* 295 */       String text = "Forge Mod Loader could not load this save.\n\nThere are " + failedElements.size() + " unassigned blocks and items in this save.\n" + "You will not be able to load until they are present again.\n\n" + "Missing Blocks/Items:\n";
/*     */ 
/*     */ 
/*     */       
/* 299 */       for (String s : failedElements) text = text + s + "\n";
/*     */       
/* 301 */       StartupQuery.notify(text);
/* 302 */       StartupQuery.abort();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Certificate getSigningCertificate() {
/* 310 */     Certificate[] certificates = getClass().getProtectionDomain().getCodeSource().getCertificates();
/* 311 */     return (certificates != null) ? certificates[0] : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSource() {
/* 317 */     return FMLSanityChecker.fmlLocation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCustomResourcePackClass() {
/* 323 */     return getSource().isDirectory() ? FMLFolderResourcePack.class : FMLFileResourcePack.class;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiClassName() {
/* 329 */     return "cpw.mods.fml.client.FMLConfigGuiFactory";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getMod() {
/* 335 */     return this;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\FMLContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */