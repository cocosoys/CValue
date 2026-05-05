/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.DuplicateModsFoundException;
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import java.io.File;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.gui.GuiErrorScreen;
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
/*    */ public class GuiDupesFound
/*    */   extends GuiErrorScreen
/*    */ {
/*    */   private DuplicateModsFoundException dupes;
/*    */   
/*    */   public GuiDupesFound(DuplicateModsFoundException dupes) {
/* 29 */     super(null, null);
/* 30 */     this.dupes = dupes;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 39 */     super.initGui();
/* 40 */     this.buttonList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 48 */     drawDefaultBackground();
/* 49 */     int offset = Math.max(85 - this.dupes.dupes.size() * 10, 10);
/* 50 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, offset, 16777215);
/* 51 */     offset += 10;
/* 52 */     drawCenteredString(this.fontRendererObj, "You have mod sources that are duplicate within your system", this.width / 2, offset, 16777215);
/* 53 */     offset += 10;
/* 54 */     drawCenteredString(this.fontRendererObj, "Mod Id : File name", this.width / 2, offset, 16777215);
/* 55 */     offset += 5;
/* 56 */     for (Map.Entry<ModContainer, File> mc : (Iterable<Map.Entry<ModContainer, File>>)this.dupes.dupes.entries()) {
/*    */       
/* 58 */       offset += 10;
/* 59 */       drawCenteredString(this.fontRendererObj, String.format("%s : %s", new Object[] { ((ModContainer)mc.getKey()).getModId(), ((File)mc.getValue()).getName() }), this.width / 2, offset, 15658734);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiDupesFound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */