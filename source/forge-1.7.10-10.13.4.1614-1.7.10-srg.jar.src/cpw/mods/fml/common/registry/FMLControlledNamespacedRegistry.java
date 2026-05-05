/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.HashBiMap;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Iterators;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.functions.GenericIterableFactory;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.util.ObjectIntIdentityMap;
/*     */ import net.minecraft.util.RegistryNamespaced;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLControlledNamespacedRegistry<I>
/*     */   extends RegistryNamespaced
/*     */ {
/*  30 */   public static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("fml.debugRegistryEntries", "false"));
/*     */   
/*     */   private final Class<I> superType;
/*     */   
/*     */   private String optionalDefaultName;
/*     */   private I optionalDefaultObject;
/*     */   private int maxId;
/*     */   private int minId;
/*     */   private char discriminator;
/*  39 */   private final Map<String, String> aliases = new HashMap<String, String>();
/*     */   private BiMap<String, I> persistentSubstitutions;
/*  41 */   private BiMap<String, I> activeSubstitutions = (BiMap<String, I>)HashBiMap.create();
/*     */ 
/*     */   
/*     */   FMLControlledNamespacedRegistry(String optionalDefault, int maxIdValue, int minIdValue, Class<I> type, char discriminator) {
/*  45 */     this.superType = type;
/*  46 */     this.discriminator = discriminator;
/*  47 */     this.optionalDefaultName = optionalDefault;
/*  48 */     this.maxId = maxIdValue;
/*  49 */     this.minId = minIdValue;
/*     */   }
/*     */ 
/*     */   
/*     */   void validateContent(int maxId, String type, BitSet availabilityMap, Set<Integer> blockedIds, FMLControlledNamespacedRegistry<Block> iBlockRegistry) {
/*  54 */     for (I obj : typeSafeIterable()) {
/*     */       
/*  56 */       int id = getId(obj);
/*  57 */       String name = getNameForObject(obj);
/*  58 */       boolean isSubstituted = this.activeSubstitutions.containsKey(name);
/*     */ 
/*     */       
/*  61 */       if (!isSubstituted && id < 0) throw new IllegalStateException(String.format("Registry entry for %s %s, name %s, doesn't yield an id.", new Object[] { type, obj, name }));
/*     */       
/*  63 */       if (id > maxId) throw new IllegalStateException(String.format("Registry entry for %s %s, name %s uses the too large id %d.", new Object[] { type, obj, name }));
/*     */       
/*  65 */       if (name == null) throw new IllegalStateException(String.format("Registry entry for %s %s, id %d, doesn't yield a name.", new Object[] { type, obj, Integer.valueOf(id) }));
/*     */       
/*  67 */       if (name.isEmpty()) throw new IllegalStateException(String.format("Registry entry for %s %s, id %d, yields an empty name.", new Object[] { type, obj, Integer.valueOf(id) }));
/*     */       
/*  69 */       if (name.indexOf(':') == -1) throw new IllegalStateException(String.format("Registry entry for %s %s, id %d, has the non-prefixed name %s.", new Object[] { type, obj, Integer.valueOf(id), name }));
/*     */       
/*  71 */       if (isSubstituted)
/*     */         continue; 
/*  73 */       if (getRaw(id) != obj) throw new IllegalStateException(String.format("Registry entry for id %d, name %s, doesn't yield the expected %s %s.", new Object[] { Integer.valueOf(id), name, type, obj }));
/*     */       
/*  75 */       if (getRaw(name) != obj) throw new IllegalStateException(String.format("Registry entry for name %s, id %d, doesn't yield the expected %s %s.", new Object[] { name, Integer.valueOf(id), type, obj }));
/*     */       
/*  77 */       if (getId(name) != id) throw new IllegalStateException(String.format("Registry entry for name %s doesn't yield the expected id %d.", new Object[] { name, Integer.valueOf(id) }));
/*     */       
/*  79 */       if (!availabilityMap.get(id)) throw new IllegalStateException(String.format("Registry entry for %s %s, id %d, name %s, marked as empty.", new Object[] { type, obj, Integer.valueOf(id), name }));
/*     */       
/*  81 */       if (blockedIds.contains(Integer.valueOf(id))) throw new IllegalStateException(String.format("Registry entry for %s %s, id %d, name %s, marked as dangling.", new Object[] { type, obj, Integer.valueOf(id), name }));
/*     */       
/*  83 */       if (obj instanceof ItemBlock) {
/*     */         
/*  85 */         Block block = ((ItemBlock)obj).field_150939_a;
/*     */ 
/*     */         
/*  88 */         if (iBlockRegistry.getId(block) != id)
/*     */         {
/*  90 */           throw new IllegalStateException(String.format("Registry entry for ItemBlock %s, id %d, is missing or uses the non-matching id %d.", new Object[] { obj, Integer.valueOf(id), Integer.valueOf(iBlockRegistry.getId(block)) }));
/*     */         }
/*     */         
/*  93 */         if (id > 4095) throw new IllegalStateException(String.format("ItemBlock %s uses the id %d outside the block id range", new Object[] { name, Integer.valueOf(id) }));
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void set(FMLControlledNamespacedRegistry<I> registry) {
/* 100 */     if (this.superType != registry.superType) throw new IllegalArgumentException("incompatible registry");
/*     */     
/* 102 */     this.discriminator = registry.discriminator;
/* 103 */     this.optionalDefaultName = registry.optionalDefaultName;
/* 104 */     this.maxId = registry.maxId;
/* 105 */     this.minId = registry.minId;
/* 106 */     this.aliases.clear();
/* 107 */     this.aliases.putAll(registry.aliases);
/* 108 */     this.activeSubstitutions.clear();
/*     */     
/* 110 */     this.underlyingIntegerMap = new ObjectIntIdentityMap();
/* 111 */     this.registryObjects.clear();
/*     */     
/* 113 */     for (I thing : registry.typeSafeIterable()) {
/*     */       
/* 115 */       int id = registry.getId(thing);
/* 116 */       addObjectRaw(id, registry.getNameForObject(thing), thing);
/*     */     } 
/* 118 */     this.activeSubstitutions.putAll((Map)registry.activeSubstitutions);
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
/*     */   @Deprecated
/*     */   public void addObject(int id, String name, Object thing) {
/* 135 */     GameData.getMain().register(thing, name, id);
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
/*     */   @Deprecated
/*     */   public void putObject(Object objName, Object obj) {
/* 150 */     String name = (String)objName;
/* 151 */     I thing = cast(obj);
/*     */     
/* 153 */     if (name == null) throw new NullPointerException("Can't use a null-name for the registry."); 
/* 154 */     if (name.isEmpty()) throw new IllegalArgumentException("Can't use an empty name for the registry."); 
/* 155 */     if (thing == null) throw new NullPointerException("Can't add null-object to the registry.");
/*     */     
/* 157 */     name = ensureNamespaced(name);
/* 158 */     String existingName = getNameForObject(thing);
/*     */     
/* 160 */     if (existingName == null) {
/*     */       
/* 162 */       FMLLog.bigWarning("Ignoring putObject(%s, %s), not resolvable", new Object[] { name, thing });
/*     */     }
/* 164 */     else if (existingName.equals(name)) {
/*     */       
/* 166 */       FMLLog.bigWarning("Ignoring putObject(%s, %s), already added", new Object[] { name, thing });
/*     */     }
/*     */     else {
/*     */       
/* 170 */       FMLLog.bigWarning("Ignoring putObject(%s, %s), adding alias to %s instead", new Object[] { name, thing, existingName });
/* 171 */       addAlias(name, existingName);
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
/*     */   public I getObject(String name) {
/* 186 */     I object = getRaw(name);
/* 187 */     return (object == null) ? this.optionalDefaultObject : object;
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
/*     */   
/*     */   public I getObjectById(int id) {
/* 204 */     I object = getRaw(id);
/* 205 */     return (object == null) ? this.optionalDefaultObject : object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public I get(int id) {
/* 217 */     return getObjectById(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public I get(String name) {
/* 226 */     return getObject(name);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId(I thing) {
/* 245 */     return getIDForObject(thing);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public I getRaw(int id) {
/* 256 */     return cast(super.getObjectById(id));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private I cast(Object obj) {
/* 267 */     return (I)obj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public I getRaw(String name) {
/* 277 */     I ret = cast(super.getObject(name));
/*     */     
/* 279 */     if (ret == null) {
/*     */       
/* 281 */       name = this.aliases.get(name);
/*     */       
/* 283 */       if (name != null) return getRaw(name);
/*     */     
/*     */     } 
/* 286 */     return ret;
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
/*     */   
/*     */   public boolean containsKey(String name) {
/* 303 */     boolean ret = super.containsKey(name);
/*     */     
/* 305 */     if (!ret) {
/*     */       
/* 307 */       name = this.aliases.get(name);
/*     */       
/* 309 */       if (name != null) return containsKey(name);
/*     */     
/*     */     } 
/* 312 */     return ret;
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
/*     */   public int getId(String itemName) {
/* 328 */     I obj = getRaw(itemName);
/* 329 */     if (obj == null) return -1;
/*     */     
/* 331 */     return getId(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean contains(String itemName) {
/* 343 */     return containsKey(itemName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<I> typeSafeIterable() {
/* 352 */     return GenericIterableFactory.newCastingIterable(super.iterator(), this.superType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serializeInto(Map<String, Integer> idMapping) {
/* 359 */     for (I thing : typeSafeIterable())
/*     */     {
/* 361 */       idMapping.put(this.discriminator + getNameForObject(thing), Integer.valueOf(getId(thing)));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getAliases() {
/* 367 */     return (Map<String, String>)ImmutableMap.copyOf(this.aliases);
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
/*     */   int add(int id, String name, I thing, BitSet availabilityMap) {
/* 381 */     if (name == null) throw new NullPointerException(String.format("Can't use a null-name for the registry, object %s.", new Object[] { thing })); 
/* 382 */     if (name.isEmpty()) throw new IllegalArgumentException(String.format("Can't use an empty name for the registry, object %s.", new Object[] { thing })); 
/* 383 */     if (name.indexOf(':') == -1) throw new IllegalArgumentException(String.format("Can't add the name (%s) without a prefix, object %s", new Object[] { name, thing })); 
/* 384 */     if (thing == null) throw new NullPointerException(String.format("Can't add null-object to the registry, name %s.", new Object[] { name })); 
/* 385 */     if (name.equals(this.optionalDefaultName) && this.optionalDefaultObject == null)
/*     */     {
/* 387 */       this.optionalDefaultObject = thing;
/*     */     }
/* 389 */     if (getPersistentSubstitutions().containsValue(thing))
/*     */     {
/* 391 */       throw new IllegalArgumentException(String.format("The object %s (%s) cannot be added to the registry. It is already being used as a substitute for %s", new Object[] { thing.getClass(), name, getPersistentSubstitutions().inverse().get(thing) }));
/*     */     }
/* 393 */     int idToUse = id;
/* 394 */     if (idToUse < 0 || availabilityMap.get(idToUse))
/*     */     {
/* 396 */       idToUse = availabilityMap.nextClearBit(this.minId);
/*     */     }
/* 398 */     if (idToUse > this.maxId)
/*     */     {
/* 400 */       throw new RuntimeException(String.format("Invalid id %d - maximum id range exceeded.", new Object[] { Integer.valueOf(idToUse) }));
/*     */     }
/*     */     
/* 403 */     if (getRaw(name) == thing) {
/*     */       
/* 405 */       FMLLog.bigWarning("The object %s has been registered twice for the same name %s.", new Object[] { thing, name });
/* 406 */       return getId(thing);
/*     */     } 
/* 408 */     if (getRaw(name) != null)
/*     */     {
/* 410 */       throw new IllegalArgumentException(String.format("The name %s has been registered twice, for %s and %s.", new Object[] { name, getRaw(name), thing }));
/*     */     }
/* 412 */     if (getId(thing) >= 0) {
/*     */       
/* 414 */       int foundId = getId(thing);
/* 415 */       Object otherThing = getRaw(foundId);
/* 416 */       throw new IllegalArgumentException(String.format("The object %s{%x} has been registered twice, using the names %s and %s. (Other object at this id is %s{%x})", new Object[] { thing, Integer.valueOf(System.identityHashCode(thing)), getNameForObject(thing), name, otherThing, Integer.valueOf(System.identityHashCode(otherThing)) }));
/*     */     } 
/* 418 */     if (GameData.isFrozen(this))
/*     */     {
/* 420 */       FMLLog.bigWarning("The object %s (name %s) is being added too late.", new Object[] { thing, name });
/*     */     }
/*     */     
/* 423 */     if (this.activeSubstitutions.containsKey(name))
/*     */     {
/* 425 */       thing = (I)this.activeSubstitutions.get(name);
/*     */     }
/* 427 */     addObjectRaw(idToUse, name, thing);
/*     */     
/* 429 */     if (DEBUG)
/* 430 */       FMLLog.finer("Registry add: %s %d %s (req. id %d)", new Object[] { name, Integer.valueOf(idToUse), thing, Integer.valueOf(id) }); 
/* 431 */     return idToUse;
/*     */   }
/*     */ 
/*     */   
/*     */   void addAlias(String from, String to) {
/* 436 */     this.aliases.put(from, to);
/* 437 */     if (DEBUG) {
/* 438 */       FMLLog.finer("Registry alias: %s -> %s", new Object[] { from, to });
/*     */     }
/*     */   }
/*     */   
/*     */   Map<String, Integer> getEntriesNotIn(FMLControlledNamespacedRegistry<I> registry) {
/* 443 */     Map<String, Integer> ret = new HashMap<String, Integer>();
/*     */     
/* 445 */     for (I thing : typeSafeIterable()) {
/*     */       
/* 447 */       if (!registry.field_148758_b.containsKey(thing))
/*     */       {
/* 449 */         if (!registry.activeSubstitutions.containsKey(getNameForObject(thing)))
/*     */         {
/* 451 */           ret.put(getNameForObject(thing), Integer.valueOf(getId(thing)));
/*     */         }
/*     */       }
/*     */     } 
/*     */     
/* 456 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   void dump() {
/* 461 */     if (!DEBUG) {
/*     */       return;
/*     */     }
/* 464 */     List<Integer> ids = new ArrayList<Integer>();
/*     */     
/* 466 */     for (I thing : typeSafeIterable())
/*     */     {
/* 468 */       ids.add(Integer.valueOf(getId(thing)));
/*     */     }
/*     */ 
/*     */     
/* 472 */     Collections.sort(ids);
/*     */     
/* 474 */     for (Iterator<Integer> iterator = ids.iterator(); iterator.hasNext(); ) { int id = ((Integer)iterator.next()).intValue();
/*     */       
/* 476 */       I thing = getRaw(id);
/* 477 */       FMLLog.finer("Registry: %d %s %s", new Object[] { Integer.valueOf(id), getNameForObject(thing), thing }); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addObjectRaw(int id, String name, I thing) {
/* 486 */     if (name == null) throw new NullPointerException("The name to be added to the registry is null. This can only happen with a corrupted registry state. Reflection/ASM hackery? Registry bug?"); 
/* 487 */     if (thing == null) throw new NullPointerException("The object to be added to the registry is null. This can only happen with a corrupted registry state. Reflection/ASM hackery? Registry bug?"); 
/* 488 */     if (!this.superType.isInstance(thing)) throw new IllegalArgumentException("The object to be added to the registry is not of the right type. Reflection/ASM hackery? Registry bug?");
/*     */     
/* 490 */     this.underlyingIntegerMap.func_148746_a(thing, id);
/* 491 */     super.putObject(name, thing);
/*     */   }
/*     */ 
/*     */   
/*     */   public I getDefaultValue() {
/* 496 */     return this.optionalDefaultObject;
/*     */   }
/*     */   
/*     */   public RegistryDelegate<I> getDelegate(I thing, Class<I> clazz) {
/* 500 */     return GameData.buildDelegate(thing, clazz);
/*     */   }
/*     */ 
/*     */   
/*     */   void activateSubstitution(String nameToReplace) {
/* 505 */     if (getPersistentSubstitutions().containsKey(nameToReplace)) {
/*     */       
/* 507 */       I original = getRaw(nameToReplace);
/* 508 */       if (this.superType == Item.class) {
/* 509 */         Item sub = (Item)getPersistentSubstitutions().get(nameToReplace);
/* 510 */         if (original == null)
/*     */         {
/*     */           
/* 513 */           original = (I)GameData.getItemRegistry().getRaw(nameToReplace);
/*     */         }
/* 515 */         FMLLog.log(Level.DEBUG, "Replacing %s with %s (name %s)", new Object[] { original, sub, nameToReplace });
/* 516 */         RegistryDelegate.Delegate<Item> delegate = (RegistryDelegate.Delegate<Item>)((Item)original).delegate;
/* 517 */         delegate.changeReference(sub);
/* 518 */         ((RegistryDelegate.Delegate)sub.delegate).setName(nameToReplace);
/*     */       } 
/* 520 */       this.activeSubstitutions.put(nameToReplace, getPersistentSubstitutions().get(nameToReplace));
/*     */     } 
/*     */   }
/*     */   
/*     */   void addSubstitutionAlias(String modId, String nameToReplace, Object toReplace) throws ExistingSubstitutionException {
/* 525 */     if (getPersistentSubstitutions().containsKey(nameToReplace) || getPersistentSubstitutions().containsValue(toReplace)) {
/*     */       
/* 527 */       FMLLog.severe("The substitution of %s has already occured. You cannot duplicate substitutions", new Object[] { nameToReplace });
/* 528 */       throw new ExistingSubstitutionException(nameToReplace, toReplace);
/*     */     } 
/* 530 */     I replacement = cast(toReplace);
/* 531 */     I original = getRaw(nameToReplace);
/* 532 */     if (original == null)
/*     */     {
/* 534 */       throw new NullPointerException("The replacement target is not present. This won't work");
/*     */     }
/* 536 */     if (!original.getClass().isAssignableFrom(replacement.getClass())) {
/*     */       
/* 538 */       FMLLog.severe("The substitute %s for %s (type %s) is type incompatible. This won't work", new Object[] { replacement.getClass().getName(), nameToReplace, original.getClass().getName() });
/* 539 */       throw new IncompatibleSubstitutionException(nameToReplace, replacement, original);
/*     */     } 
/* 541 */     int existingId = getId(replacement);
/* 542 */     if (existingId != -1) {
/*     */       
/* 544 */       FMLLog.severe("The substitute %s for %s is registered into the game independently. This won't work", new Object[] { replacement.getClass().getName(), nameToReplace });
/* 545 */       throw new IllegalArgumentException("The object substitution is already registered. This won't work");
/*     */     } 
/* 547 */     FMLLog.log(Level.DEBUG, "Adding substitution %s with %s (name %s)", new Object[] { original, replacement, nameToReplace });
/* 548 */     getPersistentSubstitutions().put(nameToReplace, replacement);
/*     */   }
/*     */ 
/*     */   
/*     */   public void serializeSubstitutions(Set<String> blockSubs) {
/* 553 */     blockSubs.addAll(this.activeSubstitutions.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   private BiMap<String, I> getPersistentSubstitutions() {
/* 558 */     if (this.persistentSubstitutions == null)
/*     */     {
/* 560 */       this.persistentSubstitutions = GameData.getMain().getPersistentSubstitutionMap(this.superType);
/*     */     }
/* 562 */     return this.persistentSubstitutions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<I> iterator() {
/* 573 */     return Iterators.concat(super.iterator(), getPersistentSubstitutions().values().iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void resetSubstitutionDelegates() {
/* 579 */     for (I item : typeSafeIterable()) {
/* 580 */       RegistryDelegate.Delegate<Item> delegate = (RegistryDelegate.Delegate<Item>)((Item)item).delegate;
/* 581 */       delegate.changeReference((Item)item);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\FMLControlledNamespacedRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */