/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.StartupQuery;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiOptionButton;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ public class GuiConfirmation
/*    */   extends GuiNotification
/*    */ {
/*    */   public GuiConfirmation(StartupQuery query) {
/* 12 */     super(query);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 22 */     this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 155, this.height - 38, I18n.format("gui.yes", new Object[0])));
/* 23 */     this.buttonList.add(new GuiOptionButton(1, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.no", new Object[0])));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton button) {
/* 29 */     if (button.enabled && (button.id == 0 || button.id == 1)) {
/*    */       
/* 31 */       FMLClientHandler.instance().showGuiScreen(null);
/* 32 */       this.query.setResult((button.id == 0));
/* 33 */       this.query.finish();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiConfirmation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */