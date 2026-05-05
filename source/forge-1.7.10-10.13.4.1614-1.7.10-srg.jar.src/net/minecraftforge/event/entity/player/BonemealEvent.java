/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.block.Block;
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
/*    */ @Cancelable
/*    */ @HasResult
/*    */ public class BonemealEvent
/*    */   extends PlayerEvent
/*    */ {
/*    */   public final World world;
/*    */   public final Block block;
/*    */   public final int x;
/*    */   public final int y;
/*    */   public final int z;
/*    */   
/*    */   public BonemealEvent(EntityPlayer player, World world, Block block, int x, int y, int z) {
/* 31 */     super(player);
/* 32 */     this.world = world;
/* 33 */     this.block = block;
/* 34 */     this.x = x;
/* 35 */     this.y = y;
/* 36 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\BonemealEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */