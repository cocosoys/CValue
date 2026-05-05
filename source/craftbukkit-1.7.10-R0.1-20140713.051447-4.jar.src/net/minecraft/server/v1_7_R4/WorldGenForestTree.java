/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldGenForestTree
/*     */   extends WorldGenTreeAbstract
/*     */ {
/*     */   public WorldGenForestTree(boolean paramBoolean) {
/*  16 */     super(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean generate(World paramWorld, Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
/*  21 */     int i = paramRandom.nextInt(3) + paramRandom.nextInt(2) + 6;
/*     */     
/*  23 */     boolean bool = true;
/*  24 */     if (paramInt2 < 1 || paramInt2 + i + 1 > 256) return false;
/*     */     
/*  26 */     for (int j = paramInt2; j <= paramInt2 + 1 + i; j++) {
/*  27 */       byte b1 = 1;
/*  28 */       if (j == paramInt2) b1 = 0; 
/*  29 */       if (j >= paramInt2 + 1 + i - 2) b1 = 2; 
/*  30 */       for (int i4 = paramInt1 - b1; i4 <= paramInt1 + b1 && bool; i4++) {
/*  31 */         for (int i5 = paramInt3 - b1; i5 <= paramInt3 + b1 && bool; i5++) {
/*  32 */           if (j >= 0 && j < 256) {
/*  33 */             Block block1 = paramWorld.getType(i4, j, i5);
/*  34 */             if (!a(block1)) bool = false; 
/*     */           } else {
/*  36 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  42 */     if (!bool) return false;
/*     */     
/*  44 */     Block block = paramWorld.getType(paramInt1, paramInt2 - 1, paramInt3);
/*  45 */     if ((block != Blocks.GRASS && block != Blocks.DIRT) || paramInt2 >= 256 - i - 1) return false;
/*     */     
/*  47 */     setType(paramWorld, paramInt1, paramInt2 - 1, paramInt3, Blocks.DIRT);
/*  48 */     setType(paramWorld, paramInt1 + 1, paramInt2 - 1, paramInt3, Blocks.DIRT);
/*  49 */     setType(paramWorld, paramInt1 + 1, paramInt2 - 1, paramInt3 + 1, Blocks.DIRT);
/*  50 */     setType(paramWorld, paramInt1, paramInt2 - 1, paramInt3 + 1, Blocks.DIRT);
/*     */     
/*  52 */     int k = paramRandom.nextInt(4);
/*  53 */     int m = i - paramRandom.nextInt(4);
/*  54 */     int n = 2 - paramRandom.nextInt(3);
/*     */     
/*  56 */     int i1 = paramInt1, i2 = paramInt3;
/*  57 */     int i3 = 0; byte b;
/*  58 */     for (b = 0; b < i; b++) {
/*  59 */       int i4 = paramInt2 + b;
/*  60 */       if (b >= m && n > 0) {
/*  61 */         i1 += Direction.a[k];
/*  62 */         i2 += Direction.b[k];
/*  63 */         n--;
/*     */       } 
/*  65 */       Block block1 = paramWorld.getType(i1, i4, i2);
/*  66 */       if (block1.getMaterial() == Material.AIR || block1.getMaterial() == Material.LEAVES) {
/*  67 */         setTypeAndData(paramWorld, i1, i4, i2, Blocks.LOG2, 1);
/*  68 */         setTypeAndData(paramWorld, i1 + 1, i4, i2, Blocks.LOG2, 1);
/*  69 */         setTypeAndData(paramWorld, i1, i4, i2 + 1, Blocks.LOG2, 1);
/*  70 */         setTypeAndData(paramWorld, i1 + 1, i4, i2 + 1, Blocks.LOG2, 1);
/*  71 */         i3 = i4;
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     for (b = -2; b <= 0; b++) {
/*  76 */       for (byte b1 = -2; b1 <= 0; b1++) {
/*  77 */         byte b2 = -1;
/*  78 */         a(paramWorld, i1 + b, i3 + b2, i2 + b1);
/*  79 */         a(paramWorld, 1 + i1 - b, i3 + b2, i2 + b1);
/*  80 */         a(paramWorld, i1 + b, i3 + b2, 1 + i2 - b1);
/*  81 */         a(paramWorld, 1 + i1 - b, i3 + b2, 1 + i2 - b1);
/*  82 */         if ((b > -2 || b1 > -1) && (b != -1 || b1 != -2)) {
/*     */ 
/*     */           
/*  85 */           b2 = 1;
/*  86 */           a(paramWorld, i1 + b, i3 + b2, i2 + b1);
/*  87 */           a(paramWorld, 1 + i1 - b, i3 + b2, i2 + b1);
/*  88 */           a(paramWorld, i1 + b, i3 + b2, 1 + i2 - b1);
/*  89 */           a(paramWorld, 1 + i1 - b, i3 + b2, 1 + i2 - b1);
/*     */         } 
/*     */       } 
/*  92 */     }  if (paramRandom.nextBoolean()) {
/*  93 */       a(paramWorld, i1, i3 + 2, i2);
/*  94 */       a(paramWorld, i1 + 1, i3 + 2, i2);
/*  95 */       a(paramWorld, i1 + 1, i3 + 2, i2 + 1);
/*  96 */       a(paramWorld, i1, i3 + 2, i2 + 1);
/*     */     } 
/*  98 */     for (b = -3; b <= 4; b++) {
/*  99 */       for (byte b1 = -3; b1 <= 4; b1++) {
/* 100 */         if ((b != -3 || b1 != -3) && (b != -3 || b1 != 4) && (b != 4 || b1 != -3) && (b != 4 || b1 != 4))
/*     */         {
/*     */           
/* 103 */           if (Math.abs(b) < 3 || Math.abs(b1) < 3)
/*     */           {
/*     */             
/* 106 */             a(paramWorld, i1 + b, i3, i2 + b1);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/* 111 */     for (b = -1; b <= 2; b++) {
/* 112 */       for (byte b1 = -1; b1 <= 2; b1++) {
/* 113 */         if (b < 0 || b > 1 || b1 < 0 || b1 > 1)
/*     */         {
/*     */           
/* 116 */           if (paramRandom.nextInt(3) <= 0) {
/*     */ 
/*     */             
/* 119 */             int i4 = paramRandom.nextInt(3) + 2; byte b2;
/* 120 */             for (b2 = 0; b2 < i4; b2++) {
/* 121 */               setTypeAndData(paramWorld, paramInt1 + b, i3 - b2 - 1, paramInt3 + b1, Blocks.LOG2, 1);
/*     */             }
/* 123 */             for (b2 = -1; b2 <= 1; b2++) {
/* 124 */               for (byte b3 = -1; b3 <= 1; b3++) {
/* 125 */                 a(paramWorld, i1 + b + b2, i3 - 0, i2 + b1 + b3);
/*     */               }
/*     */             } 
/* 128 */             for (b2 = -2; b2 <= 2; b2++) {
/* 129 */               for (byte b3 = -2; b3 <= 2; b3++) {
/* 130 */                 if (Math.abs(b2) != 2 || Math.abs(b3) != 2)
/*     */                 {
/*     */                   
/* 133 */                   a(paramWorld, i1 + b + b2, i3 - 1, i2 + b1 + b3);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   private void a(World paramWorld, int paramInt1, int paramInt2, int paramInt3) {
/* 145 */     Block block = paramWorld.getType(paramInt1, paramInt2, paramInt3);
/* 146 */     if (block.getMaterial() == Material.AIR) setTypeAndData(paramWorld, paramInt1, paramInt2, paramInt3, Blocks.LEAVES2, 1); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldGenForestTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */