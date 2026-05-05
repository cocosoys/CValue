/*    */ package cpw.mods.fml.repackage.com.nothome.delta;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.RandomAccessFile;
/*    */ import java.nio.ByteBuffer;
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
/*    */ public class RandomAccessFileSeekableSource
/*    */   implements SeekableSource
/*    */ {
/*    */   private RandomAccessFile raf;
/*    */   
/*    */   public RandomAccessFileSeekableSource(RandomAccessFile raf) {
/* 46 */     if (raf == null)
/* 47 */       throw new NullPointerException("raf"); 
/* 48 */     this.raf = raf;
/*    */   }
/*    */ 
/*    */   
/*    */   public void seek(long pos) throws IOException {
/* 53 */     this.raf.seek(pos);
/*    */   }
/*    */   
/*    */   public int read(byte[] b, int off, int len) throws IOException {
/* 57 */     return this.raf.read(b, off, len);
/*    */   }
/*    */   
/*    */   public long length() throws IOException {
/* 61 */     return this.raf.length();
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 66 */     this.raf.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(ByteBuffer bb) throws IOException {
/* 71 */     int c = this.raf.read(bb.array(), bb.position(), bb.remaining());
/* 72 */     if (c == -1)
/* 73 */       return -1; 
/* 74 */     bb.position(bb.position() + c);
/* 75 */     return c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\RandomAccessFileSeekableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */