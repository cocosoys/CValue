/*    */ package cpw.mods.fml.common.eventhandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EventPriority
/*    */   implements IEventListener
/*    */ {
/* 11 */   HIGHEST,
/* 12 */   HIGH,
/* 13 */   NORMAL,
/* 14 */   LOW,
/* 15 */   LOWEST;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void invoke(Event event) {
/* 21 */     event.setPhase(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\eventhandler\EventPriority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */