/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ 
/*    */ public class ChunkProviderEvent
/*    */   extends Event
/*    */ {
/*    */   public final IChunkProvider chunkProvider;
/*    */   
/*    */   public ChunkProviderEvent(IChunkProvider chunkProvider) {
/* 16 */     this.chunkProvider = chunkProvider;
/*    */   }
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class ReplaceBiomeBlocks
/*    */     extends ChunkProviderEvent
/*    */   {
/*    */     public final int chunkX;
/*    */     
/*    */     public final int chunkZ;
/*    */     
/*    */     public final Block[] blockArray;
/*    */     
/*    */     public final byte[] metaArray;
/*    */     
/*    */     public final BiomeGenBase[] biomeArray;
/*    */     
/*    */     public final World world;
/*    */     
/*    */     @Deprecated
/*    */     public ReplaceBiomeBlocks(IChunkProvider chunkProvider, int chunkX, int chunkZ, Block[] blockArray, BiomeGenBase[] biomeArray) {
/* 38 */       this(chunkProvider, chunkX, chunkZ, blockArray, new byte[256], biomeArray, null);
/*    */     }
/*    */ 
/*    */     
/*    */     @Deprecated
/*    */     public ReplaceBiomeBlocks(IChunkProvider chunkProvider, int chunkX, int chunkZ, Block[] blockArray, byte[] metaArray, BiomeGenBase[] biomeArray) {
/* 44 */       this(chunkProvider, chunkZ, chunkZ, blockArray, metaArray, biomeArray, null);
/*    */     }
/*    */ 
/*    */     
/*    */     public ReplaceBiomeBlocks(IChunkProvider chunkProvider, int chunkX, int chunkZ, Block[] blockArray, byte[] metaArray, BiomeGenBase[] biomeArray, World world) {
/* 49 */       super(chunkProvider);
/* 50 */       this.chunkX = chunkX;
/* 51 */       this.chunkZ = chunkZ;
/* 52 */       this.blockArray = blockArray;
/* 53 */       this.biomeArray = biomeArray;
/* 54 */       this.metaArray = metaArray;
/* 55 */       this.world = world;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @HasResult
/*    */   public static class InitNoiseField
/*    */     extends ChunkProviderEvent
/*    */   {
/*    */     public double[] noisefield;
/*    */     
/*    */     public final int posX;
/*    */     
/*    */     public final int posY;
/*    */     
/*    */     public final int posZ;
/*    */     
/*    */     public final int sizeX;
/*    */     
/*    */     public final int sizeY;
/*    */     public final int sizeZ;
/*    */     
/*    */     public InitNoiseField(IChunkProvider chunkProvider, double[] noisefield, int posX, int posY, int posZ, int sizeX, int sizeY, int sizeZ) {
/* 78 */       super(chunkProvider);
/* 79 */       this.noisefield = noisefield;
/* 80 */       this.posX = posX;
/* 81 */       this.posY = posY;
/* 82 */       this.posZ = posZ;
/* 83 */       this.sizeX = sizeX;
/* 84 */       this.sizeY = sizeY;
/* 85 */       this.sizeZ = sizeZ;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\ChunkProviderEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */