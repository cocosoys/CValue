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
/*    */ public class AssertTrueValidatorFactory
/*    */   implements ValidatorFactory
/*    */ {
/* 15 */   public static final Validator ASSERT_TRUE = new AssertTrueValidator();
/*    */   
/*    */   public Validator create(Annotation annotation, Class<?> type) {
/* 18 */     return ASSERT_TRUE;
/*    */   }
/*    */   
/*    */   public static class AssertTrueValidator
/*    */     extends NoAttributesValidator {
/*    */     public String getKey() {
/* 24 */       return "asserttrue";
/*    */     }
/*    */     
/*    */     public boolean isValid(Object value) {
/* 28 */       if (value == null) {
/* 29 */         return true;
/*    */       }
/* 31 */       return ((Boolean)value).booleanValue();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\validation\factory\AssertTrueValidatorFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */