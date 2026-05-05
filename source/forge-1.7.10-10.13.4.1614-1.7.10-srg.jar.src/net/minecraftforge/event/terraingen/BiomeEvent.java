/*     */ package net.minecraftforge.event.terraingen;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.Event.HasResult;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.world.biome.BiomeDecorator;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BiomeEvent
/*     */   extends Event
/*     */ {
/*     */   public final BiomeGenBase biome;
/*     */   
/*     */   public BiomeEvent(BiomeGenBase biome) {
/*  22 */     this.biome = biome;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CreateDecorator
/*     */     extends BiomeEvent
/*     */   {
/*     */     public final BiomeDecorator originalBiomeDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BiomeDecorator newBiomeDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CreateDecorator(BiomeGenBase biome, BiomeDecorator original) {
/*  46 */       super(biome);
/*  47 */       this.originalBiomeDecorator = original;
/*  48 */       this.newBiomeDecorator = original;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class BiomeColor
/*     */     extends BiomeEvent
/*     */   {
/*     */     public final int originalColor;
/*     */ 
/*     */     
/*     */     public int newColor;
/*     */ 
/*     */ 
/*     */     
/*     */     public BiomeColor(BiomeGenBase biome, int original) {
/*  66 */       super(biome);
/*  67 */       this.originalColor = original;
/*  68 */       this.newColor = original;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @HasResult
/*     */   public static class GetVillageBlockID
/*     */     extends BiomeEvent
/*     */   {
/*     */     public final Block original;
/*     */ 
/*     */     
/*     */     public final int type;
/*     */     
/*     */     public Block replacement;
/*     */ 
/*     */     
/*     */     public GetVillageBlockID(BiomeGenBase biome, Block original, int type) {
/*  87 */       super(biome);
/*  88 */       this.original = original;
/*  89 */       this.type = type;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @HasResult
/*     */   public static class GetVillageBlockMeta
/*     */     extends BiomeEvent
/*     */   {
/*     */     public final Block original;
/*     */ 
/*     */     
/*     */     public final int type;
/*     */     
/*     */     public int replacement;
/*     */ 
/*     */     
/*     */     public GetVillageBlockMeta(BiomeGenBase biome, Block original, int type) {
/* 108 */       super(biome);
/* 109 */       this.original = original;
/* 110 */       this.type = type;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GetGrassColor
/*     */     extends BiomeColor
/*     */   {
/*     */     public GetGrassColor(BiomeGenBase biome, int original) {
/* 121 */       super(biome, original);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GetFoliageColor
/*     */     extends BiomeColor
/*     */   {
/*     */     public GetFoliageColor(BiomeGenBase biome, int original) {
/* 132 */       super(biome, original);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class GetWaterColor
/*     */     extends BiomeColor
/*     */   {
/*     */     public GetWaterColor(BiomeGenBase biome, int original) {
/* 143 */       super(biome, original);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\terraingen\BiomeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */