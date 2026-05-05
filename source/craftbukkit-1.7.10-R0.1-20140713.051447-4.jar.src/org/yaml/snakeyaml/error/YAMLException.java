/*    */ package org.yaml.snakeyaml.error;
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
/*    */ public class YAMLException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -4738336175050337570L;
/*    */   
/*    */   public YAMLException(String message) {
/* 23 */     super(message);
/*    */   }
/*    */   
/*    */   public YAMLException(Throwable cause) {
/* 27 */     super(cause);
/*    */   }
/*    */   
/*    */   public YAMLException(String message, Throwable cause) {
/* 31 */     super(message, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\error\YAMLException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */