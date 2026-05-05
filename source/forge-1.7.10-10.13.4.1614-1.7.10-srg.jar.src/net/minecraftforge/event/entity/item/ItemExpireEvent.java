/*    */ package net.minecraftforge.event.entity.item;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.item.EntityItem;
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
/*    */ @Cancelable
/*    */ public class ItemExpireEvent
/*    */   extends ItemEvent
/*    */ {
/*    */   public int extraLife;
/*    */   
/*    */   public ItemExpireEvent(EntityItem entityItem, int extraLife) {
/* 26 */     super(entityItem);
/* 27 */     this.extraLife = extraLife;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\item\ItemExpireEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */