/*    */ package org.yaml.snakeyaml.nodes;
/*    */ 
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ public class SequenceNode
/*    */   extends CollectionNode
/*    */ {
/*    */   private final List<Node> value;
/*    */   
/*    */   public SequenceNode(Tag tag, boolean resolved, List<Node> value, Mark startMark, Mark endMark, Boolean flowStyle) {
/* 34 */     super(tag, startMark, endMark, flowStyle);
/* 35 */     if (value == null) {
/* 36 */       throw new NullPointerException("value in a Node is required.");
/*    */     }
/* 38 */     this.value = value;
/* 39 */     this.resolved = resolved;
/*    */   }
/*    */   
/*    */   public SequenceNode(Tag tag, List<Node> value, Boolean flowStyle) {
/* 43 */     this(tag, true, value, (Mark)null, (Mark)null, flowStyle);
/*    */   }
/*    */ 
/*    */   
/*    */   public NodeId getNodeId() {
/* 48 */     return NodeId.sequence;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Node> getValue() {
/* 57 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setListType(Class<? extends Object> listType) {
/* 61 */     for (Node node : this.value) {
/* 62 */       node.setType(listType);
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     return "<" + getClass().getName() + " (tag=" + getTag() + ", value=" + getValue() + ")>";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\SequenceNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */