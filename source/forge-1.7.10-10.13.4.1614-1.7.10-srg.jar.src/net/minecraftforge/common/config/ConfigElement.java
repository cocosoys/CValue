/*     */ package net.minecraftforge.common.config;
/*     */ 
/*     */ import cpw.mods.fml.client.config.ConfigGuiType;
/*     */ import cpw.mods.fml.client.config.GuiConfigEntries;
/*     */ import cpw.mods.fml.client.config.GuiEditArrayEntries;
/*     */ import cpw.mods.fml.client.config.IConfigElement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class ConfigElement<T>
/*     */   implements IConfigElement<T>
/*     */ {
/*     */   private Property prop;
/*     */   private Property.Type type;
/*     */   private boolean isProperty;
/*     */   private ConfigCategory ctgy;
/*     */   private boolean categoriesFirst = true;
/*     */   
/*     */   public ConfigElement(ConfigCategory ctgy) {
/*  32 */     this.ctgy = ctgy;
/*  33 */     this.isProperty = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigElement(Property prop) {
/*  38 */     this.prop = prop;
/*  39 */     this.type = prop.getType();
/*  40 */     this.isProperty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ConfigElement<T> listCategoriesFirst(boolean categoriesFirst) {
/*  45 */     this.categoriesFirst = categoriesFirst;
/*  46 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IConfigElement> getChildElements() {
/*  52 */     if (!this.isProperty) {
/*     */       
/*  54 */       List<IConfigElement> elements = new ArrayList<IConfigElement>();
/*  55 */       Iterator<ConfigCategory> ccI = this.ctgy.getChildren().iterator();
/*  56 */       Iterator<Property> pI = this.ctgy.getOrderedValues().iterator();
/*  57 */       int index = 0;
/*     */       
/*  59 */       if (this.categoriesFirst)
/*  60 */         while (ccI.hasNext()) {
/*     */           
/*  62 */           ConfigElement temp = new ConfigElement(ccI.next());
/*  63 */           if (temp.showInGui()) {
/*  64 */             elements.add(temp);
/*     */           }
/*     */         }  
/*  67 */       while (pI.hasNext()) {
/*     */         
/*  69 */         ConfigElement<?> temp = getTypedElement(pI.next());
/*  70 */         if (temp.showInGui()) {
/*  71 */           elements.add(temp);
/*     */         }
/*     */       } 
/*  74 */       if (!this.categoriesFirst)
/*  75 */         while (ccI.hasNext()) {
/*     */           
/*  77 */           ConfigElement temp = new ConfigElement(ccI.next());
/*  78 */           if (temp.showInGui()) {
/*  79 */             elements.add(temp);
/*     */           }
/*     */         }  
/*  82 */       return elements;
/*     */     } 
/*  84 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ConfigElement<?> getTypedElement(Property prop) {
/*  89 */     switch (getType(prop)) {
/*     */       
/*     */       case BOOLEAN:
/*  92 */         return new ConfigElement(prop);
/*     */       case DOUBLE:
/*  94 */         return new ConfigElement(prop);
/*     */       case INTEGER:
/*  96 */         return new ConfigElement(prop);
/*     */     } 
/*  98 */     return new ConfigElement(prop);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 105 */     return this.isProperty ? this.prop.getName() : this.ctgy.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isProperty() {
/* 111 */     return this.isProperty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends GuiConfigEntries.IConfigEntry> getConfigEntryClass() {
/* 117 */     return this.isProperty ? this.prop.getConfigEntryClass() : this.ctgy.getConfigEntryClass();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends GuiEditArrayEntries.IArrayEntry> getArrayEntryClass() {
/* 123 */     return this.isProperty ? this.prop.getArrayEntryClass() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/* 129 */     return this.isProperty ? this.prop.getName() : this.ctgy.getQualifiedName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigGuiType getType() {
/* 135 */     return this.isProperty ? getType(this.prop) : ConfigGuiType.CONFIG_CATEGORY;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ConfigGuiType getType(Property prop) {
/* 140 */     return (prop.getType() == Property.Type.BOOLEAN) ? ConfigGuiType.BOOLEAN : ((prop.getType() == Property.Type.DOUBLE) ? ConfigGuiType.DOUBLE : (
/* 141 */       (prop.getType() == Property.Type.INTEGER) ? ConfigGuiType.INTEGER : ((prop.getType() == Property.Type.COLOR) ? ConfigGuiType.COLOR : (
/* 142 */       (prop.getType() == Property.Type.MOD_ID) ? ConfigGuiType.MOD_ID : ConfigGuiType.STRING))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isList() {
/* 148 */     return (this.isProperty && this.prop.isList());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isListLengthFixed() {
/* 154 */     return (this.isProperty && this.prop.isListLengthFixed());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxListLength() {
/* 160 */     return this.isProperty ? this.prop.getMaxListLength() : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 166 */     return this.isProperty ? this.prop.comment : this.ctgy.getComment();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/* 172 */     return (!this.isProperty || this.prop.isDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToDefault() {
/* 178 */     if (this.isProperty) {
/* 179 */       this.prop.setToDefault();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean requiresWorldRestart() {
/* 185 */     return this.isProperty ? this.prop.requiresWorldRestart() : this.ctgy.requiresWorldRestart();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean showInGui() {
/* 191 */     return this.isProperty ? this.prop.showInGui() : this.ctgy.showInGui();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresMcRestart() {
/* 197 */     return this.isProperty ? this.prop.requiresMcRestart() : this.ctgy.requiresMcRestart();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getValidValues() {
/* 203 */     return this.isProperty ? this.prop.getValidValues() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLanguageKey() {
/* 209 */     return this.isProperty ? this.prop.getLanguageKey() : this.ctgy.getLanguagekey();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDefault() {
/* 215 */     return this.isProperty ? this.prop.getDefault() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getDefaults() {
/* 221 */     if (this.isProperty) {
/*     */       
/* 223 */       String[] aVal = this.prop.getDefaults();
/* 224 */       if (this.type == Property.Type.BOOLEAN) {
/*     */         
/* 226 */         Boolean[] ba = new Boolean[aVal.length];
/* 227 */         for (int i = 0; i < aVal.length; i++)
/* 228 */           ba[i] = Boolean.valueOf(aVal[i]); 
/* 229 */         return (Object[])ba;
/*     */       } 
/* 231 */       if (this.type == Property.Type.DOUBLE) {
/*     */         
/* 233 */         Double[] da = new Double[aVal.length];
/* 234 */         for (int i = 0; i < aVal.length; i++)
/* 235 */           da[i] = Double.valueOf(aVal[i].toString()); 
/* 236 */         return (Object[])da;
/*     */       } 
/* 238 */       if (this.type == Property.Type.INTEGER) {
/*     */         
/* 240 */         Integer[] ia = new Integer[aVal.length];
/* 241 */         for (int i = 0; i < aVal.length; i++)
/* 242 */           ia[i] = Integer.valueOf(aVal[i].toString()); 
/* 243 */         return (Object[])ia;
/*     */       } 
/*     */       
/* 246 */       return (Object[])aVal;
/*     */     } 
/* 248 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pattern getValidationPattern() {
/* 254 */     return this.isProperty ? this.prop.getValidationPattern() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get() {
/* 260 */     return this.isProperty ? this.prop.getString() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getList() {
/* 266 */     if (this.isProperty) {
/*     */       
/* 268 */       String[] aVal = this.prop.getStringList();
/* 269 */       if (this.type == Property.Type.BOOLEAN) {
/*     */         
/* 271 */         Boolean[] ba = new Boolean[aVal.length];
/* 272 */         for (int i = 0; i < aVal.length; i++)
/* 273 */           ba[i] = Boolean.valueOf(aVal[i]); 
/* 274 */         return (Object[])ba;
/*     */       } 
/* 276 */       if (this.type == Property.Type.DOUBLE) {
/*     */         
/* 278 */         Double[] da = new Double[aVal.length];
/* 279 */         for (int i = 0; i < aVal.length; i++)
/* 280 */           da[i] = Double.valueOf(aVal[i].toString()); 
/* 281 */         return (Object[])da;
/*     */       } 
/* 283 */       if (this.type == Property.Type.INTEGER) {
/*     */         
/* 285 */         Integer[] ia = new Integer[aVal.length];
/* 286 */         for (int i = 0; i < aVal.length; i++)
/* 287 */           ia[i] = Integer.valueOf(aVal[i].toString()); 
/* 288 */         return (Object[])ia;
/*     */       } 
/*     */       
/* 291 */       return (Object[])aVal;
/*     */     } 
/* 293 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T value) {
/* 299 */     if (this.isProperty)
/*     */     {
/* 301 */       if (this.type == Property.Type.BOOLEAN) {
/* 302 */         this.prop.set(Boolean.parseBoolean(value.toString()));
/* 303 */       } else if (this.type == Property.Type.DOUBLE) {
/* 304 */         this.prop.set(Double.parseDouble(value.toString()));
/* 305 */       } else if (this.type == Property.Type.INTEGER) {
/* 306 */         this.prop.set(Integer.parseInt(value.toString()));
/*     */       } else {
/* 308 */         this.prop.set(value.toString());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T[] aVal) {
/* 315 */     if (this.isProperty)
/*     */     {
/* 317 */       if (this.type == Property.Type.BOOLEAN) {
/*     */         
/* 319 */         boolean[] ba = new boolean[aVal.length];
/* 320 */         for (int i = 0; i < aVal.length; i++)
/* 321 */           ba[i] = Boolean.valueOf(aVal[i].toString()).booleanValue(); 
/* 322 */         this.prop.set(ba);
/*     */       }
/* 324 */       else if (this.type == Property.Type.DOUBLE) {
/*     */         
/* 326 */         double[] da = new double[aVal.length];
/* 327 */         for (int i = 0; i < aVal.length; i++)
/* 328 */           da[i] = Double.valueOf(aVal[i].toString()).doubleValue(); 
/* 329 */         this.prop.set(da);
/*     */       }
/* 331 */       else if (this.type == Property.Type.INTEGER) {
/*     */         
/* 333 */         int[] ia = new int[aVal.length];
/* 334 */         for (int i = 0; i < aVal.length; i++)
/* 335 */           ia[i] = Integer.valueOf(aVal[i].toString()).intValue(); 
/* 336 */         this.prop.set(ia);
/*     */       }
/*     */       else {
/*     */         
/* 340 */         String[] is = new String[aVal.length];
/* 341 */         for (int i = 0; i < aVal.length; i++)
/* 342 */           is[i] = aVal[i].toString(); 
/* 343 */         this.prop.set(is);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinValue() {
/* 351 */     return this.isProperty ? (T)this.prop.getMinValue() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMaxValue() {
/* 357 */     return this.isProperty ? (T)this.prop.getMaxValue() : null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\config\ConfigElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */