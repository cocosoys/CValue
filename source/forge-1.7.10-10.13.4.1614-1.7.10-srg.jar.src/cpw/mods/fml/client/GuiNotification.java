/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.StartupQuery;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ 
/*    */ public class GuiNotification extends GuiScreen {
/*    */   protected final StartupQuery query;
/*    */   
/*    */   public GuiNotification(StartupQuery query) {
/* 12 */     this.query = query;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 22 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height - 38, I18n.format("gui.done", new Object[0])));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton button) {
/* 28 */     if (button.enabled && button.id == 0) {
/*    */       
/* 30 */       FMLClientHandler.instance().showGuiScreen(null);
/* 31 */       this.query.finish();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 41 */     drawDefaultBackground();
/*    */     
/* 43 */     String[] lines = this.query.getText().split("\n");
/*    */     
/* 45 */     int spaceAvailable = this.height - 38 - 20;
/* 46 */     int spaceRequired = Math.min(spaceAvailable, 10 + 10 * lines.length);
/*    */     
/* 48 */     int offset = 10 + (spaceAvailable - spaceRequired) / 2;
/*    */     
/* 50 */     for (String line : lines) {
/*    */       
/* 52 */       if (offset >= spaceAvailable) {
/*    */         
/* 54 */         drawCenteredString(this.fontRendererObj, "...", this.width / 2, offset, 16777215);
/*    */         
/*    */         break;
/*    */       } 
/*    */       
/* 59 */       if (!line.isEmpty()) drawCenteredString(this.fontRendererObj, line, this.width / 2, offset, 16777215); 
/* 60 */       offset += 10;
/*    */     } 
/*    */ 
/*    */     
/* 64 */     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */