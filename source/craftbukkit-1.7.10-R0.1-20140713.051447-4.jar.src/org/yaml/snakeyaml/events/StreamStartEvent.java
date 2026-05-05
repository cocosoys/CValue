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
/*    */ 
/*    */ public final class StreamStartEvent
/*    */   extends Event
/*    */ {
/*    */   public StreamStartEvent(Mark startMark, Mark endMark) {
/* 35 */     super(startMark, endMark);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Event.ID id) {
/* 40 */     return (Event.ID.StreamStart == id);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\StreamStartEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */