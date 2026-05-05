/*    */ package com.avaje.ebeaninternal.server.deploy;
/*    */ 
/*    */ import java.util.Map;
/*    */ import scala.collection.JavaConversions;
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
/*    */ public class ScalaMapConverter
/*    */   implements CollectionTypeConverter
/*    */ {
/*    */   public Object toUnderlying(Object wrapped) {
/* 34 */     if (wrapped instanceof JavaConversions.JMapWrapper) {
/* 35 */       return ((JavaConversions.JMapWrapper)wrapped).underlying();
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public Object toWrapped(Object wrapped) {
/* 41 */     if (wrapped instanceof Map) {
/* 42 */       return JavaConversions.asMap((Map)wrapped);
/*    */     }
/* 44 */     return wrapped;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\ScalaMapConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */