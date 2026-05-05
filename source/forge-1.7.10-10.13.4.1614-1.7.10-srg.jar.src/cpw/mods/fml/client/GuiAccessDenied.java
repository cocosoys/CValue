/*    */ package cpw.mods.fml.client;
/*    */ 
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.multiplayer.ServerData;
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
/*    */ public class GuiAccessDenied
/*    */   extends GuiScreen
/*    */ {
/*    */   private GuiScreen parent;
/*    */   private ServerData data;
/*    */   
/*    */   public GuiAccessDenied(GuiScreen parent, ServerData data) {
/* 26 */     this.parent = parent;
/* 27 */     this.data = data;
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
/* 45 */       FMLClientHandler.instance().showGuiScreen(this.parent);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 54 */     drawDefaultBackground();
/* 55 */     int offset = Math.max(65, 10);
/* 56 */     drawCenteredString(this.fontRendererObj, "Forge Mod Loader could not connect to this server", this.width / 2, offset, 16777215);
/* 57 */     offset += 10;
/* 58 */     drawCenteredString(this.fontRendererObj, String.format("The server %s has forbidden modded access", new Object[] { this.data.serverName }), this.width / 2, offset, 16777215);
/* 59 */     super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\GuiAccessDenied.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */