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
/*    */ public abstract class CollectionNode
/*    */   extends Node
/*    */ {
/*    */   private Boolean flowStyle;
/*    */   
/*    */   public CollectionNode(Tag tag, Mark startMark, Mark endMark, Boolean flowStyle) {
/* 29 */     super(tag, startMark, endMark);
/* 30 */     this.flowStyle = flowStyle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getFlowStyle() {
/* 40 */     return this.flowStyle;
/*    */   }
/*    */   
/*    */   public void setFlowStyle(Boolean flowStyle) {
/* 44 */     this.flowStyle = flowStyle;
/*    */   }
/*    */   
/*    */   public void setEndMark(Mark endMark) {
/* 48 */     this.endMark = endMark;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\nodes\CollectionNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */