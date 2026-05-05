/*    */ package net.minecraftforge.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
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
/*    */ 
/*    */ 
/*    */ @HasResult
/*    */ @Deprecated
/*    */ public class FuelBurnTimeEvent
/*    */   extends Event
/*    */ {
/*    */   public final ItemStack fuel;
/*    */   public int burnTime;
/*    */   
/*    */   public FuelBurnTimeEvent(ItemStack fuel) {
/* 30 */     this.fuel = fuel;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\FuelBurnTimeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */