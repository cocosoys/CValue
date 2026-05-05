/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ public class GuiModOptionList
/*    */   extends GuiScrollingList
/*    */ {
/*    */   private GuiIngameModOptions parent;
/*    */   
/*    */   public GuiModOptionList(GuiIngameModOptions parent) {
/* 11 */     super(parent.mc, 150, parent.height, 32, parent.height - 65 + 4, 10, 35);
/* 12 */     this.parent = parent;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int getSize() {
/* 18 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void elementClicked(int index, boolean doubleClick) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isSelected(int index) {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawBackground() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5) {
/* 42 */     this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("Test 1", this.listWidth - 10), this.left + 3, var3 + 2, 16720418);
/* 43 */     this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("TEST 2", this.listWidth - 10), this.left + 3, var3 + 12, 16720418);
/* 44 */     this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("DISABLED", this.listWidth - 10), this.left + 3, var3 + 22, 16720418);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiModOptionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */