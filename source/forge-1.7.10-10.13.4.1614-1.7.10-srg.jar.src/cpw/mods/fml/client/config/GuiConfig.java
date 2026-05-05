/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import cpw.mods.fml.client.event.ConfigChangedEvent;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.lwjgl.input.Keyboard;
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
/*     */ public class GuiConfig
/*     */   extends GuiScreen
/*     */ {
/*     */   public final GuiScreen parentScreen;
/*  49 */   public String title = "Config GUI";
/*     */ 
/*     */   
/*     */   public String titleLine2;
/*     */ 
/*     */   
/*     */   public final List<IConfigElement> configElements;
/*     */ 
/*     */   
/*     */   public final List<GuiConfigEntries.IConfigEntry> initEntries;
/*     */ 
/*     */   
/*     */   public GuiConfigEntries entryList;
/*     */ 
/*     */   
/*     */   private GuiButtonExt btnDefaultAll;
/*     */ 
/*     */   
/*     */   private GuiButtonExt btnUndoAll;
/*     */ 
/*     */   
/*     */   private GuiCheckBox chkApplyGlobally;
/*     */ 
/*     */   
/*     */   public final String modID;
/*     */ 
/*     */   
/*     */   public final String configID;
/*     */   
/*     */   public final boolean isWorldRunning;
/*     */   
/*     */   public final boolean allRequireWorldRestart;
/*     */   
/*     */   public final boolean allRequireMcRestart;
/*     */   
/*     */   public boolean needsRefresh = true;
/*     */   
/*     */   private HoverChecker undoHoverChecker;
/*     */   
/*     */   private HoverChecker resetHoverChecker;
/*     */   
/*     */   private HoverChecker checkBoxHoverChecker;
/*     */ 
/*     */   
/*     */   public GuiConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID, String configID, boolean allRequireWorldRestart, boolean allRequireMcRestart, String title) {
/*  94 */     this(parentScreen, configElements, modID, configID, allRequireWorldRestart, allRequireMcRestart, title, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID, boolean allRequireWorldRestart, boolean allRequireMcRestart, String title) {
/* 113 */     this(parentScreen, configElements, modID, (String)null, allRequireWorldRestart, allRequireMcRestart, title, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID, boolean allRequireWorldRestart, boolean allRequireMcRestart, String title, String titleLine2) {
/* 134 */     this(parentScreen, configElements, modID, (String)null, allRequireWorldRestart, allRequireMcRestart, title, titleLine2);
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
/*     */   public GuiConfig(GuiScreen parentScreen, List<IConfigElement> configElements, String modID, String configID, boolean allRequireWorldRestart, boolean allRequireMcRestart, String title, String titleLine2) {
/* 158 */     this.mc = Minecraft.getMinecraft();
/* 159 */     this.parentScreen = parentScreen;
/* 160 */     this.configElements = configElements;
/* 161 */     this.entryList = new GuiConfigEntries(this, this.mc);
/* 162 */     this.initEntries = new ArrayList<GuiConfigEntries.IConfigEntry>(this.entryList.listEntries);
/* 163 */     this.allRequireWorldRestart = allRequireWorldRestart;
/* 164 */     this.allRequireMcRestart = allRequireMcRestart;
/* 165 */     this.modID = modID;
/* 166 */     this.configID = configID;
/* 167 */     this.isWorldRunning = (this.mc.theWorld != null);
/* 168 */     if (title != null)
/* 169 */       this.title = title; 
/* 170 */     this.titleLine2 = titleLine2;
/* 171 */     if (this.titleLine2 != null && this.titleLine2.startsWith(" > ")) {
/* 172 */       this.titleLine2 = this.titleLine2.replaceFirst(" > ", "");
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getAbridgedConfigPath(String path) {
/* 177 */     Minecraft mc = Minecraft.getMinecraft();
/* 178 */     if (mc.mcDataDir.getAbsolutePath().endsWith(".")) {
/* 179 */       return path.replace("\\", "/").replace(mc.mcDataDir.getAbsolutePath().replace("\\", "/").substring(0, mc.mcDataDir.getAbsolutePath().length() - 1), "/.minecraft/");
/*     */     }
/* 181 */     return path.replace("\\", "/").replace(mc.mcDataDir.getAbsolutePath().replace("\\", "/"), "/.minecraft");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/* 191 */     Keyboard.enableRepeatEvents(true);
/*     */     
/* 193 */     if (this.entryList == null || this.needsRefresh) {
/*     */       
/* 195 */       this.entryList = new GuiConfigEntries(this, this.mc);
/* 196 */       this.needsRefresh = false;
/*     */     } 
/*     */     
/* 199 */     int undoGlyphWidth = this.mc.fontRenderer.getStringWidth("↶") * 2;
/* 200 */     int resetGlyphWidth = this.mc.fontRenderer.getStringWidth("☄") * 2;
/* 201 */     int doneWidth = Math.max(this.mc.fontRenderer.getStringWidth(I18n.format("gui.done", new Object[0])) + 20, 100);
/* 202 */     int undoWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0])) + undoGlyphWidth + 20;
/* 203 */     int resetWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0])) + resetGlyphWidth + 20;
/* 204 */     int checkWidth = this.mc.fontRenderer.getStringWidth(I18n.format("fml.configgui.applyGlobally", new Object[0])) + 13;
/* 205 */     int buttonWidthHalf = (doneWidth + 5 + undoWidth + 5 + resetWidth + 5 + checkWidth) / 2;
/* 206 */     this.buttonList.add(new GuiButtonExt(2000, this.width / 2 - buttonWidthHalf, this.height - 29, doneWidth, 20, I18n.format("gui.done", new Object[0])));
/* 207 */     this.buttonList.add(this
/* 208 */         .btnDefaultAll = new GuiUnicodeGlyphButton(2001, this.width / 2 - buttonWidthHalf + doneWidth + 5 + undoWidth + 5, this.height - 29, resetWidth, 20, " " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0]), "☄", 2.0F));
/* 209 */     this.buttonList.add(this
/* 210 */         .btnUndoAll = new GuiUnicodeGlyphButton(2002, this.width / 2 - buttonWidthHalf + doneWidth + 5, this.height - 29, undoWidth, 20, " " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0]), "↶", 2.0F));
/* 211 */     this.buttonList.add(this
/* 212 */         .chkApplyGlobally = new GuiCheckBox(2003, this.width / 2 - buttonWidthHalf + doneWidth + 5 + undoWidth + 5 + resetWidth + 5, this.height - 24, I18n.format("fml.configgui.applyGlobally", new Object[0]), false));
/*     */     
/* 214 */     this.undoHoverChecker = new HoverChecker(this.btnUndoAll, 800);
/* 215 */     this.resetHoverChecker = new HoverChecker(this.btnDefaultAll, 800);
/* 216 */     this.checkBoxHoverChecker = new HoverChecker(this.chkApplyGlobally, 800);
/* 217 */     this.entryList.initGui();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 226 */     this.entryList.onGuiClosed();
/*     */     
/* 228 */     if (this.configID != null && this.parentScreen instanceof GuiConfig) {
/*     */       
/* 230 */       GuiConfig parentGuiConfig = (GuiConfig)this.parentScreen;
/* 231 */       parentGuiConfig.needsRefresh = true;
/* 232 */       parentGuiConfig.initGui();
/*     */     } 
/*     */     
/* 235 */     if (!(this.parentScreen instanceof GuiConfig)) {
/* 236 */       Keyboard.enableRepeatEvents(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/* 242 */     if (button.id == 2000) {
/*     */       
/* 244 */       boolean flag = true;
/*     */       
/*     */       try {
/* 247 */         if ((this.configID != null || this.parentScreen == null || !(this.parentScreen instanceof GuiConfig)) && this.entryList
/* 248 */           .hasChangedEntry(true)) {
/*     */           
/* 250 */           boolean requiresMcRestart = this.entryList.saveConfigElements();
/*     */           
/* 252 */           if (Loader.isModLoaded(this.modID)) {
/*     */             
/* 254 */             ConfigChangedEvent.OnConfigChangedEvent onConfigChangedEvent = new ConfigChangedEvent.OnConfigChangedEvent(this.modID, this.configID, this.isWorldRunning, requiresMcRestart);
/* 255 */             FMLCommonHandler.instance().bus().post((Event)onConfigChangedEvent);
/* 256 */             if (!onConfigChangedEvent.getResult().equals(Event.Result.DENY)) {
/* 257 */               FMLCommonHandler.instance().bus().post((Event)new ConfigChangedEvent.PostConfigChangedEvent(this.modID, this.configID, this.isWorldRunning, requiresMcRestart));
/*     */             }
/* 259 */             if (requiresMcRestart) {
/*     */               
/* 261 */               flag = false;
/* 262 */               this.mc.displayGuiScreen((GuiScreen)new GuiMessageDialog(this.parentScreen, "fml.configgui.gameRestartTitle", (IChatComponent)new ChatComponentText(
/* 263 */                       I18n.format("fml.configgui.gameRestartRequired", new Object[0])), "fml.configgui.confirmRestartMessage"));
/*     */             } 
/*     */             
/* 266 */             if (this.parentScreen instanceof GuiConfig) {
/* 267 */               ((GuiConfig)this.parentScreen).needsRefresh = true;
/*     */             }
/*     */           } 
/*     */         } 
/* 271 */       } catch (Throwable e) {
/*     */         
/* 273 */         e.printStackTrace();
/*     */       } 
/*     */       
/* 276 */       if (flag) {
/* 277 */         this.mc.displayGuiScreen(this.parentScreen);
/*     */       }
/* 279 */     } else if (button.id == 2001) {
/*     */       
/* 281 */       this.entryList.setAllToDefault(this.chkApplyGlobally.isChecked());
/*     */     }
/* 283 */     else if (button.id == 2002) {
/*     */       
/* 285 */       this.entryList.undoAllChanges(this.chkApplyGlobally.isChecked());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x, int y, int mouseEvent) {
/* 295 */     if (mouseEvent != 0 || !this.entryList.func_148179_a(x, y, mouseEvent)) {
/*     */       
/* 297 */       this.entryList.mouseClicked(x, y, mouseEvent);
/* 298 */       super.mouseClicked(x, y, mouseEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseMovedOrUp(int x, int y, int mouseEvent) {
/* 309 */     if (mouseEvent != 0 || !this.entryList.func_148181_b(x, y, mouseEvent))
/*     */     {
/* 311 */       super.mouseMovedOrUp(x, y, mouseEvent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyTyped(char eventChar, int eventKey) {
/* 321 */     if (eventKey == 1) {
/* 322 */       this.mc.displayGuiScreen(this.parentScreen);
/*     */     } else {
/* 324 */       this.entryList.keyTyped(eventChar, eventKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 333 */     super.updateScreen();
/* 334 */     this.entryList.updateScreen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 343 */     drawDefaultBackground();
/* 344 */     this.entryList.drawScreen(mouseX, mouseY, partialTicks);
/* 345 */     drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
/* 346 */     String title2 = this.titleLine2;
/*     */     
/* 348 */     if (title2 != null) {
/*     */       
/* 350 */       int strWidth = this.mc.fontRenderer.getStringWidth(title2);
/* 351 */       int elipsisWidth = this.mc.fontRenderer.getStringWidth("...");
/* 352 */       if (strWidth > this.width - 6 && strWidth > elipsisWidth)
/* 353 */         title2 = this.mc.fontRenderer.trimStringToWidth(title2, this.width - 6 - elipsisWidth).trim() + "..."; 
/* 354 */       drawCenteredString(this.fontRendererObj, title2, this.width / 2, 18, 16777215);
/*     */     } 
/*     */     
/* 357 */     this.btnUndoAll.enabled = (this.entryList.areAnyEntriesEnabled(this.chkApplyGlobally.isChecked()) && this.entryList.hasChangedEntry(this.chkApplyGlobally.isChecked()));
/* 358 */     this.btnDefaultAll.enabled = (this.entryList.areAnyEntriesEnabled(this.chkApplyGlobally.isChecked()) && !this.entryList.areAllEntriesDefault(this.chkApplyGlobally.isChecked()));
/* 359 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 360 */     this.entryList.drawScreenPost(mouseX, mouseY, partialTicks);
/* 361 */     if (this.undoHoverChecker.checkHover(mouseX, mouseY))
/* 362 */       drawToolTip(this.mc.fontRenderer.listFormattedStringToWidth(I18n.format("fml.configgui.tooltip.undoAll", new Object[0]), 300), mouseX, mouseY); 
/* 363 */     if (this.resetHoverChecker.checkHover(mouseX, mouseY))
/* 364 */       drawToolTip(this.mc.fontRenderer.listFormattedStringToWidth(I18n.format("fml.configgui.tooltip.resetAll", new Object[0]), 300), mouseX, mouseY); 
/* 365 */     if (this.checkBoxHoverChecker.checkHover(mouseX, mouseY)) {
/* 366 */       drawToolTip(this.mc.fontRenderer.listFormattedStringToWidth(I18n.format("fml.configgui.tooltip.applyGlobally", new Object[0]), 300), mouseX, mouseY);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawToolTip(List stringList, int x, int y) {
/* 372 */     func_146283_a(stringList, x, y);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */