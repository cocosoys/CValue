/*    */ package cpw.mods.fml.common.gameevent;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class PlayerEvent extends Event {
/*    */   public final EntityPlayer player;
/*    */   
/*    */   private PlayerEvent(EntityPlayer player) {
/* 13 */     this.player = player;
/*    */   }
/*    */   
/*    */   public static class ItemPickupEvent extends PlayerEvent {
/*    */     public final EntityItem pickedUp;
/*    */     
/*    */     public ItemPickupEvent(EntityPlayer player, EntityItem pickedUp) {
/* 20 */       super(player);
/* 21 */       this.pickedUp = pickedUp;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class ItemCraftedEvent extends PlayerEvent {
/*    */     public final ItemStack crafting;
/*    */     public final IInventory craftMatrix;
/*    */     
/*    */     public ItemCraftedEvent(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
/* 30 */       super(player);
/* 31 */       this.crafting = crafting;
/* 32 */       this.craftMatrix = craftMatrix;
/*    */     } }
/*    */   
/*    */   public static class ItemSmeltedEvent extends PlayerEvent {
/*    */     public final ItemStack smelting;
/*    */     
/*    */     public ItemSmeltedEvent(EntityPlayer player, ItemStack crafting) {
/* 39 */       super(player);
/* 40 */       this.smelting = crafting;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PlayerLoggedInEvent
/*    */     extends PlayerEvent {
/*    */     public PlayerLoggedInEvent(EntityPlayer player) {
/* 47 */       super(player);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PlayerLoggedOutEvent
/*    */     extends PlayerEvent {
/*    */     public PlayerLoggedOutEvent(EntityPlayer player) {
/* 54 */       super(player);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PlayerRespawnEvent
/*    */     extends PlayerEvent {
/*    */     public PlayerRespawnEvent(EntityPlayer player) {
/* 61 */       super(player);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PlayerChangedDimensionEvent extends PlayerEvent {
/*    */     public final int fromDim;
/*    */     public final int toDim;
/*    */     
/*    */     public PlayerChangedDimensionEvent(EntityPlayer player, int fromDim, int toDim) {
/* 70 */       super(player);
/* 71 */       this.fromDim = fromDim;
/* 72 */       this.toDim = toDim;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\gameevent\PlayerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */