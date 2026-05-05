/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenFlowers extends WorldGenerator {
/*    */   private Block field_150552_a;
/*    */   private int field_150551_b;
/*    */   private static final String __OBFID = "CL_00000410";
/*    */   
/*    */   public WorldGenFlowers(Block p_i45452_1_) {
/* 13 */     this.field_150552_a = p_i45452_1_;
/*    */   }
/*    */   
/*    */   public void func_150550_a(Block p_150550_1_, int p_150550_2_) {
/* 17 */     this.field_150552_a = p_150550_1_;
/* 18 */     this.field_150551_b = p_150550_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 23 */     for (byte b = 0; b < 64; b++) {
/* 24 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 25 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 26 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 27 */       if (p_76484_1_.func_147437_c(i, j, k) && (!p_76484_1_.field_73011_w.field_76576_e || j < 255) && 
/* 28 */         this.field_150552_a.func_149718_j(p_76484_1_, i, j, k)) {
/* 29 */         p_76484_1_.func_147465_d(i, j, k, this.field_150552_a, this.field_150551_b, 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenFlowers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */