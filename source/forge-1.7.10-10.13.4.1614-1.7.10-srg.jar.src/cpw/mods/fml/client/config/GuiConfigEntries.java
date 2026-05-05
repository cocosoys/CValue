/*      */ package cpw.mods.fml.client.config;
/*      */ 
/*      */ import cpw.mods.fml.common.FMLLog;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.common.ModContainer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.gui.GuiListExtended;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.gui.GuiTextField;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.resources.I18n;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class GuiConfigEntries
/*      */   extends GuiListExtended
/*      */ {
/*      */   public final GuiConfig owningScreen;
/*      */   public final Minecraft mc;
/*      */   public List<IConfigEntry> listEntries;
/*   52 */   public int maxLabelTextWidth = 0;
/*      */ 
/*      */ 
/*      */   
/*   56 */   public int maxEntryRightBound = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public int labelX;
/*      */ 
/*      */ 
/*      */   
/*      */   public int controlX;
/*      */ 
/*      */ 
/*      */   
/*      */   public int controlWidth;
/*      */ 
/*      */ 
/*      */   
/*      */   public int resetX;
/*      */ 
/*      */ 
/*      */   
/*      */   public int scrollBarX;
/*      */ 
/*      */ 
/*      */   
/*      */   public GuiConfigEntries(GuiConfig parent, Minecraft mc) {
/*   81 */     super(mc, parent.width, parent.height, (parent.titleLine2 != null) ? 33 : 23, parent.height - 32, 20);
/*   82 */     this.owningScreen = parent;
/*   83 */     setShowSelectionBox(false);
/*   84 */     this.mc = mc;
/*   85 */     this.listEntries = new ArrayList<IConfigEntry>();
/*      */ 
/*      */ 
/*      */     
/*   89 */     for (IConfigElement configElement : parent.configElements) {
/*      */       
/*   91 */       if (configElement != null)
/*      */       {
/*   93 */         if (configElement.isProperty() && configElement.showInGui()) {
/*      */           int length;
/*      */ 
/*      */ 
/*      */           
/*   98 */           if (!I18n.format(configElement.getLanguageKey(), new Object[0]).equals(configElement.getLanguageKey())) {
/*   99 */             length = mc.fontRenderer.getStringWidth(I18n.format(configElement.getLanguageKey(), new Object[0]));
/*      */           } else {
/*  101 */             length = mc.fontRenderer.getStringWidth(configElement.getName());
/*      */           } 
/*  103 */           if (length > this.maxLabelTextWidth) {
/*  104 */             this.maxLabelTextWidth = length;
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*  109 */     int viewWidth = this.maxLabelTextWidth + 8 + this.width / 2;
/*  110 */     this.labelX = this.width / 2 - viewWidth / 2;
/*  111 */     this.controlX = this.labelX + this.maxLabelTextWidth + 8;
/*  112 */     this.resetX = this.width / 2 + viewWidth / 2 - 45;
/*  113 */     this.controlWidth = this.resetX - this.controlX - 5;
/*  114 */     this.scrollBarX = this.width;
/*      */     
/*  116 */     for (IConfigElement<String> configElement : parent.configElements) {
/*      */       
/*  118 */       if (configElement != null && configElement.showInGui()) {
/*      */         
/*  120 */         if (configElement.getConfigEntryClass() != null) {
/*      */           
/*      */           try {
/*  123 */             this.listEntries.add(configElement.getConfigEntryClass()
/*  124 */                 .getConstructor(new Class[] { GuiConfig.class, GuiConfigEntries.class, IConfigElement.class
/*  125 */                   }).newInstance(new Object[] { this.owningScreen, this, configElement }));
/*      */           }
/*  127 */           catch (Throwable e) {
/*      */             
/*  129 */             FMLLog.severe("There was a critical error instantiating the custom IConfigEntry for config element %s.", new Object[] { configElement.getName() });
/*  130 */             e.printStackTrace();
/*      */           }  continue;
/*  132 */         }  if (configElement.isProperty()) {
/*      */           
/*  134 */           if (configElement.isList()) {
/*  135 */             this.listEntries.add(new ArrayEntry(this.owningScreen, this, configElement)); continue;
/*  136 */           }  if (configElement.getType() == ConfigGuiType.BOOLEAN) {
/*  137 */             this.listEntries.add(new BooleanEntry(this.owningScreen, this, configElement)); continue;
/*  138 */           }  if (configElement.getType() == ConfigGuiType.INTEGER) {
/*  139 */             this.listEntries.add(new IntegerEntry(this.owningScreen, this, configElement)); continue;
/*  140 */           }  if (configElement.getType() == ConfigGuiType.DOUBLE) {
/*  141 */             this.listEntries.add(new DoubleEntry(this.owningScreen, this, configElement)); continue;
/*  142 */           }  if (configElement.getType() == ConfigGuiType.COLOR) {
/*      */             
/*  144 */             if (configElement.getValidValues() != null && (configElement.getValidValues()).length > 0) {
/*  145 */               this.listEntries.add(new ChatColorEntry(this.owningScreen, this, configElement)); continue;
/*      */             } 
/*  147 */             this.listEntries.add(new StringEntry(this.owningScreen, this, configElement)); continue;
/*      */           } 
/*  149 */           if (configElement.getType() == ConfigGuiType.MOD_ID) {
/*      */             
/*  151 */             Map<Object, String> values = new TreeMap<Object, String>();
/*  152 */             for (ModContainer mod : Loader.instance().getActiveModList())
/*  153 */               values.put(mod.getModId(), mod.getName()); 
/*  154 */             values.put("minecraft", "Minecraft");
/*  155 */             this.listEntries.add(new SelectValueEntry(this.owningScreen, this, configElement, values)); continue;
/*      */           } 
/*  157 */           if (configElement.getType() == ConfigGuiType.STRING) {
/*      */             
/*  159 */             if (configElement.getValidValues() != null && (configElement.getValidValues()).length > 0) {
/*  160 */               this.listEntries.add(new CycleValueEntry(this.owningScreen, this, configElement)); continue;
/*      */             } 
/*  162 */             this.listEntries.add(new StringEntry(this.owningScreen, this, configElement));
/*      */           }  continue;
/*      */         } 
/*  165 */         if (configElement.getType() == ConfigGuiType.CONFIG_CATEGORY) {
/*  166 */           this.listEntries.add(new CategoryEntry(this.owningScreen, this, configElement));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void initGui() {
/*  174 */     this.width = this.owningScreen.width;
/*  175 */     this.height = this.owningScreen.height;
/*      */     
/*  177 */     this.maxLabelTextWidth = 0;
/*  178 */     for (IConfigEntry entry : this.listEntries) {
/*  179 */       if (entry.getLabelWidth() > this.maxLabelTextWidth)
/*  180 */         this.maxLabelTextWidth = entry.getLabelWidth(); 
/*      */     } 
/*  182 */     this.top = (this.owningScreen.titleLine2 != null) ? 33 : 23;
/*  183 */     this.bottom = this.owningScreen.height - 32;
/*  184 */     this.left = 0;
/*  185 */     this.right = this.width;
/*  186 */     int viewWidth = this.maxLabelTextWidth + 8 + this.width / 2;
/*  187 */     this.labelX = this.width / 2 - viewWidth / 2;
/*  188 */     this.controlX = this.labelX + this.maxLabelTextWidth + 8;
/*  189 */     this.resetX = this.width / 2 + viewWidth / 2 - 45;
/*      */     
/*  191 */     this.maxEntryRightBound = 0;
/*  192 */     for (IConfigEntry entry : this.listEntries) {
/*  193 */       if (entry.getEntryRightBound() > this.maxEntryRightBound)
/*  194 */         this.maxEntryRightBound = entry.getEntryRightBound(); 
/*      */     } 
/*  196 */     this.scrollBarX = this.maxEntryRightBound + 5;
/*  197 */     this.controlWidth = this.maxEntryRightBound - this.controlX - 45;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSize() {
/*  203 */     return this.listEntries.size();
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
/*      */   public IConfigEntry getListEntry(int index) {
/*  216 */     return this.listEntries.get(index);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getScrollBarX() {
/*  222 */     return this.scrollBarX;
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
/*      */   public int getListWidth() {
/*  234 */     return this.owningScreen.width;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void keyTyped(char eventChar, int eventKey) {
/*  243 */     for (IConfigEntry entry : this.listEntries) {
/*  244 */       entry.keyTyped(eventChar, eventKey);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateScreen() {
/*  254 */     for (IConfigEntry entry : this.listEntries) {
/*  255 */       entry.updateCursorCounter();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mouseClicked(int mouseX, int mouseY, int mouseEvent) {
/*  265 */     for (IConfigEntry entry : this.listEntries) {
/*  266 */       entry.mouseClicked(mouseX, mouseY, mouseEvent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onGuiClosed() {
/*  275 */     for (IConfigEntry entry : this.listEntries) {
/*  276 */       entry.onGuiClosed();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean saveConfigElements() {
/*  286 */     boolean requiresRestart = false;
/*  287 */     for (IConfigEntry entry : this.listEntries) {
/*  288 */       if (entry.saveConfigElement())
/*  289 */         requiresRestart = true; 
/*      */     } 
/*  291 */     return requiresRestart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean areAllEntriesDefault(boolean includeChildren) {
/*  301 */     for (IConfigEntry entry : this.listEntries) {
/*  302 */       if ((includeChildren || !(entry instanceof CategoryEntry)) && !entry.isDefault())
/*  303 */         return false; 
/*      */     } 
/*  305 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAllToDefault(boolean includeChildren) {
/*  315 */     for (IConfigEntry entry : this.listEntries) {
/*  316 */       if (includeChildren || !(entry instanceof CategoryEntry)) {
/*  317 */         entry.setToDefault();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasChangedEntry(boolean includeChildren) {
/*  327 */     for (IConfigEntry entry : this.listEntries) {
/*  328 */       if ((includeChildren || !(entry instanceof CategoryEntry)) && entry.isChanged())
/*  329 */         return true; 
/*      */     } 
/*  331 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean areAnyEntriesEnabled(boolean includeChildren) {
/*  341 */     for (IConfigEntry entry : this.listEntries) {
/*  342 */       if ((includeChildren || !(entry instanceof CategoryEntry)) && entry.enabled())
/*  343 */         return true; 
/*      */     } 
/*  345 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void undoAllChanges(boolean includeChildren) {
/*  355 */     for (IConfigEntry entry : this.listEntries) {
/*  356 */       if (includeChildren || !(entry instanceof CategoryEntry)) {
/*  357 */         entry.undoChanges();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void drawScreenPost(int mouseX, int mouseY, float partialTicks) {
/*  367 */     for (IConfigEntry entry : this.listEntries) {
/*  368 */       entry.drawToolTip(mouseX, mouseY);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class BooleanEntry
/*      */     extends ButtonEntry
/*      */   {
/*      */     protected final boolean beforeValue;
/*      */     
/*      */     protected boolean currentValue;
/*      */ 
/*      */     
/*      */     private BooleanEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<Boolean> configElement) {
/*  383 */       super(owningScreen, owningEntryList, configElement);
/*  384 */       this.beforeValue = Boolean.valueOf(configElement.get().toString()).booleanValue();
/*  385 */       this.currentValue = this.beforeValue;
/*  386 */       this.btnValue.enabled = enabled();
/*  387 */       updateValueButtonText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  393 */       this.btnValue.displayString = I18n.format(String.valueOf(this.currentValue), new Object[0]);
/*  394 */       this.btnValue.packedFGColour = this.currentValue ? GuiUtils.getColorCode('2', true) : GuiUtils.getColorCode('4', true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void valueButtonPressed(int slotIndex) {
/*  400 */       if (enabled()) {
/*  401 */         this.currentValue = !this.currentValue;
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/*  407 */       return (this.currentValue == Boolean.valueOf(this.configElement.getDefault().toString()).booleanValue());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/*  413 */       if (enabled()) {
/*      */         
/*  415 */         this.currentValue = Boolean.valueOf(this.configElement.getDefault().toString()).booleanValue();
/*  416 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*  423 */       return (this.currentValue != this.beforeValue);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/*  429 */       if (enabled()) {
/*      */         
/*  431 */         this.currentValue = this.beforeValue;
/*  432 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/*  440 */       if (enabled() && isChanged()) {
/*      */         
/*  442 */         this.configElement.set(Boolean.valueOf(this.currentValue));
/*  443 */         return this.configElement.requiresMcRestart();
/*      */       } 
/*  445 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Boolean getCurrentValue() {
/*  451 */       return Boolean.valueOf(this.currentValue);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Boolean[] getCurrentValues() {
/*  457 */       return new Boolean[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CycleValueEntry
/*      */     extends ButtonEntry
/*      */   {
/*      */     protected final int beforeIndex;
/*      */ 
/*      */     
/*      */     protected final int defaultIndex;
/*      */     
/*      */     protected int currentIndex;
/*      */ 
/*      */     
/*      */     private CycleValueEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<String> configElement) {
/*  475 */       super(owningScreen, owningEntryList, configElement);
/*  476 */       this.beforeIndex = getIndex(configElement.get().toString());
/*  477 */       this.defaultIndex = getIndex(configElement.getDefault().toString());
/*  478 */       this.currentIndex = this.beforeIndex;
/*  479 */       this.btnValue.enabled = enabled();
/*  480 */       updateValueButtonText();
/*      */     }
/*      */ 
/*      */     
/*      */     private int getIndex(String s) {
/*  485 */       for (int i = 0; i < (this.configElement.getValidValues()).length; i++) {
/*  486 */         if (this.configElement.getValidValues()[i].equalsIgnoreCase(s))
/*      */         {
/*  488 */           return i;
/*      */         }
/*      */       } 
/*  491 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  497 */       this.btnValue.displayString = I18n.format(this.configElement.getValidValues()[this.currentIndex], new Object[0]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void valueButtonPressed(int slotIndex) {
/*  503 */       if (enabled()) {
/*      */         
/*  505 */         if (++this.currentIndex >= (this.configElement.getValidValues()).length) {
/*  506 */           this.currentIndex = 0;
/*      */         }
/*  508 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/*  515 */       return (this.currentIndex == this.defaultIndex);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/*  521 */       if (enabled()) {
/*      */         
/*  523 */         this.currentIndex = this.defaultIndex;
/*  524 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*  531 */       return (this.currentIndex != this.beforeIndex);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/*  537 */       if (enabled()) {
/*      */         
/*  539 */         this.currentIndex = this.beforeIndex;
/*  540 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/*  548 */       if (enabled() && isChanged()) {
/*      */         
/*  550 */         this.configElement.set(this.configElement.getValidValues()[this.currentIndex]);
/*  551 */         return this.configElement.requiresMcRestart();
/*      */       } 
/*  553 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getCurrentValue() {
/*  559 */       return this.configElement.getValidValues()[this.currentIndex];
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String[] getCurrentValues() {
/*  565 */       return new String[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ChatColorEntry
/*      */     extends CycleValueEntry
/*      */   {
/*      */     ChatColorEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<String> configElement) {
/*  578 */       super(owningScreen, owningEntryList, configElement);
/*  579 */       this.btnValue.enabled = enabled();
/*  580 */       updateValueButtonText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/*  586 */       this.btnValue.packedFGColour = GuiUtils.getColorCode(this.configElement.getValidValues()[this.currentIndex].charAt(0), true);
/*  587 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  593 */       this.btnValue.displayString = I18n.format(this.configElement.getValidValues()[this.currentIndex], new Object[0]) + " - " + I18n.format("fml.configgui.sampletext", new Object[0]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SelectValueEntry
/*      */     extends ButtonEntry
/*      */   {
/*      */     protected final String beforeValue;
/*      */ 
/*      */     
/*      */     protected Object currentValue;
/*      */ 
/*      */     
/*      */     protected Map<Object, String> selectableValues;
/*      */ 
/*      */     
/*      */     public SelectValueEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<String> configElement, Map<Object, String> selectableValues) {
/*  612 */       super(owningScreen, owningEntryList, configElement);
/*  613 */       this.beforeValue = configElement.get().toString();
/*  614 */       this.currentValue = configElement.get().toString();
/*  615 */       this.selectableValues = selectableValues;
/*  616 */       updateValueButtonText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  622 */       this.btnValue.displayString = this.currentValue.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void valueButtonPressed(int slotIndex) {
/*  628 */       this.mc.displayGuiScreen(new GuiSelectString(this.owningScreen, this.configElement, slotIndex, this.selectableValues, this.currentValue, enabled()));
/*      */     }
/*      */ 
/*      */     
/*      */     public void setValueFromChildScreen(Object newValue) {
/*  633 */       if (enabled() ? ((this.currentValue != null) ? !this.currentValue.equals(newValue) : (newValue != null)) : (newValue != null)) {
/*      */         
/*  635 */         this.currentValue = newValue;
/*  636 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/*  643 */       if (this.configElement.getDefault() != null) {
/*  644 */         return this.configElement.getDefault().equals(this.currentValue);
/*      */       }
/*  646 */       return (this.currentValue == null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/*  652 */       if (enabled()) {
/*      */         
/*  654 */         this.currentValue = this.configElement.getDefault().toString();
/*  655 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*  662 */       if (this.beforeValue != null) {
/*  663 */         return !this.beforeValue.equals(this.currentValue);
/*      */       }
/*  665 */       return (this.currentValue == null);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/*  671 */       if (enabled()) {
/*      */         
/*  673 */         this.currentValue = this.beforeValue;
/*  674 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/*  682 */       if (enabled() && isChanged()) {
/*      */         
/*  684 */         this.configElement.set(this.currentValue);
/*  685 */         return this.configElement.requiresMcRestart();
/*      */       } 
/*  687 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getCurrentValue() {
/*  693 */       return this.currentValue.toString();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String[] getCurrentValues() {
/*  699 */       return new String[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ArrayEntry
/*      */     extends ButtonEntry
/*      */   {
/*      */     protected final Object[] beforeValues;
/*      */ 
/*      */     
/*      */     protected Object[] currentValues;
/*      */ 
/*      */ 
/*      */     
/*      */     public ArrayEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/*  717 */       super(owningScreen, owningEntryList, configElement);
/*  718 */       this.beforeValues = configElement.getList();
/*  719 */       this.currentValues = configElement.getList();
/*  720 */       updateValueButtonText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  726 */       this.btnValue.displayString = "";
/*  727 */       for (Object o : this.currentValues) {
/*  728 */         this.btnValue.displayString += ", [" + o + "]";
/*      */       }
/*  730 */       this.btnValue.displayString = this.btnValue.displayString.replaceFirst(", ", "");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void valueButtonPressed(int slotIndex) {
/*  736 */       this.mc.displayGuiScreen(new GuiEditArray(this.owningScreen, this.configElement, slotIndex, this.currentValues, enabled()));
/*      */     }
/*      */ 
/*      */     
/*      */     public void setListFromChildScreen(Object[] newList) {
/*  741 */       if (enabled() && !Arrays.deepEquals(this.currentValues, newList)) {
/*      */         
/*  743 */         this.currentValues = newList;
/*  744 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/*  751 */       return Arrays.deepEquals(this.configElement.getDefaults(), this.currentValues);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/*  757 */       if (enabled()) {
/*      */         
/*  759 */         this.currentValues = this.configElement.getDefaults();
/*  760 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*  767 */       return !Arrays.deepEquals(this.beforeValues, this.currentValues);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/*  773 */       if (enabled()) {
/*      */         
/*  775 */         this.currentValues = this.beforeValues;
/*  776 */         updateValueButtonText();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/*  784 */       if (enabled() && isChanged()) {
/*      */         
/*  786 */         this.configElement.set(this.currentValues);
/*  787 */         return this.configElement.requiresMcRestart();
/*      */       } 
/*  789 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getCurrentValue() {
/*  795 */       return this.btnValue.displayString;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object[] getCurrentValues() {
/*  801 */       return this.currentValues;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class NumberSliderEntry
/*      */     extends ButtonEntry
/*      */   {
/*      */     protected final double beforeValue;
/*      */ 
/*      */ 
/*      */     
/*      */     public NumberSliderEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/*  816 */       super(owningScreen, owningEntryList, configElement, new GuiSlider(0, owningEntryList.controlX, 0, owningEntryList.controlWidth, 18, "", "", 
/*  817 */             Double.valueOf(configElement.getMinValue().toString()).doubleValue(), Double.valueOf(configElement.getMaxValue().toString()).doubleValue(), 
/*  818 */             Double.valueOf(configElement.get().toString()).doubleValue(), (configElement.getType() == ConfigGuiType.DOUBLE), true));
/*      */       
/*  820 */       if (configElement.getType() == ConfigGuiType.INTEGER) {
/*  821 */         this.beforeValue = Integer.valueOf(configElement.get().toString()).intValue();
/*      */       } else {
/*  823 */         this.beforeValue = Double.valueOf(configElement.get().toString()).doubleValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void updateValueButtonText() {
/*  829 */       ((GuiSlider)this.btnValue).updateSlider();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void valueButtonPressed(int slotIndex) {}
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/*  838 */       if (this.configElement.getType() == ConfigGuiType.INTEGER) {
/*  839 */         return (((GuiSlider)this.btnValue).getValueInt() == Integer.valueOf(this.configElement.getDefault().toString()).intValue());
/*      */       }
/*  841 */       return (((GuiSlider)this.btnValue).getValue() == Double.valueOf(this.configElement.getDefault().toString()).doubleValue());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/*  847 */       if (enabled()) {
/*      */         
/*  849 */         ((GuiSlider)this.btnValue).setValue(Double.valueOf(this.configElement.getDefault().toString()).doubleValue());
/*  850 */         ((GuiSlider)this.btnValue).updateSlider();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*  857 */       if (this.configElement.getType() == ConfigGuiType.INTEGER) {
/*  858 */         return (((GuiSlider)this.btnValue).getValueInt() != (int)Math.round(this.beforeValue));
/*      */       }
/*  860 */       return (((GuiSlider)this.btnValue).getValue() != this.beforeValue);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/*  866 */       if (enabled()) {
/*      */         
/*  868 */         ((GuiSlider)this.btnValue).setValue(this.beforeValue);
/*  869 */         ((GuiSlider)this.btnValue).updateSlider();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/*  877 */       if (enabled() && isChanged()) {
/*      */         
/*  879 */         if (this.configElement.getType() == ConfigGuiType.INTEGER) {
/*  880 */           this.configElement.set(Integer.valueOf(((GuiSlider)this.btnValue).getValueInt()));
/*      */         } else {
/*  882 */           this.configElement.set(Double.valueOf(((GuiSlider)this.btnValue).getValue()));
/*  883 */         }  return this.configElement.requiresMcRestart();
/*      */       } 
/*  885 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getCurrentValue() {
/*  891 */       if (this.configElement.getType() == ConfigGuiType.INTEGER) {
/*  892 */         return Integer.valueOf(((GuiSlider)this.btnValue).getValueInt());
/*      */       }
/*  894 */       return Double.valueOf(((GuiSlider)this.btnValue).getValue());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object[] getCurrentValues() {
/*  900 */       return new Object[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static abstract class ButtonEntry
/*      */     extends ListEntryBase
/*      */   {
/*      */     protected final GuiButtonExt btnValue;
/*      */ 
/*      */ 
/*      */     
/*      */     public ButtonEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/*  915 */       this(owningScreen, owningEntryList, configElement, new GuiButtonExt(0, owningEntryList.controlX, 0, owningEntryList.controlWidth, 18, 
/*  916 */             (configElement.get() != null) ? I18n.format(String.valueOf(configElement.get()), new Object[0]) : ""));
/*      */     }
/*      */ 
/*      */     
/*      */     public ButtonEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement, GuiButtonExt button) {
/*  921 */       super(owningScreen, owningEntryList, configElement);
/*  922 */       this.btnValue = button;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract void updateValueButtonText();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract void valueButtonPressed(int param1Int);
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/*  938 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/*  939 */       this.btnValue.width = this.owningEntryList.controlWidth;
/*  940 */       this.btnValue.xPosition = this.owningScreen.entryList.controlX;
/*  941 */       this.btnValue.yPosition = y;
/*  942 */       this.btnValue.enabled = enabled();
/*  943 */       this.btnValue.drawButton(this.mc, mouseX, mouseY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/*  955 */       if (this.btnValue.mousePressed(this.mc, x, y)) {
/*      */         
/*  957 */         this.btnValue.func_146113_a(this.mc.getSoundHandler());
/*  958 */         valueButtonPressed(index);
/*  959 */         updateValueButtonText();
/*  960 */         return true;
/*      */       } 
/*      */       
/*  963 */       return super.mousePressed(index, x, y, mouseEvent, relativeX, relativeY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/*  975 */       super.mouseReleased(index, x, y, mouseEvent, relativeX, relativeY);
/*  976 */       this.btnValue.mouseReleased(x, y);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyTyped(char eventChar, int eventKey) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateCursorCounter() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseClicked(int x, int y, int mouseEvent) {}
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class IntegerEntry
/*      */     extends StringEntry
/*      */   {
/*      */     protected final int beforeValue;
/*      */ 
/*      */ 
/*      */     
/*      */     public IntegerEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/* 1004 */       super(owningScreen, owningEntryList, configElement);
/* 1005 */       this.beforeValue = Integer.valueOf(configElement.get().toString()).intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyTyped(char eventChar, int eventKey) {
/* 1011 */       if (enabled() || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*      */         
/* 1013 */         String validChars = "0123456789";
/* 1014 */         String before = this.textFieldValue.getText();
/* 1015 */         if (validChars.contains(String.valueOf(eventChar)) || (
/* 1016 */           !before.startsWith("-") && this.textFieldValue.getCursorPosition() == 0 && eventChar == '-') || eventKey == 14 || eventKey == 211 || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207)
/*      */         {
/*      */           
/* 1019 */           this.textFieldValue.textboxKeyTyped(enabled() ? eventChar : Character.MIN_VALUE, eventKey);
/*      */         }
/* 1021 */         if (!this.textFieldValue.getText().trim().isEmpty() && !this.textFieldValue.getText().trim().equals("-")) {
/*      */ 
/*      */           
/*      */           try {
/* 1025 */             long value = Long.parseLong(this.textFieldValue.getText().trim());
/* 1026 */             if (value < Integer.valueOf(this.configElement.getMinValue().toString()).intValue() || value > Integer.valueOf(this.configElement.getMaxValue().toString()).intValue()) {
/* 1027 */               this.isValidValue = false;
/*      */             } else {
/* 1029 */               this.isValidValue = true;
/*      */             } 
/* 1031 */           } catch (Throwable e) {
/*      */             
/* 1033 */             this.isValidValue = false;
/*      */           } 
/*      */         } else {
/*      */           
/* 1037 */           this.isValidValue = false;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*      */       try {
/* 1046 */         return (this.beforeValue != Integer.parseInt(this.textFieldValue.getText().trim()));
/*      */       }
/* 1048 */       catch (Throwable e) {
/*      */         
/* 1050 */         return true;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/* 1057 */       if (enabled()) {
/* 1058 */         this.textFieldValue.setText(String.valueOf(this.beforeValue));
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/* 1065 */       if (enabled()) {
/*      */         
/* 1067 */         if (isChanged() && this.isValidValue) {
/*      */           
/*      */           try {
/* 1070 */             int value = Integer.parseInt(this.textFieldValue.getText().trim());
/* 1071 */             this.configElement.set(Integer.valueOf(value));
/* 1072 */             return this.configElement.requiresMcRestart();
/*      */           }
/* 1074 */           catch (Throwable e) {
/*      */             
/* 1076 */             this.configElement.setToDefault();
/*      */           } 
/* 1078 */         } else if (isChanged() && !this.isValidValue) {
/*      */           
/*      */           try {
/* 1081 */             int value = Integer.parseInt(this.textFieldValue.getText().trim());
/* 1082 */             if (value < Integer.valueOf(this.configElement.getMinValue().toString()).intValue()) {
/* 1083 */               this.configElement.set(this.configElement.getMinValue());
/*      */             } else {
/* 1085 */               this.configElement.set(this.configElement.getMaxValue());
/*      */             }
/*      */           
/* 1088 */           } catch (Throwable e) {
/*      */             
/* 1090 */             this.configElement.setToDefault();
/*      */           } 
/*      */         } 
/* 1093 */         return (this.configElement.requiresMcRestart() && this.beforeValue != Integer.parseInt(this.configElement.get().toString()));
/*      */       } 
/* 1095 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DoubleEntry
/*      */     extends StringEntry
/*      */   {
/*      */     protected final double beforeValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public DoubleEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/* 1111 */       super(owningScreen, owningEntryList, configElement);
/* 1112 */       this.beforeValue = Double.valueOf(configElement.get().toString()).doubleValue();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyTyped(char eventChar, int eventKey) {
/* 1118 */       if (enabled() || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*      */         
/* 1120 */         String validChars = "0123456789";
/* 1121 */         String before = this.textFieldValue.getText();
/* 1122 */         if (validChars.contains(String.valueOf(eventChar)) || (
/* 1123 */           !before.startsWith("-") && this.textFieldValue.getCursorPosition() == 0 && eventChar == '-') || (
/* 1124 */           !before.contains(".") && eventChar == '.') || eventKey == 14 || eventKey == 211 || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207)
/*      */         {
/*      */           
/* 1127 */           this.textFieldValue.textboxKeyTyped(enabled() ? eventChar : Character.MIN_VALUE, eventKey);
/*      */         }
/* 1129 */         if (!this.textFieldValue.getText().trim().isEmpty() && !this.textFieldValue.getText().trim().equals("-")) {
/*      */ 
/*      */           
/*      */           try {
/* 1133 */             double value = Double.parseDouble(this.textFieldValue.getText().trim());
/* 1134 */             if (value < Double.valueOf(this.configElement.getMinValue().toString()).doubleValue() || value > Double.valueOf(this.configElement.getMaxValue().toString()).doubleValue()) {
/* 1135 */               this.isValidValue = false;
/*      */             } else {
/* 1137 */               this.isValidValue = true;
/*      */             } 
/* 1139 */           } catch (Throwable e) {
/*      */             
/* 1141 */             this.isValidValue = false;
/*      */           } 
/*      */         } else {
/*      */           
/* 1145 */           this.isValidValue = false;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/*      */       try {
/* 1154 */         return (this.beforeValue != Double.parseDouble(this.textFieldValue.getText().trim()));
/*      */       }
/* 1156 */       catch (Throwable e) {
/*      */         
/* 1158 */         return true;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/* 1165 */       if (enabled()) {
/* 1166 */         this.textFieldValue.setText(String.valueOf(this.beforeValue));
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/* 1173 */       if (enabled()) {
/*      */         
/* 1175 */         if (isChanged() && this.isValidValue) {
/*      */           
/*      */           try {
/* 1178 */             double value = Double.parseDouble(this.textFieldValue.getText().trim());
/* 1179 */             this.configElement.set(Double.valueOf(value));
/* 1180 */             return this.configElement.requiresMcRestart();
/*      */           }
/* 1182 */           catch (Throwable e) {
/*      */             
/* 1184 */             this.configElement.setToDefault();
/*      */           } 
/* 1186 */         } else if (isChanged() && !this.isValidValue) {
/*      */           
/*      */           try {
/* 1189 */             double value = Double.parseDouble(this.textFieldValue.getText().trim());
/* 1190 */             if (value < Double.valueOf(this.configElement.getMinValue().toString()).doubleValue()) {
/* 1191 */               this.configElement.set(this.configElement.getMinValue());
/*      */             } else {
/* 1193 */               this.configElement.set(this.configElement.getMaxValue());
/*      */             } 
/* 1195 */           } catch (Throwable e) {
/*      */             
/* 1197 */             this.configElement.setToDefault();
/*      */           } 
/*      */         } 
/* 1200 */         return (this.configElement.requiresMcRestart() && this.beforeValue != Double.parseDouble(this.configElement.get().toString()));
/*      */       } 
/* 1202 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class StringEntry
/*      */     extends ListEntryBase
/*      */   {
/*      */     protected final GuiTextField textFieldValue;
/*      */ 
/*      */     
/*      */     protected final String beforeValue;
/*      */ 
/*      */     
/*      */     public StringEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<?> configElement) {
/* 1218 */       super(owningScreen, owningEntryList, configElement);
/* 1219 */       this.beforeValue = configElement.get().toString();
/* 1220 */       this.textFieldValue = new GuiTextField(this.mc.fontRenderer, this.owningEntryList.controlX + 1, 0, this.owningEntryList.controlWidth - 3, 16);
/* 1221 */       this.textFieldValue.setMaxStringLength(10000);
/* 1222 */       this.textFieldValue.setText(configElement.get().toString());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 1228 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/* 1229 */       this.textFieldValue.xPosition = this.owningEntryList.controlX + 2;
/* 1230 */       this.textFieldValue.yPosition = y + 1;
/* 1231 */       this.textFieldValue.width = this.owningEntryList.controlWidth - 4;
/* 1232 */       this.textFieldValue.setEnabled(enabled());
/* 1233 */       this.textFieldValue.drawTextBox();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyTyped(char eventChar, int eventKey) {
/* 1239 */       if (enabled() || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*      */         
/* 1241 */         this.textFieldValue.textboxKeyTyped(enabled() ? eventChar : Character.MIN_VALUE, eventKey);
/*      */         
/* 1243 */         if (this.configElement.getValidationPattern() != null)
/*      */         {
/* 1245 */           if (this.configElement.getValidationPattern().matcher(this.textFieldValue.getText().trim()).matches()) {
/* 1246 */             this.isValidValue = true;
/*      */           } else {
/* 1248 */             this.isValidValue = false;
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void updateCursorCounter() {
/* 1256 */       this.textFieldValue.updateCursorCounter();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseClicked(int x, int y, int mouseEvent) {
/* 1262 */       this.textFieldValue.mouseClicked(x, y, mouseEvent);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/* 1268 */       return (this.configElement.getDefault() != null) ? this.configElement.getDefault().toString().equals(this.textFieldValue.getText()) : this.textFieldValue
/* 1269 */         .getText().trim().isEmpty();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/* 1275 */       if (enabled()) {
/*      */         
/* 1277 */         this.textFieldValue.setText(this.configElement.getDefault().toString());
/* 1278 */         keyTyped(false, 199);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/* 1285 */       return (this.beforeValue != null) ? (!this.beforeValue.equals(this.textFieldValue.getText())) : this.textFieldValue.getText().trim().isEmpty();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/* 1291 */       if (enabled()) {
/* 1292 */         this.textFieldValue.setText(this.beforeValue);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/* 1299 */       if (enabled()) {
/*      */         
/* 1301 */         if (isChanged() && this.isValidValue) {
/*      */           
/* 1303 */           this.configElement.set(this.textFieldValue.getText());
/* 1304 */           return this.configElement.requiresMcRestart();
/*      */         } 
/* 1306 */         if (isChanged() && !this.isValidValue) {
/*      */           
/* 1308 */           this.configElement.setToDefault();
/* 1309 */           return (this.configElement.requiresMcRestart() && this.beforeValue != null) ? this.beforeValue
/* 1310 */             .equals(this.configElement.getDefault()) : ((this.configElement.getDefault() == null));
/*      */         } 
/*      */       } 
/* 1313 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getCurrentValue() {
/* 1319 */       return this.textFieldValue.getText();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object[] getCurrentValues() {
/* 1325 */       return new Object[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class CategoryEntry
/*      */     extends ListEntryBase
/*      */   {
/*      */     protected GuiScreen childScreen;
/*      */ 
/*      */     
/*      */     protected final GuiButtonExt btnSelectCategory;
/*      */ 
/*      */ 
/*      */     
/*      */     public CategoryEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
/* 1342 */       super(owningScreen, owningEntryList, configElement);
/*      */       
/* 1344 */       this.childScreen = buildChildScreen();
/*      */       
/* 1346 */       this.btnSelectCategory = new GuiButtonExt(0, 0, 0, 300, 18, I18n.format(this.name, new Object[0]));
/* 1347 */       this.tooltipHoverChecker = new HoverChecker(this.btnSelectCategory, 800);
/*      */       
/* 1349 */       this.drawLabel = false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected GuiScreen buildChildScreen() {
/* 1358 */       return new GuiConfig(this.owningScreen, this.configElement.getChildElements(), this.owningScreen.modID, (this.owningScreen.allRequireWorldRestart || this.configElement
/* 1359 */           .requiresWorldRestart()), (this.owningScreen.allRequireMcRestart || this.configElement
/* 1360 */           .requiresMcRestart()), this.owningScreen.title, ((this.owningScreen.titleLine2 == null) ? "" : this.owningScreen.titleLine2) + " > " + this.name);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 1367 */       this.btnSelectCategory.xPosition = listWidth / 2 - 150;
/* 1368 */       this.btnSelectCategory.yPosition = y;
/* 1369 */       this.btnSelectCategory.enabled = enabled();
/* 1370 */       this.btnSelectCategory.drawButton(this.mc, mouseX, mouseY);
/*      */       
/* 1372 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void drawToolTip(int mouseX, int mouseY) {
/* 1378 */       boolean canHover = (mouseY < this.owningScreen.entryList.bottom && mouseY > this.owningScreen.entryList.top);
/*      */       
/* 1380 */       if (this.tooltipHoverChecker.checkHover(mouseX, mouseY, canHover)) {
/* 1381 */         this.owningScreen.drawToolTip(this.toolTip, mouseX, mouseY);
/*      */       }
/* 1383 */       super.drawToolTip(mouseX, mouseY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 1392 */       if (this.btnSelectCategory.mousePressed(this.mc, x, y)) {
/*      */         
/* 1394 */         this.btnSelectCategory.func_146113_a(this.mc.getSoundHandler());
/* 1395 */         Minecraft.getMinecraft().displayGuiScreen(this.childScreen);
/* 1396 */         return true;
/*      */       } 
/*      */       
/* 1399 */       return super.mousePressed(index, x, y, mouseEvent, relativeX, relativeY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 1408 */       this.btnSelectCategory.mouseReleased(x, y);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isDefault() {
/* 1414 */       if (this.childScreen instanceof GuiConfig && ((GuiConfig)this.childScreen).entryList != null) {
/* 1415 */         return ((GuiConfig)this.childScreen).entryList.areAllEntriesDefault(true);
/*      */       }
/* 1417 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void setToDefault() {
/* 1423 */       if (this.childScreen instanceof GuiConfig && ((GuiConfig)this.childScreen).entryList != null) {
/* 1424 */         ((GuiConfig)this.childScreen).entryList.setAllToDefault(true);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void keyTyped(char eventChar, int eventKey) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void updateCursorCounter() {}
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseClicked(int x, int y, int mouseEvent) {}
/*      */ 
/*      */     
/*      */     public boolean saveConfigElement() {
/* 1442 */       boolean requiresRestart = false;
/*      */       
/* 1444 */       if (this.childScreen instanceof GuiConfig && ((GuiConfig)this.childScreen).entryList != null) {
/*      */         
/* 1446 */         requiresRestart = (this.configElement.requiresMcRestart() && ((GuiConfig)this.childScreen).entryList.hasChangedEntry(true));
/*      */         
/* 1448 */         if (((GuiConfig)this.childScreen).entryList.saveConfigElements()) {
/* 1449 */           requiresRestart = true;
/*      */         }
/*      */       } 
/* 1452 */       return requiresRestart;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isChanged() {
/* 1458 */       if (this.childScreen instanceof GuiConfig && ((GuiConfig)this.childScreen).entryList != null) {
/* 1459 */         return ((GuiConfig)this.childScreen).entryList.hasChangedEntry(true);
/*      */       }
/* 1461 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void undoChanges() {
/* 1467 */       if (this.childScreen instanceof GuiConfig && ((GuiConfig)this.childScreen).entryList != null) {
/* 1468 */         ((GuiConfig)this.childScreen).entryList.undoAllChanges(true);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean enabled() {
/* 1474 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLabelWidth() {
/* 1480 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getEntryRightBound() {
/* 1486 */       return this.owningEntryList.width / 2 + 155 + 22 + 18;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getCurrentValue() {
/* 1492 */       return "";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String[] getCurrentValues() {
/* 1498 */       return new String[] { getCurrentValue() };
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static abstract class ListEntryBase
/*      */     implements IConfigEntry
/*      */   {
/*      */     protected final GuiConfig owningScreen;
/*      */     
/*      */     protected final GuiConfigEntries owningEntryList;
/*      */     
/*      */     protected final IConfigElement configElement;
/*      */     
/*      */     protected final Minecraft mc;
/*      */     
/*      */     protected final String name;
/*      */     
/*      */     protected final GuiButtonExt btnUndoChanges;
/*      */     
/*      */     protected final GuiButtonExt btnDefault;
/*      */     protected List toolTip;
/*      */     protected List undoToolTip;
/*      */     protected List defaultToolTip;
/*      */     protected boolean isValidValue = true;
/*      */     protected HoverChecker tooltipHoverChecker;
/*      */     protected HoverChecker undoHoverChecker;
/*      */     protected HoverChecker defaultHoverChecker;
/*      */     protected boolean drawLabel;
/*      */     
/*      */     public ListEntryBase(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement<T> configElement) {
/* 1529 */       this.owningScreen = owningScreen;
/* 1530 */       this.owningEntryList = owningEntryList;
/* 1531 */       this.configElement = configElement;
/* 1532 */       this.mc = Minecraft.getMinecraft();
/* 1533 */       String trans = I18n.format(configElement.getLanguageKey(), new Object[0]);
/* 1534 */       if (!trans.equals(configElement.getLanguageKey())) {
/* 1535 */         this.name = trans;
/*      */       } else {
/* 1537 */         this.name = configElement.getName();
/* 1538 */       }  this.btnUndoChanges = new GuiButtonExt(0, 0, 0, 18, 18, "↶");
/* 1539 */       this.btnDefault = new GuiButtonExt(0, 0, 0, 18, 18, "☄");
/*      */       
/* 1541 */       this.undoHoverChecker = new HoverChecker(this.btnUndoChanges, 800);
/* 1542 */       this.defaultHoverChecker = new HoverChecker(this.btnDefault, 800);
/* 1543 */       this.undoToolTip = Arrays.asList(new String[] { I18n.format("fml.configgui.tooltip.undoChanges", new Object[0]) });
/* 1544 */       this.defaultToolTip = Arrays.asList(new String[] { I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0]) });
/*      */       
/* 1546 */       this.drawLabel = true;
/*      */ 
/*      */ 
/*      */       
/* 1550 */       String comment = I18n.format(configElement.getLanguageKey() + ".tooltip", new Object[0]).replace("\\n", "\n");
/*      */       
/* 1552 */       if (!comment.equals(configElement.getLanguageKey() + ".tooltip")) {
/* 1553 */         this.toolTip = new ArrayList(this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + this.name + "\n" + EnumChatFormatting.YELLOW + comment, 300));
/*      */       }
/* 1555 */       else if (configElement.getComment() != null && !configElement.getComment().trim().isEmpty()) {
/* 1556 */         this.toolTip = new ArrayList(this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + this.name + "\n" + EnumChatFormatting.YELLOW + configElement
/* 1557 */               .getComment(), 300));
/*      */       } else {
/* 1559 */         this.toolTip = new ArrayList(this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + this.name + "\n" + EnumChatFormatting.RED + "No tooltip defined.", 300));
/*      */       } 
/*      */       
/* 1562 */       if ((configElement.getType() == ConfigGuiType.INTEGER && (
/* 1563 */         Integer.valueOf(configElement.getMinValue().toString()).intValue() != Integer.MIN_VALUE || Integer.valueOf(configElement.getMaxValue().toString()).intValue() != Integer.MAX_VALUE)) || (configElement
/* 1564 */         .getType() == ConfigGuiType.DOUBLE && (
/* 1565 */         Double.valueOf(configElement.getMinValue().toString()).doubleValue() != -1.7976931348623157E308D || Double.valueOf(configElement.getMaxValue().toString()).doubleValue() != Double.MAX_VALUE))) {
/* 1566 */         this.toolTip.addAll(this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.AQUA + 
/* 1567 */               I18n.format("fml.configgui.tooltip.defaultNumeric", new Object[] { configElement.getMinValue(), configElement.getMaxValue(), configElement.getDefault() }), 300));
/* 1568 */       } else if (configElement.getType() != ConfigGuiType.CONFIG_CATEGORY) {
/* 1569 */         this.toolTip.addAll(this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.AQUA + I18n.format("fml.configgui.tooltip.default", new Object[] { configElement.getDefault() }), 300));
/*      */       } 
/* 1571 */       if (configElement.requiresMcRestart() || owningScreen.allRequireMcRestart) {
/* 1572 */         this.toolTip.add(EnumChatFormatting.RED + "[" + I18n.format("fml.configgui.gameRestartTitle", new Object[0]) + "]");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 1578 */       boolean isChanged = isChanged();
/*      */       
/* 1580 */       if (this.drawLabel) {
/*      */ 
/*      */ 
/*      */         
/* 1584 */         String label = (!this.isValidValue ? EnumChatFormatting.RED.toString() : (isChanged ? EnumChatFormatting.WHITE.toString() : EnumChatFormatting.GRAY.toString())) + (isChanged ? EnumChatFormatting.ITALIC.toString() : "") + this.name;
/* 1585 */         this.mc.fontRenderer.drawString(label, this.owningScreen.entryList.labelX, y + slotHeight / 2 - this.mc.fontRenderer.FONT_HEIGHT / 2, 16777215);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1592 */       this.btnUndoChanges.xPosition = this.owningEntryList.scrollBarX - 44;
/* 1593 */       this.btnUndoChanges.yPosition = y;
/* 1594 */       this.btnUndoChanges.enabled = (enabled() && isChanged);
/* 1595 */       this.btnUndoChanges.drawButton(this.mc, mouseX, mouseY);
/*      */       
/* 1597 */       this.btnDefault.xPosition = this.owningEntryList.scrollBarX - 22;
/* 1598 */       this.btnDefault.yPosition = y;
/* 1599 */       this.btnDefault.enabled = (enabled() && !isDefault());
/* 1600 */       this.btnDefault.drawButton(this.mc, mouseX, mouseY);
/*      */       
/* 1602 */       if (this.tooltipHoverChecker == null) {
/* 1603 */         this.tooltipHoverChecker = new HoverChecker(y, y + slotHeight, x, this.owningScreen.entryList.controlX - 8, 800);
/*      */       } else {
/* 1605 */         this.tooltipHoverChecker.updateBounds(y, y + slotHeight, x, this.owningScreen.entryList.controlX - 8);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void drawToolTip(int mouseX, int mouseY) {
/* 1611 */       boolean canHover = (mouseY < this.owningScreen.entryList.bottom && mouseY > this.owningScreen.entryList.top);
/* 1612 */       if (this.toolTip != null && this.tooltipHoverChecker != null)
/*      */       {
/* 1614 */         if (this.tooltipHoverChecker.checkHover(mouseX, mouseY, canHover)) {
/* 1615 */           this.owningScreen.drawToolTip(this.toolTip, mouseX, mouseY);
/*      */         }
/*      */       }
/* 1618 */       if (this.undoHoverChecker.checkHover(mouseX, mouseY, canHover)) {
/* 1619 */         this.owningScreen.drawToolTip(this.undoToolTip, mouseX, mouseY);
/*      */       }
/* 1621 */       if (this.defaultHoverChecker.checkHover(mouseX, mouseY, canHover)) {
/* 1622 */         this.owningScreen.drawToolTip(this.defaultToolTip, mouseX, mouseY);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 1631 */       if (this.btnDefault.mousePressed(this.mc, x, y)) {
/*      */         
/* 1633 */         this.btnDefault.func_146113_a(this.mc.getSoundHandler());
/* 1634 */         setToDefault();
/* 1635 */         return true;
/*      */       } 
/* 1637 */       if (this.btnUndoChanges.mousePressed(this.mc, x, y)) {
/*      */         
/* 1639 */         this.btnUndoChanges.func_146113_a(this.mc.getSoundHandler());
/* 1640 */         undoChanges();
/* 1641 */         return true;
/*      */       } 
/* 1643 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 1652 */       this.btnDefault.mouseReleased(x, y);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public abstract boolean isDefault();
/*      */ 
/*      */     
/*      */     public abstract void setToDefault();
/*      */ 
/*      */     
/*      */     public abstract void keyTyped(char param1Char, int param1Int);
/*      */ 
/*      */     
/*      */     public abstract void updateCursorCounter();
/*      */ 
/*      */     
/*      */     public abstract void mouseClicked(int param1Int1, int param1Int2, int param1Int3);
/*      */ 
/*      */     
/*      */     public abstract boolean isChanged();
/*      */ 
/*      */     
/*      */     public abstract void undoChanges();
/*      */ 
/*      */     
/*      */     public abstract boolean saveConfigElement();
/*      */ 
/*      */     
/*      */     public boolean enabled() {
/* 1682 */       return this.owningScreen.isWorldRunning ? ((!this.owningScreen.allRequireWorldRestart && !this.configElement.requiresWorldRestart())) : true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLabelWidth() {
/* 1688 */       return this.mc.fontRenderer.getStringWidth(this.name);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getEntryRightBound() {
/* 1694 */       return this.owningEntryList.resetX + 40;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public IConfigElement getConfigElement() {
/* 1700 */       return this.configElement;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getName() {
/* 1706 */       return this.configElement.getName();
/*      */     }
/*      */     
/*      */     public abstract Object getCurrentValue();
/*      */     
/*      */     public abstract Object[] getCurrentValues();
/*      */     
/*      */     public void onGuiClosed() {}
/*      */   }
/*      */   
/*      */   public static interface IConfigEntry<T> extends GuiListExtended.IGuiListEntry {
/*      */     IConfigElement getConfigElement();
/*      */     
/*      */     String getName();
/*      */     
/*      */     T getCurrentValue();
/*      */     
/*      */     T[] getCurrentValues();
/*      */     
/*      */     boolean enabled();
/*      */     
/*      */     void keyTyped(char param1Char, int param1Int);
/*      */     
/*      */     void updateCursorCounter();
/*      */     
/*      */     void mouseClicked(int param1Int1, int param1Int2, int param1Int3);
/*      */     
/*      */     boolean isDefault();
/*      */     
/*      */     void setToDefault();
/*      */     
/*      */     void undoChanges();
/*      */     
/*      */     boolean isChanged();
/*      */     
/*      */     boolean saveConfigElement();
/*      */     
/*      */     void drawToolTip(int param1Int1, int param1Int2);
/*      */     
/*      */     int getLabelWidth();
/*      */     
/*      */     int getEntryRightBound();
/*      */     
/*      */     void onGuiClosed();
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiConfigEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */