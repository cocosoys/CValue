/*    */ package cpw.mods.fml.common.functions;
/*    */ 
/*    */ import com.google.common.collect.Iterables;
/*    */ import com.google.common.collect.Iterators;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ public class GenericIterableFactory
/*    */ {
/*    */   public static <T> Iterable<T> newCastingIterable(final Iterator<?> input, final Class<T> type) {
/* 11 */     return new Iterable<T>()
/*    */       {
/*    */         
/*    */         public Iterator<T> iterator()
/*    */         {
/* 16 */           return Iterators.transform(input, new TypeCastFunction(type));
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T> Iterable<T> newCastingIterable(Iterable<?> input, Class<T> type) {
/* 23 */     return Iterables.transform(input, new TypeCastFunction<T>(type));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\GenericIterableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */