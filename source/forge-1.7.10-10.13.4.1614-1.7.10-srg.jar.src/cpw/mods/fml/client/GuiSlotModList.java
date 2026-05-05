/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import cpw.mods.fml.common.LoaderState;
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.renderer.Tessellator;
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
/*    */ public class GuiSlotModList
/*    */   extends GuiScrollingList
/*    */ {
/*    */   private GuiModList parent;
/*    */   private ArrayList<ModContainer> mods;
/*    */   
/*    */   public GuiSlotModList(GuiModList parent, ArrayList<ModContainer> mods, int listWidth) {
/* 34 */     super(parent.getMinecraftInstance(), listWidth, parent.height, 32, parent.height - 66 + 4, 10, 35);
/* 35 */     this.parent = parent;
/* 36 */     this.mods = mods;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int getSize() {
/* 42 */     return this.mods.size();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void elementClicked(int var1, boolean var2) {
/* 48 */     this.parent.selectModIndex(var1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean isSelected(int var1) {
/* 54 */     return this.parent.modIndexSelected(var1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawBackground() {
/* 60 */     this.parent.drawDefaultBackground();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int getContentHeight() {
/* 66 */     return getSize() * 35 + 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5) {
/* 72 */     ModContainer mc = this.mods.get(listIndex);
/* 73 */     if (Loader.instance().getModState(mc) == LoaderState.ModState.DISABLED) {
/*    */       
/* 75 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getName(), this.listWidth - 10), this.left + 3, var3 + 2, 16720418);
/* 76 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getDisplayVersion(), this.listWidth - 10), this.left + 3, var3 + 12, 16720418);
/* 77 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth("DISABLED", this.listWidth - 10), this.left + 3, var3 + 22, 16720418);
/*    */     }
/*    */     else {
/*    */       
/* 81 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getName(), this.listWidth - 10), this.left + 3, var3 + 2, 16777215);
/* 82 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth(mc.getDisplayVersion(), this.listWidth - 10), this.left + 3, var3 + 12, 13421772);
/* 83 */       this.parent.getFontRenderer().drawString(this.parent.getFontRenderer().trimStringToWidth((mc.getMetadata() != null) ? mc.getMetadata().getChildModCountString() : "Metadata not found", this.listWidth - 10), this.left + 3, var3 + 22, 13421772);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiSlotModList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */