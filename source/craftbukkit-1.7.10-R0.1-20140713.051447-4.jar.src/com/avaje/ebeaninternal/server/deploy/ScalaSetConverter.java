/*    */ package com.avaje.ebeaninternal.server.deploy;
/*    */ 
/*    */ import java.util.Set;
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
/*    */ public class ScalaSetConverter
/*    */   implements CollectionTypeConverter
/*    */ {
/*    */   public Object toUnderlying(Object wrapped) {
/* 34 */     if (wrapped instanceof JavaConversions.JSetWrapper) {
/* 35 */       return ((JavaConversions.JSetWrapper)wrapped).underlying();
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public Object toWrapped(Object wrapped) {
/* 41 */     if (wrapped instanceof Set) {
/* 42 */       return JavaConversions.asSet((Set)wrapped);
/*    */     }
/* 44 */     return wrapped;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\ScalaSetConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */