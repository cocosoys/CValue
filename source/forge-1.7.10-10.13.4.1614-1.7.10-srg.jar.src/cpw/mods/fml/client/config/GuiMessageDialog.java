/*    */ package cpw.mods.fml.client.config;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiDisconnected;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class GuiMessageDialog
/*    */   extends GuiDisconnected
/*    */ {
/*    */   private String buttonText;
/*    */   
/*    */   public GuiMessageDialog(GuiScreen nextScreen, String title, IChatComponent message, String buttonText) {
/* 15 */     super(nextScreen, title, message);
/* 16 */     this.buttonText = buttonText;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 25 */     super.initGui();
/* 26 */     ((GuiButton)this.buttonList.get(0)).displayString = I18n.format(this.buttonText, new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiMessageDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */