/*     */ package cpw.mods.fml.repackage.com.nothome.delta;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.Channels;
/*     */ import java.nio.channels.ReadableByteChannel;
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
/*     */ public class Delta
/*     */ {
/*     */   static final boolean debug = false;
/*     */   public static final int DEFAULT_CHUNK_SIZE = 16;
/*     */   private int S;
/*     */   private SourceState source;
/*     */   private TargetState target;
/*     */   private DiffWriter output;
/*     */   
/*     */   public Delta() {
/*  94 */     setChunkSize(16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChunkSize(int size) {
/* 105 */     if (size <= 0)
/* 106 */       throw new IllegalArgumentException("Invalid size"); 
/* 107 */     this.S = size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compute(byte[] source, byte[] target, OutputStream output) throws IOException {
/* 115 */     compute(new ByteBufferSeekableSource(source), new ByteArrayInputStream(target), new GDiffWriter(output));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] compute(byte[] source, byte[] target) throws IOException {
/* 125 */     ByteArrayOutputStream os = new ByteArrayOutputStream();
/* 126 */     compute(source, target, os);
/* 127 */     return os.toByteArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compute(byte[] sourceBytes, InputStream inputStream, DiffWriter diffWriter) throws IOException {
/* 136 */     compute(new ByteBufferSeekableSource(sourceBytes), inputStream, diffWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compute(File sourceFile, File targetFile, DiffWriter output) throws IOException {
/* 147 */     RandomAccessFileSeekableSource source = new RandomAccessFileSeekableSource(new RandomAccessFile(sourceFile, "r"));
/* 148 */     InputStream is = new BufferedInputStream(new FileInputStream(targetFile));
/*     */     try {
/* 150 */       compute(source, is, output);
/*     */     } finally {
/* 152 */       source.close();
/* 153 */       is.close();
/*     */     } 
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
/*     */   public void compute(SeekableSource seekSource, InputStream targetIS, DiffWriter output) throws IOException {
/* 169 */     this.source = new SourceState(seekSource);
/* 170 */     this.target = new TargetState(targetIS);
/* 171 */     this.output = output;
/*     */ 
/*     */ 
/*     */     
/* 175 */     while (!this.target.eof()) {
/* 176 */       debug("!target.eof()");
/* 177 */       int index = this.target.find(this.source);
/* 178 */       if (index != -1) {
/*     */ 
/*     */         
/* 181 */         long offset = index * this.S;
/* 182 */         this.source.seek(offset);
/* 183 */         int match = this.target.longestMatch(this.source);
/* 184 */         if (match >= this.S) {
/*     */ 
/*     */           
/* 187 */           output.addCopy(offset, match);
/*     */           continue;
/*     */         } 
/* 190 */         this.target.tbuf.position(this.target.tbuf.position() - match);
/* 191 */         addData();
/*     */         continue;
/*     */       } 
/* 194 */       addData();
/*     */     } 
/*     */     
/* 197 */     output.close();
/*     */   }
/*     */   
/*     */   private void addData() throws IOException {
/* 201 */     int i = this.target.read();
/*     */ 
/*     */     
/* 204 */     if (i == -1)
/*     */       return; 
/* 206 */     this.output.addData((byte)i);
/*     */   }
/*     */   
/*     */   class SourceState
/*     */   {
/*     */     private Checksum checksum;
/*     */     private SeekableSource source;
/*     */     
/*     */     public SourceState(SeekableSource source) throws IOException {
/* 215 */       this.checksum = new Checksum(source, Delta.this.S);
/* 216 */       this.source = source;
/* 217 */       source.seek(0L);
/*     */     }
/*     */     
/*     */     public void seek(long index) throws IOException {
/* 221 */       this.source.seek(index);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 230 */       return "Source checksum=" + this.checksum + " source=" + this.source + "";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class TargetState
/*     */   {
/*     */     private ReadableByteChannel c;
/*     */ 
/*     */     
/* 241 */     private ByteBuffer tbuf = ByteBuffer.allocate(blocksize());
/* 242 */     private ByteBuffer sbuf = ByteBuffer.allocate(blocksize());
/*     */     private long hash;
/*     */     private boolean hashReset = true;
/*     */     private boolean eof;
/*     */     
/*     */     TargetState(InputStream targetIS) throws IOException {
/* 248 */       this.c = Channels.newChannel(targetIS);
/* 249 */       this.tbuf.limit(0);
/*     */     }
/*     */     
/*     */     private int blocksize() {
/* 253 */       return Math.min(16384, Delta.this.S * 4);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int find(Delta.SourceState source) throws IOException {
/* 260 */       if (this.eof)
/* 261 */         return -1; 
/* 262 */       this.sbuf.clear();
/* 263 */       this.sbuf.limit(0);
/* 264 */       if (this.hashReset) {
/* 265 */         Delta.this.debug("hashReset");
/* 266 */         while (this.tbuf.remaining() < Delta.this.S) {
/* 267 */           this.tbuf.compact();
/* 268 */           int read = this.c.read(this.tbuf);
/* 269 */           this.tbuf.flip();
/* 270 */           if (read == -1) {
/* 271 */             Delta.this.debug("target ending");
/* 272 */             return -1;
/*     */           } 
/*     */         } 
/* 275 */         this.hash = Checksum.queryChecksum(this.tbuf, Delta.this.S);
/* 276 */         this.hashReset = false;
/*     */       } 
/*     */ 
/*     */       
/* 280 */       return source.checksum.findChecksumIndex(this.hash);
/*     */     }
/*     */     
/*     */     public boolean eof() {
/* 284 */       return this.eof;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 292 */       if (this.tbuf.remaining() <= Delta.this.S) {
/* 293 */         readMore();
/* 294 */         if (!this.tbuf.hasRemaining()) {
/* 295 */           this.eof = true;
/* 296 */           return -1;
/*     */         } 
/*     */       } 
/* 299 */       byte b = this.tbuf.get();
/* 300 */       if (this.tbuf.remaining() >= Delta.this.S) {
/* 301 */         byte nchar = this.tbuf.get(this.tbuf.position() + Delta.this.S - 1);
/* 302 */         this.hash = Checksum.incrementChecksum(this.hash, b, nchar, Delta.this.S);
/*     */       } else {
/* 304 */         Delta.this.debug("out of char");
/*     */       } 
/* 306 */       return b & 0xFF;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int longestMatch(Delta.SourceState source) throws IOException {
/* 313 */       Delta.this.debug("longestMatch");
/* 314 */       int match = 0;
/* 315 */       this.hashReset = true;
/*     */       while (true) {
/* 317 */         if (!this.sbuf.hasRemaining()) {
/* 318 */           this.sbuf.clear();
/* 319 */           int read = source.source.read(this.sbuf);
/* 320 */           this.sbuf.flip();
/* 321 */           if (read == -1)
/* 322 */             return match; 
/*     */         } 
/* 324 */         if (!this.tbuf.hasRemaining()) {
/* 325 */           readMore();
/* 326 */           if (!this.tbuf.hasRemaining()) {
/* 327 */             Delta.this.debug("target ending");
/* 328 */             this.eof = true;
/* 329 */             return match;
/*     */           } 
/*     */         } 
/* 332 */         if (this.sbuf.get() != this.tbuf.get()) {
/* 333 */           this.tbuf.position(this.tbuf.position() - 1);
/* 334 */           return match;
/*     */         } 
/* 336 */         match++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void readMore() throws IOException {
/* 343 */       this.tbuf.compact();
/* 344 */       this.c.read(this.tbuf);
/* 345 */       this.tbuf.flip();
/*     */     }
/*     */     
/*     */     void hash() {
/* 349 */       this.hash = Checksum.queryChecksum(this.tbuf, Delta.this.S);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 358 */       return "Target[ targetBuff=" + 
/* 359 */         dump() + " sourceBuff=" + this.sbuf + " hashf=" + this.hash + " eof=" + this.eof + "]";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String dump() {
/* 366 */       return dump(this.tbuf);
/*     */     }
/*     */     private String dump(ByteBuffer bb) {
/* 369 */       return getTextDump(bb);
/*     */     }
/*     */     
/*     */     private void append(StringBuffer sb, int value) {
/* 373 */       char b1 = (char)(value >> 4 & 0xF);
/* 374 */       char b2 = (char)(value & 0xF);
/* 375 */       sb.append(Character.forDigit(b1, 16));
/* 376 */       sb.append(Character.forDigit(b2, 16));
/*     */     }
/*     */ 
/*     */     
/*     */     public String getTextDump(ByteBuffer bb) {
/* 381 */       StringBuffer sb = new StringBuffer(bb.remaining() * 2);
/* 382 */       bb.mark();
/* 383 */       while (bb.hasRemaining()) {
/* 384 */         int val = bb.get();
/* 385 */         if (val > 32 && val < 127) {
/* 386 */           sb.append(" ").append((char)val); continue;
/*     */         } 
/* 388 */         append(sb, val);
/*     */       } 
/* 390 */       bb.reset();
/* 391 */       return sb.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] argv) throws Exception {
/* 400 */     if (argv.length != 3) {
/* 401 */       System.err.println("usage Delta [-d] source target [output]");
/* 402 */       System.err.println("either -d or an output filename must be specified.");
/* 403 */       System.err.println("aborting..");
/*     */       return;
/*     */     } 
/* 406 */     DiffWriter output = null;
/* 407 */     File sourceFile = null;
/* 408 */     File targetFile = null;
/* 409 */     if (argv[0].equals("-d")) {
/* 410 */       sourceFile = new File(argv[1]);
/* 411 */       targetFile = new File(argv[2]);
/* 412 */       output = new DebugDiffWriter();
/*     */     } else {
/* 414 */       sourceFile = new File(argv[0]);
/* 415 */       targetFile = new File(argv[1]);
/* 416 */       output = new GDiffWriter(new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(argv[2])))));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     if (sourceFile.length() > 2147483647L || targetFile
/* 424 */       .length() > 2147483647L) {
/* 425 */       System.err.println("source or target is too large, max length is 2147483647");
/*     */ 
/*     */       
/* 428 */       System.err.println("aborting..");
/* 429 */       output.close();
/*     */       
/*     */       return;
/*     */     } 
/* 433 */     Delta d = new Delta();
/* 434 */     d.compute(sourceFile, targetFile, output);
/*     */     
/* 436 */     output.flush();
/* 437 */     output.close();
/*     */   }
/*     */   
/*     */   private void debug(String s) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\Delta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */