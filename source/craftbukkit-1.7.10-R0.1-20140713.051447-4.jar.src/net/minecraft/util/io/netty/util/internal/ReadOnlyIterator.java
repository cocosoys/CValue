/*    */ package net.minecraft.util.io.netty.util.internal;
/*    */ 
/*    */ import java.util.Iterator;
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
/*    */ public final class ReadOnlyIterator<T>
/*    */   implements Iterator<T>
/*    */ {
/*    */   private final Iterator<? extends T> iterator;
/*    */   
/*    */   public ReadOnlyIterator(Iterator<? extends T> iterator) {
/* 25 */     if (iterator == null) {
/* 26 */       throw new NullPointerException("iterator");
/*    */     }
/* 28 */     this.iterator = iterator;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 33 */     return this.iterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public T next() {
/* 38 */     return this.iterator.next();
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 43 */     throw new UnsupportedOperationException("read-only");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\nett\\util\internal\ReadOnlyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */