/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.VersionRange;
/*     */ import java.io.File;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.Collections;
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
/*     */ 
/*     */ public class DummyModContainer
/*     */   implements ModContainer
/*     */ {
/*     */   private ModMetadata md;
/*     */   private ArtifactVersion processedVersion;
/*     */   private String label;
/*     */   
/*     */   public DummyModContainer(ModMetadata md) {
/*  37 */     this.md = md;
/*     */   }
/*     */ 
/*     */   
/*     */   public DummyModContainer(String label) {
/*  42 */     this.label = label;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DummyModContainer() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void bindMetadata(MetadataCollection mc) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependants() {
/*  56 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependencies() {
/*  62 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<ArtifactVersion> getRequirements() {
/*  68 */     return Collections.emptySet();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModMetadata getMetadata() {
/*  74 */     return this.md;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getMod() {
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModId() {
/*  86 */     return this.md.modId;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  92 */     return this.md.name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSortingRules() {
/*  98 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSource() {
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 110 */     return this.md.version;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(Object mod) {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledState(boolean enabled) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArtifactVersion getProcessedVersion() {
/* 133 */     if (this.processedVersion == null)
/*     */     {
/* 135 */       this.processedVersion = (ArtifactVersion)new DefaultArtifactVersion(getModId(), getVersion());
/*     */     }
/* 137 */     return this.processedVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isImmutable() {
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayVersion() {
/* 149 */     return this.md.version;
/*     */   }
/*     */ 
/*     */   
/*     */   public VersionRange acceptableMinecraftVersionRange() {
/* 154 */     return Loader.instance().getMinecraftModContainer().getStaticVersionRange();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Certificate getSigningCertificate() {
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return (this.md != null) ? getModId() : ("Dummy Container (" + this.label + ") @" + System.identityHashCode(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getCustomModProperties() {
/* 172 */     return EMPTY_PROPERTIES;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getCustomResourcePackClass() {
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getSharedModDescriptor() {
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModContainer.Disableable canBeDisabled() {
/* 189 */     return ModContainer.Disableable.NEVER;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiClassName() {
/* 195 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getOwnedPackages() {
/* 201 */     return (List<String>)ImmutableList.of();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\DummyModContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */