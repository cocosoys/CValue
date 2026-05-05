/*     */ package cpw.mods.fml.client;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import cpw.mods.fml.client.config.ConfigGuiType;
/*     */ import cpw.mods.fml.client.config.DummyConfigElement;
/*     */ import cpw.mods.fml.client.config.GuiConfig;
/*     */ import cpw.mods.fml.client.config.GuiConfigEntries;
/*     */ import cpw.mods.fml.client.config.IConfigElement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLConfigGuiFactory
/*     */   implements IModGuiFactory
/*     */ {
/*     */   public static class FMLConfigGuiScreen
/*     */     extends GuiConfig
/*     */   {
/*     */     public FMLConfigGuiScreen(GuiScreen parent) {
/*  30 */       super(parent, getConfigElements(), "FML", false, false, I18n.format("fml.config.sample.title", new Object[0]));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static List<IConfigElement> getConfigElements() {
/*  36 */       List<IConfigElement> list = new ArrayList<IConfigElement>();
/*  37 */       List<IConfigElement> listsList = new ArrayList<IConfigElement>();
/*  38 */       List<IConfigElement> stringsList = new ArrayList<IConfigElement>();
/*  39 */       List<IConfigElement> numbersList = new ArrayList<IConfigElement>();
/*  40 */       Pattern commaDelimitedPattern = Pattern.compile("([A-Za-z]+((,){1}( )*|$))+?");
/*     */ 
/*     */       
/*  43 */       list.add((new DummyConfigElement("imABoolean", Boolean.valueOf(true), ConfigGuiType.BOOLEAN, "fml.config.sample.imABoolean")).setRequiresMcRestart(true));
/*  44 */       list.add((new DummyConfigElement("imAnInteger", Integer.valueOf(42), ConfigGuiType.INTEGER, "fml.config.sample.imAnInteger", Integer.valueOf(-1), Integer.valueOf(256))).setRequiresMcRestart(true));
/*  45 */       list.add((new DummyConfigElement("imADouble", Double.valueOf(42.4242D), ConfigGuiType.DOUBLE, "fml.config.sample.imADouble", Double.valueOf(-1.0D), Double.valueOf(256.256D))).setRequiresMcRestart(true));
/*  46 */       list.add((new DummyConfigElement("imAString", "http://www.montypython.net/scripts/string.php", ConfigGuiType.STRING, "fml.config.sample.imAString")).setRequiresMcRestart(true));
/*     */ 
/*     */       
/*  49 */       listsList.add(new DummyConfigElement.DummyListElement("booleanList", (Object[])new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) }, ConfigGuiType.BOOLEAN, "fml.config.sample.booleanList"));
/*  50 */       listsList.add(new DummyConfigElement.DummyListElement("booleanListFixed", (Object[])new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) }, ConfigGuiType.BOOLEAN, "fml.config.sample.booleanListFixed", true));
/*  51 */       listsList.add(new DummyConfigElement.DummyListElement("booleanListMax", (Object[])new Boolean[] { Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false) }, ConfigGuiType.BOOLEAN, "fml.config.sample.booleanListMax", 10));
/*  52 */       listsList.add(new DummyConfigElement.DummyListElement("doubleList", (Object[])new Double[] { Double.valueOf(0.0D), Double.valueOf(1.1D), Double.valueOf(2.2D), Double.valueOf(3.3D), Double.valueOf(4.4D), Double.valueOf(5.5D), Double.valueOf(6.6D), Double.valueOf(7.7D), Double.valueOf(8.8D), Double.valueOf(9.9D) }, ConfigGuiType.DOUBLE, "fml.config.sample.doubleList"));
/*  53 */       listsList.add(new DummyConfigElement.DummyListElement("doubleListFixed", (Object[])new Double[] { Double.valueOf(0.0D), Double.valueOf(1.1D), Double.valueOf(2.2D), Double.valueOf(3.3D), Double.valueOf(4.4D), Double.valueOf(5.5D), Double.valueOf(6.6D), Double.valueOf(7.7D), Double.valueOf(8.8D), Double.valueOf(9.9D) }, ConfigGuiType.DOUBLE, "fml.config.sample.doubleListFixed", true));
/*  54 */       listsList.add(new DummyConfigElement.DummyListElement("doubleListMax", (Object[])new Double[] { Double.valueOf(0.0D), Double.valueOf(1.1D), Double.valueOf(2.2D), Double.valueOf(3.3D), Double.valueOf(4.4D), Double.valueOf(5.5D), Double.valueOf(6.6D), Double.valueOf(7.7D), Double.valueOf(8.8D), Double.valueOf(9.9D) }, ConfigGuiType.DOUBLE, "fml.config.sample.doubleListMax", 15));
/*  55 */       listsList.add(new DummyConfigElement.DummyListElement("doubleListBounded", (Object[])new Double[] { Double.valueOf(0.0D), Double.valueOf(1.1D), Double.valueOf(2.2D), Double.valueOf(3.3D), Double.valueOf(4.4D), Double.valueOf(5.5D), Double.valueOf(6.6D), Double.valueOf(7.7D), Double.valueOf(8.8D), Double.valueOf(9.9D) }, ConfigGuiType.DOUBLE, "fml.config.sample.doubleListBounded", Double.valueOf(-1.0D), Double.valueOf(10.0D)));
/*  56 */       listsList.add(new DummyConfigElement.DummyListElement("integerList", (Object[])new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }, ConfigGuiType.INTEGER, "fml.config.sample.integerList"));
/*  57 */       listsList.add(new DummyConfigElement.DummyListElement("integerListFixed", (Object[])new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }, ConfigGuiType.INTEGER, "fml.config.sample.integerListFixed", true));
/*  58 */       listsList.add(new DummyConfigElement.DummyListElement("integerListMax", (Object[])new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }, ConfigGuiType.INTEGER, "fml.config.sample.integerListMax", 15));
/*  59 */       listsList.add(new DummyConfigElement.DummyListElement("integerListBounded", (Object[])new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }, ConfigGuiType.INTEGER, "fml.config.sample.integerListBounded", Integer.valueOf(-1), Integer.valueOf(10)));
/*  60 */       listsList.add(new DummyConfigElement.DummyListElement("stringList", (Object[])new String[] { "An", "array", "of", "string", "values" }, ConfigGuiType.STRING, "fml.config.sample.stringList"));
/*  61 */       listsList.add(new DummyConfigElement.DummyListElement("stringListFixed", (Object[])new String[] { "A", "fixed", "length", "array", "of", "string", "values" }, ConfigGuiType.STRING, "fml.config.sample.stringListFixed", true));
/*  62 */       listsList.add(new DummyConfigElement.DummyListElement("stringListMax", (Object[])new String[] { "An", "array", "of", "string", "values", "with", "a", "max", "length", "of", "15" }, ConfigGuiType.STRING, "fml.config.sample.stringListMax", 15));
/*  63 */       listsList.add(new DummyConfigElement.DummyListElement("stringListPattern", (Object[])new String[] { "Valid", "Not Valid", "Is, Valid", "Comma, Separated, Value" }, ConfigGuiType.STRING, "fml.config.sample.stringListPattern", commaDelimitedPattern));
/*     */       
/*  65 */       list.add(new DummyConfigElement.DummyCategoryElement("lists", "fml.config.sample.ctgy.lists", listsList));
/*     */ 
/*     */       
/*  68 */       stringsList.add(new DummyConfigElement("basicString", "Just a regular String value, anything goes.", ConfigGuiType.STRING, "fml.config.sample.basicString"));
/*  69 */       stringsList.add(new DummyConfigElement("cycleString", "this", ConfigGuiType.STRING, "fml.config.sample.cycleString", new String[] { "this", "property", "cycles", "through", "a", "list", "of", "valid", "choices" }));
/*  70 */       stringsList.add(new DummyConfigElement("patternString", "only, comma, separated, words, can, be, entered, in, this, box", ConfigGuiType.STRING, "fml.config.sample.patternString", commaDelimitedPattern));
/*  71 */       stringsList.add(new DummyConfigElement("chatColorPicker", "c", ConfigGuiType.COLOR, "fml.config.sample.chatColorPicker", new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }));
/*  72 */       stringsList.add(new DummyConfigElement("modIDSelector", "FML", ConfigGuiType.MOD_ID, "fml.config.sample.modIDSelector"));
/*     */       
/*  74 */       list.add(new DummyConfigElement.DummyCategoryElement("strings", "fml.config.sample.ctgy.strings", stringsList));
/*     */ 
/*     */       
/*  77 */       numbersList.add(new DummyConfigElement("basicInteger", Integer.valueOf(42), ConfigGuiType.INTEGER, "fml.config.sample.basicInteger"));
/*  78 */       numbersList.add(new DummyConfigElement("boundedInteger", Integer.valueOf(42), ConfigGuiType.INTEGER, "fml.config.sample.boundedInteger", Integer.valueOf(-1), Integer.valueOf(256)));
/*  79 */       numbersList.add((new DummyConfigElement("sliderInteger", Integer.valueOf(2000), ConfigGuiType.INTEGER, "fml.config.sample.sliderInteger", Integer.valueOf(100), Integer.valueOf(10000))).setCustomListEntryClass(GuiConfigEntries.NumberSliderEntry.class));
/*  80 */       numbersList.add(new DummyConfigElement("basicDouble", Double.valueOf(42.4242D), ConfigGuiType.DOUBLE, "fml.config.sample.basicDouble"));
/*  81 */       numbersList.add(new DummyConfigElement("boundedDouble", Double.valueOf(42.4242D), ConfigGuiType.DOUBLE, "fml.config.sample.boundedDouble", Double.valueOf(-1.0D), Double.valueOf(256.256D)));
/*  82 */       numbersList.add((new DummyConfigElement("sliderDouble", Double.valueOf(42.4242D), ConfigGuiType.DOUBLE, "fml.config.sample.sliderDouble", Double.valueOf(-1.0D), Double.valueOf(256.256D))).setCustomListEntryClass(GuiConfigEntries.NumberSliderEntry.class));
/*     */       
/*  84 */       list.add(new DummyConfigElement.DummyCategoryElement("numbers", "fml.config.sample.ctgy.numbers", numbersList));
/*     */       
/*  86 */       return list;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize(Minecraft minecraftInstance) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<? extends GuiScreen> mainConfigGuiClass() {
/*  98 */     return (Class)FMLConfigGuiScreen.class;
/*     */   }
/*     */   
/* 101 */   private static final Set<IModGuiFactory.RuntimeOptionCategoryElement> fmlCategories = (Set<IModGuiFactory.RuntimeOptionCategoryElement>)ImmutableSet.of(new IModGuiFactory.RuntimeOptionCategoryElement("HELP", "FML"));
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
/* 106 */     return fmlCategories;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
/* 112 */     return new IModGuiFactory.RuntimeOptionGuiHandler()
/*     */       {
/*     */         public void paint(int x, int y, int w, int h) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void addWidgets(List<Gui> widgets, int x, int y, int w, int h) {
/* 128 */           widgets.add(new GuiButton(100, x + 10, y + 10, "HELLO"));
/*     */         }
/*     */         
/*     */         public void actionCallback(int actionId) {}
/*     */       };
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\FMLConfigGuiFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */