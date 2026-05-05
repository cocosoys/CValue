/*     */ package cpw.mods.fml.common.asm.transformers;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.io.LineProcessor;
/*     */ import com.google.common.io.Resources;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.URL;
/*     */ import java.util.List;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import net.minecraft.launchwrapper.IClassTransformer;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.tree.ClassNode;
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
/*     */ public class MarkerTransformer
/*     */   implements IClassTransformer
/*     */ {
/*  46 */   private ListMultimap<String, String> markers = (ListMultimap<String, String>)ArrayListMultimap.create();
/*     */ 
/*     */   
/*     */   public MarkerTransformer() throws IOException {
/*  50 */     this("fml_marker.cfg");
/*     */   }
/*     */   
/*     */   protected MarkerTransformer(String rulesFile) throws IOException {
/*  54 */     readMapFile(rulesFile);
/*     */   }
/*     */   
/*     */   private void readMapFile(String rulesFile) throws IOException {
/*     */     URL rulesResource;
/*  59 */     File file = new File(rulesFile);
/*     */     
/*  61 */     if (file.exists()) {
/*     */       
/*  63 */       rulesResource = file.toURI().toURL();
/*     */     }
/*     */     else {
/*     */       
/*  67 */       rulesResource = Resources.getResource(rulesFile);
/*     */     } 
/*  69 */     Resources.readLines(rulesResource, Charsets.UTF_8, new LineProcessor<Void>()
/*     */         {
/*     */           
/*     */           public Void getResult()
/*     */           {
/*  74 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public boolean processLine(String input) throws IOException {
/*  80 */             String line = ((String)Iterables.getFirst(Splitter.on('#').limit(2).split(input), "")).trim();
/*  81 */             if (line.length() == 0)
/*     */             {
/*  83 */               return true;
/*     */             }
/*  85 */             List<String> parts = Lists.newArrayList(Splitter.on(" ").trimResults().split(line));
/*  86 */             if (parts.size() != 2)
/*     */             {
/*  88 */               throw new RuntimeException("Invalid config file line " + input);
/*     */             }
/*  90 */             List<String> markerInterfaces = Lists.newArrayList(Splitter.on(",").trimResults().split(parts.get(1)));
/*  91 */             for (String marker : markerInterfaces)
/*     */             {
/*  93 */               MarkerTransformer.this.markers.put(parts.get(0), marker);
/*     */             }
/*  95 */             return true;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] transform(String name, String transformedName, byte[] bytes) {
/* 103 */     if (bytes == null) return null; 
/* 104 */     if (!this.markers.containsKey(name)) return bytes;
/*     */     
/* 106 */     ClassNode classNode = new ClassNode();
/* 107 */     ClassReader classReader = new ClassReader(bytes);
/* 108 */     classReader.accept((ClassVisitor)classNode, 0);
/*     */     
/* 110 */     for (String marker : this.markers.get(name))
/*     */     {
/* 112 */       classNode.interfaces.add(marker);
/*     */     }
/*     */     
/* 115 */     ClassWriter writer = new ClassWriter(1);
/* 116 */     classNode.accept((ClassVisitor)writer);
/* 117 */     return writer.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 122 */     if (args.length < 2) {
/*     */       
/* 124 */       System.out.println("Usage: MarkerTransformer <JarPath> <MapFile> [MapFile2]... ");
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     boolean hasTransformer = false;
/* 129 */     MarkerTransformer[] trans = new MarkerTransformer[args.length - 1];
/* 130 */     for (int x = 1; x < args.length; x++) {
/*     */ 
/*     */       
/*     */       try {
/* 134 */         trans[x - 1] = new MarkerTransformer(args[x]);
/* 135 */         hasTransformer = true;
/*     */       }
/* 137 */       catch (IOException e) {
/*     */         
/* 139 */         System.out.println("Could not read Transformer Map: " + args[x]);
/* 140 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     if (!hasTransformer) {
/*     */       
/* 146 */       System.out.println("Culd not find a valid transformer to perform");
/*     */       
/*     */       return;
/*     */     } 
/* 150 */     File orig = new File(args[0]);
/* 151 */     File temp = new File(args[0] + ".ATBack");
/* 152 */     if (!orig.exists() && !temp.exists()) {
/*     */       
/* 154 */       System.out.println("Could not find target jar: " + orig);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     if (!orig.renameTo(temp)) {
/*     */       
/* 174 */       System.out.println("Could not rename file: " + orig + " -> " + temp);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 180 */       processJar(temp, orig, trans);
/*     */     }
/* 182 */     catch (IOException e) {
/*     */       
/* 184 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 187 */     if (!temp.delete())
/*     */     {
/* 189 */       System.out.println("Could not delete temp file: " + temp);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void processJar(File inFile, File outFile, MarkerTransformer[] transformers) throws IOException {
/* 195 */     ZipInputStream inJar = null;
/* 196 */     ZipOutputStream outJar = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       try {
/* 202 */         inJar = new ZipInputStream(new BufferedInputStream(new FileInputStream(inFile)));
/*     */       }
/* 204 */       catch (FileNotFoundException e) {
/*     */         
/* 206 */         throw new FileNotFoundException("Could not open input file: " + e.getMessage());
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 211 */         outJar = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));
/*     */       }
/* 213 */       catch (FileNotFoundException e) {
/*     */         
/* 215 */         throw new FileNotFoundException("Could not open output file: " + e.getMessage());
/*     */       } 
/*     */       
/*     */       ZipEntry entry;
/* 219 */       while ((entry = inJar.getNextEntry()) != null) {
/*     */         int len;
/* 221 */         if (entry.isDirectory()) {
/*     */           
/* 223 */           outJar.putNextEntry(entry);
/*     */           
/*     */           continue;
/*     */         } 
/* 227 */         byte[] data = new byte[4096];
/* 228 */         ByteArrayOutputStream entryBuffer = new ByteArrayOutputStream();
/*     */ 
/*     */ 
/*     */         
/*     */         do {
/* 233 */           len = inJar.read(data);
/* 234 */           if (len <= 0)
/*     */             continue; 
/* 236 */           entryBuffer.write(data, 0, len);
/*     */         
/*     */         }
/* 239 */         while (len != -1);
/*     */         
/* 241 */         byte[] entryData = entryBuffer.toByteArray();
/*     */         
/* 243 */         String entryName = entry.getName();
/*     */         
/* 245 */         if (entryName.endsWith(".class") && !entryName.startsWith(".")) {
/*     */           
/* 247 */           ClassNode cls = new ClassNode();
/* 248 */           ClassReader rdr = new ClassReader(entryData);
/* 249 */           rdr.accept((ClassVisitor)cls, 0);
/* 250 */           String name = cls.name.replace('/', '.').replace('\\', '.');
/*     */           
/* 252 */           for (MarkerTransformer trans : transformers)
/*     */           {
/* 254 */             entryData = trans.transform(name, name, entryData);
/*     */           }
/*     */         } 
/*     */         
/* 258 */         ZipEntry newEntry = new ZipEntry(entryName);
/* 259 */         outJar.putNextEntry(newEntry);
/* 260 */         outJar.write(entryData);
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/* 265 */       if (outJar != null) {
/*     */         
/*     */         try {
/*     */           
/* 269 */           outJar.close();
/*     */         }
/* 271 */         catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 276 */       if (inJar != null)
/*     */         
/*     */         try {
/*     */           
/* 280 */           inJar.close();
/*     */         }
/* 282 */         catch (IOException iOException) {} 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\MarkerTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */