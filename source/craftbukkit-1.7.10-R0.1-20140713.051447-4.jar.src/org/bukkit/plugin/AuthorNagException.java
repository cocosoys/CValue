/*    */ package org.bukkit.plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AuthorNagException
/*    */   extends RuntimeException
/*    */ {
/*    */   private final String message;
/*    */   
/*    */   public AuthorNagException(String message) {
/* 13 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 18 */     return this.message;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\AuthorNagException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */