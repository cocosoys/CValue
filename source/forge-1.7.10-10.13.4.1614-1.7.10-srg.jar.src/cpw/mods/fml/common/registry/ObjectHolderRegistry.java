/*     */ package cpw.mods.fml.common.registry;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ObjectHolderRegistry
/*     */ {
/*  22 */   INSTANCE; ObjectHolderRegistry() {
/*  23 */     this.objectHolders = Lists.newArrayList();
/*     */   }
/*     */   private List<ObjectHolderRef> objectHolders;
/*     */   public void findObjectHolders(ASMDataTable table) {
/*  27 */     FMLLog.info("Processing ObjectHolder annotations", new Object[0]);
/*  28 */     Set<ASMDataTable.ASMData> allObjectHolders = table.getAll(GameRegistry.ObjectHolder.class.getName());
/*  29 */     Map<String, String> classModIds = Maps.newHashMap();
/*  30 */     Map<String, Class<?>> classCache = Maps.newHashMap();
/*  31 */     for (ASMDataTable.ASMData data : allObjectHolders) {
/*     */       
/*  33 */       String className = data.getClassName();
/*  34 */       String annotationTarget = data.getObjectName();
/*  35 */       String value = (String)data.getAnnotationInfo().get("value");
/*  36 */       boolean isClass = className.equals(annotationTarget);
/*  37 */       if (isClass)
/*     */       {
/*  39 */         scanTarget(classModIds, classCache, className, annotationTarget, value, isClass, false);
/*     */       }
/*     */     } 
/*     */     
/*  43 */     for (ASMDataTable.ASMData data : allObjectHolders) {
/*     */       
/*  45 */       String className = data.getClassName();
/*  46 */       String annotationTarget = data.getObjectName();
/*  47 */       String value = (String)data.getAnnotationInfo().get("value");
/*  48 */       boolean isClass = className.equals(annotationTarget);
/*  49 */       if (!isClass)
/*     */       {
/*  51 */         scanTarget(classModIds, classCache, className, annotationTarget, value, isClass, false);
/*     */       }
/*     */     } 
/*  54 */     scanTarget(classModIds, classCache, "net.minecraft.init.Blocks", null, "minecraft", true, true);
/*  55 */     scanTarget(classModIds, classCache, "net.minecraft.init.Items", null, "minecraft", true, true);
/*  56 */     FMLLog.info("Found %d ObjectHolder annotations", new Object[] { Integer.valueOf(this.objectHolders.size()) });
/*     */   }
/*     */ 
/*     */   
/*     */   private void scanTarget(Map<String, String> classModIds, Map<String, Class<?>> classCache, String className, String annotationTarget, String value, boolean isClass, boolean extractFromValue) {
/*     */     Class<?> clazz;
/*  62 */     if (classCache.containsKey(className)) {
/*     */       
/*  64 */       clazz = classCache.get(className);
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/*  70 */         clazz = Class.forName(className, true, getClass().getClassLoader());
/*  71 */         classCache.put(className, clazz);
/*     */       }
/*  73 */       catch (Exception ex) {
/*     */ 
/*     */         
/*  76 */         throw Throwables.propagate(ex);
/*     */       } 
/*     */     } 
/*  79 */     if (isClass) {
/*     */       
/*  81 */       scanClassForFields(classModIds, className, value, clazz, extractFromValue);
/*     */     }
/*     */     else {
/*     */       
/*  85 */       if (value.indexOf(':') == -1) {
/*     */         
/*  87 */         String prefix = classModIds.get(className);
/*  88 */         if (prefix == null) {
/*     */           
/*  90 */           FMLLog.warning("Found an unqualified ObjectHolder annotation (%s) without a modid context at %s.%s, ignoring", new Object[] { value, className, annotationTarget });
/*  91 */           throw new IllegalStateException("Unqualified reference to ObjectHolder");
/*     */         } 
/*  93 */         value = prefix + ":" + value;
/*     */       } 
/*     */       
/*     */       try {
/*  97 */         Field f = clazz.getField(annotationTarget);
/*  98 */         addHolderReference(new ObjectHolderRef(f, value, extractFromValue));
/*     */       }
/* 100 */       catch (Exception ex) {
/*     */ 
/*     */         
/* 103 */         throw Throwables.propagate(ex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void scanClassForFields(Map<String, String> classModIds, String className, String value, Class<?> clazz, boolean extractFromExistingValues) {
/* 110 */     classModIds.put(className, value);
/* 111 */     for (Field f : clazz.getFields()) {
/*     */       
/* 113 */       int mods = f.getModifiers();
/* 114 */       boolean isMatch = (Modifier.isPublic(mods) && Modifier.isStatic(mods) && Modifier.isFinal(mods));
/* 115 */       if (isMatch && !f.isAnnotationPresent((Class)GameRegistry.ObjectHolder.class))
/*     */       {
/*     */ 
/*     */         
/* 119 */         addHolderReference(new ObjectHolderRef(f, value + ":" + f.getName(), extractFromExistingValues));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addHolderReference(ObjectHolderRef ref) {
/* 125 */     if (ref.isValid())
/*     */     {
/* 127 */       this.objectHolders.add(ref);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void applyObjectHolders() {
/* 133 */     FMLLog.info("Applying holder lookups", new Object[0]);
/* 134 */     for (ObjectHolderRef ohr : this.objectHolders)
/*     */     {
/* 136 */       ohr.apply();
/*     */     }
/* 138 */     FMLLog.info("Holder lookups applied", new Object[0]);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\registry\ObjectHolderRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */