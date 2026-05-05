/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModAPIManager;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModAPITransformer
/*     */   implements IClassTransformer
/*     */ {
/*  28 */   private static final boolean logDebugInfo = Boolean.valueOf(System.getProperty("fml.debugAPITransformer", "false")).booleanValue();
/*     */   
/*     */   private ListMultimap<String, ASMDataTable.ASMData> optionals;
/*     */ 
/*     */   
/*     */   public byte[] transform(String name, String transformedName, byte[] basicClass) {
/*  34 */     String lookupName = name;
/*  35 */     if (name.endsWith("$class"))
/*     */     {
/*  37 */       lookupName = name.substring(0, name.length() - 6);
/*     */     }
/*  39 */     if (this.optionals == null || !this.optionals.containsKey(lookupName))
/*     */     {
/*  41 */       return basicClass;
/*     */     }
/*  43 */     ClassNode classNode = new ClassNode();
/*  44 */     ClassReader classReader = new ClassReader(basicClass);
/*  45 */     classReader.accept((ClassVisitor)classNode, 0);
/*     */     
/*  47 */     if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - found optionals for class %s - processing", new Object[] { name }); 
/*  48 */     for (ASMDataTable.ASMData optional : this.optionals.get(lookupName)) {
/*     */       
/*  50 */       String modId = (String)optional.getAnnotationInfo().get("modid");
/*     */       
/*  52 */       if (Loader.isModLoaded(modId) || ModAPIManager.INSTANCE.hasAPI(modId)) {
/*     */         
/*  54 */         if (logDebugInfo) FMLRelaunchLog.finer("Optional removal skipped - mod present %s", new Object[] { modId }); 
/*     */         continue;
/*     */       } 
/*  57 */       if (logDebugInfo) FMLRelaunchLog.finer("Optional on %s triggered - mod missing %s", new Object[] { name, modId });
/*     */       
/*  59 */       if (optional.getAnnotationInfo().containsKey("iface")) {
/*     */         
/*  61 */         Boolean stripRefs = (Boolean)optional.getAnnotationInfo().get("striprefs");
/*  62 */         if (stripRefs == null) stripRefs = Boolean.FALSE; 
/*  63 */         stripInterface(classNode, (String)optional.getAnnotationInfo().get("iface"), stripRefs.booleanValue());
/*     */         
/*     */         continue;
/*     */       } 
/*  67 */       stripMethod(classNode, optional.getObjectName());
/*     */     } 
/*     */ 
/*     */     
/*  71 */     if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - class %s processed", new Object[] { name });
/*     */     
/*  73 */     ClassWriter writer = new ClassWriter(1);
/*  74 */     classNode.accept((ClassVisitor)writer);
/*  75 */     return writer.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   private void stripMethod(ClassNode classNode, String methodDescriptor) {
/*  80 */     if (classNode.name.endsWith("$class")) {
/*     */       
/*  82 */       String subName = classNode.name.substring(0, classNode.name.length() - 6);
/*  83 */       int pos = methodDescriptor.indexOf('(') + 1;
/*  84 */       methodDescriptor = methodDescriptor.substring(0, pos) + 'L' + subName + ';' + methodDescriptor.substring(pos);
/*     */     } 
/*  86 */     for (ListIterator<MethodNode> iterator = classNode.methods.listIterator(); iterator.hasNext(); ) {
/*     */       
/*  88 */       MethodNode method = iterator.next();
/*  89 */       if (methodDescriptor.equals(method.name + method.desc)) {
/*     */         
/*  91 */         iterator.remove();
/*  92 */         if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - method %s removed", new Object[] { methodDescriptor }); 
/*     */         return;
/*     */       } 
/*     */     } 
/*  96 */     if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - method %s NOT removed - not found", new Object[] { methodDescriptor });
/*     */   
/*     */   }
/*     */   
/*     */   private void stripInterface(ClassNode classNode, String interfaceName, boolean stripRefs) {
/* 101 */     String ifaceName = interfaceName.replace('.', '/');
/* 102 */     boolean found = classNode.interfaces.remove(ifaceName);
/* 103 */     if (found && logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s removed", new Object[] { interfaceName }); 
/* 104 */     if (!found && logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s NOT removed - not found", new Object[] { interfaceName });
/*     */     
/* 106 */     if (found && stripRefs) {
/*     */       
/* 108 */       if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s - stripping method signature references", new Object[] { interfaceName }); 
/* 109 */       for (Iterator<MethodNode> iterator = classNode.methods.iterator(); iterator.hasNext(); ) {
/*     */         
/* 111 */         MethodNode node = iterator.next();
/* 112 */         if (node.desc.contains(ifaceName)) {
/*     */           
/* 114 */           if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s - stripping method containing reference %s", new Object[] { interfaceName, node.name }); 
/* 115 */           iterator.remove();
/*     */         } 
/*     */       } 
/* 118 */       if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s - all method signature references stripped", new Object[] { interfaceName });
/*     */     
/* 120 */     } else if (found) {
/*     */       
/* 122 */       if (logDebugInfo) FMLRelaunchLog.finer("Optional removal - interface %s - NOT stripping method signature references", new Object[] { interfaceName });
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void initTable(ASMDataTable dataTable) {
/* 128 */     this.optionals = (ListMultimap<String, ASMDataTable.ASMData>)ArrayListMultimap.create();
/* 129 */     Set<ASMDataTable.ASMData> interfaceLists = dataTable.getAll("cpw.mods.fml.common.Optional$InterfaceList");
/* 130 */     addData(unpackInterfaces(interfaceLists));
/* 131 */     Set<ASMDataTable.ASMData> interfaces = dataTable.getAll("cpw.mods.fml.common.Optional$Interface");
/* 132 */     addData(interfaces);
/* 133 */     Set<ASMDataTable.ASMData> methods = dataTable.getAll("cpw.mods.fml.common.Optional$Method");
/* 134 */     addData(methods);
/*     */   }
/*     */ 
/*     */   
/*     */   private Set<ASMDataTable.ASMData> unpackInterfaces(Set<ASMDataTable.ASMData> packedInterfaces) {
/* 139 */     Set<ASMDataTable.ASMData> result = Sets.newHashSet();
/* 140 */     for (ASMDataTable.ASMData data : packedInterfaces) {
/*     */ 
/*     */       
/* 143 */       List<Map<String, Object>> packedList = (List<Map<String, Object>>)data.getAnnotationInfo().get("value");
/* 144 */       for (Map<String, Object> packed : packedList) {
/*     */         
/* 146 */         ASMDataTable.ASMData newData = data.copy(packed);
/* 147 */         result.add(newData);
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return result;
/*     */   }
/*     */   
/*     */   private void addData(Set<ASMDataTable.ASMData> interfaces) {
/* 155 */     for (ASMDataTable.ASMData data : interfaces)
/*     */     {
/* 157 */       this.optionals.put(data.getClassName(), data);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\ModAPITransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */