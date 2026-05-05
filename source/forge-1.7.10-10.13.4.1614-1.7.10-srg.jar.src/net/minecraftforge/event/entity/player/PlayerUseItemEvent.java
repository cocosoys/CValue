/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public abstract class PlayerUseItemEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack item;
/*    */   public int duration;
/*    */   
/*    */   private PlayerUseItemEvent(EntityPlayer player, ItemStack item, int duration) {
/* 14 */     super(player);
/* 15 */     this.item = item;
/* 16 */     this.duration = duration;
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
/*    */   @Cancelable
/*    */   public static class Start
/*    */     extends PlayerUseItemEvent
/*    */   {
/*    */     public Start(EntityPlayer player, ItemStack item, int duration) {
/* 35 */       super(player, item, duration);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Cancelable
/*    */   public static class Tick
/*    */     extends PlayerUseItemEvent
/*    */   {
/*    */     public Tick(EntityPlayer player, ItemStack item, int duration) {
/* 50 */       super(player, item, duration);
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
/*    */   @Cancelable
/*    */   public static class Stop
/*    */     extends PlayerUseItemEvent
/*    */   {
/*    */     public Stop(EntityPlayer player, ItemStack item, int duration) {
/* 71 */       super(player, item, duration);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Finish
/*    */     extends PlayerUseItemEvent
/*    */   {
/*    */     public ItemStack result;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public Finish(EntityPlayer player, ItemStack item, int duration, ItemStack result) {
/* 90 */       super(player, item, duration);
/* 91 */       this.result = result;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerUseItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */