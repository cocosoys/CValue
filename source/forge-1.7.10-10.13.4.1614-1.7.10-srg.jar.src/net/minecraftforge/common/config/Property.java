/*      */ package net.minecraftforge.common.config;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ public class Property {
/*      */   private String name;
/*      */   private String value;
/*      */   private String defaultValue;
/*      */   public String comment;
/*      */   private String[] values;
/*      */   private String[] defaultValues;
/*      */   private String[] validValues;
/*      */   private String langKey;
/*      */   private String minValue;
/*      */   private String maxValue;
/*      */   
/*      */   public enum Type {
/*   19 */     STRING,
/*   20 */     INTEGER,
/*   21 */     BOOLEAN,
/*   22 */     DOUBLE,
/*   23 */     COLOR,
/*   24 */     MOD_ID;
/*      */ 
/*      */     
/*      */     public static Type tryParse(char id) {
/*   28 */       for (int x = 0; x < (values()).length; x++) {
/*      */         
/*   30 */         if (values()[x].getID() == id)
/*      */         {
/*   32 */           return values()[x];
/*      */         }
/*      */       } 
/*      */       
/*   36 */       return STRING;
/*      */     }
/*      */ 
/*      */     
/*      */     public char getID() {
/*   41 */       return name().charAt(0);
/*      */     }
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
/*   56 */   private Class<? extends GuiConfigEntries.IConfigEntry> configEntryClass = null;
/*   57 */   private Class<? extends GuiEditArrayEntries.IArrayEntry> arrayEntryClass = null;
/*      */   
/*      */   private boolean requiresWorldRestart = false;
/*      */   private boolean showInGui = true;
/*      */   private boolean requiresMcRestart = false;
/*      */   private Pattern validationPattern;
/*      */   private final boolean wasRead;
/*      */   private final boolean isList;
/*      */   private boolean isListLengthFixed = false;
/*   66 */   private int maxListLength = -1;
/*      */   
/*      */   private final Type type;
/*      */   private boolean changed = false;
/*      */   
/*      */   public Property(String name, String value, Type type) {
/*   72 */     this(name, value, type, false, new String[0], name);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String value, Type type, boolean read) {
/*   77 */     this(name, value, type, read, new String[0], name);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String value, Type type, String[] validValues) {
/*   82 */     this(name, value, type, false, validValues, name);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String value, Type type, String langKey) {
/*   87 */     this(name, value, type, false, new String[0], langKey);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String value, Type type, boolean read, String langKey) {
/*   92 */     this(name, value, type, read, new String[0], langKey);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String value, Type type, String[] validValues, String langKey) {
/*   97 */     this(name, value, type, false, validValues, langKey);
/*      */   }
/*      */ 
/*      */   
/*      */   Property(String name, String value, Type type, boolean read, String[] validValues, String langKey) {
/*  102 */     setName(name);
/*  103 */     this.value = value;
/*  104 */     this.values = new String[0];
/*  105 */     this.type = type;
/*  106 */     this.wasRead = read;
/*  107 */     this.isList = false;
/*  108 */     this.defaultValue = value;
/*  109 */     this.defaultValues = new String[0];
/*  110 */     this.validValues = validValues;
/*  111 */     this.isListLengthFixed = false;
/*  112 */     this.maxListLength = -1;
/*  113 */     this.minValue = String.valueOf(-2147483648);
/*  114 */     this.maxValue = String.valueOf(2147483647);
/*  115 */     this.langKey = langKey;
/*  116 */     this.comment = "";
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String[] values, Type type) {
/*  121 */     this(name, values, type, false);
/*      */   }
/*      */ 
/*      */   
/*      */   Property(String name, String[] values, Type type, boolean read) {
/*  126 */     this(name, values, type, read, new String[0], name);
/*      */   }
/*      */ 
/*      */   
/*      */   public Property(String name, String[] values, Type type, String langKey) {
/*  131 */     this(name, values, type, false, langKey);
/*      */   }
/*      */ 
/*      */   
/*      */   Property(String name, String[] values, Type type, boolean read, String langKey) {
/*  136 */     this(name, values, type, read, new String[0], langKey);
/*      */   }
/*      */ 
/*      */   
/*      */   Property(String name, String[] values, Type type, boolean read, String[] validValues, String langKey) {
/*  141 */     setName(name);
/*  142 */     this.type = type;
/*  143 */     this.values = Arrays.<String>copyOf(values, values.length);
/*  144 */     this.wasRead = read;
/*  145 */     this.isList = true;
/*  146 */     this.value = "";
/*  147 */     this.defaultValue = "";
/*  148 */     for (String s : values)
/*  149 */       this.defaultValue += ", [" + s + "]"; 
/*  150 */     this.defaultValue = this.defaultValue.replaceFirst(", ", "");
/*  151 */     this.defaultValues = Arrays.<String>copyOf(values, values.length);
/*  152 */     this.validValues = validValues;
/*  153 */     this.isListLengthFixed = false;
/*  154 */     this.maxListLength = -1;
/*  155 */     this.minValue = String.valueOf(-2147483648);
/*  156 */     this.maxValue = String.valueOf(2147483647);
/*  157 */     this.langKey = langKey;
/*  158 */     this.comment = "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDefault() {
/*  168 */     if (isBooleanList()) {
/*      */       
/*  170 */       if (this.values.length == this.defaultValues.length) {
/*      */         
/*  172 */         for (int i = 0; i < this.values.length; i++) {
/*  173 */           if (Boolean.parseBoolean(this.values[i]) != Boolean.parseBoolean(this.defaultValues[i]))
/*  174 */             return false; 
/*      */         } 
/*  176 */         return true;
/*      */       } 
/*      */       
/*  179 */       return false;
/*      */     } 
/*      */     
/*  182 */     if (isIntList()) {
/*      */       
/*  184 */       if (this.values.length == this.defaultValues.length) {
/*      */         
/*  186 */         for (int i = 0; i < this.values.length; i++) {
/*  187 */           if (Integer.parseInt(this.values[i]) != Integer.parseInt(this.defaultValues[i]))
/*  188 */             return false; 
/*      */         } 
/*  190 */         return true;
/*      */       } 
/*      */       
/*  193 */       return false;
/*      */     } 
/*      */     
/*  196 */     if (isDoubleList()) {
/*      */       
/*  198 */       if (this.values.length == this.defaultValues.length) {
/*      */         
/*  200 */         for (int i = 0; i < this.values.length; i++) {
/*  201 */           if (Double.parseDouble(this.values[i]) != Double.parseDouble(this.defaultValues[i]))
/*  202 */             return false; 
/*      */         } 
/*  204 */         return true;
/*      */       } 
/*      */       
/*  207 */       return false;
/*      */     } 
/*      */     
/*  210 */     if (isList()) {
/*      */       
/*  212 */       if (this.values.length == this.defaultValues.length) {
/*      */         
/*  214 */         for (int i = 0; i < this.values.length; i++) {
/*  215 */           if (!this.values[i].equals(this.defaultValues[i]))
/*  216 */             return false; 
/*      */         } 
/*  218 */         return true;
/*      */       } 
/*      */       
/*  221 */       return false;
/*      */     } 
/*      */     
/*  224 */     if (this.type == Type.BOOLEAN && isBooleanValue()) {
/*  225 */       return (Boolean.parseBoolean(this.value) == Boolean.parseBoolean(this.defaultValue));
/*      */     }
/*  227 */     if (this.type == Type.INTEGER && isIntValue()) {
/*  228 */       return (Integer.parseInt(this.value) == Integer.parseInt(this.defaultValue));
/*      */     }
/*  230 */     if (this.type == Type.DOUBLE && isDoubleValue()) {
/*  231 */       return (Double.parseDouble(this.value) == Double.parseDouble(this.defaultValue));
/*      */     }
/*  233 */     return this.value.equals(this.defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setToDefault() {
/*  241 */     this.value = this.defaultValue;
/*  242 */     this.values = Arrays.<String>copyOf(this.defaultValues, this.defaultValues.length);
/*  243 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefault() {
/*  253 */     return this.defaultValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getDefaults() {
/*  263 */     return Arrays.<String>copyOf(this.defaultValues, this.defaultValues.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setRequiresWorldRestart(boolean requiresWorldRestart) {
/*  274 */     this.requiresWorldRestart = requiresWorldRestart;
/*  275 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean requiresWorldRestart() {
/*  285 */     return this.requiresWorldRestart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setShowInGui(boolean showInGui) {
/*  294 */     this.showInGui = showInGui;
/*  295 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean showInGui() {
/*  304 */     return this.showInGui;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setRequiresMcRestart(boolean requiresMcRestart) {
/*  314 */     this.requiresMcRestart = this.requiresWorldRestart = requiresMcRestart;
/*  315 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean requiresMcRestart() {
/*  324 */     return this.requiresMcRestart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setMaxListLength(int max) {
/*  334 */     this.maxListLength = max;
/*  335 */     if (this.maxListLength != -1) {
/*      */       
/*  337 */       if (this.values != null && this.values.length != this.maxListLength && (
/*  338 */         this.isListLengthFixed || this.values.length > this.maxListLength)) {
/*  339 */         this.values = Arrays.<String>copyOf(this.values, this.maxListLength);
/*      */       }
/*  341 */       if (this.defaultValues != null && this.defaultValues.length != this.maxListLength && (
/*  342 */         this.isListLengthFixed || this.defaultValues.length > this.maxListLength))
/*  343 */         this.defaultValues = Arrays.<String>copyOf(this.defaultValues, this.maxListLength); 
/*      */     } 
/*  345 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxListLength() {
/*  353 */     return this.maxListLength;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setIsListLengthFixed(boolean isListLengthFixed) {
/*  362 */     this.isListLengthFixed = isListLengthFixed;
/*  363 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isListLengthFixed() {
/*  371 */     return this.isListLengthFixed;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setConfigEntryClass(Class<? extends GuiConfigEntries.IConfigEntry> clazz) {
/*  382 */     this.configEntryClass = clazz;
/*  383 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<? extends GuiConfigEntries.IConfigEntry> getConfigEntryClass() {
/*  394 */     return this.configEntryClass;
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
/*      */   public Property setArrayEntryClass(Class<? extends GuiEditArrayEntries.IArrayEntry> clazz) {
/*  407 */     this.arrayEntryClass = clazz;
/*  408 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Class<? extends GuiEditArrayEntries.IArrayEntry> getArrayEntryClass() {
/*  419 */     return this.arrayEntryClass;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValidationPattern(Pattern validationPattern) {
/*  429 */     this.validationPattern = validationPattern;
/*  430 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Pattern getValidationPattern() {
/*  440 */     return this.validationPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setLanguageKey(String langKey) {
/*  451 */     this.langKey = langKey;
/*  452 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLanguageKey() {
/*  462 */     return this.langKey;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValue(String defaultValue) {
/*  472 */     this.defaultValue = defaultValue;
/*  473 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValues(String[] defaultValues) {
/*  483 */     this.defaultValue = "";
/*  484 */     for (String s : defaultValues)
/*  485 */       this.defaultValue += ", [" + s + "]"; 
/*  486 */     this.defaultValue = this.defaultValue.replaceFirst(", ", "");
/*  487 */     this.defaultValues = Arrays.<String>copyOf(defaultValues, defaultValues.length);
/*  488 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValue(int defaultValue) {
/*  498 */     setDefaultValue(Integer.toString(defaultValue));
/*  499 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValues(int[] defaultValues) {
/*  509 */     String[] temp = new String[defaultValues.length];
/*  510 */     for (int i = 0; i < defaultValues.length; i++) {
/*  511 */       temp[i] = Integer.toString(defaultValues[i]);
/*      */     }
/*  513 */     setDefaultValues(temp);
/*  514 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValue(double defaultValue) {
/*  524 */     setDefaultValue(Double.toString(defaultValue));
/*  525 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValues(double[] defaultValues) {
/*  535 */     String[] temp = new String[defaultValues.length];
/*  536 */     for (int i = 0; i < defaultValues.length; i++) {
/*  537 */       temp[i] = Double.toString(defaultValues[i]);
/*      */     }
/*  539 */     setDefaultValues(temp);
/*  540 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValue(boolean defaultValue) {
/*  550 */     setDefaultValue(Boolean.toString(defaultValue));
/*  551 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setDefaultValues(boolean[] defaultValues) {
/*  561 */     String[] temp = new String[defaultValues.length];
/*  562 */     for (int i = 0; i < defaultValues.length; i++) {
/*  563 */       temp[i] = Boolean.toString(defaultValues[i]);
/*      */     }
/*  565 */     setDefaultValues(temp);
/*  566 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setMinValue(int minValue) {
/*  576 */     this.minValue = Integer.toString(minValue);
/*  577 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setMaxValue(int maxValue) {
/*  587 */     this.maxValue = Integer.toString(maxValue);
/*  588 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setMinValue(double minValue) {
/*  598 */     this.minValue = Double.toString(minValue);
/*  599 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setMaxValue(double maxValue) {
/*  609 */     this.maxValue = Double.toString(maxValue);
/*  610 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMinValue() {
/*  620 */     return this.minValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getMaxValue() {
/*  630 */     return this.maxValue;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString() {
/*  640 */     return this.value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValidValues(String[] validValues) {
/*  651 */     this.validValues = validValues;
/*  652 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getValidValues() {
/*  662 */     return this.validValues;
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
/*      */   public int getInt() {
/*      */     try {
/*  675 */       return Integer.parseInt(this.value);
/*      */     }
/*  677 */     catch (NumberFormatException e) {
/*      */       
/*  679 */       return Integer.parseInt(this.defaultValue);
/*      */     } 
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
/*      */   public int getInt(int _default) {
/*      */     try {
/*  695 */       return Integer.parseInt(this.value);
/*      */     }
/*  697 */     catch (NumberFormatException e) {
/*      */       
/*  699 */       return _default;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIntValue() {
/*      */     try {
/*  711 */       Integer.parseInt(this.value);
/*  712 */       return true;
/*      */     }
/*  714 */     catch (NumberFormatException e) {
/*      */       
/*  716 */       return false;
/*      */     } 
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
/*      */   public boolean getBoolean(boolean _default) {
/*  730 */     if (isBooleanValue())
/*      */     {
/*  732 */       return Boolean.parseBoolean(this.value);
/*      */     }
/*      */ 
/*      */     
/*  736 */     return _default;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getBoolean() {
/*  747 */     if (isBooleanValue())
/*      */     {
/*  749 */       return Boolean.parseBoolean(this.value);
/*      */     }
/*      */ 
/*      */     
/*  753 */     return Boolean.parseBoolean(this.defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBooleanValue() {
/*  764 */     return ("true".equals(this.value.toLowerCase()) || "false".equals(this.value.toLowerCase()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleValue() {
/*      */     try {
/*  775 */       Double.parseDouble(this.value);
/*  776 */       return true;
/*      */     }
/*  778 */     catch (NumberFormatException e) {
/*      */       
/*  780 */       return false;
/*      */     } 
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
/*      */   public double getDouble(double _default) {
/*      */     try {
/*  796 */       return Double.parseDouble(this.value);
/*      */     }
/*  798 */     catch (NumberFormatException e) {
/*      */       
/*  800 */       return _default;
/*      */     } 
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
/*      */   public double getDouble() {
/*      */     try {
/*  814 */       return Double.parseDouble(this.value);
/*      */     }
/*  816 */     catch (NumberFormatException e) {
/*      */       
/*  818 */       return Double.parseDouble(this.defaultValue);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] getStringList() {
/*  824 */     return this.values;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getIntList() {
/*  835 */     ArrayList<Integer> nums = new ArrayList<Integer>();
/*      */     
/*  837 */     for (String value : this.values) {
/*      */ 
/*      */       
/*      */       try {
/*  841 */         nums.add(Integer.valueOf(Integer.parseInt(value)));
/*      */       }
/*  843 */       catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */     
/*  846 */     int[] primitives = new int[nums.size()];
/*      */     
/*  848 */     for (int i = 0; i < nums.size(); i++)
/*      */     {
/*  850 */       primitives[i] = ((Integer)nums.get(i)).intValue();
/*      */     }
/*      */     
/*  853 */     return primitives;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isIntList() {
/*  862 */     if (this.isList && this.type == Type.INTEGER)
/*  863 */       for (String value : this.values) {
/*      */ 
/*      */         
/*      */         try {
/*  867 */           Integer.parseInt(value);
/*      */         }
/*  869 */         catch (NumberFormatException e) {
/*      */           
/*  871 */           return false;
/*      */         } 
/*      */       }  
/*  874 */     return (this.isList && this.type == Type.INTEGER);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean[] getBooleanList() {
/*  885 */     ArrayList<Boolean> tmp = new ArrayList<Boolean>();
/*  886 */     for (String value : this.values) {
/*      */ 
/*      */       
/*      */       try {
/*  890 */         tmp.add(Boolean.valueOf(Boolean.parseBoolean(value)));
/*      */       }
/*  892 */       catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */     
/*  895 */     boolean[] primitives = new boolean[tmp.size()];
/*      */     
/*  897 */     for (int i = 0; i < tmp.size(); i++)
/*      */     {
/*  899 */       primitives[i] = ((Boolean)tmp.get(i)).booleanValue();
/*      */     }
/*      */     
/*  902 */     return primitives;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBooleanList() {
/*  911 */     if (this.isList && this.type == Type.BOOLEAN) {
/*  912 */       for (String value : this.values) {
/*      */         
/*  914 */         if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value))
/*      */         {
/*  916 */           return false;
/*      */         }
/*      */       } 
/*      */     }
/*  920 */     return (this.isList && this.type == Type.BOOLEAN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double[] getDoubleList() {
/*  931 */     ArrayList<Double> tmp = new ArrayList<Double>();
/*  932 */     for (String value : this.values) {
/*      */ 
/*      */       
/*      */       try {
/*  936 */         tmp.add(Double.valueOf(Double.parseDouble(value)));
/*      */       }
/*  938 */       catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */     
/*  941 */     double[] primitives = new double[tmp.size()];
/*      */     
/*  943 */     for (int i = 0; i < tmp.size(); i++)
/*      */     {
/*  945 */       primitives[i] = ((Double)tmp.get(i)).doubleValue();
/*      */     }
/*      */     
/*  948 */     return primitives;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDoubleList() {
/*  957 */     if (this.isList && this.type == Type.DOUBLE) {
/*  958 */       for (String value : this.values) {
/*      */ 
/*      */         
/*      */         try {
/*  962 */           Double.parseDouble(value);
/*      */         }
/*  964 */         catch (NumberFormatException e) {
/*      */           
/*  966 */           return false;
/*      */         } 
/*      */       } 
/*      */     }
/*  970 */     return (this.isList && this.type == Type.DOUBLE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  980 */     return this.name;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String name) {
/*  990 */     this.name = name;
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
/*      */   public boolean wasRead() {
/* 1002 */     return this.wasRead;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Type getType() {
/* 1012 */     return this.type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isList() {
/* 1022 */     return this.isList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasChanged() {
/* 1030 */     return this.changed; } void resetChangedState() {
/* 1031 */     this.changed = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValue(String value) {
/* 1038 */     this.value = value;
/* 1039 */     this.changed = true;
/* 1040 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(String value) {
/* 1045 */     setValue(value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValues(String[] values) {
/* 1053 */     this.values = Arrays.<String>copyOf(values, values.length);
/* 1054 */     this.changed = true;
/* 1055 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(String[] values) {
/* 1060 */     setValues(values);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValue(int value) {
/* 1068 */     setValue(Integer.toString(value));
/* 1069 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValue(boolean value) {
/* 1077 */     setValue(Boolean.toString(value));
/* 1078 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValue(double value) {
/* 1086 */     setValue(Double.toString(value));
/* 1087 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValues(boolean[] values) {
/* 1095 */     this.values = new String[values.length];
/* 1096 */     for (int i = 0; i < values.length; i++)
/* 1097 */       this.values[i] = String.valueOf(values[i]); 
/* 1098 */     this.changed = true;
/* 1099 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(boolean[] values) {
/* 1104 */     setValues(values);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValues(int[] values) {
/* 1112 */     this.values = new String[values.length];
/* 1113 */     for (int i = 0; i < values.length; i++)
/* 1114 */       this.values[i] = String.valueOf(values[i]); 
/* 1115 */     this.changed = true;
/* 1116 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(int[] values) {
/* 1121 */     setValues(values);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Property setValues(double[] values) {
/* 1129 */     this.values = new String[values.length];
/* 1130 */     for (int i = 0; i < values.length; i++)
/* 1131 */       this.values[i] = String.valueOf(values[i]); 
/* 1132 */     this.changed = true;
/* 1133 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void set(double[] values) {
/* 1138 */     setValues(values);
/*      */   }
/* 1140 */   public void set(int value) { set(Integer.toString(value)); }
/* 1141 */   public void set(boolean value) { set(Boolean.toString(value)); } public void set(double value) {
/* 1142 */     set(Double.toString(value));
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\config\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */