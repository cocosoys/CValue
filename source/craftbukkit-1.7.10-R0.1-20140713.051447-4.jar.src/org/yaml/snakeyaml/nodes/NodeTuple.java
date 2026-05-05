/*    */ package org.yaml.snakeyaml.nodes;
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
/*    */ public final class NodeTuple
/*    */ {
/*    */   private final Node keyNode;
/*    */   private final Node valueNode;
/*    */   
/*    */   public NodeTuple(Node keyNode, Node valueNode) {
/* 28 */     if (keyNode == null || valueNode == null) {
/* 29 */       throw new NullPointerException("Nodes must be provided.");
/*    */     }
/* 31 */     this.keyNode = keyNode;
/* 32 */     this.valueNode = valueNode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Node getKeyNode() {
/* 39 */     return this.keyNode;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Node getValueNode() {
/* 48 */     return this.valueNode;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 53 */     return "<NodeTuple keyNode=" + this.keyNode.toString() + "; valueNode=" + this.valueNode.toString() + ">";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\NodeTuple.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */