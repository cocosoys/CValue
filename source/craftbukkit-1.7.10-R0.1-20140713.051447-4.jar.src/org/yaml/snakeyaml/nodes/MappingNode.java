/*     */ package org.yaml.snakeyaml.nodes;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.yaml.snakeyaml.error.Mark;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MappingNode
/*     */   extends CollectionNode
/*     */ {
/*     */   private List<NodeTuple> value;
/*     */   private boolean merged = false;
/*     */   
/*     */   public MappingNode(Tag tag, boolean resolved, List<NodeTuple> value, Mark startMark, Mark endMark, Boolean flowStyle) {
/*  35 */     super(tag, startMark, endMark, flowStyle);
/*  36 */     if (value == null) {
/*  37 */       throw new NullPointerException("value in a Node is required.");
/*     */     }
/*  39 */     this.value = value;
/*  40 */     this.resolved = resolved;
/*     */   }
/*     */   
/*     */   public MappingNode(Tag tag, List<NodeTuple> value, Boolean flowStyle) {
/*  44 */     this(tag, true, value, (Mark)null, (Mark)null, flowStyle);
/*     */   }
/*     */ 
/*     */   
/*     */   public NodeId getNodeId() {
/*  49 */     return NodeId.mapping;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<NodeTuple> getValue() {
/*  58 */     return this.value;
/*     */   }
/*     */   
/*     */   public void setValue(List<NodeTuple> merge) {
/*  62 */     this.value = merge;
/*     */   }
/*     */   
/*     */   public void setOnlyKeyType(Class<? extends Object> keyType) {
/*  66 */     for (NodeTuple nodes : this.value) {
/*  67 */       nodes.getKeyNode().setType(keyType);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTypes(Class<? extends Object> keyType, Class<? extends Object> valueType) {
/*  72 */     for (NodeTuple nodes : this.value) {
/*  73 */       nodes.getValueNode().setType(valueType);
/*  74 */       nodes.getKeyNode().setType(keyType);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  81 */     StringBuilder buf = new StringBuilder();
/*  82 */     for (NodeTuple node : getValue()) {
/*  83 */       buf.append("{ key=");
/*  84 */       buf.append(node.getKeyNode());
/*  85 */       buf.append("; value=");
/*  86 */       if (node.getValueNode() instanceof CollectionNode) {
/*     */         
/*  88 */         buf.append(System.identityHashCode(node.getValueNode()));
/*     */       } else {
/*  90 */         buf.append(node.toString());
/*     */       } 
/*  92 */       buf.append(" }");
/*     */     } 
/*  94 */     String values = buf.toString();
/*  95 */     return "<" + getClass().getName() + " (tag=" + getTag() + ", values=" + values + ")>";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMerged(boolean merged) {
/* 103 */     this.merged = merged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMerged() {
/* 110 */     return this.merged;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\MappingNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */