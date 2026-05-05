/*    */ package cpw.mods.fml.common;
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
/*    */ public class LoaderException
/*    */   extends EnhancedRuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -5675297950958861378L;
/*    */   
/*    */   public LoaderException(Throwable wrapped) {
/* 24 */     super(wrapped);
/*    */   }
/*    */ 
/*    */   
/*    */   public LoaderException() {}
/*    */ 
/*    */   
/*    */   public LoaderException(String message) {
/* 32 */     super(message);
/*    */   }
/*    */   
/*    */   protected void printStackTrace(EnhancedRuntimeException.WrappedPrintStream stream) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\LoaderException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */