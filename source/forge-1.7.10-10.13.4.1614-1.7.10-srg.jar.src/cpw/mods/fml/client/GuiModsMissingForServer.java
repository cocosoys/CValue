/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.MissingModsException;
/*    */ import cpw.mods.fml.common.versioning.ArtifactVersion;
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
/*    */ 
/*    */ public class GuiModsMissingForServer
/*    */   extends GuiScreen
/*    */ {
/*    */   private MissingModsException modsMissing;
/*    */   
/*    */   public GuiModsMissingForServer(MissingModsException modsMissing) {
/* 27 */     this.modsMissing = modsMissing;
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
/* 45 */       FMLClientHandler.instance().showGuiScreen(null);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 54 */     drawDefaultBackground();
/* 55 */     int offset = Math.max(85 - this.modsMissing.missingMods.size() * 10, 10);
/* 56 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader could not connect to this server", this.width / 2, offset, 16777215);
/* 57 */     offset += 10;
/* 58 */     drawCenteredString(this.fontRendererObj, "The mods and versions listed below could not be found", this.width / 2, offset, 16777215);
/* 59 */     offset += 10;
/* 60 */     drawCenteredString(this.fontRendererObj, "They are required to play on this server", this.width / 2, offset, 16777215);
/* 61 */     offset += 5;
/* 62 */     for (ArtifactVersion v : this.modsMissing.missingMods) {
/*    */       
/* 64 */       offset += 10;
/* 65 */       drawCenteredString(this.fontRendererObj, String.format("%s : %s", new Object[] { v.getLabel(), v.getRangeString() }), this.width / 2, offset, 15658734);
/*    */     } 
/* 67 */     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiModsMissingForServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */