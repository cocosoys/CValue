/*    */ package org.yaml.snakeyaml.events;
/*    */ 
/*    */ import java.util.Map;
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
/*    */ public final class DocumentStartEvent
/*    */   extends Event
/*    */ {
/*    */   private final boolean explicit;
/*    */   private final Integer[] version;
/*    */   private final Map<String, String> tags;
/*    */   
/*    */   public DocumentStartEvent(Mark startMark, Mark endMark, boolean explicit, Integer[] version, Map<String, String> tags) {
/* 36 */     super(startMark, endMark);
/* 37 */     this.explicit = explicit;
/* 38 */     this.version = version;
/* 39 */     this.tags = tags;
/*    */   }
/*    */   
/*    */   public boolean getExplicit() {
/* 43 */     return this.explicit;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer[] getVersion() {
/* 55 */     return this.version;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> getTags() {
/* 65 */     return this.tags;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Event.ID id) {
/* 70 */     return (Event.ID.DocumentStart == id);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\events\DocumentStartEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */