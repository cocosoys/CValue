/*   */ package JinRyuu.DragonBC.common;
/*   */ 
/*   */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*   */ 
/*   */ public class DBCLocHand {
/*   */   public static void LangLod() {
/* 7 */     for (String LocFile : DBCLoc.localFiles) {
/* 8 */       String File = LocFile.replace("es_AR", "es_ES").replace("es_MX", "es_ES").replace("pt_BR", "pt_PT");
/* 9 */       LanguageRegistry.instance().loadLocalization(File, DBCLocHlp.getLocFrmName(LocFile), DBCLocHlp.isXMLLangFil(File));
/*   */     } 
/*   */   }
/*   */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCLocHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */