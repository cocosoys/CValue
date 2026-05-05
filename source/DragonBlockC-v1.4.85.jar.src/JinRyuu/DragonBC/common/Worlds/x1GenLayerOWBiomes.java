/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.IntCache;
/*    */ 
/*    */ public class x1GenLayerOWBiomes
/*    */   extends GenLayer
/*    */ {
/* 10 */   protected BiomeGenBase[] allowedBiomes = new BiomeGenBase[] { BiomeGenBaseDBC.OtherW, BiomeGenBaseDBC.OtherW2, BiomeGenBaseDBC.OtherW3, BiomeGenBaseDBC.OtherW4 };
/*    */ 
/*    */ 
/*    */   
/*    */   public x1GenLayerOWBiomes(long seed) {
/* 15 */     super(seed);
/*    */   }
/*    */   
/*    */   public x1GenLayerOWBiomes(long seed, GenLayer genlayer) {
/* 19 */     super(seed);
/* 20 */     this.field_75909_a = genlayer;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int x, int z, int width, int depth) {
/* 25 */     int[] dest = IntCache.func_76445_a(width * depth);
/* 26 */     for (int dz = 0; dz < depth; dz++) {
/* 27 */       for (int dx = 0; dx < width; dx++) {
/* 28 */         func_75903_a((dx + x), (dz + z));
/* 29 */         dest[dx + dz * width] = (this.allowedBiomes[func_75902_a(this.allowedBiomes.length)]).field_76756_M;
/*    */       } 
/*    */     } 
/* 32 */     return dest;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1GenLayerOWBiomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */