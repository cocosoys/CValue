/*   */ package JinRyuu.JBRA;
/*   */ 
/*   */ import cpw.mods.fml.common.FMLCommonHandler;
/*   */ 
/*   */ public class JBRA {
/*   */   public void registerRenderThings() {}
/*   */   
/*   */   public void registerTicks() {
/* 9 */     FMLCommonHandler.instance().bus().register(new JBRAComTickH());
/*   */   }
/*   */   
/*   */   public void postInit() {}
/*   */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */