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
/*    */ public class GuiCheckBox
/*    */   extends GuiButton
/*    */ {
/*    */   private boolean isChecked;
/*    */   private int boxWidth;
/*    */   
/*    */   public GuiCheckBox(int id, int xPos, int yPos, String displayString, boolean isChecked) {
/* 30 */     super(id, xPos, yPos, displayString);
/* 31 */     this.isChecked = isChecked;
/* 32 */     this.boxWidth = 11;
/* 33 */     this.height = 11;
/* 34 */     this.width = this.boxWidth + 2 + (Minecraft.getMinecraft()).fontRenderer.getStringWidth(displayString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 43 */     if (this.visible) {
/*    */       
/* 45 */       this.field_146123_n = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.boxWidth && mouseY < this.yPosition + this.height);
/* 46 */       GuiUtils.drawContinuousTexturedBox(buttonTextures, this.xPosition, this.yPosition, 0, 46, this.boxWidth, this.height, 200, 20, 2, 3, 2, 2, this.zLevel);
/* 47 */       mouseDragged(mc, mouseX, mouseY);
/* 48 */       int color = 14737632;
/*    */       
/* 50 */       if (this.packedFGColour != 0) {
/*    */         
/* 52 */         color = this.packedFGColour;
/*    */       }
/* 54 */       else if (!this.enabled) {
/*    */         
/* 56 */         color = 10526880;
/*    */       } 
/*    */       
/* 59 */       if (this.isChecked) {
/* 60 */         drawCenteredString(mc.fontRenderer, "x", this.xPosition + this.boxWidth / 2 + 1, this.yPosition + 1, 14737632);
/*    */       }
/* 62 */       drawString(mc.fontRenderer, this.displayString, this.xPosition + this.boxWidth + 2, this.yPosition + 2, color);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {
/* 73 */     if (this.enabled && this.visible && p_146116_2_ >= this.xPosition && p_146116_3_ >= this.yPosition && p_146116_2_ < this.xPosition + this.width && p_146116_3_ < this.yPosition + this.height) {
/*    */       
/* 75 */       this.isChecked = !this.isChecked;
/* 76 */       return true;
/*    */     } 
/*    */     
/* 79 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isChecked() {
/* 84 */     return this.isChecked;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setIsChecked(boolean isChecked) {
/* 89 */     this.isChecked = isChecked;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */