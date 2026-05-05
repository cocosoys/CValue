/*    */ package net.minecraftforge.common.chunkio;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ import net.minecraft.world.chunk.storage.AnvilChunkLoader;
/*    */ import net.minecraft.world.gen.ChunkProviderServer;
/*    */ 
/*    */ public class ChunkIOExecutor {
/*    */   static final int BASE_THREADS = 1;
/*  9 */   private static final AsynchronousExecutor<QueuedChunk, Chunk, Runnable, RuntimeException> instance = new AsynchronousExecutor(new ChunkIOProvider(), 1); static final int PLAYERS_PER_THREAD = 50;
/*    */   
/*    */   public static Chunk syncChunkLoad(World world, AnvilChunkLoader loader, ChunkProviderServer provider, int x, int z) {
/* 12 */     return (Chunk)instance.getSkipQueue(new QueuedChunk(x, z, loader, world, provider));
/*    */   }
/*    */   
/*    */   public static void queueChunkLoad(World world, AnvilChunkLoader loader, ChunkProviderServer provider, int x, int z, Runnable runnable) {
/* 16 */     instance.add(new QueuedChunk(x, z, loader, world, provider), runnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void dropQueuedChunkLoad(World world, int x, int z, Runnable runnable) {
/* 21 */     instance.drop(new QueuedChunk(x, z, null, world, null), runnable);
/*    */   }
/*    */   
/*    */   public static void adjustPoolSize(int players) {
/* 25 */     int size = Math.max(1, (int)Math.ceil((players / 50)));
/* 26 */     instance.setActiveThreads(size);
/*    */   }
/*    */   
/*    */   public static void tick() {
/* 30 */     instance.finishActive();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\chunkio\ChunkIOExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */