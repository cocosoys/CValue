/*    */ package cpw.mods.fml.relauncher;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLInjectionData
/*    */ {
/*    */   static File minecraftHome;
/*    */   static String major;
/*    */   static String minor;
/*    */   static String rev;
/*    */   static String build;
/*    */   static String mccversion;
/*    */   static String mcpversion;
/*    */   static String deobfuscationDataHash;
/* 36 */   public static List<String> containers = new ArrayList<String>();
/*    */ 
/*    */   
/*    */   static void build(File mcHome, LaunchClassLoader classLoader) {
/* 40 */     minecraftHome = mcHome;
/* 41 */     InputStream stream = classLoader.getResourceAsStream("fmlversion.properties");
/* 42 */     Properties properties = new Properties();
/*    */     
/* 44 */     if (stream != null) {
/*    */       
/*    */       try {
/*    */         
/* 48 */         properties.load(stream);
/*    */       }
/* 50 */       catch (IOException ex) {
/*    */         
/* 52 */         FMLRelaunchLog.log(Level.ERROR, ex, "Could not get FML version information - corrupted installation detected!", new Object[0]);
/*    */       } 
/*    */     }
/*    */     
/* 56 */     major = properties.getProperty("fmlbuild.major.number", "missing");
/* 57 */     minor = properties.getProperty("fmlbuild.minor.number", "missing");
/* 58 */     rev = properties.getProperty("fmlbuild.revision.number", "missing");
/* 59 */     build = properties.getProperty("fmlbuild.build.number", "missing");
/* 60 */     mccversion = properties.getProperty("fmlbuild.mcversion", "missing");
/* 61 */     mcpversion = properties.getProperty("fmlbuild.mcpversion", "missing");
/* 62 */     deobfuscationDataHash = properties.getProperty("fmlbuild.deobfuscation.hash", "deadbeef");
/*    */   }
/*    */ 
/*    */   
/*    */   static String debfuscationDataName() {
/* 67 */     return "/deobfuscation_data-" + mccversion + ".lzma";
/*    */   }
/*    */   
/*    */   public static Object[] data() {
/* 71 */     return new Object[] { major, minor, rev, build, mccversion, mcpversion, minecraftHome, containers };
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FMLInjectionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */