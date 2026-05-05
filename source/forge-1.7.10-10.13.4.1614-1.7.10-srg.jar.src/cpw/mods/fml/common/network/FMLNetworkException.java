/*    */ package cpw.mods.fml.common.network;
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
/*    */ public class FMLNetworkException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public FMLNetworkException(Exception e) {
/* 21 */     super(e);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FMLNetworkException() {}
/*    */ 
/*    */   
/*    */   public FMLNetworkException(String string) {
/* 30 */     super(string);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLNetworkException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */