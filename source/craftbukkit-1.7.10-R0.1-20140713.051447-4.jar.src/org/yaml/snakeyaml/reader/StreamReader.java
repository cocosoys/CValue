/*     */ package org.yaml.snakeyaml.reader;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.yaml.snakeyaml.error.Mark;
/*     */ import org.yaml.snakeyaml.error.YAMLException;
/*     */ import org.yaml.snakeyaml.scanner.Constant;
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
/*     */ public class StreamReader
/*     */ {
/*  35 */   static final Pattern NON_PRINTABLE = Pattern.compile("[^\t\n\r -~ -퟿-￼]");
/*     */   
/*     */   private String name;
/*     */   private final Reader stream;
/*  39 */   private int pointer = 0;
/*     */   private boolean eof = true;
/*     */   private String buffer;
/*  42 */   private int index = 0;
/*  43 */   private int line = 0;
/*  44 */   private int column = 0;
/*     */   private char[] data;
/*     */   
/*     */   public StreamReader(String stream) {
/*  48 */     this.name = "<string>";
/*  49 */     this.buffer = "";
/*  50 */     checkPrintable(stream);
/*  51 */     this.buffer = stream + "\000";
/*  52 */     this.stream = null;
/*  53 */     this.eof = true;
/*  54 */     this.data = null;
/*     */   }
/*     */   
/*     */   public StreamReader(Reader reader) {
/*  58 */     this.name = "<reader>";
/*  59 */     this.buffer = "";
/*  60 */     this.stream = reader;
/*  61 */     this.eof = false;
/*  62 */     this.data = new char[1024];
/*  63 */     update();
/*     */   }
/*     */   
/*     */   void checkPrintable(CharSequence data) {
/*  67 */     Matcher em = NON_PRINTABLE.matcher(data);
/*  68 */     if (em.find()) {
/*  69 */       int position = this.index + this.buffer.length() - this.pointer + em.start();
/*  70 */       throw new ReaderException(this.name, position, em.group().charAt(0), "special characters are not allowed");
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
/*     */ 
/*     */   
/*     */   void checkPrintable(char[] chars, int begin, int end) {
/*  88 */     for (int i = begin; i < end; ) {
/*  89 */       char c = chars[i];
/*     */       
/*  91 */       if ((c >= ' ' && c <= '~') || c == '\n' || c == '\r' || c == '\t' || c == '' || (c >= ' ' && c <= '퟿') || (c >= '' && c <= '￼')) {
/*     */         i++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*  97 */       int position = this.index + this.buffer.length() - this.pointer + i;
/*  98 */       throw new ReaderException(this.name, position, c, "special characters are not allowed");
/*     */     } 
/*     */   }
/*     */   
/*     */   public Mark getMark() {
/* 103 */     return new Mark(this.name, this.index, this.line, this.column, this.buffer, this.pointer);
/*     */   }
/*     */   
/*     */   public void forward() {
/* 107 */     forward(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void forward(int length) {
/* 116 */     if (this.pointer + length + 1 >= this.buffer.length()) {
/* 117 */       update();
/*     */     }
/* 119 */     char ch = Character.MIN_VALUE;
/* 120 */     for (int i = 0; i < length; i++) {
/* 121 */       ch = this.buffer.charAt(this.pointer);
/* 122 */       this.pointer++;
/* 123 */       this.index++;
/* 124 */       if (Constant.LINEBR.has(ch) || (ch == '\r' && this.buffer.charAt(this.pointer) != '\n')) {
/* 125 */         this.line++;
/* 126 */         this.column = 0;
/* 127 */       } else if (ch != '﻿') {
/* 128 */         this.column++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public char peek() {
/* 134 */     return this.buffer.charAt(this.pointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char peek(int index) {
/* 144 */     if (this.pointer + index + 1 > this.buffer.length()) {
/* 145 */       update();
/*     */     }
/* 147 */     return this.buffer.charAt(this.pointer + index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String prefix(int length) {
/* 157 */     if (this.pointer + length >= this.buffer.length()) {
/* 158 */       update();
/*     */     }
/* 160 */     if (this.pointer + length > this.buffer.length()) {
/* 161 */       return this.buffer.substring(this.pointer);
/*     */     }
/* 163 */     return this.buffer.substring(this.pointer, this.pointer + length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String prefixForward(int length) {
/* 170 */     String prefix = prefix(length);
/* 171 */     this.pointer += length;
/* 172 */     this.index += length;
/*     */     
/* 174 */     this.column += length;
/* 175 */     return prefix;
/*     */   }
/*     */   
/*     */   private void update() {
/* 179 */     if (!this.eof) {
/* 180 */       this.buffer = this.buffer.substring(this.pointer);
/* 181 */       this.pointer = 0;
/*     */       try {
/* 183 */         int converted = this.stream.read(this.data);
/* 184 */         if (converted > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 191 */           checkPrintable(this.data, 0, converted);
/* 192 */           this.buffer = (new StringBuilder(this.buffer.length() + converted)).append(this.buffer).append(this.data, 0, converted).toString();
/*     */         } else {
/*     */           
/* 195 */           this.eof = true;
/* 196 */           this.buffer += "\000";
/*     */         } 
/* 198 */       } catch (IOException ioe) {
/* 199 */         throw new YAMLException(ioe);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getColumn() {
/* 205 */     return this.column;
/*     */   }
/*     */   
/*     */   public Charset getEncoding() {
/* 209 */     return Charset.forName(((UnicodeReader)this.stream).getEncoding());
/*     */   }
/*     */   
/*     */   public int getIndex() {
/* 213 */     return this.index;
/*     */   }
/*     */   
/*     */   public int getLine() {
/* 217 */     return this.line;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\reader\StreamReader.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */