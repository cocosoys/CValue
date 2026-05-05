/*     */ package net.minecraftforge.common.config;
/*     */ 
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import cpw.mods.fml.client.config.GuiConfigEntries;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
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
/*     */ public class ConfigCategory
/*     */   implements Map<String, Property>
/*     */ {
/*     */   private String name;
/*     */   private String comment;
/*     */   private String languagekey;
/*  34 */   private ArrayList<ConfigCategory> children = new ArrayList<ConfigCategory>();
/*  35 */   private Map<String, Property> properties = new TreeMap<String, Property>();
/*  36 */   private int propNumber = 0;
/*     */   public final ConfigCategory parent;
/*     */   private boolean changed = false;
/*     */   private boolean requiresWorldRestart = false;
/*     */   private boolean showInGui = true;
/*     */   private boolean requiresMcRestart = false;
/*  42 */   private Class<? extends GuiConfigEntries.IConfigEntry> customEntryClass = null;
/*  43 */   private List<String> propertyOrder = null;
/*     */ 
/*     */   
/*     */   public ConfigCategory(String name) {
/*  47 */     this(name, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigCategory(String name, ConfigCategory parent) {
/*  52 */     this.name = name;
/*  53 */     this.parent = parent;
/*  54 */     if (parent != null)
/*     */     {
/*  56 */       parent.children.add(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  63 */     if (obj instanceof ConfigCategory) {
/*     */       
/*  65 */       ConfigCategory cat = (ConfigCategory)obj;
/*  66 */       return (this.name.equals(cat.name) && this.children.equals(cat.children));
/*     */     } 
/*     */     
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  74 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/*  79 */     return getQualifiedName(this.name, this.parent);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getQualifiedName(String name, ConfigCategory parent) {
/*  84 */     return (parent == null) ? name : (parent.getQualifiedName() + "." + name);
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigCategory getFirstParent() {
/*  89 */     return (this.parent == null) ? this : this.parent.getFirstParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChild() {
/*  94 */     return (this.parent != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, Property> getValues() {
/*  99 */     return (Map<String, Property>)ImmutableMap.copyOf(this.properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Property> getOrderedValues() {
/* 104 */     if (this.propertyOrder != null) {
/*     */       
/* 106 */       ArrayList<Property> set = new ArrayList<Property>();
/* 107 */       for (String key : this.propertyOrder) {
/* 108 */         if (this.properties.containsKey(key))
/* 109 */           set.add(this.properties.get(key)); 
/*     */       } 
/* 111 */       return (List<Property>)ImmutableList.copyOf(set);
/*     */     } 
/*     */     
/* 114 */     return (List<Property>)ImmutableList.copyOf(this.properties.values());
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigCategory setConfigEntryClass(Class<? extends GuiConfigEntries.IConfigEntry> clazz) {
/* 119 */     this.customEntryClass = clazz;
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<? extends GuiConfigEntries.IConfigEntry> getConfigEntryClass() {
/* 125 */     return this.customEntryClass;
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigCategory setLanguageKey(String languagekey) {
/* 130 */     this.languagekey = languagekey;
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLanguagekey() {
/* 136 */     if (this.languagekey != null) {
/* 137 */       return this.languagekey;
/*     */     }
/* 139 */     return getQualifiedName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setComment(String comment) {
/* 144 */     this.comment = comment;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 149 */     return this.comment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigCategory setRequiresWorldRestart(boolean requiresWorldRestart) {
/* 159 */     this.requiresWorldRestart = requiresWorldRestart;
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresWorldRestart() {
/* 169 */     return this.requiresWorldRestart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigCategory setShowInGui(boolean showInGui) {
/* 178 */     this.showInGui = showInGui;
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean showInGui() {
/* 188 */     return this.showInGui;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigCategory setRequiresMcRestart(boolean requiresMcRestart) {
/* 199 */     this.requiresMcRestart = this.requiresWorldRestart = requiresMcRestart;
/* 200 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresMcRestart() {
/* 209 */     return this.requiresMcRestart;
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigCategory setPropertyOrder(List<String> propertyOrder) {
/* 214 */     this.propertyOrder = propertyOrder;
/* 215 */     for (String s : this.properties.keySet()) {
/* 216 */       if (!propertyOrder.contains(s))
/* 217 */         propertyOrder.add(s); 
/* 218 */     }  return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getPropertyOrder() {
/* 223 */     if (this.propertyOrder != null) {
/* 224 */       return (List<String>)ImmutableList.copyOf(this.propertyOrder);
/*     */     }
/* 226 */     return (List<String>)ImmutableList.copyOf(this.properties.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(String key) {
/* 231 */     return this.properties.containsKey(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public Property get(String key) {
/* 236 */     return this.properties.get(key);
/*     */   }
/*     */ 
/*     */   
/*     */   private void write(BufferedWriter out, String... data) throws IOException {
/* 241 */     write(out, true, data);
/*     */   }
/*     */ 
/*     */   
/*     */   private void write(BufferedWriter out, boolean new_line, String... data) throws IOException {
/* 246 */     for (int x = 0; x < data.length; x++)
/*     */     {
/* 248 */       out.write(data[x]);
/*     */     }
/* 250 */     if (new_line) out.write(Configuration.NEW_LINE);
/*     */   
/*     */   }
/*     */   
/*     */   public void write(BufferedWriter out, int indent) throws IOException {
/* 255 */     String pad0 = getIndent(indent);
/* 256 */     String pad1 = getIndent(indent + 1);
/* 257 */     String pad2 = getIndent(indent + 2);
/*     */     
/* 259 */     if (this.comment != null && !this.comment.isEmpty()) {
/*     */       
/* 261 */       write(out, new String[] { pad0, "##########################################################################################################" });
/* 262 */       write(out, new String[] { pad0, "# ", this.name });
/* 263 */       write(out, new String[] { pad0, "#--------------------------------------------------------------------------------------------------------#" });
/* 264 */       Splitter splitter = Splitter.onPattern("\r?\n");
/*     */       
/* 266 */       for (String line : splitter.split(this.comment)) {
/*     */         
/* 268 */         write(out, new String[] { pad0, "# ", line });
/*     */       } 
/*     */       
/* 271 */       write(out, new String[] { pad0, "##########################################################################################################", Configuration.NEW_LINE });
/*     */     } 
/*     */     
/* 274 */     String displayName = this.name;
/*     */     
/* 276 */     if (!Configuration.allowedProperties.matchesAllOf(this.name))
/*     */     {
/* 278 */       displayName = '"' + this.name + '"';
/*     */     }
/*     */     
/* 281 */     write(out, new String[] { pad0, displayName, " {" });
/*     */     
/* 283 */     Property[] props = getOrderedValues().<Property>toArray(new Property[0]);
/*     */     
/* 285 */     for (int x = 0; x < props.length; x++) {
/*     */       
/* 287 */       Property prop = props[x];
/*     */       
/* 289 */       if (prop.comment != null && !prop.comment.isEmpty()) {
/*     */         
/* 291 */         if (x != 0)
/*     */         {
/* 293 */           out.newLine();
/*     */         }
/*     */         
/* 296 */         Splitter splitter = Splitter.onPattern("\r?\n");
/* 297 */         for (String commentLine : splitter.split(prop.comment)) {
/*     */           
/* 299 */           write(out, new String[] { pad1, "# ", commentLine });
/*     */         } 
/*     */       } 
/*     */       
/* 303 */       String propName = prop.getName();
/*     */       
/* 305 */       if (!Configuration.allowedProperties.matchesAllOf(propName))
/*     */       {
/* 307 */         propName = '"' + propName + '"';
/*     */       }
/*     */       
/* 310 */       if (prop.isList()) {
/*     */         
/* 312 */         char type = prop.getType().getID();
/*     */         
/* 314 */         write(out, new String[] { pad1, String.valueOf(type), ":", propName, " <" });
/*     */         
/* 316 */         for (String line : prop.getStringList()) {
/*     */           
/* 318 */           write(out, new String[] { pad2, line });
/*     */         } 
/*     */         
/* 321 */         write(out, new String[] { pad1, " >" });
/*     */       }
/* 323 */       else if (prop.getType() == null) {
/*     */         
/* 325 */         write(out, new String[] { pad1, propName, "=", prop.getString() });
/*     */       }
/*     */       else {
/*     */         
/* 329 */         char type = prop.getType().getID();
/* 330 */         write(out, new String[] { pad1, String.valueOf(type), ":", propName, "=", prop.getString() });
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     if (this.children.size() > 0) {
/* 335 */       out.newLine();
/*     */     }
/* 337 */     for (ConfigCategory child : this.children)
/*     */     {
/* 339 */       child.write(out, indent + 1);
/*     */     }
/*     */     
/* 342 */     write(out, new String[] { pad0, "}", Configuration.NEW_LINE });
/*     */   }
/*     */ 
/*     */   
/*     */   private String getIndent(int indent) {
/* 347 */     StringBuilder buf = new StringBuilder("");
/* 348 */     for (int x = 0; x < indent; x++)
/*     */     {
/* 350 */       buf.append("    ");
/*     */     }
/* 352 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasChanged() {
/* 357 */     if (this.changed) return true; 
/* 358 */     for (Property prop : this.properties.values()) {
/*     */       
/* 360 */       if (prop.hasChanged()) return true; 
/*     */     } 
/* 362 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void resetChangedState() {
/* 367 */     this.changed = false;
/* 368 */     for (Property prop : this.properties.values())
/*     */     {
/* 370 */       prop.resetChangedState();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 376 */     return this.properties.size(); }
/* 377 */   public boolean isEmpty() { return this.properties.isEmpty(); }
/* 378 */   public boolean containsKey(Object key) { return this.properties.containsKey(key); }
/* 379 */   public boolean containsValue(Object value) { return this.properties.containsValue(value); } public Property get(Object key) {
/* 380 */     return this.properties.get(key);
/*     */   }
/*     */   public Property put(String key, Property value) {
/* 383 */     this.changed = true;
/* 384 */     if (this.propertyOrder != null && !this.propertyOrder.contains(key))
/* 385 */       this.propertyOrder.add(key); 
/* 386 */     return this.properties.put(key, value);
/*     */   }
/*     */   
/*     */   public Property remove(Object key) {
/* 390 */     this.changed = true;
/* 391 */     return this.properties.remove(key);
/*     */   }
/*     */   
/*     */   public void putAll(Map<? extends String, ? extends Property> m) {
/* 395 */     this.changed = true;
/* 396 */     if (this.propertyOrder != null)
/* 397 */       for (String key : m.keySet()) {
/* 398 */         if (!this.propertyOrder.contains(key))
/* 399 */           this.propertyOrder.add(key); 
/* 400 */       }   this.properties.putAll(m);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 404 */     this.changed = true;
/* 405 */     this.properties.clear();
/*     */   }
/* 407 */   public Set<String> keySet() { return this.properties.keySet(); } public Collection<Property> values() {
/* 408 */     return this.properties.values();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<String, Property>> entrySet() {
/* 413 */     return (Set<Map.Entry<String, Property>>)ImmutableSet.copyOf(this.properties.entrySet());
/*     */   }
/*     */   public Set<ConfigCategory> getChildren() {
/* 416 */     return (Set<ConfigCategory>)ImmutableSet.copyOf(this.children);
/*     */   }
/*     */   
/*     */   public void removeChild(ConfigCategory child) {
/* 420 */     if (this.children.contains(child)) {
/*     */       
/* 422 */       this.children.remove(child);
/* 423 */       this.changed = true;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\config\ConfigCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */