/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.Direction;
/*    */ import net.minecraft.util.Facing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenVines
/*    */   extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000439";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 14 */     int i = p_76484_3_;
/* 15 */     int j = p_76484_5_;
/*    */     
/* 17 */     while (p_76484_4_ < 128) {
/* 18 */       if (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_)) {
/* 19 */         for (byte b = 2; b <= 5; b++) {
/* 20 */           if (Blocks.field_150395_bd.func_149707_d(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, b)) {
/* 21 */             p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150395_bd, 1 << Direction.field_71579_d[Facing.field_71588_a[b]], 2);
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } else {
/* 26 */         p_76484_3_ = i + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 27 */         p_76484_5_ = j + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/*    */       } 
/* 29 */       p_76484_4_++;
/*    */     } 
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenVines.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */