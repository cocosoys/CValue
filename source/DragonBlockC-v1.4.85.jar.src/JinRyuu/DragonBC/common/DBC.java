/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerServer;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import java.io.File;
/*    */ import net.minecraft.world.storage.SaveHandler;
/*    */ 
/*    */ public class DBC
/*    */ {
/*    */   public static SaveHandler saveHandler;
/* 12 */   public static DBCPacketHandlerServer phs = new DBCPacketHandlerServer(); public void postInit() {}
/*    */   public void registerRenderThings() {}
/*    */   public void initialize() {
/* 15 */     FMLCommonHandler.instance().bus().register(new DBCCommonTickHandler());
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerTicks() {}
/*    */   
/*    */   public void registerKeys() {}
/*    */   
/*    */   public String getMinecraftVersion() {
/* 24 */     return Loader.instance().getMinecraftModContainer().getVersion(); } public File getMinecraftDir() {
/* 25 */     return new File(".");
/*    */   }
/*    */   
/*    */   public void registerDBCRender() {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */