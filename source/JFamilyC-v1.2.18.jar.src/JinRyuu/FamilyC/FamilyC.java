/*    */ package JinRyuu.FamilyC;
/*    */ 
/*    */ import JinRyuu.JRMCore.p.FamilyCP;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ 
/*    */ public class FamilyC
/*    */ {
/*    */   public void registerRenderThings() {}
/*    */   
/*    */   public void registerTicks() {
/* 11 */     FMLCommonHandler.instance().bus().register(new FamilyCComTickH());
/*    */   }
/* 13 */   public static Class[] registerPackets = new Class[] { FamilyCP.class };
/*    */   
/*    */   public void postInit() {}
/*    */   
/*    */   public void registerKeys() {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\FamilyC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */