/*    */ package net.minecraft.util.gnu.trove.procedure.array;
/*    */ 
/*    */ import net.minecraft.util.gnu.trove.procedure.TObjectProcedure;
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
/*    */ public final class ToObjectArrayProceedure<T>
/*    */   implements TObjectProcedure<T>
/*    */ {
/*    */   private final T[] target;
/* 37 */   private int pos = 0;
/*    */ 
/*    */   
/*    */   public ToObjectArrayProceedure(T[] target) {
/* 41 */     this.target = target;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean execute(T value) {
/* 46 */     this.target[this.pos++] = value;
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\gnu\trove\procedure\array\ToObjectArrayProceedure.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */