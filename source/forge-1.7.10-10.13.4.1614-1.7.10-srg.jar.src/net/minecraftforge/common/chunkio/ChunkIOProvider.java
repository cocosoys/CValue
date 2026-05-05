/*    */ package net.minecraftforge.common.chunkio;
/*    */ import java.io.IOException;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.ChunkCoordIntPair;
/*    */ import net.minecraft.world.chunk.Chunk;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.chunk.storage.AnvilChunkLoader;
/*    */ import net.minecraftforge.common.util.AsynchronousExecutor;
/*    */ import net.minecraftforge.event.world.ChunkDataEvent;
/*    */ 
/*    */ class ChunkIOProvider implements AsynchronousExecutor.CallBackProvider<QueuedChunk, Chunk, Runnable, RuntimeException> {
/* 13 */   private final AtomicInteger threadNumber = new AtomicInteger(1);
/*    */ 
/*    */   
/*    */   public Chunk callStage1(QueuedChunk queuedChunk) throws RuntimeException {
/* 17 */     AnvilChunkLoader loader = queuedChunk.loader;
/* 18 */     Object[] data = null;
/*    */     try {
/* 20 */       data = loader.loadChunk__Async(queuedChunk.world, queuedChunk.x, queuedChunk.z);
/* 21 */     } catch (IOException e) {
/* 22 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 25 */     if (data != null) {
/* 26 */       queuedChunk.compound = (NBTTagCompound)data[1];
/* 27 */       return (Chunk)data[0];
/*    */     } 
/*    */     
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void callStage2(QueuedChunk queuedChunk, Chunk chunk) throws RuntimeException {
/* 35 */     if (chunk == null) {
/*    */       
/* 37 */       queuedChunk.provider.originalLoadChunk(queuedChunk.x, queuedChunk.z);
/*    */       
/*    */       return;
/*    */     } 
/* 41 */     queuedChunk.loader.loadEntities(queuedChunk.world, queuedChunk.compound.getCompoundTag("Level"), chunk);
/* 42 */     MinecraftForge.EVENT_BUS.post((Event)new ChunkDataEvent.Load(chunk, queuedChunk.compound));
/* 43 */     chunk.lastSaveTime = queuedChunk.provider.worldObj.getTotalWorldTime();
/* 44 */     queuedChunk.provider.loadedChunkHashMap.add(ChunkCoordIntPair.chunkXZ2Int(queuedChunk.x, queuedChunk.z), chunk);
/* 45 */     queuedChunk.provider.loadedChunks.add(chunk);
/* 46 */     chunk.onChunkLoad();
/*    */     
/* 48 */     if (queuedChunk.provider.currentChunkProvider != null) {
/* 49 */       queuedChunk.provider.currentChunkProvider.recreateStructures(queuedChunk.x, queuedChunk.z);
/*    */     }
/*    */     
/* 52 */     chunk.populateChunk((IChunkProvider)queuedChunk.provider, (IChunkProvider)queuedChunk.provider, queuedChunk.x, queuedChunk.z);
/*    */   }
/*    */   
/*    */   public void callStage3(QueuedChunk queuedChunk, Chunk chunk, Runnable runnable) throws RuntimeException {
/* 56 */     runnable.run();
/*    */   }
/*    */   
/*    */   public Thread newThread(Runnable runnable) {
/* 60 */     Thread thread = new Thread(runnable, "Chunk I/O Executor Thread-" + this.threadNumber.getAndIncrement());
/* 61 */     thread.setDaemon(true);
/* 62 */     return thread;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\chunkio\ChunkIOProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */