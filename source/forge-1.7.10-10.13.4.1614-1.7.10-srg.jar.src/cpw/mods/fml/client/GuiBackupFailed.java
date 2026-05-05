/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import java.io.File;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.resources.I18n;
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
/*    */ public class GuiBackupFailed
/*    */   extends GuiScreen
/*    */ {
/*    */   private GuiScreen parent;
/*    */   private File zipName;
/*    */   
/*    */   public GuiBackupFailed(GuiScreen parent, File zipName) {
/* 26 */     this.parent = parent;
/* 27 */     this.zipName = zipName;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 37 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 75, this.height - 38, I18n.format("gui.done", new Object[0])));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton p_73875_1_) {
/* 43 */     if (p_73875_1_.enabled && p_73875_1_.id == 1)
/*    */     {
/* 45 */       FMLClientHandler.instance().showGuiScreen(this.parent);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 54 */     drawDefaultBackground();
/* 55 */     int offset = Math.max(65, 10);
/* 56 */     drawCenteredString(this.fontRendererObj, String.format("There was an error saving the archive %s", new Object[] { this.zipName.getName() }), this.width / 2, offset, 16777215);
/* 57 */     offset += 10;
/* 58 */     drawCenteredString(this.fontRendererObj, String.format("Please fix the problem and try again", new Object[0]), this.width / 2, offset, 16777215);
/* 59 */     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiBackupFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */