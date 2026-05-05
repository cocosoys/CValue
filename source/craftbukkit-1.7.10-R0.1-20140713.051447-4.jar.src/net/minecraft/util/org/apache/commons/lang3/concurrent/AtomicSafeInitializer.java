/*    */ package net.minecraft.util.org.apache.commons.lang3.concurrent;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicReference;
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
/*    */ public abstract class AtomicSafeInitializer<T>
/*    */   implements ConcurrentInitializer<T>
/*    */ {
/* 59 */   private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<AtomicSafeInitializer<T>>();
/*    */ 
/*    */ 
/*    */   
/* 63 */   private final AtomicReference<T> reference = new AtomicReference<T>();
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
/*    */   public final T get() throws ConcurrentException {
/*    */     T result;
/* 76 */     while ((result = this.reference.get()) == null) {
/* 77 */       if (this.factory.compareAndSet(null, this)) {
/* 78 */         this.reference.set(initialize());
/*    */       }
/*    */     } 
/*    */     
/* 82 */     return result;
/*    */   }
/*    */   
/*    */   protected abstract T initialize() throws ConcurrentException;
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\lang3\concurrent\AtomicSafeInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */