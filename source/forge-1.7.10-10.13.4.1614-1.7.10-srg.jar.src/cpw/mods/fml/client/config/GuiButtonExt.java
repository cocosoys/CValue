/*    */ package cpw.mods.fml.client.config;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
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
/*    */ public class GuiButtonExt
/*    */   extends GuiButton
/*    */ {
/*    */   public GuiButtonExt(int id, int xPos, int yPos, String displayString) {
/* 32 */     super(id, xPos, yPos, displayString);
/*    */   }
/*    */ 
/*    */   
/*    */   public GuiButtonExt(int id, int xPos, int yPos, int width, int height, String displayString) {
/* 37 */     super(id, xPos, yPos, width, height, displayString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 49 */     if (this.visible) {
/*    */       
/* 51 */       this.field_146123_n = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 52 */       int k = getHoverState(this.field_146123_n);
/* 53 */       GuiUtils.drawContinuousTexturedBox(buttonTextures, this.xPosition, this.yPosition, 0, 46 + k * 20, this.width, this.height, 200, 20, 2, 3, 2, 2, this.zLevel);
/* 54 */       mouseDragged(mc, mouseX, mouseY);
/* 55 */       int color = 14737632;
/*    */       
/* 57 */       if (this.packedFGColour != 0) {
/*    */         
/* 59 */         color = this.packedFGColour;
/*    */       }
/* 61 */       else if (!this.enabled) {
/*    */         
/* 63 */         color = 10526880;
/*    */       }
/* 65 */       else if (this.field_146123_n) {
/*    */         
/* 67 */         color = 16777120;
/*    */       } 
/*    */       
/* 70 */       String buttonText = this.displayString;
/* 71 */       int strWidth = mc.fontRenderer.getStringWidth(buttonText);
/* 72 */       int ellipsisWidth = mc.fontRenderer.getStringWidth("...");
/*    */       
/* 74 */       if (strWidth > this.width - 6 && strWidth > ellipsisWidth) {
/* 75 */         buttonText = mc.fontRenderer.trimStringToWidth(buttonText, this.width - 6 - ellipsisWidth).trim() + "...";
/*    */       }
/* 77 */       drawCenteredString(mc.fontRenderer, buttonText, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiButtonExt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */