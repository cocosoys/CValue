/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiErrorScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiCustomModLoadingErrorScreen
/*    */   extends GuiErrorScreen
/*    */ {
/*    */   private CustomModLoadingErrorDisplayException customException;
/*    */   
/*    */   public GuiCustomModLoadingErrorScreen(CustomModLoadingErrorDisplayException customException) {
/* 22 */     super(null, null);
/* 23 */     this.customException = customException;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 31 */     super.initGui();
/* 32 */     this.buttonList.clear();
/* 33 */     this.customException.initGui(this, this.fontRendererObj);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 41 */     drawDefaultBackground();
/* 42 */     this.customException.drawScreen(this, this.fontRendererObj, p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiCustomModLoadingErrorScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */