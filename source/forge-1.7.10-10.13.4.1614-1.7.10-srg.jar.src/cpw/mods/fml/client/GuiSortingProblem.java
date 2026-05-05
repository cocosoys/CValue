/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import cpw.mods.fml.common.toposort.ModSortingException;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ public class GuiSortingProblem
/*    */   extends GuiScreen
/*    */ {
/*    */   private ModSortingException.SortingExceptionData<ModContainer> failedList;
/*    */   
/*    */   public GuiSortingProblem(ModSortingException modSorting) {
/* 13 */     this.failedList = modSorting.getExceptionData();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 22 */     super.initGui();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 31 */     drawDefaultBackground();
/* 32 */     int offset = Math.max(85 - (this.failedList.getVisitedNodes().size() + 3) * 10, 10);
/* 33 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, offset, 16777215);
/* 34 */     offset += 10;
/* 35 */     drawCenteredString(this.fontRendererObj, "A mod sorting cycle was detected and loading cannot continue", this.width / 2, offset, 16777215);
/* 36 */     offset += 10;
/* 37 */     drawCenteredString(this.fontRendererObj, String.format("The first mod in the cycle is %s", new Object[] { this.failedList.getFirstBadNode() }), this.width / 2, offset, 16777215);
/* 38 */     offset += 10;
/* 39 */     drawCenteredString(this.fontRendererObj, "The remainder of the cycle involves these mods", this.width / 2, offset, 16777215);
/* 40 */     offset += 5;
/* 41 */     for (ModContainer mc : this.failedList.getVisitedNodes()) {
/*    */       
/* 43 */       offset += 10;
/* 44 */       drawCenteredString(this.fontRendererObj, String.format("%s : before: %s, after: %s", new Object[] { mc.toString(), mc.getDependants(), mc.getDependencies() }), this.width / 2, offset, 15658734);
/*    */     } 
/* 46 */     offset += 20;
/* 47 */     drawCenteredString(this.fontRendererObj, "The file 'ForgeModLoader-client-0.log' contains more information", this.width / 2, offset, 16777215);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiSortingProblem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */