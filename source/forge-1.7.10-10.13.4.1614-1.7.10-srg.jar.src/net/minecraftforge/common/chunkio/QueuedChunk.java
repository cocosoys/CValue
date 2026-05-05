/*    */ package net.minecraftforge.common.chunkio;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.storage.AnvilChunkLoader;
/*    */ import net.minecraft.world.gen.ChunkProviderServer;
/*    */ 
/*    */ class QueuedChunk {
/*    */   final int x;
/*    */   final int z;
/*    */   final AnvilChunkLoader loader;
/*    */   
/*    */   public QueuedChunk(int x, int z, AnvilChunkLoader loader, World world, ChunkProviderServer provider) {
/* 13 */     this.x = x;
/* 14 */     this.z = z;
/* 15 */     this.loader = loader;
/* 16 */     this.world = world;
/* 17 */     this.provider = provider;
/*    */   }
/*    */   final World world; final ChunkProviderServer provider; NBTTagCompound compound;
/*    */   
/*    */   public int hashCode() {
/* 22 */     return this.x * 31 + this.z * 29 ^ this.world.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 27 */     if (object instanceof QueuedChunk) {
/* 28 */       QueuedChunk other = (QueuedChunk)object;
/* 29 */       return (this.x == other.x && this.z == other.z && this.world == other.world);
/*    */     } 
/*    */     
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     StringBuilder result = new StringBuilder();
/* 39 */     String NEW_LINE = System.getProperty("line.separator");
/*    */     
/* 41 */     result.append(getClass().getName() + " {" + NEW_LINE);
/* 42 */     result.append(" x: " + this.x + NEW_LINE);
/* 43 */     result.append(" z: " + this.z + NEW_LINE);
/* 44 */     result.append(" loader: " + this.loader + NEW_LINE);
/* 45 */     result.append(" world: " + this.world.getWorldInfo().getWorldName() + NEW_LINE);
/* 46 */     result.append(" dimension: " + this.world.provider.dimensionId + NEW_LINE);
/* 47 */     result.append(" provider: " + this.world.provider.getClass().getName() + NEW_LINE);
/* 48 */     result.append("}");
/*    */     
/* 50 */     return result.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\chunkio\QueuedChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */