/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import JinRyuu.JRMCore.i.ContainerCustomPlayer;
/*    */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*    */ import JinRyuu.JRMCore.i.GuiCustomPlayerInventory;
/*    */ import cpw.mods.fml.common.network.IGuiHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
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
/*    */ public class JRMCoreGuiHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
/* 45 */     if (guiId == mod_JRMCore.GUI_CUSTOM_INV) {
/* 46 */       return new ContainerCustomPlayer(player, player.field_71071_by, (ExtendedPlayer.get(player)).inventory);
/*    */     }
/*    */ 
/*    */     
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
/* 56 */     if (guiId == mod_JRMCore.GUI_CUSTOM_INV)
/* 57 */       return new GuiCustomPlayerInventory(player, player.field_71071_by, (ExtendedPlayer.get(player)).inventory); 
/* 58 */     if (guiId >= 0) {
/* 59 */       return new JRMCoreGuiScreen(guiId);
/*    */     }
/*    */     
/* 62 */     if (guiId == -1) {
/* 63 */       return new JRMCoreGuiSCM();
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreGuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */