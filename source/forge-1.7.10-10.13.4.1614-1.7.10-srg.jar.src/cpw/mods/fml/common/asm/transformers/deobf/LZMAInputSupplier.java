/*    */ package cpw.mods.fml.common.asm.transformers.deobf;
/*    */ 
/*    */ import LZMA.LzmaInputStream;
/*    */ import com.google.common.io.ByteSource;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ public class LZMAInputSupplier
/*    */   extends ByteSource
/*    */ {
/*    */   private InputStream compressedData;
/*    */   
/*    */   public LZMAInputSupplier(InputStream compressedData) {
/* 27 */     this.compressedData = compressedData;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InputStream openStream() throws IOException {
/* 33 */     return (InputStream)new LzmaInputStream(this.compressedData);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\deobf\LZMAInputSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */