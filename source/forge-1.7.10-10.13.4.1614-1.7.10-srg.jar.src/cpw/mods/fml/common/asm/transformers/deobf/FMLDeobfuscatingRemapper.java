/*     */ package cpw.mods.fml.common.asm.transformers.deobf;
/*     */ 
/*     */ import com.google.common.base.CharMatcher;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.BiMap;
/*     */ import com.google.common.collect.ImmutableBiMap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.CharSource;
/*     */ import cpw.mods.fml.common.patcher.ClassPatchManager;
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.commons.Remapper;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.FieldNode;
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
/*     */ public class FMLDeobfuscatingRemapper
/*     */   extends Remapper
/*     */ {
/*  51 */   public static final FMLDeobfuscatingRemapper INSTANCE = new FMLDeobfuscatingRemapper();
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
/*  64 */   private static final boolean DEBUG_REMAPPING = Boolean.parseBoolean(System.getProperty("fml.remappingDebug", "false"));
/*  65 */   private static final boolean DUMP_FIELD_MAPS = (Boolean.parseBoolean(System.getProperty("fml.remappingDebug.dumpFieldMaps", "false")) && DEBUG_REMAPPING);
/*  66 */   private static final boolean DUMP_METHOD_MAPS = (Boolean.parseBoolean(System.getProperty("fml.remappingDebug.dumpMethodMaps", "false")) && DEBUG_REMAPPING);
/*     */ 
/*     */ 
/*     */   
/*  70 */   private BiMap<String, String> classNameBiMap = (BiMap<String, String>)ImmutableBiMap.of();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setupLoadOnly(String deobfFileName, boolean loadAll) {
/*     */     try {
/*  77 */       File mapData = new File(deobfFileName);
/*  78 */       LZMAInputSupplier zis = new LZMAInputSupplier(new FileInputStream(mapData));
/*  79 */       CharSource srgSource = zis.asCharSource(Charsets.UTF_8);
/*  80 */       ImmutableList immutableList = srgSource.readLines();
/*  81 */       this.rawMethodMaps = Maps.newHashMap();
/*  82 */       this.rawFieldMaps = Maps.newHashMap();
/*  83 */       ImmutableBiMap.Builder<String, String> builder = ImmutableBiMap.builder();
/*  84 */       Splitter splitter = Splitter.on(CharMatcher.anyOf(": ")).omitEmptyStrings().trimResults();
/*  85 */       for (String line : immutableList) {
/*     */         
/*  87 */         String[] parts = (String[])Iterables.toArray(splitter.split(line), String.class);
/*  88 */         String typ = parts[0];
/*  89 */         if ("CL".equals(typ)) {
/*     */           
/*  91 */           parseClass(builder, parts); continue;
/*     */         } 
/*  93 */         if ("MD".equals(typ) && loadAll) {
/*     */           
/*  95 */           parseMethod(parts); continue;
/*     */         } 
/*  97 */         if ("FD".equals(typ) && loadAll)
/*     */         {
/*  99 */           parseField(parts);
/*     */         }
/*     */       } 
/* 102 */       this.classNameBiMap = (BiMap<String, String>)builder.build();
/*     */     }
/* 104 */     catch (IOException ioe) {
/*     */       
/* 106 */       FMLRelaunchLog.log(Level.ERROR, "An error occurred loading the deobfuscation map data", new Object[] { ioe });
/*     */     } 
/* 108 */     this.methodNameMaps = Maps.newHashMapWithExpectedSize(this.rawMethodMaps.size());
/* 109 */     this.fieldNameMaps = Maps.newHashMapWithExpectedSize(this.rawFieldMaps.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setup(File mcDir, LaunchClassLoader classLoader, String deobfFileName) {
/* 114 */     this.classLoader = classLoader;
/*     */     
/*     */     try {
/* 117 */       InputStream classData = getClass().getResourceAsStream(deobfFileName);
/* 118 */       LZMAInputSupplier zis = new LZMAInputSupplier(classData);
/* 119 */       CharSource srgSource = zis.asCharSource(Charsets.UTF_8);
/* 120 */       ImmutableList immutableList = srgSource.readLines();
/* 121 */       this.rawMethodMaps = Maps.newHashMap();
/* 122 */       this.rawFieldMaps = Maps.newHashMap();
/* 123 */       ImmutableBiMap.Builder<String, String> builder = ImmutableBiMap.builder();
/* 124 */       Splitter splitter = Splitter.on(CharMatcher.anyOf(": ")).omitEmptyStrings().trimResults();
/* 125 */       for (String line : immutableList) {
/*     */         
/* 127 */         String[] parts = (String[])Iterables.toArray(splitter.split(line), String.class);
/* 128 */         String typ = parts[0];
/* 129 */         if ("CL".equals(typ)) {
/*     */           
/* 131 */           parseClass(builder, parts); continue;
/*     */         } 
/* 133 */         if ("MD".equals(typ)) {
/*     */           
/* 135 */           parseMethod(parts); continue;
/*     */         } 
/* 137 */         if ("FD".equals(typ))
/*     */         {
/* 139 */           parseField(parts);
/*     */         }
/*     */       } 
/* 142 */       this.classNameBiMap = (BiMap<String, String>)builder.build();
/*     */     }
/* 144 */     catch (IOException ioe) {
/*     */       
/* 146 */       FMLRelaunchLog.log(Level.ERROR, ioe, "An error occurred loading the deobfuscation map data", new Object[0]);
/*     */     } 
/* 148 */     this.methodNameMaps = Maps.newHashMapWithExpectedSize(this.rawMethodMaps.size());
/* 149 */     this.fieldNameMaps = Maps.newHashMapWithExpectedSize(this.rawFieldMaps.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRemappedClass(String className) {
/* 154 */     return !map(className).equals(className);
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseField(String[] parts) {
/* 159 */     String oldSrg = parts[1];
/* 160 */     int lastOld = oldSrg.lastIndexOf('/');
/* 161 */     String cl = oldSrg.substring(0, lastOld);
/* 162 */     String oldName = oldSrg.substring(lastOld + 1);
/* 163 */     String newSrg = parts[2];
/* 164 */     int lastNew = newSrg.lastIndexOf('/');
/* 165 */     String newName = newSrg.substring(lastNew + 1);
/* 166 */     if (!this.rawFieldMaps.containsKey(cl))
/*     */     {
/* 168 */       this.rawFieldMaps.put(cl, Maps.newHashMap());
/*     */     }
/* 170 */     ((Map<String, String>)this.rawFieldMaps.get(cl)).put(oldName + ":" + getFieldType(cl, oldName), newName);
/* 171 */     ((Map<String, String>)this.rawFieldMaps.get(cl)).put(oldName + ":null", newName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 177 */   private Map<String, Map<String, String>> fieldDescriptions = Maps.newHashMap();
/*     */ 
/*     */   
/* 180 */   private Set<String> negativeCacheMethods = Sets.newHashSet();
/* 181 */   private Set<String> negativeCacheFields = Sets.newHashSet(); private Map<String, Map<String, String>> rawFieldMaps;
/*     */   private Map<String, Map<String, String>> rawMethodMaps;
/*     */   
/*     */   private String getFieldType(String owner, String name) {
/* 185 */     if (this.fieldDescriptions.containsKey(owner))
/*     */     {
/* 187 */       return (String)((Map)this.fieldDescriptions.get(owner)).get(name);
/*     */     }
/* 189 */     synchronized (this.fieldDescriptions) {
/*     */ 
/*     */ 
/*     */       
/* 193 */       byte[] classBytes = ClassPatchManager.INSTANCE.getPatchedResource(owner, map(owner).replace('/', '.'), this.classLoader);
/* 194 */       if (classBytes == null)
/*     */       {
/* 196 */         return null;
/*     */       }
/* 198 */       ClassReader cr = new ClassReader(classBytes);
/* 199 */       ClassNode classNode = new ClassNode();
/* 200 */       cr.accept((ClassVisitor)classNode, 7);
/* 201 */       Map<String, String> resMap = Maps.newHashMap();
/* 202 */       for (FieldNode fieldNode : classNode.fields) {
/* 203 */         resMap.put(fieldNode.name, fieldNode.desc);
/*     */       }
/* 205 */       this.fieldDescriptions.put(owner, resMap);
/* 206 */       return resMap.get(name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, Map<String, String>> fieldNameMaps;
/*     */   
/*     */   private Map<String, Map<String, String>> methodNameMaps;
/*     */   
/*     */   private LaunchClassLoader classLoader;
/*     */   
/*     */   private void parseClass(ImmutableBiMap.Builder<String, String> builder, String[] parts) {
/* 218 */     builder.put(parts[1], parts[2]);
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseMethod(String[] parts) {
/* 223 */     String oldSrg = parts[1];
/* 224 */     int lastOld = oldSrg.lastIndexOf('/');
/* 225 */     String cl = oldSrg.substring(0, lastOld);
/* 226 */     String oldName = oldSrg.substring(lastOld + 1);
/* 227 */     String sig = parts[2];
/* 228 */     String newSrg = parts[3];
/* 229 */     int lastNew = newSrg.lastIndexOf('/');
/* 230 */     String newName = newSrg.substring(lastNew + 1);
/* 231 */     if (!this.rawMethodMaps.containsKey(cl))
/*     */     {
/* 233 */       this.rawMethodMaps.put(cl, Maps.newHashMap());
/*     */     }
/* 235 */     ((Map<String, String>)this.rawMethodMaps.get(cl)).put(oldName + sig, newName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapFieldName(String owner, String name, String desc) {
/* 241 */     if (this.classNameBiMap == null || this.classNameBiMap.isEmpty())
/*     */     {
/* 243 */       return name;
/*     */     }
/* 245 */     Map<String, String> fieldMap = getFieldMap(owner);
/* 246 */     return (fieldMap != null && fieldMap.containsKey(name + ":" + desc)) ? fieldMap.get(name + ":" + desc) : name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String map(String typeName) {
/* 252 */     if (this.classNameBiMap == null || this.classNameBiMap.isEmpty())
/*     */     {
/* 254 */       return typeName;
/*     */     }
/* 256 */     if (this.classNameBiMap.containsKey(typeName))
/*     */     {
/* 258 */       return (String)this.classNameBiMap.get(typeName);
/*     */     }
/* 260 */     int dollarIdx = typeName.lastIndexOf('$');
/* 261 */     if (dollarIdx > -1)
/*     */     {
/* 263 */       return map(typeName.substring(0, dollarIdx)) + "$" + typeName.substring(dollarIdx + 1);
/*     */     }
/* 265 */     return typeName;
/*     */   }
/*     */ 
/*     */   
/*     */   public String unmap(String typeName) {
/* 270 */     if (this.classNameBiMap == null || this.classNameBiMap.isEmpty())
/*     */     {
/* 272 */       return typeName;
/*     */     }
/*     */     
/* 275 */     if (this.classNameBiMap.containsValue(typeName))
/*     */     {
/* 277 */       return (String)this.classNameBiMap.inverse().get(typeName);
/*     */     }
/* 279 */     int dollarIdx = typeName.lastIndexOf('$');
/* 280 */     if (dollarIdx > -1)
/*     */     {
/* 282 */       return unmap(typeName.substring(0, dollarIdx)) + "$" + typeName.substring(dollarIdx + 1);
/*     */     }
/* 284 */     return typeName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String mapMethodName(String owner, String name, String desc) {
/* 291 */     if (this.classNameBiMap == null || this.classNameBiMap.isEmpty())
/*     */     {
/* 293 */       return name;
/*     */     }
/* 295 */     Map<String, String> methodMap = getMethodMap(owner);
/* 296 */     String methodDescriptor = name + desc;
/* 297 */     return (methodMap != null && methodMap.containsKey(methodDescriptor)) ? methodMap.get(methodDescriptor) : name;
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, String> getFieldMap(String className) {
/* 302 */     if (!this.fieldNameMaps.containsKey(className) && !this.negativeCacheFields.contains(className)) {
/*     */       
/* 304 */       findAndMergeSuperMaps(className);
/* 305 */       if (!this.fieldNameMaps.containsKey(className))
/*     */       {
/* 307 */         this.negativeCacheFields.add(className);
/*     */       }
/*     */       
/* 310 */       if (DUMP_FIELD_MAPS)
/*     */       {
/* 312 */         FMLRelaunchLog.finer("Field map for %s : %s", new Object[] { className, this.fieldNameMaps.get(className) });
/*     */       }
/*     */     } 
/* 315 */     return this.fieldNameMaps.get(className);
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, String> getMethodMap(String className) {
/* 320 */     if (!this.methodNameMaps.containsKey(className) && !this.negativeCacheMethods.contains(className)) {
/*     */       
/* 322 */       findAndMergeSuperMaps(className);
/* 323 */       if (!this.methodNameMaps.containsKey(className))
/*     */       {
/* 325 */         this.negativeCacheMethods.add(className);
/*     */       }
/* 327 */       if (DUMP_METHOD_MAPS)
/*     */       {
/* 329 */         FMLRelaunchLog.finer("Method map for %s : %s", new Object[] { className, this.methodNameMaps.get(className) });
/*     */       }
/*     */     } 
/*     */     
/* 333 */     return this.methodNameMaps.get(className);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void findAndMergeSuperMaps(String name) {
/*     */     try {
/* 340 */       String superName = null;
/* 341 */       String[] interfaces = new String[0];
/* 342 */       byte[] classBytes = ClassPatchManager.INSTANCE.getPatchedResource(name, map(name), this.classLoader);
/* 343 */       if (classBytes != null) {
/*     */         
/* 345 */         ClassReader cr = new ClassReader(classBytes);
/* 346 */         superName = cr.getSuperName();
/* 347 */         interfaces = cr.getInterfaces();
/*     */       } 
/* 349 */       mergeSuperMaps(name, superName, interfaces);
/*     */     }
/* 351 */     catch (IOException e) {
/*     */       
/* 353 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void mergeSuperMaps(String name, String superName, String[] interfaces) {
/* 359 */     if (this.classNameBiMap == null || this.classNameBiMap.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 364 */     if (Strings.isNullOrEmpty(superName)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 369 */     ImmutableList immutableList = ImmutableList.builder().add(superName).addAll(Arrays.asList(interfaces)).build();
/*     */     
/* 371 */     for (String parentThing : immutableList) {
/*     */       
/* 373 */       if (!this.methodNameMaps.containsKey(parentThing))
/*     */       {
/* 375 */         findAndMergeSuperMaps(parentThing);
/*     */       }
/*     */     } 
/* 378 */     Map<String, String> methodMap = Maps.newHashMap();
/* 379 */     Map<String, String> fieldMap = Maps.newHashMap();
/* 380 */     for (String parentThing : immutableList) {
/*     */       
/* 382 */       if (this.methodNameMaps.containsKey(parentThing))
/*     */       {
/* 384 */         methodMap.putAll(this.methodNameMaps.get(parentThing));
/*     */       }
/* 386 */       if (this.fieldNameMaps.containsKey(parentThing))
/*     */       {
/* 388 */         fieldMap.putAll(this.fieldNameMaps.get(parentThing));
/*     */       }
/*     */     } 
/* 391 */     if (this.rawMethodMaps.containsKey(name))
/*     */     {
/* 393 */       methodMap.putAll(this.rawMethodMaps.get(name));
/*     */     }
/* 395 */     if (this.rawFieldMaps.containsKey(name))
/*     */     {
/* 397 */       fieldMap.putAll(this.rawFieldMaps.get(name));
/*     */     }
/* 399 */     this.methodNameMaps.put(name, ImmutableMap.copyOf(methodMap));
/* 400 */     this.fieldNameMaps.put(name, ImmutableMap.copyOf(fieldMap));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> getObfedClasses() {
/* 406 */     return (Set<String>)ImmutableSet.copyOf(this.classNameBiMap.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStaticFieldType(String oldType, String oldName, String newType, String newName) {
/* 411 */     String fType = getFieldType(oldType, oldName);
/* 412 */     if (oldType.equals(newType))
/*     */     {
/* 414 */       return fType;
/*     */     }
/* 416 */     Map<String, String> newClassMap = this.fieldDescriptions.get(newType);
/* 417 */     if (newClassMap == null) {
/*     */       
/* 419 */       newClassMap = Maps.newHashMap();
/* 420 */       this.fieldDescriptions.put(newType, newClassMap);
/*     */     } 
/* 422 */     newClassMap.put(newName, fType);
/* 423 */     return fType;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\deobf\FMLDeobfuscatingRemapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */