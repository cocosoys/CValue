/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenDesertWells extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000407";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 12 */     while (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2) {
/* 13 */       p_76484_4_--;
/*    */     }
/* 15 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150354_m) {
/* 16 */       return false;
/*    */     }
/*    */     
/*    */     byte b;
/* 20 */     for (b = -2; b <= 2; b++) {
/* 21 */       for (byte b1 = -2; b1 <= 2; b1++) {
/* 22 */         if (p_76484_1_.func_147437_c(p_76484_3_ + b, p_76484_4_ - 1, p_76484_5_ + b1) && p_76484_1_.func_147437_c(p_76484_3_ + b, p_76484_4_ - 2, p_76484_5_ + b1)) {
/* 23 */           return false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 29 */     for (b = -1; b <= 0; b++) {
/* 30 */       for (byte b1 = -2; b1 <= 2; b1++) {
/* 31 */         for (byte b2 = -2; b2 <= 2; b2++) {
/* 32 */           p_76484_1_.func_147465_d(p_76484_3_ + b1, p_76484_4_ + b, p_76484_5_ + b2, Blocks.field_150322_A, 0, 2);
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 38 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, (Block)Blocks.field_150358_i, 0, 2);
/* 39 */     p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_, p_76484_5_, (Block)Blocks.field_150358_i, 0, 2);
/* 40 */     p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_, p_76484_5_, (Block)Blocks.field_150358_i, 0, 2);
/* 41 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_ - 1, (Block)Blocks.field_150358_i, 0, 2);
/* 42 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_ + 1, (Block)Blocks.field_150358_i, 0, 2);
/*    */ 
/*    */     
/* 45 */     for (b = -2; b <= 2; b++) {
/* 46 */       for (byte b1 = -2; b1 <= 2; b1++) {
/* 47 */         if (b == -2 || b == 2 || b1 == -2 || b1 == 2) {
/* 48 */           p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + 1, p_76484_5_ + b1, Blocks.field_150322_A, 0, 2);
/*    */         }
/*    */       } 
/*    */     } 
/* 52 */     p_76484_1_.func_147465_d(p_76484_3_ + 2, p_76484_4_ + 1, p_76484_5_, (Block)Blocks.field_150333_U, 1, 2);
/* 53 */     p_76484_1_.func_147465_d(p_76484_3_ - 2, p_76484_4_ + 1, p_76484_5_, (Block)Blocks.field_150333_U, 1, 2);
/* 54 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ + 2, (Block)Blocks.field_150333_U, 1, 2);
/* 55 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + 1, p_76484_5_ - 2, (Block)Blocks.field_150333_U, 1, 2);
/*    */ 
/*    */     
/* 58 */     for (b = -1; b <= 1; b++) {
/* 59 */       for (byte b1 = -1; b1 <= 1; b1++) {
/* 60 */         if (b == 0 && b1 == 0) {
/* 61 */           p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + 4, p_76484_5_ + b1, Blocks.field_150322_A, 0, 2);
/*    */         } else {
/* 63 */           p_76484_1_.func_147465_d(p_76484_3_ + b, p_76484_4_ + 4, p_76484_5_ + b1, (Block)Blocks.field_150333_U, 1, 2);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 69 */     for (b = 1; b <= 3; b++) {
/* 70 */       p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_ - 1, Blocks.field_150322_A, 0, 2);
/* 71 */       p_76484_1_.func_147465_d(p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150322_A, 0, 2);
/* 72 */       p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ - 1, Blocks.field_150322_A, 0, 2);
/* 73 */       p_76484_1_.func_147465_d(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150322_A, 0, 2);
/*    */     } 
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenDesertWells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */