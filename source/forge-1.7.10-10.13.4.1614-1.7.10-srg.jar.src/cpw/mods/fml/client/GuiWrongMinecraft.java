/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import cpw.mods.fml.common.WrongMinecraftVersionException;
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
/*    */ public class GuiWrongMinecraft
/*    */   extends GuiErrorScreen
/*    */ {
/*    */   private WrongMinecraftVersionException wrongMC;
/*    */   
/*    */   public GuiWrongMinecraft(WrongMinecraftVersionException wrongMC) {
/* 24 */     super(null, null);
/* 25 */     this.wrongMC = wrongMC;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 33 */     super.initGui();
/* 34 */     this.buttonList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 42 */     drawDefaultBackground();
/* 43 */     int offset = 75;
/* 44 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader has found a problem with your minecraft installation", this.width / 2, offset, 16777215);
/* 45 */     offset += 10;
/* 46 */     drawCenteredString(this.fontRendererObj, String.format("The mod listed below does not want to run in Minecraft version %s", new Object[] { Loader.instance().getMinecraftModContainer().getVersion() }), this.width / 2, offset, 16777215);
/* 47 */     offset += 5;
/* 48 */     offset += 10;
/* 49 */     drawCenteredString(this.fontRendererObj, String.format("%s (%s) wants Minecraft %s", new Object[] { this.wrongMC.mod.getName(), this.wrongMC.mod.getModId(), this.wrongMC.mod.acceptableMinecraftVersionRange() }), this.width / 2, offset, 15658734);
/* 50 */     offset += 20;
/* 51 */     drawCenteredString(this.fontRendererObj, "The file 'ForgeModLoader-client-0.log' contains more information", this.width / 2, offset, 16777215);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiWrongMinecraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */