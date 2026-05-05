/*    */ package net.minecraftforge.event.world;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
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
/*    */ public class ChunkDataEvent
/*    */   extends ChunkEvent
/*    */ {
/*    */   private final NBTTagCompound data;
/*    */   
/*    */   public ChunkDataEvent(Chunk chunk, NBTTagCompound data) {
/* 21 */     super(chunk);
/* 22 */     this.data = data;
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTTagCompound getData() {
/* 27 */     return this.data;
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
/*    */   public static class Load
/*    */     extends ChunkDataEvent
/*    */   {
/*    */     public Load(Chunk chunk, NBTTagCompound data) {
/* 45 */       super(chunk, data);
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
/*    */   public static class Save
/*    */     extends ChunkDataEvent
/*    */   {
/*    */     public Save(Chunk chunk, NBTTagCompound data) {
/* 64 */       super(chunk, data);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\ChunkDataEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */