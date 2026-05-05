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
/*    */ public abstract class Event
/*    */ {
/*    */   private final Mark startMark;
/*    */   private final Mark endMark;
/*    */   
/*    */   public enum ID
/*    */   {
/* 27 */     Alias, DocumentEnd, DocumentStart, MappingEnd, MappingStart, Scalar, SequenceEnd, SequenceStart, StreamEnd, StreamStart;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Event(Mark startMark, Mark endMark) {
/* 34 */     this.startMark = startMark;
/* 35 */     this.endMark = endMark;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 39 */     return "<" + getClass().getName() + "(" + getArguments() + ")>";
/*    */   }
/*    */   
/*    */   public Mark getStartMark() {
/* 43 */     return this.startMark;
/*    */   }
/*    */   
/*    */   public Mark getEndMark() {
/* 47 */     return this.endMark;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String getArguments() {
/* 54 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract boolean is(ID paramID);
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 64 */     if (obj instanceof Event) {
/* 65 */       return toString().equals(obj.toString());
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\Event.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */