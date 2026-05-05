/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MovingObjectPosition;
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
/*    */ @Cancelable
/*    */ @HasResult
/*    */ public class FillBucketEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack current;
/*    */   public final World world;
/*    */   public final MovingObjectPosition target;
/*    */   public ItemStack result;
/*    */   
/*    */   public FillBucketEvent(EntityPlayer player, ItemStack current, World world, MovingObjectPosition target) {
/* 32 */     super(player);
/* 33 */     this.current = current;
/* 34 */     this.world = world;
/* 35 */     this.target = target;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\FillBucketEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */