/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.event.world.WorldEvent;
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
/*    */ @HasResult
/*    */ public class SaplingGrowTreeEvent
/*    */   extends WorldEvent
/*    */ {
/*    */   public final int x;
/*    */   public final int y;
/*    */   public final int z;
/*    */   public final Random rand;
/*    */   
/*    */   public SaplingGrowTreeEvent(World world, Random rand, int x, int y, int z) {
/* 36 */     super(world);
/* 37 */     this.rand = rand;
/* 38 */     this.x = x;
/* 39 */     this.y = y;
/* 40 */     this.z = z;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\SaplingGrowTreeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */