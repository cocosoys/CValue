/*    */ package net.minecraft.util.org.apache.commons.io.output;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
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
/*    */ public class NullOutputStream
/*    */   extends OutputStream
/*    */ {
/* 35 */   public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();
/*    */   
/*    */   public void write(byte[] b, int off, int len) {}
/*    */   
/*    */   public void write(int b) {}
/*    */   
/*    */   public void write(byte[] b) throws IOException {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\org\apache\commons\io\output\NullOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */