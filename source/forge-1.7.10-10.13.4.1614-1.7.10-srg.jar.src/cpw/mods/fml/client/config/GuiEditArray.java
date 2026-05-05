/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
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
/*     */ public class GuiEditArray
/*     */   extends GuiScreen
/*     */ {
/*     */   protected GuiScreen parentScreen;
/*     */   protected IConfigElement configElement;
/*     */   private GuiEditArrayEntries entryList;
/*     */   private GuiButtonExt btnUndoChanges;
/*     */   private GuiButtonExt btnDefault;
/*     */   private GuiButtonExt btnDone;
/*     */   private String title;
/*     */   protected String titleLine2;
/*     */   protected String titleLine3;
/*     */   protected int slotIndex;
/*     */   private final Object[] beforeValues;
/*     */   private Object[] currentValues;
/*     */   private HoverChecker tooltipHoverChecker;
/*     */   private List toolTip;
/*     */   protected boolean enabled;
/*     */   
/*     */   public GuiEditArray(GuiScreen parentScreen, IConfigElement configElement, int slotIndex, Object[] currentValues, boolean enabled) {
/*  57 */     this.mc = Minecraft.getMinecraft();
/*  58 */     this.parentScreen = parentScreen;
/*  59 */     this.configElement = configElement;
/*  60 */     this.slotIndex = slotIndex;
/*  61 */     this.beforeValues = currentValues;
/*  62 */     this.currentValues = currentValues;
/*  63 */     this.toolTip = new ArrayList();
/*  64 */     this.enabled = enabled;
/*  65 */     String propName = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*     */ 
/*     */     
/*  68 */     String comment = I18n.format(configElement.getLanguageKey() + ".tooltip", new Object[] { "\n" + EnumChatFormatting.AQUA, configElement
/*  69 */           .getDefault(), configElement.getMinValue(), configElement.getMaxValue() });
/*     */     
/*  71 */     if (!comment.equals(configElement.getLanguageKey() + ".tooltip")) {
/*  72 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.YELLOW + comment, 300);
/*     */     }
/*  74 */     else if (configElement.getComment() != null && !configElement.getComment().trim().isEmpty()) {
/*  75 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.YELLOW + configElement
/*  76 */           .getComment(), 300);
/*     */     } else {
/*  78 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.RED + "No tooltip defined.", 300);
/*     */     } 
/*     */     
/*  81 */     if (parentScreen instanceof GuiConfig) {
/*     */       
/*  83 */       this.title = ((GuiConfig)parentScreen).title;
/*  84 */       if (((GuiConfig)parentScreen).titleLine2 != null) {
/*     */         
/*  86 */         this.titleLine2 = ((GuiConfig)parentScreen).titleLine2;
/*  87 */         this.titleLine3 = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*     */       } else {
/*     */         
/*  90 */         this.titleLine2 = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*  91 */       }  this.tooltipHoverChecker = new HoverChecker(28, 37, 0, parentScreen.width, 800);
/*     */     }
/*     */     else {
/*     */       
/*  95 */       this.title = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*  96 */       this.tooltipHoverChecker = new HoverChecker(8, 17, 0, parentScreen.width, 800);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/* 107 */     this.entryList = new GuiEditArrayEntries(this, this.mc, this.configElement, this.beforeValues, this.currentValues);
/*     */     
/* 109 */     int undoGlyphWidth = this.mc.fontRenderer.getStringWidth("↶") * 2;
/* 110 */     int resetGlyphWidth = this.mc.fontRenderer.getStringWidth("☄") * 2;
/* 111 */     int doneWidth = Math.max(this.mc.fontRenderer.getStringWidth(I18n.format("gui.done", new Object[0])) + 20, 100);
/* 112 */     int undoWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0])) + undoGlyphWidth + 20;
/* 113 */     int resetWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0])) + resetGlyphWidth + 20;
/* 114 */     int buttonWidthHalf = (doneWidth + 5 + undoWidth + 5 + resetWidth) / 2;
/* 115 */     this.buttonList.add(this.btnDone = new GuiButtonExt(2000, this.width / 2 - buttonWidthHalf, this.height - 29, doneWidth, 20, I18n.format("gui.done", new Object[0])));
/* 116 */     this.buttonList.add(this
/* 117 */         .btnDefault = new GuiUnicodeGlyphButton(2001, this.width / 2 - buttonWidthHalf + doneWidth + 5 + undoWidth + 5, this.height - 29, resetWidth, 20, " " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0]), "☄", 2.0F));
/* 118 */     this.buttonList.add(this
/* 119 */         .btnUndoChanges = new GuiUnicodeGlyphButton(2002, this.width / 2 - buttonWidthHalf + doneWidth + 5, this.height - 29, undoWidth, 20, " " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0]), "↶", 2.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/* 125 */     if (button.id == 2000) {
/*     */ 
/*     */       
/*     */       try {
/* 129 */         this.entryList.saveListChanges();
/*     */       }
/* 131 */       catch (Throwable e) {
/*     */         
/* 133 */         e.printStackTrace();
/*     */       } 
/* 135 */       this.mc.displayGuiScreen(this.parentScreen);
/*     */     }
/* 137 */     else if (button.id == 2001) {
/*     */       
/* 139 */       this.currentValues = this.configElement.getDefaults();
/* 140 */       this.entryList = new GuiEditArrayEntries(this, this.mc, this.configElement, this.beforeValues, this.currentValues);
/*     */     }
/* 142 */     else if (button.id == 2002) {
/*     */       
/* 144 */       this.currentValues = Arrays.copyOf(this.beforeValues, this.beforeValues.length);
/* 145 */       this.entryList = new GuiEditArrayEntries(this, this.mc, this.configElement, this.beforeValues, this.currentValues);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x, int y, int mouseEvent) {
/* 155 */     if (mouseEvent != 0 || !this.entryList.func_148179_a(x, y, mouseEvent)) {
/*     */       
/* 157 */       this.entryList.mouseClicked(x, y, mouseEvent);
/* 158 */       super.mouseClicked(x, y, mouseEvent);
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
/* 169 */     if (mouseEvent != 0 || !this.entryList.func_148181_b(x, y, mouseEvent))
/*     */     {
/* 171 */       super.mouseMovedOrUp(x, y, mouseEvent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyTyped(char eventChar, int eventKey) {
/* 181 */     if (eventKey == 1) {
/* 182 */       this.mc.displayGuiScreen(this.parentScreen);
/*     */     } else {
/* 184 */       this.entryList.keyTyped(eventChar, eventKey);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 193 */     super.updateScreen();
/* 194 */     this.entryList.updateScreen();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int par1, int par2, float par3) {
/* 203 */     drawDefaultBackground();
/* 204 */     this.entryList.drawScreen(par1, par2, par3);
/* 205 */     drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
/*     */     
/* 207 */     if (this.titleLine2 != null) {
/* 208 */       drawCenteredString(this.fontRendererObj, this.titleLine2, this.width / 2, 18, 16777215);
/*     */     }
/* 210 */     if (this.titleLine3 != null) {
/* 211 */       drawCenteredString(this.fontRendererObj, this.titleLine3, this.width / 2, 28, 16777215);
/*     */     }
/* 213 */     this.btnDone.enabled = this.entryList.isListSavable();
/* 214 */     this.btnDefault.enabled = (this.enabled && !this.entryList.isDefault());
/* 215 */     this.btnUndoChanges.enabled = (this.enabled && this.entryList.isChanged());
/* 216 */     super.drawScreen(par1, par2, par3);
/* 217 */     this.entryList.drawScreenPost(par1, par2, par3);
/*     */     
/* 219 */     if (this.tooltipHoverChecker != null && this.tooltipHoverChecker.checkHover(par1, par2)) {
/* 220 */       drawToolTip(this.toolTip, par1, par2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawToolTip(List stringList, int x, int y) {
/* 226 */     func_146283_a(stringList, x, y);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiEditArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */