/*    */ package net.minecraft.util.com.google.common.reflect;
/*    */ 
/*    */ import java.lang.reflect.GenericArrayType;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
/*    */ import java.lang.reflect.TypeVariable;
/*    */ import java.lang.reflect.WildcardType;
/*    */ import java.util.Set;
/*    */ import javax.annotation.concurrent.NotThreadSafe;
/*    */ import net.minecraft.util.com.google.common.collect.Sets;
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
/*    */ @NotThreadSafe
/*    */ abstract class TypeVisitor
/*    */ {
/* 63 */   private final Set<Type> visited = Sets.newHashSet();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void visit(Type... types) {
/* 70 */     for (Type type : types) {
/* 71 */       if (type != null && this.visited.add(type))
/*    */       {
/*    */ 
/*    */         
/* 75 */         boolean succeeded = false;
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   void visitClass(Class<?> t) {}
/*    */   
/*    */   void visitGenericArrayType(GenericArrayType t) {}
/*    */   
/*    */   void visitParameterizedType(ParameterizedType t) {}
/*    */   
/*    */   void visitTypeVariable(TypeVariable<?> t) {}
/*    */   
/*    */   void visitWildcardType(WildcardType t) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\com\google\common\reflect\TypeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */