/*    */ package net.minecraftforge.event.terraingen;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.BiomeDecorator;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ public class DeferredBiomeDecorator
/*    */   extends BiomeDecorator
/*    */ {
/*    */   private BiomeDecorator wrapped;
/*    */   
/*    */   public DeferredBiomeDecorator(BiomeDecorator wrappedOriginal) {
/* 15 */     this.wrapped = wrappedOriginal;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void decorateChunk(World par1World, Random par2Random, BiomeGenBase biome, int par3, int par4) {
/* 21 */     fireCreateEventAndReplace(biome);
/*    */     
/* 23 */     biome.theBiomeDecorator.decorateChunk(par1World, par2Random, biome, par3, par4);
/*    */   }
/*    */ 
/*    */   
/*    */   public void fireCreateEventAndReplace(BiomeGenBase biome) {
/* 28 */     this.wrapped.bigMushroomsPerChunk = this.bigMushroomsPerChunk;
/* 29 */     this.wrapped.cactiPerChunk = this.cactiPerChunk;
/* 30 */     this.wrapped.clayPerChunk = this.clayPerChunk;
/* 31 */     this.wrapped.deadBushPerChunk = this.deadBushPerChunk;
/* 32 */     this.wrapped.flowersPerChunk = this.flowersPerChunk;
/* 33 */     this.wrapped.generateLakes = this.generateLakes;
/* 34 */     this.wrapped.grassPerChunk = this.grassPerChunk;
/* 35 */     this.wrapped.mushroomsPerChunk = this.mushroomsPerChunk;
/* 36 */     this.wrapped.reedsPerChunk = this.reedsPerChunk;
/* 37 */     this.wrapped.sandPerChunk = this.sandPerChunk;
/* 38 */     this.wrapped.sandPerChunk2 = this.sandPerChunk2;
/* 39 */     this.wrapped.treesPerChunk = this.treesPerChunk;
/* 40 */     this.wrapped.waterlilyPerChunk = this.waterlilyPerChunk;
/*    */     
/* 42 */     BiomeEvent.CreateDecorator event = new BiomeEvent.CreateDecorator(biome, this.wrapped);
/* 43 */     MinecraftForge.TERRAIN_GEN_BUS.post(event);
/* 44 */     biome.theBiomeDecorator = event.newBiomeDecorator;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\DeferredBiomeDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */