/*     */ package net.minecraftforge.client.gui;
/*     */ 
/*     */ import cpw.mods.fml.client.IModGuiFactory;
/*     */ import cpw.mods.fml.client.config.ConfigGuiType;
/*     */ import cpw.mods.fml.client.config.DummyConfigElement;
/*     */ import cpw.mods.fml.client.config.GuiConfig;
/*     */ import cpw.mods.fml.client.config.GuiConfigEntries;
/*     */ import cpw.mods.fml.client.config.IConfigElement;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraftforge.common.ForgeChunkManager;
/*     */ import net.minecraftforge.common.ForgeModContainer;
/*     */ import net.minecraftforge.common.config.ConfigCategory;
/*     */ import net.minecraftforge.common.config.ConfigElement;
/*     */ import net.minecraftforge.common.config.Property;
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
/*     */ public class ForgeGuiFactory
/*     */   implements IModGuiFactory
/*     */ {
/*     */   public void initialize(Minecraft minecraftInstance) {}
/*     */   
/*     */   public Class<? extends GuiScreen> mainConfigGuiClass() {
/*  92 */     return (Class)ForgeConfigGui.class;
/*     */   }
/*     */   public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
/*  95 */     return null;
/*     */   }
/*     */   public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   public static class ForgeConfigGui
/*     */     extends GuiConfig {
/*     */     public ForgeConfigGui(GuiScreen parentScreen) {
/* 104 */       super(parentScreen, getConfigElements(), "Forge", false, false, I18n.format("forge.configgui.forgeConfigTitle", new Object[0]));
/*     */     }
/*     */ 
/*     */     
/*     */     private static List<IConfigElement> getConfigElements() {
/* 109 */       List<IConfigElement> list = new ArrayList<IConfigElement>();
/* 110 */       list.add(new DummyConfigElement.DummyCategoryElement("forgeCfg", "forge.configgui.ctgy.forgeGeneralConfig", GeneralEntry.class));
/* 111 */       list.add(new DummyConfigElement.DummyCategoryElement("forgeChunkLoadingCfg", "forge.configgui.ctgy.forgeChunkLoadingConfig", ChunkLoaderEntry.class));
/* 112 */       return list;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class GeneralEntry
/*     */       extends GuiConfigEntries.CategoryEntry
/*     */     {
/*     */       public GeneralEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
/* 123 */         super(owningScreen, owningEntryList, prop);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected GuiScreen buildChildScreen() {
/* 131 */         return (GuiScreen)new GuiConfig((GuiScreen)this.owningScreen, (new ConfigElement(
/* 132 */               ForgeModContainer.getConfig().getCategory("general"))).getChildElements(), this.owningScreen.modID, "general", (this.configElement
/* 133 */             .requiresWorldRestart() || this.owningScreen.allRequireWorldRestart), (this.configElement
/* 134 */             .requiresMcRestart() || this.owningScreen.allRequireMcRestart), 
/* 135 */             GuiConfig.getAbridgedConfigPath(ForgeModContainer.getConfig().toString()));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ChunkLoaderEntry
/*     */       extends GuiConfigEntries.CategoryEntry
/*     */     {
/*     */       public ChunkLoaderEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
/* 147 */         super(owningScreen, owningEntryList, prop);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected GuiScreen buildChildScreen() {
/* 153 */         List<IConfigElement> list = new ArrayList<IConfigElement>();
/*     */         
/* 155 */         list.add(new DummyConfigElement.DummyCategoryElement("forgeChunkLoadingModCfg", "forge.configgui.ctgy.forgeChunkLoadingModConfig", ForgeGuiFactory.ForgeConfigGui.ModOverridesEntry.class));
/*     */         
/* 157 */         list.addAll((new ConfigElement(ForgeChunkManager.getDefaultsCategory())).getChildElements());
/*     */ 
/*     */ 
/*     */         
/* 161 */         return (GuiScreen)new GuiConfig((GuiScreen)this.owningScreen, list, this.owningScreen.modID, "chunkLoader", (this.configElement
/* 162 */             .requiresWorldRestart() || this.owningScreen.allRequireWorldRestart), (this.configElement
/* 163 */             .requiresMcRestart() || this.owningScreen.allRequireMcRestart), 
/* 164 */             GuiConfig.getAbridgedConfigPath(ForgeChunkManager.getConfig().toString()), 
/* 165 */             I18n.format("forge.configgui.ctgy.forgeChunkLoadingConfig", new Object[0]));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ModOverridesEntry
/*     */       extends GuiConfigEntries.CategoryEntry
/*     */     {
/*     */       public ModOverridesEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
/* 178 */         super(owningScreen, owningEntryList, prop);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected GuiScreen buildChildScreen() {
/* 187 */         List<IConfigElement> list = new ArrayList<IConfigElement>();
/*     */         
/* 189 */         list.add(new DummyConfigElement.DummyCategoryElement("addForgeChunkLoadingModCfg", "forge.configgui.ctgy.forgeChunkLoadingAddModConfig", ForgeGuiFactory.ForgeConfigGui.AddModOverrideEntry.class));
/*     */         
/* 191 */         for (ConfigCategory cc : ForgeChunkManager.getModCategories()) {
/* 192 */           list.add(new ConfigElement(cc));
/*     */         }
/* 194 */         return (GuiScreen)new GuiConfig((GuiScreen)this.owningScreen, list, this.owningScreen.modID, (this.configElement
/* 195 */             .requiresWorldRestart() || this.owningScreen.allRequireWorldRestart), (this.configElement
/* 196 */             .requiresMcRestart() || this.owningScreen.allRequireMcRestart), this.owningScreen.title, 
/* 197 */             I18n.format("forge.configgui.ctgy.forgeChunkLoadingModConfig", new Object[0]));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean enabled() {
/* 207 */         for (GuiConfigEntries.IConfigEntry entry : this.owningEntryList.listEntries) {
/*     */           
/* 209 */           if (entry.getName().equals("enabled") && entry instanceof GuiConfigEntries.BooleanEntry)
/*     */           {
/* 211 */             return Boolean.valueOf(entry.getCurrentValue().toString()).booleanValue();
/*     */           }
/*     */         } 
/*     */         
/* 215 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isChanged() {
/* 224 */         if (this.childScreen instanceof GuiConfig) {
/*     */           
/* 226 */           GuiConfig child = (GuiConfig)this.childScreen;
/* 227 */           return (child.entryList.listEntries.size() != child.initEntries.size() || child.entryList.hasChangedEntry(true));
/*     */         } 
/* 229 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void undoChanges() {
/* 239 */         if (this.childScreen instanceof GuiConfig) {
/*     */           
/* 241 */           GuiConfig child = (GuiConfig)this.childScreen;
/* 242 */           for (GuiConfigEntries.IConfigEntry ice : child.entryList.listEntries) {
/* 243 */             if (!child.initEntries.contains(ice) && ForgeChunkManager.getConfig().hasCategory(ice.getName()))
/* 244 */               ForgeChunkManager.getConfig().removeCategory(ForgeChunkManager.getConfig().getCategory(ice.getName())); 
/*     */           } 
/* 246 */           child.entryList.listEntries = new ArrayList(child.initEntries);
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class AddModOverrideEntry
/*     */       extends GuiConfigEntries.CategoryEntry
/*     */     {
/*     */       public AddModOverrideEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
/* 258 */         super(owningScreen, owningEntryList, prop);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected GuiScreen buildChildScreen() {
/* 264 */         List<IConfigElement> list = new ArrayList<IConfigElement>();
/*     */         
/* 266 */         list.add((new DummyConfigElement("modID", "", ConfigGuiType.STRING, "forge.configgui.modID")).setCustomListEntryClass(ForgeGuiFactory.ForgeConfigGui.ModIDEntry.class));
/* 267 */         list.add(new ConfigElement(new Property("maximumTicketCount", "200", Property.Type.INTEGER, "forge.configgui.maximumTicketCount")));
/* 268 */         list.add(new ConfigElement(new Property("maximumChunksPerTicket", "25", Property.Type.INTEGER, "forge.configgui.maximumChunksPerTicket")));
/*     */         
/* 270 */         return (GuiScreen)new GuiConfig((GuiScreen)this.owningScreen, list, this.owningScreen.modID, (this.configElement
/* 271 */             .requiresWorldRestart() || this.owningScreen.allRequireWorldRestart), (this.configElement
/* 272 */             .requiresMcRestart() || this.owningScreen.allRequireMcRestart), this.owningScreen.title, 
/* 273 */             I18n.format("forge.configgui.ctgy.forgeChunkLoadingAddModConfig", new Object[0]));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean isChanged() {
/* 279 */         return false;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ModIDEntry
/*     */       extends GuiConfigEntries.SelectValueEntry
/*     */     {
/*     */       public ModIDEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
/* 291 */         super(owningScreen, owningEntryList, prop, getSelectableValues());
/* 292 */         if (this.selectableValues.size() == 0) {
/* 293 */           this.btnValue.enabled = false;
/*     */         }
/*     */       }
/*     */       
/*     */       private static Map<Object, String> getSelectableValues() {
/* 298 */         Map<Object, String> selectableValues = new TreeMap<Object, String>();
/*     */         
/* 300 */         for (ModContainer mod : Loader.instance().getActiveModList()) {
/*     */           
/* 302 */           if (!mod.isImmutable() && mod.getMod() != null)
/* 303 */             selectableValues.put(mod.getModId(), mod.getName()); 
/*     */         } 
/* 305 */         return selectableValues;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void onGuiClosed() {
/* 315 */         Object modObject = Loader.instance().getModObjectList().get(Loader.instance().getIndexedModList().get(this.currentValue));
/* 316 */         int maxTickets = 200;
/* 317 */         int maxChunks = 25;
/* 318 */         if (modObject != null) {
/*     */           
/* 320 */           this.owningEntryList.saveConfigElements();
/* 321 */           for (IConfigElement ice : this.owningScreen.configElements) {
/* 322 */             if ("maximumTicketCount".equals(ice.getName())) {
/* 323 */               maxTickets = Integer.valueOf(ice.get().toString()).intValue(); continue;
/* 324 */             }  if ("maximumChunksPerTicket".equals(ice.getName()))
/* 325 */               maxChunks = Integer.valueOf(ice.get().toString()).intValue(); 
/*     */           } 
/* 327 */           ForgeChunkManager.addConfigProperty(modObject, "maximumTicketCount", String.valueOf(maxTickets), Property.Type.INTEGER);
/* 328 */           ForgeChunkManager.addConfigProperty(modObject, "maximumChunksPerTicket", String.valueOf(maxChunks), Property.Type.INTEGER);
/*     */           
/* 330 */           if (this.owningScreen.parentScreen instanceof GuiConfig) {
/*     */             
/* 332 */             GuiConfig superParent = (GuiConfig)this.owningScreen.parentScreen;
/* 333 */             ConfigCategory modCtgy = ForgeChunkManager.getConfigFor(modObject);
/* 334 */             modCtgy.setPropertyOrder(ForgeChunkManager.MOD_PROP_ORDER);
/* 335 */             ConfigElement modConfig = new ConfigElement(modCtgy);
/*     */             
/* 337 */             boolean found = false;
/* 338 */             for (IConfigElement ice : superParent.configElements) {
/* 339 */               if (ice.getName().equals(this.currentValue))
/* 340 */                 found = true; 
/*     */             } 
/* 342 */             if (!found) {
/* 343 */               superParent.configElements.add(modConfig);
/*     */             }
/* 345 */             superParent.needsRefresh = true;
/* 346 */             superParent.initGui();
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\gui\ForgeGuiFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */