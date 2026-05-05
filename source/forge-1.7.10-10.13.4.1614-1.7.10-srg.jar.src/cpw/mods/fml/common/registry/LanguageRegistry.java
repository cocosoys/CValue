/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.StringTranslate;
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
/*     */ public class LanguageRegistry
/*     */ {
/*  50 */   private static final LanguageRegistry INSTANCE = new LanguageRegistry();
/*     */   
/*  52 */   private Map<String, Properties> modLanguageData = new HashMap<String, Properties>();
/*     */   
/*  54 */   private static final Pattern assetENUSLang = Pattern.compile("assets/(.*)/lang/(?:.+/|)([\\w_-]+).lang");
/*     */ 
/*     */   
/*     */   public static LanguageRegistry instance() {
/*  58 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringLocalization(String key) {
/*  63 */     return getStringLocalization(key, FMLCommonHandler.instance().getCurrentLanguage());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringLocalization(String key, String lang) {
/*  68 */     String localizedString = "";
/*  69 */     Properties langPack = this.modLanguageData.get(lang);
/*     */     
/*  71 */     if (langPack != null && 
/*  72 */       langPack.getProperty(key) != null) {
/*  73 */       localizedString = langPack.getProperty(key);
/*     */     }
/*     */ 
/*     */     
/*  77 */     return localizedString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addStringLocalization(String key, String value) {
/*  86 */     addStringLocalization(key, "en_US", value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addStringLocalization(String key, String lang, String value) {
/*  95 */     Properties langPack = this.modLanguageData.get(lang);
/*  96 */     if (langPack == null) {
/*  97 */       langPack = new Properties();
/*  98 */       this.modLanguageData.put(lang, langPack);
/*     */     } 
/* 100 */     langPack.put(key, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addStringLocalization(Properties langPackAdditions) {
/* 108 */     addStringLocalization(langPackAdditions, "en_US");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addStringLocalization(Properties langPackAdditions, String lang) {
/* 116 */     Properties langPack = this.modLanguageData.get(lang);
/* 117 */     if (langPack == null) {
/* 118 */       langPack = new Properties();
/* 119 */       this.modLanguageData.put(lang, langPack);
/*     */     } 
/* 121 */     if (langPackAdditions != null) {
/* 122 */       langPack.putAll(langPackAdditions);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void addNameForObject(Object objectToName, String lang, String name) {
/* 133 */     if (objectToName instanceof Item) {
/* 134 */       objectName = ((Item)objectToName).getUnlocalizedName();
/* 135 */     } else if (objectToName instanceof Block) {
/* 136 */       objectName = ((Block)objectToName).getUnlocalizedName();
/* 137 */     } else if (objectToName instanceof ItemStack) {
/* 138 */       objectName = ((ItemStack)objectToName).getItem().getUnlocalizedName((ItemStack)objectToName);
/*     */     } else {
/* 140 */       throw new IllegalArgumentException(String.format("Illegal object for naming %s", new Object[] { objectToName }));
/*     */     } 
/* 142 */     String objectName = objectName + ".name";
/* 143 */     addStringLocalization(objectName, lang, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void addName(Object objectToName, String name) {
/* 152 */     instance().addNameForObject(objectToName, "en_US", name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void mergeLanguageTable(Map<?, ?> field_135032_a, String lang) {
/* 162 */     Properties langPack = this.modLanguageData.get(lang);
/* 163 */     if (langPack != null) {
/* 164 */       mergeWithoutOverwrite(langPack, field_135032_a);
/*     */     }
/* 166 */     Properties usPack = this.modLanguageData.get("en_US");
/* 167 */     if (usPack != null) {
/* 168 */       mergeWithoutOverwrite(usPack, field_135032_a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   private <K, V> void mergeWithoutOverwrite(Map<? extends K, ? extends V> from, Map<K, V> to) {
/* 175 */     for (Map.Entry<? extends K, ? extends V> e : from.entrySet()) {
/*     */       
/* 177 */       if (!to.containsKey(e.getKey()))
/*     */       {
/* 179 */         to.put(e.getKey(), e.getValue());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void loadLocalization(String localizationFile, String lang, boolean isXML) {
/* 189 */     URL urlResource = getClass().getResource(localizationFile);
/* 190 */     if (urlResource != null) {
/*     */       
/* 192 */       loadLocalization(urlResource, lang, isXML);
/*     */     }
/*     */     else {
/*     */       
/* 196 */       ModContainer activeModContainer = Loader.instance().activeModContainer();
/* 197 */       if (activeModContainer != null) {
/*     */         
/* 199 */         FMLLog.log(activeModContainer.getModId(), Level.ERROR, "The language resource %s cannot be located on the classpath. This is a programming error.", new Object[] { localizationFile });
/*     */       }
/*     */       else {
/*     */         
/* 203 */         FMLLog.log(Level.ERROR, "The language resource %s cannot be located on the classpath. This is a programming error.", new Object[] { localizationFile });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void loadLocalization(URL localizationFile, String lang, boolean isXML) {
/* 214 */     InputStream langStream = null;
/* 215 */     Properties langPack = new Properties();
/*     */     
/*     */     try {
/* 218 */       langStream = localizationFile.openStream();
/*     */       
/* 220 */       if (isXML) {
/* 221 */         langPack.loadFromXML(langStream);
/*     */       } else {
/*     */         
/* 224 */         langPack.load(new InputStreamReader(langStream, Charsets.UTF_8));
/*     */       } 
/*     */       
/* 227 */       addStringLocalization(langPack, lang);
/*     */     }
/* 229 */     catch (IOException e) {
/* 230 */       FMLLog.log(Level.ERROR, e, "Unable to load localization from file %s", new Object[] { localizationFile });
/*     */     } finally {
/*     */       
/*     */       try {
/* 234 */         if (langStream != null) {
/* 235 */           langStream.close();
/*     */         }
/*     */       }
/* 238 */       catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void injectLanguage(String language, HashMap<String, String> parsedLangFile) {
/* 247 */     Properties p = this.modLanguageData.get(language);
/* 248 */     if (p == null) {
/*     */       
/* 250 */       p = new Properties();
/* 251 */       this.modLanguageData.put(language, p);
/*     */     } 
/* 253 */     p.putAll(parsedLangFile);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadLanguagesFor(ModContainer container, Side side) {
/* 258 */     File source = container.getSource();
/*     */     
/*     */     try {
/* 261 */       if (source.isDirectory())
/*     */       {
/* 263 */         searchDirForLanguages(source, "", side);
/*     */       }
/*     */       else
/*     */       {
/* 267 */         searchZipForLanguages(source, side);
/*     */       }
/*     */     
/* 270 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void searchZipForLanguages(File source, Side side) throws IOException {
/* 278 */     ZipFile zf = new ZipFile(source);
/* 279 */     List<String> added = Lists.newArrayList();
/* 280 */     for (ZipEntry ze : Collections.<ZipEntry>list(zf.entries())) {
/*     */       
/* 282 */       Matcher matcher = assetENUSLang.matcher(ze.getName());
/* 283 */       if (matcher.matches()) {
/*     */         
/* 285 */         String lang = matcher.group(2);
/*     */         
/* 287 */         added.add(lang);
/* 288 */         instance().injectLanguage(lang, StringTranslate.parseLangFile(zf.getInputStream(ze)));
/*     */         
/* 290 */         if ("en_US".equals(lang) && side == Side.SERVER)
/*     */         {
/* 292 */           StringTranslate.inject(zf.getInputStream(ze));
/*     */         }
/*     */       } 
/*     */     } 
/* 296 */     if (added.size() > 0)
/* 297 */       FMLLog.fine("Found translations in %s [%s]", new Object[] { source.getName(), Joiner.on(", ").join(added) }); 
/* 298 */     zf.close();
/*     */   }
/*     */ 
/*     */   
/*     */   private void searchDirForLanguages(File source, String path, Side side) throws IOException {
/* 303 */     for (File file : source.listFiles()) {
/*     */       
/* 305 */       String currPath = path + file.getName();
/* 306 */       if (file.isDirectory())
/*     */       {
/* 308 */         searchDirForLanguages(file, currPath + '/', side);
/*     */       }
/* 310 */       Matcher matcher = assetENUSLang.matcher(currPath);
/* 311 */       if (matcher.matches()) {
/*     */         
/* 313 */         String lang = matcher.group(2);
/* 314 */         FMLLog.fine("Injecting found translation assets for lang %s at %s into language system", new Object[] { lang, currPath });
/* 315 */         instance().injectLanguage(lang, StringTranslate.parseLangFile(new FileInputStream(file)));
/*     */         
/* 317 */         if ("en_US".equals(lang) && side == Side.SERVER)
/*     */         {
/* 319 */           StringTranslate.inject(new FileInputStream(file));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\LanguageRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */