/*    */ package cpw.mods.fml.repackage.com.nothome.delta;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class ByteBufferSeekableSource
/*    */   implements SeekableSource
/*    */ {
/*    */   private ByteBuffer bb;
/*    */   private ByteBuffer cur;
/*    */   
/*    */   public ByteBufferSeekableSource(byte[] source) {
/* 44 */     this(ByteBuffer.wrap(source));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ByteBufferSeekableSource(ByteBuffer bb) {
/* 51 */     if (bb == null)
/* 52 */       throw new NullPointerException("bb"); 
/* 53 */     this.bb = bb;
/* 54 */     bb.rewind();
/*    */     try {
/* 56 */       seek(0L);
/* 57 */     } catch (IOException e) {
/* 58 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void seek(long pos) throws IOException {
/* 64 */     this.cur = this.bb.slice();
/* 65 */     if (pos > this.cur.limit())
/* 66 */       throw new IOException("pos " + pos + " cannot seek " + this.cur.limit()); 
/* 67 */     this.cur.position((int)pos);
/*    */   }
/*    */ 
/*    */   
/*    */   public int read(ByteBuffer dest) throws IOException {
/* 72 */     if (!this.cur.hasRemaining())
/* 73 */       return -1; 
/* 74 */     int c = 0;
/* 75 */     while (this.cur.hasRemaining() && dest.hasRemaining()) {
/* 76 */       dest.put(this.cur.get());
/* 77 */       c++;
/*    */     } 
/* 79 */     return c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 84 */     this.bb = null;
/* 85 */     this.cur = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 94 */     return "BBSeekable bb=" + this.bb
/* 95 */       .position() + "-" + this.bb.limit() + " cur=" + this.cur
/* 96 */       .position() + "-" + this.cur.limit() + "";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\ByteBufferSeekableSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */