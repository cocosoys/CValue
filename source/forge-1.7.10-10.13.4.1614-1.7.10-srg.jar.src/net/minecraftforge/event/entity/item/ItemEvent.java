/*    */ package net.minecraftforge.event.entity.item;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
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
/*    */ public class ItemEvent
/*    */   extends EntityEvent
/*    */ {
/*    */   public final EntityItem entityItem;
/*    */   
/*    */   public ItemEvent(EntityItem itemEntity) {
/* 26 */     super((Entity)itemEntity);
/* 27 */     this.entityItem = itemEntity;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\item\ItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */