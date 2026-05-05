/*    */ package com.avaje.ebeaninternal.server.deploy;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.deploy.meta.DeployBeanProperty;
/*    */ import com.avaje.ebeaninternal.server.reflect.BeanReflectSetter;
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
/*    */ public class ReflectSetter
/*    */ {
/*    */   public static BeanReflectSetter create(DeployBeanProperty prop) {
/* 39 */     return new NeverCalled(prop.getFullBeanName());
/*    */   }
/*    */   
/*    */   public static class NeverCalled
/*    */     implements BeanReflectSetter {
/*    */     private final String property;
/*    */     
/*    */     public NeverCalled(String property) {
/* 47 */       this.property = property;
/*    */     }
/*    */     
/*    */     public void set(Object bean, Object value) {
/* 51 */       throw new RuntimeException("Should never be called on " + this.property);
/*    */     }
/*    */     
/*    */     public void setIntercept(Object bean, Object value) {
/* 55 */       throw new RuntimeException("Should never be called on " + this.property);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\ReflectSetter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */