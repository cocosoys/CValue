/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
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
/*    */ @Cancelable
/*    */ public class PlayerInteractEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final Action action;
/*    */   public final int x;
/*    */   public final int y;
/*    */   public final int z;
/*    */   public final int face;
/*    */   public final World world;
/*    */   
/*    */   public enum Action
/*    */   {
/* 39 */     RIGHT_CLICK_AIR,
/* 40 */     RIGHT_CLICK_BLOCK,
/* 41 */     LEFT_CLICK_BLOCK;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 51 */   public Event.Result useBlock = Event.Result.DEFAULT;
/* 52 */   public Event.Result useItem = Event.Result.DEFAULT;
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public PlayerInteractEvent(EntityPlayer player, Action action, int x, int y, int z, int face) {
/* 57 */     this(player, action, x, y, z, face, player.worldObj);
/*    */   }
/*    */ 
/*    */   
/*    */   public PlayerInteractEvent(EntityPlayer player, Action action, int x, int y, int z, int face, World world) {
/* 62 */     super(player);
/* 63 */     this.action = action;
/* 64 */     this.x = x;
/* 65 */     this.y = y;
/* 66 */     this.z = z;
/* 67 */     this.face = face;
/* 68 */     if (face == -1) this.useBlock = Event.Result.DENY; 
/* 69 */     this.world = world;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCanceled(boolean cancel) {
/* 75 */     super.setCanceled(cancel);
/* 76 */     this.useBlock = cancel ? Event.Result.DENY : ((this.useBlock == Event.Result.DENY) ? Event.Result.DEFAULT : this.useBlock);
/* 77 */     this.useItem = cancel ? Event.Result.DENY : ((this.useItem == Event.Result.DENY) ? Event.Result.DEFAULT : this.useItem);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerInteractEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */