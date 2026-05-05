/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
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
/*     */ public interface ModContainer
/*     */ {
/*     */   public enum Disableable
/*     */   {
/*  43 */     YES, RESTART, NEVER, DEPENDENCIES;
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
/* 138 */   public static final Map<String, String> EMPTY_PROPERTIES = (Map<String, String>)ImmutableMap.of();
/*     */   
/*     */   String getModId();
/*     */   
/*     */   String getName();
/*     */   
/*     */   String getVersion();
/*     */   
/*     */   File getSource();
/*     */   
/*     */   ModMetadata getMetadata();
/*     */   
/*     */   void bindMetadata(MetadataCollection paramMetadataCollection);
/*     */   
/*     */   void setEnabledState(boolean paramBoolean);
/*     */   
/*     */   Set<ArtifactVersion> getRequirements();
/*     */   
/*     */   List<ArtifactVersion> getDependencies();
/*     */   
/*     */   List<ArtifactVersion> getDependants();
/*     */   
/*     */   String getSortingRules();
/*     */   
/*     */   boolean registerBus(EventBus paramEventBus, LoadController paramLoadController);
/*     */   
/*     */   boolean matches(Object paramObject);
/*     */   
/*     */   Object getMod();
/*     */   
/*     */   ArtifactVersion getProcessedVersion();
/*     */   
/*     */   boolean isImmutable();
/*     */   
/*     */   String getDisplayVersion();
/*     */   
/*     */   VersionRange acceptableMinecraftVersionRange();
/*     */   
/*     */   Certificate getSigningCertificate();
/*     */   
/*     */   Map<String, String> getCustomModProperties();
/*     */   
/*     */   Class<?> getCustomResourcePackClass();
/*     */   
/*     */   Map<String, String> getSharedModDescriptor();
/*     */   
/*     */   Disableable canBeDisabled();
/*     */   
/*     */   String getGuiClassName();
/*     */   
/*     */   List<String> getOwnedPackages();
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ModContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */