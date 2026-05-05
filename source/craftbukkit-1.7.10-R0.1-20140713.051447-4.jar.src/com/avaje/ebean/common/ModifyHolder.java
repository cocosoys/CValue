/*    */ package com.avaje.ebean.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedHashSet;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ModifyHolder<E>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2572572897923801083L;
/* 43 */   private Set<E> modifyDeletions = new LinkedHashSet<E>();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   private Set<E> modifyAdditions = new LinkedHashSet<E>();
/*    */   
/*    */   void reset() {
/* 51 */     this.modifyDeletions = new LinkedHashSet<E>();
/* 52 */     this.modifyAdditions = new LinkedHashSet<E>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void modifyAdditionAll(Collection<? extends E> c) {
/* 59 */     if (c != null) {
/* 60 */       this.modifyAdditions.addAll(c);
/*    */     }
/*    */   }
/*    */   
/*    */   void modifyAddition(E bean) {
/* 65 */     if (bean != null) {
/* 66 */       this.modifyAdditions.add(bean);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   void modifyRemoval(Object bean) {
/* 72 */     if (bean != null) {
/* 73 */       this.modifyDeletions.add((E)bean);
/*    */     }
/*    */   }
/*    */   
/*    */   Set<E> getModifyAdditions() {
/* 78 */     return this.modifyAdditions;
/*    */   }
/*    */   
/*    */   Set<E> getModifyRemovals() {
/* 82 */     return this.modifyDeletions;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\common\ModifyHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */