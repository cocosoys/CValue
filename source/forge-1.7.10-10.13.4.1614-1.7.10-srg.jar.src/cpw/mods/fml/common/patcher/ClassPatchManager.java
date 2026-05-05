/*     */ package cpw.mods.fml.common.patcher;
/*     */ 
/*     */ import LZMA.LzmaInputStream;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.hash.Hashing;
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import com.google.common.io.Files;
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.repackage.com.nothome.delta.GDiffPatcher;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import java.util.jar.Pack200;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassPatchManager
/*     */ {
/*  38 */   public static final ClassPatchManager INSTANCE = new ClassPatchManager();
/*     */   
/*  40 */   public static final boolean dumpPatched = Boolean.parseBoolean(System.getProperty("fml.dumpPatchedClasses", "false"));
/*  41 */   public static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("fml.debugClassPatchManager", "false"));
/*     */   
/*  43 */   private GDiffPatcher patcher = new GDiffPatcher();
/*     */   
/*     */   private ListMultimap<String, ClassPatch> patches;
/*  46 */   private Map<String, byte[]> patchedClasses = Maps.newHashMap();
/*     */   private File tempDir;
/*     */   
/*     */   private ClassPatchManager() {
/*  50 */     if (dumpPatched) {
/*     */       
/*  52 */       this.tempDir = Files.createTempDir();
/*  53 */       FMLRelaunchLog.info("Dumping patched classes to %s", new Object[] { this.tempDir.getAbsolutePath() });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getPatchedResource(String name, String mappedName, LaunchClassLoader loader) throws IOException {
/*  60 */     byte[] rawClassBytes = loader.getClassBytes(name);
/*  61 */     return applyPatch(name, mappedName, rawClassBytes);
/*     */   }
/*     */   
/*     */   public byte[] applyPatch(String name, String mappedName, byte[] inputData) {
/*  65 */     if (this.patches == null)
/*     */     {
/*  67 */       return inputData;
/*     */     }
/*  69 */     if (this.patchedClasses.containsKey(name))
/*     */     {
/*  71 */       return this.patchedClasses.get(name);
/*     */     }
/*  73 */     List<ClassPatch> list = this.patches.get(name);
/*  74 */     if (list.isEmpty())
/*     */     {
/*  76 */       return inputData;
/*     */     }
/*  78 */     boolean ignoredError = false;
/*  79 */     if (DEBUG)
/*  80 */       FMLRelaunchLog.fine("Runtime patching class %s (input size %d), found %d patch%s", new Object[] { mappedName, Integer.valueOf((inputData == null) ? 0 : inputData.length), Integer.valueOf(list.size()), (list.size() != 1) ? "es" : "" }); 
/*  81 */     for (ClassPatch patch : list) {
/*     */       
/*  83 */       if (!patch.targetClassName.equals(mappedName) && !patch.sourceClassName.equals(name))
/*     */       {
/*  85 */         FMLRelaunchLog.warning("Binary patch found %s for wrong class %s", new Object[] { patch.targetClassName, mappedName });
/*     */       }
/*  87 */       if (!patch.existsAtTarget && (inputData == null || inputData.length == 0)) {
/*     */         
/*  89 */         inputData = new byte[0];
/*     */       }
/*  91 */       else if (!patch.existsAtTarget) {
/*     */         
/*  93 */         FMLRelaunchLog.warning("Patcher expecting empty class data file for %s, but received non-empty", new Object[] { patch.targetClassName });
/*     */       }
/*     */       else {
/*     */         
/*  97 */         int inputChecksum = Hashing.adler32().hashBytes(inputData).asInt();
/*  98 */         if (patch.inputChecksum != inputChecksum) {
/*     */           
/* 100 */           FMLRelaunchLog.severe("There is a binary discrepency between the expected input class %s (%s) and the actual class. Checksum on disk is %x, in patch %x. Things are probably about to go very wrong. Did you put something into the jar file?", new Object[] { mappedName, name, Integer.valueOf(inputChecksum), Integer.valueOf(patch.inputChecksum) });
/* 101 */           if (!Boolean.parseBoolean(System.getProperty("fml.ignorePatchDiscrepancies", "false"))) {
/*     */             
/* 103 */             FMLRelaunchLog.severe("The game is going to exit, because this is a critical error, and it is very improbable that the modded game will work, please obtain clean jar files.", new Object[0]);
/* 104 */             System.exit(1);
/*     */           }
/*     */           else {
/*     */             
/* 108 */             FMLRelaunchLog.severe("FML is going to ignore this error, note that the patch will not be applied, and there is likely to be a malfunctioning behaviour, including not running at all", new Object[0]);
/* 109 */             ignoredError = true;
/*     */             continue;
/*     */           } 
/*     */         } 
/*     */       } 
/* 114 */       synchronized (this.patcher) {
/*     */ 
/*     */         
/*     */         try {
/* 118 */           inputData = this.patcher.patch(inputData, patch.patch);
/*     */         }
/* 120 */         catch (IOException e) {
/*     */           
/* 122 */           FMLRelaunchLog.log(Level.ERROR, e, "Encountered problem runtime patching class %s", new Object[] { name });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     if (!ignoredError && DEBUG)
/*     */     {
/* 129 */       FMLRelaunchLog.fine("Successfully applied runtime patches for %s (new size %d)", new Object[] { mappedName, Integer.valueOf(inputData.length) });
/*     */     }
/* 131 */     if (dumpPatched) {
/*     */       
/*     */       try {
/*     */         
/* 135 */         Files.write(inputData, new File(this.tempDir, mappedName));
/*     */       }
/* 137 */       catch (IOException e) {
/*     */         
/* 139 */         FMLRelaunchLog.log(Level.ERROR, e, "Failed to write %s to %s", new Object[] { mappedName, this.tempDir.getAbsolutePath() });
/*     */       } 
/*     */     }
/* 142 */     this.patchedClasses.put(name, inputData);
/* 143 */     return inputData;
/*     */   }
/*     */   
/*     */   public void setup(Side side) {
/*     */     JarInputStream jis;
/* 148 */     Pattern binpatchMatcher = Pattern.compile(String.format("binpatch/%s/.*.binpatch", new Object[] { side.toString().toLowerCase(Locale.ENGLISH) }));
/*     */ 
/*     */     
/*     */     try {
/* 152 */       InputStream binpatchesCompressed = getClass().getResourceAsStream("/binpatches.pack.lzma");
/* 153 */       if (binpatchesCompressed == null) {
/*     */         
/* 155 */         FMLRelaunchLog.log(Level.ERROR, "The binary patch set is missing. Either you are in a development environment, or things are not going to work!", new Object[0]);
/*     */         return;
/*     */       } 
/* 158 */       LzmaInputStream binpatchesDecompressed = new LzmaInputStream(binpatchesCompressed);
/* 159 */       ByteArrayOutputStream jarBytes = new ByteArrayOutputStream();
/* 160 */       JarOutputStream jos = new JarOutputStream(jarBytes);
/* 161 */       Pack200.newUnpacker().unpack((InputStream)binpatchesDecompressed, jos);
/* 162 */       jis = new JarInputStream(new ByteArrayInputStream(jarBytes.toByteArray()));
/*     */     }
/* 164 */     catch (Exception e) {
/*     */       
/* 166 */       FMLRelaunchLog.log(Level.ERROR, e, "Error occurred reading binary patches. Expect severe problems!", new Object[0]);
/* 167 */       throw Throwables.propagate(e);
/*     */     } 
/*     */     
/* 170 */     this.patches = (ListMultimap<String, ClassPatch>)ArrayListMultimap.create();
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       try {
/* 176 */         JarEntry entry = jis.getNextJarEntry();
/* 177 */         if (entry == null) {
/*     */           break;
/*     */         }
/*     */         
/* 181 */         if (binpatchMatcher.matcher(entry.getName()).matches()) {
/*     */           
/* 183 */           ClassPatch cp = readPatch(entry, jis);
/* 184 */           if (cp != null)
/*     */           {
/* 186 */             this.patches.put(cp.sourceClassName, cp);
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 191 */         jis.closeEntry();
/*     */       
/*     */       }
/* 194 */       catch (IOException iOException) {}
/*     */     } 
/*     */ 
/*     */     
/* 198 */     FMLRelaunchLog.fine("Read %d binary patches", new Object[] { Integer.valueOf(this.patches.size()) });
/* 199 */     if (DEBUG)
/* 200 */       FMLRelaunchLog.fine("Patch list :\n\t%s", new Object[] { Joiner.on("\t\n").join(this.patches.asMap().entrySet()) }); 
/* 201 */     this.patchedClasses.clear();
/*     */   }
/*     */   
/*     */   private ClassPatch readPatch(JarEntry patchEntry, JarInputStream jis) {
/*     */     ByteArrayDataInput input;
/* 206 */     if (DEBUG) {
/* 207 */       FMLRelaunchLog.finer("Reading patch data from %s", new Object[] { patchEntry.getName() });
/*     */     }
/*     */     
/*     */     try {
/* 211 */       input = ByteStreams.newDataInput(ByteStreams.toByteArray(jis));
/*     */     }
/* 213 */     catch (IOException e) {
/*     */       
/* 215 */       FMLRelaunchLog.log(Level.WARN, e, "Unable to read binpatch file %s - ignoring", new Object[] { patchEntry.getName() });
/* 216 */       return null;
/*     */     } 
/* 218 */     String name = input.readUTF();
/* 219 */     String sourceClassName = input.readUTF();
/* 220 */     String targetClassName = input.readUTF();
/* 221 */     boolean exists = input.readBoolean();
/* 222 */     int inputChecksum = 0;
/* 223 */     if (exists)
/*     */     {
/* 225 */       inputChecksum = input.readInt();
/*     */     }
/* 227 */     int patchLength = input.readInt();
/* 228 */     byte[] patchBytes = new byte[patchLength];
/* 229 */     input.readFully(patchBytes);
/*     */     
/* 231 */     return new ClassPatch(name, sourceClassName, targetClassName, exists, inputChecksum, patchBytes);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\patcher\ClassPatchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */