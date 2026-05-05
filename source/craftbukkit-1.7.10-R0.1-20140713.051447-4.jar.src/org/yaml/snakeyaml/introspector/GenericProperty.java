/*    */ package org.yaml.snakeyaml.introspector;
/*    */ 
/*    */ import java.lang.reflect.Array;
/*    */ import java.lang.reflect.GenericArrayType;
/*    */ import java.lang.reflect.ParameterizedType;
/*    */ import java.lang.reflect.Type;
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
/*    */ public abstract class GenericProperty
/*    */   extends Property
/*    */ {
/*    */   private Type genType;
/*    */   private boolean actualClassesChecked;
/*    */   private Class<?>[] actualClasses;
/*    */   
/*    */   public GenericProperty(String name, Class<?> aClass, Type aType) {
/* 29 */     super(name, aClass);
/* 30 */     this.genType = aType;
/* 31 */     this.actualClassesChecked = (aType == null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?>[] getActualTypeArguments() {
/* 38 */     if (!this.actualClassesChecked) {
/* 39 */       if (this.genType instanceof ParameterizedType) {
/* 40 */         ParameterizedType parameterizedType = (ParameterizedType)this.genType;
/* 41 */         Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
/* 42 */         if (actualTypeArguments.length > 0) {
/* 43 */           this.actualClasses = new Class[actualTypeArguments.length];
/* 44 */           for (int i = 0; i < actualTypeArguments.length; i++) {
/* 45 */             if (actualTypeArguments[i] instanceof Class) {
/* 46 */               this.actualClasses[i] = (Class)actualTypeArguments[i];
/* 47 */             } else if (actualTypeArguments[i] instanceof ParameterizedType) {
/* 48 */               this.actualClasses[i] = (Class)((ParameterizedType)actualTypeArguments[i]).getRawType();
/*    */             }
/* 50 */             else if (actualTypeArguments[i] instanceof GenericArrayType) {
/* 51 */               Type componentType = ((GenericArrayType)actualTypeArguments[i]).getGenericComponentType();
/*    */               
/* 53 */               if (componentType instanceof Class) {
/* 54 */                 this.actualClasses[i] = Array.newInstance((Class)componentType, 0).getClass();
/*    */               } else {
/*    */                 
/* 57 */                 this.actualClasses = null;
/*    */                 break;
/*    */               } 
/*    */             } else {
/* 61 */               this.actualClasses = null;
/*    */               break;
/*    */             } 
/*    */           } 
/*    */         } 
/* 66 */       } else if (this.genType instanceof GenericArrayType) {
/* 67 */         Type componentType = ((GenericArrayType)this.genType).getGenericComponentType();
/* 68 */         if (componentType instanceof Class) {
/* 69 */           this.actualClasses = new Class[] { (Class)componentType };
/*    */         }
/* 71 */       } else if (this.genType instanceof Class) {
/*    */         
/* 73 */         Class<?> classType = (Class)this.genType;
/* 74 */         if (classType.isArray()) {
/* 75 */           this.actualClasses = new Class[1];
/* 76 */           this.actualClasses[0] = getType().getComponentType();
/*    */         } 
/*    */       } 
/* 79 */       this.actualClassesChecked = true;
/*    */     } 
/* 81 */     return this.actualClasses;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\introspector\GenericProperty.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */