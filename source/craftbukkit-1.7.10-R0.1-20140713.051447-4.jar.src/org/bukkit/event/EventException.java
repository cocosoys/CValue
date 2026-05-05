/*    */ package org.bukkit.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EventException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 3532808232324183999L;
/*    */   private final Throwable cause;
/*    */   
/*    */   public EventException(Throwable throwable) {
/* 13 */     this.cause = throwable;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EventException() {
/* 20 */     this.cause = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EventException(Throwable cause, String message) {
/* 30 */     super(message);
/* 31 */     this.cause = cause;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EventException(String message) {
/* 40 */     super(message);
/* 41 */     this.cause = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Throwable getCause() {
/* 51 */     return this.cause;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\EventException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */