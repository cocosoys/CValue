/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenPackedIce2
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean generate(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
/* 15 */     while (paramWorld.isEmpty(paramInt1, paramInt2, paramInt3) && paramInt2 > 2) {
/* 16 */       paramInt2--;
/*    */     }
/* 18 */     if (paramWorld.getType(paramInt1, paramInt2, paramInt3) != Blocks.SNOW_BLOCK) {
/* 19 */       return false;
/*    */     }
/* 21 */     paramInt2 += paramRandom.nextInt(4);
/*    */     
/* 23 */     int i = paramRandom.nextInt(4) + 7;
/* 24 */     int j = i / 4 + paramRandom.nextInt(2);
/*    */     
/* 26 */     if (j > 1 && paramRandom.nextInt(60) == 0) {
/* 27 */       paramInt2 += 10 + paramRandom.nextInt(30);
/*    */     }
/*    */     int k;
/* 30 */     for (k = 0; k < i; k++) {
/* 31 */       float f = (1.0F - k / i) * j;
/* 32 */       int n = MathHelper.f(f);
/*    */       
/* 34 */       for (int i1 = -n; i1 <= n; i1++) {
/* 35 */         float f1 = MathHelper.a(i1) - 0.25F;
/* 36 */         for (int i2 = -n; i2 <= n; i2++) {
/* 37 */           float f2 = MathHelper.a(i2) - 0.25F;
/* 38 */           if ((i1 == 0 && i2 == 0) || f1 * f1 + f2 * f2 <= f * f)
/*    */           {
/*    */             
/* 41 */             if ((i1 != -n && i1 != n && i2 != -n && i2 != n) || 
/* 42 */               paramRandom.nextFloat() <= 0.75F) {
/*    */ 
/*    */ 
/*    */ 
/*    */               
/* 47 */               Block block = paramWorld.getType(paramInt1 + i1, paramInt2 + k, paramInt3 + i2);
/* 48 */               if (block.getMaterial() == Material.AIR || block == Blocks.DIRT || block == Blocks.SNOW_BLOCK || block == Blocks.ICE) {
/* 49 */                 setType(paramWorld, paramInt1 + i1, paramInt2 + k, paramInt3 + i2, Blocks.PACKED_ICE);
/*    */               }
/* 51 */               if (k != 0 && n > 1) {
/* 52 */                 block = paramWorld.getType(paramInt1 + i1, paramInt2 - k, paramInt3 + i2);
/* 53 */                 if (block.getMaterial() == Material.AIR || block == Blocks.DIRT || block == Blocks.SNOW_BLOCK || block == Blocks.ICE)
/* 54 */                   setType(paramWorld, paramInt1 + i1, paramInt2 - k, paramInt3 + i2, Blocks.PACKED_ICE); 
/*    */               } 
/*    */             }  } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 60 */     k = j - 1;
/* 61 */     if (k < 0) {
/* 62 */       k = 0;
/* 63 */     } else if (k > 1) {
/* 64 */       k = 1;
/*    */     } 
/* 66 */     for (int m = -k; m <= k; m++) {
/* 67 */       for (int n = -k; n <= k; n++) {
/* 68 */         int i1 = paramInt2 - 1;
/* 69 */         int i2 = 50;
/* 70 */         if (Math.abs(m) == 1 && Math.abs(n) == 1) {
/* 71 */           i2 = paramRandom.nextInt(5);
/*    */         }
/* 73 */         while (i1 > 50) {
/* 74 */           Block block = paramWorld.getType(paramInt1 + m, i1, paramInt3 + n);
/* 75 */           if (block.getMaterial() == Material.AIR || block == Blocks.DIRT || block == Blocks.SNOW_BLOCK || block == Blocks.ICE || block == Blocks.PACKED_ICE) {
/* 76 */             setType(paramWorld, paramInt1 + m, i1, paramInt3 + n, Blocks.PACKED_ICE);
/*    */ 
/*    */ 
/*    */             
/* 80 */             i1--;
/* 81 */             i2--;
/* 82 */             if (i2 <= 0) {
/* 83 */               i1 -= paramRandom.nextInt(5) + 1;
/* 84 */               i2 = paramRandom.nextInt(5);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldGenPackedIce2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */