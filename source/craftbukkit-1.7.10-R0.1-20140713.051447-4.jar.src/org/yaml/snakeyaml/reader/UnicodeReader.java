/*     */ package org.yaml.snakeyaml.reader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.io.Reader;
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
/*     */ public class UnicodeReader
/*     */   extends Reader
/*     */ {
/*     */   PushbackInputStream internalIn;
/*  53 */   InputStreamReader internalIn2 = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int BOM_SIZE = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   public UnicodeReader(InputStream in) {
/*  62 */     this.internalIn = new PushbackInputStream(in, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/*  70 */     return this.internalIn2.getEncoding();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() throws IOException {
/*     */     String encoding;
/*     */     int unread;
/*  78 */     if (this.internalIn2 != null) {
/*     */       return;
/*     */     }
/*     */     
/*  82 */     byte[] bom = new byte[3];
/*     */     
/*  84 */     int n = this.internalIn.read(bom, 0, bom.length);
/*     */     
/*  86 */     if (bom[0] == -17 && bom[1] == -69 && bom[2] == -65) {
/*  87 */       encoding = "UTF-8";
/*  88 */       unread = n - 3;
/*  89 */     } else if (bom[0] == -2 && bom[1] == -1) {
/*  90 */       encoding = "UTF-16BE";
/*  91 */       unread = n - 2;
/*  92 */     } else if (bom[0] == -1 && bom[1] == -2) {
/*  93 */       encoding = "UTF-16LE";
/*  94 */       unread = n - 2;
/*     */     } else {
/*     */       
/*  97 */       encoding = "UTF-8";
/*  98 */       unread = n;
/*     */     } 
/*     */     
/* 101 */     if (unread > 0) {
/* 102 */       this.internalIn.unread(bom, n - unread, unread);
/*     */     }
/*     */     
/* 105 */     this.internalIn2 = new InputStreamReader(this.internalIn, encoding);
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 109 */     init();
/* 110 */     this.internalIn2.close();
/*     */   }
/*     */   
/*     */   public int read(char[] cbuf, int off, int len) throws IOException {
/* 114 */     init();
/* 115 */     return this.internalIn2.read(cbuf, off, len);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\reader\UnicodeReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */