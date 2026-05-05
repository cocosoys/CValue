/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ public class GuiIngameModOptions
/*    */   extends GuiScreen {
/*    */   private final GuiScreen parentScreen;
/* 11 */   protected String title = "Mod Options";
/*    */   
/*    */   private GuiModOptionList optionList;
/*    */   
/*    */   public GuiIngameModOptions(GuiScreen parentScreen) {
/* 16 */     this.parentScreen = parentScreen;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 26 */     this.optionList = new GuiModOptionList(this);
/* 27 */     this.optionList.registerScrollButtons(this.buttonList, 7, 8);
/* 28 */     this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton p_146284_1_) {
/* 34 */     if (p_146284_1_.enabled)
/*    */     {
/* 36 */       if (p_146284_1_.id == 200) {
/*    */         
/* 38 */         this.mc.gameSettings.saveOptions();
/* 39 */         this.mc.displayGuiScreen(this.parentScreen);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 51 */     drawDefaultBackground();
/* 52 */     this.optionList.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/* 53 */     drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
/* 54 */     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   FontRenderer getFontRenderer() {
/* 59 */     return this.fontRendererObj;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiIngameModOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */