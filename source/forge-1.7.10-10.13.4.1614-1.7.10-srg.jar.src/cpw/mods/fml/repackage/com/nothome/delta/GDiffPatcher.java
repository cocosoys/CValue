/*     */ package cpw.mods.fml.repackage.com.nothome.delta;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.EOFException;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class GDiffPatcher
/*     */ {
/*  63 */   private ByteBuffer buf = ByteBuffer.allocate(1024);
/*  64 */   private byte[] buf2 = this.buf.array();
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
/*     */   public void patch(File sourceFile, File patchFile, File outputFile) throws IOException {
/*  78 */     RandomAccessFileSeekableSource source = new RandomAccessFileSeekableSource(new RandomAccessFile(sourceFile, "r"));
/*  79 */     InputStream patch = new FileInputStream(patchFile);
/*  80 */     OutputStream output = new FileOutputStream(outputFile);
/*     */     try {
/*  82 */       patch(source, patch, output);
/*  83 */     } catch (IOException e) {
/*  84 */       throw e;
/*     */     } finally {
/*  86 */       source.close();
/*  87 */       patch.close();
/*  88 */       output.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void patch(byte[] source, InputStream patch, OutputStream output) throws IOException {
/*  96 */     patch(new ByteBufferSeekableSource(source), patch, output);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] patch(byte[] source, byte[] patch) throws IOException {
/* 103 */     ByteArrayOutputStream os = new ByteArrayOutputStream();
/* 104 */     patch(source, new ByteArrayInputStream(patch), os);
/* 105 */     return os.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void patch(SeekableSource source, InputStream patch, OutputStream out) throws IOException {
/* 113 */     DataOutputStream outOS = new DataOutputStream(out);
/* 114 */     DataInputStream patchIS = new DataInputStream(patch);
/*     */ 
/*     */     
/* 117 */     if (patchIS.readUnsignedByte() != 209 || patchIS
/* 118 */       .readUnsignedByte() != 255 || patchIS
/* 119 */       .readUnsignedByte() != 209 || patchIS
/* 120 */       .readUnsignedByte() != 255 || patchIS
/* 121 */       .readUnsignedByte() != 4)
/*     */     {
/* 123 */       throw new PatchException("magic string not found, aborting!"); } 
/*     */     while (true) {
/*     */       int length, offset;
/*     */       long loffset;
/* 127 */       int command = patchIS.readUnsignedByte();
/* 128 */       if (command == 0) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 133 */       if (command <= 246) {
/* 134 */         append(command, patchIS, outOS);
/*     */         
/*     */         continue;
/*     */       } 
/* 138 */       switch (command) {
/*     */         case 247:
/* 140 */           length = patchIS.readUnsignedShort();
/* 141 */           append(length, patchIS, outOS);
/*     */           continue;
/*     */         case 248:
/* 144 */           length = patchIS.readInt();
/* 145 */           append(length, patchIS, outOS);
/*     */           continue;
/*     */         case 249:
/* 148 */           offset = patchIS.readUnsignedShort();
/* 149 */           length = patchIS.readUnsignedByte();
/* 150 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 250:
/* 153 */           offset = patchIS.readUnsignedShort();
/* 154 */           length = patchIS.readUnsignedShort();
/* 155 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 251:
/* 158 */           offset = patchIS.readUnsignedShort();
/* 159 */           length = patchIS.readInt();
/* 160 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 252:
/* 163 */           offset = patchIS.readInt();
/* 164 */           length = patchIS.readUnsignedByte();
/* 165 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 253:
/* 168 */           offset = patchIS.readInt();
/* 169 */           length = patchIS.readUnsignedShort();
/* 170 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 254:
/* 173 */           offset = patchIS.readInt();
/* 174 */           length = patchIS.readInt();
/* 175 */           copy(offset, length, source, outOS);
/*     */           continue;
/*     */         case 255:
/* 178 */           loffset = patchIS.readLong();
/* 179 */           length = patchIS.readInt();
/* 180 */           copy(loffset, length, source, outOS);
/*     */           continue;
/*     */       } 
/* 183 */       throw new IllegalStateException("command " + command);
/*     */     } 
/*     */     
/* 186 */     outOS.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void copy(long offset, int length, SeekableSource source, OutputStream output) throws IOException {
/* 192 */     source.seek(offset);
/* 193 */     while (length > 0) {
/* 194 */       int len = Math.min(this.buf.capacity(), length);
/* 195 */       this.buf.clear().limit(len);
/* 196 */       int res = source.read(this.buf);
/* 197 */       if (res == -1)
/* 198 */         throw new EOFException("in copy " + offset + " " + length); 
/* 199 */       output.write(this.buf.array(), 0, res);
/* 200 */       length -= res;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void append(int length, InputStream patch, OutputStream output) throws IOException {
/* 205 */     while (length > 0) {
/* 206 */       int len = Math.min(this.buf2.length, length);
/* 207 */       int res = patch.read(this.buf2, 0, len);
/* 208 */       if (res == -1)
/* 209 */         throw new EOFException("cannot read " + length); 
/* 210 */       output.write(this.buf2, 0, res);
/* 211 */       length -= res;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] argv) {
/* 220 */     if (argv.length != 3) {
/* 221 */       System.err.println("usage GDiffPatch source patch output");
/* 222 */       System.err.println("aborting..");
/*     */       return;
/*     */     } 
/*     */     try {
/* 226 */       File sourceFile = new File(argv[0]);
/* 227 */       File patchFile = new File(argv[1]);
/* 228 */       File outputFile = new File(argv[2]);
/*     */       
/* 230 */       if (sourceFile.length() > 2147483647L || patchFile
/* 231 */         .length() > 2147483647L) {
/* 232 */         System.err.println("source or patch is too large, max length is 2147483647");
/* 233 */         System.err.println("aborting..");
/*     */         return;
/*     */       } 
/* 236 */       GDiffPatcher patcher = new GDiffPatcher();
/* 237 */       patcher.patch(sourceFile, patchFile, outputFile);
/*     */       
/* 239 */       System.out.println("finished patching file");
/*     */     }
/* 241 */     catch (Exception ioe) {
/* 242 */       System.err.println("error while patching: " + ioe);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\GDiffPatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */