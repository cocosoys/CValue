/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.VersionRange;
/*     */ import java.io.File;
/*     */ import java.security.cert.Certificate;
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
/*     */ public class InjectedModContainer
/*     */   implements ModContainer
/*     */ {
/*     */   private File source;
/*     */   public final ModContainer wrappedContainer;
/*     */   
/*     */   public InjectedModContainer(ModContainer mc, File source) {
/*  33 */     this.source = (source != null) ? source : new File("minecraft.jar");
/*  34 */     this.wrappedContainer = mc;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModId() {
/*  40 */     return this.wrappedContainer.getModId();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  46 */     return this.wrappedContainer.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  52 */     return this.wrappedContainer.getVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSource() {
/*  58 */     return this.source;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModMetadata getMetadata() {
/*  64 */     return this.wrappedContainer.getMetadata();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bindMetadata(MetadataCollection mc) {
/*  70 */     this.wrappedContainer.bindMetadata(mc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledState(boolean enabled) {
/*  76 */     this.wrappedContainer.setEnabledState(enabled);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<ArtifactVersion> getRequirements() {
/*  82 */     return this.wrappedContainer.getRequirements();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependencies() {
/*  88 */     return this.wrappedContainer.getDependencies();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependants() {
/*  94 */     return this.wrappedContainer.getDependants();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSortingRules() {
/* 100 */     return this.wrappedContainer.getSortingRules();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 106 */     return this.wrappedContainer.registerBus(bus, controller);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(Object mod) {
/* 112 */     return this.wrappedContainer.matches(mod);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getMod() {
/* 118 */     return this.wrappedContainer.getMod();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArtifactVersion getProcessedVersion() {
/* 124 */     return this.wrappedContainer.getProcessedVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isImmutable() {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayVersion() {
/* 136 */     return this.wrappedContainer.getDisplayVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionRange acceptableMinecraftVersionRange() {
/* 142 */     return this.wrappedContainer.acceptableMinecraftVersionRange();
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldAccessContainer getWrappedWorldAccessContainer() {
/* 147 */     if (this.wrappedContainer instanceof WorldAccessContainer)
/*     */     {
/* 149 */       return (WorldAccessContainer)this.wrappedContainer;
/*     */     }
/*     */ 
/*     */     
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Certificate getSigningCertificate() {
/* 160 */     return this.wrappedContainer.getSigningCertificate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return "Wrapped{" + this.wrappedContainer.toString() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getCustomModProperties() {
/* 172 */     return this.wrappedContainer.getCustomModProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCustomResourcePackClass() {
/* 178 */     return this.wrappedContainer.getCustomResourcePackClass();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getSharedModDescriptor() {
/* 184 */     return this.wrappedContainer.getSharedModDescriptor();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModContainer.Disableable canBeDisabled() {
/* 190 */     return this.wrappedContainer.canBeDisabled();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiClassName() {
/* 196 */     return this.wrappedContainer.getGuiClassName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getOwnedPackages() {
/* 202 */     return this.wrappedContainer.getOwnedPackages();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\InjectedModContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */