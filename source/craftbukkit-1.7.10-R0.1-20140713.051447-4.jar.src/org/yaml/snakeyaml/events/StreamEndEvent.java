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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class StreamEndEvent
/*    */   extends Event
/*    */ {
/*    */   public StreamEndEvent(Mark startMark, Mark endMark) {
/* 34 */     super(startMark, endMark);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Event.ID id) {
/* 39 */     return (Event.ID.StreamEnd == id);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\StreamEndEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */