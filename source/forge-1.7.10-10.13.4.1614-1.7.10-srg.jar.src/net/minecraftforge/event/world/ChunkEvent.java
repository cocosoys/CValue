/*    */ package net.minecraftforge.event.world;
/*    */ 
/*    */ import net.minecraft.world.chunk.Chunk;
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
/*    */ public class ChunkEvent
/*    */   extends WorldEvent
/*    */ {
/*    */   private final Chunk chunk;
/*    */   
/*    */   public ChunkEvent(Chunk chunk) {
/* 20 */     super(chunk.worldObj);
/* 21 */     this.chunk = chunk;
/*    */   }
/*    */ 
/*    */   
/*    */   public Chunk getChunk() {
/* 26 */     return this.chunk;
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
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Load
/*    */     extends ChunkEvent
/*    */   {
/*    */     public Load(Chunk chunk) {
/* 45 */       super(chunk);
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
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Unload
/*    */     extends ChunkEvent
/*    */   {
/*    */     public Unload(Chunk chunk) {
/* 64 */       super(chunk);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\ChunkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */