/*     */ package cpw.mods.fml.common.toposort;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.common.DummyModContainer;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModAPIManager;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class ModSorter
/*     */ {
/*     */   private TopologicalSort.DirectedGraph<ModContainer> modGraph;
/*  37 */   private ModContainer beforeAll = (ModContainer)new DummyModContainer("BeforeAll");
/*  38 */   private ModContainer afterAll = (ModContainer)new DummyModContainer("AfterAll");
/*  39 */   private ModContainer before = (ModContainer)new DummyModContainer("Before");
/*  40 */   private ModContainer after = (ModContainer)new DummyModContainer("After");
/*     */ 
/*     */   
/*     */   public ModSorter(List<ModContainer> modList, Map<String, ModContainer> nameLookup) {
/*  44 */     HashMap<String, ModContainer> sortingNameLookup = Maps.newHashMap(nameLookup);
/*  45 */     ModAPIManager.INSTANCE.injectAPIModContainers(modList, sortingNameLookup);
/*  46 */     buildGraph(modList, sortingNameLookup);
/*     */   }
/*     */ 
/*     */   
/*     */   private void buildGraph(List<ModContainer> modList, Map<String, ModContainer> nameLookup) {
/*  51 */     this.modGraph = new TopologicalSort.DirectedGraph<ModContainer>();
/*  52 */     this.modGraph.addNode(this.beforeAll);
/*  53 */     this.modGraph.addNode(this.before);
/*  54 */     this.modGraph.addNode(this.afterAll);
/*  55 */     this.modGraph.addNode(this.after);
/*  56 */     this.modGraph.addEdge(this.before, this.after);
/*  57 */     this.modGraph.addEdge(this.beforeAll, this.before);
/*  58 */     this.modGraph.addEdge(this.after, this.afterAll);
/*     */     
/*  60 */     for (ModContainer mod : modList)
/*     */     {
/*  62 */       this.modGraph.addNode(mod);
/*     */     }
/*     */     
/*  65 */     for (ModContainer mod : modList) {
/*     */       
/*  67 */       if (mod.isImmutable()) {
/*     */ 
/*     */         
/*  70 */         this.modGraph.addEdge(this.beforeAll, mod);
/*  71 */         this.modGraph.addEdge(mod, this.before);
/*     */         continue;
/*     */       } 
/*  74 */       boolean preDepAdded = false;
/*  75 */       boolean postDepAdded = false;
/*     */       
/*  77 */       for (ArtifactVersion dep : mod.getDependencies()) {
/*     */         
/*  79 */         preDepAdded = true;
/*     */         
/*  81 */         String modid = dep.getLabel();
/*  82 */         if (modid.equals("*")) {
/*     */ 
/*     */           
/*  85 */           this.modGraph.addEdge(mod, this.afterAll);
/*  86 */           this.modGraph.addEdge(this.after, mod);
/*  87 */           postDepAdded = true;
/*     */           
/*     */           continue;
/*     */         } 
/*  91 */         this.modGraph.addEdge(this.before, mod);
/*  92 */         if (nameLookup.containsKey(modid) || Loader.isModLoaded(modid)) {
/*  93 */           this.modGraph.addEdge(nameLookup.get(modid), mod);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  98 */       for (ArtifactVersion dep : mod.getDependants()) {
/*     */         
/* 100 */         postDepAdded = true;
/*     */         
/* 102 */         String modid = dep.getLabel();
/* 103 */         if (modid.equals("*")) {
/*     */ 
/*     */           
/* 106 */           this.modGraph.addEdge(this.beforeAll, mod);
/* 107 */           this.modGraph.addEdge(mod, this.before);
/* 108 */           preDepAdded = true;
/*     */           
/*     */           continue;
/*     */         } 
/* 112 */         this.modGraph.addEdge(mod, this.after);
/* 113 */         if (Loader.isModLoaded(modid)) {
/* 114 */           this.modGraph.addEdge(mod, nameLookup.get(modid));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 119 */       if (!preDepAdded)
/*     */       {
/* 121 */         this.modGraph.addEdge(this.before, mod);
/*     */       }
/*     */       
/* 124 */       if (!postDepAdded)
/*     */       {
/* 126 */         this.modGraph.addEdge(mod, this.after);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ModContainer> sort() {
/* 133 */     List<ModContainer> sortedList = TopologicalSort.topologicalSort(this.modGraph);
/* 134 */     sortedList.removeAll(Arrays.asList((Object[])new ModContainer[] { this.beforeAll, this.before, this.after, this.afterAll }));
/* 135 */     return sortedList;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\toposort\ModSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */