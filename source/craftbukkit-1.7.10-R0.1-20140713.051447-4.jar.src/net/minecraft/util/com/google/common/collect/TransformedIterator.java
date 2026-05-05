/*    */ package net.minecraft.util.com.google.common.collect;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import net.minecraft.util.com.google.common.annotations.GwtCompatible;
/*    */ import net.minecraft.util.com.google.common.base.Preconditions;
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
/*    */ @GwtCompatible
/*    */ abstract class TransformedIterator<F, T>
/*    */   implements Iterator<T>
/*    */ {
/*    */   final Iterator<? extends F> backingIterator;
/*    */   
/*    */   TransformedIterator(Iterator<? extends F> backingIterator) {
/* 36 */     this.backingIterator = (Iterator<? extends F>)Preconditions.checkNotNull(backingIterator);
/*    */   }
/*    */ 
/*    */   
/*    */   abstract T transform(F paramF);
/*    */   
/*    */   public final boolean hasNext() {
/* 43 */     return this.backingIterator.hasNext();
/*    */   }
/*    */ 
/*    */   
/*    */   public final T next() {
/* 48 */     return transform(this.backingIterator.next());
/*    */   }
/*    */ 
/*    */   
/*    */   public final void remove() {
/* 53 */     this.backingIterator.remove();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\collect\TransformedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */