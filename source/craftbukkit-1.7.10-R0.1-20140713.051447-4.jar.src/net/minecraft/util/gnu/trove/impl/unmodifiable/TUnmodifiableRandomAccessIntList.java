/*    */ package net.minecraft.util.gnu.trove.impl.unmodifiable;
/*    */ 
/*    */ import java.util.RandomAccess;
/*    */ import net.minecraft.util.gnu.trove.list.TIntList;
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
/*    */ public class TUnmodifiableRandomAccessIntList
/*    */   extends TUnmodifiableIntList
/*    */   implements RandomAccess
/*    */ {
/*    */   private static final long serialVersionUID = -2542308836966382001L;
/*    */   
/*    */   public TUnmodifiableRandomAccessIntList(TIntList list) {
/* 58 */     super(list);
/*    */   }
/*    */   
/*    */   public TIntList subList(int fromIndex, int toIndex) {
/* 62 */     return new TUnmodifiableRandomAccessIntList(this.list.subList(fromIndex, toIndex));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Object writeReplace() {
/* 72 */     return new TUnmodifiableIntList(this.list);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\imp\\unmodifiable\TUnmodifiableRandomAccessIntList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */