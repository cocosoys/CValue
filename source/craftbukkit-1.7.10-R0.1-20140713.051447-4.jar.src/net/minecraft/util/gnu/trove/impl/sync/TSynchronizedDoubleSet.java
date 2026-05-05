/*    */ package net.minecraft.util.gnu.trove.impl.sync;
/*    */ 
/*    */ import net.minecraft.util.gnu.trove.TDoubleCollection;
/*    */ import net.minecraft.util.gnu.trove.set.TDoubleSet;
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
/*    */ public class TSynchronizedDoubleSet
/*    */   extends TSynchronizedDoubleCollection
/*    */   implements TDoubleSet
/*    */ {
/*    */   private static final long serialVersionUID = 487447009682186044L;
/*    */   
/*    */   public TSynchronizedDoubleSet(TDoubleSet s) {
/* 58 */     super((TDoubleCollection)s);
/*    */   }
/*    */   public TSynchronizedDoubleSet(TDoubleSet s, Object mutex) {
/* 61 */     super((TDoubleCollection)s, mutex);
/*    */   }
/*    */   
/*    */   public boolean equals(Object o) {
/* 65 */     synchronized (this.mutex) { return this.c.equals(o); }
/*    */   
/*    */   } public int hashCode() {
/* 68 */     synchronized (this.mutex) { return this.c.hashCode(); }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\impl\sync\TSynchronizedDoubleSet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */