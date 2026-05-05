/*    */ package com.avaje.ebeaninternal.server.query;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.lucene.LIndex;
/*    */ import com.avaje.ebeaninternal.server.lucene.LIndexField;
/*    */ import java.util.Set;
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
/*    */ public class LuceneResolvableRequest
/*    */ {
/*    */   private final BeanDescriptor<?> beanDescriptor;
/*    */   private final LIndex luceneIndex;
/*    */   private final Set<String> resolvePropertyNames;
/*    */   
/*    */   public LuceneResolvableRequest(BeanDescriptor<?> beanDescriptor, LIndex luceneIndex) {
/* 37 */     this.beanDescriptor = beanDescriptor;
/* 38 */     this.luceneIndex = luceneIndex;
/* 39 */     this.resolvePropertyNames = luceneIndex.getResolvePropertyNames();
/*    */   }
/*    */   
/*    */   public boolean indexContains(String propertyName) {
/* 43 */     return this.resolvePropertyNames.contains(propertyName);
/*    */   }
/*    */   
/*    */   public LIndexField getSortableProperty(String propertyName) {
/* 47 */     return this.luceneIndex.getIndexFieldDefn().getSortableField(propertyName);
/*    */   }
/*    */   
/*    */   public BeanDescriptor<?> getBeanDescriptor() {
/* 51 */     return this.beanDescriptor;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\query\LuceneResolvableRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */