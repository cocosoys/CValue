/*     */ package cpw.mods.fml.common.discovery.asm;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.LoaderException;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.common.discovery.ModCandidate;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.Type;
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
/*     */ public class ASMModParser
/*     */ {
/*     */   private Type asmType;
/*     */   private int classVersion;
/*     */   private Type asmSuperType;
/*  40 */   private LinkedList<ModAnnotation> annotations = Lists.newLinkedList();
/*     */   private String baseModProperties;
/*     */   
/*     */   enum AnnotationType
/*     */   {
/*  45 */     CLASS, FIELD, METHOD, SUBTYPE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ASMModParser(InputStream stream) throws IOException {
/*     */     try {
/*  52 */       ClassReader reader = new ClassReader(stream);
/*  53 */       reader.accept(new ModClassVisitor(this), 0);
/*     */     }
/*  55 */     catch (Exception ex) {
/*     */       
/*  57 */       FMLLog.log(Level.ERROR, ex, "Unable to read a class file correctly", new Object[0]);
/*  58 */       throw new LoaderException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void beginNewTypeName(String typeQName, int classVersion, String superClassQName) {
/*  64 */     this.asmType = Type.getObjectType(typeQName);
/*  65 */     this.classVersion = classVersion;
/*  66 */     this.asmSuperType = !Strings.isNullOrEmpty(superClassQName) ? Type.getObjectType(superClassQName) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void startClassAnnotation(String annotationName) {
/*  71 */     ModAnnotation ann = new ModAnnotation(AnnotationType.CLASS, Type.getType(annotationName), this.asmType.getClassName());
/*  72 */     this.annotations.addFirst(ann);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAnnotationProperty(String key, Object value) {
/*  77 */     ((ModAnnotation)this.annotations.getFirst()).addProperty(key, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startFieldAnnotation(String fieldName, String annotationName) {
/*  82 */     ModAnnotation ann = new ModAnnotation(AnnotationType.FIELD, Type.getType(annotationName), fieldName);
/*  83 */     this.annotations.addFirst(ann);
/*     */   }
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
/*     */   public String toString() {
/*  96 */     return Objects.toStringHelper("ASMAnnotationDiscoverer").add("className", this.asmType.getClassName()).add("classVersion", this.classVersion).add("superName", this.asmSuperType.getClassName()).add("annotations", this.annotations).add("isBaseMod", isBaseMod(Collections.emptyList())).add("baseModProperties", this.baseModProperties).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getASMType() {
/* 101 */     return this.asmType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getClassVersion() {
/* 106 */     return this.classVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getASMSuperType() {
/* 111 */     return this.asmSuperType;
/*     */   }
/*     */ 
/*     */   
/*     */   public LinkedList<ModAnnotation> getAnnotations() {
/* 116 */     return this.annotations;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBaseMod(List<String> rememberedTypes) {
/* 130 */     return (getASMSuperType().equals(Type.getType("LBaseMod;")) || getASMSuperType().equals(Type.getType("Lnet/minecraft/src/BaseMod;")) || rememberedTypes.contains(getASMSuperType().getClassName()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBaseModProperties(String foundProperties) {
/* 135 */     this.baseModProperties = foundProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getBaseModProperties() {
/* 140 */     return this.baseModProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendToTable(ASMDataTable table, ModCandidate candidate) {
/* 145 */     for (ModAnnotation ma : this.annotations)
/*     */     {
/* 147 */       table.addASMData(candidate, ma.asmType.getClassName(), this.asmType.getClassName(), ma.member, ma.values);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAnnotationArray(String name) {
/* 153 */     ((ModAnnotation)this.annotations.getFirst()).addArray(name);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAnnotationEnumProperty(String name, String desc, String value) {
/* 158 */     ((ModAnnotation)this.annotations.getFirst()).addEnumProperty(name, desc, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void endArray() {
/* 164 */     ((ModAnnotation)this.annotations.getFirst()).endArray();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSubAnnotation(String name, String desc) {
/* 170 */     ModAnnotation ma = this.annotations.getFirst();
/* 171 */     this.annotations.addFirst(ma.addChildAnnotation(name, desc));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void endSubAnnotation() {
/* 177 */     ModAnnotation child = this.annotations.removeFirst();
/* 178 */     this.annotations.addLast(child);
/*     */   }
/*     */ 
/*     */   
/*     */   public void startMethodAnnotation(String methodName, String methodDescriptor, String annotationName) {
/* 183 */     ModAnnotation ann = new ModAnnotation(AnnotationType.METHOD, Type.getType(annotationName), methodName + methodDescriptor);
/* 184 */     this.annotations.addFirst(ann);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\asm\ASMModParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */