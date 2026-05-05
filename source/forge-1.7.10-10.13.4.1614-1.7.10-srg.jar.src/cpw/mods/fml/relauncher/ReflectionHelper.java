/*     */ package cpw.mods.fml.relauncher;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectionHelper
/*     */ {
/*     */   public static class UnableToFindMethodException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private String[] methodNames;
/*     */     
/*     */     public UnableToFindMethodException(String[] methodNames, Exception failed) {
/*  33 */       super(failed);
/*  34 */       this.methodNames = methodNames;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class UnableToFindClassException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private String[] classNames;
/*     */     
/*     */     public UnableToFindClassException(String[] classNames, Exception err) {
/*  47 */       super(err);
/*  48 */       this.classNames = classNames;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class UnableToAccessFieldException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private String[] fieldNameList;
/*     */     
/*     */     public UnableToAccessFieldException(String[] fieldNames, Exception e) {
/*  61 */       super(e);
/*  62 */       this.fieldNameList = fieldNames;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class UnableToFindFieldException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private String[] fieldNameList;
/*     */     
/*     */     public UnableToFindFieldException(String[] fieldNameList, Exception e) {
/*  73 */       super(e);
/*  74 */       this.fieldNameList = fieldNameList;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static Field findField(Class<?> clazz, String... fieldNames) {
/*  80 */     Exception failed = null;
/*  81 */     for (String fieldName : fieldNames) {
/*     */ 
/*     */       
/*     */       try {
/*  85 */         Field f = clazz.getDeclaredField(fieldName);
/*  86 */         f.setAccessible(true);
/*  87 */         return f;
/*     */       }
/*  89 */       catch (Exception e) {
/*     */         
/*  91 */         failed = e;
/*     */       } 
/*     */     } 
/*  94 */     throw new UnableToFindFieldException(fieldNames, failed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, int fieldIndex) {
/*     */     try {
/* 102 */       Field f = classToAccess.getDeclaredFields()[fieldIndex];
/* 103 */       f.setAccessible(true);
/* 104 */       return (T)f.get(instance);
/*     */     }
/* 106 */     catch (Exception e) {
/*     */       
/* 108 */       throw new UnableToAccessFieldException(new String[0], e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, String... fieldNames) {
/*     */     try {
/* 117 */       return (T)findField(classToAccess, fieldNames).get(instance);
/*     */     }
/* 119 */     catch (Exception e) {
/*     */       
/* 121 */       throw new UnableToAccessFieldException(fieldNames, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, int fieldIndex) {
/*     */     try {
/* 129 */       Field f = classToAccess.getDeclaredFields()[fieldIndex];
/* 130 */       f.setAccessible(true);
/* 131 */       f.set(instance, value);
/*     */     }
/* 133 */     catch (Exception e) {
/*     */       
/* 135 */       throw new UnableToAccessFieldException(new String[0], e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, String... fieldNames) {
/*     */     try {
/* 143 */       findField(classToAccess, fieldNames).set(instance, value);
/*     */     }
/* 145 */     catch (Exception e) {
/*     */       
/* 147 */       throw new UnableToAccessFieldException(fieldNames, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<? super Object> getClass(ClassLoader loader, String... classNames) {
/* 154 */     Exception err = null;
/* 155 */     for (String className : classNames) {
/*     */ 
/*     */       
/*     */       try {
/* 159 */         return (Class)Class.forName(className, false, loader);
/*     */       }
/* 161 */       catch (Exception e) {
/*     */         
/* 163 */         err = e;
/*     */       } 
/*     */     } 
/*     */     
/* 167 */     throw new UnableToFindClassException(classNames, err);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Method findMethod(Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
/* 173 */     Exception failed = null;
/* 174 */     for (String methodName : methodNames) {
/*     */ 
/*     */       
/*     */       try {
/* 178 */         Method m = clazz.getDeclaredMethod(methodName, methodTypes);
/* 179 */         m.setAccessible(true);
/* 180 */         return m;
/*     */       }
/* 182 */       catch (Exception e) {
/*     */         
/* 184 */         failed = e;
/*     */       } 
/*     */     } 
/* 187 */     throw new UnableToFindMethodException(methodNames, failed);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\ReflectionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */