/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import java.util.Random;
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
/*    */ public class DecorateBiomeEvent
/*    */   extends Event
/*    */ {
/*    */   public final World world;
/*    */   public final Random rand;
/*    */   public final int chunkX;
/*    */   public final int chunkZ;
/*    */   
/*    */   public DecorateBiomeEvent(World world, Random rand, int worldX, int worldZ) {
/* 34 */     this.world = world;
/* 35 */     this.rand = rand;
/* 36 */     this.chunkX = worldX;
/* 37 */     this.chunkZ = worldZ;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Pre
/*    */     extends DecorateBiomeEvent
/*    */   {
/*    */     public Pre(World world, Random rand, int worldX, int worldZ) {
/* 47 */       super(world, rand, worldX, worldZ);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Post
/*    */     extends DecorateBiomeEvent
/*    */   {
/*    */     public Post(World world, Random rand, int worldX, int worldZ) {
/* 58 */       super(world, rand, worldX, worldZ);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class Decorate
/*    */     extends DecorateBiomeEvent
/*    */   {
/*    */     public final EventType type;
/*    */ 
/*    */     
/*    */     public enum EventType
/*    */     {
/* 72 */       BIG_SHROOM, CACTUS, CLAY, DEAD_BUSH, LILYPAD, FLOWERS, GRASS, LAKE, PUMPKIN, REED, SAND, SAND_PASS2, SHROOM, TREE, CUSTOM;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Decorate(World world, Random rand, int worldX, int worldZ, EventType type) {
/* 78 */       super(world, rand, worldX, worldZ);
/* 79 */       this.type = type;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\DecorateBiomeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */