/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Render.ArtGravDevContainer;
/*    */ import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.p.DBC.DBCPspacepod1;
/*    */ import JinRyuu.JRMCore.p.PD;
/*    */ import cpw.mods.fml.common.network.IGuiHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBCGuiHandler
/*    */   implements IGuiHandler
/*    */ {
/*    */   public static final int ArtGravDevGui = 5;
/*    */   
/*    */   public Object getServerGuiElement(int id, EntityPlayer p, World world, int x, int y, int z) {
/* 27 */     if (id == 5) {
/* 28 */       TileEntity tile_entity = world.func_147438_o(x, y, z);
/* 29 */       return new ArtGravDevContainer(p.field_71071_by, (ArtGravDevTileEntity)tile_entity);
/*    */     } 
/*    */     
/* 32 */     if (id == 13)
/* 33 */       PD.sendTo((IMessage)new DBCPspacepod1(JRMCoreH.getInt(p, "DBCSenzu")), (EntityPlayerMP)p); 
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/* 40 */     TileEntity te = world.func_147438_o(x, y, z);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 50 */     Object Gui = null;
/* 51 */     if (id == 0)
/* 52 */       Gui = new DBCGuiSpacePod01(x, y, z); 
/* 53 */     if (id == 1)
/*    */     {
/* 55 */       Gui = new DBCKiGui(player.getEntityData().func_74762_e("DBCKiCharge"));
/*    */     }
/* 57 */     if (id == 2)
/* 58 */       Gui = new DBCWishGui(1); 
/* 59 */     if (id == 3)
/* 60 */       Gui = new DBCWishGui(2); 
/* 61 */     if (id == 5)
/* 62 */       Gui = new DBCGuiArtGravDev(player.field_71071_by, (ArtGravDevTileEntity)te); 
/* 63 */     if (id == 6)
/* 64 */       Gui = new DBCSAAGui(1); 
/* 65 */     if (id == 7)
/* 66 */       Gui = new DBCSAAGui(5); 
/* 67 */     if (id >= 10) {
/* 68 */       Gui = new DBCTalkGui(id, world, x, y, z);
/*    */     }
/* 70 */     return Gui;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCGuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */