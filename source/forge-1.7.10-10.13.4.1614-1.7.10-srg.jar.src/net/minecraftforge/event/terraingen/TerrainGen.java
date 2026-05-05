/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Event;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.chunk.IChunkProvider;
/*    */ import net.minecraft.world.gen.MapGenBase;
/*    */ import net.minecraft.world.gen.NoiseGenerator;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TerrainGen
/*    */ {
/*    */   public static NoiseGenerator[] getModdedNoiseGenerators(World world, Random rand, NoiseGenerator[] original) {
/* 21 */     InitNoiseGensEvent event = new InitNoiseGensEvent(world, rand, original);
/* 22 */     MinecraftForge.TERRAIN_GEN_BUS.post((Event)event);
/* 23 */     return event.newNoiseGens;
/*    */   }
/*    */ 
/*    */   
/*    */   public static MapGenBase getModdedMapGen(MapGenBase original, InitMapGenEvent.EventType type) {
/* 28 */     InitMapGenEvent event = new InitMapGenEvent(type, original);
/* 29 */     MinecraftForge.TERRAIN_GEN_BUS.post(event);
/* 30 */     return event.newGen;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean populate(IChunkProvider chunkProvider, World world, Random rand, int chunkX, int chunkZ, boolean hasVillageGenerated, PopulateChunkEvent.Populate.EventType type) {
/* 35 */     PopulateChunkEvent.Populate event = new PopulateChunkEvent.Populate(chunkProvider, world, rand, chunkX, chunkZ, hasVillageGenerated, type);
/* 36 */     MinecraftForge.TERRAIN_GEN_BUS.post(event);
/* 37 */     return (event.getResult() != Event.Result.DENY);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean decorate(World world, Random rand, int chunkX, int chunkZ, DecorateBiomeEvent.Decorate.EventType type) {
/* 42 */     DecorateBiomeEvent.Decorate event = new DecorateBiomeEvent.Decorate(world, rand, chunkX, chunkZ, type);
/* 43 */     MinecraftForge.TERRAIN_GEN_BUS.post(event);
/* 44 */     return (event.getResult() != Event.Result.DENY);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean generateOre(World world, Random rand, WorldGenerator generator, int worldX, int worldZ, OreGenEvent.GenerateMinable.EventType type) {
/* 49 */     OreGenEvent.GenerateMinable event = new OreGenEvent.GenerateMinable(world, rand, generator, worldX, worldZ, type);
/* 50 */     MinecraftForge.ORE_GEN_BUS.post(event);
/* 51 */     return (event.getResult() != Event.Result.DENY);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean saplingGrowTree(World world, Random rand, int x, int y, int z) {
/* 56 */     SaplingGrowTreeEvent event = new SaplingGrowTreeEvent(world, rand, x, y, z);
/* 57 */     MinecraftForge.TERRAIN_GEN_BUS.post((Event)event);
/* 58 */     return (event.getResult() != Event.Result.DENY);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\TerrainGen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */