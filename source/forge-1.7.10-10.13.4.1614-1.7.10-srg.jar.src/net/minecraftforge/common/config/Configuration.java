/*      */ package net.minecraftforge.common.config;
/*      */ 
/*      */ import com.google.common.base.CharMatcher;
/*      */ import com.google.common.collect.ImmutableSet;
/*      */ import cpw.mods.fml.client.config.GuiConfigEntries;
/*      */ import cpw.mods.fml.common.FMLLog;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.relauncher.FMLInjectionData;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PushbackInputStream;
/*      */ import java.io.Reader;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Configuration
/*      */ {
/*      */   public static final String CATEGORY_GENERAL = "general";
/*      */   public static final String ALLOWED_CHARS = "._-";
/*      */   public static final String DEFAULT_ENCODING = "UTF-8";
/*      */   public static final String CATEGORY_SPLITTER = ".";
/*      */   public static final String NEW_LINE;
/*      */   public static final String COMMENT_SEPARATOR = "##########################################################################################################";
/*      */   private static final String CONFIG_VERSION_MARKER = "~CONFIG_VERSION";
/*   57 */   private static final Pattern CONFIG_START = Pattern.compile("START: \"([^\\\"]+)\"");
/*   58 */   private static final Pattern CONFIG_END = Pattern.compile("END: \"([^\\\"]+)\"");
/*   59 */   public static final CharMatcher allowedProperties = CharMatcher.JAVA_LETTER_OR_DIGIT.or(CharMatcher.anyOf("._-"));
/*   60 */   private static Configuration PARENT = null;
/*      */   
/*      */   File file;
/*      */   
/*   64 */   private Map<String, ConfigCategory> categories = new TreeMap<String, ConfigCategory>();
/*   65 */   private Map<String, Configuration> children = new TreeMap<String, Configuration>();
/*      */   
/*      */   private boolean caseSensitiveCustomCategories;
/*   68 */   public String defaultEncoding = "UTF-8";
/*   69 */   private String fileName = null;
/*      */   public boolean isChild = false;
/*      */   private boolean changed = false;
/*   72 */   private String definedConfigVersion = null;
/*   73 */   private String loadedConfigVersion = null;
/*      */ 
/*      */   
/*      */   static {
/*   77 */     NEW_LINE = System.getProperty("line.separator");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration(File file) {
/*   87 */     this(file, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration(File file, String configVersion) {
/*   95 */     this.file = file;
/*   96 */     this.definedConfigVersion = configVersion;
/*   97 */     String basePath = ((File)FMLInjectionData.data()[6]).getAbsolutePath().replace(File.separatorChar, '/').replace("/.", "");
/*   98 */     String path = file.getAbsolutePath().replace(File.separatorChar, '/').replace("/./", "/").replace(basePath, "");
/*   99 */     if (PARENT != null) {
/*      */       
/*  101 */       PARENT.setChild(path, this);
/*  102 */       this.isChild = true;
/*      */     }
/*      */     else {
/*      */       
/*  106 */       this.fileName = path;
/*      */       
/*      */       try {
/*  109 */         load();
/*      */       }
/*  111 */       catch (Throwable e) {
/*      */ 
/*      */         
/*  114 */         File fileBak = new File(file.getAbsolutePath() + "_" + (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(new Date()) + ".errored");
/*  115 */         FMLLog.severe("An exception occurred while loading config file %s. This file will be renamed to %s and a new config file will be generated.", new Object[] { file
/*  116 */               .getName(), fileBak.getName() });
/*  117 */         e.printStackTrace();
/*      */         
/*  119 */         file.renameTo(fileBak);
/*  120 */         load();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Configuration(File file, String configVersion, boolean caseSensitiveCustomCategories) {
/*  127 */     this(file, configVersion);
/*  128 */     this.caseSensitiveCustomCategories = caseSensitiveCustomCategories;
/*      */   }
/*      */ 
/*      */   
/*      */   public Configuration(File file, boolean caseSensitiveCustomCategories) {
/*  133 */     this(file, null, caseSensitiveCustomCategories);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  139 */     return this.file.getAbsolutePath();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getDefinedConfigVersion() {
/*  144 */     return this.definedConfigVersion;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getLoadedConfigVersion() {
/*  149 */     return this.loadedConfigVersion;
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
/*      */   public Property get(String category, String key, boolean defaultValue) {
/*  168 */     return get(category, key, defaultValue, (String)null);
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
/*      */   public Property get(String category, String key, boolean defaultValue, String comment) {
/*  182 */     Property prop = get(category, key, Boolean.toString(defaultValue), comment, Property.Type.BOOLEAN);
/*  183 */     prop.setDefaultValue(Boolean.toString(defaultValue));
/*      */     
/*  185 */     if (!prop.isBooleanValue())
/*      */     {
/*  187 */       prop.setValue(defaultValue);
/*      */     }
/*  189 */     return prop;
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
/*      */   public Property get(String category, String key, boolean[] defaultValues) {
/*  203 */     return get(category, key, defaultValues, (String)null);
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
/*      */   public Property get(String category, String key, boolean[] defaultValues, String comment) {
/*  217 */     return get(category, key, defaultValues, comment, false, -1);
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
/*      */   public Property get(String category, String key, boolean[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength) {
/*  235 */     String[] values = new String[defaultValues.length];
/*  236 */     for (int i = 0; i < defaultValues.length; i++)
/*      */     {
/*  238 */       values[i] = Boolean.toString(defaultValues[i]);
/*      */     }
/*      */     
/*  241 */     Property prop = get(category, key, values, comment, Property.Type.BOOLEAN);
/*  242 */     prop.setDefaultValues(values);
/*  243 */     prop.setIsListLengthFixed(isListLengthFixed);
/*  244 */     prop.setMaxListLength(maxListLength);
/*      */     
/*  246 */     if (!prop.isBooleanList())
/*      */     {
/*  248 */       prop.setValues(values);
/*      */     }
/*      */     
/*  251 */     return prop;
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
/*      */   public Property get(String category, String key, int defaultValue) {
/*  270 */     return get(category, key, defaultValue, (String)null, -2147483648, 2147483647);
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
/*      */   public Property get(String category, String key, int defaultValue, String comment) {
/*  284 */     return get(category, key, defaultValue, comment, -2147483648, 2147483647);
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
/*      */   public Property get(String category, String key, int defaultValue, String comment, int minValue, int maxValue) {
/*  300 */     Property prop = get(category, key, Integer.toString(defaultValue), comment, Property.Type.INTEGER);
/*  301 */     prop.setDefaultValue(Integer.toString(defaultValue));
/*  302 */     prop.setMinValue(minValue);
/*  303 */     prop.setMaxValue(maxValue);
/*      */     
/*  305 */     if (!prop.isIntValue())
/*      */     {
/*  307 */       prop.setValue(defaultValue);
/*      */     }
/*  309 */     return prop;
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
/*      */   public Property get(String category, String key, int[] defaultValues) {
/*  323 */     return get(category, key, defaultValues, (String)null);
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
/*      */   public Property get(String category, String key, int[] defaultValues, String comment) {
/*  338 */     return get(category, key, defaultValues, comment, -2147483648, 2147483647, false, -1);
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
/*      */   public Property get(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue) {
/*  355 */     return get(category, key, defaultValues, comment, minValue, maxValue, false, -1);
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
/*      */   public Property get(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue, boolean isListLengthFixed, int maxListLength) {
/*  375 */     String[] values = new String[defaultValues.length];
/*  376 */     for (int i = 0; i < defaultValues.length; i++)
/*      */     {
/*  378 */       values[i] = Integer.toString(defaultValues[i]);
/*      */     }
/*      */     
/*  381 */     Property prop = get(category, key, values, comment, Property.Type.INTEGER);
/*  382 */     prop.setDefaultValues(values);
/*  383 */     prop.setMinValue(minValue);
/*  384 */     prop.setMaxValue(maxValue);
/*  385 */     prop.setIsListLengthFixed(isListLengthFixed);
/*  386 */     prop.setMaxListLength(maxListLength);
/*      */     
/*  388 */     if (!prop.isIntList())
/*      */     {
/*  390 */       prop.setValues(values);
/*      */     }
/*      */     
/*  393 */     return prop;
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
/*      */   public Property get(String category, String key, double defaultValue) {
/*  412 */     return get(category, key, defaultValue, (String)null);
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
/*      */   public Property get(String category, String key, double defaultValue, String comment) {
/*  426 */     return get(category, key, defaultValue, comment, -1.7976931348623157E308D, Double.MAX_VALUE);
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
/*      */   public Property get(String category, String key, double defaultValue, String comment, double minValue, double maxValue) {
/*  442 */     Property prop = get(category, key, Double.toString(defaultValue), comment, Property.Type.DOUBLE);
/*  443 */     prop.setDefaultValue(Double.toString(defaultValue));
/*  444 */     prop.setMinValue(minValue);
/*  445 */     prop.setMaxValue(maxValue);
/*      */     
/*  447 */     if (!prop.isDoubleValue())
/*      */     {
/*  449 */       prop.setValue(defaultValue);
/*      */     }
/*  451 */     return prop;
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
/*      */   public Property get(String category, String key, double[] defaultValues) {
/*  465 */     return get(category, key, defaultValues, (String)null);
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
/*      */   public Property get(String category, String key, double[] defaultValues, String comment) {
/*  480 */     return get(category, key, defaultValues, comment, -1.7976931348623157E308D, Double.MAX_VALUE, false, -1);
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
/*      */   public Property get(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue) {
/*  497 */     return get(category, key, defaultValues, comment, minValue, maxValue, false, -1);
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
/*      */   public Property get(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue, boolean isListLengthFixed, int maxListLength) {
/*  517 */     String[] values = new String[defaultValues.length];
/*  518 */     for (int i = 0; i < defaultValues.length; i++)
/*      */     {
/*  520 */       values[i] = Double.toString(defaultValues[i]);
/*      */     }
/*      */ 
/*      */     
/*  524 */     Property prop = get(category, key, values, comment, Property.Type.DOUBLE);
/*  525 */     prop.setDefaultValues(values);
/*  526 */     prop.setMinValue(minValue);
/*  527 */     prop.setMaxValue(maxValue);
/*  528 */     prop.setIsListLengthFixed(isListLengthFixed);
/*  529 */     prop.setMaxListLength(maxListLength);
/*      */     
/*  531 */     if (!prop.isDoubleList())
/*      */     {
/*  533 */       prop.setValues(values);
/*      */     }
/*      */     
/*  536 */     return prop;
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
/*      */   public Property get(String category, String key, String defaultValue) {
/*  555 */     return get(category, key, defaultValue, (String)null);
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
/*      */   public Property get(String category, String key, String defaultValue, String comment) {
/*  569 */     return get(category, key, defaultValue, comment, Property.Type.STRING);
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
/*      */   public Property get(String category, String key, String defaultValue, String comment, Pattern validationPattern) {
/*  584 */     Property prop = get(category, key, defaultValue, comment, Property.Type.STRING);
/*  585 */     prop.setValidationPattern(validationPattern);
/*  586 */     return prop;
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
/*      */   public Property get(String category, String key, String defaultValue, String comment, String[] validValues) {
/*  602 */     Property prop = get(category, key, defaultValue, comment, Property.Type.STRING);
/*  603 */     prop.setValidValues(validValues);
/*  604 */     return prop;
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
/*      */   public Property get(String category, String key, String[] defaultValues) {
/*  617 */     return get(category, key, defaultValues, (String)null, false, -1, (Pattern)null);
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
/*      */   public Property get(String category, String key, String[] defaultValues, String comment) {
/*  631 */     return get(category, key, defaultValues, comment, false, -1, (Pattern)null);
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
/*      */   public Property get(String category, String key, String[] defaultValues, String comment, Pattern validationPattern) {
/*  646 */     return get(category, key, defaultValues, comment, false, -1, validationPattern);
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
/*      */   public Property get(String category, String key, String[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength, Pattern validationPattern) {
/*  665 */     Property prop = get(category, key, defaultValues, comment, Property.Type.STRING);
/*  666 */     prop.setIsListLengthFixed(isListLengthFixed);
/*  667 */     prop.setMaxListLength(maxListLength);
/*  668 */     prop.setValidationPattern(validationPattern);
/*  669 */     return prop;
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
/*      */   public Property get(String category, String key, String defaultValue, String comment, Property.Type type) {
/*  690 */     if (!this.caseSensitiveCustomCategories)
/*      */     {
/*  692 */       category = category.toLowerCase(Locale.ENGLISH);
/*      */     }
/*      */     
/*  695 */     ConfigCategory cat = getCategory(category);
/*      */     
/*  697 */     if (cat.containsKey(key)) {
/*      */       
/*  699 */       Property prop = cat.get(key);
/*      */       
/*  701 */       if (prop.getType() == null) {
/*      */         
/*  703 */         prop = new Property(prop.getName(), prop.getString(), type);
/*  704 */         cat.put(key, prop);
/*      */       } 
/*      */       
/*  707 */       prop.setDefaultValue(defaultValue);
/*  708 */       prop.comment = comment;
/*  709 */       return prop;
/*      */     } 
/*  711 */     if (defaultValue != null) {
/*      */       
/*  713 */       Property prop = new Property(key, defaultValue, type);
/*  714 */       prop.setValue(defaultValue);
/*  715 */       cat.put(key, prop);
/*  716 */       prop.setDefaultValue(defaultValue);
/*  717 */       prop.comment = comment;
/*  718 */       return prop;
/*      */     } 
/*      */ 
/*      */     
/*  722 */     return null;
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
/*      */   public Property get(String category, String key, String[] defaultValues, String comment, Property.Type type) {
/*  738 */     if (!this.caseSensitiveCustomCategories)
/*      */     {
/*  740 */       category = category.toLowerCase(Locale.ENGLISH);
/*      */     }
/*      */     
/*  743 */     ConfigCategory cat = getCategory(category);
/*      */     
/*  745 */     if (cat.containsKey(key)) {
/*      */       
/*  747 */       Property prop = cat.get(key);
/*      */       
/*  749 */       if (prop.getType() == null) {
/*      */         
/*  751 */         prop = new Property(prop.getName(), prop.getString(), type);
/*  752 */         cat.put(key, prop);
/*      */       } 
/*      */       
/*  755 */       prop.setDefaultValues(defaultValues);
/*  756 */       prop.comment = comment;
/*      */       
/*  758 */       return prop;
/*      */     } 
/*  760 */     if (defaultValues != null) {
/*      */       
/*  762 */       Property prop = new Property(key, defaultValues, type);
/*  763 */       prop.setDefaultValues(defaultValues);
/*  764 */       prop.comment = comment;
/*  765 */       cat.put(key, prop);
/*  766 */       return prop;
/*      */     } 
/*      */ 
/*      */     
/*  770 */     return null;
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
/*      */   public boolean hasCategory(String category) {
/*  782 */     return (this.categories.get(category) != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasKey(String category, String key) {
/*  787 */     ConfigCategory cat = this.categories.get(category);
/*  788 */     return (cat != null && cat.containsKey(key));
/*      */   }
/*      */ 
/*      */   
/*      */   public void load() {
/*  793 */     if (PARENT != null && PARENT != this) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  798 */     BufferedReader buffer = null;
/*  799 */     UnicodeInputStreamReader input = null;
/*      */     
/*      */     try {
/*  802 */       if (this.file.getParentFile() != null)
/*      */       {
/*  804 */         this.file.getParentFile().mkdirs();
/*      */       }
/*      */       
/*  807 */       if (!this.file.exists()) {
/*      */ 
/*      */         
/*  810 */         this.categories.clear();
/*  811 */         this.children.clear();
/*  812 */         if (!this.file.createNewFile()) {
/*      */           return;
/*      */         }
/*      */       } 
/*  816 */       if (this.file.canRead()) {
/*      */         
/*  818 */         input = new UnicodeInputStreamReader(new FileInputStream(this.file), this.defaultEncoding);
/*  819 */         this.defaultEncoding = input.getEncoding();
/*  820 */         buffer = new BufferedReader(input);
/*      */ 
/*      */         
/*  823 */         ConfigCategory currentCat = null;
/*  824 */         Property.Type type = null;
/*  825 */         ArrayList<String> tmpList = null;
/*  826 */         int lineNum = 0;
/*  827 */         String name = null;
/*  828 */         this.loadedConfigVersion = null;
/*      */ 
/*      */         
/*      */         while (true) {
/*  832 */           lineNum++;
/*  833 */           String line = buffer.readLine();
/*      */           
/*  835 */           if (line == null) {
/*      */             
/*  837 */             if (lineNum == 1) {
/*  838 */               this.loadedConfigVersion = this.definedConfigVersion;
/*      */             }
/*      */             break;
/*      */           } 
/*  842 */           Matcher start = CONFIG_START.matcher(line);
/*  843 */           Matcher end = CONFIG_END.matcher(line);
/*      */           
/*  845 */           if (start.matches()) {
/*      */             
/*  847 */             this.fileName = start.group(1);
/*  848 */             this.categories = new TreeMap<String, ConfigCategory>();
/*      */             continue;
/*      */           } 
/*  851 */           if (end.matches()) {
/*      */             
/*  853 */             this.fileName = end.group(1);
/*  854 */             Configuration child = new Configuration();
/*  855 */             child.categories = this.categories;
/*  856 */             this.children.put(this.fileName, child);
/*      */             
/*      */             continue;
/*      */           } 
/*  860 */           int nameStart = -1, nameEnd = -1;
/*  861 */           boolean skip = false;
/*  862 */           boolean quoted = false;
/*  863 */           boolean isFirstNonWhitespaceCharOnLine = true;
/*      */           
/*  865 */           for (int i = 0; i < line.length() && !skip; i++) {
/*      */             
/*  867 */             if (Character.isLetterOrDigit(line.charAt(i)) || "._-".indexOf(line.charAt(i)) != -1 || (quoted && line.charAt(i) != '"')) {
/*      */               
/*  869 */               if (nameStart == -1)
/*      */               {
/*  871 */                 nameStart = i;
/*      */               }
/*      */               
/*  874 */               nameEnd = i;
/*  875 */               isFirstNonWhitespaceCharOnLine = false;
/*      */             }
/*  877 */             else if (!Character.isWhitespace(line.charAt(i))) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  883 */               switch (line.charAt(i)) {
/*      */                 
/*      */                 case '#':
/*  886 */                   if (tmpList == null) {
/*      */                     
/*  888 */                     skip = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     break;
/*      */                   } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1013 */                   isFirstNonWhitespaceCharOnLine = false; break;case '"': if (tmpList == null) { if (quoted) quoted = false;  if (!quoted && nameStart == -1) quoted = true;  }  isFirstNonWhitespaceCharOnLine = false; break;case '{': if (tmpList == null) { name = line.substring(nameStart, nameEnd + 1); String qualifiedName = ConfigCategory.getQualifiedName(name, currentCat); ConfigCategory cat = this.categories.get(qualifiedName); if (cat == null) { currentCat = new ConfigCategory(name, currentCat); this.categories.put(qualifiedName, currentCat); } else { currentCat = cat; }  name = null; }  isFirstNonWhitespaceCharOnLine = false; break;case '}': if (tmpList == null) { if (currentCat == null) throw new RuntimeException(String.format("Config file corrupt, attepted to close to many categories '%s:%d'", new Object[] { this.fileName, Integer.valueOf(lineNum) }));  currentCat = currentCat.parent; }  isFirstNonWhitespaceCharOnLine = false; break;case '=': if (tmpList == null) { name = line.substring(nameStart, nameEnd + 1); if (currentCat == null) throw new RuntimeException(String.format("'%s' has no scope in '%s:%d'", new Object[] { name, this.fileName, Integer.valueOf(lineNum) }));  Property prop = new Property(name, line.substring(i + 1), type, true); i = line.length(); currentCat.put(name, prop); }  isFirstNonWhitespaceCharOnLine = false; break;case ':': if (tmpList == null) { type = Property.Type.tryParse(line.substring(nameStart, nameEnd + 1).charAt(0)); nameStart = nameEnd = -1; }  isFirstNonWhitespaceCharOnLine = false; break;case '<': if ((tmpList != null && i + 1 == line.length()) || (tmpList == null && i + 1 != line.length())) throw new RuntimeException(String.format("Malformed list property \"%s:%d\"", new Object[] { this.fileName, Integer.valueOf(lineNum) }));  if (i + 1 == line.length()) { name = line.substring(nameStart, nameEnd + 1); if (currentCat == null) throw new RuntimeException(String.format("'%s' has no scope in '%s:%d'", new Object[] { name, this.fileName, Integer.valueOf(lineNum) }));  tmpList = new ArrayList<String>(); skip = true; }  isFirstNonWhitespaceCharOnLine = false; break;case '>': if (tmpList == null) throw new RuntimeException(String.format("Malformed list property \"%s:%d\"", new Object[] { this.fileName, Integer.valueOf(lineNum) }));  if (isFirstNonWhitespaceCharOnLine) { currentCat.put(name, new Property(name, tmpList.<String>toArray(new String[tmpList.size()]), type)); name = null; tmpList = null; type = null; }  isFirstNonWhitespaceCharOnLine = false; break;case '~': if (tmpList == null) if (line.startsWith("~CONFIG_VERSION")) { int colon = line.indexOf(':'); if (colon != -1) this.loadedConfigVersion = line.substring(colon + 1).trim();  skip = true; }   isFirstNonWhitespaceCharOnLine = false; break;default: if (tmpList == null) throw new RuntimeException(String.format("Unknown character '%s' in '%s:%d'", new Object[] { Character.valueOf(line.charAt(i)), this.fileName, Integer.valueOf(lineNum) }));  isFirstNonWhitespaceCharOnLine = false; break;
/*      */               } 
/*      */             } 
/*      */           } 
/* 1017 */           if (quoted)
/*      */           {
/* 1019 */             throw new RuntimeException(String.format("Unmatched quote in '%s:%d'", new Object[] { this.fileName, Integer.valueOf(lineNum) }));
/*      */           }
/* 1021 */           if (tmpList != null && !skip)
/*      */           {
/* 1023 */             tmpList.add(line.trim());
/*      */           }
/*      */         }
/*      */       
/*      */       } 
/* 1028 */     } catch (IOException e) {
/*      */       
/* 1030 */       e.printStackTrace();
/*      */     }
/*      */     finally {
/*      */       
/* 1034 */       if (buffer != null) {
/*      */         
/*      */         try {
/*      */           
/* 1038 */           buffer.close();
/* 1039 */         } catch (IOException iOException) {}
/*      */       }
/* 1041 */       if (input != null) {
/*      */         
/*      */         try {
/*      */           
/* 1045 */           input.close();
/* 1046 */         } catch (IOException iOException) {}
/*      */       }
/*      */     } 
/*      */     
/* 1050 */     resetChangedState();
/*      */   }
/*      */ 
/*      */   
/*      */   public void save() {
/* 1055 */     if (PARENT != null && PARENT != this) {
/*      */       
/* 1057 */       PARENT.save();
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*      */     try {
/* 1063 */       if (this.file.getParentFile() != null)
/*      */       {
/* 1065 */         this.file.getParentFile().mkdirs();
/*      */       }
/*      */       
/* 1068 */       if (!this.file.exists() && !this.file.createNewFile()) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/* 1073 */       if (this.file.canWrite())
/*      */       {
/* 1075 */         FileOutputStream fos = new FileOutputStream(this.file);
/* 1076 */         BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos, this.defaultEncoding));
/*      */         
/* 1078 */         buffer.write("# Configuration file" + NEW_LINE + NEW_LINE);
/*      */         
/* 1080 */         if (this.definedConfigVersion != null) {
/* 1081 */           buffer.write("~CONFIG_VERSION: " + this.definedConfigVersion + NEW_LINE + NEW_LINE);
/*      */         }
/* 1083 */         if (this.children.isEmpty()) {
/*      */           
/* 1085 */           save(buffer);
/*      */         }
/*      */         else {
/*      */           
/* 1089 */           for (Map.Entry<String, Configuration> entry : this.children.entrySet()) {
/*      */             
/* 1091 */             buffer.write("START: \"" + (String)entry.getKey() + "\"" + NEW_LINE);
/* 1092 */             ((Configuration)entry.getValue()).save(buffer);
/* 1093 */             buffer.write("END: \"" + (String)entry.getKey() + "\"" + NEW_LINE + NEW_LINE);
/*      */           } 
/*      */         } 
/*      */         
/* 1097 */         buffer.close();
/* 1098 */         fos.close();
/*      */       }
/*      */     
/* 1101 */     } catch (IOException e) {
/*      */       
/* 1103 */       e.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void save(BufferedWriter out) throws IOException {
/* 1109 */     for (ConfigCategory cat : this.categories.values()) {
/*      */       
/* 1111 */       if (!cat.isChild()) {
/*      */         
/* 1113 */         cat.write(out, 0);
/* 1114 */         out.newLine();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ConfigCategory getCategory(String category) {
/* 1121 */     ConfigCategory ret = this.categories.get(category);
/*      */     
/* 1123 */     if (ret == null)
/*      */     {
/* 1125 */       if (category.contains(".")) {
/*      */         
/* 1127 */         String[] hierarchy = category.split("\\.");
/* 1128 */         ConfigCategory parent = this.categories.get(hierarchy[0]);
/*      */         
/* 1130 */         if (parent == null) {
/*      */           
/* 1132 */           parent = new ConfigCategory(hierarchy[0]);
/* 1133 */           this.categories.put(parent.getQualifiedName(), parent);
/* 1134 */           this.changed = true;
/*      */         } 
/*      */         
/* 1137 */         for (int i = 1; i < hierarchy.length; i++)
/*      */         {
/* 1139 */           String name = ConfigCategory.getQualifiedName(hierarchy[i], parent);
/* 1140 */           ConfigCategory child = this.categories.get(name);
/*      */           
/* 1142 */           if (child == null) {
/*      */             
/* 1144 */             child = new ConfigCategory(hierarchy[i], parent);
/* 1145 */             this.categories.put(name, child);
/* 1146 */             this.changed = true;
/*      */           } 
/*      */           
/* 1149 */           ret = child;
/* 1150 */           parent = child;
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1155 */         ret = new ConfigCategory(category);
/* 1156 */         this.categories.put(category, ret);
/* 1157 */         this.changed = true;
/*      */       } 
/*      */     }
/*      */     
/* 1161 */     return ret;
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeCategory(ConfigCategory category) {
/* 1166 */     for (ConfigCategory child : category.getChildren())
/*      */     {
/* 1168 */       removeCategory(child);
/*      */     }
/*      */     
/* 1171 */     if (this.categories.containsKey(category.getQualifiedName())) {
/*      */       
/* 1173 */       this.categories.remove(category.getQualifiedName());
/* 1174 */       if (category.parent != null)
/*      */       {
/* 1176 */         category.parent.removeChild(category);
/*      */       }
/* 1178 */       this.changed = true;
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
/*      */   public Configuration setCategoryComment(String category, String comment) {
/* 1190 */     if (!this.caseSensitiveCustomCategories)
/* 1191 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1192 */     getCategory(category).setComment(comment);
/* 1193 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addCustomCategoryComment(String category, String comment) {
/* 1198 */     setCategoryComment(category, comment);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration setCategoryLanguageKey(String category, String langKey) {
/* 1209 */     if (!this.caseSensitiveCustomCategories)
/* 1210 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1211 */     getCategory(category).setLanguageKey(langKey);
/* 1212 */     return this;
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
/*      */   public Configuration setCategoryConfigEntryClass(String category, Class<? extends GuiConfigEntries.IConfigEntry> clazz) {
/* 1224 */     if (!this.caseSensitiveCustomCategories)
/* 1225 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1226 */     getCategory(category).setConfigEntryClass(clazz);
/* 1227 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration setCategoryRequiresWorldRestart(String category, boolean requiresWorldRestart) {
/* 1237 */     if (!this.caseSensitiveCustomCategories)
/* 1238 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1239 */     getCategory(category).setRequiresWorldRestart(requiresWorldRestart);
/* 1240 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration setCategoryRequiresMcRestart(String category, boolean requiresMcRestart) {
/* 1251 */     if (!this.caseSensitiveCustomCategories)
/* 1252 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1253 */     getCategory(category).setRequiresMcRestart(requiresMcRestart);
/* 1254 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Configuration setCategoryPropertyOrder(String category, List<String> propOrder) {
/* 1263 */     if (!this.caseSensitiveCustomCategories)
/* 1264 */       category = category.toLowerCase(Locale.ENGLISH); 
/* 1265 */     getCategory(category).setPropertyOrder(propOrder);
/* 1266 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   private void setChild(String name, Configuration child) {
/* 1271 */     if (!this.children.containsKey(name)) {
/*      */       
/* 1273 */       this.children.put(name, child);
/* 1274 */       this.changed = true;
/*      */     }
/*      */     else {
/*      */       
/* 1278 */       Configuration old = this.children.get(name);
/* 1279 */       child.categories = old.categories;
/* 1280 */       child.fileName = old.fileName;
/* 1281 */       old.changed = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void enableGlobalConfig() {
/* 1287 */     PARENT = new Configuration(new File(Loader.instance().getConfigDir(), "global.cfg"));
/* 1288 */     PARENT.load();
/*      */   }
/*      */   
/*      */   public static class UnicodeInputStreamReader
/*      */     extends Reader
/*      */   {
/*      */     private final InputStreamReader input;
/*      */     private final String defaultEnc;
/*      */     
/*      */     public UnicodeInputStreamReader(InputStream source, String encoding) throws IOException {
/* 1298 */       this.defaultEnc = encoding;
/* 1299 */       String enc = encoding;
/* 1300 */       byte[] data = new byte[4];
/*      */       
/* 1302 */       PushbackInputStream pbStream = new PushbackInputStream(source, data.length);
/* 1303 */       int read = pbStream.read(data, 0, data.length);
/* 1304 */       int size = 0;
/*      */       
/* 1306 */       int bom16 = (data[0] & 0xFF) << 8 | data[1] & 0xFF;
/* 1307 */       int bom24 = bom16 << 8 | data[2] & 0xFF;
/* 1308 */       int bom32 = bom24 << 8 | data[3] & 0xFF;
/*      */       
/* 1310 */       if (bom24 == 15711167) {
/*      */         
/* 1312 */         enc = "UTF-8";
/* 1313 */         size = 3;
/*      */       }
/* 1315 */       else if (bom16 == 65279) {
/*      */         
/* 1317 */         enc = "UTF-16BE";
/* 1318 */         size = 2;
/*      */       }
/* 1320 */       else if (bom16 == 65534) {
/*      */         
/* 1322 */         enc = "UTF-16LE";
/* 1323 */         size = 2;
/*      */       }
/* 1325 */       else if (bom32 == 65279) {
/*      */         
/* 1327 */         enc = "UTF-32BE";
/* 1328 */         size = 4;
/*      */       }
/* 1330 */       else if (bom32 == -131072) {
/*      */         
/* 1332 */         enc = "UTF-32LE";
/* 1333 */         size = 4;
/*      */       } 
/*      */       
/* 1336 */       if (size < read)
/*      */       {
/* 1338 */         pbStream.unread(data, size, read - size);
/*      */       }
/*      */       
/* 1341 */       this.input = new InputStreamReader(pbStream, enc);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getEncoding() {
/* 1346 */       return this.input.getEncoding();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int read(char[] cbuf, int off, int len) throws IOException {
/* 1352 */       return this.input.read(cbuf, off, len);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() throws IOException {
/* 1358 */       this.input.close();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasChanged() {
/* 1364 */     if (this.changed) return true;
/*      */     
/* 1366 */     for (ConfigCategory cat : this.categories.values()) {
/*      */       
/* 1368 */       if (cat.hasChanged()) return true;
/*      */     
/*      */     } 
/* 1371 */     for (Configuration child : this.children.values()) {
/*      */       
/* 1373 */       if (child.hasChanged()) return true;
/*      */     
/*      */     } 
/* 1376 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void resetChangedState() {
/* 1381 */     this.changed = false;
/* 1382 */     for (ConfigCategory cat : this.categories.values())
/*      */     {
/* 1384 */       cat.resetChangedState();
/*      */     }
/*      */     
/* 1387 */     for (Configuration child : this.children.values())
/*      */     {
/* 1389 */       child.resetChangedState();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<String> getCategoryNames() {
/* 1395 */     return (Set<String>)ImmutableSet.copyOf(this.categories.keySet());
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
/*      */   public boolean renameProperty(String category, String oldPropName, String newPropName) {
/* 1408 */     if (hasCategory(category))
/*      */     {
/* 1410 */       if (getCategory(category).containsKey(oldPropName) && !oldPropName.equalsIgnoreCase(newPropName)) {
/*      */         
/* 1412 */         get(category, newPropName, getCategory(category).get(oldPropName).getString(), "");
/* 1413 */         getCategory(category).remove(oldPropName);
/* 1414 */         return true;
/*      */       } 
/*      */     }
/* 1417 */     return false;
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
/*      */   public boolean moveProperty(String oldCategory, String propName, String newCategory) {
/* 1430 */     if (!oldCategory.equals(newCategory) && 
/* 1431 */       hasCategory(oldCategory) && 
/* 1432 */       getCategory(oldCategory).containsKey(propName)) {
/*      */       
/* 1434 */       getCategory(newCategory).put(propName, getCategory(oldCategory).remove(propName));
/* 1435 */       return true;
/*      */     } 
/* 1437 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void copyCategoryProps(Configuration fromConfig, String[] ctgys) {
/* 1446 */     if (ctgys == null) {
/* 1447 */       ctgys = getCategoryNames().<String>toArray(new String[getCategoryNames().size()]);
/*      */     }
/* 1449 */     for (String ctgy : ctgys) {
/* 1450 */       if (fromConfig.hasCategory(ctgy) && hasCategory(ctgy)) {
/*      */         
/* 1452 */         ConfigCategory thiscc = getCategory(ctgy);
/* 1453 */         ConfigCategory fromcc = fromConfig.getCategory(ctgy);
/* 1454 */         for (Map.Entry<String, Property> entry : thiscc.getValues().entrySet()) {
/* 1455 */           if (fromcc.containsKey(entry.getKey())) {
/* 1456 */             thiscc.put(entry.getKey(), fromcc.get(entry.getKey()));
/*      */           }
/*      */         } 
/*      */       } 
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
/*      */   public String getString(String name, String category, String defaultValue, String comment) {
/* 1471 */     return getString(name, category, defaultValue, comment, name, (Pattern)null);
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
/*      */   public String getString(String name, String category, String defaultValue, String comment, String langKey) {
/* 1486 */     return getString(name, category, defaultValue, comment, langKey, (Pattern)null);
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
/*      */   public String getString(String name, String category, String defaultValue, String comment, Pattern pattern) {
/* 1500 */     return getString(name, category, defaultValue, comment, name, pattern);
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
/*      */   public String getString(String name, String category, String defaultValue, String comment, String langKey, Pattern pattern) {
/* 1515 */     Property prop = get(category, name, defaultValue);
/* 1516 */     prop.setLanguageKey(langKey);
/* 1517 */     prop.setValidationPattern(pattern);
/* 1518 */     prop.comment = comment + " [default: " + defaultValue + "]";
/* 1519 */     return prop.getString();
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
/*      */   public String getString(String name, String category, String defaultValue, String comment, String[] validValues) {
/* 1534 */     return getString(name, category, defaultValue, comment, validValues, name);
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
/*      */   public String getString(String name, String category, String defaultValue, String comment, String[] validValues, String langKey) {
/* 1550 */     Property prop = get(category, name, defaultValue);
/* 1551 */     prop.setValidValues(validValues);
/* 1552 */     prop.setLanguageKey(langKey);
/* 1553 */     prop.comment = comment + " [default: " + defaultValue + "]";
/* 1554 */     return prop.getString();
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
/*      */   public String[] getStringList(String name, String category, String[] defaultValues, String comment) {
/* 1568 */     return getStringList(name, category, defaultValues, comment, (String[])null, name);
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
/*      */   public String[] getStringList(String name, String category, String[] defaultValue, String comment, String[] validValues) {
/* 1582 */     return getStringList(name, category, defaultValue, comment, validValues, name);
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
/*      */   public String[] getStringList(String name, String category, String[] defaultValue, String comment, String[] validValues, String langKey) {
/* 1596 */     Property prop = get(category, name, defaultValue);
/* 1597 */     prop.setLanguageKey(langKey);
/* 1598 */     prop.setValidValues(validValues);
/* 1599 */     prop.comment = comment + " [default: " + prop.getDefault() + "]";
/* 1600 */     return prop.getStringList();
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
/*      */   public boolean getBoolean(String name, String category, boolean defaultValue, String comment) {
/* 1614 */     return getBoolean(name, category, defaultValue, comment, name);
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
/*      */   public boolean getBoolean(String name, String category, boolean defaultValue, String comment, String langKey) {
/* 1629 */     Property prop = get(category, name, defaultValue);
/* 1630 */     prop.setLanguageKey(langKey);
/* 1631 */     prop.comment = comment + " [default: " + defaultValue + "]";
/* 1632 */     return prop.getBoolean(defaultValue);
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
/*      */   public int getInt(String name, String category, int defaultValue, int minValue, int maxValue, String comment) {
/* 1648 */     return getInt(name, category, defaultValue, minValue, maxValue, comment, name);
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
/*      */   public int getInt(String name, String category, int defaultValue, int minValue, int maxValue, String comment, String langKey) {
/* 1665 */     Property prop = get(category, name, defaultValue);
/* 1666 */     prop.setLanguageKey(langKey);
/* 1667 */     prop.comment = comment + " [range: " + minValue + " ~ " + maxValue + ", default: " + defaultValue + "]";
/* 1668 */     prop.setMinValue(minValue);
/* 1669 */     prop.setMaxValue(maxValue);
/* 1670 */     return (prop.getInt(defaultValue) < minValue) ? minValue : ((prop.getInt(defaultValue) > maxValue) ? maxValue : prop.getInt(defaultValue));
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
/*      */   public float getFloat(String name, String category, float defaultValue, float minValue, float maxValue, String comment) {
/* 1686 */     return getFloat(name, category, defaultValue, minValue, maxValue, comment, name);
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
/*      */   public float getFloat(String name, String category, float defaultValue, float minValue, float maxValue, String comment, String langKey) {
/* 1703 */     Property prop = get(category, name, Float.toString(defaultValue), name);
/* 1704 */     prop.setLanguageKey(langKey);
/* 1705 */     prop.comment = comment + " [range: " + minValue + " ~ " + maxValue + ", default: " + defaultValue + "]";
/* 1706 */     prop.setMinValue(minValue);
/* 1707 */     prop.setMaxValue(maxValue);
/*      */     
/*      */     try {
/* 1710 */       return (Float.parseFloat(prop.getString()) < minValue) ? minValue : ((Float.parseFloat(prop.getString()) > maxValue) ? maxValue : Float.parseFloat(prop.getString()));
/*      */     }
/* 1712 */     catch (Exception e) {
/*      */       
/* 1714 */       e.printStackTrace();
/*      */       
/* 1716 */       return defaultValue;
/*      */     } 
/*      */   }
/*      */   
/*      */   public File getConfigFile() {
/* 1721 */     return this.file;
/*      */   }
/*      */   
/*      */   public Configuration() {}
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\config\Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */