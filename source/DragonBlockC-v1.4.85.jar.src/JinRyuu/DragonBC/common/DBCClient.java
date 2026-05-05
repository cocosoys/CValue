/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Gui.DBCKiGui;
/*    */ import JinRyuu.DragonBC.common.Gui.DBCSAAGui;
/*    */ import JinRyuu.DragonBC.common.Gui.DBCSagaGui;
/*    */ import JinRyuu.DragonBC.common.Gui.DBCWishGui;
/*    */ import JinRyuu.DragonBC.common.Gui.ScouterGui;
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntitiesDBC;
/*    */ import JinRyuu.JRMCore.p.DBC.DBCPacketHandlerClient;
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.io.File;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DBCClient
/*    */   extends DBC
/*    */ {
/*    */   public static ScouterGui scouterGui;
/*    */   public static DBCSagaGui SagaSys;
/*    */   public static DBCKiGui KiGui;
/*    */   public static DBCWishGui WishGui;
/*    */   public static DBCSAAGui SAAGui;
/* 28 */   public static Minecraft mc = Minecraft.func_71410_x();
/*    */   
/* 30 */   public static DBCPacketHandlerClient phc = new DBCPacketHandlerClient();
/*    */ 
/*    */   
/*    */   public void initialize() {
/* 34 */     super.initialize();
/* 35 */     FMLCommonHandler.instance().bus().register(new DBCClientTickHandler());
/*    */   }
/*    */   
/*    */   public void postInit() {
/* 39 */     super.postInit();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerRenderThings() {
/* 45 */     scouterGui = new ScouterGui();
/* 46 */     SagaSys = new DBCSagaGui();
/* 47 */     KiGui = new DBCKiGui(0);
/* 48 */     WishGui = new DBCWishGui(0);
/* 49 */     SAAGui = new DBCSAAGui(2);
/*    */     
/* 51 */     ItemsDBC.client();
/* 52 */     EntitiesDBC.client();
/*    */   }
/*    */   
/*    */   public void registerKeys() {
/* 56 */     ClientRegistry.registerKeyBinding(DBCKeyHandler.ScFunc);
/* 57 */     ClientRegistry.registerKeyBinding(DBCKeyHandler.thirdFn);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerTicks() {}
/*    */ 
/*    */   
/*    */   public File getMinecraftDir() {
/* 66 */     return (Minecraft.func_71410_x()).field_71412_D;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */