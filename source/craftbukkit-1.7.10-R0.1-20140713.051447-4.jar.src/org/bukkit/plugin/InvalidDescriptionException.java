/*    */ package org.bukkit.plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvalidDescriptionException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 5721389122281775896L;
/*    */   
/*    */   public InvalidDescriptionException(Throwable cause, String message) {
/* 17 */     super(message, cause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvalidDescriptionException(Throwable cause) {
/* 27 */     super("Invalid plugin.yml", cause);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvalidDescriptionException(String message) {
/* 36 */     super(message);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvalidDescriptionException() {
/* 43 */     super("Invalid plugin.yml");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\InvalidDescriptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */