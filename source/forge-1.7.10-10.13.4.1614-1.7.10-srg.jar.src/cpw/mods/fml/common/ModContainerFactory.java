/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.base.Throwables;
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.common.discovery.ModCandidate;
/*    */ import cpw.mods.fml.common.discovery.asm.ASMModParser;
/*    */ import cpw.mods.fml.common.discovery.asm.ModAnnotation;
/*    */ import java.io.File;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Pattern;
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.objectweb.asm.Type;
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
/*    */ public class ModContainerFactory
/*    */ {
/* 32 */   public static Map<Type, Constructor<? extends ModContainer>> modTypes = Maps.newHashMap();
/* 33 */   private static Pattern modClass = Pattern.compile(".*(\\.|)(mod\\_[^\\s$]+)$");
/* 34 */   private static ModContainerFactory INSTANCE = new ModContainerFactory();
/*    */ 
/*    */   
/*    */   private ModContainerFactory() {
/* 38 */     registerContainerType(Type.getType(Mod.class), (Class)FMLModContainer.class);
/*    */   }
/*    */   public static ModContainerFactory instance() {
/* 41 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   
/*    */   public void registerContainerType(Type type, Class<? extends ModContainer> container) {
/*    */     try {
/* 47 */       Constructor<? extends ModContainer> constructor = container.getConstructor(new Class[] { String.class, ModCandidate.class, Map.class });
/* 48 */       modTypes.put(type, constructor);
/* 49 */     } catch (Exception e) {
/* 50 */       FMLLog.log(Level.ERROR, e, "Critical error : cannot register mod container type %s, it has an invalid constructor", new Object[0]);
/* 51 */       Throwables.propagate(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public ModContainer build(ASMModParser modParser, File modSource, ModCandidate container) {
/* 56 */     String className = modParser.getASMType().getClassName();
/* 57 */     if (modParser.isBaseMod(container.getRememberedBaseMods()) && modClass.matcher(className).find()) {
/*    */       
/* 59 */       FMLLog.severe("Found a BaseMod type mod %s", new Object[] { className });
/* 60 */       FMLLog.severe("This will not be loaded and will be ignored. ModLoader mechanisms are no longer available.", new Object[0]);
/*    */     }
/* 62 */     else if (modClass.matcher(className).find()) {
/*    */       
/* 64 */       FMLLog.fine("Identified a class %s following modloader naming convention but not directly a BaseMod or currently seen subclass", new Object[] { className });
/* 65 */       container.rememberModCandidateType(modParser);
/*    */     }
/* 67 */     else if (modParser.isBaseMod(container.getRememberedBaseMods())) {
/*    */       
/* 69 */       FMLLog.fine("Found a basemod %s of non-standard naming format", new Object[] { className });
/* 70 */       container.rememberBaseModType(className);
/*    */     } 
/*    */     
/* 73 */     for (ModAnnotation ann : modParser.getAnnotations()) {
/*    */       
/* 75 */       if (modTypes.containsKey(ann.getASMType())) {
/*    */         
/* 77 */         FMLLog.fine("Identified a mod of type %s (%s) - loading", new Object[] { ann.getASMType(), className });
/*    */         try {
/* 79 */           return ((Constructor<ModContainer>)modTypes.get(ann.getASMType())).newInstance(new Object[] { className, container, ann.getValues() });
/* 80 */         } catch (Exception e) {
/* 81 */           FMLLog.log(Level.ERROR, e, "Unable to construct %s container", new Object[] { ann.getASMType().getClassName() });
/* 82 */           return null;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 87 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ModContainerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */