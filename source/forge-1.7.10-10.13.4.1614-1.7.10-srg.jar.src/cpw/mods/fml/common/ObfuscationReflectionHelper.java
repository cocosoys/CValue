/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
/*     */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*     */ import java.util.Arrays;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObfuscationReflectionHelper
/*     */ {
/*     */   public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, int fieldIndex) {
/*     */     try {
/*  35 */       return (T)ReflectionHelper.getPrivateValue(classToAccess, instance, fieldIndex);
/*     */     }
/*  37 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException e) {
/*     */       
/*  39 */       FMLLog.log(Level.ERROR, (Throwable)e, "There was a problem getting field index %d from %s", new Object[] { Integer.valueOf(fieldIndex), classToAccess.getName() });
/*  40 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String[] remapFieldNames(String className, String... fieldNames) {
/*  46 */     String internalClassName = FMLDeobfuscatingRemapper.INSTANCE.unmap(className.replace('.', '/'));
/*  47 */     String[] mappedNames = new String[fieldNames.length];
/*  48 */     int i = 0;
/*  49 */     for (String fName : fieldNames)
/*     */     {
/*  51 */       mappedNames[i++] = FMLDeobfuscatingRemapper.INSTANCE.mapFieldName(internalClassName, fName, null);
/*     */     }
/*  53 */     return mappedNames;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> T getPrivateValue(Class<? super E> classToAccess, E instance, String... fieldNames) {
/*     */     try {
/*  60 */       return (T)ReflectionHelper.getPrivateValue(classToAccess, instance, remapFieldNames(classToAccess.getName(), fieldNames));
/*     */     }
/*  62 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToFindFieldException e) {
/*     */       
/*  64 */       FMLLog.log(Level.ERROR, (Throwable)e, "Unable to locate any field %s on type %s", new Object[] { Arrays.toString((Object[])fieldNames), classToAccess.getName() });
/*  65 */       throw e;
/*     */     }
/*  67 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException e) {
/*     */       
/*  69 */       FMLLog.log(Level.ERROR, (Throwable)e, "Unable to access any field %s on type %s", new Object[] { Arrays.toString((Object[])fieldNames), classToAccess.getName() });
/*  70 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, int fieldIndex) {
/*     */     try {
/*  78 */       ReflectionHelper.setPrivateValue(classToAccess, instance, value, fieldIndex);
/*     */     }
/*  80 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException e) {
/*     */       
/*  82 */       FMLLog.log(Level.ERROR, (Throwable)e, "There was a problem setting field index %d on type %s", new Object[] { Integer.valueOf(fieldIndex), classToAccess.getName() });
/*  83 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, String... fieldNames) {
/*     */     try {
/*  91 */       ReflectionHelper.setPrivateValue(classToAccess, instance, value, remapFieldNames(classToAccess.getName(), fieldNames));
/*     */     }
/*  93 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToFindFieldException e) {
/*     */       
/*  95 */       FMLLog.log(Level.ERROR, (Throwable)e, "Unable to locate any field %s on type %s", new Object[] { Arrays.toString((Object[])fieldNames), classToAccess.getName() });
/*  96 */       throw e;
/*     */     }
/*  98 */     catch (cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException e) {
/*     */       
/* 100 */       FMLLog.log(Level.ERROR, (Throwable)e, "Unable to set any field %s on type %s", new Object[] { Arrays.toString((Object[])fieldNames), classToAccess.getName() });
/* 101 */       throw e;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ObfuscationReflectionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */