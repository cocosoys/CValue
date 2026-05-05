/*    */ package cpw.mods.fml.common.functions;
/*    */ 
/*    */ import com.google.common.base.Function;
/*    */ 
/*    */ public class TypeCastFunction<T> implements Function<Object, T> {
/*    */   private Class<T> type;
/*    */   
/*    */   public TypeCastFunction(Class<T> type) {
/*  9 */     this.type = type;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public T apply(Object input) {
/* 15 */     return this.type.cast(input);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\TypeCastFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */