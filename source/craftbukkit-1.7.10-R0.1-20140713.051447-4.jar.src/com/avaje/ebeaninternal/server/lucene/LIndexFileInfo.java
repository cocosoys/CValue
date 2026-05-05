/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import java.io.DataInput;
/*    */ import java.io.DataOutput;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LIndexFileInfo
/*    */ {
/*    */   private final transient File file;
/*    */   private final String name;
/*    */   private final long length;
/*    */   private final long lastModified;
/*    */   
/*    */   public LIndexFileInfo(File file) {
/* 38 */     this.file = file;
/* 39 */     this.name = file.getName();
/* 40 */     this.length = file.length();
/* 41 */     this.lastModified = file.lastModified();
/*    */   }
/*    */   
/*    */   public LIndexFileInfo(String name, long length, long lastModified) {
/* 45 */     this.file = null;
/* 46 */     this.name = name;
/* 47 */     this.length = length;
/* 48 */     this.lastModified = lastModified;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     return this.name + " length[" + this.length + "] lastModified[" + this.lastModified + "]";
/*    */   }
/*    */   
/*    */   public static LIndexFileInfo read(DataInput dataInput) throws IOException {
/* 56 */     String name = dataInput.readUTF();
/* 57 */     long len = dataInput.readLong();
/* 58 */     long lastMod = dataInput.readLong();
/* 59 */     return new LIndexFileInfo(name, len, lastMod);
/*    */   }
/*    */   
/*    */   public void write(DataOutput dataOutput) throws IOException {
/* 63 */     dataOutput.writeUTF(this.name);
/* 64 */     dataOutput.writeLong(this.length);
/* 65 */     dataOutput.writeLong(this.lastModified);
/*    */   }
/*    */   
/*    */   public boolean exists() {
/* 69 */     return this.file.exists();
/*    */   }
/*    */   
/*    */   public File getFile() {
/* 73 */     return this.file;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 77 */     return this.name;
/*    */   }
/*    */   
/*    */   public long getLength() {
/* 81 */     return this.length;
/*    */   }
/*    */   
/*    */   public long getLastModified() {
/* 85 */     return this.lastModified;
/*    */   }
/*    */   
/*    */   public boolean isMatch(LIndexFileInfo otherFile) {
/* 89 */     return (otherFile.length == this.length && otherFile.lastModified == this.lastModified);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexFileInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */