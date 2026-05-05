/*    */ package com.avaje.ebean.validation.factory;
/*    */ 
/*    */ import java.lang.annotation.Annotation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NotNullValidatorFactory
/*    */   implements ValidatorFactory
/*    */ {
/* 15 */   public static final Validator NOT_NULL = new NotNullValidator();
/*    */   
/*    */   public Validator create(Annotation annotation, Class<?> type) {
/* 18 */     return NOT_NULL;
/*    */   }
/*    */   
/*    */   public static class NotNullValidator
/*    */     extends NoAttributesValidator {
/*    */     public String getKey() {
/* 24 */       return "notnull";
/*    */     }
/*    */     
/*    */     public boolean isValid(Object value) {
/* 28 */       return (value != null);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\validation\factory\NotNullValidatorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */