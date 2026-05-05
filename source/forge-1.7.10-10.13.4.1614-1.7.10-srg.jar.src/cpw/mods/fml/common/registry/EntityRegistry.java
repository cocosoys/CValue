/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.primitives.UnsignedBytes;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.network.internal.FMLMessage;
/*     */ import java.util.BitSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityTracker;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
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
/*     */ public class EntityRegistry
/*     */ {
/*     */   public class EntityRegistration
/*     */   {
/*     */     private Class<? extends Entity> entityClass;
/*     */     private ModContainer container;
/*     */     private String entityName;
/*     */     private int modId;
/*     */     private int trackingRange;
/*     */     private int updateFrequency;
/*     */     private boolean sendsVelocityUpdates;
/*     */     private Function<FMLMessage.EntitySpawnMessage, Entity> customSpawnCallback;
/*     */     private boolean usesVanillaSpawning;
/*     */     
/*     */     public EntityRegistration(ModContainer mc, Class<? extends Entity> entityClass, String entityName, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
/*  60 */       this.container = mc;
/*  61 */       this.entityClass = entityClass;
/*  62 */       this.entityName = entityName;
/*  63 */       this.modId = id;
/*  64 */       this.trackingRange = trackingRange;
/*  65 */       this.updateFrequency = updateFrequency;
/*  66 */       this.sendsVelocityUpdates = sendsVelocityUpdates;
/*     */     }
/*     */     
/*     */     public Class<? extends Entity> getEntityClass() {
/*  70 */       return this.entityClass;
/*     */     }
/*     */     
/*     */     public ModContainer getContainer() {
/*  74 */       return this.container;
/*     */     }
/*     */     
/*     */     public String getEntityName() {
/*  78 */       return this.entityName;
/*     */     }
/*     */     
/*     */     public int getModEntityId() {
/*  82 */       return this.modId;
/*     */     }
/*     */     
/*     */     public int getTrackingRange() {
/*  86 */       return this.trackingRange;
/*     */     }
/*     */     
/*     */     public int getUpdateFrequency() {
/*  90 */       return this.updateFrequency;
/*     */     }
/*     */     
/*     */     public boolean sendsVelocityUpdates() {
/*  94 */       return this.sendsVelocityUpdates;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean usesVanillaSpawning() {
/*  99 */       return this.usesVanillaSpawning;
/*     */     }
/*     */     
/*     */     public boolean hasCustomSpawning() {
/* 103 */       return (this.customSpawnCallback != null);
/*     */     }
/*     */     
/*     */     public Entity doCustomSpawning(FMLMessage.EntitySpawnMessage spawnMsg) throws Exception {
/* 107 */       return (Entity)this.customSpawnCallback.apply(spawnMsg);
/*     */     }
/*     */     
/*     */     public void setCustomSpawning(Function<FMLMessage.EntitySpawnMessage, Entity> callable, boolean usesVanillaSpawning) {
/* 111 */       this.customSpawnCallback = callable;
/* 112 */       this.usesVanillaSpawning = usesVanillaSpawning;
/*     */     }
/*     */   }
/*     */   
/* 116 */   private static final EntityRegistry INSTANCE = new EntityRegistry();
/*     */   
/*     */   private BitSet availableIndicies;
/* 119 */   private ListMultimap<ModContainer, EntityRegistration> entityRegistrations = (ListMultimap<ModContainer, EntityRegistration>)ArrayListMultimap.create();
/* 120 */   private Map<String, ModContainer> entityNames = Maps.newHashMap();
/* 121 */   private BiMap<Class<? extends Entity>, EntityRegistration> entityClassRegistrations = (BiMap<Class<? extends Entity>, EntityRegistration>)HashBiMap.create();
/*     */   
/*     */   public static EntityRegistry instance() {
/* 124 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntityRegistry() {
/* 129 */     this.availableIndicies = new BitSet(256);
/* 130 */     this.availableIndicies.set(1, 255);
/* 131 */     for (Object id : EntityList.IDtoClassMapping.keySet())
/*     */     {
/* 133 */       this.availableIndicies.clear(((Integer)id).intValue());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerModEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
/* 150 */     instance().doModEntityRegistration(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void doModEntityRegistration(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
/* 156 */     ModContainer mc = FMLCommonHandler.instance().findContainerFor(mod);
/* 157 */     EntityRegistration er = new EntityRegistration(mc, entityClass, entityName, id, trackingRange, updateFrequency, sendsVelocityUpdates);
/*     */     
/*     */     try {
/* 160 */       this.entityClassRegistrations.put(entityClass, er);
/* 161 */       this.entityNames.put(entityName, mc);
/* 162 */       if (!EntityList.classToStringMapping.containsKey(entityClass))
/*     */       {
/* 164 */         String entityModName = String.format("%s.%s", new Object[] { mc.getModId(), entityName });
/* 165 */         EntityList.classToStringMapping.put(entityClass, entityModName);
/* 166 */         EntityList.stringToClassMapping.put(entityModName, entityClass);
/* 167 */         FMLLog.finer("Automatically registered mod %s entity %s as %s", new Object[] { mc.getModId(), entityName, entityModName });
/*     */       }
/*     */       else
/*     */       {
/* 171 */         FMLLog.fine("Skipping automatic mod %s entity registration for already registered class %s", new Object[] { mc.getModId(), entityClass.getName() });
/*     */       }
/*     */     
/* 174 */     } catch (IllegalArgumentException e) {
/*     */       
/* 176 */       FMLLog.log(Level.WARN, e, "The mod %s tried to register the entity (name,class) (%s,%s) one or both of which are already registered", new Object[] { mc.getModId(), entityName, entityClass.getName() });
/*     */       return;
/*     */     } 
/* 179 */     this.entityRegistrations.put(mc, er);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerGlobalEntityID(Class<? extends Entity> entityClass, String entityName, int id) {
/* 184 */     if (EntityList.classToStringMapping.containsKey(entityClass)) {
/*     */       
/* 186 */       ModContainer activeModContainer = Loader.instance().activeModContainer();
/* 187 */       String modId = "unknown";
/* 188 */       if (activeModContainer != null) {
/*     */         
/* 190 */         modId = activeModContainer.getModId();
/*     */       }
/*     */       else {
/*     */         
/* 194 */         FMLLog.severe("There is a rogue mod failing to register entities from outside the context of mod loading. This is incredibly dangerous and should be stopped.", new Object[0]);
/*     */       } 
/* 196 */       FMLLog.warning("The mod %s tried to register the entity class %s which was already registered - if you wish to override default naming for FML mod entities, register it here first", new Object[] { modId, entityClass });
/*     */       return;
/*     */     } 
/* 199 */     id = instance().validateAndClaimId(id);
/* 200 */     EntityList.addMapping(entityClass, entityName, id);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int validateAndClaimId(int id) {
/* 206 */     int realId = id;
/* 207 */     if (id < -128) {
/*     */       
/* 209 */       FMLLog.warning("Compensating for modloader out of range compensation by mod : entityId %d for mod %s is now %d", new Object[] { Integer.valueOf(id), Loader.instance().activeModContainer().getModId(), Integer.valueOf(realId) });
/* 210 */       realId += 3000;
/*     */     } 
/*     */     
/* 213 */     if (realId < 0)
/*     */     {
/* 215 */       realId += 127;
/*     */     }
/*     */     
/*     */     try {
/* 219 */       UnsignedBytes.checkedCast(realId);
/*     */     }
/* 221 */     catch (IllegalArgumentException e) {
/*     */       
/* 223 */       FMLLog.log(Level.ERROR, "The entity ID %d for mod %s is not an unsigned byte and may not work", new Object[] { Integer.valueOf(id), Loader.instance().activeModContainer().getModId() });
/*     */     } 
/*     */     
/* 226 */     if (!this.availableIndicies.get(realId))
/*     */     {
/* 228 */       FMLLog.severe("The mod %s has attempted to register an entity ID %d which is already reserved. This could cause severe problems", new Object[] { Loader.instance().activeModContainer().getModId(), Integer.valueOf(id) });
/*     */     }
/* 230 */     this.availableIndicies.clear(realId);
/* 231 */     return realId;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerGlobalEntityID(Class<? extends Entity> entityClass, String entityName, int id, int backgroundEggColour, int foregroundEggColour) {
/* 236 */     if (EntityList.classToStringMapping.containsKey(entityClass)) {
/*     */       
/* 238 */       ModContainer activeModContainer = Loader.instance().activeModContainer();
/* 239 */       String modId = "unknown";
/* 240 */       if (activeModContainer != null) {
/*     */         
/* 242 */         modId = activeModContainer.getModId();
/*     */       }
/*     */       else {
/*     */         
/* 246 */         FMLLog.severe("There is a rogue mod failing to register entities from outside the context of mod loading. This is incredibly dangerous and should be stopped.", new Object[0]);
/*     */       } 
/* 248 */       FMLLog.warning("The mod %s tried to register the entity class %s which was already registered - if you wish to override default naming for FML mod entities, register it here first", new Object[] { modId, entityClass });
/*     */       return;
/*     */     } 
/* 251 */     instance().validateAndClaimId(id);
/* 252 */     EntityList.addMapping(entityClass, entityName, id, backgroundEggColour, foregroundEggColour);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSpawn(Class<? extends EntityLiving> entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
/* 257 */     for (BiomeGenBase biome : biomes) {
/*     */ 
/*     */       
/* 260 */       List<BiomeGenBase.SpawnListEntry> spawns = biome.getSpawnableList(typeOfCreature);
/*     */       
/* 262 */       for (BiomeGenBase.SpawnListEntry entry : spawns) {
/*     */ 
/*     */         
/* 265 */         if (entry.entityClass == entityClass) {
/*     */           
/* 267 */           entry.itemWeight = weightedProb;
/* 268 */           entry.minGroupCount = min;
/* 269 */           entry.maxGroupCount = max;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 274 */       spawns.add(new BiomeGenBase.SpawnListEntry(entityClass, weightedProb, min, max));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addSpawn(String entityName, int weightedProb, int min, int max, EnumCreatureType spawnList, BiomeGenBase... biomes) {
/* 281 */     Class<? extends Entity> entityClazz = (Class<? extends Entity>)EntityList.stringToClassMapping.get(entityName);
/*     */     
/* 283 */     if (EntityLiving.class.isAssignableFrom(entityClazz))
/*     */     {
/* 285 */       addSpawn((Class)entityClazz, weightedProb, min, max, spawnList, biomes);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void removeSpawn(Class<? extends EntityLiving> entityClass, EnumCreatureType typeOfCreature, BiomeGenBase... biomes) {
/* 291 */     for (BiomeGenBase biome : biomes) {
/*     */ 
/*     */       
/* 294 */       Iterator<BiomeGenBase.SpawnListEntry> spawns = biome.getSpawnableList(typeOfCreature).iterator();
/*     */       
/* 296 */       while (spawns.hasNext()) {
/*     */         
/* 298 */         BiomeGenBase.SpawnListEntry entry = spawns.next();
/* 299 */         if (entry.entityClass == entityClass)
/*     */         {
/* 301 */           spawns.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeSpawn(String entityName, EnumCreatureType spawnList, BiomeGenBase... biomes) {
/* 310 */     Class<? extends Entity> entityClazz = (Class<? extends Entity>)EntityList.stringToClassMapping.get(entityName);
/*     */     
/* 312 */     if (EntityLiving.class.isAssignableFrom(entityClazz))
/*     */     {
/* 314 */       removeSpawn((Class)entityClazz, spawnList, biomes);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static int findGlobalUniqueEntityId() {
/* 320 */     int res = (instance()).availableIndicies.nextSetBit(0);
/* 321 */     if (res < 0)
/*     */     {
/* 323 */       throw new RuntimeException("No more entity indicies left");
/*     */     }
/* 325 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityRegistration lookupModSpawn(Class<? extends Entity> clazz, boolean keepLooking) {
/* 330 */     Class<?> localClazz = clazz;
/*     */ 
/*     */     
/*     */     do {
/* 334 */       EntityRegistration er = (EntityRegistration)this.entityClassRegistrations.get(localClazz);
/* 335 */       if (er != null)
/*     */       {
/* 337 */         return er;
/*     */       }
/* 339 */       localClazz = localClazz.getSuperclass();
/* 340 */       keepLooking = !Object.class.equals(localClazz);
/*     */     }
/* 342 */     while (keepLooking);
/*     */     
/* 344 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityRegistration lookupModSpawn(ModContainer mc, int modEntityId) {
/* 349 */     for (EntityRegistration er : this.entityRegistrations.get(mc)) {
/*     */       
/* 351 */       if (er.getModEntityId() == modEntityId)
/*     */       {
/* 353 */         return er;
/*     */       }
/*     */     } 
/* 356 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean tryTrackingEntity(EntityTracker entityTracker, Entity entity) {
/* 362 */     EntityRegistration er = lookupModSpawn((Class)entity.getClass(), true);
/* 363 */     if (er != null) {
/*     */       
/* 365 */       entityTracker.addEntityToTracker(entity, er.getTrackingRange(), er.getUpdateFrequency(), er.sendsVelocityUpdates());
/* 366 */       return true;
/*     */     } 
/* 368 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\EntityRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */