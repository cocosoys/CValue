/*     */ package com.avaje.ebean.text;
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
/*     */ class PathPropertiesParser
/*     */ {
/*     */   private final PathProperties pathProps;
/*     */   private final String source;
/*     */   private final char[] chars;
/*     */   private final int eof;
/*     */   private int pos;
/*     */   private int startPos;
/*     */   private PathProperties.Props currentPathProps;
/*     */   
/*     */   public static PathProperties parse(String source) {
/*  46 */     return (new PathPropertiesParser(source)).pathProps;
/*     */   }
/*     */ 
/*     */   
/*     */   private PathPropertiesParser(String src) {
/*  51 */     if (src.startsWith(":")) {
/*  52 */       src = src.substring(1);
/*     */     }
/*  54 */     this.pathProps = new PathProperties();
/*  55 */     this.source = src;
/*  56 */     this.chars = src.toCharArray();
/*  57 */     this.eof = this.chars.length;
/*     */     
/*  59 */     if (this.eof > 0) {
/*  60 */       this.currentPathProps = this.pathProps.getRootProperties();
/*  61 */       parse();
/*     */     } 
/*     */   }
/*     */   
/*     */   private String getPath() {
/*     */     while (true) {
/*  67 */       char c1 = this.chars[this.pos++];
/*  68 */       switch (c1) {
/*     */         case '(':
/*  70 */           return currentWord();
/*     */       } 
/*     */       
/*  73 */       if (this.pos >= this.eof)
/*  74 */         throw new RuntimeException("Hit EOF while reading sectionTitle from " + this.startPos); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void parse() {
/*     */     do {
/*  80 */       String path = getPath();
/*  81 */       pushPath(path);
/*  82 */       parseSection();
/*     */     }
/*  84 */     while (this.pos < this.eof);
/*     */   }
/*     */   
/*     */   private void parseSection() {
/*     */     do {
/*  89 */       char c1 = this.chars[this.pos++];
/*  90 */       switch (c1) {
/*     */         case '(':
/*  92 */           addSubpath();
/*     */           break;
/*     */         case ',':
/*  95 */           addCurrentProperty();
/*     */           break;
/*     */         
/*     */         case ':':
/*  99 */           this.startPos = this.pos;
/*     */           return;
/*     */         
/*     */         case ')':
/* 103 */           addCurrentProperty();
/* 104 */           popSubpath();
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/* 109 */     } while (this.pos < this.eof);
/*     */   }
/*     */   
/*     */   private void addSubpath() {
/* 113 */     pushPath(currentWord());
/*     */   }
/*     */   
/*     */   private void addCurrentProperty() {
/* 117 */     String w = currentWord();
/* 118 */     if (w.length() > 0) {
/* 119 */       this.currentPathProps.addProperty(w);
/*     */     }
/*     */   }
/*     */   
/*     */   private String currentWord() {
/* 124 */     if (this.startPos == this.pos) {
/* 125 */       return "";
/*     */     }
/* 127 */     String currentWord = this.source.substring(this.startPos, this.pos - 1);
/* 128 */     this.startPos = this.pos;
/* 129 */     return currentWord;
/*     */   }
/*     */ 
/*     */   
/*     */   private void pushPath(String title) {
/* 134 */     if (!"".equals(title)) {
/* 135 */       this.currentPathProps = this.currentPathProps.addChild(title);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void popSubpath() {
/* 141 */     this.currentPathProps = this.currentPathProps.getParent();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\PathPropertiesParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */