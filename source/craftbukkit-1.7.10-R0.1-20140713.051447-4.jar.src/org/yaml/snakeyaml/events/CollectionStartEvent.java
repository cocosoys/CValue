/*    */ package org.yaml.snakeyaml.events;
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
/*    */ 
/*    */ public abstract class CollectionStartEvent
/*    */   extends NodeEvent
/*    */ {
/*    */   private final String tag;
/*    */   private final boolean implicit;
/*    */   private final Boolean flowStyle;
/*    */   
/*    */   public CollectionStartEvent(String anchor, String tag, boolean implicit, Mark startMark, Mark endMark, Boolean flowStyle) {
/* 34 */     super(anchor, startMark, endMark);
/* 35 */     this.tag = tag;
/* 36 */     this.implicit = implicit;
/* 37 */     this.flowStyle = flowStyle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTag() {
/* 47 */     return this.tag;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getImplicit() {
/* 57 */     return this.implicit;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Boolean getFlowStyle() {
/* 67 */     return this.flowStyle;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 72 */     return super.getArguments() + ", tag=" + this.tag + ", implicit=" + this.implicit;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\CollectionStartEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */