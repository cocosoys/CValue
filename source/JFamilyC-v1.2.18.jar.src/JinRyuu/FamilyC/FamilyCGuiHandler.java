/*    */ package JinRyuu.FamilyC;
/*    */ 
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
/*    */ public class FamilyCGuiHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 28 */     Object Gui = null;
/*    */     
/* 30 */     Gui = new FamilyCCharGui(id);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     return Gui;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyCGuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */