/*     */ package net.minecraftforge.event.terraingen;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PopulateChunkEvent
/*     */   extends ChunkProviderEvent
/*     */ {
/*     */   public final World world;
/*     */   public final Random rand;
/*     */   public final int chunkX;
/*     */   public final int chunkZ;
/*     */   public final boolean hasVillageGenerated;
/*     */   
/*     */   public PopulateChunkEvent(IChunkProvider chunkProvider, World world, Random rand, int chunkX, int chunkZ, boolean hasVillageGenerated) {
/*  33 */     super(chunkProvider);
/*  34 */     this.world = world;
/*  35 */     this.rand = rand;
/*  36 */     this.chunkX = chunkX;
/*  37 */     this.chunkZ = chunkZ;
/*  38 */     this.hasVillageGenerated = hasVillageGenerated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Pre
/*     */     extends PopulateChunkEvent
/*     */   {
/*     */     public Pre(IChunkProvider chunkProvider, World world, Random rand, int chunkX, int chunkZ, boolean hasVillageGenerated) {
/*  58 */       super(chunkProvider, world, rand, chunkX, chunkZ, hasVillageGenerated);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Post
/*     */     extends PopulateChunkEvent
/*     */   {
/*     */     public Post(IChunkProvider chunkProvider, World world, Random rand, int chunkX, int chunkZ, boolean hasVillageGenerated) {
/*  79 */       super(chunkProvider, world, rand, chunkX, chunkZ, hasVillageGenerated);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @HasResult
/*     */   public static class Populate
/*     */     extends PopulateChunkEvent
/*     */   {
/*     */     public final EventType type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum EventType
/*     */     {
/* 104 */       DUNGEON, FIRE, GLOWSTONE, ICE, LAKE, LAVA, NETHER_LAVA, ANIMALS, CUSTOM;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Populate(IChunkProvider chunkProvider, World world, Random rand, int chunkX, int chunkZ, boolean hasVillageGenerated, EventType type) {
/* 110 */       super(chunkProvider, world, rand, chunkX, chunkZ, hasVillageGenerated);
/* 111 */       this.type = type;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\PopulateChunkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */