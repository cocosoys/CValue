/*    */ package com.avaje.ebeaninternal.server.deploy;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.core.InternString;
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
/*    */ public class ExportedProperty
/*    */ {
/*    */   private final String foreignDbColumn;
/*    */   private final BeanProperty property;
/*    */   private final boolean embedded;
/*    */   
/*    */   public ExportedProperty(boolean embedded, String foreignDbColumn, BeanProperty property) {
/* 39 */     this.embedded = embedded;
/* 40 */     this.foreignDbColumn = InternString.intern(foreignDbColumn);
/* 41 */     this.property = property;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEmbedded() {
/* 48 */     return this.embedded;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getValue(Object bean) {
/* 55 */     return this.property.getValue(bean);
/*    */   }
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
/*    */   public String getForeignDbColumn() {
/* 68 */     return this.foreignDbColumn;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\ExportedProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */