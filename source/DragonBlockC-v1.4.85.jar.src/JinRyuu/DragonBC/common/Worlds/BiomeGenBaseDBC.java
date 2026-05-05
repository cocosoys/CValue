/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm.BiomeNullRealm;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.gen.feature.WorldGenTallGrass;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ import net.minecraftforge.common.BiomeDictionary;
/*    */ import net.minecraftforge.common.BiomeManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BiomeGenBaseDBC
/*    */   extends BiomeGenBase
/*    */ {
/*    */   public static BiomeGenBase Namek;
/*    */   public static BiomeGenBase Vegeta;
/*    */   public static BiomeGenBase Stony;
/*    */   public static BiomeGenBase OtherW;
/*    */   public static BiomeGenBase OtherW2;
/*    */   public static BiomeGenBase OtherW3;
/*    */   public static BiomeGenBase OtherW4;
/*    */   public static BiomeGenBase TC;
/*    */   public static BiomeGenBase NR;
/*    */   
/*    */   public BiomeGenBaseDBC(int biomeId) {
/* 33 */     super(biomeId);
/*    */   }
/*    */   
/*    */   static {
/* 37 */     int i = 100;
/* 38 */     Namek = new x0BiomeGenNamek(i++);
/* 39 */     i++; i++;
/*    */ 
/*    */     
/* 42 */     Vegeta = new x3BiomeGenVegata(i++);
/* 43 */     Stony = new BiomeGenStony(i++);
/* 44 */     OtherW = new x1BiomeGenOW(i++);
/* 45 */     TC = new x2BiomeGenTC(i++);
/* 46 */     OtherW2 = new x1BiomeGenOW2(i++);
/* 47 */     OtherW3 = new x1BiomeGenOW3(i++);
/* 48 */     OtherW4 = new x1BiomeGenOW4(i++);
/* 49 */     NR = (BiomeGenBase)new BiomeNullRealm(i++);
/*    */   }
/*    */ 
/*    */   
/*    */   public WorldGenerator func_76730_b(Random random) {
/* 54 */     if (random.nextInt(4) == 0) {
/* 55 */       return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 2);
/*    */     }
/* 57 */     return (WorldGenerator)new WorldGenTallGrass((Block)Blocks.field_150329_H, 1);
/*    */   }
/*    */   
/*    */   public static void init() {
/* 61 */     BiomeDictionary.registerBiomeType(Namek, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
/* 62 */     BiomeDictionary.registerBiomeType(Vegeta, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
/* 63 */     BiomeDictionary.registerBiomeType(Stony, new BiomeDictionary.Type[] { BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY });
/* 64 */     BiomeDictionary.registerBiomeType(OtherW, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
/* 65 */     BiomeDictionary.registerBiomeType(OtherW2, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
/* 66 */     BiomeDictionary.registerBiomeType(OtherW4, new BiomeDictionary.Type[] { BiomeDictionary.Type.PLAINS });
/* 67 */     BiomeDictionary.registerBiomeType(TC, new BiomeDictionary.Type[] { BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY });
/* 68 */     BiomeDictionary.registerBiomeType(NR, new BiomeDictionary.Type[] { BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY });
/* 69 */     BiomeDictionary.registerAllBiomes();
/*    */     
/* 71 */     BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Stony, DBCConfig.cnfDrt));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\BiomeGenBaseDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */