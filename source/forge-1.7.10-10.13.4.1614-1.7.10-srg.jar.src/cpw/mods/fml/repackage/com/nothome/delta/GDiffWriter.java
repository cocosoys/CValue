/*     */ package cpw.mods.fml.repackage.com.nothome.delta;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public class GDiffWriter
/*     */   implements DiffWriter
/*     */ {
/*     */   public static final int CHUNK_SIZE = 32767;
/*     */   public static final byte EOF = 0;
/*     */   public static final int DATA_MAX = 246;
/*     */   public static final int DATA_USHORT = 247;
/*     */   public static final int DATA_INT = 248;
/*     */   public static final int COPY_USHORT_UBYTE = 249;
/*     */   public static final int COPY_USHORT_USHORT = 250;
/*     */   public static final int COPY_USHORT_INT = 251;
/*     */   public static final int COPY_INT_UBYTE = 252;
/*     */   public static final int COPY_INT_USHORT = 253;
/*     */   public static final int COPY_INT_INT = 254;
/*     */   public static final int COPY_LONG_INT = 255;
/*  60 */   private ByteArrayOutputStream buf = new ByteArrayOutputStream();
/*     */   
/*     */   private boolean debug = false;
/*     */   
/*  64 */   private DataOutputStream output = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDiffWriter(DataOutputStream os) throws IOException {
/*  70 */     this.output = os;
/*     */     
/*  72 */     this.output.writeByte(209);
/*  73 */     this.output.writeByte(255);
/*  74 */     this.output.writeByte(209);
/*  75 */     this.output.writeByte(255);
/*  76 */     this.output.writeByte(4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDiffWriter(OutputStream output) throws IOException {
/*  83 */     this(new DataOutputStream(output));
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCopy(long offset, int length) throws IOException {
/*  88 */     writeBuf();
/*     */ 
/*     */     
/*  91 */     if (this.debug) {
/*  92 */       System.err.println("COPY off: " + offset + ", len: " + length);
/*     */     }
/*     */     
/*  95 */     if (offset > 2147483647L) {
/*     */       
/*  97 */       this.output.writeByte(255);
/*  98 */       this.output.writeLong(offset);
/*  99 */       this.output.writeInt(length);
/* 100 */     } else if (offset < 65536L) {
/* 101 */       if (length < 256) {
/* 102 */         this.output.writeByte(249);
/* 103 */         this.output.writeShort((int)offset);
/* 104 */         this.output.writeByte(length);
/* 105 */       } else if (length > 65535) {
/* 106 */         this.output.writeByte(251);
/* 107 */         this.output.writeShort((int)offset);
/* 108 */         this.output.writeInt(length);
/*     */       } else {
/* 110 */         this.output.writeByte(250);
/* 111 */         this.output.writeShort((int)offset);
/* 112 */         this.output.writeShort(length);
/*     */       }
/*     */     
/* 115 */     } else if (length < 256) {
/* 116 */       this.output.writeByte(252);
/* 117 */       this.output.writeInt((int)offset);
/* 118 */       this.output.writeByte(length);
/* 119 */     } else if (length > 65535) {
/* 120 */       this.output.writeByte(254);
/* 121 */       this.output.writeInt((int)offset);
/* 122 */       this.output.writeInt(length);
/*     */     } else {
/* 124 */       this.output.writeByte(253);
/* 125 */       this.output.writeInt((int)offset);
/* 126 */       this.output.writeShort(length);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addData(byte b) throws IOException {
/* 136 */     this.buf.write(b);
/* 137 */     if (this.buf.size() >= 32767)
/* 138 */       writeBuf(); 
/*     */   }
/*     */   
/*     */   private void writeBuf() throws IOException {
/* 142 */     if (this.buf.size() > 0) {
/* 143 */       if (this.buf.size() <= 246) {
/* 144 */         this.output.writeByte(this.buf.size());
/* 145 */       } else if (this.buf.size() <= 65535) {
/* 146 */         this.output.writeByte(247);
/* 147 */         this.output.writeShort(this.buf.size());
/*     */       } else {
/* 149 */         this.output.writeByte(248);
/* 150 */         this.output.writeInt(this.buf.size());
/*     */       } 
/* 152 */       this.buf.writeTo(this.output);
/* 153 */       this.buf.reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 163 */     writeBuf();
/* 164 */     this.output.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 172 */     flush();
/* 173 */     this.output.write(0);
/* 174 */     this.output.close();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\GDiffWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */