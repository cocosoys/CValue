/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.client.resources.I18n;
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
/*     */ 
/*     */ 
/*     */ public class DummyConfigElement<T>
/*     */   implements IConfigElement<T>
/*     */ {
/*     */   protected boolean isProperty = true;
/*     */   protected boolean isList = false;
/*     */   protected ConfigGuiType type;
/*     */   protected String name;
/*     */   protected String langKey;
/*     */   protected Object value;
/*     */   protected Object defaultValue;
/*     */   protected T[] values;
/*     */   protected T[] defaultValues;
/*     */   protected String[] validValues;
/*     */   protected Pattern validStringPattern;
/*     */   protected T minValue;
/*     */   protected T maxValue;
/*     */   protected boolean requiresWorldRestart = false;
/*     */   protected boolean requiresMcRestart = false;
/*     */   protected boolean isListFixedLength = false;
/*  51 */   protected int maxListLength = -1;
/*     */ 
/*     */   
/*     */   protected List<IConfigElement> childElements;
/*     */ 
/*     */   
/*     */   protected Class<? extends GuiConfigEntries.IConfigEntry> configEntryClass;
/*     */ 
/*     */   
/*     */   protected Class<? extends GuiEditArrayEntries.IArrayEntry> arrayEntryClass;
/*     */ 
/*     */   
/*     */   public static class DummyCategoryElement<T>
/*     */     extends DummyConfigElement<T>
/*     */   {
/*     */     public DummyCategoryElement(String name, String langKey, List<IConfigElement> childElements) {
/*  67 */       this(name, langKey, childElements, (Class<? extends GuiConfigEntries.IConfigEntry>)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public DummyCategoryElement(String name, String langKey, Class<? extends GuiConfigEntries.IConfigEntry> customListEntryClass) {
/*  73 */       this(name, langKey, new ArrayList<IConfigElement>(), customListEntryClass);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public DummyCategoryElement(String name, String langKey, List<IConfigElement> childElements, Class<? extends GuiConfigEntries.IConfigEntry> customListEntryClass) {
/*  79 */       super(name, null, ConfigGuiType.CONFIG_CATEGORY, langKey);
/*  80 */       this.childElements = childElements;
/*  81 */       this.configEntryClass = customListEntryClass;
/*  82 */       this.isProperty = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DummyListElement<T>
/*     */     extends DummyConfigElement<T>
/*     */   {
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, boolean isListFixedLength, int maxListLength, Pattern validStringPattern, T minValue, T maxValue) {
/*  93 */       super(name, null, type, langKey, minValue, maxValue);
/*  94 */       this.defaultValues = defaultValues;
/*  95 */       this.values = defaultValues;
/*  96 */       this.isListFixedLength = isListFixedLength;
/*  97 */       this.maxListLength = maxListLength;
/*  98 */       this.validStringPattern = validStringPattern;
/*  99 */       this.isList = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey) {
/* 104 */       this(name, defaultValues, type, langKey, false, -1, (Pattern)null, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, boolean isListFixedLength) {
/* 109 */       this(name, defaultValues, type, langKey, isListFixedLength, -1, (Pattern)null, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, int maxListLength) {
/* 114 */       this(name, defaultValues, type, langKey, false, maxListLength, (Pattern)null, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, T minValue, T maxValue) {
/* 119 */       this(name, defaultValues, type, langKey, false, -1, (Pattern)null, minValue, maxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, boolean isListFixedLength, T minValue, T maxValue) {
/* 124 */       this(name, defaultValues, type, langKey, isListFixedLength, -1, (Pattern)null, minValue, maxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, int maxListLength, T minValue, T maxValue) {
/* 129 */       this(name, defaultValues, type, langKey, false, maxListLength, (Pattern)null, minValue, maxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, boolean isListFixedLength, int maxListLength, T minValue, T maxValue) {
/* 134 */       this(name, defaultValues, type, langKey, isListFixedLength, maxListLength, (Pattern)null, minValue, maxValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, Pattern validStringPattern) {
/* 139 */       this(name, defaultValues, type, langKey, false, -1, validStringPattern, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, boolean isListFixedLength, Pattern validStringPattern) {
/* 144 */       this(name, defaultValues, type, langKey, isListFixedLength, -1, validStringPattern, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */     
/*     */     public DummyListElement(String name, T[] defaultValues, ConfigGuiType type, String langKey, int maxListLength, Pattern validStringPattern) {
/* 149 */       this(name, defaultValues, type, langKey, false, maxListLength, validStringPattern, (T)null, (T)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public DummyListElement setCustomEditListEntryClass(Class<? extends GuiEditArrayEntries.IArrayEntry> clazz) {
/* 155 */       this.arrayEntryClass = clazz;
/* 156 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getDefault() {
/* 162 */       return Arrays.toString((Object[])this.defaultValues);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DummyConfigElement(String name, T defaultValue, ConfigGuiType type, String langKey, String[] validValues, Pattern validStringPattern, T minValue, T maxValue) {
/* 169 */     this.name = name;
/* 170 */     this.defaultValue = defaultValue;
/* 171 */     this.value = defaultValue;
/* 172 */     this.type = type;
/* 173 */     this.langKey = langKey;
/* 174 */     this.validValues = validValues;
/* 175 */     this.validStringPattern = validStringPattern;
/* 176 */     if (minValue == null) {
/*     */       
/* 178 */       if (type == ConfigGuiType.INTEGER) {
/* 179 */         this.minValue = (T)Integer.valueOf(-2147483648);
/* 180 */       } else if (type == ConfigGuiType.DOUBLE) {
/* 181 */         this.minValue = (T)Double.valueOf(-1.7976931348623157E308D);
/*     */       } 
/*     */     } else {
/* 184 */       this.minValue = minValue;
/* 185 */     }  if (maxValue == null) {
/*     */       
/* 187 */       if (type == ConfigGuiType.INTEGER) {
/* 188 */         this.maxValue = (T)Integer.valueOf(2147483647);
/* 189 */       } else if (type == ConfigGuiType.DOUBLE) {
/* 190 */         this.maxValue = (T)Double.valueOf(Double.MAX_VALUE);
/*     */       } 
/*     */     } else {
/* 193 */       this.maxValue = maxValue;
/*     */     } 
/*     */   }
/*     */   
/*     */   public DummyConfigElement(String name, T defaultValue, ConfigGuiType type, String langKey, Pattern validStringPattern) {
/* 198 */     this(name, defaultValue, type, langKey, (String[])null, validStringPattern, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DummyConfigElement(String name, T defaultValue, ConfigGuiType type, String langKey, String[] validValues) {
/* 203 */     this(name, defaultValue, type, langKey, validValues, (Pattern)null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DummyConfigElement(String name, T defaultValue, ConfigGuiType type, String langKey) {
/* 208 */     this(name, defaultValue, type, langKey, (String[])null, (Pattern)null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public DummyConfigElement(String name, T defaultValue, ConfigGuiType type, String langKey, T minValue, T maxValue) {
/* 213 */     this(name, defaultValue, type, langKey, (String[])null, (Pattern)null, minValue, maxValue);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DummyConfigElement setCustomListEntryClass(Class<? extends GuiConfigEntries.IConfigEntry> clazz) {
/* 219 */     this.configEntryClass = clazz;
/* 220 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isProperty() {
/* 226 */     return this.isProperty;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IConfigElement setConfigEntryClass(Class<? extends GuiConfigEntries.IConfigEntry> clazz) {
/* 232 */     this.configEntryClass = clazz;
/* 233 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends GuiConfigEntries.IConfigEntry> getConfigEntryClass() {
/* 240 */     return this.configEntryClass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IConfigElement setArrayEntryClass(Class<? extends GuiEditArrayEntries.IArrayEntry> clazz) {
/* 246 */     this.arrayEntryClass = clazz;
/* 247 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends GuiEditArrayEntries.IArrayEntry> getArrayEntryClass() {
/* 253 */     return this.arrayEntryClass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 259 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQualifiedName() {
/* 265 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLanguageKey() {
/* 271 */     return this.langKey;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 277 */     return I18n.format(this.langKey + ".tooltip", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IConfigElement> getChildElements() {
/* 284 */     return this.childElements;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ConfigGuiType getType() {
/* 290 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isList() {
/* 296 */     return this.isList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isListLengthFixed() {
/* 302 */     return this.isListFixedLength;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxListLength() {
/* 308 */     return this.maxListLength;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/* 314 */     if (this.isProperty) {
/*     */       
/* 316 */       if (!this.isList) {
/*     */         
/* 318 */         if (this.value != null) {
/* 319 */           return this.value.equals(this.defaultValue);
/*     */         }
/* 321 */         return (this.defaultValue == null);
/*     */       } 
/*     */ 
/*     */       
/* 325 */       return Arrays.deepEquals((Object[])this.values, (Object[])this.defaultValues);
/*     */     } 
/*     */ 
/*     */     
/* 329 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getDefault() {
/* 335 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] getDefaults() {
/* 341 */     return this.defaultValues;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setToDefault() {
/* 347 */     if (this.isList) {
/* 348 */       this.values = Arrays.copyOf(this.defaultValues, this.defaultValues.length);
/*     */     } else {
/* 350 */       this.value = this.defaultValue;
/*     */     } 
/*     */   }
/*     */   
/*     */   public IConfigElement<T> setRequiresWorldRestart(boolean requiresWorldRestart) {
/* 355 */     this.requiresWorldRestart = requiresWorldRestart;
/* 356 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresWorldRestart() {
/* 362 */     return this.requiresWorldRestart;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean showInGui() {
/* 368 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public IConfigElement<T> setRequiresMcRestart(boolean requiresMcRestart) {
/* 373 */     this.requiresMcRestart = this.requiresWorldRestart = requiresMcRestart;
/* 374 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean requiresMcRestart() {
/* 380 */     return this.requiresMcRestart;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getValidValues() {
/* 386 */     return this.validValues;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pattern getValidationPattern() {
/* 392 */     return this.validStringPattern;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get() {
/* 398 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T[] getList() {
/* 404 */     return this.values;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T value) {
/* 410 */     this.defaultValue = value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(T[] aVal) {
/* 416 */     this.defaultValues = aVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMinValue() {
/* 422 */     return this.minValue;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getMaxValue() {
/* 428 */     return this.maxValue;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\DummyConfigElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */