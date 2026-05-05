/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ public class ItemTooltipEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final boolean showAdvancedItemTooltips;
/*    */   public final ItemStack itemStack;
/*    */   public final List<String> toolTip;
/*    */   
/*    */   public ItemTooltipEvent(ItemStack itemStack, EntityPlayer entityPlayer, List<String> toolTip, boolean showAdvancedItemTooltips) {
/* 27 */     super(entityPlayer);
/* 28 */     this.itemStack = itemStack;
/* 29 */     this.toolTip = toolTip;
/* 30 */     this.showAdvancedItemTooltips = showAdvancedItemTooltips;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\ItemTooltipEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */