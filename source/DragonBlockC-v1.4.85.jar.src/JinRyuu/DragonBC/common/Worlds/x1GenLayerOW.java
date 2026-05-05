/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import net.minecraft.world.WorldType;
/*    */ import net.minecraft.world.gen.layer.GenLayer;
/*    */ import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
/*    */ import net.minecraft.world.gen.layer.GenLayerZoom;
/*    */ 
/*    */ public class x1GenLayerOW
/*    */   extends GenLayer {
/*    */   public x1GenLayerOW(long seed) {
/* 11 */     super(seed);
/*    */   }
/*    */   
/*    */   public static GenLayer[] makeTheWorld(long seed, WorldType type) {
/* 15 */     GenLayer biomes = new x1GenLayerOWBiomes(1L);
/* 16 */     GenLayerZoom genLayerZoom = new GenLayerZoom(1000L, biomes);
/* 17 */     genLayerZoom = new GenLayerZoom(1001L, (GenLayer)genLayerZoom);
/* 18 */     genLayerZoom = new GenLayerZoom(1002L, (GenLayer)genLayerZoom);
/* 19 */     genLayerZoom = new GenLayerZoom(1003L, (GenLayer)genLayerZoom);
/* 20 */     genLayerZoom = new GenLayerZoom(1004L, (GenLayer)genLayerZoom);
/* 21 */     genLayerZoom = new GenLayerZoom(1005L, (GenLayer)genLayerZoom);
/* 22 */     GenLayerVoronoiZoom genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, (GenLayer)genLayerZoom);
/* 23 */     genLayerZoom.func_75905_a(seed);
/* 24 */     genLayerVoronoiZoom.func_75905_a(seed);
/* 25 */     return new GenLayer[] { (GenLayer)genLayerZoom, (GenLayer)genLayerVoronoiZoom };
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 30 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1GenLayerOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */