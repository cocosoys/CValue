/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.MissingModsException;
/*    */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*    */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
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
/*    */ public class GuiModsMissing
/*    */   extends GuiErrorScreen
/*    */ {
/*    */   private MissingModsException modsMissing;
/*    */   
/*    */   public GuiModsMissing(MissingModsException modsMissing) {
/* 27 */     super(null, null);
/* 28 */     this.modsMissing = modsMissing;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 37 */     super.initGui();
/* 38 */     this.buttonList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 46 */     drawDefaultBackground();
/* 47 */     int offset = Math.max(85 - this.modsMissing.missingMods.size() * 10, 10);
/* 48 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, offset, 16777215);
/* 49 */     offset += 10;
/* 50 */     drawCenteredString(this.fontRendererObj, "The mods and versions listed below could not be found", this.width / 2, offset, 16777215);
/* 51 */     offset += 5;
/* 52 */     for (ArtifactVersion v : this.modsMissing.missingMods) {
/*    */       
/* 54 */       offset += 10;
/* 55 */       if (v instanceof DefaultArtifactVersion) {
/*    */         
/* 57 */         DefaultArtifactVersion dav = (DefaultArtifactVersion)v;
/* 58 */         if (dav.getRange() != null && dav.getRange().isUnboundedAbove()) {
/*    */           
/* 60 */           drawCenteredString(this.fontRendererObj, String.format("%s : minimum version required is %s", new Object[] { v.getLabel(), dav.getRange().getLowerBoundString() }), this.width / 2, offset, 15658734);
/*    */           continue;
/*    */         } 
/*    */       } 
/* 64 */       drawCenteredString(this.fontRendererObj, String.format("%s : %s", new Object[] { v.getLabel(), v.getRangeString() }), this.width / 2, offset, 15658734);
/*    */     } 
/* 66 */     offset += 20;
/* 67 */     drawCenteredString(this.fontRendererObj, "The file 'logs/fml-client-latest.log' contains more information", this.width / 2, offset, 16777215);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiModsMissing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */