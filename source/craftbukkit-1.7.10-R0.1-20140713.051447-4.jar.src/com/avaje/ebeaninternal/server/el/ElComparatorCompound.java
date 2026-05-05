/*    */ package com.avaje.ebeaninternal.server.el;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */ public final class ElComparatorCompound<T>
/*    */   implements Comparator<T>, ElComparator<T>
/*    */ {
/*    */   private final ElComparator<T>[] array;
/*    */   
/*    */   public ElComparatorCompound(ElComparator<T>[] array) {
/* 35 */     this.array = array;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(T o1, T o2) {
/* 40 */     for (int i = 0; i < this.array.length; i++) {
/* 41 */       int ret = this.array[i].compare(o1, o2);
/* 42 */       if (ret != 0) {
/* 43 */         return ret;
/*    */       }
/*    */     } 
/*    */     
/* 47 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareValue(Object value, T o2) {
/* 52 */     for (int i = 0; i < this.array.length; i++) {
/* 53 */       int ret = this.array[i].compareValue(value, o2);
/* 54 */       if (ret != 0) {
/* 55 */         return ret;
/*    */       }
/*    */     } 
/*    */     
/* 59 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\el\ElComparatorCompound.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */