/*     */ package cpw.mods.fml.common.event;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLModContainer;
/*     */ import cpw.mods.fml.common.LoaderState;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.ModMetadata;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import java.io.File;
/*     */ import java.security.CodeSource;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.Properties;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public class FMLPreInitializationEvent
/*     */   extends FMLStateEvent
/*     */ {
/*     */   private ModMetadata modMetadata;
/*     */   private File sourceFile;
/*     */   private File configurationDir;
/*     */   private File suggestedConfigFile;
/*     */   private ASMDataTable asmData;
/*     */   private ModContainer modContainer;
/*     */   
/*     */   public FMLPreInitializationEvent(Object... data) {
/*  40 */     super(data);
/*  41 */     this.asmData = (ASMDataTable)data[0];
/*  42 */     this.configurationDir = (File)data[1];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LoaderState.ModState getModState() {
/*  48 */     return LoaderState.ModState.PREINITIALIZED;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyModContainer(ModContainer activeContainer) {
/*  54 */     this.modContainer = activeContainer;
/*  55 */     this.modMetadata = activeContainer.getMetadata();
/*  56 */     this.sourceFile = activeContainer.getSource();
/*  57 */     this.suggestedConfigFile = new File(this.configurationDir, activeContainer.getModId() + ".cfg");
/*     */   }
/*     */ 
/*     */   
/*     */   public File getSourceFile() {
/*  62 */     return this.sourceFile;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModMetadata getModMetadata() {
/*  67 */     return this.modMetadata;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getModConfigurationDirectory() {
/*  72 */     return this.configurationDir;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getSuggestedConfigurationFile() {
/*  77 */     return this.suggestedConfigFile;
/*     */   }
/*     */ 
/*     */   
/*     */   public ASMDataTable getAsmData() {
/*  82 */     return this.asmData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Properties getVersionProperties() {
/*  87 */     if (this.modContainer instanceof FMLModContainer)
/*     */     {
/*  89 */       return ((FMLModContainer)this.modContainer).searchForVersionProperties();
/*     */     }
/*     */     
/*  92 */     return null;
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
/*     */   public Logger getModLog() {
/* 104 */     Logger log = LogManager.getLogger(this.modContainer.getModId());
/* 105 */     return log;
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
/*     */   @Deprecated
/*     */   public Certificate[] getFMLSigningCertificates() {
/* 121 */     CodeSource codeSource = getClass().getClassLoader().getParent().getClass().getProtectionDomain().getCodeSource();
/* 122 */     Certificate[] certs = codeSource.getCertificates();
/* 123 */     if (certs == null)
/*     */     {
/* 125 */       return new Certificate[0];
/*     */     }
/*     */ 
/*     */     
/* 129 */     return certs;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLPreInitializationEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */