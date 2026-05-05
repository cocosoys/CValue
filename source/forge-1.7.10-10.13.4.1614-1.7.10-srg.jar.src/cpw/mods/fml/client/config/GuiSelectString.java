/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class GuiSelectString
/*     */   extends GuiScreen
/*     */ {
/*     */   protected GuiScreen parentScreen;
/*     */   protected IConfigElement configElement;
/*     */   private GuiSelectStringEntries entriesList;
/*     */   private GuiButtonExt btnUndoChanges;
/*     */   private GuiButtonExt btnDefault;
/*     */   private GuiButtonExt btnDone;
/*     */   private String title;
/*     */   protected String titleLine2;
/*     */   protected String titleLine3;
/*     */   protected int slotIndex;
/*     */   private final Map<Object, String> selectableValues;
/*     */   public final Object beforeValue;
/*     */   public Object currentValue;
/*     */   private HoverChecker tooltipHoverChecker;
/*     */   private List toolTip;
/*     */   protected boolean enabled;
/*     */   
/*     */   public GuiSelectString(GuiScreen parentScreen, IConfigElement configElement, int slotIndex, Map<Object, String> selectableValues, Object currentValue, boolean enabled) {
/*  55 */     this.mc = Minecraft.getMinecraft();
/*  56 */     this.parentScreen = parentScreen;
/*  57 */     this.configElement = configElement;
/*  58 */     this.slotIndex = slotIndex;
/*  59 */     this.selectableValues = selectableValues;
/*  60 */     this.beforeValue = currentValue;
/*  61 */     this.currentValue = currentValue;
/*  62 */     this.toolTip = new ArrayList();
/*  63 */     this.enabled = enabled;
/*  64 */     String propName = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*     */ 
/*     */     
/*  67 */     String comment = I18n.format(configElement.getLanguageKey() + ".tooltip", new Object[] { "\n" + EnumChatFormatting.AQUA, configElement
/*  68 */           .getDefault(), configElement.getMinValue(), configElement.getMaxValue() });
/*     */     
/*  70 */     if (!comment.equals(configElement.getLanguageKey() + ".tooltip")) {
/*  71 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.YELLOW + comment, 300);
/*     */     }
/*  73 */     else if (configElement.getComment() != null && !configElement.getComment().trim().isEmpty()) {
/*  74 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.YELLOW + configElement
/*  75 */           .getComment(), 300);
/*     */     } else {
/*  77 */       this.toolTip = this.mc.fontRenderer.listFormattedStringToWidth(EnumChatFormatting.GREEN + propName + "\n" + EnumChatFormatting.RED + "No tooltip defined.", 300);
/*     */     } 
/*     */     
/*  80 */     if (parentScreen instanceof GuiConfig) {
/*     */       
/*  82 */       this.title = ((GuiConfig)parentScreen).title;
/*  83 */       this.titleLine2 = ((GuiConfig)parentScreen).titleLine2;
/*  84 */       this.titleLine3 = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*  85 */       this.tooltipHoverChecker = new HoverChecker(28, 37, 0, parentScreen.width, 800);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  90 */       this.title = I18n.format(configElement.getLanguageKey(), new Object[0]);
/*  91 */       this.tooltipHoverChecker = new HoverChecker(8, 17, 0, parentScreen.width, 800);
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
/* 102 */     this.entriesList = new GuiSelectStringEntries(this, this.mc, this.configElement, this.selectableValues);
/*     */     
/* 104 */     int undoGlyphWidth = this.mc.fontRenderer.getStringWidth("↶") * 2;
/* 105 */     int resetGlyphWidth = this.mc.fontRenderer.getStringWidth("☄") * 2;
/* 106 */     int doneWidth = Math.max(this.mc.fontRenderer.getStringWidth(I18n.format("gui.done", new Object[0])) + 20, 100);
/* 107 */     int undoWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0])) + undoGlyphWidth + 20;
/* 108 */     int resetWidth = this.mc.fontRenderer.getStringWidth(" " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0])) + resetGlyphWidth + 20;
/* 109 */     int buttonWidthHalf = (doneWidth + 5 + undoWidth + 5 + resetWidth) / 2;
/* 110 */     this.buttonList.add(this.btnDone = new GuiButtonExt(2000, this.width / 2 - buttonWidthHalf, this.height - 29, doneWidth, 20, I18n.format("gui.done", new Object[0])));
/* 111 */     this.buttonList.add(this
/* 112 */         .btnDefault = new GuiUnicodeGlyphButton(2001, this.width / 2 - buttonWidthHalf + doneWidth + 5 + undoWidth + 5, this.height - 29, resetWidth, 20, " " + I18n.format("fml.configgui.tooltip.resetToDefault", new Object[0]), "☄", 2.0F));
/* 113 */     this.buttonList.add(this
/* 114 */         .btnUndoChanges = new GuiUnicodeGlyphButton(2002, this.width / 2 - buttonWidthHalf + doneWidth + 5, this.height - 29, undoWidth, 20, " " + I18n.format("fml.configgui.tooltip.undoChanges", new Object[0]), "↶", 2.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/* 120 */     if (button.id == 2000) {
/*     */ 
/*     */       
/*     */       try {
/* 124 */         this.entriesList.saveChanges();
/*     */       }
/* 126 */       catch (Throwable e) {
/*     */         
/* 128 */         e.printStackTrace();
/*     */       } 
/* 130 */       this.mc.displayGuiScreen(this.parentScreen);
/*     */     }
/* 132 */     else if (button.id == 2001) {
/*     */       
/* 134 */       this.currentValue = this.configElement.getDefault();
/* 135 */       this.entriesList = new GuiSelectStringEntries(this, this.mc, this.configElement, this.selectableValues);
/*     */     }
/* 137 */     else if (button.id == 2002) {
/*     */       
/* 139 */       this.currentValue = this.beforeValue;
/* 140 */       this.entriesList = new GuiSelectStringEntries(this, this.mc, this.configElement, this.selectableValues);
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
/* 151 */     if (mouseEvent != 0 || !this.entriesList.func_148181_b(x, y, mouseEvent))
/*     */     {
/* 153 */       super.mouseMovedOrUp(x, y, mouseEvent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int par1, int par2, float par3) {
/* 163 */     drawDefaultBackground();
/* 164 */     this.entriesList.drawScreen(par1, par2, par3);
/* 165 */     drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
/*     */     
/* 167 */     if (this.titleLine2 != null) {
/* 168 */       drawCenteredString(this.fontRendererObj, this.titleLine2, this.width / 2, 18, 16777215);
/*     */     }
/* 170 */     if (this.titleLine3 != null) {
/* 171 */       drawCenteredString(this.fontRendererObj, this.titleLine3, this.width / 2, 28, 16777215);
/*     */     }
/* 173 */     this.btnDone.enabled = (this.currentValue != null);
/* 174 */     this.btnDefault.enabled = (this.enabled && !this.entriesList.isDefault());
/* 175 */     this.btnUndoChanges.enabled = (this.enabled && this.entriesList.isChanged());
/* 176 */     super.drawScreen(par1, par2, par3);
/*     */     
/* 178 */     if (this.tooltipHoverChecker != null && this.tooltipHoverChecker.checkHover(par1, par2)) {
/* 179 */       drawToolTip(this.toolTip, par1, par2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawToolTip(List stringList, int x, int y) {
/* 185 */     func_146283_a(stringList, x, y);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiSelectString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */