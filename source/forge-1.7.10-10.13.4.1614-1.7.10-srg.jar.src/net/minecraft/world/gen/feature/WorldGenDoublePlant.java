/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class WorldGenDoublePlant
/*    */   extends WorldGenerator
/*    */ {
/*    */   private int field_150549_a;
/*    */   private static final String __OBFID = "CL_00000408";
/*    */   
/*    */   public void func_150548_a(int p_150548_1_) {
/* 15 */     this.field_150549_a = p_150548_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 20 */     boolean bool = false;
/*    */     
/* 22 */     for (byte b = 0; b < 64; b++) {
/* 23 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 24 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 25 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 26 */       if (p_76484_1_.func_147437_c(i, j, k) && (!p_76484_1_.field_73011_w.field_76576_e || j < 254) && 
/* 27 */         Blocks.field_150398_cm.func_149742_c(p_76484_1_, i, j, k)) {
/* 28 */         Blocks.field_150398_cm.func_149889_c(p_76484_1_, i, j, k, this.field_150549_a, 2);
/* 29 */         bool = true;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 34 */     return bool;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenDoublePlant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */