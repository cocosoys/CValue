/*    */ package cpw.mods.fml.client.config;
/*    */ 
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
/*    */ public class HoverChecker
/*    */ {
/*    */   private int top;
/*    */   private int bottom;
/*    */   private int left;
/*    */   private int right;
/*    */   private int threshold;
/*    */   private GuiButton button;
/*    */   private long hoverStart;
/*    */   
/*    */   public HoverChecker(int top, int bottom, int left, int right, int threshold) {
/* 31 */     this.top = top;
/* 32 */     this.bottom = bottom;
/* 33 */     this.left = left;
/* 34 */     this.right = right;
/* 35 */     this.threshold = threshold;
/* 36 */     this.hoverStart = -1L;
/*    */   }
/*    */ 
/*    */   
/*    */   public HoverChecker(GuiButton button, int threshold) {
/* 41 */     this.button = button;
/* 42 */     this.threshold = threshold;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateBounds(int top, int bottom, int left, int right) {
/* 51 */     this.top = top;
/* 52 */     this.bottom = bottom;
/* 53 */     this.left = left;
/* 54 */     this.right = right;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean checkHover(int mouseX, int mouseY) {
/* 63 */     return checkHover(mouseX, mouseY, true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean checkHover(int mouseX, int mouseY, boolean canHover) {
/* 72 */     if (this.button != null) {
/*    */       
/* 74 */       this.top = this.button.yPosition;
/* 75 */       this.bottom = this.button.yPosition + this.button.height;
/* 76 */       this.left = this.button.xPosition;
/* 77 */       this.right = this.button.xPosition + this.button.width;
/* 78 */       canHover = (canHover && this.button.visible);
/*    */     } 
/*    */     
/* 81 */     if (canHover && this.hoverStart == -1L && mouseY >= this.top && mouseY <= this.bottom && mouseX >= this.left && mouseX <= this.right) {
/* 82 */       this.hoverStart = System.currentTimeMillis();
/* 83 */     } else if (!canHover || mouseY < this.top || mouseY > this.bottom || mouseX < this.left || mouseX > this.right) {
/* 84 */       resetHoverTimer();
/*    */     } 
/* 86 */     return (canHover && this.hoverStart != -1L && System.currentTimeMillis() - this.hoverStart >= this.threshold);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void resetHoverTimer() {
/* 94 */     this.hoverStart = -1L;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\HoverChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */