/*    */ package cpw.mods.fml.common.functions;
/*    */ 
/*    */ import com.google.common.collect.Collections2;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CollectionWrapperFactory
/*    */ {
/*    */   public static <T> Collection<T> wrap(Collection<?> coll, Class<T> elementType) {
/* 17 */     Collection<?> asGeneric = coll;
/* 18 */     return Collections2.transform(asGeneric, new TypeCastFunction<T>(elementType));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> List<T> wrap(List<?> list, Class<T> elementType) {
/* 29 */     List<?> asGeneric = list;
/* 30 */     return Lists.transform(asGeneric, new TypeCastFunction<T>(elementType));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\CollectionWrapperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */