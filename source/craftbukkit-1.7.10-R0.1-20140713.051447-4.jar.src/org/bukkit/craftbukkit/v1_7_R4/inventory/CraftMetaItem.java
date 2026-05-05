/*     */ package org.bukkit.craftbukkit.v1_7_R4.inventory;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import net.minecraft.server.v1_7_R4.NBTBase;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagCompound;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagList;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagString;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.serialization.ConfigurationSerializable;
/*     */ import org.bukkit.configuration.serialization.DelegateDeserialization;
/*     */ import org.bukkit.configuration.serialization.SerializableAs;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.Overridden;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.Repairable;
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
/*     */ 
/*     */ @DelegateDeserialization(CraftMetaItem.SerializableMeta.class)
/*     */ class CraftMetaItem
/*     */   implements ItemMeta, Repairable
/*     */ {
/*     */   static class ItemMetaKey
/*     */   {
/*     */     final String BUKKIT;
/*     */     final String NBT;
/*     */     
/*     */     @Retention(RetentionPolicy.SOURCE)
/*     */     @Target({ElementType.FIELD})
/*     */     static @interface Specific
/*     */     {
/*     */       To value();
/*     */       
/*     */       public enum To
/*     */       {
/*  70 */         BUKKIT,
/*  71 */         NBT;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ItemMetaKey(String both) {
/*  81 */       this(both, both);
/*     */     }
/*     */     
/*     */     ItemMetaKey(String nbt, String bukkit) {
/*  85 */       this.NBT = nbt;
/*  86 */       this.BUKKIT = bukkit;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SerializableAs("ItemMeta")
/*     */   public static class SerializableMeta
/*     */     implements ConfigurationSerializable
/*     */   {
/*     */     static final String TYPE_FIELD = "meta-type";
/*     */     
/*  98 */     static final ImmutableMap<Class<? extends CraftMetaItem>, String> classMap = ImmutableMap.builder().put(CraftMetaBook.class, "BOOK").put(CraftMetaSkull.class, "SKULL").put(CraftMetaLeatherArmor.class, "LEATHER_ARMOR").put(CraftMetaMap.class, "MAP").put(CraftMetaPotion.class, "POTION").put(CraftMetaEnchantedBook.class, "ENCHANTED").put(CraftMetaFirework.class, "FIREWORK").put(CraftMetaCharge.class, "FIREWORK_EFFECT").put(CraftMetaItem.class, "UNSPECIFIC").build();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static final ImmutableMap<String, Constructor<? extends CraftMetaItem>> constructorMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/* 110 */       ImmutableMap.Builder<String, Constructor<? extends CraftMetaItem>> classConstructorBuilder = ImmutableMap.builder();
/* 111 */       for (Map.Entry<Class<? extends CraftMetaItem>, String> mapping : (Iterable<Map.Entry<Class<? extends CraftMetaItem>, String>>)classMap.entrySet()) {
/*     */         try {
/* 113 */           classConstructorBuilder.put(mapping.getValue(), ((Class)mapping.getKey()).getDeclaredConstructor(new Class[] { Map.class }));
/* 114 */         } catch (NoSuchMethodException e) {
/* 115 */           throw new AssertionError(e);
/*     */         } 
/*     */       } 
/* 118 */       constructorMap = classConstructorBuilder.build();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static ItemMeta deserialize(Map<String, Object> map) throws Throwable {
/* 125 */       Validate.notNull(map, "Cannot deserialize null map");
/*     */       
/* 127 */       String type = getString(map, "meta-type", false);
/* 128 */       Constructor<? extends CraftMetaItem> constructor = (Constructor<? extends CraftMetaItem>)constructorMap.get(type);
/*     */       
/* 130 */       if (constructor == null) {
/* 131 */         throw new IllegalArgumentException(type + " is not a valid " + "meta-type");
/*     */       }
/*     */       
/*     */       try {
/* 135 */         return constructor.newInstance(new Object[] { map });
/* 136 */       } catch (InstantiationException e) {
/* 137 */         throw new AssertionError(e);
/* 138 */       } catch (IllegalAccessException e) {
/* 139 */         throw new AssertionError(e);
/* 140 */       } catch (InvocationTargetException e) {
/* 141 */         throw e.getCause();
/*     */       } 
/*     */     }
/*     */     
/*     */     public Map<String, Object> serialize() {
/* 146 */       throw new AssertionError();
/*     */     }
/*     */     
/*     */     static String getString(Map<?, ?> map, Object field, boolean nullable) {
/* 150 */       return getObject(String.class, map, field, nullable);
/*     */     }
/*     */     
/*     */     static boolean getBoolean(Map<?, ?> map, Object field) {
/* 154 */       Boolean value = getObject(Boolean.class, map, field, true);
/* 155 */       return (value != null && value.booleanValue());
/*     */     }
/*     */     
/*     */     static <T> T getObject(Class<T> clazz, Map<?, ?> map, Object field, boolean nullable) {
/* 159 */       Object object = map.get(field);
/*     */       
/* 161 */       if (clazz.isInstance(object)) {
/* 162 */         return clazz.cast(object);
/*     */       }
/* 164 */       if (object == null) {
/* 165 */         if (!nullable) {
/* 166 */           throw new NoSuchElementException(map + " does not contain " + field);
/*     */         }
/* 168 */         return null;
/*     */       } 
/* 170 */       throw new IllegalArgumentException(field + "(" + object + ") is not a valid " + clazz);
/*     */     }
/*     */   }
/*     */   
/* 174 */   static final ItemMetaKey NAME = new ItemMetaKey("Name", "display-name");
/*     */   
/* 176 */   static final ItemMetaKey DISPLAY = new ItemMetaKey("display");
/* 177 */   static final ItemMetaKey LORE = new ItemMetaKey("Lore", "lore");
/* 178 */   static final ItemMetaKey ENCHANTMENTS = new ItemMetaKey("ench", "enchants");
/*     */   
/* 180 */   static final ItemMetaKey ENCHANTMENTS_ID = new ItemMetaKey("id");
/*     */   
/* 182 */   static final ItemMetaKey ENCHANTMENTS_LVL = new ItemMetaKey("lvl");
/* 183 */   static final ItemMetaKey REPAIR = new ItemMetaKey("RepairCost", "repair-cost");
/*     */   
/* 185 */   static final ItemMetaKey ATTRIBUTES = new ItemMetaKey("AttributeModifiers");
/*     */   
/* 187 */   static final ItemMetaKey ATTRIBUTES_IDENTIFIER = new ItemMetaKey("AttributeName");
/*     */   
/* 189 */   static final ItemMetaKey ATTRIBUTES_NAME = new ItemMetaKey("Name");
/*     */   
/* 191 */   static final ItemMetaKey ATTRIBUTES_VALUE = new ItemMetaKey("Amount");
/*     */   
/* 193 */   static final ItemMetaKey ATTRIBUTES_TYPE = new ItemMetaKey("Operation");
/*     */   
/* 195 */   static final ItemMetaKey ATTRIBUTES_UUID_HIGH = new ItemMetaKey("UUIDMost");
/*     */   
/* 197 */   static final ItemMetaKey ATTRIBUTES_UUID_LOW = new ItemMetaKey("UUIDLeast");
/*     */   
/*     */   private String displayName;
/*     */   private List<String> lore;
/*     */   private Map<Enchantment, Integer> enchantments;
/*     */   private int repairCost;
/*     */   private final NBTTagList attributes;
/*     */   
/*     */   CraftMetaItem(CraftMetaItem meta) {
/* 206 */     if (meta == null) {
/* 207 */       this.attributes = null;
/*     */       
/*     */       return;
/*     */     } 
/* 211 */     this.displayName = meta.displayName;
/*     */     
/* 213 */     if (meta.hasLore()) {
/* 214 */       this.lore = new ArrayList<String>(meta.lore);
/*     */     }
/*     */     
/* 217 */     if (meta.hasEnchants()) {
/* 218 */       this.enchantments = new HashMap<Enchantment, Integer>(meta.enchantments);
/*     */     }
/*     */     
/* 221 */     this.repairCost = meta.repairCost;
/* 222 */     this.attributes = meta.attributes;
/*     */   }
/*     */   
/*     */   CraftMetaItem(NBTTagCompound tag) {
/* 226 */     if (tag.hasKey(DISPLAY.NBT)) {
/* 227 */       NBTTagCompound display = tag.getCompound(DISPLAY.NBT);
/*     */       
/* 229 */       if (display.hasKey(NAME.NBT)) {
/* 230 */         this.displayName = display.getString(NAME.NBT);
/*     */       }
/*     */       
/* 233 */       if (display.hasKey(LORE.NBT)) {
/* 234 */         NBTTagList list = display.getList(LORE.NBT, 8);
/* 235 */         this.lore = new ArrayList<String>(list.size());
/*     */         
/* 237 */         for (int index = 0; index < list.size(); index++) {
/* 238 */           String line = list.getString(index);
/* 239 */           this.lore.add(line);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 244 */     this.enchantments = buildEnchantments(tag, ENCHANTMENTS);
/*     */     
/* 246 */     if (tag.hasKey(REPAIR.NBT)) {
/* 247 */       this.repairCost = tag.getInt(REPAIR.NBT);
/*     */     }
/*     */ 
/*     */     
/* 251 */     if (tag.get(ATTRIBUTES.NBT) instanceof NBTTagList) {
/* 252 */       NBTTagList save = null;
/* 253 */       NBTTagList nbttaglist = tag.getList(ATTRIBUTES.NBT, 10);
/*     */       
/* 255 */       for (int i = 0; i < nbttaglist.size(); i++) {
/* 256 */         if (nbttaglist.get(i) instanceof NBTTagCompound) {
/*     */ 
/*     */           
/* 259 */           NBTTagCompound nbttagcompound = nbttaglist.get(i);
/*     */           
/* 261 */           if (nbttagcompound.get(ATTRIBUTES_UUID_HIGH.NBT) instanceof net.minecraft.server.v1_7_R4.NBTTagLong)
/*     */           {
/*     */             
/* 264 */             if (nbttagcompound.get(ATTRIBUTES_UUID_LOW.NBT) instanceof net.minecraft.server.v1_7_R4.NBTTagLong)
/*     */             {
/*     */               
/* 267 */               if (nbttagcompound.get(ATTRIBUTES_IDENTIFIER.NBT) instanceof NBTTagString && CraftItemFactory.KNOWN_NBT_ATTRIBUTE_NAMES.contains(nbttagcompound.getString(ATTRIBUTES_IDENTIFIER.NBT)))
/*     */               {
/*     */                 
/* 270 */                 if (nbttagcompound.get(ATTRIBUTES_NAME.NBT) instanceof NBTTagString && !nbttagcompound.getString(ATTRIBUTES_NAME.NBT).isEmpty())
/*     */                 {
/*     */                   
/* 273 */                   if (nbttagcompound.get(ATTRIBUTES_VALUE.NBT) instanceof net.minecraft.server.v1_7_R4.NBTTagDouble)
/*     */                   {
/*     */                     
/* 276 */                     if (nbttagcompound.get(ATTRIBUTES_TYPE.NBT) instanceof net.minecraft.server.v1_7_R4.NBTTagInt && nbttagcompound.getInt(ATTRIBUTES_TYPE.NBT) >= 0 && nbttagcompound.getInt(ATTRIBUTES_TYPE.NBT) <= 2) {
/*     */ 
/*     */ 
/*     */                       
/* 280 */                       if (save == null) {
/* 281 */                         save = new NBTTagList();
/*     */                       }
/*     */                       
/* 284 */                       NBTTagCompound entry = new NBTTagCompound();
/* 285 */                       entry.set(ATTRIBUTES_UUID_HIGH.NBT, nbttagcompound.get(ATTRIBUTES_UUID_HIGH.NBT));
/* 286 */                       entry.set(ATTRIBUTES_UUID_LOW.NBT, nbttagcompound.get(ATTRIBUTES_UUID_LOW.NBT));
/* 287 */                       entry.set(ATTRIBUTES_IDENTIFIER.NBT, nbttagcompound.get(ATTRIBUTES_IDENTIFIER.NBT));
/* 288 */                       entry.set(ATTRIBUTES_NAME.NBT, nbttagcompound.get(ATTRIBUTES_NAME.NBT));
/* 289 */                       entry.set(ATTRIBUTES_VALUE.NBT, nbttagcompound.get(ATTRIBUTES_VALUE.NBT));
/* 290 */                       entry.set(ATTRIBUTES_TYPE.NBT, nbttagcompound.get(ATTRIBUTES_TYPE.NBT));
/* 291 */                       save.add((NBTBase)entry);
/*     */                     }  }  }  }  }  } 
/*     */         } 
/* 294 */       }  this.attributes = save;
/*     */     } else {
/* 296 */       this.attributes = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   static Map<Enchantment, Integer> buildEnchantments(NBTTagCompound tag, ItemMetaKey key) {
/* 301 */     if (!tag.hasKey(key.NBT)) {
/* 302 */       return null;
/*     */     }
/*     */     
/* 305 */     NBTTagList ench = tag.getList(key.NBT, 10);
/* 306 */     Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>(ench.size());
/*     */     
/* 308 */     for (int i = 0; i < ench.size(); i++) {
/* 309 */       int id = 0xFFFF & ench.get(i).getShort(ENCHANTMENTS_ID.NBT);
/* 310 */       int level = 0xFFFF & ench.get(i).getShort(ENCHANTMENTS_LVL.NBT);
/*     */       
/* 312 */       enchantments.put(Enchantment.getById(id), Integer.valueOf(level));
/*     */     } 
/*     */     
/* 315 */     return enchantments;
/*     */   }
/*     */   
/*     */   CraftMetaItem(Map<String, Object> map) {
/* 319 */     setDisplayName(SerializableMeta.getString(map, NAME.BUKKIT, true));
/*     */     
/* 321 */     Iterable<?> lore = SerializableMeta.<Iterable>getObject(Iterable.class, map, LORE.BUKKIT, true);
/* 322 */     if (lore != null) {
/* 323 */       safelyAdd(lore, this.lore = new ArrayList<String>(), 2147483647);
/*     */     }
/*     */     
/* 326 */     this.enchantments = buildEnchantments(map, ENCHANTMENTS);
/*     */     
/* 328 */     Integer repairCost = SerializableMeta.<Integer>getObject(Integer.class, map, REPAIR.BUKKIT, true);
/* 329 */     if (repairCost != null) {
/* 330 */       setRepairCost(repairCost.intValue());
/*     */     }
/*     */     
/* 333 */     this.attributes = null;
/*     */   }
/*     */   
/*     */   static Map<Enchantment, Integer> buildEnchantments(Map<String, Object> map, ItemMetaKey key) {
/* 337 */     Map<?, ?> ench = SerializableMeta.<Map<?, ?>>getObject((Class)Map.class, map, key.BUKKIT, true);
/* 338 */     if (ench == null) {
/* 339 */       return null;
/*     */     }
/*     */     
/* 342 */     Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>(ench.size());
/* 343 */     for (Map.Entry<?, ?> entry : ench.entrySet()) {
/* 344 */       Enchantment enchantment = Enchantment.getByName(entry.getKey().toString());
/*     */       
/* 346 */       if (enchantment != null && entry.getValue() instanceof Integer) {
/* 347 */         enchantments.put(enchantment, (Integer)entry.getValue());
/*     */       }
/*     */     } 
/*     */     
/* 351 */     return enchantments;
/*     */   }
/*     */   
/*     */   @Overridden
/*     */   void applyToItem(NBTTagCompound itemTag) {
/* 356 */     if (hasDisplayName()) {
/* 357 */       setDisplayTag(itemTag, NAME.NBT, (NBTBase)new NBTTagString(this.displayName));
/*     */     }
/*     */     
/* 360 */     if (hasLore()) {
/* 361 */       setDisplayTag(itemTag, LORE.NBT, (NBTBase)createStringList(this.lore));
/*     */     }
/*     */     
/* 364 */     applyEnchantments(this.enchantments, itemTag, ENCHANTMENTS);
/*     */     
/* 366 */     if (hasRepairCost()) {
/* 367 */       itemTag.setInt(REPAIR.NBT, this.repairCost);
/*     */     }
/*     */     
/* 370 */     if (this.attributes != null) {
/* 371 */       itemTag.set(ATTRIBUTES.NBT, (NBTBase)this.attributes);
/*     */     }
/*     */   }
/*     */   
/*     */   static NBTTagList createStringList(List<String> list) {
/* 376 */     if (list == null || list.isEmpty()) {
/* 377 */       return null;
/*     */     }
/*     */     
/* 380 */     NBTTagList tagList = new NBTTagList();
/* 381 */     for (String value : list) {
/* 382 */       tagList.add((NBTBase)new NBTTagString(value));
/*     */     }
/*     */     
/* 385 */     return tagList;
/*     */   }
/*     */   
/*     */   static void applyEnchantments(Map<Enchantment, Integer> enchantments, NBTTagCompound tag, ItemMetaKey key) {
/* 389 */     if (enchantments == null || enchantments.size() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 393 */     NBTTagList list = new NBTTagList();
/*     */     
/* 395 */     for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
/* 396 */       NBTTagCompound subtag = new NBTTagCompound();
/*     */       
/* 398 */       subtag.setShort(ENCHANTMENTS_ID.NBT, (short)((Enchantment)entry.getKey()).getId());
/* 399 */       subtag.setShort(ENCHANTMENTS_LVL.NBT, ((Integer)entry.getValue()).shortValue());
/*     */       
/* 401 */       list.add((NBTBase)subtag);
/*     */     } 
/*     */     
/* 404 */     tag.set(key.NBT, (NBTBase)list);
/*     */   }
/*     */   
/*     */   void setDisplayTag(NBTTagCompound tag, String key, NBTBase value) {
/* 408 */     NBTTagCompound display = tag.getCompound(DISPLAY.NBT);
/*     */     
/* 410 */     if (!tag.hasKey(DISPLAY.NBT)) {
/* 411 */       tag.set(DISPLAY.NBT, (NBTBase)display);
/*     */     }
/*     */     
/* 414 */     display.set(key, value);
/*     */   }
/*     */   
/*     */   @Overridden
/*     */   boolean applicableTo(Material type) {
/* 419 */     return (type != Material.AIR);
/*     */   }
/*     */   
/*     */   @Overridden
/*     */   boolean isEmpty() {
/* 424 */     return (!hasDisplayName() && !hasEnchants() && !hasLore() && !hasAttributes() && !hasRepairCost());
/*     */   }
/*     */   
/*     */   public String getDisplayName() {
/* 428 */     return this.displayName;
/*     */   }
/*     */   
/*     */   public final void setDisplayName(String name) {
/* 432 */     this.displayName = name;
/*     */   }
/*     */   
/*     */   public boolean hasDisplayName() {
/* 436 */     return !Strings.isNullOrEmpty(this.displayName);
/*     */   }
/*     */   
/*     */   public boolean hasLore() {
/* 440 */     return (this.lore != null && !this.lore.isEmpty());
/*     */   }
/*     */   
/*     */   public boolean hasAttributes() {
/* 444 */     return (this.attributes != null);
/*     */   }
/*     */   
/*     */   public boolean hasRepairCost() {
/* 448 */     return (this.repairCost > 0);
/*     */   }
/*     */   
/*     */   public boolean hasEnchant(Enchantment ench) {
/* 452 */     return (hasEnchants() && this.enchantments.containsKey(ench));
/*     */   }
/*     */   
/*     */   public int getEnchantLevel(Enchantment ench) {
/* 456 */     Integer level = hasEnchants() ? this.enchantments.get(ench) : null;
/* 457 */     if (level == null) {
/* 458 */       return 0;
/*     */     }
/* 460 */     return level.intValue();
/*     */   }
/*     */   
/*     */   public Map<Enchantment, Integer> getEnchants() {
/* 464 */     return hasEnchants() ? (Map<Enchantment, Integer>)ImmutableMap.copyOf(this.enchantments) : (Map<Enchantment, Integer>)ImmutableMap.of();
/*     */   }
/*     */   
/*     */   public boolean addEnchant(Enchantment ench, int level, boolean ignoreRestrictions) {
/* 468 */     if (this.enchantments == null) {
/* 469 */       this.enchantments = new HashMap<Enchantment, Integer>(4);
/*     */     }
/*     */     
/* 472 */     if (ignoreRestrictions || (level >= ench.getStartLevel() && level <= ench.getMaxLevel())) {
/* 473 */       Integer old = this.enchantments.put(ench, Integer.valueOf(level));
/* 474 */       return (old == null || old.intValue() != level);
/*     */     } 
/* 476 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeEnchant(Enchantment ench) {
/* 480 */     return (hasEnchants() && this.enchantments.remove(ench) != null);
/*     */   }
/*     */   
/*     */   public boolean hasEnchants() {
/* 484 */     return (this.enchantments != null && !this.enchantments.isEmpty());
/*     */   }
/*     */   
/*     */   public boolean hasConflictingEnchant(Enchantment ench) {
/* 488 */     return checkConflictingEnchants(this.enchantments, ench);
/*     */   }
/*     */   
/*     */   public List<String> getLore() {
/* 492 */     return (this.lore == null) ? null : new ArrayList<String>(this.lore);
/*     */   }
/*     */   
/*     */   public void setLore(List<String> lore) {
/* 496 */     if (lore == null) {
/* 497 */       this.lore = null;
/*     */     }
/* 499 */     else if (this.lore == null) {
/* 500 */       safelyAdd(lore, this.lore = new ArrayList<String>(lore.size()), 2147483647);
/*     */     } else {
/* 502 */       this.lore.clear();
/* 503 */       safelyAdd(lore, this.lore, 2147483647);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRepairCost() {
/* 509 */     return this.repairCost;
/*     */   }
/*     */   
/*     */   public void setRepairCost(int cost) {
/* 513 */     this.repairCost = cost;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object object) {
/* 518 */     if (object == null) {
/* 519 */       return false;
/*     */     }
/* 521 */     if (object == this) {
/* 522 */       return true;
/*     */     }
/* 524 */     if (!(object instanceof CraftMetaItem)) {
/* 525 */       return false;
/*     */     }
/* 527 */     return CraftItemFactory.instance().equals(this, (ItemMeta)object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overridden
/*     */   boolean equalsCommon(CraftMetaItem that) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual hasDisplayName : ()Z
/*     */     //   4: ifeq -> 31
/*     */     //   7: aload_1
/*     */     //   8: invokevirtual hasDisplayName : ()Z
/*     */     //   11: ifeq -> 195
/*     */     //   14: aload_0
/*     */     //   15: getfield displayName : Ljava/lang/String;
/*     */     //   18: aload_1
/*     */     //   19: getfield displayName : Ljava/lang/String;
/*     */     //   22: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   25: ifeq -> 195
/*     */     //   28: goto -> 38
/*     */     //   31: aload_1
/*     */     //   32: invokevirtual hasDisplayName : ()Z
/*     */     //   35: ifne -> 195
/*     */     //   38: aload_0
/*     */     //   39: invokevirtual hasEnchants : ()Z
/*     */     //   42: ifeq -> 71
/*     */     //   45: aload_1
/*     */     //   46: invokevirtual hasEnchants : ()Z
/*     */     //   49: ifeq -> 195
/*     */     //   52: aload_0
/*     */     //   53: getfield enchantments : Ljava/util/Map;
/*     */     //   56: aload_1
/*     */     //   57: getfield enchantments : Ljava/util/Map;
/*     */     //   60: invokeinterface equals : (Ljava/lang/Object;)Z
/*     */     //   65: ifeq -> 195
/*     */     //   68: goto -> 78
/*     */     //   71: aload_1
/*     */     //   72: invokevirtual hasEnchants : ()Z
/*     */     //   75: ifne -> 195
/*     */     //   78: aload_0
/*     */     //   79: invokevirtual hasLore : ()Z
/*     */     //   82: ifeq -> 111
/*     */     //   85: aload_1
/*     */     //   86: invokevirtual hasLore : ()Z
/*     */     //   89: ifeq -> 195
/*     */     //   92: aload_0
/*     */     //   93: getfield lore : Ljava/util/List;
/*     */     //   96: aload_1
/*     */     //   97: getfield lore : Ljava/util/List;
/*     */     //   100: invokeinterface equals : (Ljava/lang/Object;)Z
/*     */     //   105: ifeq -> 195
/*     */     //   108: goto -> 118
/*     */     //   111: aload_1
/*     */     //   112: invokevirtual hasLore : ()Z
/*     */     //   115: ifne -> 195
/*     */     //   118: aload_0
/*     */     //   119: invokevirtual hasAttributes : ()Z
/*     */     //   122: ifeq -> 149
/*     */     //   125: aload_1
/*     */     //   126: invokevirtual hasAttributes : ()Z
/*     */     //   129: ifeq -> 195
/*     */     //   132: aload_0
/*     */     //   133: getfield attributes : Lnet/minecraft/server/v1_7_R4/NBTTagList;
/*     */     //   136: aload_1
/*     */     //   137: getfield attributes : Lnet/minecraft/server/v1_7_R4/NBTTagList;
/*     */     //   140: invokevirtual equals : (Ljava/lang/Object;)Z
/*     */     //   143: ifeq -> 195
/*     */     //   146: goto -> 156
/*     */     //   149: aload_1
/*     */     //   150: invokevirtual hasAttributes : ()Z
/*     */     //   153: ifne -> 195
/*     */     //   156: aload_0
/*     */     //   157: invokevirtual hasRepairCost : ()Z
/*     */     //   160: ifeq -> 184
/*     */     //   163: aload_1
/*     */     //   164: invokevirtual hasRepairCost : ()Z
/*     */     //   167: ifeq -> 195
/*     */     //   170: aload_0
/*     */     //   171: getfield repairCost : I
/*     */     //   174: aload_1
/*     */     //   175: getfield repairCost : I
/*     */     //   178: if_icmpne -> 195
/*     */     //   181: goto -> 191
/*     */     //   184: aload_1
/*     */     //   185: invokevirtual hasRepairCost : ()Z
/*     */     //   188: ifne -> 195
/*     */     //   191: iconst_1
/*     */     //   192: goto -> 196
/*     */     //   195: iconst_0
/*     */     //   196: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #537	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	197	0	this	Lorg/bukkit/craftbukkit/v1_7_R4/inventory/CraftMetaItem;
/*     */     //   0	197	1	that	Lorg/bukkit/craftbukkit/v1_7_R4/inventory/CraftMetaItem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Overridden
/*     */   boolean notUncommon(CraftMetaItem meta) {
/* 551 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 556 */     return applyHash();
/*     */   }
/*     */   
/*     */   @Overridden
/*     */   int applyHash() {
/* 561 */     int hash = 3;
/* 562 */     hash = 61 * hash + (hasDisplayName() ? this.displayName.hashCode() : 0);
/* 563 */     hash = 61 * hash + (hasLore() ? this.lore.hashCode() : 0);
/* 564 */     hash = 61 * hash + (hasEnchants() ? this.enchantments.hashCode() : 0);
/* 565 */     hash = 61 * hash + (hasAttributes() ? this.attributes.hashCode() : 0);
/* 566 */     hash = 61 * hash + (hasRepairCost() ? this.repairCost : 0);
/* 567 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   @Overridden
/*     */   public CraftMetaItem clone() {
/*     */     try {
/* 574 */       CraftMetaItem clone = (CraftMetaItem)super.clone();
/* 575 */       if (this.lore != null) {
/* 576 */         clone.lore = new ArrayList<String>(this.lore);
/*     */       }
/* 578 */       if (this.enchantments != null) {
/* 579 */         clone.enchantments = new HashMap<Enchantment, Integer>(this.enchantments);
/*     */       }
/* 581 */       return clone;
/* 582 */     } catch (CloneNotSupportedException e) {
/* 583 */       throw new Error(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final Map<String, Object> serialize() {
/* 588 */     ImmutableMap.Builder<String, Object> map = ImmutableMap.builder();
/* 589 */     map.put("meta-type", SerializableMeta.classMap.get(getClass()));
/* 590 */     serialize(map);
/* 591 */     return (Map<String, Object>)map.build();
/*     */   }
/*     */   
/*     */   @Overridden
/*     */   ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
/* 596 */     if (hasDisplayName()) {
/* 597 */       builder.put(NAME.BUKKIT, this.displayName);
/*     */     }
/*     */     
/* 600 */     if (hasLore()) {
/* 601 */       builder.put(LORE.BUKKIT, ImmutableList.copyOf(this.lore));
/*     */     }
/*     */     
/* 604 */     serializeEnchantments(this.enchantments, builder, ENCHANTMENTS);
/*     */     
/* 606 */     if (hasRepairCost()) {
/* 607 */       builder.put(REPAIR.BUKKIT, Integer.valueOf(this.repairCost));
/*     */     }
/*     */     
/* 610 */     return builder;
/*     */   }
/*     */   
/*     */   static void serializeEnchantments(Map<Enchantment, Integer> enchantments, ImmutableMap.Builder<String, Object> builder, ItemMetaKey key) {
/* 614 */     if (enchantments == null || enchantments.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 618 */     ImmutableMap.Builder<String, Integer> enchants = ImmutableMap.builder();
/* 619 */     for (Map.Entry<? extends Enchantment, Integer> enchant : enchantments.entrySet()) {
/* 620 */       enchants.put(((Enchantment)enchant.getKey()).getName(), enchant.getValue());
/*     */     }
/*     */     
/* 623 */     builder.put(key.BUKKIT, enchants.build());
/*     */   }
/*     */   
/*     */   static void safelyAdd(Iterable<?> addFrom, Collection<String> addTo, int maxItemLength) {
/* 627 */     if (addFrom == null) {
/*     */       return;
/*     */     }
/*     */     
/* 631 */     for (Object object : addFrom) {
/* 632 */       if (!(object instanceof String)) {
/* 633 */         if (object != null) {
/* 634 */           throw new IllegalArgumentException(addFrom + " cannot contain non-string " + object.getClass().getName());
/*     */         }
/*     */         
/* 637 */         addTo.add(""); continue;
/*     */       } 
/* 639 */       String page = object.toString();
/*     */       
/* 641 */       if (page.length() > maxItemLength) {
/* 642 */         page = page.substring(0, maxItemLength);
/*     */       }
/*     */       
/* 645 */       addTo.add(page);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean checkConflictingEnchants(Map<Enchantment, Integer> enchantments, Enchantment ench) {
/* 651 */     if (enchantments == null || enchantments.isEmpty()) {
/* 652 */       return false;
/*     */     }
/*     */     
/* 655 */     for (Enchantment enchant : enchantments.keySet()) {
/* 656 */       if (enchant.conflictsWith(ench)) {
/* 657 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 661 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 666 */     return (String)SerializableMeta.classMap.get(getClass()) + "_META:" + serialize();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\inventory\CraftMetaItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */