/*     */ package cpw.mods.fml.common.discovery;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSetMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.collect.Multimaps;
/*     */ import com.google.common.collect.SetMultimap;
/*     */ import cpw.mods.fml.common.ModContainer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ASMDataTable
/*     */ {
/*     */   public static final class ASMData
/*     */     implements Cloneable
/*     */   {
/*     */     private ModCandidate candidate;
/*     */     private String annotationName;
/*     */     private String className;
/*     */     private String objectName;
/*     */     private Map<String, Object> annotationInfo;
/*     */     
/*     */     public ASMData(ModCandidate candidate, String annotationName, String className, String objectName, Map<String, Object> info) {
/*  41 */       this.candidate = candidate;
/*  42 */       this.annotationName = annotationName;
/*  43 */       this.className = className;
/*  44 */       this.objectName = objectName;
/*  45 */       this.annotationInfo = info;
/*     */     }
/*     */     
/*     */     public ModCandidate getCandidate() {
/*  49 */       return this.candidate;
/*     */     }
/*     */     
/*     */     public String getAnnotationName() {
/*  53 */       return this.annotationName;
/*     */     }
/*     */     
/*     */     public String getClassName() {
/*  57 */       return this.className;
/*     */     }
/*     */     
/*     */     public String getObjectName() {
/*  61 */       return this.objectName;
/*     */     }
/*     */     
/*     */     public Map<String, Object> getAnnotationInfo() {
/*  65 */       return this.annotationInfo;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ASMData copy(Map<String, Object> newAnnotationInfo) {
/*     */       try {
/*  72 */         ASMData clone = (ASMData)clone();
/*  73 */         clone.annotationInfo = newAnnotationInfo;
/*  74 */         return clone;
/*     */       }
/*  76 */       catch (CloneNotSupportedException e) {
/*     */         
/*  78 */         throw new RuntimeException("Unpossible", e);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ModContainerPredicate
/*     */     implements Predicate<ASMData> {
/*     */     private ModContainer container;
/*     */     
/*     */     public ModContainerPredicate(ModContainer container) {
/*  88 */       this.container = container;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean apply(ASMDataTable.ASMData data) {
/*  93 */       return this.container.getSource().equals(data.candidate.getModContainer());
/*     */     }
/*     */   }
/*  96 */   private SetMultimap<String, ASMData> globalAnnotationData = (SetMultimap<String, ASMData>)HashMultimap.create();
/*     */   
/*     */   private Map<ModContainer, SetMultimap<String, ASMData>> containerAnnotationData;
/*  99 */   private List<ModContainer> containers = Lists.newArrayList();
/* 100 */   private SetMultimap<String, ModCandidate> packageMap = (SetMultimap<String, ModCandidate>)HashMultimap.create();
/*     */ 
/*     */   
/*     */   public SetMultimap<String, ASMData> getAnnotationsFor(ModContainer container) {
/* 104 */     if (this.containerAnnotationData == null) {
/*     */       
/* 106 */       ImmutableMap.Builder<ModContainer, SetMultimap<String, ASMData>> mapBuilder = ImmutableMap.builder();
/* 107 */       for (ModContainer cont : this.containers) {
/*     */         
/* 109 */         SetMultimap setMultimap = Multimaps.filterValues(this.globalAnnotationData, new ModContainerPredicate(cont));
/* 110 */         mapBuilder.put(cont, ImmutableSetMultimap.copyOf((Multimap)setMultimap));
/*     */       } 
/* 112 */       this.containerAnnotationData = (Map<ModContainer, SetMultimap<String, ASMData>>)mapBuilder.build();
/*     */     } 
/* 114 */     return this.containerAnnotationData.get(container);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<ASMData> getAll(String annotation) {
/* 119 */     return this.globalAnnotationData.get(annotation);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addASMData(ModCandidate candidate, String annotation, String className, String objectName, Map<String, Object> annotationInfo) {
/* 124 */     this.globalAnnotationData.put(annotation, new ASMData(candidate, annotation, className, objectName, annotationInfo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addContainer(ModContainer container) {
/* 129 */     this.containers.add(container);
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerPackage(ModCandidate modCandidate, String pkg) {
/* 134 */     this.packageMap.put(pkg, modCandidate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<ModCandidate> getCandidatesFor(String pkg) {
/* 139 */     return this.packageMap.get(pkg);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\ASMDataTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */