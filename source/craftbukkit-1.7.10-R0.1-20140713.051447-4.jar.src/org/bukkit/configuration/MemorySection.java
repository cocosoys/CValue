/*     */ package org.bukkit.configuration;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.util.NumberConversions;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MemorySection
/*     */   implements ConfigurationSection
/*     */ {
/*  22 */   protected final Map<String, Object> map = new LinkedHashMap<String, Object>();
/*     */ 
/*     */   
/*     */   private final Configuration root;
/*     */ 
/*     */   
/*     */   private final ConfigurationSection parent;
/*     */ 
/*     */   
/*     */   private final String path;
/*     */ 
/*     */   
/*     */   private final String fullPath;
/*     */ 
/*     */ 
/*     */   
/*     */   protected MemorySection() {
/*  39 */     if (!(this instanceof Configuration)) {
/*  40 */       throw new IllegalStateException("Cannot construct a root MemorySection when not a Configuration");
/*     */     }
/*     */     
/*  43 */     this.path = "";
/*  44 */     this.fullPath = "";
/*  45 */     this.parent = null;
/*  46 */     this.root = (Configuration)this;
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
/*     */   protected MemorySection(ConfigurationSection parent, String path) {
/*  59 */     Validate.notNull(parent, "Parent cannot be null");
/*  60 */     Validate.notNull(path, "Path cannot be null");
/*     */     
/*  62 */     this.path = path;
/*  63 */     this.parent = parent;
/*  64 */     this.root = parent.getRoot();
/*     */     
/*  66 */     Validate.notNull(this.root, "Path cannot be orphaned");
/*     */     
/*  68 */     this.fullPath = createPath(parent, path);
/*     */   }
/*     */   
/*     */   public Set<String> getKeys(boolean deep) {
/*  72 */     Set<String> result = new LinkedHashSet<String>();
/*     */     
/*  74 */     Configuration root = getRoot();
/*  75 */     if (root != null && root.options().copyDefaults()) {
/*  76 */       ConfigurationSection defaults = getDefaultSection();
/*     */       
/*  78 */       if (defaults != null) {
/*  79 */         result.addAll(defaults.getKeys(deep));
/*     */       }
/*     */     } 
/*     */     
/*  83 */     mapChildrenKeys(result, this, deep);
/*     */     
/*  85 */     return result;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getValues(boolean deep) {
/*  89 */     Map<String, Object> result = new LinkedHashMap<String, Object>();
/*     */     
/*  91 */     Configuration root = getRoot();
/*  92 */     if (root != null && root.options().copyDefaults()) {
/*  93 */       ConfigurationSection defaults = getDefaultSection();
/*     */       
/*  95 */       if (defaults != null) {
/*  96 */         result.putAll(defaults.getValues(deep));
/*     */       }
/*     */     } 
/*     */     
/* 100 */     mapChildrenValues(result, this, deep);
/*     */     
/* 102 */     return result;
/*     */   }
/*     */   
/*     */   public boolean contains(String path) {
/* 106 */     return (get(path) != null);
/*     */   }
/*     */   
/*     */   public boolean isSet(String path) {
/* 110 */     Configuration root = getRoot();
/* 111 */     if (root == null) {
/* 112 */       return false;
/*     */     }
/* 114 */     if (root.options().copyDefaults()) {
/* 115 */       return contains(path);
/*     */     }
/* 117 */     return (get(path, null) != null);
/*     */   }
/*     */   
/*     */   public String getCurrentPath() {
/* 121 */     return this.fullPath;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 125 */     return this.path;
/*     */   }
/*     */   
/*     */   public Configuration getRoot() {
/* 129 */     return this.root;
/*     */   }
/*     */   
/*     */   public ConfigurationSection getParent() {
/* 133 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void addDefault(String path, Object value) {
/* 137 */     Validate.notNull(path, "Path cannot be null");
/*     */     
/* 139 */     Configuration root = getRoot();
/* 140 */     if (root == null) {
/* 141 */       throw new IllegalStateException("Cannot add default without root");
/*     */     }
/* 143 */     if (root == this) {
/* 144 */       throw new UnsupportedOperationException("Unsupported addDefault(String, Object) implementation");
/*     */     }
/* 146 */     root.addDefault(createPath(this, path), value);
/*     */   }
/*     */   
/*     */   public ConfigurationSection getDefaultSection() {
/* 150 */     Configuration root = getRoot();
/* 151 */     Configuration defaults = (root == null) ? null : root.getDefaults();
/*     */     
/* 153 */     if (defaults != null && 
/* 154 */       defaults.isConfigurationSection(getCurrentPath())) {
/* 155 */       return defaults.getConfigurationSection(getCurrentPath());
/*     */     }
/*     */ 
/*     */     
/* 159 */     return null;
/*     */   }
/*     */   
/*     */   public void set(String path, Object value) {
/* 163 */     Validate.notEmpty(path, "Cannot set to an empty path");
/*     */     
/* 165 */     Configuration root = getRoot();
/* 166 */     if (root == null) {
/* 167 */       throw new IllegalStateException("Cannot use section without a root");
/*     */     }
/*     */     
/* 170 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 173 */     int i1 = -1;
/* 174 */     ConfigurationSection section = this; int i2;
/* 175 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 176 */       String node = path.substring(i2, i1);
/* 177 */       ConfigurationSection subSection = section.getConfigurationSection(node);
/* 178 */       if (subSection == null) {
/* 179 */         section = section.createSection(node); continue;
/*     */       } 
/* 181 */       section = subSection;
/*     */     } 
/*     */ 
/*     */     
/* 185 */     String key = path.substring(i2);
/* 186 */     if (section == this) {
/* 187 */       if (value == null) {
/* 188 */         this.map.remove(key);
/*     */       } else {
/* 190 */         this.map.put(key, value);
/*     */       } 
/*     */     } else {
/* 193 */       section.set(key, value);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object get(String path) {
/* 198 */     return get(path, getDefault(path));
/*     */   }
/*     */   
/*     */   public Object get(String path, Object def) {
/* 202 */     Validate.notNull(path, "Path cannot be null");
/*     */     
/* 204 */     if (path.length() == 0) {
/* 205 */       return this;
/*     */     }
/*     */     
/* 208 */     Configuration root = getRoot();
/* 209 */     if (root == null) {
/* 210 */       throw new IllegalStateException("Cannot access section without a root");
/*     */     }
/*     */     
/* 213 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 216 */     int i1 = -1;
/* 217 */     ConfigurationSection section = this; int i2;
/* 218 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 219 */       section = section.getConfigurationSection(path.substring(i2, i1));
/* 220 */       if (section == null) {
/* 221 */         return def;
/*     */       }
/*     */     } 
/*     */     
/* 225 */     String key = path.substring(i2);
/* 226 */     if (section == this) {
/* 227 */       Object result = this.map.get(key);
/* 228 */       return (result == null) ? def : result;
/*     */     } 
/* 230 */     return section.get(key, def);
/*     */   }
/*     */   
/*     */   public ConfigurationSection createSection(String path) {
/* 234 */     Validate.notEmpty(path, "Cannot create section at empty path");
/* 235 */     Configuration root = getRoot();
/* 236 */     if (root == null) {
/* 237 */       throw new IllegalStateException("Cannot create section without a root");
/*     */     }
/*     */     
/* 240 */     char separator = root.options().pathSeparator();
/*     */ 
/*     */     
/* 243 */     int i1 = -1;
/* 244 */     ConfigurationSection section = this; int i2;
/* 245 */     while ((i1 = path.indexOf(separator, i2 = i1 + 1)) != -1) {
/* 246 */       String node = path.substring(i2, i1);
/* 247 */       ConfigurationSection subSection = section.getConfigurationSection(node);
/* 248 */       if (subSection == null) {
/* 249 */         section = section.createSection(node); continue;
/*     */       } 
/* 251 */       section = subSection;
/*     */     } 
/*     */ 
/*     */     
/* 255 */     String key = path.substring(i2);
/* 256 */     if (section == this) {
/* 257 */       ConfigurationSection result = new MemorySection(this, key);
/* 258 */       this.map.put(key, result);
/* 259 */       return result;
/*     */     } 
/* 261 */     return section.createSection(key);
/*     */   }
/*     */   
/*     */   public ConfigurationSection createSection(String path, Map<?, ?> map) {
/* 265 */     ConfigurationSection section = createSection(path);
/*     */     
/* 267 */     for (Map.Entry<?, ?> entry : map.entrySet()) {
/* 268 */       if (entry.getValue() instanceof Map) {
/* 269 */         section.createSection(entry.getKey().toString(), (Map<?, ?>)entry.getValue()); continue;
/*     */       } 
/* 271 */       section.set(entry.getKey().toString(), entry.getValue());
/*     */     } 
/*     */ 
/*     */     
/* 275 */     return section;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString(String path) {
/* 280 */     Object def = getDefault(path);
/* 281 */     return getString(path, (def != null) ? def.toString() : null);
/*     */   }
/*     */   
/*     */   public String getString(String path, String def) {
/* 285 */     Object val = get(path, def);
/* 286 */     return (val != null) ? val.toString() : def;
/*     */   }
/*     */   
/*     */   public boolean isString(String path) {
/* 290 */     Object val = get(path);
/* 291 */     return val instanceof String;
/*     */   }
/*     */   
/*     */   public int getInt(String path) {
/* 295 */     Object def = getDefault(path);
/* 296 */     return getInt(path, (def instanceof Number) ? NumberConversions.toInt(def) : 0);
/*     */   }
/*     */   
/*     */   public int getInt(String path, int def) {
/* 300 */     Object val = get(path, Integer.valueOf(def));
/* 301 */     return (val instanceof Number) ? NumberConversions.toInt(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isInt(String path) {
/* 305 */     Object val = get(path);
/* 306 */     return val instanceof Integer;
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String path) {
/* 310 */     Object def = getDefault(path);
/* 311 */     return getBoolean(path, (def instanceof Boolean) ? ((Boolean)def).booleanValue() : false);
/*     */   }
/*     */   
/*     */   public boolean getBoolean(String path, boolean def) {
/* 315 */     Object val = get(path, Boolean.valueOf(def));
/* 316 */     return (val instanceof Boolean) ? ((Boolean)val).booleanValue() : def;
/*     */   }
/*     */   
/*     */   public boolean isBoolean(String path) {
/* 320 */     Object val = get(path);
/* 321 */     return val instanceof Boolean;
/*     */   }
/*     */   
/*     */   public double getDouble(String path) {
/* 325 */     Object def = getDefault(path);
/* 326 */     return getDouble(path, (def instanceof Number) ? NumberConversions.toDouble(def) : 0.0D);
/*     */   }
/*     */   
/*     */   public double getDouble(String path, double def) {
/* 330 */     Object val = get(path, Double.valueOf(def));
/* 331 */     return (val instanceof Number) ? NumberConversions.toDouble(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isDouble(String path) {
/* 335 */     Object val = get(path);
/* 336 */     return val instanceof Double;
/*     */   }
/*     */   
/*     */   public long getLong(String path) {
/* 340 */     Object def = getDefault(path);
/* 341 */     return getLong(path, (def instanceof Number) ? NumberConversions.toLong(def) : 0L);
/*     */   }
/*     */   
/*     */   public long getLong(String path, long def) {
/* 345 */     Object val = get(path, Long.valueOf(def));
/* 346 */     return (val instanceof Number) ? NumberConversions.toLong(val) : def;
/*     */   }
/*     */   
/*     */   public boolean isLong(String path) {
/* 350 */     Object val = get(path);
/* 351 */     return val instanceof Long;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<?> getList(String path) {
/* 356 */     Object def = getDefault(path);
/* 357 */     return getList(path, (def instanceof List) ? (List)def : null);
/*     */   }
/*     */   
/*     */   public List<?> getList(String path, List<?> def) {
/* 361 */     Object val = get(path, def);
/* 362 */     return (val instanceof List) ? (List)val : def;
/*     */   }
/*     */   
/*     */   public boolean isList(String path) {
/* 366 */     Object val = get(path);
/* 367 */     return val instanceof List;
/*     */   }
/*     */   
/*     */   public List<String> getStringList(String path) {
/* 371 */     List<?> list = getList(path);
/*     */     
/* 373 */     if (list == null) {
/* 374 */       return new ArrayList<String>(0);
/*     */     }
/*     */     
/* 377 */     List<String> result = new ArrayList<String>();
/*     */     
/* 379 */     for (Object object : list) {
/* 380 */       if (object instanceof String || isPrimitiveWrapper(object)) {
/* 381 */         result.add(String.valueOf(object));
/*     */       }
/*     */     } 
/*     */     
/* 385 */     return result;
/*     */   }
/*     */   
/*     */   public List<Integer> getIntegerList(String path) {
/* 389 */     List<?> list = getList(path);
/*     */     
/* 391 */     if (list == null) {
/* 392 */       return new ArrayList<Integer>(0);
/*     */     }
/*     */     
/* 395 */     List<Integer> result = new ArrayList<Integer>();
/*     */     
/* 397 */     for (Object object : list) {
/* 398 */       if (object instanceof Integer) {
/* 399 */         result.add((Integer)object); continue;
/* 400 */       }  if (object instanceof String) {
/*     */         try {
/* 402 */           result.add(Integer.valueOf((String)object));
/* 403 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 405 */       if (object instanceof Character) {
/* 406 */         result.add(Integer.valueOf(((Character)object).charValue())); continue;
/* 407 */       }  if (object instanceof Number) {
/* 408 */         result.add(Integer.valueOf(((Number)object).intValue()));
/*     */       }
/*     */     } 
/*     */     
/* 412 */     return result;
/*     */   }
/*     */   
/*     */   public List<Boolean> getBooleanList(String path) {
/* 416 */     List<?> list = getList(path);
/*     */     
/* 418 */     if (list == null) {
/* 419 */       return new ArrayList<Boolean>(0);
/*     */     }
/*     */     
/* 422 */     List<Boolean> result = new ArrayList<Boolean>();
/*     */     
/* 424 */     for (Object object : list) {
/* 425 */       if (object instanceof Boolean) {
/* 426 */         result.add((Boolean)object); continue;
/* 427 */       }  if (object instanceof String) {
/* 428 */         if (Boolean.TRUE.toString().equals(object)) {
/* 429 */           result.add(Boolean.valueOf(true)); continue;
/* 430 */         }  if (Boolean.FALSE.toString().equals(object)) {
/* 431 */           result.add(Boolean.valueOf(false));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 436 */     return result;
/*     */   }
/*     */   
/*     */   public List<Double> getDoubleList(String path) {
/* 440 */     List<?> list = getList(path);
/*     */     
/* 442 */     if (list == null) {
/* 443 */       return new ArrayList<Double>(0);
/*     */     }
/*     */     
/* 446 */     List<Double> result = new ArrayList<Double>();
/*     */     
/* 448 */     for (Object object : list) {
/* 449 */       if (object instanceof Double) {
/* 450 */         result.add((Double)object); continue;
/* 451 */       }  if (object instanceof String) {
/*     */         try {
/* 453 */           result.add(Double.valueOf((String)object));
/* 454 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 456 */       if (object instanceof Character) {
/* 457 */         result.add(Double.valueOf(((Character)object).charValue())); continue;
/* 458 */       }  if (object instanceof Number) {
/* 459 */         result.add(Double.valueOf(((Number)object).doubleValue()));
/*     */       }
/*     */     } 
/*     */     
/* 463 */     return result;
/*     */   }
/*     */   
/*     */   public List<Float> getFloatList(String path) {
/* 467 */     List<?> list = getList(path);
/*     */     
/* 469 */     if (list == null) {
/* 470 */       return new ArrayList<Float>(0);
/*     */     }
/*     */     
/* 473 */     List<Float> result = new ArrayList<Float>();
/*     */     
/* 475 */     for (Object object : list) {
/* 476 */       if (object instanceof Float) {
/* 477 */         result.add((Float)object); continue;
/* 478 */       }  if (object instanceof String) {
/*     */         try {
/* 480 */           result.add(Float.valueOf((String)object));
/* 481 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 483 */       if (object instanceof Character) {
/* 484 */         result.add(Float.valueOf(((Character)object).charValue())); continue;
/* 485 */       }  if (object instanceof Number) {
/* 486 */         result.add(Float.valueOf(((Number)object).floatValue()));
/*     */       }
/*     */     } 
/*     */     
/* 490 */     return result;
/*     */   }
/*     */   
/*     */   public List<Long> getLongList(String path) {
/* 494 */     List<?> list = getList(path);
/*     */     
/* 496 */     if (list == null) {
/* 497 */       return new ArrayList<Long>(0);
/*     */     }
/*     */     
/* 500 */     List<Long> result = new ArrayList<Long>();
/*     */     
/* 502 */     for (Object object : list) {
/* 503 */       if (object instanceof Long) {
/* 504 */         result.add((Long)object); continue;
/* 505 */       }  if (object instanceof String) {
/*     */         try {
/* 507 */           result.add(Long.valueOf((String)object));
/* 508 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 510 */       if (object instanceof Character) {
/* 511 */         result.add(Long.valueOf(((Character)object).charValue())); continue;
/* 512 */       }  if (object instanceof Number) {
/* 513 */         result.add(Long.valueOf(((Number)object).longValue()));
/*     */       }
/*     */     } 
/*     */     
/* 517 */     return result;
/*     */   }
/*     */   
/*     */   public List<Byte> getByteList(String path) {
/* 521 */     List<?> list = getList(path);
/*     */     
/* 523 */     if (list == null) {
/* 524 */       return new ArrayList<Byte>(0);
/*     */     }
/*     */     
/* 527 */     List<Byte> result = new ArrayList<Byte>();
/*     */     
/* 529 */     for (Object object : list) {
/* 530 */       if (object instanceof Byte) {
/* 531 */         result.add((Byte)object); continue;
/* 532 */       }  if (object instanceof String) {
/*     */         try {
/* 534 */           result.add(Byte.valueOf((String)object));
/* 535 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 537 */       if (object instanceof Character) {
/* 538 */         result.add(Byte.valueOf((byte)((Character)object).charValue())); continue;
/* 539 */       }  if (object instanceof Number) {
/* 540 */         result.add(Byte.valueOf(((Number)object).byteValue()));
/*     */       }
/*     */     } 
/*     */     
/* 544 */     return result;
/*     */   }
/*     */   
/*     */   public List<Character> getCharacterList(String path) {
/* 548 */     List<?> list = getList(path);
/*     */     
/* 550 */     if (list == null) {
/* 551 */       return new ArrayList<Character>(0);
/*     */     }
/*     */     
/* 554 */     List<Character> result = new ArrayList<Character>();
/*     */     
/* 556 */     for (Object object : list) {
/* 557 */       if (object instanceof Character) {
/* 558 */         result.add((Character)object); continue;
/* 559 */       }  if (object instanceof String) {
/* 560 */         String str = (String)object;
/*     */         
/* 562 */         if (str.length() == 1)
/* 563 */           result.add(Character.valueOf(str.charAt(0)));  continue;
/*     */       } 
/* 565 */       if (object instanceof Number) {
/* 566 */         result.add(Character.valueOf((char)((Number)object).intValue()));
/*     */       }
/*     */     } 
/*     */     
/* 570 */     return result;
/*     */   }
/*     */   
/*     */   public List<Short> getShortList(String path) {
/* 574 */     List<?> list = getList(path);
/*     */     
/* 576 */     if (list == null) {
/* 577 */       return new ArrayList<Short>(0);
/*     */     }
/*     */     
/* 580 */     List<Short> result = new ArrayList<Short>();
/*     */     
/* 582 */     for (Object object : list) {
/* 583 */       if (object instanceof Short) {
/* 584 */         result.add((Short)object); continue;
/* 585 */       }  if (object instanceof String) {
/*     */         try {
/* 587 */           result.add(Short.valueOf((String)object));
/* 588 */         } catch (Exception ex) {} continue;
/*     */       } 
/* 590 */       if (object instanceof Character) {
/* 591 */         result.add(Short.valueOf((short)((Character)object).charValue())); continue;
/* 592 */       }  if (object instanceof Number) {
/* 593 */         result.add(Short.valueOf(((Number)object).shortValue()));
/*     */       }
/*     */     } 
/*     */     
/* 597 */     return result;
/*     */   }
/*     */   
/*     */   public List<Map<?, ?>> getMapList(String path) {
/* 601 */     List<?> list = getList(path);
/* 602 */     List<Map<?, ?>> result = new ArrayList<Map<?, ?>>();
/*     */     
/* 604 */     if (list == null) {
/* 605 */       return result;
/*     */     }
/*     */     
/* 608 */     for (Object object : list) {
/* 609 */       if (object instanceof Map) {
/* 610 */         result.add((Map<?, ?>)object);
/*     */       }
/*     */     } 
/*     */     
/* 614 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vector getVector(String path) {
/* 619 */     Object def = getDefault(path);
/* 620 */     return getVector(path, (def instanceof Vector) ? (Vector)def : null);
/*     */   }
/*     */   
/*     */   public Vector getVector(String path, Vector def) {
/* 624 */     Object val = get(path, def);
/* 625 */     return (val instanceof Vector) ? (Vector)val : def;
/*     */   }
/*     */   
/*     */   public boolean isVector(String path) {
/* 629 */     Object val = get(path);
/* 630 */     return val instanceof Vector;
/*     */   }
/*     */   
/*     */   public OfflinePlayer getOfflinePlayer(String path) {
/* 634 */     Object def = getDefault(path);
/* 635 */     return getOfflinePlayer(path, (def instanceof OfflinePlayer) ? (OfflinePlayer)def : null);
/*     */   }
/*     */   
/*     */   public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
/* 639 */     Object val = get(path, def);
/* 640 */     return (val instanceof OfflinePlayer) ? (OfflinePlayer)val : def;
/*     */   }
/*     */   
/*     */   public boolean isOfflinePlayer(String path) {
/* 644 */     Object val = get(path);
/* 645 */     return val instanceof OfflinePlayer;
/*     */   }
/*     */   
/*     */   public ItemStack getItemStack(String path) {
/* 649 */     Object def = getDefault(path);
/* 650 */     return getItemStack(path, (def instanceof ItemStack) ? (ItemStack)def : null);
/*     */   }
/*     */   
/*     */   public ItemStack getItemStack(String path, ItemStack def) {
/* 654 */     Object val = get(path, def);
/* 655 */     return (val instanceof ItemStack) ? (ItemStack)val : def;
/*     */   }
/*     */   
/*     */   public boolean isItemStack(String path) {
/* 659 */     Object val = get(path);
/* 660 */     return val instanceof ItemStack;
/*     */   }
/*     */   
/*     */   public Color getColor(String path) {
/* 664 */     Object def = getDefault(path);
/* 665 */     return getColor(path, (def instanceof Color) ? (Color)def : null);
/*     */   }
/*     */   
/*     */   public Color getColor(String path, Color def) {
/* 669 */     Object val = get(path, def);
/* 670 */     return (val instanceof Color) ? (Color)val : def;
/*     */   }
/*     */   
/*     */   public boolean isColor(String path) {
/* 674 */     Object val = get(path);
/* 675 */     return val instanceof Color;
/*     */   }
/*     */   
/*     */   public ConfigurationSection getConfigurationSection(String path) {
/* 679 */     Object val = get(path, null);
/* 680 */     if (val != null) {
/* 681 */       return (val instanceof ConfigurationSection) ? (ConfigurationSection)val : null;
/*     */     }
/*     */     
/* 684 */     val = get(path, getDefault(path));
/* 685 */     return (val instanceof ConfigurationSection) ? createSection(path) : null;
/*     */   }
/*     */   
/*     */   public boolean isConfigurationSection(String path) {
/* 689 */     Object val = get(path);
/* 690 */     return val instanceof ConfigurationSection;
/*     */   }
/*     */   
/*     */   protected boolean isPrimitiveWrapper(Object input) {
/* 694 */     return (input instanceof Integer || input instanceof Boolean || input instanceof Character || input instanceof Byte || input instanceof Short || input instanceof Double || input instanceof Long || input instanceof Float);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getDefault(String path) {
/* 701 */     Validate.notNull(path, "Path cannot be null");
/*     */     
/* 703 */     Configuration root = getRoot();
/* 704 */     Configuration defaults = (root == null) ? null : root.getDefaults();
/* 705 */     return (defaults == null) ? null : defaults.get(createPath(this, path));
/*     */   }
/*     */   
/*     */   protected void mapChildrenKeys(Set<String> output, ConfigurationSection section, boolean deep) {
/* 709 */     if (section instanceof MemorySection) {
/* 710 */       MemorySection sec = (MemorySection)section;
/*     */       
/* 712 */       for (Map.Entry<String, Object> entry : sec.map.entrySet()) {
/* 713 */         output.add(createPath(section, entry.getKey(), this));
/*     */         
/* 715 */         if (deep && entry.getValue() instanceof ConfigurationSection) {
/* 716 */           ConfigurationSection subsection = (ConfigurationSection)entry.getValue();
/* 717 */           mapChildrenKeys(output, subsection, deep);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 721 */       Set<String> keys = section.getKeys(deep);
/*     */       
/* 723 */       for (String key : keys) {
/* 724 */         output.add(createPath(section, key, this));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void mapChildrenValues(Map<String, Object> output, ConfigurationSection section, boolean deep) {
/* 730 */     if (section instanceof MemorySection) {
/* 731 */       MemorySection sec = (MemorySection)section;
/*     */       
/* 733 */       for (Map.Entry<String, Object> entry : sec.map.entrySet()) {
/* 734 */         output.put(createPath(section, entry.getKey(), this), entry.getValue());
/*     */         
/* 736 */         if (entry.getValue() instanceof ConfigurationSection && 
/* 737 */           deep) {
/* 738 */           mapChildrenValues(output, (ConfigurationSection)entry.getValue(), deep);
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 743 */       Map<String, Object> values = section.getValues(deep);
/*     */       
/* 745 */       for (Map.Entry<String, Object> entry : values.entrySet()) {
/* 746 */         output.put(createPath(section, entry.getKey(), this), entry.getValue());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String createPath(ConfigurationSection section, String key) {
/* 763 */     return createPath(section, key, (section == null) ? null : section.getRoot());
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
/*     */   public static String createPath(ConfigurationSection section, String key, ConfigurationSection relativeTo) {
/* 779 */     Validate.notNull(section, "Cannot create path without a section");
/* 780 */     Configuration root = section.getRoot();
/* 781 */     if (root == null) {
/* 782 */       throw new IllegalStateException("Cannot create path without a root");
/*     */     }
/* 784 */     char separator = root.options().pathSeparator();
/*     */     
/* 786 */     StringBuilder builder = new StringBuilder();
/* 787 */     if (section != null) {
/* 788 */       for (ConfigurationSection parent = section; parent != null && parent != relativeTo; parent = parent.getParent()) {
/* 789 */         if (builder.length() > 0) {
/* 790 */           builder.insert(0, separator);
/*     */         }
/*     */         
/* 793 */         builder.insert(0, parent.getName());
/*     */       } 
/*     */     }
/*     */     
/* 797 */     if (key != null && key.length() > 0) {
/* 798 */       if (builder.length() > 0) {
/* 799 */         builder.append(separator);
/*     */       }
/*     */       
/* 802 */       builder.append(key);
/*     */     } 
/*     */     
/* 805 */     return builder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 810 */     Configuration root = getRoot();
/* 811 */     return getClass().getSimpleName() + "[path='" + getCurrentPath() + "', root='" + ((root == null) ? null : root.getClass().getSimpleName()) + "']";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\configuration\MemorySection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */