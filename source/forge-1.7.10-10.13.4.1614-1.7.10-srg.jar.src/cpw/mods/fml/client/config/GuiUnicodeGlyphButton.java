/*    */ package cpw.mods.fml.client.config;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.lwjgl.opengl.GL11;
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
/*    */ public class GuiUnicodeGlyphButton
/*    */   extends GuiButtonExt
/*    */ {
/*    */   public String glyph;
/*    */   public float glyphScale;
/*    */   
/*    */   public GuiUnicodeGlyphButton(int id, int xPos, int yPos, int width, int height, String displayString, String glyph, float glyphScale) {
/* 31 */     super(id, xPos, yPos, width, height, displayString);
/* 32 */     this.glyph = glyph;
/* 33 */     this.glyphScale = glyphScale;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 42 */     if (this.visible) {
/*    */       
/* 44 */       this.field_146123_n = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 45 */       int k = getHoverState(this.field_146123_n);
/* 46 */       GuiUtils.drawContinuousTexturedBox(buttonTextures, this.xPosition, this.yPosition, 0, 46 + k * 20, this.width, this.height, 200, 20, 2, 3, 2, 2, this.zLevel);
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
/* 58 */       else if (this.field_146123_n) {
/*    */         
/* 60 */         color = 16777120;
/*    */       } 
/*    */       
/* 63 */       String buttonText = this.displayString;
/* 64 */       int glyphWidth = (int)(mc.fontRenderer.getStringWidth(this.glyph) * this.glyphScale);
/* 65 */       int strWidth = mc.fontRenderer.getStringWidth(buttonText);
/* 66 */       int elipsisWidth = mc.fontRenderer.getStringWidth("...");
/* 67 */       int totalWidth = strWidth + glyphWidth;
/*    */       
/* 69 */       if (totalWidth > this.width - 6 && totalWidth > elipsisWidth) {
/* 70 */         buttonText = mc.fontRenderer.trimStringToWidth(buttonText, this.width - 6 - elipsisWidth).trim() + "...";
/*    */       }
/* 72 */       strWidth = mc.fontRenderer.getStringWidth(buttonText);
/* 73 */       totalWidth = glyphWidth + strWidth;
/*    */       
/* 75 */       GL11.glPushMatrix();
/* 76 */       GL11.glScalef(this.glyphScale, this.glyphScale, 1.0F);
/* 77 */       drawCenteredString(mc.fontRenderer, this.glyph, (int)((this.xPosition + this.width / 2 - strWidth / 2) / this.glyphScale - glyphWidth / 2.0F * this.glyphScale + 2.0F), (int)((this.yPosition + (this.height - 8) / this.glyphScale / 2.0F - 1.0F) / this.glyphScale), color);
/*    */ 
/*    */       
/* 80 */       GL11.glPopMatrix();
/*    */       
/* 82 */       drawCenteredString(mc.fontRenderer, buttonText, (int)((this.xPosition + this.width / 2) + glyphWidth / this.glyphScale), this.yPosition + (this.height - 8) / 2, color);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiUnicodeGlyphButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */