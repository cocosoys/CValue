/*     */ package net.minecraftforge.event.terraingen;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*     */ import java.util.Random;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
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
/*     */ public class OreGenEvent
/*     */   extends Event
/*     */ {
/*     */   public final World world;
/*     */   public final Random rand;
/*     */   public final int worldX;
/*     */   public final int worldZ;
/*     */   
/*     */   public OreGenEvent(World world, Random rand, int worldX, int worldZ) {
/*  31 */     this.world = world;
/*  32 */     this.rand = rand;
/*  33 */     this.worldX = worldX;
/*  34 */     this.worldZ = worldZ;
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
/*     */   public static class Pre
/*     */     extends OreGenEvent
/*     */   {
/*     */     public Pre(World world, Random rand, int worldX, int worldZ) {
/*  52 */       super(world, rand, worldX, worldZ);
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
/*     */   public static class Post
/*     */     extends OreGenEvent
/*     */   {
/*     */     public Post(World world, Random rand, int worldX, int worldZ) {
/*  71 */       super(world, rand, worldX, worldZ);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @HasResult
/*     */   public static class GenerateMinable
/*     */     extends OreGenEvent
/*     */   {
/*     */     public final EventType type;
/*     */ 
/*     */ 
/*     */     
/*     */     public final WorldGenerator generator;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public enum EventType
/*     */     {
/*  93 */       COAL, DIAMOND, DIRT, GOLD, GRAVEL, IRON, LAPIS, REDSTONE, QUARTZ, CUSTOM;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public GenerateMinable(World world, Random rand, WorldGenerator generator, int worldX, int worldZ, EventType type) {
/* 100 */       super(world, rand, worldX, worldZ);
/* 101 */       this.generator = generator;
/* 102 */       this.type = type;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\OreGenEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */