/*    */ package org.bukkit.event.hanging;
/*    */ 
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Hanging;
/*    */ 
/*    */ 
/*    */ public class HangingBreakByEntityEvent
/*    */   extends HangingBreakEvent
/*    */ {
/*    */   private final Entity remover;
/*    */   
/*    */   public HangingBreakByEntityEvent(Hanging hanging, Entity remover) {
/* 13 */     super(hanging, HangingBreakEvent.RemoveCause.ENTITY);
/* 14 */     this.remover = remover;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Entity getRemover() {
/* 23 */     return this.remover;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\hanging\HangingBreakByEntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */