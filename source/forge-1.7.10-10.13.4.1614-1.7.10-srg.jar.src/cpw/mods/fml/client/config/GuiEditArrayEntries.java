/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiListExtended;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.EnumChatFormatting;
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
/*     */ public class GuiEditArrayEntries
/*     */   extends GuiListExtended
/*     */ {
/*     */   private GuiEditArray owningGui;
/*     */   public Minecraft mc;
/*     */   public IConfigElement configElement;
/*     */   public List<IArrayEntry> listEntries;
/*     */   public boolean isDefault;
/*     */   public boolean isChanged;
/*     */   public boolean canAddMoreEntries;
/*     */   public final int controlWidth;
/*     */   public final Object[] beforeValues;
/*     */   public Object[] currentValues;
/*     */   
/*     */   public GuiEditArrayEntries(GuiEditArray parent, Minecraft mc, IConfigElement configElement, Object[] beforeValues, Object[] currentValues) {
/*  57 */     super(mc, parent.width, parent.height, (parent.titleLine2 != null) ? ((parent.titleLine3 != null) ? 43 : 33) : 23, parent.height - 32, 20);
/*  58 */     this.owningGui = parent;
/*  59 */     this.mc = mc;
/*  60 */     this.configElement = configElement;
/*  61 */     this.beforeValues = beforeValues;
/*  62 */     this.currentValues = currentValues;
/*  63 */     setShowSelectionBox(false);
/*  64 */     this.isChanged = !Arrays.deepEquals(beforeValues, currentValues);
/*  65 */     this.isDefault = Arrays.deepEquals(currentValues, configElement.getDefaults());
/*  66 */     this.canAddMoreEntries = (!configElement.isListLengthFixed() && (configElement.getMaxListLength() == -1 || currentValues.length < configElement.getMaxListLength()));
/*     */     
/*  68 */     this.listEntries = new ArrayList<IArrayEntry>();
/*     */     
/*  70 */     this.controlWidth = parent.width / 2 - (configElement.isListLengthFixed() ? 0 : 48);
/*     */     
/*  72 */     if (configElement.isList() && configElement.getArrayEntryClass() != null) {
/*     */       
/*  74 */       Class<? extends IArrayEntry> clazz = configElement.getArrayEntryClass();
/*  75 */       for (Object value : currentValues) {
/*     */         
/*     */         try
/*     */         {
/*  79 */           this.listEntries.add(clazz.getConstructor(new Class[] { GuiEditArray.class, GuiEditArrayEntries.class, IConfigElement.class, Object.class
/*  80 */                 }).newInstance(new Object[] { this.owningGui, this, configElement, value.toString() }));
/*     */         }
/*  82 */         catch (Throwable e)
/*     */         {
/*  84 */           FMLLog.severe("There was a critical error instantiating the custom IGuiEditListEntry for property %s.", new Object[] { configElement.getName() });
/*  85 */           e.printStackTrace();
/*     */         }
/*     */       
/*     */       } 
/*  89 */     } else if (configElement.isList() && configElement.getType().equals(ConfigGuiType.BOOLEAN)) {
/*  90 */       for (Object value : currentValues)
/*  91 */         this.listEntries.add(new BooleanEntry(this.owningGui, this, configElement, Boolean.valueOf(value.toString()).booleanValue())); 
/*  92 */     } else if (configElement.isList() && configElement.getType().equals(ConfigGuiType.INTEGER)) {
/*  93 */       for (Object value : currentValues)
/*  94 */         this.listEntries.add(new IntegerEntry(this.owningGui, this, configElement, Integer.valueOf(Integer.parseInt(value.toString())))); 
/*  95 */     } else if (configElement.isList() && configElement.getType().equals(ConfigGuiType.DOUBLE)) {
/*  96 */       for (Object value : currentValues)
/*  97 */         this.listEntries.add(new DoubleEntry(this.owningGui, this, configElement, Double.valueOf(Double.parseDouble(value.toString())))); 
/*  98 */     } else if (configElement.isList()) {
/*  99 */       for (Object value : currentValues)
/* 100 */         this.listEntries.add(new StringEntry(this.owningGui, this, configElement, value.toString())); 
/*     */     } 
/* 102 */     if (!configElement.isListLengthFixed()) {
/* 103 */       this.listEntries.add(new BaseEntry(this.owningGui, this, configElement));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getScrollBarX() {
/* 110 */     return this.width - this.width / 4;
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
/*     */   public int getListWidth() {
/* 122 */     return this.owningGui.width;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IArrayEntry getListEntry(int index) {
/* 131 */     return this.listEntries.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getSize() {
/* 137 */     return this.listEntries.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addNewEntry(int index) {
/* 142 */     if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.BOOLEAN) {
/* 143 */       this.listEntries.add(index, new BooleanEntry(this.owningGui, this, this.configElement, Boolean.valueOf(true).booleanValue()));
/* 144 */     } else if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.INTEGER) {
/* 145 */       this.listEntries.add(index, new IntegerEntry(this.owningGui, this, this.configElement, Integer.valueOf(0)));
/* 146 */     } else if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.DOUBLE) {
/* 147 */       this.listEntries.add(index, new DoubleEntry(this.owningGui, this, this.configElement, Double.valueOf(0.0D)));
/* 148 */     } else if (this.configElement.isList()) {
/* 149 */       this.listEntries.add(index, new StringEntry(this.owningGui, this, this.configElement, ""));
/* 150 */     }  this
/* 151 */       .canAddMoreEntries = (!this.configElement.isListLengthFixed() && (this.configElement.getMaxListLength() == -1 || this.listEntries.size() - 1 < this.configElement.getMaxListLength()));
/* 152 */     keyTyped(false, 207);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeEntry(int index) {
/* 157 */     this.listEntries.remove(index);
/* 158 */     this
/* 159 */       .canAddMoreEntries = (!this.configElement.isListLengthFixed() && (this.configElement.getMaxListLength() == -1 || this.listEntries.size() - 1 < this.configElement.getMaxListLength()));
/* 160 */     keyTyped(false, 207);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChanged() {
/* 165 */     return this.isChanged;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/* 170 */     return this.isDefault;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recalculateState() {
/* 175 */     this.isDefault = true;
/* 176 */     this.isChanged = false;
/*     */     
/* 178 */     int listLength = this.configElement.isListLengthFixed() ? this.listEntries.size() : (this.listEntries.size() - 1);
/*     */     
/* 180 */     if (listLength != (this.configElement.getDefaults()).length)
/*     */     {
/* 182 */       this.isDefault = false;
/*     */     }
/*     */     
/* 185 */     if (listLength != this.beforeValues.length)
/*     */     {
/* 187 */       this.isChanged = true;
/*     */     }
/*     */     
/* 190 */     if (this.isDefault)
/* 191 */       for (int i = 0; i < listLength; i++) {
/* 192 */         if (!this.configElement.getDefaults()[i].equals(((IArrayEntry)this.listEntries.get(i)).getValue()))
/* 193 */           this.isDefault = false; 
/*     */       }  
/* 195 */     if (!this.isChanged)
/* 196 */       for (int i = 0; i < listLength; i++) {
/* 197 */         if (!this.beforeValues[i].equals(((IArrayEntry)this.listEntries.get(i)).getValue()))
/* 198 */           this.isChanged = true; 
/*     */       }  
/*     */   }
/*     */   
/*     */   protected void keyTyped(char eventChar, int eventKey) {
/* 203 */     for (IArrayEntry entry : this.listEntries) {
/* 204 */       entry.keyTyped(eventChar, eventKey);
/*     */     }
/* 206 */     recalculateState();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateScreen() {
/* 211 */     for (IArrayEntry entry : this.listEntries) {
/* 212 */       entry.updateCursorCounter();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void mouseClicked(int x, int y, int mouseEvent) {
/* 217 */     for (IArrayEntry entry : this.listEntries) {
/* 218 */       entry.mouseClicked(x, y, mouseEvent);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean isListSavable() {
/* 223 */     for (IArrayEntry entry : this.listEntries) {
/* 224 */       if (!entry.isValueSavable())
/* 225 */         return false; 
/*     */     } 
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void saveListChanges() {
/* 233 */     int listLength = this.configElement.isListLengthFixed() ? this.listEntries.size() : (this.listEntries.size() - 1);
/*     */     
/* 235 */     if (this.owningGui.slotIndex != -1 && this.owningGui.parentScreen != null && this.owningGui.parentScreen instanceof GuiConfig && ((GuiConfig)this.owningGui.parentScreen).entryList
/*     */       
/* 237 */       .getListEntry(this.owningGui.slotIndex) instanceof GuiConfigEntries.ArrayEntry) {
/*     */       
/* 239 */       GuiConfigEntries.ArrayEntry entry = (GuiConfigEntries.ArrayEntry)((GuiConfig)this.owningGui.parentScreen).entryList.getListEntry(this.owningGui.slotIndex);
/*     */       
/* 241 */       Object[] ao = new Object[listLength];
/* 242 */       for (int i = 0; i < listLength; i++) {
/* 243 */         ao[i] = ((IArrayEntry)this.listEntries.get(i)).getValue();
/*     */       }
/* 245 */       entry.setListFromChildScreen(ao);
/*     */ 
/*     */     
/*     */     }
/* 249 */     else if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.BOOLEAN) {
/*     */       
/* 251 */       Boolean[] abol = new Boolean[listLength];
/* 252 */       for (int i = 0; i < listLength; i++) {
/* 253 */         abol[i] = Boolean.valueOf(((IArrayEntry)this.listEntries.get(i)).getValue().toString());
/*     */       }
/* 255 */       this.configElement.set(abol);
/*     */     }
/* 257 */     else if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.INTEGER) {
/*     */       
/* 259 */       Integer[] ai = new Integer[listLength];
/* 260 */       for (int i = 0; i < listLength; i++) {
/* 261 */         ai[i] = Integer.valueOf(((IArrayEntry)this.listEntries.get(i)).getValue().toString());
/*     */       }
/* 263 */       this.configElement.set(ai);
/*     */     }
/* 265 */     else if (this.configElement.isList() && this.configElement.getType() == ConfigGuiType.DOUBLE) {
/*     */       
/* 267 */       Double[] ad = new Double[listLength];
/* 268 */       for (int i = 0; i < listLength; i++) {
/* 269 */         ad[i] = Double.valueOf(((IArrayEntry)this.listEntries.get(i)).getValue().toString());
/*     */       }
/* 271 */       this.configElement.set(ad);
/*     */     }
/* 273 */     else if (this.configElement.isList()) {
/*     */       
/* 275 */       String[] as = new String[listLength];
/* 276 */       for (int i = 0; i < listLength; i++) {
/* 277 */         as[i] = ((IArrayEntry)this.listEntries.get(i)).getValue().toString();
/*     */       }
/* 279 */       this.configElement.set(as);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawScreenPost(int mouseX, int mouseY, float f) {
/* 286 */     for (IArrayEntry entry : this.listEntries) {
/* 287 */       entry.drawToolTip(mouseX, mouseY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DoubleEntry
/*     */     extends StringEntry
/*     */   {
/*     */     public DoubleEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement, Double value) {
/* 298 */       super(owningScreen, owningEntryList, configElement, value);
/* 299 */       this.isValidated = true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void keyTyped(char eventChar, int eventKey) {
/* 305 */       if (this.owningScreen.enabled || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*     */ 
/*     */         
/* 308 */         String validChars = "0123456789";
/* 309 */         String before = this.textFieldValue.getText();
/* 310 */         if (validChars.contains(String.valueOf(eventChar)) || (
/* 311 */           !before.startsWith("-") && this.textFieldValue.getCursorPosition() == 0 && eventChar == '-') || (
/* 312 */           !before.contains(".") && eventChar == '.') || eventKey == 14 || eventKey == 211 || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207)
/*     */         {
/*     */           
/* 315 */           this.textFieldValue.textboxKeyTyped(this.owningScreen.enabled ? eventChar : Character.MIN_VALUE, eventKey);
/*     */         }
/* 317 */         if (!this.textFieldValue.getText().trim().isEmpty() && !this.textFieldValue.getText().trim().equals("-")) {
/*     */ 
/*     */           
/*     */           try {
/* 321 */             double value = Double.parseDouble(this.textFieldValue.getText().trim());
/* 322 */             if (value < Double.valueOf(this.configElement.getMinValue().toString()).doubleValue() || value > Double.valueOf(this.configElement.getMaxValue().toString()).doubleValue()) {
/* 323 */               this.isValidValue = false;
/*     */             } else {
/* 325 */               this.isValidValue = true;
/*     */             } 
/* 327 */           } catch (Throwable e) {
/*     */             
/* 329 */             this.isValidValue = false;
/*     */           } 
/*     */         } else {
/*     */           
/* 333 */           this.isValidValue = false;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Double getValue() {
/*     */       try {
/* 342 */         return Double.valueOf(this.textFieldValue.getText().trim());
/*     */       }
/* 344 */       catch (Throwable e) {
/*     */         
/* 346 */         return Double.valueOf(Double.MAX_VALUE);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IntegerEntry
/*     */     extends StringEntry
/*     */   {
/*     */     public IntegerEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement, Integer value) {
/* 355 */       super(owningScreen, owningEntryList, configElement, value);
/* 356 */       this.isValidated = true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void keyTyped(char eventChar, int eventKey) {
/* 362 */       if (this.owningScreen.enabled || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*     */ 
/*     */         
/* 365 */         String validChars = "0123456789";
/* 366 */         String before = this.textFieldValue.getText();
/* 367 */         if (validChars.contains(String.valueOf(eventChar)) || (
/* 368 */           !before.startsWith("-") && this.textFieldValue.getCursorPosition() == 0 && eventChar == '-') || eventKey == 14 || eventKey == 211 || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207)
/*     */         {
/*     */           
/* 371 */           this.textFieldValue.textboxKeyTyped(this.owningScreen.enabled ? eventChar : Character.MIN_VALUE, eventKey);
/*     */         }
/* 373 */         if (!this.textFieldValue.getText().trim().isEmpty() && !this.textFieldValue.getText().trim().equals("-")) {
/*     */ 
/*     */           
/*     */           try {
/* 377 */             long value = Long.parseLong(this.textFieldValue.getText().trim());
/* 378 */             if (value < Integer.valueOf(this.configElement.getMinValue().toString()).intValue() || value > Integer.valueOf(this.configElement.getMaxValue().toString()).intValue()) {
/* 379 */               this.isValidValue = false;
/*     */             } else {
/* 381 */               this.isValidValue = true;
/*     */             } 
/* 383 */           } catch (Throwable e) {
/*     */             
/* 385 */             this.isValidValue = false;
/*     */           } 
/*     */         } else {
/*     */           
/* 389 */           this.isValidValue = false;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Integer getValue() {
/*     */       try {
/* 398 */         return Integer.valueOf(this.textFieldValue.getText().trim());
/*     */       }
/* 400 */       catch (Throwable e) {
/*     */         
/* 402 */         return Integer.valueOf(2147483647);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class StringEntry
/*     */     extends BaseEntry
/*     */   {
/*     */     protected final GuiTextField textFieldValue;
/*     */     
/*     */     public StringEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement, Object value) {
/* 413 */       super(owningScreen, owningEntryList, configElement);
/* 414 */       this.textFieldValue = new GuiTextField(owningEntryList.mc.fontRenderer, owningEntryList.width / 4 + 1, 0, owningEntryList.controlWidth - 3, 16);
/* 415 */       this.textFieldValue.setMaxStringLength(10000);
/* 416 */       this.textFieldValue.setText(value.toString());
/* 417 */       this.isValidated = (configElement.getValidationPattern() != null);
/*     */       
/* 419 */       if (configElement.getValidationPattern() != null)
/*     */       {
/* 421 */         if (configElement.getValidationPattern().matcher(this.textFieldValue.getText().trim()).matches()) {
/* 422 */           this.isValidValue = true;
/*     */         } else {
/* 424 */           this.isValidValue = false;
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 431 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/* 432 */       if (this.configElement.isListLengthFixed() || slotIndex != this.owningEntryList.listEntries.size() - 1) {
/*     */         
/* 434 */         this.textFieldValue.setVisible(true);
/* 435 */         this.textFieldValue.yPosition = y + 1;
/* 436 */         this.textFieldValue.drawTextBox();
/*     */       } else {
/*     */         
/* 439 */         this.textFieldValue.setVisible(false);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void keyTyped(char eventChar, int eventKey) {
/* 445 */       if (this.owningScreen.enabled || eventKey == 203 || eventKey == 205 || eventKey == 199 || eventKey == 207) {
/*     */ 
/*     */         
/* 448 */         this.textFieldValue.textboxKeyTyped(this.owningScreen.enabled ? eventChar : Character.MIN_VALUE, eventKey);
/*     */         
/* 450 */         if (this.configElement.getValidationPattern() != null)
/*     */         {
/* 452 */           if (this.configElement.getValidationPattern().matcher(this.textFieldValue.getText().trim()).matches()) {
/* 453 */             this.isValidValue = true;
/*     */           } else {
/* 455 */             this.isValidValue = false;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void updateCursorCounter() {
/* 463 */       this.textFieldValue.updateCursorCounter();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseClicked(int x, int y, int mouseEvent) {
/* 469 */       this.textFieldValue.mouseClicked(x, y, mouseEvent);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getValue() {
/* 475 */       return this.textFieldValue.getText().trim();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class BooleanEntry
/*     */     extends BaseEntry
/*     */   {
/*     */     protected final GuiButtonExt btnValue;
/*     */     private boolean value;
/*     */     
/*     */     public BooleanEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement, boolean value) {
/* 487 */       super(owningScreen, owningEntryList, configElement);
/* 488 */       this.value = value;
/* 489 */       this.btnValue = new GuiButtonExt(0, 0, 0, owningEntryList.controlWidth, 18, I18n.format(String.valueOf(value), new Object[0]));
/* 490 */       this.btnValue.enabled = owningScreen.enabled;
/* 491 */       this.isValidated = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 497 */       super.drawEntry(slotIndex, x, y, listWidth, slotHeight, tessellator, mouseX, mouseY, isSelected);
/* 498 */       this.btnValue.xPosition = listWidth / 4;
/* 499 */       this.btnValue.yPosition = y;
/*     */       
/* 501 */       String trans = I18n.format(String.valueOf(this.value), new Object[0]);
/* 502 */       if (!trans.equals(String.valueOf(this.value))) {
/* 503 */         this.btnValue.displayString = trans;
/*     */       } else {
/* 505 */         this.btnValue.displayString = String.valueOf(this.value);
/* 506 */       }  this.btnValue.packedFGColour = this.value ? GuiUtils.getColorCode('2', true) : GuiUtils.getColorCode('4', true);
/*     */       
/* 508 */       this.btnValue.drawButton(this.owningEntryList.mc, mouseX, mouseY);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 517 */       if (this.btnValue.mousePressed(this.owningEntryList.mc, x, y)) {
/*     */         
/* 519 */         this.btnValue.func_146113_a(this.owningEntryList.mc.getSoundHandler());
/* 520 */         this.value = !this.value;
/* 521 */         this.owningEntryList.recalculateState();
/* 522 */         return true;
/*     */       } 
/*     */       
/* 525 */       return super.mousePressed(index, x, y, mouseEvent, relativeX, relativeY);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 534 */       this.btnValue.mouseReleased(x, y);
/* 535 */       super.mouseReleased(index, x, y, mouseEvent, relativeX, relativeY);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getValue() {
/* 541 */       return Boolean.valueOf(this.value);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BaseEntry
/*     */     implements IArrayEntry
/*     */   {
/*     */     protected final GuiEditArray owningScreen;
/*     */     protected final GuiEditArrayEntries owningEntryList;
/*     */     protected final IConfigElement configElement;
/*     */     protected final GuiButtonExt btnAddNewEntryAbove;
/*     */     private final HoverChecker addNewEntryAboveHoverChecker;
/*     */     protected final GuiButtonExt btnRemoveEntry;
/*     */     private final HoverChecker removeEntryHoverChecker;
/*     */     private List addNewToolTip;
/*     */     private List removeToolTip;
/*     */     protected boolean isValidValue = true;
/*     */     protected boolean isValidated = false;
/*     */     
/*     */     public BaseEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement) {
/* 561 */       this.owningScreen = owningScreen;
/* 562 */       this.owningEntryList = owningEntryList;
/* 563 */       this.configElement = configElement;
/* 564 */       this.btnAddNewEntryAbove = new GuiButtonExt(0, 0, 0, 18, 18, "+");
/* 565 */       this.btnAddNewEntryAbove.packedFGColour = GuiUtils.getColorCode('2', true);
/* 566 */       this.btnAddNewEntryAbove.enabled = owningScreen.enabled;
/* 567 */       this.btnRemoveEntry = new GuiButtonExt(0, 0, 0, 18, 18, "x");
/* 568 */       this.btnRemoveEntry.packedFGColour = GuiUtils.getColorCode('c', true);
/* 569 */       this.btnRemoveEntry.enabled = owningScreen.enabled;
/* 570 */       this.addNewEntryAboveHoverChecker = new HoverChecker(this.btnAddNewEntryAbove, 800);
/* 571 */       this.removeEntryHoverChecker = new HoverChecker(this.btnRemoveEntry, 800);
/* 572 */       this.addNewToolTip = new ArrayList();
/* 573 */       this.removeToolTip = new ArrayList();
/* 574 */       this.addNewToolTip.add(I18n.format("fml.configgui.tooltip.addNewEntryAbove", new Object[0]));
/* 575 */       this.removeToolTip.add(I18n.format("fml.configgui.tooltip.removeEntry", new Object[0]));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 581 */       if (getValue() != null && this.isValidated) {
/* 582 */         this.owningEntryList.mc.fontRenderer.drawString(this.isValidValue ? (EnumChatFormatting.GREEN + "✔") : (EnumChatFormatting.RED + "✕"), listWidth / 4 - this.owningEntryList.mc.fontRenderer
/*     */             
/* 584 */             .getStringWidth("✔") - 2, y + slotHeight / 2 - this.owningEntryList.mc.fontRenderer.FONT_HEIGHT / 2, 16777215);
/*     */       }
/*     */ 
/*     */       
/* 588 */       int half = listWidth / 2;
/* 589 */       if (this.owningEntryList.canAddMoreEntries) {
/*     */         
/* 591 */         this.btnAddNewEntryAbove.visible = true;
/* 592 */         this.btnAddNewEntryAbove.xPosition = half + half / 2 - 44;
/* 593 */         this.btnAddNewEntryAbove.yPosition = y;
/* 594 */         this.btnAddNewEntryAbove.drawButton(this.owningEntryList.mc, mouseX, mouseY);
/*     */       } else {
/*     */         
/* 597 */         this.btnAddNewEntryAbove.visible = false;
/*     */       } 
/* 599 */       if (!this.configElement.isListLengthFixed() && slotIndex != this.owningEntryList.listEntries.size() - 1) {
/*     */         
/* 601 */         this.btnRemoveEntry.visible = true;
/* 602 */         this.btnRemoveEntry.xPosition = half + half / 2 - 22;
/* 603 */         this.btnRemoveEntry.yPosition = y;
/* 604 */         this.btnRemoveEntry.drawButton(this.owningEntryList.mc, mouseX, mouseY);
/*     */       } else {
/*     */         
/* 607 */         this.btnRemoveEntry.visible = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void drawToolTip(int mouseX, int mouseY) {
/* 613 */       boolean canHover = (mouseY < this.owningEntryList.bottom && mouseY > this.owningEntryList.top);
/* 614 */       if (this.btnAddNewEntryAbove.visible && this.addNewEntryAboveHoverChecker.checkHover(mouseX, mouseY, canHover))
/* 615 */         this.owningScreen.drawToolTip(this.addNewToolTip, mouseX, mouseY); 
/* 616 */       if (this.btnRemoveEntry.visible && this.removeEntryHoverChecker.checkHover(mouseX, mouseY, canHover)) {
/* 617 */         this.owningScreen.drawToolTip(this.removeToolTip, mouseX, mouseY);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 626 */       if (this.btnAddNewEntryAbove.mousePressed(this.owningEntryList.mc, x, y)) {
/*     */         
/* 628 */         this.btnAddNewEntryAbove.func_146113_a(this.owningEntryList.mc.getSoundHandler());
/* 629 */         this.owningEntryList.addNewEntry(index);
/* 630 */         this.owningEntryList.recalculateState();
/* 631 */         return true;
/*     */       } 
/* 633 */       if (this.btnRemoveEntry.mousePressed(this.owningEntryList.mc, x, y)) {
/*     */         
/* 635 */         this.btnRemoveEntry.func_146113_a(this.owningEntryList.mc.getSoundHandler());
/* 636 */         this.owningEntryList.removeEntry(index);
/* 637 */         this.owningEntryList.recalculateState();
/* 638 */         return true;
/*     */       } 
/*     */       
/* 641 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 650 */       this.btnAddNewEntryAbove.mouseReleased(x, y);
/* 651 */       this.btnRemoveEntry.mouseReleased(x, y);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void keyTyped(char eventChar, int eventKey) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void updateCursorCounter() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseClicked(int x, int y, int mouseEvent) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isValueSavable() {
/* 669 */       return this.isValidValue;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getValue() {
/* 675 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface IArrayEntry extends GuiListExtended.IGuiListEntry {
/*     */     void keyTyped(char param1Char, int param1Int);
/*     */     
/*     */     void updateCursorCounter();
/*     */     
/*     */     void mouseClicked(int param1Int1, int param1Int2, int param1Int3);
/*     */     
/*     */     void drawToolTip(int param1Int1, int param1Int2);
/*     */     
/*     */     boolean isValueSavable();
/*     */     
/*     */     Object getValue();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiEditArrayEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */