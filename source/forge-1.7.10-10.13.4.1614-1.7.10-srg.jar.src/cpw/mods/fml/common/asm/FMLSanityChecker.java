/*     */ package cpw.mods.fml.common.asm;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import cpw.mods.fml.common.CertificateHelper;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
/*     */ import cpw.mods.fml.common.patcher.ClassPatchManager;
/*     */ import cpw.mods.fml.relauncher.FMLLaunchHandler;
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import cpw.mods.fml.relauncher.IFMLCallHook;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URLDecoder;
/*     */ import java.security.CodeSource;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.Map;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ public class FMLSanityChecker
/*     */   implements IFMLCallHook
/*     */ {
/*  41 */   private static final String FMLFINGERPRINT = "51:0A:FB:4C:AF:A4:A0:F2:F5:CF:C5:0E:B4:CC:3C:30:24:4A:E3:8E".toLowerCase().replace(":", "");
/*  42 */   private static final String FORGEFINGERPRINT = "E3:C3:D5:0C:7C:98:6D:F7:4C:64:5C:0A:C5:46:39:74:1C:90:A5:57".toLowerCase().replace(":", "");
/*  43 */   private static final String MCFINGERPRINT = "CD:99:95:96:56:F7:53:DC:28:D8:63:B4:67:69:F7:F8:FB:AE:FC:FC".toLowerCase().replace(":", "");
/*     */   
/*     */   private LaunchClassLoader cl;
/*     */   
/*     */   private boolean liveEnv;
/*     */   public static File fmlLocation;
/*     */   
/*     */   public Void call() throws Exception {
/*  51 */     CodeSource codeSource = getClass().getProtectionDomain().getCodeSource();
/*  52 */     boolean goodFML = false;
/*  53 */     boolean fmlIsJar = false;
/*  54 */     if (codeSource.getLocation().getProtocol().equals("jar")) {
/*     */       
/*  56 */       fmlIsJar = true;
/*  57 */       Certificate[] certificates = codeSource.getCertificates();
/*  58 */       if (certificates != null)
/*     */       {
/*     */         
/*  61 */         for (Certificate cert : certificates) {
/*     */           
/*  63 */           String fingerprint = CertificateHelper.getFingerprint(cert);
/*  64 */           if (fingerprint.equals(FMLFINGERPRINT))
/*     */           {
/*  66 */             FMLRelaunchLog.info("Found valid fingerprint for FML. Certificate fingerprint %s", new Object[] { fingerprint });
/*  67 */             goodFML = true;
/*     */           }
/*  69 */           else if (fingerprint.equals(FORGEFINGERPRINT))
/*     */           {
/*  71 */             FMLRelaunchLog.info("Found valid fingerprint for Minecraft Forge. Certificate fingerprint %s", new Object[] { fingerprint });
/*  72 */             goodFML = true;
/*     */           }
/*     */           else
/*     */           {
/*  76 */             FMLRelaunchLog.severe("Found invalid fingerprint for FML: %s", new Object[] { fingerprint });
/*     */           }
/*     */         
/*     */         } 
/*     */       }
/*     */     } else {
/*     */       
/*  83 */       goodFML = true;
/*     */     } 
/*     */     
/*  86 */     boolean goodMC = (FMLLaunchHandler.side() == Side.SERVER || !this.liveEnv);
/*  87 */     int certCount = 0;
/*     */     
/*     */     try {
/*  90 */       Class<?> cbr = Class.forName("net.minecraft.client.ClientBrandRetriever", false, (ClassLoader)this.cl);
/*  91 */       codeSource = cbr.getProtectionDomain().getCodeSource();
/*     */     }
/*  93 */     catch (Exception e) {
/*     */ 
/*     */       
/*  96 */       goodMC = true;
/*     */     } 
/*  98 */     JarFile mcJarFile = null;
/*  99 */     if (fmlIsJar && !goodMC && codeSource.getLocation().getProtocol().equals("jar")) {
/*     */ 
/*     */       
/*     */       try {
/* 103 */         String mcPath = codeSource.getLocation().getPath().substring(5);
/* 104 */         mcPath = mcPath.substring(0, mcPath.lastIndexOf('!'));
/* 105 */         mcPath = URLDecoder.decode(mcPath, Charsets.UTF_8.name());
/* 106 */         mcJarFile = new JarFile(mcPath, true);
/* 107 */         mcJarFile.getManifest();
/* 108 */         JarEntry cbrEntry = mcJarFile.getJarEntry("net/minecraft/client/ClientBrandRetriever.class");
/* 109 */         ByteStreams.toByteArray(mcJarFile.getInputStream(cbrEntry));
/* 110 */         Certificate[] certificates = cbrEntry.getCertificates();
/* 111 */         certCount = (certificates != null) ? certificates.length : 0;
/* 112 */         if (certificates != null)
/*     */         {
/*     */           
/* 115 */           for (Certificate cert : certificates) {
/*     */             
/* 117 */             String fingerprint = CertificateHelper.getFingerprint(cert);
/* 118 */             if (fingerprint.equals(MCFINGERPRINT))
/*     */             {
/* 120 */               FMLRelaunchLog.info("Found valid fingerprint for Minecraft. Certificate fingerprint %s", new Object[] { fingerprint });
/* 121 */               goodMC = true;
/*     */             }
/*     */           
/*     */           } 
/*     */         }
/* 126 */       } catch (Throwable e) {
/*     */         
/* 128 */         FMLRelaunchLog.log(Level.ERROR, e, "A critical error occurred trying to read the minecraft jar file", new Object[0]);
/*     */       }
/*     */       finally {
/*     */         
/* 132 */         if (mcJarFile != null) {
/*     */           
/*     */           try {
/*     */             
/* 136 */             mcJarFile.close();
/*     */           }
/* 138 */           catch (IOException iOException) {}
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 147 */       goodMC = true;
/*     */     } 
/* 149 */     if (!goodMC) {
/*     */       
/* 151 */       FMLRelaunchLog.severe("The minecraft jar %s appears to be corrupt! There has been CRITICAL TAMPERING WITH MINECRAFT, it is highly unlikely minecraft will work! STOP NOW, get a clean copy and try again!", new Object[] { codeSource.getLocation().getFile() });
/* 152 */       if (!Boolean.parseBoolean(System.getProperty("fml.ignoreInvalidMinecraftCertificates", "false"))) {
/*     */         
/* 154 */         FMLRelaunchLog.severe("For your safety, FML will not launch minecraft. You will need to fetch a clean version of the minecraft jar file", new Object[0]);
/* 155 */         FMLRelaunchLog.severe("Technical information: The class net.minecraft.client.ClientBrandRetriever should have been associated with the minecraft jar file, and should have returned us a valid, intact minecraft jar location. This did not work. Either you have modified the minecraft jar file (if so run the forge installer again), or you are using a base editing jar that is changing this class (and likely others too). If you REALLY want to run minecraft in this configuration, add the flag -Dfml.ignoreInvalidMinecraftCertificates=true to the 'JVM settings' in your launcher profile.", new Object[0]);
/*     */ 
/*     */ 
/*     */         
/* 159 */         FMLCommonHandler.instance().exitJava(1, false);
/*     */       }
/*     */       else {
/*     */         
/* 163 */         FMLRelaunchLog.severe("FML has been ordered to ignore the invalid or missing minecraft certificate. This is very likely to cause a problem!", new Object[0]);
/* 164 */         FMLRelaunchLog.severe("Technical information: ClientBrandRetriever was at %s, there were %d certificates for it", new Object[] { codeSource.getLocation(), Integer.valueOf(certCount) });
/*     */       } 
/*     */     } 
/* 167 */     if (!goodFML)
/*     */     {
/* 169 */       FMLRelaunchLog.severe("FML appears to be missing any signature data. This is not a good thing", new Object[0]);
/*     */     }
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void injectData(Map<String, Object> data) {
/* 177 */     this.liveEnv = ((Boolean)data.get("runtimeDeobfuscationEnabled")).booleanValue();
/* 178 */     this.cl = (LaunchClassLoader)data.get("classLoader");
/* 179 */     File mcDir = (File)data.get("mcLocation");
/* 180 */     fmlLocation = (File)data.get("coremodLocation");
/* 181 */     ClassPatchManager.INSTANCE.setup(FMLLaunchHandler.side());
/* 182 */     FMLDeobfuscatingRemapper.INSTANCE.setup(mcDir, this.cl, (String)data.get("deobfuscationFileName"));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\FMLSanityChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */