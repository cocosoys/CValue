/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.asm.transformers.ModAPITransformer;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.common.discovery.ModCandidate;
/*     */ import cpw.mods.fml.common.discovery.ModDiscoverer;
/*     */ import cpw.mods.fml.common.functions.ModIdFunction;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.VersionParser;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ public class ModAPIManager
/*     */ {
/*  24 */   public static final ModAPIManager INSTANCE = new ModAPIManager();
/*     */   private ModAPITransformer transformer;
/*     */   private ASMDataTable dataTable;
/*     */   private Map<String, APIContainer> apiContainers;
/*     */   
/*     */   private static class APIContainer
/*     */     extends DummyModContainer
/*     */   {
/*     */     private List<ArtifactVersion> referredMods;
/*     */     private ArtifactVersion ownerMod;
/*     */     private ArtifactVersion ourVersion;
/*     */     private String providedAPI;
/*     */     private File source;
/*     */     private String version;
/*     */     private Set<String> currentReferents;
/*     */     private Set<String> packages;
/*     */     private boolean selfReferenced;
/*     */     
/*     */     public APIContainer(String providedAPI, String apiVersion, File source, ArtifactVersion ownerMod) {
/*  43 */       this.providedAPI = providedAPI;
/*  44 */       this.version = apiVersion;
/*  45 */       this.ownerMod = ownerMod;
/*  46 */       this.ourVersion = (ArtifactVersion)new DefaultArtifactVersion(providedAPI, apiVersion);
/*  47 */       this.referredMods = Lists.newArrayList();
/*  48 */       this.source = source;
/*  49 */       this.currentReferents = Sets.newHashSet();
/*  50 */       this.packages = Sets.newHashSet();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public File getSource() {
/*  56 */       return this.source;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getVersion() {
/*  61 */       return this.version;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/*  66 */       return "API: " + this.providedAPI;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getModId() {
/*  71 */       return this.providedAPI;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<ArtifactVersion> getDependants() {
/*  76 */       return this.referredMods;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public List<ArtifactVersion> getDependencies() {
/*  82 */       return this.selfReferenced ? (List<ArtifactVersion>)ImmutableList.of() : (List<ArtifactVersion>)ImmutableList.of(this.ownerMod);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ArtifactVersion getProcessedVersion() {
/*  88 */       return this.ourVersion;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void validate(String providedAPI, String apiOwner, String apiVersion) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  99 */       return "APIContainer{" + this.providedAPI + ":" + this.version + "}";
/*     */     }
/*     */ 
/*     */     
/*     */     public void addAPIReference(String embedded) {
/* 104 */       if (this.currentReferents.add(embedded))
/*     */       {
/* 106 */         this.referredMods.add(VersionParser.parseVersionReference(embedded));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void addOwnedPackage(String apiPackage) {
/* 112 */       this.packages.add(apiPackage);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addAPIReferences(List<String> candidateIds) {
/* 117 */       for (String modId : candidateIds)
/*     */       {
/* 119 */         addAPIReference(modId);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     void markSelfReferenced() {
/* 125 */       this.selfReferenced = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void registerDataTableAndParseAPI(ASMDataTable dataTable) {
/* 130 */     this.dataTable = dataTable;
/*     */     
/* 132 */     Set<ASMDataTable.ASMData> apiList = dataTable.getAll("cpw.mods.fml.common.API");
/*     */     
/* 134 */     this.apiContainers = Maps.newHashMap();
/*     */     
/* 136 */     for (ASMDataTable.ASMData data : apiList) {
/*     */       
/* 138 */       Map<String, Object> annotationInfo = data.getAnnotationInfo();
/* 139 */       String apiPackage = data.getClassName().substring(0, data.getClassName().indexOf(".package-info"));
/* 140 */       String providedAPI = (String)annotationInfo.get("provides");
/* 141 */       String apiOwner = (String)annotationInfo.get("owner");
/* 142 */       String apiVersion = (String)annotationInfo.get("apiVersion");
/* 143 */       APIContainer container = this.apiContainers.get(providedAPI);
/* 144 */       if (container == null) {
/*     */         
/* 146 */         container = new APIContainer(providedAPI, apiVersion, data.getCandidate().getModContainer(), VersionParser.parseVersionReference(apiOwner));
/* 147 */         this.apiContainers.put(providedAPI, container);
/*     */       }
/*     */       else {
/*     */         
/* 151 */         container.validate(providedAPI, apiOwner, apiVersion);
/*     */       } 
/* 153 */       container.addOwnedPackage(apiPackage);
/* 154 */       for (ModContainer mc : data.getCandidate().getContainedMods()) {
/*     */         
/* 156 */         String embeddedIn = mc.getModId();
/* 157 */         if (container.currentReferents.contains(embeddedIn)) {
/*     */           continue;
/*     */         }
/*     */         
/* 161 */         FMLLog.fine("Found API %s (owned by %s providing %s) embedded in %s", new Object[] { apiPackage, apiOwner, providedAPI, embeddedIn });
/* 162 */         if (!embeddedIn.equals(apiOwner))
/*     */         {
/* 164 */           container.addAPIReference(embeddedIn);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     for (APIContainer container : this.apiContainers.values()) {
/*     */       
/* 171 */       for (String pkg : container.packages) {
/*     */         
/* 173 */         Set<ModCandidate> candidates = dataTable.getCandidatesFor(pkg);
/* 174 */         for (ModCandidate candidate : candidates) {
/*     */           
/* 176 */           List<String> candidateIds = Lists.transform(candidate.getContainedMods(), (Function)new ModIdFunction());
/* 177 */           if (!candidateIds.contains(container.ownerMod.getLabel()) && !container.currentReferents.containsAll(candidateIds)) {
/*     */             
/* 179 */             FMLLog.info("Found mod(s) %s containing declared API package %s (owned by %s) without associated API reference", new Object[] { candidateIds, pkg, APIContainer.access$200(container) });
/* 180 */             container.addAPIReferences(candidateIds);
/*     */           } 
/*     */         } 
/*     */       } 
/* 184 */       if (this.apiContainers.containsKey(container.ownerMod.getLabel())) {
/*     */         
/* 186 */         ArtifactVersion owner = container.ownerMod;
/*     */         
/*     */         do {
/* 189 */           APIContainer parent = this.apiContainers.get(owner.getLabel());
/* 190 */           if (parent == container) {
/*     */             
/* 192 */             FMLLog.finer("APIContainer %s is it's own parent. skipping", new Object[] { owner });
/* 193 */             container.markSelfReferenced();
/*     */             break;
/*     */           } 
/* 196 */           FMLLog.finer("Removing upstream parent %s from %s", new Object[] { APIContainer.access$200(parent).getLabel(), container });
/* 197 */           container.currentReferents.remove(parent.ownerMod.getLabel());
/* 198 */           container.referredMods.remove(parent.ownerMod);
/* 199 */           owner = parent.ownerMod;
/*     */         }
/* 201 */         while (this.apiContainers.containsKey(owner.getLabel()));
/*     */       } 
/* 203 */       FMLLog.fine("Creating API container dummy for API %s: owner: %s, dependents: %s", new Object[] { APIContainer.access$400(container), APIContainer.access$200(container), APIContainer.access$300(container) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void manageAPI(ModClassLoader modClassLoader, ModDiscoverer discoverer) {
/* 209 */     registerDataTableAndParseAPI(discoverer.getASMTable());
/* 210 */     this.transformer = modClassLoader.addModAPITransformer(this.dataTable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void injectAPIModContainers(List<ModContainer> mods, Map<String, ModContainer> nameLookup) {
/* 215 */     mods.addAll(this.apiContainers.values());
/* 216 */     nameLookup.putAll((Map)this.apiContainers);
/*     */   }
/*     */ 
/*     */   
/*     */   public void cleanupAPIContainers(List<ModContainer> mods) {
/* 221 */     mods.removeAll(this.apiContainers.values());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAPI(String modId) {
/* 226 */     return this.apiContainers.containsKey(modId);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterable<? extends ModContainer> getAPIList() {
/* 231 */     return this.apiContainers.values();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ModAPIManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */