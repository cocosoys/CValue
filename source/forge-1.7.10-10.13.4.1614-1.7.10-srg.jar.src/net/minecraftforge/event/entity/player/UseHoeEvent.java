/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ @Cancelable
/*    */ @HasResult
/*    */ public class UseHoeEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final ItemStack current;
/*    */   public final World world;
/*    */   public final int x;
/*    */   public final int y;
/*    */   public final int z;
/*    */   
/*    */   public UseHoeEvent(EntityPlayer player, ItemStack current, World world, int x, int y, int z) {
/* 31 */     super(player);
/* 32 */     this.current = current;
/* 33 */     this.world = world;
/* 34 */     this.x = x;
/* 35 */     this.y = y;
/* 36 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\UseHoeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */