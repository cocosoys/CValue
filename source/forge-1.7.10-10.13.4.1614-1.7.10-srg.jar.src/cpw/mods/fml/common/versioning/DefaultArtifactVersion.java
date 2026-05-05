/*     */ package cpw.mods.fml.common.versioning;
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
/*     */ public class DefaultArtifactVersion
/*     */   implements ArtifactVersion
/*     */ {
/*     */   private ComparableVersion comparableVersion;
/*     */   private String label;
/*     */   private boolean unbounded;
/*     */   private VersionRange range;
/*     */   
/*     */   public DefaultArtifactVersion(String versionNumber) {
/*  25 */     this.comparableVersion = new ComparableVersion(versionNumber);
/*  26 */     this.range = VersionRange.createFromVersion(versionNumber, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultArtifactVersion(String label, VersionRange range) {
/*  31 */     this.label = label;
/*  32 */     this.range = range;
/*     */   }
/*     */   
/*     */   public DefaultArtifactVersion(String label, String version) {
/*  36 */     this(version);
/*  37 */     this.label = label;
/*     */   }
/*     */ 
/*     */   
/*     */   public DefaultArtifactVersion(String string, boolean unbounded) {
/*  42 */     this.label = string;
/*  43 */     this.unbounded = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/*  49 */     return ((DefaultArtifactVersion)obj).containsVersion(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(ArtifactVersion o) {
/*  55 */     return this.unbounded ? 0 : this.comparableVersion.compareTo(((DefaultArtifactVersion)o).comparableVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLabel() {
/*  61 */     return this.label;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsVersion(ArtifactVersion source) {
/*  67 */     if (!source.getLabel().equals(getLabel()))
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     if (this.unbounded)
/*     */     {
/*  73 */       return true;
/*     */     }
/*  75 */     if (this.range != null)
/*     */     {
/*  77 */       return this.range.containsVersion(source);
/*     */     }
/*     */ 
/*     */     
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersionString() {
/*  88 */     return (this.comparableVersion == null) ? "unknown" : this.comparableVersion.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRangeString() {
/*  94 */     return (this.range == null) ? "any" : this.range.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  99 */     return (this.label == null) ? this.comparableVersion.toString() : (this.label + (this.unbounded ? "" : ("@" + this.range)));
/*     */   }
/*     */ 
/*     */   
/*     */   public VersionRange getRange() {
/* 104 */     return this.range;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\DefaultArtifactVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */