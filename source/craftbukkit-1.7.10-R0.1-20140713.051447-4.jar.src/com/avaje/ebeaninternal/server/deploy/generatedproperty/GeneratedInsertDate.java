/*    */ package com.avaje.ebeaninternal.server.deploy.generatedproperty;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanProperty;
/*    */ import java.util.Date;
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
/*    */ public class GeneratedInsertDate
/*    */   implements GeneratedProperty
/*    */ {
/*    */   public Object getInsertValue(BeanProperty prop, Object bean) {
/* 35 */     return new Date(System.currentTimeMillis());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getUpdateValue(BeanProperty prop, Object bean) {
/* 42 */     return prop.getValue(bean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean includeInUpdate() {
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean includeInInsert() {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isDDLNotNullable() {
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\generatedproperty\GeneratedInsertDate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */