/*    */ package com.avaje.ebean;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import javax.persistence.PersistenceException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidationException
/*    */   extends PersistenceException
/*    */ {
/*    */   private static final long serialVersionUID = -6185355529565362494L;
/*    */   final InvalidValue invalid;
/*    */   
/*    */   public ValidationException(InvalidValue invalid) {
/* 17 */     super("validation failed for: " + invalid.getBeanType());
/* 18 */     this.invalid = invalid;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvalidValue getInvalid() {
/* 29 */     return this.invalid;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InvalidValue[] getErrors() {
/* 40 */     return this.invalid.getErrors();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 44 */     return super.toString() + ": " + Arrays.toString((Object[])getErrors());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\ValidationException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */