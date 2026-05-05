/*    */ package org.yaml.snakeyaml.constructor;
/*    */ 
/*    */ import org.yaml.snakeyaml.error.Mark;
/*    */ import org.yaml.snakeyaml.error.MarkedYAMLException;
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
/*    */ public class ConstructorException
/*    */   extends MarkedYAMLException
/*    */ {
/*    */   private static final long serialVersionUID = -8816339931365239910L;
/*    */   
/*    */   protected ConstructorException(String context, Mark contextMark, String problem, Mark problemMark, Throwable cause) {
/* 27 */     super(context, contextMark, problem, problemMark, cause);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ConstructorException(String context, Mark contextMark, String problem, Mark problemMark) {
/* 32 */     this(context, contextMark, problem, problemMark, null);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\constructor\ConstructorException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */