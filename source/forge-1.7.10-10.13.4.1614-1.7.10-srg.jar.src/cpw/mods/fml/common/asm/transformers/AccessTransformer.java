/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.io.CharSource;
/*     */ import com.google.common.io.LineProcessor;
/*     */ import com.google.common.io.Resources;
/*     */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.FieldNode;
/*     */ import org.objectweb.asm.tree.MethodInsnNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
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
/*     */ public class AccessTransformer
/*     */   implements IClassTransformer
/*     */ {
/*  62 */   private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("fml.debugAccessTransformer", "false"));
/*     */   
/*     */   class Modifier {
/*  65 */     public String name = "";
/*  66 */     public String desc = "";
/*  67 */     public int oldAccess = 0;
/*  68 */     public int newAccess = 0;
/*  69 */     public int targetAccess = 0;
/*     */     
/*     */     public boolean changeFinal = false;
/*     */     public boolean markFinal = false;
/*     */     protected boolean modifyClassVisibility;
/*     */     
/*     */     private void setTargetAccess(String name) {
/*  76 */       if (name.startsWith("public")) { this.targetAccess = 1; }
/*  77 */       else if (name.startsWith("private")) { this.targetAccess = 2; }
/*  78 */       else if (name.startsWith("protected")) { this.targetAccess = 4; }
/*     */       
/*  80 */       if (name.endsWith("-f")) {
/*     */         
/*  82 */         this.changeFinal = true;
/*  83 */         this.markFinal = false;
/*     */       }
/*  85 */       else if (name.endsWith("+f")) {
/*     */         
/*  87 */         this.changeFinal = true;
/*  88 */         this.markFinal = true;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*  93 */   private Multimap<String, Modifier> modifiers = (Multimap<String, Modifier>)ArrayListMultimap.create();
/*     */ 
/*     */   
/*     */   public AccessTransformer() throws IOException {
/*  97 */     this("fml_at.cfg");
/*     */   }
/*     */   
/*     */   protected AccessTransformer(String rulesFile) throws IOException {
/* 101 */     readMapFile(rulesFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void readMapFile(String rulesFile) throws IOException {
/*     */     URL rulesResource;
/* 110 */     File file = new File(rulesFile);
/*     */     
/* 112 */     if (file.exists()) {
/*     */       
/* 114 */       rulesResource = file.toURI().toURL();
/*     */     }
/*     */     else {
/*     */       
/* 118 */       rulesResource = Resources.getResource(rulesFile);
/*     */     } 
/* 120 */     processATFile(Resources.asCharSource(rulesResource, Charsets.UTF_8));
/* 121 */     FMLRelaunchLog.fine("Loaded %d rules from AccessTransformer config file %s", new Object[] { Integer.valueOf(this.modifiers.size()), rulesFile });
/*     */   }
/*     */   
/*     */   protected void processATFile(CharSource rulesResource) throws IOException {
/* 125 */     rulesResource.readLines(new LineProcessor<Void>()
/*     */         {
/*     */           
/*     */           public Void getResult()
/*     */           {
/* 130 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean processLine(String input) throws IOException {
/* 136 */             String line = ((String)Iterables.getFirst(Splitter.on('#').limit(2).split(input), "")).trim();
/* 137 */             if (line.length() == 0)
/*     */             {
/* 139 */               return true;
/*     */             }
/* 141 */             List<String> parts = Lists.newArrayList(Splitter.on(" ").trimResults().split(line));
/* 142 */             if (parts.size() > 3)
/*     */             {
/* 144 */               throw new RuntimeException("Invalid config file line " + input);
/*     */             }
/* 146 */             AccessTransformer.Modifier m = new AccessTransformer.Modifier();
/* 147 */             m.setTargetAccess(parts.get(0));
/*     */             
/* 149 */             if (parts.size() == 2) {
/*     */               
/* 151 */               m.modifyClassVisibility = true;
/*     */             }
/*     */             else {
/*     */               
/* 155 */               String nameReference = parts.get(2);
/* 156 */               int parenIdx = nameReference.indexOf('(');
/* 157 */               if (parenIdx > 0) {
/*     */                 
/* 159 */                 m.desc = nameReference.substring(parenIdx);
/* 160 */                 m.name = nameReference.substring(0, parenIdx);
/*     */               }
/*     */               else {
/*     */                 
/* 164 */                 m.name = nameReference;
/*     */               } 
/*     */             } 
/* 167 */             String className = ((String)parts.get(1)).replace('/', '.');
/* 168 */             AccessTransformer.this.modifiers.put(className, m);
/* 169 */             if (AccessTransformer.DEBUG) System.out.printf("AT RULE: %s %s %s (type %s)\n", new Object[] { AccessTransformer.access$300(this.this$0, m.targetAccess), m.name, m.desc, className }); 
/* 170 */             return true;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/* 178 */     if (bytes == null) return null;
/*     */     
/* 180 */     if (DEBUG)
/*     */     {
/* 182 */       FMLRelaunchLog.fine("Considering all methods and fields on %s (%s)\n", new Object[] { transformedName, name });
/*     */     }
/* 184 */     if (!this.modifiers.containsKey(transformedName)) return bytes;
/*     */     
/* 186 */     ClassNode classNode = new ClassNode();
/* 187 */     ClassReader classReader = new ClassReader(bytes);
/* 188 */     classReader.accept((ClassVisitor)classNode, 0);
/*     */     
/* 190 */     Collection<Modifier> mods = this.modifiers.get(transformedName);
/* 191 */     for (Modifier m : mods) {
/*     */       
/* 193 */       if (m.modifyClassVisibility) {
/*     */         
/* 195 */         classNode.access = getFixedAccess(classNode.access, m);
/* 196 */         if (DEBUG)
/*     */         {
/* 198 */           System.out.println(String.format("Class: %s %s -> %s", new Object[] { name, toBinary(m.oldAccess), toBinary(m.newAccess) }));
/*     */         }
/*     */         continue;
/*     */       } 
/* 202 */       if (m.desc.isEmpty()) {
/*     */         
/* 204 */         for (FieldNode n : classNode.fields) {
/*     */           
/* 206 */           if (n.name.equals(m.name) || m.name.equals("*")) {
/*     */             
/* 208 */             n.access = getFixedAccess(n.access, m);
/* 209 */             if (DEBUG)
/*     */             {
/* 211 */               System.out.println(String.format("Field: %s.%s %s -> %s", new Object[] { name, n.name, toBinary(m.oldAccess), toBinary(m.newAccess) }));
/*     */             }
/*     */             
/* 214 */             if (!m.name.equals("*")) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 223 */       List<MethodNode> nowOverridable = Lists.newArrayList();
/* 224 */       for (MethodNode n : classNode.methods) {
/*     */         
/* 226 */         if ((n.name.equals(m.name) && n.desc.equals(m.desc)) || m.name.equals("*")) {
/*     */           
/* 228 */           n.access = getFixedAccess(n.access, m);
/*     */ 
/*     */           
/* 231 */           if (!n.name.equals("<init>")) {
/*     */ 
/*     */ 
/*     */             
/* 235 */             boolean wasPrivate = ((m.oldAccess & 0x2) == 2);
/* 236 */             boolean isNowPrivate = ((m.newAccess & 0x2) == 2);
/*     */             
/* 238 */             if (wasPrivate && !isNowPrivate)
/*     */             {
/* 240 */               nowOverridable.add(n);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 245 */           if (DEBUG)
/*     */           {
/* 247 */             System.out.println(String.format("Method: %s.%s%s %s -> %s", new Object[] { name, n.name, n.desc, toBinary(m.oldAccess), toBinary(m.newAccess) }));
/*     */           }
/*     */           
/* 250 */           if (!m.name.equals("*")) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 257 */       replaceInvokeSpecial(classNode, nowOverridable);
/*     */     } 
/*     */ 
/*     */     
/* 261 */     ClassWriter writer = new ClassWriter(1);
/* 262 */     classNode.accept((ClassVisitor)writer);
/* 263 */     return writer.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   private void replaceInvokeSpecial(ClassNode clazz, List<MethodNode> toReplace) {
/* 268 */     for (MethodNode method : clazz.methods) {
/*     */       
/* 270 */       for (Iterator<AbstractInsnNode> it = method.instructions.iterator(); it.hasNext(); ) {
/*     */         
/* 272 */         AbstractInsnNode insn = it.next();
/* 273 */         if (insn.getOpcode() == 183) {
/*     */           
/* 275 */           MethodInsnNode mInsn = (MethodInsnNode)insn;
/* 276 */           for (MethodNode n : toReplace) {
/*     */             
/* 278 */             if (n.name.equals(mInsn.name) && n.desc.equals(mInsn.desc))
/*     */             {
/* 280 */               mInsn.setOpcode(182);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String toBinary(int num) {
/* 291 */     return String.format("%16s", new Object[] { Integer.toBinaryString(num) }).replace(' ', '0');
/*     */   }
/*     */ 
/*     */   
/*     */   private int getFixedAccess(int access, Modifier target) {
/* 296 */     target.oldAccess = access;
/* 297 */     int t = target.targetAccess;
/* 298 */     int ret = access & 0xFFFFFFF8;
/*     */     
/* 300 */     switch (access & 0x7) {
/*     */       
/*     */       case 2:
/* 303 */         ret |= t;
/*     */         break;
/*     */       case 0:
/* 306 */         ret |= (t != 2) ? t : 0;
/*     */         break;
/*     */       case 4:
/* 309 */         ret |= (t != 2 && t != 0) ? t : 4;
/*     */         break;
/*     */       case 1:
/* 312 */         ret |= (t != 2 && t != 0 && t != 4) ? t : 1;
/*     */         break;
/*     */       default:
/* 315 */         throw new RuntimeException("The fuck?");
/*     */     } 
/*     */ 
/*     */     
/* 319 */     if (target.changeFinal)
/*     */     {
/* 321 */       if (target.markFinal) {
/*     */         
/* 323 */         ret |= 0x10;
/*     */       }
/*     */       else {
/*     */         
/* 327 */         ret &= 0xFFFFFFEF;
/*     */       } 
/*     */     }
/* 330 */     target.newAccess = ret;
/* 331 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 336 */     if (args.length < 2) {
/*     */       
/* 338 */       System.out.println("Usage: AccessTransformer <JarPath> <MapFile> [MapFile2]... ");
/* 339 */       System.exit(1);
/*     */     } 
/*     */     
/* 342 */     boolean hasTransformer = false;
/* 343 */     AccessTransformer[] trans = new AccessTransformer[args.length - 1];
/* 344 */     for (int x = 1; x < args.length; x++) {
/*     */ 
/*     */       
/*     */       try {
/* 348 */         trans[x - 1] = new AccessTransformer(args[x]);
/* 349 */         hasTransformer = true;
/*     */       }
/* 351 */       catch (IOException e) {
/*     */         
/* 353 */         System.out.println("Could not read Transformer Map: " + args[x]);
/* 354 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 358 */     if (!hasTransformer) {
/*     */       
/* 360 */       System.out.println("Culd not find a valid transformer to perform");
/* 361 */       System.exit(1);
/*     */     } 
/*     */     
/* 364 */     File orig = new File(args[0]);
/* 365 */     File temp = new File(args[0] + ".ATBack");
/* 366 */     if (!orig.exists() && !temp.exists()) {
/*     */       
/* 368 */       System.out.println("Could not find target jar: " + orig);
/* 369 */       System.exit(1);
/*     */     } 
/*     */     
/* 372 */     if (!orig.renameTo(temp)) {
/*     */       
/* 374 */       System.out.println("Could not rename file: " + orig + " -> " + temp);
/* 375 */       System.exit(1);
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 380 */       processJar(temp, orig, trans);
/*     */     }
/* 382 */     catch (IOException e) {
/*     */       
/* 384 */       e.printStackTrace();
/* 385 */       System.exit(1);
/*     */     } 
/*     */     
/* 388 */     if (!temp.delete())
/*     */     {
/* 390 */       System.out.println("Could not delete temp file: " + temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void processJar(File inFile, File outFile, AccessTransformer[] transformers) throws IOException {
/* 396 */     ZipInputStream inJar = null;
/* 397 */     ZipOutputStream outJar = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       try {
/* 403 */         inJar = new ZipInputStream(new BufferedInputStream(new FileInputStream(inFile)));
/*     */       }
/* 405 */       catch (FileNotFoundException e) {
/*     */         
/* 407 */         throw new FileNotFoundException("Could not open input file: " + e.getMessage());
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 412 */         outJar = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));
/*     */       }
/* 414 */       catch (FileNotFoundException e) {
/*     */         
/* 416 */         throw new FileNotFoundException("Could not open output file: " + e.getMessage());
/*     */       } 
/*     */       
/*     */       ZipEntry entry;
/* 420 */       while ((entry = inJar.getNextEntry()) != null) {
/*     */         int len;
/* 422 */         if (entry.isDirectory()) {
/*     */           
/* 424 */           outJar.putNextEntry(entry);
/*     */           
/*     */           continue;
/*     */         } 
/* 428 */         byte[] data = new byte[4096];
/* 429 */         ByteArrayOutputStream entryBuffer = new ByteArrayOutputStream();
/*     */ 
/*     */ 
/*     */         
/*     */         do {
/* 434 */           len = inJar.read(data);
/* 435 */           if (len <= 0)
/*     */             continue; 
/* 437 */           entryBuffer.write(data, 0, len);
/*     */         
/*     */         }
/* 440 */         while (len != -1);
/*     */         
/* 442 */         byte[] entryData = entryBuffer.toByteArray();
/*     */         
/* 444 */         String entryName = entry.getName();
/*     */         
/* 446 */         if (entryName.endsWith(".class") && !entryName.startsWith(".")) {
/*     */           
/* 448 */           ClassNode cls = new ClassNode();
/* 449 */           ClassReader rdr = new ClassReader(entryData);
/* 450 */           rdr.accept((ClassVisitor)cls, 0);
/* 451 */           String name = cls.name.replace('/', '.').replace('\\', '.');
/*     */           
/* 453 */           for (AccessTransformer trans : transformers)
/*     */           {
/* 455 */             entryData = trans.transform(name, name, entryData);
/*     */           }
/*     */         } 
/*     */         
/* 459 */         ZipEntry newEntry = new ZipEntry(entryName);
/* 460 */         outJar.putNextEntry(newEntry);
/* 461 */         outJar.write(entryData);
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/* 466 */       if (outJar != null) {
/*     */         
/*     */         try {
/*     */           
/* 470 */           outJar.close();
/*     */         }
/* 472 */         catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 477 */       if (inJar != null) {
/*     */         
/*     */         try {
/*     */           
/* 481 */           inJar.close();
/*     */         }
/* 483 */         catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Multimap<String, Modifier> getModifiers() {
/* 491 */     return this.modifiers;
/*     */   }
/*     */   
/*     */   boolean isEmpty() {
/* 495 */     return this.modifiers.isEmpty();
/*     */   }
/*     */   
/*     */   AccessTransformer(Class<? extends AccessTransformer> dummyClazz) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\AccessTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */