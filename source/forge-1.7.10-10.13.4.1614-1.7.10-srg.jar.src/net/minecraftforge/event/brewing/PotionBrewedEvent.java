/*    */ package net.minecraftforge.event.brewing;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class PotionBrewedEvent
/*    */   extends PotionBrewEvent
/*    */ {
/*    */   @Deprecated
/*    */   public ItemStack[] brewingStacks;
/*    */   
/*    */   public PotionBrewedEvent(ItemStack[] brewingStacks) {
/* 31 */     super(brewingStacks);
/* 32 */     this.brewingStacks = brewingStacks;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\brewing\PotionBrewedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */