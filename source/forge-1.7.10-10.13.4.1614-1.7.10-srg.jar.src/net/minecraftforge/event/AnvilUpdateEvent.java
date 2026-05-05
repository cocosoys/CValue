/*    */ package net.minecraftforge.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class AnvilUpdateEvent
/*    */   extends Event
/*    */ {
/*    */   public final ItemStack left;
/*    */   public final ItemStack right;
/*    */   public final String name;
/*    */   public ItemStack output;
/*    */   public int cost;
/*    */   public int materialCost;
/*    */   
/*    */   public AnvilUpdateEvent(ItemStack left, ItemStack right, String name, int cost) {
/* 26 */     this.left = left;
/* 27 */     this.right = right;
/* 28 */     this.name = name;
/* 29 */     this.cost = cost;
/* 30 */     this.materialCost = 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\AnvilUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */