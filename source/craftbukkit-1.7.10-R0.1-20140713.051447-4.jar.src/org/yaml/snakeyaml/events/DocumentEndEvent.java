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
/*    */ public final class DocumentEndEvent
/*    */   extends Event
/*    */ {
/*    */   private final boolean explicit;
/*    */   
/*    */   public DocumentEndEvent(Mark startMark, Mark endMark, boolean explicit) {
/* 31 */     super(startMark, endMark);
/* 32 */     this.explicit = explicit;
/*    */   }
/*    */   
/*    */   public boolean getExplicit() {
/* 36 */     return this.explicit;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Event.ID id) {
/* 41 */     return (Event.ID.DocumentEnd == id);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\DocumentEndEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */