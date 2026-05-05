/*    */ package net.minecraftforge.event.brewing;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PotionBrewEvent
/*    */   extends Event
/*    */ {
/*    */   private ItemStack[] stacks;
/*    */   
/*    */   protected PotionBrewEvent(ItemStack[] stacks) {
/* 15 */     this.stacks = stacks;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack getItem(int index) {
/* 20 */     if (index >= this.stacks.length) return null; 
/* 21 */     return this.stacks[index];
/*    */   }
/*    */ 
/*    */   
/*    */   public void setItem(int index, ItemStack stack) {
/* 26 */     if (index < this.stacks.length)
/*    */     {
/* 28 */       this.stacks[index] = stack;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLength() {
/* 34 */     return this.stacks.length;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Cancelable
/*    */   public static class Pre
/*    */     extends PotionBrewEvent
/*    */   {
/*    */     public Pre(ItemStack[] stacks) {
/* 59 */       super(stacks);
/*    */     }
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Post
/*    */     extends PotionBrewedEvent
/*    */   {
/*    */     public Post(ItemStack[] stacks) {
/* 80 */       super(stacks);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\brewing\PotionBrewEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */