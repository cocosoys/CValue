/*    */ package cpw.mods.fml.repackage.com.nothome.delta;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DebugDiffWriter
/*    */   implements DiffWriter
/*    */ {
/* 36 */   private ByteArrayOutputStream os = new ByteArrayOutputStream();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addCopy(long offset, int length) throws IOException {
/* 45 */     if (this.os.size() > 0)
/* 46 */       writeBuf(); 
/* 47 */     System.err.println("COPY off: " + offset + ", len: " + length);
/*    */   }
/*    */ 
/*    */   
/*    */   public void addData(byte b) throws IOException {
/* 52 */     this.os.write(b);
/* 53 */     writeBuf();
/*    */   }
/*    */   private void writeBuf() {
/* 56 */     System.err.print("DATA: ");
/* 57 */     byte[] ba = this.os.toByteArray();
/* 58 */     for (int ix = 0; ix < ba.length; ix++) {
/* 59 */       if (ba[ix] == 10) {
/* 60 */         System.err.print("\\n");
/*    */       } else {
/* 62 */         System.err.print(String.valueOf((char)ba[ix]));
/*    */       } 
/*    */     } 
/* 65 */     System.err.println("");
/* 66 */     this.os.reset();
/*    */   }
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 71 */     System.err.println("FLUSH");
/*    */   }
/*    */   
/*    */   public void close() throws IOException {
/* 75 */     System.err.println("CLOSE");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\repackage\com\nothome\delta\DebugDiffWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */