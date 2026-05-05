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
/*    */ public class AnchorNode
/*    */   extends Node
/*    */ {
/*    */   private Node realNode;
/*    */   
/*    */   public AnchorNode(Node realNode) {
/* 24 */     super(realNode.getTag(), realNode.getStartMark(), realNode.getEndMark());
/* 25 */     this.realNode = realNode;
/*    */   }
/*    */ 
/*    */   
/*    */   public NodeId getNodeId() {
/* 30 */     return NodeId.anchor;
/*    */   }
/*    */   
/*    */   public Node getRealNode() {
/* 34 */     return this.realNode;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\AnchorNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */