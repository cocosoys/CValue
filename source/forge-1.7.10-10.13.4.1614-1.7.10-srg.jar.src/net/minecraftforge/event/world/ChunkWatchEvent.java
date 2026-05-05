/*    */ package net.minecraftforge.event.world;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.world.ChunkCoordIntPair;
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
/*    */ public class ChunkWatchEvent
/*    */   extends Event
/*    */ {
/*    */   public final ChunkCoordIntPair chunk;
/*    */   public final EntityPlayerMP player;
/*    */   
/*    */   public ChunkWatchEvent(ChunkCoordIntPair chunk, EntityPlayerMP player) {
/* 24 */     this.chunk = chunk;
/* 25 */     this.player = player;
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
/*    */   public static class Watch
/*    */     extends ChunkWatchEvent
/*    */   {
/*    */     public Watch(ChunkCoordIntPair chunk, EntityPlayerMP player) {
/* 41 */       super(chunk, player);
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
/*    */   public static class UnWatch
/*    */     extends ChunkWatchEvent
/*    */   {
/*    */     public UnWatch(ChunkCoordIntPair chunkLocation, EntityPlayerMP player) {
/* 57 */       super(chunkLocation, player);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\ChunkWatchEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */