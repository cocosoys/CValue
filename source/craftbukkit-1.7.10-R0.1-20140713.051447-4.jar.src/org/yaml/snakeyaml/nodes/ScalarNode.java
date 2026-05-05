/*    */ package org.yaml.snakeyaml.nodes;
/*    */ 
/*    */ import org.yaml.snakeyaml.error.Mark;
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
/*    */ public class ScalarNode
/*    */   extends Node
/*    */ {
/*    */   private Character style;
/*    */   private String value;
/*    */   
/*    */   public ScalarNode(Tag tag, String value, Mark startMark, Mark endMark, Character style) {
/* 32 */     this(tag, true, value, startMark, endMark, style);
/*    */   }
/*    */ 
/*    */   
/*    */   public ScalarNode(Tag tag, boolean resolved, String value, Mark startMark, Mark endMark, Character style) {
/* 37 */     super(tag, startMark, endMark);
/* 38 */     if (value == null) {
/* 39 */       throw new NullPointerException("value in a Node is required.");
/*    */     }
/* 41 */     this.value = value;
/* 42 */     this.style = style;
/* 43 */     this.resolved = resolved;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Character getStyle() {
/* 54 */     return this.style;
/*    */   }
/*    */ 
/*    */   
/*    */   public NodeId getNodeId() {
/* 59 */     return NodeId.scalar;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getValue() {
/* 68 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     return "<" + getClass().getName() + " (tag=" + getTag() + ", value=" + getValue() + ")>";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\ScalarNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */