/*    */ package org.yaml.snakeyaml.reader;
/*    */ 
/*    */ import org.yaml.snakeyaml.error.YAMLException;
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
/*    */ public class ReaderException
/*    */   extends YAMLException
/*    */ {
/*    */   private static final long serialVersionUID = 8710781187529689083L;
/*    */   private String name;
/*    */   private char character;
/*    */   private int position;
/*    */   
/*    */   public ReaderException(String name, int position, char character, String message) {
/* 28 */     super(message);
/* 29 */     this.name = name;
/* 30 */     this.character = character;
/* 31 */     this.position = position;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 36 */     return "unacceptable character '" + this.character + "' (0x" + Integer.toHexString(this.character).toUpperCase() + ") " + getMessage() + "\nin \"" + this.name + "\", position " + this.position;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\reader\ReaderException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */